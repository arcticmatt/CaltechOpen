package com.jm2.caltechopen;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by matt on 11/3/13.
 */
public class MyCountDownTimer extends CountDownTimer {
    TextView timeView;
    TextView infoView;
    TextView titleView;
    TextView openView;

    final String infoClosingTime = " until closed";
    final String infoOpenTime = " until open";
    final String openString = "Open";
    final String closedString = "Closed";

    boolean open;

    int green;
    int red;

    Activity myActivity;
    String storeName;

    public MyCountDownTimer(long startTime, long interval, int isOpen,
                            int[] viewIds, Activity mainActivity, int store) {
        super(startTime, interval);

        myActivity = mainActivity;

        timeView = (TextView) myActivity.findViewById(viewIds[0]);
        infoView = (TextView) myActivity.findViewById(viewIds[1]);
        titleView = (TextView) myActivity.findViewById(viewIds[2]);
        openView = (TextView) myActivity.findViewById(viewIds[3]);

        if (isOpen == 0) {
            open = true;
        }
        else {
            open = false;
        }

        Resources res = myActivity.getResources();

        green = res.getColor(android.R.color.holo_green_dark);
        red = res.getColor(android.R.color.holo_red_dark);

        String[] titles = {res.getString(R.string.c_store),
        res.getString(R.string.red_door), res.getString(R.string.bookstore),
        res.getString(R.string.chandler), res.getString(R.string.cafe_broad), res.getString(R.string.braun_gym)};

        storeName = titles[store];
    }

    @Override
    public void onTick(long millisUntilFinished) {
        long hoursToClose = millisUntilFinished / 3600000;
        long minutesToClose = (millisUntilFinished / 60000 - hoursToClose * 60) + 1;
        if (minutesToClose == 60) {
            minutesToClose--;
            hoursToClose++;
        }
        /*long secondsToClose = millisUntilFinished / 1000 - minutesToClose * 60
                - hoursToClose * 60 * 60;*/
        String minutesToCloseString = Long.toString(minutesToClose);
        if (minutesToClose < 10) {
            minutesToCloseString = "0" + minutesToClose;
        }
        /*String secondsToCloseString = Long.toString(secondsToClose);
        if (secondsToClose < 10) {
            secondsToCloseString = "0" + secondsToClose;
        }*/
        String time = hoursToClose + ":" + minutesToCloseString;

        timeView.setText(time);

        titleView.setText(storeName);
        if (open) {
            openView.setText(openString);
            infoView.setText(infoClosingTime);
            openView.setTextColor(green);
        } else {
            openView.setText(closedString);
            infoView.setText(infoOpenTime);
            openView.setTextColor(red);
        }


    }

    @Override
    public void onFinish() {
        myActivity.recreate();
    }


}
