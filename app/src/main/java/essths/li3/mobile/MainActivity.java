package essths.li3.mobile;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import essths.li3.mobile.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // ---------------------------------------------------------
        // Configuration AppBar (facultatif)
        // ---------------------------------------------------------
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home,
                R.id.navigation_dashboard,
                R.id.navigation_notifications
        ).build();

        NavController navController = Navigation.findNavController(
                this,
                R.id.nav_host_fragment_activity_main
        );

        // ---------------------------------------------------------
        // 🔥 1) RÉCUPÈRE TOUS LES SCORES ENVOYÉS PAR LES QUIZ
        // ---------------------------------------------------------
        Intent intent = getIntent();

        int scoreC = intent.getIntExtra("score_c", -1); // Culture
        int scoreD = intent.getIntExtra("score_d", -1); // Divers
        int scoreT = intent.getIntExtra("score_t", -1); // Techno
        int scoreS = intent.getIntExtra("score_s", -1); // Sport

        // ---------------------------------------------------------
        // 🔥 2) STOCKER UNIQUEMENT LES SCORES QUI ONT ÉTÉ ENVOYÉS
        // ---------------------------------------------------------
        if (scoreC != -1) {
            getSharedPreferences("scores", MODE_PRIVATE)
                    .edit()
                    .putInt("score_culture", scoreC)
                    .apply();
        }

        if (scoreD != -1) {
            getSharedPreferences("scores", MODE_PRIVATE)
                    .edit()
                    .putInt("score_divers", scoreD)
                    .apply();
        }

        if (scoreT != -1) {
            getSharedPreferences("scores", MODE_PRIVATE)
                    .edit()
                    .putInt("score_techno", scoreT)
                    .apply();
        }

        if (scoreS != -1) {
            getSharedPreferences("scores", MODE_PRIVATE)
                    .edit()
                    .putInt("score_sport", scoreS)
                    .apply();
        }

        // ---------------------------------------------------------
        // 🔥 3) Navigation Bottom Bar
        // ---------------------------------------------------------
        NavigationUI.setupWithNavController(binding.navView, navController);
    }
}
