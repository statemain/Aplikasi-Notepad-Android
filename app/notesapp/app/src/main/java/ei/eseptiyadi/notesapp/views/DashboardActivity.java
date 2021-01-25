package ei.eseptiyadi.notesapp.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
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

    RecyclerView rvListNotes;
    SwipeRefreshLayout srvListNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        rvListNotes = (RecyclerView)findViewById(R.id.rv_listtask);
        srvListNotes = (SwipeRefreshLayout)findViewById(R.id.srlLoadList);

        rvListNotes.setHasFixedSize(true);
        rvListNotes.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        String userName = "septiadi";
        String userKey = "!!&21adi";
        String hashUser = "adminkantor";
        String levelUser = "Administrator";
        String categoryNotes = "Task";

        loadDataNotes(userName, userKey, hashUser, levelUser, categoryNotes);
    }

    private void loadDataNotes(String userName, String userKey, String hashUser, String levelUser, String categoryNotes) {
        ApiServices apiServices = RetrofitClient.getInstance();
        Call<ResponseListNotes> responseListNotesCall = apiServices.reqListNotes(userName, userKey, hashUser,levelUser, categoryNotes);

        responseListNotesCall.enqueue(new Callback<ResponseListNotes>() {
            @Override
            public void onResponse(Call<ResponseListNotes> call, Response<ResponseListNotes> response) {
                if (response.isSuccessful()) {
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