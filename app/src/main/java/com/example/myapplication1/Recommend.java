package com.example.myapplication1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication1.databinding.RecommendBinding;

public class Recommend extends Fragment {

    private RecommendBinding binding;
    private static String RecomendedLevel;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = RecommendBinding.inflate(inflater, container, false);

        Recommend recommend = (Recommend) getFragmentManager().findFragmentById(R.id.Recommend);
        MainActivity mainActivity = (MainActivity) getActivity();



        Integer puls = mainActivity.Puls;
        Integer weight = mainActivity.Weight;
        boolean head = mainActivity.Head;
        boolean ache = mainActivity.Ache;
        String level = mainActivity.getLevel();
        int tired = mainActivity.UserTired;
        RecomendedLevel = level;

        if (180 < puls || head || ache || tired==5)
        {
            binding.textView21.setText("Ваши показатели превышают норму. Рекомендуется сходить на осмотр ко врачу.\n" +
                    "Обязательно отдохните и сделайте перекус после тренировки." +
                    "Рекомендуется сменить уровень сложности на лёгкий ");
            DownLevel(level);
        }
        else if (level.equals("Средний") && 150 >= puls && !head && !ache)
        {
            binding.textView21.setText("Ваши показатели в норме. \n" +
                    "Обязательно отдохните и сделайте перекус после тренировки." +
                    "Рекомендуется сменить уровень сложности на более тяжелый");
            UpLevel(level);
        }
        else if (level.equals("Легкий") && 140 >= puls && !head && !ache)
        {
            binding.textView21.setText("Ваши показатели в норме.\n" +
                    "Обязательно отдохните и сделайте перекус после тренировки.\n" +
                    "Рекомендуется сменить уровень сложности на средний");
            DownLevel(level);
        }
        else {
            binding.textView21.setText("Ваши показатели в норме.\n" +
                    "Обязательно отдохните и сделайте перекус после тренировки.");
            binding.textView24.setVisibility(View.GONE);
            binding.imageButton6.setVisibility(View.GONE);
        }

        binding.imageButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.superSetLevel(RecomendedLevel);
            }
        });

        binding.button25.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Recommend.this)
                        .navigate(R.id.action_Recommend_to_End);
            }
        });
        return binding.getRoot();
    }

    private void UpLevel(String level) {
        switch (level){
            case "Лёгкий":
                RecomendedLevel = "Средний";
                break;
            case "Средний":
                RecomendedLevel = "Сложный";
                break;
        }
    }

    private void DownLevel(String level) {
        switch (level){
            case "Средний":
                RecomendedLevel = "Лёгкий";
                break;
            case "Сложный":
                RecomendedLevel = "Средний";
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}