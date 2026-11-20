package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzh {
    private long zzA;

    @Nullable
    private String zzB;
    private boolean zzC;
    private long zzD;
    private long zzE;
    private final zzfr zza;
    private final String zzb;

    @Nullable
    private String zzc;

    @Nullable
    private String zzd;

    @Nullable
    private String zze;

    @Nullable
    private String zzf;
    private long zzg;
    private long zzh;
    private long zzi;

    @Nullable
    private String zzj;
    private long zzk;

    @Nullable
    private String zzl;
    private long zzm;
    private long zzn;
    private boolean zzo;
    private boolean zzp;

    @Nullable
    private String zzq;

    @Nullable
    private Boolean zzr;
    private long zzs;

    @Nullable
    private List zzt;

    @Nullable
    private String zzu;
    private long zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    public zzh(zzfr zzfrVar, String str) {
        Preconditions.checkNotNull(zzfrVar);
        Preconditions.checkNotEmpty(str);
        this.zza = zzfrVar;
        this.zzb = str;
        zzfrVar.zzaz().zzg();
    }

    @Nullable
    public final String zzA() {
        this.zza.zzaz().zzg();
        return this.zze;
    }

    @Nullable
    public final String zzB() {
        this.zza.zzaz().zzg();
        return this.zzu;
    }

    @Nullable
    public final List zzC() {
        this.zza.zzaz().zzg();
        return this.zzt;
    }

    public final void zzD() {
        this.zza.zzaz().zzg();
        this.zzC = false;
    }

    public final void zzE() {
        this.zza.zzaz().zzg();
        long j11 = this.zzg + 1;
        if (j11 > 2147483647L) {
            this.zza.zzay().zzk().zzb("Bundle index overflow. appId", zzeh.zzn(this.zzb));
            j11 = 0;
        }
        this.zzC = true;
        this.zzg = j11;
    }

    public final void zzF(@Nullable String str) {
        this.zza.zzaz().zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzC |= true ^ zzg.zza(this.zzq, str);
        this.zzq = str;
    }

    public final void zzG(boolean z11) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzp != z11;
        this.zzp = z11;
    }

    public final void zzH(@Nullable String str) {
        this.zza.zzaz().zzg();
        this.zzC |= !zzg.zza(this.zzc, str);
        this.zzc = str;
    }

    public final void zzI(@Nullable String str) {
        this.zza.zzaz().zzg();
        this.zzC |= !zzg.zza(this.zzl, str);
        this.zzl = str;
    }

    public final void zzJ(@Nullable String str) {
        this.zza.zzaz().zzg();
        this.zzC |= !zzg.zza(this.zzj, str);
        this.zzj = str;
    }

    public final void zzK(long j11) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzk != j11;
        this.zzk = j11;
    }

    public final void zzL(long j11) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzD != j11;
        this.zzD = j11;
    }

    public final void zzM(long j11) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzy != j11;
        this.zzy = j11;
    }

    public final void zzN(long j11) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzz != j11;
        this.zzz = j11;
    }

    public final void zzO(long j11) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzx != j11;
        this.zzx = j11;
    }

    public final void zzP(long j11) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzw != j11;
        this.zzw = j11;
    }

    public final void zzQ(long j11) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzA != j11;
        this.zzA = j11;
    }

    public final void zzR(long j11) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzv != j11;
        this.zzv = j11;
    }

    public final void zzS(long j11) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzn != j11;
        this.zzn = j11;
    }

    public final void zzT(long j11) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzs != j11;
        this.zzs = j11;
    }

    public final void zzU(long j11) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzE != j11;
        this.zzE = j11;
    }

    public final void zzV(@Nullable String str) {
        this.zza.zzaz().zzg();
        this.zzC |= !zzg.zza(this.zzf, str);
        this.zzf = str;
    }

    public final void zzW(@Nullable String str) {
        this.zza.zzaz().zzg();
        if (true == TextUtils.isEmpty(str)) {
            str = null;
        }
        this.zzC |= true ^ zzg.zza(this.zzd, str);
        this.zzd = str;
    }

    public final void zzX(long j11) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzm != j11;
        this.zzm = j11;
    }

    public final void zzY(@Nullable String str) {
        this.zza.zzaz().zzg();
        this.zzC |= !zzg.zza(this.zzB, str);
        this.zzB = str;
    }

    public final void zzZ(long j11) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzi != j11;
        this.zzi = j11;
    }

    public final long zza() {
        this.zza.zzaz().zzg();
        return 0L;
    }

    public final void zzaa(long j11) {
        Preconditions.checkArgument(j11 >= 0);
        this.zza.zzaz().zzg();
        this.zzC |= this.zzg != j11;
        this.zzg = j11;
    }

    public final void zzab(long j11) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzh != j11;
        this.zzh = j11;
    }

    public final void zzac(boolean z11) {
        this.zza.zzaz().zzg();
        this.zzC |= this.zzo != z11;
        this.zzo = z11;
    }

    public final void zzad(@Nullable Boolean bool) {
        this.zza.zzaz().zzg();
        this.zzC |= !zzg.zza(this.zzr, bool);
        this.zzr = bool;
    }

    public final void zzae(@Nullable String str) {
        this.zza.zzaz().zzg();
        this.zzC |= !zzg.zza(this.zze, str);
        this.zze = str;
    }

    public final void zzaf(@Nullable List list) {
        this.zza.zzaz().zzg();
        if (zzg.zza(this.zzt, list)) {
            return;
        }
        this.zzC = true;
        this.zzt = list != null ? new ArrayList(list) : null;
    }

    public final void zzag(@Nullable String str) {
        this.zza.zzaz().zzg();
        this.zzC |= !zzg.zza(this.zzu, str);
        this.zzu = str;
    }

    public final boolean zzah() {
        this.zza.zzaz().zzg();
        return this.zzp;
    }

    public final boolean zzai() {
        this.zza.zzaz().zzg();
        return this.zzo;
    }

    public final boolean zzaj() {
        this.zza.zzaz().zzg();
        return this.zzC;
    }

    public final long zzb() {
        this.zza.zzaz().zzg();
        return this.zzk;
    }

    public final long zzc() {
        this.zza.zzaz().zzg();
        return this.zzD;
    }

    public final long zzd() {
        this.zza.zzaz().zzg();
        return this.zzy;
    }

    public final long zze() {
        this.zza.zzaz().zzg();
        return this.zzz;
    }

    public final long zzf() {
        this.zza.zzaz().zzg();
        return this.zzx;
    }

    public final long zzg() {
        this.zza.zzaz().zzg();
        return this.zzw;
    }

    public final long zzh() {
        this.zza.zzaz().zzg();
        return this.zzA;
    }

    public final long zzi() {
        this.zza.zzaz().zzg();
        return this.zzv;
    }

    public final long zzj() {
        this.zza.zzaz().zzg();
        return this.zzn;
    }

    public final long zzk() {
        this.zza.zzaz().zzg();
        return this.zzs;
    }

    public final long zzl() {
        this.zza.zzaz().zzg();
        return this.zzE;
    }

    public final long zzm() {
        this.zza.zzaz().zzg();
        return this.zzm;
    }

    public final long zzn() {
        this.zza.zzaz().zzg();
        return this.zzi;
    }

    public final long zzo() {
        this.zza.zzaz().zzg();
        return this.zzg;
    }

    public final long zzp() {
        this.zza.zzaz().zzg();
        return this.zzh;
    }

    @Nullable
    public final Boolean zzq() {
        this.zza.zzaz().zzg();
        return this.zzr;
    }

    @Nullable
    public final String zzr() {
        this.zza.zzaz().zzg();
        return this.zzq;
    }

    @Nullable
    public final String zzs() {
        this.zza.zzaz().zzg();
        String str = this.zzB;
        zzY(null);
        return str;
    }

    public final String zzt() {
        this.zza.zzaz().zzg();
        return this.zzb;
    }

    @Nullable
    public final String zzu() {
        this.zza.zzaz().zzg();
        return this.zzc;
    }

    @Nullable
    public final String zzv() {
        this.zza.zzaz().zzg();
        return this.zzl;
    }

    @Nullable
    public final String zzw() {
        this.zza.zzaz().zzg();
        return this.zzj;
    }

    @Nullable
    public final String zzx() {
        this.zza.zzaz().zzg();
        return this.zzf;
    }

    @Nullable
    public final String zzy() {
        this.zza.zzaz().zzg();
        return this.zzd;
    }

    @Nullable
    public final String zzz() {
        this.zza.zzaz().zzg();
        return this.zzB;
    }
}
