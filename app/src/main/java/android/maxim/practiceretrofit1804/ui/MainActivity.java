package android.maxim.practiceretrofit1804.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import android.maxim.practiceretrofit1804.app.App;
import android.maxim.practiceretrofit1804.databinding.ActivityMainBinding;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ((App) getApplication()).appComponent.injectActivity(this);

        mainActivityViewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);

        binding.btnShowName.setOnClickListener(v -> showUserName());
    }

    private void showUserName() {
        int idFromUI = Integer.parseInt(binding.etEnterId.getText().toString());
        mainActivityViewModel.getDataFromRepository(idFromUI);
        mainActivityViewModel.repository.getLiveData()
                .observe(this, userResponse -> {
                    binding.tvOutputName
                            .setText(userResponse.firstName + " " + userResponse.lastName);
                });
    }
}
