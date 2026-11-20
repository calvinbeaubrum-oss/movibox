package com.bytedance.sdk.openadsdk.Sfl;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.os.Vibrator;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class WH {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static WeakReference<sc> f27240sc;
    protected static final float[] pFF = new float[3];
    protected static final float[] zY = new float[3];
    protected static final float[] We = new float[9];
    protected static final float[] ExN = new float[3];

    public static void We(Context context, SensorEventListener sensorEventListener, int i11) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            WeakReference<sc> weakReference = f27240sc;
            if (weakReference != null) {
                weakReference.get();
            }
        } catch (Throwable th2) {
            qr.sc("SensorHub", "startListenRotationVector err", th2);
        }
    }

    public static void pFF(Context context, SensorEventListener sensorEventListener, int i11) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            WeakReference<sc> weakReference = f27240sc;
            if (weakReference != null) {
                weakReference.get();
            }
        } catch (Throwable th2) {
            qr.sc("SensorHub", "startListenGyroscope error", th2);
        }
    }

    public static void sc(Context context, long j11) {
        if (context == null) {
            return;
        }
        ((Vibrator) context.getSystemService("vibrator")).vibrate(j11);
    }

    public static void sc(Context context, SensorEventListener sensorEventListener) {
    }

    public static void sc(Context context, SensorEventListener sensorEventListener, int i11) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            WeakReference<sc> weakReference = f27240sc;
            if (weakReference != null) {
                weakReference.get();
            }
        } catch (Throwable th2) {
            qr.sc("SensorHub", "startListenAccelerometer error", th2);
        }
    }

    public static void sc(sc scVar) {
        f27240sc = new WeakReference<>(scVar);
    }

    public static void zY(Context context, SensorEventListener sensorEventListener, int i11) {
        if (sensorEventListener == null || context == null) {
            return;
        }
        try {
            WeakReference<sc> weakReference = f27240sc;
            if (weakReference != null) {
                weakReference.get();
            }
        } catch (Throwable th2) {
            qr.sc("SensorHub", "startListenLinearAcceleration error", th2);
        }
    }
}
