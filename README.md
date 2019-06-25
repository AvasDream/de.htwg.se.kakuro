
[![Build Status](https://travis-ci.org/AvasDream/de.htwg.se.kakuro.svg?branch=master)](https://travis-ci.org/AvasDream/de.htwg.se.kakuro)
[![Coverage Status](https://coveralls.io/repos/github/AvasDream/de.htwg.se.kakuro/badge.svg?branch=master)](https://coveralls.io/github/AvasDream/de.htwg.se.kakuro?branch=master)
HTWG Kakuro
=========================


## Docker

Build:

`docker build . -t scala`

Run:

`docker run -it -p "8080:8080" -p "8090:8090" --volume="$(pwd):/root/src" --rm scala /bin/bash`

Inside the Container execute:

`sbt run`



This is a kakuro game project as used in the
class Software Engineering at the University of Applied Science HTWG Konstanz

* Has a folder structure prepared for a MVC-style application
* Has *ScalaTest* and *ScalaMock* at their latest versions as dependencies.
* Has *scalastyle-sbt-plugin* and *sbt-scoverage* sbt plugins
* Has *sbt-scalariform*, *sbt-scapegoat*, *scalastyle-sbt-plugin* and *sbt-scoverage* sbt plugins
* Has .gitignore defaults
