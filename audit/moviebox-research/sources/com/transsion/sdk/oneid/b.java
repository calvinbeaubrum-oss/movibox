package com.transsion.sdk.oneid;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@TargetApi(17)
public class b extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f57394a = true;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
            if (this.f57394a) {
                this.f57394a = false;
                return;
            }
            try {
                if (f.m(context)) {
                    e.a(context).l();
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }
}
