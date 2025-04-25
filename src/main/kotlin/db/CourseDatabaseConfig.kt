package db

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.sql.Connection

object CourseDatabaseConfig {
    private val config = HikariConfig().apply {
        jdbcUrl = System.getenv("COURSE_DB_URL")
        username = System.getenv("DB_USER")
        password = System.getenv("DB_PASSWORD")
    }

    private val dataSource = HikariDataSource(config)

    fun getConnection(): Connection {
        return dataSource.connection
    }
}