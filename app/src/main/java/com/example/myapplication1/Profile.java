package com.example.myapplication1;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication1.databinding.ProfileBinding;

public class Profile extends Fragment {

    private ProfileBinding binding;
    String[] levels = {"Лёгкий", "Средний", "Сложный"};

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = ProfileBinding.inflate(inflater, container, false);
        MainActivity mainActivity = (MainActivity) getActivity();

        Profile profile = (Profile) getFragmentManager().findFragmentById(R.id.Profile);
        User user = mainActivity.getCurrentUser();
        binding.textView25.setText( user.getName());
        binding.textView25.setEnabled(false);
        binding.textInputLayout7.setHint("" + user.getHeight());
        binding.textInputLayout9.setHint("" + user.getAge());
        binding.textInputLayout10.setHint("" + user.getWeight());

        Spinner spinner_levels =  binding.getRoot().findViewById(R.id.spinnerProfile);
        ArrayAdapter<String> adapter_levels = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, levels);
        adapter_levels.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner_levels.setAdapter(adapter_levels);

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
        int i;
        for (i = 0; i < levels.length; i++)
        {
            if (levels[i].equals(user.getLevel()))
                break;
        }
        spinner_levels.setSelection(i);
        binding.button24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String age = ((TextInputLayout)binding.getRoot().findViewById(R.id.textInputLayout7))
                        .getEditText().getText().toString();
                String weight = ((TextInputLayout)binding.getRoot().findViewById(R.id.textInputLayout9))
                        .getEditText().getText().toString();
                String height = ((TextInputLayout)binding.getRoot().findViewById(R.id.textInputLayout10))
                        .getEditText().getText().toString();
                if (!age.isEmpty() && !weight.isEmpty() && !height.isEmpty())
                {
                    user.setHeight(Integer.parseInt(height));
                    user.setWeight(Integer.parseInt(weight));
                    user.setAge(Integer.parseInt(age));
                    user.setLevel(mainActivity.getLevel());
                    MainActivity mainActivity = (MainActivity)  getActivity();
                    mainActivity.setCurrentUser(user);
                    mainActivity.superSetLevel(user.getLevel());
                }
            }
        });
        binding.imageButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Profile.this)
                        .navigate(R.id.action_Profile_to_Statistics);
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}