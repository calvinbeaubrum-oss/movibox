package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaxi extends zzaxx {
    private final zzavm zzi;
    private final long zzj;
    private final long zzk;

    public zzaxi(zzawj zzawjVar, String str, String str2, zzasg zzasgVar, int i11, int i12, zzavm zzavmVar, long j11, long j12) {
        super(zzawjVar, "ChMYhePBDqkXl5DeRTg9cgSXXNPVEcIqgEVciYHEVlkZyx/HkVQXSnen8aw33G2s", "tJ+SvALjKnpAv9FF8u56pKKRS55/vzUDe+m9ct97Lx4=", zzasgVar, i11, 11);
        this.zzi = zzavmVar;
        this.zzj = j11;
        this.zzk = j12;
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        zzavm zzavmVar = this.zzi;
        if (zzavmVar != null) {
            zzavk zzavkVar = new zzavk((String) this.zzf.invoke(null, zzavmVar.zzb(), Long.valueOf(this.zzj), Long.valueOf(this.zzk)));
            synchronized (this.zze) {
                try {
                    this.zze.zzz(zzavkVar.zza.longValue());
                    if (zzavkVar.zzb.longValue() >= 0) {
                        this.zze.zzQ(zzavkVar.zzb.longValue());
                    }
                    if (zzavkVar.zzc.longValue() >= 0) {
                        this.zze.zzf(zzavkVar.zzc.longValue());
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }
}
