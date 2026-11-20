package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Trace;
import android.util.Pair;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzkz implements Handler.Callback, zzuo, zzyn, zzlw, zziw, zzlz {
    private boolean zzB;
    private boolean zzE;
    private int zzF;

    @Nullable
    private zzky zzG;
    private long zzH;
    private int zzI;
    private boolean zzJ;

    @Nullable
    private zziz zzK;
    private final zzjk zzM;
    private final zziu zzN;
    private final zzmf[] zza;
    private final Set zzb;
    private final zzmh[] zzc;
    private final zzyo zzd;
    private final zzyp zze;
    private final zzlc zzf;
    private final zzyw zzg;
    private final zzew zzh;

    @Nullable
    private final HandlerThread zzi;
    private final Looper zzj;
    private final zzcw zzk;
    private final zzcu zzl;
    private final long zzm;
    private final zzix zzn;
    private final ArrayList zzo;
    private final zzel zzp;
    private final zzll zzq;
    private final zzlx zzr;
    private final long zzs;
    private zzmj zzt;
    private zzly zzu;
    private zzkx zzv;
    private boolean zzw;
    private boolean zzy;
    private boolean zzz;
    private int zzC = 0;
    private boolean zzD = false;
    private boolean zzx = false;
    private long zzL = C.TIME_UNSET;
    private long zzA = C.TIME_UNSET;

    public zzkz(zzmf[] zzmfVarArr, zzyo zzyoVar, zzyp zzypVar, zzlc zzlcVar, zzyw zzywVar, int i11, boolean z11, zzmp zzmpVar, zzmj zzmjVar, zziu zziuVar, long j11, boolean z12, Looper looper, zzel zzelVar, zzjk zzjkVar, zzpb zzpbVar, Looper looper2) {
        this.zzM = zzjkVar;
        this.zza = zzmfVarArr;
        this.zzd = zzyoVar;
        this.zze = zzypVar;
        this.zzf = zzlcVar;
        this.zzg = zzywVar;
        this.zzt = zzmjVar;
        this.zzN = zziuVar;
        this.zzs = j11;
        this.zzp = zzelVar;
        this.zzm = zzlcVar.zza();
        zzlcVar.zzf();
        zzly zzlyVarZzg = zzly.zzg(zzypVar);
        this.zzu = zzlyVarZzg;
        this.zzv = new zzkx(zzlyVarZzg);
        int length = zzmfVarArr.length;
        this.zzc = new zzmh[2];
        zzmg zzmgVarZzd = zzyoVar.zzd();
        for (int i12 = 0; i12 < 2; i12++) {
            zzmfVarArr[i12].zzu(i12, zzpbVar, zzelVar);
            this.zzc[i12] = zzmfVarArr[i12].zzl();
            this.zzc[i12].zzK(zzmgVarZzd);
        }
        this.zzn = new zzix(this, zzelVar);
        this.zzo = new ArrayList();
        this.zzb = Collections.newSetFromMap(new IdentityHashMap());
        this.zzk = new zzcw();
        this.zzl = new zzcu();
        zzyoVar.zzs(this, zzywVar);
        this.zzJ = true;
        zzew zzewVarZzb = zzelVar.zzb(looper, null);
        this.zzq = new zzll(zzmpVar, zzewVarZzb, new zzkr(this));
        this.zzr = new zzlx(this, zzmpVar, zzewVarZzb, zzpbVar);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.zzi = handlerThread;
        handlerThread.start();
        Looper looper3 = handlerThread.getLooper();
        this.zzj = looper3;
        this.zzh = zzelVar.zzb(looper3, this);
    }

    private final void zzA(zzmf zzmfVar) throws zziz {
        if (zzaf(zzmfVar)) {
            this.zzn.zzd(zzmfVar);
            zzam(zzmfVar);
            zzmfVar.zzq();
            this.zzF--;
        }
    }

    private final void zzB() throws zziz {
        int length = this.zza.length;
        zzC(new boolean[2], this.zzq.zzf().zzf());
    }

    private final void zzC(boolean[] zArr, long j11) throws zziz {
        zzli zzliVarZzf = this.zzq.zzf();
        zzyp zzypVarZzi = zzliVarZzf.zzi();
        int i11 = 0;
        while (true) {
            int length = this.zza.length;
            if (i11 >= 2) {
                break;
            }
            if (!zzypVarZzi.zzb(i11) && this.zzb.remove(this.zza[i11])) {
                this.zza[i11].zzH();
            }
            i11++;
        }
        int i12 = 0;
        while (true) {
            int length2 = this.zza.length;
            if (i12 >= 2) {
                zzliVarZzf.zzg = true;
                return;
            }
            if (zzypVarZzi.zzb(i12)) {
                boolean z11 = zArr[i12];
                zzmf zzmfVar = this.zza[i12];
                if (!zzaf(zzmfVar)) {
                    zzll zzllVar = this.zzq;
                    zzli zzliVarZzf2 = zzllVar.zzf();
                    boolean z12 = zzliVarZzf2 == zzllVar.zze();
                    zzyp zzypVarZzi2 = zzliVarZzf2.zzi();
                    zzmi zzmiVar = zzypVarZzi2.zzb[i12];
                    zzam[] zzamVarArrZzak = zzak(zzypVarZzi2.zzc[i12]);
                    boolean z13 = zzai() && this.zzu.zze == 3;
                    boolean z14 = !z11 && z13;
                    this.zzF++;
                    this.zzb.add(zzmfVar);
                    zzmfVar.zzr(zzmiVar, zzamVarArrZzak, zzliVarZzf2.zzc[i12], this.zzH, z14, z12, j11, zzliVarZzf2.zze(), zzliVarZzf2.zzf.zza);
                    zzmfVar.zzt(11, new zzks(this));
                    this.zzn.zze(zzmfVar);
                    if (z13) {
                        zzmfVar.zzN();
                    }
                }
            }
            i12++;
        }
    }

    private final void zzD(IOException iOException, int i11) {
        zzll zzllVar = this.zzq;
        zziz zzizVarZzc = zziz.zzc(iOException, i11);
        zzli zzliVarZze = zzllVar.zze();
        if (zzliVarZze != null) {
            zzizVarZzc = zzizVarZzc.zza(zzliVarZze.zzf.zza);
        }
        zzff.zzd("ExoPlayerImplInternal", "Playback error", zzizVarZzc);
        zzW(false, false);
        this.zzu = this.zzu.zzd(zzizVarZzc);
    }

    private final void zzE(boolean z11) {
        zzli zzliVarZzd = this.zzq.zzd();
        zzur zzurVar = zzliVarZzd == null ? this.zzu.zzb : zzliVarZzd.zzf.zza;
        boolean z12 = !this.zzu.zzk.equals(zzurVar);
        if (z12) {
            this.zzu = this.zzu.zza(zzurVar);
        }
        zzly zzlyVar = this.zzu;
        zzlyVar.zzp = zzliVarZzd == null ? zzlyVar.zzr : zzliVarZzd.zzc();
        this.zzu.zzq = zzt();
        if ((z12 || z11) && zzliVarZzd != null && zzliVarZzd.zzd) {
            zzZ(zzliVarZzd.zzf.zza, zzliVarZzd.zzh(), zzliVarZzd.zzi());
        }
    }

    /* JADX WARN: Code duplicated, block: B:192:0x0394  */
    /* JADX WARN: Code duplicated, block: B:193:0x039a  */
    /* JADX WARN: Code duplicated, block: B:196:0x03ae  */
    /* JADX WARN: Code duplicated, block: B:200:0x03b9  */
    /* JADX WARN: Code duplicated, block: B:202:0x03c3 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:208:0x03d6  */
    /* JADX WARN: Code duplicated, block: B:211:0x03e3  */
    /* JADX WARN: Code duplicated, block: B:215:0x040e  */
    private final void zzF(zzcx zzcxVar, boolean z11) throws Throwable {
        zzur zzurVar;
        zzcu zzcuVar;
        zzcw zzcwVar;
        int i11;
        long j11;
        Object obj;
        int iZzg;
        boolean z12;
        boolean z13;
        boolean z14;
        int iZzg2;
        boolean z15;
        long j12;
        boolean z16;
        long jZzv;
        boolean z17;
        boolean z18;
        boolean z19;
        zzur zzurVarZzh;
        long j13;
        int i12;
        boolean z21;
        int iZzg3;
        boolean z22;
        boolean z23;
        boolean z24;
        boolean z25;
        boolean z26;
        long j14;
        int i13;
        boolean z27;
        long j15;
        boolean z28;
        zzly zzlyVar = this.zzu;
        zzky zzkyVar = this.zzG;
        int i14 = this.zzC;
        boolean z29 = this.zzD;
        if (zzcxVar.zzo()) {
            zzurVarZzh = zzly.zzh();
            j13 = -9223372036854775807L;
            z17 = false;
            z18 = true;
            z19 = false;
            z16 = true;
            jZzv = 0;
            j11 = 0;
        } else {
            zzcu zzcuVar2 = this.zzl;
            zzur zzurVar2 = zzlyVar.zzb;
            Object obj2 = zzurVar2.zza;
            boolean zZzah = zzah(zzlyVar, zzcuVar2);
            long jLongValue = (zzlyVar.zzb.zzb() || zZzah) ? zzlyVar.zzc : zzlyVar.zzr;
            zzcw zzcwVar2 = this.zzk;
            if (zzkyVar != null) {
                zzurVar = zzurVar2;
                zzcuVar = zzcuVar2;
                Pair pairZzy = zzy(zzcxVar, zzkyVar, true, i14, z29, zzcwVar2, zzcuVar);
                if (pairZzy == null) {
                    iZzg3 = zzcxVar.zzg(z29);
                    jLongValue = jLongValue;
                    obj = obj2;
                    z23 = false;
                    z22 = false;
                    z24 = true;
                } else {
                    if (zzkyVar.zzc == C.TIME_UNSET) {
                        iZzg3 = zzcxVar.zzn(pairZzy.first, zzcuVar).zzd;
                        jLongValue = jLongValue;
                        obj = obj2;
                        z21 = false;
                    } else {
                        Object obj3 = pairZzy.first;
                        jLongValue = ((Long) pairZzy.second).longValue();
                        obj = obj3;
                        z21 = true;
                        iZzg3 = -1;
                    }
                    z22 = zzlyVar.zze == 4;
                    z23 = z21;
                    z24 = false;
                }
                z12 = z22;
                z13 = z24;
                iZzg = iZzg3;
                zzcwVar = zzcwVar2;
                i11 = -1;
                j11 = 0;
                z14 = z23;
            } else {
                zzurVar = zzurVar2;
                zzcuVar = zzcuVar2;
                zzcwVar = zzcwVar2;
                if (zzlyVar.zza.zzo()) {
                    iZzg = zzcxVar.zzg(z29);
                    obj = obj2;
                    z12 = false;
                    z13 = false;
                    i11 = -1;
                } else if (zzcxVar.zza(obj2) == -1) {
                    i11 = -1;
                    Object objZzf = zzf(zzcwVar, zzcuVar, i14, z29, obj2, zzlyVar.zza, zzcxVar);
                    if (objZzf == null) {
                        iZzg2 = zzcxVar.zzg(z29);
                        z15 = true;
                    } else {
                        iZzg2 = zzcxVar.zzn(objZzf, zzcuVar).zzd;
                        z15 = false;
                    }
                    iZzg = iZzg2;
                    z13 = z15;
                    obj = obj2;
                    z12 = false;
                } else {
                    i11 = -1;
                    if (jLongValue == C.TIME_UNSET) {
                        iZzg = zzcxVar.zzn(obj2, zzcuVar).zzd;
                        obj = obj2;
                        z12 = false;
                        z13 = false;
                    } else if (zZzah) {
                        zzlyVar.zza.zzn(zzurVar.zza, zzcuVar);
                        zzcwVar = zzcwVar;
                        j11 = 0;
                        if (zzlyVar.zza.zze(zzcuVar.zzd, zzcwVar, 0L).zzp == zzlyVar.zza.zza(zzurVar.zza)) {
                            Pair pairZzl = zzcxVar.zzl(zzcwVar, zzcuVar, zzcxVar.zzn(obj2, zzcuVar).zzd, jLongValue);
                            Object obj4 = pairZzl.first;
                            jLongValue = ((Long) pairZzl.second).longValue();
                            obj = obj4;
                        } else {
                            obj = obj2;
                            jLongValue = jLongValue;
                        }
                        iZzg = -1;
                        z12 = false;
                        z13 = false;
                        z14 = true;
                    } else {
                        zzcwVar = zzcwVar;
                        j11 = 0;
                        jLongValue = jLongValue;
                        iZzg = -1;
                        z12 = false;
                        z13 = false;
                        z14 = false;
                    }
                }
                z14 = false;
                j11 = 0;
            }
            if (iZzg != i11) {
                obj = obj2;
                Pair pairZzl2 = zzcxVar.zzl(zzcwVar, zzcuVar, iZzg, C.TIME_UNSET);
                Object obj5 = pairZzl2.first;
                long jLongValue2 = ((Long) pairZzl2.second).longValue();
                obj = obj5;
                j12 = jLongValue2;
                jLongValue = -9223372036854775807L;
            } else {
                obj = obj2;
                j12 = jLongValue;
            }
            zzur zzurVarZzi = this.zzq.zzi(zzcxVar, obj, j12);
            int i15 = zzurVarZzi.zze;
            boolean z30 = zzurVar.zza.equals(obj) && !zzurVar.zzb() && !zzurVarZzi.zzb() && (i15 == i11 || ((i12 = zzurVar.zze) != i11 && i15 >= i12));
            zzcu zzcuVarZzn = zzcxVar.zzn(obj, zzcuVar);
            if (!zZzah && jLongValue == jLongValue && zzurVar.zza.equals(zzurVarZzi.zza)) {
                if (zzurVar.zzb()) {
                    zzcuVarZzn.zzn(zzurVar.zzb);
                }
                if (zzurVarZzi.zzb()) {
                    zzcuVarZzn.zzn(zzurVarZzi.zzb);
                }
            }
            z16 = true;
            if (true == z30) {
                zzurVarZzi = zzurVar;
            }
            if (zzurVarZzi.zzb()) {
                if (zzurVarZzi.equals(zzurVar)) {
                    j12 = zzlyVar.zzr;
                } else {
                    zzcxVar.zzn(zzurVarZzi.zza, zzcuVar);
                    if (zzurVarZzi.zzc == zzcuVar.zze(zzurVarZzi.zzb)) {
                        zzcuVar.zzj();
                    }
                    j12 = j11;
                }
            }
            jZzv = j12;
            z17 = z12;
            z18 = z13;
            z19 = z14;
            zzurVarZzh = zzurVarZzi;
            j13 = jLongValue;
        }
        boolean z31 = (this.zzu.zzb.equals(zzurVarZzh) && jZzv == this.zzu.zzr) ? false : true;
        if (z18) {
            try {
                if (this.zzu.zze != z16) {
                    try {
                        zzU(4);
                    } catch (Throwable th2) {
                        th = th2;
                        z26 = z19;
                        z25 = false;
                        zzly zzlyVar2 = this.zzu;
                        zzcx zzcxVar2 = zzlyVar2.zza;
                        zzur zzurVar3 = zzlyVar2.zzb;
                        if (true != z26) {
                            j14 = C.TIME_UNSET;
                        } else {
                            j14 = jZzv;
                        }
                        zzab(zzcxVar, zzurVarZzh, zzcxVar2, zzurVar3, j14, false);
                        if (z31) {
                            zzly zzlyVar3 = this.zzu;
                            Object obj6 = zzlyVar3.zzb.zza;
                            zzcx zzcxVar3 = zzlyVar3.zza;
                            this.zzu = zzz(zzurVarZzh, jZzv, j13, this.zzu.zzd, (z31 || !z11 || zzcxVar3.zzo() || zzcxVar3.zzn(obj6, this.zzl).zzg) ? false : true, zzcxVar.zza(obj6) == -1 ? 4 : 3);
                        } else {
                            zzly zzlyVar4 = this.zzu;
                            Object obj7 = zzlyVar4.zzb.zza;
                            zzcx zzcxVar4 = zzlyVar4.zza;
                            this.zzu = zzz(zzurVarZzh, jZzv, j13, this.zzu.zzd, (z31 || !z11 || zzcxVar4.zzo() || zzcxVar4.zzn(obj7, this.zzl).zzg) ? false : true, zzcxVar.zza(obj7) == -1 ? 4 : 3);
                        }
                        zzN();
                        zzP(zzcxVar, this.zzu.zza);
                        this.zzu = this.zzu.zzf(zzcxVar);
                        if (!zzcxVar.zzo()) {
                            this.zzG = z25;
                        }
                        zzE(false);
                        throw th;
                    }
                }
                zzM(false, false, false, z16);
            } catch (Throwable th3) {
                th = th3;
                z26 = z19;
                z25 = false;
                zzly zzlyVar5 = this.zzu;
                zzcx zzcxVar5 = zzlyVar5.zza;
                zzur zzurVar4 = zzlyVar5.zzb;
                if (true != z26) {
                    j14 = C.TIME_UNSET;
                } else {
                    j14 = jZzv;
                }
                zzab(zzcxVar, zzurVarZzh, zzcxVar5, zzurVar4, j14, false);
                if (z31) {
                    zzly zzlyVar6 = this.zzu;
                    Object obj8 = zzlyVar6.zzb.zza;
                    zzcx zzcxVar6 = zzlyVar6.zza;
                    this.zzu = zzz(zzurVarZzh, jZzv, j13, this.zzu.zzd, (z31 || !z11 || zzcxVar6.zzo() || zzcxVar6.zzn(obj8, this.zzl).zzg) ? false : true, zzcxVar.zza(obj8) == -1 ? 4 : 3);
                } else {
                    zzly zzlyVar7 = this.zzu;
                    Object obj9 = zzlyVar7.zzb.zza;
                    zzcx zzcxVar7 = zzlyVar7.zza;
                    this.zzu = zzz(zzurVarZzh, jZzv, j13, this.zzu.zzd, (z31 || !z11 || zzcxVar7.zzo() || zzcxVar7.zzn(obj9, this.zzl).zzg) ? false : true, zzcxVar.zza(obj9) == -1 ? 4 : 3);
                }
                zzN();
                zzP(zzcxVar, this.zzu.zza);
                this.zzu = this.zzu.zzf(zzcxVar);
                if (!zzcxVar.zzo()) {
                    this.zzG = z25;
                }
                zzE(false);
                throw th;
            }
        }
        zzmf[] zzmfVarArr = this.zza;
        int length = zzmfVarArr.length;
        int i16 = 0;
        while (true) {
            i13 = 2;
            if (i16 < 2) {
                zzmfVarArr[i16].zzM(zzcxVar);
                i16++;
            } else {
                try {
                    break;
                } catch (Throwable th4) {
                    th = th4;
                }
            }
        }
        if (z31) {
            z27 = z19;
            if (!zzcxVar.zzo()) {
                for (zzli zzliVarZze = this.zzq.zze(); zzliVarZze != null; zzliVarZze = zzliVarZze.zzg()) {
                    if (zzliVarZze.zzf.zza.equals(zzurVarZzh)) {
                        zzliVarZze.zzf = this.zzq.zzh(zzcxVar, zzliVarZze.zzf);
                        zzliVarZze.zzq();
                    }
                }
                jZzv = zzv(zzurVarZzh, jZzv, z17);
            }
        } else {
            try {
                zzll zzllVar = this.zzq;
                long j16 = this.zzH;
                zzli zzliVarZzf = zzllVar.zzf();
                if (zzliVarZzf == null) {
                    z27 = z19;
                    j15 = j11;
                } else {
                    long jZze = zzliVarZzf.zze();
                    z27 = z19;
                    if (zzliVarZzf.zzd) {
                        long jMax = jZze;
                        int i17 = 0;
                        while (true) {
                            try {
                                zzmf[] zzmfVarArr2 = this.zza;
                                int length2 = zzmfVarArr2.length;
                                if (i17 >= i13) {
                                    j15 = jMax;
                                    break;
                                }
                                if (zzaf(zzmfVarArr2[i17]) && this.zza[i17].zzo() == zzliVarZzf.zzc[i17]) {
                                    long jZzbh = this.zza[i17].zzbh();
                                    j15 = Long.MIN_VALUE;
                                    if (jZzbh == Long.MIN_VALUE) {
                                        break;
                                    } else {
                                        jMax = Math.max(jZzbh, jMax);
                                    }
                                }
                                i17++;
                                i13 = 2;
                            } catch (Throwable th5) {
                                th = th5;
                                z26 = z27;
                                z25 = false;
                                zzly zzlyVar8 = this.zzu;
                                zzcx zzcxVar8 = zzlyVar8.zza;
                                zzur zzurVar5 = zzlyVar8.zzb;
                                if (true != z26) {
                                    j14 = C.TIME_UNSET;
                                } else {
                                    j14 = jZzv;
                                }
                                zzab(zzcxVar, zzurVarZzh, zzcxVar8, zzurVar5, j14, false);
                                if (z31 || j13 != this.zzu.zzc) {
                                    zzly zzlyVar9 = this.zzu;
                                    Object obj10 = zzlyVar9.zzb.zza;
                                    zzcx zzcxVar9 = zzlyVar9.zza;
                                    this.zzu = zzz(zzurVarZzh, jZzv, j13, this.zzu.zzd, (z31 || !z11 || zzcxVar9.zzo() || zzcxVar9.zzn(obj10, this.zzl).zzg) ? false : true, zzcxVar.zza(obj10) == -1 ? 4 : 3);
                                }
                                zzN();
                                zzP(zzcxVar, this.zzu.zza);
                                this.zzu = this.zzu.zzf(zzcxVar);
                                if (!zzcxVar.zzo()) {
                                    this.zzG = z25;
                                }
                                zzE(false);
                                throw th;
                            }
                        }
                    } else {
                        j15 = jZze;
                    }
                }
                if (!zzllVar.zzp(zzcxVar, j16, j15)) {
                    zzR(false);
                }
            } catch (Throwable th6) {
                th = th6;
                boolean z32 = z19;
                z26 = z32;
                z25 = false;
                zzly zzlyVar10 = this.zzu;
                zzcx zzcxVar10 = zzlyVar10.zza;
                zzur zzurVar6 = zzlyVar10.zzb;
                if (true != z26) {
                    j14 = C.TIME_UNSET;
                } else {
                    j14 = jZzv;
                }
                zzab(zzcxVar, zzurVarZzh, zzcxVar10, zzurVar6, j14, false);
                if (z31) {
                    zzly zzlyVar11 = this.zzu;
                    Object obj11 = zzlyVar11.zzb.zza;
                    zzcx zzcxVar11 = zzlyVar11.zza;
                    this.zzu = zzz(zzurVarZzh, jZzv, j13, this.zzu.zzd, (z31 || !z11 || zzcxVar11.zzo() || zzcxVar11.zzn(obj11, this.zzl).zzg) ? false : true, zzcxVar.zza(obj11) == -1 ? 4 : 3);
                } else {
                    zzly zzlyVar12 = this.zzu;
                    Object obj12 = zzlyVar12.zzb.zza;
                    zzcx zzcxVar12 = zzlyVar12.zza;
                    this.zzu = zzz(zzurVarZzh, jZzv, j13, this.zzu.zzd, (z31 || !z11 || zzcxVar12.zzo() || zzcxVar12.zzn(obj12, this.zzl).zzg) ? false : true, zzcxVar.zza(obj12) == -1 ? 4 : 3);
                }
                zzN();
                zzP(zzcxVar, this.zzu.zza);
                this.zzu = this.zzu.zzf(zzcxVar);
                if (!zzcxVar.zzo()) {
                    this.zzG = z25;
                }
                zzE(false);
                throw th;
            }
        }
        zzly zzlyVar13 = this.zzu;
        zzab(zzcxVar, zzurVarZzh, zzlyVar13.zza, zzlyVar13.zzb, true != z27 ? C.TIME_UNSET : jZzv, false);
        if (z31 || j13 != this.zzu.zzc) {
            zzly zzlyVar14 = this.zzu;
            Object obj13 = zzlyVar14.zzb.zza;
            zzcx zzcxVar13 = zzlyVar14.zza;
            z28 = false;
            this.zzu = zzz(zzurVarZzh, jZzv, j13, this.zzu.zzd, z31 && z11 && !zzcxVar13.zzo() && !zzcxVar13.zzn(obj13, this.zzl).zzg, zzcxVar.zza(obj13) == -1 ? 4 : 3);
        } else {
            z28 = false;
        }
        zzN();
        zzP(zzcxVar, this.zzu.zza);
        this.zzu = this.zzu.zzf(zzcxVar);
        if (!zzcxVar.zzo()) {
            this.zzG = null;
        }
        zzE(z28);
    }

    private final void zzG(zzcg zzcgVar, boolean z11) throws zziz {
        zzH(zzcgVar, zzcgVar.zzc, true, z11);
    }

    private final void zzH(zzcg zzcgVar, float f11, boolean z11, boolean z12) throws zziz {
        int i11;
        zzkz zzkzVar = this;
        if (z11) {
            if (z12) {
                zzkzVar.zzv.zza(1);
            }
            zzly zzlyVar = zzkzVar.zzu;
            zzkzVar = this;
            zzkzVar.zzu = new zzly(zzlyVar.zza, zzlyVar.zzb, zzlyVar.zzc, zzlyVar.zzd, zzlyVar.zze, zzlyVar.zzf, zzlyVar.zzg, zzlyVar.zzh, zzlyVar.zzi, zzlyVar.zzj, zzlyVar.zzk, zzlyVar.zzl, zzlyVar.zzm, zzcgVar, zzlyVar.zzp, zzlyVar.zzq, zzlyVar.zzr, zzlyVar.zzs, false);
        }
        float f12 = zzcgVar.zzc;
        zzli zzliVarZze = zzkzVar.zzq.zze();
        while (true) {
            i11 = 0;
            if (zzliVarZze == null) {
                break;
            }
            zzyi[] zzyiVarArr = zzliVarZze.zzi().zzc;
            int length = zzyiVarArr.length;
            while (i11 < length) {
                zzyi zzyiVar = zzyiVarArr[i11];
                i11++;
            }
            zzliVarZze = zzliVarZze.zzg();
        }
        zzmf[] zzmfVarArr = zzkzVar.zza;
        int length2 = zzmfVarArr.length;
        while (i11 < 2) {
            zzmf zzmfVar = zzmfVarArr[i11];
            if (zzmfVar != null) {
                zzmfVar.zzL(f11, zzcgVar.zzc);
            }
            i11++;
        }
    }

    private final void zzI() {
        long jZze;
        long jZze2;
        boolean zZzg = false;
        if (zzae()) {
            zzli zzliVarZzd = this.zzq.zzd();
            long jZzu = zzu(zzliVarZzd.zzd());
            if (zzliVarZzd == this.zzq.zze()) {
                jZze = this.zzH;
                jZze2 = zzliVarZzd.zze();
            } else {
                jZze = this.zzH - zzliVarZzd.zze();
                jZze2 = zzliVarZzd.zzf.zzb;
            }
            long j11 = jZze - jZze2;
            boolean zZzg2 = this.zzf.zzg(j11, jZzu, this.zzn.zzc().zzc);
            if (zZzg2 || jZzu >= 500000 || this.zzm <= 0) {
                zZzg = zZzg2;
            } else {
                this.zzq.zze().zza.zzj(this.zzu.zzr, false);
                zZzg = this.zzf.zzg(j11, jZzu, this.zzn.zzc().zzc);
            }
        }
        this.zzB = zZzg;
        if (zZzg) {
            this.zzq.zzd().zzk(this.zzH, this.zzn.zzc().zzc, this.zzA);
        }
        zzY();
    }

    private final void zzJ() {
        this.zzv.zzc(this.zzu);
        if (this.zzv.zzg) {
            zzjk zzjkVar = this.zzM;
            zzjkVar.zza.zzT(this.zzv);
            this.zzv = new zzkx(this.zzu);
        }
    }

    private final void zzK() throws zziz {
        int i11;
        float f11 = this.zzn.zzc().zzc;
        zzll zzllVar = this.zzq;
        zzli zzliVarZzf = zzllVar.zzf();
        boolean z11 = true;
        for (zzli zzliVarZze = zzllVar.zze(); zzliVarZze != null && zzliVarZze.zzd; zzliVarZze = zzliVarZze.zzg()) {
            zzyp zzypVarZzj = zzliVarZze.zzj(f11, this.zzu.zza);
            zzyp zzypVarZzi = zzliVarZze.zzi();
            boolean z12 = false;
            if (zzypVarZzi != null) {
                if (zzypVarZzi.zzc.length == zzypVarZzj.zzc.length) {
                    int i12 = 0;
                    while (true) {
                        if (i12 >= zzypVarZzj.zzc.length) {
                            if (zzliVarZze != zzliVarZzf) {
                                z12 = true;
                            }
                            z11 &= z12;
                        } else if (zzypVarZzj.zza(zzypVarZzi, i12)) {
                            i12++;
                        }
                    }
                }
            }
            if (z11) {
                zzll zzllVar2 = this.zzq;
                zzli zzliVarZze2 = zzllVar2.zze();
                boolean zZzn = zzllVar2.zzn(zzliVarZze2);
                int length = this.zza.length;
                boolean[] zArr = new boolean[2];
                long jZzb = zzliVarZze2.zzb(zzypVarZzj, this.zzu.zzr, zZzn, zArr);
                zzly zzlyVar = this.zzu;
                boolean z13 = (zzlyVar.zze == 4 || jZzb == zzlyVar.zzr) ? false : true;
                zzly zzlyVar2 = this.zzu;
                i11 = 2;
                this.zzu = zzz(zzlyVar2.zzb, jZzb, zzlyVar2.zzc, zzlyVar2.zzd, z13, 5);
                if (z13) {
                    zzO(jZzb);
                }
                int length2 = this.zza.length;
                boolean[] zArr2 = new boolean[2];
                int i13 = 0;
                while (true) {
                    zzmf[] zzmfVarArr = this.zza;
                    int length3 = zzmfVarArr.length;
                    if (i13 >= 2) {
                        break;
                    }
                    zzmf zzmfVar = zzmfVarArr[i13];
                    boolean zZzaf = zzaf(zzmfVar);
                    zArr2[i13] = zZzaf;
                    zzwh zzwhVar = zzliVarZze2.zzc[i13];
                    if (zZzaf) {
                        if (zzwhVar != zzmfVar.zzo()) {
                            zzA(zzmfVar);
                        } else if (zArr[i13]) {
                            zzmfVar.zzI(this.zzH);
                        }
                    }
                    i13++;
                }
                zzC(zArr2, this.zzH);
            } else {
                i11 = 2;
                this.zzq.zzn(zzliVarZze);
                if (zzliVarZze.zzd) {
                    zzliVarZze.zza(zzypVarZzj, Math.max(zzliVarZze.zzf.zzb, this.zzH - zzliVarZze.zze()), false);
                }
            }
            zzE(true);
            if (this.zzu.zze != 4) {
                zzI();
                zzaa();
                this.zzh.zzi(i11);
                return;
            }
            return;
        }
    }

    private final void zzL() throws zziz {
        zzK();
        zzR(true);
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00a6 A[PHI: r2 r6 r8
  0x00a6: PHI (r2v2 com.google.android.gms.internal.ads.zzur) = (r2v1 com.google.android.gms.internal.ads.zzur), (r2v11 com.google.android.gms.internal.ads.zzur) binds: [B:30:0x007b, B:32:0x00a0] A[DONT_GENERATE, DONT_INLINE]
  0x00a6: PHI (r6v3 long) = (r6v2 long), (r6v9 long) binds: [B:30:0x007b, B:32:0x00a0] A[DONT_GENERATE, DONT_INLINE]
  0x00a6: PHI (r8v3 long) = (r8v2 long), (r8v5 long) binds: [B:30:0x007b, B:32:0x00a0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:44:0x00f1 A[PHI: r0
  0x00f1: PHI (r0v11 com.google.android.gms.internal.ads.zzcx) = 
  (r0v10 com.google.android.gms.internal.ads.zzcx)
  (r0v10 com.google.android.gms.internal.ads.zzcx)
  (r0v15 com.google.android.gms.internal.ads.zzcx)
  (r0v15 com.google.android.gms.internal.ads.zzcx)
 binds: [B:36:0x00b5, B:38:0x00b9, B:40:0x00ca, B:42:0x00e2] A[DONT_GENERATE, DONT_INLINE]] */
    private final void zzM(boolean z11, boolean z12, boolean z13, boolean z14) {
        long j11;
        long j12;
        zzcx zzcxVar;
        zzur zzurVar;
        this.zzh.zzf(2);
        this.zzK = null;
        boolean z15 = true;
        zzac(false, true);
        this.zzn.zzi();
        this.zzH = 1000000000000L;
        zzmf[] zzmfVarArr = this.zza;
        int length = zzmfVarArr.length;
        for (int i11 = 0; i11 < 2; i11++) {
            try {
                zzA(zzmfVarArr[i11]);
            } catch (zziz | RuntimeException e11) {
                zzff.zzd("ExoPlayerImplInternal", "Disable failed.", e11);
            }
        }
        if (z11) {
            zzmf[] zzmfVarArr2 = this.zza;
            int length2 = zzmfVarArr2.length;
            for (int i12 = 0; i12 < 2; i12++) {
                zzmf zzmfVar = zzmfVarArr2[i12];
                if (this.zzb.remove(zzmfVar)) {
                    try {
                        zzmfVar.zzH();
                    } catch (RuntimeException e12) {
                        zzff.zzd("ExoPlayerImplInternal", "Reset failed.", e12);
                    }
                }
            }
        }
        this.zzF = 0;
        zzly zzlyVar = this.zzu;
        zzur zzurVar2 = zzlyVar.zzb;
        long jLongValue = zzlyVar.zzr;
        long j13 = (this.zzu.zzb.zzb() || zzah(this.zzu, this.zzl)) ? this.zzu.zzc : this.zzu.zzr;
        if (z12) {
            this.zzG = null;
            Pair pairZzx = zzx(this.zzu.zza);
            zzurVar2 = (zzur) pairZzx.first;
            jLongValue = ((Long) pairZzx.second).longValue();
            boolean zEquals = zzurVar2.equals(this.zzu.zzb);
            j13 = C.TIME_UNSET;
            if (zEquals) {
                j11 = jLongValue;
                j12 = j13;
                z15 = false;
            } else {
                j11 = jLongValue;
                j12 = -9223372036854775807L;
            }
        } else {
            j11 = jLongValue;
            j12 = j13;
            z15 = false;
        }
        this.zzq.zzj();
        this.zzB = false;
        zzcx zzcxVarZzx = this.zzu.zza;
        if (z13 && (zzcxVarZzx instanceof zzmd)) {
            zzcxVarZzx = ((zzmd) zzcxVarZzx).zzx(this.zzr.zzq());
            if (zzurVar2.zzb != -1) {
                zzcxVarZzx.zzn(zzurVar2.zza, this.zzl);
                zzcu zzcuVar = this.zzl;
                zzcw zzcwVar = this.zzk;
                zzcxVarZzx.zze(zzcuVar.zzd, zzcwVar, 0L);
                if (zzcwVar.zzb()) {
                    zzcxVar = zzcxVarZzx;
                    zzurVar = new zzur(zzurVar2.zza, zzurVar2.zzd);
                } else {
                    zzcxVar = zzcxVarZzx;
                    zzurVar = zzurVar2;
                }
            } else {
                zzcxVar = zzcxVarZzx;
                zzurVar = zzurVar2;
            }
        } else {
            zzcxVar = zzcxVarZzx;
            zzurVar = zzurVar2;
        }
        zzly zzlyVar2 = this.zzu;
        int i13 = zzlyVar2.zze;
        zziz zzizVar = z14 ? null : zzlyVar2.zzf;
        zzws zzwsVar = z15 ? zzws.zza : zzlyVar2.zzh;
        zzyp zzypVar = z15 ? this.zze : zzlyVar2.zzi;
        List listZzl = z15 ? zzgaa.zzl() : zzlyVar2.zzj;
        zzly zzlyVar3 = this.zzu;
        this.zzu = new zzly(zzcxVar, zzurVar, j12, j11, i13, zzizVar, false, zzwsVar, zzypVar, listZzl, zzurVar, zzlyVar3.zzl, zzlyVar3.zzm, zzlyVar3.zzn, j11, 0L, j11, 0L, false);
        if (z13) {
            this.zzr.zzh();
        }
    }

    private final void zzN() {
        zzli zzliVarZze = this.zzq.zze();
        boolean z11 = false;
        if (zzliVarZze != null && zzliVarZze.zzf.zzh && this.zzx) {
            z11 = true;
        }
        this.zzy = z11;
    }

    private final void zzO(long j11) throws zziz {
        zzli zzliVarZze = this.zzq.zze();
        long jZze = j11 + (zzliVarZze == null ? 1000000000000L : zzliVarZze.zze());
        this.zzH = jZze;
        this.zzn.zzf(jZze);
        zzmf[] zzmfVarArr = this.zza;
        int length = zzmfVarArr.length;
        for (int i11 = 0; i11 < 2; i11++) {
            zzmf zzmfVar = zzmfVarArr[i11];
            if (zzaf(zzmfVar)) {
                zzmfVar.zzI(this.zzH);
            }
        }
        for (zzli zzliVarZze2 = this.zzq.zze(); zzliVarZze2 != null; zzliVarZze2 = zzliVarZze2.zzg()) {
            for (zzyi zzyiVar : zzliVarZze2.zzi().zzc) {
            }
        }
    }

    private final void zzP(zzcx zzcxVar, zzcx zzcxVar2) {
        if (zzcxVar.zzo() && zzcxVar2.zzo()) {
            return;
        }
        int size = this.zzo.size() - 1;
        if (size < 0) {
            Collections.sort(this.zzo);
        } else {
            Object obj = ((zzkw) this.zzo.get(size)).zzb;
            int i11 = zzfy.zza;
            throw null;
        }
    }

    private final void zzQ(long j11, long j12) {
        this.zzh.zzj(2, j11 + j12);
    }

    private final void zzR(boolean z11) throws zziz {
        zzur zzurVar = this.zzq.zze().zzf.zza;
        long jZzw = zzw(zzurVar, this.zzu.zzr, true, false);
        if (jZzw != this.zzu.zzr) {
            zzly zzlyVar = this.zzu;
            this.zzu = zzz(zzurVar, jZzw, zzlyVar.zzc, zzlyVar.zzd, z11, 5);
        }
    }

    private final void zzS(zzcg zzcgVar) {
        this.zzh.zzf(16);
        this.zzn.zzg(zzcgVar);
    }

    private final void zzT(boolean z11, int i11, boolean z12, int i12) throws zziz {
        this.zzv.zza(z12 ? 1 : 0);
        this.zzv.zzb(i12);
        this.zzu = this.zzu.zzc(z11, i11);
        zzac(false, false);
        for (zzli zzliVarZze = this.zzq.zze(); zzliVarZze != null; zzliVarZze = zzliVarZze.zzg()) {
            for (zzyi zzyiVar : zzliVarZze.zzi().zzc) {
            }
        }
        if (!zzai()) {
            zzX();
            zzaa();
            return;
        }
        int i13 = this.zzu.zze;
        if (i13 == 3) {
            zzV();
            this.zzh.zzi(2);
        } else if (i13 == 2) {
            this.zzh.zzi(2);
        }
    }

    private final void zzU(int i11) {
        zzly zzlyVar = this.zzu;
        if (zzlyVar.zze != i11) {
            if (i11 != 2) {
                this.zzL = C.TIME_UNSET;
            }
            this.zzu = zzlyVar.zze(i11);
        }
    }

    private final void zzV() throws zziz {
        zzac(false, false);
        this.zzn.zzh();
        zzmf[] zzmfVarArr = this.zza;
        int length = zzmfVarArr.length;
        for (int i11 = 0; i11 < 2; i11++) {
            zzmf zzmfVar = zzmfVarArr[i11];
            if (zzaf(zzmfVar)) {
                zzmfVar.zzN();
            }
        }
    }

    private final void zzW(boolean z11, boolean z12) {
        zzM(z11 || !this.zzE, false, true, false);
        this.zzv.zza(z12 ? 1 : 0);
        this.zzf.zzd();
        zzU(1);
    }

    private final void zzX() throws zziz {
        this.zzn.zzi();
        zzmf[] zzmfVarArr = this.zza;
        int length = zzmfVarArr.length;
        for (int i11 = 0; i11 < 2; i11++) {
            zzmf zzmfVar = zzmfVarArr[i11];
            if (zzaf(zzmfVar)) {
                zzam(zzmfVar);
            }
        }
    }

    private final void zzY() {
        zzli zzliVarZzd = this.zzq.zzd();
        boolean z11 = this.zzB || (zzliVarZzd != null && zzliVarZzd.zza.zzp());
        zzly zzlyVar = this.zzu;
        if (z11 != zzlyVar.zzg) {
            this.zzu = new zzly(zzlyVar.zza, zzlyVar.zzb, zzlyVar.zzc, zzlyVar.zzd, zzlyVar.zze, zzlyVar.zzf, z11, zzlyVar.zzh, zzlyVar.zzi, zzlyVar.zzj, zzlyVar.zzk, zzlyVar.zzl, zzlyVar.zzm, zzlyVar.zzn, zzlyVar.zzp, zzlyVar.zzq, zzlyVar.zzr, zzlyVar.zzs, false);
        }
    }

    private final void zzZ(zzur zzurVar, zzws zzwsVar, zzyp zzypVar) {
        zzcx zzcxVar = this.zzu.zza;
        zzyi[] zzyiVarArr = zzypVar.zzc;
        this.zzf.zze(zzcxVar, zzurVar, this.zza, zzwsVar, zzyiVarArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00ad, code lost:
    
        r5 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void zzaa() throws zziz {
        zzkw zzkwVar;
        zzli zzliVarZze = this.zzq.zze();
        if (zzliVarZze == null) {
            return;
        }
        long jZzd = zzliVarZze.zzd ? zzliVarZze.zza.zzd() : -9223372036854775807L;
        if (jZzd != C.TIME_UNSET) {
            if (!zzliVarZze.zzr()) {
                this.zzq.zzn(zzliVarZze);
                zzE(false);
                zzI();
            }
            zzO(jZzd);
            if (jZzd != this.zzu.zzr) {
                zzly zzlyVar = this.zzu;
                this.zzu = zzz(zzlyVar.zzb, jZzd, zzlyVar.zzc, jZzd, true, 5);
            }
        } else {
            long jZzb = this.zzn.zzb(zzliVarZze != this.zzq.zzf());
            this.zzH = jZzb;
            long jZze = jZzb - zzliVarZze.zze();
            long j11 = this.zzu.zzr;
            if (!this.zzo.isEmpty() && !this.zzu.zzb.zzb()) {
                if (this.zzJ) {
                    j11--;
                    this.zzJ = false;
                }
                zzly zzlyVar2 = this.zzu;
                int iZza = zzlyVar2.zza.zza(zzlyVar2.zzb.zza);
                int iMin = Math.min(this.zzI, this.zzo.size());
                if (iMin > 0) {
                    zzkwVar = (zzkw) this.zzo.get(iMin - 1);
                    while (zzkwVar != null && (iZza < 0 || (iZza == 0 && j11 < 0))) {
                        int i11 = iMin - 1;
                        if (i11 > 0) {
                            zzkwVar = (zzkw) this.zzo.get(iMin - 2);
                            iMin = i11;
                        } else {
                            iMin = i11;
                            zzkwVar = null;
                        }
                    }
                    if (iMin < this.zzo.size()) {
                    }
                    this.zzI = iMin;
                } else {
                    zzkwVar = null;
                }
            }
            if (this.zzn.zzj()) {
                zzly zzlyVar3 = this.zzu;
                this.zzu = zzz(zzlyVar3.zzb, jZze, zzlyVar3.zzc, jZze, true, 6);
            } else {
                zzly zzlyVar4 = this.zzu;
                zzlyVar4.zzr = jZze;
                zzlyVar4.zzs = SystemClock.elapsedRealtime();
            }
        }
        this.zzu.zzp = this.zzq.zzd().zzc();
        this.zzu.zzq = zzt();
        zzly zzlyVar5 = this.zzu;
        if (zzlyVar5.zzl && zzlyVar5.zze == 3 && zzaj(zzlyVar5.zza, zzlyVar5.zzb)) {
            zzly zzlyVar6 = this.zzu;
            if (zzlyVar6.zzn.zzc == 1.0f) {
                float fZza = this.zzN.zza(zzs(zzlyVar6.zza, zzlyVar6.zzb.zza, zzlyVar6.zzr), zzt());
                if (this.zzn.zzc().zzc != fZza) {
                    zzS(new zzcg(fZza, this.zzu.zzn.zzd));
                    zzH(this.zzu.zzn, this.zzn.zzc().zzc, false, false);
                }
            }
        }
    }

    private final void zzab(zzcx zzcxVar, zzur zzurVar, zzcx zzcxVar2, zzur zzurVar2, long j11, boolean z11) throws zziz {
        if (!zzaj(zzcxVar, zzurVar)) {
            zzcg zzcgVar = zzurVar.zzb() ? zzcg.zza : this.zzu.zzn;
            if (this.zzn.zzc().equals(zzcgVar)) {
                return;
            }
            zzS(zzcgVar);
            zzH(this.zzu.zzn, zzcgVar.zzc, false, false);
            return;
        }
        zzcxVar.zze(zzcxVar.zzn(zzurVar.zza, this.zzl).zzd, this.zzk, 0L);
        zziu zziuVar = this.zzN;
        zzbf zzbfVar = this.zzk.zzl;
        int i11 = zzfy.zza;
        zziuVar.zzd(zzbfVar);
        if (j11 != C.TIME_UNSET) {
            this.zzN.zze(zzs(zzcxVar, zzurVar.zza, j11));
            return;
        }
        if (!zzfy.zzF(!zzcxVar2.zzo() ? zzcxVar2.zze(zzcxVar2.zzn(zzurVar2.zza, this.zzl).zzd, this.zzk, 0L).zzc : null, this.zzk.zzc) || z11) {
            this.zzN.zze(C.TIME_UNSET);
        }
    }

    private final void zzac(boolean z11, boolean z12) {
        this.zzz = z11;
        this.zzA = z12 ? C.TIME_UNSET : SystemClock.elapsedRealtime();
    }

    private final synchronized void zzad(zzfxu zzfxuVar, long j11) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() + j11;
        boolean z11 = false;
        while (!Boolean.valueOf(((zzkp) zzfxuVar).zza.zzw).booleanValue() && j11 > 0) {
            try {
                wait(j11);
            } catch (InterruptedException unused) {
                z11 = true;
            }
            j11 = jElapsedRealtime - SystemClock.elapsedRealtime();
        }
        if (z11) {
            Thread.currentThread().interrupt();
        }
    }

    private final boolean zzae() {
        zzli zzliVarZzd = this.zzq.zzd();
        return (zzliVarZzd == null || zzliVarZzd.zzd() == Long.MIN_VALUE) ? false : true;
    }

    private static boolean zzaf(zzmf zzmfVar) {
        return zzmfVar.zzbf() != 0;
    }

    private final boolean zzag() {
        zzli zzliVarZze = this.zzq.zze();
        long j11 = zzliVarZze.zzf.zze;
        if (zzliVarZze.zzd) {
            return j11 == C.TIME_UNSET || this.zzu.zzr < j11 || !zzai();
        }
        return false;
    }

    private static boolean zzah(zzly zzlyVar, zzcu zzcuVar) {
        zzur zzurVar = zzlyVar.zzb;
        zzcx zzcxVar = zzlyVar.zza;
        return zzcxVar.zzo() || zzcxVar.zzn(zzurVar.zza, zzcuVar).zzg;
    }

    private final boolean zzai() {
        zzly zzlyVar = this.zzu;
        return zzlyVar.zzl && zzlyVar.zzm == 0;
    }

    private final boolean zzaj(zzcx zzcxVar, zzur zzurVar) {
        if (!zzurVar.zzb() && !zzcxVar.zzo()) {
            zzcxVar.zze(zzcxVar.zzn(zzurVar.zza, this.zzl).zzd, this.zzk, 0L);
            if (this.zzk.zzb()) {
                zzcw zzcwVar = this.zzk;
                if (zzcwVar.zzj && zzcwVar.zzg != C.TIME_UNSET) {
                    return true;
                }
            }
        }
        return false;
    }

    private static zzam[] zzak(zzyi zzyiVar) {
        int iZzc = zzyiVar != null ? zzyiVar.zzc() : 0;
        zzam[] zzamVarArr = new zzam[iZzc];
        for (int i11 = 0; i11 < iZzc; i11++) {
            zzamVarArr[i11] = zzyiVar.zzd(i11);
        }
        return zzamVarArr;
    }

    private static final void zzal(zzmb zzmbVar) throws zziz {
        zzmbVar.zzj();
        try {
            zzmbVar.zzc().zzt(zzmbVar.zza(), zzmbVar.zzg());
        } finally {
            zzmbVar.zzh(true);
        }
    }

    private static final void zzam(zzmf zzmfVar) {
        if (zzmfVar.zzbf() == 2) {
            zzmfVar.zzO();
        }
    }

    private static final void zzan(zzmf zzmfVar, long j11) {
        zzmfVar.zzJ();
        if (zzmfVar instanceof zzww) {
            throw null;
        }
    }

    public static /* synthetic */ zzli zzd(zzkz zzkzVar, zzlj zzljVar, long j11) {
        zzlc zzlcVar = zzkzVar.zzf;
        zzyo zzyoVar = zzkzVar.zzd;
        zzyx zzyxVarZzi = zzlcVar.zzi();
        zzyp zzypVar = zzkzVar.zze;
        return new zzli(zzkzVar.zzc, j11, zzyoVar, zzyxVarZzi, zzkzVar.zzr, zzljVar, zzypVar);
    }

    @Nullable
    public static Object zzf(zzcw zzcwVar, zzcu zzcuVar, int i11, boolean z11, Object obj, zzcx zzcxVar, zzcx zzcxVar2) {
        int iZza = zzcxVar.zza(obj);
        int iZzb = zzcxVar.zzb();
        int iZzi = iZza;
        int iZza2 = -1;
        for (int i12 = 0; i12 < iZzb && iZza2 == -1; i12++) {
            iZzi = zzcxVar.zzi(iZzi, zzcuVar, zzcwVar, i11, z11);
            if (iZzi == -1) {
                iZza2 = -1;
                break;
            }
            iZza2 = zzcxVar2.zza(zzcxVar.zzf(iZzi));
        }
        if (iZza2 == -1) {
            return null;
        }
        return zzcxVar2.zzf(iZza2);
    }

    public static final /* synthetic */ void zzr(zzmb zzmbVar) {
        try {
            zzal(zzmbVar);
        } catch (zziz e11) {
            zzff.zzd("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e11);
            throw new RuntimeException(e11);
        }
    }

    private final long zzs(zzcx zzcxVar, Object obj, long j11) {
        zzcxVar.zze(zzcxVar.zzn(obj, this.zzl).zzd, this.zzk, 0L);
        zzcw zzcwVar = this.zzk;
        if (zzcwVar.zzg != C.TIME_UNSET && zzcwVar.zzb()) {
            zzcw zzcwVar2 = this.zzk;
            if (zzcwVar2.zzj) {
                long j12 = zzcwVar2.zzh;
                return zzfy.zzq((j12 == C.TIME_UNSET ? System.currentTimeMillis() : j12 + SystemClock.elapsedRealtime()) - this.zzk.zzg) - j11;
            }
        }
        return C.TIME_UNSET;
    }

    private final long zzt() {
        return zzu(this.zzu.zzp);
    }

    private final long zzu(long j11) {
        zzli zzliVarZzd = this.zzq.zzd();
        if (zzliVarZzd == null) {
            return 0L;
        }
        return Math.max(0L, j11 - (this.zzH - zzliVarZzd.zze()));
    }

    private final long zzv(zzur zzurVar, long j11, boolean z11) throws zziz {
        zzll zzllVar = this.zzq;
        return zzw(zzurVar, j11, zzllVar.zze() != zzllVar.zzf(), z11);
    }

    private final long zzw(zzur zzurVar, long j11, boolean z11, boolean z12) throws zziz {
        zzX();
        zzac(false, true);
        if (z12 || this.zzu.zze == 3) {
            zzU(2);
        }
        zzli zzliVarZze = this.zzq.zze();
        zzli zzliVarZzg = zzliVarZze;
        while (zzliVarZzg != null && !zzurVar.equals(zzliVarZzg.zzf.zza)) {
            zzliVarZzg = zzliVarZzg.zzg();
        }
        if (z11 || zzliVarZze != zzliVarZzg || (zzliVarZzg != null && zzliVarZzg.zze() + j11 < 0)) {
            zzmf[] zzmfVarArr = this.zza;
            int length = zzmfVarArr.length;
            for (int i11 = 0; i11 < 2; i11++) {
                zzA(zzmfVarArr[i11]);
            }
            if (zzliVarZzg != null) {
                while (this.zzq.zze() != zzliVarZzg) {
                    this.zzq.zza();
                }
                this.zzq.zzn(zzliVarZzg);
                zzliVarZzg.zzp(1000000000000L);
                zzB();
            }
        }
        if (zzliVarZzg != null) {
            this.zzq.zzn(zzliVarZzg);
            if (!zzliVarZzg.zzd) {
                zzliVarZzg.zzf = zzliVarZzg.zzf.zzb(j11);
            } else if (zzliVarZzg.zze) {
                j11 = zzliVarZzg.zza.zze(j11);
                zzliVarZzg.zza.zzj(j11 - this.zzm, false);
            }
            zzO(j11);
            zzI();
        } else {
            this.zzq.zzj();
            zzO(j11);
        }
        zzE(false);
        this.zzh.zzi(2);
        return j11;
    }

    private final Pair zzx(zzcx zzcxVar) {
        long j11 = 0;
        if (zzcxVar.zzo()) {
            return Pair.create(zzly.zzh(), 0L);
        }
        Pair pairZzl = zzcxVar.zzl(this.zzk, this.zzl, zzcxVar.zzg(this.zzD), C.TIME_UNSET);
        zzur zzurVarZzi = this.zzq.zzi(zzcxVar, pairZzl.first, 0L);
        long jLongValue = ((Long) pairZzl.second).longValue();
        if (zzurVarZzi.zzb()) {
            zzcxVar.zzn(zzurVarZzi.zza, this.zzl);
            if (zzurVarZzi.zzc == this.zzl.zze(zzurVarZzi.zzb)) {
                this.zzl.zzj();
            }
        } else {
            j11 = jLongValue;
        }
        return Pair.create(zzurVarZzi, Long.valueOf(j11));
    }

    @Nullable
    private static Pair zzy(zzcx zzcxVar, zzky zzkyVar, boolean z11, int i11, boolean z12, zzcw zzcwVar, zzcu zzcuVar) {
        zzcx zzcxVar2 = zzkyVar.zza;
        if (zzcxVar.zzo()) {
            return null;
        }
        zzcx zzcxVar3 = true == zzcxVar2.zzo() ? zzcxVar : zzcxVar2;
        try {
            Pair pairZzl = zzcxVar3.zzl(zzcwVar, zzcuVar, zzkyVar.zzb, zzkyVar.zzc);
            if (zzcxVar.equals(zzcxVar3)) {
                return pairZzl;
            }
            if (zzcxVar.zza(pairZzl.first) != -1) {
                return (zzcxVar3.zzn(pairZzl.first, zzcuVar).zzg && zzcxVar3.zze(zzcuVar.zzd, zzcwVar, 0L).zzp == zzcxVar3.zza(pairZzl.first)) ? zzcxVar.zzl(zzcwVar, zzcuVar, zzcxVar.zzn(pairZzl.first, zzcuVar).zzd, zzkyVar.zzc) : pairZzl;
            }
            Object objZzf = zzf(zzcwVar, zzcuVar, i11, z12, pairZzl.first, zzcxVar3, zzcxVar);
            if (objZzf != null) {
                return zzcxVar.zzl(zzcwVar, zzcuVar, zzcxVar.zzn(objZzf, zzcuVar).zzd, C.TIME_UNSET);
            }
            return null;
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:55:0x00eb  */
    @CheckResult
    private final zzly zzz(zzur zzurVar, long j11, long j12, long j13, boolean z11, int i11) {
        List listZzl;
        zzyp zzypVar;
        zzws zzwsVar;
        int i12 = 0;
        this.zzJ = (!this.zzJ && j11 == this.zzu.zzr && zzurVar.equals(this.zzu.zzb)) ? false : true;
        zzN();
        zzly zzlyVar = this.zzu;
        zzws zzwsVarZzh = zzlyVar.zzh;
        zzyp zzypVarZzi = zzlyVar.zzi;
        List list = zzlyVar.zzj;
        if (!this.zzr.zzj()) {
            if (zzurVar.equals(this.zzu.zzb)) {
                listZzl = list;
            } else {
                zzypVar = this.zze;
                zzwsVar = zzws.zza;
                listZzl = zzgaa.zzl();
            }
            if (z11) {
                this.zzv.zzd(i11);
            }
            return this.zzu.zzb(zzurVar, j11, j12, j13, zzt(), zzwsVar, zzypVar, listZzl);
        }
        zzli zzliVarZze = this.zzq.zze();
        zzwsVarZzh = zzliVarZze == null ? zzws.zza : zzliVarZze.zzh();
        zzypVarZzi = zzliVarZze == null ? this.zze : zzliVarZze.zzi();
        zzyi[] zzyiVarArr = zzypVarZzi.zzc;
        zzfzx zzfzxVar = new zzfzx();
        boolean z12 = false;
        for (zzyi zzyiVar : zzyiVarArr) {
            if (zzyiVar != null) {
                zzby zzbyVar = zzyiVar.zzd(0).zzk;
                if (zzbyVar == null) {
                    zzfzxVar.zzf(new zzby(C.TIME_UNSET, new zzbx[0]));
                } else {
                    zzfzxVar.zzf(zzbyVar);
                    z12 = true;
                }
            }
        }
        zzgaa zzgaaVarZzi = z12 ? zzfzxVar.zzi() : zzgaa.zzl();
        if (zzliVarZze != null) {
            zzlj zzljVar = zzliVarZze.zzf;
            if (zzljVar.zzc != j12) {
                zzliVarZze.zzf = zzljVar.zza(j12);
            }
        }
        zzli zzliVarZze2 = this.zzq.zze();
        if (zzliVarZze2 != null) {
            zzyp zzypVarZzi2 = zzliVarZze2.zzi();
            while (true) {
                int length = this.zza.length;
                if (i12 >= 2) {
                    break;
                }
                if (zzypVarZzi2.zzb(i12)) {
                    if (this.zza[i12].zzbj() != 1) {
                        break;
                    }
                    int i13 = zzypVarZzi2.zzb[i12].zzb;
                }
                i12++;
            }
        }
        listZzl = zzgaaVarZzi;
        zzwsVar = zzwsVarZzh;
        zzypVar = zzypVarZzi;
        if (z11) {
            this.zzv.zzd(i11);
        }
        return this.zzu.zzb(zzurVar, j11, j12, j13, zzt(), zzwsVar, zzypVar, listZzl);
    }

    /* JADX WARN: Code duplicated, block: B:219:0x0495  */
    /* JADX WARN: Code duplicated, block: B:345:0x06f7 A[Catch: RuntimeException -> 0x002e, IOException -> 0x0032, zztt -> 0x0036, zzgx -> 0x003a, zzcc -> 0x003e, zzrq -> 0x0042, zziz -> 0x0046, TryCatch #8 {zzcc -> 0x003e, zzgx -> 0x003a, zziz -> 0x0046, zzrq -> 0x0042, zztt -> 0x0036, IOException -> 0x0032, RuntimeException -> 0x002e, blocks: (B:3:0x0006, B:4:0x0011, B:6:0x0015, B:22:0x004a, B:23:0x004e, B:24:0x0052, B:28:0x0059, B:30:0x0062, B:32:0x0070, B:33:0x0077, B:34:0x0081, B:35:0x0094, B:36:0x00ab, B:37:0x00c1, B:39:0x00d0, B:40:0x00d4, B:41:0x00e5, B:43:0x00f4, B:44:0x0110, B:45:0x0123, B:46:0x012c, B:48:0x013e, B:49:0x014a, B:50:0x015a, B:52:0x0166, B:55:0x0171, B:56:0x0178, B:57:0x0185, B:61:0x018c, B:63:0x0194, B:65:0x0198, B:67:0x019e, B:69:0x01a6, B:71:0x01ae, B:72:0x01b1, B:74:0x01b6, B:81:0x01c3, B:82:0x01c4, B:86:0x01cb, B:88:0x01d9, B:89:0x01dc, B:90:0x01e1, B:92:0x01f1, B:93:0x01f4, B:94:0x01f9, B:95:0x01fe, B:97:0x020a, B:98:0x0216, B:100:0x0222, B:102:0x024e, B:103:0x026e, B:104:0x0273, B:105:0x0277, B:107:0x027c, B:108:0x028d, B:110:0x0299, B:111:0x029c, B:118:0x02a7, B:119:0x02a8, B:120:0x02ad, B:121:0x02b5, B:122:0x02c7, B:124:0x02ee, B:194:0x040b, B:174:0x03d2, B:173:0x03ce, B:198:0x0417, B:199:0x0424, B:125:0x0310, B:129:0x0323, B:131:0x0333, B:133:0x034a, B:135:0x0354, B:200:0x0425, B:202:0x0439, B:205:0x0443, B:207:0x0452, B:209:0x045e, B:211:0x0473, B:212:0x0478, B:213:0x047c, B:215:0x0480, B:217:0x048d, B:289:0x05e9, B:291:0x05f1, B:293:0x05f9, B:296:0x05fe, B:297:0x060a, B:299:0x0610, B:301:0x0618, B:304:0x0628, B:306:0x062e, B:307:0x064e, B:309:0x0654, B:311:0x0659, B:313:0x065e, B:315:0x0662, B:317:0x0668, B:319:0x066c, B:321:0x0674, B:323:0x067a, B:325:0x0684, B:328:0x068a, B:329:0x068d, B:331:0x0696, B:333:0x06a8, B:335:0x06b1, B:337:0x06b9, B:342:0x06c5, B:343:0x06f1, B:345:0x06f7, B:347:0x06fd, B:348:0x0704, B:220:0x049c, B:222:0x04a2, B:225:0x04ad, B:228:0x04b8, B:230:0x04bd, B:233:0x04cb, B:235:0x04d1, B:236:0x04d9, B:237:0x04dc, B:239:0x04e4, B:241:0x04f2, B:243:0x052e, B:245:0x0538, B:248:0x0543, B:250:0x054b, B:251:0x054e, B:252:0x0551, B:254:0x0557, B:256:0x0566, B:258:0x056c, B:260:0x0578, B:262:0x0582, B:264:0x0593, B:266:0x0599, B:267:0x05a4, B:268:0x05a9, B:270:0x05af, B:273:0x05b4, B:275:0x05ba, B:277:0x05c2, B:279:0x05c8, B:281:0x05ce, B:285:0x05dc, B:287:0x05e3, B:288:0x05e6, B:216:0x048a, B:351:0x0710, B:355:0x071b, B:357:0x0725, B:358:0x072a, B:360:0x0738, B:361:0x0750, B:363:0x0756, B:365:0x075e, B:367:0x0765, B:371:0x076e, B:376:0x077d, B:382:0x078a, B:384:0x0790, B:393:0x07a2, B:395:0x07a7, B:397:0x07b3, B:399:0x07b9, B:403:0x07c6, B:405:0x07ce, B:407:0x07d2, B:408:0x07dd, B:410:0x07e3, B:465:0x08d7, B:468:0x08df, B:470:0x08e4, B:472:0x08ec, B:474:0x08fa, B:475:0x0901, B:476:0x0905, B:478:0x090b, B:480:0x0914, B:482:0x091a, B:484:0x0925, B:491:0x0949, B:493:0x094f, B:497:0x0958, B:509:0x0978, B:505:0x096b, B:507:0x096f, B:508:0x0975, B:485:0x092c, B:488:0x093a, B:489:0x0941, B:490:0x0942, B:411:0x07ec, B:413:0x07f3, B:415:0x07f7, B:444:0x0880, B:446:0x088c, B:421:0x0806, B:423:0x080a, B:425:0x081e, B:427:0x082c, B:429:0x0838, B:433:0x0841, B:435:0x084b, B:441:0x0856, B:447:0x0890, B:449:0x0896, B:451:0x089a, B:455:0x08a3, B:457:0x08b3, B:459:0x08bb, B:461:0x08c5, B:462:0x08ca, B:463:0x08cf, B:464:0x08d4, B:396:0x07ac, B:510:0x097d, B:514:0x0984, B:515:0x098c, B:519:0x09aa), top: B:582:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:347:0x06fd A[Catch: RuntimeException -> 0x002e, IOException -> 0x0032, zztt -> 0x0036, zzgx -> 0x003a, zzcc -> 0x003e, zzrq -> 0x0042, zziz -> 0x0046, TryCatch #8 {zzcc -> 0x003e, zzgx -> 0x003a, zziz -> 0x0046, zzrq -> 0x0042, zztt -> 0x0036, IOException -> 0x0032, RuntimeException -> 0x002e, blocks: (B:3:0x0006, B:4:0x0011, B:6:0x0015, B:22:0x004a, B:23:0x004e, B:24:0x0052, B:28:0x0059, B:30:0x0062, B:32:0x0070, B:33:0x0077, B:34:0x0081, B:35:0x0094, B:36:0x00ab, B:37:0x00c1, B:39:0x00d0, B:40:0x00d4, B:41:0x00e5, B:43:0x00f4, B:44:0x0110, B:45:0x0123, B:46:0x012c, B:48:0x013e, B:49:0x014a, B:50:0x015a, B:52:0x0166, B:55:0x0171, B:56:0x0178, B:57:0x0185, B:61:0x018c, B:63:0x0194, B:65:0x0198, B:67:0x019e, B:69:0x01a6, B:71:0x01ae, B:72:0x01b1, B:74:0x01b6, B:81:0x01c3, B:82:0x01c4, B:86:0x01cb, B:88:0x01d9, B:89:0x01dc, B:90:0x01e1, B:92:0x01f1, B:93:0x01f4, B:94:0x01f9, B:95:0x01fe, B:97:0x020a, B:98:0x0216, B:100:0x0222, B:102:0x024e, B:103:0x026e, B:104:0x0273, B:105:0x0277, B:107:0x027c, B:108:0x028d, B:110:0x0299, B:111:0x029c, B:118:0x02a7, B:119:0x02a8, B:120:0x02ad, B:121:0x02b5, B:122:0x02c7, B:124:0x02ee, B:194:0x040b, B:174:0x03d2, B:173:0x03ce, B:198:0x0417, B:199:0x0424, B:125:0x0310, B:129:0x0323, B:131:0x0333, B:133:0x034a, B:135:0x0354, B:200:0x0425, B:202:0x0439, B:205:0x0443, B:207:0x0452, B:209:0x045e, B:211:0x0473, B:212:0x0478, B:213:0x047c, B:215:0x0480, B:217:0x048d, B:289:0x05e9, B:291:0x05f1, B:293:0x05f9, B:296:0x05fe, B:297:0x060a, B:299:0x0610, B:301:0x0618, B:304:0x0628, B:306:0x062e, B:307:0x064e, B:309:0x0654, B:311:0x0659, B:313:0x065e, B:315:0x0662, B:317:0x0668, B:319:0x066c, B:321:0x0674, B:323:0x067a, B:325:0x0684, B:328:0x068a, B:329:0x068d, B:331:0x0696, B:333:0x06a8, B:335:0x06b1, B:337:0x06b9, B:342:0x06c5, B:343:0x06f1, B:345:0x06f7, B:347:0x06fd, B:348:0x0704, B:220:0x049c, B:222:0x04a2, B:225:0x04ad, B:228:0x04b8, B:230:0x04bd, B:233:0x04cb, B:235:0x04d1, B:236:0x04d9, B:237:0x04dc, B:239:0x04e4, B:241:0x04f2, B:243:0x052e, B:245:0x0538, B:248:0x0543, B:250:0x054b, B:251:0x054e, B:252:0x0551, B:254:0x0557, B:256:0x0566, B:258:0x056c, B:260:0x0578, B:262:0x0582, B:264:0x0593, B:266:0x0599, B:267:0x05a4, B:268:0x05a9, B:270:0x05af, B:273:0x05b4, B:275:0x05ba, B:277:0x05c2, B:279:0x05c8, B:281:0x05ce, B:285:0x05dc, B:287:0x05e3, B:288:0x05e6, B:216:0x048a, B:351:0x0710, B:355:0x071b, B:357:0x0725, B:358:0x072a, B:360:0x0738, B:361:0x0750, B:363:0x0756, B:365:0x075e, B:367:0x0765, B:371:0x076e, B:376:0x077d, B:382:0x078a, B:384:0x0790, B:393:0x07a2, B:395:0x07a7, B:397:0x07b3, B:399:0x07b9, B:403:0x07c6, B:405:0x07ce, B:407:0x07d2, B:408:0x07dd, B:410:0x07e3, B:465:0x08d7, B:468:0x08df, B:470:0x08e4, B:472:0x08ec, B:474:0x08fa, B:475:0x0901, B:476:0x0905, B:478:0x090b, B:480:0x0914, B:482:0x091a, B:484:0x0925, B:491:0x0949, B:493:0x094f, B:497:0x0958, B:509:0x0978, B:505:0x096b, B:507:0x096f, B:508:0x0975, B:485:0x092c, B:488:0x093a, B:489:0x0941, B:490:0x0942, B:411:0x07ec, B:413:0x07f3, B:415:0x07f7, B:444:0x0880, B:446:0x088c, B:421:0x0806, B:423:0x080a, B:425:0x081e, B:427:0x082c, B:429:0x0838, B:433:0x0841, B:435:0x084b, B:441:0x0856, B:447:0x0890, B:449:0x0896, B:451:0x089a, B:455:0x08a3, B:457:0x08b3, B:459:0x08bb, B:461:0x08c5, B:462:0x08ca, B:463:0x08cf, B:464:0x08d4, B:396:0x07ac, B:510:0x097d, B:514:0x0984, B:515:0x098c, B:519:0x09aa), top: B:582:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:411:0x07ec A[Catch: RuntimeException -> 0x002e, IOException -> 0x0032, zztt -> 0x0036, zzgx -> 0x003a, zzcc -> 0x003e, zzrq -> 0x0042, zziz -> 0x0046, TryCatch #8 {zzcc -> 0x003e, zzgx -> 0x003a, zziz -> 0x0046, zzrq -> 0x0042, zztt -> 0x0036, IOException -> 0x0032, RuntimeException -> 0x002e, blocks: (B:3:0x0006, B:4:0x0011, B:6:0x0015, B:22:0x004a, B:23:0x004e, B:24:0x0052, B:28:0x0059, B:30:0x0062, B:32:0x0070, B:33:0x0077, B:34:0x0081, B:35:0x0094, B:36:0x00ab, B:37:0x00c1, B:39:0x00d0, B:40:0x00d4, B:41:0x00e5, B:43:0x00f4, B:44:0x0110, B:45:0x0123, B:46:0x012c, B:48:0x013e, B:49:0x014a, B:50:0x015a, B:52:0x0166, B:55:0x0171, B:56:0x0178, B:57:0x0185, B:61:0x018c, B:63:0x0194, B:65:0x0198, B:67:0x019e, B:69:0x01a6, B:71:0x01ae, B:72:0x01b1, B:74:0x01b6, B:81:0x01c3, B:82:0x01c4, B:86:0x01cb, B:88:0x01d9, B:89:0x01dc, B:90:0x01e1, B:92:0x01f1, B:93:0x01f4, B:94:0x01f9, B:95:0x01fe, B:97:0x020a, B:98:0x0216, B:100:0x0222, B:102:0x024e, B:103:0x026e, B:104:0x0273, B:105:0x0277, B:107:0x027c, B:108:0x028d, B:110:0x0299, B:111:0x029c, B:118:0x02a7, B:119:0x02a8, B:120:0x02ad, B:121:0x02b5, B:122:0x02c7, B:124:0x02ee, B:194:0x040b, B:174:0x03d2, B:173:0x03ce, B:198:0x0417, B:199:0x0424, B:125:0x0310, B:129:0x0323, B:131:0x0333, B:133:0x034a, B:135:0x0354, B:200:0x0425, B:202:0x0439, B:205:0x0443, B:207:0x0452, B:209:0x045e, B:211:0x0473, B:212:0x0478, B:213:0x047c, B:215:0x0480, B:217:0x048d, B:289:0x05e9, B:291:0x05f1, B:293:0x05f9, B:296:0x05fe, B:297:0x060a, B:299:0x0610, B:301:0x0618, B:304:0x0628, B:306:0x062e, B:307:0x064e, B:309:0x0654, B:311:0x0659, B:313:0x065e, B:315:0x0662, B:317:0x0668, B:319:0x066c, B:321:0x0674, B:323:0x067a, B:325:0x0684, B:328:0x068a, B:329:0x068d, B:331:0x0696, B:333:0x06a8, B:335:0x06b1, B:337:0x06b9, B:342:0x06c5, B:343:0x06f1, B:345:0x06f7, B:347:0x06fd, B:348:0x0704, B:220:0x049c, B:222:0x04a2, B:225:0x04ad, B:228:0x04b8, B:230:0x04bd, B:233:0x04cb, B:235:0x04d1, B:236:0x04d9, B:237:0x04dc, B:239:0x04e4, B:241:0x04f2, B:243:0x052e, B:245:0x0538, B:248:0x0543, B:250:0x054b, B:251:0x054e, B:252:0x0551, B:254:0x0557, B:256:0x0566, B:258:0x056c, B:260:0x0578, B:262:0x0582, B:264:0x0593, B:266:0x0599, B:267:0x05a4, B:268:0x05a9, B:270:0x05af, B:273:0x05b4, B:275:0x05ba, B:277:0x05c2, B:279:0x05c8, B:281:0x05ce, B:285:0x05dc, B:287:0x05e3, B:288:0x05e6, B:216:0x048a, B:351:0x0710, B:355:0x071b, B:357:0x0725, B:358:0x072a, B:360:0x0738, B:361:0x0750, B:363:0x0756, B:365:0x075e, B:367:0x0765, B:371:0x076e, B:376:0x077d, B:382:0x078a, B:384:0x0790, B:393:0x07a2, B:395:0x07a7, B:397:0x07b3, B:399:0x07b9, B:403:0x07c6, B:405:0x07ce, B:407:0x07d2, B:408:0x07dd, B:410:0x07e3, B:465:0x08d7, B:468:0x08df, B:470:0x08e4, B:472:0x08ec, B:474:0x08fa, B:475:0x0901, B:476:0x0905, B:478:0x090b, B:480:0x0914, B:482:0x091a, B:484:0x0925, B:491:0x0949, B:493:0x094f, B:497:0x0958, B:509:0x0978, B:505:0x096b, B:507:0x096f, B:508:0x0975, B:485:0x092c, B:488:0x093a, B:489:0x0941, B:490:0x0942, B:411:0x07ec, B:413:0x07f3, B:415:0x07f7, B:444:0x0880, B:446:0x088c, B:421:0x0806, B:423:0x080a, B:425:0x081e, B:427:0x082c, B:429:0x0838, B:433:0x0841, B:435:0x084b, B:441:0x0856, B:447:0x0890, B:449:0x0896, B:451:0x089a, B:455:0x08a3, B:457:0x08b3, B:459:0x08bb, B:461:0x08c5, B:462:0x08ca, B:463:0x08cf, B:464:0x08d4, B:396:0x07ac, B:510:0x097d, B:514:0x0984, B:515:0x098c, B:519:0x09aa), top: B:582:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:413:0x07f3 A[Catch: RuntimeException -> 0x002e, IOException -> 0x0032, zztt -> 0x0036, zzgx -> 0x003a, zzcc -> 0x003e, zzrq -> 0x0042, zziz -> 0x0046, TryCatch #8 {zzcc -> 0x003e, zzgx -> 0x003a, zziz -> 0x0046, zzrq -> 0x0042, zztt -> 0x0036, IOException -> 0x0032, RuntimeException -> 0x002e, blocks: (B:3:0x0006, B:4:0x0011, B:6:0x0015, B:22:0x004a, B:23:0x004e, B:24:0x0052, B:28:0x0059, B:30:0x0062, B:32:0x0070, B:33:0x0077, B:34:0x0081, B:35:0x0094, B:36:0x00ab, B:37:0x00c1, B:39:0x00d0, B:40:0x00d4, B:41:0x00e5, B:43:0x00f4, B:44:0x0110, B:45:0x0123, B:46:0x012c, B:48:0x013e, B:49:0x014a, B:50:0x015a, B:52:0x0166, B:55:0x0171, B:56:0x0178, B:57:0x0185, B:61:0x018c, B:63:0x0194, B:65:0x0198, B:67:0x019e, B:69:0x01a6, B:71:0x01ae, B:72:0x01b1, B:74:0x01b6, B:81:0x01c3, B:82:0x01c4, B:86:0x01cb, B:88:0x01d9, B:89:0x01dc, B:90:0x01e1, B:92:0x01f1, B:93:0x01f4, B:94:0x01f9, B:95:0x01fe, B:97:0x020a, B:98:0x0216, B:100:0x0222, B:102:0x024e, B:103:0x026e, B:104:0x0273, B:105:0x0277, B:107:0x027c, B:108:0x028d, B:110:0x0299, B:111:0x029c, B:118:0x02a7, B:119:0x02a8, B:120:0x02ad, B:121:0x02b5, B:122:0x02c7, B:124:0x02ee, B:194:0x040b, B:174:0x03d2, B:173:0x03ce, B:198:0x0417, B:199:0x0424, B:125:0x0310, B:129:0x0323, B:131:0x0333, B:133:0x034a, B:135:0x0354, B:200:0x0425, B:202:0x0439, B:205:0x0443, B:207:0x0452, B:209:0x045e, B:211:0x0473, B:212:0x0478, B:213:0x047c, B:215:0x0480, B:217:0x048d, B:289:0x05e9, B:291:0x05f1, B:293:0x05f9, B:296:0x05fe, B:297:0x060a, B:299:0x0610, B:301:0x0618, B:304:0x0628, B:306:0x062e, B:307:0x064e, B:309:0x0654, B:311:0x0659, B:313:0x065e, B:315:0x0662, B:317:0x0668, B:319:0x066c, B:321:0x0674, B:323:0x067a, B:325:0x0684, B:328:0x068a, B:329:0x068d, B:331:0x0696, B:333:0x06a8, B:335:0x06b1, B:337:0x06b9, B:342:0x06c5, B:343:0x06f1, B:345:0x06f7, B:347:0x06fd, B:348:0x0704, B:220:0x049c, B:222:0x04a2, B:225:0x04ad, B:228:0x04b8, B:230:0x04bd, B:233:0x04cb, B:235:0x04d1, B:236:0x04d9, B:237:0x04dc, B:239:0x04e4, B:241:0x04f2, B:243:0x052e, B:245:0x0538, B:248:0x0543, B:250:0x054b, B:251:0x054e, B:252:0x0551, B:254:0x0557, B:256:0x0566, B:258:0x056c, B:260:0x0578, B:262:0x0582, B:264:0x0593, B:266:0x0599, B:267:0x05a4, B:268:0x05a9, B:270:0x05af, B:273:0x05b4, B:275:0x05ba, B:277:0x05c2, B:279:0x05c8, B:281:0x05ce, B:285:0x05dc, B:287:0x05e3, B:288:0x05e6, B:216:0x048a, B:351:0x0710, B:355:0x071b, B:357:0x0725, B:358:0x072a, B:360:0x0738, B:361:0x0750, B:363:0x0756, B:365:0x075e, B:367:0x0765, B:371:0x076e, B:376:0x077d, B:382:0x078a, B:384:0x0790, B:393:0x07a2, B:395:0x07a7, B:397:0x07b3, B:399:0x07b9, B:403:0x07c6, B:405:0x07ce, B:407:0x07d2, B:408:0x07dd, B:410:0x07e3, B:465:0x08d7, B:468:0x08df, B:470:0x08e4, B:472:0x08ec, B:474:0x08fa, B:475:0x0901, B:476:0x0905, B:478:0x090b, B:480:0x0914, B:482:0x091a, B:484:0x0925, B:491:0x0949, B:493:0x094f, B:497:0x0958, B:509:0x0978, B:505:0x096b, B:507:0x096f, B:508:0x0975, B:485:0x092c, B:488:0x093a, B:489:0x0941, B:490:0x0942, B:411:0x07ec, B:413:0x07f3, B:415:0x07f7, B:444:0x0880, B:446:0x088c, B:421:0x0806, B:423:0x080a, B:425:0x081e, B:427:0x082c, B:429:0x0838, B:433:0x0841, B:435:0x084b, B:441:0x0856, B:447:0x0890, B:449:0x0896, B:451:0x089a, B:455:0x08a3, B:457:0x08b3, B:459:0x08bb, B:461:0x08c5, B:462:0x08ca, B:463:0x08cf, B:464:0x08d4, B:396:0x07ac, B:510:0x097d, B:514:0x0984, B:515:0x098c, B:519:0x09aa), top: B:582:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:415:0x07f7 A[Catch: RuntimeException -> 0x002e, IOException -> 0x0032, zztt -> 0x0036, zzgx -> 0x003a, zzcc -> 0x003e, zzrq -> 0x0042, zziz -> 0x0046, TryCatch #8 {zzcc -> 0x003e, zzgx -> 0x003a, zziz -> 0x0046, zzrq -> 0x0042, zztt -> 0x0036, IOException -> 0x0032, RuntimeException -> 0x002e, blocks: (B:3:0x0006, B:4:0x0011, B:6:0x0015, B:22:0x004a, B:23:0x004e, B:24:0x0052, B:28:0x0059, B:30:0x0062, B:32:0x0070, B:33:0x0077, B:34:0x0081, B:35:0x0094, B:36:0x00ab, B:37:0x00c1, B:39:0x00d0, B:40:0x00d4, B:41:0x00e5, B:43:0x00f4, B:44:0x0110, B:45:0x0123, B:46:0x012c, B:48:0x013e, B:49:0x014a, B:50:0x015a, B:52:0x0166, B:55:0x0171, B:56:0x0178, B:57:0x0185, B:61:0x018c, B:63:0x0194, B:65:0x0198, B:67:0x019e, B:69:0x01a6, B:71:0x01ae, B:72:0x01b1, B:74:0x01b6, B:81:0x01c3, B:82:0x01c4, B:86:0x01cb, B:88:0x01d9, B:89:0x01dc, B:90:0x01e1, B:92:0x01f1, B:93:0x01f4, B:94:0x01f9, B:95:0x01fe, B:97:0x020a, B:98:0x0216, B:100:0x0222, B:102:0x024e, B:103:0x026e, B:104:0x0273, B:105:0x0277, B:107:0x027c, B:108:0x028d, B:110:0x0299, B:111:0x029c, B:118:0x02a7, B:119:0x02a8, B:120:0x02ad, B:121:0x02b5, B:122:0x02c7, B:124:0x02ee, B:194:0x040b, B:174:0x03d2, B:173:0x03ce, B:198:0x0417, B:199:0x0424, B:125:0x0310, B:129:0x0323, B:131:0x0333, B:133:0x034a, B:135:0x0354, B:200:0x0425, B:202:0x0439, B:205:0x0443, B:207:0x0452, B:209:0x045e, B:211:0x0473, B:212:0x0478, B:213:0x047c, B:215:0x0480, B:217:0x048d, B:289:0x05e9, B:291:0x05f1, B:293:0x05f9, B:296:0x05fe, B:297:0x060a, B:299:0x0610, B:301:0x0618, B:304:0x0628, B:306:0x062e, B:307:0x064e, B:309:0x0654, B:311:0x0659, B:313:0x065e, B:315:0x0662, B:317:0x0668, B:319:0x066c, B:321:0x0674, B:323:0x067a, B:325:0x0684, B:328:0x068a, B:329:0x068d, B:331:0x0696, B:333:0x06a8, B:335:0x06b1, B:337:0x06b9, B:342:0x06c5, B:343:0x06f1, B:345:0x06f7, B:347:0x06fd, B:348:0x0704, B:220:0x049c, B:222:0x04a2, B:225:0x04ad, B:228:0x04b8, B:230:0x04bd, B:233:0x04cb, B:235:0x04d1, B:236:0x04d9, B:237:0x04dc, B:239:0x04e4, B:241:0x04f2, B:243:0x052e, B:245:0x0538, B:248:0x0543, B:250:0x054b, B:251:0x054e, B:252:0x0551, B:254:0x0557, B:256:0x0566, B:258:0x056c, B:260:0x0578, B:262:0x0582, B:264:0x0593, B:266:0x0599, B:267:0x05a4, B:268:0x05a9, B:270:0x05af, B:273:0x05b4, B:275:0x05ba, B:277:0x05c2, B:279:0x05c8, B:281:0x05ce, B:285:0x05dc, B:287:0x05e3, B:288:0x05e6, B:216:0x048a, B:351:0x0710, B:355:0x071b, B:357:0x0725, B:358:0x072a, B:360:0x0738, B:361:0x0750, B:363:0x0756, B:365:0x075e, B:367:0x0765, B:371:0x076e, B:376:0x077d, B:382:0x078a, B:384:0x0790, B:393:0x07a2, B:395:0x07a7, B:397:0x07b3, B:399:0x07b9, B:403:0x07c6, B:405:0x07ce, B:407:0x07d2, B:408:0x07dd, B:410:0x07e3, B:465:0x08d7, B:468:0x08df, B:470:0x08e4, B:472:0x08ec, B:474:0x08fa, B:475:0x0901, B:476:0x0905, B:478:0x090b, B:480:0x0914, B:482:0x091a, B:484:0x0925, B:491:0x0949, B:493:0x094f, B:497:0x0958, B:509:0x0978, B:505:0x096b, B:507:0x096f, B:508:0x0975, B:485:0x092c, B:488:0x093a, B:489:0x0941, B:490:0x0942, B:411:0x07ec, B:413:0x07f3, B:415:0x07f7, B:444:0x0880, B:446:0x088c, B:421:0x0806, B:423:0x080a, B:425:0x081e, B:427:0x082c, B:429:0x0838, B:433:0x0841, B:435:0x084b, B:441:0x0856, B:447:0x0890, B:449:0x0896, B:451:0x089a, B:455:0x08a3, B:457:0x08b3, B:459:0x08bb, B:461:0x08c5, B:462:0x08ca, B:463:0x08cf, B:464:0x08d4, B:396:0x07ac, B:510:0x097d, B:514:0x0984, B:515:0x098c, B:519:0x09aa), top: B:582:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:417:0x07fd  */
    /* JADX WARN: Code duplicated, block: B:418:0x0800  */
    /* JADX WARN: Code duplicated, block: B:419:0x0803  */
    /* JADX WARN: Code duplicated, block: B:420:0x0805  */
    /* JADX WARN: Code duplicated, block: B:421:0x0806 A[Catch: RuntimeException -> 0x002e, IOException -> 0x0032, zztt -> 0x0036, zzgx -> 0x003a, zzcc -> 0x003e, zzrq -> 0x0042, zziz -> 0x0046, TryCatch #8 {zzcc -> 0x003e, zzgx -> 0x003a, zziz -> 0x0046, zzrq -> 0x0042, zztt -> 0x0036, IOException -> 0x0032, RuntimeException -> 0x002e, blocks: (B:3:0x0006, B:4:0x0011, B:6:0x0015, B:22:0x004a, B:23:0x004e, B:24:0x0052, B:28:0x0059, B:30:0x0062, B:32:0x0070, B:33:0x0077, B:34:0x0081, B:35:0x0094, B:36:0x00ab, B:37:0x00c1, B:39:0x00d0, B:40:0x00d4, B:41:0x00e5, B:43:0x00f4, B:44:0x0110, B:45:0x0123, B:46:0x012c, B:48:0x013e, B:49:0x014a, B:50:0x015a, B:52:0x0166, B:55:0x0171, B:56:0x0178, B:57:0x0185, B:61:0x018c, B:63:0x0194, B:65:0x0198, B:67:0x019e, B:69:0x01a6, B:71:0x01ae, B:72:0x01b1, B:74:0x01b6, B:81:0x01c3, B:82:0x01c4, B:86:0x01cb, B:88:0x01d9, B:89:0x01dc, B:90:0x01e1, B:92:0x01f1, B:93:0x01f4, B:94:0x01f9, B:95:0x01fe, B:97:0x020a, B:98:0x0216, B:100:0x0222, B:102:0x024e, B:103:0x026e, B:104:0x0273, B:105:0x0277, B:107:0x027c, B:108:0x028d, B:110:0x0299, B:111:0x029c, B:118:0x02a7, B:119:0x02a8, B:120:0x02ad, B:121:0x02b5, B:122:0x02c7, B:124:0x02ee, B:194:0x040b, B:174:0x03d2, B:173:0x03ce, B:198:0x0417, B:199:0x0424, B:125:0x0310, B:129:0x0323, B:131:0x0333, B:133:0x034a, B:135:0x0354, B:200:0x0425, B:202:0x0439, B:205:0x0443, B:207:0x0452, B:209:0x045e, B:211:0x0473, B:212:0x0478, B:213:0x047c, B:215:0x0480, B:217:0x048d, B:289:0x05e9, B:291:0x05f1, B:293:0x05f9, B:296:0x05fe, B:297:0x060a, B:299:0x0610, B:301:0x0618, B:304:0x0628, B:306:0x062e, B:307:0x064e, B:309:0x0654, B:311:0x0659, B:313:0x065e, B:315:0x0662, B:317:0x0668, B:319:0x066c, B:321:0x0674, B:323:0x067a, B:325:0x0684, B:328:0x068a, B:329:0x068d, B:331:0x0696, B:333:0x06a8, B:335:0x06b1, B:337:0x06b9, B:342:0x06c5, B:343:0x06f1, B:345:0x06f7, B:347:0x06fd, B:348:0x0704, B:220:0x049c, B:222:0x04a2, B:225:0x04ad, B:228:0x04b8, B:230:0x04bd, B:233:0x04cb, B:235:0x04d1, B:236:0x04d9, B:237:0x04dc, B:239:0x04e4, B:241:0x04f2, B:243:0x052e, B:245:0x0538, B:248:0x0543, B:250:0x054b, B:251:0x054e, B:252:0x0551, B:254:0x0557, B:256:0x0566, B:258:0x056c, B:260:0x0578, B:262:0x0582, B:264:0x0593, B:266:0x0599, B:267:0x05a4, B:268:0x05a9, B:270:0x05af, B:273:0x05b4, B:275:0x05ba, B:277:0x05c2, B:279:0x05c8, B:281:0x05ce, B:285:0x05dc, B:287:0x05e3, B:288:0x05e6, B:216:0x048a, B:351:0x0710, B:355:0x071b, B:357:0x0725, B:358:0x072a, B:360:0x0738, B:361:0x0750, B:363:0x0756, B:365:0x075e, B:367:0x0765, B:371:0x076e, B:376:0x077d, B:382:0x078a, B:384:0x0790, B:393:0x07a2, B:395:0x07a7, B:397:0x07b3, B:399:0x07b9, B:403:0x07c6, B:405:0x07ce, B:407:0x07d2, B:408:0x07dd, B:410:0x07e3, B:465:0x08d7, B:468:0x08df, B:470:0x08e4, B:472:0x08ec, B:474:0x08fa, B:475:0x0901, B:476:0x0905, B:478:0x090b, B:480:0x0914, B:482:0x091a, B:484:0x0925, B:491:0x0949, B:493:0x094f, B:497:0x0958, B:509:0x0978, B:505:0x096b, B:507:0x096f, B:508:0x0975, B:485:0x092c, B:488:0x093a, B:489:0x0941, B:490:0x0942, B:411:0x07ec, B:413:0x07f3, B:415:0x07f7, B:444:0x0880, B:446:0x088c, B:421:0x0806, B:423:0x080a, B:425:0x081e, B:427:0x082c, B:429:0x0838, B:433:0x0841, B:435:0x084b, B:441:0x0856, B:447:0x0890, B:449:0x0896, B:451:0x089a, B:455:0x08a3, B:457:0x08b3, B:459:0x08bb, B:461:0x08c5, B:462:0x08ca, B:463:0x08cf, B:464:0x08d4, B:396:0x07ac, B:510:0x097d, B:514:0x0984, B:515:0x098c, B:519:0x09aa), top: B:582:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:423:0x080a A[Catch: RuntimeException -> 0x002e, IOException -> 0x0032, zztt -> 0x0036, zzgx -> 0x003a, zzcc -> 0x003e, zzrq -> 0x0042, zziz -> 0x0046, TryCatch #8 {zzcc -> 0x003e, zzgx -> 0x003a, zziz -> 0x0046, zzrq -> 0x0042, zztt -> 0x0036, IOException -> 0x0032, RuntimeException -> 0x002e, blocks: (B:3:0x0006, B:4:0x0011, B:6:0x0015, B:22:0x004a, B:23:0x004e, B:24:0x0052, B:28:0x0059, B:30:0x0062, B:32:0x0070, B:33:0x0077, B:34:0x0081, B:35:0x0094, B:36:0x00ab, B:37:0x00c1, B:39:0x00d0, B:40:0x00d4, B:41:0x00e5, B:43:0x00f4, B:44:0x0110, B:45:0x0123, B:46:0x012c, B:48:0x013e, B:49:0x014a, B:50:0x015a, B:52:0x0166, B:55:0x0171, B:56:0x0178, B:57:0x0185, B:61:0x018c, B:63:0x0194, B:65:0x0198, B:67:0x019e, B:69:0x01a6, B:71:0x01ae, B:72:0x01b1, B:74:0x01b6, B:81:0x01c3, B:82:0x01c4, B:86:0x01cb, B:88:0x01d9, B:89:0x01dc, B:90:0x01e1, B:92:0x01f1, B:93:0x01f4, B:94:0x01f9, B:95:0x01fe, B:97:0x020a, B:98:0x0216, B:100:0x0222, B:102:0x024e, B:103:0x026e, B:104:0x0273, B:105:0x0277, B:107:0x027c, B:108:0x028d, B:110:0x0299, B:111:0x029c, B:118:0x02a7, B:119:0x02a8, B:120:0x02ad, B:121:0x02b5, B:122:0x02c7, B:124:0x02ee, B:194:0x040b, B:174:0x03d2, B:173:0x03ce, B:198:0x0417, B:199:0x0424, B:125:0x0310, B:129:0x0323, B:131:0x0333, B:133:0x034a, B:135:0x0354, B:200:0x0425, B:202:0x0439, B:205:0x0443, B:207:0x0452, B:209:0x045e, B:211:0x0473, B:212:0x0478, B:213:0x047c, B:215:0x0480, B:217:0x048d, B:289:0x05e9, B:291:0x05f1, B:293:0x05f9, B:296:0x05fe, B:297:0x060a, B:299:0x0610, B:301:0x0618, B:304:0x0628, B:306:0x062e, B:307:0x064e, B:309:0x0654, B:311:0x0659, B:313:0x065e, B:315:0x0662, B:317:0x0668, B:319:0x066c, B:321:0x0674, B:323:0x067a, B:325:0x0684, B:328:0x068a, B:329:0x068d, B:331:0x0696, B:333:0x06a8, B:335:0x06b1, B:337:0x06b9, B:342:0x06c5, B:343:0x06f1, B:345:0x06f7, B:347:0x06fd, B:348:0x0704, B:220:0x049c, B:222:0x04a2, B:225:0x04ad, B:228:0x04b8, B:230:0x04bd, B:233:0x04cb, B:235:0x04d1, B:236:0x04d9, B:237:0x04dc, B:239:0x04e4, B:241:0x04f2, B:243:0x052e, B:245:0x0538, B:248:0x0543, B:250:0x054b, B:251:0x054e, B:252:0x0551, B:254:0x0557, B:256:0x0566, B:258:0x056c, B:260:0x0578, B:262:0x0582, B:264:0x0593, B:266:0x0599, B:267:0x05a4, B:268:0x05a9, B:270:0x05af, B:273:0x05b4, B:275:0x05ba, B:277:0x05c2, B:279:0x05c8, B:281:0x05ce, B:285:0x05dc, B:287:0x05e3, B:288:0x05e6, B:216:0x048a, B:351:0x0710, B:355:0x071b, B:357:0x0725, B:358:0x072a, B:360:0x0738, B:361:0x0750, B:363:0x0756, B:365:0x075e, B:367:0x0765, B:371:0x076e, B:376:0x077d, B:382:0x078a, B:384:0x0790, B:393:0x07a2, B:395:0x07a7, B:397:0x07b3, B:399:0x07b9, B:403:0x07c6, B:405:0x07ce, B:407:0x07d2, B:408:0x07dd, B:410:0x07e3, B:465:0x08d7, B:468:0x08df, B:470:0x08e4, B:472:0x08ec, B:474:0x08fa, B:475:0x0901, B:476:0x0905, B:478:0x090b, B:480:0x0914, B:482:0x091a, B:484:0x0925, B:491:0x0949, B:493:0x094f, B:497:0x0958, B:509:0x0978, B:505:0x096b, B:507:0x096f, B:508:0x0975, B:485:0x092c, B:488:0x093a, B:489:0x0941, B:490:0x0942, B:411:0x07ec, B:413:0x07f3, B:415:0x07f7, B:444:0x0880, B:446:0x088c, B:421:0x0806, B:423:0x080a, B:425:0x081e, B:427:0x082c, B:429:0x0838, B:433:0x0841, B:435:0x084b, B:441:0x0856, B:447:0x0890, B:449:0x0896, B:451:0x089a, B:455:0x08a3, B:457:0x08b3, B:459:0x08bb, B:461:0x08c5, B:462:0x08ca, B:463:0x08cf, B:464:0x08d4, B:396:0x07ac, B:510:0x097d, B:514:0x0984, B:515:0x098c, B:519:0x09aa), top: B:582:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:425:0x081e A[Catch: RuntimeException -> 0x002e, IOException -> 0x0032, zztt -> 0x0036, zzgx -> 0x003a, zzcc -> 0x003e, zzrq -> 0x0042, zziz -> 0x0046, TryCatch #8 {zzcc -> 0x003e, zzgx -> 0x003a, zziz -> 0x0046, zzrq -> 0x0042, zztt -> 0x0036, IOException -> 0x0032, RuntimeException -> 0x002e, blocks: (B:3:0x0006, B:4:0x0011, B:6:0x0015, B:22:0x004a, B:23:0x004e, B:24:0x0052, B:28:0x0059, B:30:0x0062, B:32:0x0070, B:33:0x0077, B:34:0x0081, B:35:0x0094, B:36:0x00ab, B:37:0x00c1, B:39:0x00d0, B:40:0x00d4, B:41:0x00e5, B:43:0x00f4, B:44:0x0110, B:45:0x0123, B:46:0x012c, B:48:0x013e, B:49:0x014a, B:50:0x015a, B:52:0x0166, B:55:0x0171, B:56:0x0178, B:57:0x0185, B:61:0x018c, B:63:0x0194, B:65:0x0198, B:67:0x019e, B:69:0x01a6, B:71:0x01ae, B:72:0x01b1, B:74:0x01b6, B:81:0x01c3, B:82:0x01c4, B:86:0x01cb, B:88:0x01d9, B:89:0x01dc, B:90:0x01e1, B:92:0x01f1, B:93:0x01f4, B:94:0x01f9, B:95:0x01fe, B:97:0x020a, B:98:0x0216, B:100:0x0222, B:102:0x024e, B:103:0x026e, B:104:0x0273, B:105:0x0277, B:107:0x027c, B:108:0x028d, B:110:0x0299, B:111:0x029c, B:118:0x02a7, B:119:0x02a8, B:120:0x02ad, B:121:0x02b5, B:122:0x02c7, B:124:0x02ee, B:194:0x040b, B:174:0x03d2, B:173:0x03ce, B:198:0x0417, B:199:0x0424, B:125:0x0310, B:129:0x0323, B:131:0x0333, B:133:0x034a, B:135:0x0354, B:200:0x0425, B:202:0x0439, B:205:0x0443, B:207:0x0452, B:209:0x045e, B:211:0x0473, B:212:0x0478, B:213:0x047c, B:215:0x0480, B:217:0x048d, B:289:0x05e9, B:291:0x05f1, B:293:0x05f9, B:296:0x05fe, B:297:0x060a, B:299:0x0610, B:301:0x0618, B:304:0x0628, B:306:0x062e, B:307:0x064e, B:309:0x0654, B:311:0x0659, B:313:0x065e, B:315:0x0662, B:317:0x0668, B:319:0x066c, B:321:0x0674, B:323:0x067a, B:325:0x0684, B:328:0x068a, B:329:0x068d, B:331:0x0696, B:333:0x06a8, B:335:0x06b1, B:337:0x06b9, B:342:0x06c5, B:343:0x06f1, B:345:0x06f7, B:347:0x06fd, B:348:0x0704, B:220:0x049c, B:222:0x04a2, B:225:0x04ad, B:228:0x04b8, B:230:0x04bd, B:233:0x04cb, B:235:0x04d1, B:236:0x04d9, B:237:0x04dc, B:239:0x04e4, B:241:0x04f2, B:243:0x052e, B:245:0x0538, B:248:0x0543, B:250:0x054b, B:251:0x054e, B:252:0x0551, B:254:0x0557, B:256:0x0566, B:258:0x056c, B:260:0x0578, B:262:0x0582, B:264:0x0593, B:266:0x0599, B:267:0x05a4, B:268:0x05a9, B:270:0x05af, B:273:0x05b4, B:275:0x05ba, B:277:0x05c2, B:279:0x05c8, B:281:0x05ce, B:285:0x05dc, B:287:0x05e3, B:288:0x05e6, B:216:0x048a, B:351:0x0710, B:355:0x071b, B:357:0x0725, B:358:0x072a, B:360:0x0738, B:361:0x0750, B:363:0x0756, B:365:0x075e, B:367:0x0765, B:371:0x076e, B:376:0x077d, B:382:0x078a, B:384:0x0790, B:393:0x07a2, B:395:0x07a7, B:397:0x07b3, B:399:0x07b9, B:403:0x07c6, B:405:0x07ce, B:407:0x07d2, B:408:0x07dd, B:410:0x07e3, B:465:0x08d7, B:468:0x08df, B:470:0x08e4, B:472:0x08ec, B:474:0x08fa, B:475:0x0901, B:476:0x0905, B:478:0x090b, B:480:0x0914, B:482:0x091a, B:484:0x0925, B:491:0x0949, B:493:0x094f, B:497:0x0958, B:509:0x0978, B:505:0x096b, B:507:0x096f, B:508:0x0975, B:485:0x092c, B:488:0x093a, B:489:0x0941, B:490:0x0942, B:411:0x07ec, B:413:0x07f3, B:415:0x07f7, B:444:0x0880, B:446:0x088c, B:421:0x0806, B:423:0x080a, B:425:0x081e, B:427:0x082c, B:429:0x0838, B:433:0x0841, B:435:0x084b, B:441:0x0856, B:447:0x0890, B:449:0x0896, B:451:0x089a, B:455:0x08a3, B:457:0x08b3, B:459:0x08bb, B:461:0x08c5, B:462:0x08ca, B:463:0x08cf, B:464:0x08d4, B:396:0x07ac, B:510:0x097d, B:514:0x0984, B:515:0x098c, B:519:0x09aa), top: B:582:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:426:0x0827  */
    /* JADX WARN: Code duplicated, block: B:432:0x0840  */
    /* JADX WARN: Code duplicated, block: B:438:0x0851  */
    /* JADX WARN: Code duplicated, block: B:446:0x088c A[Catch: RuntimeException -> 0x002e, IOException -> 0x0032, zztt -> 0x0036, zzgx -> 0x003a, zzcc -> 0x003e, zzrq -> 0x0042, zziz -> 0x0046, TryCatch #8 {zzcc -> 0x003e, zzgx -> 0x003a, zziz -> 0x0046, zzrq -> 0x0042, zztt -> 0x0036, IOException -> 0x0032, RuntimeException -> 0x002e, blocks: (B:3:0x0006, B:4:0x0011, B:6:0x0015, B:22:0x004a, B:23:0x004e, B:24:0x0052, B:28:0x0059, B:30:0x0062, B:32:0x0070, B:33:0x0077, B:34:0x0081, B:35:0x0094, B:36:0x00ab, B:37:0x00c1, B:39:0x00d0, B:40:0x00d4, B:41:0x00e5, B:43:0x00f4, B:44:0x0110, B:45:0x0123, B:46:0x012c, B:48:0x013e, B:49:0x014a, B:50:0x015a, B:52:0x0166, B:55:0x0171, B:56:0x0178, B:57:0x0185, B:61:0x018c, B:63:0x0194, B:65:0x0198, B:67:0x019e, B:69:0x01a6, B:71:0x01ae, B:72:0x01b1, B:74:0x01b6, B:81:0x01c3, B:82:0x01c4, B:86:0x01cb, B:88:0x01d9, B:89:0x01dc, B:90:0x01e1, B:92:0x01f1, B:93:0x01f4, B:94:0x01f9, B:95:0x01fe, B:97:0x020a, B:98:0x0216, B:100:0x0222, B:102:0x024e, B:103:0x026e, B:104:0x0273, B:105:0x0277, B:107:0x027c, B:108:0x028d, B:110:0x0299, B:111:0x029c, B:118:0x02a7, B:119:0x02a8, B:120:0x02ad, B:121:0x02b5, B:122:0x02c7, B:124:0x02ee, B:194:0x040b, B:174:0x03d2, B:173:0x03ce, B:198:0x0417, B:199:0x0424, B:125:0x0310, B:129:0x0323, B:131:0x0333, B:133:0x034a, B:135:0x0354, B:200:0x0425, B:202:0x0439, B:205:0x0443, B:207:0x0452, B:209:0x045e, B:211:0x0473, B:212:0x0478, B:213:0x047c, B:215:0x0480, B:217:0x048d, B:289:0x05e9, B:291:0x05f1, B:293:0x05f9, B:296:0x05fe, B:297:0x060a, B:299:0x0610, B:301:0x0618, B:304:0x0628, B:306:0x062e, B:307:0x064e, B:309:0x0654, B:311:0x0659, B:313:0x065e, B:315:0x0662, B:317:0x0668, B:319:0x066c, B:321:0x0674, B:323:0x067a, B:325:0x0684, B:328:0x068a, B:329:0x068d, B:331:0x0696, B:333:0x06a8, B:335:0x06b1, B:337:0x06b9, B:342:0x06c5, B:343:0x06f1, B:345:0x06f7, B:347:0x06fd, B:348:0x0704, B:220:0x049c, B:222:0x04a2, B:225:0x04ad, B:228:0x04b8, B:230:0x04bd, B:233:0x04cb, B:235:0x04d1, B:236:0x04d9, B:237:0x04dc, B:239:0x04e4, B:241:0x04f2, B:243:0x052e, B:245:0x0538, B:248:0x0543, B:250:0x054b, B:251:0x054e, B:252:0x0551, B:254:0x0557, B:256:0x0566, B:258:0x056c, B:260:0x0578, B:262:0x0582, B:264:0x0593, B:266:0x0599, B:267:0x05a4, B:268:0x05a9, B:270:0x05af, B:273:0x05b4, B:275:0x05ba, B:277:0x05c2, B:279:0x05c8, B:281:0x05ce, B:285:0x05dc, B:287:0x05e3, B:288:0x05e6, B:216:0x048a, B:351:0x0710, B:355:0x071b, B:357:0x0725, B:358:0x072a, B:360:0x0738, B:361:0x0750, B:363:0x0756, B:365:0x075e, B:367:0x0765, B:371:0x076e, B:376:0x077d, B:382:0x078a, B:384:0x0790, B:393:0x07a2, B:395:0x07a7, B:397:0x07b3, B:399:0x07b9, B:403:0x07c6, B:405:0x07ce, B:407:0x07d2, B:408:0x07dd, B:410:0x07e3, B:465:0x08d7, B:468:0x08df, B:470:0x08e4, B:472:0x08ec, B:474:0x08fa, B:475:0x0901, B:476:0x0905, B:478:0x090b, B:480:0x0914, B:482:0x091a, B:484:0x0925, B:491:0x0949, B:493:0x094f, B:497:0x0958, B:509:0x0978, B:505:0x096b, B:507:0x096f, B:508:0x0975, B:485:0x092c, B:488:0x093a, B:489:0x0941, B:490:0x0942, B:411:0x07ec, B:413:0x07f3, B:415:0x07f7, B:444:0x0880, B:446:0x088c, B:421:0x0806, B:423:0x080a, B:425:0x081e, B:427:0x082c, B:429:0x0838, B:433:0x0841, B:435:0x084b, B:441:0x0856, B:447:0x0890, B:449:0x0896, B:451:0x089a, B:455:0x08a3, B:457:0x08b3, B:459:0x08bb, B:461:0x08c5, B:462:0x08ca, B:463:0x08cf, B:464:0x08d4, B:396:0x07ac, B:510:0x097d, B:514:0x0984, B:515:0x098c, B:519:0x09aa), top: B:582:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:449:0x0896 A[Catch: RuntimeException -> 0x002e, IOException -> 0x0032, zztt -> 0x0036, zzgx -> 0x003a, zzcc -> 0x003e, zzrq -> 0x0042, zziz -> 0x0046, TryCatch #8 {zzcc -> 0x003e, zzgx -> 0x003a, zziz -> 0x0046, zzrq -> 0x0042, zztt -> 0x0036, IOException -> 0x0032, RuntimeException -> 0x002e, blocks: (B:3:0x0006, B:4:0x0011, B:6:0x0015, B:22:0x004a, B:23:0x004e, B:24:0x0052, B:28:0x0059, B:30:0x0062, B:32:0x0070, B:33:0x0077, B:34:0x0081, B:35:0x0094, B:36:0x00ab, B:37:0x00c1, B:39:0x00d0, B:40:0x00d4, B:41:0x00e5, B:43:0x00f4, B:44:0x0110, B:45:0x0123, B:46:0x012c, B:48:0x013e, B:49:0x014a, B:50:0x015a, B:52:0x0166, B:55:0x0171, B:56:0x0178, B:57:0x0185, B:61:0x018c, B:63:0x0194, B:65:0x0198, B:67:0x019e, B:69:0x01a6, B:71:0x01ae, B:72:0x01b1, B:74:0x01b6, B:81:0x01c3, B:82:0x01c4, B:86:0x01cb, B:88:0x01d9, B:89:0x01dc, B:90:0x01e1, B:92:0x01f1, B:93:0x01f4, B:94:0x01f9, B:95:0x01fe, B:97:0x020a, B:98:0x0216, B:100:0x0222, B:102:0x024e, B:103:0x026e, B:104:0x0273, B:105:0x0277, B:107:0x027c, B:108:0x028d, B:110:0x0299, B:111:0x029c, B:118:0x02a7, B:119:0x02a8, B:120:0x02ad, B:121:0x02b5, B:122:0x02c7, B:124:0x02ee, B:194:0x040b, B:174:0x03d2, B:173:0x03ce, B:198:0x0417, B:199:0x0424, B:125:0x0310, B:129:0x0323, B:131:0x0333, B:133:0x034a, B:135:0x0354, B:200:0x0425, B:202:0x0439, B:205:0x0443, B:207:0x0452, B:209:0x045e, B:211:0x0473, B:212:0x0478, B:213:0x047c, B:215:0x0480, B:217:0x048d, B:289:0x05e9, B:291:0x05f1, B:293:0x05f9, B:296:0x05fe, B:297:0x060a, B:299:0x0610, B:301:0x0618, B:304:0x0628, B:306:0x062e, B:307:0x064e, B:309:0x0654, B:311:0x0659, B:313:0x065e, B:315:0x0662, B:317:0x0668, B:319:0x066c, B:321:0x0674, B:323:0x067a, B:325:0x0684, B:328:0x068a, B:329:0x068d, B:331:0x0696, B:333:0x06a8, B:335:0x06b1, B:337:0x06b9, B:342:0x06c5, B:343:0x06f1, B:345:0x06f7, B:347:0x06fd, B:348:0x0704, B:220:0x049c, B:222:0x04a2, B:225:0x04ad, B:228:0x04b8, B:230:0x04bd, B:233:0x04cb, B:235:0x04d1, B:236:0x04d9, B:237:0x04dc, B:239:0x04e4, B:241:0x04f2, B:243:0x052e, B:245:0x0538, B:248:0x0543, B:250:0x054b, B:251:0x054e, B:252:0x0551, B:254:0x0557, B:256:0x0566, B:258:0x056c, B:260:0x0578, B:262:0x0582, B:264:0x0593, B:266:0x0599, B:267:0x05a4, B:268:0x05a9, B:270:0x05af, B:273:0x05b4, B:275:0x05ba, B:277:0x05c2, B:279:0x05c8, B:281:0x05ce, B:285:0x05dc, B:287:0x05e3, B:288:0x05e6, B:216:0x048a, B:351:0x0710, B:355:0x071b, B:357:0x0725, B:358:0x072a, B:360:0x0738, B:361:0x0750, B:363:0x0756, B:365:0x075e, B:367:0x0765, B:371:0x076e, B:376:0x077d, B:382:0x078a, B:384:0x0790, B:393:0x07a2, B:395:0x07a7, B:397:0x07b3, B:399:0x07b9, B:403:0x07c6, B:405:0x07ce, B:407:0x07d2, B:408:0x07dd, B:410:0x07e3, B:465:0x08d7, B:468:0x08df, B:470:0x08e4, B:472:0x08ec, B:474:0x08fa, B:475:0x0901, B:476:0x0905, B:478:0x090b, B:480:0x0914, B:482:0x091a, B:484:0x0925, B:491:0x0949, B:493:0x094f, B:497:0x0958, B:509:0x0978, B:505:0x096b, B:507:0x096f, B:508:0x0975, B:485:0x092c, B:488:0x093a, B:489:0x0941, B:490:0x0942, B:411:0x07ec, B:413:0x07f3, B:415:0x07f7, B:444:0x0880, B:446:0x088c, B:421:0x0806, B:423:0x080a, B:425:0x081e, B:427:0x082c, B:429:0x0838, B:433:0x0841, B:435:0x084b, B:441:0x0856, B:447:0x0890, B:449:0x0896, B:451:0x089a, B:455:0x08a3, B:457:0x08b3, B:459:0x08bb, B:461:0x08c5, B:462:0x08ca, B:463:0x08cf, B:464:0x08d4, B:396:0x07ac, B:510:0x097d, B:514:0x0984, B:515:0x098c, B:519:0x09aa), top: B:582:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:451:0x089a A[Catch: RuntimeException -> 0x002e, IOException -> 0x0032, zztt -> 0x0036, zzgx -> 0x003a, zzcc -> 0x003e, zzrq -> 0x0042, zziz -> 0x0046, TryCatch #8 {zzcc -> 0x003e, zzgx -> 0x003a, zziz -> 0x0046, zzrq -> 0x0042, zztt -> 0x0036, IOException -> 0x0032, RuntimeException -> 0x002e, blocks: (B:3:0x0006, B:4:0x0011, B:6:0x0015, B:22:0x004a, B:23:0x004e, B:24:0x0052, B:28:0x0059, B:30:0x0062, B:32:0x0070, B:33:0x0077, B:34:0x0081, B:35:0x0094, B:36:0x00ab, B:37:0x00c1, B:39:0x00d0, B:40:0x00d4, B:41:0x00e5, B:43:0x00f4, B:44:0x0110, B:45:0x0123, B:46:0x012c, B:48:0x013e, B:49:0x014a, B:50:0x015a, B:52:0x0166, B:55:0x0171, B:56:0x0178, B:57:0x0185, B:61:0x018c, B:63:0x0194, B:65:0x0198, B:67:0x019e, B:69:0x01a6, B:71:0x01ae, B:72:0x01b1, B:74:0x01b6, B:81:0x01c3, B:82:0x01c4, B:86:0x01cb, B:88:0x01d9, B:89:0x01dc, B:90:0x01e1, B:92:0x01f1, B:93:0x01f4, B:94:0x01f9, B:95:0x01fe, B:97:0x020a, B:98:0x0216, B:100:0x0222, B:102:0x024e, B:103:0x026e, B:104:0x0273, B:105:0x0277, B:107:0x027c, B:108:0x028d, B:110:0x0299, B:111:0x029c, B:118:0x02a7, B:119:0x02a8, B:120:0x02ad, B:121:0x02b5, B:122:0x02c7, B:124:0x02ee, B:194:0x040b, B:174:0x03d2, B:173:0x03ce, B:198:0x0417, B:199:0x0424, B:125:0x0310, B:129:0x0323, B:131:0x0333, B:133:0x034a, B:135:0x0354, B:200:0x0425, B:202:0x0439, B:205:0x0443, B:207:0x0452, B:209:0x045e, B:211:0x0473, B:212:0x0478, B:213:0x047c, B:215:0x0480, B:217:0x048d, B:289:0x05e9, B:291:0x05f1, B:293:0x05f9, B:296:0x05fe, B:297:0x060a, B:299:0x0610, B:301:0x0618, B:304:0x0628, B:306:0x062e, B:307:0x064e, B:309:0x0654, B:311:0x0659, B:313:0x065e, B:315:0x0662, B:317:0x0668, B:319:0x066c, B:321:0x0674, B:323:0x067a, B:325:0x0684, B:328:0x068a, B:329:0x068d, B:331:0x0696, B:333:0x06a8, B:335:0x06b1, B:337:0x06b9, B:342:0x06c5, B:343:0x06f1, B:345:0x06f7, B:347:0x06fd, B:348:0x0704, B:220:0x049c, B:222:0x04a2, B:225:0x04ad, B:228:0x04b8, B:230:0x04bd, B:233:0x04cb, B:235:0x04d1, B:236:0x04d9, B:237:0x04dc, B:239:0x04e4, B:241:0x04f2, B:243:0x052e, B:245:0x0538, B:248:0x0543, B:250:0x054b, B:251:0x054e, B:252:0x0551, B:254:0x0557, B:256:0x0566, B:258:0x056c, B:260:0x0578, B:262:0x0582, B:264:0x0593, B:266:0x0599, B:267:0x05a4, B:268:0x05a9, B:270:0x05af, B:273:0x05b4, B:275:0x05ba, B:277:0x05c2, B:279:0x05c8, B:281:0x05ce, B:285:0x05dc, B:287:0x05e3, B:288:0x05e6, B:216:0x048a, B:351:0x0710, B:355:0x071b, B:357:0x0725, B:358:0x072a, B:360:0x0738, B:361:0x0750, B:363:0x0756, B:365:0x075e, B:367:0x0765, B:371:0x076e, B:376:0x077d, B:382:0x078a, B:384:0x0790, B:393:0x07a2, B:395:0x07a7, B:397:0x07b3, B:399:0x07b9, B:403:0x07c6, B:405:0x07ce, B:407:0x07d2, B:408:0x07dd, B:410:0x07e3, B:465:0x08d7, B:468:0x08df, B:470:0x08e4, B:472:0x08ec, B:474:0x08fa, B:475:0x0901, B:476:0x0905, B:478:0x090b, B:480:0x0914, B:482:0x091a, B:484:0x0925, B:491:0x0949, B:493:0x094f, B:497:0x0958, B:509:0x0978, B:505:0x096b, B:507:0x096f, B:508:0x0975, B:485:0x092c, B:488:0x093a, B:489:0x0941, B:490:0x0942, B:411:0x07ec, B:413:0x07f3, B:415:0x07f7, B:444:0x0880, B:446:0x088c, B:421:0x0806, B:423:0x080a, B:425:0x081e, B:427:0x082c, B:429:0x0838, B:433:0x0841, B:435:0x084b, B:441:0x0856, B:447:0x0890, B:449:0x0896, B:451:0x089a, B:455:0x08a3, B:457:0x08b3, B:459:0x08bb, B:461:0x08c5, B:462:0x08ca, B:463:0x08cf, B:464:0x08d4, B:396:0x07ac, B:510:0x097d, B:514:0x0984, B:515:0x098c, B:519:0x09aa), top: B:582:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:453:0x08a0  */
    /* JADX WARN: Code duplicated, block: B:454:0x08a1 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:455:0x08a3 A[Catch: RuntimeException -> 0x002e, IOException -> 0x0032, zztt -> 0x0036, zzgx -> 0x003a, zzcc -> 0x003e, zzrq -> 0x0042, zziz -> 0x0046, TryCatch #8 {zzcc -> 0x003e, zzgx -> 0x003a, zziz -> 0x0046, zzrq -> 0x0042, zztt -> 0x0036, IOException -> 0x0032, RuntimeException -> 0x002e, blocks: (B:3:0x0006, B:4:0x0011, B:6:0x0015, B:22:0x004a, B:23:0x004e, B:24:0x0052, B:28:0x0059, B:30:0x0062, B:32:0x0070, B:33:0x0077, B:34:0x0081, B:35:0x0094, B:36:0x00ab, B:37:0x00c1, B:39:0x00d0, B:40:0x00d4, B:41:0x00e5, B:43:0x00f4, B:44:0x0110, B:45:0x0123, B:46:0x012c, B:48:0x013e, B:49:0x014a, B:50:0x015a, B:52:0x0166, B:55:0x0171, B:56:0x0178, B:57:0x0185, B:61:0x018c, B:63:0x0194, B:65:0x0198, B:67:0x019e, B:69:0x01a6, B:71:0x01ae, B:72:0x01b1, B:74:0x01b6, B:81:0x01c3, B:82:0x01c4, B:86:0x01cb, B:88:0x01d9, B:89:0x01dc, B:90:0x01e1, B:92:0x01f1, B:93:0x01f4, B:94:0x01f9, B:95:0x01fe, B:97:0x020a, B:98:0x0216, B:100:0x0222, B:102:0x024e, B:103:0x026e, B:104:0x0273, B:105:0x0277, B:107:0x027c, B:108:0x028d, B:110:0x0299, B:111:0x029c, B:118:0x02a7, B:119:0x02a8, B:120:0x02ad, B:121:0x02b5, B:122:0x02c7, B:124:0x02ee, B:194:0x040b, B:174:0x03d2, B:173:0x03ce, B:198:0x0417, B:199:0x0424, B:125:0x0310, B:129:0x0323, B:131:0x0333, B:133:0x034a, B:135:0x0354, B:200:0x0425, B:202:0x0439, B:205:0x0443, B:207:0x0452, B:209:0x045e, B:211:0x0473, B:212:0x0478, B:213:0x047c, B:215:0x0480, B:217:0x048d, B:289:0x05e9, B:291:0x05f1, B:293:0x05f9, B:296:0x05fe, B:297:0x060a, B:299:0x0610, B:301:0x0618, B:304:0x0628, B:306:0x062e, B:307:0x064e, B:309:0x0654, B:311:0x0659, B:313:0x065e, B:315:0x0662, B:317:0x0668, B:319:0x066c, B:321:0x0674, B:323:0x067a, B:325:0x0684, B:328:0x068a, B:329:0x068d, B:331:0x0696, B:333:0x06a8, B:335:0x06b1, B:337:0x06b9, B:342:0x06c5, B:343:0x06f1, B:345:0x06f7, B:347:0x06fd, B:348:0x0704, B:220:0x049c, B:222:0x04a2, B:225:0x04ad, B:228:0x04b8, B:230:0x04bd, B:233:0x04cb, B:235:0x04d1, B:236:0x04d9, B:237:0x04dc, B:239:0x04e4, B:241:0x04f2, B:243:0x052e, B:245:0x0538, B:248:0x0543, B:250:0x054b, B:251:0x054e, B:252:0x0551, B:254:0x0557, B:256:0x0566, B:258:0x056c, B:260:0x0578, B:262:0x0582, B:264:0x0593, B:266:0x0599, B:267:0x05a4, B:268:0x05a9, B:270:0x05af, B:273:0x05b4, B:275:0x05ba, B:277:0x05c2, B:279:0x05c8, B:281:0x05ce, B:285:0x05dc, B:287:0x05e3, B:288:0x05e6, B:216:0x048a, B:351:0x0710, B:355:0x071b, B:357:0x0725, B:358:0x072a, B:360:0x0738, B:361:0x0750, B:363:0x0756, B:365:0x075e, B:367:0x0765, B:371:0x076e, B:376:0x077d, B:382:0x078a, B:384:0x0790, B:393:0x07a2, B:395:0x07a7, B:397:0x07b3, B:399:0x07b9, B:403:0x07c6, B:405:0x07ce, B:407:0x07d2, B:408:0x07dd, B:410:0x07e3, B:465:0x08d7, B:468:0x08df, B:470:0x08e4, B:472:0x08ec, B:474:0x08fa, B:475:0x0901, B:476:0x0905, B:478:0x090b, B:480:0x0914, B:482:0x091a, B:484:0x0925, B:491:0x0949, B:493:0x094f, B:497:0x0958, B:509:0x0978, B:505:0x096b, B:507:0x096f, B:508:0x0975, B:485:0x092c, B:488:0x093a, B:489:0x0941, B:490:0x0942, B:411:0x07ec, B:413:0x07f3, B:415:0x07f7, B:444:0x0880, B:446:0x088c, B:421:0x0806, B:423:0x080a, B:425:0x081e, B:427:0x082c, B:429:0x0838, B:433:0x0841, B:435:0x084b, B:441:0x0856, B:447:0x0890, B:449:0x0896, B:451:0x089a, B:455:0x08a3, B:457:0x08b3, B:459:0x08bb, B:461:0x08c5, B:462:0x08ca, B:463:0x08cf, B:464:0x08d4, B:396:0x07ac, B:510:0x097d, B:514:0x0984, B:515:0x098c, B:519:0x09aa), top: B:582:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:457:0x08b3 A[Catch: RuntimeException -> 0x002e, IOException -> 0x0032, zztt -> 0x0036, zzgx -> 0x003a, zzcc -> 0x003e, zzrq -> 0x0042, zziz -> 0x0046, TryCatch #8 {zzcc -> 0x003e, zzgx -> 0x003a, zziz -> 0x0046, zzrq -> 0x0042, zztt -> 0x0036, IOException -> 0x0032, RuntimeException -> 0x002e, blocks: (B:3:0x0006, B:4:0x0011, B:6:0x0015, B:22:0x004a, B:23:0x004e, B:24:0x0052, B:28:0x0059, B:30:0x0062, B:32:0x0070, B:33:0x0077, B:34:0x0081, B:35:0x0094, B:36:0x00ab, B:37:0x00c1, B:39:0x00d0, B:40:0x00d4, B:41:0x00e5, B:43:0x00f4, B:44:0x0110, B:45:0x0123, B:46:0x012c, B:48:0x013e, B:49:0x014a, B:50:0x015a, B:52:0x0166, B:55:0x0171, B:56:0x0178, B:57:0x0185, B:61:0x018c, B:63:0x0194, B:65:0x0198, B:67:0x019e, B:69:0x01a6, B:71:0x01ae, B:72:0x01b1, B:74:0x01b6, B:81:0x01c3, B:82:0x01c4, B:86:0x01cb, B:88:0x01d9, B:89:0x01dc, B:90:0x01e1, B:92:0x01f1, B:93:0x01f4, B:94:0x01f9, B:95:0x01fe, B:97:0x020a, B:98:0x0216, B:100:0x0222, B:102:0x024e, B:103:0x026e, B:104:0x0273, B:105:0x0277, B:107:0x027c, B:108:0x028d, B:110:0x0299, B:111:0x029c, B:118:0x02a7, B:119:0x02a8, B:120:0x02ad, B:121:0x02b5, B:122:0x02c7, B:124:0x02ee, B:194:0x040b, B:174:0x03d2, B:173:0x03ce, B:198:0x0417, B:199:0x0424, B:125:0x0310, B:129:0x0323, B:131:0x0333, B:133:0x034a, B:135:0x0354, B:200:0x0425, B:202:0x0439, B:205:0x0443, B:207:0x0452, B:209:0x045e, B:211:0x0473, B:212:0x0478, B:213:0x047c, B:215:0x0480, B:217:0x048d, B:289:0x05e9, B:291:0x05f1, B:293:0x05f9, B:296:0x05fe, B:297:0x060a, B:299:0x0610, B:301:0x0618, B:304:0x0628, B:306:0x062e, B:307:0x064e, B:309:0x0654, B:311:0x0659, B:313:0x065e, B:315:0x0662, B:317:0x0668, B:319:0x066c, B:321:0x0674, B:323:0x067a, B:325:0x0684, B:328:0x068a, B:329:0x068d, B:331:0x0696, B:333:0x06a8, B:335:0x06b1, B:337:0x06b9, B:342:0x06c5, B:343:0x06f1, B:345:0x06f7, B:347:0x06fd, B:348:0x0704, B:220:0x049c, B:222:0x04a2, B:225:0x04ad, B:228:0x04b8, B:230:0x04bd, B:233:0x04cb, B:235:0x04d1, B:236:0x04d9, B:237:0x04dc, B:239:0x04e4, B:241:0x04f2, B:243:0x052e, B:245:0x0538, B:248:0x0543, B:250:0x054b, B:251:0x054e, B:252:0x0551, B:254:0x0557, B:256:0x0566, B:258:0x056c, B:260:0x0578, B:262:0x0582, B:264:0x0593, B:266:0x0599, B:267:0x05a4, B:268:0x05a9, B:270:0x05af, B:273:0x05b4, B:275:0x05ba, B:277:0x05c2, B:279:0x05c8, B:281:0x05ce, B:285:0x05dc, B:287:0x05e3, B:288:0x05e6, B:216:0x048a, B:351:0x0710, B:355:0x071b, B:357:0x0725, B:358:0x072a, B:360:0x0738, B:361:0x0750, B:363:0x0756, B:365:0x075e, B:367:0x0765, B:371:0x076e, B:376:0x077d, B:382:0x078a, B:384:0x0790, B:393:0x07a2, B:395:0x07a7, B:397:0x07b3, B:399:0x07b9, B:403:0x07c6, B:405:0x07ce, B:407:0x07d2, B:408:0x07dd, B:410:0x07e3, B:465:0x08d7, B:468:0x08df, B:470:0x08e4, B:472:0x08ec, B:474:0x08fa, B:475:0x0901, B:476:0x0905, B:478:0x090b, B:480:0x0914, B:482:0x091a, B:484:0x0925, B:491:0x0949, B:493:0x094f, B:497:0x0958, B:509:0x0978, B:505:0x096b, B:507:0x096f, B:508:0x0975, B:485:0x092c, B:488:0x093a, B:489:0x0941, B:490:0x0942, B:411:0x07ec, B:413:0x07f3, B:415:0x07f7, B:444:0x0880, B:446:0x088c, B:421:0x0806, B:423:0x080a, B:425:0x081e, B:427:0x082c, B:429:0x0838, B:433:0x0841, B:435:0x084b, B:441:0x0856, B:447:0x0890, B:449:0x0896, B:451:0x089a, B:455:0x08a3, B:457:0x08b3, B:459:0x08bb, B:461:0x08c5, B:462:0x08ca, B:463:0x08cf, B:464:0x08d4, B:396:0x07ac, B:510:0x097d, B:514:0x0984, B:515:0x098c, B:519:0x09aa), top: B:582:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:459:0x08bb A[Catch: RuntimeException -> 0x002e, IOException -> 0x0032, zztt -> 0x0036, zzgx -> 0x003a, zzcc -> 0x003e, zzrq -> 0x0042, zziz -> 0x0046, TryCatch #8 {zzcc -> 0x003e, zzgx -> 0x003a, zziz -> 0x0046, zzrq -> 0x0042, zztt -> 0x0036, IOException -> 0x0032, RuntimeException -> 0x002e, blocks: (B:3:0x0006, B:4:0x0011, B:6:0x0015, B:22:0x004a, B:23:0x004e, B:24:0x0052, B:28:0x0059, B:30:0x0062, B:32:0x0070, B:33:0x0077, B:34:0x0081, B:35:0x0094, B:36:0x00ab, B:37:0x00c1, B:39:0x00d0, B:40:0x00d4, B:41:0x00e5, B:43:0x00f4, B:44:0x0110, B:45:0x0123, B:46:0x012c, B:48:0x013e, B:49:0x014a, B:50:0x015a, B:52:0x0166, B:55:0x0171, B:56:0x0178, B:57:0x0185, B:61:0x018c, B:63:0x0194, B:65:0x0198, B:67:0x019e, B:69:0x01a6, B:71:0x01ae, B:72:0x01b1, B:74:0x01b6, B:81:0x01c3, B:82:0x01c4, B:86:0x01cb, B:88:0x01d9, B:89:0x01dc, B:90:0x01e1, B:92:0x01f1, B:93:0x01f4, B:94:0x01f9, B:95:0x01fe, B:97:0x020a, B:98:0x0216, B:100:0x0222, B:102:0x024e, B:103:0x026e, B:104:0x0273, B:105:0x0277, B:107:0x027c, B:108:0x028d, B:110:0x0299, B:111:0x029c, B:118:0x02a7, B:119:0x02a8, B:120:0x02ad, B:121:0x02b5, B:122:0x02c7, B:124:0x02ee, B:194:0x040b, B:174:0x03d2, B:173:0x03ce, B:198:0x0417, B:199:0x0424, B:125:0x0310, B:129:0x0323, B:131:0x0333, B:133:0x034a, B:135:0x0354, B:200:0x0425, B:202:0x0439, B:205:0x0443, B:207:0x0452, B:209:0x045e, B:211:0x0473, B:212:0x0478, B:213:0x047c, B:215:0x0480, B:217:0x048d, B:289:0x05e9, B:291:0x05f1, B:293:0x05f9, B:296:0x05fe, B:297:0x060a, B:299:0x0610, B:301:0x0618, B:304:0x0628, B:306:0x062e, B:307:0x064e, B:309:0x0654, B:311:0x0659, B:313:0x065e, B:315:0x0662, B:317:0x0668, B:319:0x066c, B:321:0x0674, B:323:0x067a, B:325:0x0684, B:328:0x068a, B:329:0x068d, B:331:0x0696, B:333:0x06a8, B:335:0x06b1, B:337:0x06b9, B:342:0x06c5, B:343:0x06f1, B:345:0x06f7, B:347:0x06fd, B:348:0x0704, B:220:0x049c, B:222:0x04a2, B:225:0x04ad, B:228:0x04b8, B:230:0x04bd, B:233:0x04cb, B:235:0x04d1, B:236:0x04d9, B:237:0x04dc, B:239:0x04e4, B:241:0x04f2, B:243:0x052e, B:245:0x0538, B:248:0x0543, B:250:0x054b, B:251:0x054e, B:252:0x0551, B:254:0x0557, B:256:0x0566, B:258:0x056c, B:260:0x0578, B:262:0x0582, B:264:0x0593, B:266:0x0599, B:267:0x05a4, B:268:0x05a9, B:270:0x05af, B:273:0x05b4, B:275:0x05ba, B:277:0x05c2, B:279:0x05c8, B:281:0x05ce, B:285:0x05dc, B:287:0x05e3, B:288:0x05e6, B:216:0x048a, B:351:0x0710, B:355:0x071b, B:357:0x0725, B:358:0x072a, B:360:0x0738, B:361:0x0750, B:363:0x0756, B:365:0x075e, B:367:0x0765, B:371:0x076e, B:376:0x077d, B:382:0x078a, B:384:0x0790, B:393:0x07a2, B:395:0x07a7, B:397:0x07b3, B:399:0x07b9, B:403:0x07c6, B:405:0x07ce, B:407:0x07d2, B:408:0x07dd, B:410:0x07e3, B:465:0x08d7, B:468:0x08df, B:470:0x08e4, B:472:0x08ec, B:474:0x08fa, B:475:0x0901, B:476:0x0905, B:478:0x090b, B:480:0x0914, B:482:0x091a, B:484:0x0925, B:491:0x0949, B:493:0x094f, B:497:0x0958, B:509:0x0978, B:505:0x096b, B:507:0x096f, B:508:0x0975, B:485:0x092c, B:488:0x093a, B:489:0x0941, B:490:0x0942, B:411:0x07ec, B:413:0x07f3, B:415:0x07f7, B:444:0x0880, B:446:0x088c, B:421:0x0806, B:423:0x080a, B:425:0x081e, B:427:0x082c, B:429:0x0838, B:433:0x0841, B:435:0x084b, B:441:0x0856, B:447:0x0890, B:449:0x0896, B:451:0x089a, B:455:0x08a3, B:457:0x08b3, B:459:0x08bb, B:461:0x08c5, B:462:0x08ca, B:463:0x08cf, B:464:0x08d4, B:396:0x07ac, B:510:0x097d, B:514:0x0984, B:515:0x098c, B:519:0x09aa), top: B:582:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:461:0x08c5 A[Catch: RuntimeException -> 0x002e, IOException -> 0x0032, zztt -> 0x0036, zzgx -> 0x003a, zzcc -> 0x003e, zzrq -> 0x0042, zziz -> 0x0046, LOOP:12: B:460:0x08c3->B:461:0x08c5, LOOP_END, TryCatch #8 {zzcc -> 0x003e, zzgx -> 0x003a, zziz -> 0x0046, zzrq -> 0x0042, zztt -> 0x0036, IOException -> 0x0032, RuntimeException -> 0x002e, blocks: (B:3:0x0006, B:4:0x0011, B:6:0x0015, B:22:0x004a, B:23:0x004e, B:24:0x0052, B:28:0x0059, B:30:0x0062, B:32:0x0070, B:33:0x0077, B:34:0x0081, B:35:0x0094, B:36:0x00ab, B:37:0x00c1, B:39:0x00d0, B:40:0x00d4, B:41:0x00e5, B:43:0x00f4, B:44:0x0110, B:45:0x0123, B:46:0x012c, B:48:0x013e, B:49:0x014a, B:50:0x015a, B:52:0x0166, B:55:0x0171, B:56:0x0178, B:57:0x0185, B:61:0x018c, B:63:0x0194, B:65:0x0198, B:67:0x019e, B:69:0x01a6, B:71:0x01ae, B:72:0x01b1, B:74:0x01b6, B:81:0x01c3, B:82:0x01c4, B:86:0x01cb, B:88:0x01d9, B:89:0x01dc, B:90:0x01e1, B:92:0x01f1, B:93:0x01f4, B:94:0x01f9, B:95:0x01fe, B:97:0x020a, B:98:0x0216, B:100:0x0222, B:102:0x024e, B:103:0x026e, B:104:0x0273, B:105:0x0277, B:107:0x027c, B:108:0x028d, B:110:0x0299, B:111:0x029c, B:118:0x02a7, B:119:0x02a8, B:120:0x02ad, B:121:0x02b5, B:122:0x02c7, B:124:0x02ee, B:194:0x040b, B:174:0x03d2, B:173:0x03ce, B:198:0x0417, B:199:0x0424, B:125:0x0310, B:129:0x0323, B:131:0x0333, B:133:0x034a, B:135:0x0354, B:200:0x0425, B:202:0x0439, B:205:0x0443, B:207:0x0452, B:209:0x045e, B:211:0x0473, B:212:0x0478, B:213:0x047c, B:215:0x0480, B:217:0x048d, B:289:0x05e9, B:291:0x05f1, B:293:0x05f9, B:296:0x05fe, B:297:0x060a, B:299:0x0610, B:301:0x0618, B:304:0x0628, B:306:0x062e, B:307:0x064e, B:309:0x0654, B:311:0x0659, B:313:0x065e, B:315:0x0662, B:317:0x0668, B:319:0x066c, B:321:0x0674, B:323:0x067a, B:325:0x0684, B:328:0x068a, B:329:0x068d, B:331:0x0696, B:333:0x06a8, B:335:0x06b1, B:337:0x06b9, B:342:0x06c5, B:343:0x06f1, B:345:0x06f7, B:347:0x06fd, B:348:0x0704, B:220:0x049c, B:222:0x04a2, B:225:0x04ad, B:228:0x04b8, B:230:0x04bd, B:233:0x04cb, B:235:0x04d1, B:236:0x04d9, B:237:0x04dc, B:239:0x04e4, B:241:0x04f2, B:243:0x052e, B:245:0x0538, B:248:0x0543, B:250:0x054b, B:251:0x054e, B:252:0x0551, B:254:0x0557, B:256:0x0566, B:258:0x056c, B:260:0x0578, B:262:0x0582, B:264:0x0593, B:266:0x0599, B:267:0x05a4, B:268:0x05a9, B:270:0x05af, B:273:0x05b4, B:275:0x05ba, B:277:0x05c2, B:279:0x05c8, B:281:0x05ce, B:285:0x05dc, B:287:0x05e3, B:288:0x05e6, B:216:0x048a, B:351:0x0710, B:355:0x071b, B:357:0x0725, B:358:0x072a, B:360:0x0738, B:361:0x0750, B:363:0x0756, B:365:0x075e, B:367:0x0765, B:371:0x076e, B:376:0x077d, B:382:0x078a, B:384:0x0790, B:393:0x07a2, B:395:0x07a7, B:397:0x07b3, B:399:0x07b9, B:403:0x07c6, B:405:0x07ce, B:407:0x07d2, B:408:0x07dd, B:410:0x07e3, B:465:0x08d7, B:468:0x08df, B:470:0x08e4, B:472:0x08ec, B:474:0x08fa, B:475:0x0901, B:476:0x0905, B:478:0x090b, B:480:0x0914, B:482:0x091a, B:484:0x0925, B:491:0x0949, B:493:0x094f, B:497:0x0958, B:509:0x0978, B:505:0x096b, B:507:0x096f, B:508:0x0975, B:485:0x092c, B:488:0x093a, B:489:0x0941, B:490:0x0942, B:411:0x07ec, B:413:0x07f3, B:415:0x07f7, B:444:0x0880, B:446:0x088c, B:421:0x0806, B:423:0x080a, B:425:0x081e, B:427:0x082c, B:429:0x0838, B:433:0x0841, B:435:0x084b, B:441:0x0856, B:447:0x0890, B:449:0x0896, B:451:0x089a, B:455:0x08a3, B:457:0x08b3, B:459:0x08bb, B:461:0x08c5, B:462:0x08ca, B:463:0x08cf, B:464:0x08d4, B:396:0x07ac, B:510:0x097d, B:514:0x0984, B:515:0x098c, B:519:0x09aa), top: B:582:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:490:0x0942 A[Catch: RuntimeException -> 0x002e, IOException -> 0x0032, zztt -> 0x0036, zzgx -> 0x003a, zzcc -> 0x003e, zzrq -> 0x0042, zziz -> 0x0046, TryCatch #8 {zzcc -> 0x003e, zzgx -> 0x003a, zziz -> 0x0046, zzrq -> 0x0042, zztt -> 0x0036, IOException -> 0x0032, RuntimeException -> 0x002e, blocks: (B:3:0x0006, B:4:0x0011, B:6:0x0015, B:22:0x004a, B:23:0x004e, B:24:0x0052, B:28:0x0059, B:30:0x0062, B:32:0x0070, B:33:0x0077, B:34:0x0081, B:35:0x0094, B:36:0x00ab, B:37:0x00c1, B:39:0x00d0, B:40:0x00d4, B:41:0x00e5, B:43:0x00f4, B:44:0x0110, B:45:0x0123, B:46:0x012c, B:48:0x013e, B:49:0x014a, B:50:0x015a, B:52:0x0166, B:55:0x0171, B:56:0x0178, B:57:0x0185, B:61:0x018c, B:63:0x0194, B:65:0x0198, B:67:0x019e, B:69:0x01a6, B:71:0x01ae, B:72:0x01b1, B:74:0x01b6, B:81:0x01c3, B:82:0x01c4, B:86:0x01cb, B:88:0x01d9, B:89:0x01dc, B:90:0x01e1, B:92:0x01f1, B:93:0x01f4, B:94:0x01f9, B:95:0x01fe, B:97:0x020a, B:98:0x0216, B:100:0x0222, B:102:0x024e, B:103:0x026e, B:104:0x0273, B:105:0x0277, B:107:0x027c, B:108:0x028d, B:110:0x0299, B:111:0x029c, B:118:0x02a7, B:119:0x02a8, B:120:0x02ad, B:121:0x02b5, B:122:0x02c7, B:124:0x02ee, B:194:0x040b, B:174:0x03d2, B:173:0x03ce, B:198:0x0417, B:199:0x0424, B:125:0x0310, B:129:0x0323, B:131:0x0333, B:133:0x034a, B:135:0x0354, B:200:0x0425, B:202:0x0439, B:205:0x0443, B:207:0x0452, B:209:0x045e, B:211:0x0473, B:212:0x0478, B:213:0x047c, B:215:0x0480, B:217:0x048d, B:289:0x05e9, B:291:0x05f1, B:293:0x05f9, B:296:0x05fe, B:297:0x060a, B:299:0x0610, B:301:0x0618, B:304:0x0628, B:306:0x062e, B:307:0x064e, B:309:0x0654, B:311:0x0659, B:313:0x065e, B:315:0x0662, B:317:0x0668, B:319:0x066c, B:321:0x0674, B:323:0x067a, B:325:0x0684, B:328:0x068a, B:329:0x068d, B:331:0x0696, B:333:0x06a8, B:335:0x06b1, B:337:0x06b9, B:342:0x06c5, B:343:0x06f1, B:345:0x06f7, B:347:0x06fd, B:348:0x0704, B:220:0x049c, B:222:0x04a2, B:225:0x04ad, B:228:0x04b8, B:230:0x04bd, B:233:0x04cb, B:235:0x04d1, B:236:0x04d9, B:237:0x04dc, B:239:0x04e4, B:241:0x04f2, B:243:0x052e, B:245:0x0538, B:248:0x0543, B:250:0x054b, B:251:0x054e, B:252:0x0551, B:254:0x0557, B:256:0x0566, B:258:0x056c, B:260:0x0578, B:262:0x0582, B:264:0x0593, B:266:0x0599, B:267:0x05a4, B:268:0x05a9, B:270:0x05af, B:273:0x05b4, B:275:0x05ba, B:277:0x05c2, B:279:0x05c8, B:281:0x05ce, B:285:0x05dc, B:287:0x05e3, B:288:0x05e6, B:216:0x048a, B:351:0x0710, B:355:0x071b, B:357:0x0725, B:358:0x072a, B:360:0x0738, B:361:0x0750, B:363:0x0756, B:365:0x075e, B:367:0x0765, B:371:0x076e, B:376:0x077d, B:382:0x078a, B:384:0x0790, B:393:0x07a2, B:395:0x07a7, B:397:0x07b3, B:399:0x07b9, B:403:0x07c6, B:405:0x07ce, B:407:0x07d2, B:408:0x07dd, B:410:0x07e3, B:465:0x08d7, B:468:0x08df, B:470:0x08e4, B:472:0x08ec, B:474:0x08fa, B:475:0x0901, B:476:0x0905, B:478:0x090b, B:480:0x0914, B:482:0x091a, B:484:0x0925, B:491:0x0949, B:493:0x094f, B:497:0x0958, B:509:0x0978, B:505:0x096b, B:507:0x096f, B:508:0x0975, B:485:0x092c, B:488:0x093a, B:489:0x0941, B:490:0x0942, B:411:0x07ec, B:413:0x07f3, B:415:0x07f7, B:444:0x0880, B:446:0x088c, B:421:0x0806, B:423:0x080a, B:425:0x081e, B:427:0x082c, B:429:0x0838, B:433:0x0841, B:435:0x084b, B:441:0x0856, B:447:0x0890, B:449:0x0896, B:451:0x089a, B:455:0x08a3, B:457:0x08b3, B:459:0x08bb, B:461:0x08c5, B:462:0x08ca, B:463:0x08cf, B:464:0x08d4, B:396:0x07ac, B:510:0x097d, B:514:0x0984, B:515:0x098c, B:519:0x09aa), top: B:582:0x0006 }] */
    /* JADX WARN: Code duplicated, block: B:602:0x0704 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:459:0x08bb, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v35, types: [com.google.android.gms.internal.ads.zzhy, com.google.android.gms.internal.ads.zzyw] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) throws Throwable {
        boolean z11;
        boolean z12;
        zzli zzliVarZzf;
        boolean z13;
        boolean z14;
        zzly zzlyVar;
        int i11;
        zzli zzliVarZze;
        int i12;
        zzli zzliVarZze2;
        long jZzb;
        zzli zzliVarZzd;
        boolean z15;
        boolean z16;
        zzli zzliVarZze3;
        zzli zzliVarZzg;
        boolean z17;
        zzyp zzypVarZzi;
        int i13;
        zzlj zzljVarZzg;
        long jLongValue;
        long j11;
        boolean z18;
        zzur zzurVar;
        zzur zzurVar2;
        Throwable th2;
        Throwable th3;
        long j12;
        long jZza;
        long j13;
        zzly zzlyVar2;
        int i14;
        zzly zzlyVarZzz;
        try {
            switch (message.what) {
                case 0:
                    this.zzv.zza(1);
                    zzM(false, false, false, true);
                    this.zzf.zzb();
                    zzU(true != this.zzu.zza.zzo() ? 2 : 4);
                    this.zzr.zzg(this.zzg);
                    this.zzh.zzi(2);
                    z11 = true;
                    zzJ();
                    return z11;
                case 1:
                    zzT(message.arg1 != 0, message.arg2, true, 1);
                    z11 = true;
                    zzJ();
                    return z11;
                case 2:
                    int i15 = 4;
                    long jUptimeMillis = SystemClock.uptimeMillis();
                    this.zzh.zzf(2);
                    if (!this.zzu.zza.zzo() && this.zzr.zzj()) {
                        this.zzq.zzl(this.zzH);
                        if (this.zzq.zzo() && (zzljVarZzg = this.zzq.zzg(this.zzH, this.zzu)) != null) {
                            zzli zzliVarZzc = this.zzq.zzc(zzljVarZzg);
                            zzliVarZzc.zza.zzl(this, zzljVarZzg.zzb);
                            if (this.zzq.zze() == zzliVarZzc) {
                                zzO(zzljVarZzg.zzb);
                            }
                            zzE(false);
                        }
                        if (this.zzB) {
                            this.zzB = zzae();
                            zzY();
                        } else {
                            zzI();
                        }
                        zzli zzliVarZzf2 = this.zzq.zzf();
                        if (zzliVarZzf2 != null) {
                            if (zzliVarZzf2.zzg() != null && !this.zzy) {
                                zzli zzliVarZzf3 = this.zzq.zzf();
                                if (zzliVarZzf3.zzd) {
                                    int i16 = 0;
                                    while (true) {
                                        zzmf[] zzmfVarArr = this.zza;
                                        int length = zzmfVarArr.length;
                                        if (i16 < 2) {
                                            zzmf zzmfVar = zzmfVarArr[i16];
                                            zzwh zzwhVar = zzliVarZzf3.zzc[i16];
                                            if (zzmfVar.zzo() == zzwhVar) {
                                                if (zzwhVar == null || zzmfVar.zzP()) {
                                                    i16++;
                                                } else {
                                                    zzliVarZzf3.zzg();
                                                    boolean z19 = zzliVarZzf3.zzf.zzf;
                                                }
                                            }
                                        } else if (zzliVarZzf2.zzg().zzd || this.zzH >= zzliVarZzf2.zzg().zzf()) {
                                            zzyp zzypVarZzi2 = zzliVarZzf2.zzi();
                                            zzli zzliVarZzb = this.zzq.zzb();
                                            zzyp zzypVarZzi3 = zzliVarZzb.zzi();
                                            zzcx zzcxVar = this.zzu.zza;
                                            zzyp zzypVar = zzypVarZzi3;
                                            zzab(zzcxVar, zzliVarZzb.zzf.zza, zzcxVar, zzliVarZzf2.zzf.zza, C.TIME_UNSET, false);
                                            if (!zzliVarZzb.zzd || zzliVarZzb.zza.zzd() == C.TIME_UNSET) {
                                                int i17 = 0;
                                                while (true) {
                                                    int length2 = this.zza.length;
                                                    if (i17 < 2) {
                                                        boolean zZzb = zzypVarZzi2.zzb(i17);
                                                        zzyp zzypVar2 = zzypVar;
                                                        boolean zZzb2 = zzypVar2.zzb(i17);
                                                        if (zZzb && !this.zza[i17].zzQ()) {
                                                            this.zzc[i17].zzbj();
                                                            zzmi zzmiVar = zzypVarZzi2.zzb[i17];
                                                            zzmi zzmiVar2 = zzypVar2.zzb[i17];
                                                            if (!zZzb2 || !zzmiVar2.equals(zzmiVar)) {
                                                                zzan(this.zza[i17], zzliVarZzb.zzf());
                                                            }
                                                        }
                                                        i17++;
                                                        zzypVar = zzypVar2;
                                                    }
                                                }
                                            } else {
                                                long jZzf = zzliVarZzb.zzf();
                                                zzmf[] zzmfVarArr2 = this.zza;
                                                int length3 = zzmfVarArr2.length;
                                                for (int i18 = 0; i18 < 2; i18++) {
                                                    zzmf zzmfVar2 = zzmfVarArr2[i18];
                                                    if (zzmfVar2.zzo() != null) {
                                                        zzan(zzmfVar2, jZzf);
                                                    }
                                                }
                                                if (!zzliVarZzb.zzr()) {
                                                    this.zzq.zzn(zzliVarZzb);
                                                    zzE(false);
                                                    zzI();
                                                }
                                            }
                                        }
                                    }
                                }
                            } else if (zzliVarZzf2.zzf.zzi || this.zzy) {
                                int i19 = 0;
                                while (true) {
                                    zzmf[] zzmfVarArr3 = this.zza;
                                    int length4 = zzmfVarArr3.length;
                                    if (i19 < 2) {
                                        zzmf zzmfVar3 = zzmfVarArr3[i19];
                                        zzwh zzwhVar2 = zzliVarZzf2.zzc[i19];
                                        if (zzwhVar2 != null && zzmfVar3.zzo() == zzwhVar2 && zzmfVar3.zzP()) {
                                            long j14 = zzliVarZzf2.zzf.zze;
                                            zzan(zzmfVar3, (j14 == C.TIME_UNSET || j14 == Long.MIN_VALUE) ? -9223372036854775807L : zzliVarZzf2.zze() + j14);
                                        }
                                        i19++;
                                    }
                                }
                            }
                        }
                        zzli zzliVarZzf4 = this.zzq.zzf();
                        if (zzliVarZzf4 != null && this.zzq.zze() != zzliVarZzf4 && !zzliVarZzf4.zzg) {
                            zzli zzliVarZzf5 = this.zzq.zzf();
                            zzyp zzypVarZzi4 = zzliVarZzf5.zzi();
                            int i21 = 0;
                            boolean z21 = false;
                            while (true) {
                                zzmf[] zzmfVarArr4 = this.zza;
                                int length5 = zzmfVarArr4.length;
                                if (i21 < 2) {
                                    zzmf zzmfVar4 = zzmfVarArr4[i21];
                                    if (zzaf(zzmfVar4)) {
                                        zzwh zzwhVarZzo = zzmfVar4.zzo();
                                        zzwh zzwhVar3 = zzliVarZzf5.zzc[i21];
                                        if (!zzypVarZzi4.zzb(i21) || zzwhVarZzo != zzwhVar3) {
                                            if (!zzmfVar4.zzQ()) {
                                                zzmfVar4.zzG(zzak(zzypVarZzi4.zzc[i21]), zzliVarZzf5.zzc[i21], zzliVarZzf5.zzf(), zzliVarZzf5.zze(), zzliVarZzf5.zzf.zza);
                                            } else if (zzmfVar4.zzV()) {
                                                zzA(zzmfVar4);
                                            } else {
                                                z21 = true;
                                            }
                                        }
                                    }
                                    i21++;
                                } else if (!z21) {
                                    zzB();
                                }
                            }
                        }
                        boolean z22 = false;
                        while (zzai() && !this.zzy && (zzliVarZze3 = this.zzq.zze()) != null && (zzliVarZzg = zzliVarZze3.zzg()) != null && this.zzH >= zzliVarZzg.zzf() && zzliVarZzg.zzg) {
                            if (z22) {
                                zzJ();
                            }
                            zzli zzliVarZza = this.zzq.zza();
                            zzliVarZza.getClass();
                            if (this.zzu.zzb.zza.equals(zzliVarZza.zzf.zza.zza)) {
                                zzur zzurVar3 = this.zzu.zzb;
                                if (zzurVar3.zzb == -1) {
                                    zzur zzurVar4 = zzliVarZza.zzf.zza;
                                    if (zzurVar4.zzb == -1 && zzurVar3.zze != zzurVar4.zze) {
                                        z17 = true;
                                    }
                                }
                                zzlj zzljVar = zzliVarZza.zzf;
                                zzur zzurVar5 = zzljVar.zza;
                                long j15 = zzljVar.zzb;
                                this.zzu = zzz(zzurVar5, j15, zzljVar.zzc, j15, !z17, 0);
                                zzN();
                                zzaa();
                                zzypVarZzi = this.zzq.zze().zzi();
                                i13 = 0;
                                while (true) {
                                    int length6 = this.zza.length;
                                    if (i13 < 2) {
                                        if (zzypVarZzi.zzb(i13)) {
                                            this.zza[i13].zzs();
                                        }
                                        i13++;
                                    }
                                }
                                z22 = true;
                            }
                            z17 = false;
                            zzlj zzljVar2 = zzliVarZza.zzf;
                            zzur zzurVar6 = zzljVar2.zza;
                            long j16 = zzljVar2.zzb;
                            this.zzu = zzz(zzurVar6, j16, zzljVar2.zzc, j16, !z17, 0);
                            zzN();
                            zzaa();
                            zzypVarZzi = this.zzq.zze().zzi();
                            i13 = 0;
                            while (true) {
                                int length7 = this.zza.length;
                                if (i13 < 2) {
                                    if (zzypVarZzi.zzb(i13)) {
                                        this.zza[i13].zzs();
                                    }
                                    i13++;
                                }
                            }
                            z22 = true;
                        }
                        i15 = 4;
                    }
                    int i22 = this.zzu.zze;
                    z11 = true;
                    if (i22 != 1) {
                        if (i22 != i15) {
                            zzli zzliVarZze4 = this.zzq.zze();
                            if (zzliVarZze4 == null) {
                                zzQ(jUptimeMillis, 10L);
                            } else {
                                int i23 = zzfy.zza;
                                Trace.beginSection("doSomeWork");
                                zzaa();
                                if (zzliVarZze4.zzd) {
                                    long jZzq = zzfy.zzq(SystemClock.elapsedRealtime());
                                    zzliVarZze4.zza.zzj(this.zzu.zzr - this.zzm, false);
                                    z13 = true;
                                    z14 = true;
                                    int i24 = 0;
                                    while (true) {
                                        zzmf[] zzmfVarArr5 = this.zza;
                                        int length8 = zzmfVarArr5.length;
                                        if (i24 < 2) {
                                            zzmf zzmfVar5 = zzmfVarArr5[i24];
                                            if (zzaf(zzmfVar5)) {
                                                zzmfVar5.zzU(this.zzH, jZzq);
                                                boolean z23 = z13 && zzmfVar5.zzV();
                                                boolean z24 = zzliVarZze4.zzc[i24] != zzmfVar5.zzo();
                                                boolean z25 = z24 || (!z24 && zzmfVar5.zzP()) || zzmfVar5.zzW() || zzmfVar5.zzV();
                                                boolean z26 = z14 && z25;
                                                if (!z25) {
                                                    zzmfVar5.zzv();
                                                }
                                                z14 = z26;
                                                z13 = z23;
                                            }
                                            i24++;
                                        }
                                    }
                                } else {
                                    zzliVarZze4.zza.zzk();
                                    z13 = true;
                                    z14 = true;
                                }
                                long j17 = zzliVarZze4.zzf.zze;
                                if (z13 && zzliVarZze4.zzd && (j17 == C.TIME_UNSET || j17 <= this.zzu.zzr)) {
                                    if (this.zzy) {
                                        this.zzy = false;
                                        zzT(false, this.zzu.zzm, false, 5);
                                    }
                                    if (zzliVarZze4.zzf.zzi) {
                                        zzU(i15);
                                        zzX();
                                        i11 = 3;
                                    } else {
                                        zzlyVar = this.zzu;
                                        if (zzlyVar.zze != 2) {
                                            i11 = 3;
                                            if (this.zzu.zze == 3) {
                                                if (this.zzF == 0) {
                                                    if (!zzag()) {
                                                        zzac(zzai(), false);
                                                        zzU(2);
                                                        if (this.zzz) {
                                                            for (zzliVarZze = this.zzq.zze(); zzliVarZze != null; zzliVarZze = zzliVarZze.zzg()) {
                                                                for (zzyi zzyiVar : zzliVarZze.zzi().zzc) {
                                                                }
                                                            }
                                                            this.zzN.zzc();
                                                        }
                                                        zzX();
                                                    }
                                                } else if (!z14) {
                                                    zzac(zzai(), false);
                                                    zzU(2);
                                                    if (this.zzz) {
                                                        while (zzliVarZze != null) {
                                                            while (i12 < r5) {
                                                            }
                                                        }
                                                        this.zzN.zzc();
                                                    }
                                                    zzX();
                                                }
                                            }
                                        } else if (this.zzF == 0) {
                                            if (z14) {
                                                if (zzlyVar.zzg) {
                                                    zzliVarZze2 = this.zzq.zze();
                                                    if (zzaj(this.zzu.zza, zzliVarZze2.zzf.zza)) {
                                                        jZzb = this.zzN.zzb();
                                                    } else {
                                                        jZzb = C.TIME_UNSET;
                                                    }
                                                    zzliVarZzd = this.zzq.zzd();
                                                    if (zzliVarZzd.zzr()) {
                                                        z15 = false;
                                                    } else {
                                                        z15 = false;
                                                    }
                                                    if (zzliVarZzd.zzf.zza.zzb()) {
                                                        z16 = false;
                                                    } else {
                                                        z16 = false;
                                                    }
                                                    if (!z15) {
                                                    }
                                                }
                                                i11 = 3;
                                                zzU(3);
                                                this.zzK = null;
                                                if (zzai()) {
                                                    zzV();
                                                }
                                            }
                                            i11 = 3;
                                            if (this.zzu.zze == 3) {
                                                if (this.zzF == 0) {
                                                    if (!zzag()) {
                                                        zzac(zzai(), false);
                                                        zzU(2);
                                                        if (this.zzz) {
                                                            while (zzliVarZze != null) {
                                                                while (i12 < r5) {
                                                                }
                                                            }
                                                            this.zzN.zzc();
                                                        }
                                                        zzX();
                                                    }
                                                } else if (!z14) {
                                                    zzac(zzai(), false);
                                                    zzU(2);
                                                    if (this.zzz) {
                                                        while (zzliVarZze != null) {
                                                            while (i12 < r5) {
                                                            }
                                                        }
                                                        this.zzN.zzc();
                                                    }
                                                    zzX();
                                                }
                                            }
                                        } else if (zzag()) {
                                            i11 = 3;
                                            zzU(3);
                                            this.zzK = null;
                                            if (zzai()) {
                                                zzV();
                                            }
                                        } else {
                                            i11 = 3;
                                            if (this.zzu.zze == 3) {
                                                if (this.zzF == 0) {
                                                    if (!zzag()) {
                                                        zzac(zzai(), false);
                                                        zzU(2);
                                                        if (this.zzz) {
                                                            while (zzliVarZze != null) {
                                                                while (i12 < r5) {
                                                                }
                                                            }
                                                            this.zzN.zzc();
                                                        }
                                                        zzX();
                                                    }
                                                } else if (!z14) {
                                                    zzac(zzai(), false);
                                                    zzU(2);
                                                    if (this.zzz) {
                                                        while (zzliVarZze != null) {
                                                            while (i12 < r5) {
                                                            }
                                                        }
                                                        this.zzN.zzc();
                                                    }
                                                    zzX();
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    zzlyVar = this.zzu;
                                    if (zzlyVar.zze != 2) {
                                        i11 = 3;
                                        if (this.zzu.zze == 3) {
                                            if (this.zzF == 0) {
                                                if (!zzag()) {
                                                    zzac(zzai(), false);
                                                    zzU(2);
                                                    if (this.zzz) {
                                                        while (zzliVarZze != null) {
                                                            while (i12 < r5) {
                                                            }
                                                        }
                                                        this.zzN.zzc();
                                                    }
                                                    zzX();
                                                }
                                            } else if (!z14) {
                                                zzac(zzai(), false);
                                                zzU(2);
                                                if (this.zzz) {
                                                    while (zzliVarZze != null) {
                                                        while (i12 < r5) {
                                                        }
                                                    }
                                                    this.zzN.zzc();
                                                }
                                                zzX();
                                            }
                                        }
                                    } else if (this.zzF == 0) {
                                        if (z14) {
                                            if (zzlyVar.zzg) {
                                                zzliVarZze2 = this.zzq.zze();
                                                if (zzaj(this.zzu.zza, zzliVarZze2.zzf.zza)) {
                                                    jZzb = this.zzN.zzb();
                                                } else {
                                                    jZzb = C.TIME_UNSET;
                                                }
                                                zzliVarZzd = this.zzq.zzd();
                                                if (zzliVarZzd.zzr() || !zzliVarZzd.zzf.zzi) {
                                                    z15 = false;
                                                } else {
                                                    z15 = true;
                                                }
                                                if (zzliVarZzd.zzf.zza.zzb() || zzliVarZzd.zzd) {
                                                    z16 = false;
                                                } else {
                                                    z16 = true;
                                                }
                                                if (!z15 || z16 || this.zzf.zzh(this.zzu.zza, zzliVarZze2.zzf.zza, zzt(), this.zzn.zzc().zzc, this.zzz, jZzb)) {
                                                }
                                            }
                                            i11 = 3;
                                            zzU(3);
                                            this.zzK = null;
                                            if (zzai()) {
                                                zzV();
                                            }
                                        }
                                        i11 = 3;
                                        if (this.zzu.zze == 3) {
                                            if (this.zzF == 0) {
                                                if (!zzag()) {
                                                    zzac(zzai(), false);
                                                    zzU(2);
                                                    if (this.zzz) {
                                                        while (zzliVarZze != null) {
                                                            while (i12 < r5) {
                                                            }
                                                        }
                                                        this.zzN.zzc();
                                                    }
                                                    zzX();
                                                }
                                            } else if (!z14) {
                                                zzac(zzai(), false);
                                                zzU(2);
                                                if (this.zzz) {
                                                    while (zzliVarZze != null) {
                                                        while (i12 < r5) {
                                                        }
                                                    }
                                                    this.zzN.zzc();
                                                }
                                                zzX();
                                            }
                                        }
                                    } else if (zzag()) {
                                        i11 = 3;
                                        zzU(3);
                                        this.zzK = null;
                                        if (zzai()) {
                                            zzV();
                                        }
                                    } else {
                                        i11 = 3;
                                        if (this.zzu.zze == 3) {
                                            if (this.zzF == 0) {
                                                if (!zzag()) {
                                                    zzac(zzai(), false);
                                                    zzU(2);
                                                    if (this.zzz) {
                                                        while (zzliVarZze != null) {
                                                            while (i12 < r5) {
                                                            }
                                                        }
                                                        this.zzN.zzc();
                                                    }
                                                    zzX();
                                                }
                                            } else if (!z14) {
                                                zzac(zzai(), false);
                                                zzU(2);
                                                if (this.zzz) {
                                                    while (zzliVarZze != null) {
                                                        while (i12 < r5) {
                                                        }
                                                    }
                                                    this.zzN.zzc();
                                                }
                                                zzX();
                                            }
                                        }
                                    }
                                }
                                int i25 = 2;
                                if (this.zzu.zze == 2) {
                                    int i26 = 0;
                                    while (true) {
                                        zzmf[] zzmfVarArr6 = this.zza;
                                        int length9 = zzmfVarArr6.length;
                                        if (i26 < i25) {
                                            if (zzaf(zzmfVarArr6[i26]) && this.zza[i26].zzo() == zzliVarZze4.zzc[i26]) {
                                                this.zza[i26].zzv();
                                            }
                                            i26++;
                                            i25 = 2;
                                        } else {
                                            zzly zzlyVar3 = this.zzu;
                                            if (zzlyVar3.zzg || zzlyVar3.zzq >= 500000 || !zzae()) {
                                                this.zzL = C.TIME_UNSET;
                                            } else if (this.zzL == C.TIME_UNSET) {
                                                this.zzL = SystemClock.elapsedRealtime();
                                            } else if (SystemClock.elapsedRealtime() - this.zzL >= 4000) {
                                                throw new IllegalStateException("Playback stuck buffering and not loading");
                                            }
                                        }
                                    }
                                } else {
                                    this.zzL = C.TIME_UNSET;
                                }
                                boolean z27 = zzai() && this.zzu.zze == i11;
                                zzly zzlyVar4 = this.zzu;
                                boolean z28 = zzlyVar4.zzo;
                                int i27 = zzlyVar4.zze;
                                if (i27 != i15) {
                                    if (z27 || i27 == 2) {
                                        zzQ(jUptimeMillis, 10L);
                                    } else if (i27 == i11 && this.zzF != 0) {
                                        zzQ(jUptimeMillis, 1000L);
                                    }
                                }
                                Trace.endSection();
                            }
                        }
                        z11 = true;
                    }
                    zzJ();
                    return z11;
                case 3:
                    zzky zzkyVar = (zzky) message.obj;
                    this.zzv.zza(1);
                    Pair pairZzy = zzy(this.zzu.zza, zzkyVar, true, this.zzC, this.zzD, this.zzk, this.zzl);
                    if (pairZzy == null) {
                        Pair pairZzx = zzx(this.zzu.zza);
                        zzurVar = (zzur) pairZzx.first;
                        long jLongValue2 = ((Long) pairZzx.second).longValue();
                        j11 = -9223372036854775807L;
                        z18 = !this.zzu.zza.zzo();
                        jLongValue = jLongValue2;
                    } else {
                        Object obj = pairZzy.first;
                        jLongValue = ((Long) pairZzy.second).longValue();
                        j11 = zzkyVar.zzc == C.TIME_UNSET ? -9223372036854775807L : jLongValue;
                        zzur zzurVarZzi = this.zzq.zzi(this.zzu.zza, obj, jLongValue);
                        if (zzurVarZzi.zzb()) {
                            this.zzu.zza.zzn(zzurVarZzi.zza, this.zzl);
                            if (this.zzl.zze(zzurVarZzi.zzb) == zzurVarZzi.zzc) {
                                this.zzl.zzj();
                            }
                            zzurVar = zzurVarZzi;
                            jLongValue = 0;
                            z18 = true;
                        } else {
                            z18 = zzkyVar.zzc == C.TIME_UNSET;
                            zzurVar = zzurVarZzi;
                        }
                    }
                    try {
                        try {
                            if (!this.zzu.zza.zzo()) {
                                if (pairZzy == null) {
                                    if (this.zzu.zze != 1) {
                                        zzU(4);
                                    }
                                    zzM(false, true, false, true);
                                } else {
                                    if (zzurVar.equals(this.zzu.zzb)) {
                                        zzli zzliVarZze5 = this.zzq.zze();
                                        jZza = (zzliVarZze5 == null || !zzliVarZze5.zzd || jLongValue == 0) ? jLongValue : zzliVarZze5.zza.zza(jLongValue, this.zzt);
                                        zzurVar2 = zzurVar;
                                        try {
                                            if (zzfy.zzt(jZza) == zzfy.zzt(this.zzu.zzr) && ((i14 = (zzlyVar2 = this.zzu).zze) == 2 || i14 == 3)) {
                                                long j18 = zzlyVar2.zzr;
                                                zzlyVarZzz = zzz(zzurVar2, j18, j11, j18, z18, 2);
                                            }
                                        } catch (Throwable th4) {
                                            th = th4;
                                            th2 = th;
                                            th3 = th2;
                                            j12 = jLongValue;
                                            this.zzu = zzz(zzurVar2, j12, j11, j12, z18, 2);
                                            throw th3;
                                        }
                                    } else {
                                        zzurVar2 = zzurVar;
                                        jZza = jLongValue;
                                    }
                                    long jZzv = zzv(zzurVar2, jZza, this.zzu.zze == 4);
                                    z18 |= jLongValue != jZzv;
                                    try {
                                        zzly zzlyVar5 = this.zzu;
                                        zzcx zzcxVar2 = zzlyVar5.zza;
                                        zzab(zzcxVar2, zzurVar2, zzcxVar2, zzlyVar5.zzb, j11, true);
                                        j13 = jZzv;
                                        zzlyVarZzz = zzz(zzurVar2, j13, j11, j13, z18, 2);
                                    } catch (Throwable th5) {
                                        j12 = jZzv;
                                        th3 = th5;
                                        this.zzu = zzz(zzurVar2, j12, j11, j12, z18, 2);
                                        throw th3;
                                    }
                                }
                                this.zzu = zzlyVarZzz;
                                z11 = true;
                                zzJ();
                                return z11;
                            }
                            this.zzG = zzkyVar;
                            j13 = jLongValue;
                            zzurVar2 = zzurVar;
                            zzlyVarZzz = zzz(zzurVar2, j13, j11, j13, z18, 2);
                            this.zzu = zzlyVarZzz;
                            z11 = true;
                            zzJ();
                            return z11;
                        } catch (Throwable th6) {
                            th2 = th6;
                            zzurVar2 = zzurVar;
                            th3 = th2;
                            j12 = jLongValue;
                            this.zzu = zzz(zzurVar2, j12, j11, j12, z18, 2);
                            throw th3;
                        }
                    } catch (Throwable th7) {
                        th = th7;
                        zzurVar2 = zzurVar;
                    }
                    break;
                case 4:
                    zzS((zzcg) message.obj);
                    zzG(this.zzn.zzc(), true);
                    z11 = true;
                    zzJ();
                    return z11;
                case 5:
                    this.zzt = (zzmj) message.obj;
                    z11 = true;
                    zzJ();
                    return z11;
                case 6:
                    zzW(false, true);
                    z11 = true;
                    zzJ();
                    return z11;
                case 7:
                    zzM(true, false, true, false);
                    int i28 = 0;
                    while (true) {
                        int length10 = this.zza.length;
                        if (i28 >= 2) {
                            this.zzf.zzc();
                            zzU(1);
                            HandlerThread handlerThread = this.zzi;
                            if (handlerThread != null) {
                                handlerThread.quit();
                            }
                            synchronized (this) {
                                this.zzw = true;
                                notifyAll();
                                break;
                            }
                            return true;
                        }
                        this.zzc[i28].zzp();
                        this.zza[i28].zzF();
                        i28++;
                    }
                    break;
                case 8:
                    if (this.zzq.zzm((zzup) message.obj)) {
                        zzli zzliVarZzd2 = this.zzq.zzd();
                        zzliVarZzd2.zzl(this.zzn.zzc().zzc, this.zzu.zza);
                        zzZ(zzliVarZzd2.zzf.zza, zzliVarZzd2.zzh(), zzliVarZzd2.zzi());
                        if (zzliVarZzd2 == this.zzq.zze()) {
                            zzO(zzliVarZzd2.zzf.zzb);
                            zzB();
                            zzly zzlyVar6 = this.zzu;
                            zzur zzurVar7 = zzlyVar6.zzb;
                            long j19 = zzliVarZzd2.zzf.zzb;
                            this.zzu = zzz(zzurVar7, j19, zzlyVar6.zzc, j19, false, 5);
                        }
                        zzI();
                    }
                    z11 = true;
                    zzJ();
                    return z11;
                case 9:
                    if (this.zzq.zzm((zzup) message.obj)) {
                        this.zzq.zzl(this.zzH);
                        zzI();
                    }
                    z11 = true;
                    zzJ();
                    return z11;
                case 10:
                    zzK();
                    z11 = true;
                    zzJ();
                    return z11;
                case 11:
                    int i29 = message.arg1;
                    this.zzC = i29;
                    if (!this.zzq.zzq(this.zzu.zza, i29)) {
                        zzR(true);
                    }
                    zzE(false);
                    z11 = true;
                    zzJ();
                    return z11;
                case 12:
                    boolean z29 = message.arg1 != 0;
                    this.zzD = z29;
                    if (!this.zzq.zzr(this.zzu.zza, z29)) {
                        zzR(true);
                    }
                    zzE(false);
                    z11 = true;
                    zzJ();
                    return z11;
                case 13:
                    boolean z30 = message.arg1 != 0;
                    AtomicBoolean atomicBoolean = (AtomicBoolean) message.obj;
                    if (this.zzE != z30) {
                        this.zzE = z30;
                        if (!z30) {
                            zzmf[] zzmfVarArr7 = this.zza;
                            int length11 = zzmfVarArr7.length;
                            for (int i31 = 0; i31 < 2; i31++) {
                                zzmf zzmfVar6 = zzmfVarArr7[i31];
                                if (!zzaf(zzmfVar6) && this.zzb.remove(zzmfVar6)) {
                                    zzmfVar6.zzH();
                                }
                            }
                        }
                    }
                    if (atomicBoolean != null) {
                        synchronized (this) {
                            atomicBoolean.set(true);
                            notifyAll();
                            break;
                        }
                    }
                    z11 = true;
                    zzJ();
                    return z11;
                case 14:
                    zzmb zzmbVar = (zzmb) message.obj;
                    if (zzmbVar.zzb() == this.zzj) {
                        zzal(zzmbVar);
                        int i32 = this.zzu.zze;
                        if (i32 == 3 || i32 == 2) {
                            this.zzh.zzi(2);
                        }
                    } else {
                        this.zzh.zzc(15, zzmbVar).zza();
                    }
                    z11 = true;
                    zzJ();
                    return z11;
                case 15:
                    final zzmb zzmbVar2 = (zzmb) message.obj;
                    Looper looperZzb = zzmbVar2.zzb();
                    if (looperZzb.getThread().isAlive()) {
                        this.zzp.zzb(looperZzb, null).zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzkq
                            @Override // java.lang.Runnable
                            public final void run() {
                                zzkz.zzr(zzmbVar2);
                            }
                        });
                    } else {
                        zzff.zzf("TAG", "Trying to send message on a dead thread.");
                        zzmbVar2.zzh(false);
                    }
                    z11 = true;
                    zzJ();
                    return z11;
                case 16:
                    zzG((zzcg) message.obj, false);
                    z11 = true;
                    zzJ();
                    return z11;
                case 17:
                    zzku zzkuVar = (zzku) message.obj;
                    this.zzv.zza(1);
                    if (zzkuVar.zzb != -1) {
                        this.zzG = new zzky(new zzmd(zzkuVar.zza, zzkuVar.zzd), zzkuVar.zzb, zzkuVar.zzc);
                    }
                    zzF(this.zzr.zzn(zzkuVar.zza, zzkuVar.zzd), false);
                    z11 = true;
                    zzJ();
                    return z11;
                case 18:
                    zzku zzkuVar2 = (zzku) message.obj;
                    int iZza = message.arg1;
                    this.zzv.zza(1);
                    zzlx zzlxVar = this.zzr;
                    if (iZza == -1) {
                        iZza = zzlxVar.zza();
                    }
                    zzF(zzlxVar.zzk(iZza, zzkuVar2.zza, zzkuVar2.zzd), false);
                    z11 = true;
                    zzJ();
                    return z11;
                case 19:
                    zzkv zzkvVar = (zzkv) message.obj;
                    this.zzv.zza(1);
                    zzlx zzlxVar2 = this.zzr;
                    int i33 = zzkvVar.zza;
                    zzF(zzlxVar2.zzl(0, 0, 0, null), false);
                    z11 = true;
                    zzJ();
                    return z11;
                case 20:
                    int i34 = message.arg1;
                    int i35 = message.arg2;
                    zzwk zzwkVar = (zzwk) message.obj;
                    this.zzv.zza(1);
                    zzF(this.zzr.zzm(i34, i35, zzwkVar), false);
                    z11 = true;
                    zzJ();
                    return z11;
                case 21:
                    zzwk zzwkVar2 = (zzwk) message.obj;
                    this.zzv.zza(1);
                    zzF(this.zzr.zzo(zzwkVar2), false);
                    z11 = true;
                    zzJ();
                    return z11;
                case 22:
                    zzF(this.zzr.zzb(), true);
                    z11 = true;
                    zzJ();
                    return z11;
                case 23:
                    this.zzx = message.arg1 != 0;
                    zzN();
                    if (this.zzy && this.zzq.zzf() != this.zzq.zze()) {
                        zzR(true);
                        zzE(false);
                    }
                    z11 = true;
                    zzJ();
                    return z11;
                case 24:
                default:
                    return false;
                case 25:
                    zzL();
                    z11 = true;
                    zzJ();
                    return z11;
                case 26:
                    zzL();
                    z11 = true;
                    zzJ();
                    return z11;
                case 27:
                    int i36 = message.arg1;
                    int i37 = message.arg2;
                    List list = (List) message.obj;
                    this.zzv.zza(1);
                    zzF(this.zzr.zzc(i36, i37, list), false);
                    z11 = true;
                    zzJ();
                    return z11;
            }
        } catch (zzcc e11) {
            zzD(e11, e11.zzb == 1 ? true != e11.zza ? 3003 : 3001 : 1000);
        } catch (zzgx e12) {
            zzD(e12, e12.zza);
        } catch (zziz e13) {
            zziz zzizVarZza = e13;
            if (zzizVarZza.zze == 1 && (zzliVarZzf = this.zzq.zzf()) != null) {
                zzizVarZza = zzizVarZza.zza(zzliVarZzf.zzf.zza);
            }
            if (zzizVarZza.zzk && (this.zzK == null || zzizVarZza.zzb == 5003)) {
                zzff.zzg("ExoPlayerImplInternal", "Recoverable renderer error", zzizVarZza);
                zziz zzizVar = this.zzK;
                if (zzizVar != null) {
                    zzizVar.addSuppressed(zzizVarZza);
                    zzizVarZza = this.zzK;
                } else {
                    this.zzK = zzizVarZza;
                }
                zzew zzewVar = this.zzh;
                zzewVar.zzk(zzewVar.zzc(25, zzizVarZza));
            } else {
                zziz zzizVar2 = this.zzK;
                if (zzizVar2 != null) {
                    zzizVar2.addSuppressed(zzizVarZza);
                    zzizVarZza = this.zzK;
                }
                zziz zzizVar3 = zzizVarZza;
                zzff.zzd("ExoPlayerImplInternal", "Playback error", zzizVar3);
                z11 = true;
                if (zzizVar3.zze == 1) {
                    zzll zzllVar = this.zzq;
                    if (zzllVar.zze() != zzllVar.zzf()) {
                        while (true) {
                            zzll zzllVar2 = this.zzq;
                            if (zzllVar2.zze() == zzllVar2.zzf()) {
                                break;
                            }
                            this.zzq.zza();
                        }
                        zzli zzliVarZze6 = this.zzq.zze();
                        zzliVarZze6.getClass();
                        zzlj zzljVar3 = zzliVarZze6.zzf;
                        zzur zzurVar8 = zzljVar3.zza;
                        long j21 = zzljVar3.zzb;
                        this.zzu = zzz(zzurVar8, j21, zzljVar3.zzc, j21, true, 0);
                    }
                    z12 = false;
                    z11 = true;
                } else {
                    z12 = false;
                }
                zzW(z11, z12);
                this.zzu = this.zzu.zzd(zzizVar3);
            }
        } catch (zzrq e14) {
            zzD(e14, e14.zza);
        } catch (zztt e15) {
            zzD(e15, 1002);
        } catch (IOException e16) {
            zzD(e16, 2000);
        } catch (RuntimeException e17) {
            zziz zzizVarZzd = zziz.zzd(e17, ((e17 instanceof IllegalStateException) || (e17 instanceof IllegalArgumentException)) ? 1004 : 1000);
            zzff.zzd("ExoPlayerImplInternal", "Playback error", zzizVarZzd);
            zzW(true, false);
            this.zzu = this.zzu.zzd(zzizVarZzd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zziw
    public final void zza(zzcg zzcgVar) {
        this.zzh.zzc(16, zzcgVar).zza();
    }

    public final Looper zzb() {
        return this.zzj;
    }

    public final /* synthetic */ Boolean zze() {
        return Boolean.valueOf(this.zzw);
    }

    @Override // com.google.android.gms.internal.ads.zzwi
    public final /* bridge */ /* synthetic */ void zzg(zzwj zzwjVar) {
        this.zzh.zzc(9, (zzup) zzwjVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzlw
    public final void zzh() {
        this.zzh.zzi(22);
    }

    @Override // com.google.android.gms.internal.ads.zzuo
    public final void zzi(zzup zzupVar) {
        this.zzh.zzc(8, zzupVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzyn
    public final void zzj() {
        this.zzh.zzi(10);
    }

    public final void zzk() {
        this.zzh.zzb(0).zza();
    }

    public final void zzl(zzcx zzcxVar, int i11, long j11) {
        this.zzh.zzc(3, new zzky(zzcxVar, i11, j11)).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzlz
    public final synchronized void zzm(zzmb zzmbVar) {
        if (!this.zzw && this.zzj.getThread().isAlive()) {
            this.zzh.zzc(14, zzmbVar).zza();
            return;
        }
        zzff.zzf("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        zzmbVar.zzh(false);
    }

    public final void zzn(boolean z11, int i11) {
        this.zzh.zzd(1, z11 ? 1 : 0, i11).zza();
    }

    public final void zzo() {
        this.zzh.zzb(6).zza();
    }

    public final synchronized boolean zzp() {
        if (!this.zzw && this.zzj.getThread().isAlive()) {
            this.zzh.zzi(7);
            zzad(new zzkp(this), this.zzs);
            return this.zzw;
        }
        return true;
    }

    public final void zzq(List list, int i11, long j11, zzwk zzwkVar) {
        this.zzh.zzc(17, new zzku(list, zzwkVar, i11, j11, null)).zza();
    }
}
