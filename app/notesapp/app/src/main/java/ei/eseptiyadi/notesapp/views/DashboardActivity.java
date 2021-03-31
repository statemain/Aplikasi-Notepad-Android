package ei.eseptiyadi.notesapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import ei.eseptiyadi.notesapp.R;
import ei.eseptiyadi.notesapp.adapter.AdapterDashboard;
import ei.eseptiyadi.notesapp.auth.LoginActivity;
import ei.eseptiyadi.notesapp.model.listdatanotes.ListnotesItem;
import ei.eseptiyadi.notesapp.model.listdatanotes.ResponseListNotes;
import ei.eseptiyadi.notesapp.network.ApiServices;
import ei.eseptiyadi.notesapp.network.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardActivity extends AppCompatActivity {

    RecyclerView rvListTasks, rvListTodo, rvListNotes;
    SwipeRefreshLayout srvListNotes;

    TextView infoNotFoundTodo;

    String categoryOfNotes;

    String getlogUsername = "", getlogPassword = "", getlogHash = "", getlogLevel = "", infoAdd = "New";

    FloatingActionButton fabTambahNotes;

    Bundle kirimdataLogin = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        Bundle getpackageLogin = getIntent().getExtras();

        if (getIntent().getExtras() != null) {
            getlogUsername = getpackageLogin.getString("dataUsername");
            getlogPassword = getpackageLogin.getString("dataPwd");
            getlogHash = getpackageLogin.getString("dataHash");
            getlogLevel = getpackageLogin.getString("dataLvl");

            getSupportActionBar().setTitle("Hi, " + getlogUsername);
        } else {

        }

        // Log.d("Log", "Data Login User : " + getlogUsername + " " + getlogPassword + " " + getlogHash + " " + getlogLevel);

        rvListTasks = (RecyclerView)findViewById(R.id.rv_listtask);
        rvListTodo = (RecyclerView)findViewById(R.id.rv_listtodo);
        rvListNotes = (RecyclerView)findViewById(R.id.rv_listnotes);
        fabTambahNotes = (FloatingActionButton) findViewById(R.id.fabTambah);

        infoNotFoundTodo = (TextView) findViewById(R.id.notFoundTodo);

        srvListNotes = (SwipeRefreshLayout)findViewById(R.id.srlLoadList);

        rvListTasks.setHasFixedSize(true);
        rvListTodo.setHasFixedSize(true);
        rvListNotes.setHasFixedSize(true);

        rvListTasks.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvListTodo.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvListNotes.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        srvListNotes.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Meload ketika swipe refresh di laksanakan
                updateList(getlogUsername, getlogPassword, getlogHash, getlogLevel);
            }
        });

        loadNotes(getlogUsername, getlogPassword, getlogHash, getlogLevel);

        fabTambahNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent pindah ke Tambah Notes Activity
                // Mengirim Username, Password, Hash, Level ke Activity Tambah Notes
                // Di Activity Tambah Notes ini menerima hasil intent dari activity Login
                // bisa digunakan ketika menmabahkan data

                kirimdataLogin.putString("USR", getlogUsername);
                kirimdataLogin.putString("PWD", getlogPassword);
                kirimdataLogin.putString("HASH", getlogHash);
                kirimdataLogin.putString("LVL", getlogLevel);
                kirimdataLogin.putString("INFO", infoAdd);

                Intent kirimdatakeTambahNote = new Intent(DashboardActivity.this, TambahNotesActivity.class);
                kirimdatakeTambahNote.putExtras(kirimdataLogin);
                startActivity(kirimdatakeTambahNote);

            }
        });

    }

    public void loadNotes(String username, String password, String hash, String level) {
        loadDataTask(username, password, hash, level);
        loadDataNotes(username, password, hash, level);
        loadDataTodos(username, password, hash, level);
    }

    public void updateList(String username, String password, String hash, String level) {
        loadDataTask(username, password, hash, level);
        loadDataNotes(username, password, hash, level);
        loadDataTodos(username, password, hash, level);
    }

    private void loadDataTodos(String userName, String userKey, String hashUser, String levelUser) {
        categoryOfNotes = "To do";

        TextView totalDataTodo, titleTodo, infoNotFoundDataTodo;
        totalDataTodo = (TextView)findViewById(R.id.txTotalDataTodo);
        titleTodo = (TextView)findViewById(R.id.txCategoryTodo);
        infoNotFoundDataTodo = (TextView)findViewById(R.id.notFoundTodo);

        ApiServices apiServices = RetrofitClient.getInstance();
        Call<ResponseListNotes> responseListNotesCall = apiServices.reqListNotes(userName, userKey, hashUser,levelUser, categoryOfNotes);

        responseListNotesCall.enqueue(new Callback<ResponseListNotes>() {
            @Override
            public void onResponse(Call<ResponseListNotes> call, Response<ResponseListNotes> response) {
                if (response.isSuccessful()) {

                    totalDataTodo.setText(response.body().getTotalnotes() + " Total Item");
                    titleTodo.setText("Kategori " + response.body().getCategory());

                    List<ListnotesItem> notesItemList = response.body().getListnotes();
                    AdapterDashboard adapterDashboard = new AdapterDashboard(DashboardActivity.this, notesItemList);

                    int totalDataCatatan = Integer.parseInt(response.body().getTotalnotes().toString());

                    if (totalDataCatatan == 0) {
                        infoNotFoundDataTodo.setVisibility(View.VISIBLE);
                        infoNotFoundDataTodo.setText(response.body().getMessage());
                        srvListNotes.setRefreshing(false);
                        rvListTodo.setVisibility(View.GONE);
                    } else if (totalDataCatatan >= 0) {
                        infoNotFoundDataTodo.setVisibility(View.GONE);
                        rvListTodo.setVisibility(View.VISIBLE);
                        rvListTodo.setAdapter(adapterDashboard);
                        srvListNotes.setRefreshing(false);
                    }

                } else {
                    Toast.makeText(DashboardActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseListNotes> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void loadDataNotes(String userName, String userKey, String hashUser, String levelUser) {
        categoryOfNotes = "Notes";

        TextView totalDataNotes, titleNotes, infoNotFoundDataNotes;
        totalDataNotes = (TextView)findViewById(R.id.txTotalDataNotes);
        titleNotes = (TextView)findViewById(R.id.txCategoryNotes);
        infoNotFoundDataNotes = (TextView)findViewById(R.id.notFoundNotes);


        ApiServices apiServices = RetrofitClient.getInstance();
        Call<ResponseListNotes> responseListNotesCall = apiServices.reqListNotes(userName, userKey, hashUser,levelUser, categoryOfNotes);

        responseListNotesCall.enqueue(new Callback<ResponseListNotes>() {
            @Override
            public void onResponse(Call<ResponseListNotes> call, Response<ResponseListNotes> response) {
                if (response.isSuccessful()) {

                    totalDataNotes.setText(response.body().getTotalnotes() + " Total Item");
                    titleNotes.setText("Kategori " + response.body().getCategory());

                    List<ListnotesItem> notesItemList = response.body().getListnotes();
                    AdapterDashboard adapterDashboard = new AdapterDashboard(DashboardActivity.this, notesItemList);

                    int totalDataCatatan = Integer.parseInt(response.body().getTotalnotes().toString());

                    if (totalDataCatatan == 0) {
                        infoNotFoundDataNotes.setVisibility(View.VISIBLE);
                        infoNotFoundDataNotes.setText(response.body().getMessage());
                        srvListNotes.setRefreshing(false);
                        rvListNotes.setVisibility(View.GONE);
                    } else if (totalDataCatatan >= 0) {
                        infoNotFoundDataNotes.setVisibility(View.GONE);
                        rvListNotes.setVisibility(View.VISIBLE);
                        rvListNotes.setAdapter(adapterDashboard);
                        srvListNotes.setRefreshing(false);
                    }

                } else {
                    Toast.makeText(DashboardActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseListNotes> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void loadDataTask(String userName, String userKey, String hashUser, String levelUser) {
        categoryOfNotes = "Task";

        TextView totalDataTask, titleTask, infoNotFoundDataTask;
        totalDataTask = (TextView)findViewById(R.id.txTotalDataTask);
        titleTask = (TextView)findViewById(R.id.txCategoryTask);
        infoNotFoundDataTask = (TextView)findViewById(R.id.notFoundTask);

        ApiServices apiServices = RetrofitClient.getInstance();
        Call<ResponseListNotes> responseListNotesCall = apiServices.reqListNotes(userName, userKey, hashUser,levelUser, categoryOfNotes);

        responseListNotesCall.enqueue(new Callback<ResponseListNotes>() {
            @Override
            public void onResponse(Call<ResponseListNotes> call, Response<ResponseListNotes> response) {
                if (response.isSuccessful()) {

                    totalDataTask.setText(response.body().getTotalnotes() + " Total Item");
                    titleTask.setText("Kategori " + response.body().getCategory());

                    List<ListnotesItem> notesItemList = response.body().getListnotes();
                    AdapterDashboard adapterDashboard = new AdapterDashboard(DashboardActivity.this, notesItemList);

                    int totalDataCatatan = Integer.parseInt(response.body().getTotalnotes().toString());

                    if (totalDataCatatan == 0) {
                        infoNotFoundDataTask.setVisibility(View.VISIBLE);
                        infoNotFoundDataTask.setText(response.body().getMessage());
                        srvListNotes.setRefreshing(false);
                        rvListTasks.setVisibility(View.GONE);
                    } else if (totalDataCatatan >= 0) {
                        infoNotFoundDataTask.setVisibility(View.GONE);
                        rvListTasks.setVisibility(View.VISIBLE);
                        rvListTasks.setAdapter(adapterDashboard);
                        srvListNotes.setRefreshing(false);
                    }
                } else {
                    Toast.makeText(DashboardActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseListNotes> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Authentication Info")
                .setMessage("Apakah anda ingin logout?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        DashboardActivity.super.onBackPressed();
                    }
                }).create().show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadNotes(getlogUsername, getlogPassword, getlogHash, getlogLevel);
    }
}