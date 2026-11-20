package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Arrays;
import okhttp3.internal.http2.Settings;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzyx {
    private int zza;
    private int zzb;
    private int zzc = 0;
    private zzyq[] zzd = new zzyq[100];

    public zzyx(boolean z11, int i11) {
    }

    public final synchronized int zza() {
        return this.zzb * 65536;
    }

    public final synchronized zzyq zzb() {
        zzyq zzyqVar;
        try {
            this.zzb++;
            int i11 = this.zzc;
            if (i11 > 0) {
                zzyq[] zzyqVarArr = this.zzd;
                int i12 = i11 - 1;
                this.zzc = i12;
                zzyqVar = zzyqVarArr[i12];
                zzyqVar.getClass();
                zzyqVarArr[i12] = null;
            } else {
                zzyqVar = new zzyq(new byte[65536], 0);
                int i13 = this.zzb;
                zzyq[] zzyqVarArr2 = this.zzd;
                int length = zzyqVarArr2.length;
                if (i13 > length) {
                    this.zzd = (zzyq[]) Arrays.copyOf(zzyqVarArr2, length + length);
                    return zzyqVar;
                }
            }
            return zzyqVar;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void zzc(zzyq zzyqVar) {
        zzyq[] zzyqVarArr = this.zzd;
        int i11 = this.zzc;
        this.zzc = i11 + 1;
        zzyqVarArr[i11] = zzyqVar;
        this.zzb--;
        notifyAll();
    }

    public final synchronized void zzd(@Nullable zzyr zzyrVar) {
        while (zzyrVar != null) {
            try {
                zzyq[] zzyqVarArr = this.zzd;
                int i11 = this.zzc;
                this.zzc = i11 + 1;
                zzyqVarArr[i11] = zzyrVar.zzc();
                this.zzb--;
                zzyrVar = zzyrVar.zzd();
            } catch (Throwable th2) {
                throw th2;
            }
        }
        notifyAll();
    }

    public final synchronized void zze() {
        zzf(0);
    }

    public final synchronized void zzf(int i11) {
        int i12 = this.zza;
        this.zza = i11;
        if (i11 < i12) {
            zzg();
        }
    }

    public final synchronized void zzg() {
        int i11 = this.zza;
        int i12 = zzfy.zza;
        int iMax = Math.max(0, ((i11 + Settings.DEFAULT_INITIAL_WINDOW_SIZE) / 65536) - this.zzb);
        int i13 = this.zzc;
        if (iMax >= i13) {
            return;
        }
        Arrays.fill(this.zzd, iMax, i13, (Object) null);
        this.zzc = iMax;
    }
}
