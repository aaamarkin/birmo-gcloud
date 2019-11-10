package com.aaamarkin.birmo.config

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import java.io.IOException
import javax.annotation.PostConstruct

@Configuration
class FirebaseConfig {

    @Autowired
    lateinit var hostProperties: HostProperties

    @PostConstruct
    fun init() {
        FirebaseApp.initializeApp(localOptions());
        if (true){
            FirebaseApp.initializeApp(localOptions());
        } else {
            FirebaseApp.initializeApp(cloudOptions());
        }

    }

    @Throws(IOException::class)
    private fun localOptions(): FirebaseOptions {

        val resource = ClassPathResource(
                "tmp.json").inputStream

        return FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(resource))
                .setProjectId("aaamarkin-386a0")
                .build()
    }

    @Throws(IOException::class)
    private fun cloudOptions(): FirebaseOptions {
        return FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.getApplicationDefault())
                .setProjectId("aaamarkin-386a0")
                .build()
    }
}