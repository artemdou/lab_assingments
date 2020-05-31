# lab_assingments

[![Build Status](https://travis-ci.org/artemdou/lab_assingments.svg?branch=development)](https://travis-ci.org/artemdou/lab_assingments)

## Overview
This repository is used for the purposes of the course Software Engineering in Practice (Department of Management Science and Technology, Athens University of Economics and business).

## Requirements
This project requires:
- Java JDK [version 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) (or later) and
- Maven [3.6](https://maven.apache.org/download.cgi) (or later)

## Project Structure
This repository consists of a parent Maven project and two sub-projects (modules):

 1. [HistogramGenerator](https://github.com/artemdou/lab_assingments/tree/development/seip2020_practical_assignments/gradeshistogram), that handles dependencies. More specifically, it creates a histogram from a given set of numbers.
 2. [Math](https://github.com/artemdou/lab_assingments/blob/development/seip2020_practical_assignments/math/README.md), that handles arithmetic operations. 
[learn about the math module](https://github.com/artemdou/lab_assingments/blob/development/seip2020_practical_assignments/math/README.md)
3.[SourceCodeAnalyzer](https://github.com/artemdou/lab_assingments/tree/development/seip2020_practical_assignments/SourceCodeAnalyzer)
[learn about the SourceCodeAnalyzer module](https://github.com/artemdou/lab_assingments/blob/development/seip2020_practical_assignments/SourceCodeAnalyzer/README.txt)

In order to build the project execute the following Maven command in the project's root folder:
```
mvn clean install jacoco:report
```
This command will also generate a report of the code coverage produced by JaCoCo. The report will be located in the following path for each module:
```
target/site/jacoco
```

### Histogram Generator
This module requires one runtime dependency which is packaged in the main jar (fat-jar). To create a fat-jar you need to use the ```maven-assembly-plugin``` plugin and also define the class that is the main entry point of the system (the class that contains the main method). 
```
<plugin>
	<artifactId>maven-assembly-plugin</artifactId>
	<configuration>
		<archive>
			<manifest>
			  <mainClass>gradeshistogram.HistogramGenerator</mainClass> 
			</manifest>
		</archive>
		<descriptorRefs>
			<descriptorRef>jar-with-dependencies</descriptorRef>
		</descriptorRefs>
	</configuration>
	<executions>
		<execution>
			<id>make-assembly</id>
			<phase>package</phase>
			<goals>
				<goal>single</goal>
			</goals>
		</execution>
	</executions>
</plugin>
```

The produced jar is located in the target directory and can be executed as following:
```
java -jar gradeshistogram/target/gradeshistogram-0.0.1-SNAPSHOT-jar-with-dependencies.jar
```
Note that the gradeshistogram-0.0.1-SNAPSHOT.jar is not executable. 

## Run Tests
Since the project uses Maven and implements unit testing, test are run with the following command.
```
mvn test
``` 

***Important:*** Note that only classes with a ```Test``` suffix located in the ```src/test``` will be executed and reported as Tests.


## Generate Test-coverage report
To simply run the unit tests of the project, execute the following Maven command: 
```
mvn test jacoco:report
```

## Continuous Integration service
This projects utilizes TravisCI services in other to test and build the application upon each ```git-push``` in the remote repository. 
There are multiple build environments in which the application will be tested and build. You can check these options under the ```jdk``` tag in the ```.travis.yml``` file. 

After each build, the badge is updated with the corresponding build status, ```green``` for passes and ```red``` for failures.

[Here](https://docs.travis-ci.com/user/getting-started/) is a TravisCI quick guide. It's free for public repositories! 


## How to 
1) Setup Maven in Windows - [tutorial](https://mkyong.com/maven/how-to-install-maven-in-windows/)
2) Setup Maven in Linux. Execute ```sudo apt update && sudo apt install maven``` in a terminal. 
