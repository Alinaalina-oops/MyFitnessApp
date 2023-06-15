package com.example.myapplication1;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SimpleCursorAdapter;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication1.databinding.ActivityMainBinding;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static boolean Head;
    public static boolean Ache;
    public static int Puls;
    public static int Weight;
    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;
    private static User currentUser = null;
    private static boolean isMale = false;
    private static String Level = "Лёгкий";
    public int currentTraining = 1;
    public int currentCategory = 1;
    public static int UserTired = 0;

    public boolean getGender() {
        return isMale;
    }

    public static SharedPreferences sharedPreferences;
    private static final String PREFS_FILE = "Account";
    static DatabaseHelper databaseHelper;
    static SQLiteDatabase db;
    Cursor userCursor;
    SimpleCursorAdapter userAdapter;

    public static String getLevel() {
        return Level;
    }

    public static void setLevel(String level) {
        Level = level;
    }

    public static void superSetLevel(String level) {
        currentUser.setLevel(level);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user" + currentUser.Id, currentUser.toString());
        editor.commit();
    }

    public static void superSetUser(String user) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("user" + currentUser.Id, user.toString());
        editor.commit();
    }

    public void setGender(boolean value) {
        if (isMale != value) {
            isMale = value;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);


        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        databaseHelper = new DatabaseHelper(getApplicationContext());
    }

    public void addUserStats()
    {
        db = databaseHelper.open();
        String pattern = "MM/dd/yyyy HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);
        Date currentTime = Calendar.getInstance().getTime();
        db.execSQL("INSERT INTO UserMetrics(TrainingDate, Pulse, Weight, UserID)" +
                " VALUES (\"" + df.format(currentTime) + "\", " + Puls + ", " + Weight + ", " + currentUser.Id + ");");
    }

    public ArrayList<UserStats> getUserStats() throws ParseException {
        db = databaseHelper.open();

        Integer userId = currentUser.Id;
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.ENGLISH);
        ArrayList<UserStats> stats = new ArrayList<>();
        String query = String.format("SELECT * FROM UserMetrics " +
                "WHERE UserId = "+ userId + ";");
        Cursor cursor = db.rawQuery(query, null);
        while (cursor.moveToNext()){
            UserStats stat = new UserStats();
            Integer pulseString = cursor.getColumnIndex("Pulse");
            stat.Pulse = cursor.getInt(pulseString);
            Integer weightString = cursor.getColumnIndex("Weight");
            stat.Weight = cursor.getInt(weightString);
            Integer dataString = cursor.getColumnIndex("TrainingDate");
            String year = cursor.getString(dataString);
            stat.TrainingDate = formatter.parse(year);
            stats.add(stat);
        }
        cursor.close();
        return  stats;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public void setCurrentUser(User user) {
        currentUser = user;
        setGender(currentUser.isMale);
        setLevel(currentUser.getLevel());
    }

    public User getCurrentUser() {
        return currentUser;
    }
}