package com.example.farazpcir.masoud.item;

/**
 * Created by farazpc.ir on 26/08/2016.
 */
public class item {
    private  String name;
    private String picturename;
    private int id;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setPicturename(String picturename){
        this.picturename=picturename;
    }
    public String getPicturename(){
        return  picturename;
    }
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return  id;
    }
}
