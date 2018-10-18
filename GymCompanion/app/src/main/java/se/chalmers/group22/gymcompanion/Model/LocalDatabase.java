package se.chalmers.group22.gymcompanion.Model;

import android.content.Context;
import android.util.Log;
import se.chalmers.group22.gymcompanion.Model.Exercises.Exercise;
import se.chalmers.group22.gymcompanion.Model.Exercises.StrengthExercise;
import se.chalmers.group22.gymcompanion.R;

import java.io.*;
import java.util.List;

public class LocalDatabase {
    private static final String FILENAME = "database.txt";

    private static LocalDatabase localDatabase;

    private Parser parser;

    private LocalDatabase(){
        parser = new Parser();
        parser.parseJson();
    }

    public static LocalDatabase getInstance(){
        if(localDatabase == null){
            localDatabase = new LocalDatabase();
        }
        return localDatabase;
    }

    public void saveUser(User user){
        FileOutputStream fos;
        ObjectOutputStream os;
        try{
            //fos = new FileOutputStream("raw/user.ser");
            fos = GymCompanionContext.getContext().openFileOutput(FILENAME, Context.MODE_PRIVATE);
            os = new ObjectOutputStream(fos);
            os.writeObject(user);
            os.close();
            fos.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public User loadUser(){
        User loadedUser = null;
        FileInputStream fis;
        ObjectInputStream is;
        try{
            fis = GymCompanionContext.getContext().openFileInput(FILENAME);
            //fis = GymCompanionContext.getContext().getResources().openRawResource(R.raw.user);
            is = new ObjectInputStream(fis);
            loadedUser = (User) is.readObject();
            is.close();
            fis.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        if(loadedUser == null){
            User user = new User("Unknown User", "Unknown Gym", 1, 1, true);
            Routine r1 = new Routine();
            Exercise e1 = new StrengthExercise("Test Exercise", 2);
            r1.addExercise(e1);
            user.addRoutine(r1);
            user.finishRoutine(r1);
            saveUser(user);
            return user;
        }

        return loadedUser;
    }

    public List<Exercise> loadTotalExercises(){
        return parser.getExercises();
    }

    public List<Routine> loadTotalRoutines(){
        return parser.getRoutines();
    }
}
