package network

import io.ktor.client.HttpClient

expect fun createPlatformHttpClient(): HttpClient
