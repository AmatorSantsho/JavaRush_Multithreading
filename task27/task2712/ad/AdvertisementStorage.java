package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 123 on 30.09.2017.
 */
public class AdvertisementStorage {
    private static AdvertisementStorage advertisementStorage;
    private  final List<Advertisement> videos = new ArrayList<>();

    public List<Advertisement> list(){
        return videos;
    }
    public  void add(Advertisement advertisement){
        videos.add(advertisement);
    }

    private AdvertisementStorage() {
        Object someContent = new Object();
        new Advertisement(someContent, "First Video", 5000, 100, 3 * 60);
        new Advertisement(someContent, "Second Video", 100, 10, 15 * 60);
        new Advertisement(someContent, "Third Video", 400, 2, 10 * 60);


    }
    public static AdvertisementStorage getInstance(){
        if (advertisementStorage==null){
            advertisementStorage=new AdvertisementStorage();
        return advertisementStorage;}
        else return advertisementStorage;
    }
}
