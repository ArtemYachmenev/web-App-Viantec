package com.viantec.web.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.viantec.web.R;

public class WebFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_web,container, false);

    }
    public void setSelectedItem(String selectedItem) {
        TextView view = getView().findViewById(R.id.titleTextView);
        view.setText(selectedItem);
        view.setText(("title"));
    }
}
