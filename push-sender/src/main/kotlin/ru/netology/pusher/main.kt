package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

    val token = "c5sY3QZ9TuSsa8MlzWfbsz:APA91bFSyai_W5DvuOAUyo3o5ZmClyBcxNRO2LBSgHzIpowyAXVeKmpLg6z6dBXtFnRG1PHHCvUI5M5zYO8iiAOZgfZPyYav-ibT9x032aeilg_STIZDR1o"
    val message = Message.builder()
        .putData("action", "LIKE")
        .putData("content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 2,
          "postAuthor": "Netology"
        }""".trimIndent())
        .setToken(token)
        .build()

    val messagePost = Message.builder()
        .putData("action", "POST")
        .putData("content", """{
          "userId": 1,
          "userName": "Danilich",
          "postId": 2,
          "postText": "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb"
        }""".trimIndent())
        .setToken(token)
        .build()

    FirebaseMessaging.getInstance().send(messagePost)
}
