// Largest Difference
// Programming challenge description:
// Write a program that finds the greatest difference between integers in a list. The list can contain positive and negative integers.
// Input:
// Your program should read lines from standard input. Each line contains a comma-separated list of integers.
// Output:
// For each input list, print to standard output the greatest difference between any two integers in the list. Print each difference on its own line.
// Test 1
// Test Input
// Download Test 1 Input
// 1,2,10,0,3,9
// Expected Output
// Download Test 1 Output
// 10
// Test 2
// Test Input
// Download Test 2 Input
// 4,-9,-3,0,7,9
// Expected Output
// Download Test 2 Output
// 18

#include <iostream>
#include <string>
#include <vector>
#include <sstream>
#include <algorithm>
#include <iterator>
#include <limits>

using namespace std;

int main()
{
    string line;
    while (getline(cin, line))
    {
        vector<int> v;
        istringstream iss(line);
        copy(istream_iterator<int>(iss), istream_iterator<int>(), back_inserter(v));
        int min = numeric_limits<int>::max();
        int max = numeric_limits<int>::min();
        for (auto i : v)
        {
            if (i < min)
            {
                min = i;
            }
            if (i > max)
            {
                max = i;
            }
        }
        cout << max - min << endl;
    }
    return 0;
}

