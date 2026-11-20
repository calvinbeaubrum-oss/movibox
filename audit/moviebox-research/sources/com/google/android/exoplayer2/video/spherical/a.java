package com.google.android.exoplayer2.video.spherical;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import gi.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class a implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f35836a = new float[16];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float[] f35837b = new float[16];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float[] f35838c = new float[16];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float[] f35839d = new float[3];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Display f35840f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final InterfaceC0376a[] f35841g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f35842h;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.video.spherical.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0376a {
        void a(float[] fArr, float f11);
    }

    public a(Display display, InterfaceC0376a... interfaceC0376aArr) {
        this.f35840f = display;
        this.f35841g = interfaceC0376aArr;
    }

    public static void e(float[] fArr) {
        Matrix.rotateM(fArr, 0, 90.0f, 1.0f, 0.0f, 0.0f);
    }

    public final float a(float[] fArr) {
        SensorManager.remapCoordinateSystem(fArr, 1, 131, this.f35837b);
        SensorManager.getOrientation(this.f35837b, this.f35839d);
        return this.f35839d[2];
    }

    public final void b(float[] fArr, float f11) {
        for (InterfaceC0376a interfaceC0376a : this.f35841g) {
            interfaceC0376a.a(fArr, f11);
        }
    }

    public final void c(float[] fArr) {
        if (!this.f35842h) {
            c.a(this.f35838c, fArr);
            this.f35842h = true;
        }
        float[] fArr2 = this.f35837b;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        Matrix.multiplyMM(fArr, 0, this.f35837b, 0, this.f35838c, 0);
    }

    public final void d(float[] fArr, int i11) {
        if (i11 != 0) {
            int i12 = TsExtractor.TS_STREAM_TYPE_AC3;
            int i13 = 1;
            if (i11 == 1) {
                i12 = 2;
                i13 = TsExtractor.TS_STREAM_TYPE_AC3;
            } else if (i11 == 2) {
                i13 = TsExtractor.TS_STREAM_TYPE_HDMV_DTS;
            } else {
                if (i11 != 3) {
                    throw new IllegalStateException();
                }
                i12 = TsExtractor.TS_STREAM_TYPE_HDMV_DTS;
            }
            float[] fArr2 = this.f35837b;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            SensorManager.remapCoordinateSystem(this.f35837b, i12, i13, fArr);
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i11) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        SensorManager.getRotationMatrixFromVector(this.f35836a, sensorEvent.values);
        d(this.f35836a, this.f35840f.getRotation());
        float fA = a(this.f35836a);
        e(this.f35836a);
        c(this.f35836a);
        b(this.f35836a, fA);
    }
}
