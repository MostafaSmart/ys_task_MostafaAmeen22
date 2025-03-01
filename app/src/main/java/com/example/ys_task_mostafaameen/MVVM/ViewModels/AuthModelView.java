package com.example.ys_task_mostafaameen.MVVM.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ys_task_mostafaameen.data.model.RequestModels.Login.LoginRequest;
import com.example.ys_task_mostafaameen.data.model.ResponseModels.Login.LoginData;
import com.example.ys_task_mostafaameen.data.model.ResponseModels.Login.LoginResponse;
import com.example.ys_task_mostafaameen.data.Repositorys.LoginRepository;
import com.example.ys_task_mostafaameen.data.model.ResponseModels.ResponseBaseModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AuthModelView extends ViewModel {


    private MutableLiveData<ResponseBaseModel<LoginData>> loginResponse = new MutableLiveData<>();
    private final LoginRepository userRepository;

    @Inject
    public AuthModelView(LoginRepository userRepository) {
        this.userRepository = userRepository;
    }


    public void login (LoginRequest authRequest){
        userRepository.login(authRequest).observeForever(authResponse -> loginResponse.setValue(authResponse));
    }




    public LiveData<ResponseBaseModel<LoginData>> getLoginResponse() {
        return loginResponse;
    }

}
