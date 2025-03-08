package com.example.ys_task_mostafaameen.Hilt;

import com.example.ys_task_mostafaameen.data.Repositorys.LoginRepository;
import com.example.ys_task_mostafaameen.data.Retrofit.LoginApi;
import com.example.ys_task_mostafaameen.data.Room.User.Dao.UserDao;
import com.example.ys_task_mostafaameen.data.Room.User.Helpers.UserDatabaseHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class LoginRepositoryModule {
    @Provides
    @Singleton
    public static UserDatabaseHelper provideUserDatabaseHelper(UserDao userDao) {
        return new UserDatabaseHelper(userDao);
    }

    @Provides
    @Singleton
    public static LoginRepository provideLoginRepository(
            LoginApi loginApi,
            UserDatabaseHelper userDatabaseHelper
    ) {
        return new LoginRepository(loginApi, userDatabaseHelper);
    }
}
