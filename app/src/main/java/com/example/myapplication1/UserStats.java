package com.example.myapplication1;

import java.util.Date;

public class UserStats implements Comparable<UserStats>{
    public Date TrainingDate;
    public int Pulse;
    public int Weight;

    @Override
    public int compareTo(UserStats o) {
        return TrainingDate.compareTo(o.TrainingDate);
    }
}
