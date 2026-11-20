package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaen implements zzacu {
    private int zzc;
    private zzaeo zze;
    private long zzh;

    @Nullable
    private zzaeq zzi;
    private int zzm;
    private boolean zzn;
    private final zzfp zza = new zzfp(12);
    private final zzaem zzb = new zzaem(null);
    private zzacx zzd = new zzacs();
    private zzaeq[] zzg = new zzaeq[0];
    private long zzk = -1;
    private long zzl = -1;
    private int zzj = -1;
    private long zzf = C.TIME_UNSET;

    @Nullable
    private final zzaeq zzf(int i11) {
        for (zzaeq zzaeqVar : this.zzg) {
            if (zzaeqVar.zzg(i11)) {
                return zzaeqVar;
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:134:0x030f  */
    @Override // com.google.android.gms.internal.ads.zzacu
    public final int zzb(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        boolean z11;
        int i11;
        int i12;
        int i13;
        zzaeq zzaeqVar;
        long j11;
        long j12 = this.zzh;
        int i14 = 0;
        if (j12 != -1) {
            long jZzf = zzacvVar.zzf();
            if (j12 < jZzf || j12 > PlaybackStateCompat.ACTION_SET_REPEAT_MODE + jZzf) {
                zzadrVar.zza = j12;
                z11 = true;
            } else {
                ((zzack) zzacvVar).zzo((int) (j12 - jZzf), false);
                z11 = false;
            }
        } else {
            z11 = false;
        }
        this.zzh = -1L;
        if (z11) {
            return 1;
        }
        int i15 = this.zzc;
        zzaeq zzaeqVar2 = null;
        if (i15 == 0) {
            if (!zze(zzacvVar)) {
                throw zzcc.zza("AVI Header List not found", null);
            }
            ((zzack) zzacvVar).zzo(12, false);
            this.zzc = 1;
            return 0;
        }
        if (i15 == 1) {
            ((zzack) zzacvVar).zzn(this.zza.zzM(), 0, 12, false);
            this.zza.zzK(0);
            zzaem zzaemVar = this.zzb;
            zzfp zzfpVar = this.zza;
            zzaemVar.zza(zzfpVar);
            int i16 = zzaemVar.zza;
            if (i16 != 1414744396) {
                throw zzcc.zza("LIST expected, found: " + i16, null);
            }
            zzaemVar.zzc = zzfpVar.zzi();
            zzaem zzaemVar2 = this.zzb;
            int i17 = zzaemVar2.zzc;
            if (i17 == 1819436136) {
                this.zzj = zzaemVar2.zzb;
                this.zzc = 2;
                return 0;
            }
            throw zzcc.zza("hdrl expected, found: " + i17, null);
        }
        if (i15 == 2) {
            int i18 = this.zzj - 4;
            zzfp zzfpVar2 = new zzfp(i18);
            ((zzack) zzacvVar).zzn(zzfpVar2.zzM(), 0, i18, false);
            zzaer zzaerVarZzc = zzaer.zzc(1819436136, zzfpVar2);
            if (zzaerVarZzc.zza() != 1819436136) {
                throw zzcc.zza("Unexpected header list type " + zzaerVarZzc.zza(), null);
            }
            zzaeo zzaeoVar = (zzaeo) zzaerVarZzc.zzb(zzaeo.class);
            if (zzaeoVar == null) {
                throw zzcc.zza("AviHeader not found", null);
            }
            this.zze = zzaeoVar;
            this.zzf = ((long) zzaeoVar.zzc) * ((long) zzaeoVar.zza);
            ArrayList arrayList = new ArrayList();
            zzgaa zzgaaVar = zzaerVarZzc.zza;
            int size = zzgaaVar.size();
            int i19 = 0;
            int i21 = 0;
            while (i19 < size) {
                zzaej zzaejVar = (zzaej) zzgaaVar.get(i19);
                if (zzaejVar.zza() == 1819440243) {
                    zzaer zzaerVar = (zzaer) zzaejVar;
                    int i22 = i21 + 1;
                    zzaep zzaepVar = (zzaep) zzaerVar.zzb(zzaep.class);
                    zzaes zzaesVar = (zzaes) zzaerVar.zzb(zzaes.class);
                    if (zzaepVar == null) {
                        zzff.zzf("AviExtractor", "Missing Stream Header");
                    } else {
                        if (zzaesVar == null) {
                            zzff.zzf("AviExtractor", "Missing Stream Format");
                        } else {
                            i11 = i19;
                            i12 = i22;
                            long jZzs = zzfy.zzs(zzaepVar.zzd, ((long) zzaepVar.zzb) * 1000000, zzaepVar.zzc, RoundingMode.FLOOR);
                            zzam zzamVar = zzaesVar.zza;
                            zzak zzakVarZzb = zzamVar.zzb();
                            zzakVarZzb.zzJ(i21);
                            int i23 = zzaepVar.zze;
                            if (i23 != 0) {
                                zzakVarZzb.zzO(i23);
                            }
                            zzaet zzaetVar = (zzaet) zzaerVar.zzb(zzaet.class);
                            if (zzaetVar != null) {
                                zzakVarZzb.zzM(zzaetVar.zza);
                            }
                            int iZzb = zzcb.zzb(zzamVar.zzm);
                            if (iZzb == 1) {
                                i13 = iZzb;
                            } else if (iZzb == 2) {
                                i13 = 2;
                            } else {
                                zzaeqVar = null;
                            }
                            zzaea zzaeaVarZzw = this.zzd.zzw(i21, i13);
                            zzaeaVarZzw.zzl(zzakVarZzb.zzac());
                            zzaeqVar = new zzaeq(i21, i13, jZzs, zzaepVar.zzd, zzaeaVarZzw);
                            this.zzf = jZzs;
                        }
                        if (zzaeqVar != null) {
                            arrayList.add(zzaeqVar);
                        }
                        i21 = i12;
                    }
                    i11 = i19;
                    zzaeqVar = zzaeqVar2;
                    i12 = i22;
                    if (zzaeqVar != null) {
                        arrayList.add(zzaeqVar);
                    }
                    i21 = i12;
                } else {
                    i11 = i19;
                }
                i19 = i11 + 1;
                i14 = 0;
                zzaeqVar2 = null;
            }
            this.zzg = (zzaeq[]) arrayList.toArray(new zzaeq[i14]);
            this.zzd.zzD();
            this.zzc = 3;
            return i14;
        }
        if (i15 == 3) {
            long j13 = this.zzk;
            if (j13 != -1 && zzacvVar.zzf() != j13) {
                this.zzh = j13;
                return 0;
            }
            ((zzack) zzacvVar).zzm(this.zza.zzM(), 0, 12, false);
            zzacvVar.zzj();
            this.zza.zzK(0);
            this.zzb.zza(this.zza);
            zzfp zzfpVar3 = this.zza;
            zzaem zzaemVar3 = this.zzb;
            int iZzi = zzfpVar3.zzi();
            int i24 = zzaemVar3.zza;
            if (i24 == 1179011410) {
                ((zzack) zzacvVar).zzo(12, false);
                return 0;
            }
            if (i24 != 1414744396 || iZzi != 1769369453) {
                this.zzh = zzacvVar.zzf() + ((long) zzaemVar3.zzb) + 8;
                return 0;
            }
            long jZzf2 = zzacvVar.zzf();
            this.zzk = jZzf2;
            long j14 = jZzf2 + ((long) zzaemVar3.zzb) + 8;
            this.zzl = j14;
            if (!this.zzn) {
                zzaeo zzaeoVar2 = this.zze;
                zzaeoVar2.getClass();
                if ((zzaeoVar2.zzb & 16) == 16) {
                    this.zzc = 4;
                    this.zzh = j14;
                    return 0;
                }
                this.zzd.zzO(new zzadt(this.zzf, 0L));
                this.zzn = true;
            }
            this.zzh = zzacvVar.zzf() + 12;
            this.zzc = 6;
            return 0;
        }
        if (i15 == 4) {
            ((zzack) zzacvVar).zzn(this.zza.zzM(), 0, 8, false);
            this.zza.zzK(0);
            zzfp zzfpVar4 = this.zza;
            int iZzi2 = zzfpVar4.zzi();
            int iZzi3 = zzfpVar4.zzi();
            if (iZzi2 == 829973609) {
                this.zzc = 5;
                this.zzm = iZzi3;
            } else {
                this.zzh = zzacvVar.zzf() + ((long) iZzi3);
            }
            return 0;
        }
        if (i15 == 5) {
            zzfp zzfpVar5 = new zzfp(this.zzm);
            ((zzack) zzacvVar).zzn(zzfpVar5.zzM(), 0, this.zzm, false);
            if (zzfpVar5.zzb() < 16) {
                j11 = 0;
            } else {
                int iZzd = zzfpVar5.zzd();
                zzfpVar5.zzL(8);
                long jZzi = zzfpVar5.zzi();
                long j15 = this.zzk;
                j11 = jZzi > j15 ? 0L : j15 + 8;
                zzfpVar5.zzK(iZzd);
            }
            while (zzfpVar5.zzb() >= 16) {
                int iZzi4 = zzfpVar5.zzi();
                int iZzi5 = zzfpVar5.zzi();
                long jZzi2 = ((long) zzfpVar5.zzi()) + j11;
                zzfpVar5.zzi();
                zzaeq zzaeqVarZzf = zzf(iZzi4);
                if (zzaeqVarZzf != null) {
                    if ((iZzi5 & 16) == 16) {
                        zzaeqVarZzf.zzb(jZzi2);
                    }
                    zzaeqVarZzf.zzd();
                }
            }
            for (zzaeq zzaeqVar3 : this.zzg) {
                zzaeqVar3.zzc();
            }
            this.zzn = true;
            this.zzd.zzO(new zzaek(this, this.zzf));
            this.zzc = 6;
            this.zzh = this.zzk;
            return 0;
        }
        if (zzacvVar.zzf() >= this.zzl) {
            return -1;
        }
        zzaeq zzaeqVar4 = this.zzi;
        if (zzaeqVar4 != null) {
            if (!zzaeqVar4.zzh(zzacvVar)) {
                return 0;
            }
            this.zzi = null;
            return 0;
        }
        if ((zzacvVar.zzf() & 1) == 1) {
            ((zzack) zzacvVar).zzo(1, false);
        }
        zzack zzackVar = (zzack) zzacvVar;
        zzackVar.zzm(this.zza.zzM(), 0, 12, false);
        this.zza.zzK(0);
        int iZzi6 = this.zza.zzi();
        if (iZzi6 == 1414744396) {
            this.zza.zzK(8);
            zzackVar.zzo(this.zza.zzi() != 1769369453 ? 8 : 12, false);
            zzacvVar.zzj();
            return 0;
        }
        int iZzi7 = this.zza.zzi();
        if (iZzi6 == 1263424842) {
            this.zzh = zzacvVar.zzf() + ((long) iZzi7) + 8;
            return 0;
        }
        zzackVar.zzo(8, false);
        zzacvVar.zzj();
        zzaeq zzaeqVarZzf2 = zzf(iZzi6);
        if (zzaeqVarZzf2 == null) {
            this.zzh = zzacvVar.zzf() + ((long) iZzi7);
            return 0;
        }
        zzaeqVarZzf2.zze(iZzi7);
        this.zzi = zzaeqVarZzf2;
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzc(zzacx zzacxVar) {
        this.zzc = 0;
        this.zzd = zzacxVar;
        this.zzh = -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzd(long j11, long j12) {
        this.zzh = -1L;
        this.zzi = null;
        for (zzaeq zzaeqVar : this.zzg) {
            zzaeqVar.zzf(j11);
        }
        if (j11 == 0) {
            this.zzc = this.zzg.length != 0 ? 3 : 0;
        } else {
            this.zzc = 6;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final boolean zze(zzacv zzacvVar) throws IOException {
        ((zzack) zzacvVar).zzm(this.zza.zzM(), 0, 12, false);
        this.zza.zzK(0);
        if (this.zza.zzi() != 1179011410) {
            return false;
        }
        this.zza.zzL(4);
        return this.zza.zzi() == 541677121;
    }
}
