package com.google.android.exoplayer2.util;

import android.opengl.GLES20;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f35595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a[] f35596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b[] f35597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, a> f35598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, b> f35599e;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f35600a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f35601b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f35602c;

        public a(String str, int i11, int i12) {
            this.f35600a = str;
            this.f35601b = i11;
            this.f35602c = i12;
        }

        public static a a(int i11, int i12) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i11, 35722, iArr, 0);
            int i13 = iArr[0];
            byte[] bArr = new byte[i13];
            GLES20.glGetActiveAttrib(i11, i12, i13, new int[1], 0, new int[1], 0, new int[1], 0, bArr, 0);
            String str = new String(bArr, 0, n.h(bArr));
            return new a(str, i12, n.f(i11, str));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f35603a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f35604b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f35605c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float[] f35606d = new float[16];

        public b(String str, int i11, int i12) {
            this.f35603a = str;
            this.f35604b = i11;
            this.f35605c = i12;
        }

        public static b a(int i11, int i12) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i11, 35719, iArr, 0);
            int[] iArr2 = new int[1];
            int i13 = iArr[0];
            byte[] bArr = new byte[i13];
            GLES20.glGetActiveUniform(i11, i12, i13, new int[1], 0, new int[1], 0, iArr2, 0, bArr, 0);
            String str = new String(bArr, 0, n.h(bArr));
            return new b(str, n.i(i11, str), iArr2[0]);
        }
    }

    public n(String str, String str2) {
        int iGlCreateProgram = GLES20.glCreateProgram();
        this.f35595a = iGlCreateProgram;
        GlUtil.c();
        d(iGlCreateProgram, 35633, str);
        d(iGlCreateProgram, 35632, str2);
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = {0};
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] != 1) {
            GlUtil.j("Unable to link shader program: \n" + GLES20.glGetProgramInfoLog(iGlCreateProgram));
        }
        GLES20.glUseProgram(iGlCreateProgram);
        this.f35598d = new HashMap();
        int[] iArr2 = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35721, iArr2, 0);
        this.f35596b = new a[iArr2[0]];
        for (int i11 = 0; i11 < iArr2[0]; i11++) {
            a aVarA = a.a(this.f35595a, i11);
            this.f35596b[i11] = aVarA;
            this.f35598d.put(aVarA.f35600a, aVarA);
        }
        this.f35599e = new HashMap();
        int[] iArr3 = new int[1];
        GLES20.glGetProgramiv(this.f35595a, 35718, iArr3, 0);
        this.f35597c = new b[iArr3[0]];
        for (int i12 = 0; i12 < iArr3[0]; i12++) {
            b bVarA = b.a(this.f35595a, i12);
            this.f35597c[i12] = bVarA;
            this.f35599e.put(bVarA.f35603a, bVarA);
        }
        GlUtil.c();
    }

    public static void d(int i11, int i12, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i12);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 1) {
            GlUtil.j(GLES20.glGetShaderInfoLog(iGlCreateShader) + ", source: " + str);
        }
        GLES20.glAttachShader(i11, iGlCreateShader);
        GLES20.glDeleteShader(iGlCreateShader);
        GlUtil.c();
    }

    public static int f(int i11, String str) {
        return GLES20.glGetAttribLocation(i11, str);
    }

    public static int h(byte[] bArr) {
        for (int i11 = 0; i11 < bArr.length; i11++) {
            if (bArr[i11] == 0) {
                return i11;
            }
        }
        return bArr.length;
    }

    public static int i(int i11, String str) {
        return GLES20.glGetUniformLocation(i11, str);
    }

    public int e(String str) {
        int iG = g(str);
        GLES20.glEnableVertexAttribArray(iG);
        GlUtil.c();
        return iG;
    }

    public final int g(String str) {
        return f(this.f35595a, str);
    }

    public int j(String str) {
        return i(this.f35595a, str);
    }
}
