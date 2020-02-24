package com.example.recovery;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Button button ;
    TextView textView;

    int CVersion ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        textView = (TextView)findViewById(R.id.textView);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CVersion = Build.VERSION.SDK_INT;

                switch (CVersion){
                    case 1:
                        textView.setText("Base:Not Supported");
                        break;

                    case 2:
                        textView.setText("Base:Not Supported");
                        break;

                    case 3:
                        textView.setText("Cupcake:Not Supported");
                        break;

                    case 4:
                        textView.setText("Donut:Not Supported");
                        break;

                    case 5:
                        textView.setText("Eclair:Not Supported");
                        break;

                    case 6:
                        textView.setText("Eclair:Not Supported");
                        break;

                    case 7:
                        textView.setText("Eclair:Not Supported");
                        break;

                    case 8:
                        textView.setText("Froyo:Not Supported");
                        break;

                    case 9:
                        textView.setText("Gingerbread:Not Supported");
                        break;

                    case 10:
                        textView.setText("Gingerbread:Not Supported");
                        break;

                    case 11:
                        textView.setText("Honeycomb:Not Supported");
                        break;

                    case 12:
                        textView.setText("Honeycomb:Not Supported");
                        break;

                    case 13:
                        textView.setText("Honeycomb:Not Supported");
                        break;

                    case 14:
                        textView.setText("Ice Cream Sandwich:Not Supported");
                        break;

                    case 15:
                        textView.setText("Ice Cream Sandwich:Not Supported");
                        break;

                    case 16:
                        textView.setText("Jelly Bean:Not Supported");
                        break;

                    case 17:
                        textView.setText("Jelly Bean:Not Supported");
                        break;

                    case 18:
                        textView.setText("Jelly Bean:Not Supported");
                        break;

                    case 19:
                        textView.setText("KitKat:Not Supported");
                        break;

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
                        textView.setText("Nougat:Nearing End");
                        break;

                    case 26:
                        textView.setText("Oreo:Nearing End");
                        break;

                    case 27:
                        textView.setText("Oreo: Nearing End");
                        break;

                    case 28:
                        textView.setText("Pie:Nearing End");
                        break;

                    case 29:
                        textView.setText("Android 10: Supported!");
                        break;

                        default:
                            Toast.makeText(MainActivity.this,"Not Found", Toast.LENGTH_LONG).show();
                            break;
                }
            }
        });
    }
}
