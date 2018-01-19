package de.htwg.se.kakuro

import de.htwg.se.kakuro.controller.controllerComponent.controllerImpl.Controller
import de.htwg.se.kakuro.model.fieldComponent.FieldImpl.Field
import de.htwg.se.kakuro.aview.Tui2
import org.apache.logging.log4j.Logger
import org.apache.logging.log4j.LogManager

object Kakuro {
  def main(args: Array[String]): Unit = {
    val logger = LogManager.getLogger(this.getClass.getName)
    val defaultsize = 8
    val controller = new Controller(new Field(defaultsize))
    //var field = Field(8, 8)
    val tui = new Tui2(controller)
    var input: String = ""
    do {
      tui.printTui()
      input = scala.io.StdIn.readLine()
      if (input != "exit" && input != "") tui.handleInput(input.toString)
      logger.debug("kakuro() input: " + input)
    } while (input != "exit" && input != "q")
  }
}