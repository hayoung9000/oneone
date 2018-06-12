package kr.hs.e_mirim.bomi0324.dongwhapiece;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import kr.hs.e_mirim.bomi0324.dongwhapiece.MainActivity;

/**
 * Created by LG on 2017-11-10.
 */

public class IntroActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro); // xml과 java소스를 연결
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), JoinActivity.class);
                startActivity(intent); // 다음화면으로 넘어가기
                finish();
            }
        },2000);
    } // end of onCreate


}