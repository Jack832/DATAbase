package com.example.test4.database;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by bridgelabz4 on 18/2/16.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.myholder> {
    //data storage in arraylist
    ArrayList<Recycleid> arrayList=new ArrayList<>();
    public Adapter(ArrayList<Recycleid> idr){
        this.arrayList=idr;

    }
    @Override
    public myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        //setting the layout
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout,parent,false);
        myholder myh= new myholder(view);
        return myh;
    }

    @Override
    public void onBindViewHolder(myholder holder, int position) {
        Recycleid r=arrayList.get(position);


        holder.userid.setText(r.getUserid());

        holder.user.setText(r.getId());

        holder.title.setText(r.getTitle());

    }

    @Override
    //initialize the attribute present on screen
    public int getItemCount() {
        return arrayList.size();
    }
    public static class myholder extends RecyclerView.ViewHolder{
        TextView userid,user,title;

        public myholder(View itemView) {
            super(itemView);
            userid =(TextView)itemView.findViewById(R.id.text1);
            user =(TextView)itemView.findViewById(R.id.text2);
            title =(TextView)itemView.findViewById(R.id.text3);

        }
    }
}
