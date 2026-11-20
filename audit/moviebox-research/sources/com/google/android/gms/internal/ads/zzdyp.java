package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdyp extends zzfua {
    private final SensorManager zzb;
    private final Sensor zzc;
    private float zzd;
    private Float zze;
    private long zzf;
    private int zzg;
    private boolean zzh;
    private boolean zzi;
    private zzdyo zzj;
    private boolean zzk;

    public zzdyp(Context context) {
        super("FlickDetector", com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS);
        this.zzd = 0.0f;
        this.zze = Float.valueOf(0.0f);
        this.zzf = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
        this.zzg = 0;
        this.zzh = false;
        this.zzi = false;
        this.zzj = null;
        this.zzk = false;
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        this.zzb = sensorManager;
        if (sensorManager != null) {
            this.zzc = sensorManager.getDefaultSensor(4);
        } else {
            this.zzc = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfua
    public final void zza(SensorEvent sensorEvent) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziW)).booleanValue()) {
            long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
            if (this.zzf + ((long) ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziY)).intValue()) < jCurrentTimeMillis) {
                this.zzg = 0;
                this.zzf = jCurrentTimeMillis;
                this.zzh = false;
                this.zzi = false;
                this.zzd = this.zze.floatValue();
            }
            Float fValueOf = Float.valueOf(this.zze.floatValue() + (sensorEvent.values[1] * 4.0f));
            this.zze = fValueOf;
            float fFloatValue = fValueOf.floatValue();
            float f11 = this.zzd;
            zzbfu zzbfuVar = zzbgc.zziX;
            if (fFloatValue > f11 + ((Float) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbfuVar)).floatValue()) {
                this.zzd = this.zze.floatValue();
                this.zzi = true;
            } else if (this.zze.floatValue() < this.zzd - ((Float) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbfuVar)).floatValue()) {
                this.zzd = this.zze.floatValue();
                this.zzh = true;
            }
            if (this.zze.isInfinite()) {
                this.zze = Float.valueOf(0.0f);
                this.zzd = 0.0f;
            }
            if (this.zzh && this.zzi) {
                com.google.android.gms.ads.internal.util.zze.zza("Flick detected.");
                this.zzf = jCurrentTimeMillis;
                int i11 = this.zzg + 1;
                this.zzg = i11;
                this.zzh = false;
                this.zzi = false;
                zzdyo zzdyoVar = this.zzj;
                if (zzdyoVar != null) {
                    if (i11 == ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziZ)).intValue()) {
                        zzdzd zzdzdVar = (zzdzd) zzdyoVar;
                        zzdzdVar.zzh(new zzdzb(zzdzdVar), zzdzc.GESTURE);
                    }
                }
            }
        }
    }

    public final void zzb() {
        SensorManager sensorManager;
        Sensor sensor;
        synchronized (this) {
            try {
                if (this.zzk && (sensorManager = this.zzb) != null && (sensor = this.zzc) != null) {
                    sensorManager.unregisterListener(this, sensor);
                    this.zzk = false;
                    com.google.android.gms.ads.internal.util.zze.zza("Stopped listening for flick gestures.");
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
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbgc.zziW)).booleanValue()) {
                    if (!this.zzk && (sensorManager = this.zzb) != null && (sensor = this.zzc) != null) {
                        sensorManager.registerListener(this, sensor, 2);
                        this.zzk = true;
                        com.google.android.gms.ads.internal.util.zze.zza("Listening for flick gestures.");
                    }
                    if (this.zzb == null || this.zzc == null) {
                        zzcec.zzj("Flick detection failed to initialize. Failed to obtain gyroscope.");
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void zzd(zzdyo zzdyoVar) {
        this.zzj = zzdyoVar;
    }
}
