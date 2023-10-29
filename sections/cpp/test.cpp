#include <iostream>
#include <vector>
using namespace std;

int main() {
    float array[] = {1.1, 2.2, 3.3, 4.4, 5.5};
    vector<float> floatVector;
    floatVector.insert(floatVector.begin(), array, array + 5);
    vector<float>::iterator i = floatVector.begin();


    while (i != floatVector.end()) {
        cout << *i << " ";
        i++;
    }

    return 0;
}