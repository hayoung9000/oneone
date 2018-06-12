package kr.hs.e_mirim.bomi0324.dongwhapiece;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;


/**
 * Created by LG on 2017-11-07.
 */
public class f_MypageActivity extends Fragment implements View.OnClickListener {
    Button back;
    String uid;
    private String nameStr, tagStrAll;
    private String tagStr[]=new String[6];
    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference nameView;
    private DatabaseReference tagView[]=new DatabaseReference[5];
    private Button wantSee;
    private TextView name,tag;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView=(ViewGroup)inflater.inflate(R.layout.fragment_mypage, container, false);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
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

        nameView=databaseReference.child("userData").child(uid).child("nickname");
        tagView[0]=databaseReference.child("userData").child(uid).child("type1");
        tagView[1]=databaseReference.child("userData").child(uid).child("type2");
        tagView[2]=databaseReference.child("userData").child(uid).child("type3");
        tagView[3]=databaseReference.child("userData").child(uid).child("type4");
        tagView[4]=databaseReference.child("userData").child(uid).child("type5");



        wantSee=(Button)rootView.findViewById(R.id.wantSee);
        name=(TextView)rootView.findViewById(R.id.nameText);
        tag=(TextView)rootView.findViewById(R.id.tagText);


        wantSee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddbookActivity.class);
                startActivity(intent);
            }
        });
        //밑에는 인기순 추천순처럼 나타나지만 sum을 찾아서 나타낸다.
        return rootView;
    }

    @Override
    public void onClick(View view) {

    }
    @Override
    public void onStart() {
        super.onStart();
        nameView.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                nameStr=dataSnapshot.getValue(String.class);
                name.setText(nameStr);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });

        tagView[0].addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tagStr[0]=dataSnapshot.getValue(String.class);
                tagStr[5]="#"+tagStr[0];
            }
            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });

        tagView[1].addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tagStr[1]=dataSnapshot.getValue(String.class);
                tagStr[5]+=" #"+tagStr[1];
            }
            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });

        tagView[2].addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tagStr[2]=dataSnapshot.getValue(String.class);
                tagStr[5]+=" #"+tagStr[2];
            }
            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });

        tagView[3].addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tagStr[3]=dataSnapshot.getValue(String.class);
                tagStr[5]+=" #"+tagStr[3];
            }
            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });

        tagView[4].addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tagStr[4]=dataSnapshot.getValue(String.class);
                tagStr[5]+=" #"+tagStr[4];
                Toast.makeText(getActivity(), tagStr[5], Toast.LENGTH_SHORT).show();
                tag.setText(tagStr[5]);

            }
            @Override
            public void onCancelled(DatabaseError databaseError) { }
        });

    }


}