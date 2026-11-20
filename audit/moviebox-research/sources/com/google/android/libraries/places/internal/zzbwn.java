package com.google.android.libraries.places.internal;

import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
@SourceDebugExtension
public final class zzbwn {
    public static final zzbwm zza = new zzbwm(null);

    @JvmField
    public final byte[] zzb;

    @JvmField
    public int zzc;

    @JvmField
    public int zzd;

    @JvmField
    public boolean zze;

    @JvmField
    public final boolean zzf;

    @JvmField
    public zzbwn zzg;

    @JvmField
    public zzbwn zzh;

    public zzbwn() {
        this.zzb = new byte[8192];
        this.zzf = true;
        this.zze = false;
    }

    public zzbwn(byte[] data, int i11, int i12, boolean z11, boolean z12) {
        Intrinsics.g(data, "data");
        this.zzb = data;
        this.zzc = i11;
        this.zzd = i12;
        this.zze = z11;
        this.zzf = false;
    }

    public final zzbwn zza() {
        zzbwn zzbwnVar = this.zzg;
        if (zzbwnVar == this) {
            zzbwnVar = null;
        }
        zzbwn zzbwnVar2 = this.zzh;
        Intrinsics.d(zzbwnVar2);
        zzbwnVar2.zzg = this.zzg;
        zzbwn zzbwnVar3 = this.zzg;
        Intrinsics.d(zzbwnVar3);
        zzbwnVar3.zzh = this.zzh;
        this.zzg = null;
        this.zzh = null;
        return zzbwnVar;
    }

    public final zzbwn zzb(zzbwn segment) {
        Intrinsics.g(segment, "segment");
        segment.zzh = this;
        segment.zzg = this.zzg;
        zzbwn zzbwnVar = this.zzg;
        Intrinsics.d(zzbwnVar);
        zzbwnVar.zzh = segment;
        this.zzg = segment;
        return segment;
    }

    public final zzbwn zzc() {
        this.zze = true;
        return new zzbwn(this.zzb, this.zzc, this.zzd, true, false);
    }

    public final zzbwn zzd(int i11) {
        zzbwn zzbwnVarZza;
        if (i11 > this.zzd - this.zzc) {
            throw new IllegalArgumentException("byteCount out of range");
        }
        if (i11 >= 1024) {
            zzbwnVarZza = zzc();
        } else {
            byte[] bArr = this.zzb;
            zzbwnVarZza = zzbwo.zza();
            byte[] bArr2 = zzbwnVarZza.zzb;
            int i12 = this.zzc;
            ArraysKt___ArraysJvmKt.m(bArr, bArr2, 0, i12, i12 + i11, 2, null);
        }
        zzbwnVarZza.zzd = zzbwnVarZza.zzc + i11;
        this.zzc += i11;
        zzbwn zzbwnVar = this.zzh;
        Intrinsics.d(zzbwnVar);
        zzbwnVar.zzb(zzbwnVarZza);
        return zzbwnVarZza;
    }

    public final void zze(zzbwn sink, int i11) {
        Intrinsics.g(sink, "sink");
        if (!sink.zzf) {
            throw new IllegalStateException("only owner can write");
        }
        int i12 = sink.zzd;
        int i13 = i12 + i11;
        if (i13 > 8192) {
            if (sink.zze) {
                throw new IllegalArgumentException();
            }
            int i14 = sink.zzc;
            if (i13 - i14 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = sink.zzb;
            ArraysKt___ArraysJvmKt.m(bArr, bArr, 0, i14, i12, 2, null);
            i12 = sink.zzd - sink.zzc;
            sink.zzd = i12;
            sink.zzc = 0;
        }
        byte[] bArr2 = this.zzb;
        byte[] bArr3 = sink.zzb;
        int i15 = this.zzc;
        ArraysKt___ArraysJvmKt.h(bArr2, bArr3, i12, i15, i15 + i11);
        sink.zzd += i11;
        this.zzc += i11;
    }
}
