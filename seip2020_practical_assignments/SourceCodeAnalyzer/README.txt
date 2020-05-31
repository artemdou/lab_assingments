# SourceCodeAnalyzer

## Build 
Build the executable Java application with:
```
mvn package jacoco:report
```

Run the executable by executing
```
java –jar “jar-with-dependencies” arg0 arg1 arg2 arg3 arg4
```
were args translate to: 	
	**arg0** = *“JavaSourceCodeInputFile”* (e.g., src/test/resources/TestClass.java)
	**arg1** = *“sourceCodeAnalyzerType”* [regex|strcomp]
	**arg2** = *“SourceCodeLocationType”* [local|web]
	**arg3** = *“OutputFilePath”* (e.g., ../output_metrics_file)
	**arg4** = *“OutputFileType”* [csv|json]
	
*example:*
```
java –jar ./target/sourcecodeanalyzer-0.0.1-SNAPSHOT-jar-with-dependencies.jar ./src/test/resources/TestClass.java regex local metrics_results csv
```

## Design Patterns

![class diagram](https://github.com/artemdou/lab_assingments/blob/development/seip2020_practical_assignments/SourceCodeAnalyzer/media/class%20diagram.png)

### DemoClient
This class has the role of the client and is associated inly with *Facade*
### Facade
This class belongs in the **Facade** Pattern. This pattern in used here since we want to implement a **mulsti-step service** (read a file, extract and analyze information and extract the information in an output file) and "hide" it from the client class. 
All of the functionality is implemented through Facade. It provides a **simple interface** to a complex system, it **de-couples** the subsystem for clients thereby promoting subsystem **independence** and **portability**. It layers the subsystem and defines an entry point to each subsystem level (in this case the *SourceCodeAnalyzer* and *MetricsExporter* subsystems)
### SourceCodeAnalyzer Subsystem
The SourceCodeAnalyzer Subsystem implements both the **Strategy** and the **Factory** Pattern. 
It consists of a Factory class *"SourceCodeAnalyzerFactory"*, which produces the appropriate *SourceCodeAnalyzer* object (*RegexSourceCodeAnalyzer* or *StrcomSourceCodeAnalyzer*). With the use of the **Factory** pattern we achieve **separation of concerns** and **flexibility**, since we can extend *SourceCodeAnalyzer* hierarchy without affecting the client subsystems.

Regerding the **Stratery** Pattern, it is achieved throught the use of the *SourceCodeAnalyzer* interface and it is appropriate for the project since  it *defines a family of algorithms, encapsulates each one,  makes them interchangeable and lets the algorithm vary independently from the client that uses it* which is exactrly what we want to achieve here with the calculation of the *LOC*, *NOC*, and *NOM* metrics. Thrpught this pattern we ae able to choose throught multiple algorythms and the program is more easily extensible and throught its compination with the **Facrory** pattern the tradeoff of coupling with the client is avoided. 

### MetricsExporter Subsystem
The pattern used is again the compination of **Strategy & Factory** therefore we are not going to repeat their benefits.**Factory** is used since we need to handle indepedently a familly of different objects (here types of output files). It is implemented throught the class *MetricsExporteFactory*. The use of **Strategy** probably could be avoided, thought it provides a helpfull stucture if there is need for extension of the functionality of the class (see interface MetricsExporter and classes *CsvMetricsExporte*r and *JSONMetricsExporter*).

### SourceFileReader Subsystem
The *SourceFileReader Subsystem* again follows the combination of **Strategy & Factory** and with a *SourceFileReader* object being a class variable to the classes implementing *SourceCodeAnalyzer* we can safely say that the subsystem is associated with the *SourceCodeAnalyzer* subsystem.
The **Factory** pattern occurs throught the class *SourceFileReaderFactory* and is useful since again we want to handle differently objects of the same family (here location of a file). The **Stratery** pattern is used since we  whant to chose to use one of the algorithms (*List<String> readFileIntoList(filepath), String readFileIntoString(filepath)*) independently from the client. The use of the patenr is proven by the existence of the *SourceFileReader* interface and the corresponding classes
