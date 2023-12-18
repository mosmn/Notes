# File Input and Output

## The File Class

To operate on a file, we must first create a `File` object (from `java.io`).

```java
File inFile = new File("sample.dat");
```

Opens the file `sample.dat` in the current directory.

```java
File inFile = new File("C:/SamplePrograms/test.dat");
```

Opens the file `test.dat` in the directory `C:\SamplePrograms` using the generic file separator `/` and providing the full pathname.

### Some File Methods

```java
if (inFile.exists()) {
```

To see if `inFile` is associated with a real file correctly.

```java
if (inFile.isFile()) {
```

To see if `inFile` is associated with a file or not. If false, it is a directory.

```java
File directory = new File("C:/JavaPrograms/Ch12");
String filename[] = directory.list();
```

List the name of all files in the directory `C:\JavaProjects\Ch12`.

## The JFileChooser Class

A `javax.swing.JFileChooser` object allows the user to select a file.

```java
JFileChooser chooser = new JFileChooser();
chooser.showOpenDialog(null);
```

```java
JFileChooser chooser = new JFileChooser("C:/JavaPrograms/Ch12");
chooser.showOpenDialog(null);
```

To start the listing from a specific directory.

## Designating the Path Name

- Absolute to the current directory (Windows platform): `"C:\\JavaPrograms\\Ch12"`
- The relative path name is relative to the current directory: `"../Ch12"` is equivalent to the full path name `"C:/JavaPrograms/Ch12"` where the two dots `..` in the string mean “one directory above.”

## Getting Info from JFileChooser

```java
int status = chooser.showOpenDialog(null);
if (status == JFileChooser.APPROVE_OPTION) {
    System.out.println("Open is clicked");
} else {
    System.out.println("Cancel is clicked");
}

File selectedFile = chooser.getSelectedFile();
File currentDirectory = chooser.getCurrentDirectory();
```

```java
status = chooser.showSaveDialog(null);
if (status == JFileChooser.APPROVE_OPTION) {
    file = chooser.getSelectedFile();
    directory = chooser.getCurrentDirectory();

    System.out.println("Directory: " + directory.getName());
    System.out.println("File selected for saving data: " + file.getName());
    System.out.println("Full path name: " + file.getAbsolutePath());
} else {
    System.out.println("Save File dialog canceled");
}
```

## Applying a File Filter

A file filter may be used to restrict the listing in `JFileChooser` to only those files/directories that meet the designated filtering criteria. To apply a file filter, we define a subclass of the `javax.swing.filechooser.FileFilter` class and provide the `accept` and `getDescription` methods.

```java
import java.io.File;
import javax.swing.filechooser.*;

class JavaFilter extends FileFilter {
    private static final String JAVA = "java";
    private static final char DOT = '.';

    // Accepts only directories and files with .java extension only
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }
        if (extension(f).equalsIgnoreCase(JAVA)) {
            return true;
        } else {
            return false;
        }
    }

    // Description of the filtered files
    public String getDescription() {
        return "Java source files (.java)";
    }

    // Extracts the extension from the filename
    private String extension(File f) {
        String filename = f.getName();
        int loc = filename.lastIndexOf(DOT);
        if (loc > 0 && loc < filename.length() - 1) {
            return filename.substring(loc + 1);
        } else {
            return "";
        }
    }
}
```

## Applying a File Filter

```java
import javax.swing.*;

public class TestJavaFilter {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        // JFileChooser is set to the default directory folder
        fileChooser.setAcceptAllFileFilterUsed(false);
        JavaFilter filter = new JavaFilter();
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.showOpenDialog(null);
        // ...
    }
}
```

## Applying a File Filter

### JavaFilter.java

```java
import java.io.*;
import javax.swing.filechooser.*;

public class JavaFilter extends FileFilter {
    private static final String JAVA = "java";
    private static final char DOT = '.';

    // Accepts only directories and files with .java extension only
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }
        if (extension(f).equalsIgnoreCase(JAVA)) {
            return true;
        } else {
            return false;
        }
    }

    // Description of the filtered files
    public String getDescription() {
        return "Java source files (.java)";
    }

    // Extracts the extension from the filename
    private String extension(File f) {
        String filename = f.getName();
        int loc = filename.lastIndexOf(DOT);
        if (loc > 0 && loc < filename.length() - 1) {
            return filename.substring(loc + 1);
        } else {
            return "";
        }
    }
}
```

