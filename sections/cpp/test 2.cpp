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