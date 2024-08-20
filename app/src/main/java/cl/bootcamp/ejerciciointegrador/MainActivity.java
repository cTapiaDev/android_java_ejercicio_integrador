package cl.bootcamp.ejerciciointegrador;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

import cl.bootcamp.ejerciciointegrador.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        Glide
                .with(this)
                .load("https://i.pinimg.com/564x/45/7e/23/457e23ba64ca4d2d0c3d7d35dda1a356.jpg")
                .into(binding.ivProfile);

        textDefault();
        goWsp();
        goEmail();

    }

    public void textDefault() {
        binding.tvPrincipal.setText(
                String.format(
                        "Soy %s, \nAhora pertenezco a %s",
                        getString(R.string.name),
                        getString(R.string.marvel)
                )
        );
    }

    public void goWsp() {
        binding.btnWsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uriUrl = Uri.parse("https://wa.me/56952271906");
                intent = new Intent(Intent.ACTION_VIEW, uriUrl);
                startActivity(intent);
            }
        });
    }

    public void goEmail() {
        binding.btnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent email = new Intent(Intent.ACTION_SEND);

                email.setType("text/plain");
                email.putExtra(Intent.EXTRA_SUBJECT, "Asunto de prueba");
                email.putExtra(Intent.EXTRA_TEXT, binding.etText.getText());
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"ctapiadev@gmail.com"});
                startActivity(email);
            }
        });
    }
}