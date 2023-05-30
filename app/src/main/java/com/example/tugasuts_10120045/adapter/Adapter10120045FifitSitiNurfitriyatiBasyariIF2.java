package com.example.tugasuts_10120045.adapter;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tugasuts_10120045.R;
import com.example.tugasuts_10120045.model.Data10120045FifitSitiNurfitriyatiBasyariIF2;

import org.w3c.dom.Text;

import java.util.List;

public class Adapter10120045FifitSitiNurfitriyatiBasyariIF2 extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Data10120045FifitSitiNurfitriyatiBasyariIF2> lists;

    public Adapter10120045FifitSitiNurfitriyatiBasyariIF2(Activity activity, List<Data10120045FifitSitiNurfitriyatiBasyariIF2> list) {
        this.activity = activity;
        this.lists = lists;

    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int i) {
        return lists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (inflater == null) {
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        }
        if (view == null && inflater != null) {
            view = inflater.inflate(R.layout.list_users, null);

        }
        if (view != null) {
            TextView name = view.findViewById(R.id.text_name);
            TextView email = view.findViewById(R.id.text_email);
            Data10120045FifitSitiNurfitriyatiBasyariIF2 data = lists.get(i);
            name.setText(data.getNama());
            email.setText(data.getEmail());

            return view;
        }
        return view;
    }
}
