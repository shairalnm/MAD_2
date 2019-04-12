package com.example.inclass03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    Student student;
    TextView name, studentId, dept;
    ImageView imageView;
    String nameString, studentIdString, deptString, avatarString;
    Button editBtn;
    static final String OBJECT_KEY="object";

    public static int reqCode = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        setTitle("Display Activity");

        name = findViewById(R.id.textViewNameValue);
        studentId = findViewById(R.id.textViewStudentIdValue);
        dept = findViewById(R.id.textViewDepartmentValue);
        imageView = findViewById(R.id.imageView2);
        editBtn = findViewById(R.id.buttonEdit);

        if(getIntent() != null && getIntent().getExtras() != null){
            student = (Student) getIntent().getExtras().getSerializable(MainActivity.OBJECT_KEY);
            Log.d("demo", "student = " + student.toString());

            nameString = student.getFullName();
            studentIdString = student.getS_id();
            deptString = student.getDept();
            avatarString = student.getAvatar();


            name.setText(nameString);
            studentId.setText(studentIdString);
            dept.setText(deptString);
            if(avatarString.matches("m1")){
                imageView.setImageResource(R.drawable.avatar_m_1);
            }
            else if(avatarString.matches("m2")){
                imageView.setImageResource(R.drawable.avatar_m_2);
            }
            else if(avatarString.matches("m3")){
                imageView.setImageResource(R.drawable.avatar_m_3);
            }
            else if(avatarString.matches("f1")){
                imageView.setImageResource(R.drawable.avatar_f_1);
            }
            else if(avatarString.matches("f2")){
                imageView.setImageResource(R.drawable.avatar_f_2);
            }
            else if(avatarString.matches("f3")){
                imageView.setImageResource(R.drawable.avatar_f_3);
            }



            editBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(DisplayActivity.this, EditActivity.class);
                    intent.putExtra(OBJECT_KEY, student);
                    startActivity(intent);
                }
            });




        }


    }
}
