package com.bytedance.adsdk.pFF.We;

import android.content.Context;
import android.util.Pair;
import com.bytedance.adsdk.pFF.Tf;
import com.bytedance.component.sdk.annotation.RestrictTo;
import com.bytedance.component.sdk.annotation.WorkerThread;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipInputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class Qj {
    private final TRI pFF;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private final qr f26163sc;

    public Qj(qr qrVar, TRI tri) {
        this.f26163sc = qrVar;
        this.pFF = tri;
    }

    @WorkerThread
    private com.bytedance.adsdk.pFF.qr pFF(Context context, String str, String str2) {
        qr qrVar;
        Pair<zY, InputStream> pairSc;
        if (str2 == null || (qrVar = this.f26163sc) == null || (pairSc = qrVar.sc(str)) == null) {
            return null;
        }
        zY zYVar = (zY) pairSc.first;
        InputStream inputStream = (InputStream) pairSc.second;
        Tf<com.bytedance.adsdk.pFF.qr> tfSc = zYVar == zY.ZIP ? com.bytedance.adsdk.pFF.Qj.sc(context, new ZipInputStream(inputStream), str2) : com.bytedance.adsdk.pFF.Qj.pFF(inputStream, str2);
        if (tfSc.sc() != null) {
            return tfSc.sc();
        }
        return null;
    }

    private Tf<com.bytedance.adsdk.pFF.qr> sc(Context context, String str, InputStream inputStream, String str2) throws IOException {
        qr qrVar;
        return (str2 == null || (qrVar = this.f26163sc) == null) ? com.bytedance.adsdk.pFF.Qj.sc(context, new ZipInputStream(inputStream), (String) null) : com.bytedance.adsdk.pFF.Qj.sc(context, new ZipInputStream(new FileInputStream(qrVar.sc(str, inputStream, zY.ZIP))), str);
    }

    private Tf<com.bytedance.adsdk.pFF.qr> sc(Context context, String str, InputStream inputStream, String str2, String str3) throws IOException {
        Tf<com.bytedance.adsdk.pFF.qr> tfSc;
        zY zYVar;
        qr qrVar;
        if (str2 == null) {
            str2 = "application/json";
        }
        if (str2.contains("application/zip") || str2.contains("application/x-zip") || str2.contains("application/x-zip-compressed") || str.split("\\?")[0].endsWith(".lottie")) {
            zY zYVar2 = zY.ZIP;
            tfSc = sc(context, str, inputStream, str3);
            zYVar = zYVar2;
        } else {
            zYVar = zY.JSON;
            tfSc = sc(str, inputStream, str3);
        }
        if (str3 != null && tfSc.sc() != null && (qrVar = this.f26163sc) != null) {
            qrVar.sc(str, zYVar);
        }
        return tfSc;
    }

    private Tf<com.bytedance.adsdk.pFF.qr> sc(String str, InputStream inputStream, String str2) throws IOException {
        qr qrVar;
        return (str2 == null || (qrVar = this.f26163sc) == null) ? com.bytedance.adsdk.pFF.Qj.pFF(inputStream, (String) null) : com.bytedance.adsdk.pFF.Qj.pFF(new FileInputStream(qrVar.sc(str, inputStream, zY.JSON).getAbsolutePath()), str);
    }

    @WorkerThread
    private Tf<com.bytedance.adsdk.pFF.qr> zY(Context context, String str, String str2) {
        Closeable closeable = null;
        try {
            try {
                We weSc = this.pFF.sc(str);
                if (!weSc.sc()) {
                    Tf<com.bytedance.adsdk.pFF.qr> tf2 = new Tf<>(new IllegalArgumentException(weSc.We()));
                    try {
                        weSc.close();
                    } catch (IOException unused) {
                    }
                    return tf2;
                }
                Tf<com.bytedance.adsdk.pFF.qr> tfSc = sc(context, str, weSc.pFF(), weSc.zY(), str2);
                tfSc.sc();
                try {
                    weSc.close();
                } catch (IOException unused2) {
                }
                return tfSc;
            } catch (Throwable th2) {
                if (0 != 0) {
                    try {
                        closeable.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th2;
            }
        } catch (Exception e11) {
            Tf<com.bytedance.adsdk.pFF.qr> tf3 = new Tf<>(e11);
            if (0 != 0) {
                try {
                    closeable.close();
                } catch (IOException unused4) {
                }
            }
            return tf3;
        }
    }

    @WorkerThread
    public Tf<com.bytedance.adsdk.pFF.qr> sc(Context context, String str, String str2) {
        com.bytedance.adsdk.pFF.qr qrVarPFF = pFF(context, str, str2);
        return qrVarPFF != null ? new Tf<>(qrVarPFF) : zY(context, str, str2);
    }
}
