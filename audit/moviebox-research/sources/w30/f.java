package w30;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.j;
import java.lang.reflect.Type;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class f<R> implements retrofit2.c<R, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Type f79230a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Scheduler f79231b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f79232c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f79233d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f79234e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f79235f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f79236g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f79237h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f79238i;

    public f(Type type, Scheduler scheduler, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, boolean z16, boolean z17) {
        this.f79230a = type;
        this.f79231b = scheduler;
        this.f79232c = z11;
        this.f79233d = z12;
        this.f79234e = z13;
        this.f79235f = z14;
        this.f79236g = z15;
        this.f79237h = z16;
        this.f79238i = z17;
    }

    @Override // retrofit2.c
    public Type a() {
        return this.f79230a;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0028  */
    /* JADX WARN: Code duplicated, block: B:18:0x0030  */
    /* JADX WARN: Code duplicated, block: B:20:0x0037  */
    /* JADX WARN: Code duplicated, block: B:22:0x003b  */
    /* JADX WARN: Code duplicated, block: B:24:0x0040  */
    /* JADX WARN: Code duplicated, block: B:26:0x0044  */
    /* JADX WARN: Code duplicated, block: B:28:0x0049  */
    /* JADX WARN: Code duplicated, block: B:30:0x004d  */
    /* JADX WARN: Code duplicated, block: B:32:0x0052  */
    @Override // retrofit2.c
    public Object b(retrofit2.b<R> bVar) {
        j aVar;
        Scheduler scheduler;
        j bVar2 = this.f79232c ? new b(bVar) : new c(bVar);
        if (!this.f79233d) {
            if (this.f79234e) {
                aVar = new a(bVar2);
            }
            scheduler = this.f79231b;
            if (scheduler != null) {
                bVar2 = bVar2.A(scheduler);
            }
            if (this.f79235f) {
                return bVar2.B(BackpressureStrategy.LATEST);
            }
            if (this.f79236g) {
                return bVar2.w();
            }
            if (this.f79237h) {
                return bVar2.v();
            }
            return this.f79238i ? bVar2.o() : p10.a.n(bVar2);
        }
        aVar = new e(bVar2);
        bVar2 = aVar;
        scheduler = this.f79231b;
        if (scheduler != null) {
            bVar2 = bVar2.A(scheduler);
        }
        if (this.f79235f) {
            return bVar2.B(BackpressureStrategy.LATEST);
        }
        if (this.f79236g) {
            return bVar2.w();
        }
        if (this.f79237h) {
            return bVar2.v();
        }
        if (this.f79238i) {
        }
    }
}
