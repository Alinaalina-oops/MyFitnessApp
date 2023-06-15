package com.example.myapplication1;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.navigation.fragment.NavHostFragment;

import com.bumptech.glide.Glide;
import com.example.myapplication1.databinding.TrainigVideoBinding;

import java.text.DecimalFormat;

public class TrainingVideo extends Fragment {

    private TrainigVideoBinding binding;

    public static int[] listOfGifs;

    public ProgressBar progressBar;
    public Button button;
    private final int MaxTime = 10;
    private boolean isPaused;
    private double PausedTime = 0;
    public static int state = 0;
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = TrainigVideoBinding.inflate(inflater, container, false);
        assert getFragmentManager() != null;
        TrainingVideo trainingVideo = (TrainingVideo) getFragmentManager().findFragmentById(R.id.TrainingVideo);
        Glide.with(getContext()).load(listOfGifs[state - 1]).into(binding.imageView4);
        return binding.getRoot();
    }

    @Override
    public void onStart() {
        super.onStart();
        Glide.with(getContext()).load(listOfGifs[state - 1]).into(binding.imageView4);
        isPaused = false;
    }

    @SuppressLint("ResourceType")
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        progressBar = binding.progressBar3;
        button = binding.button22;
        TextView timeView = binding.textView15;
        progressBar.setMax(MaxTime);
        CountDownTimerWithPause timer = new CountDownTimerWithPause(
                MaxTime * 1000, 100, true)
        {
            @Override
            public void onTick(long l) {
                Integer currentTime = MaxTime - (int)l/1000;
                Integer seconds = (int)l/1000 % 60;
                Integer minutes = (int)l/1000 / 60;
                progressBar.setProgress(currentTime);
                DecimalFormat format = new DecimalFormat("#00");
                timeView.setText(format.format(minutes) + " : " + format.format(seconds));
            }

            @Override
            public void onFinish() {
                NavHostFragment.findNavController(TrainingVideo.this)
                        .navigate(R.id.action_TrainingVideo_to_SecondTraining);
                Training_second.index = state;
            }
        }.create();
        timer.hasBeenStarted();
        button.setOnClickListener(new View.OnClickListener() {
            ViewGroup.LayoutParams params = button.getLayoutParams();
            @Override
            public void onClick(View view) {
                if (isPaused){
                    button.setText("Пауза");
                    isPaused = false;
                    timer.resume();
                    params.width = 300;
                    Glide.with(getContext()).load(listOfGifs[state - 1])
                            .into(binding.imageView4);
                }
                else {
                    button.setText("Продолжить");
                    isPaused = true;
                    timer.pause();
                    params.width = 480;
                    Glide.with(getContext()).pauseAllRequests();
                }
                button.setLayoutParams(params);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        isPaused = false;
        PausedTime = 0;
        binding = null;
        state = 0;
    }
}
