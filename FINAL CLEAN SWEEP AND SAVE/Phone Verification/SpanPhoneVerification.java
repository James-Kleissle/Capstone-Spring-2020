package com.example.cleansweepsave;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SpanPhoneVerification extends AppCompatActivity {
Button button;
TextView textView;
int CVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_span_phone_verification);

        button = (Button)findViewById(R.id.button);
        textView=(TextView)findViewById(R.id.textView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CVersion = Build.VERSION.SDK_INT;

                switch (CVersion){
                    case 21:
                        textView.setText("Lollipop:Not Supported");
                        break;

                    case 22:
                        textView.setText("Lollipop:Not Supported");
                        break;

                    case 23:
                        textView.setText("Marshmallow:Not Supported");
                        break;

                    case 24:
                        textView.setText("Nougat:Not Supported");
                        break;

                    case 25:
                        textView.setText("Su sistema operativo es Nougat (25). Este sistema operativo está llegando al final del soporte, lo que significa que pronto ya no recibirá actualizaciones. Esto se puede transmitir pero no se recomienda");
                        break;

                }

            }
        });
    }
}
