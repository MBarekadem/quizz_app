package essths.li3.mobile.c2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import essths.li3.mobile.R;
import essths.li3.mobile.c1.C1q2;

public class C2q1 extends AppCompatActivity {

    RadioButton r1,r2,r3,r4;
    Button btn;
    RadioGroup radioGroup;
    int score=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_c2q1);

        r1 = findViewById(R.id.option1);
        r2 = findViewById(R.id.option2);
        r3 = findViewById(R.id.option3);
        r4 = findViewById(R.id.option4);
        btn = findViewById(R.id.btnNext);
        radioGroup = findViewById(R.id.radioGroup);   // ✔️ OBLIGATOIRE

        RadioButton correctOption = r2;

        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {

            RadioButton selectedOption = findViewById(checkedId);

            if (selectedOption != null) {

                if (selectedOption.getId() == correctOption.getId()) {
                    selectedOption.setBackgroundResource(R.drawable.bg_radio_correct);
                    score++;
                } else {
                    selectedOption.setBackgroundResource(R.drawable.bg_radio_error);
                    correctOption.setBackgroundResource(R.drawable.bg_radio_correct);
                }
                dialed();
            }
        });

        btn.setOnClickListener(v -> {
            if (radioGroup.getCheckedRadioButtonId() == -1) {
                Toast.makeText(essths.li3.mobile.c2.C2q1.this, "Veuillez choisir une réponse", Toast.LENGTH_SHORT).show();
            } else {
                Intent i=new Intent(this, C2q2.class);
                i.putExtra("score", score);
                startActivity(i);
            }

        });
    }
    private void dialed(){
        r1.setEnabled(false);
        r2.setEnabled(false);
        r3.setEnabled(false);
        r4.setEnabled(false);
    }

}
