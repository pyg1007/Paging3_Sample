package kr.ryan.paging_sample.retrofit

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.ryan.paging_sample.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Paging-Sample
 * Class: GitHubRetrofitModule
 * Created by pyg10.
 * Created On 2021-11-22.
 * Description:
 */
@Module
@InstallIn(SingletonComponent::class)
object GitHubRetrofitModule {

    private const val BASE_URL = "https://api.github.com/search/"

    @Singleton
    @Provides
    fun provideGitHubRetrofit(
        client: OkHttpClient
    ): GitHubService {
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(GitHubService::class.java)
    }

    @Singleton
    @Provides
    fun provideInterceptor() : Interceptor{
        return HttpLoggingInterceptor().apply {
            level = when{
                BuildConfig.DEBUG -> HttpLoggingInterceptor.Level.BODY
                else -> HttpLoggingInterceptor.Level.NONE
            }
        }
    }

    @Singleton
    @Provides
    fun provideClient(
        interceptor: Interceptor
    ): OkHttpClient{
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
    }

}