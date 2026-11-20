package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzip {
    private final AudioManager zza;
    private final zzin zzb;

    @Nullable
    private zzio zzc;
    private int zzd;
    private float zze = 1.0f;

    public zzip(Context context, Handler handler, zzio zzioVar) {
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        audioManager.getClass();
        this.zza = audioManager;
        this.zzc = zzioVar;
        this.zzb = new zzin(this, handler);
        this.zzd = 0;
    }

    public static /* bridge */ /* synthetic */ void zzc(zzip zzipVar, int i11) {
        if (i11 == -3 || i11 == -2) {
            if (i11 != -2) {
                zzipVar.zzg(3);
                return;
            } else {
                zzipVar.zzf(0);
                zzipVar.zzg(2);
                return;
            }
        }
        if (i11 == -1) {
            zzipVar.zzf(-1);
            zzipVar.zze();
        } else if (i11 == 1) {
            zzipVar.zzg(1);
            zzipVar.zzf(1);
        } else {
            zzff.zzf("AudioFocusManager", "Unknown focus change type: " + i11);
        }
    }

    private final void zze() {
        if (this.zzd == 0) {
            return;
        }
        if (zzfy.zza < 26) {
            this.zza.abandonAudioFocus(this.zzb);
        }
        zzg(0);
    }

    private final void zzf(int i11) {
        zzio zzioVar = this.zzc;
        if (zzioVar != null) {
            zzkk zzkkVar = (zzkk) zzioVar;
            boolean zZzv = zzkkVar.zza.zzv();
            zzkkVar.zza.zzak(zZzv, i11, zzko.zzX(zZzv, i11));
        }
    }

    private final void zzg(int i11) {
        if (this.zzd == i11) {
            return;
        }
        this.zzd = i11;
        float f11 = i11 == 3 ? 0.2f : 1.0f;
        if (this.zze != f11) {
            this.zze = f11;
            zzio zzioVar = this.zzc;
            if (zzioVar != null) {
                ((zzkk) zzioVar).zza.zzah();
            }
        }
    }

    public final float zza() {
        return this.zze;
    }

    public final int zzb(boolean z11, int i11) {
        zze();
        return z11 ? 1 : -1;
    }

    public final void zzd() {
        this.zzc = null;
        zze();
    }
}
