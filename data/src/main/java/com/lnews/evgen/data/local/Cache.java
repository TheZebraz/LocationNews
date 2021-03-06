package com.lnews.evgen.data.local;

import com.lnews.evgen.data.local.preferences.IPreferencesStorage;
import com.lnews.evgen.domain.entities.UserEntity;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Cache {

    private final IPreferencesStorage preferencesStorage;

    @Inject
    Cache(IPreferencesStorage preferencesStorage) {
        this.preferencesStorage = preferencesStorage;
    }

    public String getToken(){
        return preferencesStorage.getToken();
    }

    public void setToken(String token){
        preferencesStorage.setToken(token);
    }

    public void setFirstLaunch(boolean isFirstLaunchFlag){
        preferencesStorage.setFirstLaunch(isFirstLaunchFlag);
    }

    public boolean isFirstLaunch(){
        return preferencesStorage.isFirstLaunch();
    }

    public UserEntity getAuthUser(){
        return preferencesStorage.getAuthUser();
    }

    public void setAuthUser(UserEntity user){
        preferencesStorage.setAuthUser(user);
    }

}
