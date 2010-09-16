package jp.co.cosmoroot.android.samples;

import android.app.Activity;
import android.os.Bundle;

public class RenderSpeedTest extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);
        setContentView(new CustomView(this));
    }
}