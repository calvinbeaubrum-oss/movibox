package com.bytedance.sdk.component.ExN.zY.sc;

import android.content.Context;
import android.os.Environment;
import android.os.StatFs;
import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class sc implements com.bytedance.sdk.component.ExN.pFF, Cloneable {
    private static volatile com.bytedance.sdk.component.ExN.pFF TRI;
    private File ExN;
    private boolean We;
    private int pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private long f26518sc;
    private boolean zY;

    public sc(int i11, long j11, File file) {
        this(i11, j11, i11 != 0, j11 != 0, file);
    }

    public sc(int i11, long j11, boolean z11, boolean z12, File file) {
        this.f26518sc = j11;
        this.pFF = i11;
        this.zY = z11;
        this.We = z12;
        this.ExN = file;
    }

    private static long Qj() {
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        return ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    public static com.bytedance.sdk.component.ExN.pFF qr() {
        return TRI;
    }

    public static com.bytedance.sdk.component.ExN.pFF sc(File file) {
        int iMin;
        long jMin;
        file.mkdirs();
        if (TRI == null) {
            iMin = Math.min(Long.valueOf(Runtime.getRuntime().maxMemory()).intValue() / 16, 31457280);
            jMin = Math.min(Qj() / 16, 41943040L);
        } else {
            iMin = Math.min(TRI.pFF() / 2, 31457280);
            jMin = Math.min(TRI.sc() / 2, 41943040L);
        }
        return new sc(Math.max(iMin, 26214400), Math.max(jMin, 20971520L), file);
    }

    public static void sc(Context context, com.bytedance.sdk.component.ExN.pFF pff) {
        if (pff != null) {
            TRI = pff;
        } else {
            TRI = sc(new File(context.getCacheDir(), "image"));
        }
    }

    @Override // com.bytedance.sdk.component.ExN.pFF
    public File ExN() {
        return this.ExN;
    }

    @Override // com.bytedance.sdk.component.ExN.pFF
    public boolean TRI() {
        return true;
    }

    @Override // com.bytedance.sdk.component.ExN.pFF
    public boolean We() {
        return this.We;
    }

    @Override // com.bytedance.sdk.component.ExN.pFF
    public int pFF() {
        return this.pFF;
    }

    @Override // com.bytedance.sdk.component.ExN.pFF
    public long sc() {
        return this.f26518sc;
    }

    @Override // com.bytedance.sdk.component.ExN.pFF
    public boolean zY() {
        return this.zY;
    }
}
