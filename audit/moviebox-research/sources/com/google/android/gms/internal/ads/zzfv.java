package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzfv {
    private long[] zza;
    private Object[] zzb;
    private int zzc;
    private int zzd;

    public zzfv() {
        this(10);
    }

    public zzfv(int i11) {
        this.zza = new long[10];
        this.zzb = new Object[10];
    }

    @Nullable
    private final Object zzf() {
        zzek.zzf(this.zzd > 0);
        Object[] objArr = this.zzb;
        int i11 = this.zzc;
        Object obj = objArr[i11];
        objArr[i11] = null;
        this.zzc = (i11 + 1) % objArr.length;
        this.zzd--;
        return obj;
    }

    public final synchronized int zza() {
        return this.zzd;
    }

    @Nullable
    public final synchronized Object zzb() {
        if (this.zzd == 0) {
            return null;
        }
        return zzf();
    }

    @Nullable
    public final synchronized Object zzc(long j11) {
        Object objZzf;
        objZzf = null;
        while (this.zzd > 0 && j11 - this.zza[this.zzc] >= 0) {
            objZzf = zzf();
        }
        return objZzf;
    }

    public final synchronized void zzd(long j11, Object obj) {
        try {
            int i11 = this.zzd;
            if (i11 > 0) {
                if (j11 <= this.zza[((this.zzc + i11) - 1) % this.zzb.length]) {
                    zze();
                }
            }
            int length = this.zzb.length;
            if (this.zzd >= length) {
                int i12 = length + length;
                long[] jArr = new long[i12];
                Object[] objArr = new Object[i12];
                int i13 = this.zzc;
                int i14 = length - i13;
                System.arraycopy(this.zza, i13, jArr, 0, i14);
                System.arraycopy(this.zzb, this.zzc, objArr, 0, i14);
                int i15 = this.zzc;
                if (i15 > 0) {
                    System.arraycopy(this.zza, 0, jArr, i14, i15);
                    System.arraycopy(this.zzb, 0, objArr, i14, this.zzc);
                }
                this.zza = jArr;
                this.zzb = objArr;
                this.zzc = 0;
            }
            int i16 = this.zzc;
            int i17 = this.zzd;
            Object[] objArr2 = this.zzb;
            int length2 = (i16 + i17) % objArr2.length;
            this.zza[length2] = j11;
            objArr2[length2] = obj;
            this.zzd = i17 + 1;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void zze() {
        this.zzc = 0;
        this.zzd = 0;
        Arrays.fill(this.zzb, (Object) null);
    }
}
