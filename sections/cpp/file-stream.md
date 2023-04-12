# 7.1 Streams I/O

## 7.1.1 Concept of Streams

### STREAMS

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