## Applying a File Filter

### TestJavaFilter.java

```java
import javax.swing.*;

public class TestJavaFilter {
    public static void main(String[] args) {
        JFileChooser fileChooser = new JFileChooser();
        // JFileChooser is set to the default directory folder
        fileChooser.setAcceptAllFileFilterUsed(false);
        JavaFilter filter = new JavaFilter();
        fileChooser.addChoosableFileFilter(filter);
        fileChooser.showOpenDialog(null);
        // ...
    }
}
```

## FileNameExtensionFilter (Filter Class)

```java
import java.io.*;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class TestFilter {
    public static void main(String[] args) {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Word Document", "doc", "docx");
        chooser

.setCurrentDirectory(new File("C:\\Users\\Zailani Acer\\Documents\\ALIEN"));
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            System.out.println("You chose to open this file: " + chooser.getSelectedFile().getName());
        }
    }
}
```

# Low-Level File I/O

To read data from or write data to a file, we must create one of the Java stream objects and attach it to the file. A stream is a sequence of data items, usually 8-bit bytes. Java has two types of streams: an input stream and an output stream. An input stream has a source from which the data items come, and an output stream has a destination to which the data items are going.

## Streams for Low-Level File I/O

`FileOutputStream` and `FileInputStream` are two stream objects that facilitate file access. `FileOutputStream` allows us to output/write a sequence of bytes (values of data type byte), while `FileInputStream` allows us to input/read in an array of bytes.

## Sample: Low-Level File Output

```java
// Set up file and stream
File outFile = new File("sample1.data");
FileOutputStream outStream = new FileOutputStream(outFile);

// Data to save
byte[] byteArray = {10, 20, 30, 40, 50, 60, 70, 80};

// Write data to the stream
outStream.write(byteArray);

// Output done, so close the stream
outStream.close();
```

## Sample: Low-Level File Input

```java
// Set up file and stream
File inFile = new File("sample1.data");
FileInputStream inStream = new FileInputStream(inFile);

// Set up an array to read data in
int fileSize = (int) inFile.length();
byte[] byteArray = new byte[fileSize];

// Read data in and display them
inStream.read(byteArray);
for (int i = 0; i < fileSize; i++) {
    System.out.println(byteArray[i]);
}

// Input done, so close the stream
inStream.close();
```

## Streams for High-Level File I/O

`FileOutputStream` and `DataOutputStream` are used to output primitive data values, while `FileInputStream` and `DataInputStream` are used to input primitive data values. To read the data back correctly, we must know the order of the data stored and their data types.

## Setting up `DataOutputStream`

A standard sequence to set up a `DataOutputStream` object:

```java
File outFile = new File("sample2.data");
FileOutputStream outFileStream = new FileOutputStream(outFile);
DataOutputStream outDataStream = new DataOutputStream(outFileStream);
```

## Sample Output

```java
import java.io.*;

class Ch12TestDataOutputStream {
    public static void main(String[] args) throws IOException {
        // Set up outDataStream

        // Write values of primitive data types to the stream
        outDataStream.writeInt(987654321);
        outDataStream.writeLong(11111111L);
        outDataStream.writeFloat(22222222F);
        outDataStream.writeDouble(3333333D);
        outDataStream.writeChar('A');
        outDataStream.writeBoolean(true);

        // Output done, so close the stream
        outDataStream.close();
    }
}
```

## Setting up `DataInputStream`

A standard sequence to set up a `DataInputStream` object:

```java
File inFile = new File("sample2.data");
FileInputStream inFileStream = new FileInputStream(inFile);
DataInputStream inDataStream = new DataInputStream(inFileStream);
```

## Sample Input

