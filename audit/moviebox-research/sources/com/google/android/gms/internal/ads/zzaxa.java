package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaxa extends zzaxx {
    private final long zzi;

    public zzaxa(zzawj zzawjVar, String str, String str2, zzasg zzasgVar, long j11, int i11, int i12) {
        super(zzawjVar, "hIbo0WHjc5N2XBD7HI+Mwh9BXu/nIzOhdTaHZ1DPjeizuR48SZNCpBdtOxY4cHlb", "mLbfRIQxtPVbZphUgAhWqMeuqa25Ale/5rz8vv9YVkc=", zzasgVar, i11, 25);
        this.zzi = j11;
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        long jLongValue = ((Long) this.zzf.invoke(null, new Object[0])).longValue();
        synchronized (this.zze) {
            try {
                this.zze.zzt(jLongValue);
                long j11 = this.zzi;
                if (j11 != 0) {
                    this.zze.zzT(jLongValue - j11);
                    this.zze.zzU(this.zzi);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
