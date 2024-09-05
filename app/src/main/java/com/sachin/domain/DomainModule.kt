package com.sachin.domain

import com.sachin.domain.books.BooksHelper
import com.sachin.domain.books.BooksHelperImpl
import com.sachin.domain.cart.CartHelper
import com.sachin.domain.cart.CartHelperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideDomainHelper(domainHelper: DomainHelperImpl): DomainHelper {
        return domainHelper
    }

    @Provides
    @Singleton
    fun provideCartHelper(cartHelper: CartHelperImpl): CartHelper {
        return cartHelper
    }

    @Provides
    @Singleton
    fun provideBooksHelper(booksHelper: BooksHelperImpl): BooksHelper {
        return booksHelper
    }

}