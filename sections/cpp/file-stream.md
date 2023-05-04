# 7.1 Streams I/O

## 7.1.1 Concept of Streams

### STREAMS

C++ I/O occurs in streams of bytes​

A stream is simply a sequence of bytes ​

Input operation – bytes flow a device (mouse) to main memory.​

Output operation – bytes flow from main memory to device​

Bytes may represent ASCII characters, internal format raw data, movie etc.​

C++ provides both “low level” and “high level” I/O capabilities.

![Streams](/imgs/sfio1.png)

C++ program:
- Input stream:
    - Input source (keyboard, file, network, program)
- Output stream:
    - Output sink (console, file, network, program)

Internal data formats:
- Text: char, wchar_t
- int, float, double, etc.

External data formats:
- Text in various encodings (US-ASCII, ISO-8859-1, UCS-2, UTF-8, UTF-16, UTF-16BE, UTF16-LE, etc.)
- Binary (raw bytes)

### HEADER FILES IN C++

- `iostream`: iostream stands for standard input-output stream. This header file contains definitions of objects like cin, cout, cerr, etc.
- `iomanip`: iomanipstands for input-output manipulators. The methods declared in these files are used for manipulating streams. This file contains definitions of setw, setprecision, etc.
- `fstream`: This header file mainly describes the file stream. This header file is used to handle the data being read from a file as input or data being written into the file as output.
- `bits`/`stdc++`: This header file includes every standard library. In programming contests, using this file is a good idea, when you want to reduce the time wasted in doing chores; especially when your rank is time sensitive. 

## 7.1.2 Stream Manipulators

### MANIPULATORS IN C++

Manipulators are functions used to change formatting parameters on streams and to insert or extract certain special characters.

INPUT manipulators:
- `ws`: skips white space

OUTPUT manipulators:
- `endl`: inserts a newline character and flushes the stream
- `ends`: inserts a null character
- `flush`: flushes the stream

PARAMETERIZED manipulators:(iomanip)
- `setiosflags`: sets the format flags
- `resetiosflags`: resets the format flags
- `setbase`: sets the base for integer output
- `setfill`: sets the fill character    
- `setprecision`: sets the precision for floating-point output 
- `setw`: sets the field width for output

Operators:
- `<<`: Stream insertion operator
- `>>`: Stream extraction operator
    - Stream-Extraction Operator returns 0 on end-of-file
    ```C++
    // when EOF(meaning invalid input or ctrl c) is entered, the expression returns false(0)
    // then, the value of while(cin >> marks) becomes 0 and the loop terminates
    while(cin >> marks) {
        // do something
    }
    ```

Stream Format States and Stream Manipulators:
Manipulator | Description
--- | ---
`skipws` | Skip white-space characters on an input stream. This setting is reset with stream manipulator noskipws.
`left` | Left justify output in a field. Padding characters appear to the right if necessary.
`right` | Right justify output in a field. Padding characters appear to the left if necessary.
`internal` | Indicate that a number's sign should be left justified in a field and a number's magnitude should be right justified in that same field (i.e., padding characters appear between the sign and the number).
`boolalpha` | Specify that bool values should be displayed as the word true or false. The manipulator noboolalpha sets the stream back to displaying bool values as 1 (true) and 0 (false).
`dec` | Specify that integers should be treated as decimal (base 10) values.
`oct` | Specify that integers should be treated as octal (base 8) values.
`hex` | Specify that integers should be treated as hexadecimal (base 16) values.
`showbase` | Specify that the base of a number is to be output ahead of the number (a lead- ing 0 for octals; a leading Ox or 0x for hexadecimals). This setting is reset with stream manipulator noshowbase.
`showpoint` | Specify that floating-point numbers should be output with a decimal point. This is used normally with fixed to guarantee a certain number of digits to the right of the decimal point, even if they're zeros. This setting is reset with stream manipulator noshowpoint.
`uppercase` | Specify that uppercase letters (i.e., X and A through F) should be used in a hexadecimal integer and that uppercase E should be used when representing a floating-point value in scientific notation. This setting is reset with stream manipulator nouppercase.
`showpos` | Specify that positive numbers should be preceded by a plus sign (+). This set- ting is reset with stream manipulator noshowpos.
`scientific` | Specify output of a floating-point value in scientific notation.
`fixed` | Specify output of a floating-point value in fixed-point notation with a specific number of digits to the right of the decimal point.

