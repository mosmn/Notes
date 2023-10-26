#include <iostream>
#include <list>
#include <string>
using namespace std;

// i
void display(list<string> &lst)
{
    //ii
    list<string>::iterator it;
    for (it = lst.begin(); it != lst.end(); it++)
    {
        cout << *it << " ";
    }
}

int main()
{
    list<string> CCI{"BIT(IS)", "BIT(GM)"}; // im getting error o this line although i alread have a ";": expected ';' at end of declaration
    string BCS[] = {"BCS(SE)", "BCS(CS)", "BCS(SN)"};
    list<string> Other;

    cout<<"CCI Program: ";
    display(CCI);


    // cout << "\nOther Program: ";
    // display(Other);

    // cout << "\nCCI Program: ";
    // display(CCI);

    // cout << "\nOther Program: ";
    // display(Other);

    // cout << "\nCCI Program: ";
    // display(CCI);

    // cout << "\nTotal CCI Program: " << CCI.size();

    // cout << "\nThe end";

    return 0;
}