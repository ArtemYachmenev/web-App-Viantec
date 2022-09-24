package com.viantec.web.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.viantec.web.R;

public class ListFragment extends Fragment {

//    @Override
//    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
//        String[] links = getResources().getStringArray(R.array.tut_links);
//
//        String content = links[position];
//        Intent showContent = new Intent(getActivity().getApplicationContext(),
//                TutViewerActivity.class);
//        showContent.setData(Uri.parse(content));
//        startActivity(showContent);
//    }

//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recycler_view, null);
    }
}
