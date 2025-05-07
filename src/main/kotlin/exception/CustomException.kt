package exception

sealed class CustomException(message: String) : Exception(message) {

    class NotFound(message: String = "Resource not found") : CustomException(message)
    class InValidDataException(message: String = "Valid data is not provided") : CustomException(message)
    class StudentDBException(message: String= "Error Student DB"): CustomException(message)
    class CourseDBException(message: String= "Error Course DB"): CustomException(message)
    class StudentRegistrationException(message: String = "Error in register student"): CustomException(message)
}

