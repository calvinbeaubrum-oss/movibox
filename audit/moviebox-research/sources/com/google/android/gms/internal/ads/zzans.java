package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzans extends zzacg {
    public zzans(zzfw zzfwVar, long j11, long j12) {
        super(new zzacb(), new zzanr(zzfwVar, null), j11, 0L, j11 + 1, 0L, j12, 188L, 1000);
    }

    public static /* bridge */ /* synthetic */ int zzh(byte[] bArr, int i11) {
        return (bArr[i11 + 3] & 255) | ((bArr[i11] & 255) << 24) | ((bArr[i11 + 1] & 255) << 16) | ((bArr[i11 + 2] & 255) << 8);
    }
}
