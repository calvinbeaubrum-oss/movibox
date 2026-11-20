package com.google.android.material.snackbar;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static e f37632e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final Object f37633a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Handler f37634b = new Handler(Looper.getMainLooper(), new a());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public c f37635c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public c f37636d;

    /* JADX INFO: compiled from: source.java */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(@NonNull Message message) {
            if (message.what != 0) {
                return false;
            }
            e.this.d((c) message.obj);
            return true;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface b {
        void a(int i11);

        void show();
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final WeakReference<b> f37638a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f37639b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f37640c;

        public c(int i11, b bVar) {
            this.f37638a = new WeakReference<>(bVar);
            this.f37639b = i11;
        }

        public boolean a(@Nullable b bVar) {
            return bVar != null && this.f37638a.get() == bVar;
        }
    }

    public static e c() {
        if (f37632e == null) {
            f37632e = new e();
        }
        return f37632e;
    }

    public final boolean a(@NonNull c cVar, int i11) {
        b bVar = cVar.f37638a.get();
        if (bVar == null) {
            return false;
        }
        this.f37634b.removeCallbacksAndMessages(cVar);
        bVar.a(i11);
        return true;
    }

    public void b(b bVar, int i11) {
        synchronized (this.f37633a) {
            try {
                if (f(bVar)) {
                    a(this.f37635c, i11);
                } else if (g(bVar)) {
                    a(this.f37636d, i11);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void d(@NonNull c cVar) {
        synchronized (this.f37633a) {
            try {
                if (this.f37635c == cVar || this.f37636d == cVar) {
                    a(cVar, 2);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean e(b bVar) {
        boolean z11;
        synchronized (this.f37633a) {
            try {
                z11 = f(bVar) || g(bVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z11;
    }

    public final boolean f(b bVar) {
        c cVar = this.f37635c;
        return cVar != null && cVar.a(bVar);
    }

    public final boolean g(b bVar) {
        c cVar = this.f37636d;
        return cVar != null && cVar.a(bVar);
    }

    public void h(b bVar) {
        synchronized (this.f37633a) {
            try {
                if (f(bVar)) {
                    this.f37635c = null;
                    if (this.f37636d != null) {
                        n();
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void i(b bVar) {
        synchronized (this.f37633a) {
            try {
                if (f(bVar)) {
                    l(this.f37635c);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void j(b bVar) {
        synchronized (this.f37633a) {
            try {
                if (f(bVar)) {
                    c cVar = this.f37635c;
                    if (!cVar.f37640c) {
                        cVar.f37640c = true;
                        this.f37634b.removeCallbacksAndMessages(cVar);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void k(b bVar) {
        synchronized (this.f37633a) {
            try {
                if (f(bVar)) {
                    c cVar = this.f37635c;
                    if (cVar.f37640c) {
                        cVar.f37640c = false;
                        l(cVar);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void l(@NonNull c cVar) {
        int i11 = cVar.f37639b;
        if (i11 == -2) {
            return;
        }
        if (i11 <= 0) {
            i11 = i11 == -1 ? 1500 : 2750;
        }
        this.f37634b.removeCallbacksAndMessages(cVar);
        Handler handler = this.f37634b;
        handler.sendMessageDelayed(Message.obtain(handler, 0, cVar), i11);
    }

    public void m(int i11, b bVar) {
        synchronized (this.f37633a) {
            try {
                if (f(bVar)) {
                    c cVar = this.f37635c;
                    cVar.f37639b = i11;
                    this.f37634b.removeCallbacksAndMessages(cVar);
                    l(this.f37635c);
                    return;
                }
                if (g(bVar)) {
                    this.f37636d.f37639b = i11;
                } else {
                    this.f37636d = new c(i11, bVar);
                }
                c cVar2 = this.f37635c;
                if (cVar2 == null || !a(cVar2, 4)) {
                    this.f37635c = null;
                    n();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void n() {
        c cVar = this.f37636d;
        if (cVar != null) {
            this.f37635c = cVar;
            this.f37636d = null;
            b bVar = cVar.f37638a.get();
            if (bVar != null) {
                bVar.show();
            } else {
                this.f37635c = null;
            }
        }
    }
}
