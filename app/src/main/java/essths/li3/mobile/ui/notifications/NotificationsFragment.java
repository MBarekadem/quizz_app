package essths.li3.mobile.ui.notifications;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import essths.li3.mobile.R;
import essths.li3.mobile.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        // Charger le layout du fragment
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        // Récupérer ViewModel
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        // Récupérer la TextView
        final TextView textView = root.findViewById(R.id.text_notifications);

        notificationsViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        // -------------------------------
        // 🔹 Bouton Appel
        // -------------------------------
        Button btnCall = root.findViewById(R.id.button_call);

        btnCall.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:5554"));
            startActivity(intent);
        });

        // -------------------------------
        // 🔹 Bouton SMS
        // -------------------------------
        Button btnSms = root.findViewById(R.id.button_msg);

        btnSms.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("sms:5554"));
            startActivity(intent);
        });

        return root;
    }
}
