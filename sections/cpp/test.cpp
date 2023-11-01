#include <iostream>
#include <list>
using namespace std;

void display(list<float> lst) {
    list<float>::iterator i = lst.begin();
    for(;i != lst.end(); i++)
        cout << *i << " ";
}

int main() {
    float arr[] = {54.6, 78.2, 89.1, 55.7, 60.5};
    list <float> all(arr, arr+5);

    cout<<"\nData in list all: "; display(all);

    list<float>::iterator i = all.end();
    // advance(i, -1);
    i--;
    all.insert(i, 33.3);
    // all.splice(all.end(), local);
    cout<<"\nData in list local: "; display(all);
    // cout<<"\nData in list all: "; display(all);
    int total = 0;
    list<float>::iterator it = all.begin();
    for(;it != all.end(); it++)
        if(*it > 60)
            total++;
    cout<<"\nTotal: "<<total;

    // replace(all.begin(), all.end(), "Apple", "Lemon");
    // cout<<"\nData in list all: "; display(all);

    // list <string>::iterator i = all.begin();
    // advance(i, 2);
    // all.insert(i, "Avocado");
    // cout<<"\nData in list all: "; display(all);
    // cout<<"\nThe end";
    return 0; 

}