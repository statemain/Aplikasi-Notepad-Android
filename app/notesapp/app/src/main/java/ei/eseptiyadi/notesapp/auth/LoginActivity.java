package ei.eseptiyadi.notesapp.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ei.eseptiyadi.notesapp.R;
import ei.eseptiyadi.notesapp.model.auth.RequestLogin;
import ei.eseptiyadi.notesapp.network.ApiServices;
import ei.eseptiyadi.notesapp.network.RetrofitClient;
import ei.eseptiyadi.notesapp.views.DashboardActivity;
import ei.eseptiyadi.notesapp.views.WelcomeActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText logUsername, logPassword;
    Button btnActionLogin;
    ProgressDialog pd;

    Bundle kirimdataLogin = new Bundle();

    String getUsername, getPassword, getLevel, getHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Bundle getPackageNewUser = getIntent().getExtras();

        if (getIntent().getExtras() != null) {
            getUsername = getPackageNewUser.getString("key_username");
            getPassword = getPackageNewUser.getString("key_password");
            getHash = getPackageNewUser.getString("key_hash");
            getLevel = getPackageNewUser.getString("key_level");
        } else {

        }

        logUsername = (EditText)findViewById(R.id.edtLogUsername);
        logPassword = (EditText)findViewById(R.id.edtLogPassword);
        btnActionLogin = (Button)findViewById(R.id.btnLogSignin);

        logUsername.setText(getUsername);
        logPassword.setText(getPassword);

        btnActionLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cekUsername, cekPassword;
                cekUsername = logUsername.getText().toString();
                cekPassword = logPassword.getText().toString();
                
                if (cekUsername.equals("")) {
                    logUsername.requestFocus();
                    logUsername.setError("Username anda belum diisi!");
                } else if (cekPassword.equals("")) {
                    logPassword.requestFocus();
                    logPassword.setError("Password anda belum diisi!");
                } else {
                    moudleLoginUser(cekUsername, cekPassword, getHash, getLevel);
                    // Log.d("Log", "Data User : " + getUsername + " " + getPassword + " " + getHash + " " + getLevel);
                }
            }
        });


    }

    private void moudleLoginUser(String cekUsername, String cekPassword, String getHash, String getLevel) {
        // Log.d("Log", "Module Login : " + cekUsername + " " + cekPassword + " " + getHash + " " + getLevel);
        ApiServices apiServices = RetrofitClient.getInstance();
        Call<RequestLogin> requestLoginCall = apiServices.reqLoginUser(cekUsername, cekPassword, getHash, getLevel);

        requestLoginCall.enqueue(new Callback<RequestLogin>() {
            @Override
            public void onResponse(Call<RequestLogin> call, Response<RequestLogin> response) {
                if (response.isSuccessful()){

                    int codeResponse = response.body().getCode();

                    if (codeResponse == 200) {
                        // Log.d("Log", "Data Login : " + cekUsername + " " + cekPassword + " " + getHash + " " + getLevel);
                        kirimdataLogin.putString("dataUsername", cekUsername);
                        kirimdataLogin.putString("dataPwd", cekPassword);
                        kirimdataLogin.putString("dataHash", getHash);
                        kirimdataLogin.putString("dataLvl", getLevel);

                        Intent kirimresultLogin = new Intent(LoginActivity.this, DashboardActivity.class);
                        kirimresultLogin.putExtras(kirimdataLogin);
                        startActivity(kirimresultLogin);
                    } else if (codeResponse == 404) {
                        Toast.makeText(LoginActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<RequestLogin> call, Throwable t) {

            }
        });
    }

    public void registerNow(View view) {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));

    }
}