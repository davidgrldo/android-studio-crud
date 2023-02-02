package com.rmn.getapi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rmn.getapi.model.PostPutDelSubject;
import com.rmn.getapi.rest.ApiClient;
import com.rmn.getapi.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InsertActivity extends AppCompatActivity {
    EditText edtNama, edtSKS;
    Button btInsert, btBack;
    ApiInterface mApiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        edtNama = (EditText) findViewById(R.id.edtNama);
        edtSKS = (EditText) findViewById(R.id.edtSKS);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btInsert = (Button) findViewById(R.id.btInserting);
        btInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelSubject> postSubjectCall = mApiInterface.postSubject(edtNama.getText().toString(), Integer.parseInt(edtSKS.getText().toString()));
                postSubjectCall.enqueue(new Callback<PostPutDelSubject>() {
                    @Override
                    public void onResponse(Call<PostPutDelSubject> call, Response<PostPutDelSubject> response) {
                        MainActivity.ma.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelSubject> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        btBack = (Button) findViewById(R.id.btBackGo);
        btBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.ma.refresh();
                finish();
            }
        });
    }
}