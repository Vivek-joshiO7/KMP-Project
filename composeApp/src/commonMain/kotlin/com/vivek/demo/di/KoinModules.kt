package com.vivek.demo.di


import com.russhwolf.settings.Settings
import com.vivek.demo.data.local.manager.LocalUserManagerImpl
import com.vivek.demo.data.remote.KtorApiService
import com.vivek.demo.data.remote.KtorApiServiceImpl
import com.vivek.demo.data.repo.NewsRepoImpl
import com.vivek.demo.domain.manager.LocalUserManager
import com.vivek.demo.domain.repo.NewsRepo
import com.vivek.demo.domain.usecase.GetNewsUseCase
import com.vivek.demo.domain.usecase.local_store_settings.GetUserEntry
import com.vivek.demo.domain.usecase.local_store_settings.SaveUserEntry
import com.vivek.demo.domain.usecase.local_store_settings.UserEntryUseCases
import com.vivek.demo.ui.screens.news_screen.NewsViewModel
import com.vivek.demo.ui.screens.onboarding.OnboardingViewModel
import com.vivek.demo.utils.Constants
import io.ktor.client.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val koinModule = module {

    factory {
        HttpClient {
            install(ContentNegotiation) {
                json(
                    json = Json {
                        ignoreUnknownKeys = true
                    }, contentType = ContentType.Any
                )
            }
            install(HttpTimeout) {
                socketTimeoutMillis = 3000
                connectTimeoutMillis = 3000
                requestTimeoutMillis = 3000
            }
            install(Logging) {
                level = LogLevel.ALL
            }
            install(DefaultRequest) {
                url {
                    host = Constants.BASE_URL
                    protocol = URLProtocol.HTTPS
                }
            }
        }
    }

    factory<KtorApiService> {
        KtorApiServiceImpl(ktorClient = get())
    }

    factory<NewsRepo> {
        NewsRepoImpl(ktorApiService = get())
    }

    factory {
        GetNewsUseCase(repo = get())
    }
    factory <Settings> { Settings() }

    factory<LocalUserManager> {
        LocalUserManagerImpl(localStoreSetting = get())
    }

    single {
        UserEntryUseCases(
            getUserEntry = GetUserEntry(get()),
            saveUserEntry = SaveUserEntry(get())
        )
    }


}

val koinViewModelModule = module {
    viewModel { NewsViewModel(newsUseCase = get()) }
    viewModel { OnboardingViewModel(get()) }
}

expect fun sharedViewModelModule(): Module