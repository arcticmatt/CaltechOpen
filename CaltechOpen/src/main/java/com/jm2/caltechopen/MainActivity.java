package com.jm2.caltechopen;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;
// S/O to blacker hovse

public class MainActivity extends Activity {
    Context context;
    int green;
    int red;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;
        Resources res = this.getResources();
        green = res.getColor(android.R.color.holo_green_dark);
        red = res.getColor(android.R.color.holo_red_dark);
    }


    @Override
    public void onResume()
    {
        super.onResume();
        Calendar countDownCalendar = Calendar.getInstance();

        int dayOfWeek = countDownCalendar.get(Calendar.DAY_OF_WEEK);
        int hour = countDownCalendar.get(Calendar.HOUR_OF_DAY);
        int minute = countDownCalendar.get(Calendar.MINUTE);
        int second = countDownCalendar.get(Calendar.SECOND);
        int millisecond = countDownCalendar.get(Calendar.MILLISECOND);
        long millisecondsInDay = hour * 3600000 + minute * 60000 + second
                * 1000 + millisecond;


        int[] viewIds1 = {R.id.time_view, R.id.info_view, R.id.title_view, R.id.open_view};
        int[] viewIds2 = {R.id.time_view2, R.id.info_view2, R.id.title_view2, R.id.open_view2};
        int[] viewIds3 = {R.id.time_view3, R.id.info_view3, R.id.title_view3, R.id.open_view3};
        int[] viewIds4 = {R.id.time_view4, R.id.info_view4, R.id.title_view4, R.id.open_view4};
        int[] viewIds5 = {R.id.time_view5, R.id.info_view5, R.id.title_view5, R.id.open_view5};
        int[] viewIds6 = {R.id.time_view6, R.id.info_view6, R.id.title_view6, R.id.open_view6};
        int[][] viewIds = {viewIds1, viewIds2, viewIds3, viewIds4, viewIds5, viewIds6};


        for (int i = 0; i < 6; i++)
        {
            long[] openAndTime = getInfo(i, dayOfWeek, millisecondsInDay);
            int isOpen = (int) openAndTime[0];
            long startTime = openAndTime[1];
            MyCountDownTimer myCountDownTimer = new MyCountDownTimer(startTime, 1000, isOpen,
                    viewIds[i], this, i);
            myCountDownTimer.start();
        }

    }

    public void toCStore(View view)
    {
        Intent intent = new Intent(this, CStoreActivity.class);
        startActivity(intent);
    }

    public void toRedDoor(View view)
    {
        Intent intent = new Intent(this, RedDoorActivity.class);
        startActivity(intent);
    }

    public void toBookstore(View view)
    {
        Intent intent = new Intent(this, BookstoreActivity.class);
        startActivity(intent);
    }

    public void toChandler(View view)
    {
        Intent intent = new Intent(this, ChandlerActivity.class);
        startActivity(intent);
    }

    public void toCafeBroad(View view)
    {
        Intent intent = new Intent(this, CafeBroadActivity.class);
        startActivity(intent);
    }
    public void toBraun(View view)
    {
        Intent intent = new Intent(this, BraunActivity.class);
        startActivity(intent);
    }

    public long[] getInfo(int store, int dayOfWeek, long millis) {
        long[] returnVals = null;
        if (store == 0)
        {
            returnVals = getCStoreInfo(dayOfWeek, millis);
        }
        else if (store == 1) {
            returnVals = getRedDoorInfo(dayOfWeek, millis);
        }
        else if (store == 2) {
            returnVals = getBookstoreInfo(dayOfWeek, millis);
        }
        else if (store == 3) {
            returnVals = getChandlerInfo(dayOfWeek, millis);
        }
        else if (store == 4) {
            returnVals = getCafeBroadInfo(dayOfWeek, millis);
        }
        else if (store == 5) {
            returnVals = getBraunBrownInfo(dayOfWeek, millis);
        }

        return returnVals;
    }

    public long[] getCStoreInfo(int dayOfWeek, long millisecondsInDay) {
        boolean open = true;
        long timeToOpen = 0;
        long timeToClose = 0;
        /*** C store ***/
        if (dayOfWeek == Calendar.SUNDAY) {
            int[] times = {0, 43200000, 50400000, 51300000, 59400000,
                    61200000, 72000000, 72900000, 77400000, 79200000, 90000000};
            for (int i = 0; i < times.length - 1; i++) {
                if (millisecondsInDay >= times[i] &&
                        millisecondsInDay < times[i + 1]) {
                    if (i % 2 == 0) {
                        open = false;
                        timeToOpen = times[i + 1] - millisecondsInDay;
                    } else {
                        open = true;
                        timeToClose = times[i + 1] - millisecondsInDay;
                    }
                }
            }
        }
        else if (dayOfWeek == Calendar.MONDAY || dayOfWeek == Calendar.TUESDAY
                || dayOfWeek == Calendar.WEDNESDAY
                || dayOfWeek == Calendar.THURSDAY
                || dayOfWeek == Calendar.FRIDAY) {
            int[] times = {0, 3600000, 34200000, 77400000, 79200000, 83700000,
                    84600000, 90000000};
            for (int i = 0; i < times.length - 1; i++) {
                if (millisecondsInDay >= times[i] &&
                        millisecondsInDay < times[i + 1]) {
                    if (i % 2 == 0) {
                        open = true;
                        timeToClose = times[i + 1] - millisecondsInDay;
                    } else {
                        open = false;
                        timeToOpen = times[i + 1] - millisecondsInDay;
                    }
                }
            }
        }
        else if (dayOfWeek == Calendar.SATURDAY) {
            int[] times = {0, 39600000, 49500000, 50400000, 55800000, 57600000,
                    64800000, 65700000, 73800000, 75600000, 79200000, 129600000};
            for (int i = 0; i < times.length - 1; i++) {
                if (millisecondsInDay >= times[i] &&
                        millisecondsInDay < times[i + 1]) {
                    if (i % 2 == 0) {
                        open = false;
                        timeToOpen = times[i + 1] - millisecondsInDay;
                    } else {
                        open = true;
                        timeToClose = times[i + 1] - millisecondsInDay;
                    }
                }
            }
        }

        long[] returnVals = new long[2];
        if (open) {
            returnVals[0] = 0;
            returnVals[1] = timeToClose;
        }
        else {
            returnVals[0] = 1;
            returnVals[1] = timeToOpen;
        }
        return returnVals;
    }

    public long[] getRedDoorInfo(int dayOfWeek, long millisecondsInDay) {
        boolean open = true;
        long timeToOpen = 0;
        long timeToClose = 0;
        /*** red door ***/
        if (dayOfWeek == Calendar.MONDAY || dayOfWeek == Calendar.TUESDAY
                || dayOfWeek == Calendar.WEDNESDAY
                || dayOfWeek == Calendar.THURSDAY)
        {
            if (millisecondsInDay < 7200000)
            {
                open = true;
                timeToClose = 7200000 - millisecondsInDay;
            }
            if (millisecondsInDay >= 7200000 && millisecondsInDay < 27000000)
            {
                open = false;
                timeToOpen = 27000000 - millisecondsInDay;
            }
            if (millisecondsInDay >= 27000000 && millisecondsInDay < 63000000)
            {
                open = true;
                timeToClose = 63000000 - millisecondsInDay;
            }
            if (millisecondsInDay >= 63000000 && millisecondsInDay < 79200000)
            {
                open = false;
                timeToOpen = 79200000 - millisecondsInDay;
            }
            if (millisecondsInDay >= 79200000)
            {
                open = true;
                timeToClose = 7200000 + (86400000 - millisecondsInDay);
            }

        }
        else if (dayOfWeek == Calendar.FRIDAY)
        {
            if (millisecondsInDay < 7200000)
            {
                open = true;
                timeToClose = 7200000 - millisecondsInDay;
            }
            if (millisecondsInDay >= 7200000 && millisecondsInDay < 27000000)
            {
                open = false;
                timeToOpen = 27000000 - millisecondsInDay;
            }
            if (millisecondsInDay >= 27000000 && millisecondsInDay < 61200000)
            {
                open = true;
                timeToClose = 61200000 - millisecondsInDay;
            }
            if (millisecondsInDay >= 61200000)
            {
                open = false;
                timeToOpen = (86400000 - millisecondsInDay) + 86400000 + 79200000;
            }
        }
        else if (dayOfWeek == Calendar.SATURDAY)
        {
            open = false;
            timeToOpen = (86400000 - millisecondsInDay) + 79200000;
        }
        else if (dayOfWeek == Calendar.SUNDAY)
        {
            if (millisecondsInDay < 79200000) {
                open = false;
                timeToOpen = 79200000 - millisecondsInDay;
            }
            if (millisecondsInDay >= 79200000) {
                open = true;
                timeToClose = 7200000 + (86400000 - millisecondsInDay);
            }
        }

        long[] returnVals = new long[2];
        if (open) {
            returnVals[0] = 0;
            returnVals[1] = timeToClose;
        }
        else {
            returnVals[0] = 1;
            returnVals[1] = timeToOpen;
        }
        return returnVals;
    }

    public long[] getBookstoreInfo(int dayOfWeek, long millisecondsInDay) {
        boolean open = true;
        long timeToOpen = 0;
        long timeToClose = 0;
        /*** book store ***/
        if (dayOfWeek == Calendar.MONDAY || dayOfWeek == Calendar.TUESDAY
                || dayOfWeek == Calendar.WEDNESDAY
                || dayOfWeek == Calendar.THURSDAY)
        {
            if (millisecondsInDay < 30600000)
            {
                open = false;
                timeToOpen = 30600000 - millisecondsInDay;
            }
            else if (millisecondsInDay >= 30600000 && millisecondsInDay < 63000000)
            {
                open = true;
                timeToClose = 63000000 - millisecondsInDay;
            }
            else if (millisecondsInDay >= 63000000)
            {
                open = false;
                timeToOpen = 86400000 - millisecondsInDay + 30600000;
            }
        }
        else if (dayOfWeek == Calendar.FRIDAY)
        {
            if (millisecondsInDay < 30600000)
            {
                open = false;
                timeToOpen = 30600000 - millisecondsInDay;
            }
            else if (millisecondsInDay >= 30600000 && millisecondsInDay < 63000000)
            {
                open = true;
                timeToClose = 63000000 - millisecondsInDay;
            }
            else if (millisecondsInDay >= 63000000)
            {
                open = false;
                timeToOpen = 86400000 - millisecondsInDay + 86400000 * 2 + 30600000;
            }
        }
        else if (dayOfWeek == Calendar.SATURDAY)
        {
            open = false;
            timeToOpen = 86400000 - millisecondsInDay + 86400000 + 30600000;
        }
        else if (dayOfWeek == Calendar.SUNDAY)
        {
            open = false;
            timeToOpen = 86400000 - millisecondsInDay + 30600000;
        }

        long[] returnVals = new long[2];
        if (open) {
            returnVals[0] = 0;
            returnVals[1] = timeToClose;
        }
        else {
            returnVals[0] = 1;
            returnVals[1] = timeToOpen;
        }
        return returnVals;
    }

    public long[] getChandlerInfo(int dayOfWeek, long millisecondsInDay) {
        boolean open = true;
        long timeToOpen = 0;
        long timeToClose = 0;
        /*** Chandler ***/
        if (dayOfWeek == Calendar.MONDAY || dayOfWeek == Calendar.TUESDAY
                || dayOfWeek == Calendar.WEDNESDAY
                || dayOfWeek == Calendar.THURSDAY)
        {
            if (millisecondsInDay < 25200000)
            {
                open = false;
                timeToOpen = 25200000 - millisecondsInDay;
            }
            else if (millisecondsInDay >= 25200000 && millisecondsInDay < 52200000)
            {
                open = true;
                timeToClose = 52200000 - millisecondsInDay;
            }
            else if (millisecondsInDay >= 52200000)
            {
                open = false;
                timeToOpen = 86400000 - millisecondsInDay + 27900000;
            }
        }
        else if (dayOfWeek == Calendar.FRIDAY)
        {
            if (millisecondsInDay < 25200000)
            {
                open = false;
                timeToOpen = 25200000 - millisecondsInDay;
            }
            else if (millisecondsInDay >= 25200000 && millisecondsInDay < 52200000)
            {
                open = true;
                timeToClose = 52200000 - millisecondsInDay;
            }
            else if (millisecondsInDay >= 52200000)
            {
                open = false;
                timeToOpen = 86400000 - millisecondsInDay + 86400000 * 2 + 25200000;
            }
        }
        else if (dayOfWeek == Calendar.SATURDAY)
        {
            open = false;
            timeToOpen = 86400000 - millisecondsInDay + 86400000 + 25200000;
        }
        else if (dayOfWeek == Calendar.SUNDAY)
        {
            open = false;
            timeToOpen = 86400000 - millisecondsInDay + 25200000;
        }

        long[] returnVals = new long[2];
        if (open) {
            returnVals[0] = 0;
            returnVals[1] = timeToClose;
        }
        else {
            returnVals[0] = 1;
            returnVals[1] = timeToOpen;
        }
        return returnVals;
    }

    public long[] getCafeBroadInfo(int dayOfWeek, long millisecondsInDay) {
        boolean open = true;
        long timeToOpen = 0;
        long timeToClose = 0;
        /*** Cafe Broad ***/
        if (dayOfWeek == Calendar.MONDAY || dayOfWeek == Calendar.TUESDAY
                || dayOfWeek == Calendar.WEDNESDAY
                || dayOfWeek == Calendar.THURSDAY)
        {
            if (millisecondsInDay < 27900000)
            {
                open = false;
                timeToOpen = 27900000 - millisecondsInDay;
            }
            else if (millisecondsInDay >= 27900000 && millisecondsInDay < 52200000)
            {
                open = true;
                timeToClose = 52200000 - millisecondsInDay;
            }
            else if (millisecondsInDay >= 52200000)
            {
                open = false;
                timeToOpen = 86400000 - millisecondsInDay + 27900000;
            }
        }
        else if (dayOfWeek == Calendar.FRIDAY)
        {
            if (millisecondsInDay < 27900000)
            {
                open = false;
                timeToOpen = 27900000 - millisecondsInDay;
            }
            else if (millisecondsInDay >= 27900000 && millisecondsInDay < 52200000)
            {
                open = true;
                timeToClose = 52200000 - millisecondsInDay;
            }
            else if (millisecondsInDay >= 52200000)
            {
                open = false;
                timeToOpen = 86400000 - millisecondsInDay + 86400000 * 2 + 27900000;
            }
        }
        else if (dayOfWeek == Calendar.SATURDAY)
        {
            open = false;
            timeToOpen = 86400000 - millisecondsInDay + 86400000 + 27900000;
        }
        else if (dayOfWeek == Calendar.SUNDAY)
        {
            open = false;
            timeToOpen = 86400000 - millisecondsInDay + 27900000;
        }

        long[] returnVals = new long[2];
        if (open) {
            returnVals[0] = 0;
            returnVals[1] = timeToClose;
        }
        else {
            returnVals[0] = 1;
            returnVals[1] = timeToOpen;
        }
        return returnVals;
    }

    public long[] getBraunBrownInfo(int dayOfWeek, long millisecondsInDay) {
        boolean open = true;
        long timeToOpen = 0;
        long timeToClose = 0;
        /*** Braun/Brown Athletic Centers ***/
        if (dayOfWeek == Calendar.MONDAY || dayOfWeek == Calendar.TUESDAY
                || dayOfWeek == Calendar.WEDNESDAY
                || dayOfWeek == Calendar.THURSDAY)
        {
            if (millisecondsInDay < 21600000)
            {
                open = false;
                timeToOpen = 21600000 - millisecondsInDay;
            }
            else if (millisecondsInDay >= 21600000 && millisecondsInDay < 81000000)
            {
                open = true;
                timeToClose = 81000000 - millisecondsInDay;
            }
            else if (millisecondsInDay >= 81000000)
            {
                open = false;
                timeToOpen = 86400000 - millisecondsInDay + 21600000;
            }
        }
        else if (dayOfWeek == Calendar.FRIDAY)
        {
            if (millisecondsInDay < 21600000)
            {
                open = false;
                timeToOpen = 21600000 - millisecondsInDay;
            }
            else if (millisecondsInDay >= 21600000 && millisecondsInDay < 81000000)
            {
                open = true;
                timeToClose = 81000000 - millisecondsInDay;
            }
            else if (millisecondsInDay >= 81000000)
            {
                open = false;
                timeToOpen = 86400000 - millisecondsInDay + 28800000;
            }
        }
        else if (dayOfWeek == Calendar.SATURDAY)
        {
            if (millisecondsInDay < 28800000)
            {
                open = false;
                timeToOpen = 28800000 - millisecondsInDay;
            }
            else if (millisecondsInDay >= 28800000 && millisecondsInDay < 72000000)
            {
                open = true;
                timeToClose = 72000000 - millisecondsInDay;
            }
            else if (millisecondsInDay >= 72000000)
            {
                open = false;
                timeToOpen = 86400000 - millisecondsInDay + 28800000;
            }
        }
        else if (dayOfWeek == Calendar.SUNDAY)
        {
            if (millisecondsInDay < 28800000)
            {
                open = false;
                timeToOpen = 28800000 - millisecondsInDay;
            }
            else if (millisecondsInDay >= 28800000 && millisecondsInDay < 72000000)
            {
                open = true;
                timeToClose = 72000000 - millisecondsInDay;
            }
            else if (millisecondsInDay >= 72000000)
            {
                open = false;
                timeToOpen = 86400000 - millisecondsInDay + 21600000;
            }
        }

        long[] returnVals = new long[2];
        if (open) {
            returnVals[0] = 0;
            returnVals[1] = timeToClose;
        }
        else {
            returnVals[0] = 1;
            returnVals[1] = timeToOpen;
        }
        return returnVals;
    }



}
