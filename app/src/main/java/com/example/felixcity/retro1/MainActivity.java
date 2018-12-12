package com.example.felixcity.retro1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
    public EditText Editname,Editpass,EditConpass,Editemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Editname = findViewById(R.id.Tname);
        Editpass = findViewById(R.id.password);
        EditConpass = findViewById(R.id.con_password);
        Editemail = findViewById(R.id.Temail);

        findViewById(R.id.button).setOnClickListener(this);

    }

    private void userSignup() {

        Users users = new Users(Editname.getText().toString().trim(),
                                 Editemail.getText().toString().trim(),
                                 Editpass.getText().toString().trim(),
                                 EditConpass.getText().toString().trim()
                               );

        Call<Users> call = RetrofitClient.getInstance().getApi().createAccount(users);
          call.enqueue(new Callback<Users>() {
              @Override
              public void onResponse(Call<Users> call, Response<Users> response) {
                  assert response.body() != null;
                   String s = "Code " + response.code()+"\n";
                  Toast.makeText(MainActivity.this,"Yeah Is: " + s ,Toast.LENGTH_LONG).show();
              }

              @Override
              public void onFailure(Call<Users> call, Throwable t) {
                  Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_LONG).show();
              }
          });

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button :userSignup(); break;
        }
    }
}
