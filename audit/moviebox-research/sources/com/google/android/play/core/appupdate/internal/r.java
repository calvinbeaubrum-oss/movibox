package com.google.android.play.core.appupdate.internal;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.annotation.Nullable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f38057a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IntentFilter f38058b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f38059c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f38060d = new HashSet();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    public q f38061e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile boolean f38062f = false;

    public r(s sVar, IntentFilter intentFilter, Context context) {
        this.f38057a = sVar;
        this.f38058b = intentFilter;
        this.f38059c = z.a(context);
    }

    public abstract void a(Context context, Intent intent);

    public final synchronized void b(ej.a aVar) {
        this.f38057a.d("registerListener", new Object[0]);
        d.a(aVar, "Registered Play Core listener should not be null.");
        this.f38060d.add(aVar);
        e();
    }

    public final synchronized void c(ej.a aVar) {
        this.f38057a.d("unregisterListener", new Object[0]);
        d.a(aVar, "Unregistered Play Core listener should not be null.");
        this.f38060d.remove(aVar);
        e();
    }

    public final synchronized void d(Object obj) {
        Iterator it = new HashSet(this.f38060d).iterator();
        while (it.hasNext()) {
            ((ej.a) it.next()).a(obj);
        }
    }

    public final void e() {
        q qVar;
        if (!this.f38060d.isEmpty() && this.f38061e == null) {
            q qVar2 = new q(this, null);
            this.f38061e = qVar2;
            if (Build.VERSION.SDK_INT >= 33) {
                this.f38059c.registerReceiver(qVar2, this.f38058b, 2);
            } else {
                this.f38059c.registerReceiver(qVar2, this.f38058b);
            }
        }
        if (!this.f38060d.isEmpty() || (qVar = this.f38061e) == null) {
            return;
        }
        this.f38059c.unregisterReceiver(qVar);
        this.f38061e = null;
    }
}
