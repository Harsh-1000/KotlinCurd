package serviceImpl

import dao.StudentDao
import db.StudentDatabaseConfig
import exception.CustomException
import model.Student
import service.StudentService
import java.sql.Connection

class StudentServiceImpl: StudentService {

    override fun listStudents(): List<Student> {
        return try {
            StudentDatabaseConfig.getConnection().use {
                StudentDao.getAll(it)
            }
        } catch (e: CustomException.StudentDBException){
            throw e
        }
    }

    override fun registerStudent(name: String, email: String): Student? {
        return try {
            StudentDatabaseConfig.getConnection().use {
                StudentDao.addStudent(it,name,email)
            }
        } catch (e : Exception){
            throw e
        }
    }
}

