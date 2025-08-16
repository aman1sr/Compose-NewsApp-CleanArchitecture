# MVVM Clean Arch NewsApp

## Overview
This is a  part_1 to understand the integration of BottomNavigation using AndroidX libraries

![Sample GIF](https://media.tenor.com/wXUw6BcUiBAAAAAM/spongebob-squarepants-cheer.gif)

## Overview of BottomNavigation impl 
- use of Route as a sealed class for type-safe navigation
- use of Navigation states for holding the current screen information
- use of Scaffold as main layout structure carring predefine slots for Common UI eg (bottomNav)
- use of NavHost as a container for managing the navigation graph (linking routes with its corresponding composables UI screens)


## Dependency required

       ```
        //Navigation Components
   implementation("androidx.navigation:navigation-compose:2.6.0")
      ```
   


---
##  Article references:
- [Special Thanks : khush panchal](https://github.com/khushpanchal/NewsApp/tree/master)
- [Article Link: Google Official doc](https://developer.android.com/develop/ui/compose/components/navigation-bar)
- [Article Link: Medium](https://medium.com/@ramadan123sayed/simple-guide-to-hilt-dependency-injection-in-android-with-jetpack-compose-and-ksp-3ddcbfaad37d)