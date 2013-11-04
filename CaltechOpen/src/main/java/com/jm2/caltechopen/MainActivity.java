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
        int year = countDownCalendar.get(Calendar.YEAR);
        String[] titleArray = new String[4];

        long currentTimeMillis = countDownCalendar.getTimeInMillis();
        int month = countDownCalendar.get(Calendar.MONTH) + 1;
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
        int[][] viewIds = {viewIds1, viewIds2, viewIds3, viewIds4, viewIds5};


        for (int i = 0; i < 5; i++)
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

        return returnVals;
    }

    public long[] getCStoreInfo(int dayOfWeek, long millisecondsInDay) {
        boolean open = true;
        long timeToOpen = 0;
        long timeToClose = 0;
        /*** C store ***/
        if (dayOfWeek == Calendar.SUNDAY) {
            if (millisecondsInDay < 39600000) {
                open = false;
                timeToOpen = 39600000 - millisecondsInDay;
            } else if (millisecondsInDay >= 39600000 && millisecondsInDay < 43200000) {
                open = true;
                timeToClose = 43200000 - millisecondsInDay;
            } else if (millisecondsInDay >= 43200000 && millisecondsInDay < 44100000) {
                open = false;
                timeToOpen = 44100000 - millisecondsInDay;
            } else if (millisecondsInDay >= 44100000 && millisecondsInDay < 50400000) {
                open = true;
                timeToClose = 50400000 - millisecondsInDay;
            } else if (millisecondsInDay >= 5040000 && millisecondsInDay < 52200000) {
                open = false;
                timeToOpen = 52200000 - millisecondsInDay;
            } else if (millisecondsInDay >= 52200000 && millisecondsInDay < 61200000) {
                open = true;
                timeToClose = 61200000 - millisecondsInDay;
            } else if (millisecondsInDay >= 61200000 && millisecondsInDay < 62100000) {
                open = false;
                timeToOpen = 62100000 - millisecondsInDay;
            } else if (millisecondsInDay >= 62100000 && millisecondsInDay < 70200000) {
                open = true;
                timeToClose = 70200000 - millisecondsInDay;
            } else if (millisecondsInDay >= 70200000 && millisecondsInDay < 72000000) {
                open = false;
                timeToOpen = 72000000 - millisecondsInDay;
            } else if (millisecondsInDay >= 72000000 && millisecondsInDay < 82800000) {
                open = true;
                timeToClose = 82800000 - millisecondsInDay;
            } else if (millisecondsInDay >= 82800000 && millisecondsInDay < 83700000) {
                open = false;
                timeToOpen = 83700000 - millisecondsInDay;
            } else if (millisecondsInDay >= 83700000 && millisecondsInDay < 90000000) {
                open = true;
                timeToClose = 90000000 - millisecondsInDay;
            }


        }
        else if (dayOfWeek == Calendar.MONDAY || dayOfWeek == Calendar.TUESDAY
                || dayOfWeek == Calendar.WEDNESDAY
                || dayOfWeek == Calendar.THURSDAY
                || dayOfWeek == Calendar.FRIDAY) {
            if (millisecondsInDay < 3600000) {
                open = true;
                timeToClose = 3600000 - millisecondsInDay;
            } else if (millisecondsInDay >= 3600000 && millisecondsInDay < 34200000) {
                open = false;
                timeToOpen = 34200000 - millisecondsInDay;
            } else if (millisecondsInDay >= 34200000 && millisecondsInDay < 77400000) {
                open = true;
                timeToClose = 77400000 - millisecondsInDay;
            } else if (millisecondsInDay >= 77400000 && millisecondsInDay < 79200000) {
                open = false;
                timeToOpen = 79200000 - millisecondsInDay;
            } else if (millisecondsInDay >= 79200000 && millisecondsInDay < 83700000) {
                open = true;
                timeToClose = 83700000 - millisecondsInDay;
            } else if (millisecondsInDay >= 83700000 && millisecondsInDay < 84600000) {
                open = false;
                timeToOpen = 84600000 - millisecondsInDay;
            } else if (millisecondsInDay >= 84600000 && millisecondsInDay < 90000000) {
                open = true;
                timeToClose = 90000000 - millisecondsInDay;
            }
        }
        else if (dayOfWeek == Calendar.SATURDAY) {
            if (millisecondsInDay < 3600000) {
                open = true;
                timeToClose = 3600000 - millisecondsInDay;
            } else if (millisecondsInDay >= 3600000 && millisecondsInDay < 39600000) {
                open = false;
                timeToClose = 39600000 - millisecondsInDay;
            } else if (millisecondsInDay >= 39600000 && millisecondsInDay < 50400000) {
                open = true;
                timeToClose = 50400000 - millisecondsInDay;
            } else if (millisecondsInDay >= 50400000 && millisecondsInDay < 51300000) {
                open = false;
                timeToOpen = 51300000 - millisecondsInDay;
            } else if (millisecondsInDay >= 51300000 && millisecondsInDay < 56700000) {
                open = true;
                timeToClose = 56700000 - millisecondsInDay;
            } else if (millisecondsInDay >= 56700000 && millisecondsInDay < 58500000) {
                open = false;
                timeToOpen = 58500000 - millisecondsInDay;
            } else if (millisecondsInDay >= 58500000 && millisecondsInDay < 72000000) {
                open = true;
                timeToClose = 72000000 - millisecondsInDay;
            } else if (millisecondsInDay >= 72000000 && millisecondsInDay < 72900000) {
                open = false;
                timeToOpen = 72900000 - millisecondsInDay;
            } else if (millisecondsInDay >= 72900000 && millisecondsInDay < 79200000) {
                open = true;
                timeToClose = 79200000 - millisecondsInDay;
            } else if (millisecondsInDay >= 79200000) {
                open = false;
                timeToOpen = 39600000 + (86400000 - millisecondsInDay);
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


}
