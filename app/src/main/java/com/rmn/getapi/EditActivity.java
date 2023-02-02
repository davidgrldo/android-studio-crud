package com.rmn.getapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rmn.getapi.model.PostPutDelSubject;
import com.rmn.getapi.rest.ApiClient;
import com.rmn.getapi.rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class EditActivity extends AppCompatActivity {
    EditText edtId, edtNama, edtSKS;
    Button btUpdate, btDelete, btBack;
    ApiInterface mApiInterface;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        edtId = (EditText) findViewById(R.id.edtId);
        edtNama = (EditText) findViewById(R.id.edtNama);
        edtSKS = (EditText) findViewById(R.id.edtSKS);
        Intent mIntent = getIntent();
        edtId.setText(String.valueOf(mIntent.getIntExtra("id",0)));
        edtId.setTag(edtId.getKeyListener());
        edtId.setKeyListener(null);
        edtNama.setText(mIntent.getStringExtra("nama"));
        edtSKS.setText(String.valueOf(mIntent.getIntExtra("sks",0)));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btUpdate = (Button) findViewById(R.id.btUpdate);
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelSubject> updateSubjectCall = mApiInterface.putSubject(
                        Integer.parseInt(edtId.getText().toString()),
                        Integer.parseInt(edtId.getText().toString()),
                        edtNama.getText().toString(),
                        Integer.parseInt(edtSKS.getText().toString()));
                updateSubjectCall.enqueue(new Callback<PostPutDelSubject>() {
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
        btDelete = (Button) findViewById(R.id.btDelete);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtId.getText().toString().trim().isEmpty()==false){
                    Call<PostPutDelSubject> deleteSubject = mApiInterface.deleteSubject(Integer.parseInt(edtId.getText().toString()),Integer.parseInt(edtId.getText().toString()));
                    deleteSubject.enqueue(new Callback<PostPutDelSubject>() {
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
                }else{
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
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