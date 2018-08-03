package com.example.farazpcir.masoud.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.farazpcir.masoud.OnTapListener;
import com.example.farazpcir.masoud.R;
import com.example.farazpcir.masoud.item.item;
import com.example.farazpcir.masoud.item.setViewHolder;
import java.lang.Integer;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class shopadapter extends RecyclerView.Adapter <setViewHolder>{
    public Map map;


    List<item> items= Collections.emptyList();
    private OnTapListener onTapListener;
    public shopadapter(List<item>items){
        this.items=items;

    }
    @Override
    public setViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_recyceler,parent,false);
        return new setViewHolder(view);
    }

    @Override
    public void onBindViewHolder(setViewHolder holder, final int position) {
        map=new HashMap();
        map.put("eastdiamond",new Integer(R.drawable.eastdiamond));
        map.put("ferdowsibazar",new Integer(R.drawable.ferdowsibazar));
        map.put("arman",new Integer(R.drawable.arman));
        map.put("sky",new Integer(R.drawable.sky));
        map.put("bazarreza",new Integer(R.drawable.bazarreza));
        map.put("vesal",new Integer(R.drawable.vesal));
        map.put("zistkhavar",new Integer(R.drawable.zistkhavar));
        map.put("poroma",new Integer(R.drawable.poroma));
        map.put("altoon",new Integer(R.drawable.altoon));
        map.put("caspian",new Integer(R.drawable.caspian));
        map.put("sepad",new Integer(R.drawable.sepad));
        map.put("vilagh",new Integer(R.drawable.vilagh));
        map.put("takcomputer",new Integer(R.drawable.takcomputer));
        map.put("janat",new Integer(R.drawable.janat));
        map.put("bazarbook",new Integer(R.drawable.bazarbook));
        map.put("kiancenter",new Integer(R.drawable.kiancenter));
        map.put("niika",new Integer(R.drawable.niika));
        map.put("khorshid",new Integer(R.drawable.khorshid));
        map.put("ghoharshad",new Integer(R.drawable.ghoharshad));
        map.put("taban",new Integer(R.drawable.taban));
        map.put("mlalbazar",new Integer(R.drawable.mlalbazar));
        map.put("salman",new Integer(R.drawable.salman));
        map.put("bazarhafez",new Integer(R.drawable.bazarhafez));
        map.put("mahtabbook",new Integer(R.drawable.mahtabbook));
        map.put("omid",new Integer(R.drawable.omid));
        map.put("khorasanart",new Integer(R.drawable.khorasanart));
        map.put("shrivar",new Integer(R.drawable.shrivar));
        map.put("noghan",new Integer(R.drawable.noghan));
        holder.txtname.setText(items.get(position).getName());
        String image_name=items.get(position).getPicturename();

        if (map.containsKey(image_name)) {
            holder.txtpicturename.setImageResource((Integer) (map.get(image_name)));
        }


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onTapListener!=null){
                    onTapListener.OnTapView(position);
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return items.size();
    }
    public void setOnTapListener(OnTapListener onTapListener){
        this.onTapListener=onTapListener;

    }
}
