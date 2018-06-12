package kr.hs.e_mirim.bomi0324.dongwhapiece;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

/**
 * Created by Student on 2017-11-09.
 */

public class Book_iActivity extends AppCompatActivity {
    int pl=0;
    Button left, right, binlike;
    LinearLayout background;
    int[] imgs = {R.drawable.istart,R.drawable.i1, R.drawable.i2, R.drawable.i3, R.drawable.i4,
            R.drawable.i5, R.drawable.i6, R.drawable.i7, R.drawable.i8, R.drawable.i9,R.drawable.i10, R.drawable.i11 };
    int cnt=0;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.i);
        left=(Button)findViewById(R.id.left);
        right=(Button)findViewById(R.id.right);
        binlike=(Button)findViewById(R.id.binlike);
        background=(LinearLayout)findViewById(R.id.backgroundi);
        background.setBackgroundResource(R.drawable.istart);

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
                Intent intent = new Intent(Book_iActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}