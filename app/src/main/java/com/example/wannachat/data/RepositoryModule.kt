package com.example.wannachat.data

import com.example.wannachat.domain.ChatRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    @Singleton
    fun getRepo(impl: ChatRepoImpl): ChatRepo {
        return impl
    }

}