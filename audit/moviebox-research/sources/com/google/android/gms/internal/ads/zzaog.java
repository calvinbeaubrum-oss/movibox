package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaog implements zzacu {

    @Deprecated
    public static final zzadb zza = new zzadb() { // from class: com.google.android.gms.internal.ads.zzaod
        @Override // com.google.android.gms.internal.ads.zzadb
        public final /* synthetic */ zzacu[] zza(Uri uri, Map map) {
            int i11 = zzada.zza;
            return new zzacu[]{new zzaog(1, 1, zzakp.zza, new zzfw(0L), new zzamv(0), 112800)};
        }
    };
    private final List zzb;
    private final zzfp zzc;
    private final SparseIntArray zzd;
    private final zzaoj zze;
    private final zzakp zzf;
    private final SparseArray zzg;
    private final SparseBooleanArray zzh;
    private final SparseBooleanArray zzi;
    private final zzaoc zzj;
    private zzaob zzk;
    private zzacx zzl;
    private int zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private int zzq;
    private int zzr;

    @Deprecated
    public zzaog() {
        throw null;
    }

    public zzaog(int i11, int i12, zzakp zzakpVar, zzfw zzfwVar, zzaoj zzaojVar, int i13) {
        this.zze = zzaojVar;
        this.zzf = zzakpVar;
        this.zzb = Collections.singletonList(zzfwVar);
        this.zzc = new zzfp(new byte[9400], 0);
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        this.zzh = sparseBooleanArray;
        this.zzi = new SparseBooleanArray();
        SparseArray sparseArray = new SparseArray();
        this.zzg = sparseArray;
        this.zzd = new SparseIntArray();
        this.zzj = new zzaoc(112800);
        this.zzl = zzacx.zza;
        this.zzr = -1;
        sparseBooleanArray.clear();
        sparseArray.clear();
        SparseArray sparseArray2 = new SparseArray();
        int size = sparseArray2.size();
        for (int i14 = 0; i14 < size; i14++) {
            this.zzg.put(sparseArray2.keyAt(i14), (zzaol) sparseArray2.valueAt(i14));
        }
        this.zzg.put(0, new zzany(new zzaoe(this)));
    }

    /* JADX WARN: Code duplicated, block: B:95:0x01b5  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v2, types: [boolean, int] */
    @Override // com.google.android.gms.internal.ads.zzacu
    public final int zzb(zzacv zzacvVar, zzadr zzadrVar) throws IOException {
        ?? r11;
        long j11;
        boolean z11;
        long jZzd = zzacvVar.zzd();
        if (this.zzn) {
            if (jZzd != -1) {
                zzaoc zzaocVar = this.zzj;
                if (!zzaocVar.zzd()) {
                    return zzaocVar.zza(zzacvVar, zzadrVar, this.zzr);
                }
            }
            if (this.zzo) {
                j11 = 0;
            } else {
                this.zzo = true;
                zzaoc zzaocVar2 = this.zzj;
                if (zzaocVar2.zzb() != C.TIME_UNSET) {
                    j11 = 0;
                    zzaob zzaobVar = new zzaob(zzaocVar2.zzc(), zzaocVar2.zzb(), jZzd, this.zzr, 112800);
                    this.zzk = zzaobVar;
                    this.zzl.zzO(zzaobVar.zzb());
                } else {
                    j11 = 0;
                    this.zzl.zzO(new zzadt(zzaocVar2.zzb(), 0L));
                }
            }
            if (this.zzp) {
                z11 = false;
                this.zzp = false;
                zzd(j11, j11);
                if (zzacvVar.zzf() != j11) {
                    zzadrVar.zza = j11;
                    return 1;
                }
            } else {
                z11 = false;
            }
            zzaob zzaobVar2 = this.zzk;
            r11 = z11;
            if (zzaobVar2 != null && zzaobVar2.zze()) {
                r11 = z11;
                return zzaobVar2.zza(zzacvVar, zzadrVar);
            }
        } else {
            r11 = 0;
        }
        r11 = z11;
        zzfp zzfpVar = this.zzc;
        byte[] bArrZzM = zzfpVar.zzM();
        if (9400 - zzfpVar.zzd() < 188) {
            int iZzb = zzfpVar.zzb();
            if (iZzb > 0) {
                System.arraycopy(bArrZzM, zzfpVar.zzd(), bArrZzM, r11, iZzb);
            }
            this.zzc.zzI(bArrZzM, iZzb);
        }
        while (true) {
            zzfp zzfpVar2 = this.zzc;
            if (zzfpVar2.zzb() >= 188) {
                int iZzd = zzfpVar2.zzd();
                int iZze = zzfpVar2.zze();
                int iZza = zzaom.zza(zzfpVar2.zzM(), iZzd, iZze);
                this.zzc.zzK(iZza);
                int i11 = iZza + 188;
                if (i11 > iZze) {
                    this.zzq += iZza - iZzd;
                } else {
                    this.zzq = r11;
                }
                zzfp zzfpVar3 = this.zzc;
                int iZze2 = zzfpVar3.zze();
                if (i11 > iZze2) {
                    return r11;
                }
                int iZzg = zzfpVar3.zzg();
                if ((8388608 & iZzg) != 0) {
                    this.zzc.zzK(i11);
                    return r11;
                }
                int i12 = (4194304 & iZzg) != 0 ? 1 : 0;
                int i13 = iZzg & 32;
                int i14 = (iZzg >> 8) & 8191;
                zzaol zzaolVar = (iZzg & 16) != 0 ? (zzaol) this.zzg.get(i14) : null;
                if (zzaolVar == null) {
                    this.zzc.zzK(i11);
                    return r11;
                }
                int i15 = iZzg & 15;
                int i16 = this.zzd.get(i14, i15 - 1);
                this.zzd.put(i14, i15);
                if (i16 == i15) {
                    this.zzc.zzK(i11);
                    return r11;
                }
                if (i15 != ((i16 + 1) & 15)) {
                    zzaolVar.zzc();
                }
                if (i13 != 0) {
                    zzfp zzfpVar4 = this.zzc;
                    int iZzm = zzfpVar4.zzm();
                    i12 |= (zzfpVar4.zzm() & 64) != 0 ? 2 : 0;
                    this.zzc.zzL(iZzm - 1);
                }
                boolean z12 = this.zzn;
                if (z12 || !this.zzi.get(i14, r11)) {
                    this.zzc.zzJ(i11);
                    zzaolVar.zza(this.zzc, i12);
                    this.zzc.zzJ(iZze2);
                    if (!z12) {
                        if (this.zzn && jZzd != -1) {
                            this.zzp = true;
                        }
                    }
                } else if (this.zzn) {
                    this.zzp = true;
                }
                this.zzc.zzK(i11);
                return r11;
            }
            int iZze3 = zzfpVar2.zze();
            int iZza2 = zzacvVar.zza(bArrZzM, iZze3, 9400 - iZze3);
            if (iZza2 == -1) {
                for (int i17 = 0; i17 < this.zzg.size(); i17++) {
                    zzaol zzaolVar2 = (zzaol) this.zzg.valueAt(i17);
                    if (zzaolVar2 instanceof zzanp) {
                        zzaolVar2.zza(new zzfp(), 1);
                    }
                }
                return -1;
            }
            this.zzc.zzJ(iZze3 + iZza2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzc(zzacx zzacxVar) {
        this.zzl = zzacxVar;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0031  */
    @Override // com.google.android.gms.internal.ads.zzacu
    public final void zzd(long j11, long j12) {
        zzaob zzaobVar;
        int size = this.zzb.size();
        for (int i11 = 0; i11 < size; i11++) {
            zzfw zzfwVar = (zzfw) this.zzb.get(i11);
            if (zzfwVar.zzf() != C.TIME_UNSET) {
                long jZzd = zzfwVar.zzd();
                if (jZzd != C.TIME_UNSET && jZzd != 0 && jZzd != j12) {
                    zzfwVar.zzi(j12);
                }
            } else {
                zzfwVar.zzi(j12);
            }
        }
        if (j12 != 0 && (zzaobVar = this.zzk) != null) {
            zzaobVar.zzd(j12);
        }
        this.zzc.zzH(0);
        this.zzd.clear();
        for (int i12 = 0; i12 < this.zzg.size(); i12++) {
            ((zzaol) this.zzg.valueAt(i12)).zzc();
        }
        this.zzq = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzacu
    public final boolean zze(zzacv zzacvVar) throws IOException {
        byte[] bArrZzM = this.zzc.zzM();
        zzack zzackVar = (zzack) zzacvVar;
        zzackVar.zzm(bArrZzM, 0, 940, false);
        for (int i11 = 0; i11 < 188; i11++) {
            int i12 = 0;
            while (true) {
                if (i12 >= 5) {
                    zzackVar.zzo(i11, false);
                    return true;
                }
                if (bArrZzM[(i12 * 188) + i11] != 71) {
                    break;
                }
                i12++;
            }
        }
        return false;
    }
}
