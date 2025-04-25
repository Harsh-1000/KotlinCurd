package service

import model.Course

interface CourseService {
    fun listCourses(): List<Course>
}