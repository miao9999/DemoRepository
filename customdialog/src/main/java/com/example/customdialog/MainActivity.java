package com.example.customdialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = findViewById(R.id.tv);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CustomDialog.confirmClose(MainActivity.this, "deatil", "title", new CustomDialog.ClickListener() {
                    @Override
                    public void yesClick() {
                        Toast.makeText(MainActivity.this, "yes", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void noClick() {
                        Toast.makeText(MainActivity.this, "no", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
