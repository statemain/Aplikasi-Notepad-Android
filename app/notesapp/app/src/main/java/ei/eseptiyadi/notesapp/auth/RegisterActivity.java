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
import ei.eseptiyadi.notesapp.model.auth.RequestRegister;
import ei.eseptiyadi.notesapp.network.ApiServices;
import ei.eseptiyadi.notesapp.network.RetrofitClient;
import ei.eseptiyadi.notesapp.views.WelcomeActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {


    // Deklarasi
    EditText setUsername, setPassword, setConfirmPassword, setLevel;
    Button btnSignup;
    String buatHash;
    ProgressDialog pd;
    Bundle packageNewUser = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        // Instansiasi
        pd = new ProgressDialog(RegisterActivity.this);

        setUsername = (EditText)findViewById(R.id.edtRegUsername);
        setPassword = (EditText)findViewById(R.id.edtRegPassword);
        setConfirmPassword = (EditText)findViewById(R.id.edtRegConfPassword);
        setLevel = (EditText)findViewById(R.id.edtRegLevel);

        btnSignup = (Button)findViewById(R.id.btnRegSignup);


        // Implementasi
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username, password, confirmPassword, level;

                username = setUsername.getText().toString();
                password = setPassword.getText().toString();
                confirmPassword = setConfirmPassword.getText().toString();
                level = setLevel.getText().toString();

                if (username.equals("")) {
                    setUsername.requestFocus();
                    setUsername.setError("Username anda belum diisi!");
                } else if (password.equals("")) {
                    setPassword.requestFocus();
                    setPassword.setError("Password anda belum diisi!");
                } else if (confirmPassword.equals("")) {
                    setConfirmPassword.requestFocus();
                    setConfirmPassword.setError("Confirm Password anda belum diisi!");
                } else if (!confirmPassword.equals(password)) {
                    setConfirmPassword.requestFocus();
                    setConfirmPassword.setError("Confirm Password tidak sama dengan password");
                } else if (level.equals("")) {
                    setLevel.requestFocus();
                    setLevel.setError("Level user belum dipilih!");
                } else {
                    pd.setTitle("Processing...");
                    pd.setMessage("Please wait.");
                    pd.setCancelable(false);
                    pd.setIndeterminate(true);
                    pd.show();

                    moduleRegisterNewuser(username, password, level);
                }

            }
        });

    }

    private void moduleRegisterNewuser(String username, String password, String level) {

        // Request
        ApiServices apiServices = RetrofitClient.getInstance();

        if (level.equals("Administrator")) {
            buatHash = "administrator";
        } else if (level.equals("Staff Kantor")) {
            buatHash = "staffkantor";
        } else if (level.equals("User Biasa")) {
            buatHash = "userbiasa";
        } else if (level.equals("General")) {
            buatHash = "general";
        }

        // Toast.makeText(this, username + password + buatHash + "_" + username + level, Toast.LENGTH_LONG).show();

        Call<RequestRegister> reqRegisterCall = apiServices.reqRegisterNewUser(username, password, buatHash + "_" + username, level);

        // Server ngasih Response

        reqRegisterCall.enqueue(new Callback<RequestRegister>() {
            @Override
            public void onResponse(Call<RequestRegister> call, Response<RequestRegister> response) {

                if (response.isSuccessful()) {
                    pd.dismiss();

                    int codeResponse = response.body().getCode();

                    if (codeResponse == 201) {
                        packageNewUser.putString("key_username", username);
                        packageNewUser.putString("key_password", password);

                        Intent kirimkeLogin = new Intent(RegisterActivity.this, LoginActivity.class);
                        kirimkeLogin.putExtras(packageNewUser);
                        startActivity(kirimkeLogin);
                    } else if (codeResponse == 405) {
                        Toast.makeText(RegisterActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<RequestRegister> call, Throwable t) {

            }
        });

    }

    public void loginNow(View view) {
        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        finish();
    }

    public void clearRegField(View view) {
        setUsername.setText("");
        setPassword.setText("");
        setConfirmPassword.setText("");
        setLevel.setText("");
    }
}