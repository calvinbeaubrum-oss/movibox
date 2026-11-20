package com.pgl.ssdk;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class j0 implements SensorEventListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static j0 f48783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SensorManager f48784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f48785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f48786d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private float[] f48787e = new float[3];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private List<String> f48788f = new ArrayList();

    private j0(Context context) {
        this.f48784b = null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            try {
                this.f48784b = (SensorManager) applicationContext.getSystemService("sensor");
            } catch (Throwable unused) {
            }
        }
    }

    public static j0 a(Context context) {
        if (f48783a == null) {
            synchronized (j0.class) {
                try {
                    if (f48783a == null) {
                        f48783a = new j0(context);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f48783a;
    }

    private synchronized void d() {
        try {
            SensorManager sensorManager = this.f48784b;
            if (sensorManager != null) {
                if (this.f48785c == 0) {
                    if (!this.f48784b.registerListener(this, sensorManager.getDefaultSensor(1), 3)) {
                        return;
                    }
                }
                this.f48785c++;
            }
        } catch (Exception unused) {
        }
    }

    private synchronized void e() {
        try {
            SensorManager sensorManager = this.f48784b;
            if (sensorManager != null) {
                int i11 = this.f48785c - 1;
                this.f48785c = i11;
                if (i11 == 0) {
                    sensorManager.unregisterListener(this);
                }
            }
        } catch (Exception unused) {
        }
    }

    public void a() {
        String strC = c();
        if (strC == null) {
            return;
        }
        this.f48788f.add(strC);
        try {
            int size = this.f48788f.size();
            if (size > 20) {
                ArrayList arrayList = new ArrayList(this.f48788f.subList(size - 10, size));
                this.f48788f.clear();
                this.f48788f = arrayList;
            }
        } catch (Throwable unused) {
        }
    }

    public synchronized String b() {
        String strSubstring = "";
        int size = this.f48788f.size();
        if (size <= 0) {
            return "";
        }
        if (size == 1) {
            return this.f48788f.get(0);
        }
        try {
            List<String> list = this.f48788f;
            int i11 = size - 10;
            if (i11 <= 0) {
                i11 = 0;
            }
            List<String> listSubList = list.subList(i11, size);
            for (int i12 = 0; i12 < listSubList.size(); i12++) {
                strSubstring = strSubstring + listSubList.get(i12) + "|";
            }
            strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
        } catch (Throwable unused) {
        }
        return strSubstring;
    }

    public String c() {
        String str;
        try {
            try {
                d();
                synchronized (this) {
                    int i11 = 0;
                    while (this.f48786d == 0 && i11 < 10) {
                        try {
                            i11++;
                            wait(100L);
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
                DecimalFormat decimalFormat = new DecimalFormat("0.0");
                str = decimalFormat.format(this.f48787e[0]) + "," + decimalFormat.format(this.f48787e[1]) + "," + decimalFormat.format(this.f48787e[2]);
            } catch (Throwable unused) {
                DecimalFormat decimalFormat2 = new DecimalFormat("0.0");
                str = decimalFormat2.format(this.f48787e[0]) + "," + decimalFormat2.format(this.f48787e[1]) + "," + decimalFormat2.format(this.f48787e[2]);
            }
        } catch (Throwable unused2) {
            str = null;
        }
        e();
        this.f48786d = 0;
        return str;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i11) {
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        this.f48787e = sensorEvent.values;
        this.f48786d = 1;
    }
}
