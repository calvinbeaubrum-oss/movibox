package com.google.android.play.core.appupdate.internal;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class y {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final Map f38068o = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f38069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s f38070b;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f38075g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Intent f38076h;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @Nullable
    public ServiceConnection f38080l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    public IInterface f38081m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.google.android.play.core.appupdate.q f38082n;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f38072d = new ArrayList();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set f38073e = new HashSet();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Object f38074f = new Object();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final IBinder.DeathRecipient f38078j = new IBinder.DeathRecipient() { // from class: com.google.android.play.core.appupdate.internal.u
        @Override // android.os.IBinder.DeathRecipient
        public final void binderDied() {
            y.j(this.f38066a);
        }
    };

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final AtomicInteger f38079k = new AtomicInteger(0);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f38071c = "AppUpdateService";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final WeakReference f38077i = new WeakReference(null);

    public y(Context context, s sVar, String str, Intent intent, com.google.android.play.core.appupdate.q qVar, @Nullable v vVar) {
        this.f38069a = context;
        this.f38070b = sVar;
        this.f38076h = intent;
        this.f38082n = qVar;
    }

    public static /* synthetic */ void j(y yVar) {
        yVar.f38070b.d("reportBinderDeath", new Object[0]);
        v vVar = (v) yVar.f38077i.get();
        if (vVar != null) {
            yVar.f38070b.d("calling onBinderDied", new Object[0]);
            vVar.zza();
        } else {
            yVar.f38070b.d("%s : Binder has died.", yVar.f38071c);
            Iterator it = yVar.f38072d.iterator();
            while (it.hasNext()) {
                ((zzn) it.next()).zzc(yVar.v());
            }
            yVar.f38072d.clear();
        }
        synchronized (yVar.f38074f) {
            yVar.w();
        }
    }

    public static /* bridge */ /* synthetic */ void n(final y yVar, final TaskCompletionSource taskCompletionSource) {
        yVar.f38073e.add(taskCompletionSource);
        taskCompletionSource.getTask().addOnCompleteListener(new OnCompleteListener() { // from class: com.google.android.play.core.appupdate.internal.t
            @Override // com.google.android.gms.tasks.OnCompleteListener
            public final void onComplete(Task task) {
                this.f38064a.t(taskCompletionSource, task);
            }
        });
    }

    public static /* bridge */ /* synthetic */ void p(y yVar, zzn zznVar) {
        if (yVar.f38081m != null || yVar.f38075g) {
            if (!yVar.f38075g) {
                zznVar.run();
                return;
            } else {
                yVar.f38070b.d("Waiting to bind to the service.", new Object[0]);
                yVar.f38072d.add(zznVar);
                return;
            }
        }
        yVar.f38070b.d("Initiate binding to the service.", new Object[0]);
        yVar.f38072d.add(zznVar);
        x xVar = new x(yVar, null);
        yVar.f38080l = xVar;
        yVar.f38075g = true;
        if (yVar.f38069a.bindService(yVar.f38076h, xVar, 1)) {
            return;
        }
        yVar.f38070b.d("Failed to bind to the service.", new Object[0]);
        yVar.f38075g = false;
        Iterator it = yVar.f38072d.iterator();
        while (it.hasNext()) {
            ((zzn) it.next()).zzc(new zzy());
        }
        yVar.f38072d.clear();
    }

    public static /* bridge */ /* synthetic */ void q(y yVar) {
        yVar.f38070b.d("linkToDeath", new Object[0]);
        try {
            yVar.f38081m.asBinder().linkToDeath(yVar.f38078j, 0);
        } catch (RemoteException e11) {
            yVar.f38070b.c(e11, "linkToDeath failed", new Object[0]);
        }
    }

    public static /* bridge */ /* synthetic */ void r(y yVar) {
        yVar.f38070b.d("unlinkToDeath", new Object[0]);
        yVar.f38081m.asBinder().unlinkToDeath(yVar.f38078j, 0);
    }

    public final Handler c() {
        Handler handler;
        Map map = f38068o;
        synchronized (map) {
            try {
                if (!map.containsKey(this.f38071c)) {
                    HandlerThread handlerThread = new HandlerThread(this.f38071c, 10);
                    handlerThread.start();
                    map.put(this.f38071c, new Handler(handlerThread.getLooper()));
                }
                handler = (Handler) map.get(this.f38071c);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return handler;
    }

    @Nullable
    public final IInterface e() {
        return this.f38081m;
    }

    public final void s(zzn zznVar, @Nullable TaskCompletionSource taskCompletionSource) {
        c().post(new zzq(this, zznVar.zzb(), taskCompletionSource, zznVar));
    }

    public final /* synthetic */ void t(TaskCompletionSource taskCompletionSource, Task task) {
        synchronized (this.f38074f) {
            this.f38073e.remove(taskCompletionSource);
        }
    }

    public final void u(TaskCompletionSource taskCompletionSource) {
        synchronized (this.f38074f) {
            this.f38073e.remove(taskCompletionSource);
        }
        c().post(new zzr(this));
    }

    public final RemoteException v() {
        return new RemoteException(String.valueOf(this.f38071c).concat(" : Binder has died."));
    }

    public final void w() {
        Iterator it = this.f38073e.iterator();
        while (it.hasNext()) {
            ((TaskCompletionSource) it.next()).trySetException(v());
        }
        this.f38073e.clear();
    }
}
