package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzeac extends zzfua {
    private final Context zzb;
    private SensorManager zzc;
    private Sensor zzd;
    private long zze;
    private int zzf;
    private zzeab zzg;
    private boolean zzh;

    public zzeac(Context context) {
        super("ShakeDetector", com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS);
        this.zzb = context;
    }

    @Override // com.google.android.gms.internal.ads.zzfua
    public final void zza(SensorEvent sensorEvent) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziR)).booleanValue()) {
            float[] fArr = sensorEvent.values;
            float f11 = fArr[0] / 9.80665f;
            float f12 = fArr[1] / 9.80665f;
            float f13 = fArr[2] / 9.80665f;
            if (((float) Math.sqrt((f11 * f11) + (f12 * f12) + (f13 * f13))) >= ((Float) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziS)).floatValue()) {
                long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
                if (this.zze + ((long) ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziT)).intValue()) <= jCurrentTimeMillis) {
                    if (this.zze + ((long) ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziU)).intValue()) < jCurrentTimeMillis) {
                        this.zzf = 0;
                    }
                    com.google.android.gms.ads.internal.util.zze.zza("Shake detected.");
                    this.zze = jCurrentTimeMillis;
                    int i11 = this.zzf + 1;
                    this.zzf = i11;
                    zzeab zzeabVar = this.zzg;
                    if (zzeabVar != null) {
                        if (i11 == ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziV)).intValue()) {
                            zzdzd zzdzdVar = (zzdzd) zzeabVar;
                            zzdzdVar.zzh(new zzdza(zzdzdVar), zzdzc.GESTURE);
                        }
                    }
                }
            }
        }
    }

    public final void zzb() {
        synchronized (this) {
            try {
                if (this.zzh) {
                    SensorManager sensorManager = this.zzc;
                    if (sensorManager != null) {
                        sensorManager.unregisterListener(this, this.zzd);
                        com.google.android.gms.ads.internal.util.zze.zza("Stopped listening for shake gestures.");
                    }
                    this.zzh = false;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void zzc() {
        SensorManager sensorManager;
        Sensor sensor;
        synchronized (this) {
            try {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziR)).booleanValue()) {
                    if (this.zzc == null) {
                        SensorManager sensorManager2 = (SensorManager) this.zzb.getSystemService("sensor");
                        this.zzc = sensorManager2;
                        if (sensorManager2 == null) {
                            zzcec.zzj("Shake detection failed to initialize. Failed to obtain accelerometer.");
                            return;
                        }
                        this.zzd = sensorManager2.getDefaultSensor(1);
                    }
                    if (!this.zzh && (sensorManager = this.zzc) != null && (sensor = this.zzd) != null) {
                        sensorManager.registerListener(this, sensor, 2);
                        this.zze = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis() - ((long) ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziT)).intValue());
                        this.zzh = true;
                        com.google.android.gms.ads.internal.util.zze.zza("Listening for shake gestures.");
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void zzd(zzeab zzeabVar) {
        this.zzg = zzeabVar;
    }
}
