# MicroExperiment for Performance Evaluation

`./gradlew bundle`

## Before Running

### BundleTool

To extract `.apk` from `.aab` file, we used [bundletool](https://github.com/google/bundletool/). We just download the [version 1.15.1 jar file](https://github.com/google/bundletool/releases/download/1.15.5/bundletool-all-1.15.5.jar) and run it with some parameters detailed below.

### Execution Environment

To run the experiment we use an Android Emulator API 33.

- In one shell we call the emultor:

```
emulator -avd Pixel_7_Pro_API_33
```

Such a `Pixel_7_Pro_API_33` emulator was previously created with AVD Manager from Android Studio.

- In another shell we call logcat for monitor performance

```
adb shell logcat | grep MICROEXPERIMENT
```

### Passing parameter via adb

```
shell am start -a android.intent.action.VIEW -n app.microexperiment/.MainActivity -e MUID "ae7f9682-6bd8-45e8-a3da-4020ccc153fa"
```

with -a did not work. I removed the -a parameter and run the command below:

```
adb shell setprop debug.MUID "ae7f9682-6bd8-45e8-a3da-4020ccc153fa"
adb shell am start -n app.microexperiment/.MainActivity -e MUID "ae7f9682-6bd8-45e8-a3da-4020ccc153fa"
```


Inside the app, we can recover this parameter by calling:

```
getIntent().getStringExtra("MUID")
```

### Simplifying apk

cd app/build/outputs/bundle/release/apks/splits
java -jar /local/tools/simplify/simplify/build/libs/simplify.jar -it "org/cf/obfuscated" -et "MainActivity" base-master.apk

// My password for sign auri5113
jarsigner -verbose -sigalg SHA1withRSA -digestalg SHA1 -keystore ~/insync/keystores/upload-keystore.jks base-master_simple.apk key0

apksigner sign -verbose -ks ~/insync/keystores/upload-keystore.jks --out "$OUT_SIGNED" "$OUT_ALIGNED"

This did not work... App cannot be installed due to some errors

## Experimental Results Using R8 minify for APK code optimization in Debug version

```
cd app/build/outputs/bundle/debug
java -jar /local/tools/bundletool/bundletool-all-1.15.5.jar build-apks --bundle=app-debug.aab --output=output.apks
mv output.apks output.zip
unzip -d apks output.zip
cd apks/splits/
adb install base-master.apk
```

### Collected Times:

10-30 10:17:21.465 18127 18160 D MICROEXPERIMENT: Experiment 'static final, static init, first path' took 104ms
10-30 10:17:22.723 18127 18160 D MICROEXPERIMENT: Experiment 'static final, static init, else path' took 1258ms
10-30 10:17:22.831 18127 18160 D MICROEXPERIMENT: Experiment 'static non-final, static init, first path' took 108ms
10-30 10:17:24.203 18127 18160 D MICROEXPERIMENT: Experiment 'static non-final, static init, else path' took 1371ms
10-30 10:17:25.755 18127 18160 D MICROEXPERIMENT: Experiment 'static final, property, first path' took 1552ms
10-30 10:17:27.164 18127 18160 D MICROEXPERIMENT: Experiment 'static final, property, else path' took 1407ms
10-30 10:17:28.532 18127 18160 D MICROEXPERIMENT: Experiment 'static non-final, property, first path' took 1368ms
10-30 10:17:29.926 18127 18160 D MICROEXPERIMENT: Experiment 'static non-final, property, else path' took 1393ms

It seems optimization options has no effect on debug release.

## Experimental Results Using R8 minify for APK code optimization in Release version

```
cd app/build/outputs/bundle/release/
java -jar /local/tools/bundletool/bundletool-all-1.15.5.jar build-apks --bundle=app-release.aab --output=output.apks
mv output.apks output.zip
unzip -d apks output.zip
cd apks/splits/
adb install base-master.apk
```
### Collected Times:

10-30 10:18:49.559 18507 18540 D MICROEXPERIMENT: Experiment 'static final, static init, first path' took 252ms
10-30 10:18:49.781 18507 18540 D MICROEXPERIMENT: Experiment 'static final, static init, else path' took 221ms
10-30 10:18:50.003 18507 18540 D MICROEXPERIMENT: Experiment 'static non-final, static init, first path' took 221ms
10-30 10:18:50.218 18507 18540 D MICROEXPERIMENT: Experiment 'static non-final, static init, else path' took 215ms
10-30 10:19:12.430 18507 18540 D MICROEXPERIMENT: Experiment 'static final, property, first path' took 22211ms
10-30 10:19:35.185 18507 18540 D MICROEXPERIMENT: Experiment 'static final, property, else path' took 22754ms
10-30 10:19:58.293 18507 18540 D MICROEXPERIMENT: Experiment 'static non-final, property, first path' took 23107ms
10-30 10:19:59.804 18507 18540 D MICROEXPERIMENT: Experiment 'static non-final, property, else path' took 1511ms

It seems optimization options has some problems with the use of get/set prop.


### Collected Times for setprop and parameters via adb shell

10-31 10:45:44.788 14506 14506 D MICROEXPERIMENT: MUID value ae7f9682-6bd8-45e8-a3da-4020ccc153fa
10-31 10:45:55.976 14506 14546 D MICROEXPERIMENT: debud.MUID Value 'ae7f9682-6bd8-45e8-a3da-4020ccc153fa
10-31 10:45:55.987 14506 14546 D MICROEXPERIMENT: debud.MUID Value 'ae7f9682-6bd8-45e8-a3da-4020ccc153fa
10-31 10:45:56.360 14506 14546 D MICROEXPERIMENT: Experiment 'static final, static init, first path' took 372ms
10-31 10:45:56.606 14506 14546 D MICROEXPERIMENT: Experiment 'static final, static init, else path' took 245ms
10-31 10:45:56.852 14506 14546 D MICROEXPERIMENT: Experiment 'static non-final, static init, first path' took 246ms
10-31 10:45:57.069 14506 14546 D MICROEXPERIMENT: Experiment 'static non-final, static init, else path' took 217ms
10-31 10:45:57.892 14506 14546 D MICROEXPERIMENT: Experiment 'static non-final, static init, parameter, first path' took 822ms
10-31 10:46:23.394 14506 14546 D MICROEXPERIMENT: Experiment 'static non-final, static init, parameter, else path' took 25502ms
10-31 10:46:24.149 14506 14546 D MICROEXPERIMENT: Experiment 'static final, property, first path' took 754ms
10-31 10:46:25.638 14506 14546 D MICROEXPERIMENT: Experiment 'static final, property, else path' took 1489ms
10-31 10:46:26.106 14506 14546 D MICROEXPERIMENT: Experiment 'static non-final, property, first path' took 468ms
10-31 10:46:27.672 14506 14546 D MICROEXPERIMENT: Experiment 'static non-final, property, else path' took 1565ms