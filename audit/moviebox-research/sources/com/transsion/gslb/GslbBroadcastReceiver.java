package com.transsion.gslb;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class GslbBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Worker worker;
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            try {
                if (!Utils.isNetworkAvailable(context) || (worker = GslbSdk.getWorker()) == null) {
                    return;
                }
                worker.retry();
            } catch (Exception e11) {
                Utils.LOG.i(Log.getStackTraceString(e11));
            }
        }
    }
}
