package com.viantec.web;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.viantec.web.fragment.WebFragmentContacts;
import com.viantec.web.fragment.WebFragmentFiles;
import com.viantec.web.fragment.WebFragmentMenu;
import com.viantec.web.fragment.WebFragmentNotification;
import com.viantec.web.fragment.WebFragmentRequest;

import java.util.ArrayList;
// implements MenuFragment.OnFragmentSendDataListener
public class MainActivity extends AppCompatActivity  {




    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {




        super.onCreate(savedInstanceState);
       // setContentView(R.layout.recycler_view);

        setContentView(R.layout.horizont);



        ArrayList<RecyclerViewItem> recyclerViews=new ArrayList<>();
        recyclerViews.add(new RecyclerViewItem(R.drawable.ic_baseline_announcement_24,"Уведомления"));
        recyclerViews.add(new RecyclerViewItem(R.drawable.ic_baseline_home_24,"Меню"));
        recyclerViews.add(new RecyclerViewItem(R.drawable.ic_baseline_input_24,"Запросы БД"));
        recyclerViews.add(new RecyclerViewItem(R.drawable.ic_baseline_people_24,"Контакты"));
        recyclerViews.add(new RecyclerViewItem(R.drawable.ic_baseline_description_24,"Файлы"));
     //   recyclerViews.add(new RecyclerViewItem(R.drawable.ic_baseline_description_24,"Что-то еще"));

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        adapter=new RecyclerViewAdapter(recyclerViews,this);
        layoutManager=new LinearLayoutManager(this);


        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(layoutManager);

        WebFragmentNotification notification=new WebFragmentNotification();

        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.webFragment,notification);
        ft.commit();

    }


    public  void changeFragment(){

            if (UtilsList.pushFragmentMenu.equals("Уведомления")){
                changeFragmentNotification();
        }
            else if  (UtilsList.pushFragmentMenu.equals("Меню")){
                changeFragmentMenu();
        }
            else if  (UtilsList.pushFragmentMenu.equals("Запросы БД")){
                changeFragmentRequest();
            }
            else if  (UtilsList.pushFragmentMenu.equals("Контакты")){
                changeFragmentContacts();
            }
            else if  (UtilsList.pushFragmentMenu.equals("Файлы")){
                changeFragmentFiles();
            }

    }
    public void changeFragmentNotification(){
        WebFragmentNotification notification=new WebFragmentNotification();

        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.webFragment,notification);
        ft.commit();
    }
    public void changeFragmentMenu(){
        WebFragmentMenu menu=new WebFragmentMenu();

        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.webFragment,menu);
        ft.commit();
    }
    public void changeFragmentRequest(){
        WebFragmentRequest request=new WebFragmentRequest();

        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.webFragment,request);
        ft.commit();
    }
    public void changeFragmentContacts(){
        WebFragmentContacts contacts=new WebFragmentContacts();

        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.webFragment,contacts);
        ft.commit();
    }
    public void changeFragmentFiles(){
        WebFragmentFiles files=new WebFragmentFiles();

        FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.webFragment,files);
        ft.commit();
    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }
//
//    @Override
//    public void onSendData(String selectedItem) {
//        WebFragment fragment = (WebFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.detailFragment);
//        if (fragment != null)
//            fragment.setSelectedItem(selectedItem);
//    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater menuInflater =getMenuInflater();
        menuInflater.inflate(R.menu.user_menu_landscape,menu);
        return true;
    }


    public class RecyclerViewAdapter extends RecyclerView.Adapter <RecyclerViewAdapter.RecyclerViewHolder>{


        private ArrayList<RecyclerViewItem> arrayList;
        Context context;
        private boolean keyClick=false;
        class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            public ImageView imageView;
            public TextView textView1;
            public TextView textView2;


            public RecyclerViewHolder(@NonNull View itemView) {
                super(itemView);
                itemView.setOnClickListener(this);

                imageView=itemView.findViewById(R.id.imageView);
                textView1=itemView.findViewById(R.id.textView1);
                textView2=itemView.findViewById(R.id.textView2);
            }

            @Override
            public void onClick(View view) {
                int position =getAdapterPosition();
                RecyclerViewItem item=arrayList.get(position);


                //  Intent intent=new Intent(context,WebActivity.class);
                //   intent.putExtra("imageResourse",item.getImageResourse());
                //   intent.putExtra("title",item.getText1());


                //  keyClick=true;

                UtilsList.pushFragmentMenu=item.getText1();
                getItem(item);
             //   context.getApplicationContext();
               // System.out.println(UtilsList.pushFragmentMenu);
                //    context.startActivity(intent);




           //     WebFragmentUved uved=new WebFragmentUved();

           //     FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
           //     ft.replace(R.id.webFragment,uved);
            //    ft.commit();

                changeFragment();
            }
        }
        public String  getItem(RecyclerViewItem item){
            return item.getText1();
        }

//    private void getFragment(RecyclerViewItem item) {
//        if (item.getText1().endsWith("Уведомления")){
//
//            WebFragmentUved uved=new WebFragmentUved();
//
//            FragmentTransaction ft=getSupportFragmentManager().beginTransaction;
//        }
//    }

        public RecyclerViewAdapter(ArrayList<RecyclerViewItem> arrayList, Context context){

            this.arrayList=arrayList;
            this.context=context;
        }

        @NonNull
        @Override
        public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_item,
                    parent,false);
           RecyclerViewHolder recyclerViewHolder= new RecyclerViewHolder(view);
            return recyclerViewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

            RecyclerViewItem recyclerViewItem=arrayList.get(position);

            holder.imageView.setImageResource(recyclerViewItem.getImageResourse());
            holder.textView1.setText(recyclerViewItem.getText1());
            holder.textView2.setText(recyclerViewItem.getText2());
        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }





    }


}
