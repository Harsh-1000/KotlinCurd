import exception.CustomException
import kotlinx.coroutines.runBlocking
import service.CourseService
import service.StudentService
import serviceImpl.CourseServiceImpl
import serviceImpl.StudentServiceImpl

fun main()  {

    try {

        val studentService: StudentService = StudentServiceImpl()
        val courseService: CourseService = CourseServiceImpl()

        val allStudents = studentService.listStudents()
        val allCourse = courseService.listCourses()

        println("All Students")
        allStudents.forEach { println(it) }

        println("All Courses")
        allCourse.forEach { println(it) }

        val newStudent = studentService.registerStudent("Monkey.D.Luffy","one.piece@gmail.com") ?: "Student Not Added"
        println(newStudent)
    } catch (e : Exception){
        println(e.message)
    }

 }


