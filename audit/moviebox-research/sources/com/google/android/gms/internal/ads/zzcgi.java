package com.google.android.gms.internal.ads;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Display;
import android.view.WindowManager;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzcgi extends zzfua {
    private final SensorManager zzb;
    private final Object zzc;
    private final Display zzd;
    private final float[] zze;
    private final float[] zzf;
    private float[] zzg;
    private Handler zzh;
    private zzcgh zzi;

    public zzcgi(Context context) {
        super("OrientationMonitor", com.mbridge.msdk.foundation.entity.b.JSON_KEY_ADS);
        this.zzb = (SensorManager) context.getSystemService("sensor");
        this.zzd = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        this.zze = new float[9];
        this.zzf = new float[9];
        this.zzc = new Object();
    }

    @Override // com.google.android.gms.internal.ads.zzfua
    public final void zza(SensorEvent sensorEvent) {
        float[] fArr = sensorEvent.values;
        if (fArr[0] == 0.0f && fArr[1] == 0.0f && fArr[2] == 0.0f) {
            return;
        }
        synchronized (this.zzc) {
            try {
                if (this.zzg == null) {
                    this.zzg = new float[9];
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        SensorManager.getRotationMatrixFromVector(this.zze, fArr);
        int rotation = this.zzd.getRotation();
        if (rotation == 1) {
            SensorManager.remapCoordinateSystem(this.zze, 2, TsExtractor.TS_STREAM_TYPE_AC3, this.zzf);
        } else if (rotation == 2) {
            SensorManager.remapCoordinateSystem(this.zze, TsExtractor.TS_STREAM_TYPE_AC3, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, this.zzf);
        } else if (rotation != 3) {
            System.arraycopy(this.zze, 0, this.zzf, 0, 9);
        } else {
            SensorManager.remapCoordinateSystem(this.zze, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 1, this.zzf);
        }
        float[] fArr2 = this.zzf;
        float f11 = fArr2[1];
        fArr2[1] = fArr2[3];
        fArr2[3] = f11;
        float f12 = fArr2[2];
        fArr2[2] = fArr2[6];
        fArr2[6] = f12;
        float f13 = fArr2[5];
        fArr2[5] = fArr2[7];
        fArr2[7] = f13;
        synchronized (this.zzc) {
            System.arraycopy(this.zzf, 0, this.zzg, 0, 9);
        }
        zzcgh zzcghVar = this.zzi;
        if (zzcghVar != null) {
            zzcghVar.zza();
        }
    }

    public final void zzb(zzcgh zzcghVar) {
        this.zzi = zzcghVar;
    }

    public final void zzc() {
        if (this.zzh != null) {
            return;
        }
        Sensor defaultSensor = this.zzb.getDefaultSensor(11);
        if (defaultSensor == null) {
            zzcec.zzg("No Sensor of TYPE_ROTATION_VECTOR");
            return;
        }
        HandlerThread handlerThread = new HandlerThread("OrientationMonitor");
        handlerThread.start();
        zzftt zzfttVar = new zzftt(handlerThread.getLooper());
        this.zzh = zzfttVar;
        if (this.zzb.registerListener(this, defaultSensor, 0, zzfttVar)) {
            return;
        }
        zzcec.zzg("SensorManager.registerListener failed.");
        zzd();
    }

    public final void zzd() {
        if (this.zzh == null) {
            return;
        }
        this.zzb.unregisterListener(this);
        this.zzh.post(new zzcgg(this));
        this.zzh = null;
    }

    public final boolean zze(float[] fArr) {
        synchronized (this.zzc) {
            try {
                float[] fArr2 = this.zzg;
                if (fArr2 == null) {
                    return false;
                }
                System.arraycopy(fArr2, 0, fArr, 0, 9);
                return true;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
