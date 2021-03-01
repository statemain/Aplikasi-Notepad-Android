package ei.eseptiyadi.notesapp.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ei.eseptiyadi.notesapp.R;
import ei.eseptiyadi.notesapp.views.WelcomeActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void registerNow(View view) {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));

    }
}