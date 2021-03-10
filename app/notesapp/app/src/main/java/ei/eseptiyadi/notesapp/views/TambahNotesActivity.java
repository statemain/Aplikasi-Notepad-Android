package ei.eseptiyadi.notesapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    String usernm, passwd, hashwd, lvlwd, setTittle, setContent, setCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_notes);

        etTittle = (EditText)findViewById(R.id.edtAddTittleNotes);
        etCotntent = (EditText)findViewById(R.id.edtAddContentNotes);
        etCategory = (EditText)findViewById(R.id.edtAddCategoryNotes);
    }

    public void simpanNotes(View view) {

        usernm = "arif";
        passwd = "0ff6c3ace16359e41e37d40b8301d67f";
        hashwd = "92b6099770d8bd96bbed3c6ecdcbf8b8fef78b5e";
        lvlwd = "Staff Kantor";

        setTittle = etTittle.getText().toString();
        setContent = etCotntent.getText().toString();
        setCategory = etCategory.getText().toString();

        ApiServices apiServices = RetrofitClient.getInstance();
        Call<RequestTambahNotes> callRequesttambahNotes = apiServices.reqAddNotes(usernm, passwd, hashwd, lvlwd, setTittle, setContent, setCategory);

        callRequesttambahNotes.enqueue(new Callback<RequestTambahNotes>() {
            @Override
            public void onResponse(Call<RequestTambahNotes> call, Response<RequestTambahNotes> response) {
                if (response.isSuccessful()){
                    int responseCode = response.body().getCode();

                    if (responseCode == 201) {
                        Toast.makeText(TambahNotesActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
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

    public void cancelAddNotes(View view) {
    }
}