package com.example.ys_task_mostafaameen.MVVM.ModelFactory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.ys_task_mostafaameen.MVVM.ViewModels.AuthModelView;
import com.example.ys_task_mostafaameen.data.Repositorys.LoginRepository;

public class AuthViewModelFactory implements ViewModelProvider.Factory {
private final LoginRepository userRepository;
public AuthViewModelFactory(LoginRepository userRepository) {
        this.userRepository = userRepository;
        }

@NonNull
@Override
public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(AuthModelView.class)) {
        return (T) new AuthModelView(userRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
        }
        }

