package kr.hs.e_mirim.bomi0324.dongwhapiece;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YookyungJung on 2017-11-23.
 */

public class Searchsc extends AppCompatActivity {
    private ListView listView;
    private ArrayList<BookItem> data=null;
    ArrayAdapter adapter;
    static boolean calledAlready = false;
    Button back;
    String sum;
    int pl=0;
    int cnt=0;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_list);
        Intent intent =getIntent();
        sum=intent.getStringExtra("sum");
        //밑에는 인기순 추천순처럼 나타나지만 sum을 찾아서 나타낸다.


        listView= (ListView)  findViewById(R.id.book_listview);

        BookAdapter adapter=new BookAdapter(this, R.layout.book_item, data);
        listView.setAdapter(adapter);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseRef = database.getReference("bookData");

        // Read from the database
        databaseRef.child("1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String str[]=new String[5];
                // 클래스 모델이 필요?
                for (DataSnapshot fileSnapshot : dataSnapshot.getChildren()) {
                    //MyFiles filename = (MyFiles) fileSnapshot.getValue(MyFiles.class);
                    //하위키들의 value를 어떻게 가져오느냐???
                    str[0] = fileSnapshot.child("type1").getValue(String.class);
                    str[1] = fileSnapshot.child("type2").getValue(String.class);
                    str[2] = fileSnapshot.child("type3").getValue(String.class);
                    str[3] = fileSnapshot.child("type4").getValue(String.class);
                    str[4] = fileSnapshot.child("type5").getValue(String.class);

                    for(int i=0;i<5;i++) {
                        if (str.equals(str[i])) {
                            BookItem b=new BookItem(R.drawable.profile, (String) fileSnapshot.child("제목").getValue(), (String) fileSnapshot.child("작가").getValue(), (String) fileSnapshot.child("출판사").getValue());
                            data.add(b);
                            break;
                        }
                    }
                   // Log.i("TAG: value is ", str);

                }
                //adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("TAG: ", "Failed to read value", databaseError.toException());
            }
        });
    }
}

