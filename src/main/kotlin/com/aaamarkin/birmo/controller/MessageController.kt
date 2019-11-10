package com.aaamarkin.birmo.controller

import com.aaamarkin.birmo.config.HostProperties
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.aaamarkin.birmo.service.UserRepository
import org.springframework.beans.factory.annotation.Autowired



data class Message(val text: String, val priority: String)

@RestController
class MessageController {

    @Autowired(required = true)
    lateinit var userRepository: UserRepository

    @Autowired(required = true)
    lateinit var hostProperties: HostProperties

    @RequestMapping("/message")
    fun message(): Message {
//        userRepository.GetUserInfo("test_user");
        return Message("Hello from Google Cloud ${hostProperties.local}", "High")
    }
}