import SwiftUI
import shared

@main
struct iOSApp: App {
        startKoin {
            modules(koinModule, koinViewModelModule, sharedViewModelModule())
        }
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}