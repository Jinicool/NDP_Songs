package sg.edu.rp.c346.id20022543.ndpsongs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    Button btnStar;
    ArrayList<Song> alSongs;
    ListView lv;
    ArrayAdapter<Song> aaSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnStar = findViewById(R.id.btnStars);
        lv = findViewById(R.id.lv);
        alSongs= new ArrayList<>();
        aaSongs = new ArrayAdapter<Song>(this,
                android.R.layout.simple_list_item_1, alSongs);
        lv.setAdapter(aaSongs);

        DBHelper dbh = new DBHelper(SecondActivity.this);
        alSongs.addAll(dbh.getAllSongs());
        aaSongs.notifyDataSetChanged();

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song data = alSongs.get(position);
                Intent i = new Intent(SecondActivity.this,ThirdActivity.class);
                i.putExtra("data",data);
                startActivity(i);
            }
        });

        btnStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper dbh = new DBHelper(SecondActivity.this);
                alSongs.clear();
                alSongs.addAll(dbh.getAllSongs());
                aaSongs.notifyDataSetChanged();
            }
        });
    }
}