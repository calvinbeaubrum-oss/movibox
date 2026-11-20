package com.bytedance.sdk.component.ExN.zY.sc.sc;

import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class pFF implements com.bytedance.sdk.component.ExN.zY {
    private sc pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private long f26520sc;

    public pFF(File file, long j11, ExecutorService executorService) {
        this.f26520sc = j11;
        try {
            this.pFF = sc.sc(file, 20210302, 1, j11, executorService);
        } catch (IOException e11) {
            Log.w("LruCountDiskCache", e11.toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    @Override // com.bytedance.sdk.component.ExN.sc
    /* JADX INFO: renamed from: pFF, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public byte[] sc(String str) throws Throwable {
        ?? r11;
        ByteArrayOutputStream byteArrayOutputStream;
        sc scVar = this.pFF;
        ?? r12 = 0;
        if (scVar != null) {
            try {
                if (str != 0) {
                    try {
                        sc.zY zYVarSc = scVar.sc((String) str);
                        if (zYVarSc == null) {
                            com.bytedance.sdk.component.ExN.zY.zY.pFF.sc(null);
                            com.bytedance.sdk.component.ExN.zY.zY.pFF.sc(null);
                            return null;
                        }
                        str = zYVarSc.sc(0);
                        if (str != 0) {
                            try {
                                byteArrayOutputStream = new ByteArrayOutputStream();
                                try {
                                    byte[] bArr = new byte[1024];
                                    while (true) {
                                        int i11 = str.read(bArr);
                                        if (i11 == -1) {
                                            break;
                                        }
                                        byteArrayOutputStream.write(bArr, 0, i11);
                                    }
                                } catch (IOException e11) {
                                    e = e11;
                                    r11 = str;
                                }
                            } catch (IOException e12) {
                                e = e12;
                                byteArrayOutputStream = null;
                                r11 = str;
                            } catch (Throwable th2) {
                                th = th2;
                                r12 = str;
                                com.bytedance.sdk.component.ExN.zY.zY.pFF.sc(r12);
                                com.bytedance.sdk.component.ExN.zY.zY.pFF.sc(0);
                                throw th;
                            }
                        } else {
                            byteArrayOutputStream = null;
                        }
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        com.bytedance.sdk.component.ExN.zY.zY.pFF.sc(str);
                        com.bytedance.sdk.component.ExN.zY.zY.pFF.sc(byteArrayOutputStream);
                        return byteArray;
                    } catch (IOException e13) {
                        e = e13;
                        r11 = 0;
                        byteArrayOutputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        com.bytedance.sdk.component.ExN.zY.zY.pFF.sc(r12);
                        com.bytedance.sdk.component.ExN.zY.zY.pFF.sc(0);
                        throw th;
                    }
                    Log.w("LruCountDiskCache", e.toString());
                    com.bytedance.sdk.component.ExN.zY.zY.pFF.sc(r11);
                    com.bytedance.sdk.component.ExN.zY.zY.pFF.sc(byteArrayOutputStream);
                    return null;
                }
            } catch (Throwable th4) {
                th = th4;
            }
        }
        return null;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.bytedance.sdk.component.ExN.zY
    public InputStream sc(String str) {
        sc scVar = this.pFF;
        if (scVar == null) {
            return null;
        }
        try {
            sc.zY zYVarSc = scVar.sc(str);
            if (zYVarSc != null) {
                return zYVarSc.sc(0);
            }
        } catch (IOException e11) {
            Log.w("LruCountDiskCache", e11.getMessage());
        }
        return null;
    }

    @Override // com.bytedance.sdk.component.ExN.sc
    public boolean sc(String str, byte[] bArr) throws Throwable {
        sc scVar = this.pFF;
        if (scVar == null || bArr == null || str == null) {
            return false;
        }
        Closeable closeable = null;
        sc.C0242sc c0242sc = null;
        try {
            try {
                sc.C0242sc c0242scPFF = scVar.pFF(str);
                try {
                    if (c0242scPFF == null) {
                        Log.w("LruCountDiskCache", "save " + str + " failed for edit null");
                        com.bytedance.sdk.component.ExN.zY.zY.pFF.sc(null);
                        return false;
                    }
                    OutputStream outputStreamSc = c0242scPFF.sc(0);
                    if (outputStreamSc != sc.zY) {
                        outputStreamSc.write(bArr);
                        c0242scPFF.sc();
                        this.pFF.sc();
                        com.bytedance.sdk.component.ExN.zY.zY.pFF.sc(outputStreamSc);
                        return true;
                    }
                    Log.w("LruCountDiskCache", "save " + str + " failed for null OutputStream");
                    com.bytedance.sdk.component.ExN.zY.zY.pFF.sc(outputStreamSc);
                    return false;
                } catch (IOException e11) {
                    e = e11;
                    c0242sc = c0242scPFF;
                    try {
                        Log.w("LruCountDiskCache", e.toString());
                        if (c0242sc != null) {
                            try {
                                c0242sc.pFF();
                            } catch (IOException unused) {
                            }
                        }
                        com.bytedance.sdk.component.ExN.zY.zY.pFF.sc(0);
                        return false;
                    } catch (Throwable th2) {
                        th = th2;
                        closeable = closeable;
                        com.bytedance.sdk.component.ExN.zY.zY.pFF.sc(closeable);
                        throw th;
                    }
                }
            } catch (IOException e12) {
                e = e12;
            }
        } catch (Throwable th3) {
            th = th3;
            com.bytedance.sdk.component.ExN.zY.zY.pFF.sc(closeable);
            throw th;
        }
    }

    @Override // com.bytedance.sdk.component.ExN.sc
    /* JADX INFO: renamed from: zY, reason: merged with bridge method [inline-methods] */
    public boolean pFF(String str) {
        try {
            try {
                sc.zY zYVarSc = this.pFF.sc(str);
                boolean z11 = zYVarSc != null;
                com.bytedance.sdk.component.ExN.zY.zY.pFF.sc(zYVarSc);
                return z11;
            } catch (IOException e11) {
                Log.w("LruCountDiskCache", e11.getMessage());
                com.bytedance.sdk.component.ExN.zY.zY.pFF.sc(null);
                return false;
            }
        } catch (Throwable th2) {
            com.bytedance.sdk.component.ExN.zY.zY.pFF.sc(null);
            throw th2;
        }
    }
}
