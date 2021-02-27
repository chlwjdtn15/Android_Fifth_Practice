package com.example.week5;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {



    private int value = 0;
    private MutableLiveData<Integer> number = new MutableLiveData<Integer>(0);



    public LiveData getNumber() {

        return number;
    }

    public void increamentNumber() {
        Integer v = number.getValue() + 1;

        number.setValue(v);
    }

    public int getValue() {
        return value;
    }


    public void increament() {
        value += 1;
    }



    public void setValue(int value) {
        this.value = value;
    }
}
