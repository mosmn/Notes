#include <iostream>
#include <stack>
using namespace std;

int main()
{
    int num = 0;
    stack<int> bi;

    // Input validation
    cout << "Enter a decimal number: ";
    cin >> num;

    // Conversion to binary
    while (num > 0)
    {
        int remainder = num % 2;
        cout << remainder << endl;
        bi.push(remainder);
        num /= 2;
    }

    // Displaying binary equivalent
    cout << "Binary equivalent: ";
    while (!bi.empty())
    {
        cout << bi.top();
        bi.pop();
    }

    cout << endl;

    return 0;
}
