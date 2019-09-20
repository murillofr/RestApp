package murillofr.restapp.services;

import java.util.List;

import murillofr.restapp.entidades.Post;
import murillofr.restapp.entidades.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiEndPoint {

    @GET("users")
    Call<List<User>> obterUsuarios();

    @POST("posts")
    Call<Post> createPost(@Body Post post);

}
