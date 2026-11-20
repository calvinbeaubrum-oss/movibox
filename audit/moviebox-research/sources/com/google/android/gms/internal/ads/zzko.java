package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzko extends zzm implements zzjj {
    public static final /* synthetic */ int zzd = 0;
    private final zzmo zzA;
    private final long zzB;
    private int zzC;
    private int zzD;
    private boolean zzE;
    private int zzF;
    private zzmj zzG;
    private zzck zzH;
    private zzbv zzI;
    private zzbv zzJ;

    @Nullable
    private zzam zzK;

    @Nullable
    private zzam zzL;

    @Nullable
    private Object zzM;

    @Nullable
    private Surface zzN;
    private int zzO;
    private zzfq zzP;

    @Nullable
    private zzir zzQ;

    @Nullable
    private zzir zzR;
    private int zzS;
    private zzk zzT;
    private float zzU;
    private boolean zzV;
    private zzee zzW;
    private boolean zzX;
    private boolean zzY;
    private zzaa zzZ;
    private zzdp zzaa;
    private zzbv zzab;
    private zzly zzac;
    private int zzad;
    private long zzae;
    private final zzjk zzaf;
    private zzwk zzag;
    final zzyp zzb;
    final zzck zzc;
    private final zzeo zze;
    private final Context zzf;
    private final zzco zzg;
    private final zzmf[] zzh;
    private final zzyo zzi;
    private final zzew zzj;
    private final zzkz zzk;
    private final zzfc zzl;
    private final CopyOnWriteArraySet zzm;
    private final zzcu zzn;
    private final List zzo;
    private final boolean zzp;
    private final zzuq zzq;
    private final zzmp zzr;
    private final Looper zzs;
    private final zzyw zzt;
    private final zzel zzu;
    private final zzkk zzv;
    private final zzkm zzw;
    private final zzil zzx;
    private final zzip zzy;
    private final zzmn zzz;

    static {
        zzbq.zzb("media3.exoplayer");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v6, types: [com.google.android.gms.internal.ads.zzmp, com.google.android.gms.internal.ads.zzyv, java.lang.Object] */
    @SuppressLint({"HandlerLeak"})
    public zzko(zzji zzjiVar, @Nullable zzco zzcoVar) {
        zzeo zzeoVar = new zzeo(zzel.zza);
        this.zze = zzeoVar;
        try {
            zzff.zze("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.2.1] [" + zzfy.zze + "]");
            Context applicationContext = zzjiVar.zza.getApplicationContext();
            this.zzf = applicationContext;
            ?? Apply = zzjiVar.zzh.apply(zzjiVar.zzb);
            this.zzr = Apply;
            this.zzT = zzjiVar.zzj;
            this.zzO = zzjiVar.zzk;
            this.zzV = false;
            this.zzB = zzjiVar.zzo;
            zzkk zzkkVar = new zzkk(this, null);
            this.zzv = zzkkVar;
            zzkm zzkmVar = new zzkm(null);
            this.zzw = zzkmVar;
            Handler handler = new Handler(zzjiVar.zzi);
            zzmf[] zzmfVarArrZza = ((zzjb) zzjiVar.zzc).zza.zza(handler, zzkkVar, zzkkVar, zzkkVar, zzkkVar);
            this.zzh = zzmfVarArrZza;
            int length = zzmfVarArrZza.length;
            zzyo zzyoVar = (zzyo) zzjiVar.zze.zza();
            this.zzi = zzyoVar;
            this.zzq = zzji.zza(((zzjc) zzjiVar.zzd).zza);
            zzza zzzaVarZzg = zzza.zzg(((zzjf) zzjiVar.zzg).zza);
            this.zzt = zzzaVarZzg;
            this.zzp = zzjiVar.zzl;
            this.zzG = zzjiVar.zzm;
            Looper looper = zzjiVar.zzi;
            this.zzs = looper;
            zzel zzelVar = zzjiVar.zzb;
            this.zzu = zzelVar;
            this.zzg = zzcoVar;
            zzfc zzfcVar = new zzfc(looper, zzelVar, new zzfa() { // from class: com.google.android.gms.internal.ads.zzke
                @Override // com.google.android.gms.internal.ads.zzfa
                public final void zza(Object obj, zzah zzahVar) {
                }
            });
            this.zzl = zzfcVar;
            CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
            this.zzm = copyOnWriteArraySet;
            this.zzo = new ArrayList();
            this.zzag = new zzwk(0);
            int length2 = zzmfVarArrZza.length;
            zzyp zzypVar = new zzyp(new zzmi[2], new zzyi[2], zzdk.zza, null);
            this.zzb = zzypVar;
            this.zzn = new zzcu();
            zzci zzciVar = new zzci();
            zzciVar.zzc(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 35, 22, 24, 27, 28, 32);
            zzyoVar.zzn();
            zzciVar.zzd(29, true);
            zzciVar.zzd(23, false);
            zzciVar.zzd(25, false);
            zzciVar.zzd(33, false);
            zzciVar.zzd(26, false);
            zzciVar.zzd(34, false);
            zzck zzckVarZze = zzciVar.zze();
            this.zzc = zzckVarZze;
            zzci zzciVar2 = new zzci();
            zzciVar2.zzb(zzckVarZze);
            zzciVar2.zza(4);
            zzciVar2.zza(10);
            this.zzH = zzciVar2.zze();
            this.zzj = zzelVar.zzb(looper, null);
            zzjk zzjkVar = new zzjk(this);
            this.zzaf = zzjkVar;
            this.zzac = zzly.zzg(zzypVar);
            Apply.zzR(zzcoVar, looper);
            this.zzk = new zzkz(zzmfVarArrZza, zzyoVar, zzypVar, (zzlc) zzjiVar.zzf.zza(), zzzaVarZzg, 0, false, Apply, this.zzG, zzjiVar.zzr, zzjiVar.zzn, false, looper, zzelVar, zzjkVar, zzfy.zza < 31 ? new zzpb() : zzkf.zza(applicationContext, this, zzjiVar.zzp), null);
            this.zzU = 1.0f;
            zzbv zzbvVar = zzbv.zza;
            this.zzI = zzbvVar;
            this.zzJ = zzbvVar;
            this.zzab = zzbvVar;
            int iGenerateAudioSessionId = -1;
            this.zzad = -1;
            AudioManager audioManager = (AudioManager) applicationContext.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
            if (audioManager != null) {
                iGenerateAudioSessionId = audioManager.generateAudioSessionId();
            }
            this.zzS = iGenerateAudioSessionId;
            this.zzW = zzee.zza;
            this.zzX = true;
            Apply.getClass();
            zzfcVar.zzb(Apply);
            zzzaVarZzg.zze(new Handler(looper), Apply);
            copyOnWriteArraySet.add(zzkkVar);
            this.zzx = new zzil(zzjiVar.zza, handler, zzkkVar);
            this.zzy = new zzip(zzjiVar.zza, handler, zzkkVar);
            zzfy.zzF(null, null);
            this.zzz = new zzmn(zzjiVar.zza);
            this.zzA = new zzmo(zzjiVar.zza);
            this.zzZ = new zzy(0).zza();
            this.zzaa = zzdp.zza;
            this.zzP = zzfq.zza;
            zzyoVar.zzk(this.zzT);
            zzag(1, 10, Integer.valueOf(this.zzS));
            zzag(2, 10, Integer.valueOf(this.zzS));
            zzag(1, 3, this.zzT);
            zzag(2, 4, Integer.valueOf(this.zzO));
            zzag(2, 5, 0);
            zzag(1, 9, Boolean.valueOf(this.zzV));
            zzag(2, 7, zzkmVar);
            zzag(6, 8, zzkmVar);
            zzeoVar.zze();
        } catch (Throwable th2) {
            this.zze.zze();
            throw th2;
        }
    }

    public static /* bridge */ /* synthetic */ void zzP(zzko zzkoVar, SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        zzkoVar.zzai(surface);
        zzkoVar.zzN = surface;
    }

    private final int zzW(zzly zzlyVar) {
        return zzlyVar.zza.zzo() ? this.zzad : zzlyVar.zza.zzn(zzlyVar.zzb.zza, this.zzn).zzd;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int zzX(boolean z11, int i11) {
        return (!z11 || i11 == 1) ? 1 : 2;
    }

    private final long zzY(zzly zzlyVar) {
        if (!zzlyVar.zzb.zzb()) {
            return zzfy.zzt(zzZ(zzlyVar));
        }
        zzlyVar.zza.zzn(zzlyVar.zzb.zza, this.zzn);
        long j11 = zzlyVar.zzc;
        if (j11 != C.TIME_UNSET) {
            return zzfy.zzt(j11) + zzfy.zzt(0L);
        }
        long j12 = zzlyVar.zza.zze(zzW(zzlyVar), this.zza, 0L).zzn;
        return zzfy.zzt(0L);
    }

    private final long zzZ(zzly zzlyVar) {
        if (zzlyVar.zza.zzo()) {
            return zzfy.zzq(this.zzae);
        }
        long j11 = zzlyVar.zzr;
        if (zzlyVar.zzb.zzb()) {
            return j11;
        }
        zzab(zzlyVar.zza, zzlyVar.zzb, j11);
        return j11;
    }

    private static long zzaa(zzly zzlyVar) {
        zzcw zzcwVar = new zzcw();
        zzcu zzcuVar = new zzcu();
        zzlyVar.zza.zzn(zzlyVar.zzb.zza, zzcuVar);
        long j11 = zzlyVar.zzc;
        if (j11 != C.TIME_UNSET) {
            return j11;
        }
        long j12 = zzlyVar.zza.zze(zzcuVar.zzd, zzcwVar, 0L).zzn;
        return 0L;
    }

    private final long zzab(zzcx zzcxVar, zzur zzurVar, long j11) {
        zzcxVar.zzn(zzurVar.zza, this.zzn);
        return j11;
    }

    @Nullable
    private final Pair zzac(zzcx zzcxVar, int i11, long j11) {
        if (zzcxVar.zzo()) {
            this.zzad = i11;
            if (j11 == C.TIME_UNSET) {
                j11 = 0;
            }
            this.zzae = j11;
            return null;
        }
        if (i11 == -1 || i11 >= zzcxVar.zzc()) {
            i11 = zzcxVar.zzg(false);
            long j12 = zzcxVar.zze(i11, this.zza, 0L).zzn;
            j11 = zzfy.zzt(0L);
        }
        return zzcxVar.zzl(this.zza, this.zzn, i11, zzfy.zzq(j11));
    }

    private final zzly zzad(zzly zzlyVar, zzcx zzcxVar, @Nullable Pair pair) {
        zzek.zzd(zzcxVar.zzo() || pair != null);
        zzcx zzcxVar2 = zzlyVar.zza;
        long jZzY = zzY(zzlyVar);
        zzly zzlyVarZzf = zzlyVar.zzf(zzcxVar);
        if (zzcxVar.zzo()) {
            zzur zzurVarZzh = zzly.zzh();
            long jZzq = zzfy.zzq(this.zzae);
            zzly zzlyVarZza = zzlyVarZzf.zzb(zzurVarZzh, jZzq, jZzq, jZzq, 0L, zzws.zza, this.zzb, zzgaa.zzl()).zza(zzurVarZzh);
            zzlyVarZza.zzp = zzlyVarZza.zzr;
            return zzlyVarZza;
        }
        Object obj = zzlyVarZzf.zzb.zza;
        int i11 = zzfy.zza;
        boolean z11 = !obj.equals(pair.first);
        zzur zzurVar = z11 ? new zzur(pair.first, -1L) : zzlyVarZzf.zzb;
        long jLongValue = ((Long) pair.second).longValue();
        long jZzq2 = zzfy.zzq(jZzY);
        if (!zzcxVar2.zzo()) {
            zzcxVar2.zzn(obj, this.zzn);
        }
        if (z11 || jLongValue < jZzq2) {
            zzek.zzf(!zzurVar.zzb());
            zzly zzlyVarZza2 = zzlyVarZzf.zzb(zzurVar, jLongValue, jLongValue, jLongValue, 0L, z11 ? zzws.zza : zzlyVarZzf.zzh, z11 ? this.zzb : zzlyVarZzf.zzi, z11 ? zzgaa.zzl() : zzlyVarZzf.zzj).zza(zzurVar);
            zzlyVarZza2.zzp = jLongValue;
            return zzlyVarZza2;
        }
        if (jLongValue != jZzq2) {
            zzek.zzf(!zzurVar.zzb());
            long jMax = Math.max(0L, zzlyVarZzf.zzq - (jLongValue - jZzq2));
            long j11 = zzlyVarZzf.zzp;
            if (zzlyVarZzf.zzk.equals(zzlyVarZzf.zzb)) {
                j11 = jLongValue + jMax;
            }
            zzly zzlyVarZzb = zzlyVarZzf.zzb(zzurVar, jLongValue, jLongValue, jLongValue, jMax, zzlyVarZzf.zzh, zzlyVarZzf.zzi, zzlyVarZzf.zzj);
            zzlyVarZzb.zzp = j11;
            return zzlyVarZzb;
        }
        int iZza = zzcxVar.zza(zzlyVarZzf.zzk.zza);
        if (iZza != -1 && zzcxVar.zzd(iZza, this.zzn, false).zzd == zzcxVar.zzn(zzurVar.zza, this.zzn).zzd) {
            return zzlyVarZzf;
        }
        zzcxVar.zzn(zzurVar.zza, this.zzn);
        long jZzh = zzurVar.zzb() ? this.zzn.zzh(zzurVar.zzb, zzurVar.zzc) : this.zzn.zze;
        zzly zzlyVarZza3 = zzlyVarZzf.zzb(zzurVar, zzlyVarZzf.zzr, zzlyVarZzf.zzr, zzlyVarZzf.zzd, jZzh - zzlyVarZzf.zzr, zzlyVarZzf.zzh, zzlyVarZzf.zzi, zzlyVarZzf.zzj).zza(zzurVar);
        zzlyVarZza3.zzp = jZzh;
        return zzlyVarZza3;
    }

    private final zzmb zzae(zzma zzmaVar) {
        int iZzW = zzW(this.zzac);
        zzcx zzcxVar = this.zzac.zza;
        int i11 = iZzW == -1 ? 0 : iZzW;
        zzel zzelVar = this.zzu;
        zzkz zzkzVar = this.zzk;
        return new zzmb(zzkzVar, zzmaVar, zzcxVar, i11, zzelVar, zzkzVar.zzb());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzaf(final int i11, final int i12) {
        if (i11 == this.zzP.zzb() && i12 == this.zzP.zza()) {
            return;
        }
        this.zzP = new zzfq(i11, i12);
        zzfc zzfcVar = this.zzl;
        zzfcVar.zzd(24, new zzez() { // from class: com.google.android.gms.internal.ads.zzkb
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
                int i13 = zzko.zzd;
                ((zzcl) obj).zzo(i11, i12);
            }
        });
        zzfcVar.zzc();
        zzag(2, 14, new zzfq(i11, i12));
    }

    private final void zzag(int i11, int i12, @Nullable Object obj) {
        zzmf[] zzmfVarArr = this.zzh;
        int length = zzmfVarArr.length;
        for (int i13 = 0; i13 < 2; i13++) {
            zzmf zzmfVar = zzmfVarArr[i13];
            if (zzmfVar.zzbj() == i11) {
                zzmb zzmbVarZzae = zzae(zzmfVar);
                zzmbVarZzae.zzf(i12);
                zzmbVarZzae.zze(obj);
                zzmbVarZzae.zzd();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzah() {
        zzag(1, 2, Float.valueOf(this.zzU * this.zzy.zza()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzai(@Nullable Object obj) {
        ArrayList arrayList = new ArrayList();
        zzmf[] zzmfVarArr = this.zzh;
        int length = zzmfVarArr.length;
        boolean z11 = false;
        for (int i11 = 0; i11 < 2; i11++) {
            zzmf zzmfVar = zzmfVarArr[i11];
            if (zzmfVar.zzbj() == 2) {
                zzmb zzmbVarZzae = zzae(zzmfVar);
                zzmbVarZzae.zzf(1);
                zzmbVarZzae.zze(obj);
                zzmbVarZzae.zzd();
                arrayList.add(zzmbVarZzae);
            }
        }
        Object obj2 = this.zzM;
        if (obj2 != null && obj2 != obj) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((zzmb) it.next()).zzi(this.zzB);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
                z11 = true;
            }
            Object obj3 = this.zzM;
            Surface surface = this.zzN;
            if (obj3 == surface) {
                surface.release();
                this.zzN = null;
            }
        }
        this.zzM = obj;
        if (z11) {
            zzaj(zziz.zzd(new zzla(3), 1003));
        }
    }

    private final void zzaj(@Nullable zziz zzizVar) {
        zzly zzlyVar = this.zzac;
        zzly zzlyVarZza = zzlyVar.zza(zzlyVar.zzb);
        zzlyVarZza.zzp = zzlyVarZza.zzr;
        zzlyVarZza.zzq = 0L;
        zzly zzlyVarZze = zzlyVarZza.zze(1);
        if (zzizVar != null) {
            zzlyVarZze = zzlyVarZze.zzd(zzizVar);
        }
        this.zzC++;
        this.zzk.zzo();
        zzal(zzlyVarZze, 0, 1, false, 5, C.TIME_UNSET, -1, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzak(boolean z11, int i11, int i12) {
        int i13 = 0;
        boolean z12 = z11 && i11 != -1;
        if (z12 && i11 != 1) {
            i13 = 1;
        }
        zzly zzlyVar = this.zzac;
        if (zzlyVar.zzl == z12 && zzlyVar.zzm == i13) {
            return;
        }
        this.zzC++;
        zzly zzlyVarZzc = zzlyVar.zzc(z12, i13);
        this.zzk.zzn(z12, i13);
        zzal(zzlyVarZzc, 0, i12, false, 5, C.TIME_UNSET, -1, false);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:102:0x02e4  */
    /* JADX WARN: Code duplicated, block: B:104:0x02ea  */
    /* JADX WARN: Code duplicated, block: B:105:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:108:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:110:0x030d  */
    /* JADX WARN: Code duplicated, block: B:113:0x031d  */
    /* JADX WARN: Code duplicated, block: B:115:0x0331  */
    /* JADX WARN: Code duplicated, block: B:117:0x0341  */
    /* JADX WARN: Code duplicated, block: B:120:0x0350  */
    /* JADX WARN: Code duplicated, block: B:123:0x035e  */
    /* JADX WARN: Code duplicated, block: B:126:0x036b  */
    /* JADX WARN: Code duplicated, block: B:129:0x037e  */
    /* JADX WARN: Code duplicated, block: B:132:0x0393  */
    /* JADX WARN: Code duplicated, block: B:135:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:141:0x03de  */
    /* JADX WARN: Code duplicated, block: B:144:0x03e9  */
    /* JADX WARN: Code duplicated, block: B:146:0x03ee  */
    /* JADX WARN: Code duplicated, block: B:148:0x0400  */
    /* JADX WARN: Code duplicated, block: B:151:0x040c  */
    /* JADX WARN: Code duplicated, block: B:152:0x040e  */
    /* JADX WARN: Code duplicated, block: B:154:0x041e  */
    /* JADX WARN: Code duplicated, block: B:157:0x0429  */
    /* JADX WARN: Code duplicated, block: B:159:0x043b  */
    /* JADX WARN: Code duplicated, block: B:161:0x043f  */
    /* JADX WARN: Code duplicated, block: B:164:0x044c  */
    /* JADX WARN: Code duplicated, block: B:167:0x045c  */
    /* JADX WARN: Code duplicated, block: B:170:0x0474 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:172:0x0478  */
    /* JADX WARN: Code duplicated, block: B:175:0x047e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:178:0x0483  */
    /* JADX WARN: Code duplicated, block: B:181:0x048a A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:185:0x0491  */
    /* JADX WARN: Code duplicated, block: B:191:0x049d A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:193:0x04a1  */
    /* JADX WARN: Code duplicated, block: B:196:0x04a9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:200:0x04b0  */
    /* JADX WARN: Code duplicated, block: B:205:0x04c1 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:207:0x04c7  */
    /* JADX WARN: Code duplicated, block: B:210:0x04cf A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:212:0x04d5  */
    /* JADX WARN: Code duplicated, block: B:215:0x04e7  */
    /* JADX WARN: Code duplicated, block: B:37:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:39:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:40:0x010d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0113  */
    /* JADX WARN: Code duplicated, block: B:45:0x011e  */
    /* JADX WARN: Code duplicated, block: B:48:0x012d  */
    /* JADX WARN: Code duplicated, block: B:51:0x013a A[LOOP:1: B:49:0x0134->B:51:0x013a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:56:0x015a  */
    /* JADX WARN: Code duplicated, block: B:57:0x015d  */
    /* JADX WARN: Code duplicated, block: B:60:0x018a  */
    /* JADX WARN: Code duplicated, block: B:61:0x018c  */
    /* JADX WARN: Code duplicated, block: B:64:0x0193  */
    /* JADX WARN: Code duplicated, block: B:65:0x0195  */
    /* JADX WARN: Code duplicated, block: B:68:0x019a  */
    /* JADX WARN: Code duplicated, block: B:71:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:72:0x01a5  */
    /* JADX WARN: Code duplicated, block: B:74:0x01a8  */
    /* JADX WARN: Code duplicated, block: B:76:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:78:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:79:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:81:0x0206  */
    /* JADX WARN: Code duplicated, block: B:83:0x020e  */
    /* JADX WARN: Code duplicated, block: B:84:0x021d  */
    /* JADX WARN: Code duplicated, block: B:86:0x0224  */
    /* JADX WARN: Code duplicated, block: B:88:0x022c  */
    /* JADX WARN: Code duplicated, block: B:89:0x022f  */
    /* JADX WARN: Code duplicated, block: B:91:0x0237  */
    /* JADX WARN: Code duplicated, block: B:92:0x023e  */
    /* JADX WARN: Code duplicated, block: B:95:0x026a  */
    /* JADX WARN: Code duplicated, block: B:96:0x029d  */
    /* JADX WARN: Code duplicated, block: B:99:0x02b5  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v9 */
    private final void zzal(final zzly zzlyVar, final int i11, final int i12, boolean z11, int i13, long j11, int i14, boolean z12) {
        int i15;
        boolean z13;
        Pair pair;
        boolean z14;
        boolean z15;
        int i16;
        Pair pair2;
        boolean zBooleanValue;
        final int iIntValue;
        final zzbp zzbpVar;
        zzcx zzcxVarZzn;
        zzbv zzbvVarZzu;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        zzyp zzypVar;
        zzyp zzypVar2;
        zzck zzckVar;
        zzm zzmVar;
        zzcx zzcxVarZzn2;
        boolean z21;
        zzcx zzcxVarZzn3;
        boolean z22;
        int i17;
        boolean z23;
        ?? r14;
        zzcx zzcxVarZzn4;
        int iZzd;
        boolean z24;
        zzcx zzcxVarZzn5;
        long j12;
        zzcx zzcxVarZzn6;
        boolean z25;
        boolean zZzo;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z30;
        int i18;
        boolean z31;
        int i19;
        boolean z32;
        zzck zzckVarZze;
        zzcu zzcuVar;
        int i21;
        Object obj;
        zzbp zzbpVar2;
        Object obj2;
        int i22;
        long jZzaa;
        long jZzaa2;
        int iZzd2;
        Object obj3;
        zzbp zzbpVar3;
        Object obj4;
        int iZza;
        long jZzt;
        long jZzt2;
        zzbt zzbtVarZza;
        List list;
        int i23;
        zzby zzbyVar;
        int i24;
        final int i25 = i13;
        zzly zzlyVar2 = this.zzac;
        this.zzac = zzlyVar;
        boolean z33 = !zzlyVar2.zza.equals(zzlyVar.zza);
        zzcx zzcxVar = zzlyVar2.zza;
        zzcx zzcxVar2 = zzlyVar.zza;
        if (!zzcxVar2.zzo() || !zzcxVar.zzo()) {
            if (zzcxVar2.zzo() != zzcxVar.zzo()) {
                pair2 = new Pair(Boolean.TRUE, 3);
            } else if (zzcxVar.zze(zzcxVar.zzn(zzlyVar2.zzb.zza, this.zzn).zzd, this.zza, 0L).zzc.equals(zzcxVar2.zze(zzcxVar2.zzn(zzlyVar.zzb.zza, this.zzn).zzd, this.zza, 0L).zzc)) {
                if (!z11) {
                    i15 = i25;
                    z13 = false;
                } else if (i25 != 0) {
                    i15 = i25;
                    z13 = true;
                } else if (zzlyVar2.zzb.zzd < zzlyVar.zzb.zzd) {
                    pair = new Pair(Boolean.TRUE, 0);
                    i25 = 0;
                    z14 = true;
                } else {
                    z13 = true;
                    i15 = 0;
                }
                pair = new Pair(Boolean.FALSE, -1);
                int i26 = i15;
                z14 = z13;
                i25 = i26;
            } else {
                if (z11) {
                    if (i25 == 0) {
                        i25 = 0;
                        z14 = true;
                        i16 = 1;
                    } else {
                        z14 = true;
                        z15 = true;
                    }
                    pair = new Pair(Boolean.TRUE, Integer.valueOf(i16));
                } else {
                    z14 = false;
                    z15 = false;
                }
                if (z14 && i25 == 1) {
                    z14 = z15;
                    i16 = 2;
                } else {
                    if (!z33) {
                        throw new IllegalStateException();
                    }
                    i16 = 3;
                }
                pair = new Pair(Boolean.TRUE, Integer.valueOf(i16));
            }
            zBooleanValue = ((Boolean) pair.first).booleanValue();
            iIntValue = ((Integer) pair.second).intValue();
            if (zBooleanValue) {
                if (zzlyVar.zza.zzo()) {
                    zzbpVar = null;
                } else {
                    zzbpVar = zzlyVar.zza.zze(zzlyVar.zza.zzn(zzlyVar.zzb.zza, this.zzn).zzd, this.zza, 0L).zze;
                }
                this.zzab = zzbv.zza;
            } else {
                zzbpVar = null;
            }
            if (!zzlyVar2.zzj.equals(zzlyVar.zzj)) {
                zzbtVarZza = this.zzab.zza();
                list = zzlyVar.zzj;
                for (i23 = 0; i23 < list.size(); i23++) {
                    zzbyVar = (zzby) list.get(i23);
                    for (i24 = 0; i24 < zzbyVar.zza(); i24++) {
                        zzbyVar.zzb(i24).zza(zzbtVarZza);
                    }
                }
                this.zzab = zzbtVarZza.zzu();
            }
            zzcxVarZzn = zzn();
            if (zzcxVarZzn.zzo()) {
                zzbvVarZzu = this.zzab;
            } else {
                zzbp zzbpVar4 = zzcxVarZzn.zze(zzd(), this.zza, 0L).zze;
                zzbt zzbtVarZza2 = this.zzab.zza();
                zzbtVarZza2.zzb(zzbpVar4.zzg);
                zzbvVarZzu = zzbtVarZza2.zzu();
            }
            z16 = !zzbvVarZzu.equals(this.zzI);
            this.zzI = zzbvVarZzu;
            if (zzlyVar2.zzl != zzlyVar.zzl) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (zzlyVar2.zze != zzlyVar.zze) {
                z18 = true;
            } else {
                z18 = false;
            }
            if (z18 || z17) {
                zzam();
            }
            if (zzlyVar2.zzg != zzlyVar.zzg) {
                z19 = true;
            } else {
                z19 = false;
            }
            if (z33) {
                this.zzl.zzd(0, new zzez() { // from class: com.google.android.gms.internal.ads.zzjm
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj5) {
                        int i27 = zzko.zzd;
                        ((zzcl) obj5).zzp(zzlyVar.zza, i11);
                    }
                });
            }
            if (z14) {
                zzcuVar = new zzcu();
                if (zzlyVar2.zza.zzo()) {
                    i21 = i14;
                    obj = null;
                    zzbpVar2 = null;
                    obj2 = null;
                    i22 = -1;
                } else {
                    Object obj5 = zzlyVar2.zzb.zza;
                    zzlyVar2.zza.zzn(obj5, zzcuVar);
                    int i27 = zzcuVar.zzd;
                    int iZza2 = zzlyVar2.zza.zza(obj5);
                    obj2 = obj5;
                    obj = zzlyVar2.zza.zze(i27, this.zza, 0L).zzc;
                    zzbpVar2 = this.zza.zze;
                    i21 = i27;
                    i22 = iZza2;
                }
                if (i25 == 0) {
                    if (zzlyVar2.zzb.zzb()) {
                        zzur zzurVar = zzlyVar2.zzb;
                        jZzaa = zzcuVar.zzh(zzurVar.zzb, zzurVar.zzc);
                        jZzaa2 = zzaa(zzlyVar2);
                    } else {
                        if (zzlyVar2.zzb.zze != -1) {
                            jZzaa = zzaa(this.zzac);
                        } else {
                            jZzaa = zzcuVar.zze;
                        }
                        jZzaa2 = jZzaa;
                    }
                } else if (zzlyVar2.zzb.zzb()) {
                    jZzaa = zzlyVar2.zzr;
                    jZzaa2 = zzaa(zzlyVar2);
                } else {
                    jZzaa = zzlyVar2.zzr;
                    jZzaa2 = jZzaa;
                }
                int i28 = zzfy.zza;
                zzur zzurVar2 = zzlyVar2.zzb;
                final zzcn zzcnVar = new zzcn(obj, i21, zzbpVar2, obj2, i22, zzfy.zzt(jZzaa), zzfy.zzt(jZzaa2), zzurVar2.zzb, zzurVar2.zzc);
                iZzd2 = zzd();
                if (this.zzac.zza.zzo()) {
                    obj3 = null;
                    zzbpVar3 = null;
                    obj4 = null;
                    iZza = -1;
                } else {
                    zzly zzlyVar3 = this.zzac;
                    Object obj6 = zzlyVar3.zzb.zza;
                    zzlyVar3.zza.zzn(obj6, this.zzn);
                    iZza = this.zzac.zza.zza(obj6);
                    obj3 = this.zzac.zza.zze(iZzd2, this.zza, 0L).zzc;
                    zzbpVar3 = this.zza.zze;
                    obj4 = obj6;
                }
                jZzt = zzfy.zzt(j11);
                if (this.zzac.zzb.zzb()) {
                    jZzt2 = zzfy.zzt(zzaa(this.zzac));
                } else {
                    jZzt2 = jZzt;
                }
                zzur zzurVar3 = this.zzac.zzb;
                final zzcn zzcnVar2 = new zzcn(obj3, iZzd2, zzbpVar3, obj4, iZza, jZzt, jZzt2, zzurVar3.zzb, zzurVar3.zzc);
                this.zzl.zzd(11, new zzez() { // from class: com.google.android.gms.internal.ads.zzjr
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj7) {
                        int i29 = zzko.zzd;
                        ((zzcl) obj7).zzm(zzcnVar, zzcnVar2, i25);
                    }
                });
            } else {
                z17 = z17;
                z19 = z19;
            }
            if (zBooleanValue) {
                this.zzl.zzd(1, new zzez() { // from class: com.google.android.gms.internal.ads.zzjt
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj7) {
                        int i29 = zzko.zzd;
                        ((zzcl) obj7).zzd(zzbpVar, iIntValue);
                    }
                });
            }
            if (zzlyVar2.zzf != zzlyVar.zzf) {
                this.zzl.zzd(10, new zzez() { // from class: com.google.android.gms.internal.ads.zzju
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj7) {
                        int i29 = zzko.zzd;
                        ((zzcl) obj7).zzk(zzlyVar.zzf);
                    }
                });
                if (zzlyVar.zzf != null) {
                    this.zzl.zzd(10, new zzez() { // from class: com.google.android.gms.internal.ads.zzjv
                        @Override // com.google.android.gms.internal.ads.zzez
                        public final void zza(Object obj7) {
                            int i29 = zzko.zzd;
                            ((zzcl) obj7).zzj(zzlyVar.zzf);
                        }
                    });
                }
            }
            zzypVar = zzlyVar2.zzi;
            zzypVar2 = zzlyVar.zzi;
            if (zzypVar != zzypVar2) {
                this.zzi.zzq(zzypVar2.zze);
                this.zzl.zzd(2, new zzez() { // from class: com.google.android.gms.internal.ads.zzjw
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj7) {
                        int i29 = zzko.zzd;
                        ((zzcl) obj7).zzq(zzlyVar.zzi.zzd);
                    }
                });
            }
            if (z16) {
                final zzbv zzbvVar = this.zzI;
                this.zzl.zzd(14, new zzez() { // from class: com.google.android.gms.internal.ads.zzjx
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj7) {
                        int i29 = zzko.zzd;
                        ((zzcl) obj7).zze(zzbvVar);
                    }
                });
            }
            if (z19) {
                this.zzl.zzd(3, new zzez() { // from class: com.google.android.gms.internal.ads.zzjy
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj7) {
                        int i29 = zzko.zzd;
                        ((zzcl) obj7).zzb(zzlyVar.zzg);
                    }
                });
            }
            if (z18 || z17) {
                this.zzl.zzd(-1, new zzez() { // from class: com.google.android.gms.internal.ads.zzjz
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj7) {
                        int i29 = zzko.zzd;
                        zzly zzlyVar4 = zzlyVar;
                        ((zzcl) obj7).zzl(zzlyVar4.zzl, zzlyVar4.zze);
                    }
                });
            }
            if (z18) {
                this.zzl.zzd(4, new zzez() { // from class: com.google.android.gms.internal.ads.zzka
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj7) {
                        int i29 = zzko.zzd;
                        ((zzcl) obj7).zzh(zzlyVar.zze);
                    }
                });
            }
            if (z17) {
                this.zzl.zzd(5, new zzez() { // from class: com.google.android.gms.internal.ads.zzjn
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj7) {
                        int i29 = zzko.zzd;
                        ((zzcl) obj7).zzf(zzlyVar.zzl, i12);
                    }
                });
            }
            if (zzlyVar2.zzm != zzlyVar.zzm) {
                this.zzl.zzd(6, new zzez() { // from class: com.google.android.gms.internal.ads.zzjo
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj7) {
                        int i29 = zzko.zzd;
                        ((zzcl) obj7).zzi(zzlyVar.zzm);
                    }
                });
            }
            if (zzlyVar2.zzi() != zzlyVar.zzi()) {
                this.zzl.zzd(7, new zzez() { // from class: com.google.android.gms.internal.ads.zzjp
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj7) {
                        int i29 = zzko.zzd;
                        ((zzcl) obj7).zzc(zzlyVar.zzi());
                    }
                });
            }
            if (!zzlyVar2.zzn.equals(zzlyVar.zzn)) {
                this.zzl.zzd(12, new zzez() { // from class: com.google.android.gms.internal.ads.zzjq
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj7) {
                        int i29 = zzko.zzd;
                        ((zzcl) obj7).zzg(zzlyVar.zzn);
                    }
                });
            }
            zzckVar = this.zzH;
            zzco zzcoVar = this.zzg;
            zzck zzckVar2 = this.zzc;
            int i29 = zzfy.zza;
            boolean zZzx = zzcoVar.zzx();
            zzmVar = (zzm) zzcoVar;
            zzcxVarZzn2 = zzmVar.zzn();
            if (zzcxVarZzn2.zzo() && zzcxVarZzn2.zze(zzmVar.zzd(), zzmVar.zza, 0L).zzi) {
                z21 = true;
            } else {
                z21 = false;
            }
            zzcxVarZzn3 = zzmVar.zzn();
            if (zzcxVarZzn3.zzo()) {
                int iZzd3 = zzmVar.zzd();
                zzmVar.zzh();
                zzmVar.zzw();
                z22 = false;
                r14 = 0;
                int iZzk = zzcxVarZzn3.zzk(iZzd3, 0, false);
                i17 = -1;
                z23 = iZzk != -1;
                zzcxVarZzn4 = zzmVar.zzn();
                if (zzcxVarZzn4.zzo()) {
                    z24 = false;
                } else {
                    iZzd = zzmVar.zzd();
                    zzmVar.zzh();
                    zzmVar.zzw();
                    if (zzcxVarZzn4.zzj(iZzd, r14, r14) != i17) {
                        z24 = true;
                    } else {
                        z24 = false;
                    }
                }
                zzcxVarZzn5 = zzmVar.zzn();
                if (!zzcxVarZzn5.zzo()) {
                    j12 = 0;
                    boolean z34 = zzcxVarZzn5.zze(zzmVar.zzd(), zzmVar.zza, 0L).zzb();
                    zzcxVarZzn6 = zzmVar.zzn();
                    if (zzcxVarZzn6.zzo() && zzcxVarZzn6.zze(zzmVar.zzd(), zzmVar.zza, j12).zzj) {
                        z25 = true;
                    } else {
                        z25 = false;
                    }
                    zZzo = zzcoVar.zzn().zzo();
                    zzci zzciVar = new zzci();
                    zzciVar.zzb(zzckVar2);
                    boolean z35 = !zZzx;
                    zzciVar.zzd(4, z35);
                    if (z21 || zZzx) {
                        z26 = false;
                    } else {
                        z26 = true;
                    }
                    zzciVar.zzd(5, z26);
                    if (z23 || zZzx) {
                        z27 = false;
                    } else {
                        z27 = true;
                    }
                    zzciVar.zzd(6, z27);
                    if (!zZzo || (!(z23 || !z34 || z21) || zZzx)) {
                        z28 = false;
                    } else {
                        z28 = true;
                    }
                    zzciVar.zzd(7, z28);
                    if (z24 || zZzx) {
                        z29 = false;
                    } else {
                        z29 = true;
                    }
                    zzciVar.zzd(8, z29);
                    if (!zZzo || (!(z24 || (z34 && z25)) || zZzx)) {
                        z30 = false;
                    } else {
                        z30 = true;
                    }
                    zzciVar.zzd(9, z30);
                    zzciVar.zzd(10, z35);
                    if (z21 || zZzx) {
                        i18 = 11;
                        z31 = false;
                    } else {
                        i18 = 11;
                        z31 = true;
                    }
                    zzciVar.zzd(i18, z31);
                    if (z21 || zZzx) {
                        i19 = 12;
                        z32 = false;
                    } else {
                        i19 = 12;
                        z32 = true;
                    }
                    zzciVar.zzd(i19, z32);
                    zzckVarZze = zzciVar.zze();
                    this.zzH = zzckVarZze;
                    if (!zzckVarZze.equals(zzckVar)) {
                        this.zzl.zzd(13, new zzez() { // from class: com.google.android.gms.internal.ads.zzjl
                            @Override // com.google.android.gms.internal.ads.zzez
                            public final void zza(Object obj7) {
                                this.zza.zzU((zzcl) obj7);
                            }
                        });
                    }
                    this.zzl.zzc();
                }
                j12 = 0;
                zzcxVarZzn6 = zzmVar.zzn();
                if (zzcxVarZzn6.zzo()) {
                    z25 = false;
                } else {
                    z25 = false;
                }
                zZzo = zzcoVar.zzn().zzo();
                zzci zzciVar2 = new zzci();
                zzciVar2.zzb(zzckVar2);
                boolean z36 = !zZzx;
                zzciVar2.zzd(4, z36);
                if (z21) {
                    z26 = false;
                } else {
                    z26 = false;
                }
                zzciVar2.zzd(5, z26);
                if (z23) {
                    z27 = false;
                } else {
                    z27 = false;
                }
                zzciVar2.zzd(6, z27);
                if (zZzo) {
                    z28 = false;
                } else {
                    z28 = false;
                }
                zzciVar2.zzd(7, z28);
                if (z24) {
                    z29 = false;
                } else {
                    z29 = false;
                }
                zzciVar2.zzd(8, z29);
                if (zZzo) {
                    z30 = false;
                } else {
                    z30 = false;
                }
                zzciVar2.zzd(9, z30);
                zzciVar2.zzd(10, z36);
                if (z21) {
                    i18 = 11;
                    z31 = false;
                } else {
                    i18 = 11;
                    z31 = false;
                }
                zzciVar2.zzd(i18, z31);
                if (z21) {
                    i19 = 12;
                    z32 = false;
                } else {
                    i19 = 12;
                    z32 = false;
                }
                zzciVar2.zzd(i19, z32);
                zzckVarZze = zzciVar2.zze();
                this.zzH = zzckVarZze;
                if (!zzckVarZze.equals(zzckVar)) {
                    this.zzl.zzd(13, new zzez() { // from class: com.google.android.gms.internal.ads.zzjl
                        @Override // com.google.android.gms.internal.ads.zzez
                        public final void zza(Object obj7) {
                            this.zza.zzU((zzcl) obj7);
                        }
                    });
                }
                this.zzl.zzc();
            }
            i17 = -1;
            z22 = false;
            r14 = z22;
            zzcxVarZzn4 = zzmVar.zzn();
            if (zzcxVarZzn4.zzo()) {
                z24 = false;
            } else {
                iZzd = zzmVar.zzd();
                zzmVar.zzh();
                zzmVar.zzw();
                if (zzcxVarZzn4.zzj(iZzd, r14, r14) != i17) {
                    z24 = true;
                } else {
                    z24 = false;
                }
            }
            zzcxVarZzn5 = zzmVar.zzn();
            if (!zzcxVarZzn5.zzo()) {
                j12 = 0;
                if (zzcxVarZzn5.zze(zzmVar.zzd(), zzmVar.zza, 0L).zzb()) {
                }
                zzcxVarZzn6 = zzmVar.zzn();
                if (zzcxVarZzn6.zzo()) {
                    z25 = false;
                } else {
                    z25 = false;
                }
                zZzo = zzcoVar.zzn().zzo();
                zzci zzciVar3 = new zzci();
                zzciVar3.zzb(zzckVar2);
                boolean z37 = !zZzx;
                zzciVar3.zzd(4, z37);
                if (z21) {
                    z26 = false;
                } else {
                    z26 = false;
                }
                zzciVar3.zzd(5, z26);
                if (z23) {
                    z27 = false;
                } else {
                    z27 = false;
                }
                zzciVar3.zzd(6, z27);
                if (zZzo) {
                    z28 = false;
                } else {
                    z28 = false;
                }
                zzciVar3.zzd(7, z28);
                if (z24) {
                    z29 = false;
                } else {
                    z29 = false;
                }
                zzciVar3.zzd(8, z29);
                if (zZzo) {
                    z30 = false;
                } else {
                    z30 = false;
                }
                zzciVar3.zzd(9, z30);
                zzciVar3.zzd(10, z37);
                if (z21) {
                    i18 = 11;
                    z31 = false;
                } else {
                    i18 = 11;
                    z31 = false;
                }
                zzciVar3.zzd(i18, z31);
                if (z21) {
                    i19 = 12;
                    z32 = false;
                } else {
                    i19 = 12;
                    z32 = false;
                }
                zzciVar3.zzd(i19, z32);
                zzckVarZze = zzciVar3.zze();
                this.zzH = zzckVarZze;
                if (!zzckVarZze.equals(zzckVar)) {
                    this.zzl.zzd(13, new zzez() { // from class: com.google.android.gms.internal.ads.zzjl
                        @Override // com.google.android.gms.internal.ads.zzez
                        public final void zza(Object obj7) {
                            this.zza.zzU((zzcl) obj7);
                        }
                    });
                }
                this.zzl.zzc();
            }
            j12 = 0;
            zzcxVarZzn6 = zzmVar.zzn();
            if (zzcxVarZzn6.zzo()) {
                z25 = false;
            } else {
                z25 = false;
            }
            zZzo = zzcoVar.zzn().zzo();
            zzci zzciVar4 = new zzci();
            zzciVar4.zzb(zzckVar2);
            boolean z38 = !zZzx;
            zzciVar4.zzd(4, z38);
            if (z21) {
                z26 = false;
            } else {
                z26 = false;
            }
            zzciVar4.zzd(5, z26);
            if (z23) {
                z27 = false;
            } else {
                z27 = false;
            }
            zzciVar4.zzd(6, z27);
            if (zZzo) {
                z28 = false;
            } else {
                z28 = false;
            }
            zzciVar4.zzd(7, z28);
            if (z24) {
                z29 = false;
            } else {
                z29 = false;
            }
            zzciVar4.zzd(8, z29);
            if (zZzo) {
                z30 = false;
            } else {
                z30 = false;
            }
            zzciVar4.zzd(9, z30);
            zzciVar4.zzd(10, z38);
            if (z21) {
                i18 = 11;
                z31 = false;
            } else {
                i18 = 11;
                z31 = false;
            }
            zzciVar4.zzd(i18, z31);
            if (z21) {
                i19 = 12;
                z32 = false;
            } else {
                i19 = 12;
                z32 = false;
            }
            zzciVar4.zzd(i19, z32);
            zzckVarZze = zzciVar4.zze();
            this.zzH = zzckVarZze;
            if (!zzckVarZze.equals(zzckVar)) {
                this.zzl.zzd(13, new zzez() { // from class: com.google.android.gms.internal.ads.zzjl
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj7) {
                        this.zza.zzU((zzcl) obj7);
                    }
                });
            }
            this.zzl.zzc();
        }
        pair2 = new Pair(Boolean.FALSE, -1);
        pair = pair2;
        z14 = z11;
        zBooleanValue = ((Boolean) pair.first).booleanValue();
        iIntValue = ((Integer) pair.second).intValue();
        if (zBooleanValue) {
            if (zzlyVar.zza.zzo()) {
                zzbpVar = zzlyVar.zza.zze(zzlyVar.zza.zzn(zzlyVar.zzb.zza, this.zzn).zzd, this.zza, 0L).zze;
            } else {
                zzbpVar = null;
            }
            this.zzab = zzbv.zza;
        } else {
            zzbpVar = null;
        }
        if (!zzlyVar2.zzj.equals(zzlyVar.zzj)) {
            zzbtVarZza = this.zzab.zza();
            list = zzlyVar.zzj;
            while (i23 < list.size()) {
                zzbyVar = (zzby) list.get(i23);
                while (i24 < zzbyVar.zza()) {
                    zzbyVar.zzb(i24).zza(zzbtVarZza);
                }
            }
            this.zzab = zzbtVarZza.zzu();
        }
        zzcxVarZzn = zzn();
        if (zzcxVarZzn.zzo()) {
            zzbvVarZzu = this.zzab;
        } else {
            zzbp zzbpVar5 = zzcxVarZzn.zze(zzd(), this.zza, 0L).zze;
            zzbt zzbtVarZza3 = this.zzab.zza();
            zzbtVarZza3.zzb(zzbpVar5.zzg);
            zzbvVarZzu = zzbtVarZza3.zzu();
        }
        z16 = !zzbvVarZzu.equals(this.zzI);
        this.zzI = zzbvVarZzu;
        if (zzlyVar2.zzl != zzlyVar.zzl) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (zzlyVar2.zze != zzlyVar.zze) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (z18) {
            zzam();
        } else {
            zzam();
        }
        if (zzlyVar2.zzg != zzlyVar.zzg) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z33) {
            this.zzl.zzd(0, new zzez() { // from class: com.google.android.gms.internal.ads.zzjm
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj7) {
                    int i210 = zzko.zzd;
                    ((zzcl) obj7).zzp(zzlyVar.zza, i11);
                }
            });
        }
        if (z14) {
            zzcuVar = new zzcu();
            if (zzlyVar2.zza.zzo()) {
                Object obj7 = zzlyVar2.zzb.zza;
                zzlyVar2.zza.zzn(obj7, zzcuVar);
                int i210 = zzcuVar.zzd;
                int iZza3 = zzlyVar2.zza.zza(obj7);
                obj2 = obj7;
                obj = zzlyVar2.zza.zze(i210, this.zza, 0L).zzc;
                zzbpVar2 = this.zza.zze;
                i21 = i210;
                i22 = iZza3;
            } else {
                i21 = i14;
                obj = null;
                zzbpVar2 = null;
                obj2 = null;
                i22 = -1;
            }
            if (i25 == 0) {
                if (zzlyVar2.zzb.zzb()) {
                    zzur zzurVar4 = zzlyVar2.zzb;
                    jZzaa = zzcuVar.zzh(zzurVar4.zzb, zzurVar4.zzc);
                    jZzaa2 = zzaa(zzlyVar2);
                } else {
                    if (zzlyVar2.zzb.zze != -1) {
                        jZzaa = zzaa(this.zzac);
                    } else {
                        jZzaa = zzcuVar.zze;
                    }
                    jZzaa2 = jZzaa;
                }
            } else if (zzlyVar2.zzb.zzb()) {
                jZzaa = zzlyVar2.zzr;
                jZzaa2 = zzaa(zzlyVar2);
            } else {
                jZzaa = zzlyVar2.zzr;
                jZzaa2 = jZzaa;
            }
            int i211 = zzfy.zza;
            zzur zzurVar5 = zzlyVar2.zzb;
            final zzcn zzcnVar3 = new zzcn(obj, i21, zzbpVar2, obj2, i22, zzfy.zzt(jZzaa), zzfy.zzt(jZzaa2), zzurVar5.zzb, zzurVar5.zzc);
            iZzd2 = zzd();
            if (this.zzac.zza.zzo()) {
                zzly zzlyVar4 = this.zzac;
                Object obj8 = zzlyVar4.zzb.zza;
                zzlyVar4.zza.zzn(obj8, this.zzn);
                iZza = this.zzac.zza.zza(obj8);
                obj3 = this.zzac.zza.zze(iZzd2, this.zza, 0L).zzc;
                zzbpVar3 = this.zza.zze;
                obj4 = obj8;
            } else {
                obj3 = null;
                zzbpVar3 = null;
                obj4 = null;
                iZza = -1;
            }
            jZzt = zzfy.zzt(j11);
            if (this.zzac.zzb.zzb()) {
                jZzt2 = zzfy.zzt(zzaa(this.zzac));
            } else {
                jZzt2 = jZzt;
            }
            zzur zzurVar6 = this.zzac.zzb;
            final zzcn zzcnVar4 = new zzcn(obj3, iZzd2, zzbpVar3, obj4, iZza, jZzt, jZzt2, zzurVar6.zzb, zzurVar6.zzc);
            this.zzl.zzd(11, new zzez() { // from class: com.google.android.gms.internal.ads.zzjr
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj9) {
                    int i212 = zzko.zzd;
                    ((zzcl) obj9).zzm(zzcnVar3, zzcnVar4, i25);
                }
            });
        } else {
            z17 = z17;
            z19 = z19;
        }
        if (zBooleanValue) {
            this.zzl.zzd(1, new zzez() { // from class: com.google.android.gms.internal.ads.zzjt
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj9) {
                    int i212 = zzko.zzd;
                    ((zzcl) obj9).zzd(zzbpVar, iIntValue);
                }
            });
        }
        if (zzlyVar2.zzf != zzlyVar.zzf) {
            this.zzl.zzd(10, new zzez() { // from class: com.google.android.gms.internal.ads.zzju
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj9) {
                    int i212 = zzko.zzd;
                    ((zzcl) obj9).zzk(zzlyVar.zzf);
                }
            });
            if (zzlyVar.zzf != null) {
                this.zzl.zzd(10, new zzez() { // from class: com.google.android.gms.internal.ads.zzjv
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj9) {
                        int i212 = zzko.zzd;
                        ((zzcl) obj9).zzj(zzlyVar.zzf);
                    }
                });
            }
        }
        zzypVar = zzlyVar2.zzi;
        zzypVar2 = zzlyVar.zzi;
        if (zzypVar != zzypVar2) {
            this.zzi.zzq(zzypVar2.zze);
            this.zzl.zzd(2, new zzez() { // from class: com.google.android.gms.internal.ads.zzjw
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj9) {
                    int i212 = zzko.zzd;
                    ((zzcl) obj9).zzq(zzlyVar.zzi.zzd);
                }
            });
        }
        if (z16) {
            final zzbv zzbvVar2 = this.zzI;
            this.zzl.zzd(14, new zzez() { // from class: com.google.android.gms.internal.ads.zzjx
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj9) {
                    int i212 = zzko.zzd;
                    ((zzcl) obj9).zze(zzbvVar2);
                }
            });
        }
        if (z19) {
            this.zzl.zzd(3, new zzez() { // from class: com.google.android.gms.internal.ads.zzjy
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj9) {
                    int i212 = zzko.zzd;
                    ((zzcl) obj9).zzb(zzlyVar.zzg);
                }
            });
        }
        if (z18) {
            this.zzl.zzd(-1, new zzez() { // from class: com.google.android.gms.internal.ads.zzjz
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj9) {
                    int i212 = zzko.zzd;
                    zzly zzlyVar5 = zzlyVar;
                    ((zzcl) obj9).zzl(zzlyVar5.zzl, zzlyVar5.zze);
                }
            });
        } else {
            this.zzl.zzd(-1, new zzez() { // from class: com.google.android.gms.internal.ads.zzjz
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj9) {
                    int i212 = zzko.zzd;
                    zzly zzlyVar5 = zzlyVar;
                    ((zzcl) obj9).zzl(zzlyVar5.zzl, zzlyVar5.zze);
                }
            });
        }
        if (z18) {
            this.zzl.zzd(4, new zzez() { // from class: com.google.android.gms.internal.ads.zzka
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj9) {
                    int i212 = zzko.zzd;
                    ((zzcl) obj9).zzh(zzlyVar.zze);
                }
            });
        }
        if (z17) {
            this.zzl.zzd(5, new zzez() { // from class: com.google.android.gms.internal.ads.zzjn
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj9) {
                    int i212 = zzko.zzd;
                    ((zzcl) obj9).zzf(zzlyVar.zzl, i12);
                }
            });
        }
        if (zzlyVar2.zzm != zzlyVar.zzm) {
            this.zzl.zzd(6, new zzez() { // from class: com.google.android.gms.internal.ads.zzjo
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj9) {
                    int i212 = zzko.zzd;
                    ((zzcl) obj9).zzi(zzlyVar.zzm);
                }
            });
        }
        if (zzlyVar2.zzi() != zzlyVar.zzi()) {
            this.zzl.zzd(7, new zzez() { // from class: com.google.android.gms.internal.ads.zzjp
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj9) {
                    int i212 = zzko.zzd;
                    ((zzcl) obj9).zzc(zzlyVar.zzi());
                }
            });
        }
        if (!zzlyVar2.zzn.equals(zzlyVar.zzn)) {
            this.zzl.zzd(12, new zzez() { // from class: com.google.android.gms.internal.ads.zzjq
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj9) {
                    int i212 = zzko.zzd;
                    ((zzcl) obj9).zzg(zzlyVar.zzn);
                }
            });
        }
        zzckVar = this.zzH;
        zzco zzcoVar2 = this.zzg;
        zzck zzckVar3 = this.zzc;
        int i212 = zzfy.zza;
        boolean zZzx2 = zzcoVar2.zzx();
        zzmVar = (zzm) zzcoVar2;
        zzcxVarZzn2 = zzmVar.zzn();
        if (zzcxVarZzn2.zzo()) {
            z21 = false;
        } else {
            z21 = false;
        }
        zzcxVarZzn3 = zzmVar.zzn();
        if (zzcxVarZzn3.zzo()) {
            int iZzd4 = zzmVar.zzd();
            zzmVar.zzh();
            zzmVar.zzw();
            z22 = false;
            r14 = 0;
            int iZzk2 = zzcxVarZzn3.zzk(iZzd4, 0, false);
            i17 = -1;
            if (iZzk2 != -1) {
            }
            zzcxVarZzn4 = zzmVar.zzn();
            if (zzcxVarZzn4.zzo()) {
                z24 = false;
            } else {
                iZzd = zzmVar.zzd();
                zzmVar.zzh();
                zzmVar.zzw();
                if (zzcxVarZzn4.zzj(iZzd, r14, r14) != i17) {
                    z24 = true;
                } else {
                    z24 = false;
                }
            }
            zzcxVarZzn5 = zzmVar.zzn();
            if (!zzcxVarZzn5.zzo()) {
                j12 = 0;
                if (zzcxVarZzn5.zze(zzmVar.zzd(), zzmVar.zza, 0L).zzb()) {
                }
                zzcxVarZzn6 = zzmVar.zzn();
                if (zzcxVarZzn6.zzo()) {
                    z25 = false;
                } else {
                    z25 = false;
                }
                zZzo = zzcoVar2.zzn().zzo();
                zzci zzciVar5 = new zzci();
                zzciVar5.zzb(zzckVar3);
                boolean z39 = !zZzx2;
                zzciVar5.zzd(4, z39);
                if (z21) {
                    z26 = false;
                } else {
                    z26 = false;
                }
                zzciVar5.zzd(5, z26);
                if (z23) {
                    z27 = false;
                } else {
                    z27 = false;
                }
                zzciVar5.zzd(6, z27);
                if (zZzo) {
                    z28 = false;
                } else {
                    z28 = false;
                }
                zzciVar5.zzd(7, z28);
                if (z24) {
                    z29 = false;
                } else {
                    z29 = false;
                }
                zzciVar5.zzd(8, z29);
                if (zZzo) {
                    z30 = false;
                } else {
                    z30 = false;
                }
                zzciVar5.zzd(9, z30);
                zzciVar5.zzd(10, z39);
                if (z21) {
                    i18 = 11;
                    z31 = false;
                } else {
                    i18 = 11;
                    z31 = false;
                }
                zzciVar5.zzd(i18, z31);
                if (z21) {
                    i19 = 12;
                    z32 = false;
                } else {
                    i19 = 12;
                    z32 = false;
                }
                zzciVar5.zzd(i19, z32);
                zzckVarZze = zzciVar5.zze();
                this.zzH = zzckVarZze;
                if (!zzckVarZze.equals(zzckVar)) {
                    this.zzl.zzd(13, new zzez() { // from class: com.google.android.gms.internal.ads.zzjl
                        @Override // com.google.android.gms.internal.ads.zzez
                        public final void zza(Object obj9) {
                            this.zza.zzU((zzcl) obj9);
                        }
                    });
                }
                this.zzl.zzc();
            }
            j12 = 0;
            zzcxVarZzn6 = zzmVar.zzn();
            if (zzcxVarZzn6.zzo()) {
                z25 = false;
            } else {
                z25 = false;
            }
            zZzo = zzcoVar2.zzn().zzo();
            zzci zzciVar6 = new zzci();
            zzciVar6.zzb(zzckVar3);
            boolean z310 = !zZzx2;
            zzciVar6.zzd(4, z310);
            if (z21) {
                z26 = false;
            } else {
                z26 = false;
            }
            zzciVar6.zzd(5, z26);
            if (z23) {
                z27 = false;
            } else {
                z27 = false;
            }
            zzciVar6.zzd(6, z27);
            if (zZzo) {
                z28 = false;
            } else {
                z28 = false;
            }
            zzciVar6.zzd(7, z28);
            if (z24) {
                z29 = false;
            } else {
                z29 = false;
            }
            zzciVar6.zzd(8, z29);
            if (zZzo) {
                z30 = false;
            } else {
                z30 = false;
            }
            zzciVar6.zzd(9, z30);
            zzciVar6.zzd(10, z310);
            if (z21) {
                i18 = 11;
                z31 = false;
            } else {
                i18 = 11;
                z31 = false;
            }
            zzciVar6.zzd(i18, z31);
            if (z21) {
                i19 = 12;
                z32 = false;
            } else {
                i19 = 12;
                z32 = false;
            }
            zzciVar6.zzd(i19, z32);
            zzckVarZze = zzciVar6.zze();
            this.zzH = zzckVarZze;
            if (!zzckVarZze.equals(zzckVar)) {
                this.zzl.zzd(13, new zzez() { // from class: com.google.android.gms.internal.ads.zzjl
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj9) {
                        this.zza.zzU((zzcl) obj9);
                    }
                });
            }
            this.zzl.zzc();
        }
        i17 = -1;
        z22 = false;
        r14 = z22;
        zzcxVarZzn4 = zzmVar.zzn();
        if (zzcxVarZzn4.zzo()) {
            z24 = false;
        } else {
            iZzd = zzmVar.zzd();
            zzmVar.zzh();
            zzmVar.zzw();
            if (zzcxVarZzn4.zzj(iZzd, r14, r14) != i17) {
                z24 = true;
            } else {
                z24 = false;
            }
        }
        zzcxVarZzn5 = zzmVar.zzn();
        if (!zzcxVarZzn5.zzo()) {
            j12 = 0;
            if (zzcxVarZzn5.zze(zzmVar.zzd(), zzmVar.zza, 0L).zzb()) {
            }
            zzcxVarZzn6 = zzmVar.zzn();
            if (zzcxVarZzn6.zzo()) {
                z25 = false;
            } else {
                z25 = false;
            }
            zZzo = zzcoVar2.zzn().zzo();
            zzci zzciVar7 = new zzci();
            zzciVar7.zzb(zzckVar3);
            boolean z311 = !zZzx2;
            zzciVar7.zzd(4, z311);
            if (z21) {
                z26 = false;
            } else {
                z26 = false;
            }
            zzciVar7.zzd(5, z26);
            if (z23) {
                z27 = false;
            } else {
                z27 = false;
            }
            zzciVar7.zzd(6, z27);
            if (zZzo) {
                z28 = false;
            } else {
                z28 = false;
            }
            zzciVar7.zzd(7, z28);
            if (z24) {
                z29 = false;
            } else {
                z29 = false;
            }
            zzciVar7.zzd(8, z29);
            if (zZzo) {
                z30 = false;
            } else {
                z30 = false;
            }
            zzciVar7.zzd(9, z30);
            zzciVar7.zzd(10, z311);
            if (z21) {
                i18 = 11;
                z31 = false;
            } else {
                i18 = 11;
                z31 = false;
            }
            zzciVar7.zzd(i18, z31);
            if (z21) {
                i19 = 12;
                z32 = false;
            } else {
                i19 = 12;
                z32 = false;
            }
            zzciVar7.zzd(i19, z32);
            zzckVarZze = zzciVar7.zze();
            this.zzH = zzckVarZze;
            if (!zzckVarZze.equals(zzckVar)) {
                this.zzl.zzd(13, new zzez() { // from class: com.google.android.gms.internal.ads.zzjl
                    @Override // com.google.android.gms.internal.ads.zzez
                    public final void zza(Object obj9) {
                        this.zza.zzU((zzcl) obj9);
                    }
                });
            }
            this.zzl.zzc();
        }
        j12 = 0;
        zzcxVarZzn6 = zzmVar.zzn();
        if (zzcxVarZzn6.zzo()) {
            z25 = false;
        } else {
            z25 = false;
        }
        zZzo = zzcoVar2.zzn().zzo();
        zzci zzciVar8 = new zzci();
        zzciVar8.zzb(zzckVar3);
        boolean z312 = !zZzx2;
        zzciVar8.zzd(4, z312);
        if (z21) {
            z26 = false;
        } else {
            z26 = false;
        }
        zzciVar8.zzd(5, z26);
        if (z23) {
            z27 = false;
        } else {
            z27 = false;
        }
        zzciVar8.zzd(6, z27);
        if (zZzo) {
            z28 = false;
        } else {
            z28 = false;
        }
        zzciVar8.zzd(7, z28);
        if (z24) {
            z29 = false;
        } else {
            z29 = false;
        }
        zzciVar8.zzd(8, z29);
        if (zZzo) {
            z30 = false;
        } else {
            z30 = false;
        }
        zzciVar8.zzd(9, z30);
        zzciVar8.zzd(10, z312);
        if (z21) {
            i18 = 11;
            z31 = false;
        } else {
            i18 = 11;
            z31 = false;
        }
        zzciVar8.zzd(i18, z31);
        if (z21) {
            i19 = 12;
            z32 = false;
        } else {
            i19 = 12;
            z32 = false;
        }
        zzciVar8.zzd(i19, z32);
        zzckVarZze = zzciVar8.zze();
        this.zzH = zzckVarZze;
        if (!zzckVarZze.equals(zzckVar)) {
            this.zzl.zzd(13, new zzez() { // from class: com.google.android.gms.internal.ads.zzjl
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj9) {
                    this.zza.zzU((zzcl) obj9);
                }
            });
        }
        this.zzl.zzc();
    }

    private final void zzam() {
        int iZzf = zzf();
        if (iZzf == 2 || iZzf == 3) {
            zzan();
            boolean z11 = this.zzac.zzo;
            zzv();
            zzv();
        }
    }

    private final void zzan() {
        this.zze.zzb();
        if (Thread.currentThread() != this.zzs.getThread()) {
            String str = String.format(Locale.US, "Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://developer.android.com/guide/topics/media/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), this.zzs.getThread().getName());
            if (this.zzX) {
                throw new IllegalStateException(str);
            }
            zzff.zzg("ExoPlayerImpl", str, this.zzY ? null : new IllegalStateException());
            this.zzY = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzjj
    public final void zzA(zzms zzmsVar) {
        zzan();
        this.zzr.zzQ(zzmsVar);
    }

    @Override // com.google.android.gms.internal.ads.zzjj
    public final void zzB(zzut zzutVar) {
        zzan();
        List listSingletonList = Collections.singletonList(zzutVar);
        zzan();
        zzan();
        zzW(this.zzac);
        zzk();
        this.zzC++;
        if (!this.zzo.isEmpty()) {
            int size = this.zzo.size();
            for (int i11 = size - 1; i11 >= 0; i11--) {
                this.zzo.remove(i11);
            }
            this.zzag = this.zzag.zzh(0, size);
        }
        ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < listSingletonList.size(); i12++) {
            zzlv zzlvVar = new zzlv((zzut) listSingletonList.get(i12), this.zzp);
            arrayList.add(zzlvVar);
            this.zzo.add(i12, new zzkn(zzlvVar.zzb, zzlvVar.zza));
        }
        this.zzag = this.zzag.zzg(0, arrayList.size());
        zzmd zzmdVar = new zzmd(this.zzo, this.zzag);
        if (!zzmdVar.zzo() && zzmdVar.zzc() < 0) {
            throw new zzan(zzmdVar, -1, C.TIME_UNSET);
        }
        int iZzg = zzmdVar.zzg(false);
        zzly zzlyVarZzad = zzad(this.zzac, zzmdVar, zzac(zzmdVar, iZzg, C.TIME_UNSET));
        int i13 = zzlyVarZzad.zze;
        if (iZzg != -1 && i13 != 1) {
            i13 = 4;
            if (!zzmdVar.zzo() && iZzg < zzmdVar.zzc()) {
                i13 = 2;
            }
        }
        zzly zzlyVarZze = zzlyVarZzad.zze(i13);
        this.zzk.zzq(arrayList, iZzg, zzfy.zzq(C.TIME_UNSET), this.zzag);
        zzal(zzlyVarZze, 0, 1, (this.zzac.zzb.zza.equals(zzlyVarZze.zzb.zza) || this.zzac.zza.zzo()) ? false : true, 4, zzZ(zzlyVarZze), -1, false);
    }

    @Nullable
    public final zziz zzE() {
        zzan();
        return this.zzac.zzf;
    }

    public final /* synthetic */ void zzS(zzkx zzkxVar) {
        long j11;
        boolean z11;
        int i11 = this.zzC - zzkxVar.zzb;
        this.zzC = i11;
        boolean z12 = true;
        if (zzkxVar.zzc) {
            this.zzD = zzkxVar.zzd;
            this.zzE = true;
        }
        if (zzkxVar.zze) {
            this.zzF = zzkxVar.zzf;
        }
        if (i11 == 0) {
            zzcx zzcxVar = zzkxVar.zza.zza;
            if (!this.zzac.zza.zzo() && zzcxVar.zzo()) {
                this.zzad = -1;
                this.zzae = 0L;
            }
            if (!zzcxVar.zzo()) {
                List listZzw = ((zzmd) zzcxVar).zzw();
                zzek.zzf(listZzw.size() == this.zzo.size());
                for (int i12 = 0; i12 < listZzw.size(); i12++) {
                    ((zzkn) this.zzo.get(i12)).zzc((zzcx) listZzw.get(i12));
                }
            }
            if (this.zzE) {
                if (zzkxVar.zza.zzb.equals(this.zzac.zzb) && zzkxVar.zza.zzd == this.zzac.zzr) {
                    z12 = false;
                }
                if (!z12) {
                    j11 = -9223372036854775807L;
                } else if (zzcxVar.zzo() || zzkxVar.zza.zzb.zzb()) {
                    j11 = zzkxVar.zza.zzd;
                } else {
                    zzly zzlyVar = zzkxVar.zza;
                    zzur zzurVar = zzlyVar.zzb;
                    j11 = zzlyVar.zzd;
                    zzab(zzcxVar, zzurVar, j11);
                }
                z11 = z12;
            } else {
                j11 = -9223372036854775807L;
                z11 = false;
            }
            this.zzE = false;
            zzal(zzkxVar.zza, 1, this.zzF, z11, this.zzD, j11, -1, false);
        }
    }

    public final /* synthetic */ void zzT(final zzkx zzkxVar) {
        this.zzj.zzh(new Runnable() { // from class: com.google.android.gms.internal.ads.zzkd
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzS(zzkxVar);
            }
        });
    }

    public final /* synthetic */ void zzU(zzcl zzclVar) {
        zzclVar.zza(this.zzH);
    }

    @Override // com.google.android.gms.internal.ads.zzm
    public final void zza(int i11, long j11, int i12, boolean z11) {
        zzan();
        zzek.zzd(i11 >= 0);
        this.zzr.zzu();
        zzcx zzcxVar = this.zzac.zza;
        if (zzcxVar.zzo() || i11 < zzcxVar.zzc()) {
            this.zzC++;
            if (zzx()) {
                zzff.zzf("ExoPlayerImpl", "seekTo ignored because an ad is playing");
                zzkx zzkxVar = new zzkx(this.zzac);
                zzkxVar.zza(1);
                this.zzaf.zza.zzT(zzkxVar);
                return;
            }
            zzly zzlyVarZze = this.zzac;
            int i13 = zzlyVarZze.zze;
            if (i13 == 3 || (i13 == 4 && !zzcxVar.zzo())) {
                zzlyVarZze = this.zzac.zze(2);
            }
            int iZzd = zzd();
            zzly zzlyVarZzad = zzad(zzlyVarZze, zzcxVar, zzac(zzcxVar, i11, j11));
            this.zzk.zzl(zzcxVar, i11, zzfy.zzq(j11));
            zzal(zzlyVarZzad, 0, 1, true, 1, zzZ(zzlyVarZzad), iZzd, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final int zzb() {
        zzan();
        if (zzx()) {
            return this.zzac.zzb.zzb;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final int zzc() {
        zzan();
        if (zzx()) {
            return this.zzac.zzb.zzc;
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final int zzd() {
        zzan();
        int iZzW = zzW(this.zzac);
        if (iZzW == -1) {
            return 0;
        }
        return iZzW;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final int zze() {
        zzan();
        if (this.zzac.zza.zzo()) {
            return 0;
        }
        zzly zzlyVar = this.zzac;
        return zzlyVar.zza.zza(zzlyVar.zzb.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final int zzf() {
        zzan();
        return this.zzac.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final int zzg() {
        zzan();
        return this.zzac.zzm;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final int zzh() {
        zzan();
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final long zzi() {
        zzan();
        if (zzx()) {
            zzly zzlyVar = this.zzac;
            return zzlyVar.zzk.equals(zzlyVar.zzb) ? zzfy.zzt(this.zzac.zzp) : zzl();
        }
        zzan();
        if (this.zzac.zza.zzo()) {
            return this.zzae;
        }
        zzly zzlyVar2 = this.zzac;
        long j11 = 0;
        if (zzlyVar2.zzk.zzd != zzlyVar2.zzb.zzd) {
            return zzfy.zzt(zzlyVar2.zza.zze(zzd(), this.zza, 0L).zzo);
        }
        long j12 = zzlyVar2.zzp;
        if (this.zzac.zzk.zzb()) {
            zzly zzlyVar3 = this.zzac;
            zzlyVar3.zza.zzn(zzlyVar3.zzk.zza, this.zzn).zzi(this.zzac.zzk.zzb);
        } else {
            j11 = j12;
        }
        zzly zzlyVar4 = this.zzac;
        zzab(zzlyVar4.zza, zzlyVar4.zzk, j11);
        return zzfy.zzt(j11);
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final long zzj() {
        zzan();
        return zzY(this.zzac);
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final long zzk() {
        zzan();
        return zzfy.zzt(zzZ(this.zzac));
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final long zzl() {
        zzan();
        if (!zzx()) {
            zzcx zzcxVarZzn = zzn();
            return zzcxVarZzn.zzo() ? C.TIME_UNSET : zzfy.zzt(zzcxVarZzn.zze(zzd(), this.zza, 0L).zzo);
        }
        zzly zzlyVar = this.zzac;
        zzur zzurVar = zzlyVar.zzb;
        zzlyVar.zza.zzn(zzurVar.zza, this.zzn);
        return zzfy.zzt(this.zzn.zzh(zzurVar.zzb, zzurVar.zzc));
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final long zzm() {
        zzan();
        return zzfy.zzt(this.zzac.zzq);
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final zzcx zzn() {
        zzan();
        return this.zzac.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final zzdk zzo() {
        zzan();
        return this.zzac.zzi.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzp() {
        zzan();
        zzip zzipVar = this.zzy;
        boolean zZzv = zzv();
        int iZzb = zzipVar.zzb(zZzv, 2);
        zzak(zZzv, iZzb, zzX(zZzv, iZzb));
        zzly zzlyVar = this.zzac;
        if (zzlyVar.zze != 1) {
            return;
        }
        zzly zzlyVarZzd = zzlyVar.zzd(null);
        zzly zzlyVarZze = zzlyVarZzd.zze(true == zzlyVarZzd.zza.zzo() ? 4 : 2);
        this.zzC++;
        this.zzk.zzk();
        zzal(zzlyVarZze, 1, 1, false, 5, C.TIME_UNSET, -1, false);
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzq() {
        zzff.zze("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.2.1] [" + zzfy.zze + "] [" + zzbq.zza() + "]");
        zzan();
        this.zzy.zzd();
        if (!this.zzk.zzp()) {
            zzfc zzfcVar = this.zzl;
            zzfcVar.zzd(10, new zzez() { // from class: com.google.android.gms.internal.ads.zzkc
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj) {
                    ((zzcl) obj).zzj(zziz.zzd(new zzla(1), 1003));
                }
            });
            zzfcVar.zzc();
        }
        this.zzl.zze();
        this.zzj.zze(null);
        this.zzt.zzf(this.zzr);
        zzly zzlyVar = this.zzac;
        boolean z11 = zzlyVar.zzo;
        zzly zzlyVarZze = zzlyVar.zze(1);
        this.zzac = zzlyVarZze;
        zzly zzlyVarZza = zzlyVarZze.zza(zzlyVarZze.zzb);
        this.zzac = zzlyVarZza;
        zzlyVarZza.zzp = zzlyVarZza.zzr;
        this.zzac.zzq = 0L;
        this.zzr.zzP();
        this.zzi.zzj();
        Surface surface = this.zzN;
        if (surface != null) {
            surface.release();
            this.zzN = null;
        }
        this.zzW = zzee.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzr(boolean z11) {
        zzan();
        int iZzb = this.zzy.zzb(z11, zzf());
        zzak(z11, iZzb, zzX(z11, iZzb));
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzs(@Nullable Surface surface) {
        zzan();
        zzai(surface);
        int i11 = surface == null ? 0 : -1;
        zzaf(i11, i11);
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzt(float f11) {
        zzan();
        final float fMax = Math.max(0.0f, Math.min(f11, 1.0f));
        if (this.zzU == fMax) {
            return;
        }
        this.zzU = fMax;
        zzah();
        zzfc zzfcVar = this.zzl;
        zzfcVar.zzd(22, new zzez() { // from class: com.google.android.gms.internal.ads.zzjs
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
                int i11 = zzko.zzd;
                ((zzcl) obj).zzs(fMax);
            }
        });
        zzfcVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final void zzu() {
        zzan();
        this.zzy.zzb(zzv(), 1);
        zzaj(null);
        this.zzW = new zzee(zzgaa.zzl(), this.zzac.zzr);
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final boolean zzv() {
        zzan();
        return this.zzac.zzl;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final boolean zzw() {
        zzan();
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzco
    public final boolean zzx() {
        zzan();
        return this.zzac.zzb.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzjj
    public final int zzy() {
        zzan();
        int length = this.zzh.length;
        return 2;
    }

    @Override // com.google.android.gms.internal.ads.zzjj
    public final void zzz(zzms zzmsVar) {
        this.zzr.zzt(zzmsVar);
    }
}
