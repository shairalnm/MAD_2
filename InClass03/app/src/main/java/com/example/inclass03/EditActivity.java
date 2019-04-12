package com.example.inclass03;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    Student student;
    EditText etFirstName, etLastName, etStudentID;
    RadioButton rbSis, rbCs, rbBio,rbOthers, radioButton;
    RadioGroup rg;
    Button save;
    int deptId;
    ImageView imageView;

    public static int reqCode = 100;
    public static String value = "avatar";
    public static String avatarValue= "";

    static final String OBJECT_KEY="object";

    String firstString, lastString, studentIdString, deptString, avatarString;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        setTitle("My Profile");

        etFirstName = (EditText)findViewById(R.id.editeditText_firstName);
        etLastName =(EditText)findViewById(R.id.editeditText_lastName);
        etStudentID = (EditText)findViewById(R.id.editeditText_ID);
        rg = findViewById(R.id.editRadioGroup);
        imageView = findViewById(R.id.editImageView);

        rbSis=(RadioButton)findViewById(R.id.editRadioButton_SIS);
        rbCs=(RadioButton)findViewById(R.id.editRadioButton_CS);
        rbBio=(RadioButton)findViewById(R.id.editRadioButton_BIO);
        rbOthers=(RadioButton)findViewById(R.id.editRadioButton_Others);

        save=(Button)findViewById(R.id.editSaveButtonEditAct);

        if(getIntent() != null && getIntent().getExtras() != null){
            student = (Student) getIntent().getExtras().getSerializable(MainActivity.OBJECT_KEY);
            Log.d("demo", "Edit, student = " + student.toString());

            firstString = student.getFname();
            lastString = student.getLname();
            studentIdString = student.getS_id();
            deptString = student.getDept();
            avatarString = student.getAvatar();

            etFirstName.setText(firstString);
            etLastName.setText(lastString);
            etStudentID.setText(studentIdString);
            if(deptString.matches("CS")){
                rg.check(R.id.editRadioButton_CS);
            }
            else if(deptString.matches("SIS")){
                rg.check(R.id.editRadioButton_SIS);
            }
            else if(deptString.matches("BIO")){
                rg.check(R.id.editRadioButton_BIO);
            }
            else if(deptString.matches("Other")){
                rg.check(R.id.editRadioButton_Others);
            }

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

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(EditActivity.this, SelectAvatarActivity.class);
                    startActivityForResult(intent, reqCode);
                }
            });

            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    student.setFname(etFirstName.getText().toString());
                    student.setLname(etLastName.getText().toString());
                    student.setS_id(etStudentID.getText().toString());

                    deptId = rg.getCheckedRadioButtonId();
                    radioButton = findViewById(deptId);


                    student.setDept(radioButton.getText().toString());
                    Intent intent = new Intent(EditActivity.this, DisplayActivity.class);
                    intent.putExtra(OBJECT_KEY, student);
                    startActivity(intent);
                }
            });


        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == reqCode){
            if(resultCode == RESULT_OK){
                avatarValue = data.getExtras().getString(value);
                Log.d("demo", "avatarValue = " + avatarValue);
                student.setAvatar(avatarValue);
                if(avatarValue.matches("m1")){
                    imageView.setImageResource(R.drawable.avatar_m_1);
                }
                else if(avatarValue.matches("m2")){
                    imageView.setImageResource(R.drawable.avatar_m_2);
                }
                else if(avatarValue.matches("m3")){
                    imageView.setImageResource(R.drawable.avatar_m_3);
                }
                else if(avatarValue.matches("f1")){
                    imageView.setImageResource(R.drawable.avatar_f_1);
                }
                else if(avatarValue.matches("f2")){
                    imageView.setImageResource(R.drawable.avatar_f_2);
                }
                else if(avatarValue.matches("f3")){
                    imageView.setImageResource(R.drawable.avatar_f_3);
                }
                else{
                    imageView.setImageResource(R.drawable.select_image);
                }
            }
        }
    }
}
