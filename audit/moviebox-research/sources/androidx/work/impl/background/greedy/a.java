package androidx.work.impl.background.greedy;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.work.WorkInfo;
import androidx.work.impl.d0;
import androidx.work.impl.e;
import androidx.work.impl.s;
import androidx.work.impl.utils.p;
import androidx.work.impl.v;
import androidx.work.j;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import p6.c;
import p6.d;
import r6.n;
import s6.m;
import s6.u;
import s6.x;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements s, c, e {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final String f13354k = j.i("GreedyScheduler");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f13355a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0 f13356b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d f13357c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public DelayedWorkTracker f13359f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f13360g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Boolean f13363j;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<u> f13358d = new HashSet();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final v f13362i = new v();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f13361h = new Object();

    public a(@NonNull Context context, @NonNull androidx.work.a aVar, @NonNull n nVar, @NonNull d0 d0Var) {
        this.f13355a = context;
        this.f13356b = d0Var;
        this.f13357c = new p6.e(nVar, this);
        this.f13359f = new DelayedWorkTracker(this, aVar.k());
    }

    @Override // androidx.work.impl.s
    public void a(@NonNull String str) {
        if (this.f13363j == null) {
            g();
        }
        if (!this.f13363j.booleanValue()) {
            j.e().f(f13354k, "Ignoring schedule request in non-main process");
            return;
        }
        h();
        j.e().a(f13354k, "Cancelling work ID " + str);
        DelayedWorkTracker delayedWorkTracker = this.f13359f;
        if (delayedWorkTracker != null) {
            delayedWorkTracker.b(str);
        }
        Iterator<androidx.work.impl.u> it = this.f13362i.c(str).iterator();
        while (it.hasNext()) {
            this.f13356b.D(it.next());
        }
    }

    @Override // p6.c
    public void b(@NonNull List<u> list) {
        Iterator<u> it = list.iterator();
        while (it.hasNext()) {
            m mVarA = x.a(it.next());
            j.e().a(f13354k, "Constraints not met: Cancelling work ID " + mVarA);
            androidx.work.impl.u uVarB = this.f13362i.b(mVarA);
            if (uVarB != null) {
                this.f13356b.D(uVarB);
            }
        }
    }

    @Override // androidx.work.impl.e
    /* JADX INFO: renamed from: c */
    public void l(@NonNull m mVar, boolean z11) {
        this.f13362i.b(mVar);
        i(mVar);
    }

    @Override // androidx.work.impl.s
    public boolean d() {
        return false;
    }

    @Override // p6.c
    public void e(@NonNull List<u> list) {
        Iterator<u> it = list.iterator();
        while (it.hasNext()) {
            m mVarA = x.a(it.next());
            if (!this.f13362i.a(mVarA)) {
                j.e().a(f13354k, "Constraints met: Scheduling work ID " + mVarA);
                this.f13356b.A(this.f13362i.d(mVarA));
            }
        }
    }

    @Override // androidx.work.impl.s
    public void f(@NonNull u... uVarArr) {
        if (this.f13363j == null) {
            g();
        }
        if (!this.f13363j.booleanValue()) {
            j.e().f(f13354k, "Ignoring schedule request in a secondary process");
            return;
        }
        h();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (u uVar : uVarArr) {
            if (!this.f13362i.a(x.a(uVar))) {
                long jC = uVar.c();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (uVar.f76200b == WorkInfo.State.ENQUEUED) {
                    if (jCurrentTimeMillis < jC) {
                        DelayedWorkTracker delayedWorkTracker = this.f13359f;
                        if (delayedWorkTracker != null) {
                            delayedWorkTracker.a(uVar);
                        }
                    } else if (uVar.h()) {
                        int i11 = Build.VERSION.SDK_INT;
                        if (i11 >= 23 && uVar.f76208j.h()) {
                            j.e().a(f13354k, "Ignoring " + uVar + ". Requires device idle.");
                        } else if (i11 < 24 || !uVar.f76208j.e()) {
                            hashSet.add(uVar);
                            hashSet2.add(uVar.f76199a);
                        } else {
                            j.e().a(f13354k, "Ignoring " + uVar + ". Requires ContentUri triggers.");
                        }
                    } else if (!this.f13362i.a(x.a(uVar))) {
                        j.e().a(f13354k, "Starting work for " + uVar.f76199a);
                        this.f13356b.A(this.f13362i.e(uVar));
                    }
                }
            }
        }
        synchronized (this.f13361h) {
            try {
                if (!hashSet.isEmpty()) {
                    j.e().a(f13354k, "Starting tracking for " + TextUtils.join(",", hashSet2));
                    this.f13358d.addAll(hashSet);
                    this.f13357c.a(this.f13358d);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void g() {
        this.f13363j = Boolean.valueOf(p.b(this.f13355a, this.f13356b.n()));
    }

    public final void h() {
        if (this.f13360g) {
            return;
        }
        this.f13356b.r().g(this);
        this.f13360g = true;
    }

    public final void i(@NonNull m mVar) {
        synchronized (this.f13361h) {
            try {
                for (u uVar : this.f13358d) {
                    if (x.a(uVar).equals(mVar)) {
                        j.e().a(f13354k, "Stopping tracking for " + mVar);
                        this.f13358d.remove(uVar);
                        this.f13357c.a(this.f13358d);
                        break;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
