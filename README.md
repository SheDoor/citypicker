# CityPicker
fork form https://github.com/crazyandcoder/citypicker . change something!


> 为了方便使用，fork 原库的代码重新配置。


Step 1. Add the JitPack repository to your build file


Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.SheDoor:citypicker:v1.0'
	}
