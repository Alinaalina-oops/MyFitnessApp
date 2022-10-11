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

import com.example.myapplication1.databinding.FragmentFourthBinding;


public class FourthFragment extends Fragment {
    private FragmentFourthBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFourthBinding.inflate(inflater, container, false);

        FourthFragment fourthFragment = (FourthFragment) getFragmentManager().findFragmentById(R.id.FourthFragment);
        return binding.getRoot();
    }

        public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            MainActivity mainActivity = (MainActivity) getActivity();

            binding.button6.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mainActivity.currentTraining = 1;
                    NavHostFragment.findNavController(FourthFragment.this)
                            .navigate(R.id.action_FourthFragment_to_FirstTraining);
                }
            });
            binding.button7.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mainActivity.currentTraining = 2;
                    NavHostFragment.findNavController(FourthFragment.this)
                            .navigate(R.id.action_FourthFragment_to_FirstTraining);
                }
            });
            binding.button8.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mainActivity.currentTraining =3;

                    NavHostFragment.findNavController(FourthFragment.this)
                            .navigate(R.id.action_FourthFragment_to_FirstTraining);
                }
            });
            binding.button9.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mainActivity.currentTraining = 4;
                    NavHostFragment.findNavController(FourthFragment.this)
                            .navigate(R.id.action_FourthFragment_to_FirstTraining);
                }
            });

            binding.button10.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mainActivity.currentTraining = 5;
                    NavHostFragment.findNavController(FourthFragment.this)
                            .navigate(R.id.action_FourthFragment_to_FirstTraining);
                }
            });
            binding.imageButton13.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast toast = Toast.makeText(getActivity(), "Данная тренировка начинается с разминки.Она включает упражнения для поддержания в тонусе группу мышц нижних конечностей.", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            });
            binding.imageButton12.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast toast = Toast.makeText(getActivity(), "Данная тренировка начинается с разминки.Она включает упражнения для поддержания в тонусе группу мышц всего тела.", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            });
            binding.imageButton14.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast toast = Toast.makeText(getActivity(), "Данная тренировка начинается с разминки.Она включает упражнения для поддержания в тонусе группу мышц живота.", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            });
            binding.imageButton11.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast toast = Toast.makeText(getActivity(), "Данная тренировка начинается с разминки.Она включает упражнения для поддержания в тонусе группу мышц нижних конечностей.", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            });
            binding.imageButton15.setOnClickListener(new View.OnClickListener() {
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
