package com.google.android.gms.internal.ads;

import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import java.io.IOException;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzwg implements zzaea {
    private boolean zzB;

    @Nullable
    private zzrz zzC;
    private final zzwa zza;

    @Nullable
    private final zzry zzd;

    @Nullable
    private final zzrs zze;

    @Nullable
    private zzwf zzf;

    @Nullable
    private zzam zzg;
    private int zzo;
    private int zzp;
    private int zzq;
    private int zzr;
    private boolean zzv;

    @Nullable
    private zzam zzy;

    @Nullable
    private zzam zzz;
    private final zzwc zzb = new zzwc();
    private int zzh = 1000;
    private long[] zzi = new long[1000];
    private long[] zzj = new long[1000];
    private long[] zzm = new long[1000];
    private int[] zzl = new int[1000];
    private int[] zzk = new int[1000];
    private zzadz[] zzn = new zzadz[1000];
    private final zzwn zzc = new zzwn(new zzep() { // from class: com.google.android.gms.internal.ads.zzwb
        @Override // com.google.android.gms.internal.ads.zzep
        public final void zza(Object obj) {
            throw null;
        }
    });
    private long zzs = Long.MIN_VALUE;
    private long zzt = Long.MIN_VALUE;
    private long zzu = Long.MIN_VALUE;
    private boolean zzx = true;
    private boolean zzw = true;
    private boolean zzA = true;

    public zzwg(zzyx zzyxVar, @Nullable zzry zzryVar, @Nullable zzrs zzrsVar) {
        this.zzd = zzryVar;
        this.zze = zzrsVar;
        this.zza = new zzwa(zzyxVar);
    }

    private final int zzB(int i11, int i12, long j11, boolean z11) {
        int i13 = -1;
        for (int i14 = 0; i14 < i12; i14++) {
            long j12 = this.zzm[i11];
            if (j12 > j11) {
                break;
            }
            if (!z11 || (this.zzl[i11] & 1) != 0) {
                i13 = i14;
                if (j12 == j11) {
                    break;
                }
            }
            i11++;
            if (i11 == this.zzh) {
                i11 = 0;
            }
        }
        return i13;
    }

    private final int zzC(int i11) {
        int i12 = this.zzq + i11;
        int i13 = this.zzh;
        return i12 < i13 ? i12 : i12 - i13;
    }

    private final synchronized int zzD(zzlb zzlbVar, zzih zzihVar, boolean z11, boolean z12, zzwc zzwcVar) {
        try {
            zzihVar.zzd = false;
            if (!zzL()) {
                if (!z12 && !this.zzv) {
                    zzam zzamVar = this.zzz;
                    if (zzamVar == null || (!z11 && zzamVar == this.zzg)) {
                        return -3;
                    }
                    zzI(zzamVar, zzlbVar);
                    return -5;
                }
                zzihVar.zzc(4);
                zzihVar.zze = Long.MIN_VALUE;
                return -4;
            }
            zzam zzamVar2 = ((zzwe) this.zzc.zza(this.zzp + this.zzr)).zza;
            if (!z11 && zzamVar2 == this.zzg) {
                int iZzC = zzC(this.zzr);
                if (!zzM(iZzC)) {
                    zzihVar.zzd = true;
                    return -3;
                }
                zzihVar.zzc(this.zzl[iZzC]);
                if (this.zzr == this.zzo - 1 && (z12 || this.zzv)) {
                    zzihVar.zza(ASTNode.DISCARD);
                }
                long j11 = this.zzm[iZzC];
                zzihVar.zze = j11;
                if (j11 < this.zzs) {
                    zzihVar.zza(Integer.MIN_VALUE);
                }
                zzwcVar.zza = this.zzk[iZzC];
                zzwcVar.zzb = this.zzj[iZzC];
                zzwcVar.zzc = this.zzn[iZzC];
                return -4;
            }
            zzI(zzamVar2, zzlbVar);
            return -5;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private final synchronized long zzE(long j11, boolean z11, boolean z12) {
        int i11;
        try {
            int i12 = this.zzo;
            if (i12 != 0) {
                long[] jArr = this.zzm;
                int i13 = this.zzq;
                if (j11 >= jArr[i13]) {
                    if (z12 && (i11 = this.zzr) != i12) {
                        i12 = i11 + 1;
                    }
                    int iZzB = zzB(i13, i12, j11, false);
                    if (iZzB != -1) {
                        return zzG(iZzB);
                    }
                }
            }
            return -1L;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private final synchronized long zzF() {
        int i11 = this.zzo;
        if (i11 == 0) {
            return -1L;
        }
        return zzG(i11);
    }

    private final long zzG(int i11) {
        long j11 = this.zzt;
        long jMax = Long.MIN_VALUE;
        if (i11 != 0) {
            int iZzC = zzC(i11 - 1);
            for (int i12 = 0; i12 < i11; i12++) {
                jMax = Math.max(jMax, this.zzm[iZzC]);
                if ((this.zzl[iZzC] & 1) != 0) {
                    break;
                }
                iZzC--;
                if (iZzC == -1) {
                    iZzC = this.zzh - 1;
                }
            }
        }
        this.zzt = Math.max(j11, jMax);
        this.zzo -= i11;
        int i13 = this.zzp + i11;
        this.zzp = i13;
        int i14 = this.zzq + i11;
        this.zzq = i14;
        int i15 = this.zzh;
        if (i14 >= i15) {
            this.zzq = i14 - i15;
        }
        int i16 = this.zzr - i11;
        this.zzr = i16;
        if (i16 < 0) {
            this.zzr = 0;
        }
        this.zzc.zze(i13);
        if (this.zzo != 0) {
            return this.zzj[this.zzq];
        }
        int i17 = this.zzq;
        if (i17 == 0) {
            i17 = this.zzh;
        }
        int i18 = i17 - 1;
        return this.zzj[i18] + ((long) this.zzk[i18]);
    }

    private final synchronized void zzH(long j11, int i11, long j12, int i12, @Nullable zzadz zzadzVar) {
        try {
            int i13 = this.zzo;
            if (i13 > 0) {
                int iZzC = zzC(i13 - 1);
                zzek.zzd(this.zzj[iZzC] + ((long) this.zzk[iZzC]) <= j12);
            }
            this.zzv = (536870912 & i11) != 0;
            this.zzu = Math.max(this.zzu, j11);
            int iZzC2 = zzC(this.zzo);
            this.zzm[iZzC2] = j11;
            this.zzj[iZzC2] = j12;
            this.zzk[iZzC2] = i12;
            this.zzl[iZzC2] = i11;
            this.zzn[iZzC2] = zzadzVar;
            this.zzi[iZzC2] = 0;
            if (this.zzc.zzf() || !((zzwe) this.zzc.zzb()).zza.equals(this.zzz)) {
                zzam zzamVar = this.zzz;
                zzamVar.getClass();
                this.zzc.zzc(this.zzp + this.zzo, new zzwe(zzamVar, zzrx.zzb, null));
            }
            int i14 = this.zzo + 1;
            this.zzo = i14;
            int i15 = this.zzh;
            if (i14 == i15) {
                int i16 = i15 + 1000;
                long[] jArr = new long[i16];
                long[] jArr2 = new long[i16];
                long[] jArr3 = new long[i16];
                int[] iArr = new int[i16];
                int[] iArr2 = new int[i16];
                zzadz[] zzadzVarArr = new zzadz[i16];
                int i17 = this.zzq;
                int i18 = i15 - i17;
                System.arraycopy(this.zzj, i17, jArr2, 0, i18);
                System.arraycopy(this.zzm, this.zzq, jArr3, 0, i18);
                System.arraycopy(this.zzl, this.zzq, iArr, 0, i18);
                System.arraycopy(this.zzk, this.zzq, iArr2, 0, i18);
                System.arraycopy(this.zzn, this.zzq, zzadzVarArr, 0, i18);
                System.arraycopy(this.zzi, this.zzq, jArr, 0, i18);
                int i19 = this.zzq;
                System.arraycopy(this.zzj, 0, jArr2, i18, i19);
                System.arraycopy(this.zzm, 0, jArr3, i18, i19);
                System.arraycopy(this.zzl, 0, iArr, i18, i19);
                System.arraycopy(this.zzk, 0, iArr2, i18, i19);
                System.arraycopy(this.zzn, 0, zzadzVarArr, i18, i19);
                System.arraycopy(this.zzi, 0, jArr, i18, i19);
                this.zzj = jArr2;
                this.zzm = jArr3;
                this.zzl = iArr;
                this.zzk = iArr2;
                this.zzn = zzadzVarArr;
                this.zzi = jArr;
                this.zzq = 0;
                this.zzh = i16;
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private final void zzI(zzam zzamVar, zzlb zzlbVar) {
        zzam zzamVar2 = this.zzg;
        zzae zzaeVar = zzamVar2 == null ? null : zzamVar2.zzp;
        this.zzg = zzamVar;
        zzae zzaeVar2 = zzamVar.zzp;
        zzlbVar.zza = zzamVar.zzc(this.zzd.zza(zzamVar));
        zzlbVar.zzb = this.zzC;
        if (zzamVar2 == null || !zzfy.zzF(zzaeVar, zzaeVar2)) {
            zzrz zzrzVar = zzamVar.zzp != null ? new zzrz(new zzrq(new zzsb(1), 6001)) : null;
            this.zzC = zzrzVar;
            zzlbVar.zzb = zzrzVar;
        }
    }

    private final void zzJ() {
        if (this.zzC != null) {
            this.zzC = null;
            this.zzg = null;
        }
    }

    private final synchronized void zzK() {
        this.zzr = 0;
        this.zza.zzg();
    }

    private final boolean zzL() {
        return this.zzr != this.zzo;
    }

    private final boolean zzM(int i11) {
        if (this.zzC != null) {
            return (this.zzl[i11] & 1073741824) != 0 ? false : false;
        }
        return true;
    }

    private final synchronized boolean zzN(zzam zzamVar) {
        try {
            this.zzx = false;
            if (zzfy.zzF(zzamVar, this.zzz)) {
                return false;
            }
            if (this.zzc.zzf() || !((zzwe) this.zzc.zzb()).zza.equals(zzamVar)) {
                this.zzz = zzamVar;
            } else {
                this.zzz = ((zzwe) this.zzc.zzb()).zza;
            }
            boolean z11 = this.zzA;
            zzam zzamVar2 = this.zzz;
            this.zzA = z11 & zzcb.zzf(zzamVar2.zzm, zzamVar2.zzj);
            this.zzB = false;
            return true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static /* synthetic */ void zzm(zzwe zzweVar) {
        zzrx zzrxVar = zzweVar.zzb;
        int i11 = zzrw.zza;
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0028 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:3:0x0001, B:5:0x0011, B:7:0x0019, B:11:0x0023, B:13:0x0028, B:15:0x002e, B:17:0x0036, B:20:0x003d, B:30:0x0057, B:27:0x0049), top: B:37:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:15:0x002e A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:3:0x0001, B:5:0x0011, B:7:0x0019, B:11:0x0023, B:13:0x0028, B:15:0x002e, B:17:0x0036, B:20:0x003d, B:30:0x0057, B:27:0x0049), top: B:37:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x0036 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:3:0x0001, B:5:0x0011, B:7:0x0019, B:11:0x0023, B:13:0x0028, B:15:0x002e, B:17:0x0036, B:20:0x003d, B:30:0x0057, B:27:0x0049), top: B:37:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x003c  */
    /* JADX WARN: Code duplicated, block: B:25:0x0046 A[EDGE_INSN: B:25:0x0046->B:28:0x0054 BREAK  A[LOOP:0: B:14:0x002c->B:20:0x003d]] */
    /* JADX WARN: Code duplicated, block: B:26:0x0047 A[EDGE_INSN: B:26:0x0047->B:28:0x0054 BREAK  A[LOOP:0: B:14:0x002c->B:20:0x003d]] */
    /* JADX WARN: Code duplicated, block: B:27:0x0049 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:3:0x0001, B:5:0x0011, B:7:0x0019, B:11:0x0023, B:13:0x0028, B:15:0x002e, B:17:0x0036, B:20:0x003d, B:30:0x0057, B:27:0x0049), top: B:37:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x0056  */
    /* JADX WARN: Code duplicated, block: B:30:0x0057 A[Catch: all -> 0x0040, TRY_LEAVE, TryCatch #0 {all -> 0x0040, blocks: (B:3:0x0001, B:5:0x0011, B:7:0x0019, B:11:0x0023, B:13:0x0028, B:15:0x002e, B:17:0x0036, B:20:0x003d, B:30:0x0057, B:27:0x0049), top: B:37:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0042 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x0044 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:42:0x003d A[SYNTHETIC] */
    public final synchronized boolean zzA(long j11, boolean z11) {
        int iZzB;
        int i11;
        try {
            zzK();
            int i12 = this.zzr;
            int iZzC = zzC(i12);
            if (zzL() && j11 >= this.zzm[iZzC]) {
                if (j11 <= this.zzu) {
                    if (this.zzA) {
                        iZzB = this.zzo - i12;
                        i11 = 0;
                        while (true) {
                            if (i11 < iZzB) {
                                if (z11) {
                                    iZzB = -1;
                                    break;
                                }
                                break;
                            }
                            if (this.zzm[iZzC] < j11) {
                                iZzB = i11;
                                break;
                            }
                            iZzC++;
                            if (iZzC == this.zzh) {
                                iZzC = 0;
                            }
                            i11++;
                        }
                    } else {
                        iZzB = zzB(iZzC, this.zzo - i12, j11, true);
                    }
                    if (iZzB == -1) {
                        this.zzs = j11;
                        this.zzr += iZzB;
                        return true;
                    }
                } else if (z11) {
                    z11 = true;
                    if (this.zzA) {
                        iZzB = this.zzo - i12;
                        i11 = 0;
                        while (true) {
                            if (i11 < iZzB) {
                                if (z11) {
                                    iZzB = -1;
                                    break;
                                }
                                break;
                                break;
                            }
                            if (this.zzm[iZzC] < j11) {
                                iZzB = i11;
                                break;
                            }
                            iZzC++;
                            if (iZzC == this.zzh) {
                                iZzC = 0;
                            }
                            i11++;
                        }
                    } else {
                        iZzB = zzB(iZzC, this.zzo - i12, j11, true);
                    }
                    if (iZzB == -1) {
                        this.zzs = j11;
                        this.zzr += iZzB;
                        return true;
                    }
                }
            }
            return false;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final int zza() {
        return this.zzp;
    }

    public final int zzb() {
        return this.zzp + this.zzr;
    }

    public final synchronized int zzc(long j11, boolean z11) {
        int i11 = this.zzr;
        int iZzC = zzC(i11);
        if (zzL() && j11 >= this.zzm[iZzC]) {
            if (j11 > this.zzu && z11) {
                return this.zzo - i11;
            }
            int iZzB = zzB(iZzC, this.zzo - i11, j11, true);
            if (iZzB == -1) {
                return 0;
            }
            return iZzB;
        }
        return 0;
    }

    public final int zzd() {
        return this.zzp + this.zzo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0035, code lost:
    
        if (r9 != 0) goto L14;
     */
    @CallSuper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zze(zzlb zzlbVar, zzih zzihVar, int i11, boolean z11) {
        int iZzD = zzD(zzlbVar, zzihVar, (i11 & 2) != 0, z11, this.zzb);
        if (iZzD != -4) {
            return iZzD;
        }
        if (!zzihVar.zzf()) {
            int i12 = i11 & 1;
            if ((i11 & 4) == 0) {
                if (i12 == 0) {
                    this.zza.zze(zzihVar, this.zzb);
                    this.zzr++;
                    return -4;
                }
                this.zza.zzd(zzihVar, this.zzb);
            }
        }
        return -4;
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final /* synthetic */ int zzf(zzu zzuVar, int i11, boolean z11) {
        return zzady.zza(this, zzuVar, i11, z11);
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final int zzg(zzu zzuVar, int i11, boolean z11, int i12) throws IOException {
        return this.zza.zza(zzuVar, i11, z11);
    }

    public final synchronized long zzh() {
        return this.zzu;
    }

    @Nullable
    public final synchronized zzam zzi() {
        if (this.zzx) {
            return null;
        }
        return this.zzz;
    }

    public final void zzj(long j11, boolean z11, boolean z12) {
        this.zza.zzc(zzE(j11, false, z12));
    }

    public final void zzk() {
        this.zza.zzc(zzF());
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final void zzl(zzam zzamVar) {
        this.zzy = zzamVar;
        boolean zZzN = zzN(zzamVar);
        zzwf zzwfVar = this.zzf;
        if (zzwfVar == null || !zZzN) {
            return;
        }
        zzwfVar.zzM(zzamVar);
    }

    @CallSuper
    public final void zzn() throws IOException {
        zzrz zzrzVar = this.zzC;
        if (zzrzVar != null) {
            throw zzrzVar.zza();
        }
    }

    @CallSuper
    public final void zzo() {
        zzk();
        zzJ();
    }

    @CallSuper
    public final void zzp() {
        zzq(true);
        zzJ();
    }

    @CallSuper
    public final void zzq(boolean z11) {
        this.zza.zzf();
        this.zzo = 0;
        this.zzp = 0;
        this.zzq = 0;
        this.zzr = 0;
        this.zzw = true;
        this.zzs = Long.MIN_VALUE;
        this.zzt = Long.MIN_VALUE;
        this.zzu = Long.MIN_VALUE;
        this.zzv = false;
        this.zzc.zzd();
        if (z11) {
            this.zzy = null;
            this.zzz = null;
            this.zzx = true;
            this.zzA = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final /* synthetic */ void zzr(zzfp zzfpVar, int i11) {
        zzady.zzb(this, zzfpVar, i11);
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final void zzs(zzfp zzfpVar, int i11, int i12) {
        this.zza.zzh(zzfpVar, i11);
    }

    @Override // com.google.android.gms.internal.ads.zzaea
    public final void zzt(long j11, int i11, int i12, int i13, @Nullable zzadz zzadzVar) {
        if (this.zzw) {
            if ((i11 & 1) == 0) {
                return;
            } else {
                this.zzw = false;
            }
        }
        if (this.zzA) {
            if (j11 < this.zzs) {
                return;
            }
            if ((i11 & 1) == 0) {
                if (!this.zzB) {
                    zzff.zzf("SampleQueue", "Overriding unexpected non-sync sample for format: ".concat(String.valueOf(this.zzz)));
                    this.zzB = true;
                }
                i11 |= 1;
            }
        }
        int i14 = i11;
        zzH(j11, i14, (this.zza.zzb() - ((long) i12)) - ((long) i13), i12, zzadzVar);
    }

    public final void zzu(long j11) {
        this.zzs = j11;
    }

    public final void zzv(@Nullable zzwf zzwfVar) {
        this.zzf = zzwfVar;
    }

    public final synchronized void zzw(int i11) {
        boolean z11 = false;
        if (i11 >= 0) {
            try {
                if (this.zzr + i11 <= this.zzo) {
                    z11 = true;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        zzek.zzd(z11);
        this.zzr += i11;
    }

    public final synchronized boolean zzx() {
        return this.zzv;
    }

    @CallSuper
    public final synchronized boolean zzy(boolean z11) {
        boolean z12 = true;
        if (zzL()) {
            if (((zzwe) this.zzc.zza(this.zzp + this.zzr)).zza != this.zzg) {
                return true;
            }
            return zzM(zzC(this.zzr));
        }
        if (!z11 && !this.zzv) {
            zzam zzamVar = this.zzz;
            if (zzamVar == null) {
                z12 = false;
            } else if (zzamVar == this.zzg) {
                return false;
            }
        }
        return z12;
    }

    public final synchronized boolean zzz(int i11) {
        zzK();
        int i12 = this.zzp;
        if (i11 >= i12 && i11 <= this.zzo + i12) {
            this.zzs = Long.MIN_VALUE;
            this.zzr = i11 - i12;
            return true;
        }
        return false;
    }
}
