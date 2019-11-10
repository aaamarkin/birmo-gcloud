package com.aaamarkin.birmo.model

import java.util.*


class PlayerModel {

    var name: String? = null

    var id: Int = 0
    var random: Int = 0

    var coins: Long = 0
    var energy: Long = 0
    var rating: Long = 0
    var food: Long = 0
    var updatedAt: Long = 0


    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as PlayerModel?
        return coins == that!!.coins &&
                energy == that.energy &&
                rating == that.rating &&
                food == that.food &&
                id == that.id
    }

    override fun hashCode(): Int {
        return Objects.hash(id, name, coins, energy, rating, food)
    }

    override fun toString(): String {
        return "CoinsEastUserInfo{" +
                "name='" + name + '\''.toString() +
                ", coinsAmount=" + coins +
                ", energyAmount=" + energy +
                ", rating=" + rating +
                ", food=" + food +
                ", id=" + id +
                '}'.toString()
    }
}
