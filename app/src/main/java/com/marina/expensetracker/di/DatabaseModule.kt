package com.marina.expensetracker.di

import android.content.Context
import com.marina.expensetracker.data.ExpenseDataBase
import com.marina.expensetracker.data.dao.ExpenseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): ExpenseDataBase {
        return ExpenseDataBase.getInstance(context)
    }

    @Provides
    fun provideExpenseDao(dataBase: ExpenseDataBase): ExpenseDao {
        return dataBase.expenseDao()
    }
}
