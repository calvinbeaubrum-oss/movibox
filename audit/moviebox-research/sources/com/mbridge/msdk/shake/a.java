package com.mbridge.msdk.shake;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.foundation.same.report.q;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SensorManager f46930a;

    /* JADX INFO: renamed from: com.mbridge.msdk.shake.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0520a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static a f46931a = new a();
    }

    private a() {
    }

    public static a a() {
        return C0520a.f46931a;
    }

    public final void a(SensorEventListener sensorEventListener) {
        Context contextC = c.m().c();
        if (contextC != null) {
            try {
                if (this.f46930a == null) {
                    this.f46930a = (SensorManager) contextC.getSystemService("sensor");
                }
                this.f46930a.registerListener(sensorEventListener, this.f46930a.getDefaultSensor(1), 2);
            } catch (Exception e11) {
                e11.printStackTrace();
                String message = e11.getMessage();
                try {
                    if (TextUtils.isEmpty(message)) {
                        return;
                    }
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("key=2000106&");
                    if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.U)) {
                        stringBuffer.append("b=" + com.mbridge.msdk.foundation.same.a.U + "&");
                    }
                    if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f44371g)) {
                        stringBuffer.append("c=" + com.mbridge.msdk.foundation.same.a.f44371g + "&");
                    }
                    stringBuffer.append("reason=" + message);
                    if (j.a().b()) {
                        j.a().a(stringBuffer.toString());
                    } else {
                        q.b(contextC, stringBuffer.toString());
                    }
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
    }

    public final void b(SensorEventListener sensorEventListener) {
        SensorManager sensorManager = this.f46930a;
        if (sensorManager != null) {
            try {
                sensorManager.unregisterListener(sensorEventListener);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }
}
