package sg.edu.rp.c346.id20022543.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etTitle, etSingers, etYear;
    RadioGroup rgStars;
    Button btnInsert, btnShowList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etTitle = findViewById(R.id.editTitle);
        etSingers = findViewById(R.id.editSingers);
        etYear = findViewById(R.id.editYear);
        rgStars = findViewById(R.id.rgStars);
        btnInsert = findViewById(R.id.btnInsert);
        btnShowList = findViewById(R.id.btnShowList);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(MainActivity.this);

                String title = etTitle.getText().toString();
                String singers = etSingers.getText().toString();
                int year = Integer.parseInt(etYear.getText().toString());
                int selected = rgStars.getCheckedRadioButtonId();

                RadioButton radioButton = (RadioButton) findViewById(selected);
                int stars = Integer.parseInt(radioButton.getText().toString());

                dbh.insertSong(title,singers,year,stars);
                Toast.makeText(MainActivity.this, "Successfully inserted", Toast.LENGTH_LONG).show();

                etTitle.setText("");
                etSingers.setText("");
                etYear.setText("");
                rgStars.getCheckedRadioButtonId();


            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(i);
            }
        });

    }

}