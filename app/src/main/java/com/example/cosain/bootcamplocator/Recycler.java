package com.example.cosain.bootcamplocator;

/**
 * Created by cosain on 8/15/2017.
 */

public class Recycler {
    private String title, address;
    private int imageUrl;


    public Recycler() {


    }



    public Recycler(String title, String address, int imageUrl){
        this.title = title;
        this.address = address;
        this.imageUrl = imageUrl;


    }

    public int getImageUrl() {
        return imageUrl;
    }

    public String getTitle(){

        return title;
    }

    public void setTitle(String title){

            this.title = title;
    }

    public String getAddress(){
        return address;
    }


    public void setAddress(String address){

        this.address = address;
    }

}