package com.google.android.play.core.appupdate;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.play.core.install.InstallState;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class i extends com.google.android.play.core.appupdate.internal.r {
    public i(Context context) {
        super(new com.google.android.play.core.appupdate.internal.s("AppUpdateListenerRegistry"), new IntentFilter("com.google.android.play.core.install.ACTION_INSTALL_STATUS"), context);
    }

    @Override // com.google.android.play.core.appupdate.internal.r
    public final void a(Context context, Intent intent) {
        if (!context.getPackageName().equals(intent.getStringExtra("package.name"))) {
            this.f38057a.a("ListenerRegistryBroadcastReceiver received broadcast for third party app: %s", intent.getStringExtra("package.name"));
            return;
        }
        this.f38057a.a("List of extras in received intent:", new Object[0]);
        for (String str : intent.getExtras().keySet()) {
            this.f38057a.a("Key: %s; value: %s", str, intent.getExtras().get(str));
        }
        InstallState installStateF = InstallState.f(intent, this.f38057a);
        this.f38057a.a("ListenerRegistryBroadcastReceiver.onReceive: %s", installStateF);
        d(installStateF);
    }
}
