package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public enum zzbec implements zzgzw {
    UNSPECIFIED(0),
    CONNECTING(1),
    CONNECTED(2),
    DISCONNECTING(3),
    DISCONNECTED(4),
    SUSPENDED(5);

    private static final zzgzx zzg = new zzgzx() { // from class: com.google.android.gms.internal.ads.zzbea
    };
    private final int zzi;

    zzbec(int i11) {
        this.zzi = i11;
    }

    public static zzbec zzb(int i11) {
        if (i11 == 0) {
            return UNSPECIFIED;
        }
        if (i11 == 1) {
            return CONNECTING;
        }
        if (i11 == 2) {
            return CONNECTED;
        }
        if (i11 == 3) {
            return DISCONNECTING;
        }
        if (i11 == 4) {
            return DISCONNECTED;
        }
        if (i11 != 5) {
            return null;
        }
        return SUSPENDED;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return Integer.toString(this.zzi);
    }

    public final int zza() {
        return this.zzi;
    }
}
