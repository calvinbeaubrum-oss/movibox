package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.net.Uri;
import android.view.Surface;
import android.view.TextureView;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzchd extends zzcfr implements TextureView.SurfaceTextureListener, zzcgb {
    private final zzcgl zzc;
    private final zzcgm zzd;
    private final zzcgk zze;
    private zzcfq zzf;
    private Surface zzg;
    private zzcgc zzh;
    private String zzi;
    private String[] zzj;
    private boolean zzk;
    private int zzl;
    private zzcgj zzm;
    private final boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private int zzq;
    private int zzr;
    private float zzs;

    public zzchd(Context context, zzcgm zzcgmVar, zzcgl zzcglVar, boolean z11, boolean z12, zzcgk zzcgkVar) {
        super(context);
        this.zzl = 1;
        this.zzc = zzcglVar;
        this.zzd = zzcgmVar;
        this.zzn = z11;
        this.zze = zzcgkVar;
        setSurfaceTextureListener(this);
        zzcgmVar.zza(this);
    }

    private static String zzT(String str, Exception exc) {
        return str + "/" + exc.getClass().getCanonicalName() + ":" + exc.getMessage();
    }

    private final void zzU() {
        zzcgc zzcgcVar = this.zzh;
        if (zzcgcVar != null) {
            zzcgcVar.zzQ(true);
        }
    }

    private final void zzV() {
        if (this.zzo) {
            return;
        }
        this.zzo = true;
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzchc
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzI();
            }
        });
        zzn();
        this.zzd.zzb();
        if (this.zzp) {
            zzp();
        }
    }

    private final void zzW(boolean z11, @Nullable Integer num) {
        zzcgc zzcgcVar = this.zzh;
        if (zzcgcVar != null && !z11) {
            zzcgcVar.zzP(num);
            return;
        }
        if (this.zzi == null || this.zzg == null) {
            return;
        }
        if (z11) {
            if (!zzad()) {
                zzcec.zzj("No valid ExoPlayerAdapter exists when switch source.");
                return;
            } else {
                zzcgcVar.zzU();
                zzY();
            }
        }
        if (this.zzi.startsWith("cache:")) {
            zzchw zzchwVarZzp = this.zzc.zzp(this.zzi);
            if (zzchwVarZzp instanceof zzcif) {
                zzcgc zzcgcVarZza = ((zzcif) zzchwVarZzp).zza();
                this.zzh = zzcgcVarZza;
                zzcgcVarZza.zzP(num);
                if (!this.zzh.zzV()) {
                    zzcec.zzj("Precached video player has been released.");
                    return;
                }
            } else {
                if (!(zzchwVarZzp instanceof zzcic)) {
                    zzcec.zzj("Stream cache miss: ".concat(String.valueOf(this.zzi)));
                    return;
                }
                zzcic zzcicVar = (zzcic) zzchwVarZzp;
                String strZzF = zzF();
                ByteBuffer byteBufferZzk = zzcicVar.zzk();
                boolean zZzl = zzcicVar.zzl();
                String strZzi = zzcicVar.zzi();
                if (strZzi == null) {
                    zzcec.zzj("Stream cache URL is null.");
                    return;
                } else {
                    zzcgc zzcgcVarZzE = zzE(num);
                    this.zzh = zzcgcVarZzE;
                    zzcgcVarZzE.zzG(new Uri[]{Uri.parse(strZzi)}, strZzF, byteBufferZzk, zZzl);
                }
            }
        } else {
            this.zzh = zzE(num);
            String strZzF2 = zzF();
            Uri[] uriArr = new Uri[this.zzj.length];
            int i11 = 0;
            while (true) {
                String[] strArr = this.zzj;
                if (i11 >= strArr.length) {
                    break;
                }
                uriArr[i11] = Uri.parse(strArr[i11]);
                i11++;
            }
            this.zzh.zzF(uriArr, strZzF2);
        }
        this.zzh.zzL(this);
        zzZ(this.zzg, false);
        if (this.zzh.zzV()) {
            int iZzt = this.zzh.zzt();
            this.zzl = iZzt;
            if (iZzt == 3) {
                zzV();
            }
        }
    }

    private final void zzX() {
        zzcgc zzcgcVar = this.zzh;
        if (zzcgcVar != null) {
            zzcgcVar.zzQ(false);
        }
    }

    private final void zzY() {
        if (this.zzh != null) {
            zzZ(null, true);
            zzcgc zzcgcVar = this.zzh;
            if (zzcgcVar != null) {
                zzcgcVar.zzL(null);
                this.zzh.zzH();
                this.zzh = null;
            }
            this.zzl = 1;
            this.zzk = false;
            this.zzo = false;
            this.zzp = false;
        }
    }

    private final void zzZ(Surface surface, boolean z11) {
        zzcgc zzcgcVar = this.zzh;
        if (zzcgcVar == null) {
            zzcec.zzj("Trying to set surface before player is initialized.");
            return;
        }
        try {
            zzcgcVar.zzS(surface, z11);
        } catch (IOException e11) {
            zzcec.zzk("", e11);
        }
    }

    private final void zzaa() {
        zzab(this.zzq, this.zzr);
    }

    private final void zzab(int i11, int i12) {
        float f11 = i12 > 0 ? i11 / i12 : 1.0f;
        if (this.zzs != f11) {
            this.zzs = f11;
            requestLayout();
        }
    }

    private final boolean zzac() {
        return zzad() && this.zzl != 1;
    }

    private final boolean zzad() {
        zzcgc zzcgcVar = this.zzh;
        return (zzcgcVar == null || !zzcgcVar.zzV() || this.zzk) ? false : true;
    }

    @Override // android.view.View
    public final void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        float f11 = this.zzs;
        if (f11 != 0.0f && this.zzm == null) {
            float f12 = measuredWidth;
            float f13 = f12 / measuredHeight;
            if (f11 > f13) {
                measuredHeight = (int) (f12 / f11);
            }
            if (f11 < f13) {
                measuredWidth = (int) (measuredHeight * f11);
            }
        }
        setMeasuredDimension(measuredWidth, measuredHeight);
        zzcgj zzcgjVar = this.zzm;
        if (zzcgjVar != null) {
            zzcgjVar.zzc(measuredWidth, measuredHeight);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i11, int i12) {
        if (this.zzn) {
            zzcgj zzcgjVar = new zzcgj(getContext());
            this.zzm = zzcgjVar;
            zzcgjVar.zzd(surfaceTexture, i11, i12);
            this.zzm.start();
            SurfaceTexture surfaceTextureZzb = this.zzm.zzb();
            if (surfaceTextureZzb != null) {
                surfaceTexture = surfaceTextureZzb;
            } else {
                this.zzm.zze();
                this.zzm = null;
            }
        }
        Surface surface = new Surface(surfaceTexture);
        this.zzg = surface;
        if (this.zzh == null) {
            zzW(false, null);
        } else {
            zzZ(surface, true);
            if (!this.zze.zza) {
                zzU();
            }
        }
        if (this.zzq == 0 || this.zzr == 0) {
            zzab(i11, i12);
        } else {
            zzaa();
        }
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgz
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzM();
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzo();
        zzcgj zzcgjVar = this.zzm;
        if (zzcgjVar != null) {
            zzcgjVar.zze();
            this.zzm = null;
        }
        if (this.zzh != null) {
            zzX();
            Surface surface = this.zzg;
            if (surface != null) {
                surface.release();
            }
            this.zzg = null;
            zzZ(null, true);
        }
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgv
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzN();
            }
        });
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, final int i11, final int i12) {
        zzcgj zzcgjVar = this.zzm;
        if (zzcgjVar != null) {
            zzcgjVar.zzc(i11, i12);
        }
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgu
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzO(i11, i12);
            }
        });
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.zzd.zzf(this);
        this.zza.zza(surfaceTexture, this.zzf);
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(final int i11) {
        com.google.android.gms.ads.internal.util.zze.zza("AdExoPlayerView3 window visibility changed to " + i11);
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgt
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzQ(i11);
            }
        });
        super.onWindowVisibilityChanged(i11);
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzA(int i11) {
        zzcgc zzcgcVar = this.zzh;
        if (zzcgcVar != null) {
            zzcgcVar.zzN(i11);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzB(int i11) {
        zzcgc zzcgcVar = this.zzh;
        if (zzcgcVar != null) {
            zzcgcVar.zzR(i11);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzC(@Nullable String str, @Nullable String[] strArr, @Nullable Integer num) {
        if (str == null) {
            return;
        }
        if (strArr == null) {
            this.zzj = new String[]{str};
        } else {
            this.zzj = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
        String str2 = this.zzi;
        boolean z11 = false;
        if (this.zze.zzl && str2 != null && !str.equals(str2) && this.zzl == 4) {
            z11 = true;
        }
        this.zzi = str;
        zzW(z11, num);
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzD(int i11, int i12) {
        this.zzq = i11;
        this.zzr = i12;
        zzaa();
    }

    public final zzcgc zzE(@Nullable Integer num) {
        zzcgk zzcgkVar = this.zze;
        zzcgl zzcglVar = this.zzc;
        zzcix zzcixVar = new zzcix(zzcglVar.getContext(), zzcgkVar, zzcglVar, num);
        zzcec.zzi("ExoPlayerAdapter initialized.");
        return zzcixVar;
    }

    public final String zzF() {
        zzcgl zzcglVar = this.zzc;
        return com.google.android.gms.ads.internal.zzt.zzp().zzc(zzcglVar.getContext(), zzcglVar.zzn().zza);
    }

    public final /* synthetic */ void zzG(String str) {
        zzcfq zzcfqVar = this.zzf;
        if (zzcfqVar != null) {
            zzcfqVar.zzb("ExoPlayerAdapter error", str);
        }
    }

    public final /* synthetic */ void zzH() {
        zzcfq zzcfqVar = this.zzf;
        if (zzcfqVar != null) {
            zzcfqVar.zza();
        }
    }

    public final /* synthetic */ void zzI() {
        zzcfq zzcfqVar = this.zzf;
        if (zzcfqVar != null) {
            zzcfqVar.zzf();
        }
    }

    public final /* synthetic */ void zzJ(boolean z11, long j11) {
        this.zzc.zzv(z11, j11);
    }

    public final /* synthetic */ void zzK(String str) {
        zzcfq zzcfqVar = this.zzf;
        if (zzcfqVar != null) {
            zzcfqVar.zzc("ExoPlayerAdapter exception", str);
        }
    }

    public final /* synthetic */ void zzL() {
        zzcfq zzcfqVar = this.zzf;
        if (zzcfqVar != null) {
            zzcfqVar.zzg();
        }
    }

    public final /* synthetic */ void zzM() {
        zzcfq zzcfqVar = this.zzf;
        if (zzcfqVar != null) {
            zzcfqVar.zzh();
        }
    }

    public final /* synthetic */ void zzN() {
        zzcfq zzcfqVar = this.zzf;
        if (zzcfqVar != null) {
            zzcfqVar.zzi();
        }
    }

    public final /* synthetic */ void zzO(int i11, int i12) {
        zzcfq zzcfqVar = this.zzf;
        if (zzcfqVar != null) {
            zzcfqVar.zzj(i11, i12);
        }
    }

    public final /* synthetic */ void zzP() {
        float fZza = this.zzb.zza();
        zzcgc zzcgcVar = this.zzh;
        if (zzcgcVar == null) {
            zzcec.zzj("Trying to set volume before player is initialized.");
            return;
        }
        try {
            zzcgcVar.zzT(fZza, false);
        } catch (IOException e11) {
            zzcec.zzk("", e11);
        }
    }

    public final /* synthetic */ void zzQ(int i11) {
        zzcfq zzcfqVar = this.zzf;
        if (zzcfqVar != null) {
            zzcfqVar.onWindowVisibilityChanged(i11);
        }
    }

    public final /* synthetic */ void zzR() {
        zzcfq zzcfqVar = this.zzf;
        if (zzcfqVar != null) {
            zzcfqVar.zzd();
        }
    }

    public final /* synthetic */ void zzS() {
        zzcfq zzcfqVar = this.zzf;
        if (zzcfqVar != null) {
            zzcfqVar.zze();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final int zza() {
        if (zzac()) {
            return (int) this.zzh.zzy();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final int zzb() {
        zzcgc zzcgcVar = this.zzh;
        if (zzcgcVar != null) {
            return zzcgcVar.zzr();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final int zzc() {
        if (zzac()) {
            return (int) this.zzh.zzz();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final int zzd() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final int zze() {
        return this.zzq;
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final long zzf() {
        zzcgc zzcgcVar = this.zzh;
        if (zzcgcVar != null) {
            return zzcgcVar.zzx();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final long zzg() {
        zzcgc zzcgcVar = this.zzh;
        if (zzcgcVar != null) {
            return zzcgcVar.zzA();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final long zzh() {
        zzcgc zzcgcVar = this.zzh;
        if (zzcgcVar != null) {
            return zzcgcVar.zzB();
        }
        return -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzi(final boolean z11, final long j11) {
        if (this.zzc != null) {
            zzcep.zze.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgw
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzJ(z11, j11);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final String zzj() {
        return "ExoPlayer/2".concat(true != this.zzn ? "" : " spherical");
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzk(String str, Exception exc) {
        final String strZzT = zzT(str, exc);
        zzcec.zzj("ExoPlayerAdapter error: ".concat(strZzT));
        this.zzk = true;
        if (this.zze.zza) {
            zzX();
        }
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcha
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzG(strZzT);
            }
        });
        com.google.android.gms.ads.internal.zzt.zzo().zzv(exc, "AdExoPlayerView.onError");
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzl(String str, Exception exc) {
        final String strZzT = zzT("onLoadException", exc);
        zzcec.zzj("ExoPlayerAdapter exception: ".concat(strZzT));
        com.google.android.gms.ads.internal.zzt.zzo().zzv(exc, "AdExoPlayerView.onException");
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgx
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzK(strZzT);
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzm(int i11) {
        if (this.zzl != i11) {
            this.zzl = i11;
            if (i11 == 3) {
                zzV();
                return;
            }
            if (i11 != 4) {
                return;
            }
            if (this.zze.zza) {
                zzX();
            }
            this.zzd.zze();
            this.zzb.zzc();
            com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzchb
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzH();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfr, com.google.android.gms.internal.ads.zzcgo
    public final void zzn() {
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgs
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzP();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzo() {
        if (zzac()) {
            if (this.zze.zza) {
                zzX();
            }
            this.zzh.zzO(false);
            this.zzd.zze();
            this.zzb.zzc();
            com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgy
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzR();
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzp() {
        if (!zzac()) {
            this.zzp = true;
            return;
        }
        if (this.zze.zza) {
            zzU();
        }
        this.zzh.zzO(true);
        this.zzd.zzc();
        this.zzb.zzb();
        this.zza.zzb();
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgr
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzS();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzq(int i11) {
        if (zzac()) {
            this.zzh.zzI(i11);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzr(zzcfq zzcfqVar) {
        this.zzf = zzcfqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzs(@Nullable String str) {
        if (str != null) {
            zzC(str, null, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzt() {
        if (zzad()) {
            this.zzh.zzU();
            zzY();
        }
        this.zzd.zze();
        this.zzb.zzc();
        this.zzd.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzu(float f11, float f12) {
        zzcgj zzcgjVar = this.zzm;
        if (zzcgjVar != null) {
            zzcgjVar.zzf(f11, f12);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgb
    public final void zzv() {
        com.google.android.gms.ads.internal.util.zzt.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcgq
            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzL();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    @Nullable
    public final Integer zzw() {
        zzcgc zzcgcVar = this.zzh;
        if (zzcgcVar != null) {
            return zzcgcVar.zzC();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzx(int i11) {
        zzcgc zzcgcVar = this.zzh;
        if (zzcgcVar != null) {
            zzcgcVar.zzJ(i11);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzy(int i11) {
        zzcgc zzcgcVar = this.zzh;
        if (zzcgcVar != null) {
            zzcgcVar.zzK(i11);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcfr
    public final void zzz(int i11) {
        zzcgc zzcgcVar = this.zzh;
        if (zzcgcVar != null) {
            zzcgcVar.zzM(i11);
        }
    }
}
