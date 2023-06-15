package com.example.myapplication1;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication1.databinding.StatisticsBinding;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Statistics extends Fragment {

    private StatisticsBinding binding;
    private LineChart chart;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = StatisticsBinding.inflate(inflater, container, false);
        Statistics statistics = (Statistics) getFragmentManager().findFragmentById(R.id.Statistics);
        chart = binding.getRoot().findViewById(R.id.chart);

        MainActivity mainActivity = (MainActivity) getActivity();
        ArrayList<UserStats> stats = new ArrayList<>();
        try {
            stats = mainActivity.getUserStats();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Integer countOfMonth = getMonthStats(stats);
        Integer countOfWeek = getWeekStats(stats);

        binding.textView35.setText(countOfWeek.toString());
        binding.textView36.setText(countOfWeek.toString());
        ArrayList<Entry> entries = new ArrayList<Entry>();

        ArrayList<UserStats> sortedList = getWeekStatsList(stats);

        int k = 1;
        for (int i = sortedList.size() - 7; i < sortedList.size(); i++)
        {
            float weight = sortedList.get(i).Weight;
            entries.add(new Entry(k, weight));
            k++;
        }

// На основании массива точек создадим первую линию с названием
        LineDataSet dataset = new LineDataSet(entries, "ВЕС ПОЛЬЗОВАТЕЛЯ ЗА ПОСЛЕДНИЕ 7 ТРЕНИРОВОК");

// Создадим переменную данных для графика
        LineData data = new LineData(dataset);
// Передадим данные для графика в сам график
        chart.setData(data);

// Не забудем отправить команду на перерисовку кадра, иначе график не отобразится
        chart.invalidate();


        return binding.getRoot();
    }

    public int getMonthStats(ArrayList<UserStats> stats)
    {
        int result = 0;
        Date now = Calendar.getInstance().getTime();

        for (int i=0; i < stats.size(); i++) {
            long ms = Math.abs(now.getTime() - stats.get(i).TrainingDate.getTime());
            long days = TimeUnit.DAYS.convert(ms, TimeUnit.MILLISECONDS);

            if (days <= 30)
                result++;
        }

        return result;
    }

    public int getWeekStats(ArrayList<UserStats> stats)
    {
        int result = 0;
        Date now = Calendar.getInstance().getTime();

        for (int i=0; i < stats.size(); i++) {
            long ms = Math.abs(now.getTime() - stats.get(i).TrainingDate.getTime());
            long days = TimeUnit.DAYS.convert(ms, TimeUnit.MILLISECONDS);

            if (days <= 7)
                result++;
        }

        return result;
    }

    public ArrayList<UserStats> getWeekStatsList(ArrayList<UserStats> stats)
    {
        ArrayList<UserStats> result = new ArrayList<UserStats>();
        Date now = Calendar.getInstance().getTime();

        for (int i = 0; i < stats.size(); i++) {
            long ms = Math.abs(now.getTime() - stats.get(i).TrainingDate.getTime());
            long days = TimeUnit.DAYS.convert(ms, TimeUnit.MILLISECONDS);

            if (days <= 7)
                result.add(stats.get(i));
        }
        Collections.sort(result);
        return result;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}


