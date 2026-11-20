package ca;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class f implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SensorManager f14760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float[] f14761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f14762c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float[] f14763d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f14764f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f14765g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float[] f14766h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f14767i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float[] f14768j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float[] f14769k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final AtomicBoolean f14770l;

    /* JADX INFO: compiled from: source.java */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f14771a = new f();
    }

    public f() {
        this.f14761b = new float[0];
        this.f14763d = new float[0];
        this.f14766h = new float[0];
        this.f14768j = new float[0];
        this.f14769k = new float[0];
        this.f14770l = new AtomicBoolean(false);
        this.f14760a = (SensorManager) com.cloud.sdk.commonutil.util.f.a().getSystemService("sensor");
    }

    public static f e() {
        return b.f14771a;
    }

    public static Bundle k() {
        Bundle bundle = new Bundle();
        try {
            bundle.putFloatArray("ots", e().h());
            bundle.putFloat("ls", e().f());
            bundle.putFloatArray("ms", e().g());
            bundle.putFloat("pxs", e().j());
            bundle.putFloat("tps", e().l());
            bundle.putFloatArray("gs", e().d());
            bundle.putFloat("pss", e().i());
            bundle.putFloatArray("gvs", e().c());
            bundle.putFloatArray("ams", e().b());
        } catch (Exception e11) {
            ca.b.r0(Log.getStackTraceString(e11));
        }
        return bundle;
    }

    public static void q() {
        try {
            try {
                try {
                    e().o();
                    e().p();
                } catch (Exception e11) {
                    ca.b.r0(Log.getStackTraceString(e11));
                    e().p();
                }
            } catch (Exception e12) {
                ca.b.r0(Log.getStackTraceString(e12));
            }
        } catch (Throwable th2) {
            try {
                e().p();
            } catch (Exception e13) {
                ca.b.r0(Log.getStackTraceString(e13));
            }
            throw th2;
        }
    }

    public float[] b() {
        return this.f14769k;
    }

    public float[] c() {
        return this.f14768j;
    }

    public float[] d() {
        return this.f14766h;
    }

    public float f() {
        return this.f14762c;
    }

    public float[] g() {
        return this.f14763d;
    }

    public float[] h() {
        return this.f14761b;
    }

    public float i() {
        return this.f14767i;
    }

    public float j() {
        return this.f14764f;
    }

    public float l() {
        return this.f14765g;
    }

    public boolean m() {
        return this.f14770l.get();
    }

    public final /* synthetic */ void n() {
        this.f14770l.set(true);
        this.f14760a.unregisterListener(this);
    }

    public void o() {
        SensorManager sensorManager = this.f14760a;
        sensorManager.registerListener(this, sensorManager.getDefaultSensor(3), 3);
        SensorManager sensorManager2 = this.f14760a;
        sensorManager2.registerListener(this, sensorManager2.getDefaultSensor(4), 3);
        SensorManager sensorManager3 = this.f14760a;
        sensorManager3.registerListener(this, sensorManager3.getDefaultSensor(9), 3);
        SensorManager sensorManager4 = this.f14760a;
        sensorManager4.registerListener(this, sensorManager4.getDefaultSensor(1), 3);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i11) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor;
        float[] fArr;
        if (sensorEvent == null || (sensor = sensorEvent.sensor) == null || (fArr = sensorEvent.values) == null || fArr.length < 1) {
            return;
        }
        switch (sensor.getType()) {
            case 1:
                this.f14769k = sensorEvent.values;
                break;
            case 2:
                this.f14763d = sensorEvent.values;
                break;
            case 3:
                this.f14761b = sensorEvent.values;
                break;
            case 4:
                this.f14766h = sensorEvent.values;
                break;
            case 5:
                this.f14762c = sensorEvent.values[0];
                break;
            case 6:
                this.f14767i = sensorEvent.values[0];
                break;
            case 7:
                this.f14765g = sensorEvent.values[0];
                break;
            case 8:
                this.f14764f = sensorEvent.values[0];
                break;
            case 9:
                this.f14768j = sensorEvent.values;
                break;
        }
    }

    public void p() {
        if (Looper.myLooper() == null) {
            return;
        }
        new Handler(Looper.myLooper()).postDelayed(new Runnable() { // from class: ca.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f14759a.n();
            }
        }, 1000L);
    }
}
