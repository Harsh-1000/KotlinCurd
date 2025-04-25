package dao

import exception.CustomException
import model.Course
import java.sql.Connection
import java.sql.SQLException

object CourseDao {
    fun getAll(conn: Connection): List<Course>{

        val courses = mutableListOf<Course>()
        try {
            conn.prepareStatement("select * from courses").use {
                    stmt -> stmt.executeQuery().use { rs ->
                while (rs.next()){
                    courses.add(
                        Course(
                            id = rs.getInt("id"),
                            title = rs.getString("title"),
                            description = rs.getString("description"),
                        )
                    )
                }
            }
            }
        } catch (e: SQLException){
            throw CustomException.CourseDBException("Error while fetching courses ${e.message}")
        }

        return courses
    }
}