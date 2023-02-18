package com.ettounani.monsupercalculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ICalcul{






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void clearAll() {
        
    }

    @Override
    public void number() {

    }

    @Override
    public void result() {

    }

    @Override
    public void removeOne() {

    }

    @Override
    public void operation() {

    }

    @Override
    public void percent() {

    }
}