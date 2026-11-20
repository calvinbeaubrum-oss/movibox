package com.applovin.impl;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.os.Handler;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n7 implements SurfaceTexture.OnFrameAvailableListener, Runnable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int[] f21291h = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12327, 12344, 12339, 4, 12344};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f21292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f21293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private EGLDisplay f21294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private EGLContext f21295d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private EGLSurface f21296f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private SurfaceTexture f21297g;

    /* JADX INFO: compiled from: source.java */
    public static final class b extends RuntimeException {
        private b(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c {
    }

    public n7(Handler handler) {
        this(handler, null);
    }

    public n7(Handler handler, c cVar) {
        this.f21292a = handler;
        this.f21293b = new int[1];
    }

    private static EGLConfig a(EGLDisplay eGLDisplay) {
        EGLConfig eGLConfig;
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        int[] iArr = new int[1];
        boolean zEglChooseConfig = EGL14.eglChooseConfig(eGLDisplay, f21291h, 0, eGLConfigArr, 0, 1, iArr, 0);
        if (!zEglChooseConfig || iArr[0] <= 0 || (eGLConfig = eGLConfigArr[0]) == null) {
            throw new b(xp.a("eglChooseConfig failed: success=%b, numConfigs[0]=%d, configs[0]=%s", Boolean.valueOf(zEglChooseConfig), Integer.valueOf(iArr[0]), eGLConfigArr[0]));
        }
        return eGLConfig;
    }

    private static EGLContext a(EGLDisplay eGLDisplay, EGLConfig eGLConfig, int i11) {
        EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, EGL14.EGL_NO_CONTEXT, i11 == 0 ? new int[]{12440, 2, 12344} : new int[]{12440, 2, 12992, 1, 12344}, 0);
        if (eGLContextEglCreateContext != null) {
            return eGLContextEglCreateContext;
        }
        throw new b("eglCreateContext failed");
    }

    private static EGLSurface a(EGLDisplay eGLDisplay, EGLConfig eGLConfig, EGLContext eGLContext, int i11) {
        EGLSurface eGLSurfaceEglCreatePbufferSurface;
        if (i11 == 1) {
            eGLSurfaceEglCreatePbufferSurface = EGL14.EGL_NO_SURFACE;
        } else {
            eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, eGLConfig, i11 == 2 ? new int[]{12375, 1, 12374, 1, 12992, 1, 12344} : new int[]{12375, 1, 12374, 1, 12344}, 0);
            if (eGLSurfaceEglCreatePbufferSurface == null) {
                throw new b("eglCreatePbufferSurface failed");
            }
        }
        if (EGL14.eglMakeCurrent(eGLDisplay, eGLSurfaceEglCreatePbufferSurface, eGLSurfaceEglCreatePbufferSurface, eGLContext)) {
            return eGLSurfaceEglCreatePbufferSurface;
        }
        throw new b("eglMakeCurrent failed");
    }

    private void a() {
    }

    private static void a(int[] iArr) {
        GLES20.glGenTextures(1, iArr, 0);
        ba.a();
    }

    private static EGLDisplay b() {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        if (eGLDisplayEglGetDisplay == null) {
            throw new b("eglGetDisplay failed");
        }
        int[] iArr = new int[2];
        if (EGL14.eglInitialize(eGLDisplayEglGetDisplay, iArr, 0, iArr, 1)) {
            return eGLDisplayEglGetDisplay;
        }
        throw new b("eglInitialize failed");
    }

    public void a(int i11) {
        EGLDisplay eGLDisplayB = b();
        this.f21294c = eGLDisplayB;
        EGLConfig eGLConfigA = a(eGLDisplayB);
        EGLContext eGLContextA = a(this.f21294c, eGLConfigA, i11);
        this.f21295d = eGLContextA;
        this.f21296f = a(this.f21294c, eGLConfigA, eGLContextA, i11);
        a(this.f21293b);
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f21293b[0]);
        this.f21297g = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
    }

    public SurfaceTexture c() {
        return (SurfaceTexture) b1.a(this.f21297g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void d() {
        this.f21292a.removeCallbacks(this);
        try {
            SurfaceTexture surfaceTexture = this.f21297g;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                GLES20.glDeleteTextures(1, this.f21293b, 0);
            }
        } finally {
            EGLDisplay eGLDisplay = this.f21294c;
            if (eGLDisplay != null && !eGLDisplay.equals(EGL14.EGL_NO_DISPLAY)) {
                EGLDisplay eGLDisplay2 = this.f21294c;
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay2, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            }
            EGLSurface eGLSurface2 = this.f21296f;
            if (eGLSurface2 != null && !eGLSurface2.equals(EGL14.EGL_NO_SURFACE)) {
                EGL14.eglDestroySurface(this.f21294c, this.f21296f);
            }
            EGLContext eGLContext = this.f21295d;
            if (eGLContext != null) {
                EGL14.eglDestroyContext(this.f21294c, eGLContext);
            }
            if (xp.f24372a >= 19) {
                EGL14.eglReleaseThread();
            }
            EGLDisplay eGLDisplay3 = this.f21294c;
            if (eGLDisplay3 != null && !eGLDisplay3.equals(EGL14.EGL_NO_DISPLAY)) {
                EGL14.eglTerminate(this.f21294c);
            }
            this.f21294c = null;
            this.f21295d = null;
            this.f21296f = null;
            this.f21297g = null;
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.f21292a.post(this);
    }

    @Override // java.lang.Runnable
    public void run() {
        a();
        SurfaceTexture surfaceTexture = this.f21297g;
        if (surfaceTexture != null) {
            try {
                surfaceTexture.updateTexImage();
            } catch (RuntimeException unused) {
            }
        }
    }
}
