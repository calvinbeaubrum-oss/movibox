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
public class s6 implements SensorEventListener, AppLovinBroadcastManager.Receiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f22298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final SensorManager f22299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Sensor f22300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final a f22301d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f22302f;

    /* JADX INFO: compiled from: source.java */
    public interface a {
        void a();

        void b();
    }

    public s6(com.applovin.impl.sdk.j jVar, a aVar) {
        this.f22298a = jVar;
        SensorManager sensorManager = (SensorManager) com.applovin.impl.sdk.j.l().getSystemService("sensor");
        this.f22299b = sensorManager;
        this.f22300c = sensorManager.getDefaultSensor(1);
        this.f22301d = aVar;
    }

    public void a() {
        if (Boolean.parseBoolean(this.f22298a.g0().getExtraParameters().get("disable_sensor_data_collection"))) {
            return;
        }
        this.f22299b.unregisterListener(this);
        this.f22299b.registerListener(this, this.f22300c, (int) TimeUnit.MILLISECONDS.toMicros(50L));
        AppLovinBroadcastManager.unregisterReceiver(this);
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_PAUSED));
        AppLovinBroadcastManager.registerReceiver(this, new IntentFilter(SessionTracker.ACTION_APPLICATION_RESUMED));
    }

    public void b() {
        AppLovinBroadcastManager.unregisterReceiver(this);
        this.f22299b.unregisterListener(this);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i11) {
    }

    @Override // com.applovin.impl.sdk.AppLovinBroadcastManager.Receiver
    public void onReceive(Intent intent, Map map) {
        String action = intent.getAction();
        if (SessionTracker.ACTION_APPLICATION_PAUSED.equals(action)) {
            this.f22299b.unregisterListener(this);
        } else if (SessionTracker.ACTION_APPLICATION_RESUMED.equals(action)) {
            a();
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            float fMax = Math.max(Math.min(sensorEvent.values[2] / 9.81f, 1.0f), -1.0f);
            float f11 = this.f22302f;
            float f12 = (f11 * 0.5f) + (fMax * 0.5f);
            this.f22302f = f12;
            if (f11 < 0.8f && f12 > 0.8f) {
                this.f22301d.a();
            } else {
                if (f11 <= -0.8f || f12 >= -0.8f) {
                    return;
                }
                this.f22301d.b();
            }
        }
    }
}
