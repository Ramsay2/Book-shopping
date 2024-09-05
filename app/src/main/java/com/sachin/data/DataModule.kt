package com.sachin.data

import com.sachin.data.db.DatabaseModule
import com.sachin.data.http.ApiModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module(includes = [ApiModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideDataHelper(dataHelper: DataHelperImpl): DataHelper {
        return dataHelper
    }

}