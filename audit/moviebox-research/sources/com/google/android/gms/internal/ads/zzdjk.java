package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdjk extends zzdgl {
    private boolean zzb;

    public zzdjk(Set set) {
        super(set);
    }

    public final void zza() {
        zzu(new zzdgk() { // from class: com.google.android.gms.internal.ads.zzdjh
            @Override // com.google.android.gms.internal.ads.zzdgk
            public final void zza(Object obj) {
                ((VideoController.VideoLifecycleCallbacks) obj).onVideoEnd();
            }
        });
    }

    public final void zzb() {
        zzu(new zzdgk() { // from class: com.google.android.gms.internal.ads.zzdjg
            @Override // com.google.android.gms.internal.ads.zzdgk
            public final void zza(Object obj) {
                ((VideoController.VideoLifecycleCallbacks) obj).onVideoPause();
            }
        });
    }

    public final synchronized void zzc() {
        try {
            if (!this.zzb) {
                zzu(zzdji.zza);
                this.zzb = true;
            }
            zzu(new zzdgk() { // from class: com.google.android.gms.internal.ads.zzdjj
                @Override // com.google.android.gms.internal.ads.zzdgk
                public final void zza(Object obj) {
                    ((VideoController.VideoLifecycleCallbacks) obj).onVideoPlay();
                }
            });
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void zzd() {
        zzu(zzdji.zza);
        this.zzb = true;
    }
}
