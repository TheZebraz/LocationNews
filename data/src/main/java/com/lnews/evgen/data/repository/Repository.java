package com.lnews.evgen.data.repository;

import com.google.firebase.auth.AuthResult;
import com.lnews.evgen.data.local.Cache;
import com.lnews.evgen.data.network.RestApiService;
import com.lnews.evgen.domain.entities.UserEntity;
import com.lnews.evgen.domain.repository.IRepository;
import io.reactivex.Completable;
import io.reactivex.Emitter;
import io.reactivex.Single;
import javax.inject.Inject;

public class Repository implements IRepository {
    private final RestApiService networkRepository;
    private final Cache cache;

    @Inject
    Repository(RestApiService networkRepository, Cache cache) {
        this.networkRepository = networkRepository;
        this.cache = cache;
    }

    @Override
    public Single<AuthResult> register(String email, String password) {
        return networkRepository.register(email, password).toSingle();
    }

    @Override public Single auth(String email, String password) {
        return networkRepository.auth(email, password).toSingle();
    }

    @Override public Completable sendResetPassRequest(String email) {
        return networkRepository.sendResetRequest(email);
    }

    @Override
    public boolean isAuth() {
        return false;
    }

    @Override
    public boolean isFirstLaunch() {
        return cache.isFirstLaunch();
    }

    @Override
    public void disableFirstLaunch(){
        cache.setFirstLaunch(false);
    }

    @Override public UserEntity getAuthUser() {
        return null; //TODO
    }

    @Override public void setAuthUser(UserEntity user) {
        //TODO
    }
}
