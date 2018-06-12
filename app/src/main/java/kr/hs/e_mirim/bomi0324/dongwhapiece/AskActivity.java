package kr.hs.e_mirim.bomi0324.dongwhapiece;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static kr.hs.e_mirim.bomi0324.dongwhapiece.R.layout.activity_ask;

/**
 * Created by dbwlt on 2017-11-13.
 */

public class AskActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private String uid;
    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;
    private EditText nickname;
    private RadioGroup rg[]=new RadioGroup[5];
    private RadioButton rd[]=new RadioButton[5];
    private String selectedValue[]=new String[5];
    private String fbName[]={"type1","type2","type3","type4","type5"};
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_ask);
        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();


        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            // Name, email address, and profile photo Url
            String name = user.getDisplayName();
            String email = user.getEmail();
            Uri photoUrl = user.getPhotoUrl();

            // Check if user's email is verified
            boolean emailVerified = user.isEmailVerified();

            // The user's ID, unique to the Firebase project. Do NOT use this value to
            // authenticate with your backend server, if you have one. Use
            // FirebaseUser.getToken() instead.
            uid = user.getUid();
        }

        Button submitBtn = (Button) findViewById(R.id.choose);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //체크한 값 가져옴
                nickname=(EditText)findViewById(R.id.nickname);
                databaseReference.child("userData").child(uid).child("nickname").setValue(nickname.getText().toString());
                for(int i=0; i<5; i++) {
                    rg[i] = (RadioGroup)findViewById((R.id.radioGroup1)+i);
                    rd[i] = (RadioButton)findViewById(rg[i].getCheckedRadioButtonId());
                    selectedValue[i] = rd[i].getText().toString(); // 해당 라디오버튼 객체의 값 가져오기
                }
                //firebase에 입력
                for(int i=0; i<5; i++) {
                    databaseReference.child("userData").child(uid).child("type"+(i+1)).setValue(selectedValue[i]);
                }
                databaseReference.child("userData").child(uid).child("profilePic").setValue("기본값");
                databaseReference.child("userData").child(uid).child("cnt").setValue(0);

                Intent i=new Intent(AskActivity.this, MainActivity.class);
               startActivity(i);
                }

        });

    }


}