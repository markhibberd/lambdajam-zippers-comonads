# lambdajam workshop
## zippers, comonads and data structures in scala

This is the base project for "Zippers, Comonads and Data Structures in
Scala" workshop, for the LambdaJam Australia conference.

__note__: please test your environment before you arrive so we can get
started quickly on the day.

__note__: test you environment as soon as possible, but please grab the
latest copy of this repository the day before the course with a `git pull origin master`.


## Getting started

Before you attend you will need to get a few things
ready and ensure everything is setup properly. `sbt`
is going to do all the heavy lifting though, so
hopefully it is all straight forward, if not, send
us an email via <mark@hibberd.id.au>.


Pre requisuites.

 1. A valid install of java 6+
 2. git
 3. **if you are windows only** install sbt using the [msi installer](http://scalasbt.artifactoryonline.com/scalasbt/sbt-native-packages/org/scala-sbt/sbt/0.12.3/sbt.msi)


Getting scala and validating your environment (for unix):

    git clone https://github.com/markhibberd/lambdajam-zippers-comonads.git
    cd lambdajam-zippers-comonads
    ./sbt test


Getting scala and validating your environment (for windows):

    git clone https://github.com/markhibberd/lambdajam-zippers-comonads.git
    cd lambdajam-zippers-comonads
    sbt test


For either platform this may take a few minutes. It will:

 1. Download the sbt build tool.
 2. Download the required versions of scala.
 3. Compile the main and test source code.
 4. Run the tests.

You should see a successful compilation. The tests will
fail until you complete the exercises during the workshop :)

## Working with scala.

Any good text editor will be sufficient for the course. If you
prefer an IDE, you can use the eclipse based scala-ide or
intellij with the scala and sbt plugins installed.

You can generate project files for intellij with:

    ./sbt 'gen-idea no-classifiers'

You can generate project files for eclipse with:

    ./sbt eclipse

Just note that if you choose eclipse or intellij, have a
backup texteditor as well, because there won't be enough
time to debug any editor issues.


## Notes

There are 35 exercises in total.

 1. src/main/scala/exercise1/Comonad.scala
 2. src/main/scala/exercise2/Zipper.scala
 3. src/main/scala/exercise3/Store.scala

There are test to help validate, but make
sure you use the _types_ to guide you.
