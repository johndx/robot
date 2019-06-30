# robot


This is my version of the Robot Exercise.


## Environment

It was developed in Java, using Spring and scaffolded using Spring Boot.
The development IDE is intelliJ.

## Execution
This can be run via an IDE such as IntelliJ or from the command line using the 'java' command and it takes no arguments.


## Status
The code is a working example and takes the contents of the 'cmdFile.txt' in the app resources and produces a mixture of logged and console output.
Sample runtime output is stored in SampleOutput.txt.

## Consideration

With more time I would focus on the two switch statements in the 'GridLocation' and make them more elegant.
The app could also be supplied at runtime with the file location and I would look for a better solution to the use of the Optional in the Simulator Service, but it does guard against NPE's.


