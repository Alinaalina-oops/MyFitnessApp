package com.example.myapplication1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication1.databinding.FragmentTrainThirdBinding;

public class Training_third extends Fragment {

    private FragmentTrainThirdBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentTrainThirdBinding.inflate(inflater, container, false);

        Training_third training_third = (Training_third) getFragmentManager().findFragmentById(R.id.Training_third);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Training_third.this)
                        .navigate(R.id.action_ThirdTraining_to_SecondFragment);
            }
        });
        MainActivity mainActivity = (MainActivity) getActivity();
        boolean isMale = mainActivity.getGender();
        if (isMale)
        {
        binding.button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Training_third.this)
                        .navigate(R.id.action_ThirdTraining_to_FifthFragment);
            }
        });} else  {
            binding.button18.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    NavHostFragment.findNavController(Training_third.this)
                            .navigate(R.id.action_ThirdTraining_to_FourthFragment);
                }
            });}
        binding.button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
                System.exit(0);
            }
        });
        binding.myButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Training_third.this)
                        .navigate(R.id.action_ThirdTraining_to_Profile);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
