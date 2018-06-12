package kr.hs.e_mirim.bomi0324.dongwhapiece;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import static kr.hs.e_mirim.bomi0324.dongwhapiece.R.layout.activity_login;


public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private String email, pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_login);
        mAuth = FirebaseAuth.getInstance();

        editTextEmail = (EditText) findViewById(R.id.edit_emaillog);
        editTextPassword = (EditText) findViewById(R.id.edit_pwlog);

        Button emaillogin = (Button) findViewById(R.id.login);
        Button loginbutton = (Button) findViewById(R.id.join);

        emaillogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email=editTextEmail.getText().toString();
                pw=editTextPassword.getText().toString();
                if(TextUtils.isEmpty(email)&&TextUtils.isEmpty(pw)) {
                    Toast.makeText(LoginActivity.this,"둘다 입력 필요", Toast.LENGTH_SHORT).show();
                } else if(TextUtils.isEmpty(email)) {
                    Toast.makeText(LoginActivity.this,"이메일 입력 필요", Toast.LENGTH_SHORT).show();
                } else if(TextUtils.isEmpty(pw)) {
                    Toast.makeText(LoginActivity.this,"비번 입력 필요", Toast.LENGTH_SHORT).show();
                } else {
                    login(editTextEmail.getText().toString(), editTextPassword.getText().toString());
                }
            }
        });

        loginbutton.setOnClickListener(new View.OnClickListener() { //로그인버튼튼
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,JoinActivity.class);
                startActivity(intent);
            }
        });
    }

    private void login(String email,String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "로그인 성공!", Toast.LENGTH_SHORT).show();
                            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginActivity.this, "로그인 실패!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }



}
