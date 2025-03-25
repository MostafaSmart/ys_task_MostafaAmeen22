package com.example.ys_task_mostafaameen.UI.auth;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.ys_task_mostafaameen.data.model.RequestModels.BaseRequest;
import com.example.ys_task_mostafaameen.data.model.RequestModels.Login.LoginValue;
import com.example.ys_task_mostafaameen.data.model.ResponseModels.Login.LoginData;
import com.example.ys_task_mostafaameen.data.Repositorys.LoginRepository;
import com.example.ys_task_mostafaameen.data.model.ResponseModels.ResponseBaseModel;
import com.example.ys_task_mostafaameen.data.model.UserData;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class AuthModelView extends ViewModel {

    private MutableLiveData<UserData> user2Data = new MutableLiveData<>() ;

    private MutableLiveData<ResponseBaseModel<LoginData>> loginResponse = new MutableLiveData<>();

    private final MutableLiveData<Boolean> logoutStatus = new MutableLiveData<>();

    private final LoginRepository userRepository;

    @Inject
    public AuthModelView(LoginRepository userRepository) {
        this.userRepository = userRepository;

        userRepository.getCurrentUser().observeForever(userData -> user2Data.setValue(userData));
    }

    public LiveData<UserData> getCurrentUserLiveData(){
        return user2Data;
    }
    public void login (BaseRequest<LoginValue> authRequest){
        userRepository.login(authRequest).observeForever(authResponse -> {
           if (authResponse.getResult().getErrNo()==0){
               userRepository.insertUserLoacl(authResponse.getData().getUserData());
           }
            loginResponse.setValue(authResponse);
        });
    }

    public LiveData<ResponseBaseModel<LoginData>> getLoginResponse() {
        return loginResponse;
    }

    public void saveUserLocal (UserData userData){
        userRepository.insertUserLoacl(userData);
    }


    public void logout() {
        userRepository.logout(() -> logoutStatus.postValue(true));
    }

    public LiveData<Boolean> getLogoutStatus() {
        return logoutStatus;
    }



}
