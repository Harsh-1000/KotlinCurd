package service

import model.Student

interface StudentService {
     fun listStudents(): List<Student>
     fun registerStudent(name: String, email: String): Student?
}