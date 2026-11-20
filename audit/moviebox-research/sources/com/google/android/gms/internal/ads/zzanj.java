package com.google.android.gms.internal.ads;

import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.Collections;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzanj implements zzamy {
    private final zzanz zza;
    private String zzb;
    private zzaea zzc;
    private zzani zzd;
    private boolean zze;
    private long zzl;
    private final boolean[] zzf = new boolean[3];
    private final zzann zzg = new zzann(32, 128);
    private final zzann zzh = new zzann(33, 128);
    private final zzann zzi = new zzann(34, 128);
    private final zzann zzj = new zzann(39, 128);
    private final zzann zzk = new zzann(40, 128);
    private long zzm = C.TIME_UNSET;
    private final zzfp zzn = new zzfp();

    public zzanj(zzanz zzanzVar) {
        this.zza = zzanzVar;
    }

    private final void zzf(byte[] bArr, int i11, int i12) {
        this.zzd.zzc(bArr, i11, i12);
        if (!this.zze) {
            this.zzg.zza(bArr, i11, i12);
            this.zzh.zza(bArr, i11, i12);
            this.zzi.zza(bArr, i11, i12);
        }
        this.zzj.zza(bArr, i11, i12);
        this.zzk.zza(bArr, i11, i12);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0139  */
    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zza(zzfp zzfpVar) {
        zzek.zzb(this.zzc);
        int i11 = zzfy.zza;
        while (zzfpVar.zzb() > 0) {
            int iZzd = zzfpVar.zzd();
            int iZze = zzfpVar.zze();
            byte[] bArrZzM = zzfpVar.zzM();
            this.zzl += (long) zzfpVar.zzb();
            this.zzc.zzr(zzfpVar, zzfpVar.zzb());
            while (iZzd < iZze) {
                int iZza = zzgm.zza(bArrZzM, iZzd, iZze, this.zzf);
                if (iZza == iZze) {
                    zzf(bArrZzM, iZzd, iZze);
                    return;
                }
                int i12 = iZza + 3;
                int i13 = bArrZzM[i12] & 126;
                int i14 = iZza - iZzd;
                if (i14 > 0) {
                    zzf(bArrZzM, iZzd, iZza);
                }
                int i15 = iZze - iZza;
                long j11 = this.zzl - ((long) i15);
                int i16 = i14 < 0 ? -i14 : 0;
                long j12 = this.zzm;
                this.zzd.zzb(j11, i15, this.zze);
                if (!this.zze) {
                    this.zzg.zzd(i16);
                    this.zzh.zzd(i16);
                    this.zzi.zzd(i16);
                    zzann zzannVar = this.zzg;
                    if (zzannVar.zze()) {
                        zzann zzannVar2 = this.zzh;
                        if (zzannVar2.zze()) {
                            zzann zzannVar3 = this.zzi;
                            if (zzannVar3.zze()) {
                                zzaea zzaeaVar = this.zzc;
                                String str = this.zzb;
                                int i17 = zzannVar.zzb;
                                byte[] bArr = new byte[zzannVar2.zzb + i17 + zzannVar3.zzb];
                                System.arraycopy(zzannVar.zza, 0, bArr, 0, i17);
                                System.arraycopy(zzannVar2.zza, 0, bArr, zzannVar.zzb, zzannVar2.zzb);
                                System.arraycopy(zzannVar3.zza, 0, bArr, zzannVar.zzb + zzannVar2.zzb, zzannVar3.zzb);
                                zzgj zzgjVarZzc = zzgm.zzc(zzannVar2.zza, 5, zzannVar2.zzb);
                                String strZzb = zzem.zzb(zzgjVarZzc.zza, zzgjVarZzc.zzb, zzgjVarZzc.zzc, zzgjVarZzc.zzd, zzgjVarZzc.zzg, zzgjVarZzc.zzh);
                                zzak zzakVar = new zzak();
                                zzakVar.zzK(str);
                                zzakVar.zzW(MimeTypes.VIDEO_H265);
                                zzakVar.zzz(strZzb);
                                zzakVar.zzab(zzgjVarZzc.zzi);
                                zzakVar.zzI(zzgjVarZzc.zzj);
                                zzr zzrVar = new zzr();
                                zzrVar.zzc(zzgjVarZzc.zzl);
                                zzrVar.zzb(zzgjVarZzc.zzm);
                                zzrVar.zzd(zzgjVarZzc.zzn);
                                zzrVar.zzf(zzgjVarZzc.zze + 8);
                                zzrVar.zza(zzgjVarZzc.zzf + 8);
                                zzakVar.zzA(zzrVar.zzg());
                                zzakVar.zzS(zzgjVarZzc.zzk);
                                zzakVar.zzL(Collections.singletonList(bArr));
                                zzaeaVar.zzl(zzakVar.zzac());
                                this.zze = true;
                            }
                        }
                    }
                }
                if (this.zzj.zzd(i16)) {
                    zzann zzannVar4 = this.zzj;
                    this.zzn.zzI(this.zzj.zza, zzgm.zzb(zzannVar4.zza, zzannVar4.zzb));
                    this.zzn.zzL(5);
                    this.zza.zza(j12, this.zzn);
                }
                if (this.zzk.zzd(i16)) {
                    zzann zzannVar5 = this.zzk;
                    this.zzn.zzI(this.zzk.zza, zzgm.zzb(zzannVar5.zza, zzannVar5.zzb));
                    this.zzn.zzL(5);
                    this.zza.zza(j12, this.zzn);
                }
                int i18 = i13 >> 1;
                this.zzd.zze(j11, i15, i18, this.zzm, this.zze);
                if (!this.zze) {
                    this.zzg.zzc(i18);
                    this.zzh.zzc(i18);
                    this.zzi.zzc(i18);
                }
                this.zzj.zzc(i18);
                this.zzk.zzc(i18);
                iZzd = i12;
                iZze = iZze;
                bArrZzM = bArrZzM;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzb(zzacx zzacxVar, zzaok zzaokVar) {
        zzaokVar.zzc();
        this.zzb = zzaokVar.zzb();
        zzaea zzaeaVarZzw = zzacxVar.zzw(zzaokVar.zza(), 2);
        this.zzc = zzaeaVarZzw;
        this.zzd = new zzani(zzaeaVarZzw);
        this.zza.zzb(zzacxVar, zzaokVar);
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzc(boolean z11) {
        zzek.zzb(this.zzc);
        int i11 = zzfy.zza;
        if (z11) {
            this.zzd.zza(this.zzl);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zzd(long j11, int i11) {
        this.zzm = j11;
    }

    @Override // com.google.android.gms.internal.ads.zzamy
    public final void zze() {
        this.zzl = 0L;
        this.zzm = C.TIME_UNSET;
        zzgm.zzf(this.zzf);
        this.zzg.zzb();
        this.zzh.zzb();
        this.zzi.zzb();
        this.zzj.zzb();
        this.zzk.zzb();
        zzani zzaniVar = this.zzd;
        if (zzaniVar != null) {
            zzaniVar.zzd();
        }
    }
}
