package com.example.appcompose.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(Settings)
class AppDataStore @Inject constructor(
    private var dataStore: DataStore<Preferences>
) {

    suspend fun putBoolean(Key: Preferences.Key<Boolean>, value: Boolean) {
        dataStore.edit { preferences ->
            preferences[Key] = value
        }
    }

    fun getBoolean(Key:Preferences.Key<Boolean>): Flow<Boolean>{
        return dataStore.data.map { preferences -> preferences[Key] ?: false }
    }
}