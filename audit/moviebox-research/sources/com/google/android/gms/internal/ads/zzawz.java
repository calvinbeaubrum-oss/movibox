package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzawz extends zzaxx {
    private static volatile Long zzi;
    private static final Object zzj = new Object();

    public zzawz(zzawj zzawjVar, String str, String str2, zzasg zzasgVar, int i11, int i12) {
        super(zzawjVar, "L1KomYFd7sBH8JLOTR3glPup1jq/oqWyQJNU/5dJtxixjKQHD3ZBhAic9dH4TZgA", "m4uJd6hJYeAUgFAUB1OT370Awen8YINd4hKC7XM/6ec=", zzasgVar, i11, 44);
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
            this.zze.zzo(zzi.longValue());
        }
    }
}
