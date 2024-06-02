# WannaChat

## Description
The project is structured into 3 layers:
- __UI (MVVM)__ - Activity, Fragments, ViewModel, Navigator
- __Domain__ - facilitates app logic (date converter, sent/received state etc.)
- __Data__ - Repository, Network Data Source


Also have:
- Dependency Injection with Hilt Dagger
- Unit tests fot the ViewModels

## Screenshots 
<div class="row">
  <img src="app/app-screenshots/chats.png" width="30%"/>
  <img src="app/app-screenshots/conversation.png" width="30%"/>
  <img src="app/app-screenshots/error_screen.png" width="30%"/>
</div>        


## Tech stack & open-source libraries
- Min SDK level 24
- [Retrofit](https://github.com/square/retrofit)
- [Gson](https://github.com/google/gson)
- [Parcelize](https://plugins.gradle.org/plugin/org.jetbrains.kotlin.plugin.parcelize)
- [Glide](https://github.com/bumptech/glide)
- [Hilt](https://dagger.dev/hilt/) 
- [Material Design 3](https://m3.material.io/)
- Maps Play Services