```java
import java.io.*;

class Ch12TestDataInputStream {
    public static void main(String[] args) throws IOException {
        // Set up inDataStream

        // Read values back from the stream and display them
        System.out.println(inDataStream.readInt());
        System.out.println(inDataStream.readLong());
        System.out.println(inDataStream.readFloat());
        System.out.println(inDataStream.readDouble());
        System.out.println(inDataStream.readChar());
        System.out.println(inDataStream.readBoolean());

        // Input done, so close the stream
        inDataStream.close();
    }
}
```

## Reading Data Back in the Right Order

The order of write and read operations must match to read the stored primitive data back correctly.

```java
outStream.writeInteger(...);
outStream.writeLong(...);
outStream.writeChar(...);
outStream.writeBoolean(...);
```

```java
inStream.readInteger(...);
inStream.readLong(...);
inStream.readChar(...);
inStream.readBoolean(...);
```

- `<integer>`
- `<long>`
- `<char>`
- `<boolean>`

# Textfile Input and Output

Instead of storing primitive data values as binary data in a file, we can convert and store them as string data. This allows us to view the file content using any text editor. To output data as a string to a file, we use a `PrintWriter` object. To input data from a text file, we use `FileReader` and `BufferedReader` classes. From Java 5.0 (SDK 1.5), we can also use the `Scanner` class for inputting text files.

## Sample Textfile Output

```java
import java.io.*;

class Ch12TestPrintWriter {
    public static void main(String[] args) throws IOException {
        // Set up file and stream
        File outFile = new File("sample3.data");
        FileOutputStream outFileStream = new FileOutputStream(outFile);
        PrintWriter outStream = new PrintWriter(outFileStream);

        // Write values of primitive data types to the stream
        outStream.println(987654321);
        outStream.println("Hello, world.");
        outStream.println(true);

        // Output done, so close the stream
        outStream.close();
    }
}
```

## Sample Textfile Input

```java
import java.io.*;

class Ch12TestBufferedReader {
    public static void main(String[] args) throws IOException {
        // Set up file and stream
        File inFile = new File("sample3.data");
        FileReader fileReader = new FileReader(inFile);
        BufferedReader bufReader = new BufferedReader(fileReader);
        String str;

        str = bufReader.readLine(); // Read data as a String
        int i = Integer.parseInt(str);

        // Similar process for other data types

        bufReader.close();
    }
}
```

## Sample Textfile Input with Scanner

```java
import java.io.*;

class Ch12TestScanner {
    public static void main(String[] args) throws IOException {
        // Open the Scanner
        Scanner scanner = new Scanner(new File("sample3.data"));

        // Get integer
        int i = scanner.nextInt(); // Read data as the respective type according to the method used

        // Similar process for other data types

        scanner.close();
    }
}
```

## Object File I/O

It is possible to store objects just as easily as you store primitive data values. We use `ObjectOutputStream` and `ObjectInputStream` to save and load objects from a file. To save objects from a given class, the class declaration must include the phrase `implements Serializable`.

## Saving Objects

```java
File outFile = new File("objects.data");
FileOutputStream outFileStream = new FileOutputStream(outFile);
ObjectOutputStream outObjectStream = new ObjectOutputStream(outFileStream);

Person person = new Person("Mr. Espresso", 20, 'M');
outObjectStream.writeObject(person);

Account account1 = new Account();
Bank bank1 = new Bank();
outObjectStream.writeObject(account1);
outObjectStream.writeObject(bank1);
```

## Reading Objects

```java
File inFile = new File("objects.data");
FileInputStream inFileStream = new FileInputStream(inFile);
ObjectInputStream inObjectStream = new ObjectInputStream(inFileStream);

Person person = (Person) inObjectStream.readObject();
Account account1 = (Account) inObjectStream.readObject();
Bank bank1 = (Bank) inObjectStream.readObject();
```

## Saving and Loading Arrays

Instead of processing array elements individually, it is possible to save and load the whole array at once.

```java
Person[] people = new Person[N]; // Assume N already has a value

// Build the people array
...

// Save the array
outObjectStream.writeObject(people);

// Read the array
Person[] people = (Person[]) inObjectStream.readObject();
```


