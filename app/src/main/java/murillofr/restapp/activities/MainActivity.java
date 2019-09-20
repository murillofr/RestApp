package murillofr.restapp.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.List;

import murillofr.restapp.R;
import murillofr.restapp.entidades.User;
import murillofr.restapp.services.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView campos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        campos = findViewById(R.id.viewJSON);
        buscaDados();
    }

    private void buscaDados() {
        RetrofitService.getServico().obterUsuarios().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> lista = response.body();
                for (User user : lista) {
                    campos.append("id: " + user.getId() +
                            "\nNome: " + user.getName() +
                            "\nUsername: " + user.getUsername() +
                            "\nEmail: " + user.getEmail() +
                            "\nEndereço: " + user.getAddress().getStreet() + ", " + user.getAddress().getCity() +
                            "\nTelefone: " + user.getPhone() +
                            "\nWebsite: " + user.getWebsite()+"\n\n");
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Log.e("RestApp", t.getStackTrace().toString());
            }
        });
    }

    public void navegar(View view) {
        startActivity(new Intent(this, PostActivity.class));
    }

}
