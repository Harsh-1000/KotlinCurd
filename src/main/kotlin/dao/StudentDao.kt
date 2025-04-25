package dao

import exception.CustomException
import model.Student
import java.sql.Connection
import java.sql.SQLException


object StudentDao {

    fun getAll(conn: Connection): List<Student>{

        val students = mutableListOf<Student>()
        try {
            conn.prepareStatement("select * from students").use {
                stmt -> stmt.executeQuery().use { rs ->
                    while (rs.next()){
                        students.add(
                            Student(
                                id = rs.getInt("id"),
                                name = rs.getString("name"),
                                email = rs.getString("email"),
                                )
                        )
                    }
            }
            }
        } catch (e: SQLException){
            throw CustomException.StudentDBException("Error while fetching students ${e.message}")
        }

        return students
    }

    fun addStudent(conn: Connection,name : String, email: String) : Student? {

        try {
            val query = "insert into students (name,email) values (? , ?) returning id,name,email"
            conn.prepareStatement(query).use {
                    stmt ->
                stmt.setString(1,name)
                stmt.setString(2,email)
                stmt.executeQuery().use { rs ->
                    if(rs.next()){
                         return  Student(
                            id = rs.getInt("id"),
                            name = rs.getString("name"),
                            email = rs.getString("email")
                        )
                    }
                }
            }

        } catch (e: SQLException){
            throw CustomException.StudentRegistrationException("Failed to register student ${e.message}")
        }

        return null
    }

}