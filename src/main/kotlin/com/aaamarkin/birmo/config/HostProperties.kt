package com.aaamarkin.birmo.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.PropertySource

@Configuration
@PropertySource("classpath:config.properties")
@ConfigurationProperties(prefix = "host")
class HostProperties {

    var local: Boolean = true
    lateinit var credentials: String
    lateinit var projectId: String
}