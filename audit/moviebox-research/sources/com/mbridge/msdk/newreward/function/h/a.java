package com.mbridge.msdk.newreward.function.h;

import android.text.TextUtils;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.newreward.function.common.MBridgeTaskManager;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static String a(File file) throws Throwable {
        StringBuilder sb2 = new StringBuilder();
        FileInputStream fileInputStream = null;
        try {
            try {
                try {
                    FileInputStream fileInputStream2 = new FileInputStream(file);
                    try {
                        byte[] bArr = new byte[1024];
                        for (int i11 = fileInputStream2.read(bArr); i11 > 0; i11 = fileInputStream2.read(bArr)) {
                            sb2.append(new String(bArr, 0, i11));
                        }
                        fileInputStream2.close();
                    } catch (Exception unused) {
                        fileInputStream = fileInputStream2;
                        sb2.setLength(0);
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        return sb2.toString();
                    } catch (Throwable th2) {
                        th = th2;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception unused2) {
                            }
                        }
                        throw th;
                    }
                } catch (Exception unused3) {
                }
                return sb2.toString();
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (Exception unused4) {
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String path = new URL(str).getPath();
            return path.substring(path.lastIndexOf(47) + 1);
        } catch (Exception unused) {
            return str;
        }
    }

    public static void a(final String str, final int i11, final int i12, final int i13) {
        MBridgeTaskManager.commonExecute(new Runnable() { // from class: com.mbridge.msdk.newreward.function.h.a.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ivRewardEnable", 1);
                    jSONObject.put("ivRewardMode", i11 == com.mbridge.msdk.foundation.same.a.G ? 0 : 1);
                    jSONObject.put("ivRewardPlayValueMode", i12 == com.mbridge.msdk.foundation.same.a.I ? 0 : 1);
                    jSONObject.put("ivRewardPlayValue", i13);
                    h.a().f(str, jSONObject.toString());
                } catch (Exception unused) {
                }
            }
        });
    }

    public static boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return ai.i(str);
    }

    public static boolean c(String str) {
        String[] strArrSplit;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String[] strArrSplit2 = str.split("_");
            if (strArrSplit2.length < 4) {
                return false;
            }
            String str2 = strArrSplit2[3];
            return (TextUtils.isEmpty(str2) || (strArrSplit = x.a(str2).split("\\|")) == null || strArrSplit.length == 0) ? false : true;
        } catch (Exception unused) {
            return true;
        }
    }

    public static double d(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0.0d;
        }
        try {
            String[] strArrSplit = str.split("_");
            if (strArrSplit.length < 4) {
                return 0.0d;
            }
            String str2 = strArrSplit[3];
            if (TextUtils.isEmpty(str2)) {
                return 0.0d;
            }
            String[] strArrSplit2 = x.a(str2).split("\\|");
            if (strArrSplit2.length > 0) {
                return Double.parseDouble(strArrSplit2[0]);
            }
        } catch (Exception unused) {
        }
        return 0.0d;
    }
}
