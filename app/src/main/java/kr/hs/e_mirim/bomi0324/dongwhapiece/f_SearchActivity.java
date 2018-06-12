package kr.hs.e_mirim.bomi0324.dongwhapiece;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * Created by LG on 2017-11-07.
 */
public class f_SearchActivity extends Fragment{
    Button back;
    Button[] buttags = new Button[8];

    String sum = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ViewGroup rootView=(ViewGroup)inflater.inflate(R.layout.fragment_search,container, false);
        for (int i = 0; i < buttags.length; i++) {
            buttags[i] = (Button)rootView.findViewById(R.id.but1+i);
            buttags[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(), Searchsc.class);
                    Button but = (Button) view;
                    sum += but.getText();
                    intent.putExtra("sum", sum);
                    startActivity(intent);
                    sum = "";
                }
            });
        }
        return rootView;
    }
}