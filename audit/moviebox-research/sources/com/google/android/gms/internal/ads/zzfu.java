package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzfu implements zzew {
    private static final List zza = new ArrayList(50);
    private final Handler zzb;

    public zzfu(Handler handler) {
        this.zzb = handler;
    }

    public static /* bridge */ /* synthetic */ void zzl(zzft zzftVar) {
        List list = zza;
        synchronized (list) {
            try {
                if (list.size() < 50) {
                    list.add(zzftVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static zzft zzm() {
        zzft zzftVar;
        List list = zza;
        synchronized (list) {
            try {
                zzftVar = list.isEmpty() ? new zzft(null) : (zzft) list.remove(list.size() - 1);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return zzftVar;
    }

    @Override // com.google.android.gms.internal.ads.zzew
    public final Looper zza() {
        return this.zzb.getLooper();
    }

    @Override // com.google.android.gms.internal.ads.zzew
    public final zzev zzb(int i11) {
        Handler handler = this.zzb;
        zzft zzftVarZzm = zzm();
        zzftVarZzm.zzb(handler.obtainMessage(i11), this);
        return zzftVarZzm;
    }

    @Override // com.google.android.gms.internal.ads.zzew
    public final zzev zzc(int i11, @Nullable Object obj) {
        Handler handler = this.zzb;
        zzft zzftVarZzm = zzm();
        zzftVarZzm.zzb(handler.obtainMessage(i11, obj), this);
        return zzftVarZzm;
    }

    @Override // com.google.android.gms.internal.ads.zzew
    public final zzev zzd(int i11, int i12, int i13) {
        Handler handler = this.zzb;
        zzft zzftVarZzm = zzm();
        zzftVarZzm.zzb(handler.obtainMessage(1, i12, i13), this);
        return zzftVarZzm;
    }

    @Override // com.google.android.gms.internal.ads.zzew
    public final void zze(@Nullable Object obj) {
        this.zzb.removeCallbacksAndMessages(null);
    }

    @Override // com.google.android.gms.internal.ads.zzew
    public final void zzf(int i11) {
        this.zzb.removeMessages(i11);
    }

    @Override // com.google.android.gms.internal.ads.zzew
    public final boolean zzg(int i11) {
        return this.zzb.hasMessages(0);
    }

    @Override // com.google.android.gms.internal.ads.zzew
    public final boolean zzh(Runnable runnable) {
        return this.zzb.post(runnable);
    }

    @Override // com.google.android.gms.internal.ads.zzew
    public final boolean zzi(int i11) {
        return this.zzb.sendEmptyMessage(i11);
    }

    @Override // com.google.android.gms.internal.ads.zzew
    public final boolean zzj(int i11, long j11) {
        return this.zzb.sendEmptyMessageAtTime(2, j11);
    }

    @Override // com.google.android.gms.internal.ads.zzew
    public final boolean zzk(zzev zzevVar) {
        return ((zzft) zzevVar).zzc(this.zzb);
    }
}
