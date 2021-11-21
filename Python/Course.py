class Course:
    def __init__(self, courseName):
        self.courseName = courseName
        self.students = []
        self.MAX_COURSE_SIZE = 100

    def addStudent(self, student):
        if len(self.students) == self.MAX_COURSE_SIZE:
            return
        self.students.append(student)

    def getNumberStudents(self):
        return len(self.students)

    def showStudents(self):
        print(*self.students, end='\n')

    def getCourseName(self):
        return self.courseName

    def dropStudent(self, student):
        self.students.remove(student)


def main():
    MAC2311 = Course('MAC2311')

    while True:
        print("Enter 1 to add a student:")
        print("Enter 2 to drop a student:")
        print("Enter 3 to view the students in the course:")
        print("Enter 4 to see the number of students in the course:")
        print("Enter 5 to quit the program.")

        while True:
            try:
                choice = int(input())
                break
            except:
                print('PLEASE ENTER A INTEGER!')

        if choice == 1:
            name = input('Enter the name of the student :: ')
            MAC2311.addStudent(name)
        elif choice == 2:
            name = input('Enter student to drop :: ')
            MAC2311.dropStudent(name)
        elif choice == 3:
            MAC2311.showStudents()
        elif choice == 4:
            print(MAC2311.getNumberStudents())
        elif choice == 5:
            break
        else:
            print('INVALID CHOICE!')


if __name__ == '__main__':
    main()
