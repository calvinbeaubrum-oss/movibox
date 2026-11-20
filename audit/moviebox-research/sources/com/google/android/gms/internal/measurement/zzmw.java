package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzmw extends zzmx {
    public zzmw(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final double zza(Object obj, long j11) {
        return Double.longBitsToDouble(zzk(obj, j11));
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final float zzb(Object obj, long j11) {
        return Float.intBitsToFloat(zzj(obj, j11));
    }

    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.measurement.zzmy.zzi(java.lang.Object, long, boolean):void */
    /* JADX WARN: Failed to inline method: com.google.android.gms.internal.measurement.zzmy.zzj(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 boolean)' in method call: com.google.android.gms.internal.measurement.zzmy.zzi(java.lang.Object, long, boolean):void */
    /* JADX WARN: Unknown register number '(r5v0 boolean)' in method call: com.google.android.gms.internal.measurement.zzmy.zzj(java.lang.Object, long, boolean):void */
    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zzc(Object obj, long j11, boolean z11) {
        if (zzmy.zzb) {
            zzmy.zzi(obj, j11, z11);
        } else {
            zzmy.zzj(obj, j11, z11);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zzd(Object obj, long j11, byte b11) {
        if (zzmy.zzb) {
            zzmy.zzD(obj, j11, b11);
        } else {
            zzmy.zzE(obj, j11, b11);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zze(Object obj, long j11, double d11) {
        zzo(obj, j11, Double.doubleToLongBits(d11));
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final void zzf(Object obj, long j11, float f11) {
        zzn(obj, j11, Float.floatToIntBits(f11));
    }

    @Override // com.google.android.gms.internal.measurement.zzmx
    public final boolean zzg(Object obj, long j11) {
        return zzmy.zzb ? zzmy.zzt(obj, j11) : zzmy.zzu(obj, j11);
    }
}
