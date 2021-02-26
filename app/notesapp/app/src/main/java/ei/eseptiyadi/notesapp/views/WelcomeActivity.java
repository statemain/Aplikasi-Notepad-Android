package ei.eseptiyadi.notesapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ei.eseptiyadi.notesapp.auth.LoginActivity;

import ei.eseptiyadi.notesapp.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void gotoSignin(View view) {
        startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
    }
}