package app.microexperiment;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MicroExperimentMain {

    private final static boolean IS_ANDROID = true;

    private static int REPETITIONS = 10_000_000;

    private static final String STATIC_FINAL_STATIC_INIT = "ae7f9682-6bd8-45e8-a3da-4020ccc153fa";

    private static String STATIC_NON_FINAL_STATIC_INIT = "ae7f9682-6bd8-45e8-a3da-4020ccc153fa";

    private static String STATIC_NON_FINAL_STATIC_PARAMETER = MutantID.getMUID();

    private static final String STATIC_FINAL_WITH_PROP = getProp();

    private static String STATIC_NON_FINAL_WITH_PROP = getProp();

    private static String getProp() {
        if (IS_ANDROID) {
            String propertyValue = null;
            try {
                java.lang.Process process = Runtime.getRuntime().exec("getprop debug.MUID");
                InputStream inputStream = process.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                propertyValue = reader.readLine();
                reader.close();
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            Log.d("MICROEXPERIMENT", "debud.MUID Value '" + propertyValue);
            return propertyValue;
        } else {
            return System.getProperty("debug.MUID");
        }
    }

    private static void setProp() {
        if (IS_ANDROID) {
            try {
                Process process = Runtime.getRuntime().exec("setprop debug.MUID ae7f9682-6bd8-45e8-a3da-4020ccc153fa");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            // Setup property
            System.setProperty("debug.MUID", "ae7f9682-6bd8-45e8-a3da-4020ccc153fa");
        }
    }

    public static void main(String[] args) {

        //setProp(); // property set by adb shell

        MicroExperimentMain.testHarness("static final, static init, first path", () -> staticFinalWithStaticInitFirstPath());
        MicroExperimentMain.testHarness("static final, static init, else path", () -> staticFinalWithStaticInitElsePath());
        MicroExperimentMain.testHarness("static non-final, static init, first path", () -> staticNonFinalWithStaticInitFirstPath());
        MicroExperimentMain.testHarness("static non-final, static init, else path", () -> staticNonFinalWithStaticInitElsePath());
        MicroExperimentMain.testHarness("static non-final, static init, parameter, first path", () -> staticNonFinalWithStaticParameterFirstPath());
        MicroExperimentMain.testHarness("static non-final, static init, parameter, else path", () -> staticNonFinalWithStaticParameterElsePath());
        MicroExperimentMain.testHarness("static final, property, first path", () -> staticFinalWithPropFirstPath());
        MicroExperimentMain.testHarness("static final, property, else path", () -> staticFinalWithPropElsePath());
        MicroExperimentMain.testHarness("static non-final, property, first path", () -> staticNonFinalWithPropFirstPath());
        MicroExperimentMain.testHarness("static non-final, property, else path", () -> staticNonFinalWithPropElsePath());
        MicroExperimentMain.testHarness("static non-final, parameter, switch", () -> staticNonFinalWithStaticParameterSwitchDefault());
        MicroExperimentMain.testHarness("static non-final, property, switch", () -> staticNonFinalWithPropSwitchDefault());
    }

    public static long testHarness(String name, Runnable experiment) {
        long start = System.nanoTime();
        for (int i = 0; i < REPETITIONS; i++) {
            experiment.run();
        }
        long stop = System.nanoTime();
        long duration = stop - start;

        //Replace System.out.println to Log.d
        Log.d("MICROEXPERIMENT", "Experiment '" + name + "' took " + (duration) / 1_000_000 + "ms");

        return duration;
    }

    public static long staticFinalWithStaticInitFirstPath() {

        long count = 0;
        if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-0".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-1".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-2".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-3".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-4".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-5".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-6".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-7".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-8".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-9".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-10".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-11".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-12".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-13".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-14".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-15".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-16".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-17".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-18".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-19".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-20".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-21".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-22".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-23".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-24".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-25".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-26".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-27".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-28".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-29".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-30".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-31".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-32".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-33".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-34".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-35".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-36".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-37".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-38".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-39".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-40".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-41".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-42".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-43".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-44".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-45".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-46".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-47".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-48".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-49".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-50".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-51".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-52".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-53".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-54".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-55".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-56".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-57".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-58".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-59".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-60".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-61".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-62".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-63".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-64".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-65".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-66".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-67".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-68".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-69".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-70".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-71".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-72".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-73".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-74".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-75".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-76".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-77".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-78".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-79".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-80".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-81".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-82".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-83".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-84".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-85".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-86".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-87".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-88".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-89".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-90".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-91".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-92".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-93".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-94".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-95".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-96".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-97".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-98".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-99".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else {
            count += 1;
        }

        return count;
    }

    public static long staticFinalWithStaticInitElsePath() {
        long count = 0l;

        if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-dummy".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-0".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-1".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-2".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-3".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-4".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-5".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-6".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-7".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-8".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-9".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-10".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-11".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-12".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-13".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-14".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-15".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-16".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-17".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-18".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-19".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-20".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-21".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-22".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-23".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-24".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-25".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-26".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-27".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-28".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-29".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-30".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-31".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-32".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-33".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-34".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-35".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-36".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-37".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-38".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-39".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-40".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-41".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-42".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-43".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-44".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-45".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-46".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-47".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-48".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-49".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-50".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-51".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-52".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-53".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-54".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-55".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-56".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-57".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-58".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-59".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-60".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-61".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-62".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-63".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-64".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-65".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-66".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-67".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-68".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-69".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-70".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-71".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-72".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-73".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-74".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-75".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-76".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-77".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-78".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-79".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-80".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-81".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-82".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-83".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-84".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-85".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-86".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-87".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-88".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-89".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-90".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-91".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-92".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-93".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-94".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-95".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-96".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-97".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-98".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-99".equals(STATIC_FINAL_STATIC_INIT)) {
            count -= 1;
        } else {
            count += 1;
        }

        return count;
    }

    public static long staticNonFinalWithStaticInitFirstPath() {

        long count = 0;
        if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-0".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-1".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-2".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-3".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-4".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-5".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-6".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-7".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-8".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-9".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-10".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-11".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-12".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-13".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-14".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-15".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-16".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-17".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-18".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-19".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-20".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-21".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-22".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-23".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-24".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-25".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-26".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-27".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-28".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-29".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-30".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-31".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-32".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-33".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-34".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-35".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-36".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-37".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-38".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-39".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-40".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-41".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-42".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-43".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-44".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-45".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-46".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-47".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-48".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-49".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-50".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-51".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-52".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-53".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-54".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-55".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-56".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-57".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-58".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-59".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-60".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-61".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-62".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-63".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-64".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-65".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-66".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-67".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-68".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-69".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-70".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-71".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-72".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-73".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-74".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-75".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-76".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-77".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-78".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-79".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-80".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-81".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-82".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-83".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-84".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-85".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-86".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-87".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-88".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-89".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-90".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-91".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-92".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-93".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-94".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-95".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-96".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-97".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-98".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-99".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else {
            count += 1;
        }

        return count;
    }

    public static long staticNonFinalWithStaticInitElsePath() {
        long count = 0l;

        if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-dummy".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-0".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-1".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-2".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-3".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-4".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-5".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-6".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-7".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-8".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-9".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-10".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-11".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-12".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-13".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-14".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-15".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-16".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-17".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-18".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-19".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-20".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-21".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-22".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-23".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-24".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-25".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-26".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-27".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-28".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-29".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-30".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-31".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-32".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-33".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-34".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-35".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-36".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-37".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-38".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-39".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-40".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-41".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-42".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-43".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-44".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-45".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-46".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-47".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-48".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-49".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-50".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-51".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-52".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-53".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-54".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-55".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-56".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-57".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-58".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-59".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-60".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-61".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-62".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-63".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-64".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-65".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-66".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-67".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-68".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-69".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-70".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-71".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-72".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-73".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-74".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-75".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-76".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-77".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-78".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-79".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-80".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-81".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-82".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-83".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-84".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-85".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-86".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-87".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-88".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-89".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-90".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-91".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-92".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-93".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-94".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-95".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-96".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-97".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-98".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-99".equals(STATIC_NON_FINAL_STATIC_INIT)) {
            count -= 1;
        } else {
            count += 1;
        }

        return count;
    }

    public static long staticFinalWithPropFirstPath() {

        long count = 0;
        if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-0".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-1".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-2".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-3".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-4".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-5".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-6".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-7".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-8".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-9".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-10".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-11".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-12".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-13".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-14".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-15".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-16".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-17".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-18".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-19".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-20".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-21".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-22".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-23".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-24".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-25".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-26".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-27".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-28".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-29".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-30".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-31".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-32".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-33".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-34".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-35".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-36".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-37".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-38".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-39".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-40".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-41".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-42".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-43".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-44".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-45".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-46".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-47".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-48".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-49".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-50".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-51".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-52".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-53".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-54".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-55".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-56".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-57".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-58".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-59".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-60".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-61".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-62".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-63".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-64".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-65".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-66".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-67".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-68".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-69".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-70".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-71".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-72".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-73".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-74".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-75".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-76".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-77".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-78".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-79".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-80".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-81".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-82".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-83".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-84".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-85".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-86".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-87".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-88".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-89".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-90".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-91".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-92".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-93".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-94".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-95".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-96".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-97".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-98".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-99".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else {
            count += 1;
        }

        return count;
    }

    public static long staticFinalWithPropElsePath() {
        long count = 0l;

        if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-dummy".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-0".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-1".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-2".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-3".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-4".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-5".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-6".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-7".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-8".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-9".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-10".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-11".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-12".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-13".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-14".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-15".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-16".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-17".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-18".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-19".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-20".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-21".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-22".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-23".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-24".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-25".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-26".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-27".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-28".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-29".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-30".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-31".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-32".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-33".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-34".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-35".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-36".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-37".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-38".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-39".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-40".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-41".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-42".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-43".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-44".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-45".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-46".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-47".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-48".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-49".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-50".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-51".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-52".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-53".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-54".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-55".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-56".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-57".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-58".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-59".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-60".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-61".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-62".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-63".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-64".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-65".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-66".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-67".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-68".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-69".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-70".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-71".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-72".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-73".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-74".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-75".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-76".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-77".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-78".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-79".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-80".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-81".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-82".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-83".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-84".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-85".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-86".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-87".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-88".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-89".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-90".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-91".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-92".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-93".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-94".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-95".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-96".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-97".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-98".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-99".equals(STATIC_FINAL_WITH_PROP)) {
            count -= 1;
        } else {
            count += 1;
        }

        return count;
    }

    public static long staticNonFinalWithPropFirstPath() {

        long count = 0;
        if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-0".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-1".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-2".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-3".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-4".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-5".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-6".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-7".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-8".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-9".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-10".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-11".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-12".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-13".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-14".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-15".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-16".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-17".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-18".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-19".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-20".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-21".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-22".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-23".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-24".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-25".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-26".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-27".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-28".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-29".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-30".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-31".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-32".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-33".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-34".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-35".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-36".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-37".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-38".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-39".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-40".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-41".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-42".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-43".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-44".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-45".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-46".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-47".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-48".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-49".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-50".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-51".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-52".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-53".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-54".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-55".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-56".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-57".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-58".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-59".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-60".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-61".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-62".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-63".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-64".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-65".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-66".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-67".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-68".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-69".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-70".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-71".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-72".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-73".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-74".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-75".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-76".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-77".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-78".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-79".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-80".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-81".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-82".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-83".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-84".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-85".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-86".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-87".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-88".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-89".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-90".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-91".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-92".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-93".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-94".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-95".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-96".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-97".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-98".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-99".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else {
            count += 1;
        }

        return count;
    }

    public static long staticNonFinalWithPropElsePath() {
        long count = 0l;

        if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-dummy".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-0".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-1".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-2".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-3".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-4".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-5".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-6".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-7".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-8".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-9".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-10".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-11".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-12".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-13".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-14".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-15".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-16".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-17".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-18".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-19".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-20".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-21".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-22".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-23".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-24".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-25".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-26".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-27".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-28".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-29".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-30".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-31".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-32".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-33".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-34".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-35".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-36".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-37".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-38".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-39".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-40".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-41".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-42".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-43".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-44".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-45".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-46".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-47".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-48".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-49".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-50".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-51".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-52".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-53".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-54".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-55".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-56".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-57".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-58".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-59".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-60".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-61".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-62".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-63".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-64".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-65".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-66".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-67".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-68".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-69".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-70".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-71".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-72".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-73".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-74".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-75".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-76".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-77".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-78".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-79".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-80".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-81".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-82".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-83".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-84".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-85".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-86".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-87".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-88".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-89".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-90".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-91".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-92".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-93".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-94".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-95".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-96".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-97".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-98".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-99".equals(STATIC_NON_FINAL_WITH_PROP)) {
            count -= 1;
        } else {
            count += 1;
        }

        return count;
    }

    public static long staticNonFinalWithStaticParameterFirstPath() {

        long count = 0;
        if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-0".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-1".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-2".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-3".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-4".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-5".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-6".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-7".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-8".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-9".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-10".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-11".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-12".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-13".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-14".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-15".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-16".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-17".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-18".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-19".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-20".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-21".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-22".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-23".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-24".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-25".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-26".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-27".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-28".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-29".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-30".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-31".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-32".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-33".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-34".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-35".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-36".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-37".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-38".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-39".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-40".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-41".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-42".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-43".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-44".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-45".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-46".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-47".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-48".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-49".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-50".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-51".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-52".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-53".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-54".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-55".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-56".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-57".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-58".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-59".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-60".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-61".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-62".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-63".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-64".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-65".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-66".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-67".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-68".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-69".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-70".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-71".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-72".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-73".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-74".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-75".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-76".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-77".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-78".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-79".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-80".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-81".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-82".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-83".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-84".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-85".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-86".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-87".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-88".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-89".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-90".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-91".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-92".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-93".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-94".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-95".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-96".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-97".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-98".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-99".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else {
            count += 1;
        }

        return count;
    }

    public static long staticNonFinalWithStaticParameterElsePath() {

        long count = 0;
        if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-dummy".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-0".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-1".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-2".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-3".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-4".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-5".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-6".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-7".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-8".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-9".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-10".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-11".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-12".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-13".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-14".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-15".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-16".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-17".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-18".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-19".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-20".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-21".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-22".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-23".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-24".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-25".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-26".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-27".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-28".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-29".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-30".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-31".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-32".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-33".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-34".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-35".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-36".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-37".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-38".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-39".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-40".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-41".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-42".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-43".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-44".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-45".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-46".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-47".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-48".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-49".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-50".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-51".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-52".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-53".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-54".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-55".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-56".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-57".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-58".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-59".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-60".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-61".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-62".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-63".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-64".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-65".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-66".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-67".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-68".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-69".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-70".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-71".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-72".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-73".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-74".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-75".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-76".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-77".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-78".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-79".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-80".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-81".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-82".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-83".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-84".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-85".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-86".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-87".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-88".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-89".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-90".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-91".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-92".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-93".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-94".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-95".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-96".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-97".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-98".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else if ("ae7f9682-6bd8-45e8-a3da-4020ccc153fa-99".equals(STATIC_NON_FINAL_STATIC_PARAMETER)) {
            count -= 1;
        } else {
            count += 1;
        }

        return count;
    }

    public static long staticNonFinalWithStaticParameterSwitchDefault() {

        long count = 0;
        switch (STATIC_NON_FINAL_STATIC_PARAMETER) {
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-dummy":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-0":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-1":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-2":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-3":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-4":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-5":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-6":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-7":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-8":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-9":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-10":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-11":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-12":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-13":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-14":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-15":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-16":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-17":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-18":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-19":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-20":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-21":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-22":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-23":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-24":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-25":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-26":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-27":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-28":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-29":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-30":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-31":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-32":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-33":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-34":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-35":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-36":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-37":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-38":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-39":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-40":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-41":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-42":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-43":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-44":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-45":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-46":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-47":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-48":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-49":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-50":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-51":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-52":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-53":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-54":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-55":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-56":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-57":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-58":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-59":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-60":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-61":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-62":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-63":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-64":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-65":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-66":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-67":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-68":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-69":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-70":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-71":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-72":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-73":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-74":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-75":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-76":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-77":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-78":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-79":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-80":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-81":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-82":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-83":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-84":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-85":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-86":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-87":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-88":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-89":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-90":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-91":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-92":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-93":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-94":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-95":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-96":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-97":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-98":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-99":
                count -= 1;
                break;
            default:
                count += 1;
                break;
        }
        return count;
    }

    public static long staticNonFinalWithPropSwitchDefault() {

        long count = 0;
        switch (STATIC_NON_FINAL_WITH_PROP) {
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-dummy":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-0":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-1":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-2":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-3":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-4":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-5":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-6":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-7":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-8":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-9":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-10":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-11":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-12":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-13":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-14":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-15":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-16":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-17":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-18":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-19":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-20":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-21":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-22":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-23":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-24":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-25":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-26":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-27":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-28":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-29":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-30":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-31":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-32":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-33":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-34":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-35":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-36":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-37":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-38":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-39":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-40":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-41":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-42":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-43":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-44":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-45":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-46":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-47":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-48":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-49":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-50":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-51":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-52":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-53":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-54":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-55":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-56":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-57":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-58":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-59":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-60":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-61":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-62":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-63":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-64":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-65":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-66":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-67":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-68":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-69":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-70":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-71":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-72":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-73":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-74":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-75":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-76":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-77":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-78":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-79":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-80":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-81":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-82":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-83":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-84":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-85":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-86":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-87":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-88":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-89":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-90":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-91":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-92":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-93":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-94":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-95":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-96":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-97":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-98":
                count -= 1;
                break;
            case "ae7f9682-6bd8-45e8-a3da-4020ccc153fa-99":
                count -= 1;
                break;
            default:
                count += 1;
                break;
        }
        return count;
    }
}