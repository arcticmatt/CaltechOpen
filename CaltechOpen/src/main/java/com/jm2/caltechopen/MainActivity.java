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
        boolean open = false;
        boolean open2 = false;
        boolean open3 = false;
        boolean bookStoreWeekend = false;
        boolean open4 = false;
        boolean open5 = false;
        long timeToOpen = 0;
        long timeToOpen2 = 0;
        long timeToOpen3 = 0;
        long timeToOpen4 = 0;
        long timeToOpen5 = 0;
        long timeToClose = 0;
        long timeToClose2 = 0;
        long timeToClose3 = 0;
        long timeToClose4 = 0;
        long timeToClose5 = 0;
        Calendar countDownCalendar = Calendar.getInstance();
        int year = countDownCalendar.get(Calendar.YEAR);
        String[] titleArray = new String[4];
        titleArray[0] = "C-Store";
        titleArray[1] = "Red Door";

        long currentTimeMillis = countDownCalendar.getTimeInMillis();
        int month = countDownCalendar.get(Calendar.MONTH) + 1;
        int dayOfWeek = countDownCalendar.get(Calendar.DAY_OF_WEEK);
        int hour = countDownCalendar.get(Calendar.HOUR_OF_DAY);
        int minute = countDownCalendar.get(Calendar.MINUTE);
        int second = countDownCalendar.get(Calendar.SECOND);
        int millisecond = countDownCalendar.get(Calendar.MILLISECOND);
        long millisecondsInDay = hour * 3600000 + minute * 60000 + second
                * 1000 + millisecond;


        if (dayOfWeek == Calendar.SUNDAY) {
            /*Date mondayThruFridayOpen = new Date(year, month, dayOfWeek, 9, 30);
            Date mondayThruFridayClose = new Date(year, month, dayOfWeek + 1, 1, 0);
            Date mondayThruFridayBreak1Start = new Date(year, month, dayOfWeek, 21, 30);
            Date mondayThruFridayBreak1End = new Date(year, month, dayOfWeek, 22, 0);
            Date mondayThruFridayBreak2Start = new Date(year, month, dayOfWeek, 23, 15);
            Date mondayThruFridayBreak2End = new Date(year, month, dayOfWeek, 23, 30);
*/
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



        if (dayOfWeek == Calendar.MONDAY || dayOfWeek == Calendar.TUESDAY
                || dayOfWeek == Calendar.WEDNESDAY
                || dayOfWeek == Calendar.THURSDAY)
        {
            if (millisecondsInDay < 7200000)
            {
                open2 = true;
                timeToClose2 = 7200000 - millisecondsInDay;
            }
            if (millisecondsInDay >= 7200000 && millisecondsInDay < 27000000)
            {
                open2 = false;
                timeToOpen2 = 27000000 - millisecondsInDay;
            }
            if (millisecondsInDay >= 27000000 && millisecondsInDay < 63000000)
            {
                open2 = true;
                timeToClose2 = 63000000 - millisecondsInDay;
            }
            if (millisecondsInDay >= 63000000 && millisecondsInDay < 79200000)
            {
                open2 = false;
                timeToOpen2 = 79200000 - millisecondsInDay;
            }
            if (millisecondsInDay >= 79200000)
            {
                open2 = true;
                timeToClose2 = 7200000 + (86400000 - millisecondsInDay);
            }

        }
        else if (dayOfWeek == Calendar.FRIDAY)
        {
            if (millisecondsInDay < 7200000)
            {
                open2 = true;
                timeToClose2 = 7200000 - millisecondsInDay;
            }
            if (millisecondsInDay >= 7200000 && millisecondsInDay < 27000000)
            {
                open2 = false;
                timeToOpen2 = 27000000 - millisecondsInDay;
            }
            if (millisecondsInDay >= 27000000 && millisecondsInDay < 61200000)
            {
                open2 = true;
                timeToClose2 = 61200000 - millisecondsInDay;
            }
            if (millisecondsInDay >= 61200000)
            {
                open2 = false;
                timeToOpen2 = (86400000 - millisecondsInDay) + 86400000 + 79200000;
            }
        }
        else if (dayOfWeek == Calendar.SATURDAY)
        {
            open2 = false;
            timeToOpen2 = (86400000 - millisecondsInDay) + 79200000;
        }
        else if (dayOfWeek == Calendar.SUNDAY)
        {
            if (millisecondsInDay < 79200000) {
                open2 = false;
                timeToOpen2 = 79200000 - millisecondsInDay;
            }
            if (millisecondsInDay >= 79200000) {
                open2 = true;
                timeToClose2 = 7200000 + (86400000 - millisecondsInDay);
            }
        }

        if (dayOfWeek == Calendar.MONDAY || dayOfWeek == Calendar.TUESDAY
                || dayOfWeek == Calendar.WEDNESDAY
                || dayOfWeek == Calendar.THURSDAY)
        {
            if (millisecondsInDay < 30600000)
            {
                open3 = false;
                timeToOpen3 = 30600000 - millisecondsInDay;
            }
            else if (millisecondsInDay >= 30600000 && millisecondsInDay < 63000000)
            {
                open3 = true;
                timeToClose3 = 63000000 - millisecondsInDay;
            }
            else if (millisecondsInDay >= 63000000)
            {
                open3 = false;
                timeToOpen3 = 86400000 - millisecondsInDay + 30600000;
            }
        }
        else if (dayOfWeek == Calendar.FRIDAY)
        {
            if (millisecondsInDay < 30600000)
            {
                open3 = false;
                timeToOpen3 = 30600000 - millisecondsInDay;
            }
            else if (millisecondsInDay >= 30600000 && millisecondsInDay < 63000000)
            {
                open3 = true;
                timeToClose3 = 63000000 - millisecondsInDay;
            }
            else if (millisecondsInDay >= 63000000)
            {
                open3 = false;
                timeToOpen3 = 86400000 - millisecondsInDay + 86400000 * 2 + 30600000;
            }
        }
        else if (dayOfWeek == Calendar.SATURDAY)
        {
            open3 = false;
            timeToOpen3 = 86400000 - millisecondsInDay + 86400000 + 30600000;
        }
        else if (dayOfWeek == Calendar.SUNDAY)
        {
            open3 = false;
            timeToOpen3 = 86400000 - millisecondsInDay + 30600000;
        }


        /*** Chandler ***/
        if (dayOfWeek == Calendar.MONDAY || dayOfWeek == Calendar.TUESDAY
                || dayOfWeek == Calendar.WEDNESDAY
                || dayOfWeek == Calendar.THURSDAY)
        {
            if (millisecondsInDay < 25200000)
            {
                open4 = false;
                timeToOpen4 = 25200000 - millisecondsInDay;
            }
            else if (millisecondsInDay >= 25200000 && millisecondsInDay < 52200000)
            {
                open4 = true;
                timeToClose4 = 52200000 - millisecondsInDay;
            }
            else if (millisecondsInDay >= 52200000)
            {
                open4 = false;
                timeToOpen4 = 86400000 - millisecondsInDay + 27900000;
            }
        }
        else if (dayOfWeek == Calendar.FRIDAY)
        {
            if (millisecondsInDay < 25200000)
            {
                open4 = false;
                timeToOpen4 = 25200000 - millisecondsInDay;
            }
            else if (millisecondsInDay >= 25200000 && millisecondsInDay < 52200000)
            {
                open4 = true;
                timeToClose4 = 52200000 - millisecondsInDay;
            }
            else if (millisecondsInDay >= 52200000)
            {
                open4 = false;
                timeToOpen4 = 86400000 - millisecondsInDay + 86400000 * 2 + 25200000;
            }
        }
        else if (dayOfWeek == Calendar.SATURDAY)
        {
            open4 = false;
            timeToOpen4 = 86400000 - millisecondsInDay + 86400000 + 25200000;
        }
        else if (dayOfWeek == Calendar.SUNDAY)
        {
            open4 = false;
            timeToOpen4 = 86400000 - millisecondsInDay + 25200000;
        }

        /*** Cafe Broad ***/
        if (dayOfWeek == Calendar.MONDAY || dayOfWeek == Calendar.TUESDAY
                || dayOfWeek == Calendar.WEDNESDAY
                || dayOfWeek == Calendar.THURSDAY)
        {
            if (millisecondsInDay < 27900000)
            {
                open5 = false;
                timeToOpen5 = 27900000 - millisecondsInDay;
            }
            else if (millisecondsInDay >= 27900000 && millisecondsInDay < 52200000)
            {
                open5 = true;
                timeToClose5 = 52200000 - millisecondsInDay;
            }
            else if (millisecondsInDay >= 52200000)
            {
                open5 = false;
                timeToOpen5 = 86400000 - millisecondsInDay + 27900000;
            }
        }
        else if (dayOfWeek == Calendar.FRIDAY)
        {
            if (millisecondsInDay < 27900000)
            {
                open5 = false;
                timeToOpen5 = 27900000 - millisecondsInDay;
            }
            else if (millisecondsInDay >= 27900000 && millisecondsInDay < 52200000)
            {
                open5 = true;
                timeToClose5 = 52200000 - millisecondsInDay;
            }
            else if (millisecondsInDay >= 52200000)
            {
                open5 = false;
                timeToOpen5 = 86400000 - millisecondsInDay + 86400000 * 2 + 27900000;
            }
        }
        else if (dayOfWeek == Calendar.SATURDAY)
        {
            open5 = false;
            timeToOpen5 = 86400000 - millisecondsInDay + 86400000 + 27900000;
        }
        else if (dayOfWeek == Calendar.SUNDAY)
        {
            open5 = false;
            timeToOpen5 = 86400000 - millisecondsInDay + 27900000;
        }


        final String infoClosingTime = " until closed";
        final String infoOpenTime = " until open";
        final TextView timeView = (TextView) findViewById(R.id.time_view);
        final TextView infoView = (TextView) findViewById(R.id.info_view);
        final TextView titleView = (TextView) findViewById(R.id.title_view);
        final TextView openView = (TextView) findViewById(R.id.open_view);

        final TextView timeView2 = (TextView) findViewById(R.id.time_view2);
        final TextView infoView2 = (TextView) findViewById(R.id.info_view2);
        final TextView titleView2 = (TextView) findViewById(R.id.title_view2);
        final TextView openView2 = (TextView) findViewById(R.id.open_view2);

        final TextView timeView3 = (TextView) findViewById(R.id.time_view3);
        final TextView infoView3 = (TextView) findViewById(R.id.info_view3);
        final TextView titleView3 = (TextView) findViewById(R.id.title_view3);
        final TextView openView3 = (TextView) findViewById(R.id.open_view3);

        final TextView timeView4 = (TextView) findViewById(R.id.time_view4);
        final TextView infoView4 = (TextView) findViewById(R.id.info_view4);
        final TextView titleView4 = (TextView) findViewById(R.id.title_view4);
        final TextView openView4 = (TextView) findViewById(R.id.open_view4);

        final TextView timeView5 = (TextView) findViewById(R.id.time_view5);
        final TextView infoView5 = (TextView) findViewById(R.id.info_view5);
        final TextView titleView5 = (TextView) findViewById(R.id.title_view5);
        final TextView openView5 = (TextView) findViewById(R.id.open_view5);

        if (open) {
            CountDownTimer myCountDownTimer = new CountDownTimer(timeToClose, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    long hoursToClose = millisUntilFinished / 3600000;
                    long minutesToClose = millisUntilFinished / 60000 - hoursToClose * 60;
                    long secondsToClose = millisUntilFinished / 1000 - minutesToClose * 60
                            - hoursToClose * 60 * 60;
                    String minutesToCloseString = Long.toString(minutesToClose);
                    if (minutesToClose < 10)
                    {
                        minutesToCloseString = "0" + minutesToClose;
                    }
                    String secondsToCloseString = Long.toString(secondsToClose);
                    if (secondsToClose < 10) {
                        secondsToCloseString = "0" + secondsToClose;
                    }
                    String time = hoursToClose + ":" + minutesToCloseString
                            + ":" + secondsToCloseString;

                    timeView.setText(time);
                    infoView.setText(infoClosingTime);
                    titleView.setText("C-Store");
                    openView.setText("Open");
                    openView.setTextColor(green);

                }

                @Override
                public void onFinish() {
                    onResume();
                }
            }.start();
        }

        if (open2) {
            CountDownTimer myCountDownTimer = new CountDownTimer(timeToClose2, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    long hoursToClose = millisUntilFinished / 3600000;
                    long minutesToClose = millisUntilFinished / 60000 - hoursToClose * 60;
                    long secondsToClose = millisUntilFinished / 1000 - minutesToClose * 60
                            - hoursToClose * 60 * 60;
                    String minutesToCloseString = Long.toString(minutesToClose);
                    if (minutesToClose < 10)
                    {
                        minutesToCloseString = "0" + minutesToClose;
                    }
                    String secondsToCloseString = Long.toString(secondsToClose);
                    if (secondsToClose < 10) {
                        secondsToCloseString = "0" + secondsToClose;
                    }
                    String time = hoursToClose + ":" + minutesToCloseString
                            + ":" + secondsToCloseString;

                    timeView2.setText(time);
                    infoView2.setText(infoClosingTime);
                    titleView2.setText("Red Door");
                    openView2.setText("Open");
                    openView2.setTextColor(green);
                }

                @Override
                public void onFinish() {
                    onResume();
                }
            }.start();
        }

        if (open3) {
            CountDownTimer myCountDownTimer = new CountDownTimer(timeToClose3, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    long hoursToClose = millisUntilFinished / 3600000;
                    long minutesToClose = millisUntilFinished / 60000 - hoursToClose * 60;
                    long secondsToClose = millisUntilFinished / 1000 - minutesToClose * 60
                            - hoursToClose * 60 * 60;
                    String minutesToCloseString = Long.toString(minutesToClose);
                    if (minutesToClose < 10)
                    {
                        minutesToCloseString = "0" + minutesToClose;
                    }
                    String secondsToCloseString = Long.toString(secondsToClose);
                    if (secondsToClose < 10) {
                        secondsToCloseString = "0" + secondsToClose;
                    }
                    String time = hoursToClose + ":" + minutesToCloseString
                            + ":" + secondsToCloseString;

                    timeView3.setText(time);
                    infoView3.setText(infoClosingTime);
                    titleView3.setText("Bookstore");
                    openView3.setText("Open");
                    openView3.setTextColor(green);
                }

                @Override
                public void onFinish() {
                    onResume();
                }
            }.start();
        }

        if (open4) {
            CountDownTimer myCountDownTimer = new CountDownTimer(timeToClose4, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    long hoursToClose = millisUntilFinished / 3600000;
                    long minutesToClose = millisUntilFinished / 60000 - hoursToClose * 60;
                    long secondsToClose = millisUntilFinished / 1000 - minutesToClose * 60
                            - hoursToClose * 60 * 60;
                    String minutesToCloseString = Long.toString(minutesToClose);
                    if (minutesToClose < 10)
                    {
                        minutesToCloseString = "0" + minutesToClose;
                    }
                    String secondsToCloseString = Long.toString(secondsToClose);
                    if (secondsToClose < 10) {
                        secondsToCloseString = "0" + secondsToClose;
                    }
                    String time = hoursToClose + ":" + minutesToCloseString
                            + ":" + secondsToCloseString;

                    timeView4.setText(time);
                    infoView4.setText(infoClosingTime);
                    titleView4.setText("Chandler");
                    openView4.setText("Open");
                    openView4.setTextColor(green);
                }

                @Override
                public void onFinish() {
                    onResume();
                }
            }.start();
        }

        if (open5) {
            CountDownTimer myCountDownTimer = new CountDownTimer(timeToClose5, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    long hoursToClose = millisUntilFinished / 3600000;
                    long minutesToClose = millisUntilFinished / 60000 - hoursToClose * 60;
                    long secondsToClose = millisUntilFinished / 1000 - minutesToClose * 60
                            - hoursToClose * 60 * 60;
                    String minutesToCloseString = Long.toString(minutesToClose);
                    if (minutesToClose < 10)
                    {
                        minutesToCloseString = "0" + minutesToClose;
                    }
                    String secondsToCloseString = Long.toString(secondsToClose);
                    if (secondsToClose < 10) {
                        secondsToCloseString = "0" + secondsToClose;
                    }
                    String time = hoursToClose + ":" + minutesToCloseString
                            + ":" + secondsToCloseString;

                    timeView5.setText(time);
                    infoView5.setText(infoClosingTime);
                    titleView5.setText("Cafe Broad");
                    openView5.setText("Open");
                    openView5.setTextColor(green);
                }

                @Override
                public void onFinish() {
                    onResume();
                }
            }.start();
        }



        if (!open) {
            CountDownTimer myCountDownTimer = new CountDownTimer(timeToOpen, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    long hoursToOpen = millisUntilFinished / 3600000;
                    long minutesToOpen = millisUntilFinished / 60000 - hoursToOpen * 60;
                    long secondsToOpen = millisUntilFinished / 1000 - minutesToOpen * 60
                            - hoursToOpen * 60 * 60;
                    String minutesToOpenString = Long.toString(minutesToOpen);
                    if (minutesToOpen < 10)
                    {
                        minutesToOpenString = "0" + minutesToOpenString;
                    }
                    String secondsToOpenString = Long.toString(secondsToOpen);
                    if (secondsToOpen < 10) {
                        secondsToOpenString = "0" + secondsToOpen;
                    }

                    String time = hoursToOpen + ":" + minutesToOpenString
                            + ":" + secondsToOpenString;

                    timeView.setText(time);
                    infoView.setText(infoOpenTime);
                    titleView.setText("C-Store");
                    openView.setText("Closed");
                    openView.setTextColor(red);

                }

                @Override
                public void onFinish() {
                    onResume();
                }
            }.start();
        }

        if (!open2) {
            CountDownTimer myCountDownTimer = new CountDownTimer(timeToOpen2, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    long hoursToOpen = millisUntilFinished / 3600000;
                    long minutesToOpen = millisUntilFinished / 60000 - hoursToOpen * 60;
                    long secondsToOpen = millisUntilFinished / 1000 - minutesToOpen * 60
                            - hoursToOpen * 60 * 60;
                    String minutesToOpenString = Long.toString(minutesToOpen);
                    if (minutesToOpen < 10)
                    {
                        minutesToOpenString = "0" + minutesToOpenString;
                    }
                    String secondsToOpenString = Long.toString(secondsToOpen);
                    if (secondsToOpen < 10) {
                        secondsToOpenString = "0" + secondsToOpen;
                    }

                    String time = hoursToOpen + ":" + minutesToOpenString
                            + ":" + secondsToOpenString;

                    timeView2.setText(time);
                    infoView2.setText(infoOpenTime);
                    titleView2.setText("Red Door");
                    openView2.setText("Closed");
                    openView2.setTextColor(red);

                }

                @Override
                public void onFinish() {
                    onResume();
                }
            }.start();
        }

        if (!open3) {
            CountDownTimer myCountDownTimer = new CountDownTimer(timeToOpen3, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    long hoursToOpen = millisUntilFinished / 3600000;
                    long minutesToOpen = millisUntilFinished / 60000 - hoursToOpen * 60;
                    long secondsToOpen = millisUntilFinished / 1000 - minutesToOpen * 60
                            - hoursToOpen * 60 * 60;
                    String minutesToOpenString = Long.toString(minutesToOpen);
                    if (minutesToOpen < 10)
                    {
                        minutesToOpenString = "0" + minutesToOpenString;
                    }
                    String secondsToOpenString = Long.toString(secondsToOpen);
                    if (secondsToOpen < 10) {
                        secondsToOpenString = "0" + secondsToOpen;
                    }

                    String time = hoursToOpen + ":" + minutesToOpenString
                            + ":" + secondsToOpenString;

                    timeView3.setText(time);
                    infoView3.setText(infoOpenTime);
                    titleView3.setText("Bookstore");
                    openView3.setText("Closed");
                    openView3.setTextColor(red);

                }

                @Override
                public void onFinish() {
                    onResume();
                }
            }.start();
        }

        if (!open4) {
        CountDownTimer myCountDownTimer = new CountDownTimer(timeToOpen4, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long hoursToOpen = millisUntilFinished / 3600000;
                long minutesToOpen = millisUntilFinished / 60000 - hoursToOpen * 60;
                long secondsToOpen = millisUntilFinished / 1000 - minutesToOpen * 60
                        - hoursToOpen * 60 * 60;
                String minutesToOpenString = Long.toString(minutesToOpen);
                if (minutesToOpen < 10)
                {
                    minutesToOpenString = "0" + minutesToOpenString;
                }
                String secondsToOpenString = Long.toString(secondsToOpen);
                if (secondsToOpen < 10) {
                    secondsToOpenString = "0" + secondsToOpen;
                }

                String time = hoursToOpen + ":" + minutesToOpenString
                        + ":" + secondsToOpenString;

                timeView4.setText(time);
                infoView4.setText(infoOpenTime);
                titleView4.setText("Chandler");
                openView4.setText("Closed");
                openView4.setTextColor(red);

            }

            @Override
            public void onFinish() {
                onResume();
            }
        }.start();
        }


        if (!open5) {
            CountDownTimer myCountDownTimer = new CountDownTimer(timeToOpen5, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    long hoursToOpen = millisUntilFinished / 3600000;
                    long minutesToOpen = millisUntilFinished / 60000 - hoursToOpen * 60;
                    long secondsToOpen = millisUntilFinished / 1000 - minutesToOpen * 60
                            - hoursToOpen * 60 * 60;
                    String minutesToOpenString = Long.toString(minutesToOpen);
                    if (minutesToOpen < 10)
                    {
                        minutesToOpenString = "0" + minutesToOpenString;
                    }
                    String secondsToOpenString = Long.toString(secondsToOpen);
                    if (secondsToOpen < 10) {
                        secondsToOpenString = "0" + secondsToOpen;
                    }

                    String time = hoursToOpen + ":" + minutesToOpenString
                            + ":" + secondsToOpenString;

                    timeView5.setText(time);
                    infoView5.setText(infoOpenTime);
                    titleView5.setText("Cafe Broad");
                    openView5.setText("Closed");
                    openView5.setTextColor(red);

                }

                @Override
                public void onFinish() {
                    onResume();
                }
            }.start();
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
}