### I/O MANIPULATORS

1. setw() manipulator (in <iomanip> header) to set the field width.
2. setfill() manipulator (in <iomanip> header) to set the fill character.
3. left|right|internal manipulator (in <iostream> header) to set the text alignment.
4. setprecision() manipulator (in <iomanip> header) to set the precision of floatingpoint number.
5. fixed|scientific manipulators (in <iostream> header) to set the floating-point display format.

### FIELD WIDTH: setw()

The setw() stands for set width and it works for both the input and the output
streams.

Example:
```C++
include <iomanip>
include <iostream>
using namespace std;

int main()
{
    // Initializing the integer
    int num = 50;
    cout << "Before setting the width: \n" << num << endl;
    // Using setw()
    cout << "Setting the width"
         << " using setw to 5: \n"
         << setw(5);
    cout << num;
    return 0;
}
```
output:
```
Before setting the width:
50
Setting the width using setw to 5:
     50
```

```C++
#include <iostream>
using namespace std;

int main()
{
    int widthValue = 4;
    char sentence [ 10 ];
    cout<<"Enter a sentence: " << endl;
    cin.width( 5 );
    // set field width, then display characters based on that width
    while (cin >> sentence )
    {
        cout.width( widthValue++ );
        cout << sentence << endl;
        cin.width( 5 );
    }
    return 0;
}
```
output:
```
Enter a sentence:
Hello wassup man, long time no see
Hell
    o
  wass
     up
    man,
     long
      time
         no
         see
^Z
```

### PADDING: setfill()

The setfill() is used to set the ios library fill character based on the
character specified as the parameter to this method.

Example:
```C++
include <iomanip>
include <iostream>
using namespace std;

int main()
{
    // Initializing the integer
    int num = 50;
    cout << "Before setting the fill character: \n" << num << endl;
    // Using setfill()
    cout << "Setting the fill character"
         << " using setfill to 0: \n"
         << setfill('0');
    cout << setw(5);
    cout << num;
    return 0;
}
```
output:
```
Before setting the fill character:
50
Setting the fill character using setfill to 0:
00050
```

### JUSTIFICATION: left|right|internal

- internal: the output is padded to the field width by inserting fill characters at a specified internal point.
- left: the output is padded to the field width appending fill characters at the end.
- right: the output is padded to the field width by inserting fill characters at the beginning.

Example:
```C++
int n = -77;
cout << setw(6) << internal << n << endl;
cout << setw(6) << left << n << endl;
cout << setw(6) << right << n << endl;
```
output:
```
-      77
-77
      -77
```

### FLOATING-POINT PRECISION: setprecision()

Sets the decimal precision to be used to format floating-point values on output operations.

Example:
```C++
#include <iomanip>
#include <iostream>
using namespace std;

int main()
{
    double f = 3.14159265358979323846;
    cout << setprecision(5) << f << endl;
    cout << setprecision(9) << f << endl;
    cout << fixed; // use fixed floating-point notation
    cout << setprecision(5) << f << endl;
    cout << setprecision(9) << f << endl;
    return 0;
}
```
output:
```
3.1416
3.14159
3.14159
3.141592654
```

## get and put​

Formatted and unformatted input capabilities are provided by istream. The stream extraction operator (>>) normally skips whitespace characters (such as blanks, tabs and newlines) in the input stream​

The get member function with no arguments inputs one character from the designated stream (including white-space characters and other nongraphic characters, such as the key sequence that represents end-of-file) and returns it as the value of the function call. This version of get returns EOF when end-of-file is encountered on the stream.

