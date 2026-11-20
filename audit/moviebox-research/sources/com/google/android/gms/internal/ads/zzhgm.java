package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzhgm extends zzhgk {
    private int zza;

    public zzhgm(String str) {
        super("mvhd");
    }

    public final int zzh() {
        if (!this.zzc) {
            zzg();
        }
        return this.zza;
    }

    public final long zzi(ByteBuffer byteBuffer) {
        this.zza = zzarl.zzc(byteBuffer.get());
        zzarl.zzd(byteBuffer);
        byteBuffer.get();
        return 4L;
    }
}
