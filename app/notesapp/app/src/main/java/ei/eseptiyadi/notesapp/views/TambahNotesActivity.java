package ei.eseptiyadi.notesapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ei.eseptiyadi.notesapp.R;
import ei.eseptiyadi.notesapp.model.tambahnotes.RequestTambahNotes;
import ei.eseptiyadi.notesapp.network.ApiServices;
import ei.eseptiyadi.notesapp.network.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahNotesActivity extends AppCompatActivity {

    EditText etTittle, etCotntent, etCategory, etIdNotes;
    String usernm, passwd, hashwd, lvlwd, setTittle, setContent, setCategory, infoAct, idNotes, tittleNotes, contentNotes, categoryNotes, dateCreateNotes;

    Button btActionTambah;

    TextView txtDateCreated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_notes);


        etTittle = (EditText)findViewById(R.id.edtAddTittleNotes);
        etCotntent = (EditText)findViewById(R.id.edtAddContentNotes);
        etCategory = (EditText)findViewById(R.id.edtAddCategoryNotes);
        etIdNotes = (EditText)findViewById(R.id.edtAddIdNotes);
        btActionTambah = (Button) findViewById(R.id.btnTambahNotes);
        txtDateCreated = (TextView) findViewById(R.id.txDeateCreaetd);

        Bundle getpackageDataLogin = getIntent().getExtras();

        if (getIntent().getExtras() != null) {
            usernm = getpackageDataLogin.getString("USR");
            passwd = getpackageDataLogin.getString("PWD");
            hashwd = getpackageDataLogin.getString("HASH");
            lvlwd = getpackageDataLogin.getString("LVL");
            infoAct = getpackageDataLogin.getString("INFO");

            // Data Edit Notes
            idNotes = getpackageDataLogin.getString("ID_NOTES");
            tittleNotes = getpackageDataLogin.getString("TITTLE_NOTES");
            contentNotes = getpackageDataLogin.getString("CONTENT_NOTES");
            categoryNotes = getpackageDataLogin.getString("CAT_NOTES");
            dateCreateNotes = getpackageDataLogin.getString("DATE_CREATED");

            if (infoAct.equals("New")) {
                getSupportActionBar().setTitle(infoAct + " Note");
                etIdNotes.setVisibility(View.GONE);
                btActionTambah.setText("Tambah Note");
                txtDateCreated.setVisibility(View.GONE);

                btActionTambah.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        actionTambahNotes_API();
                    }
                });
            } else if (infoAct.equals("Edit")) {
                getSupportActionBar().setTitle(infoAct + " Note");
                etIdNotes.setVisibility(View.VISIBLE);
                etIdNotes.setText(idNotes);
                etTittle.setText(tittleNotes);
                etCotntent.setText(contentNotes);
                etCategory.setText(categoryNotes);
                btActionTambah.setText("Ubah Note");
                txtDateCreated.setText(dateCreateNotes);

                btActionTambah.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        actionEditNotes_API();
                    }
                });
            }

        } else {

        }
    }

    private void actionEditNotes_API() {
        Toast.makeText(this, "Belum Ada Action", Toast.LENGTH_SHORT).show();
    }

    private void actionTambahNotes_API() {
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
}