package com.bytedance.adsdk.pFF;

import android.content.Context;
import android.os.Trace;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.bytedance.component.sdk.annotation.RestrictTo;
import java.io.File;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class ExN {
    private static String[] ExN = null;
    private static com.bytedance.adsdk.pFF.We.TRI Ol = null;
    private static int Qj = 0;
    private static long[] TRI = null;
    private static volatile com.bytedance.adsdk.pFF.We.qr Tf = null;
    private static volatile com.bytedance.adsdk.pFF.We.Qj UFX = null;
    private static com.bytedance.adsdk.pFF.We.ExN WH = null;
    private static boolean We = true;
    private static boolean pFF = false;

    /* JADX INFO: renamed from: qr, reason: collision with root package name */
    private static int f26083qr = 0;

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    public static boolean f26084sc = false;
    private static boolean zY = true;

    public static float pFF(String str) {
        int i11 = Qj;
        if (i11 > 0) {
            Qj = i11 - 1;
            return 0.0f;
        }
        if (!pFF) {
            return 0.0f;
        }
        int i12 = f26083qr - 1;
        f26083qr = i12;
        if (i12 == -1) {
            throw new IllegalStateException("Can't end trace section. There are none.");
        }
        if (str.equals(ExN[i12])) {
            Trace.endSection();
            return (System.nanoTime() - TRI[f26083qr]) / 1000000.0f;
        }
        throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + ExN[f26083qr] + InstructionFileId.DOT);
    }

    public static com.bytedance.adsdk.pFF.We.qr pFF(Context context) {
        com.bytedance.adsdk.pFF.We.qr qrVar;
        if (!zY) {
            return null;
        }
        final Context applicationContext = context.getApplicationContext();
        com.bytedance.adsdk.pFF.We.qr qrVar2 = Tf;
        if (qrVar2 != null) {
            return qrVar2;
        }
        synchronized (com.bytedance.adsdk.pFF.We.qr.class) {
            try {
                qrVar = Tf;
                if (qrVar == null) {
                    com.bytedance.adsdk.pFF.We.ExN exN = WH;
                    if (exN == null) {
                        exN = new com.bytedance.adsdk.pFF.We.ExN() { // from class: com.bytedance.adsdk.pFF.ExN.1
                            @Override // com.bytedance.adsdk.pFF.We.ExN
                            public File sc() {
                                return new File(applicationContext.getCacheDir(), "lottie_network_cache");
                            }
                        };
                    }
                    qrVar = new com.bytedance.adsdk.pFF.We.qr(exN);
                    Tf = qrVar;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return qrVar;
    }

    public static com.bytedance.adsdk.pFF.We.Qj sc(Context context) {
        com.bytedance.adsdk.pFF.We.Qj qj2;
        com.bytedance.adsdk.pFF.We.Qj qj3 = UFX;
        if (qj3 != null) {
            return qj3;
        }
        synchronized (com.bytedance.adsdk.pFF.We.Qj.class) {
            try {
                qj2 = UFX;
                if (qj2 == null) {
                    com.bytedance.adsdk.pFF.We.qr qrVarPFF = pFF(context);
                    com.bytedance.adsdk.pFF.We.TRI pff = Ol;
                    if (pff == null) {
                        pff = new com.bytedance.adsdk.pFF.We.pFF();
                    }
                    qj2 = new com.bytedance.adsdk.pFF.We.Qj(qrVarPFF, pff);
                    UFX = qj2;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return qj2;
    }

    public static void sc(String str) {
        if (pFF) {
            int i11 = f26083qr;
            if (i11 == 20) {
                Qj++;
                return;
            }
            ExN[i11] = str;
            TRI[i11] = System.nanoTime();
            Trace.beginSection(str);
            f26083qr++;
        }
    }

    public static boolean sc() {
        return We;
    }
}
