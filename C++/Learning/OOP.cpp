#include <stdlib.h>

#include <array>
#include <cmath>
#include <iomanip>
#include <iostream>
#include <list>
#include <random>
#include <string>
#include <vector>

using namespace std;

// members are PUBLIC by default
struct Student {
    string name;
    int age;
    vector<int> grades;

    double avg() {
        double sum = 0;
        for (int i = 0; i < grades.size(); i++) {
            sum += grades[i];
        }

        return sum / grades.size();
    }
};

class Car {
   public:
    string brand;
    string model;
    int year;

    Car(string brand, string model, int year) {
        this->brand = brand;
        this->model = model;
        this->year = year;
    }

    Car(string brand, string model) {
        this->brand = brand;
        this->model = model;
        this->year = 0;
    }

    // un-implemented method
    void called();

    // DESTRUCTOR: runs right before the object instance is being cleared from memory
    ~Car() {
        cout << "Car: " << brand << " is being destroyed!" << endl;
    }
};

void Car::called() {
    cout << "Called!" << endl;
}

int main() {
    Student student1;

    student1.name = "Sebastian";
    student1.age = 20;
    student1.grades.push_back(90);
    student1.grades.push_back(92);

    cout << &student1 << endl;
    cout << "avg of " << student1.name << " = " << student1.avg() << "%" << endl;

    // NOTE: use arrow operator to access specific value/property of a object
    Student *ptr = &student1;
    cout << "Age of " << ptr->name << " is " << ptr->age << endl;

    Car carObj1("BMW", "X5", 1999);
    Car carObj2("Ford", "Mustang", 1969);
    Car carObj3("Kia", "Forte");

    // Print values
    cout << carObj1.brand << " " << carObj1.model << " " << carObj1.year << "\n";
    cout << carObj2.brand << " " << carObj2.model << " " << carObj2.year << "\n";
    cout << carObj3.brand << " " << carObj3.model << " " << carObj3.year << "\n";

    carObj1.called();
    return 0;
}
