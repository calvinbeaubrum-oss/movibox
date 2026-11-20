package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzaxx implements Callable {
    protected final String zza = getClass().getSimpleName();
    protected final zzawj zzb;
    protected final String zzc;
    protected final String zzd;
    protected final zzasg zze;
    protected Method zzf;
    protected final int zzg;
    protected final int zzh;

    public zzaxx(zzawj zzawjVar, String str, String str2, zzasg zzasgVar, int i11, int i12) {
        this.zzb = zzawjVar;
        this.zzc = str;
        this.zzd = str2;
        this.zze = zzasgVar;
        this.zzg = i11;
        this.zzh = i12;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() throws Exception {
        zzm();
        return null;
    }

    public abstract void zza() throws IllegalAccessException, InvocationTargetException;

    public Void zzm() throws Exception {
        int i11;
        try {
            long jNanoTime = System.nanoTime();
            Method methodZzj = this.zzb.zzj(this.zzc, this.zzd);
            this.zzf = methodZzj;
            if (methodZzj == null) {
                return null;
            }
            zza();
            zzavd zzavdVarZzd = this.zzb.zzd();
            if (zzavdVarZzd == null || (i11 = this.zzg) == Integer.MIN_VALUE) {
                return null;
            }
            zzavdVarZzd.zzc(this.zzh, i11, (System.nanoTime() - jNanoTime) / 1000, null, null);
            return null;
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }
}
