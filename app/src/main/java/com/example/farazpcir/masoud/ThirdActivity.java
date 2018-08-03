package com.example.farazpcir.masoud;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;


public class ThirdActivity extends AppCompatActivity {
    public Map map;
    public Bundle b;
    public TextView txtdecshop,txtadress;
    public ImageView imageView;
    private DatabaseHelper databaseHelper;
    private Cursor cursor;
    public Bundle build;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        imageView=(ImageView) findViewById(R.id.shopmap);
        txtdecshop=(TextView)findViewById(R.id.shoptxtdecribtion);
        txtadress=(TextView) findViewById(R.id.addressshop);
        Button btnmenu=(Button)findViewById(R.id.button2);

        build=new Bundle();
        if(build!=null) {
            build = getIntent().getExtras();
            int who = build.getInt("who");
            if(who==2) {


                Loaddataforeachitemshop();

            }else if(who==1){
                Loadfromres();

            }
        }
    }

    public void Loaddataforeachitemshop() {
        b=new Bundle();
        if (b != null) {
            b = getIntent().getExtras();
            int id = b.getInt("position identifier");

            databaseHelper = new DatabaseHelper(ThirdActivity.this);
            databaseHelper.checkAndCopyDatabase();
            databaseHelper.openDatabase();

            cursor=databaseHelper.QueryData("SELECT  * FROM shoping " );

            if(cursor!=null) {
                if(cursor.moveToPosition(id)) {
                    String txtdecribtion = cursor.getString(cursor.getColumnIndex("decribtion"));

                    String txtadd=cursor.getString(cursor.getColumnIndex("address"));
                    String  txtpic=cursor.getString(cursor.getColumnIndex("picturename"));
                    txtadress.setText(txtadd);

                    txtdecshop.setText(txtdecribtion);
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
                    if (map.containsKey(txtpic)) {
                        imageView.setImageResource((Integer) (map.get(txtpic)));
                    }

                }
            }


        }
    }
    public void Loadfromres(){
        b=new Bundle();
        if (b != null) {
            b = getIntent().getExtras();
            int id = b.getInt("position identifier");

            databaseHelper = new DatabaseHelper(ThirdActivity.this);
            databaseHelper.checkAndCopyDatabase();
            databaseHelper.openDatabase();

            cursor=databaseHelper.QueryData("SELECT  * FROM resturant " );

            if(cursor!=null) {
                if(cursor.moveToPosition(id)) {
                    String txtdecribtion = cursor.getString(cursor.getColumnIndex("describtion"));

                    String txtadd=cursor.getString(cursor.getColumnIndex("address"));
                    String  txtpic=cursor.getString(cursor.getColumnIndex("picturename"));
                    txtadress.setText(txtadd);

                    txtdecshop.setText(txtdecribtion);
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


                    if (map.containsKey(txtpic)) {
                        imageView.setImageResource((Integer) (map.get(txtpic)));
                    }

                }
            }


        }

    }
}
