package essths.li3.mobile.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import essths.li3.mobile.c1.C1q1;
import essths.li3.mobile.c2.C2q1;
import essths.li3.mobile.c3.C3q1;
import essths.li3.mobile.c4.C4q1;
import essths.li3.mobile.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    Button culture, sport, div, tech;
    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Récupération des boutons
        culture = binding.button;
        sport = binding.button6;
        div = binding.button4;
        tech = binding.button3;

        // Action du bouton Culture
        culture.setOnClickListener(v -> {
            Intent i = new Intent(requireActivity(), C1q1.class);
            startActivity(i);
        });
        div.setOnClickListener(v -> {
            Intent i = new Intent(requireActivity(), C2q1.class);
            startActivity(i);
        });
        tech.setOnClickListener(v->{
            Intent i = new Intent(requireActivity(), C3q1.class);
            startActivity(i);
        });
        sport.setOnClickListener(v->{
            Intent i = new Intent(requireActivity(), C4q1.class);
            startActivity(i);
        });


        return root;
    }


}
