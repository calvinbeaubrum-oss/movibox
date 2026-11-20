package com.bytedance.sdk.component.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class HomeWatcherReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private sc f27024sc;

    /* JADX INFO: compiled from: source.java */
    public interface sc {
        void pFF();

        void sc();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        try {
            String action = intent.getAction();
            "onReceive: action: ".concat(String.valueOf(action));
            if ("android.intent.action.CLOSE_SYSTEM_DIALOGS".equals(action)) {
                String stringExtra = intent.getStringExtra("reason");
                "reason: ".concat(String.valueOf(stringExtra));
                if ("homekey".equals(stringExtra)) {
                    sc scVar = this.f27024sc;
                    if (scVar != null) {
                        scVar.sc();
                        return;
                    }
                    return;
                }
                if (!"recentapps".equals(stringExtra)) {
                    "assist".equals(stringExtra);
                    return;
                }
                sc scVar2 = this.f27024sc;
                if (scVar2 != null) {
                    scVar2.pFF();
                }
            }
        } catch (Throwable unused) {
            Tf.sc("HomeReceiver", "ACTION_CLOSE_SYSTEM_DIALOGS throw");
        }
    }

    public void sc(sc scVar) {
        this.f27024sc = scVar;
    }
}
