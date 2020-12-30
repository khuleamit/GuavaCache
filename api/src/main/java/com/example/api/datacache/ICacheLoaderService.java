package com.example.api.datacache;

public interface ICacheLoaderService<T> {

    //This interface provides a way to implement common methode in all services wish to implement LoadingCache

    T getBackendData(String id);

}