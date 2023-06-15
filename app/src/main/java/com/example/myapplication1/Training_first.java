package com.example.myapplication1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication1.databinding.FragmentTrainFirstBinding;

public class Training_first extends Fragment {

    private FragmentTrainFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentTrainFirstBinding.inflate(inflater, container, false);

        Training_first training_first = (Training_first) getFragmentManager().findFragmentById(R.id.Training_first);
        return binding.getRoot();}

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Training_first.this)
                        .navigate(R.id.action_FirstTraining_to_SecondTraining);
            }
        });
        binding.myButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Training_first.this)
                        .navigate(R.id.action_FirstTraining_to_Profile);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}