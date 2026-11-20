package com.applovin.impl;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Surface;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h7 extends Surface {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static int f19382d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f19383f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f19384a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b f19385b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f19386c;

    /* JADX INFO: compiled from: source.java */
    public static class b extends HandlerThread implements Handler.Callback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private n7 f19387a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Handler f19388b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Error f19389c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private RuntimeException f19390d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private h7 f19391f;

        public b() {
            super("ExoPlayer:DummySurface");
        }

        private void b() {
            b1.a(this.f19387a);
            this.f19387a.d();
        }

        private void b(int i11) {
            b1.a(this.f19387a);
            this.f19387a.a(i11);
            this.f19391f = new h7(this, this.f19387a.c(), i11 != 0);
        }

        public h7 a(int i11) {
            boolean z11;
            start();
            this.f19388b = new Handler(getLooper(), this);
            this.f19387a = new n7(this.f19388b);
            synchronized (this) {
                z11 = false;
                this.f19388b.obtainMessage(1, i11, 0).sendToTarget();
                while (this.f19391f == null && this.f19390d == null && this.f19389c == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z11 = true;
                    }
                }
            }
            if (z11) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.f19390d;
            if (runtimeException != null) {
                throw runtimeException;
            }
            Error error = this.f19389c;
            if (error == null) {
                return (h7) b1.a(this.f19391f);
            }
            throw error;
        }

        public void a() {
            b1.a(this.f19388b);
            this.f19388b.sendEmptyMessage(2);
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i11 = message.what;
            try {
                if (i11 != 1) {
                    if (i11 != 2) {
                        return true;
                    }
                    try {
                        b();
                    } catch (Throwable th2) {
                        try {
                            pc.a("DummySurface", "Failed to release dummy surface", th2);
                        } finally {
                            quit();
                        }
                    }
                    return true;
                }
                try {
                    b(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e11) {
                    pc.a("DummySurface", "Failed to initialize dummy surface", e11);
                    this.f19389c = e11;
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e12) {
                    pc.a("DummySurface", "Failed to initialize dummy surface", e12);
                    this.f19390d = e12;
                    synchronized (this) {
                        notify();
                    }
                }
                return true;
            } catch (Throwable th3) {
                synchronized (this) {
                    notify();
                    throw th3;
                }
            }
        }
    }

    private h7(b bVar, SurfaceTexture surfaceTexture, boolean z11) {
        super(surfaceTexture);
        this.f19385b = bVar;
        this.f19384a = z11;
    }

    private static int a(Context context) {
        if (ba.a(context)) {
            return ba.c() ? 1 : 2;
        }
        return 0;
    }

    public static h7 a(Context context, boolean z11) {
        b1.b(!z11 || b(context));
        return new b().a(z11 ? f19382d : 0);
    }

    public static synchronized boolean b(Context context) {
        try {
            if (!f19383f) {
                f19382d = a(context);
                f19383f = true;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f19382d != 0;
    }

    @Override // android.view.Surface
    public void release() {
        super.release();
        synchronized (this.f19385b) {
            try {
                if (!this.f19386c) {
                    this.f19385b.a();
                    this.f19386c = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
