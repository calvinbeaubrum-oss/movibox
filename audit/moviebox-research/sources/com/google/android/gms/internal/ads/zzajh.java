package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzajh implements zzacu, zzadu {

    @Deprecated
    public static final zzadb zza = new zzadb() { // from class: com.google.android.gms.internal.ads.zzajf
        @Override // com.google.android.gms.internal.ads.zzadb
        public final /* synthetic */ zzacu[] zza(Uri uri, Map map) {
            int i11 = zzada.zza;
            return new zzacu[]{new zzajh()};
        }
    };

    @Nullable
    private zzahe zzA;
    private final zzakp zzb;
    private final int zzc;
    private final zzfp zzd;
    private final zzfp zze;
    private final zzfp zzf;
    private final zzfp zzg;
    private final ArrayDeque zzh;
    private final zzajk zzi;
    private final List zzj;
    private int zzk;
    private int zzl;
    private long zzm;
    private int zzn;

    @Nullable
    private zzfp zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private boolean zzt;
    private zzacx zzu;
    private zzajg[] zzv;
    private long[][] zzw;
    private int zzx;
    private long zzy;
    private int zzz;

    @Deprecated
    public zzajh() {
        this(zzakp.zza, 16);
    }

    public zzajh(zzakp zzakpVar, int i11) {
        this.zzb = zzakpVar;
        this.zzc = i11;
        this.zzk = (i11 & 4) != 0 ? 3 : 0;
        this.zzi = new zzajk();
        this.zzj = new ArrayList();
        this.zzg = new zzfp(16);
        this.zzh = new ArrayDeque();
        this.zzd = new zzfp(zzgm.zza);
        this.zze = new zzfp(4);
        this.zzf = new zzfp();
        this.zzp = -1;
        this.zzu = zzacx.zza;
        this.zzv = new zzajg[0];
    }

    private static int zzf(int i11) {
        if (i11 != 1751476579) {
            return i11 != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    private static int zzi(zzajp zzajpVar, long j11) {
        int iZza = zzajpVar.zza(j11);
        return iZza == -1 ? zzajpVar.zzb(j11) : iZza;
    }

    private static long zzj(zzajp zzajpVar, long j11, long j12) {
        int iZzi = zzi(zzajpVar, j11);
        return iZzi == -1 ? j12 : Math.min(zzajpVar.zzc[iZzi], j12);
    }

    private final void zzk() {
        this.zzk = 0;
        this.zzn = 0;
    }

    /* JADX WARN: Code duplicated, block: B:53:0x012c  */
    private final void zzl(long j11) throws zzcc {
        zzby zzbyVar;
        long j12;
        int i11;
        zzby zzbyVar2;
        int i12;
        while (!this.zzh.isEmpty() && ((zzaim) this.zzh.peek()).zza == j11) {
            zzaim zzaimVar = (zzaim) this.zzh.pop();
            if (zzaimVar.zzd == 1836019574) {
                ArrayList arrayList = new ArrayList();
                int i13 = this.zzz;
                zzadk zzadkVar = new zzadk();
                zzain zzainVarZzb = zzaimVar.zzb(1969517665);
                if (zzainVarZzb != null) {
                    zzby zzbyVarZzb = zzaiw.zzb(zzainVarZzb);
                    zzadkVar.zzb(zzbyVarZzb);
                    zzbyVar = zzbyVarZzb;
                } else {
                    zzbyVar = null;
                }
                zzaim zzaimVarZza = zzaimVar.zza(1835365473);
                zzby zzbyVarZza = zzaimVarZza != null ? zzaiw.zza(zzaimVarZza) : null;
                zzbx[] zzbxVarArr = new zzbx[1];
                zzain zzainVarZzb2 = zzaimVar.zzb(1836476516);
                zzainVarZzb2.getClass();
                boolean z11 = i13 == 1;
                zzbxVarArr[0] = zzaiw.zzc(zzainVarZzb2.zza);
                zzby zzbyVar3 = new zzby(C.TIME_UNSET, zzbxVarArr);
                zzby zzbyVar4 = zzbyVar;
                long j13 = -9223372036854775807L;
                List listZzd = zzaiw.zzd(zzaimVar, zzadkVar, C.TIME_UNSET, null, 1 == (this.zzc & 1), z11, new zzfws() { // from class: com.google.android.gms.internal.ads.zzaje
                    @Override // com.google.android.gms.internal.ads.zzfws
                    public final Object apply(Object obj) {
                        zzajm zzajmVar = (zzajm) obj;
                        zzadb zzadbVar = zzajh.zza;
                        return zzajmVar;
                    }
                });
                int size = listZzd.size();
                long j14 = -9223372036854775807L;
                int size2 = -1;
                int i14 = 0;
                while (true) {
                    j12 = 0;
                    if (i14 >= size) {
                        break;
                    }
                    zzajp zzajpVar = (zzajp) listZzd.get(i14);
                    if (zzajpVar.zzb != 0) {
                        zzajm zzajmVar = zzajpVar.zza;
                        long j15 = zzajmVar.zze;
                        if (j15 == j13) {
                            j15 = zzajpVar.zzh;
                        }
                        long jMax = Math.max(j14, j15);
                        zzajg zzajgVar = new zzajg(zzajmVar, zzajpVar, this.zzu.zzw(i14, zzajmVar.zzb));
                        int i15 = MimeTypes.AUDIO_TRUEHD.equals(zzajmVar.zzf.zzm) ? zzajpVar.zze * 16 : zzajpVar.zze + 30;
                        zzak zzakVarZzb = zzajmVar.zzf.zzb();
                        zzakVarZzb.zzO(i15);
                        if (zzajmVar.zzb != 2) {
                            i11 = 1;
                        } else {
                            if ((this.zzc & 8) != 0) {
                                zzakVarZzb.zzU(zzajmVar.zzf.zzf | (size2 == -1 ? 1 : 2));
                            }
                            if (j15 > 0) {
                                int i16 = zzajpVar.zzb;
                                i11 = 1;
                                if (i16 > 1) {
                                    zzakVarZzb.zzH(i16 / (j15 / 1000000.0f));
                                }
                            } else {
                                i11 = 1;
                            }
                        }
                        int i17 = zzajmVar.zzb;
                        int i18 = zzajd.zzb;
                        if (i17 == i11 && zzadkVar.zza()) {
                            zzakVarZzb.zzF(zzadkVar.zza);
                            zzakVarZzb.zzG(zzadkVar.zzb);
                        }
                        int i19 = zzajmVar.zzb;
                        zzby[] zzbyVarArr = new zzby[3];
                        if (this.zzj.isEmpty()) {
                            i12 = 0;
                            zzbyVar2 = null;
                        } else {
                            zzbyVar2 = new zzby(this.zzj);
                            i12 = 0;
                        }
                        zzbyVarArr[i12] = zzbyVar2;
                        zzbyVarArr[i11] = zzbyVar4;
                        zzbyVarArr[2] = zzbyVar3;
                        zzby zzbyVar5 = new zzby(C.TIME_UNSET, new zzbx[i12]);
                        if (zzbyVarZza != null) {
                            for (int i21 = 0; i21 < zzbyVarZza.zza(); i21++) {
                                zzbx zzbxVarZzb = zzbyVarZza.zzb(i21);
                                if (zzbxVarZzb instanceof zzgc) {
                                    zzgc zzgcVar = (zzgc) zzbxVarZzb;
                                    if (!zzgcVar.zza.equals("com.android.capture.fps")) {
                                        zzbyVar5 = zzbyVar5.zzc(zzgcVar);
                                    } else if (i19 == 2) {
                                        zzbyVar5 = zzbyVar5.zzc(zzgcVar);
                                    }
                                }
                            }
                        }
                        for (int i22 = 0; i22 < 3; i22++) {
                            zzbyVar5 = zzbyVar5.zzd(zzbyVarArr[i22]);
                        }
                        if (zzbyVar5.zza() > 0) {
                            zzakVarZzb.zzP(zzbyVar5);
                        }
                        zzajgVar.zzc.zzl(zzakVarZzb.zzac());
                        if (zzajmVar.zzb == 2 && size2 == -1) {
                            size2 = arrayList.size();
                        }
                        arrayList.add(zzajgVar);
                        j14 = jMax;
                    }
                    i14++;
                    zzadkVar = zzadkVar;
                    listZzd = listZzd;
                    size = size;
                    j13 = C.TIME_UNSET;
                }
                this.zzx = size2;
                this.zzy = j14;
                zzajg[] zzajgVarArr = (zzajg[]) arrayList.toArray(new zzajg[0]);
                this.zzv = zzajgVarArr;
                int length = zzajgVarArr.length;
                long[][] jArr = new long[length][];
                int[] iArr = new int[length];
                long[] jArr2 = new long[length];
                boolean[] zArr = new boolean[length];
                for (int i23 = 0; i23 < zzajgVarArr.length; i23++) {
                    jArr[i23] = new long[zzajgVarArr[i23].zzb.zzb];
                    jArr2[i23] = zzajgVarArr[i23].zzb.zzf[0];
                }
                int i24 = 0;
                while (i24 < zzajgVarArr.length) {
                    long j16 = Long.MAX_VALUE;
                    int i25 = -1;
                    for (int i26 = 0; i26 < zzajgVarArr.length; i26++) {
                        if (!zArr[i26]) {
                            long j17 = jArr2[i26];
                            if (j17 <= j16) {
                                i25 = i26;
                                j16 = j17;
                            }
                        }
                    }
                    int i27 = iArr[i25];
                    long[] jArr3 = jArr[i25];
                    jArr3[i27] = j12;
                    zzajp zzajpVar2 = zzajgVarArr[i25].zzb;
                    j12 += (long) zzajpVar2.zzd[i27];
                    int i28 = i27 + 1;
                    iArr[i25] = i28;
                    if (i28 < jArr3.length) {
                        jArr2[i25] = zzajpVar2.zzf[i28];
                    } else {
                        zArr[i25] = true;
                        i24++;
                    }
                }
                this.zzw = jArr;
                this.zzu.zzD();
                this.zzu.zzO(this);
                this.zzh.clear();
                this.zzk = 2;
            } else if (!this.zzh.isEmpty()) {
                ((zzaim) this.zzh.peek()).zzc(zzaimVar);
            }
        }
        if (this.zzk != 2) {
            zzk();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final long zza() {
        return this.zzy;
    }

    /* JADX WARN: Code duplicated, block: B:277:0x0094 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:33:0x007f  */
    /* JADX WARN: Code duplicated, block: B:37:0x008e  */
    @Override // com.google.android.gms.internal.ads.zzacu
    public final int zzb(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        boolean z11;
        boolean z12;
        while (true) {
            int i11 = this.zzk;
            if (i11 == 0) {
                if (this.zzn == 0) {
                    if (!zzacvVar.zzn(this.zzg.zzM(), 0, 8, true)) {
                        if (this.zzz != 2 || (this.zzc & 2) == 0) {
                            return -1;
                        }
                        zzaea zzaeaVarZzw = this.zzu.zzw(0, 4);
                        zzahe zzaheVar = this.zzA;
                        zzby zzbyVar = zzaheVar == null ? null : new zzby(C.TIME_UNSET, zzaheVar);
                        zzak zzakVar = new zzak();
                        zzakVar.zzP(zzbyVar);
                        zzaeaVarZzw.zzl(zzakVar.zzac());
                        this.zzu.zzD();
                        this.zzu.zzO(new zzadt(C.TIME_UNSET, 0L));
                        return -1;
                    }
                    this.zzn = 8;
                    this.zzg.zzK(0);
                    this.zzm = this.zzg.zzu();
                    this.zzl = this.zzg.zzg();
                }
                long j11 = this.zzm;
                if (j11 == 1) {
                    zzacvVar.zzi(this.zzg.zzM(), 8, 8);
                    this.zzn += 8;
                    this.zzm = this.zzg.zzv();
                } else if (j11 == 0) {
                    long jZzd = zzacvVar.zzd();
                    if (jZzd == -1) {
                        zzaim zzaimVar = (zzaim) this.zzh.peek();
                        jZzd = zzaimVar != null ? zzaimVar.zza : -1L;
                    }
                    if (jZzd != -1) {
                        this.zzm = (jZzd - zzacvVar.zzf()) + ((long) this.zzn);
                    }
                }
                long j12 = this.zzm;
                int i12 = this.zzn;
                if (j12 < i12) {
                    throw zzcc.zzc("Atom size less than header length (unsupported).");
                }
                int i13 = this.zzl;
                if (i13 == 1836019574 || i13 == 1953653099 || i13 == 1835297121 || i13 == 1835626086 || i13 == 1937007212 || i13 == 1701082227 || i13 == 1835365473) {
                    long jZzf = zzacvVar.zzf();
                    long j13 = this.zzm;
                    long j14 = jZzf + j13;
                    long j15 = this.zzn;
                    if (j13 != j15 && this.zzl == 1835365473) {
                        this.zzf.zzH(8);
                        zzacvVar.zzh(this.zzf.zzM(), 0, 8);
                        zzaiw.zze(this.zzf);
                        zzacvVar.zzk(this.zzf.zzd());
                        zzacvVar.zzj();
                    }
                    long j16 = j14 - j15;
                    this.zzh.push(new zzaim(this.zzl, j16));
                    if (this.zzm == this.zzn) {
                        zzl(j16);
                    } else {
                        zzk();
                    }
                } else if (i13 == 1835296868 || i13 == 1836476516 || i13 == 1751411826 || i13 == 1937011556 || i13 == 1937011827 || i13 == 1937011571 || i13 == 1668576371 || i13 == 1701606260 || i13 == 1937011555 || i13 == 1937011578 || i13 == 1937013298 || i13 == 1937007471 || i13 == 1668232756 || i13 == 1953196132 || i13 == 1718909296 || i13 == 1969517665 || i13 == 1801812339 || i13 == 1768715124) {
                    zzek.zzf(i12 == 8);
                    zzek.zzf(this.zzm <= 2147483647L);
                    zzfp zzfpVar = new zzfp((int) this.zzm);
                    System.arraycopy(this.zzg.zzM(), 0, zzfpVar.zzM(), 0, 8);
                    this.zzo = zzfpVar;
                    this.zzk = 1;
                } else {
                    long jZzf2 = zzacvVar.zzf();
                    long j17 = this.zzn;
                    long j18 = jZzf2 - j17;
                    if (this.zzl == 1836086884) {
                        this.zzA = new zzahe(0L, j18, C.TIME_UNSET, j18 + j17, this.zzm - j17);
                    }
                    this.zzo = null;
                    this.zzk = 1;
                }
            } else {
                if (i11 != 1) {
                    if (i11 != 2) {
                        this.zzi.zza(zzacvVar, zzadrVar, this.zzj);
                        if (zzadrVar.zza == 0) {
                            zzk();
                        }
                        return 1;
                    }
                    long jZzf3 = zzacvVar.zzf();
                    int i14 = this.zzp;
                    if (i14 == -1) {
                        long j19 = Long.MAX_VALUE;
                        long j21 = Long.MAX_VALUE;
                        long j22 = Long.MAX_VALUE;
                        int i15 = 0;
                        boolean z13 = true;
                        int i16 = -1;
                        int i17 = -1;
                        boolean z14 = true;
                        while (true) {
                            zzajg[] zzajgVarArr = this.zzv;
                            if (i15 >= zzajgVarArr.length) {
                                break;
                            }
                            zzajg zzajgVar = zzajgVarArr[i15];
                            int i18 = zzajgVar.zze;
                            zzajp zzajpVar = zzajgVar.zzb;
                            if (i18 != zzajpVar.zzb) {
                                long j23 = zzajpVar.zzc[i18];
                                long[][] jArr = this.zzw;
                                int i19 = zzfy.zza;
                                long j24 = jArr[i15][i18];
                                long j25 = j23 - jZzf3;
                                boolean z15 = j25 < 0 || j25 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE;
                                if (z15) {
                                    z11 = z14;
                                } else {
                                    if (z14) {
                                        z14 = z15;
                                        i17 = i15;
                                        j22 = j25;
                                        j21 = j24;
                                    } else {
                                        z11 = false;
                                    }
                                    if (j24 < j19) {
                                        z13 = z15;
                                        i16 = i15;
                                        j19 = j24;
                                    }
                                }
                                if (z15 != z11 || j25 >= j22) {
                                    z14 = z11;
                                } else {
                                    z14 = z15;
                                    i17 = i15;
                                    j22 = j25;
                                    j21 = j24;
                                }
                                if (j24 < j19) {
                                    z13 = z15;
                                    i16 = i15;
                                    j19 = j24;
                                }
                            }
                            i15++;
                        }
                        i14 = (j19 == Long.MAX_VALUE || !z13 || j21 < j19 + 10485760) ? i17 : i16;
                        this.zzp = i14;
                        if (i14 == -1) {
                            return -1;
                        }
                    }
                    zzajg zzajgVar2 = this.zzv[i14];
                    zzaea zzaeaVar = zzajgVar2.zzc;
                    int i21 = zzajgVar2.zze;
                    zzajp zzajpVar2 = zzajgVar2.zzb;
                    long j26 = zzajpVar2.zzc[i21];
                    int i22 = zzajpVar2.zzd[i21];
                    zzaeb zzaebVar = zzajgVar2.zzd;
                    long j27 = (j26 - jZzf3) + ((long) this.zzq);
                    if (j27 < 0 || j27 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                        zzadrVar.zza = j26;
                        return 1;
                    }
                    if (zzajgVar2.zza.zzg == 1) {
                        j27 += 8;
                        i22 -= 8;
                    }
                    zzacvVar.zzk((int) j27);
                    zzajm zzajmVar = zzajgVar2.zza;
                    int i23 = zzajmVar.zzj;
                    if (i23 == 0) {
                        if ("audio/ac4".equals(zzajmVar.zzf.zzm)) {
                            if (this.zzr == 0) {
                                zzaby.zzb(i22, this.zzf);
                                zzaeaVar.zzr(this.zzf, 7);
                                this.zzr += 7;
                            }
                            i22 += 7;
                        } else if (zzaebVar != null) {
                            zzaebVar.zzd(zzacvVar);
                        }
                        while (true) {
                            int i24 = this.zzr;
                            if (i24 >= i22) {
                                break;
                            }
                            int iZzf = zzaeaVar.zzf(zzacvVar, i22 - i24, false);
                            this.zzq += iZzf;
                            this.zzr += iZzf;
                            this.zzs -= iZzf;
                        }
                    } else {
                        byte[] bArrZzM = this.zze.zzM();
                        bArrZzM[0] = 0;
                        bArrZzM[1] = 0;
                        bArrZzM[2] = 0;
                        int i25 = 4 - i23;
                        while (this.zzr < i22) {
                            int i26 = this.zzs;
                            if (i26 == 0) {
                                zzacvVar.zzi(bArrZzM, i25, i23);
                                this.zzq += i23;
                                this.zze.zzK(0);
                                int iZzg = this.zze.zzg();
                                if (iZzg < 0) {
                                    throw zzcc.zza("Invalid NAL length", null);
                                }
                                this.zzs = iZzg;
                                this.zzd.zzK(0);
                                zzaeaVar.zzr(this.zzd, 4);
                                this.zzr += 4;
                                i22 += i25;
                            } else {
                                int iZzf2 = zzaeaVar.zzf(zzacvVar, i26, false);
                                this.zzq += iZzf2;
                                this.zzr += iZzf2;
                                this.zzs -= iZzf2;
                            }
                        }
                    }
                    zzajp zzajpVar3 = zzajgVar2.zzb;
                    long j28 = zzajpVar3.zzf[i21];
                    int i27 = zzajpVar3.zzg[i21];
                    if (zzaebVar != null) {
                        zzaebVar.zzc(zzaeaVar, j28, i27, i22, 0, null);
                        if (i21 + 1 == zzajgVar2.zzb.zzb) {
                            zzaebVar.zza(zzaeaVar, null);
                        }
                    } else {
                        zzaeaVar.zzt(j28, i27, i22, 0, null);
                    }
                    zzajgVar2.zze++;
                    this.zzp = -1;
                    this.zzq = 0;
                    this.zzr = 0;
                    this.zzs = 0;
                    return 0;
                }
                long j29 = this.zzm - ((long) this.zzn);
                long jZzf4 = zzacvVar.zzf() + j29;
                zzfp zzfpVar2 = this.zzo;
                if (zzfpVar2 != null) {
                    zzacvVar.zzi(zzfpVar2.zzM(), this.zzn, (int) j29);
                    if (this.zzl == 1718909296) {
                        this.zzt = true;
                        zzfpVar2.zzK(8);
                        int iZzf3 = zzf(zzfpVar2.zzg());
                        if (iZzf3 == 0) {
                            zzfpVar2.zzL(4);
                            do {
                                if (zzfpVar2.zzb() <= 0) {
                                    iZzf3 = 0;
                                    break;
                                }
                                iZzf3 = zzf(zzfpVar2.zzg());
                            } while (iZzf3 == 0);
                        }
                        this.zzz = iZzf3;
                    } else if (!this.zzh.isEmpty()) {
                        ((zzaim) this.zzh.peek()).zzd(new zzain(this.zzl, zzfpVar2));
                    }
                } else {
                    if (!this.zzt && this.zzl == 1835295092) {
                        this.zzz = 1;
                    }
                    if (j29 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                        zzacvVar.zzk((int) j29);
                    } else {
                        zzadrVar.zza = zzacvVar.zzf() + j29;
                        z12 = true;
                    }
                    zzl(jZzf4);
                    if (z12 && this.zzk != 2) {
                        return 1;
                    }
                }
                z12 = false;
                zzl(jZzf4);
                if (z12) {
                    continue;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzc(zzacx zzacxVar) {
        if ((this.zzc & 16) == 0) {
            zzacxVar = new zzaks(zzacxVar, this.zzb);
        }
        this.zzu = zzacxVar;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzd(long j11, long j12) {
        this.zzh.clear();
        this.zzn = 0;
        this.zzp = -1;
        this.zzq = 0;
        this.zzr = 0;
        this.zzs = 0;
        if (j11 == 0) {
            if (this.zzk != 3) {
                zzk();
                return;
            } else {
                this.zzi.zzb();
                this.zzj.clear();
                return;
            }
        }
        for (zzajg zzajgVar : this.zzv) {
            zzajp zzajpVar = zzajgVar.zzb;
            int iZza = zzajpVar.zza(j12);
            if (iZza == -1) {
                iZza = zzajpVar.zzb(j12);
            }
            zzajgVar.zze = iZza;
            zzaeb zzaebVar = zzajgVar.zzd;
            if (zzaebVar != null) {
                zzaebVar.zzb();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final boolean zze(zzacv zzacvVar) throws IOException {
        return zzajl.zzb(zzacvVar, (this.zzc & 2) != 0);
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final zzads zzg(long j11) {
        long j12;
        long j13;
        int iZzb;
        zzajg[] zzajgVarArr = this.zzv;
        if (zzajgVarArr.length == 0) {
            zzadv zzadvVar = zzadv.zza;
            return new zzads(zzadvVar, zzadvVar);
        }
        int i11 = this.zzx;
        long jZzj = -1;
        if (i11 != -1) {
            zzajp zzajpVar = zzajgVarArr[i11].zzb;
            int iZzi = zzi(zzajpVar, j11);
            if (iZzi == -1) {
                zzadv zzadvVar2 = zzadv.zza;
                return new zzads(zzadvVar2, zzadvVar2);
            }
            long j14 = zzajpVar.zzf[iZzi];
            j12 = zzajpVar.zzc[iZzi];
            if (j14 >= j11 || iZzi >= zzajpVar.zzb - 1 || (iZzb = zzajpVar.zzb(j11)) == -1 || iZzb == iZzi) {
                j13 = -9223372036854775807L;
            } else {
                j13 = zzajpVar.zzf[iZzb];
                jZzj = zzajpVar.zzc[iZzb];
            }
            j11 = j14;
        } else {
            j12 = Long.MAX_VALUE;
            j13 = -9223372036854775807L;
        }
        int i12 = 0;
        while (true) {
            zzajg[] zzajgVarArr2 = this.zzv;
            if (i12 >= zzajgVarArr2.length) {
                break;
            }
            if (i12 != this.zzx) {
                zzajp zzajpVar2 = zzajgVarArr2[i12].zzb;
                long jZzj2 = zzj(zzajpVar2, j11, j12);
                if (j13 != C.TIME_UNSET) {
                    jZzj = zzj(zzajpVar2, j13, jZzj);
                }
                j12 = jZzj2;
            }
            i12++;
        }
        zzadv zzadvVar3 = new zzadv(j11, j12);
        return j13 == C.TIME_UNSET ? new zzads(zzadvVar3, zzadvVar3) : new zzads(zzadvVar3, new zzadv(j13, jZzj));
    }

    @Override // com.google.android.gms.internal.ads.zzadu
    public final boolean zzh() {
        return true;
    }
}
