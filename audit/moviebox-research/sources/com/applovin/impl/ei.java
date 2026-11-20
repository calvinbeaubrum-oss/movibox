package com.applovin.impl;

import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class ei {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final String[] f18727j = {"uniform mat4 uMvpMatrix;", "uniform mat3 uTexMatrix;", "attribute vec4 aPosition;", "attribute vec2 aTexCoords;", "varying vec2 vTexCoords;", "void main() {", "  gl_Position = uMvpMatrix * aPosition;", "  vTexCoords = (uTexMatrix * vec3(aTexCoords, 1)).xy;", "}"};

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final String[] f18728k = {"#extension GL_OES_EGL_image_external : require", "precision mediump float;", "uniform samplerExternalOES uTexture;", "varying vec2 vTexCoords;", "void main() {", "  gl_FragColor = texture2D(uTexture, vTexCoords);", "}"};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final float[] f18729l = {1.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final float[] f18730m = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 0.5f, 1.0f};

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final float[] f18731n = {1.0f, 0.0f, 0.0f, 0.0f, -0.5f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static final float[] f18732o = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static final float[] f18733p = {0.5f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.5f, 1.0f, 1.0f};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18734a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f18735b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f18736c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f18737d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f18738e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f18739f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f18740g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f18741h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f18742i;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f18743a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final FloatBuffer f18744b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final FloatBuffer f18745c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f18746d;

        public a(ci.b bVar) {
            this.f18743a = bVar.a();
            this.f18744b = ba.a(bVar.f18199c);
            this.f18745c = ba.a(bVar.f18200d);
            int i11 = bVar.f18198b;
            if (i11 == 1) {
                this.f18746d = 5;
            } else if (i11 != 2) {
                this.f18746d = 4;
            } else {
                this.f18746d = 6;
            }
        }
    }

    public static boolean a(ci ciVar) {
        ci.a aVar = ciVar.f18192a;
        ci.a aVar2 = ciVar.f18193b;
        return aVar.a() == 1 && aVar.a(0).f18197a == 0 && aVar2.a() == 1 && aVar2.a(0).f18197a == 0;
    }

    public void a() {
        int iA = ba.a(f18727j, f18728k);
        this.f18737d = iA;
        this.f18738e = GLES20.glGetUniformLocation(iA, "uMvpMatrix");
        this.f18739f = GLES20.glGetUniformLocation(this.f18737d, "uTexMatrix");
        this.f18740g = GLES20.glGetAttribLocation(this.f18737d, "aPosition");
        this.f18741h = GLES20.glGetAttribLocation(this.f18737d, "aTexCoords");
        this.f18742i = GLES20.glGetUniformLocation(this.f18737d, "uTexture");
    }

    public void a(int i11, float[] fArr, boolean z11) {
        float[] fArr2;
        a aVar = z11 ? this.f18736c : this.f18735b;
        if (aVar == null) {
            return;
        }
        GLES20.glUseProgram(this.f18737d);
        ba.a();
        GLES20.glEnableVertexAttribArray(this.f18740g);
        GLES20.glEnableVertexAttribArray(this.f18741h);
        ba.a();
        int i12 = this.f18734a;
        if (i12 == 1) {
            fArr2 = z11 ? f18731n : f18730m;
        } else if (i12 == 2) {
            fArr2 = z11 ? f18733p : f18732o;
        } else {
            fArr2 = f18729l;
        }
        GLES20.glUniformMatrix3fv(this.f18739f, 1, false, fArr2, 0);
        GLES20.glUniformMatrix4fv(this.f18738e, 1, false, fArr, 0);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(36197, i11);
        GLES20.glUniform1i(this.f18742i, 0);
        ba.a();
        GLES20.glVertexAttribPointer(this.f18740g, 3, 5126, false, 12, (Buffer) aVar.f18744b);
        ba.a();
        GLES20.glVertexAttribPointer(this.f18741h, 2, 5126, false, 8, (Buffer) aVar.f18745c);
        ba.a();
        GLES20.glDrawArrays(aVar.f18746d, 0, aVar.f18743a);
        ba.a();
        GLES20.glDisableVertexAttribArray(this.f18740g);
        GLES20.glDisableVertexAttribArray(this.f18741h);
    }

    public void b(ci ciVar) {
        if (a(ciVar)) {
            this.f18734a = ciVar.f18194c;
            a aVar = new a(ciVar.f18192a.a(0));
            this.f18735b = aVar;
            if (!ciVar.f18195d) {
                aVar = new a(ciVar.f18193b.a(0));
            }
            this.f18736c = aVar;
        }
    }
}
