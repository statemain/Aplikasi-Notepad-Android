package ei.eseptiyadi.notesapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import ei.eseptiyadi.notesapp.R;
import ei.eseptiyadi.notesapp.model.tambahnotes.RequestTambahNotes;
import ei.eseptiyadi.notesapp.network.ApiServices;
import ei.eseptiyadi.notesapp.network.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahNotesActivity extends AppCompatActivity {

    EditText etTittle, etCotntent, etCategory;
    String usernm, passwd, hashwd, lvlwd, setTittle, setContent, setCategory, infoAct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_notes);


        Bundle getpackageDataLogin = getIntent().getExtras();

        if (getIntent().getExtras() != null) {
            usernm = getpackageDataLogin.getString("USR");
            passwd = getpackageDataLogin.getString("PWD");
            hashwd = getpackageDataLogin.getString("HASH");
            lvlwd = getpackageDataLogin.getString("LVL");
            infoAct = getpackageDataLogin.getString("INFO");


            if (infoAct.equals("New")) {
                getSupportActionBar().setTitle(infoAct + " Note");
            } else if (infoAct.equals("Edit")) {
                getSupportActionBar().setTitle(infoAct + " Note");
            }

        } else {

        }

        etTittle = (EditText)findViewById(R.id.edtAddTittleNotes);
        etCotntent = (EditText)findViewById(R.id.edtAddContentNotes);
        etCategory = (EditText)findViewById(R.id.edtAddCategoryNotes);
    }

    public void simpanNotes(View view) {

        setTittle = etTittle.getText().toString();
        setContent = etCotntent.getText().toString();
        setCategory = etCategory.getText().toString();

        if (setTittle.equals("")) {
            etTittle.requestFocus();
            etTittle.setError("Tittle belum diisi!");
        } else if (setContent.equals("")) {
            etCotntent.requestFocus();
            etCotntent.setError("Content belum diisi!");
        } else if (setCategory.equals("")) {
            etCategory.requestFocus();
            etCategory.setError("Category belum diisi!");
        } else {
            ApiServices apiServices = RetrofitClient.getInstance();
            Call<RequestTambahNotes> callRequesttambahNotes = apiServices.reqAddNotes(usernm, passwd, hashwd, lvlwd, setTittle, setContent, setCategory);

            callRequesttambahNotes.enqueue(new Callback<RequestTambahNotes>() {
                @Override
                public void onResponse(Call<RequestTambahNotes> call, Response<RequestTambahNotes> response) {
                    if (response.isSuccessful()){
                        int responseCode = response.body().getCode();

                        if (responseCode == 201) {
                            Toast.makeText(TambahNotesActivity.this, response.body().getMessage() + " User by " + usernm, Toast.LENGTH_SHORT).show();
                        } else if (responseCode == 401) {
                            Toast.makeText(TambahNotesActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<RequestTambahNotes> call, Throwable t) {

                }
            });
        }

    }

    public void cancelAddNotes(View view) {
    }
}