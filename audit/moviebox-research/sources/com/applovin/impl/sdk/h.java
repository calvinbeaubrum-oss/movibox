package com.applovin.impl.sdk;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import com.applovin.impl.e4;
import com.applovin.impl.go;
import com.applovin.impl.sj;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
class h implements AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static AlertDialog f22537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final AtomicBoolean f22538d = new AtomicBoolean();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f22539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private go f22540b;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a();

        void b();
    }

    public h(i iVar, j jVar) {
        this.f22539a = iVar;
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(a aVar, DialogInterface dialogInterface, int i11) {
        aVar.b();
        dialogInterface.dismiss();
        f22538d.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(a aVar, j jVar, DialogInterface dialogInterface, int i11) {
        aVar.a();
        dialogInterface.dismiss();
        f22538d.set(false);
        a(((Long) jVar.a(sj.f23093x0)).longValue(), jVar, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(final j jVar, final a aVar) {
        AlertDialog alertDialogCreate = new AlertDialog.Builder(jVar.e().b()).setTitle((CharSequence) jVar.a(sj.f23109z0)).setMessage((CharSequence) jVar.a(sj.A0)).setCancelable(false).setPositiveButton((CharSequence) jVar.a(sj.B0), new DialogInterface.OnClickListener() { // from class: com.applovin.impl.sdk.f0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                h.a(aVar, dialogInterface, i11);
            }
        }).setNegativeButton((CharSequence) jVar.a(sj.C0), new DialogInterface.OnClickListener() { // from class: com.applovin.impl.sdk.g0
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i11) {
                this.f22531a.a(aVar, jVar, dialogInterface, i11);
            }
        }).create();
        f22537c = alertDialogCreate;
        alertDialogCreate.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(final j jVar, final a aVar) {
        if (this.f22539a.f()) {
            jVar.J();
            if (n.a()) {
                jVar.J().b("ConsentAlertManager", "Consent dialog already showing, skip showing of consent alert");
                return;
            }
            return;
        }
        Activity activityB = jVar.e().b();
        if (activityB != null && e4.a(j.l())) {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.d0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f22487a.a(jVar, aVar);
                }
            });
            return;
        }
        if (activityB == null) {
            jVar.J();
            if (n.a()) {
                jVar.J().b("ConsentAlertManager", "No parent Activity found - rescheduling consent alert...");
            }
        } else {
            jVar.J();
            if (n.a()) {
                jVar.J().b("ConsentAlertManager", "No internet available - rescheduling consent alert...");
            }
        }
        f22538d.set(false);
        a(((Long) jVar.a(sj.f23101y0)).longValue(), jVar, aVar);
    }

    public void a(long j11, final j jVar, final a aVar) {
        if (j11 <= 0) {
            return;
        }
        AlertDialog alertDialog = f22537c;
        if (alertDialog == null || !alertDialog.isShowing()) {
            if (f22538d.getAndSet(true)) {
                if (j11 >= this.f22540b.c()) {
                    jVar.J();
                    if (n.a()) {
                        jVar.J().k("ConsentAlertManager", "Skip scheduling consent alert - one scheduled already with remaining time of " + this.f22540b.c() + " milliseconds");
                        return;
                    }
                    return;
                }
                jVar.J();
                if (n.a()) {
                    jVar.J().a("ConsentAlertManager", "Scheduling consent alert earlier (" + j11 + "ms) than remaining scheduled time (" + this.f22540b.c() + "ms)");
                }
                this.f22540b.a();
            }
            jVar.J();
            if (n.a()) {
                jVar.J().a("ConsentAlertManager", "Scheduling consent alert for " + j11 + " milliseconds");
            }
            this.f22540b = go.a(j11, jVar, new Runnable() { // from class: com.applovin.impl.sdk.e0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f22514a.b(jVar, aVar);
                }
            });
        }
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        if (this.f22540b == null) {
            return;
        }
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            this.f22540b.d();
        } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            this.f22540b.e();
        }
    }
}
