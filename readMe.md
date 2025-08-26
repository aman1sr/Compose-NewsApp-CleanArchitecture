# MVVM Clean Arch NewsApp

## Overview
This is a  part_1 to understand the integration of BottomNavigation using AndroidX libraries

![Sample GIF](https://media.tenor.com/wXUw6BcUiBAAAAAM/spongebob-squarepants-cheer.gif)

## Overview of BottomNavigation impl 
- use of Route as a sealed class for type-safe navigation
- use of Navigation states for holding the current screen information
- use of Scaffold as main layout structure carring predefine slots for Common UI eg (bottomNav)
- use of NavHost as a container for managing the navigation graph (linking routes with its corresponding composables UI screens)
<br>
<br>
<br>
[![Read the Full Article on Medium](https://img.shields.io/badge/Read%20More%20on-Medium-green?logo=medium)](https://medium.com/@aman1024/bottom-nav-integration-in-newsapp-part-1-4bb868b8f62f)


## Dependency required

       ```
          implementation("androidx.navigation:navigation-compose:2.6.0")
       ```
   
## App demo
<p align="center">
  <img src="https://github.com/aman1sr/Compose-NewsApp-CleanArchitecture/blob/main/app/screenshots/bottom_nav_mvvm_newsapp.gif?raw=true" width="400"/>
</p>


---
##  Article references:
- [Special Thanks : khush panchal](https://github.com/khushpanchal/NewsApp/tree/master)
- [Article Link: Google Official doc](https://developer.android.com/develop/ui/compose/components/navigation-bar)
- [Article Link: Medium](https://medium.com/@ramadan123sayed/simple-guide-to-hilt-dependency-injection-in-android-with-jetpack-compose-and-ksp-3ddcbfaad37d)
