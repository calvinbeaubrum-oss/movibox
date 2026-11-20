package com.bytedance.sdk.component.adexpress.theme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class ThemeStatusBroadcastReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private WeakReference<sc> f26917sc;

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        int intExtra = intent.getIntExtra("theme_status_change", 0);
        WeakReference<sc> weakReference = this.f26917sc;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f26917sc.get().onThemeChanged(intExtra);
    }

    public void sc(sc scVar) {
        this.f26917sc = new WeakReference<>(scVar);
    }
}
