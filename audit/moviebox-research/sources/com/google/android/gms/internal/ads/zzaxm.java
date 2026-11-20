package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaxm extends zzaxx {
    public zzaxm(zzawj zzawjVar, String str, String str2, zzasg zzasgVar, int i11, int i12) {
        super(zzawjVar, "PyZj3I+LGZvAhJ9n3OQrlENydgM2JwW0T6dRxf3as8iTDiIpqvAE/3692CSblz+3", "8lD2ezwwsI93agi51tjtw1sdZVRU2vHPSc7HynOlFDE=", zzasgVar, i11, 73);
    }

    @Override // com.google.android.gms.internal.ads.zzaxx
    public final void zza() throws IllegalAccessException, InvocationTargetException {
        try {
            int i11 = 1;
            boolean zBooleanValue = ((Boolean) this.zzf.invoke(null, this.zzb.zzb())).booleanValue();
            zzasg zzasgVar = this.zze;
            if (true == zBooleanValue) {
                i11 = 2;
            }
            zzasgVar.zzaf(i11);
        } catch (InvocationTargetException unused) {
            this.zze.zzaf(3);
        }
    }
}
