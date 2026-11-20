package com.google.android.gms.internal.ads;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import android.view.TextureView;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzkk implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener, zzabk, zzpu, zzwv, zztr, zzio, zzik {
    public static final /* synthetic */ int zzb = 0;
    final /* synthetic */ zzko zza;

    public /* synthetic */ zzkk(zzko zzkoVar, zzkj zzkjVar) {
        this.zza = zzkoVar;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i11, int i12) {
        zzko.zzP(this.zza, surfaceTexture);
        this.zza.zzaf(i11, i12);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.zza.zzai(null);
        this.zza.zzaf(0, 0);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i11, int i12) {
        this.zza.zzaf(i11, i12);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i11, int i12, int i13) {
        this.zza.zzaf(i12, i13);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.zza.zzaf(0, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzpu
    public final void zza(Exception exc) {
        this.zza.zzr.zzv(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzpu
    public final void zzb(String str, long j11, long j12) {
        this.zza.zzr.zzw(str, j11, j12);
    }

    @Override // com.google.android.gms.internal.ads.zzpu
    public final void zzc(String str) {
        this.zza.zzr.zzx(str);
    }

    @Override // com.google.android.gms.internal.ads.zzpu
    public final void zzd(zzir zzirVar) {
        this.zza.zzr.zzy(zzirVar);
        this.zza.zzL = null;
        this.zza.zzR = null;
    }

    @Override // com.google.android.gms.internal.ads.zzpu
    public final void zze(zzir zzirVar) {
        this.zza.zzR = zzirVar;
        this.zza.zzr.zzz(zzirVar);
    }

    @Override // com.google.android.gms.internal.ads.zzpu
    public final void zzf(zzam zzamVar, @Nullable zzis zzisVar) {
        this.zza.zzL = zzamVar;
        this.zza.zzr.zzA(zzamVar, zzisVar);
    }

    @Override // com.google.android.gms.internal.ads.zzpu
    public final void zzg(long j11) {
        this.zza.zzr.zzB(j11);
    }

    @Override // com.google.android.gms.internal.ads.zzpu
    public final void zzh(Exception exc) {
        this.zza.zzr.zzC(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzpu
    public final void zzi(zzpv zzpvVar) {
        this.zza.zzr.zzD(zzpvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzpu
    public final void zzj(zzpv zzpvVar) {
        this.zza.zzr.zzE(zzpvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzpu
    public final void zzk(int i11, long j11, long j12) {
        this.zza.zzr.zzF(i11, j11, j12);
    }

    @Override // com.google.android.gms.internal.ads.zzabk
    public final void zzl(int i11, long j11) {
        this.zza.zzr.zzG(i11, j11);
    }

    @Override // com.google.android.gms.internal.ads.zzabk
    public final void zzm(Object obj, long j11) {
        this.zza.zzr.zzH(obj, j11);
        zzko zzkoVar = this.zza;
        if (zzkoVar.zzM == obj) {
            zzfc zzfcVar = zzkoVar.zzl;
            zzfcVar.zzd(26, new zzez() { // from class: com.google.android.gms.internal.ads.zzki
                @Override // com.google.android.gms.internal.ads.zzez
                public final void zza(Object obj2) {
                }
            });
            zzfcVar.zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzpu
    public final void zzn(final boolean z11) {
        zzko zzkoVar = this.zza;
        if (zzkoVar.zzV == z11) {
            return;
        }
        zzkoVar.zzV = z11;
        zzfc zzfcVar = this.zza.zzl;
        zzfcVar.zzd(23, new zzez() { // from class: com.google.android.gms.internal.ads.zzkg
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
                ((zzcl) obj).zzn(z11);
            }
        });
        zzfcVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzabk
    public final void zzo(Exception exc) {
        this.zza.zzr.zzI(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzabk
    public final void zzp(String str, long j11, long j12) {
        this.zza.zzr.zzJ(str, j11, j12);
    }

    @Override // com.google.android.gms.internal.ads.zzabk
    public final void zzq(String str) {
        this.zza.zzr.zzK(str);
    }

    @Override // com.google.android.gms.internal.ads.zzabk
    public final void zzr(zzir zzirVar) {
        this.zza.zzr.zzL(zzirVar);
        this.zza.zzK = null;
        this.zza.zzQ = null;
    }

    @Override // com.google.android.gms.internal.ads.zzabk
    public final void zzs(zzir zzirVar) {
        this.zza.zzQ = zzirVar;
        this.zza.zzr.zzM(zzirVar);
    }

    @Override // com.google.android.gms.internal.ads.zzabk
    public final void zzt(long j11, int i11) {
        this.zza.zzr.zzN(j11, i11);
    }

    @Override // com.google.android.gms.internal.ads.zzabk
    public final void zzu(zzam zzamVar, @Nullable zzis zzisVar) {
        this.zza.zzK = zzamVar;
        this.zza.zzr.zzO(zzamVar, zzisVar);
    }

    @Override // com.google.android.gms.internal.ads.zzabk
    public final void zzv(final zzdp zzdpVar) {
        this.zza.zzaa = zzdpVar;
        zzfc zzfcVar = this.zza.zzl;
        zzfcVar.zzd(25, new zzez() { // from class: com.google.android.gms.internal.ads.zzkh
            @Override // com.google.android.gms.internal.ads.zzez
            public final void zza(Object obj) {
                ((zzcl) obj).zzr(zzdpVar);
            }
        });
        zzfcVar.zzc();
    }
}
