package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaww extends zzaxx {
    private static final zzaxy zzi = new zzaxy();
    private final Context zzj;

    public zzaww(zzawj zzawjVar, String str, String str2, zzasg zzasgVar, int i11, int i12, Context context) {
        super(zzawjVar, "F0+pSvx9GtXcjR12oFzzp5apK08MRky74IYez805WxvZBZTjFs672zxMax8w5kp9", "69psxaRqrIVZzPpt4pN0wGmA/kc6O8gjOJlblyEzW1E=", zzasgVar, i11, 29);
        this.zzj = context;
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzn("E");
        AtomicReference atomicReferenceZza = zzi.zza(this.zzj.getPackageName());
        if (atomicReferenceZza.get() == null) {
            synchronized (atomicReferenceZza) {
                try {
                    if (atomicReferenceZza.get() == null) {
                        atomicReferenceZza.set((String) this.zzf.invoke(null, this.zzj));
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        String str = (String) atomicReferenceZza.get();
        synchronized (this.zze) {
            this.zze.zzn(zzatt.zza(str.getBytes(), true));
        }
    }
}
