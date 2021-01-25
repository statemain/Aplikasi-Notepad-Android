package ei.eseptiyadi.notesapp.network;

import ei.eseptiyadi.notesapp.model.listdatanotes.ResponseListNotes;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiServices {

    @FormUrlEncoded
    @POST("module/list_notes.php")
    Call<ResponseListNotes> reqListNotes(
            @Field("username") String username,
            @Field("password") String password,
            @Field("hash_useraccess") String hash_useraccess,
            @Field("level") String level,
            @Field("categoryof_notes") String categoryof_notes
    );
}
