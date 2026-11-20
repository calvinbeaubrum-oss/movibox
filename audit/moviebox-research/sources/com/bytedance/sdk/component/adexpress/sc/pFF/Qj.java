package com.bytedance.sdk.component.adexpress.sc.pFF;

import com.bytedance.sdk.component.utils.Tf;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class Qj {

    /* JADX INFO: renamed from: sc, reason: collision with root package name */
    private static com.bytedance.sdk.component.adexpress.sc.zY.sc f26899sc;

    public static void We() {
        zY.pFF(ExN.Qj(), pFF(), "temp_pkg_info.json");
        f26899sc = null;
    }

    public static synchronized com.bytedance.sdk.component.adexpress.sc.zY.sc pFF() {
        return f26899sc;
    }

    public static boolean pFF(com.bytedance.sdk.component.adexpress.sc.zY.sc scVar) {
        return zY.zY(pFF(), scVar);
    }

    public static void sc() {
        FileInputStream fileInputStream;
        Throwable th2;
        FileInputStream fileInputStream2 = null;
        try {
            File file = new File(ExN.Qj(), "temp_pkg_info.json");
            Long lValueOf = Long.valueOf(file.length());
            if (lValueOf.longValue() > 0 && file.exists() && file.isFile()) {
                byte[] bArr = new byte[lValueOf.intValue()];
                fileInputStream = new FileInputStream(file);
                try {
                    fileInputStream.read(bArr);
                    com.bytedance.sdk.component.adexpress.sc.zY.sc scVarSc = com.bytedance.sdk.component.adexpress.sc.zY.sc.sc(new JSONObject(new String(bArr, "utf-8")));
                    if (scVarSc != null) {
                        f26899sc = scVarSc;
                        f26899sc.zY();
                    }
                    fileInputStream2 = fileInputStream;
                } catch (Throwable th3) {
                    th2 = th3;
                    try {
                        Tf.sc("Version", "version init error", th2);
                        if (fileInputStream != null) {
                            try {
                                return;
                            } catch (IOException unused) {
                                return;
                            }
                        }
                        return;
                    } finally {
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException unused2) {
                            }
                        }
                    }
                }
            }
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException unused3) {
                }
            }
        } catch (Throwable th4) {
            fileInputStream = null;
            th2 = th4;
        }
    }

    public static synchronized void sc(com.bytedance.sdk.component.adexpress.sc.zY.sc scVar) {
        if (scVar != null) {
            if (scVar.qr()) {
                f26899sc = scVar;
            }
        }
    }

    public static boolean sc(String str) {
        return zY.sc(pFF(), str);
    }

    public static void zY() {
        zY.sc(ExN.Qj(), pFF(), "temp_pkg_info.json");
    }
}
