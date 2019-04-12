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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    EditText etFirstName, etLastName, etStudentID;
    RadioButton rbSis, rbCs, rbBio,rbOthers, radioButton;
    RadioGroup rg;
    Button btSave;
    Student student;
    String fname, lname, dept, s_id;
    int deptId;

    ImageView imageView;
    public static int reqCode = 100;
    public static String value = "avatar";
    public static String avatarValue= "";
    static final String OBJECT_KEY="object";





    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == reqCode){
            if(resultCode == RESULT_OK){
                avatarValue = data.getExtras().getString(value);
                Log.d("demo", "avatarValue = " + avatarValue);
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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("My Profile");

        etFirstName = (EditText)findViewById(R.id.editeditText_firstName);
        etLastName =(EditText)findViewById(R.id.editText_lastName);
        etStudentID = (EditText)findViewById(R.id.editText_ID);
        rg = findViewById(R.id.radioGroup);

        rbSis=(RadioButton)findViewById(R.id.editRadioButton_SIS);
        rbCs=(RadioButton)findViewById(R.id.editRadioButton_CS);
        rbBio=(RadioButton)findViewById(R.id.editRadioButton_BIO);
        rbOthers=(RadioButton)findViewById(R.id.radioButton_Others);

        btSave=(Button)findViewById(R.id.saveButton);

        imageView = findViewById(R.id.editImageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SelectAvatarActivity.class);
                startActivityForResult(intent, reqCode);
            }
        });

        btSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int flag=0;
                fname=etFirstName.getText().toString();
                if(fname.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Name not entered", Toast.LENGTH_SHORT).show();
                    flag=1;
                }

                lname=etLastName.getText().toString();
                if(lname.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Name not entered", Toast.LENGTH_SHORT).show();
                    flag=1;
                }

                s_id = etStudentID.getText().toString();
                if(s_id.equals(""))
                {
                    Toast.makeText(MainActivity.this, "Not a valid entry", Toast.LENGTH_SHORT).show();
                    flag=1;
                }

//                if (rbSis.isChecked())
//                {
//                    dept="SIS";
//                }
//                else if (rbCs.isChecked())
//                {
//                    dept="CS";
//                }
//                else if(rbBio.isChecked())
//                {
//                    dept="BIO";
//                }
//                else
//                {
//                    dept="OTHERS";
//                }
                if(flag==0) {
                    deptId = rg.getCheckedRadioButtonId();
                    radioButton = findViewById(deptId);
                    dept = (String) radioButton.getText();
                    student = new Student(fname, lname, dept, s_id, avatarValue);
                    Intent intent = new Intent(MainActivity.this, DisplayActivity.class);
                    intent.putExtra(OBJECT_KEY, student);
                    startActivity(intent);
                }
            }
        });

     }
}
