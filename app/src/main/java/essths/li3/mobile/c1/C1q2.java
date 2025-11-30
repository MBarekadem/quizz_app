package essths.li3.mobile.c1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import essths.li3.mobile.R;

public class C1q2 extends AppCompatActivity {

    RadioButton r1, r2, r3, r4;
    Button btn;
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_c1q2);

        r1 = findViewById(R.id.option1);
        r2 = findViewById(R.id.option2);
        r3 = findViewById(R.id.option3);
        r4 = findViewById(R.id.option4);
        btn = findViewById(R.id.btnNext);
        radioGroup = findViewById(R.id.radioGroup);

        // score doit être stocké dans un tableau pour pouvoir être modifié dans un listener
        Intent intent = getIntent();
        int r = intent.getIntExtra("score",0);


// On met score dans un tableau pour pouvoir le modifier dans le listener
        final int[] score = { r };

        RadioButton correctOption = r2;

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            RadioButton selectedOption = findViewById(checkedId);

            if (selectedOption != null) {

                if (selectedOption.getId() == correctOption.getId()) {
                    selectedOption.setBackgroundResource(R.drawable.bg_radio_correct);

                    score[0] = r + 1;   // 👍 maintenant ça compile
                } else {
                    selectedOption.setBackgroundResource(R.drawable.bg_radio_error);
                    correctOption.setBackgroundResource(R.drawable.bg_radio_correct);
                }

                disableOptions();
            }
        });

        btn.setOnClickListener(v -> {
            if (radioGroup.getCheckedRadioButtonId() == -1) {
                Toast.makeText(this, "Veuillez choisir une réponse", Toast.LENGTH_SHORT).show();
            } else {
                // score[0] contient le score mis à jour
                Intent i = new Intent(this, C1q3.class);
                i.putExtra("score", score[0]);

                startActivity(i);
            }
        });
    }

    private void disableOptions() {
        r1.setEnabled(false);
        r2.setEnabled(false);
        r3.setEnabled(false);
        r4.setEnabled(false);
    }
}
