package com.google.android.gms.internal.ads;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.EOFException;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaig implements zzacu {
    public static final zzadb zza = new zzadb() { // from class: com.google.android.gms.internal.ads.zzaie
        @Override // com.google.android.gms.internal.ads.zzadb
        public final /* synthetic */ zzacu[] zza(Uri uri, Map map) {
            int i11 = zzada.zza;
            return new zzacu[]{new zzaig(0)};
        }
    };
    private static final zzago zzb = new zzago() { // from class: com.google.android.gms.internal.ads.zzaif
    };
    private final zzfp zzc;
    private final zzado zzd;
    private final zzadk zze;
    private final zzadm zzf;
    private final zzaea zzg;
    private zzacx zzh;
    private zzaea zzi;
    private zzaea zzj;
    private int zzk;

    @Nullable
    private zzby zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private int zzp;
    private zzaii zzq;
    private boolean zzr;

    public zzaig() {
        this(0);
    }

    public zzaig(int i11) {
        this.zzc = new zzfp(10);
        this.zzd = new zzado();
        this.zze = new zzadk();
        this.zzm = C.TIME_UNSET;
        this.zzf = new zzadm();
        zzact zzactVar = new zzact();
        this.zzg = zzactVar;
        this.zzj = zzactVar;
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0220  */
    /* JADX WARN: Code duplicated, block: B:109:0x0229  */
    /* JADX WARN: Code duplicated, block: B:120:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x0069  */
    /* JADX WARN: Code duplicated, block: B:26:0x0071  */
    /* JADX WARN: Code duplicated, block: B:28:0x007a  */
    /* JADX WARN: Code duplicated, block: B:29:0x007e  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:46:0x00e0  */
    /* JADX WARN: Multi-variable type inference failed */
    private final int zzf(zzacv zzacvVar) throws IOException {
        int iZzf;
        int i11;
        int iZzg;
        zzadk zzadkVar;
        zzail zzailVarZzb;
        zzaii zzaiiVarZzh;
        int i12;
        int i13;
        zzaid zzaidVarZzb;
        long jZzq;
        if (this.zzk == 0) {
            try {
                zzk(zzacvVar, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.zzq == null) {
            zzfp zzfpVar = new zzfp(this.zzd.zzc);
            ((zzack) zzacvVar).zzm(zzfpVar.zzM(), 0, this.zzd.zzc, false);
            zzado zzadoVar = this.zzd;
            int i14 = 21;
            if ((zzadoVar.zza & 1) != 0) {
                if (zzadoVar.zze != 1) {
                    i14 = 36;
                }
            } else if (zzadoVar.zze == 1) {
                i14 = 13;
            }
            if (zzfpVar.zze() >= i14 + 4) {
                zzfpVar.zzK(i14);
                iZzg = zzfpVar.zzg();
                if (iZzg != 1483304551) {
                    if (iZzg == 1231971951) {
                        iZzg = 1231971951;
                    } else if (zzfpVar.zze() >= 40) {
                        zzfpVar.zzK(36);
                        if (zzfpVar.zzg() == 1447187017) {
                            iZzg = 1447187017;
                        } else {
                            iZzg = 0;
                        }
                    } else {
                        iZzg = 0;
                    }
                }
            } else if (zzfpVar.zze() >= 40) {
                zzfpVar.zzK(36);
                if (zzfpVar.zzg() == 1447187017) {
                    iZzg = 1447187017;
                } else {
                    iZzg = 0;
                }
            } else {
                iZzg = 0;
            }
            if (iZzg == 1231971951) {
                zzaik zzaikVarZza = zzaik.zza(this.zzd, zzfpVar);
                zzadkVar = this.zze;
                if (!zzadkVar.zza() && (i12 = zzaikVarZza.zzd) != -1 && (i13 = zzaikVarZza.zze) != -1) {
                    zzadkVar.zza = i12;
                    zzadkVar.zzb = i13;
                }
                zzailVarZzb = zzail.zzb(zzacvVar.zzd(), zzaikVarZza, zzacvVar.zzf());
                ((zzack) zzacvVar).zzo(this.zzd.zzc, false);
                if (zzailVarZzb.zzh() && iZzg == 1231971951) {
                    zzaiiVarZzh = zzh(zzacvVar, false);
                } else {
                    zzaiiVarZzh = zzailVarZzb;
                }
            } else if (iZzg == 1447187017) {
                zzaiiVarZzh = zzaij.zzb(zzacvVar.zzd(), zzacvVar.zzf(), this.zzd, zzfpVar);
                ((zzack) zzacvVar).zzo(this.zzd.zzc, false);
            } else if (iZzg != 1483304551) {
                zzacvVar.zzj();
                zzaiiVarZzh = null;
            } else {
                zzaik zzaikVarZza2 = zzaik.zza(this.zzd, zzfpVar);
                zzadkVar = this.zze;
                if (!zzadkVar.zza()) {
                    zzadkVar.zza = i12;
                    zzadkVar.zzb = i13;
                }
                zzailVarZzb = zzail.zzb(zzacvVar.zzd(), zzaikVarZza2, zzacvVar.zzf());
                ((zzack) zzacvVar).zzo(this.zzd.zzc, false);
                if (zzailVarZzb.zzh()) {
                    zzaiiVarZzh = zzailVarZzb;
                } else {
                    zzaiiVarZzh = zzailVarZzb;
                }
            }
            zzby zzbyVar = this.zzl;
            long jZzf = zzacvVar.zzf();
            if (zzbyVar == null) {
                zzaidVarZzb = null;
                break;
            }
            int iZza = zzbyVar.zza();
            int i15 = 0;
            while (true) {
                if (i15 >= iZza) {
                    zzaidVarZzb = null;
                    break;
                }
                zzbx zzbxVarZzb = zzbyVar.zzb(i15);
                if (zzbxVarZzb instanceof zzagv) {
                    zzagv zzagvVar = (zzagv) zzbxVarZzb;
                    int iZza2 = zzbyVar.zza();
                    int i16 = 0;
                    while (true) {
                        if (i16 >= iZza2) {
                            jZzq = -9223372036854775807L;
                            break;
                        }
                        zzbx zzbxVarZzb2 = zzbyVar.zzb(i16);
                        if (zzbxVarZzb2 instanceof zzagz) {
                            zzagz zzagzVar = (zzagz) zzbxVarZzb2;
                            if (zzagzVar.zzf.equals("TLEN")) {
                                jZzq = zzfy.zzq(Long.parseLong((String) zzagzVar.zzc.get(0)));
                                break;
                            }
                        }
                        i16++;
                    }
                    zzaidVarZzb = zzaid.zzb(jZzf, zzagvVar, jZzq);
                    break;
                }
                i15++;
            }
            if (this.zzr) {
                zzaiiVarZzh = new zzaih();
            } else {
                if (zzaidVarZzb != null) {
                    zzaiiVarZzh = zzaidVarZzb;
                } else if (zzaiiVarZzh == null) {
                    zzaiiVarZzh = null;
                }
                if (zzaiiVarZzh != null) {
                    zzaiiVarZzh.zzh();
                } else {
                    zzaiiVarZzh = zzh(zzacvVar, false);
                }
            }
            this.zzq = zzaiiVarZzh;
            this.zzh.zzO(zzaiiVarZzh);
            zzaea zzaeaVar = this.zzj;
            zzak zzakVar = new zzak();
            zzakVar.zzW(this.zzd.zzb);
            zzakVar.zzO(4096);
            zzakVar.zzy(this.zzd.zze);
            zzakVar.zzX(this.zzd.zzd);
            zzakVar.zzF(this.zze.zza);
            zzakVar.zzG(this.zze.zzb);
            zzakVar.zzP(this.zzl);
            zzaeaVar.zzl(zzakVar.zzac());
            this.zzo = zzacvVar.zzf();
        } else {
            long j11 = this.zzo;
            if (j11 != 0) {
                long jZzf2 = zzacvVar.zzf();
                if (jZzf2 < j11) {
                    ((zzack) zzacvVar).zzo((int) (j11 - jZzf2), false);
                }
            }
        }
        int i17 = this.zzp;
        if (i17 == 0) {
            zzacvVar.zzj();
            if (zzj(zzacvVar)) {
                return -1;
            }
            this.zzc.zzK(0);
            int iZzg2 = this.zzc.zzg();
            if (!zzi(iZzg2, this.zzk) || zzadp.zzb(iZzg2) == -1) {
                ((zzack) zzacvVar).zzo(1, false);
                this.zzk = 0;
            } else {
                this.zzd.zza(iZzg2);
                if (this.zzm == C.TIME_UNSET) {
                    this.zzm = this.zzq.zzd(zzacvVar.zzf());
                }
                zzado zzadoVar2 = this.zzd;
                int i18 = zzadoVar2.zzc;
                this.zzp = i18;
                zzaii zzaiiVar = this.zzq;
                if (zzaiiVar instanceof zzaic) {
                    zzg(this.zzn + ((long) zzadoVar2.zzg));
                    throw null;
                }
                i17 = i18;
                iZzf = this.zzj.zzf(zzacvVar, i17, true);
                if (iZzf == -1) {
                    return -1;
                }
                i11 = this.zzp - iZzf;
                this.zzp = i11;
                if (i11 <= 0) {
                    this.zzj.zzt(zzg(this.zzn), 1, this.zzd.zzc, 0, null);
                    this.zzn += (long) this.zzd.zzg;
                    this.zzp = 0;
                    return 0;
                }
            }
        } else {
            iZzf = this.zzj.zzf(zzacvVar, i17, true);
            if (iZzf == -1) {
                return -1;
            }
            i11 = this.zzp - iZzf;
            this.zzp = i11;
            if (i11 <= 0) {
                this.zzj.zzt(zzg(this.zzn), 1, this.zzd.zzc, 0, null);
                this.zzn += (long) this.zzd.zzg;
                this.zzp = 0;
                return 0;
            }
        }
        return 0;
    }

    private final long zzg(long j11) {
        return this.zzm + ((j11 * 1000000) / ((long) this.zzd.zzd));
    }

    private final zzaii zzh(zzacv zzacvVar, boolean z11) throws IOException {
        ((zzack) zzacvVar).zzm(this.zzc.zzM(), 0, 4, false);
        this.zzc.zzK(0);
        this.zzd.zza(this.zzc.zzg());
        return new zzaib(zzacvVar.zzd(), zzacvVar.zzf(), this.zzd, false);
    }

    private static boolean zzi(int i11, long j11) {
        return ((long) (i11 & (-128000))) == (j11 & (-128000));
    }

    private final boolean zzj(zzacv zzacvVar) throws IOException {
        zzaii zzaiiVar = this.zzq;
        if (zzaiiVar != null) {
            long jZzc = zzaiiVar.zzc();
            if (jZzc != -1 && zzacvVar.zze() > jZzc - 4) {
                return true;
            }
        }
        try {
            return !zzacvVar.zzm(this.zzc.zzM(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    private final boolean zzk(zzacv zzacvVar, boolean z11) throws IOException {
        int i11;
        int iZze;
        int iZzb;
        zzacvVar.zzj();
        if (zzacvVar.zzf() == 0) {
            zzby zzbyVarZza = this.zzf.zza(zzacvVar, null);
            this.zzl = zzbyVarZza;
            if (zzbyVarZza != null) {
                this.zze.zzb(zzbyVarZza);
            }
            iZze = (int) zzacvVar.zze();
            if (!z11) {
                ((zzack) zzacvVar).zzo(iZze, false);
            }
            i11 = 0;
        } else {
            i11 = 0;
            iZze = 0;
        }
        int i12 = 0;
        int i13 = 0;
        while (true) {
            if (zzj(zzacvVar)) {
                if (i12 > 0) {
                    break;
                }
                throw new EOFException();
            }
            this.zzc.zzK(0);
            int iZzg = this.zzc.zzg();
            if ((i11 == 0 || zzi(iZzg, i11)) && (iZzb = zzadp.zzb(iZzg)) != -1) {
                i12++;
                if (i12 != 1) {
                    if (i12 == 4) {
                        break;
                    }
                } else {
                    this.zzd.zza(iZzg);
                    i11 = iZzg;
                }
                ((zzack) zzacvVar).zzl(iZzb - 4, false);
            } else {
                int i14 = i13 + 1;
                if (i13 == (true != z11 ? 131072 : 32768)) {
                    if (z11) {
                        return false;
                    }
                    throw zzcc.zza("Searched too many bytes.", null);
                }
                if (z11) {
                    zzacvVar.zzj();
                    ((zzack) zzacvVar).zzl(iZze + i14, false);
                } else {
                    ((zzack) zzacvVar).zzo(1, false);
                }
                i13 = i14;
                i11 = 0;
                i12 = 0;
            }
        }
        if (z11) {
            ((zzack) zzacvVar).zzo(iZze + i13, false);
        } else {
            zzacvVar.zzj();
        }
        this.zzk = i11;
        return true;
    }

    public final void zza() {
        this.zzr = true;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final int zzb(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        zzek.zzb(this.zzi);
        int i11 = zzfy.zza;
        int iZzf = zzf(zzacvVar);
        if (iZzf == -1 && (this.zzq instanceof zzaic)) {
            if (this.zzq.zza() != zzg(this.zzn)) {
                throw null;
            }
        }
        return iZzf;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzc(zzacx zzacxVar) {
        this.zzh = zzacxVar;
        zzaea zzaeaVarZzw = zzacxVar.zzw(0, 1);
        this.zzi = zzaeaVarZzw;
        this.zzj = zzaeaVarZzw;
        this.zzh.zzD();
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzd(long j11, long j12) {
        this.zzk = 0;
        this.zzm = C.TIME_UNSET;
        this.zzn = 0L;
        this.zzp = 0;
        zzaii zzaiiVar = this.zzq;
        if (zzaiiVar instanceof zzaic) {
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final boolean zze(zzacv zzacvVar) throws IOException {
        return zzk(zzacvVar, true);
    }
}
