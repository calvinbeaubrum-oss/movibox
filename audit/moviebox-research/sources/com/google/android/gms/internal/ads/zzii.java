package com.google.android.gms.internal.ads;

import android.util.Pair;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzii extends zzcx {
    private final int zzc;
    private final zzwk zzd;

    public zzii(boolean z11, zzwk zzwkVar) {
        this.zzd = zzwkVar;
        this.zzc = zzwkVar.zzc();
    }

    private final int zzw(int i11, boolean z11) {
        if (z11) {
            return this.zzd.zzd(i11);
        }
        if (i11 >= this.zzc - 1) {
            return -1;
        }
        return i11 + 1;
    }

    private final int zzx(int i11, boolean z11) {
        if (z11) {
            return this.zzd.zze(i11);
        }
        if (i11 <= 0) {
            return -1;
        }
        return i11 - 1;
    }

    @Override // com.google.android.gms.internal.ads.zzcx
    public final int zza(Object obj) {
        int iZza;
        if (obj instanceof Pair) {
            Pair pair = (Pair) obj;
            Object obj2 = pair.first;
            Object obj3 = pair.second;
            int iZzp = zzp(obj2);
            if (iZzp != -1 && (iZza = zzu(iZzp).zza(obj3)) != -1) {
                return zzs(iZzp) + iZza;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcx
    public final zzcu zzd(int i11, zzcu zzcuVar, boolean z11) {
        int iZzq = zzq(i11);
        int iZzt = zzt(iZzq);
        zzu(iZzq).zzd(i11 - zzs(iZzq), zzcuVar, z11);
        zzcuVar.zzd += iZzt;
        if (z11) {
            Object objZzv = zzv(iZzq);
            Object obj = zzcuVar.zzc;
            obj.getClass();
            zzcuVar.zzc = Pair.create(objZzv, obj);
        }
        return zzcuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcx
    public final zzcw zze(int i11, zzcw zzcwVar, long j11) {
        int iZzr = zzr(i11);
        int iZzt = zzt(iZzr);
        int iZzs = zzs(iZzr);
        zzu(iZzr).zze(i11 - iZzt, zzcwVar, j11);
        Object objZzv = zzv(iZzr);
        if (!zzcw.zza.equals(zzcwVar.zzc)) {
            objZzv = Pair.create(objZzv, zzcwVar.zzc);
        }
        zzcwVar.zzc = objZzv;
        zzcwVar.zzp += iZzs;
        zzcwVar.zzq += iZzs;
        return zzcwVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcx
    public final Object zzf(int i11) {
        int iZzq = zzq(i11);
        return Pair.create(zzv(iZzq), zzu(iZzq).zzf(i11 - zzs(iZzq)));
    }

    @Override // com.google.android.gms.internal.ads.zzcx
    public final int zzg(boolean z11) {
        if (this.zzc != 0) {
            int iZza = z11 ? this.zzd.zza() : 0;
            while (zzu(iZza).zzo()) {
                iZza = zzw(iZza, z11);
                if (iZza == -1) {
                }
            }
            return zzt(iZza) + zzu(iZza).zzg(z11);
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcx
    public final int zzh(boolean z11) {
        int i11 = this.zzc;
        if (i11 != 0) {
            int iZzb = z11 ? this.zzd.zzb() : i11 - 1;
            while (zzu(iZzb).zzo()) {
                iZzb = zzx(iZzb, z11);
                if (iZzb == -1) {
                }
            }
            return zzt(iZzb) + zzu(iZzb).zzh(z11);
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcx
    public final int zzj(int i11, int i12, boolean z11) {
        int iZzr = zzr(i11);
        int iZzt = zzt(iZzr);
        int iZzj = zzu(iZzr).zzj(i11 - iZzt, i12 == 2 ? 0 : i12, z11);
        if (iZzj != -1) {
            return iZzt + iZzj;
        }
        int iZzw = zzw(iZzr, z11);
        while (iZzw != -1 && zzu(iZzw).zzo()) {
            iZzw = zzw(iZzw, z11);
        }
        if (iZzw != -1) {
            return zzt(iZzw) + zzu(iZzw).zzg(z11);
        }
        if (i12 == 2) {
            return zzg(z11);
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcx
    public final int zzk(int i11, int i12, boolean z11) {
        int iZzr = zzr(i11);
        int iZzt = zzt(iZzr);
        int iZzk = zzu(iZzr).zzk(i11 - iZzt, 0, false);
        if (iZzk != -1) {
            return iZzt + iZzk;
        }
        int iZzx = zzx(iZzr, false);
        while (iZzx != -1 && zzu(iZzx).zzo()) {
            iZzx = zzx(iZzx, false);
        }
        if (iZzx != -1) {
            return zzt(iZzx) + zzu(iZzx).zzh(false);
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcx
    public final zzcu zzn(Object obj, zzcu zzcuVar) {
        Pair pair = (Pair) obj;
        Object obj2 = pair.first;
        Object obj3 = pair.second;
        int iZzp = zzp(obj2);
        int iZzt = zzt(iZzp);
        zzu(iZzp).zzn(obj3, zzcuVar);
        zzcuVar.zzd += iZzt;
        zzcuVar.zzc = obj;
        return zzcuVar;
    }

    public abstract int zzp(Object obj);

    public abstract int zzq(int i11);

    public abstract int zzr(int i11);

    public abstract int zzs(int i11);

    public abstract int zzt(int i11);

    public abstract zzcx zzu(int i11);

    public abstract Object zzv(int i11);
}
