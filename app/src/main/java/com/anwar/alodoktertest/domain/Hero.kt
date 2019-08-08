package com.anwar.alodoktertest.domain

import java.io.Serializable

class Hero(
    val id: Long,
    val images: List<String>
) : Serializable {

    val firstImage = images[0]

    override fun equals(other: Any?): Boolean {
        return this.id == (other as Hero).id
    }

    override fun toString(): String {
        return "Hero(id=$id, images=$images, firstImage='$firstImage')"
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }


}