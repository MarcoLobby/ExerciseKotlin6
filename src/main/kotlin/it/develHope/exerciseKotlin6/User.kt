package it.develHope.exerciseKotlin6

fun main (){
    val user = User.EmailUser("PinoPigno","pigno1")
    val user1 = User.FacebookUser("PinoSpigno","spignopino2@live.it")
    val user2 = User.GoogleUser ("ElPinoLoco","pinoloco123","elpignoloco@gmail.it")

    getPrintableValue(user)
    getPrintableValue(user1)
    getPrintableValue(user2)
}

sealed class User (open val id: String, open val password: String?=null, open val email: String?=null) {
    data class EmailUser (override val id: String, override val password: String): User(id,password)
    data class FacebookUser (override val id: String, override val email: String) : User(id,email)
    data class GoogleUser (override val id: String, override val password: String, override val email: String): User(id,password,email)
}

fun getPrintableValue(user: User) = when (user){

    is User.EmailUser -> println("$user")
    is User.FacebookUser -> println("$user")
    is User.GoogleUser -> println("$user")
}






