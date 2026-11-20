package com.google.android.gms.internal.ads;

import android.media.AudioManager;
import android.os.Handler;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzin implements AudioManager.OnAudioFocusChangeListener {
    final /* synthetic */ zzip zza;
    private final Handler zzb;

    public zzin(zzip zzipVar, Handler handler) {
        this.zza = zzipVar;
        this.zzb = handler;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(final int i11) {
        this.zzb.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzim
            @Override // java.lang.Runnable
            public final void run() {
                zzip.zzc(this.zza.zza, i11);
            }
        });
    }
}
