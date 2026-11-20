package com.cloud.hisavana.sdk.common.http.listener;

import android.os.Handler;
import android.os.Looper;
import com.cloud.hisavana.sdk.common.constant.TaErrorCode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class ResponseBaseListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Handler f29457a;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }
    }

    public ResponseBaseListener() {
        this(Looper.myLooper());
    }

    public ResponseBaseListener(Looper looper) {
        this.f29457a = null;
        this.f29457a = looper != null ? new a(looper) : null;
    }

    public ResponseBaseListener(boolean z11) {
        this(z11 ? null : Looper.myLooper());
    }

    public abstract void a(TaErrorCode taErrorCode);

    public void b(int i11) {
    }

    public void c(int i11, String str, Throwable th2) {
        e(new TaErrorCode(i11, "erro msg = " + str));
    }

    public void d(int i11, byte[] bArr, Throwable th2) {
        e(new TaErrorCode(i11, "erro msg = " + bArr));
    }

    public void e(final TaErrorCode taErrorCode) {
        Handler handler = this.f29457a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener.1
                @Override // java.lang.Runnable
                public void run() {
                    ResponseBaseListener.this.a(taErrorCode);
                }
            });
        } else {
            a(taErrorCode);
        }
    }

    public void f(final int i11) {
        Handler handler = this.f29457a;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.cloud.hisavana.sdk.common.http.listener.ResponseBaseListener.2
                @Override // java.lang.Runnable
                public void run() {
                    ResponseBaseListener.this.b(i11);
                }
            });
        } else {
            b(i11);
        }
    }
}
