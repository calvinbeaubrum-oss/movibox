package androidx.dynamicanimation.animation;

import android.os.SystemClock;
import android.view.Choreographer;
import androidx.annotation.RequiresApi;
import androidx.collection.v0;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ThreadLocal<a> f8224g = new ThreadLocal<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f8228d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v0<b, Long> f8225a = new v0<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<b> f8226b = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0079a f8227c = new C0079a();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f8229e = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f8230f = false;

    /* JADX INFO: renamed from: androidx.dynamicanimation.animation.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public class C0079a {
        public C0079a() {
        }

        public void a() {
            a.this.f8229e = SystemClock.uptimeMillis();
            a aVar = a.this;
            aVar.c(aVar.f8229e);
            if (a.this.f8226b.size() > 0) {
                a.this.e().a();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        boolean a(long j11);
    }

    /* JADX INFO: compiled from: source.java */
    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C0079a f8232a;

        public c(C0079a c0079a) {
            this.f8232a = c0079a;
        }

        public abstract void a();
    }

    /* JADX INFO: compiled from: source.java */
    public static class d extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f8233b;
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(16)
    public static class e extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Choreographer f8234b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Choreographer.FrameCallback f8235c;

        /* JADX INFO: renamed from: androidx.dynamicanimation.animation.a$e$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public class ChoreographerFrameCallbackC0080a implements Choreographer.FrameCallback {
            public ChoreographerFrameCallbackC0080a() {
            }

            @Override // android.view.Choreographer.FrameCallback
            public void doFrame(long j11) {
                e.this.f8232a.a();
            }
        }

        public e(C0079a c0079a) {
            super(c0079a);
            this.f8234b = Choreographer.getInstance();
            this.f8235c = new ChoreographerFrameCallbackC0080a();
        }

        @Override // androidx.dynamicanimation.animation.a.c
        public void a() {
            this.f8234b.postFrameCallback(this.f8235c);
        }
    }

    public static a d() {
        ThreadLocal<a> threadLocal = f8224g;
        if (threadLocal.get() == null) {
            threadLocal.set(new a());
        }
        return threadLocal.get();
    }

    public void a(b bVar, long j11) {
        if (this.f8226b.size() == 0) {
            e().a();
        }
        if (!this.f8226b.contains(bVar)) {
            this.f8226b.add(bVar);
        }
        if (j11 > 0) {
            this.f8225a.put(bVar, Long.valueOf(SystemClock.uptimeMillis() + j11));
        }
    }

    public final void b() {
        if (this.f8230f) {
            for (int size = this.f8226b.size() - 1; size >= 0; size--) {
                if (this.f8226b.get(size) == null) {
                    this.f8226b.remove(size);
                }
            }
            this.f8230f = false;
        }
    }

    public void c(long j11) {
        long jUptimeMillis = SystemClock.uptimeMillis();
        for (int i11 = 0; i11 < this.f8226b.size(); i11++) {
            b bVar = this.f8226b.get(i11);
            if (bVar != null && f(bVar, jUptimeMillis)) {
                bVar.a(j11);
            }
        }
        b();
    }

    public c e() {
        if (this.f8228d == null) {
            this.f8228d = new e(this.f8227c);
        }
        return this.f8228d;
    }

    public final boolean f(b bVar, long j11) {
        Long l11 = this.f8225a.get(bVar);
        if (l11 == null) {
            return true;
        }
        if (l11.longValue() >= j11) {
            return false;
        }
        this.f8225a.remove(bVar);
        return true;
    }

    public void g(b bVar) {
        this.f8225a.remove(bVar);
        int iIndexOf = this.f8226b.indexOf(bVar);
        if (iIndexOf >= 0) {
            this.f8226b.set(iIndexOf, null);
            this.f8230f = true;
        }
    }
}
