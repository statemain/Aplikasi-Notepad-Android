package ei.eseptiyadi.notesapp.network;

import ei.eseptiyadi.notesapp.model.auth.RequestLogin;
import ei.eseptiyadi.notesapp.model.auth.RequestRegister;
import ei.eseptiyadi.notesapp.model.listdatanotes.ResponseListNotes;
import ei.eseptiyadi.notesapp.model.tambahnotes.RequestTambahNotes;
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

    @FormUrlEncoded
    @POST("auth/register.php")
    Call<RequestRegister> reqRegisterNewUser (
            @Field("username") String setUsername,
            @Field("password") String setPassword,
            @Field("hash_useraccess") String setHash,
            @Field("level") String setLevel
    );

    @FormUrlEncoded
    @POST("auth/login.php")
    Call<RequestLogin> reqLoginUser (
            @Field("username") String setUsername,
            @Field("password") String setPassword
    );

    @FormUrlEncoded
    @POST("module/create_note.php")
    Call<RequestTambahNotes> reqAddNotes (
            @Field("username") String setUsername,
            @Field("password") String setPassword,
            @Field("hash_useraccess") String setHash,
            @Field("level") String setLevel,
            @Field("titleof_notes") String setTittle,
            @Field("contentof_notes") String setContent,
            @Field("categoryof_notes") String setCategory
    );
}
