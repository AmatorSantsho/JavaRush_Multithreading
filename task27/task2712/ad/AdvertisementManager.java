package com.javarush.task.task27.task2712.ad;

import com.javarush.task.task27.task2712.ConsoleHelper;

/**
 * Created by 123 on 30.09.2017.
 */
public class AdvertisementManager {
    private final AdvertisementStorage storage =AdvertisementStorage.getInstance();
    private int timeSeconds;

    public AdvertisementManager(int timeSeconds) {
        this.timeSeconds = timeSeconds;
    }
   public void processVideos() throws NoVideoAvailableException {
      if(storage.list().isEmpty())
          throw new NoVideoAvailableException();
   }
}