The get member function with a character reference argument inputs the next character from the input stream (even if this is a white-space character) and stores it in the characters argument. This version of get returns a reference to the istream object for which the get member function is being invoked

```C++
#include <iostream>
using namespace std;

int main()
{
    char c;

    cout << "Before input, cin.eof() is " << cin.eof() // cin.eof() is a flag, its value is 0
         << "\nEnter a sentence followed by end-of-file:\n";

    // cin.get() is equivalent to cin >> c but it does not skip whitespace
    while((c = cin.get()) != EOF)
    // cout.put(c) is equivalent to cout << c
        cout.put(c);
    cout << "\nEOF in this system is: " << c;
    cout << "\nAfter input, cin.eof() is " << cin.eof() << endl;
    return 0;
}
```
output:
```
Before input, cin.eof() is 0
Enter a sentence followed by end-of-file:
Good Morning Mr. Kok, wassup y'all!
Good Morning Mr. Kok, wassup y'all!
^Z

EOF in this system is:
After input, cin.eof() is 1
```

```C++
#include <iostream>
using namespace std;

int main()
{
    const int SIZE = 80;
    char buff1[SIZE], buff2[SIZE];
    cout << "Enter a sentence:\n";
    cin >> buff1;
    cout << "\nThe string read with cin was:\n"
         << buff1 << "\n\n";
    cout << "Enter a sentence:\n";
    // cin.get() can take 3 arguments- a char array, a size limit,
    // and a delimiter (with default value '\n')
    cin.get(buff2, SIZE);
    cout << "The string read with cin.get was: \n"
         << buff2 << endl;
    return 0;
}
```
output:
```
Enter a sentence:
Good Morning Mr. Kok, W
The string read with cin was:
Good
Enter a sentence:
The string read with cin.get was:
 Morning Mr. Kok, W
```

A third version of `get` takes three arguments—a character array, a size
limit and a delimiter (with default value '\n'). This version reads
characters from the input stream.

It either reads one fewer than the specified maximum number of
characters and terminates or terminates as soon as the delimiter is read.

A null character is inserted to terminate the input string in the character
array used as a buffer by the program.

### get and getline

Member function `getline` operates similarly to the third version of the
get member function and inserts a null character after the line in the
character array.

The `getline` function removes the delimiter from the stream (i.e., reads
the character and discards it), but does not store it in the character
array.

__so the difference between `get` and `getline` is that `get` will read the delimiter and store it in the character array, while `getline` will read the delimiter and discard it.__

#### getline vs read

`getline` assigns a null character to the end of the string, while `read` does not.

so the output for `cin.read(buff1,10)` will be something like this "hello, was1j2njk12nj12jhj" because the null character is not assigned to the end of the string.
- to only get the valid characters, use `cin.gcount()` to get the number of characters read by the last unformatted input operation.`cout.write(buff1, cin.gcount())`


# 7.2 File I/O

## 7.2.1 What is File I/O?

### WHY USE FILES FOR INPUT/OUTPUT?

Keyboard input and screen output deal with temporary data.

Filesprovide a way to storedatapermanently.

Files store a sequence of data as raw data bytes.

The end of a file is either denoted by a end-of-file marker or a specific byte number.

Programmatic processing of them is required to derive any meaning out of them.

File processing:
1. File input – read from the file (`ifstream`)
2. File output – write to the file (`ofstream`)
3. File input/output – input AND output (`fstream`)

### FILE MODES

Various file modes supported by C++:

Ios file mode | Meaning
--------------|--------
app | Opens the file in append mode
ate | Seeks to the end of the file before reading/writing
binary | Opens the file in binary mode (instead of text mode)
in | Opens the file in read mode (default for ifstream)
out | Opens the file in write mode (default for ofstream)
trunc | Erases the file if it already exists

## 7.2.2 Working with Sequential Data Files

### BASIC STEPS TO PERFORM FILE PROCESSING

