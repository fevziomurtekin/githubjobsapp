package com.fevziomurtekin.githubjobs.data

import android.content.Context
import android.preference.PreferenceManager

object StorageExt{

    fun savePref(context: Context, key: String, value: String) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(key, value).apply()
    }

    fun removePref(context: Context, key: String) {
        PreferenceManager.getDefaultSharedPreferences(context).edit().remove(key).apply()
    }

    fun getPref(context: Context, key: String): String? {
        return PreferenceManager.getDefaultSharedPreferences(context).getString(key, "")
    }

    fun hasPref(context: Context, keyUser: String): Boolean {
        return PreferenceManager.getDefaultSharedPreferences(context).contains(keyUser)
    }


}