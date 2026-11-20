package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
final class zzca {
    public final int zza;

    public zzca(int i11, int i12) {
        this.zza = i12;
    }

    public final int zza() {
        int i11 = this.zza;
        if (i11 == 2) {
            return 10;
        }
        if (i11 == 5) {
            return 11;
        }
        if (i11 == 29) {
            return 12;
        }
        if (i11 == 42) {
            return 16;
        }
        if (i11 != 22) {
            return i11 != 23 ? 0 : 15;
        }
        return 1073741824;
    }
}
