package com.example.ys_task_mostafaameen.MVVM.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ys_task_mostafaameen.data.model.RequestModels.Login.LoginRequest;
import com.example.ys_task_mostafaameen.data.model.ResponseModels.Login.LoginResponse;
import com.example.ys_task_mostafaameen.data.Repositorys.LoginRepository;

public class AuthModelView extends ViewModel {


    private MutableLiveData<LoginResponse> loginResponse;
    private LoginRepository userRepository;

    public AuthModelView(LoginRepository userRepository) {
        this.loginResponse = new MutableLiveData<>();
        this.userRepository=userRepository;
    }

    public void login (LoginRequest authRequest){
        userRepository.login(authRequest).observeForever(authResponse -> loginResponse.setValue(authResponse));
    }




    public LiveData<LoginResponse> getLoginResponse() {
        return loginResponse;
    }

}
