package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaxf extends zzaxx {
    private static volatile Long zzi;
    private static final Object zzj = new Object();

    public zzaxf(zzawj zzawjVar, String str, String str2, zzasg zzasgVar, int i11, int i12) {
        super(zzawjVar, "J3qHQsXE9gxUWY3EQze3pD9LpRQkp3i0z4IBb3xvxMfPfsFZNBOU+l2pHi8zC3DO", "W1peSRrFFzj+W6DyflucA6CQWTsphM4X4AkhjKjRy/o=", zzasgVar, i11, 22);
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (zzi == null) {
            synchronized (zzj) {
                try {
                    if (zzi == null) {
                        zzi = (Long) this.zzf.invoke(null, new Object[0]);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        synchronized (this.zze) {
            this.zze.zzy(zzi.longValue());
        }
    }
}
