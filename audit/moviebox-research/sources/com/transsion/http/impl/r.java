package com.transsion.http.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class r implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f52873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f52874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f52875c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Looper f52876d;

    /* JADX INFO: compiled from: source.java */
    public static class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r f52877a;

        public a(r rVar, Looper looper) {
            super(looper);
            this.f52877a = rVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.f52877a.i(message);
        }
    }

    public r() {
        this((Looper) null);
    }

    public r(Looper looper) {
        this(looper == null ? Looper.myLooper() : looper, false);
    }

    public r(Looper looper, boolean z11) {
        this.f52876d = null;
        if (z11) {
            bu.b.a(looper == null, "use pool thread, looper should be null!");
            this.f52876d = null;
            this.f52873a = null;
        } else {
            bu.b.a(looper != null, "use looper thread, must call Looper.prepare() first!");
            this.f52876d = looper;
            this.f52873a = new a(this, looper);
        }
        this.f52875c = z11;
    }

    public r(boolean z11) {
        this(z11 ? null : Looper.myLooper(), z11);
    }

    public void A(int i11, byte[] bArr, String str) {
        k(h(0, new Object[]{Integer.valueOf(i11), bArr, str}));
    }

    public void B(int i11, byte[] bArr, Map<String, List<String>> map) {
        k(h(0, new Object[]{Integer.valueOf(i11), bArr, map}));
    }

    @Override // com.transsion.http.impl.s
    public void a() {
        k(h(2, null));
    }

    @Override // com.transsion.http.impl.s
    public void b() {
        k(h(3, null));
    }

    @Override // com.transsion.http.impl.s
    public void c(int i11, byte[] bArr, String str) {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        if (i11 >= 300) {
            e(i11, bArr, new IOException());
        } else {
            A(i11, bArr, str);
        }
    }

    @Override // com.transsion.http.impl.s
    public void d(int i11, byte[] bArr) {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        if (i11 >= 300) {
            e(i11, bArr, new IOException());
        } else {
            z(i11, bArr);
        }
    }

    @Override // com.transsion.http.impl.s
    public void e(int i11, byte[] bArr, Throwable th2) {
        k(h(1, new Object[]{Integer.valueOf(i11), bArr, th2}));
    }

    @Override // com.transsion.http.impl.s
    public void f(int i11, byte[] bArr, Map<String, List<String>> map) {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        if (i11 >= 300) {
            y(i11, bArr, new IOException(), map);
        } else {
            B(i11, bArr, map);
        }
    }

    @Override // com.transsion.http.impl.s
    public final void g() {
        k(h(6, null));
    }

    public Message h(int i11, Object obj) {
        return Message.obtain(this.f52873a, i11, obj);
    }

    public void i(Message message) {
        try {
            switch (message.what) {
                case 0:
                    Object[] objArr = (Object[]) message.obj;
                    if (objArr == null || objArr.length < 2) {
                        zt.a.f82154a.e("HttpCallbackImpl", "SUCCESS_MESSAGE didn't got enough params");
                        return;
                    }
                    if (objArr.length < 3) {
                        v(((Integer) objArr[0]).intValue(), (byte[]) objArr[1]);
                        return;
                    }
                    Object obj = objArr[2];
                    if (obj instanceof String) {
                        w(((Integer) objArr[0]).intValue(), (byte[]) objArr[1], (String) objArr[2]);
                        return;
                    } else {
                        if (obj instanceof Map) {
                            v(((Integer) objArr[0]).intValue(), (byte[]) objArr[1]);
                            s((Map) objArr[2]);
                            return;
                        }
                        return;
                    }
                case 1:
                    Object[] objArr2 = (Object[]) message.obj;
                    if (objArr2 == null || objArr2.length < 3) {
                        zt.a.f82154a.e("HttpCallbackImpl", "FAILURE_MESSAGE didn't got enough params");
                        return;
                    }
                    if (objArr2.length >= 4) {
                        Object obj2 = objArr2[3];
                        if (obj2 instanceof Map) {
                            s((Map) obj2);
                        }
                    }
                    o(((Integer) objArr2[0]).intValue(), (byte[]) objArr2[1], (Throwable) objArr2[2]);
                    return;
                case 2:
                    u();
                    return;
                case 3:
                    p();
                    return;
                case 4:
                    Object[] objArr3 = (Object[]) message.obj;
                    if (objArr3 == null || objArr3.length < 2) {
                        zt.a.f82154a.e("HttpCallbackImpl", "PROGRESS_MESSAGE didn't got enough params");
                        return;
                    }
                    try {
                        r(((Long) objArr3[0]).longValue(), ((Long) objArr3[1]).longValue());
                        return;
                    } catch (Throwable th2) {
                        zt.a.f82154a.e("HttpCallbackImpl", "custom onProgress contains an error", th2);
                        return;
                    }
                case 5:
                    Object[] objArr4 = (Object[]) message.obj;
                    if (objArr4 == null || objArr4.length != 1) {
                        zt.a.f82154a.e("HttpCallbackImpl", "RETRY_MESSAGE didn't get enough params");
                        return;
                    } else {
                        t(((Integer) objArr4[0]).intValue());
                        return;
                    }
                case 6:
                    n();
                    return;
                case 7:
                    q();
                    return;
                default:
                    return;
            }
        } catch (Throwable th3) {
            x(th3);
        }
        x(th3);
    }

    public void j(Runnable runnable) {
        Handler handler;
        if (runnable != null) {
            if (m() || (handler = this.f52873a) == null) {
                runnable.run();
            } else {
                handler.post(runnable);
            }
        }
    }

    public void k(Message message) {
        if (m() || this.f52873a == null) {
            i(message);
        } else {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }
            bu.b.a(this.f52873a != null, "handler should not be null!");
            this.f52873a.sendMessage(message);
        }
    }

    public boolean l() {
        return this.f52875c;
    }

    public boolean m() {
        return this.f52874b;
    }

    public void n() {
        zt.a.f82154a.d("HttpCallbackImpl", "Request got cancelled");
    }

    public abstract void o(int i11, byte[] bArr, Throwable th2);

    public void p() {
    }

    public void q() {
        zt.a.f82154a.d("HttpCallbackImpl", "Request got onPaused");
    }

    public void r(long j11, long j12) {
        zt.c cVar = zt.a.f82154a;
        Object[] objArr = new Object[3];
        objArr[0] = Long.valueOf(j11);
        objArr[1] = Long.valueOf(j12);
        objArr[2] = Double.valueOf(j12 > 0 ? ((j11 * 1.0d) / j12) * 100.0d : -1.0d);
        cVar.v("HttpCallbackImpl", String.format("Progress %d from %d (%2.0f%%)", objArr));
    }

    public void s(Map<String, List<String>> map) {
    }

    public void t(int i11) {
        zt.a.f82154a.d("HttpCallbackImpl", String.format("Request retry no. %d", Integer.valueOf(i11)));
    }

    public void u() {
    }

    public abstract void v(int i11, byte[] bArr);

    public void w(int i11, byte[] bArr, String str) {
    }

    public void x(Throwable th2) {
        zt.a.f82154a.e("HttpCallbackImpl", "User-space exception detected!", th2);
        throw new RuntimeException(th2);
    }

    public void y(int i11, byte[] bArr, Throwable th2, Map<String, List<String>> map) {
        k(h(1, new Object[]{Integer.valueOf(i11), bArr, th2, map}));
    }

    public void z(int i11, byte[] bArr) {
        k(h(0, new Object[]{Integer.valueOf(i11), bArr}));
    }
}
