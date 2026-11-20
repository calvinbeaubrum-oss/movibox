package com.google.android.gms.internal.ads;

import java.io.File;
import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzauz implements zzfsm {
    final /* synthetic */ zzfqm zza;

    public zzauz(zzavb zzavbVar, zzfqm zzfqmVar) {
        this.zza = zzfqmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfsm
    public final boolean zza(File file) {
        try {
            return this.zza.zza(file);
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }
}
