package com.example.appcompose.datastore
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

const val Settings = "settings"
@Module
@InstallIn(SingletonComponent::class)
class DataStoreModule {
    @Provides
    @Singleton

    fun providerPreferenceDataStore(
        @ApplicationContext context: Context //acessar recursos do contexto da aplicação
    ): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create(
            produceFile = { context.preferencesDataStoreFile("Settings")}
        )

    }
}