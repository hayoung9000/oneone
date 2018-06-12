package kr.hs.e_mirim.bomi0324.dongwhapiece;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by dbwlt on 2017-11-22.
 */

public class AddbookActivity extends AppCompatActivity{
    private FirebaseAuth mAuth;
    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;
    private EditText wantBook;
    private String  sum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbook);
       // requestWindowFeature(Window.FEATURE_NO_TITLE);
        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference();
       // this.setFinishOnTouchOutside(false);;

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        wantBook=(EditText)findViewById(R.id.wantBook);
        Button submitBtn = (Button)findViewById(R.id.submit);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sum= wantBook.getText().toString();
                if (sum.length() == 0 ) {
                    Toast.makeText(getApplicationContext(), "책 제목을 입력해주세요 !", Toast.LENGTH_SHORT).show();
                } else {
                    databaseReference.child("bookData").child(sum).child("출판사").setValue("출판사값");
                    databaseReference.child("bookData").child(sum).child("작가").setValue("작가값");
                    databaseReference.child("bookData").child(sum).child("사진").setValue("사진넣기");
                    databaseReference.child("bookData").child(sum).child("태그1").setValue("태그");
                    databaseReference.child("bookData").child(sum).child("태그2").setValue("태그");
                    databaseReference.child("bookData").child(sum).child("태그3").setValue("태그");
                    databaseReference.child("bookData").child(sum).child("태그4").setValue("태그");
                    databaseReference.child("bookData").child(sum).child("태그5").setValue("태그");
                    databaseReference.child("bookData").child(sum).child("제목").setValue("제목넣기");
                    Toast.makeText(getApplicationContext(), "책 신청이 완료되었습니다 !", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}