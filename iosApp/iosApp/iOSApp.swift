import SwiftUI
import shared

@main
struct iOSApp: App {
        startKoin {
            modules(koinModule,sharedViewModelModule())
        }
    var body: some Scene {
        WindowGroup {
            ContentView()
        }
    }
}