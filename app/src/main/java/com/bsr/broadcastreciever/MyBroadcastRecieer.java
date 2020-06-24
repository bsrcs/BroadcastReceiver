package com.bsr.broadcastreciever;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;

public class MyBroadcastRecieer extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //sure bittigi zaman yapilacak isleri yakalaycak ve
        // yapilacak isler bu metodun icersinde olacak.
        Toast.makeText(context, "Time is up!", Toast.LENGTH_SHORT).show();
        // vibrate for 2sec
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(2000);
    }
}
