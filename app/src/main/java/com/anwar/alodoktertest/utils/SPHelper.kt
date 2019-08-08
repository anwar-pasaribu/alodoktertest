package com.anwar.alodoktertest.utils

import android.content.Context
import android.content.SharedPreferences
import com.anwar.alodoktertest.AlodokterApp
import com.anwar.alodoktertest.BuildConfig


class SPHelper {

    private val preferenceName = BuildConfig.APPLICATION_ID
    private var p: SharedPreferences? = null

    init {

        if (p == null) {
            p = AlodokterApp.instance.applicationContext.getSharedPreferences(preferenceName, Context.MODE_PRIVATE)
        }
    }

    fun getSharedPreferences(key: String, defValue: Int): Int {
        return p!!.getInt(key, defValue)
    }

    fun getSharedPreferences(key: String, defValue: Double): Double {
        return java.lang.Double.longBitsToDouble(
            p!!.getLong(
                key,
                java.lang.Double.doubleToLongBits(defValue)
            )
        )
    }

    fun getSharedPreferences(key: String, defValue: String): String? {
        return p!!.getString(key, defValue)
    }

    fun getSharedPreferences(key: String, defValue: Boolean): Boolean {
        return p!!.getBoolean(key, defValue)
    }

    fun setPreferences(key: String, value: Boolean) {
        val e = p!!.edit()
        e.putBoolean(key, value)
        e.apply()
    }

    fun setPreferences(key: String, value: CharSequence) {
        val e = p!!.edit()
        e.putString(key, value.toString())
        e.apply()
    }

    fun setPreferences(key: String, value: Int) {
        val e = p!!.edit()
        e.putInt(key, value)
        e.apply()
    }

    fun setPreferences(key: String, value: Double) {
        val e = p!!.edit()
        e.putLong(key, java.lang.Double.doubleToLongBits(value))
        e.apply()
    }

    fun clearData() {
        val e = p!!.edit().clear()
        e.commit()
    }

    companion object {
        val instance: SPHelper by lazy { SPHelper() }
    }
}
