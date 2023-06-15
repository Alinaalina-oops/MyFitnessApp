package com.example.myapplication1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication1.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    String[] genders = {"Женщина", "Мужчина"};
    String[] levels = {"Лёгкий", "Средний", "Сложный"};
    public SharedPreferences sharedPreferences;
    private static final String PREFS_FILE = "Account";


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);

        Spinner spinner =  binding.getRoot().findViewById(R.id.genders_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, genders);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Spinner spinner_levels =  binding.getRoot().findViewById(R.id.spinner_level);
        ArrayAdapter<String> adapter_levels = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, levels);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner_levels.setAdapter(adapter_levels);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String item = (String)parent.getItemAtPosition(position);
                MainActivity mainActivity = (MainActivity)  getActivity();
                mainActivity.setGender(position == 1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);

        AdapterView.OnItemSelectedListener itemSelectedListener2 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String item = (String)parent.getItemAtPosition(position);
                MainActivity mainActivity = (MainActivity)  getActivity();
                if (position == 0)
                    mainActivity.setLevel("Лёгкий");
                else
                    if (position == 1)
                        mainActivity.setLevel("Средний");
                    else
                        mainActivity.setLevel("Сложный");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner_levels.setOnItemSelectedListener(itemSelectedListener2);

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ((TextInputLayout)binding.getRoot().findViewById(R.id.textInputLayout))
                        .getEditText().getText().toString();
                String age = ((TextInputLayout)binding.getRoot().findViewById(R.id.textInputLayout2))
                        .getEditText().getText().toString();
                String weight = ((TextInputLayout)binding.getRoot().findViewById(R.id.textInputLayout3))
                        .getEditText().getText().toString();
                String height = ((TextInputLayout)binding.getRoot().findViewById(R.id.textInputLayout4))
                        .getEditText().getText().toString();
                if (!name.isEmpty() && !age.isEmpty() && !weight.isEmpty() && !height.isEmpty())
                {
                    User currentUser = new User();

                    currentUser.setHeight(Integer.parseInt(height));
                    currentUser.setName(name);
                    currentUser.setWeight(Integer.parseInt(weight));
                    currentUser.setAge(Integer.parseInt(age));
                    MainActivity mainActivity = (MainActivity)  getActivity();
                    currentUser.isMale = mainActivity.getGender();
                    currentUser.setLevel(mainActivity.getLevel());

                    sharedPreferences = getActivity().getSharedPreferences(PREFS_FILE, Context.MODE_PRIVATE);

                    int count = sharedPreferences.getInt("userCount", 0);
                    currentUser.Id = count;
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("user"+count, currentUser.toString());
                    editor.putInt("userCount", count + 1);
                    editor.commit();
                }

                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}