package com.example.myapplication1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication1.databinding.FragmentThirdBinding;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Base64;

public class ThirdFragment extends Fragment {

    private FragmentThirdBinding binding;
    public SharedPreferences sharedPreferences;
    private static final String PREFS_FILE = "Account";
    private static final String PREF_NAME = "Name";
    private static final String PREF_USERS = "User";

    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentThirdBinding.inflate(inflater, container, false);

        GetUsersToUsersSpinner();

        return binding.getRoot();

    }

    private void GetUsersToUsersSpinner() {
        ArrayList<User> users = getUsers();

        String[] userNames = new String[users.toArray().length];

        int ind = 0;
        for (User user:
             users) {
            userNames[ind] = user.getName();
            ind++;
        }

        Spinner spinner =  binding.getRoot().findViewById(R.id.users_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, userNames);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String item = (String)parent.getItemAtPosition(position);
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.setCurrentUser(users.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);
    }

    private ArrayList<User> getUsers() {
        sharedPreferences = getActivity().getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);
        int count = sharedPreferences.getInt("userCount", 0);
        ArrayList<User> users = new ArrayList<>();
        for (int i=0; i < count; i++)
        {
            String userString = sharedPreferences.getString("user" + i, "");
            User tempUser = new User();
            String[] userFields = userString.split(",");
            tempUser.setName(userFields[0]);
            tempUser.setWeight(Integer.parseInt(userFields[1]));
            tempUser.setHeight(Integer.parseInt(userFields[2]));
            tempUser.setAge(Integer.parseInt(userFields[3]));
            tempUser.isMale = Boolean.parseBoolean(userFields[4]);
            tempUser.setLevel(userFields[5]);
            tempUser.Id = Integer.parseInt(userFields[6]);
            users.add(tempUser);
        }

        return users;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private static Object fromString(String s ) throws IOException ,
            ClassNotFoundException {
        byte [] data = Base64.getDecoder().decode( s );
        ObjectInputStream ois = new ObjectInputStream(
                new ByteArrayInputStream(  data ) );
        Object o  = ois.readObject();
        ois.close();
        return o;
    }
    /** Write the object to a Base64 string. */
    @RequiresApi(api = Build.VERSION_CODES.O)
    private static String toString(Serializable o ) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream( baos );
        oos.writeObject( o );
        oos.close();
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_ThirdFragment_to_FirstFragment);
            }
        });
        binding.button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.usersSpinner.performClick();
                NavHostFragment.findNavController(ThirdFragment.this)
                        .navigate(R.id.action_ThirdFragment_to_SecondFragment);
            }
        });
        binding.button12.setOnClickListener(new View.OnClickListener() {
            //удаление юзеров
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) getActivity();
                User user = mainActivity.getCurrentUser();
                int targetId = -1;
                ArrayList<User> users = getUsers();
                for (int i=0; i < users.size(); i++)
                {
                    if (users.get(i).equals(user))
                    {
                        targetId = i;
                        break;
                    }
                }
                if (targetId != -1)
                {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.remove("user" + targetId);
                    int count = sharedPreferences.getInt("userCount", 0);
                    for (int i = targetId; i < count - 1; i++)
                    {
                        int tempI = i + 1;
                        String tempUser = sharedPreferences.getString("user" + tempI, "");
                        editor.putString("user" + i, tempUser);
                    }
                    editor.remove("userCount");
                    editor.putInt("userCount", count - 1);
                    editor.apply();
                    GetUsersToUsersSpinner();
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
