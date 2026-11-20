package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class zzark extends zzhgo {
    private static final zzhgv zza = zzhgv.zzb(zzark.class);

    public zzark(zzhgp zzhgpVar, zzarj zzarjVar) throws IOException {
        zzf(zzhgpVar, zzhgpVar.zzc(), zzarjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhgo, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
    }

    @Override // com.google.android.gms.internal.ads.zzhgo
    public final String toString() {
        String string = this.zzd.toString();
        StringBuilder sb2 = new StringBuilder(String.valueOf(string).length() + 7);
        sb2.append("model(");
        sb2.append(string);
        sb2.append(")");
        return sb2.toString();
    }
}
