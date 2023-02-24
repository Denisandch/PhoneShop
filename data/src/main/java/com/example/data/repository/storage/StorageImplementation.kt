package com.example.data.repository.storage

import android.content.Context
import android.content.SharedPreferences
import com.example.data.repository.model.PhoneDescriptionData
import com.example.data.repository.model.PhoneData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

private const val SHARED_PREFERENCES_DATA = "dataShared"
private const val SAVE_LIST = "list"

class StorageImplementation(
    private val context: Context
) : Storage {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(SHARED_PREFERENCES_DATA, Context.MODE_PRIVATE)
    private val gson = Gson()
    private val phoneListClassType: Type = object : TypeToken<List<PhoneData>>() {}.type

    override suspend fun getPhoneList(): List<PhoneData>? {
        val json = sharedPreferences.getString(SAVE_LIST, null)

        return if (json == null) {
            null
        } else {
            gson.fromJson(json, phoneListClassType) as List<PhoneData>
        }
    }

    override suspend fun getDescription(phoneID: Int): PhoneDescriptionData? {
        val json = sharedPreferences.getString(phoneID.toString(), null)

        return if (json == null) {
            null
        } else {
            gson.fromJson(json, PhoneDescriptionData::class.java)
        }
    }

    override suspend fun savePhoneList(list: List<PhoneData>): Boolean {
        sharedPreferences
            .edit()
            .putString(SAVE_LIST, gson.toJson(list))
            .apply()
        return true
    }

    override suspend fun savePhoneDescription(description: PhoneDescriptionData): Boolean {
        sharedPreferences
            .edit()
            .putString(description.id.toString(), gson.toJson(description))
            .apply()
        return true
    }

}