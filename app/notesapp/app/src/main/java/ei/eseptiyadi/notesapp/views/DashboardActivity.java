package ei.eseptiyadi.notesapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import ei.eseptiyadi.notesapp.R;
import ei.eseptiyadi.notesapp.adapter.AdapterDashboard;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        rvListTasks = (RecyclerView)findViewById(R.id.rv_listtask);
        rvListTodo = (RecyclerView)findViewById(R.id.rv_listtodo);
        rvListNotes = (RecyclerView)findViewById(R.id.rv_listnotes);
        srvListNotes = (SwipeRefreshLayout)findViewById(R.id.srlLoadList);

        rvListTasks.setHasFixedSize(true);
        rvListTodo.setHasFixedSize(true);
        rvListNotes.setHasFixedSize(true);

        rvListTasks.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvListTodo.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvListNotes.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        String userName = "septiadi";
        String userKey = "!!&21adi";
        String hashUser = "adminkantor";
        String levelUser = "Administrator";

        updateList(userName, userKey, hashUser, levelUser);

        srvListNotes.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                updateList(userName, userKey, hashUser, levelUser);
            }
        });

    }

    public void updateList(String username, String password, String hash, String level) {
        loadDataTask(username, password, hash, level, "Task");
        loadDataNotes(username, password, hash, level, "Notes");
        loadDataTodos(username, password, hash, level, "To do");
    }

    private void loadDataTodos(String userName, String userKey, String hashUser, String levelUser, String to_do) {
        TextView totalDataTodo, titleTodo;
        totalDataTodo = (TextView)findViewById(R.id.txTotalDataTodo);
        titleTodo = (TextView)findViewById(R.id.txCategoryTodo);

        ApiServices apiServices = RetrofitClient.getInstance();
        Call<ResponseListNotes> responseListNotesCall = apiServices.reqListNotes(userName, userKey, hashUser,levelUser, to_do);

        responseListNotesCall.enqueue(new Callback<ResponseListNotes>() {
            @Override
            public void onResponse(Call<ResponseListNotes> call, Response<ResponseListNotes> response) {
                if (response.isSuccessful()) {

                    totalDataTodo.setText(response.body().getTotalnotes() + " Total Item");
                    titleTodo.setText("Kategori " + response.body().getCategory());

                    boolean status = response.body().isStatus();
                    List<ListnotesItem> notesItemList = response.body().getListnotes();

                    if (status == true) {
                        AdapterDashboard adapterDashboard = new AdapterDashboard(DashboardActivity.this, notesItemList);
                        rvListTodo.setAdapter(adapterDashboard);
                        srvListNotes.setRefreshing(false);
                    } else {
                        Toast.makeText(DashboardActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(DashboardActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseListNotes> call, Throwable t) {

            }
        });
    }

    private void loadDataNotes(String userName, String userKey, String hashUser, String levelUser, String notes) {
        TextView totalDataNotes, titleNotes;
        totalDataNotes = (TextView)findViewById(R.id.txTotalDataNotes);
        titleNotes = (TextView)findViewById(R.id.txCategoryNotes);


        ApiServices apiServices = RetrofitClient.getInstance();
        Call<ResponseListNotes> responseListNotesCall = apiServices.reqListNotes(userName, userKey, hashUser,levelUser, notes);

        responseListNotesCall.enqueue(new Callback<ResponseListNotes>() {
            @Override
            public void onResponse(Call<ResponseListNotes> call, Response<ResponseListNotes> response) {
                if (response.isSuccessful()) {

                    totalDataNotes.setText(response.body().getTotalnotes() + " Total Item");
                    titleNotes.setText("Kategori " + response.body().getCategory());

                    boolean status = response.body().isStatus();
                    List<ListnotesItem> notesItemList = response.body().getListnotes();

                    if (status == true) {
                        AdapterDashboard adapterDashboard = new AdapterDashboard(DashboardActivity.this, notesItemList);
                        rvListNotes.setAdapter(adapterDashboard);
                        srvListNotes.setRefreshing(false);
                    } else {
                        Toast.makeText(DashboardActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(DashboardActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseListNotes> call, Throwable t) {

            }
        });
    }

    private void loadDataTask(String userName, String userKey, String hashUser, String levelUser, String task) {
        TextView totalDataTask, titleTask;
        totalDataTask = (TextView)findViewById(R.id.txTotalDataTask);
        titleTask = (TextView)findViewById(R.id.txCategoryTask);

        ApiServices apiServices = RetrofitClient.getInstance();
        Call<ResponseListNotes> responseListNotesCall = apiServices.reqListNotes(userName, userKey, hashUser,levelUser, task);

        responseListNotesCall.enqueue(new Callback<ResponseListNotes>() {
            @Override
            public void onResponse(Call<ResponseListNotes> call, Response<ResponseListNotes> response) {
                if (response.isSuccessful()) {

                    totalDataTask.setText(response.body().getTotalnotes() + " Total Item");
                    titleTask.setText("Kategori " + response.body().getCategory());

                    boolean status = response.body().isStatus();
                    List<ListnotesItem> notesItemList = response.body().getListnotes();

                    if (status == true) {
                        AdapterDashboard adapterDashboard = new AdapterDashboard(DashboardActivity.this, notesItemList);
                        rvListTasks.setAdapter(adapterDashboard);
                        srvListNotes.setRefreshing(false);
                    } else {
                        Toast.makeText(DashboardActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(DashboardActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseListNotes> call, Throwable t) {

            }
        });
    }
}