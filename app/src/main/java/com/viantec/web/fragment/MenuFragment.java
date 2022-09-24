package com.viantec.web.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.viantec.web.R;
import com.viantec.web.RecyclerViewAdapter;
import com.viantec.web.RecyclerViewItem;
import com.viantec.web.WebActivity;

import java.util.ArrayList;

public class MenuFragment extends Fragment {
    private ArrayList<RecyclerViewItem> arrayList;
 public    interface OnFragmentSendDataListener {
        void onSendData(String data);
    }

    private OnFragmentSendDataListener fragmentSendDataListener;



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            fragmentSendDataListener = (OnFragmentSendDataListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()
                    + " должен реализовывать интерфейс OnFragmentInteractionListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         RecyclerView recyclerView;





        ArrayList<RecyclerViewItem> recyclerViews=new ArrayList<>();
        recyclerViews.add(new RecyclerViewItem(R.drawable.ic_baseline_announcement_24,"Уведомления"));
        recyclerViews.add(new RecyclerViewItem(R.drawable.ic_baseline_home_24,"Меню"));
        recyclerViews.add(new RecyclerViewItem(R.drawable.ic_baseline_input_24,"Запросы БД"));
        recyclerViews.add(new RecyclerViewItem("Анекдоты"));
        recyclerViews.add(new RecyclerViewItem("Фоточки"));





        View view = inflater.inflate(R.layout.recycler_view_item, container, false);
        // получаем элемент ListView
        ListView countriesList = view.findViewById(R.id.textView1);
        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, recyclerViews);
        // устанавливаем для списка адаптер
        countriesList.setAdapter(adapter);
        // добавляем для списка слушатель
        countriesList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                // получаем выбранный элемент
                String selectedItem = (String)parent.getItemAtPosition(position);
                // Посылаем данные Activity
                fragmentSendDataListener.onSendData(selectedItem);
            }
        });
        return view;
    }
}
