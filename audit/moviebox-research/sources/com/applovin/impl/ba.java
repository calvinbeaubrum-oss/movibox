package com.applovin.impl;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.text.TextUtils;
import com.google.android.gms.gcm.Task;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ba {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f17888a = false;

    /* JADX INFO: compiled from: source.java */
    public static final class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    public static int a(String str, String str2) {
        int iGlCreateProgram = GLES20.glCreateProgram();
        a();
        a(35633, str, iGlCreateProgram);
        a(35632, str2, iGlCreateProgram);
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = {0};
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            a("Unable to link shader program: \n" + GLES20.glGetProgramInfoLog(iGlCreateProgram));
        }
        a();
        return iGlCreateProgram;
    }

    public static int a(String[] strArr, String[] strArr2) {
        return a(TextUtils.join("\n", strArr), TextUtils.join("\n", strArr2));
    }

    public static FloatBuffer a(int i11) {
        return ByteBuffer.allocateDirect(i11 * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }

    public static FloatBuffer a(float[] fArr) {
        return (FloatBuffer) a(fArr.length).put(fArr).flip();
    }

    public static void a() {
        int i11 = 0;
        while (true) {
            int iGlGetError = GLES20.glGetError();
            if (iGlGetError == 0) {
                break;
            }
            pc.b("GlUtil", "glError " + GLU.gluErrorString(iGlGetError));
            i11 = iGlGetError;
        }
        if (i11 != 0) {
            a("glError " + GLU.gluErrorString(i11));
        }
    }

    private static void a(int i11, String str, int i12) {
        int iGlCreateShader = GLES20.glCreateShader(i11);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 1) {
            a(GLES20.glGetShaderInfoLog(iGlCreateShader) + ", source: " + str);
        }
        GLES20.glAttachShader(i12, iGlCreateShader);
        GLES20.glDeleteShader(iGlCreateShader);
        a();
    }

    private static void a(String str) {
        pc.b("GlUtil", str);
        if (f17888a) {
            throw new a(str);
        }
    }

    public static boolean a(Context context) {
        String strEglQueryString;
        int i11 = xp.f24372a;
        if (i11 < 24) {
            return false;
        }
        if (i11 >= 26 || !("samsung".equals(xp.f24374c) || "XT1650".equals(xp.f24375d))) {
            return (i11 >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) && (strEglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && strEglQueryString.contains("EGL_EXT_protected_content");
        }
        return false;
    }

    public static int b() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, IntBuffer.wrap(iArr));
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameteri(36197, 10241, 9729);
        GLES20.glTexParameteri(36197, Task.EXTRAS_LIMIT_BYTES, 9729);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        a();
        return iArr[0];
    }

    public static boolean c() {
        String strEglQueryString;
        return xp.f24372a >= 17 && (strEglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) != null && strEglQueryString.contains("EGL_KHR_surfaceless_context");
    }
}
