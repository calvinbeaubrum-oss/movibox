package com.bytedance.adsdk.pFF.ExN;

import android.util.JsonReader;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class We {
    public static com.bytedance.adsdk.pFF.zY.sc.Qj ExN(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar) throws IOException {
        return new com.bytedance.adsdk.pFF.zY.sc.Qj(sc(jsonReader, com.bytedance.adsdk.pFF.TRI.TRI.sc(), qrVar, cJ.f26096sc));
    }

    public static com.bytedance.adsdk.pFF.zY.sc.WH TRI(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar) throws IOException {
        return new com.bytedance.adsdk.pFF.zY.sc.WH(sc(jsonReader, com.bytedance.adsdk.pFF.TRI.TRI.sc(), qrVar, Ol.f26090sc));
    }

    public static com.bytedance.adsdk.pFF.zY.sc.qr We(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar) throws IOException {
        return new com.bytedance.adsdk.pFF.zY.sc.qr(sc(jsonReader, qrVar, OXF.f26089sc));
    }

    public static com.bytedance.adsdk.pFF.zY.sc.We pFF(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar) throws IOException {
        return new com.bytedance.adsdk.pFF.zY.sc.We(sc(jsonReader, qrVar, wjp.f26099sc));
    }

    public static com.bytedance.adsdk.pFF.zY.sc.sc qr(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar) throws IOException {
        return new com.bytedance.adsdk.pFF.zY.sc.sc(sc(jsonReader, qrVar, qr.f26097sc));
    }

    public static com.bytedance.adsdk.pFF.zY.sc.pFF sc(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar) throws IOException {
        return sc(jsonReader, qrVar, true);
    }

    public static com.bytedance.adsdk.pFF.zY.sc.pFF sc(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar, boolean z11) throws IOException {
        return new com.bytedance.adsdk.pFF.zY.sc.pFF(sc(jsonReader, z11 ? com.bytedance.adsdk.pFF.TRI.TRI.sc() : 1.0f, qrVar, Tf.f26092sc));
    }

    public static com.bytedance.adsdk.pFF.zY.sc.zY sc(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar, int i11) throws IOException {
        return new com.bytedance.adsdk.pFF.zY.sc.zY(sc(jsonReader, qrVar, new BT(i11)));
    }

    private static <T> List<com.bytedance.adsdk.pFF.qr.sc<T>> sc(JsonReader jsonReader, float f11, com.bytedance.adsdk.pFF.qr qrVar, pc<T> pcVar) throws IOException {
        return Dl.sc(jsonReader, qrVar, f11, pcVar, false);
    }

    private static <T> List<com.bytedance.adsdk.pFF.qr.sc<T>> sc(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar, pc<T> pcVar) throws IOException {
        return Dl.sc(jsonReader, qrVar, 1.0f, pcVar, false);
    }

    public static com.bytedance.adsdk.pFF.zY.sc.TRI zY(JsonReader jsonReader, com.bytedance.adsdk.pFF.qr qrVar) throws IOException {
        return new com.bytedance.adsdk.pFF.zY.sc.TRI(Dl.sc(jsonReader, qrVar, com.bytedance.adsdk.pFF.TRI.TRI.sc(), McK.f26088sc, true));
    }
}
