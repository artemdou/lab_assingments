# lab_assingments
This repository is used for the purposes of the course Software Engineering in Practice (Department of Management Science and Technology, Athens University of Economics and business).

## Project Structure
This repository consists of a parent Maven project and two sub-projects (modules):

 1. [HistogramGenerator](https://github.com/artemdou/lab_assingments/tree/development/seip2020_practical_assignments/gradeshistogram), that handles dependencies. More specifically, it creates a histogram from a given set of numbers.
 2. [Math]
(https://github.com/artemdou/lab_assingments/tree/development/seip2020_practical_assignments/math), that handles arithmetic operations. 
[learn about the math module] (https://github.com/artemdou/lab_assingments/blob/development/seip2020_practical_assignments/math/README.md)
Execute the following command in the repository root directory in order to build all modules.
```
mvn package
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

##Run Tests
Since the project uses Maven and implements unit testing, test are run with the ```
mvn test
``` command.

## How to..
1) Setup Maven in Windows - [tutorial](https://mkyong.com/maven/how-to-install-maven-in-windows/)
2) Setup Maven in Linux. Execute ```sudo apt update && sudo apt install maven``` in a terminal. 
