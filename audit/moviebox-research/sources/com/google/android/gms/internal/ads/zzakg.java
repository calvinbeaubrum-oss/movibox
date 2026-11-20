package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzakg extends zzake {

    @Nullable
    private zzakf zza;
    private int zzb;
    private boolean zzc;

    @Nullable
    private zzaef zzd;

    @Nullable
    private zzaed zze;

    @Override // com.google.android.gms.internal.ads.zzake
    public final long zza(zzfp zzfpVar) {
        if ((zzfpVar.zzM()[0] & 1) == 1) {
            return -1L;
        }
        byte b11 = zzfpVar.zzM()[0];
        zzakf zzakfVar = this.zza;
        zzek.zzb(zzakfVar);
        int i11 = !zzakfVar.zzd[(b11 >> 1) & (255 >>> (8 - zzakfVar.zze))].zza ? zzakfVar.zza.zze : zzakfVar.zza.zzf;
        int i12 = this.zzc ? (this.zzb + i11) / 4 : 0;
        if (zzfpVar.zzc() < zzfpVar.zze() + 4) {
            byte[] bArrCopyOf = Arrays.copyOf(zzfpVar.zzM(), zzfpVar.zze() + 4);
            zzfpVar.zzI(bArrCopyOf, bArrCopyOf.length);
        } else {
            zzfpVar.zzJ(zzfpVar.zze() + 4);
        }
        long j11 = i12;
        byte[] bArrZzM = zzfpVar.zzM();
        bArrZzM[zzfpVar.zze() - 4] = (byte) (j11 & 255);
        bArrZzM[zzfpVar.zze() - 3] = (byte) ((j11 >>> 8) & 255);
        bArrZzM[zzfpVar.zze() - 2] = (byte) ((j11 >>> 16) & 255);
        bArrZzM[zzfpVar.zze() - 1] = (byte) ((j11 >>> 24) & 255);
        this.zzc = true;
        this.zzb = i11;
        return j11;
    }

    @Override // com.google.android.gms.internal.ads.zzake
    public final void zzb(boolean z11) {
        super.zzb(z11);
        if (z11) {
            this.zza = null;
            this.zzd = null;
            this.zze = null;
        }
        this.zzb = 0;
        this.zzc = false;
    }

    /* JADX WARN: Code duplicated, block: B:167:0x03c7 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:169:0x03c9  */
    @Override // com.google.android.gms.internal.ads.zzake
    public final boolean zzc(zzfp zzfpVar, long j11, zzakb zzakbVar) throws IOException {
        zzakf zzakfVar;
        int i11;
        int iZzb;
        int i12;
        int i13;
        if (this.zza != null) {
            zzakbVar.zza.getClass();
            return false;
        }
        zzaef zzaefVar = this.zzd;
        int i14 = 4;
        if (zzaefVar != null) {
            zzaed zzaedVar = this.zze;
            if (zzaedVar == null) {
                this.zze = zzaeg.zzc(zzfpVar, true, true);
            } else {
                byte[] bArr = new byte[zzfpVar.zze()];
                System.arraycopy(zzfpVar.zzM(), 0, bArr, 0, zzfpVar.zze());
                int i15 = zzaefVar.zza;
                int i16 = 5;
                zzaeg.zzd(5, zzfpVar, false);
                int iZzm = zzfpVar.zzm() + 1;
                zzaec zzaecVar = new zzaec(zzfpVar.zzM());
                zzaecVar.zzc(zzfpVar.zzd() * 8);
                int i17 = 0;
                while (true) {
                    int i18 = 2;
                    int i19 = 16;
                    if (i17 >= iZzm) {
                        zzaef zzaefVar2 = zzaefVar;
                        int i21 = 6;
                        int iZzb2 = zzaecVar.zzb(6) + 1;
                        for (int i22 = 0; i22 < iZzb2; i22++) {
                            if (zzaecVar.zzb(16) != 0) {
                                throw zzcc.zza("placeholder of time domain transforms not zeroed out", null);
                            }
                        }
                        int i23 = 1;
                        int iZzb3 = zzaecVar.zzb(6) + 1;
                        int i24 = 0;
                        while (true) {
                            int i25 = 3;
                            if (i24 >= iZzb3) {
                                int i26 = 1;
                                int iZzb4 = zzaecVar.zzb(i21) + 1;
                                int i27 = 0;
                                while (i27 < iZzb4) {
                                    if (zzaecVar.zzb(16) > 2) {
                                        throw zzcc.zza("residueType greater than 2 is not decodable", null);
                                    }
                                    zzaecVar.zzc(24);
                                    zzaecVar.zzc(24);
                                    zzaecVar.zzc(24);
                                    int iZzb5 = zzaecVar.zzb(i21) + i26;
                                    int i28 = 8;
                                    zzaecVar.zzc(8);
                                    int[] iArr = new int[iZzb5];
                                    for (int i29 = 0; i29 < iZzb5; i29++) {
                                        iArr[i29] = ((zzaecVar.zzd() ? zzaecVar.zzb(5) : 0) * 8) + zzaecVar.zzb(3);
                                    }
                                    int i31 = 0;
                                    while (i31 < iZzb5) {
                                        int i32 = 0;
                                        while (i32 < i28) {
                                            if ((iArr[i31] & (1 << i32)) != 0) {
                                                zzaecVar.zzc(i28);
                                            }
                                            i32++;
                                            i28 = 8;
                                        }
                                        i31++;
                                        i28 = 8;
                                    }
                                    i27++;
                                    i21 = 6;
                                    i26 = 1;
                                }
                                int iZzb6 = zzaecVar.zzb(i21) + 1;
                                for (int i33 = 0; i33 < iZzb6; i33++) {
                                    int iZzb7 = zzaecVar.zzb(16);
                                    if (iZzb7 != 0) {
                                        zzff.zzc("VorbisUtil", "mapping type other than 0 not supported: " + iZzb7);
                                    } else {
                                        if (zzaecVar.zzd()) {
                                            i11 = 1;
                                            iZzb = zzaecVar.zzb(4) + 1;
                                        } else {
                                            i11 = 1;
                                            iZzb = 1;
                                        }
                                        if (zzaecVar.zzd()) {
                                            int iZzb8 = zzaecVar.zzb(8) + i11;
                                            for (int i34 = 0; i34 < iZzb8; i34++) {
                                                int i35 = i15 - 1;
                                                zzaecVar.zzc(zzaeg.zza(i35));
                                                zzaecVar.zzc(zzaeg.zza(i35));
                                            }
                                        }
                                        if (zzaecVar.zzb(2) != 0) {
                                            throw zzcc.zza("to reserved bits must be zero after mapping coupling steps", null);
                                        }
                                        if (iZzb > 1) {
                                            for (int i36 = 0; i36 < i15; i36++) {
                                                zzaecVar.zzc(4);
                                            }
                                        }
                                        for (int i37 = 0; i37 < iZzb; i37++) {
                                            zzaecVar.zzc(8);
                                            zzaecVar.zzc(8);
                                            zzaecVar.zzc(8);
                                        }
                                    }
                                }
                                int iZzb9 = zzaecVar.zzb(6);
                                int i38 = iZzb9 + 1;
                                zzaee[] zzaeeVarArr = new zzaee[i38];
                                for (int i39 = 0; i39 < i38; i39++) {
                                    zzaeeVarArr[i39] = new zzaee(zzaecVar.zzd(), zzaecVar.zzb(16), zzaecVar.zzb(16), zzaecVar.zzb(8));
                                }
                                if (!zzaecVar.zzd()) {
                                    throw zzcc.zza("framing bit after modes not set as expected", null);
                                }
                                zzakfVar = new zzakf(zzaefVar2, zzaedVar, bArr, zzaeeVarArr, zzaeg.zza(iZzb9));
                                break;
                            }
                            int iZzb10 = zzaecVar.zzb(i19);
                            if (iZzb10 == 0) {
                                i12 = iZzb3;
                                int i40 = 8;
                                zzaecVar.zzc(8);
                                zzaecVar.zzc(16);
                                zzaecVar.zzc(16);
                                zzaecVar.zzc(6);
                                zzaecVar.zzc(8);
                                int iZzb11 = zzaecVar.zzb(4) + 1;
                                int i41 = 0;
                                while (i41 < iZzb11) {
                                    zzaecVar.zzc(i40);
                                    i41++;
                                    i40 = 8;
                                }
                            } else {
                                if (iZzb10 != i23) {
                                    throw zzcc.zza("floor type greater than 1 not decodable: " + iZzb10, null);
                                }
                                int iZzb12 = zzaecVar.zzb(i16);
                                int[] iArr2 = new int[iZzb12];
                                int i42 = -1;
                                for (int i43 = 0; i43 < iZzb12; i43++) {
                                    int iZzb13 = zzaecVar.zzb(4);
                                    iArr2[i43] = iZzb13;
                                    if (iZzb13 > i42) {
                                        i42 = iZzb13;
                                    }
                                }
                                int i44 = i42 + 1;
                                int[] iArr3 = new int[i44];
                                int i45 = 0;
                                while (i45 < i44) {
                                    iArr3[i45] = zzaecVar.zzb(i25) + 1;
                                    int iZzb14 = zzaecVar.zzb(i18);
                                    if (iZzb14 > 0) {
                                        i13 = 8;
                                        zzaecVar.zzc(8);
                                    } else {
                                        i13 = 8;
                                    }
                                    int i46 = iZzb3;
                                    int i47 = 0;
                                    for (int i48 = 1; i47 < (i48 << iZzb14); i48 = 1) {
                                        zzaecVar.zzc(i13);
                                        i47++;
                                        i13 = 8;
                                    }
                                    i45++;
                                    iZzb3 = i46;
                                    i18 = 2;
                                    i25 = 3;
                                }
                                i12 = iZzb3;
                                zzaecVar.zzc(i18);
                                int iZzb15 = zzaecVar.zzb(4);
                                int i49 = 0;
                                int i50 = 0;
                                for (int i51 = 0; i51 < iZzb12; i51++) {
                                    i49 += iArr3[iArr2[i51]];
                                    while (i50 < i49) {
                                        zzaecVar.zzc(iZzb15);
                                        i50++;
                                    }
                                }
                            }
                            i24++;
                            iZzb3 = i12;
                            i21 = 6;
                            i18 = 2;
                            i19 = 16;
                            i23 = 1;
                            i16 = 5;
                        }
                    } else {
                        if (zzaecVar.zzb(24) != 5653314) {
                            throw zzcc.zza("expected code book to start with [0x56, 0x43, 0x42] at " + zzaecVar.zza(), null);
                        }
                        int iZzb16 = zzaecVar.zzb(16);
                        int iZzb17 = zzaecVar.zzb(24);
                        if (zzaecVar.zzd()) {
                            zzaecVar.zzc(5);
                            for (int iZzb18 = 0; iZzb18 < iZzb17; iZzb18 += zzaecVar.zzb(zzaeg.zza(iZzb17 - iZzb18))) {
                            }
                        } else {
                            boolean zZzd = zzaecVar.zzd();
                            for (int i52 = 0; i52 < iZzb17; i52++) {
                                if (!zZzd) {
                                    zzaecVar.zzc(5);
                                } else if (zzaecVar.zzd()) {
                                    zzaecVar.zzc(5);
                                }
                            }
                        }
                        int iZzb19 = zzaecVar.zzb(i14);
                        if (iZzb19 > 2) {
                            throw zzcc.zza("lookup type greater than 2 not decodable: " + iZzb19, null);
                        }
                        if (iZzb19 != 1) {
                            if (iZzb19 != 2) {
                                zzaefVar = zzaefVar;
                            }
                            i17++;
                            zzaefVar = zzaefVar;
                            i14 = 4;
                        } else {
                            i18 = iZzb19;
                        }
                        zzaecVar.zzc(32);
                        zzaecVar.zzc(32);
                        int iZzb20 = zzaecVar.zzb(i14) + 1;
                        zzaecVar.zzc(1);
                        zzaecVar.zzc((int) ((i18 == 1 ? iZzb16 != 0 ? (long) Math.floor(Math.pow(iZzb17, 1.0d / ((double) iZzb16))) : 0L : ((long) iZzb16) * ((long) iZzb17)) * ((long) iZzb20)));
                        i17++;
                        zzaefVar = zzaefVar;
                        i14 = 4;
                    }
                }
            }
            this.zza = zzakfVar;
            if (zzakfVar == null) {
                return true;
            }
            ArrayList arrayList = new ArrayList();
            zzaef zzaefVar3 = zzakfVar.zza;
            arrayList.add(zzaefVar3.zzg);
            arrayList.add(zzakfVar.zzc);
            zzby zzbyVarZzb = zzaeg.zzb(zzgaa.zzk(zzakfVar.zzb.zzb));
            zzak zzakVar = new zzak();
            zzakVar.zzW(MimeTypes.AUDIO_VORBIS);
            zzakVar.zzx(zzaefVar3.zzd);
            zzakVar.zzR(zzaefVar3.zzc);
            zzakVar.zzy(zzaefVar3.zza);
            zzakVar.zzX(zzaefVar3.zzb);
            zzakVar.zzL(arrayList);
            zzakVar.zzP(zzbyVarZzb);
            zzakbVar.zza = zzakVar.zzac();
            return true;
        }
        zzaeg.zzd(1, zzfpVar, false);
        int iZzj = zzfpVar.zzj();
        int iZzm2 = zzfpVar.zzm();
        int iZzj2 = zzfpVar.zzj();
        int iZzi = zzfpVar.zzi();
        int i53 = iZzi <= 0 ? -1 : iZzi;
        int iZzi2 = zzfpVar.zzi();
        int i54 = iZzi2 <= 0 ? -1 : iZzi2;
        int iZzi3 = zzfpVar.zzi();
        int i55 = iZzi3 <= 0 ? -1 : iZzi3;
        int iZzm3 = zzfpVar.zzm();
        this.zzd = new zzaef(iZzj, iZzm2, iZzj2, i53, i54, i55, (int) Math.pow(2.0d, iZzm3 & 15), (int) Math.pow(2.0d, (iZzm3 & 240) >> 4), 1 == (zzfpVar.zzm() & 1), Arrays.copyOf(zzfpVar.zzM(), zzfpVar.zze()));
        zzakfVar = null;
        this.zza = zzakfVar;
        if (zzakfVar == null) {
            return true;
        }
        ArrayList arrayList2 = new ArrayList();
        zzaef zzaefVar4 = zzakfVar.zza;
        arrayList2.add(zzaefVar4.zzg);
        arrayList2.add(zzakfVar.zzc);
        zzby zzbyVarZzb2 = zzaeg.zzb(zzgaa.zzk(zzakfVar.zzb.zzb));
        zzak zzakVar2 = new zzak();
        zzakVar2.zzW(MimeTypes.AUDIO_VORBIS);
        zzakVar2.zzx(zzaefVar4.zzd);
        zzakVar2.zzR(zzaefVar4.zzc);
        zzakVar2.zzy(zzaefVar4.zza);
        zzakVar2.zzX(zzaefVar4.zzb);
        zzakVar2.zzL(arrayList2);
        zzakVar2.zzP(zzbyVarZzb2);
        zzakbVar.zza = zzakVar2.zzac();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzake
    public final void zzi(long j11) {
        super.zzi(j11);
        this.zzc = j11 != 0;
        zzaef zzaefVar = this.zzd;
        this.zzb = zzaefVar != null ? zzaefVar.zze : 0;
    }
}
