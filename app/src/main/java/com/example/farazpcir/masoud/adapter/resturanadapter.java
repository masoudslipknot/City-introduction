package com.example.farazpcir.masoud.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.farazpcir.masoud.OnTapListener;
import com.example.farazpcir.masoud.R;
import com.example.farazpcir.masoud.item.item;
import com.example.farazpcir.masoud.item.setViewHolder;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by farazpc.ir on 07/09/2016.
 */
public class resturanadapter  extends RecyclerView.Adapter <setViewHolder> {
    HashMap map;
    List<item> items= Collections.emptyList();
    private OnTapListener onTapListener;
    public resturanadapter(List<item>items){
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
        map.put("powerdad",new Integer(R.drawable.powerdad));
        map.put("karimsons",new Integer(R.drawable.karimsons));
        map.put("daryoush",new Integer(R.drawable.daryoush));
        map.put("mishef",new Integer(R.drawable.mishef));
        map.put("zeytoon2",new Integer(R.drawable.zeytoon2));
        map.put("toranj",new Integer(R.drawable.toranj));
        map.put("moeandarbarii",new Integer(R.drawable.moeandarbarii));
        map.put("khohsar",new Integer(R.drawable.khohsar));
        map.put("altoon",new Integer(R.drawable.altoon));
        map.put("fanoosblue",new Integer(R.drawable.fanoosblue));
        map.put("nasimlobnan",new Integer(R.drawable.nasimlobnan));
        map.put("abnooos",new Integer(R.drawable.abnooos));
        map.put("lioitaly",new Integer(R.drawable.lioitaly));
        map.put("stonemountain",new Integer(R.drawable.stonemountain));
        map.put("ivanshandiz",new Integer(R.drawable.ivanshandiz));
        map.put("solooations",new Integer(R.drawable.solooations));
        map.put("cityfood",new Integer(R.drawable.cityfood));
        map.put("royalcenter",new Integer(R.drawable.royalcenter));
        map.put("bargah",new Integer(R.drawable.bargah));
        map.put("baran",new Integer(R.drawable.baran));

        holder.txtname.setText(items.get(position).getName());
        String image_name=items.get(position).getPicturename();
        if (map.containsKey(image_name)) {
            holder.txtpicturename.setImageResource((Integer) (map.get(image_name))); // not sure so much is necessary...
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
