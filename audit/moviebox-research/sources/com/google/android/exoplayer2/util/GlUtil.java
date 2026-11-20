package com.google.android.exoplayer2.util;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLU;
import com.google.android.gms.gcm.Task;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class GlUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f35531a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f35532b = {12344};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f35533c = {12445, 13120, 12344};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f35534d = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f35535e = {12352, 4, 12324, 10, 12323, 10, 12322, 10, 12321, 2, 12325, 0, 12326, 0, 12344};

    /* JADX INFO: compiled from: source.java */
    public static final class GlException extends RuntimeException {
        public GlException(String str) {
            super(str);
        }
    }

    public static void a(int i11, int i12) {
        GLES20.glBindTexture(i11, i12);
        c();
        GLES20.glTexParameteri(i11, Task.EXTRAS_LIMIT_BYTES, 9729);
        c();
        GLES20.glTexParameteri(i11, 10241, 9729);
        c();
        GLES20.glTexParameteri(i11, 10242, 33071);
        c();
        GLES20.glTexParameteri(i11, 10243, 33071);
        c();
    }

    public static void b(boolean z11, String str) {
        if (z11) {
            return;
        }
        j(str);
    }

    public static void c() {
        int i11 = 0;
        while (true) {
            int iGlGetError = GLES20.glGetError();
            if (iGlGetError == 0) {
                break;
            }
            s.c("GlUtil", "glError: " + GLU.gluErrorString(iGlGetError));
            i11 = iGlGetError;
        }
        if (i11 != 0) {
            j("glError: " + GLU.gluErrorString(i11));
        }
    }

    public static FloatBuffer d(int i11) {
        return ByteBuffer.allocateDirect(i11 * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }

    public static FloatBuffer e(float[] fArr) {
        return (FloatBuffer) d(fArr.length).put(fArr).flip();
    }

    public static int f() {
        int iG = g();
        a(36197, iG);
        return iG;
    }

    public static int g() {
        b(!o0.c(EGL14.eglGetCurrentContext(), EGL14.EGL_NO_CONTEXT), "No current context");
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        c();
        return iArr[0];
    }

    public static boolean h(Context context) {
        String strEglQueryString;
        int i11 = o0.f35608a;
        if (i11 < 24) {
            return false;
        }
        if (i11 >= 26 || !("samsung".equals(o0.f35610c) || "XT1650".equals(o0.f35611d))) {
            return (i11 >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (strEglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && strEglQueryString.contains("EGL_EXT_protected_content");
        }
        return false;
    }

    public static boolean i() {
        String strEglQueryString;
        return o0.f35608a >= 17 && (strEglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && strEglQueryString.contains("EGL_KHR_surfaceless_context");
    }

    public static void j(String str) {
        if (f35531a) {
            throw new GlException(str);
        }
        s.c("GlUtil", str);
    }
}
