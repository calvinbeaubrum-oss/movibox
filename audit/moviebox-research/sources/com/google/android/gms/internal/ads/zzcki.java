package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.CollectionUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.player.mediasession.MediaItem;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzcki extends com.google.android.gms.ads.internal.client.zzdp {
    private final zzcgl zza;
    private final boolean zzc;
    private final boolean zzd;
    private int zze;

    @Nullable
    private com.google.android.gms.ads.internal.client.zzdt zzf;
    private boolean zzg;
    private float zzi;
    private float zzj;
    private float zzk;
    private boolean zzl;
    private boolean zzm;
    private zzbku zzn;
    private final Object zzb = new Object();
    private boolean zzh = true;

    public zzcki(zzcgl zzcglVar, float f11, boolean z11, boolean z12) {
        this.zza = zzcglVar;
        this.zzi = f11;
        this.zzc = z11;
        this.zzd = z12;
    }

    private final void zzw(final int i11, final int i12, final boolean z11, final boolean z12) {
        zzcep.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzckh
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzd(i11, i12, z11, z12);
            }
        });
    }

    private final void zzx(String str, @Nullable Map map) {
        final HashMap map2 = map == null ? new HashMap() : new HashMap(map);
        map2.put("action", str);
        zzcep.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzckg
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzr(map2);
            }
        });
    }

    public final void zzc(float f11, float f12, int i11, boolean z11, float f13) {
        boolean z12;
        boolean z13;
        int i12;
        synchronized (this.zzb) {
            try {
                z12 = true;
                if (f12 == this.zzi && f13 == this.zzk) {
                    z12 = false;
                }
                this.zzi = f12;
                this.zzj = f11;
                z13 = this.zzh;
                this.zzh = z11;
                i12 = this.zze;
                this.zze = i11;
                float f14 = this.zzk;
                this.zzk = f13;
                if (Math.abs(f13 - f14) > 1.0E-4f) {
                    this.zza.zzF().invalidate();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (z12) {
            try {
                zzbku zzbkuVar = this.zzn;
                if (zzbkuVar != null) {
                    zzbkuVar.zze();
                }
            } catch (RemoteException e11) {
                zzcec.zzl("#007 Could not call remote method.", e11);
            }
        }
        zzw(i12, i11, z13, z11);
    }

    public final /* synthetic */ void zzd(int i11, int i12, boolean z11, boolean z12) {
        int i13;
        boolean z13;
        boolean z14;
        com.google.android.gms.ads.internal.client.zzdt zzdtVar;
        com.google.android.gms.ads.internal.client.zzdt zzdtVar2;
        com.google.android.gms.ads.internal.client.zzdt zzdtVar3;
        synchronized (this.zzb) {
            try {
                boolean z15 = this.zzg;
                if (z15 || i12 != 1) {
                    i13 = i12;
                    z13 = false;
                } else {
                    i12 = 1;
                    i13 = 1;
                    z13 = true;
                }
                boolean z16 = i11 != i12;
                if (z16 && i13 == 1) {
                    z14 = true;
                    i13 = 1;
                } else {
                    z14 = false;
                }
                boolean z17 = z16 && i13 == 2;
                boolean z18 = z16 && i13 == 3;
                this.zzg = z15 || z13;
                if (z13) {
                    try {
                        com.google.android.gms.ads.internal.client.zzdt zzdtVar4 = this.zzf;
                        if (zzdtVar4 != null) {
                            zzdtVar4.zzi();
                        }
                    } catch (RemoteException e11) {
                        zzcec.zzl("#007 Could not call remote method.", e11);
                    }
                }
                if (z14 && (zzdtVar3 = this.zzf) != null) {
                    zzdtVar3.zzh();
                }
                if (z17 && (zzdtVar2 = this.zzf) != null) {
                    zzdtVar2.zzg();
                }
                if (z18) {
                    com.google.android.gms.ads.internal.client.zzdt zzdtVar5 = this.zzf;
                    if (zzdtVar5 != null) {
                        zzdtVar5.zze();
                    }
                    this.zza.zzw();
                }
                if (z11 != z12 && (zzdtVar = this.zzf) != null) {
                    zzdtVar.zzf(z12);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdq
    public final float zze() {
        float f11;
        synchronized (this.zzb) {
            f11 = this.zzk;
        }
        return f11;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdq
    public final float zzf() {
        float f11;
        synchronized (this.zzb) {
            f11 = this.zzj;
        }
        return f11;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdq
    public final float zzg() {
        float f11;
        synchronized (this.zzb) {
            f11 = this.zzi;
        }
        return f11;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdq
    public final int zzh() {
        int i11;
        synchronized (this.zzb) {
            i11 = this.zze;
        }
        return i11;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdq
    @Nullable
    public final com.google.android.gms.ads.internal.client.zzdt zzi() throws RemoteException {
        com.google.android.gms.ads.internal.client.zzdt zzdtVar;
        synchronized (this.zzb) {
            zzdtVar = this.zzf;
        }
        return zzdtVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdq
    public final void zzj(boolean z11) {
        zzx(true != z11 ? CampaignEx.JSON_NATIVE_VIDEO_UNMUTE : CampaignEx.JSON_NATIVE_VIDEO_MUTE, null);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdq
    public final void zzk() {
        zzx("pause", null);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdq
    public final void zzl() {
        zzx(MediaItem.MUSIC_FLOAT_STATE_PLAY, null);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdq
    public final void zzm(@Nullable com.google.android.gms.ads.internal.client.zzdt zzdtVar) {
        synchronized (this.zzb) {
            this.zzf = zzdtVar;
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzdq
    public final void zzn() {
        zzx("stop", null);
    }

    @Override // com.google.android.gms.ads.internal.client.zzdq
    public final boolean zzo() {
        boolean z11;
        Object obj = this.zzb;
        boolean zZzp = zzp();
        synchronized (obj) {
            z11 = false;
            if (!zZzp) {
                try {
                    if (this.zzm && this.zzd) {
                        z11 = true;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return z11;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdq
    public final boolean zzp() {
        boolean z11;
        synchronized (this.zzb) {
            try {
                z11 = false;
                if (this.zzc && this.zzl) {
                    z11 = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return z11;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdq
    public final boolean zzq() {
        boolean z11;
        synchronized (this.zzb) {
            z11 = this.zzh;
        }
        return z11;
    }

    public final /* synthetic */ void zzr(Map map) {
        this.zza.zzd("pubVideoCmd", map);
    }

    public final void zzs(com.google.android.gms.ads.internal.client.zzfk zzfkVar) {
        Object obj = this.zzb;
        boolean z11 = zzfkVar.zza;
        boolean z12 = zzfkVar.zzb;
        boolean z13 = zzfkVar.zzc;
        synchronized (obj) {
            this.zzl = z12;
            this.zzm = z13;
        }
        zzx("initialState", CollectionUtils.mapOf("muteStart", true != z11 ? "0" : "1", "customControlsRequested", true != z12 ? "0" : "1", "clickToExpandRequested", true != z13 ? "0" : "1"));
    }

    public final void zzt(float f11) {
        synchronized (this.zzb) {
            this.zzj = f11;
        }
    }

    public final void zzu() {
        boolean z11;
        int i11;
        synchronized (this.zzb) {
            z11 = this.zzh;
            i11 = this.zze;
            this.zze = 3;
        }
        zzw(i11, 3, z11, z11);
    }

    public final void zzv(zzbku zzbkuVar) {
        synchronized (this.zzb) {
            this.zzn = zzbkuVar;
        }
    }
}
