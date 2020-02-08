import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Build build;
    Build.VERSION version;
    String information;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

        saveInfo();
        textView.setText(information);
    }

    private void saveInfo() {
        information = "Brand: "+ build.BRAND+"\n"+
                "Product: "+ build.PRODUCT +"\n"+
                "Hardware: "+ build.HARDWARE +"\n"+
                "Device: "+ build.DEVICE +"\n"+
                "Manufacturer: "+ build.MANUFACTURER +"\n"+
                "Model: "+ build.MODEL +"\n"+
                "Security Patch: "+ version.SECURITY_PATCH +"\n"+
                "Release: "+ version.RELEASE +"\n"+
                "SDK: "+ version.SDK_INT +"\n";
    }
}
