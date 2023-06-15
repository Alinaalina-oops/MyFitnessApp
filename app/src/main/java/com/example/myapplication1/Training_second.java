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
    private int[] ListOfGifs;
    public static int index = 0;
    private int totalCount = 0;
    private boolean isFinished = false;
    private int[] CurrentListOfGifs;
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentTrainSecondBinding.inflate(inflater, container, false);

        assert getFragmentManager() != null;
        Training_second training_second = (Training_second) getFragmentManager().findFragmentById(R.id.Training_second);
        MainActivity mainActivity = (MainActivity) getActivity();
        assert mainActivity != null;
        boolean isMale = mainActivity.getGender();
        String Level = MainActivity.getLevel();
        if (isMale)
        {
            switch (mainActivity.currentCategory) {
                case 1:
                    switch (mainActivity.currentTraining){
                        case 1:
                            if (Level.equals("Лёгкий"))
                                GetExercisesForMan(R.array.ExercisesForManToKeepFitForTrainThree1);
                            else if  (Level.equals("Средний"))
                                GetExercisesForMan(R.array.ExercisesForManToKeepFitForTrainThree);
                            else
                                GetExercisesForMan(R.array.ExercisesForManToKeepFitForTrainThree2);
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
                    switch (mainActivity.currentTraining) {
                        case 1:
                            if (Level.equals("Лёгкий")) {
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainOne1);
                                CurrentListOfGifs = new int[]{
                                        R.drawable.viprigivanie_s_prisedom,
                                        R.drawable.sumokulaki
                                };
                            } else if (Level.equals("Средний")) {
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainOne);
                                CurrentListOfGifs = new int[]{
                                        R.drawable.viprigivanie_s_prisedom,
                                        R.drawable.sumokulaki
                                };
                            } else
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainOne2);
                            CurrentListOfGifs = new int[]{
                                    R.drawable.viprigivanie_s_prisedom,
                                    R.drawable.sumokulaki
                            };
                            break;

                        case 2:
                            if (Level.equals("Лёгкий")) {
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainTwo);
                                CurrentListOfGifs = new int[]{
                                        R.drawable.stul,
                                        R.drawable.dinam_planka
                                };
                            } else if (Level.equals("Средний")) {
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainTwo1);

                                CurrentListOfGifs = new int[]{
                                        R.drawable.stul,
                                        R.drawable.dinam_planka
                                };
                            }
                          else
                             GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainTwo2);
                         CurrentListOfGifs = new int[]{
                                 R.drawable.stul,
                                 R.drawable.dinam_planka
                          };
                        break;
                        case 3:
                            if (Level.equals("Лёгкий")) {
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainSix);
                                CurrentListOfGifs = new int[]{
                                        R.drawable.lodka,
                                        R.drawable.vipad
                                };
                            } else if (Level.equals("Средний")) {
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainSix1);

                                CurrentListOfGifs = new int[]{
                                        R.drawable.lodka,
                                        R.drawable.vipad
                                };
                            }
                            else
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainSix2);
                            CurrentListOfGifs = new int[]{
                                    R.drawable.lodka,
                                    R.drawable.vipad
                            };
                            break;
                        case 4:
                            if (Level.equals("Лёгкий")) {
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainNine1);
                                CurrentListOfGifs = new int[]{
                                        R.drawable.otzhimania,
                                        R.drawable.taz
                                };
                            } else if (Level.equals("Средний")) {
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainNine);

                                CurrentListOfGifs = new int[]{
                                        R.drawable.otzhimania,
                                        R.drawable.taz
                                };
                            }
                            else
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainNine2);
                            CurrentListOfGifs = new int[]{
                                    R.drawable.otzhimania,
                                    R.drawable.taz
                            };
                            break;

                        default:
                            if (Level.equals("Лёгкий")) {
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainThree);
                                CurrentListOfGifs = new int[]{
                                        R.drawable.otzhimania,
                                        R.drawable.mah_nogoi
                                };
                            } else if (Level.equals("Средний")) {
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainThree1);

                                CurrentListOfGifs = new int[]{
                                        R.drawable.otzhimania,
                                        R.drawable.mah_nogoi
                                };
                            }
                            else
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainThree2);
                            CurrentListOfGifs = new int[]{
                                    R.drawable.otzhimania,
                                    R.drawable.mah_nogoi
                            };
                            break;
                    }
                    break;
                case 2:
                    switch (mainActivity.currentTraining){
                        case 1:
                            if (Level.equals("Лёгкий")) {
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainThree);
                                CurrentListOfGifs = new int[]{
                                        R.drawable.otzhimania,
                                        R.drawable.mah_nogoi
                                };
                            } else if (Level.equals("Средний")) {
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainThree1);

                                CurrentListOfGifs = new int[]{
                                        R.drawable.otzhimania,
                                        R.drawable.mah_nogoi
                                };
                            }
                            else
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainThree2);
                            CurrentListOfGifs = new int[]{
                                    R.drawable.otzhimania,
                                    R.drawable.mah_nogoi
                            };
                            break;
                        case 2:
                            if (Level.equals("Лёгкий")) {
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainTwo);
                                CurrentListOfGifs = new int[]{
                                        R.drawable.stul,
                                        R.drawable.dinam_planka
                                };
                            } else if (Level.equals("Средний")) {
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainTwo1);

                                CurrentListOfGifs = new int[]{
                                        R.drawable.stul,
                                        R.drawable.dinam_planka
                                };
                            }
                            else
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainTwo2);
                            CurrentListOfGifs = new int[]{
                                    R.drawable.stul,
                                    R.drawable.dinam_planka
                            };
                            break;
                        case 3:
                            if (Level.equals("Лёгкий")) {
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainSeven);
                                CurrentListOfGifs = new int[]{
                                        R.drawable.kobra,
                                        R.drawable.tazik
                                };
                            } else if (Level.equals("Средний")) {
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainSeven1);

                                CurrentListOfGifs = new int[]{
                                        R.drawable.kobra,
                                        R.drawable.tazik
                                };
                            }
                            else
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainSeven2);
                            CurrentListOfGifs = new int[]{
                                    R.drawable.kobra,
                                    R.drawable.tazik
                            };
                            break;
                        case 5:
                            if (Level.equals("Лёгкий")) {
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainTen);
                                CurrentListOfGifs = new int[]{
                                        R.drawable.mah_gantel,
                                        R.drawable.gant
                                };
                            } else if (Level.equals("Средний")) {
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainTen1);

                                CurrentListOfGifs = new int[]{
                                        R.drawable.mah_gantel,
                                        R.drawable.gant
                                };
                            }
                            else
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainTen2);
                            CurrentListOfGifs = new int[]{
                                    R.drawable.mah_gantel,
                                    R.drawable.gant
                            };
                            break;
                        default:
                            if (Level.equals("Лёгкий")) {
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainOne1);
                                CurrentListOfGifs = new int[]{
                                        R.drawable.viprigivanie_s_prisedom,
                                        R.drawable.sumokulaki
                                };
                            } else if (Level.equals("Средний")) {
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainOne);
                                CurrentListOfGifs = new int[]{
                                        R.drawable.viprigivanie_s_prisedom,
                                        R.drawable.sumokulaki
                                };
                            } else
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainOne2);
                            CurrentListOfGifs = new int[]{
                                    R.drawable.viprigivanie_s_prisedom,
                                    R.drawable.sumokulaki
                            };
                            break;
                    }

                    break;
                case 3:
                    switch (mainActivity.currentTraining){
                        case 1:
                            if (Level.equals("Лёгкий")) {
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainFour);
                                CurrentListOfGifs = new int[]{
                                        R.drawable.rim,
                                        R.drawable.skr
                                };
                            } else if (Level.equals("Средний")) {
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainFour1);
                                CurrentListOfGifs = new int[]{
                                        R.drawable.rim,
                                        R.drawable.skr
                                };
                            } else
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainFour2);
                            CurrentListOfGifs = new int[]{
                                    R.drawable.rim,
                                    R.drawable.skr
                            };
                            break;
                        case 2:
                            if (Level.equals("Лёгкий")) {
                            GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainFive);
                            CurrentListOfGifs = new int[]{
                                    R.drawable.lodka,
                                    R.drawable.vipad
                            };
                        } else if (Level.equals("Средний")) {
                            GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainFive1);

                            CurrentListOfGifs = new int[]{
                                    R.drawable.lodka,
                                    R.drawable.vipad
                            };
                        }
                        else
                            GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainFive2);
                            CurrentListOfGifs = new int[]{
                                    R.drawable.lodka,
                                    R.drawable.vipad
                            };
                            break;
                        case 3:
                            GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainEight);
                            break;
                        case 5:
                            if (Level.equals("Лёгкий")) {
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainEleven);
                                CurrentListOfGifs = new int[]{
                                        R.drawable.run,
                                        R.drawable.noga
                                };
                            } else if (Level.equals("Средний")) {
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainEleven1);
                                CurrentListOfGifs = new int[]{
                                        R.drawable.run,
                                        R.drawable.noga
                                };
                            } else
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainEleven2);
                            CurrentListOfGifs = new int[]{
                                    R.drawable.run,
                                    R.drawable.noga
                            };
                            break;
                        default:
                            if (Level.equals("Лёгкий")) {
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainOne1);
                                CurrentListOfGifs = new int[]{
                                        R.drawable.viprigivanie_s_prisedom,
                                        R.drawable.sumokulaki
                                };
                            } else if (Level.equals("Средний")) {
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainOne);
                                CurrentListOfGifs = new int[]{
                                        R.drawable.viprigivanie_s_prisedom,
                                        R.drawable.sumokulaki
                                };
                            } else
                                GetExercisesForMan(R.array.ExercisesForWomanToKeepFitForTrainOne2);
                            CurrentListOfGifs = new int[]{
                                    R.drawable.viprigivanie_s_prisedom,
                                    R.drawable.sumokulaki
                            };
                            break;
                    }
                    break;
                default:
                    break;
            }
        }
        if (index < totalCount) {
            binding.textView23.setText(exercises.get(index).Text);
            binding.textView22.setText(exercises.get(index).Title);
            TrainingVideo.listOfGifs = CurrentListOfGifs;
            TrainingVideo.state = index;
        }
        else
        {
            binding.textView23.setText("");
            binding.textView22.setText("Тренировка окончена!");
            isFinished = true;
        }
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                if (index <= totalCount) {
                    NavHostFragment.findNavController(Training_second.this)
                            .navigate(R.id.action_SecondTraining_to_TrainingVideo);
                    TrainingVideo.state = index;
                    TrainingVideo.listOfGifs = CurrentListOfGifs;
                }
                if (index < totalCount) {
                    binding.textView23.setText(exercises.get(index).Text);
                    binding.textView22.setText(exercises.get(index).Title);
                    TrainingVideo.listOfGifs = CurrentListOfGifs;
                }
                else
                {
                    binding.textView23.setText("");
                    binding.textView22.setText("Тренировка окончена!");

                    if (isFinished) {
                        NavHostFragment.findNavController(Training_second.this)
                                .navigate(R.id.action_SecondTraining_to_Measurements);
                        index = 0;
                        TrainingVideo.state = 0;
                    }
                    isFinished = true;
                }
            }
        });
        binding.myButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Training_second.this)
                        .navigate(R.id.action_SecondTraining_to_Profile);
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
