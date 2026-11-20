package com.google.android.gms.internal.ads;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzll {
    private final zzcu zza = new zzcu();
    private final zzcw zzb = new zzcw();
    private final zzmp zzc;
    private final zzew zzd;
    private long zze;
    private int zzf;
    private boolean zzg;

    @Nullable
    private zzli zzh;

    @Nullable
    private zzli zzi;

    @Nullable
    private zzli zzj;
    private int zzk;

    @Nullable
    private Object zzl;
    private long zzm;
    private final zzkr zzn;

    public zzll(zzmp zzmpVar, zzew zzewVar, zzkr zzkrVar) {
        this.zzc = zzmpVar;
        this.zzd = zzewVar;
        this.zzn = zzkrVar;
    }

    private final boolean zzA(zzcx zzcxVar, zzur zzurVar) {
        if (zzC(zzurVar)) {
            return zzcxVar.zze(zzcxVar.zzn(zzurVar.zza, this.zza).zzd, this.zzb, 0L).zzq == zzcxVar.zza(zzurVar.zza);
        }
        return false;
    }

    private final boolean zzB(zzcx zzcxVar) {
        zzli zzliVarZzg = this.zzh;
        if (zzliVarZzg == null) {
            return true;
        }
        int iZza = zzcxVar.zza(zzliVarZzg.zzb);
        while (true) {
            iZza = zzcxVar.zzi(iZza, this.zza, this.zzb, this.zzf, this.zzg);
            while (true) {
                zzliVarZzg.getClass();
                if (zzliVarZzg.zzg() == null || zzliVarZzg.zzf.zzg) {
                    break;
                }
                zzliVarZzg = zzliVarZzg.zzg();
            }
            zzli zzliVarZzg2 = zzliVarZzg.zzg();
            if (iZza == -1 || zzliVarZzg2 == null || zzcxVar.zza(zzliVarZzg2.zzb) != iZza) {
                break;
            }
            zzliVarZzg = zzliVarZzg2;
        }
        boolean zZzn = zzn(zzliVarZzg);
        zzliVarZzg.zzf = zzh(zzcxVar, zzliVarZzg.zzf);
        return !zZzn;
    }

    private static final boolean zzC(zzur zzurVar) {
        return !zzurVar.zzb() && zzurVar.zze == -1;
    }

    private final long zzs(zzcx zzcxVar, Object obj, int i11) {
        zzcxVar.zzn(obj, this.zza);
        this.zza.zzi(i11);
        this.zza.zzk(i11);
        return 0L;
    }

    @Nullable
    private final zzlj zzt(zzcx zzcxVar, zzli zzliVar, long j11) {
        long j12;
        zzlj zzljVar = zzliVar.zzf;
        long jZze = (zzliVar.zze() + zzljVar.zze) - j11;
        if (zzljVar.zzg) {
            long j13 = 0;
            int iZzi = zzcxVar.zzi(zzcxVar.zza(zzljVar.zza.zza), this.zza, this.zzb, this.zzf, this.zzg);
            if (iZzi != -1) {
                int i11 = zzcxVar.zzd(iZzi, this.zza, true).zzd;
                Object obj = this.zza.zzc;
                obj.getClass();
                long j14 = zzljVar.zza.zzd;
                if (zzcxVar.zze(i11, this.zzb, 0L).zzp == iZzi) {
                    Pair pairZzm = zzcxVar.zzm(this.zzb, this.zza, i11, C.TIME_UNSET, Math.max(0L, jZze));
                    if (pairZzm != null) {
                        obj = pairZzm.first;
                        long jLongValue = ((Long) pairZzm.second).longValue();
                        zzli zzliVarZzg = zzliVar.zzg();
                        if (zzliVarZzg == null || !zzliVarZzg.zzb.equals(obj)) {
                            j14 = this.zze;
                            this.zze = 1 + j14;
                        } else {
                            j14 = zzliVarZzg.zzf.zza.zzd;
                        }
                        j12 = jLongValue;
                        j13 = C.TIME_UNSET;
                    }
                } else {
                    j12 = 0;
                }
                zzur zzurVarZzx = zzx(zzcxVar, obj, j12, j14, this.zzb, this.zza);
                if (j13 != C.TIME_UNSET && zzljVar.zzc != C.TIME_UNSET) {
                    zzcxVar.zzn(zzljVar.zza.zza, this.zza).zzb();
                    this.zza.zzg();
                }
                return zzu(zzcxVar, zzurVarZzx, j13, j12);
            }
        } else {
            zzur zzurVar = zzljVar.zza;
            zzcxVar.zzn(zzurVar.zza, this.zza);
            if (!zzurVar.zzb()) {
                int i12 = zzurVar.zze;
                if (i12 != -1) {
                    this.zza.zzm(i12);
                }
                zzcu zzcuVar = this.zza;
                int i13 = zzurVar.zze;
                int iZze = zzcuVar.zze(i13);
                zzcuVar.zzn(i13);
                if (iZze != this.zza.zza(zzurVar.zze)) {
                    return zzv(zzcxVar, zzurVar.zza, zzurVar.zze, iZze, zzljVar.zze, zzurVar.zzd);
                }
                zzs(zzcxVar, zzurVar.zza, zzurVar.zze);
                return zzw(zzcxVar, zzurVar.zza, 0L, zzljVar.zze, zzurVar.zzd);
            }
            int i14 = zzurVar.zzb;
            if (this.zza.zza(i14) != -1) {
                int iZzf = this.zza.zzf(i14, zzurVar.zzc);
                if (iZzf < 0) {
                    return zzv(zzcxVar, zzurVar.zza, i14, iZzf, zzljVar.zzc, zzurVar.zzd);
                }
                long jLongValue2 = zzljVar.zzc;
                if (jLongValue2 == C.TIME_UNSET) {
                    zzcw zzcwVar = this.zzb;
                    zzcu zzcuVar2 = this.zza;
                    Pair pairZzm2 = zzcxVar.zzm(zzcwVar, zzcuVar2, zzcuVar2.zzd, C.TIME_UNSET, Math.max(0L, jZze));
                    if (pairZzm2 != null) {
                        jLongValue2 = ((Long) pairZzm2.second).longValue();
                    }
                }
                zzs(zzcxVar, zzurVar.zza, zzurVar.zzb);
                return zzw(zzcxVar, zzurVar.zza, Math.max(0L, jLongValue2), zzljVar.zzc, zzurVar.zzd);
            }
        }
        return null;
    }

    @Nullable
    private final zzlj zzu(zzcx zzcxVar, zzur zzurVar, long j11, long j12) {
        zzcxVar.zzn(zzurVar.zza, this.zza);
        return zzurVar.zzb() ? zzv(zzcxVar, zzurVar.zza, zzurVar.zzb, zzurVar.zzc, j11, zzurVar.zzd) : zzw(zzcxVar, zzurVar.zza, j12, j11, zzurVar.zzd);
    }

    private final zzlj zzv(zzcx zzcxVar, Object obj, int i11, int i12, long j11, long j12) {
        zzur zzurVar = new zzur(obj, i11, i12, j12);
        Object obj2 = zzurVar.zza;
        long jZzh = zzcxVar.zzn(obj2, this.zza).zzh(zzurVar.zzb, zzurVar.zzc);
        if (i12 == this.zza.zze(i11)) {
            this.zza.zzj();
        }
        this.zza.zzn(zzurVar.zzb);
        long jMax = 0;
        if (jZzh != C.TIME_UNSET && jZzh <= 0) {
            jMax = Math.max(0L, (-1) + jZzh);
        }
        return new zzlj(zzurVar, jMax, j11, C.TIME_UNSET, jZzh, false, false, false, false);
    }

    private final zzlj zzw(zzcx zzcxVar, Object obj, long j11, long j12, long j13) {
        long j14;
        long j15;
        long j16;
        long jMax = j11;
        zzcxVar.zzn(obj, this.zza);
        int iZzc = this.zza.zzc(jMax);
        if (iZzc != -1) {
            this.zza.zzm(iZzc);
        }
        if (iZzc == -1) {
            this.zza.zzb();
        } else {
            this.zza.zzn(iZzc);
        }
        zzur zzurVar = new zzur(obj, j13, iZzc);
        boolean zZzC = zzC(zzurVar);
        boolean zZzA = zzA(zzcxVar, zzurVar);
        boolean zZzz = zzz(zzcxVar, zzurVar, zZzC);
        if (iZzc != -1) {
            this.zza.zzn(iZzc);
        }
        if (iZzc != -1) {
            this.zza.zzi(iZzc);
            j14 = 0;
        } else {
            j14 = -9223372036854775807L;
        }
        if (j14 != C.TIME_UNSET) {
            j15 = 0;
            j16 = 0;
        } else {
            j15 = j14;
            j16 = this.zza.zze;
        }
        if (j16 != C.TIME_UNSET && jMax >= j16) {
            jMax = Math.max(0L, j16 - 1);
        }
        return new zzlj(zzurVar, jMax, j12, j15, j16, false, zZzC, zZzA, zZzz);
    }

    private static zzur zzx(zzcx zzcxVar, Object obj, long j11, long j12, zzcw zzcwVar, zzcu zzcuVar) {
        zzcxVar.zzn(obj, zzcuVar);
        zzcxVar.zze(zzcuVar.zzd, zzcwVar, 0L);
        zzcxVar.zza(obj);
        zzcuVar.zzb();
        zzcxVar.zzn(obj, zzcuVar);
        int iZzd = zzcuVar.zzd(j11);
        return iZzd == -1 ? new zzur(obj, j12, zzcuVar.zzc(j11)) : new zzur(obj, iZzd, zzcuVar.zze(iZzd), j12);
    }

    private final void zzy() {
        final zzfzx zzfzxVar = new zzfzx();
        for (zzli zzliVarZzg = this.zzh; zzliVarZzg != null; zzliVarZzg = zzliVarZzg.zzg()) {
            zzfzxVar.zzf(zzliVarZzg.zzf.zza);
        }
        zzli zzliVar = this.zzi;
        final zzur zzurVar = zzliVar == null ? null : zzliVar.zzf.zza;
        this.zzd.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzlk
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzk(zzfzxVar, zzurVar);
            }
        });
    }

    private final boolean zzz(zzcx zzcxVar, zzur zzurVar, boolean z11) {
        int iZza = zzcxVar.zza(zzurVar.zza);
        return !zzcxVar.zze(zzcxVar.zzd(iZza, this.zza, false).zzd, this.zzb, 0L).zzj && zzcxVar.zzi(iZza, this.zza, this.zzb, this.zzf, this.zzg) == -1 && z11;
    }

    @Nullable
    public final zzli zza() {
        zzli zzliVar = this.zzh;
        if (zzliVar == null) {
            return null;
        }
        if (zzliVar == this.zzi) {
            this.zzi = zzliVar.zzg();
        }
        zzliVar.zzn();
        int i11 = this.zzk - 1;
        this.zzk = i11;
        if (i11 == 0) {
            this.zzj = null;
            zzli zzliVar2 = this.zzh;
            this.zzl = zzliVar2.zzb;
            this.zzm = zzliVar2.zzf.zza.zzd;
        }
        this.zzh = this.zzh.zzg();
        zzy();
        return this.zzh;
    }

    public final zzli zzb() {
        zzli zzliVar = this.zzi;
        zzek.zzb(zzliVar);
        this.zzi = zzliVar.zzg();
        zzy();
        zzli zzliVar2 = this.zzi;
        zzek.zzb(zzliVar2);
        return zzliVar2;
    }

    public final zzli zzc(zzlj zzljVar) {
        zzli zzliVar = this.zzj;
        zzli zzliVarZzd = zzkz.zzd(this.zzn.zza, zzljVar, zzliVar == null ? 1000000000000L : (zzliVar.zze() + zzliVar.zzf.zze) - zzljVar.zzb);
        zzli zzliVar2 = this.zzj;
        if (zzliVar2 != null) {
            zzliVar2.zzo(zzliVarZzd);
        } else {
            this.zzh = zzliVarZzd;
            this.zzi = zzliVarZzd;
        }
        this.zzl = null;
        this.zzj = zzliVarZzd;
        this.zzk++;
        zzy();
        return zzliVarZzd;
    }

    @Nullable
    public final zzli zzd() {
        return this.zzj;
    }

    @Nullable
    public final zzli zze() {
        return this.zzh;
    }

    @Nullable
    public final zzli zzf() {
        return this.zzi;
    }

    @Nullable
    public final zzlj zzg(long j11, zzly zzlyVar) {
        zzli zzliVar = this.zzj;
        return zzliVar == null ? zzu(zzlyVar.zza, zzlyVar.zzb, zzlyVar.zzc, zzlyVar.zzr) : zzt(zzlyVar.zza, zzliVar, j11);
    }

    /* JADX WARN: Code duplicated, block: B:18:0x005c  */
    /* JADX WARN: Code duplicated, block: B:19:0x0064  */
    /* JADX WARN: Code duplicated, block: B:21:0x0068  */
    public final zzlj zzh(zzcx zzcxVar, zzlj zzljVar) {
        long j11;
        long jZzh;
        long j12;
        long j13;
        int i11;
        int i12;
        zzur zzurVar = zzljVar.zza;
        boolean zZzC = zzC(zzurVar);
        boolean zZzA = zzA(zzcxVar, zzurVar);
        boolean zZzz = zzz(zzcxVar, zzurVar, zZzC);
        zzcxVar.zzn(zzljVar.zza.zza, this.zza);
        if (zzurVar.zzb() || (i12 = zzurVar.zze) == -1) {
            j11 = -9223372036854775807L;
        } else {
            this.zza.zzi(i12);
            j11 = 0;
        }
        if (!zzurVar.zzb()) {
            if (j11 != C.TIME_UNSET) {
                j12 = 0;
                j13 = 0;
            } else {
                jZzh = this.zza.zze;
            }
            if (zzurVar.zzb()) {
                this.zza.zzn(zzurVar.zzb);
            } else {
                i11 = zzurVar.zze;
                if (i11 != -1) {
                    this.zza.zzn(i11);
                }
            }
            return new zzlj(zzurVar, zzljVar.zzb, zzljVar.zzc, j12, j13, false, zZzC, zZzA, zZzz);
        }
        jZzh = this.zza.zzh(zzurVar.zzb, zzurVar.zzc);
        j12 = j11;
        j13 = jZzh;
        if (zzurVar.zzb()) {
            this.zza.zzn(zzurVar.zzb);
        } else {
            i11 = zzurVar.zze;
            if (i11 != -1) {
                this.zza.zzn(i11);
            }
        }
        return new zzlj(zzurVar, zzljVar.zzb, zzljVar.zzc, j12, j13, false, zZzC, zZzA, zZzz);
    }

    public final zzur zzi(zzcx zzcxVar, Object obj, long j11) {
        long j12;
        int iZza;
        int i11 = zzcxVar.zzn(obj, this.zza).zzd;
        Object obj2 = this.zzl;
        if (obj2 == null || (iZza = zzcxVar.zza(obj2)) == -1 || zzcxVar.zzd(iZza, this.zza, false).zzd != i11) {
            zzli zzliVarZzg = this.zzh;
            while (true) {
                if (zzliVarZzg == null) {
                    zzli zzliVarZzg2 = this.zzh;
                    while (true) {
                        if (zzliVarZzg2 != null) {
                            int iZza2 = zzcxVar.zza(zzliVarZzg2.zzb);
                            if (iZza2 != -1 && zzcxVar.zzd(iZza2, this.zza, false).zzd == i11) {
                                j12 = zzliVarZzg2.zzf.zza.zzd;
                                break;
                            }
                            zzliVarZzg2 = zzliVarZzg2.zzg();
                        } else {
                            j12 = this.zze;
                            this.zze = 1 + j12;
                            if (this.zzh != null) {
                                break;
                            }
                            this.zzl = obj;
                            this.zzm = j12;
                            break;
                        }
                    }
                } else {
                    if (zzliVarZzg.zzb.equals(obj)) {
                        j12 = zzliVarZzg.zzf.zza.zzd;
                        break;
                    }
                    zzliVarZzg = zzliVarZzg.zzg();
                }
            }
        } else {
            j12 = this.zzm;
        }
        long j13 = j12;
        zzcxVar.zzn(obj, this.zza);
        zzcxVar.zze(this.zza.zzd, this.zzb, 0L);
        int iZza3 = zzcxVar.zza(obj);
        Object obj3 = obj;
        while (true) {
            zzcw zzcwVar = this.zzb;
            if (iZza3 < zzcwVar.zzp) {
                return zzx(zzcxVar, obj3, j11, j13, zzcwVar, this.zza);
            }
            zzcxVar.zzd(iZza3, this.zza, true);
            this.zza.zzb();
            zzcu zzcuVar = this.zza;
            if (zzcuVar.zzd(zzcuVar.zze) != -1) {
                obj3 = this.zza.zzc;
                obj3.getClass();
            }
            iZza3--;
        }
    }

    public final void zzj() {
        if (this.zzk == 0) {
            return;
        }
        zzli zzliVarZzg = this.zzh;
        zzek.zzb(zzliVarZzg);
        this.zzl = zzliVarZzg.zzb;
        this.zzm = zzliVarZzg.zzf.zza.zzd;
        while (zzliVarZzg != null) {
            zzliVarZzg.zzn();
            zzliVarZzg = zzliVarZzg.zzg();
        }
        this.zzh = null;
        this.zzj = null;
        this.zzi = null;
        this.zzk = 0;
        zzy();
    }

    public final /* synthetic */ void zzk(zzfzx zzfzxVar, zzur zzurVar) {
        this.zzc.zzS(zzfzxVar.zzi(), zzurVar);
    }

    public final void zzl(long j11) {
        zzli zzliVar = this.zzj;
        if (zzliVar != null) {
            zzliVar.zzm(j11);
        }
    }

    public final boolean zzm(zzup zzupVar) {
        zzli zzliVar = this.zzj;
        return zzliVar != null && zzliVar.zza == zzupVar;
    }

    public final boolean zzn(zzli zzliVar) {
        zzek.zzb(zzliVar);
        boolean z11 = false;
        if (zzliVar.equals(this.zzj)) {
            return false;
        }
        this.zzj = zzliVar;
        while (zzliVar.zzg() != null) {
            zzliVar = zzliVar.zzg();
            zzliVar.getClass();
            if (zzliVar == this.zzi) {
                this.zzi = this.zzh;
                z11 = true;
            }
            zzliVar.zzn();
            this.zzk--;
        }
        zzli zzliVar2 = this.zzj;
        zzliVar2.getClass();
        zzliVar2.zzo(null);
        zzy();
        return z11;
    }

    public final boolean zzo() {
        zzli zzliVar = this.zzj;
        if (zzliVar != null) {
            return !zzliVar.zzf.zzi && zzliVar.zzr() && this.zzj.zzf.zze != C.TIME_UNSET && this.zzk < 100;
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:35:0x007b  */
    public final boolean zzp(zzcx zzcxVar, long j11, long j12) {
        zzlj zzljVarZzh;
        boolean z11;
        zzli zzliVar = null;
        for (zzli zzliVarZzg = this.zzh; zzliVarZzg != null; zzliVarZzg = zzliVarZzg.zzg()) {
            zzlj zzljVar = zzliVarZzg.zzf;
            if (zzliVar == null) {
                zzljVarZzh = zzh(zzcxVar, zzljVar);
            } else {
                zzlj zzljVarZzt = zzt(zzcxVar, zzliVar, j11);
                if (zzljVarZzt == null) {
                    return !zzn(zzliVar);
                }
                if (zzljVar.zzb != zzljVarZzt.zzb || !zzljVar.zza.equals(zzljVarZzt.zza)) {
                    return !zzn(zzliVar);
                }
                zzljVarZzh = zzljVarZzt;
            }
            zzliVarZzg.zzf = zzljVarZzh.zza(zzljVar.zzc);
            long j13 = zzljVar.zze;
            long j14 = zzljVarZzh.zze;
            if (j13 != C.TIME_UNSET && j13 != j14) {
                zzliVarZzg.zzq();
                long j15 = zzljVarZzh.zze;
                long jZze = j15 == C.TIME_UNSET ? Long.MAX_VALUE : j15 + zzliVarZzg.zze();
                if (zzliVarZzg == this.zzi) {
                    boolean z12 = zzliVarZzg.zzf.zzf;
                    if (j12 == Long.MIN_VALUE || j12 >= jZze) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                } else {
                    z11 = false;
                }
                return (zzn(zzliVarZzg) || z11) ? false : true;
            }
            zzliVar = zzliVarZzg;
        }
        return true;
    }

    public final boolean zzq(zzcx zzcxVar, int i11) {
        this.zzf = i11;
        return zzB(zzcxVar);
    }

    public final boolean zzr(zzcx zzcxVar, boolean z11) {
        this.zzg = z11;
        return zzB(zzcxVar);
    }
}
