import android.view.View;
import android.widget.Button;

import android.os.Bundle;

public class PartialProperties extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partial_properties);

       /*Button button1 = findViewById(R.id.button1);
         button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWelcomeActivity();
            }
        });

        */
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openContactRemover();
            }
        });
    }
    public void openContactRemover() {
        Intent removerIntent = new Intent(this, ContactRemover.class);
        startActivity(removerIntent);
    }

    public void openWelcomeActivity() {
        Intent homeIntent = new Intent(this, WelcomeActivity.class);
        startActivity(homeIntent);
    }
}
