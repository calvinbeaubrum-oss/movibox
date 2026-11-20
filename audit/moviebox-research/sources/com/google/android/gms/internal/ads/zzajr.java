package com.google.android.gms.internal.ads;

import java.math.BigInteger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzajr implements zzadu {
    final /* synthetic */ zzajs zza;

    public /* synthetic */ zzajr(zzajs zzajsVar, zzajq zzajqVar) {
        this.zza = zzajsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final long zza() {
        zzajs zzajsVar = this.zza;
        return zzajsVar.zzd.zzf(zzajsVar.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final zzads zzg(long j11) {
        zzajs zzajsVar = this.zza;
        long jZzg = zzajsVar.zzd.zzg(j11);
        long j12 = zzajsVar.zzb;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(jZzg);
        zzajs zzajsVar2 = this.zza;
        long jLongValue = j12 + bigIntegerValueOf.multiply(BigInteger.valueOf(zzajsVar2.zzc - zzajsVar2.zzb)).divide(BigInteger.valueOf(this.zza.zzf)).longValue();
        zzajs zzajsVar3 = this.zza;
        zzadv zzadvVar = new zzadv(j11, Math.max(zzajsVar3.zzb, Math.min(jLongValue - 30000, zzajsVar3.zzc - 1)));
        return new zzads(zzadvVar, zzadvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final boolean zzh() {
        return true;
    }
}
