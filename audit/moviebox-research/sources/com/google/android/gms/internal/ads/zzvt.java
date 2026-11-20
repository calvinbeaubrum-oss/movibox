package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzvt implements zzup, zzacx, zzzc, zzzh, zzwf {
    private static final Map zzb;
    private static final zzam zzc;
    private long zzA;
    private boolean zzB;
    private int zzC;
    private boolean zzD;
    private boolean zzE;
    private int zzF;
    private boolean zzG;
    private long zzH;
    private long zzI;
    private boolean zzJ;
    private int zzK;
    private boolean zzL;
    private boolean zzM;
    private final zzzb zzN;
    private final zzyx zzO;
    private final Uri zzd;
    private final zzgw zze;
    private final zzry zzf;
    private final zzva zzg;
    private final zzrs zzh;
    private final zzvp zzi;
    private final long zzj;
    private final zzzk zzk = new zzzk("ProgressiveMediaPeriod");
    private final zzvi zzl;
    private final zzeo zzm;
    private final Runnable zzn;
    private final Runnable zzo;
    private final Handler zzp;
    private final boolean zzq;

    @Nullable
    private zzuo zzr;

    @Nullable
    private zzaga zzs;
    private zzwg[] zzt;
    private zzvr[] zzu;
    private boolean zzv;
    private boolean zzw;
    private boolean zzx;
    private zzvs zzy;
    private zzadu zzz;

    static {
        HashMap map = new HashMap();
        map.put("Icy-MetaData", "1");
        zzb = Collections.unmodifiableMap(map);
        zzak zzakVar = new zzak();
        zzakVar.zzK("icy");
        zzakVar.zzW("application/x-icy");
        zzc = zzakVar.zzac();
    }

    public zzvt(Uri uri, zzgw zzgwVar, zzvi zzviVar, zzry zzryVar, zzrs zzrsVar, zzzb zzzbVar, zzva zzvaVar, zzvp zzvpVar, zzyx zzyxVar, @Nullable String str, int i11, long j11) {
        this.zzd = uri;
        this.zze = zzgwVar;
        this.zzf = zzryVar;
        this.zzh = zzrsVar;
        this.zzN = zzzbVar;
        this.zzg = zzvaVar;
        this.zzi = zzvpVar;
        this.zzO = zzyxVar;
        this.zzj = i11;
        this.zzl = zzviVar;
        this.zzA = j11;
        this.zzq = j11 != C.TIME_UNSET;
        this.zzm = new zzeo(zzel.zza);
        this.zzn = new Runnable() { // from class: com.google.android.gms.internal.ads.zzvk
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzU();
            }
        };
        this.zzo = new Runnable() { // from class: com.google.android.gms.internal.ads.zzvl
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzE();
            }
        };
        this.zzp = zzfy.zzw(null);
        this.zzu = new zzvr[0];
        this.zzt = new zzwg[0];
        this.zzI = C.TIME_UNSET;
        this.zzC = 1;
    }

    public static /* bridge */ /* synthetic */ void zzC(final zzvt zzvtVar) {
        zzvtVar.zzp.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzvj
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzF();
            }
        });
    }

    private final int zzQ() {
        int iZzd = 0;
        for (zzwg zzwgVar : this.zzt) {
            iZzd += zzwgVar.zzd();
        }
        return iZzd;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0015  */
    private final long zzR(boolean z11) {
        int i11 = 0;
        long jMax = Long.MIN_VALUE;
        while (true) {
            zzwg[] zzwgVarArr = this.zzt;
            if (i11 >= zzwgVarArr.length) {
                return jMax;
            }
            if (z11) {
                jMax = Math.max(jMax, zzwgVarArr[i11].zzh());
            } else {
                zzvs zzvsVar = this.zzy;
                zzvsVar.getClass();
                if (zzvsVar.zzc[i11]) {
                    jMax = Math.max(jMax, zzwgVarArr[i11].zzh());
                }
            }
            i11++;
        }
    }

    private final zzaea zzS(zzvr zzvrVar) {
        int length = this.zzt.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (zzvrVar.equals(this.zzu[i11])) {
                return this.zzt[i11];
            }
        }
        zzwg zzwgVar = new zzwg(this.zzO, this.zzf, this.zzh);
        zzwgVar.zzv(this);
        int i12 = length + 1;
        zzvr[] zzvrVarArr = (zzvr[]) Arrays.copyOf(this.zzu, i12);
        zzvrVarArr[length] = zzvrVar;
        int i13 = zzfy.zza;
        this.zzu = zzvrVarArr;
        zzwg[] zzwgVarArr = (zzwg[]) Arrays.copyOf(this.zzt, i12);
        zzwgVarArr[length] = zzwgVar;
        this.zzt = zzwgVarArr;
        return zzwgVar;
    }

    private final void zzT() {
        zzek.zzf(this.zzw);
        this.zzy.getClass();
        this.zzz.getClass();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzU() {
        int i11;
        if (this.zzM || this.zzw || !this.zzv || this.zzz == null) {
            return;
        }
        for (zzwg zzwgVar : this.zzt) {
            if (zzwgVar.zzi() == null) {
                return;
            }
        }
        this.zzm.zzc();
        int length = this.zzt.length;
        zzcz[] zzczVarArr = new zzcz[length];
        boolean[] zArr = new boolean[length];
        for (int i12 = 0; i12 < length; i12++) {
            zzam zzamVarZzi = this.zzt[i12].zzi();
            zzamVarZzi.getClass();
            String str = zzamVarZzi.zzm;
            boolean zZzg = zzcb.zzg(str);
            boolean z11 = zZzg || zzcb.zzh(str);
            zArr[i12] = z11;
            this.zzx = z11 | this.zzx;
            zzaga zzagaVar = this.zzs;
            if (zzagaVar != null) {
                if (zZzg || this.zzu[i12].zzb) {
                    zzby zzbyVar = zzamVarZzi.zzk;
                    zzby zzbyVar2 = zzbyVar == null ? new zzby(C.TIME_UNSET, zzagaVar) : zzbyVar.zzc(zzagaVar);
                    zzak zzakVarZzb = zzamVarZzi.zzb();
                    zzakVarZzb.zzP(zzbyVar2);
                    zzamVarZzi = zzakVarZzb.zzac();
                }
                if (zZzg && zzamVarZzi.zzg == -1 && zzamVarZzi.zzh == -1 && (i11 = zzagaVar.zza) != -1) {
                    zzak zzakVarZzb2 = zzamVarZzi.zzb();
                    zzakVarZzb2.zzx(i11);
                    zzamVarZzi = zzakVarZzb2.zzac();
                }
            }
            zzczVarArr[i12] = new zzcz(Integer.toString(i12), zzamVarZzi.zzc(this.zzf.zza(zzamVarZzi)));
        }
        this.zzy = new zzvs(new zzws(zzczVarArr), zArr);
        this.zzw = true;
        zzuo zzuoVar = this.zzr;
        zzuoVar.getClass();
        zzuoVar.zzi(this);
    }

    private final void zzV(int i11) {
        zzT();
        zzvs zzvsVar = this.zzy;
        boolean[] zArr = zzvsVar.zzd;
        if (zArr[i11]) {
            return;
        }
        zzam zzamVarZzb = zzvsVar.zza.zzb(i11).zzb(0);
        this.zzg.zzc(new zzun(1, zzcb.zzb(zzamVarZzb.zzm), zzamVarZzb, 0, null, zzfy.zzt(this.zzH), C.TIME_UNSET));
        zArr[i11] = true;
    }

    private final void zzW(int i11) {
        zzT();
        boolean[] zArr = this.zzy.zzb;
        if (this.zzJ && zArr[i11] && !this.zzt[i11].zzy(false)) {
            this.zzI = 0L;
            this.zzJ = false;
            this.zzE = true;
            this.zzH = 0L;
            this.zzK = 0;
            for (zzwg zzwgVar : this.zzt) {
                zzwgVar.zzq(false);
            }
            zzuo zzuoVar = this.zzr;
            zzuoVar.getClass();
            zzuoVar.zzg(this);
        }
    }

    private final void zzX() {
        zzvo zzvoVar = new zzvo(this, this.zzd, this.zze, this.zzl, this, this.zzm);
        if (this.zzw) {
            zzek.zzf(zzY());
            long j11 = this.zzA;
            if (j11 != C.TIME_UNSET && this.zzI > j11) {
                this.zzL = true;
                this.zzI = C.TIME_UNSET;
                return;
            }
            zzadu zzaduVar = this.zzz;
            zzaduVar.getClass();
            zzvo.zzf(zzvoVar, zzaduVar.zzg(this.zzI).zza.zzc, this.zzI);
            for (zzwg zzwgVar : this.zzt) {
                zzwgVar.zzu(this.zzI);
            }
            this.zzI = C.TIME_UNSET;
        }
        this.zzK = zzQ();
        long jZza = this.zzk.zza(zzvoVar, this, zzzb.zza(this.zzC));
        zzhb zzhbVar = zzvoVar.zzl;
        this.zzg.zzg(new zzui(zzvoVar.zzb, zzhbVar, zzhbVar.zza, Collections.emptyMap(), jZza, 0L, 0L), new zzun(1, -1, null, 0, null, zzfy.zzt(zzvoVar.zzk), zzfy.zzt(this.zzA)));
    }

    private final boolean zzY() {
        return this.zzI != C.TIME_UNSET;
    }

    private final boolean zzZ() {
        return this.zzE || zzY();
    }

    public static /* bridge */ /* synthetic */ long zzr(zzvt zzvtVar, boolean z11) {
        return zzvtVar.zzR(true);
    }

    @Override // com.google.android.gms.internal.ads.zzacx
    public final void zzD() {
        this.zzv = true;
        this.zzp.post(this.zzn);
    }

    public final /* synthetic */ void zzE() {
        if (this.zzM) {
            return;
        }
        zzuo zzuoVar = this.zzr;
        zzuoVar.getClass();
        zzuoVar.zzg(this);
    }

    public final /* synthetic */ void zzF() {
        this.zzG = true;
    }

    public final /* synthetic */ void zzG(zzadu zzaduVar) {
        this.zzz = this.zzs == null ? zzaduVar : new zzadt(C.TIME_UNSET, 0L);
        if (zzaduVar.zza() == C.TIME_UNSET && this.zzA != C.TIME_UNSET) {
            this.zzz = new zzvn(this, this.zzz);
        }
        this.zzA = this.zzz.zza();
        boolean z11 = false;
        if (!this.zzG && zzaduVar.zza() == C.TIME_UNSET) {
            z11 = true;
        }
        this.zzB = z11;
        this.zzC = true == z11 ? 7 : 1;
        this.zzi.zza(this.zzA, zzaduVar.zzh(), this.zzB);
        if (this.zzw) {
            return;
        }
        zzU();
    }

    public final void zzH() throws IOException {
        this.zzk.zzi(zzzb.zza(this.zzC));
    }

    public final void zzI(int i11) throws IOException {
        this.zzt[i11].zzn();
        zzH();
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final /* bridge */ /* synthetic */ void zzJ(zzzg zzzgVar, long j11, long j12, boolean z11) {
        zzvo zzvoVar = (zzvo) zzzgVar;
        zzhx zzhxVar = zzvoVar.zzd;
        zzui zzuiVar = new zzui(zzvoVar.zzb, zzvoVar.zzl, zzhxVar.zzh(), zzhxVar.zzi(), j11, j12, zzhxVar.zzg());
        long unused = zzvoVar.zzb;
        this.zzg.zzd(zzuiVar, new zzun(1, -1, null, 0, null, zzfy.zzt(zzvoVar.zzk), zzfy.zzt(this.zzA)));
        if (z11) {
            return;
        }
        for (zzwg zzwgVar : this.zzt) {
            zzwgVar.zzq(false);
        }
        if (this.zzF > 0) {
            zzuo zzuoVar = this.zzr;
            zzuoVar.getClass();
            zzuoVar.zzg(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final /* bridge */ /* synthetic */ void zzK(zzzg zzzgVar, long j11, long j12) {
        zzadu zzaduVar;
        if (this.zzA == C.TIME_UNSET && (zzaduVar = this.zzz) != null) {
            boolean zZzh = zzaduVar.zzh();
            long jZzR = zzR(true);
            long j13 = jZzR == Long.MIN_VALUE ? 0L : jZzR + 10000;
            this.zzA = j13;
            this.zzi.zza(j13, zZzh, this.zzB);
        }
        zzvo zzvoVar = (zzvo) zzzgVar;
        zzhx zzhxVar = zzvoVar.zzd;
        zzui zzuiVar = new zzui(zzvoVar.zzb, zzvoVar.zzl, zzhxVar.zzh(), zzhxVar.zzi(), j11, j12, zzhxVar.zzg());
        long unused = zzvoVar.zzb;
        this.zzg.zze(zzuiVar, new zzun(1, -1, null, 0, null, zzfy.zzt(zzvoVar.zzk), zzfy.zzt(this.zzA)));
        this.zzL = true;
        zzuo zzuoVar = this.zzr;
        zzuoVar.getClass();
        zzuoVar.zzg(this);
    }

    @Override // com.google.android.gms.internal.ads.zzzh
    public final void zzL() {
        for (zzwg zzwgVar : this.zzt) {
            zzwgVar.zzp();
        }
        this.zzl.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzwf
    public final void zzM(zzam zzamVar) {
        this.zzp.post(this.zzn);
    }

    public final void zzN() {
        if (this.zzw) {
            for (zzwg zzwgVar : this.zzt) {
                zzwgVar.zzo();
            }
        }
        this.zzk.zzj(this);
        this.zzp.removeCallbacksAndMessages(null);
        this.zzr = null;
        this.zzM = true;
    }

    @Override // com.google.android.gms.internal.ads.zzacx
    public final void zzO(final zzadu zzaduVar) {
        this.zzp.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzvm
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzG(zzaduVar);
            }
        });
    }

    public final boolean zzP(int i11) {
        return !zzZ() && this.zzt[i11].zzy(this.zzL);
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final long zza(long j11, zzmj zzmjVar) {
        zzT();
        if (!this.zzz.zzh()) {
            return 0L;
        }
        zzads zzadsVarZzg = this.zzz.zzg(j11);
        zzadv zzadvVar = zzadsVarZzg.zza;
        zzadv zzadvVar2 = zzadsVarZzg.zzb;
        long j12 = zzmjVar.zzf;
        if (j12 == 0) {
            if (zzmjVar.zzg == 0) {
                return j11;
            }
            j12 = 0;
        }
        long j13 = zzadvVar.zzb;
        int i11 = zzfy.zza;
        long j14 = j11 - j12;
        long j15 = zzmjVar.zzg;
        long j16 = j11 + j15;
        long j17 = j11 ^ j16;
        long j18 = j15 ^ j16;
        if (((j11 ^ j12) & (j11 ^ j14)) < 0) {
            j14 = Long.MIN_VALUE;
        }
        if ((j17 & j18) < 0) {
            j16 = Long.MAX_VALUE;
        }
        boolean z11 = j14 <= j13 && j13 <= j16;
        long j19 = zzadvVar2.zzb;
        boolean z12 = j14 <= j19 && j19 <= j16;
        if (z11 && z12) {
            if (Math.abs(j13 - j11) > Math.abs(j19 - j11)) {
                return j19;
            }
        } else if (!z11) {
            return z12 ? j19 : j14;
        }
        return j13;
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final long zzb() {
        long jZzR;
        zzT();
        if (this.zzL || this.zzF == 0) {
            return Long.MIN_VALUE;
        }
        if (zzY()) {
            return this.zzI;
        }
        if (this.zzx) {
            int length = this.zzt.length;
            jZzR = Long.MAX_VALUE;
            for (int i11 = 0; i11 < length; i11++) {
                zzvs zzvsVar = this.zzy;
                if (zzvsVar.zzb[i11] && zzvsVar.zzc[i11] && !this.zzt[i11].zzx()) {
                    jZzR = Math.min(jZzR, this.zzt[i11].zzh());
                }
            }
        } else {
            jZzR = Long.MAX_VALUE;
        }
        if (jZzR == Long.MAX_VALUE) {
            jZzR = zzR(false);
        }
        return jZzR == Long.MIN_VALUE ? this.zzH : jZzR;
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final long zzc() {
        return zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final long zzd() {
        if (!this.zzE) {
            return C.TIME_UNSET;
        }
        if (!this.zzL && zzQ() <= this.zzK) {
            return C.TIME_UNSET;
        }
        this.zzE = false;
        return this.zzH;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x005c  */
    /* JADX WARN: Code duplicated, block: B:28:0x0061 A[LOOP:1: B:27:0x005f->B:28:0x0061, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:30:0x006f  */
    /* JADX WARN: Code duplicated, block: B:32:0x0078 A[LOOP:2: B:31:0x0076->B:32:0x0078, LOOP_END] */
    /* JADX WARN: Instruction removed from duplicated block: B:26:0x005c, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:30:0x006f, please report this as an issue */
    @Override // com.google.android.gms.internal.ads.zzup
    public final long zze(long j11) {
        zzzk zzzkVar;
        int i11;
        zzT();
        boolean[] zArr = this.zzy.zzb;
        if (true != this.zzz.zzh()) {
            j11 = 0;
        }
        this.zzE = false;
        this.zzH = j11;
        if (zzY()) {
            this.zzI = j11;
            return j11;
        }
        if (this.zzC == 7) {
            this.zzJ = false;
            this.zzI = j11;
            this.zzL = false;
            zzzkVar = this.zzk;
            if (zzzkVar.zzl()) {
                zzzkVar.zzh();
                for (zzwg zzwgVar : this.zzt) {
                    zzwgVar.zzq(false);
                }
                break;
                break;
            }
            for (zzwg zzwgVar2 : this.zzt) {
                zzwgVar2.zzk();
            }
            this.zzk.zzg();
            break;
        }
        int length = this.zzt.length;
        for (int i12 = 0; i12 < length; i12++) {
            zzwg zzwgVar3 = this.zzt[i12];
            if (!(this.zzq ? zzwgVar3.zzz(zzwgVar3.zza()) : zzwgVar3.zzA(j11, false)) && (zArr[i12] || !this.zzx)) {
                this.zzJ = false;
                this.zzI = j11;
                this.zzL = false;
                zzzkVar = this.zzk;
                if (zzzkVar.zzl()) {
                    zzzkVar.zzh();
                    while (i11 < r2) {
                        zzwgVar.zzq(false);
                    }
                    break;
                }
                while (i < r2) {
                    zzwgVar2.zzk();
                }
                this.zzk.zzg();
                break;
            }
        }
        return j11;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0040  */
    /* JADX WARN: Code duplicated, block: B:19:0x0042 A[PHI: r12
  0x0042: PHI (r12v1 long) = (r12v0 long), (r12v5 long), (r12v0 long) binds: [B:14:0x0038, B:23:0x004b, B:17:0x003e] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.gms.internal.ads.zzup
    public final long zzf(zzyi[] zzyiVarArr, boolean[] zArr, zzwh[] zzwhVarArr, boolean[] zArr2, long j11) {
        boolean z11;
        zzyi zzyiVar;
        zzT();
        zzvs zzvsVar = this.zzy;
        zzws zzwsVar = zzvsVar.zza;
        boolean[] zArr3 = zzvsVar.zzc;
        int i11 = this.zzF;
        int i12 = 0;
        for (int i13 = 0; i13 < zzyiVarArr.length; i13++) {
            zzwh zzwhVar = zzwhVarArr[i13];
            if (zzwhVar != null && (zzyiVarArr[i13] == null || !zArr[i13])) {
                int i14 = ((zzvq) zzwhVar).zzb;
                zzek.zzf(zArr3[i14]);
                this.zzF--;
                zArr3[i14] = false;
                zzwhVarArr[i13] = null;
            }
        }
        if (this.zzq) {
            z11 = false;
        } else if (this.zzD) {
            if (i11 == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
        } else if (j11 != 0) {
            z11 = true;
        } else {
            j11 = 0;
            z11 = false;
        }
        for (int i15 = 0; i15 < zzyiVarArr.length; i15++) {
            if (zzwhVarArr[i15] == null && (zzyiVar = zzyiVarArr[i15]) != null) {
                zzek.zzf(zzyiVar.zzc() == 1);
                zzek.zzf(zzyiVar.zza(0) == 0);
                int iZza = zzwsVar.zza(zzyiVar.zze());
                zzek.zzf(!zArr3[iZza]);
                this.zzF++;
                zArr3[iZza] = true;
                zzwhVarArr[i15] = new zzvq(this, iZza);
                zArr2[i15] = true;
                if (!z11) {
                    zzwg zzwgVar = this.zzt[iZza];
                    z11 = (zzwgVar.zzb() == 0 || zzwgVar.zzA(j11, true)) ? false : true;
                }
            }
        }
        if (this.zzF == 0) {
            this.zzJ = false;
            this.zzE = false;
            if (this.zzk.zzl()) {
                zzwg[] zzwgVarArr = this.zzt;
                int length = zzwgVarArr.length;
                while (i12 < length) {
                    zzwgVarArr[i12].zzk();
                    i12++;
                }
                this.zzk.zzg();
            } else {
                for (zzwg zzwgVar2 : this.zzt) {
                    zzwgVar2.zzq(false);
                }
            }
        } else if (z11) {
            j11 = zze(j11);
            while (i12 < zzwhVarArr.length) {
                if (zzwhVarArr[i12] != null) {
                    zArr2[i12] = true;
                }
                i12++;
            }
        }
        this.zzD = true;
        return j11;
    }

    public final int zzg(int i11, zzlb zzlbVar, zzih zzihVar, int i12) {
        if (zzZ()) {
            return -3;
        }
        zzV(i11);
        int iZze = this.zzt[i11].zze(zzlbVar, zzihVar, i12, this.zzL);
        if (iZze == -3) {
            zzW(i11);
        }
        return iZze;
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final zzws zzh() {
        zzT();
        return this.zzy.zza;
    }

    public final int zzi(int i11, long j11) {
        if (zzZ()) {
            return 0;
        }
        zzV(i11);
        zzwg zzwgVar = this.zzt[i11];
        int iZzc = zzwgVar.zzc(j11, this.zzL);
        zzwgVar.zzw(iZzc);
        if (iZzc != 0) {
            return iZzc;
        }
        zzW(i11);
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final void zzj(long j11, boolean z11) {
        if (this.zzq) {
            return;
        }
        zzT();
        if (zzY()) {
            return;
        }
        boolean[] zArr = this.zzy.zzc;
        int length = this.zzt.length;
        for (int i11 = 0; i11 < length; i11++) {
            this.zzt[i11].zzj(j11, false, zArr[i11]);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final void zzk() throws IOException {
        zzH();
        if (this.zzL && !this.zzw) {
            throw zzcc.zza("Loading finished before preparation is complete.", null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzup
    public final void zzl(zzuo zzuoVar, long j11) {
        this.zzr = zzuoVar;
        this.zzm.zze();
        zzX();
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final void zzm(long j11) {
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final boolean zzo(zzlg zzlgVar) {
        if (this.zzL) {
            return false;
        }
        zzzk zzzkVar = this.zzk;
        if (zzzkVar.zzk() || this.zzJ) {
            return false;
        }
        if (this.zzw && this.zzF == 0) {
            return false;
        }
        boolean zZze = this.zzm.zze();
        if (zzzkVar.zzl()) {
            return zZze;
        }
        zzX();
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzup, com.google.android.gms.internal.ads.zzwj
    public final boolean zzp() {
        return this.zzk.zzl() && this.zzm.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzzc
    public final /* bridge */ /* synthetic */ zzze zzu(zzzg zzzgVar, long j11, long j12, IOException iOException, int i11) {
        long jMin;
        zzze zzzeVarZzb;
        zzadu zzaduVar;
        zzvo zzvoVar = (zzvo) zzzgVar;
        zzhx zzhxVar = zzvoVar.zzd;
        zzui zzuiVar = new zzui(zzvoVar.zzb, zzvoVar.zzl, zzhxVar.zzh(), zzhxVar.zzi(), j11, j12, zzhxVar.zzg());
        long unused = zzvoVar.zzk;
        int i12 = zzfy.zza;
        if ((iOException instanceof zzcc) || (iOException instanceof FileNotFoundException) || (iOException instanceof zzho) || (iOException instanceof zzzj)) {
            jMin = -9223372036854775807L;
            break;
        }
        Throwable cause = iOException;
        while (true) {
            if (cause == null) {
                jMin = Math.min((i11 - 1) * 1000, 5000);
                break;
            }
            if ((cause instanceof zzgx) && ((zzgx) cause).zza == 2008) {
                jMin = -9223372036854775807L;
                break;
            }
            cause = cause.getCause();
        }
        if (jMin == C.TIME_UNSET) {
            zzzeVarZzb = zzzk.zzd;
        } else {
            int iZzQ = zzQ();
            boolean z11 = iZzQ > this.zzK;
            if (this.zzG || !((zzaduVar = this.zzz) == null || zzaduVar.zza() == C.TIME_UNSET)) {
                this.zzK = iZzQ;
            } else {
                boolean z12 = this.zzw;
                if (!z12 || zzZ()) {
                    this.zzE = z12;
                    this.zzH = 0L;
                    this.zzK = 0;
                    for (zzwg zzwgVar : this.zzt) {
                        zzwgVar.zzq(false);
                    }
                    zzvo.zzf(zzvoVar, 0L, 0L);
                } else {
                    this.zzJ = true;
                    zzzeVarZzb = zzzk.zzc;
                }
            }
            zzzeVarZzb = zzzk.zzb(z11, jMin);
        }
        boolean zZzc = true ^ zzzeVarZzb.zzc();
        this.zzg.zzf(zzuiVar, new zzun(1, -1, null, 0, null, zzfy.zzt(zzvoVar.zzk), zzfy.zzt(this.zzA)), iOException, zZzc);
        if (zZzc) {
            long unused2 = zzvoVar.zzb;
        }
        return zzzeVarZzb;
    }

    public final zzaea zzv() {
        return zzS(new zzvr(0, true));
    }

    @Override // com.google.android.gms.internal.ads.zzacx
    public final zzaea zzw(int i11, int i12) {
        return zzS(new zzvr(i11, false));
    }
}
