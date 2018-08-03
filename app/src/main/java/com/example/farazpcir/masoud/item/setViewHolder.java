package com.example.farazpcir.masoud.item;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.farazpcir.masoud.R;

/**
 * Created by farazpc.ir on 26/08/2016.
 */
public class setViewHolder extends RecyclerView.ViewHolder {
    public TextView txtname;
    public ImageView txtpicturename;

    public setViewHolder(View itemView) {
        super(itemView);
        txtname=(TextView)itemView.findViewById(R.id.TVdecribtion);
        txtpicturename=(ImageView)itemView.findViewById(R.id.txtpicturename);
    }
}
