package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaxk extends zzaxx {
    private static volatile String zzi;
    private static final Object zzj = new Object();

    public zzaxk(zzawj zzawjVar, String str, String str2, zzasg zzasgVar, int i11, int i12) {
        super(zzawjVar, "d4INySQwKXrFgcw/Yp0O6t4YGx7HF+F75DncE44LSIy22mr4UP50R657OPRB1jqZ", "AemuwIJaLmYE+nU5fadET3FINkdby4LnWDkawsC9pWk=", zzasgVar, i11, 1);
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zze.zzB("E");
        if (zzi == null) {
            synchronized (zzj) {
                try {
                    if (zzi == null) {
                        zzi = (String) this.zzf.invoke(null, new Object[0]);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        synchronized (this.zze) {
            this.zze.zzB(zzi);
        }
    }
}
