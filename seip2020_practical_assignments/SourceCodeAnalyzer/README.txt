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

#Design Pattern

![class diagram](https://github.com/artemdou/lab_assingments/blob/development/seip2020_practical_assignments/SourceCodeAnalyzer/media/class%20diagram.png)

