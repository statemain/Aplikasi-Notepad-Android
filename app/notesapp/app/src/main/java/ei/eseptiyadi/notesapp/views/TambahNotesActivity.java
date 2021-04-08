package ei.eseptiyadi.notesapp.views;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import ei.eseptiyadi.notesapp.R;
import ei.eseptiyadi.notesapp.model.delete.RequestDelete;
import ei.eseptiyadi.notesapp.model.tambahnotes.RequestTambahNotes;
import ei.eseptiyadi.notesapp.model.update.RequestUpdate;
import ei.eseptiyadi.notesapp.network.ApiServices;
import ei.eseptiyadi.notesapp.network.RetrofitClient;
import ei.eseptiyadi.notesapp.preferences.Session;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahNotesActivity extends AppCompatActivity {

    EditText etTittle, etCotntent, etCategory, etIdNotes;
    String setId, setTittle, setContent, setCategory, infoAct, idNotes, tittleNotes, contentNotes, categoryNotes, dateCreateNotes;

    Button btActionTambah, btnDelete;

    TextView txtDateCreated;

    String usrnm, paskey, hashusr, lvlusr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_notes);

        usrnm = Session.getRegisesi_User(getBaseContext());
        paskey = Session.getRegisesi_Pass(getBaseContext());
        hashusr = Session.getRegisesi_Hash(getBaseContext());
        lvlusr = Session.getRegisesi_Lvl(getBaseContext());

        etTittle = (EditText)findViewById(R.id.edtAddTittleNotes);
        etCotntent = (EditText)findViewById(R.id.edtAddContentNotes);
        etCategory = (EditText)findViewById(R.id.edtAddCategoryNotes);
        etIdNotes = (EditText)findViewById(R.id.edtAddIdNotes);
        btActionTambah = (Button) findViewById(R.id.btnTambahNotes);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        txtDateCreated = (TextView) findViewById(R.id.txDeateCreaetd);

        Bundle getpackageDataLogin = getIntent().getExtras();

        if (getIntent().getExtras() != null) {
            infoAct = getpackageDataLogin.getString("INFO");

            // Data Edit Notes
            idNotes = getpackageDataLogin.getString("ID_NOTES");
            tittleNotes = getpackageDataLogin.getString("TITTLE_NOTES");
            contentNotes = getpackageDataLogin.getString("CONTENT_NOTES");
            categoryNotes = getpackageDataLogin.getString("CAT_NOTES");
            dateCreateNotes = getpackageDataLogin.getString("DATE_CREATED");

            switch (infoAct) {
                case "New" :
                            getSupportActionBar().setTitle(infoAct + " Note");
                            etIdNotes.setVisibility(View.GONE);
                            btActionTambah.setText("Tambah Note");
                            txtDateCreated.setVisibility(View.GONE);
                            btnDelete.setVisibility(View.GONE);

                            btActionTambah.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    actionTambahNotes_API();
                                }
                            });
                    break;
                case "Edit" :
                            getSupportActionBar().setTitle(infoAct + " Note");
                            etIdNotes.setVisibility(View.VISIBLE);
                            etIdNotes.setText(idNotes);
                            etIdNotes.setFocusable(false);
                            btnDelete.setVisibility(View.VISIBLE);
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
                            
                            btnDelete.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    final AlertDialog.Builder builder = new AlertDialog.Builder(TambahNotesActivity.this);

                                    builder.setTitle("Notice!")
                                            .setMessage("Apakah anda ingin menghapus data note dengan id " + idNotes + " ini?")
                                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {

                                                }
                                            })
                                            .setPositiveButton("Setuju", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    actionDeleteNotes_API();
                                                }
                                            });
                                    AlertDialog dialog = builder.create();
                                    dialog.show();
                                }
                            });
                    break;
            }

        } else {

        }
    }

    private void actionDeleteNotes_API() {
        ApiServices apiServices = RetrofitClient.getInstance();
        Call<RequestDelete> deleteCall = apiServices.reqDeleteNotes(usrnm, paskey, hashusr, lvlusr, etIdNotes.getText().toString());

        deleteCall.enqueue(new Callback<RequestDelete>() {
            @Override
            public void onResponse(Call<RequestDelete> call, Response<RequestDelete> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(TambahNotesActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(TambahNotesActivity.this, DashboardActivity.class));
                    finish();
                } else {
                    Toast.makeText(TambahNotesActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RequestDelete> call, Throwable t) {
                Toast.makeText(TambahNotesActivity.this, "Cek Internet", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void actionEditNotes_API() {
        ApiServices apiServices = RetrofitClient.getInstance();
        Call<RequestUpdate> updateCall = apiServices.reqUpdateNotes(usrnm, paskey, hashusr, lvlusr, etIdNotes.getText().toString(), etTittle.getText().toString(), etCotntent.getText().toString(), etCategory.getText().toString());

        // Log.d("Log", "MSG " + usrnm + paskey + hashusr + lvlusr + etIdNotes.getText().toString() + etTittle.getText().toString() + etCotntent.getText().toString() + etCategory.getText().toString());

        updateCall.enqueue(new Callback<RequestUpdate>() {
            @Override
            public void onResponse(Call<RequestUpdate> call, Response<RequestUpdate> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(TambahNotesActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(TambahNotesActivity.this, DashboardActivity.class));
                    finish();
                } else {
                    Toast.makeText(TambahNotesActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RequestUpdate> call, Throwable t) {
                Toast.makeText(TambahNotesActivity.this, "Cek internet", Toast.LENGTH_SHORT).show();
            }
        });
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
            Call<RequestTambahNotes> callRequesttambahNotes = apiServices.reqAddNotes(usrnm, paskey, hashusr, lvlusr, setTittle, setContent, setCategory);

            callRequesttambahNotes.enqueue(new Callback<RequestTambahNotes>() {
                @Override
                public void onResponse(Call<RequestTambahNotes> call, Response<RequestTambahNotes> response) {
                    if (response.isSuccessful()){
                        int responseCode = response.body().getCode();

                        if (responseCode == 201) {
                            Toast.makeText(TambahNotesActivity.this, response.body().getMessage() + " User by " + usrnm, Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(TambahNotesActivity.this, DashboardActivity.class));
                            finish();

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