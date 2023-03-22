package com.example.helloandroid;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //상단바 이미지 변경
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_launcher);

        //각종 이벤트 처리를 위한 객체 생성
        Button viewBtn = findViewById(R.id.Btn1);
        Button urlbBtn = findViewById(R.id.Btn2);
        EditText editText = findViewById(R.id.editText);
        RadioGroup radioGroup = findViewById(R.id.radiogGroup);
        RadioButton radioBtn1 = findViewById(R.id.radioBtn1);
        RadioButton radioBtn2 = findViewById(R.id.radioBtn2);
        ImageView imageView = findViewById(R.id.imageView);

        //RadioGroup 에 있는 RadioButton 두개 중 선택에 따른 imageView
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int choice) {
                switch (choice) {
                    case R.id.radioBtn1:
                        imageView.setImageResource(R.drawable.snow_corn);
                        break;
                    case R.id.radioBtn2:
                        imageView.setImageResource(R.drawable.tiramisu01);
                        break;
                }
            }
        });

        //EditText에 입력한 Toast 메세지 출력을 하기 위한 글자 나타내기 버튼 이벤트
        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editTextM = editText.getText().toString();
                Toast.makeText(MainActivity.this, editTextM, Toast.LENGTH_SHORT).show();
            }
        });

        //EditText에 입력한 url에 연결 해주는 홈페이지 열기 버튼에 대한 이벤트
        urlbBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String editTextM = editText.getText().toString();

                //EditText 부분에 http://, https:// 를 입력 하지 않아서 생기는 오류를 방지하기 위한 코드
                if (!editTextM.startsWith("http://") && !editTextM.startsWith("https://")) {
                    editTextM = "http://" + editTextM;
                }
                Intent mlntent = new Intent(Intent.ACTION_VIEW, Uri.parse(editTextM));
                startActivity(mlntent);
            }
        });
    }
}
