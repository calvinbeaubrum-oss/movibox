package com.bytedance.sdk.openadsdk.JPJ;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.Tf;
import com.bytedance.sdk.openadsdk.core.Xc;
import com.bytedance.sdk.openadsdk.core.model.Sfl;
import com.bytedance.sdk.openadsdk.utils.cJ;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class sc {
    private static int sc(int i11) {
        int i12 = 2;
        if (i11 != 2) {
            i12 = 3;
            if (i11 != 3) {
                i12 = 4;
                if (i11 != 4) {
                    i12 = 5;
                    if (i11 != 5 && i11 != 15) {
                        return -1;
                    }
                }
            }
        }
        return i12;
    }

    private static String sc(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return str.replace("[ss_random]", String.valueOf(new SecureRandom().nextLong())).replace("[ss_timestamp]", String.valueOf(System.currentTimeMillis()));
        } catch (Exception e11) {
            Tf.sc("TrackAdUrlUtils", e11.getMessage());
            return str;
        }
    }

    public static List<String> sc(List<String> list, boolean z11) {
        String strSc = com.bytedance.sdk.openadsdk.core.Tf.sc(Xc.sc());
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.contains("{TS}") || next.contains("__TS__")) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                next = next.replace("{TS}", String.valueOf(jCurrentTimeMillis)).replace("__TS__", String.valueOf(jCurrentTimeMillis));
            }
            if ((next.contains("{UID}") || next.contains("__UID__")) && !TextUtils.isEmpty(strSc)) {
                next = next.replace("{UID}", strSc).replace("__UID__", strSc);
            }
            if (z11) {
                next = sc(next);
            }
            arrayList.add(next);
        }
        return arrayList;
    }

    public static List<String> sc(List<String> list, boolean z11, Sfl sfl) {
        String strSc = com.bytedance.sdk.openadsdk.core.Tf.sc(Xc.sc());
        if (list == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (next.contains("{TS}") || next.contains("__TS__")) {
                long jCurrentTimeMillis = System.currentTimeMillis();
                next = next.replace("{TS}", String.valueOf(jCurrentTimeMillis)).replace("__TS__", String.valueOf(jCurrentTimeMillis));
            }
            if ((next.contains("{UID}") || next.contains("__UID__")) && !TextUtils.isEmpty(strSc)) {
                next = next.replace("{UID}", strSc).replace("__UID__", strSc);
            }
            if (next.contains("__CID__") && sfl != null && !TextUtils.isEmpty(sfl.kDg())) {
                next = next.replace("__CID__", sfl.kDg());
            }
            if (next.contains("__CTYPE__") && sfl != null) {
                next = next.replace("__CTYPE__", String.valueOf(sc(sfl.dix())));
            }
            if (next.contains("__GAID__")) {
                next = next.replace("__GAID__", com.bytedance.sdk.openadsdk.wjp.sc.pFF.sc.sc().pFF());
            }
            if (next.contains("__OS__")) {
                next = next.replace("__OS__", "0");
            }
            if (next.contains("__UA1__")) {
                next = next.replace("__UA1__", URLEncoder.encode(cJ.zY()));
            }
            if (z11) {
                next = sc(next);
            }
            arrayList.add(next);
        }
        return arrayList;
    }
}
