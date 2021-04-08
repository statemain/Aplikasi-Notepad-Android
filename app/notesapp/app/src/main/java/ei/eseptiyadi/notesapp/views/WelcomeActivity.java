package ei.eseptiyadi.notesapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import ei.eseptiyadi.notesapp.auth.LoginActivity;

import ei.eseptiyadi.notesapp.R;
import ei.eseptiyadi.notesapp.auth.RegisterActivity;
import ei.eseptiyadi.notesapp.preferences.Session;

public class WelcomeActivity extends AppCompatActivity {
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (Session.getStatus_Userlog(getBaseContext())) {
            startActivity(new Intent(getBaseContext(), DashboardActivity.class));
            finish();
        }
    }

    public void gotoSignin(View view) {
        startActivity(new Intent(WelcomeActivity.this, LoginActivity.class));
    }

    public void gotoSignup(View view) {
        startActivity(new Intent(WelcomeActivity.this, RegisterActivity.class));
    }
}