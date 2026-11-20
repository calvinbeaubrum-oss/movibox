package androidx.media3.common.util;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.opengl.Matrix;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.gms.gcm.Task;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import z3.u0;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class GlUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f9453a = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f9454b = {12352, 4, 12324, 10, 12323, 10, 12322, 10, 12321, 2, 12325, 0, 12326, 0, 12344};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f9455c = {12445, 13120, 12344, 12344};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f9456d = {12344};

    /* JADX INFO: compiled from: source.java */
    public static final class GlException extends Exception {
        public GlException(String str) {
            super(str);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(17)
    public static final class a {
        public static void a(String str) throws GlException {
            int iEglGetError = EGL14.eglGetError();
            if (iEglGetError == 12288) {
                return;
            }
            throw new GlException(str + ", error code: 0x" + Integer.toHexString(iEglGetError));
        }

        public static EGLContext b(EGLContext eGLContext, EGLDisplay eGLDisplay, int i11, int[] iArr) throws GlException {
            EGLContext eGLContextEglCreateContext = EGL14.eglCreateContext(eGLDisplay, k(eGLDisplay, iArr), eGLContext, new int[]{12440, i11, 12344}, 0);
            if (eGLContextEglCreateContext != null) {
                GlUtil.b();
                return eGLContextEglCreateContext;
            }
            EGL14.eglTerminate(eGLDisplay);
            throw new GlException("eglCreateContext() failed to create a valid context. The device may not support EGL version " + i11);
        }

        public static EGLSurface c(EGLDisplay eGLDisplay, int[] iArr, int[] iArr2) throws GlException {
            EGLSurface eGLSurfaceEglCreatePbufferSurface = EGL14.eglCreatePbufferSurface(eGLDisplay, k(eGLDisplay, iArr), iArr2, 0);
            a("Error creating a new EGL Pbuffer surface");
            return eGLSurfaceEglCreatePbufferSurface;
        }

        public static EGLSurface d(EGLDisplay eGLDisplay, Object obj, int[] iArr, int[] iArr2) throws GlException {
            EGLSurface eGLSurfaceEglCreateWindowSurface = EGL14.eglCreateWindowSurface(eGLDisplay, k(eGLDisplay, iArr), obj, iArr2, 0);
            a("Error creating a new EGL surface");
            return eGLSurfaceEglCreateWindowSurface;
        }

        public static void e(@Nullable EGLDisplay eGLDisplay, @Nullable EGLContext eGLContext) throws GlException {
            if (eGLDisplay == null) {
                return;
            }
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            a("Error releasing context");
            if (eGLContext != null) {
                EGL14.eglDestroyContext(eGLDisplay, eGLContext);
                a("Error destroying context");
            }
            EGL14.eglReleaseThread();
            a("Error releasing thread");
            EGL14.eglTerminate(eGLDisplay);
            a("Error terminating display");
        }

        public static void f(@Nullable EGLDisplay eGLDisplay, @Nullable EGLSurface eGLSurface) throws GlException {
            if (eGLDisplay == null || eGLSurface == null || EGL14.eglGetCurrentSurface(12377) == EGL14.EGL_NO_SURFACE) {
                return;
            }
            EGL14.eglDestroySurface(eGLDisplay, eGLSurface);
            a("Error destroying surface");
        }

        public static void g(EGLDisplay eGLDisplay, EGLContext eGLContext, EGLSurface eGLSurface, int i11, int i12, int i13) throws GlException {
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, eGLContext);
            a("Error making context current");
            GlUtil.g(i11, i12, i13);
        }

        public static int h() throws GlException {
            int[] iArr = new int[1];
            EGL14.eglQueryContext(EGL14.eglGetDisplay(0), EGL14.eglGetCurrentContext(), 12440, iArr, 0);
            GlUtil.b();
            return iArr[0];
        }

        public static EGLContext i() {
            return EGL14.eglGetCurrentContext();
        }

        public static EGLDisplay j() throws GlException {
            EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
            GlUtil.c(!eGLDisplayEglGetDisplay.equals(EGL14.EGL_NO_DISPLAY), "No EGL display.");
            GlUtil.c(EGL14.eglInitialize(eGLDisplayEglGetDisplay, new int[1], 0, new int[1], 0), "Error in eglInitialize.");
            GlUtil.b();
            return eGLDisplayEglGetDisplay;
        }

        private static EGLConfig k(EGLDisplay eGLDisplay, int[] iArr) throws GlException {
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            if (EGL14.eglChooseConfig(eGLDisplay, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
                return eGLConfigArr[0];
            }
            throw new GlException("eglChooseConfig failed.");
        }

        public static boolean l(String str) {
            String strEglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373);
            return strEglQueryString != null && strEglQueryString.contains(str);
        }
    }

    public static void a(int i11, int i12) throws GlException {
        GLES20.glBindTexture(i11, i12);
        b();
        GLES20.glTexParameteri(i11, Task.EXTRAS_LIMIT_BYTES, 9729);
        b();
        GLES20.glTexParameteri(i11, 10241, 9729);
        b();
        GLES20.glTexParameteri(i11, 10242, 33071);
        b();
        GLES20.glTexParameteri(i11, 10243, 33071);
        b();
    }

    public static void b() throws GlException {
        StringBuilder sb2 = new StringBuilder();
        boolean z11 = false;
        while (true) {
            int iGlGetError = GLES20.glGetError();
            if (iGlGetError == 0) {
                break;
            }
            if (z11) {
                sb2.append('\n');
            }
            String strGluErrorString = GLU.gluErrorString(iGlGetError);
            if (strGluErrorString == null) {
                strGluErrorString = "error code: 0x" + Integer.toHexString(iGlGetError);
            }
            sb2.append("glError: ");
            sb2.append(strGluErrorString);
            z11 = true;
        }
        if (z11) {
            throw new GlException(sb2.toString());
        }
    }

    public static void c(boolean z11, String str) throws GlException {
        if (!z11) {
            throw new GlException(str);
        }
    }

    public static FloatBuffer d(int i11) {
        return ByteBuffer.allocateDirect(i11 * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }

    public static FloatBuffer e(float[] fArr) {
        return (FloatBuffer) d(fArr.length).put(fArr).flip();
    }

    public static int f() throws GlException {
        int iH = h();
        a(36197, iH);
        return iH;
    }

    public static void g(int i11, int i12, int i13) throws GlException {
        int[] iArr = new int[1];
        GLES20.glGetIntegerv(36006, iArr, 0);
        if (iArr[0] != i11) {
            GLES20.glBindFramebuffer(36160, i11);
        }
        b();
        GLES20.glViewport(0, 0, i12, i13);
        b();
    }

    public static int h() throws GlException {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        b();
        return iArr[0];
    }

    public static boolean i(Context context) {
        int i11 = u0.f81838a;
        if (i11 < 24) {
            return false;
        }
        if (i11 < 26 && ("samsung".equals(u0.f81840c) || "XT1650".equals(u0.f81841d))) {
            return false;
        }
        if (i11 >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) {
            return a.l("EGL_EXT_protected_content");
        }
        return false;
    }

    public static boolean j() {
        return u0.f81838a >= 17 && a.l("EGL_KHR_surfaceless_context");
    }

    public static void k(float[] fArr) {
        Matrix.setIdentityM(fArr, 0);
    }
}
