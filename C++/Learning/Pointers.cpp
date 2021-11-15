#include <stdlib.h>

#include <array>
#include <cmath>
#include <iomanip>
#include <iostream>
#include <list>
#include <random>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

int main() {
    int *ptr;

    int num = 1;

    ptr = &num;
    cout << ptr << endl;

    int PI = 3;
    ptr = &PI;
    cout << *ptr << endl;

    int **p_ptr = &ptr;

    cout << "ptr: " << ptr << endl;
    cout << "*ptr: " << *ptr << endl;

    cout << "p_ptr: " << p_ptr << endl;
    cout << "*p_ptr: " << *p_ptr << endl;
    cout << "**p_ptr: " << **p_ptr << endl;

    **p_ptr = 4;
    cout << "*ptr: " << **p_ptr << endl;

    list<int> l1;

    l1.push_back(1);
    l1.push_back(6);
    l1.push_back(4);

    l1.pop_back();

    for (list<int>::iterator i = l1.begin(); i != l1.end(); i++) {
        cout << *i << endl;
    }

    return 0;
}
