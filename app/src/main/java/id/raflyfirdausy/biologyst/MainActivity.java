package id.raflyfirdausy.biologyst;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvJudul;
    private Button btnPlay;
    private Button btnLeaderBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvJudul = findViewById(R.id.tvJudul);
        btnPlay = findViewById(R.id.btnPlay);
        btnLeaderBoard = findViewById(R.id.btnLeaderBoard);

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, InGameActivity.class));
            }
        });

        btnLeaderBoard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LearderboardActivity.class));
            }
        });

        tvJudul.setTypeface(Typeface.createFromAsset(getAssets(), "font.otf"));
    }
}
