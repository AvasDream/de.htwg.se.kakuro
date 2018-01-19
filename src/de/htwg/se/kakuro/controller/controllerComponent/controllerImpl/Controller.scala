package de.htwg.se.kakuro.controller.controllerComponent.controllerImpl

import controller.controllerComponent.GameStatus._
import de.htwg.se.kakuro.controller.controllerComponent.{ CandidatesChanged, CellChanged, ControllerInterface }
import de.htwg.se.kakuro.model.fieldComponent.FieldImpl.{ Field, FieldCreator }
import de.htwg.se.kakuro.model.fieldComponent.{ CellInterface, FieldInterface, WhiteCellInterface }
import de.htwg.se.kakuro.util.Observable
import de.htwg.se.kakuro.util.UndoManager

import scala.swing.Publisher
import org.apache.logging.log4j.Logger
import org.apache.logging.log4j.LogManager

class Controller(var field: FieldInterface) extends ControllerInterface with Publisher {
  val logger: Logger = LogManager.getLogger(this.getClass.getName)

  private val undoManager = new UndoManager
  var gameStatus: GameStatus = IDLE
  var showAllCandidates: Boolean = false

  def undo(): Unit = {
    undoManager.undoStep
    gameStatus = UNDO
    publish(new CellChanged)
  }

  def redo(): Unit = {
    undoManager.redoStep
    gameStatus = REDO
    publish(new CellChanged)
  }

  def initField(): FieldInterface = {
    var samplefield = new FieldCreator()
    //field = samplefield.createEmptyGrid(8)
    //field = samplefield.createNewField(8)
    field
  }
  def available(row: Int, col: Int): Set[Int] = ???
  def isShowCandidates(row: Int, col: Int): Boolean = ???
  def isWhite(row: Int, col: Int): Boolean = ???
  /*
  def set(row: Int, col: Int, value: Int): Boolean = {
    logger.debug("row: " + row.toString + " col: " + col.toString + " value:" + value.toString)
    if (field.cell(row, col).isInstanceOf[WhiteCellInterface]
      && isValidInput(row)
      && isValidInput(col)
      && isValidInput(value)) {
      //field.cell(row, col).asInstanceOf[WhiteCellInterface].value = value
      true
    } else { false }
  }*/
  def set(row: Int, col: Int): Unit = {
    logger.debug("row: " + row.toString + " col: " + col.toString + "set to simple Cell")
    field.set(row, col)
  }

  def set(row: Int, col: Int, value: Int): Unit = {
    logger.debug("row: " + row.toString + " col: " + col.toString + "type: white value: " + value.toString)
    field.set(row, col, value)
  }

  def set(row: Int, col: Int, rightSum: Int, downSum: Int): Unit = {
    logger.debug("row: " + row.toString + " col: " + col.toString + "type: black" +
      " rightSum: " + rightSum.toString + " downSum: " + downSum.toString)
    field.set(row, col, rightSum, downSum)
  }

  def clear(row: Int, col: Int): Unit = {
    logger.debug("row: " + row.toString + " col: " + col.toString + " reset")
    field.reset(row, col)
  }

  def isValidInput(input: Int): Boolean = {
    logger.debug("isValidInput, input: " + input.toString)
    if (input >= 1 && input <= 9) true
    else { false }
  }

  def gridSize: Int = field.width

  def createEmptyGrid(size: Int): Unit = {
    field = new Field(8)
    publish(new CellChanged)
  }

  //def cell(row: Int, col: Int) = field.cell(row, col)

  //override def isSet(row: Int, col: Int): Boolean = true //cell(row, col).isSet
  def isSet(row: Int, col: Int): Boolean = true
  def showCandidates(row: Int, col: Int): Unit = {
    field = field.setShowCandidates(row, col)
    gameStatus = CANDIDATES
    publish(new CandidatesChanged)
  }

  def fieldToString: String = Field.toString()

  //override def isShowCandidates(row: Int, col: Int): Boolean = ???

  def toggleShowAllCandidates: Unit = {
    showAllCandidates = !showAllCandidates
    gameStatus = CANDIDATES
    publish(new CellChanged)
  }

  //override def showAllCandidates: Boolean = ???

  //override def available(row: Int, col: Int): Set[Int] = ???

  //override def statusText: String = ???
}
