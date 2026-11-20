package com.mbridge.msdk.foundation.same.report;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.ad;
import org.json.JSONArray;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f44859a = "DomainReport";

    public static boolean a(com.mbridge.msdk.c.g gVar, String str) {
        if (gVar == null) {
            return true;
        }
        try {
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            int iO = gVar.O();
            JSONArray jSONArrayM = gVar.M();
            JSONArray jSONArrayL = gVar.L();
            if (jSONArrayL != null) {
                for (int i11 = 0; i11 < jSONArrayL.length(); i11++) {
                    if (str.contains(jSONArrayL.getString(i11))) {
                        return false;
                    }
                }
            }
            if (iO != 2) {
                return true;
            }
            if (jSONArrayM != null) {
                for (int i12 = 0; i12 < jSONArrayM.length(); i12++) {
                    if (str.contains(jSONArrayM.getString(i12))) {
                        return true;
                    }
                }
            }
            return false;
        } catch (Exception e11) {
            ad.b(f44859a, e11.getMessage());
            return true;
        }
    }
}
