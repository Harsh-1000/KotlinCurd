import kotlinx.coroutines.*
import model.Course
import model.Student
import service.CourseService
import service.StudentService
import serviceImpl.CourseServiceImpl
import serviceImpl.StudentServiceImpl

fun main(): Unit = runBlocking {

    val supervisor = SupervisorJob()
    val scope = CoroutineScope(Dispatchers.Default + supervisor)


    try {
        val studentService: StudentService = StudentServiceImpl()
        val courseService: CourseService = CourseServiceImpl()

        var allStudents : List<Student>? = null
        var allCourses : List<Course>? = null

        val studentJob = scope.launch {
            allStudents = studentService.listStudents()
        }

        val courseJob = scope.launch {
            allCourses = courseService.listCourses()
        }

        studentJob.join()
        courseJob.join()

        println("All Students")
        allStudents?.forEach { println(it) }

        println("All Courses")
        allCourses?.forEach { println(it) }

    } catch (e : Exception){
        println(e.message)
    }

 }


