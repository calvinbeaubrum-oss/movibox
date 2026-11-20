package com.mbridge.msdk.shake;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class b implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f46932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f46933b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f46934d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f46935e = 0.0f;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f46936f = 0.0f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f46937g = 0.0f;

    public b(int i11, int i12) {
        this.f46932a = i11;
        this.f46933b = i12;
    }

    public abstract void a();

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i11) {
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0048  */
    /* JADX WARN: Code duplicated, block: B:16:0x0057  */
    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        long jCurrentTimeMillis;
        float[] fArr = sensorEvent.values;
        float f11 = -fArr[0];
        float f12 = -fArr[1];
        float f13 = -fArr[2];
        float f14 = this.f46935e;
        if (f14 == 0.0f || Math.abs(f11 - f14) <= this.f46932a) {
            float f15 = this.f46936f;
            if (f15 == 0.0f || Math.abs(f12 - f15) <= this.f46932a) {
                float f16 = this.f46937g;
                if (f16 != 0.0f && Math.abs(f13 - f16) > this.f46932a) {
                    jCurrentTimeMillis = System.currentTimeMillis();
                    if (jCurrentTimeMillis - this.f46934d > this.f46933b) {
                        this.f46934d = jCurrentTimeMillis;
                        a();
                    }
                }
            } else {
                jCurrentTimeMillis = System.currentTimeMillis();
                if (jCurrentTimeMillis - this.f46934d > this.f46933b) {
                    this.f46934d = jCurrentTimeMillis;
                    a();
                }
            }
        } else {
            jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.f46934d > this.f46933b) {
                this.f46934d = jCurrentTimeMillis;
                a();
            }
        }
        this.f46935e = f11;
        this.f46936f = f12;
        this.f46937g = f13;
    }
}
