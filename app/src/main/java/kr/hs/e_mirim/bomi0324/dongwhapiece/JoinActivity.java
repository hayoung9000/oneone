package kr.hs.e_mirim.bomi0324.dongwhapiece;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static kr.hs.e_mirim.bomi0324.dongwhapiece.R.layout.activity_join;

public class JoinActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText editTextEmail; //이메일 입력
    private EditText editTextPassword; //비밀번호 입력
    private String email, pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_join);
        mAuth = FirebaseAuth.getInstance();

        editTextEmail = (EditText) findViewById(R.id.edit_email);
        editTextPassword = (EditText) findViewById(R.id.edit_pw);

        Button signinbutton = (Button) findViewById(R.id.join); //회원가입 버튼
        Button loginbutton = (Button) findViewById(R.id.login); //로그인 버튼
        signinbutton.setOnClickListener(new View.OnClickListener() { //회원가입 버튼
            @Override
            public void onClick(View view) {
                email=editTextEmail.getText().toString();
                pw=editTextPassword.getText().toString();
              //  Toast.makeText(JoinActivity.this,email, Toast.LENGTH_SHORT).show();
               // Toast.makeText(JoinActivity.this,pw, Toast.LENGTH_SHORT).show();
                if(TextUtils.isEmpty(email)&&TextUtils.isEmpty(pw)) {
                    Toast.makeText(JoinActivity.this,"둘다 입력 필요", Toast.LENGTH_SHORT).show();
                } else if(TextUtils.isEmpty(email)) {
                    Toast.makeText(JoinActivity.this,"이메일 입력 필요", Toast.LENGTH_SHORT).show();
                } else if(TextUtils.isEmpty(pw)) {
                    Toast.makeText(JoinActivity.this,"비번 입력 필요", Toast.LENGTH_SHORT).show();
                } else {
                    createUser(editTextEmail.getText().toString(), editTextPassword.getText().toString());
                }
            }
        });

        loginbutton.setOnClickListener(new View.OnClickListener() { //로그인버튼튼
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(JoinActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    private void createUser(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(JoinActivity.this, "회원가입 실패!", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(JoinActivity.this, "회원가입 성공", Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(JoinActivity.this, AskActivity.class);
                            startActivity(i);
                        }
                    }
                });
    }

}



