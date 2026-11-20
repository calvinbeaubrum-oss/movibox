package com.applovin.impl;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.opengl.Matrix;
import android.view.Display;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
final class xg implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float[] f24317a = new float[16];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f24318b = new float[16];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final float[] f24319c = new float[16];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final float[] f24320d = new float[3];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Display f24321f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a[] f24322g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f24323h;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a(float[] fArr, float f11);
    }

    public xg(Display display, a... aVarArr) {
        this.f24321f = display;
        this.f24322g = aVarArr;
    }

    private float a(float[] fArr) {
        SensorManager.remapCoordinateSystem(fArr, 1, 131, this.f24318b);
        SensorManager.getOrientation(this.f24318b, this.f24320d);
        return this.f24320d[2];
    }

    private void a(float[] fArr, float f11) {
        for (a aVar : this.f24322g) {
            aVar.a(fArr, f11);
        }
    }

    private void a(float[] fArr, int i11) {
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
            float[] fArr2 = this.f24318b;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            SensorManager.remapCoordinateSystem(this.f24318b, i12, i13, fArr);
        }
    }

    private void b(float[] fArr) {
        if (!this.f24323h) {
            k9.a(this.f24319c, fArr);
            this.f24323h = true;
        }
        float[] fArr2 = this.f24318b;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        Matrix.multiplyMM(fArr, 0, this.f24318b, 0, this.f24319c, 0);
    }

    private static void c(float[] fArr) {
        Matrix.rotateM(fArr, 0, 90.0f, 1.0f, 0.0f, 0.0f);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i11) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        SensorManager.getRotationMatrixFromVector(this.f24317a, sensorEvent.values);
        a(this.f24317a, this.f24321f.getRotation());
        float fA = a(this.f24317a);
        c(this.f24317a);
        b(this.f24317a);
        a(this.f24317a, fA);
    }
}
