package com.ettounani.monsupercalculatrice;

import android.view.View;

public interface ICalcul {
    void clearAll();
    void ClickedNumber(View view);
    void result();
    void removeOne();
    void pointToDouble();
    void operation(View view);
    void percent();
    void ShowInScreen();
}
