package com.example.studentssql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Type;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public Button insertButton;
    public Button selectAllButton;

    public EditText textName;
    public EditText textSurname;
    public EditText textAge;
    public EditText textPESEL;
    public EditText textGender;
    public TextView textFromDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);

        insertButton = (Button)findViewById(R.id.insertButton);
        selectAllButton = (Button)findViewById(R.id.selectAllButton);

        textName = (EditText)findViewById(R.id.nameText);
        textSurname = (EditText)findViewById(R.id.surnameText);
        textAge = (EditText)findViewById(R.id.ageText);
        textPESEL = (EditText)findViewById(R.id.peselText);
        textGender = (EditText)findViewById(R.id.genderText);
        textFromDatabase = (TextView)findViewById(R.id.fromDatabaseText);

        textFromDatabase.setMovementMethod(new ScrollingMovementMethod());
    }


    public void loadStudents(View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        textFromDatabase.setText(dbHandler.loadHandler());

        textName.setText("");
        textSurname.setText("");
        textAge.setText("");
        textPESEL.setText("");
        textGender.setText("");
    }

    public void addStudent(View view) {
        Random rand = new Random();
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        String name = (!textName.getText().toString().equals("")) ? textName.getText().toString() : getRandomString(8);
        String surname = (!textSurname.getText().toString().equals("")) ? textSurname.getText().toString() : getRandomString(10);
        int age = (!textAge.getText().toString().equals("")) ? Integer.parseInt(textAge.getText().toString()) : (rand.nextInt(98) + 1);
        String pesel = (!textPESEL.getText().toString().equals("")) ? textPESEL.getText().toString() : getRandomPESEL();
        String gender = (!textGender.getText().toString().equals("")) ? textGender.getText().toString() : getRandomString(5);
        Student student = new Student(name, surname, age, pesel, gender);

        dbHandler.addHandler(student);

        textName.setText("");
        textSurname.setText("");
        textAge.setText("");
        textPESEL.setText("");
        textGender.setText("");

        Toast.makeText(this, "Inserted into Students", Toast.LENGTH_SHORT).show();
    }

    static String getRandomString(int n) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }

    static String getRandomPESEL() {
        String AlphaNumericString = "0123456789";
        StringBuilder sb = new StringBuilder(11);

        for (int i = 0; i < 11; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }
}
