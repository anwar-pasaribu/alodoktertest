/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.anwar.alodoktertest.data

import androidx.lifecycle.MutableLiveData
import com.anwar.alodoktertest.domain.Hero

/**
 * Provide data for Hero list.
 */
class StaticRepository {

    fun getHeroes() = MutableLiveData<List<Hero>>().apply {
        val heroList = listOf(
            Hero(
                System.currentTimeMillis(),
                listOf(
                "https://firebasestorage.googleapis.com/v0/b/itung-1993.appspot.com/o/hero%2Fcaptain-marvel%2Fcaptain-marvel1.jpg?alt=media&token=7e03f034-7a42-4cd4-a53d-3e0819f50d9a",
                "https://firebasestorage.googleapis.com/v0/b/itung-1993.appspot.com/o/hero%2Fcaptain-marvel%2Fcaptain-marvel5.png?alt=media&token=89b0440b-ba79-4fd0-b598-98a6c96b5013",
                "https://firebasestorage.googleapis.com/v0/b/itung-1993.appspot.com/o/hero%2Fcaptain-marvel%2Fcaptain-marvel3.jpg?alt=media&token=12ccbc41-06d8-439f-9da9-4f3b30e607a0",
                "https://firebasestorage.googleapis.com/v0/b/itung-1993.appspot.com/o/hero%2Fcaptain-marvel%2Fcaptain-marvel4.jpeg?alt=media&token=cd785b6a-d2ae-4ac9-95ef-2648830f02c4"
                )
            ),
            Hero(
                System.currentTimeMillis(),
                listOf(
                    "https://firebasestorage.googleapis.com/v0/b/itung-1993.appspot.com/o/hero%2Fthanos%2Fthanos-01.jpg?alt=media&token=31139302-2815-4ea5-ac2b-60aedb14a3c5",
                    "https://firebasestorage.googleapis.com/v0/b/itung-1993.appspot.com/o/hero%2Fthanos%2Fthanos-02.png?alt=media&token=d0914de6-d5df-46c8-80ca-fda05a30ef34",
                    "https://firebasestorage.googleapis.com/v0/b/itung-1993.appspot.com/o/hero%2Fthanos%2Fthanos-03.jpg?alt=media&token=76d0a71d-b8a0-4b12-af29-f33097b0f560",
                    "https://firebasestorage.googleapis.com/v0/b/itung-1993.appspot.com/o/hero%2Fthanos%2Fthanos-04.png?alt=media&token=ee3aefdc-a53e-409d-a9c7-806e1c08bfb3"
                )
            ),
            Hero(
                System.currentTimeMillis(),
                listOf(
                    "https://firebasestorage.googleapis.com/v0/b/itung-1993.appspot.com/o/hero%2Fspider-man%2Fspider-01.webp?alt=media&token=49bc9f28-f49f-447d-b28d-292219c8bb5e",
                    "https://firebasestorage.googleapis.com/v0/b/itung-1993.appspot.com/o/hero%2Fspider-man%2Fspider-02.png?alt=media&token=4af491bc-5138-443b-adf7-af342ae1d42b",
                    "https://firebasestorage.googleapis.com/v0/b/itung-1993.appspot.com/o/hero%2Fspider-man%2Fspider-03.jpg?alt=media&token=9aa6441c-45bb-45b7-b4a9-a00800a510f2",
                    "https://firebasestorage.googleapis.com/v0/b/itung-1993.appspot.com/o/hero%2Fspider-man%2Fspider-04.jpg?alt=media&token=085b6077-167a-44ee-bc47-25acd931fc02"
                )
            )
        )
        value = heroList
    }

    companion object {

        @Volatile private var instance: StaticRepository? = null

        fun getInstance() =
                instance ?: synchronized(this) {
                    instance ?: StaticRepository().also { instance = it }
                }
    }
}
