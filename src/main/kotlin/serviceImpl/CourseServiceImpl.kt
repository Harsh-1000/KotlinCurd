package serviceImpl

import dao.CourseDao
import db.CourseDatabaseConfig
import model.Course
import service.CourseService
import java.sql.Connection

class CourseServiceImpl : CourseService {
    override fun listCourses(): List<Course> {
        return  CourseDatabaseConfig.getConnection().use {
                CourseDao.getAll(it)
        }
   }

}