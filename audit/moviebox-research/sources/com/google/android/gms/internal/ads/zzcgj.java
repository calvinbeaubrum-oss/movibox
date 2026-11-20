package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.gcm.Task;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcgj extends Thread implements SurfaceTexture.OnFrameAvailableListener, zzcgh {
    private static final float[] zza = {-1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f};
    private volatile boolean zzA;
    private volatile boolean zzB;
    private final zzcgi zzb;
    private final float[] zzc;
    private final float[] zzd;
    private final float[] zze;
    private final float[] zzf;
    private final float[] zzg;
    private final float[] zzh;
    private final float[] zzi;
    private float zzj;
    private float zzk;
    private float zzl;
    private int zzm;
    private int zzn;
    private SurfaceTexture zzo;
    private SurfaceTexture zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private final FloatBuffer zzt;
    private final CountDownLatch zzu;
    private final Object zzv;
    private EGL10 zzw;
    private EGLDisplay zzx;
    private EGLContext zzy;
    private EGLSurface zzz;

    public zzcgj(Context context) {
        super("SphericalVideoProcessor");
        float[] fArr = zza;
        int length = fArr.length;
        FloatBuffer floatBufferAsFloatBuffer = ByteBuffer.allocateDirect(48).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.zzt = floatBufferAsFloatBuffer;
        floatBufferAsFloatBuffer.put(fArr).position(0);
        this.zzc = new float[9];
        this.zzd = new float[9];
        this.zze = new float[9];
        this.zzf = new float[9];
        this.zzg = new float[9];
        this.zzh = new float[9];
        this.zzi = new float[9];
        this.zzj = Float.NaN;
        zzcgi zzcgiVar = new zzcgi(context);
        this.zzb = zzcgiVar;
        zzcgiVar.zzb(this);
        this.zzu = new CountDownLatch(1);
        this.zzv = new Object();
    }

    private static final void zzh(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError != 0) {
            Log.e("SphericalVideoRenderer", str + ": glError " + iGlGetError);
        }
    }

    private static final void zzi(float[] fArr, float[] fArr2, float[] fArr3) {
        float f11 = fArr2[0] * fArr3[0];
        float f12 = fArr2[1];
        float f13 = fArr3[3];
        float f14 = fArr2[2];
        float f15 = fArr3[6];
        fArr[0] = f11 + (f12 * f13) + (f14 * f15);
        float f16 = fArr2[0];
        float f17 = fArr3[1] * f16;
        float f18 = fArr3[4];
        float f19 = fArr3[7];
        fArr[1] = f17 + (f12 * f18) + (f14 * f19);
        float f21 = f16 * fArr3[2];
        float f22 = fArr2[1];
        float f23 = fArr3[5];
        float f24 = fArr3[8];
        fArr[2] = f21 + (f22 * f23) + (f14 * f24);
        float f25 = fArr2[3];
        float f26 = fArr3[0];
        float f27 = fArr2[4];
        float f28 = fArr2[5];
        fArr[3] = (f25 * f26) + (f13 * f27) + (f28 * f15);
        float f29 = fArr2[3];
        float f31 = fArr3[1];
        fArr[4] = (f29 * f31) + (f27 * f18) + (f28 * f19);
        float f32 = fArr3[2];
        fArr[5] = (f29 * f32) + (fArr2[4] * f23) + (f28 * f24);
        float f33 = fArr2[6] * f26;
        float f34 = fArr2[7];
        float f35 = fArr3[3] * f34;
        float f36 = fArr2[8];
        fArr[6] = f33 + f35 + (f15 * f36);
        float f37 = fArr2[6];
        fArr[7] = (f31 * f37) + (f34 * fArr3[4]) + (f19 * f36);
        fArr[8] = (f37 * f32) + (fArr2[7] * fArr3[5]) + (f36 * f24);
    }

    private static final void zzj(float[] fArr, float f11) {
        fArr[0] = 1.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        double d11 = f11;
        fArr[4] = (float) Math.cos(d11);
        fArr[5] = (float) (-Math.sin(d11));
        fArr[6] = 0.0f;
        fArr[7] = (float) Math.sin(d11);
        fArr[8] = (float) Math.cos(d11);
    }

    private static final void zzk(float[] fArr, float f11) {
        double d11 = f11;
        fArr[0] = (float) Math.cos(d11);
        fArr[1] = (float) (-Math.sin(d11));
        fArr[2] = 0.0f;
        fArr[3] = (float) Math.sin(d11);
        fArr[4] = (float) Math.cos(d11);
        fArr[5] = 0.0f;
        fArr[6] = 0.0f;
        fArr[7] = 0.0f;
        fArr[8] = 1.0f;
    }

    private static final int zzl(int i11, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i11);
        zzh("createShader");
        if (iGlCreateShader != 0) {
            GLES20.glShaderSource(iGlCreateShader, str);
            zzh("shaderSource");
            GLES20.glCompileShader(iGlCreateShader);
            zzh("compileShader");
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
            zzh("getShaderiv");
            if (iArr[0] == 0) {
                Log.e("SphericalVideoRenderer", "Could not compile shader " + i11 + ":");
                Log.e("SphericalVideoRenderer", GLES20.glGetShaderInfoLog(iGlCreateShader));
                GLES20.glDeleteShader(iGlCreateShader);
                zzh("deleteShader");
                return 0;
            }
        }
        return iGlCreateShader;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        this.zzs++;
        synchronized (this.zzv) {
            this.zzv.notifyAll();
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:6:0x001c  */
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        boolean z11;
        int iGlCreateProgram;
        if (this.zzp == null) {
            zzcec.zzg("SphericalVideoProcessor started with no output texture.");
            this.zzu.countDown();
            return;
        }
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.zzw = egl10;
        EGLDisplay eGLDisplayEglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.zzx = eGLDisplayEglGetDisplay;
        if (eGLDisplayEglGetDisplay == EGL10.EGL_NO_DISPLAY) {
            z11 = false;
        } else {
            if (this.zzw.eglInitialize(eGLDisplayEglGetDisplay, new int[2])) {
                int[] iArr = new int[1];
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                EGLConfig eGLConfig = (this.zzw.eglChooseConfig(this.zzx, new int[]{12352, 4, 12324, 8, 12323, 8, 12322, 8, 12325, 16, 12344}, eGLConfigArr, 1, iArr) && iArr[0] > 0) ? eGLConfigArr[0] : null;
                if (eGLConfig == null) {
                    z11 = false;
                } else {
                    EGL10 egl11 = this.zzw;
                    EGLDisplay eGLDisplay = this.zzx;
                    EGLContext eGLContext = EGL10.EGL_NO_CONTEXT;
                    EGLContext eGLContextEglCreateContext = egl11.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, new int[]{12440, 2, 12344});
                    this.zzy = eGLContextEglCreateContext;
                    if (eGLContextEglCreateContext == null || eGLContextEglCreateContext == eGLContext) {
                        z11 = false;
                    } else {
                        EGLSurface eGLSurfaceEglCreateWindowSurface = this.zzw.eglCreateWindowSurface(this.zzx, eGLConfig, this.zzp, null);
                        this.zzz = eGLSurfaceEglCreateWindowSurface;
                        if (eGLSurfaceEglCreateWindowSurface == null || eGLSurfaceEglCreateWindowSurface == EGL10.EGL_NO_SURFACE || !this.zzw.eglMakeCurrent(this.zzx, eGLSurfaceEglCreateWindowSurface, eGLSurfaceEglCreateWindowSurface, this.zzy)) {
                            z11 = false;
                        } else {
                            z11 = true;
                        }
                    }
                }
            } else {
                z11 = false;
            }
        }
        zzbfu zzbfuVar = zzbgc.zzbj;
        int iZzl = zzl(35633, !((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbfuVar)).equals(zzbfuVar.zzm()) ? (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbfuVar) : "attribute highp vec3 aPosition;varying vec3 pos;void main() {  gl_Position = vec4(aPosition, 1.0);  pos = aPosition;}");
        if (iZzl == 0) {
            iGlCreateProgram = 0;
        } else {
            zzbfu zzbfuVar2 = zzbgc.zzbk;
            int iZzl2 = zzl(35632, !((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbfuVar2)).equals(zzbfuVar2.zzm()) ? (String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbfuVar2) : "#extension GL_OES_EGL_image_external : require\n#define INV_PI 0.3183\nprecision highp float;varying vec3 pos;uniform samplerExternalOES uSplr;uniform mat3 uVMat;uniform float uFOVx;uniform float uFOVy;void main() {  vec3 ray = vec3(pos.x * tan(uFOVx), pos.y * tan(uFOVy), -1);  ray = (uVMat * ray).xyz;  ray = normalize(ray);  vec2 texCrd = vec2(    0.5 + atan(ray.x, - ray.z) * INV_PI * 0.5, acos(ray.y) * INV_PI);  gl_FragColor = vec4(texture2D(uSplr, texCrd).xyz, 1.0);}");
            if (iZzl2 == 0) {
                iGlCreateProgram = 0;
            } else {
                iGlCreateProgram = GLES20.glCreateProgram();
                zzh("createProgram");
                if (iGlCreateProgram != 0) {
                    GLES20.glAttachShader(iGlCreateProgram, iZzl);
                    zzh("attachShader");
                    GLES20.glAttachShader(iGlCreateProgram, iZzl2);
                    zzh("attachShader");
                    GLES20.glLinkProgram(iGlCreateProgram);
                    zzh("linkProgram");
                    int[] iArr2 = new int[1];
                    GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr2, 0);
                    zzh("getProgramiv");
                    if (iArr2[0] != 1) {
                        Log.e("SphericalVideoRenderer", "Could not link program: ");
                        Log.e("SphericalVideoRenderer", GLES20.glGetProgramInfoLog(iGlCreateProgram));
                        GLES20.glDeleteProgram(iGlCreateProgram);
                        zzh("deleteProgram");
                        iGlCreateProgram = 0;
                    } else {
                        GLES20.glValidateProgram(iGlCreateProgram);
                        zzh("validateProgram");
                    }
                }
            }
        }
        this.zzq = iGlCreateProgram;
        GLES20.glUseProgram(iGlCreateProgram);
        zzh("useProgram");
        int iGlGetAttribLocation = GLES20.glGetAttribLocation(this.zzq, "aPosition");
        GLES20.glVertexAttribPointer(iGlGetAttribLocation, 3, 5126, false, 12, (Buffer) this.zzt);
        zzh("vertexAttribPointer");
        GLES20.glEnableVertexAttribArray(iGlGetAttribLocation);
        zzh("enableVertexAttribArray");
        int[] iArr3 = new int[1];
        GLES20.glGenTextures(1, iArr3, 0);
        zzh("genTextures");
        int i11 = iArr3[0];
        GLES20.glBindTexture(36197, i11);
        zzh("bindTextures");
        GLES20.glTexParameteri(36197, Task.EXTRAS_LIMIT_BYTES, 9729);
        zzh("texParameteri");
        GLES20.glTexParameteri(36197, 10241, 9729);
        zzh("texParameteri");
        GLES20.glTexParameteri(36197, 10242, 33071);
        zzh("texParameteri");
        GLES20.glTexParameteri(36197, 10243, 33071);
        zzh("texParameteri");
        int iGlGetUniformLocation = GLES20.glGetUniformLocation(this.zzq, "uVMat");
        this.zzr = iGlGetUniformLocation;
        GLES20.glUniformMatrix3fv(iGlGetUniformLocation, 1, false, new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f}, 0);
        int i12 = this.zzq;
        if (!z11 || i12 == 0) {
            String strConcat = "EGL initialization failed: ".concat(String.valueOf(GLUtils.getEGLErrorString(this.zzw.eglGetError())));
            zzcec.zzg(strConcat);
            com.google.android.gms.ads.internal.zzt.zzo().zzw(new Throwable(strConcat), "SphericalVideoProcessor.run.1");
            zzg();
            this.zzu.countDown();
            return;
        }
        SurfaceTexture surfaceTexture = new SurfaceTexture(i11);
        this.zzo = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(this);
        this.zzu.countDown();
        this.zzb.zzc();
        try {
            try {
                try {
                    this.zzA = true;
                    while (!this.zzB) {
                        while (this.zzs > 0) {
                            this.zzo.updateTexImage();
                            this.zzs--;
                        }
                        if (this.zzb.zze(this.zzc)) {
                            if (Float.isNaN(this.zzj)) {
                                float[] fArr = this.zzc;
                                float[] fArr2 = {0.0f, 1.0f, 0.0f};
                                float f11 = fArr[0];
                                float f12 = fArr2[0];
                                float f13 = fArr[1];
                                float f14 = fArr2[1];
                                float f15 = (f11 * f12) + (f13 * f14) + (fArr[2] * 0.0f);
                                float f16 = (fArr[3] * f12) + (fArr[4] * f14) + (fArr[5] * 0.0f);
                                float f17 = fArr[6];
                                float f18 = fArr[7];
                                float f19 = fArr[8];
                                this.zzj = -(((float) Math.atan2(f16, f15)) - 1.5707964f);
                            }
                            zzk(this.zzh, this.zzj + this.zzk);
                        } else {
                            zzj(this.zzc, -1.5707964f);
                            zzk(this.zzh, this.zzk);
                        }
                        zzj(this.zzd, 1.5707964f);
                        zzi(this.zze, this.zzh, this.zzd);
                        zzi(this.zzf, this.zzc, this.zze);
                        zzj(this.zzg, this.zzl);
                        zzi(this.zzi, this.zzg, this.zzf);
                        GLES20.glUniformMatrix3fv(this.zzr, 1, false, this.zzi, 0);
                        GLES20.glDrawArrays(5, 0, 4);
                        zzh("drawArrays");
                        GLES20.glFinish();
                        this.zzw.eglSwapBuffers(this.zzx, this.zzz);
                        if (this.zzA) {
                            GLES20.glViewport(0, 0, this.zzn, this.zzm);
                            zzh("viewport");
                            int iGlGetUniformLocation2 = GLES20.glGetUniformLocation(this.zzq, "uFOVx");
                            int iGlGetUniformLocation3 = GLES20.glGetUniformLocation(this.zzq, "uFOVy");
                            int i13 = this.zzn;
                            int i14 = this.zzm;
                            if (i13 > i14) {
                                GLES20.glUniform1f(iGlGetUniformLocation2, 0.87266463f);
                                GLES20.glUniform1f(iGlGetUniformLocation3, (this.zzm * 0.87266463f) / this.zzn);
                            } else {
                                GLES20.glUniform1f(iGlGetUniformLocation2, (i13 * 0.87266463f) / i14);
                                GLES20.glUniform1f(iGlGetUniformLocation3, 0.87266463f);
                            }
                            this.zzA = false;
                        }
                        try {
                            synchronized (this.zzv) {
                                try {
                                    if (!this.zzB && !this.zzA && this.zzs == 0) {
                                        this.zzv.wait();
                                    }
                                } catch (Throwable th2) {
                                    throw th2;
                                }
                            }
                        } catch (InterruptedException unused) {
                        }
                    }
                } catch (IllegalStateException unused2) {
                    zzcec.zzj("SphericalVideoProcessor halted unexpectedly.");
                }
            } catch (Throwable th3) {
                zzcec.zzh("SphericalVideoProcessor died.", th3);
                com.google.android.gms.ads.internal.zzt.zzo().zzw(th3, "SphericalVideoProcessor.run.2");
            }
            this.zzb.zzd();
            this.zzo.setOnFrameAvailableListener(null);
            this.zzo = null;
            zzg();
        } catch (Throwable th4) {
            this.zzb.zzd();
            this.zzo.setOnFrameAvailableListener(null);
            this.zzo = null;
            zzg();
            throw th4;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgh
    public final void zza() {
        synchronized (this.zzv) {
            this.zzv.notifyAll();
        }
    }

    @Nullable
    public final SurfaceTexture zzb() {
        if (this.zzp == null) {
            return null;
        }
        try {
            this.zzu.await();
        } catch (InterruptedException unused) {
        }
        return this.zzo;
    }

    public final void zzc(int i11, int i12) {
        synchronized (this.zzv) {
            this.zzn = i11;
            this.zzm = i12;
            this.zzA = true;
            this.zzv.notifyAll();
        }
    }

    public final void zzd(SurfaceTexture surfaceTexture, int i11, int i12) {
        this.zzn = i11;
        this.zzm = i12;
        this.zzp = surfaceTexture;
    }

    public final void zze() {
        synchronized (this.zzv) {
            this.zzB = true;
            this.zzp = null;
            this.zzv.notifyAll();
        }
    }

    public final void zzf(float f11, float f12) {
        int i11 = this.zzn;
        int i12 = this.zzm;
        if (i11 <= i12) {
            i11 = i12;
        }
        float f13 = i11;
        this.zzk -= (f11 * 1.7453293f) / f13;
        float f14 = this.zzl - ((f12 * 1.7453293f) / f13);
        this.zzl = f14;
        if (f14 < -1.5707964f) {
            this.zzl = -1.5707964f;
            f14 = -1.5707964f;
        }
        if (f14 > 1.5707964f) {
            this.zzl = 1.5707964f;
        }
    }

    public final boolean zzg() {
        EGLSurface eGLSurface;
        EGLSurface eGLSurface2 = this.zzz;
        boolean zEglDestroyContext = false;
        if (eGLSurface2 != null && eGLSurface2 != (eGLSurface = EGL10.EGL_NO_SURFACE)) {
            zEglDestroyContext = this.zzw.eglDestroySurface(this.zzx, this.zzz) | this.zzw.eglMakeCurrent(this.zzx, eGLSurface, eGLSurface, EGL10.EGL_NO_CONTEXT);
            this.zzz = null;
        }
        EGLContext eGLContext = this.zzy;
        if (eGLContext != null) {
            zEglDestroyContext |= this.zzw.eglDestroyContext(this.zzx, eGLContext);
            this.zzy = null;
        }
        EGLDisplay eGLDisplay = this.zzx;
        if (eGLDisplay == null) {
            return zEglDestroyContext;
        }
        boolean zEglTerminate = this.zzw.eglTerminate(eGLDisplay) | zEglDestroyContext;
        this.zzx = null;
        return zEglTerminate;
    }
}
