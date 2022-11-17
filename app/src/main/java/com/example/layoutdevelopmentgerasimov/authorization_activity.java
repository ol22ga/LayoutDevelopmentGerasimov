package com.example.layoutdevelopmentgerasimov;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

public class authorization_activity extends AppCompatActivity {


    EditText editText;
    EditText editText2;
    ImageView image;
    ImageButton imgButton;
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);
        editText = findViewById(R.id.etEmailPhone);
        image = findViewById(R.id.imageView3);
        editText2 = findViewById(R.id.password);
        imgButton = findViewById(R.id.imgButton);
        editText2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        editText.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus)
                editText.setHint("");
            else if (!hasFocus)
                editText.setHint("Enter Email / Phone Number");
        });
        editText2.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus)
                editText2.setHint("");
            else if (!hasFocus)
                editText2.setHint("Password");
        });


        imgButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // меняем изображение на кнопке
                if (flag)
                    imgButton.setImageResource(R.drawable.cb1);
                else
                    // возвращаем первую картинку
                    imgButton.setImageResource(R.drawable.cb);
                flag = !flag;
            }
        });


    }

    public void visiblePassword(View v) {
        if (editText2.getInputType() == 129) {
            image.setImageResource(R.drawable.eyeslash);
            editText2.setInputType(InputType.TYPE_CLASS_TEXT);
        } else {
            image.setImageResource(R.drawable.eyevisible);

            editText2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }

    public void goToRegistered(View v) {

        startActivity(new Intent(authorization_activity.this, registration.class));
    }

    public void showFacebook(View V){
        Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("http://facebook.com/"));
        startActivity(browser);
    }
    public void showGoogle(View V){
        Intent browser = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.ru/"));
        startActivity(browser);
    }

}
