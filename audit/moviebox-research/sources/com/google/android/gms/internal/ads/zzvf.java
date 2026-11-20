package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzvf implements zzup, zzuo {
    private final zzup[] zza;

    @Nullable
    private zzuo zze;

    @Nullable
    private zzws zzf;
    private final zzuc zzi;
    private final ArrayList zzc = new ArrayList();
    private final HashMap zzd = new HashMap();
    private zzwj zzh = new zzub(new zzwj[0]);
    private final IdentityHashMap zzb = new IdentityHashMap();
    private zzup[] zzg = new zzup[0];

    public zzvf(zzuc zzucVar, long[] jArr, zzup... zzupVarArr) {
        this.zzi = zzucVar;
        this.zza = zzupVarArr;
        for (int i11 = 0; i11 < zzupVarArr.length; i11++) {
            long j11 = jArr[i11];
            if (j11 != 0) {
                this.zza[i11] = new zzwp(zzupVarArr[i11], j11);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final long zza(long j11, zzmj zzmjVar) {
        zzup[] zzupVarArr = this.zzg;
        return (zzupVarArr.length > 0 ? zzupVarArr[0] : this.zza[0]).zza(j11, zzmjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final long zzb() {
        return this.zzh.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final long zzc() {
        return this.zzh.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final long zzd() {
        long j11 = -9223372036854775807L;
        for (zzup zzupVar : this.zzg) {
            long jZzd = zzupVar.zzd();
            if (jZzd == C.TIME_UNSET) {
                if (j11 != C.TIME_UNSET && zzupVar.zze(j11) != j11) {
                    throw new IllegalStateException("Unexpected child seekToUs result.");
                }
            } else if (j11 == C.TIME_UNSET) {
                for (zzup zzupVar2 : this.zzg) {
                    if (zzupVar2 == zzupVar) {
                        break;
                    }
                    if (zzupVar2.zze(jZzd) != jZzd) {
                        throw new IllegalStateException("Unexpected child seekToUs result.");
                    }
                }
                j11 = jZzd;
            } else if (jZzd != j11) {
                throw new IllegalStateException("Conflicting discontinuities.");
            }
        }
        return j11;
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final long zze(long j11) {
        long jZze = this.zzg[0].zze(j11);
        int i11 = 1;
        while (true) {
            zzup[] zzupVarArr = this.zzg;
            if (i11 >= zzupVarArr.length) {
                return jZze;
            }
            if (zzupVarArr[i11].zze(jZze) != jZze) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final long zzf(zzyi[] zzyiVarArr, boolean[] zArr, zzwh[] zzwhVarArr, boolean[] zArr2, long j11) {
        int length;
        int length2 = zzyiVarArr.length;
        int[] iArr = new int[length2];
        int[] iArr2 = new int[length2];
        int i11 = 0;
        while (true) {
            length = zzyiVarArr.length;
            if (i11 >= length) {
                break;
            }
            zzwh zzwhVar = zzwhVarArr[i11];
            Integer num = zzwhVar != null ? (Integer) this.zzb.get(zzwhVar) : null;
            iArr[i11] = num == null ? -1 : num.intValue();
            zzyi zzyiVar = zzyiVarArr[i11];
            if (zzyiVar != null) {
                String str = zzyiVar.zze().zzc;
                iArr2[i11] = Integer.parseInt(str.substring(0, str.indexOf(":")));
            } else {
                iArr2[i11] = -1;
            }
            i11++;
        }
        this.zzb.clear();
        zzwh[] zzwhVarArr2 = new zzwh[length];
        zzwh[] zzwhVarArr3 = new zzwh[length];
        zzyi[] zzyiVarArr2 = new zzyi[length];
        ArrayList arrayList = new ArrayList(this.zza.length);
        long j12 = j11;
        int i12 = 0;
        while (i12 < this.zza.length) {
            for (int i13 = 0; i13 < zzyiVarArr.length; i13++) {
                zzwhVarArr3[i13] = iArr[i13] == i12 ? zzwhVarArr[i13] : null;
                if (iArr2[i13] == i12) {
                    zzyi zzyiVar2 = zzyiVarArr[i13];
                    zzyiVar2.getClass();
                    zzcz zzczVar = (zzcz) this.zzd.get(zzyiVar2.zze());
                    zzczVar.getClass();
                    zzyiVarArr2[i13] = new zzve(zzyiVar2, zzczVar);
                } else {
                    zzyiVarArr2[i13] = null;
                }
            }
            ArrayList arrayList2 = arrayList;
            zzyi[] zzyiVarArr3 = zzyiVarArr2;
            zzwh[] zzwhVarArr4 = zzwhVarArr3;
            long jZzf = this.zza[i12].zzf(zzyiVarArr2, zArr, zzwhVarArr3, zArr2, j12);
            if (i12 == 0) {
                j12 = jZzf;
            } else if (jZzf != j12) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z11 = false;
            for (int i14 = 0; i14 < zzyiVarArr.length; i14++) {
                if (iArr2[i14] == i12) {
                    zzwh zzwhVar2 = zzwhVarArr4[i14];
                    zzwhVar2.getClass();
                    zzwhVarArr2[i14] = zzwhVar2;
                    this.zzb.put(zzwhVar2, Integer.valueOf(i12));
                    z11 = true;
                } else if (iArr[i14] == i12) {
                    zzek.zzf(zzwhVarArr4[i14] == null);
                }
            }
            if (z11) {
                arrayList2.add(this.zza[i12]);
            }
            i12++;
            arrayList = arrayList2;
            zzyiVarArr2 = zzyiVarArr3;
            zzwhVarArr3 = zzwhVarArr4;
        }
        System.arraycopy(zzwhVarArr2, 0, zzwhVarArr, 0, length);
        zzup[] zzupVarArr = (zzup[]) arrayList.toArray(new zzup[0]);
        this.zzg = zzupVarArr;
        this.zzh = new zzub(zzupVarArr);
        return j12;
    }

    @Override // com.google.android.gms.internal.ads.zzwi
    public final /* bridge */ /* synthetic */ void zzg(zzwj zzwjVar) {
        zzuo zzuoVar = this.zze;
        zzuoVar.getClass();
        zzuoVar.zzg(this);
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final zzws zzh() {
        zzws zzwsVar = this.zzf;
        zzwsVar.getClass();
        return zzwsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzuo
    public final void zzi(zzup zzupVar) {
        this.zzc.remove(zzupVar);
        if (!this.zzc.isEmpty()) {
            return;
        }
        int i11 = 0;
        for (zzup zzupVar2 : this.zza) {
            i11 += zzupVar2.zzh().zzc;
        }
        zzcz[] zzczVarArr = new zzcz[i11];
        int i12 = 0;
        int i13 = 0;
        while (true) {
            zzup[] zzupVarArr = this.zza;
            if (i12 >= zzupVarArr.length) {
                this.zzf = new zzws(zzczVarArr);
                zzuo zzuoVar = this.zze;
                zzuoVar.getClass();
                zzuoVar.zzi(this);
                return;
            }
            zzws zzwsVarZzh = zzupVarArr[i12].zzh();
            int i14 = zzwsVarZzh.zzc;
            int i15 = 0;
            while (i15 < i14) {
                zzcz zzczVarZzb = zzwsVarZzh.zzb(i15);
                zzcz zzczVarZzc = zzczVarZzb.zzc(i12 + ":" + zzczVarZzb.zzc);
                this.zzd.put(zzczVarZzc, zzczVarZzb);
                zzczVarArr[i13] = zzczVarZzc;
                i15++;
                i13++;
            }
            i12++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final void zzj(long j11, boolean z11) {
        for (zzup zzupVar : this.zzg) {
            zzupVar.zzj(j11, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final void zzk() throws IOException {
        int i11 = 0;
        while (true) {
            zzup[] zzupVarArr = this.zza;
            if (i11 >= zzupVarArr.length) {
                return;
            }
            zzupVarArr[i11].zzk();
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final void zzl(zzuo zzuoVar, long j11) {
        this.zze = zzuoVar;
        Collections.addAll(this.zzc, this.zza);
        int i11 = 0;
        while (true) {
            zzup[] zzupVarArr = this.zza;
            if (i11 >= zzupVarArr.length) {
                return;
            }
            zzupVarArr[i11].zzl(this, j11);
            i11++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final void zzm(long j11) {
        this.zzh.zzm(j11);
    }

    public final zzup zzn(int i11) {
        zzup zzupVar = this.zza[i11];
        return zzupVar instanceof zzwp ? ((zzwp) zzupVar).zzn() : zzupVar;
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final boolean zzo(zzlg zzlgVar) {
        if (this.zzc.isEmpty()) {
            return this.zzh.zzo(zzlgVar);
        }
        int size = this.zzc.size();
        for (int i11 = 0; i11 < size; i11++) {
            ((zzup) this.zzc.get(i11)).zzo(zzlgVar);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final boolean zzp() {
        return this.zzh.zzp();
    }
}
