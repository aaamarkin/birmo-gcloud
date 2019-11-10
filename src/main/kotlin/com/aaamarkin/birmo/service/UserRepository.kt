package com.aaamarkin.birmo.service

//import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service
import java.util.concurrent.ExecutionException
import com.aaamarkin.birmo.model.PlayerModel
import kotlin.random.Random


interface UserRepository {
    @Throws(ExecutionException::class, InterruptedException::class)
    fun GetUserInfo(uid: String): PlayerModel
}

@Service(value = UserRepositoryImpl.NAME)
class UserRepositoryImpl: UserRepository {

    companion object {
        const val NAME = "io.ambidexter.firebase.service.UserRepository"
    }

    override fun GetUserInfo(uid: String): PlayerModel {
        return GetOrCreateUserInfo(uid);
    }

    @Throws(ExecutionException::class, InterruptedException::class)
    private fun GetOrCreateUserInfo(uid: String): PlayerModel {
//        val db = FirestoreClient.getFirestore()
//
//        val users = db.collection("users")
//        // Create a query against the collection.
//        val docRef = users.document(uid)
//        // retrieve  query results asynchronously using query.get()
//        val futureSnapshot = docRef.get()
//        val document = futureSnapshot.get()

        var user: PlayerModel? = null
//        if (document.exists()) {
//            user = document.toObject(PlayerModel::class.java)
//        } else {
//            user = CreateDefaultUserInfo()
//            val futureResult = db.collection("users").document(uid).set(user!!)
//        }

        return user!!
    }

    private fun CreateDefaultUserInfo(): PlayerModel {

        val userInfo = PlayerModel()
        userInfo.coins = 500
        userInfo.energy = 50
        userInfo.food = 0
        userInfo.rating = 0

        userInfo.updatedAt = System.currentTimeMillis()
        userInfo.id = Random.nextInt(Integer.MAX_VALUE)
        return userInfo
    }

}