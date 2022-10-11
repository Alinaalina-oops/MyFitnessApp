package com.example.myapplication1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication1.databinding.FragmentFifthBinding;

public class FifthFragment extends Fragment {
    private FragmentFifthBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFifthBinding.inflate(inflater, container, false);

        FifthFragment fifthFragment = (FifthFragment) getFragmentManager().findFragmentById(R.id.FifthFragment);
        return binding.getRoot();}

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.button17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.currentTraining = 1;
                NavHostFragment.findNavController(FifthFragment.this)
                        .navigate(R.id.action_FifthFragment_to_FirstTraining);
            }
        });
        binding.button16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.currentTraining = 5;
                NavHostFragment.findNavController(FifthFragment.this)
                        .navigate(R.id.action_FifthFragment_to_FirstTraining);
            }
        });
        binding.button15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.currentTraining = 3;
                NavHostFragment.findNavController(FifthFragment.this)
                        .navigate(R.id.action_FifthFragment_to_FirstTraining);
            }
        });
        binding.button14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.currentTraining = 4;
                NavHostFragment.findNavController(FifthFragment.this)
                        .navigate(R.id.action_FifthFragment_to_FirstTraining);
            }
        });
        binding.button13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.currentTraining = 2;
                NavHostFragment.findNavController(FifthFragment.this)
                        .navigate(R.id.action_FifthFragment_to_FirstTraining);
            }
        });
        binding.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getActivity(), "Данная тренировка начинается с разминки.Она включает упражнения для поддержания тонусе группу мышц всего тела.", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });
        binding.imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getActivity(), "Данная тренировка начинается с разминки.Она включает упражнения для поддержания в тонусе группу мышц живота.", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });
        binding.imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getActivity(), "Данная тренировка начинается с разминки.Она включает упражнения для поддержания в тонусе группу мышц нижних конечностей.", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });
        binding.imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getActivity(), "Данная тренировка начинается с разминки.Она включает упражнения для поддержания в тонусе группу мышц нижних конечностей.", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });
        binding.imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(getActivity(), "Данная тренировка начинается с разминки.Она включает упражнения для поддержания в тонусе группу мышц нижних конечностей.", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        });



    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}