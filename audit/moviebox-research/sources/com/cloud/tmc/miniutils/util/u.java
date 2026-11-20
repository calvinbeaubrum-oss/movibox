package com.cloud.tmc.miniutils.util;

import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final class u {
    public static boolean a(String str, String str2) {
        try {
            String[] list = e0.a().getAssets().list(str);
            if (list == null || list.length <= 0) {
                return h0.B(str2, e0.a().getAssets().open(str));
            }
            boolean zA = true;
            for (String str3 : list) {
                zA &= a(str + "/" + str3, str2 + "/" + str3);
            }
            return zA;
        } catch (IOException e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public static String b(String str) {
        return c(str, null);
    }

    public static String c(String str, String str2) {
        try {
            byte[] bArrO = h0.o(e0.a().getAssets().open(str));
            if (bArrO.length == 0) {
                return "";
            }
            return h0.u(str2) ? new String(bArrO) : new String(bArrO, str2);
        } catch (IOException e11) {
            e11.printStackTrace();
            return "";
        }
    }
}
