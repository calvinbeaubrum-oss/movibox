package com.google.android.libraries.places.internal;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzbef extends zzbej implements zzbfr, zzbmv {
    private static final Logger zza = Logger.getLogger(zzbef.class.getName());
    private final zzbqz zzb;
    private final zzbis zzc;
    private final boolean zzd;
    private zzbcf zze;
    private volatile boolean zzf;

    public zzbef(zzbrb zzbrbVar, zzbqo zzbqoVar, zzbqz zzbqzVar, zzbcf zzbcfVar, zzayj zzayjVar, boolean z11) {
        zzmt.zzc(zzbqzVar, "transportTracer");
        this.zzb = zzbqzVar;
        this.zzd = !Boolean.TRUE.equals(zzayjVar.zzl(zzbjd.zzo));
        this.zzc = new zzbmw(this, zzbrbVar, zzbqoVar);
        this.zze = zzbcfVar;
    }

    public abstract zzbec zza();

    public abstract zzbee zzb();

    @Override // com.google.android.libraries.places.internal.zzbej
    public /* bridge */ /* synthetic */ zzbei zzc() {
        throw null;
    }

    @Override // com.google.android.libraries.places.internal.zzbej
    public final zzbis zzd() {
        return this.zzc;
    }

    public final zzbqz zze() {
        return this.zzb;
    }

    @Override // com.google.android.libraries.places.internal.zzbfr
    public final void zzg(zzbjj zzbjjVar) {
        zzbjjVar.zzb("remote_addr", zzam().zzc(zzazw.zza));
    }

    @Override // com.google.android.libraries.places.internal.zzbfr
    public final void zzh(zzbdo zzbdoVar) {
        zzmt.zzf(!zzbdoVar.zzl(), "Should not cancel with OK status");
        this.zzf = true;
        zza().zza(zzbdoVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbmv
    public final void zzi(zzbra zzbraVar, boolean z11, boolean z12, int i11) {
        boolean z13 = true;
        if (zzbraVar == null && !z11) {
            z13 = false;
        }
        zzmt.zzf(z13, "null frame before EOS");
        zza().zzb(zzbraVar, z11, z12, i11);
    }

    @Override // com.google.android.libraries.places.internal.zzbfr
    public final void zzj() {
        if (zzb().zzk()) {
            return;
        }
        zzb().zzg = true;
        zzd().zzb();
    }

    @Override // com.google.android.libraries.places.internal.zzbfr
    public final void zzk(zzazn zzaznVar) {
        zzbcf zzbcfVar = this.zze;
        zzbca zzbcaVar = zzbjd.zzb;
        zzbcfVar.zzd(zzbcaVar);
        this.zze.zzf(zzbcaVar, Long.valueOf(Math.max(0L, zzaznVar.zzb(TimeUnit.NANOSECONDS))));
    }

    @Override // com.google.android.libraries.places.internal.zzbfr
    public final void zzl(zzazq zzazqVar) {
        zzbee.zzc(zzb(), zzazqVar);
    }

    @Override // com.google.android.libraries.places.internal.zzbfr
    public final void zzm(int i11) {
        zzb().zzx(i11);
    }

    @Override // com.google.android.libraries.places.internal.zzbfr
    public final void zzn(int i11) {
        this.zzc.zzd(i11);
    }

    @Override // com.google.android.libraries.places.internal.zzbfr
    public final void zzo(zzbft zzbftVar) {
        zzb().zzi(zzbftVar);
        zza().zzc(this.zze, null);
        this.zze = null;
    }

    @Override // com.google.android.libraries.places.internal.zzbej, com.google.android.libraries.places.internal.zzbqp
    public final boolean zzp() {
        return zzc().zzc() && !this.zzf;
    }

    public final boolean zzq() {
        return this.zzd;
    }
}
