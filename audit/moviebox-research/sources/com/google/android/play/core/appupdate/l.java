package com.google.android.play.core.appupdate;

import android.app.Activity;
import android.content.Context;
import android.content.IntentSender;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.Task;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class l implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f38085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i f38086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f38087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f38088d = new Handler(Looper.getMainLooper());

    public l(u uVar, i iVar, Context context) {
        this.f38085a = uVar;
        this.f38086b = iVar;
        this.f38087c = context;
    }

    @Override // com.google.android.play.core.appupdate.b
    public final synchronized void a(cj.a aVar) {
        this.f38086b.c(aVar);
    }

    @Override // com.google.android.play.core.appupdate.b
    public final synchronized void b(cj.a aVar) {
        this.f38086b.b(aVar);
    }

    @Override // com.google.android.play.core.appupdate.b
    public final Task<Void> c() {
        return this.f38085a.d(this.f38087c.getPackageName());
    }

    @Override // com.google.android.play.core.appupdate.b
    public final Task<a> d() {
        return this.f38085a.e(this.f38087c.getPackageName());
    }

    @Override // com.google.android.play.core.appupdate.b
    public final boolean e(a aVar, int i11, Activity activity, int i12) throws IntentSender.SendIntentException {
        d dVarC = d.c(i11);
        if (activity == null) {
            return false;
        }
        return f(aVar, new k(this, activity), dVarC, i12);
    }

    public final boolean f(a aVar, bj.a aVar2, d dVar, int i11) throws IntentSender.SendIntentException {
        if (aVar == null || aVar2 == null || dVar == null || !aVar.c(dVar) || aVar.h()) {
            return false;
        }
        aVar.g();
        aVar2.a(aVar.e(dVar).getIntentSender(), i11, null, 0, 0, 0, null);
        return true;
    }
}
