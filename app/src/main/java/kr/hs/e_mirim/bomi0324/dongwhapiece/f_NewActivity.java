package kr.hs.e_mirim.bomi0324.dongwhapiece;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class f_NewActivity extends Fragment  {
    Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_10;

    private View view;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView=(ViewGroup)inflater.inflate(R.layout.activity_chu, container, false);


        btn_1 = (Button) rootView.findViewById(R.id.btn1);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Book_alActivity.class);
                startActivity(intent);
            }
        });
        btn_2 = (Button) rootView.findViewById(R.id.btn2);
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Book_eActivity.class);
                startActivity(intent);
            }
        });
        btn_3 = (Button) rootView.findViewById(R.id.btn3);
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Book_umActivity.class);
                startActivity(intent);
            }
        });
        btn_4 = (Button) rootView.findViewById(R.id.btn4);
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Book_jiActivity.class);
                startActivity(intent);
            }
        });
        btn_5 = (Button) rootView.findViewById(R.id.btn5);
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Book_fActivity.class);
                startActivity(intent);
            }
        });
        btn_6 = (Button) rootView.findViewById(R.id.btn6);
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Book_ahActivity.class);
                startActivity(intent);
            }
        });
        btn_7 = (Button) rootView.findViewById(R.id.btn7);
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Book_halActivity.class);
                startActivity(intent);
            }
        });
        btn_8 = (Button) rootView.findViewById(R.id.btn8);
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Book_hangActivity.class);
                startActivity(intent);
            }
        });
        btn_9 = (Button) rootView.findViewById(R.id.btn9);
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Book_woActivity.class);
                startActivity(intent);
            }
        });
        btn_10 = (Button) rootView.findViewById(R.id.btn10);
        btn_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Book_julActivity.class);
                startActivity(intent);
            }
        });
        return rootView;
    }


}
