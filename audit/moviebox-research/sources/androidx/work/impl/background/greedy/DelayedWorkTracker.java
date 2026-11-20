package androidx.work.impl.background.greedy;

import androidx.annotation.NonNull;
import androidx.work.j;
import androidx.work.o;
import java.util.HashMap;
import java.util.Map;
import s6.u;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class DelayedWorkTracker {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f13350d = j.i("DelayedWorkTracker");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f13351a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f13352b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Runnable> f13353c = new HashMap();

    public DelayedWorkTracker(@NonNull a aVar, @NonNull o oVar) {
        this.f13351a = aVar;
        this.f13352b = oVar;
    }

    public void a(@NonNull final u uVar) {
        Runnable runnableRemove = this.f13353c.remove(uVar.f76199a);
        if (runnableRemove != null) {
            this.f13352b.a(runnableRemove);
        }
        Runnable runnable = new Runnable() { // from class: androidx.work.impl.background.greedy.DelayedWorkTracker.1
            @Override // java.lang.Runnable
            public void run() {
                j.e().a(DelayedWorkTracker.f13350d, "Scheduling work " + uVar.f76199a);
                DelayedWorkTracker.this.f13351a.f(uVar);
            }
        };
        this.f13353c.put(uVar.f76199a, runnable);
        this.f13352b.b(uVar.c() - System.currentTimeMillis(), runnable);
    }

    public void b(@NonNull String str) {
        Runnable runnableRemove = this.f13353c.remove(str);
        if (runnableRemove != null) {
            this.f13352b.a(runnableRemove);
        }
    }
}
