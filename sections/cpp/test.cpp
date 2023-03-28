#include <iostream>
using namespace std;

class AutoVsStatic
{
public:
    AutoVsStatic(int i, string num)
    {
        x = i;
        s = num;
        cout << x << "&" << s << " Created" << endl;
    }

    ~AutoVsStatic()
    {
        cout << x << "&" << s << " Destroyed" << endl;
    }

private:
    int x;
    string s;
};

void func()
{
    AutoVsStatic a(4, "four"); 
    static AutoVsStatic b(5, "five");
    AutoVsStatic c(6, "six"); // 4) all objects are created in the order they are declared 
} // 5) function ends. therefor, all objects (EXCEPT STATIC) are destroyed in reverse order of creation

int main()
{
    AutoVsStatic a(1, "one");// 2) then main function is called and all objects before the next function call are created
    static AutoVsStatic b(2, "two");
    func(); // 3) then func() is called hence we go to that function and execute it before returning to main
    AutoVsStatic c(3, "three"); // 6) we return to main and create the last object

    return 0;
}

AutoVsStatic z(0, "zero"); // 1) global varibles are always created first