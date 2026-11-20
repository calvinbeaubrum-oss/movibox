package com.bytedance.sdk.openadsdk.core.theme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class ThemeStatusBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private WeakReference<Object> f28522sc;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        intent.getIntExtra("theme_status_change", 0);
        WeakReference<Object> weakReference = this.f28522sc;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f28522sc.get();
    }
}
