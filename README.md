# MicroExperiment for Performance Evaluation

`./gradlew bundle`

## Before Running

### BundleTool

To extract `.apk` from `.aab` file, we used [bundletool](https://github.com/google/bundletool/). We just download the [version 1.15.1 jar file](https://github.com/google/bundletool/releases/download/1.15.5/bundletool-all-1.15.5.jar) and run it with some parameters detailed below.

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