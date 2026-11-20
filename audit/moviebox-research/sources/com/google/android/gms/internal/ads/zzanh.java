package com.google.android.gms.internal.ads;

import com.applovin.exoplayer2.common.base.Ascii;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzanh implements zzamy {
    private final zzanz zza;
    private long zze;
    private String zzg;
    private zzaea zzh;
    private zzang zzi;
    private boolean zzj;
    private boolean zzl;
    private final boolean[] zzf = new boolean[3];
    private final zzann zzb = new zzann(7, 128);
    private final zzann zzc = new zzann(8, 128);
    private final zzann zzd = new zzann(6, 128);
    private long zzk = C.TIME_UNSET;
    private final zzfp zzm = new zzfp();

    public zzanh(zzanz zzanzVar, boolean z11, boolean z12) {
        this.zza = zzanzVar;
    }

    private final void zzf(byte[] bArr, int i11, int i12) {
        if (!this.zzj) {
            this.zzb.zza(bArr, i11, i12);
            this.zzc.zza(bArr, i11, i12);
        }
        this.zzd.zza(bArr, i11, i12);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0052  */
    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zza(zzfp zzfpVar) {
        int i11;
        int i12;
        zzek.zzb(this.zzh);
        int i13 = zzfy.zza;
        int iZzd = zzfpVar.zzd();
        int iZze = zzfpVar.zze();
        byte[] bArrZzM = zzfpVar.zzM();
        this.zze += (long) zzfpVar.zzb();
        this.zzh.zzr(zzfpVar, zzfpVar.zzb());
        while (true) {
            int iZza = zzgm.zza(bArrZzM, iZzd, iZze, this.zzf);
            if (iZza == iZze) {
                zzf(bArrZzM, iZzd, iZze);
                return;
            }
            int i14 = iZza + 3;
            int i15 = bArrZzM[i14] & Ascii.US;
            int i16 = iZza - iZzd;
            if (i16 > 0) {
                zzf(bArrZzM, iZzd, iZza);
            }
            int i17 = iZze - iZza;
            long j11 = this.zze - ((long) i17);
            int i18 = i16 < 0 ? -i16 : 0;
            long j12 = this.zzk;
            if (this.zzj) {
                i11 = iZze;
                i12 = i14;
            } else {
                this.zzb.zzd(i18);
                this.zzc.zzd(i18);
                if (this.zzj) {
                    i11 = iZze;
                    i12 = i14;
                    zzann zzannVar = this.zzb;
                    if (zzannVar.zze()) {
                        this.zzi.zzc(zzgm.zze(zzannVar.zza, 4, zzannVar.zzb));
                        this.zzb.zzb();
                    } else {
                        zzann zzannVar2 = this.zzc;
                        if (zzannVar2.zze()) {
                            this.zzi.zzb(zzgm.zzd(zzannVar2.zza, 4, zzannVar2.zzb));
                            this.zzc.zzb();
                        }
                    }
                } else if (this.zzb.zze() && this.zzc.zze()) {
                    ArrayList arrayList = new ArrayList();
                    zzann zzannVar3 = this.zzb;
                    arrayList.add(Arrays.copyOf(zzannVar3.zza, zzannVar3.zzb));
                    zzann zzannVar4 = this.zzc;
                    arrayList.add(Arrays.copyOf(zzannVar4.zza, zzannVar4.zzb));
                    zzann zzannVar5 = this.zzb;
                    zzgl zzglVarZze = zzgm.zze(zzannVar5.zza, 4, zzannVar5.zzb);
                    zzann zzannVar6 = this.zzc;
                    zzgk zzgkVarZzd = zzgm.zzd(zzannVar6.zza, 4, zzannVar6.zzb);
                    i12 = i14;
                    String strZza = zzem.zza(zzglVarZze.zza, zzglVarZze.zzb, zzglVarZze.zzc);
                    zzaea zzaeaVar = this.zzh;
                    zzak zzakVar = new zzak();
                    i11 = iZze;
                    zzakVar.zzK(this.zzg);
                    zzakVar.zzW(MimeTypes.VIDEO_H264);
                    zzakVar.zzz(strZza);
                    zzakVar.zzab(zzglVarZze.zze);
                    zzakVar.zzI(zzglVarZze.zzf);
                    zzr zzrVar = new zzr();
                    zzrVar.zzc(zzglVarZze.zzj);
                    zzrVar.zzb(zzglVarZze.zzk);
                    zzrVar.zzd(zzglVarZze.zzl);
                    zzrVar.zzf(zzglVarZze.zzh + 8);
                    zzrVar.zza(zzglVarZze.zzi + 8);
                    zzakVar.zzA(zzrVar.zzg());
                    zzakVar.zzS(zzglVarZze.zzg);
                    zzakVar.zzL(arrayList);
                    zzaeaVar.zzl(zzakVar.zzac());
                    this.zzj = true;
                    this.zzi.zzc(zzglVarZze);
                    this.zzi.zzb(zzgkVarZzd);
                    this.zzb.zzb();
                    this.zzc.zzb();
                } else {
                    i11 = iZze;
                    i12 = i14;
                }
            }
            if (this.zzd.zzd(i18)) {
                zzann zzannVar7 = this.zzd;
                this.zzm.zzI(this.zzd.zza, zzgm.zzb(zzannVar7.zza, zzannVar7.zzb));
                this.zzm.zzK(4);
                this.zza.zza(j12, this.zzm);
            }
            if (this.zzi.zzf(j11, i17, this.zzj)) {
                this.zzl = false;
            }
            long j13 = this.zzk;
            if (!this.zzj) {
                this.zzb.zzc(i15);
                this.zzc.zzc(i15);
            }
            this.zzd.zzc(i15);
            this.zzi.zze(j11, i15, j13, this.zzl);
            iZzd = i12;
            iZze = i11;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzb(zzacx zzacxVar, zzaok zzaokVar) {
        zzaokVar.zzc();
        this.zzg = zzaokVar.zzb();
        zzaea zzaeaVarZzw = zzacxVar.zzw(zzaokVar.zza(), 2);
        this.zzh = zzaeaVarZzw;
        this.zzi = new zzang(zzaeaVarZzw, false, false);
        this.zza.zzb(zzacxVar, zzaokVar);
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzc(boolean z11) {
        zzek.zzb(this.zzh);
        int i11 = zzfy.zza;
        if (z11) {
            this.zzi.zza(this.zze);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzd(long j11, int i11) {
        this.zzk = j11;
        int i12 = i11 & 2;
        this.zzl = (i12 != 0) | this.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zze() {
        this.zze = 0L;
        this.zzl = false;
        this.zzk = C.TIME_UNSET;
        zzgm.zzf(this.zzf);
        this.zzb.zzb();
        this.zzc.zzb();
        this.zzd.zzb();
        zzang zzangVar = this.zzi;
        if (zzangVar != null) {
            zzangVar.zzd();
        }
    }
}
