package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.os.PowerManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.work.impl.u;
import androidx.work.impl.utils.WorkTimer;
import androidx.work.impl.utils.s;
import androidx.work.j;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import r6.n;
import s6.m;
import s6.x;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class f implements p6.c, WorkTimer.a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final String f13394n = j.i("DelayMetCommandHandler");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f13395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m f13397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final SystemAlarmDispatcher f13398d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final p6.e f13399f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f13400g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13401h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Executor f13402i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Executor f13403j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @Nullable
    public PowerManager.WakeLock f13404k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f13405l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final u f13406m;

    public f(@NonNull Context context, int i11, @NonNull SystemAlarmDispatcher systemAlarmDispatcher, @NonNull u uVar) {
        this.f13395a = context;
        this.f13396b = i11;
        this.f13398d = systemAlarmDispatcher;
        this.f13397c = uVar.a();
        this.f13406m = uVar;
        n nVarT = systemAlarmDispatcher.g().t();
        this.f13402i = systemAlarmDispatcher.f().b();
        this.f13403j = systemAlarmDispatcher.f().a();
        this.f13399f = new p6.e(nVarT, this);
        this.f13405l = false;
        this.f13401h = 0;
        this.f13400g = new Object();
    }

    @Override // androidx.work.impl.utils.WorkTimer.a
    public void a(@NonNull m mVar) {
        j.e().a(f13394n, "Exceeded time limits on execution for " + mVar);
        this.f13402i.execute(new d(this));
    }

    @Override // p6.c
    public void b(@NonNull List<s6.u> list) {
        this.f13402i.execute(new d(this));
    }

    @Override // p6.c
    public void e(@NonNull List<s6.u> list) {
        Iterator<s6.u> it = list.iterator();
        while (it.hasNext()) {
            if (x.a(it.next()).equals(this.f13397c)) {
                this.f13402i.execute(new Runnable() { // from class: androidx.work.impl.background.systemalarm.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f13393a.i();
                    }
                });
                return;
            }
        }
    }

    public final void f() {
        synchronized (this.f13400g) {
            try {
                this.f13399f.reset();
                this.f13398d.h().b(this.f13397c);
                PowerManager.WakeLock wakeLock = this.f13404k;
                if (wakeLock != null && wakeLock.isHeld()) {
                    j.e().a(f13394n, "Releasing wakelock " + this.f13404k + "for WorkSpec " + this.f13397c);
                    this.f13404k.release();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void g() {
        String strB = this.f13397c.b();
        this.f13404k = s.b(this.f13395a, strB + " (" + this.f13396b + ")");
        j jVarE = j.e();
        String str = f13394n;
        jVarE.a(str, "Acquiring wakelock " + this.f13404k + "for WorkSpec " + strB);
        this.f13404k.acquire();
        s6.u uVarJ = this.f13398d.g().u().N().j(strB);
        if (uVarJ == null) {
            this.f13402i.execute(new d(this));
            return;
        }
        boolean zH = uVarJ.h();
        this.f13405l = zH;
        if (zH) {
            this.f13399f.a(Collections.singletonList(uVarJ));
            return;
        }
        j.e().a(str, "No constraints for " + strB);
        e(Collections.singletonList(uVarJ));
    }

    public void h(boolean z11) {
        j.e().a(f13394n, "onExecuted " + this.f13397c + ", " + z11);
        f();
        if (z11) {
            this.f13403j.execute(new SystemAlarmDispatcher.AddRunnable(this.f13398d, b.f(this.f13395a, this.f13397c), this.f13396b));
        }
        if (this.f13405l) {
            this.f13403j.execute(new SystemAlarmDispatcher.AddRunnable(this.f13398d, b.a(this.f13395a), this.f13396b));
        }
    }

    public final void i() {
        if (this.f13401h != 0) {
            j.e().a(f13394n, "Already started work for " + this.f13397c);
            return;
        }
        this.f13401h = 1;
        j.e().a(f13394n, "onAllConstraintsMet for " + this.f13397c);
        if (this.f13398d.e().p(this.f13406m)) {
            this.f13398d.h().a(this.f13397c, TTAdConstant.AD_MAX_EVENT_TIME, this);
        } else {
            f();
        }
    }

    public final void j() {
        String strB = this.f13397c.b();
        if (this.f13401h >= 2) {
            j.e().a(f13394n, "Already stopped work for " + strB);
            return;
        }
        this.f13401h = 2;
        j jVarE = j.e();
        String str = f13394n;
        jVarE.a(str, "Stopping work for WorkSpec " + strB);
        this.f13403j.execute(new SystemAlarmDispatcher.AddRunnable(this.f13398d, b.h(this.f13395a, this.f13397c), this.f13396b));
        if (!this.f13398d.e().k(this.f13397c.b())) {
            j.e().a(str, "Processor does not have WorkSpec " + strB + ". No need to reschedule");
            return;
        }
        j.e().a(str, "WorkSpec " + strB + " needs to be rescheduled");
        this.f13403j.execute(new SystemAlarmDispatcher.AddRunnable(this.f13398d, b.f(this.f13395a, this.f13397c), this.f13396b));
    }
}
