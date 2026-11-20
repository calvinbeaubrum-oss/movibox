package com.google.android.gms.internal.ads;

import com.google.android.gms.fido.fido2.api.common.DevicePublicKeyStringDef;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public enum zzfom {
    NATIVE("native"),
    JAVASCRIPT("javascript"),
    NONE(DevicePublicKeyStringDef.NONE);

    private final String zze;

    zzfom(String str) {
        this.zze = str;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.zze;
    }
}
