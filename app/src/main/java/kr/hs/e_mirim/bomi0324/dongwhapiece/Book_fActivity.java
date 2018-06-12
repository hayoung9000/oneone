package kr.hs.e_mirim.bomi0324.dongwhapiece;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Student on 2017-11-09.
 */

public class Book_fActivity extends AppCompatActivity {
    int pl=0;
    Button left, right, binlike;
    LinearLayout background;
    int[] imgs = {R.drawable.fstart, R.drawable.f1, R.drawable.f2, R.drawable.f3, R.drawable.f4, R.drawable.f5,
            R.drawable.f6, R.drawable.f7, R.drawable.f8, R.drawable.f9, R.drawable.f10};
    int cnt=0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.f);
        left=(Button)findViewById(R.id.left);
        right=(Button)findViewById(R.id.right);
        binlike=(Button)findViewById(R.id.binlike);
        background=(LinearLayout)findViewById(R.id.backgroundf);
        background.setBackgroundResource(R.drawable.fstart);

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cnt!=0) cnt--;
                background.setBackgroundResource(imgs[cnt]);
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cnt<(imgs.length-1)) {
                    cnt++;
                    background.setBackgroundResource(imgs[cnt]);
                }
            }
        });
        binlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pl%2==0)binlike.setBackgroundResource(R.drawable.like);
                else binlike.setBackgroundResource(R.drawable.binlike);
                pl++;
            }
        });

        Button btn_prev =(Button)findViewById(R.id.back);
        btn_prev.setOnClickListener(new Button.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(Book_fActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
