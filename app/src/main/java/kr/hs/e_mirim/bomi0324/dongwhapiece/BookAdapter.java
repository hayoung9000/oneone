package kr.hs.e_mirim.bomi0324.dongwhapiece;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by YookyungJung on 2017-11-21.
 */

public class BookAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<BookItem> data;
    private int layout;

    public BookAdapter(Context context, int layout, ArrayList<BookItem> data) {
        this.inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.data=data;
        this.layout=layout;
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position).getBookName();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null) {
            convertView=inflater.inflate(layout, parent, false);
        }
        BookItem bookItem =data.get(position);

        ImageView profile=(ImageView) convertView.findViewById(R.id.profile);
        profile.setImageResource(bookItem.getProfile());

        TextView bookName=(TextView)convertView.findViewById(R.id.bookName);
        bookName.setText(bookItem.getBookName());

        TextView writer=(TextView)convertView.findViewById(R.id.writer);
        writer.setText(bookItem.getWriter());

        TextView publisher=(TextView)convertView.findViewById(R.id.publisher);
        publisher.setText(bookItem.getPublisher());

        return convertView;
    }
}
