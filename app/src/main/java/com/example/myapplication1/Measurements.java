package com.example.myapplication1;


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

import com.example.myapplication1.databinding.MeasurementsBinding;

public class Measurements extends Fragment {
    private MeasurementsBinding binding;

    private static String[] spinnerItems = new String[] { "Нет", "Да" };
    String[] tired = {"1", "2","3", "4","5"};

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = MeasurementsBinding.inflate(inflater, container, false);

        Measurements measurements = (Measurements) getFragmentManager().findFragmentById(R.id.Measurements);
        Spinner spinnerHead =  binding.getRoot().findViewById(R.id.head_spinner);
        Spinner spinnerAche =  binding.getRoot().findViewById(R.id.ache_spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, spinnerItems);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerHead.setAdapter(adapter);
        spinnerAche.setAdapter(adapter);


        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String item = (String)parent.getItemAtPosition(position);
                MainActivity mainActivity = (MainActivity)  getActivity();
                mainActivity.Head = position == 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinnerHead.setOnItemSelectedListener(itemSelectedListener);


        AdapterView.OnItemSelectedListener itemSelectedListener2 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String item = (String)parent.getItemAtPosition(position);
                MainActivity mainActivity = (MainActivity)  getActivity();
                mainActivity.Ache = position == 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinnerAche.setOnItemSelectedListener(itemSelectedListener2);

        Spinner spinnerDig =  binding.getRoot().findViewById(R.id.spinner);
        ArrayAdapter<String> adapter2 = new ArrayAdapter(this.getActivity(), android.R.layout.simple_spinner_item, tired);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDig.setAdapter(adapter2);
        AdapterView.OnItemSelectedListener itemSelectedListener3 = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String item = (String)parent.getItemAtPosition(position);
                MainActivity mainActivity = (MainActivity)  getActivity();
                int tired = position + 1;
                mainActivity.UserTired = tired;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinnerDig.setOnItemSelectedListener(itemSelectedListener3);

        return binding.getRoot();
    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        MainActivity mainActivity = (MainActivity) getActivity();

        binding.button23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String weight = ((TextInputLayout)binding.getRoot().findViewById(R.id.textInputLayout6))
                        .getEditText().getText().toString();
                String puls = ((TextInputLayout)binding.getRoot().findViewById(R.id.textInputLayout5))
                        .getEditText().getText().toString();
                MainActivity mainActivity = (MainActivity)  getActivity();
                mainActivity.Weight = Integer.parseInt(weight);
                mainActivity.Puls = Integer.parseInt(puls);
                NavHostFragment.findNavController(Measurements.this)
                        .navigate(R.id.action_Measurements_to_ThirdTraining);
                mainActivity.addUserStats();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
  }
