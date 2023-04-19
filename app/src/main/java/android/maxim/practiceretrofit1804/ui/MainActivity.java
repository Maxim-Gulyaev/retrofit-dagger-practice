package android.maxim.practiceretrofit1804.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.maxim.practiceretrofit1804.databinding.ActivityMainBinding;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        binding.btnShowName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDataFromViewModel();
            }
         });
    }

    private String getIdFromUI() {
        return binding.etEnterId.getText().toString();
    }

    private void getDataFromViewModel() {
        mainActivityViewModel.getDataFromRepository(getIdFromUI());
    }

}
