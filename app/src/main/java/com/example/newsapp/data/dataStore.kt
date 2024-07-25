package com.example.newsapp.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "user_datastore")

//private const val TAG = "dataStore"
class DataStoreManager(val context: Context) {

    companion object {
        val TEMP_POP = booleanPreferencesKey("TEMP_POP")

    }

}


suspend fun Context.dataStoreSetGroupPopup(data: Boolean) {
    dataStore.edit {
        it[DataStoreManager.TEMP_POP] = data
    }
}

fun Context.dataStoreGetGroupPopup() = dataStore.data.map {
    it[DataStoreManager.TEMP_POP] ?: false
}


private fun generateList(list: ArrayList<String>): String {
    var str = ""

    list.forEach {
        str = if (str == "") it
        else ",$it"
    }

    return str
}


