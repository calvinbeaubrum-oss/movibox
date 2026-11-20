package com.applovin.impl;

import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.SessionTracker;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class oj implements SensorEventListener, AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f21559a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float f21560b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final SensorManager f21561c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Sensor f21562d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Sensor f21563f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f21564g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float[] f21565h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f21566i;

    public oj(com.applovin.impl.sdk.j jVar) {
        this.f21564g = jVar;
        SensorManager sensorManager = (SensorManager) com.applovin.impl.sdk.j.l().getSystemService("sensor");
        this.f21561c = sensorManager;
        this.f21562d = sensorManager.getDefaultSensor(9);
        this.f21563f = sensorManager.getDefaultSensor(4);
        this.f21559a = ((Integer) jVar.a(sj.f23033p4)).intValue();
        this.f21560b = ((Float) jVar.a(sj.f23025o4)).floatValue();
    }

    private void a(Sensor sensor) {
        try {
            this.f21561c.registerListener(this, sensor, (int) TimeUnit.MILLISECONDS.toMicros(this.f21559a));
        } catch (Throwable th2) {
            this.f21564g.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f21564g.J().a("SensorDataManager", "Unable to register sensor listener", th2);
            }
        }
    }

    public float a() {
        float[] fArr = this.f21565h;
        if (fArr == null) {
            return 0.0f;
        }
        return (float) Math.toDegrees(Math.acos(fArr[2] / 9.81f));
    }

    public float b() {
        return this.f21566i;
    }

    public void c() {
        if (Boolean.parseBoolean(this.f21564g.g0().getExtraParameters().get("disable_sensor_data_collection"))) {
            return;
        }
        this.f21561c.unregisterListener(this);
        if (((Boolean) this.f21564g.h0().a(sj.f23001l4)).booleanValue()) {
            a(this.f21562d);
        }
        if (((Boolean) this.f21564g.h0().a(sj.f23009m4)).booleanValue()) {
            a(this.f21563f);
        }
        AppLovinBroadcastManager.unregisterReceiver(this);
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i11) {
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            this.f21561c.unregisterListener(this);
        } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            c();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 9) {
            this.f21565h = sensorEvent.values;
        } else if (sensorEvent.sensor.getType() == 4) {
            float f11 = this.f21566i * this.f21560b;
            this.f21566i = f11;
            this.f21566i = f11 + Math.abs(sensorEvent.values[0]) + Math.abs(sensorEvent.values[1]) + Math.abs(sensorEvent.values[2]);
        }
    }
}
