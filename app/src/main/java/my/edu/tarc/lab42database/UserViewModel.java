package my.edu.tarc.lab42database;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

//TODO 7: Create an Android View Model class to link data to UI

public class UserViewModel extends AndroidViewModel {
    private UserRepository userRepository;
    private LiveData<List<User>> allUsers; // A cache copy of record

    public UserViewModel(@NonNull Application application) {
        super(application);
        //Create an instance of repository
        userRepository = new UserRepository(application);
        //Retrieve all user records and store in LiveData
        allUsers = userRepository.getAllUsers();
    }

    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public  void insertUser(User user){
        userRepository.insertUser(user);
    }
}
