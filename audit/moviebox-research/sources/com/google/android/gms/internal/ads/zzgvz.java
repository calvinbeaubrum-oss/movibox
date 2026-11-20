package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public enum zzgvz implements zzgzw {
    UNKNOWN_PREFIX(0),
    TINK(1),
    LEGACY(2),
    RAW(3),
    CRUNCHY(4),
    UNRECOGNIZED(-1);

    private static final zzgzx zzg = new zzgzx() { // from class: com.google.android.gms.internal.ads.zzgvy
    };
    private final int zzi;

    zzgvz(int i11) {
        this.zzi = i11;
    }

    public static zzgvz zzb(int i11) {
        if (i11 == 0) {
            return UNKNOWN_PREFIX;
        }
        if (i11 == 1) {
            return TINK;
        }
        if (i11 == 2) {
            return LEGACY;
        }
        if (i11 == 3) {
            return RAW;
        }
        if (i11 != 4) {
            return null;
        }
        return CRUNCHY;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(zza());
    }

    public final int zza() {
        if (this != UNRECOGNIZED) {
            return this.zzi;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }
}
