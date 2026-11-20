package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import java.util.ArrayList;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzaof implements zzanx {
    final /* synthetic */ zzaog zza;
    private final zzfo zzb = new zzfo(new byte[5], 5);
    private final SparseArray zzc = new SparseArray();
    private final SparseIntArray zzd = new SparseIntArray();
    private final int zze;

    public zzaof(zzaog zzaogVar, int i11) {
        this.zza = zzaogVar;
        this.zze = i11;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:22:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:25:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:29:0x0107  */
    @Override // com.google.android.gms.internal.ads.zzanx
    public final void zza(zzfp zzfpVar) {
        zzfw zzfwVar;
        int i11;
        int i12;
        if (zzfpVar.zzm() != 2) {
            return;
        }
        zzfw zzfwVar2 = (zzfw) this.zza.zzb.get(0);
        if ((zzfpVar.zzm() & 128) != 0) {
            zzfpVar.zzL(1);
            int iZzq = zzfpVar.zzq();
            int i13 = 3;
            zzfpVar.zzL(3);
            zzfpVar.zzF(this.zzb, 2);
            this.zzb.zzm(3);
            int i14 = 13;
            this.zza.zzr = this.zzb.zzd(13);
            zzfpVar.zzF(this.zzb, 2);
            int i15 = 4;
            this.zzb.zzm(4);
            int i16 = 12;
            zzfpVar.zzL(this.zzb.zzd(12));
            this.zzc.clear();
            this.zzd.clear();
            int iZzb = zzfpVar.zzb();
            while (iZzb > 0) {
                int i17 = 5;
                zzfpVar.zzF(this.zzb, 5);
                zzfo zzfoVar = this.zzb;
                int iZzd = zzfoVar.zzd(8);
                zzfoVar.zzm(i13);
                int iZzd2 = this.zzb.zzd(i14);
                this.zzb.zzm(i15);
                int iZzd3 = this.zzb.zzd(i16);
                int iZzd4 = zzfpVar.zzd();
                int i18 = iZzd4 + iZzd3;
                ArrayList arrayList = null;
                String strTrim = null;
                int i19 = -1;
                while (zzfpVar.zzd() < i18) {
                    int iZzm = zzfpVar.zzm();
                    int iZzd5 = zzfpVar.zzd() + zzfpVar.zzm();
                    if (iZzd5 > i18) {
                        break;
                    }
                    if (iZzm == i17) {
                        long jZzu = zzfpVar.zzu();
                        if (jZzu == 1094921523) {
                            zzfwVar2 = zzfwVar2;
                            i12 = iZzq;
                            i19 = TsExtractor.TS_STREAM_TYPE_AC3;
                        } else if (jZzu == 1161904947) {
                            zzfwVar2 = zzfwVar2;
                            i12 = iZzq;
                            i19 = TsExtractor.TS_STREAM_TYPE_E_AC3;
                        } else if (jZzu == 1094921524) {
                            zzfwVar2 = zzfwVar2;
                            i12 = iZzq;
                            i19 = 172;
                        } else if (jZzu == 1212503619) {
                            zzfwVar2 = zzfwVar2;
                            i12 = iZzq;
                            i19 = 36;
                        } else {
                            i12 = iZzq;
                        }
                    } else if (iZzm == 106) {
                        zzfwVar2 = zzfwVar2;
                        i12 = iZzq;
                        i19 = TsExtractor.TS_STREAM_TYPE_AC3;
                    } else if (iZzm == 122) {
                        zzfwVar2 = zzfwVar2;
                        i12 = iZzq;
                        i19 = TsExtractor.TS_STREAM_TYPE_E_AC3;
                    } else if (iZzm == 127) {
                        if (zzfpVar.zzm() == 21) {
                            zzfwVar2 = zzfwVar2;
                            i12 = iZzq;
                            i19 = 172;
                        } else {
                            i12 = iZzq;
                        }
                    } else if (iZzm == 123) {
                        zzfwVar2 = zzfwVar2;
                        i12 = iZzq;
                        i19 = TsExtractor.TS_STREAM_TYPE_DTS;
                    } else if (iZzm == 10) {
                        strTrim = zzfpVar.zzA(i13, zzfwq.zzc).trim();
                        i12 = iZzq;
                    } else if (iZzm == 89) {
                        ArrayList arrayList2 = new ArrayList();
                        while (zzfpVar.zzd() < iZzd5) {
                            String strTrim2 = zzfpVar.zzA(i13, zzfwq.zzc).trim();
                            int iZzm2 = zzfpVar.zzm();
                            zzfw zzfwVar3 = zzfwVar2;
                            byte[] bArr = new byte[4];
                            zzfpVar.zzG(bArr, 0, 4);
                            arrayList2.add(new zzaoh(strTrim2, iZzm2, bArr));
                            zzfwVar2 = zzfwVar3;
                            iZzq = iZzq;
                            i13 = 3;
                        }
                        zzfwVar2 = zzfwVar2;
                        i12 = iZzq;
                        arrayList = arrayList2;
                        i19 = 89;
                    } else {
                        zzfwVar2 = zzfwVar2;
                        i12 = iZzq;
                        if (iZzm == 111) {
                            i19 = InputDeviceCompat.SOURCE_KEYBOARD;
                        }
                    }
                    zzfpVar.zzL(iZzd5 - zzfpVar.zzd());
                    zzfwVar2 = zzfwVar2;
                    iZzq = i12;
                    i13 = 3;
                    i17 = 5;
                }
                zzfw zzfwVar4 = zzfwVar2;
                int i21 = iZzq;
                zzfpVar.zzK(i18);
                zzaoi zzaoiVar = new zzaoi(i19, strTrim, arrayList, Arrays.copyOfRange(zzfpVar.zzM(), iZzd4, i18));
                if (iZzd == 6 || iZzd == 5) {
                    iZzd = zzaoiVar.zza;
                }
                iZzb -= iZzd3 + 5;
                if (!this.zza.zzh.get(iZzd2)) {
                    zzaol zzaolVarZza = this.zza.zze.zza(iZzd, zzaoiVar);
                    this.zzd.put(iZzd2, iZzd2);
                    this.zzc.put(iZzd2, zzaolVarZza);
                }
                zzfwVar2 = zzfwVar4;
                iZzq = i21;
                i13 = 3;
                i15 = 4;
                i16 = 12;
                i14 = 13;
            }
            zzfw zzfwVar5 = zzfwVar2;
            int i22 = iZzq;
            int size = this.zzd.size();
            int i23 = 0;
            while (i23 < size) {
                SparseIntArray sparseIntArray = this.zzd;
                zzaog zzaogVar = this.zza;
                int iKeyAt = sparseIntArray.keyAt(i23);
                int iValueAt = sparseIntArray.valueAt(i23);
                zzaogVar.zzh.put(iKeyAt, true);
                this.zza.zzi.put(iValueAt, true);
                zzaol zzaolVar = (zzaol) this.zzc.valueAt(i23);
                if (zzaolVar != null) {
                    zzacx zzacxVar = this.zza.zzl;
                    i11 = i22;
                    zzaok zzaokVar = new zzaok(i11, iKeyAt, 8192);
                    zzfwVar = zzfwVar5;
                    zzaolVar.zzb(zzfwVar, zzacxVar, zzaokVar);
                    this.zza.zzg.put(iValueAt, zzaolVar);
                } else {
                    zzfwVar = zzfwVar5;
                    i11 = i22;
                }
                i23++;
                zzfwVar5 = zzfwVar;
                i22 = i11;
            }
            this.zza.zzg.remove(this.zze);
            this.zza.zzm = 0;
            zzaog zzaogVar2 = this.zza;
            if (zzaogVar2.zzm == 0) {
                zzaogVar2.zzl.zzD();
                this.zza.zzn = true;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzanx
    public final void zzb(zzfw zzfwVar, zzacx zzacxVar, zzaok zzaokVar) {
    }
}
