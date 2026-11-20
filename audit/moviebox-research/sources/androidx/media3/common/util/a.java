package androidx.media3.common.util;

import android.opengl.GLES20;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9457a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0089a[] f9458b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b[] f9459c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, C0089a> f9460d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, b> f9461e;

    /* JADX INFO: renamed from: androidx.media3.common.util.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0089a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f9462a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f9463b;

        public C0089a(String str, int i11) {
            this.f9462a = str;
            this.f9463b = i11;
        }

        public static C0089a a(int i11, int i12) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i11, 35722, iArr, 0);
            int i13 = iArr[0];
            byte[] bArr = new byte[i13];
            GLES20.glGetActiveAttrib(i11, i12, i13, new int[1], 0, new int[1], 0, new int[1], 0, bArr, 0);
            String str = new String(bArr, 0, a.h(bArr));
            return new C0089a(str, a.f(i11, str));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f9464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f9465b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f9466c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float[] f9467d = new float[16];

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int[] f9468e = new int[4];

        public b(String str, int i11, int i12) {
            this.f9464a = str;
            this.f9465b = i11;
            this.f9466c = i12;
        }

        public static b a(int i11, int i12) {
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(i11, 35719, iArr, 0);
            int[] iArr2 = new int[1];
            int i13 = iArr[0];
            byte[] bArr = new byte[i13];
            GLES20.glGetActiveUniform(i11, i12, i13, new int[1], 0, new int[1], 0, iArr2, 0, bArr, 0);
            String str = new String(bArr, 0, a.h(bArr));
            return new b(str, a.i(i11, str), iArr2[0]);
        }
    }

    public a(String str, String str2) throws GlUtil.GlException {
        int iGlCreateProgram = GLES20.glCreateProgram();
        this.f9457a = iGlCreateProgram;
        GlUtil.b();
        d(iGlCreateProgram, 35633, str);
        d(iGlCreateProgram, 35632, str2);
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = {0};
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        GlUtil.c(iArr[0] == 1, "Unable to link shader program: \n" + GLES20.glGetProgramInfoLog(iGlCreateProgram));
        GLES20.glUseProgram(iGlCreateProgram);
        this.f9460d = new HashMap();
        int[] iArr2 = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35721, iArr2, 0);
        this.f9458b = new C0089a[iArr2[0]];
        for (int i11 = 0; i11 < iArr2[0]; i11++) {
            C0089a c0089aA = C0089a.a(this.f9457a, i11);
            this.f9458b[i11] = c0089aA;
            this.f9460d.put(c0089aA.f9462a, c0089aA);
        }
        this.f9461e = new HashMap();
        int[] iArr3 = new int[1];
        GLES20.glGetProgramiv(this.f9457a, 35718, iArr3, 0);
        this.f9459c = new b[iArr3[0]];
        for (int i12 = 0; i12 < iArr3[0]; i12++) {
            b bVarA = b.a(this.f9457a, i12);
            this.f9459c[i12] = bVarA;
            this.f9461e.put(bVarA.f9464a, bVarA);
        }
        GlUtil.b();
    }

    public static void d(int i11, int i12, String str) throws GlUtil.GlException {
        int iGlCreateShader = GLES20.glCreateShader(i12);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = {0};
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        GlUtil.c(iArr[0] == 1, GLES20.glGetShaderInfoLog(iGlCreateShader) + ", source: " + str);
        GLES20.glAttachShader(i11, iGlCreateShader);
        GLES20.glDeleteShader(iGlCreateShader);
        GlUtil.b();
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

    public int e(String str) throws GlUtil.GlException {
        int iG = g(str);
        GLES20.glEnableVertexAttribArray(iG);
        GlUtil.b();
        return iG;
    }

    public final int g(String str) {
        return f(this.f9457a, str);
    }

    public int j(String str) {
        return i(this.f9457a, str);
    }
}
