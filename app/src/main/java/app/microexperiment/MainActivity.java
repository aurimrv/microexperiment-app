package app.microexperiment;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.Button;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends Activity {
    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final Handler mainHandler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnStartExperiment = findViewById(R.id.btnStartExperiment);
        btnStartExperiment.setOnClickListener(v -> {
            btnStartExperiment.setClickable(false);
            runExperiment();
            btnStartExperiment.setClickable(true);
        });
    }

    private void runExperiment() {
        executorService.execute(() -> {
            // Put the main() content of MicroExperimentMain here
            // Remember to replace System.out.println with Log.d(TAG, ...)
            MicroExperimentMain.main(new String[0]);

            mainHandler.post(() -> {
                // If you want to update the UI after the experiments, you can do it here
            });
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        executorService.shutdown();  // Shutdown the executor when the activity is destroyed
    }
}
