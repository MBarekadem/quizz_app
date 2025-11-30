package essths.li3.mobile.ui.dashboard;

import static android.content.Context.MODE_PRIVATE;
import static android.widget.Toast.LENGTH_LONG;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import essths.li3.mobile.MainActivity;
import essths.li3.mobile.StartActivity;
import essths.li3.mobile.databinding.FragmentDashboardBinding;
public class DashboardFragment extends Fragment {
TextView t1,t2,t3,t4,tf,tn;
Button r;
    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.titleStats;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        int scoreCulture = requireActivity()
                .getSharedPreferences("scores", MODE_PRIVATE)
                .getInt("score_culture", 0);

        int scoreDivers = requireActivity()
                .getSharedPreferences("scores", MODE_PRIVATE)
                .getInt("score_divers", 0);

        int scoreTechno = requireActivity()
                .getSharedPreferences("scores", MODE_PRIVATE)
                .getInt("score_techno", 0);


        int scoreSport = requireActivity()
                .getSharedPreferences("scores", MODE_PRIVATE)
                .getInt("score_sport", 0);


        t1=binding.textView3;
        t2=binding.textView4;
        t3=binding.textView6;
        t4=binding.textView5;
        tf=binding.textView14;
        tn=binding.textView15;
        r=binding.rest;
        t1.setText((scoreCulture * 100 / 5) + "%");
        t2.setText((scoreSport*100/5)+"%");
        t3.setText((scoreDivers*100/5)+"%");
        t4.setText((scoreTechno*100/5)+"%");

        double m = ((scoreCulture + scoreDivers + scoreTechno + scoreSport) / 20.0) * 100;

            tf.setText(m+"%");
            if (m >= 70) {
                tn.setText("Professeur 😎");

            } else if (m >= 50) {
                tn.setText("Bravo 👏");

            } else if (m >= 30) {
                tn.setText("Passable 🙂");

            } else {
                tn.setText("À améliorer 😢");
            }
            r.setOnClickListener(v->{
                requireActivity()
                        .getSharedPreferences("scores", MODE_PRIVATE)
                        .edit()
                        .clear()
                        .apply();

                // 2️⃣ Remettre les TextView à 0%
                t1.setText("0%");
                t2.setText("0%");
                t3.setText("0%");
                t4.setText("0%");
                tf.setText("0%");
                tn.setText("A améliorer 😢");
                Intent i=new Intent(requireActivity(), MainActivity.class);
                startActivity(i);

                // 3️⃣ Message confirmation
                Toast.makeText(requireContext(), "Scores réinitialisés !", Toast.LENGTH_SHORT).show();
            });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}