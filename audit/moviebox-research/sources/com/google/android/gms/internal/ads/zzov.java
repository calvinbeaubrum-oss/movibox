package com.google.android.gms.internal.ads;

import android.util.Base64;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzov implements zzoz {
    public static final zzfxu zza = new zzfxu() { // from class: com.google.android.gms.internal.ads.zzot
        @Override // com.google.android.gms.internal.ads.zzfxu
        public final Object zza() {
            return zzov.zzn();
        }
    };
    private static final Random zzb = new Random();
    private final zzcw zzc;
    private final zzcu zzd;
    private final HashMap zze;
    private final zzfxu zzf;
    private zzoy zzg;
    private zzcx zzh;

    @Nullable
    private String zzi;
    private long zzj;

    public zzov() {
        throw null;
    }

    public zzov(zzfxu zzfxuVar) {
        this.zzf = zzfxuVar;
        this.zzc = new zzcw();
        this.zzd = new zzcu();
        this.zze = new HashMap();
        this.zzh = zzcx.zza;
        this.zzj = -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long zzl() {
        zzou zzouVar = (zzou) this.zze.get(this.zzi);
        return (zzouVar == null || zzouVar.zzd == -1) ? this.zzj + 1 : zzouVar.zzd;
    }

    private final zzou zzm(int i11, @Nullable zzur zzurVar) {
        long j11 = Long.MAX_VALUE;
        zzou zzouVar = null;
        for (zzou zzouVar2 : this.zze.values()) {
            zzouVar2.zzg(i11, zzurVar);
            if (zzouVar2.zzj(i11, zzurVar)) {
                long j12 = zzouVar2.zzd;
                if (j12 == -1 || j12 < j11) {
                    zzouVar = zzouVar2;
                    j11 = j12;
                } else if (j12 == j11) {
                    int i12 = zzfy.zza;
                    if (zzouVar.zze != null && zzouVar2.zze != null) {
                        zzouVar = zzouVar2;
                    }
                }
            }
        }
        if (zzouVar != null) {
            return zzouVar;
        }
        String strZzn = zzn();
        zzou zzouVar3 = new zzou(this, strZzn, i11, zzurVar);
        this.zze.put(strZzn, zzouVar3);
        return zzouVar3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String zzn() {
        byte[] bArr = new byte[12];
        zzb.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    private final void zzo(zzou zzouVar) {
        if (zzouVar.zzd != -1) {
            this.zzj = zzouVar.zzd;
        }
        this.zzi = null;
    }

    private final void zzp(zzmq zzmqVar) {
        if (zzmqVar.zzb.zzo()) {
            String str = this.zzi;
            if (str != null) {
                zzou zzouVar = (zzou) this.zze.get(str);
                zzouVar.getClass();
                zzo(zzouVar);
                return;
            }
            return;
        }
        zzou zzouVar2 = (zzou) this.zze.get(this.zzi);
        zzou zzouVarZzm = zzm(zzmqVar.zzc, zzmqVar.zzd);
        this.zzi = zzouVarZzm.zzb;
        zzi(zzmqVar);
        zzur zzurVar = zzmqVar.zzd;
        if (zzurVar == null || !zzurVar.zzb()) {
            return;
        }
        if (zzouVar2 != null) {
            if (zzouVar2.zzd == zzurVar.zzd && zzouVar2.zze != null && zzouVar2.zze.zzb == zzmqVar.zzd.zzb && zzouVar2.zze.zzc == zzmqVar.zzd.zzc) {
                return;
            }
        }
        zzur zzurVar2 = zzmqVar.zzd;
        String unused = zzm(zzmqVar.zzc, new zzur(zzurVar2.zza, zzurVar2.zzd)).zzb;
        String unused2 = zzouVarZzm.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    @Nullable
    public final synchronized String zze() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final synchronized String zzf(zzcx zzcxVar, zzur zzurVar) {
        return zzm(zzcxVar.zzn(zzurVar.zza, this.zzd).zzd, zzurVar).zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final synchronized void zzg(zzmq zzmqVar) {
        zzoy zzoyVar;
        try {
            String str = this.zzi;
            if (str != null) {
                zzou zzouVar = (zzou) this.zze.get(str);
                zzouVar.getClass();
                zzo(zzouVar);
            }
            Iterator it = this.zze.values().iterator();
            while (it.hasNext()) {
                zzou zzouVar2 = (zzou) it.next();
                it.remove();
                if (zzouVar2.zzf && (zzoyVar = this.zzg) != null) {
                    zzoyVar.zzd(zzmqVar, zzouVar2.zzb, false);
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final void zzh(zzoy zzoyVar) {
        this.zzg = zzoyVar;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0040 A[Catch: all -> 0x003d, TryCatch #0 {all -> 0x003d, blocks: (B:3:0x0001, B:5:0x0006, B:8:0x0010, B:10:0x0014, B:12:0x001e, B:14:0x002a, B:16:0x0034, B:21:0x0040, B:23:0x004c, B:24:0x0052, B:26:0x0057, B:28:0x005d, B:30:0x0074, B:31:0x009c, B:33:0x00a2, B:34:0x00a8, B:36:0x00b4, B:38:0x00ba), top: B:45:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:23:0x004c A[Catch: all -> 0x003d, TryCatch #0 {all -> 0x003d, blocks: (B:3:0x0001, B:5:0x0006, B:8:0x0010, B:10:0x0014, B:12:0x001e, B:14:0x002a, B:16:0x0034, B:21:0x0040, B:23:0x004c, B:24:0x0052, B:26:0x0057, B:28:0x005d, B:30:0x0074, B:31:0x009c, B:33:0x00a2, B:34:0x00a8, B:36:0x00b4, B:38:0x00ba), top: B:45:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:30:0x0074 A[Catch: all -> 0x003d, TryCatch #0 {all -> 0x003d, blocks: (B:3:0x0001, B:5:0x0006, B:8:0x0010, B:10:0x0014, B:12:0x001e, B:14:0x002a, B:16:0x0034, B:21:0x0040, B:23:0x004c, B:24:0x0052, B:26:0x0057, B:28:0x005d, B:30:0x0074, B:31:0x009c, B:33:0x00a2, B:34:0x00a8, B:36:0x00b4, B:38:0x00ba), top: B:45:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x00a2 A[Catch: all -> 0x003d, TryCatch #0 {all -> 0x003d, blocks: (B:3:0x0001, B:5:0x0006, B:8:0x0010, B:10:0x0014, B:12:0x001e, B:14:0x002a, B:16:0x0034, B:21:0x0040, B:23:0x004c, B:24:0x0052, B:26:0x0057, B:28:0x005d, B:30:0x0074, B:31:0x009c, B:33:0x00a2, B:34:0x00a8, B:36:0x00b4, B:38:0x00ba), top: B:45:0x0001 }] */
    @Override // com.google.android.gms.internal.ads.zzoz
    public final synchronized void zzi(zzmq zzmqVar) {
        zzou zzouVarZzm;
        zzur zzurVar;
        zzou zzouVarZzm2;
        zzou zzouVar;
        try {
            this.zzg.getClass();
            if (!zzmqVar.zzb.zzo()) {
                zzur zzurVar2 = zzmqVar.zzd;
                if (zzurVar2 == null) {
                    zzouVarZzm = zzm(zzmqVar.zzc, zzmqVar.zzd);
                    if (this.zzi == null) {
                        this.zzi = zzouVarZzm.zzb;
                    }
                    zzurVar = zzmqVar.zzd;
                    if (zzurVar != null) {
                        zzouVarZzm2 = zzm(zzmqVar.zzc, new zzur(zzurVar.zza, zzurVar.zzd, zzurVar.zzb));
                        if (!zzouVarZzm2.zzf) {
                            zzouVarZzm2.zzf = true;
                            zzmqVar.zzb.zzn(zzmqVar.zzd.zza, this.zzd);
                            this.zzd.zzi(zzmqVar.zzd.zzb);
                            Math.max(0L, zzfy.zzt(0L) + zzfy.zzt(0L));
                            String unused = zzouVarZzm2.zzb;
                        }
                    }
                    if (!zzouVarZzm.zzf) {
                        zzouVarZzm.zzf = true;
                        String unused2 = zzouVarZzm.zzb;
                    }
                    if (zzouVarZzm.zzb.equals(this.zzi)) {
                        zzouVarZzm.zzg = true;
                        this.zzg.zzc(zzmqVar, zzouVarZzm.zzb);
                    }
                } else if (zzurVar2.zzd >= zzl() && ((zzouVar = (zzou) this.zze.get(this.zzi)) == null || zzouVar.zzd != -1 || zzouVar.zzc == zzmqVar.zzc)) {
                    zzouVarZzm = zzm(zzmqVar.zzc, zzmqVar.zzd);
                    if (this.zzi == null) {
                        this.zzi = zzouVarZzm.zzb;
                    }
                    zzurVar = zzmqVar.zzd;
                    if (zzurVar != null && zzurVar.zzb()) {
                        zzouVarZzm2 = zzm(zzmqVar.zzc, new zzur(zzurVar.zza, zzurVar.zzd, zzurVar.zzb));
                        if (!zzouVarZzm2.zzf) {
                            zzouVarZzm2.zzf = true;
                            zzmqVar.zzb.zzn(zzmqVar.zzd.zza, this.zzd);
                            this.zzd.zzi(zzmqVar.zzd.zzb);
                            Math.max(0L, zzfy.zzt(0L) + zzfy.zzt(0L));
                            String unused3 = zzouVarZzm2.zzb;
                        }
                    }
                    if (!zzouVarZzm.zzf) {
                        zzouVarZzm.zzf = true;
                        String unused4 = zzouVarZzm.zzb;
                    }
                    if (zzouVarZzm.zzb.equals(this.zzi) && !zzouVarZzm.zzg) {
                        zzouVarZzm.zzg = true;
                        this.zzg.zzc(zzmqVar, zzouVarZzm.zzb);
                    }
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final synchronized void zzj(zzmq zzmqVar, int i11) {
        try {
            this.zzg.getClass();
            Iterator it = this.zze.values().iterator();
            while (it.hasNext()) {
                zzou zzouVar = (zzou) it.next();
                if (zzouVar.zzk(zzmqVar)) {
                    it.remove();
                    if (zzouVar.zzf) {
                        boolean zEquals = zzouVar.zzb.equals(this.zzi);
                        boolean z11 = false;
                        if (i11 == 0 && zEquals && zzouVar.zzg) {
                            z11 = true;
                        }
                        if (zEquals) {
                            zzo(zzouVar);
                        }
                        this.zzg.zzd(zzmqVar, zzouVar.zzb, z11);
                    }
                }
            }
            zzp(zzmqVar);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzoz
    public final synchronized void zzk(zzmq zzmqVar) {
        try {
            this.zzg.getClass();
            zzcx zzcxVar = this.zzh;
            this.zzh = zzmqVar.zzb;
            Iterator it = this.zze.values().iterator();
            while (it.hasNext()) {
                zzou zzouVar = (zzou) it.next();
                if (!zzouVar.zzl(zzcxVar, this.zzh) || zzouVar.zzk(zzmqVar)) {
                    it.remove();
                    if (zzouVar.zzf) {
                        if (zzouVar.zzb.equals(this.zzi)) {
                            zzo(zzouVar);
                        }
                        this.zzg.zzd(zzmqVar, zzouVar.zzb, false);
                    }
                }
            }
            zzp(zzmqVar);
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
