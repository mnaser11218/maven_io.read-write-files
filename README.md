# Read and Write Document
* **Objective** - To implement a `Document` object which uses a composite `File` and `FileWriter` to `read` and `write` to a `File`.
  * _Click [here](https://www.geeksforgeeks.org/filewriter-class-in-java/) to read more about_ `FileWriter`.
* **Purpose** -  To demonstrate use of:
  * Exception Handling
  * Reading from file
  * Writing to file
* **Note**
  * The code block below demonstrates how to create a `File` object that references the current project directory

```java
String projectDirectory = System.getPropterty("user.dir");
String srcMain = projectDirectory + "/src/main";
String newFileName = srcMain + "/hello-world.txt";
File file = new File(newFileName);
```


## Instructions
* Ensure each of the test classes passes with 100% pass rate.
