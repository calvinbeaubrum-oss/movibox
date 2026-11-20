package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzhcp {
    public abstract int zza(Object obj);

    public abstract int zzb(Object obj);

    public abstract Object zzc(Object obj);

    public abstract Object zzd(Object obj);

    public abstract Object zze(Object obj, Object obj2);

    public abstract Object zzf();

    public abstract Object zzg(Object obj);

    public abstract void zzh(Object obj, int i11, int i12);

    public abstract void zzi(Object obj, int i11, long j11);

    public abstract void zzj(Object obj, int i11, Object obj2);

    public abstract void zzk(Object obj, int i11, zzgyl zzgylVar);

    public abstract void zzl(Object obj, int i11, long j11);

    public abstract void zzm(Object obj);

    public abstract void zzn(Object obj, Object obj2);

    public abstract void zzo(Object obj, Object obj2);

    public final boolean zzp(Object obj, zzhbq zzhbqVar) throws IOException {
        int iZzd = zzhbqVar.zzd();
        int i11 = iZzd >>> 3;
        int i12 = iZzd & 7;
        if (i12 == 0) {
            zzl(obj, i11, zzhbqVar.zzl());
            return true;
        }
        if (i12 == 1) {
            zzi(obj, i11, zzhbqVar.zzk());
            return true;
        }
        if (i12 == 2) {
            zzk(obj, i11, zzhbqVar.zzp());
            return true;
        }
        if (i12 != 3) {
            if (i12 == 4) {
                return false;
            }
            if (i12 != 5) {
                throw zzhag.zza();
            }
            zzh(obj, i11, zzhbqVar.zzf());
            return true;
        }
        Object objZzf = zzf();
        int i13 = i11 << 3;
        while (zzhbqVar.zzc() != Integer.MAX_VALUE && zzp(objZzf, zzhbqVar)) {
        }
        if ((4 | i13) != zzhbqVar.zzd()) {
            throw zzhag.zzb();
        }
        zzg(objZzf);
        zzj(obj, i11, objZzf);
        return true;
    }

    public abstract boolean zzq(zzhbq zzhbqVar);

    public abstract void zzr(Object obj, zzgzb zzgzbVar) throws IOException;
}
