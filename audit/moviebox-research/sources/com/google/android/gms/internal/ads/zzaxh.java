package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaxh extends zzaxx {
    private final zzawb zzi;

    public zzaxh(zzawj zzawjVar, String str, String str2, zzasg zzasgVar, int i11, int i12, zzawb zzawbVar) {
        super(zzawjVar, "ouo6/s5NPxZlxezvpiuAYZ73R/AsqpZljIGTfLgJpzrsB+84nXU0ZzhmetmfkBrN", "5BsC37pqFx3Fp5Qtv0y+RSU8LVttAMXjX8aFccLrzxg=", zzasgVar, i11, 94);
        this.zzi = zzawbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        int iIntValue = ((Integer) this.zzf.invoke(null, this.zzi.zza())).intValue();
        synchronized (this.zze) {
            this.zze.zzae(zzasu.zza(iIntValue));
        }
    }
}
