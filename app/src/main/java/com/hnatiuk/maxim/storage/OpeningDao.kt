package com.hnatiuk.maxim.storage

import android.content.Context

private const val PREFERENCES_NAME = "_opening"

class OpeningDao(context: Context) {

    companion object {
        private const val OPENING_TIMES = "OPENING_TIMES"
    }

    private val preferences by lazy {
        context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)
    }

    fun getOpeningTimes(): Int {
        return preferences.getInt(OPENING_TIMES, 0)
    }

    fun increaseOpeningTimes() {
        val currentTimes = getOpeningTimes() + 1
        preferences
            .edit()
            .putInt(OPENING_TIMES, currentTimes)
            .apply()
    }
}