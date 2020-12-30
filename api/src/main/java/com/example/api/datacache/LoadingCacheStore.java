package com.example.api.datacache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class LoadingCacheStore<T> {

    private LoadingCache<String, T> loadingCache;

    //Constructor to build LoadingCache Store instance
    public LoadingCacheStore(int expiryDuration, TimeUnit timeUnit, ICacheLoaderService<T> service) {

        //Note the use of interface ICacheLoaderService here
        //   ICacheLoaderService provides a way to implement a common methode
        //   i.e. --> public T getBackendData(key)
        //   in all services wish to use this LoadingCache

        //This defines a loader (backend service method) which helps LoadingCache
        //LoadingCache uses this loader to load values from backend and store in Cache
        CacheLoader<String, T> loader = new CacheLoader<>() {
            @Override
            public T load(String key) {
                return service.getBackendData(key);
            }
        };

        //This creates a LoadingCache instance using previously defined loader
        //expireAfterWrite specifies the time duration post which Cache entry will be invalidated
        loadingCache = CacheBuilder.newBuilder()
                .expireAfterWrite(expiryDuration, timeUnit)
                .concurrencyLevel(Runtime.getRuntime().availableProcessors())
                .build(loader);

    }

    //Method to fetch previously stored record using record key
    //Record will be fetched from backend Service if not already present in the Cache
    public T get(java.lang.String key) throws ExecutionException {
        return loadingCache.get(key);
    }
}
