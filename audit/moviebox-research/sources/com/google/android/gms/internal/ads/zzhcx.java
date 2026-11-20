package com.google.android.gms.internal.ads;

import libcore.io.Memory;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzhcx extends zzhcy {
    public zzhcx(Unsafe unsafe) {
        super(unsafe);
    }

    @Override // com.google.android.gms.internal.ads.zzhcy
    public final byte zza(long j11) {
        return Memory.peekByte(j11);
    }

    @Override // com.google.android.gms.internal.ads.zzhcy
    public final double zzb(Object obj, long j11) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j11));
    }

    @Override // com.google.android.gms.internal.ads.zzhcy
    public final float zzc(Object obj, long j11) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j11));
    }

    @Override // com.google.android.gms.internal.ads.zzhcy
    public final void zzd(long j11, byte[] bArr, long j12, long j13) {
        Memory.peekByteArray(j11, bArr, (int) j12, (int) j13);
    }

    @Override // com.google.android.gms.internal.ads.zzhcy
    public final void zze(Object obj, long j11, boolean z11) {
        if (zzhcz.zzb) {
            zzhcz.zzG(obj, j11, z11 ? (byte) 1 : (byte) 0);
        } else {
            zzhcz.zzH(obj, j11, z11 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcy
    public final void zzf(Object obj, long j11, byte b11) {
        if (zzhcz.zzb) {
            zzhcz.zzG(obj, j11, b11);
        } else {
            zzhcz.zzH(obj, j11, b11);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzhcy
    public final void zzg(Object obj, long j11, double d11) {
        this.zza.putLong(obj, j11, Double.doubleToLongBits(d11));
    }

    @Override // com.google.android.gms.internal.ads.zzhcy
    public final void zzh(Object obj, long j11, float f11) {
        this.zza.putInt(obj, j11, Float.floatToIntBits(f11));
    }

    @Override // com.google.android.gms.internal.ads.zzhcy
    public final boolean zzi(Object obj, long j11) {
        return zzhcz.zzb ? zzhcz.zzw(obj, j11) : zzhcz.zzx(obj, j11);
    }
}
