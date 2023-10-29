#include <iostream>
#include <vector>
using namespace std;

int main() {
    int loc, data, i=0, *p;
    int arr[5] = {5,4,6,2,9};
 vector<int>vec (arr, arr+5); // initialize vector with array
 cout<<"Size of vector: "<<vec.size();
 cout<<"\n**Data in vector**";
 cout<<"\nFirst data : "<<vec.front(); // returns a reference to first element in vector
 cout<<"\nLast data : "<<vec.back();// returns a reference to last element in vector
 cout<<"\nMiddle data : "<<vec.at(2); // returns a reference to certain element in vector
 cout<<"\n\nCurrent content of vector: ";
 for (; i<vec.size();i++)
 cout<<vec[i]<<" "; // returns a reference to certain element in vector
 cout<<"\nEnter location of data (between 1 - "<<vec.size()<<") to update: ";
 cin>>loc;
 cout<<"Enter new data for location "<<loc<<": ";
 cin>>data;
 vec[loc-1] = data; //vec.at(loc-1) = data;
 cout<<"Updated content of vector: ";
 for (i = 0; i<vec.size();i++)
 cout<<vec.at(i)<<" ";
 p = vec.data(); // returns a direct pointer to the memory array
 p++;
 ++*p = 9;
 cout<<"\nUpdated content of vector: ";
 for (i = 0; i<vec.size();i++)
 cout<<vec.at(i)<<" ";
 return 0;
}