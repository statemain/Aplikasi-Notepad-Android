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

    RecyclerView rvListNotes, rvListTodo;
    SwipeRefreshLayout srvListNotes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        rvListNotes = (RecyclerView)findViewById(R.id.rv_listtask);
        rvListTodo = (RecyclerView)findViewById(R.id.rv_listtodo);
        srvListNotes = (SwipeRefreshLayout)findViewById(R.id.srlLoadList);

        rvListNotes.setHasFixedSize(true);
        rvListTodo.setHasFixedSize(true);

        rvListNotes.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rvListTodo.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        String userName = "septiadi";
        String userKey = "!!&21adi";
        String hashUser = "adminkantor";
        String levelUser = "Administrator";

        loadDataTask(userName, userKey, hashUser, levelUser, "Task");
        loadDataNotes(userName, userKey, hashUser, levelUser, "Notes");
        loadDataTodos(userName, userKey, hashUser, levelUser, "To do");
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
                        rvListNotes.setAdapter(adapterDashboard);
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