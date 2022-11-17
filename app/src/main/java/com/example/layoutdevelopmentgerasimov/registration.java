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

public class registration extends AppCompatActivity {
    EditText fullname;
    EditText etEmailPhone;
    EditText password;
    EditText confirmpassword;
    ImageView image;
    ImageView imageView3;
    ImageButton imgButton;
    boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        fullname = findViewById(R.id.fullname);
        etEmailPhone = findViewById(R.id.etEmailPhone);
        password = findViewById(R.id.password);
        confirmpassword = findViewById(R.id.confirmpassword);
        image = findViewById(R.id.imageView3);
        imageView3 = findViewById(R.id.imageView4);
        imgButton = findViewById(R.id.imgButton);
        password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        confirmpassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        fullname.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus)
                fullname.setHint("");
            else if (!hasFocus)
                fullname.setHint("Full Name");
        });

        etEmailPhone.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus)
                etEmailPhone.setHint("");
            else if (!hasFocus)
                etEmailPhone.setHint("Enter Email / Phone Number");
        });

        password.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus)
                password.setHint("");
            else if (!hasFocus)
                password.setHint("Password");
        });

        confirmpassword.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus)
                confirmpassword.setHint("");
            else if (!hasFocus)
                confirmpassword.setHint("Confirm Password");
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
    public void visiblePassword(View v)
    {
        if(password.getInputType() == 129)
        {
            image.setImageResource(R.drawable.eyeslash);
            password.setInputType(InputType.TYPE_CLASS_TEXT);
        }
        else
        {
            image.setImageResource(R.drawable.eyevisible);

            password.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }
    public void confirmPasword(View v)
    {
        if(confirmpassword.getInputType() == 129)
        {
            imageView3.setImageResource(R.drawable.eyeslash);
            confirmpassword.setInputType(InputType.TYPE_CLASS_TEXT);
        }
        else
        {
            imageView3.setImageResource(R.drawable.eyevisible);

            confirmpassword.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        }
    }
    public void goBack(View v){

        startActivity(new Intent(registration.this, authorization_activity.class));
    }
    public void goCreate(View v){

        startActivity(new Intent(registration.this, successfulRegistration.class));
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