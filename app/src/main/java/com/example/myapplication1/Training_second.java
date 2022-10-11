package com.example.myapplication1;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication1.databinding.FragmentTrainSecondBinding;

import java.util.ArrayList;

public class Training_second extends Fragment {
    private FragmentTrainSecondBinding binding;
    private ArrayList<Exercise> exercises;
    private int index = 0;
    private int totalCount = 0;
    private boolean isFinished = false;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentTrainSecondBinding.inflate(inflater, container, false);

        Training_second training_second = (Training_second) getFragmentManager().findFragmentById(R.id.Training_second);
        MainActivity mainActivity = (MainActivity) getActivity();
        boolean isMale = mainActivity.getGender();
        if (isMale)
        {
            switch (mainActivity.currentCategory) {
                case 1:
                    switch (mainActivity.currentTraining){
                        case 1:
                            GetExercisesForMan(R.array.ExercisesForManToKeepFitForTrainThree);
                            break;
                        case 2:
                            GetExercisesForMan(R.array.ExercisesForManToKeepFitForTrainFour);
                            break;
                        default:
                            GetExercisesForMan(R.array.ExercisesForManToKeepFitForTrainOne);
                            break;
                    }
                    break;
                case 2:
                    switch (mainActivity.currentTraining){
                        case 1:
                            GetExercisesForMan(R.array.ExercisesForManToKeepFitForTrainOne);
                            break;
                        case 2:
                            GetExercisesForMan(R.array.ExercisesForManToKeepFitForTrainTwo);
                            break;
                        default:
                            GetExercisesForMan(R.array.ExercisesForManToKeepFitForTrainOne);
                            break;
                    }
                    break;
                case 3:
                    switch (mainActivity.currentTraining){
                        case 1:
                            GetExercisesForMan(R.array.ExercisesForManToKeepFitForTrainFive);
                            break;
                        case 2:
                            GetExercisesForMan(R.array.ExercisesForManToKeepFitForTrainFour);
                            break;
                        default:
                            GetExercisesForMan(R.array.ExercisesForManToKeepFitForTrainOne);
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
        else
        {
            switch (mainActivity.currentCategory) {
                case 1:
                    switch (mainActivity.currentTraining){
                        case 1:
                            GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainOne);
                            break;
                        case 2:
                            GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainTwo);
                            break;
                        case 3:
                            GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainSix);
                            break;
                        case 4:
                            GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainNine);
                            break;
                        default:
                            GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainThree);
                            break;
                    }
                    break;
                case 2:
                    switch (mainActivity.currentTraining){
                        case 1:
                            GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainThree);
                            break;
                        case 2:
                            GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainTwo);
                            break;
                        case 3:
                            GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainSeven);
                            break;
                        case 5:
                            GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainTen);
                            break;
                        default:
                            GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainOne);
                            break;
                    }

                    break;
                case 3:
                    switch (mainActivity.currentTraining){
                        case 1:
                            GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainFour);
                            break;
                        case 2:
                            GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainFive);
                            break;
                        case 3:
                            GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainEight);
                            break;
                        case 5:
                            GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainEleven);
                            break;
                        default:
                            GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainOne);
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
        binding.textView23.setText(exercises.get(0).Text);
        binding.textView22.setText(exercises.get(0).Title);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                if (index < totalCount) {
                    binding.textView23.setText(exercises.get(index).Text);
                    binding.textView22.setText(exercises.get(index).Title);
                }
                else
                {
                    binding.textView23.setText("");
                    binding.textView22.setText("Тренировка окончена!");
                    if (isFinished) {
                        NavHostFragment.findNavController(Training_second.this)
                                .navigate(R.id.action_SecondTraining_to_ThirdTraining);
                    }
                    isFinished = true;
                }
            }
        });

    }

    private void GetExercisesForMan(int id)
    {
        Resources res = getResources();
        String[] exercisesString = res.getStringArray(id);
        totalCount = exercisesString.length;
        exercises = new ArrayList<>();
        for (String item:
             exercisesString) {
            String[] splitArr = item.split("/");
            exercises.add(new Exercise(splitArr[0], splitArr[1]));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
