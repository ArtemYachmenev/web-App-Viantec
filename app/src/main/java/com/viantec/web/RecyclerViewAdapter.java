package com.viantec.web;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

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
           context.getApplicationContext();

        //    context.startActivity(intent);

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
        RecyclerViewHolder recyclerViewHolder=new RecyclerViewHolder(view);
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
