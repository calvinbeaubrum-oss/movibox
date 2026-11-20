package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaxr extends zzaxx {
    private final zzawq zzi;
    private long zzj;

    public zzaxr(zzawj zzawjVar, String str, String str2, zzasg zzasgVar, int i11, int i12, zzawq zzawqVar) {
        super(zzawjVar, "2ZUgS25mCfmBpvNAAnoop42ZvK9H4E17vIqHMHWBgDSruAgpJ0/PRWhyN3sqcUbC", "ZqqofhkB4+yK9ARzF+IbcECpWBtuTXlqWFDkC/AVdcM=", zzasgVar, i11, 53);
        this.zzi = zzawqVar;
        if (zzawqVar != null) {
            this.zzj = zzawqVar.zza();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzi != null) {
            this.zze.zzP(((Long) this.zzf.invoke(null, Long.valueOf(this.zzj))).longValue());
        }
    }
}