1. Include header file for processing file (`#include <fstream>`)
2. OpenFile
- Determine purpose then specify file name, location and mode
- Example: `ofstream outClientfile("clients.txt", ios::out);`
3. Perform operation to the opened file
- To write -use `ofstream` or `fstream` object and the stream insertion operator `<<`
- To read – use `ifstream` or `fstream` object and the stream extraction operator `>>`
4. Close File – explicitly close the file
- Example: `outClientfile.close();`

### CREATING A SEQUENTIAL FILE

```C++
#include<iostream>
#include<fstream> //required for file I/O
#include <cstdlib> //exit function prototype
using namespace std;
int main(){
    //ofstream constructor opens file
    ofstream outClientFile{"clients.txt", ios::out};

    cout<<"Enter the account, nam, and balance.\n" 
        << "Enter end-of-file(ctrl+z) to end input.\n";

    int account;
    string name;
    double balance;

    //read account, name, and balance, then place in file
    while(cin>> account >> name >> balance) {
        outClientFile << account <<<< name <<< << balance << endl;
        cout << "? ";
    }
    outClientFile.close();
    return 0;
}
```
output:
```
Enter the account, nam, and balance.
Enter end-of-file to end input
? 100 James 25.45
? 200 White 567.87
? 300 Anna 0.00
? ^Z
```
clients.txt
```
100 James 25.45
200 White 567.87
300 Anna 0
```

### FILE I/O WITH CHECKS ON OPEN

```C++
#include<iostream>
#include<fstream> //required for file I/O
#include <cstdlib> //exit function prototype
using namespace std;
int main(){
    //ofstream constructor opens file
    ofstream outClientFile{"clients.txt", ios::out};

    //exit program if ofstream could not open file
    if(!outClientFile){
        cerr << "File could not be opened" << endl;
        exit(EXIT_FAILURE);
    }

    cout<<"Enter the account, nam, and balance.\n" 
        << "Enter end-of-file(ctrl+z) to end input.\n";

    int account;
    string name;
    double balance;

    //read account, name, and balance, then place in file
    while(cin>> account >> name >> balance) {
        outClientFile << account <<<< name <<< << balance << endl;
        cout << "? ";
    }
    outClientFile.close();
    return 0;
}
```

### READING FROM A SEQUENTIAL FILE

```C++
#include<iostream>
#include<fstream> //required for file I/O
#include <cstdlib> //exit function prototype
#include <iomanip>
using namespace std;

//Display single record from file
void Display (int acc, string n, double bal){
    cout<<< left <<< setw(10) <<< acc << setw(13) << n << setw(7) << setprecision (2) << right << bal <<< endl;
}

int main(){
    //ifstream constructor opens the file
    ifstream inClientFile{"clients.txt", ios::in};

    //exit program if unable to create a file
    if (!inClientFile) {
        cerr << "File could not be opened" << endl;
        exit(EXIT_FAILURE);
    }

    cout<<<< left <<< setw(10) << "Account" << setw(13) << "Name" << "Balance \n" <<< fixed;
    int account;
    string name;
    double balance;

    //display each record in the file
    while (inClientFile >> account >> name >> balance) {
        Display (account, name, balance);
    }

    inClientFile.close(); //explicitly close the file
    return 0;
}
```
output:
```
Account   Name        Balance
100       James       25.45
200       White       567.87
300       Anna        0.00
```

### APPENDING A SEQUENTIAL FILE

```C++
#include<iostream>
#include<fstream> //required for file I/O
#include <cstdlib> //exit function prototype
using namespace std;

int main(){
    cout << "Opening clients.txt for appending\n";

    ofstream outClientFile{"clients.txt", ios::app};

    //exit program if ofstream could not open file
    if(!outClientFile){
        cerr << "File could not be opened" << endl;
        exit(EXIT_FAILURE);
    }

    outClientFile << "400 Smith 99.99\n"
                    << "500 Jones 88.88\n";
    
    outClientFile.close();
    cout << "Done" << endl;
    return 0;
}
