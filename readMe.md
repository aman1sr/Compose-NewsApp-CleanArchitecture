# MVVM Clean Arch NewsApp

## Overview
This is a  part 2 to understand the integration of Hilt DI for network calling

![Sample GIF](https://mir-s3-cdn-cf.behance.net/project_modules/source/5eeea355389655.59822ff824b72.gif)

## Overview of Hilt impl
- 


## Dependency required

       ```
     //coil
    implementation("io.coil-kt.coil3:coil-compose:3.3.0")
    implementation("io.coil-kt.coil3:coil-network-okhttp:3.3.0")
    
     //Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.5.0")

    // Dagger-Hilt ( check kotlin version compactible with hilt : https://stackoverflow.com/a/68319048)
    implementation ("com.google.dagger:hilt-android:2.57.1")
    kapt ("com.google.dagger:hilt-compiler:2.57.1")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
       ```
   
## App demo
<p align="center">
  <img src="https://github.com/aman1sr/Compose-NewsApp-CleanArchitecture/blob/feat/network_layer_hilt/app/screenshots/hilt_di.gif?raw=true" width="400"/>
</p>


---
##  Article references:
- [Article Link: Google Official doc](https://developer.android.com/training/dependency-injection/hilt-android)
