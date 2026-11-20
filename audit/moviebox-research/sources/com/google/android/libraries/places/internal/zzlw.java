package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzlw extends zzlv {
    private final char zza;

    public zzlw(char c11) {
        this.zza = c11;
    }

    public final String toString() {
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        int i11 = this.zza;
        for (int i12 = 0; i12 < 4; i12++) {
            cArr[5 - i12] = "0123456789ABCDEF".charAt(i11 & 15);
            i11 >>= 4;
        }
        return "CharMatcher.is('" + String.copyValueOf(cArr) + "')";
    }

    @Override // com.google.android.libraries.places.internal.zzma
    public final boolean zza(char c11) {
        return c11 == this.zza;
    }
}
