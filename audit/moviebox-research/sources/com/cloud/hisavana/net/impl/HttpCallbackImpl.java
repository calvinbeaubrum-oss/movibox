package com.cloud.hisavana.net.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.cloud.hisavana.net.utils.CheckUtil;
import java.io.IOException;
import okhttp3.Headers;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class HttpCallbackImpl implements IHttpCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f29018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f29019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f29020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Looper f29021d;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public static class ResponderHandler extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HttpCallbackImpl f29022a;

        public ResponderHandler(HttpCallbackImpl httpCallbackImpl, Looper looper) {
            super(looper);
            this.f29022a = httpCallbackImpl;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.f29022a.h(message);
        }
    }

    public HttpCallbackImpl() {
        this((Looper) null);
    }

    public HttpCallbackImpl(Looper looper) {
        this(looper == null ? Looper.myLooper() : looper, false);
    }

    public HttpCallbackImpl(Looper looper, boolean z11) {
        this.f29021d = null;
        if (z11) {
            CheckUtil.a(looper == null, "use pool thread, looper should be null!");
            this.f29021d = null;
            this.f29018a = null;
        } else {
            CheckUtil.a(looper != null, "use looper thread, must call Looper.prepare() first!");
            this.f29021d = looper;
            this.f29018a = new ResponderHandler(this, looper);
        }
        this.f29020c = z11;
    }

    public HttpCallbackImpl(boolean z11) {
        this(z11 ? null : Looper.myLooper(), z11);
    }

    @Override // com.cloud.hisavana.net.impl.IHttpCallback
    public void a() {
        t(i(2, null));
    }

    @Override // com.cloud.hisavana.net.impl.IHttpCallback
    public void b() {
        t(i(3, null));
    }

    @Override // com.cloud.hisavana.net.impl.IHttpCallback
    public void c(int i11, byte[] bArr, String str) {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        if (i11 >= 300) {
            e(i11, bArr, new IOException());
        } else {
            v(i11, bArr, str);
        }
    }

    @Override // com.cloud.hisavana.net.impl.IHttpCallback
    public void d(int i11, byte[] bArr) {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        if (i11 >= 300) {
            e(i11, bArr, new IOException());
        } else {
            u(i11, bArr);
        }
    }

    @Override // com.cloud.hisavana.net.impl.IHttpCallback
    public void e(int i11, byte[] bArr, Throwable th2) {
        t(i(1, new Object[]{Integer.valueOf(i11), bArr, th2}));
    }

    @Override // com.cloud.hisavana.net.impl.IHttpCallback
    public void f(int i11, byte[] bArr, Headers headers) {
        if (Thread.currentThread().isInterrupted()) {
            return;
        }
        if (i11 >= 300) {
            s(i11, bArr, new IOException(), headers);
        } else {
            w(i11, bArr, headers);
        }
    }

    public boolean g() {
        return this.f29019b;
    }

    public void h(Message message) {
        try {
            int i11 = message.what;
            if (i11 == 0) {
                Object[] objArr = (Object[]) message.obj;
                if (objArr == null || objArr.length < 2) {
                    Log.e("HttpCallbackImpl", "SUCCESS_MESSAGE didn't got enough params");
                    return;
                }
                if (objArr.length < 3) {
                    o(((Integer) objArr[0]).intValue(), (byte[]) objArr[1]);
                    return;
                }
                Object obj = objArr[2];
                if (obj instanceof String) {
                    p(((Integer) objArr[0]).intValue(), (byte[]) objArr[1], (String) objArr[2]);
                    return;
                } else {
                    if (obj instanceof Headers) {
                        m((Headers) obj);
                        o(((Integer) objArr[0]).intValue(), (byte[]) objArr[1]);
                        return;
                    }
                    return;
                }
            }
            if (i11 != 1) {
                if (i11 == 2) {
                    n();
                    return;
                }
                if (i11 == 3) {
                    k();
                    return;
                } else if (i11 != 7) {
                    Log.e("HttpCallbackImpl", "UnKnown message");
                    return;
                } else {
                    l();
                    return;
                }
            }
            Object[] objArr2 = (Object[]) message.obj;
            if (objArr2 == null || objArr2.length < 3) {
                Log.e("HttpCallbackImpl", "FAILURE_MESSAGE didn't got enough params");
                return;
            }
            if (objArr2.length >= 4) {
                Object obj2 = objArr2[3];
                if (obj2 instanceof Headers) {
                    m((Headers) obj2);
                }
            }
            j(((Integer) objArr2[0]).intValue(), (byte[]) objArr2[1], (Throwable) objArr2[2]);
        } catch (Throwable th2) {
            q(th2);
        }
    }

    public Message i(int i11, Object obj) {
        return Message.obtain(this.f29018a, i11, obj);
    }

    public abstract void j(int i11, byte[] bArr, Throwable th2);

    public void k() {
    }

    public void l() {
    }

    public void m(Headers headers) {
    }

    public void n() {
    }

    public abstract void o(int i11, byte[] bArr);

    public void p(int i11, byte[] bArr, String str) {
    }

    public void q(Throwable th2) {
        Log.e("HttpCallbackImpl", "User-space exception detected!", th2);
        throw new RuntimeException(th2);
    }

    public void r(Runnable runnable) {
        Handler handler;
        if (runnable != null) {
            if (g() || (handler = this.f29018a) == null) {
                runnable.run();
            } else {
                handler.post(runnable);
            }
        }
    }

    public void s(int i11, byte[] bArr, Throwable th2, Headers headers) {
        t(i(1, new Object[]{Integer.valueOf(i11), bArr, th2, headers}));
    }

    public void t(Message message) {
        Handler handler;
        if (g() || this.f29018a == null) {
            h(message);
        } else {
            if (Thread.currentThread().isInterrupted() || (handler = this.f29018a) == null) {
                return;
            }
            handler.sendMessage(message);
        }
    }

    public void u(int i11, byte[] bArr) {
        t(i(0, new Object[]{Integer.valueOf(i11), bArr}));
    }

    public void v(int i11, byte[] bArr, String str) {
        t(i(0, new Object[]{Integer.valueOf(i11), bArr, str}));
    }

    public void w(int i11, byte[] bArr, Headers headers) {
        t(i(0, new Object[]{Integer.valueOf(i11), bArr, headers}));
    }
}
