package essths.li3.mobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class StartActivity extends AppCompatActivity {
    Button btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_start);

        btn_start = findViewById(R.id.btnStart);

        btn_start.setOnClickListener(v -> {
            Intent x = new Intent(StartActivity.this, MainActivity.class);
            startActivity(x);
        });
    }
}
