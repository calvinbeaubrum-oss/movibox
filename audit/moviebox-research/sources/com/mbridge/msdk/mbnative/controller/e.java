package com.mbridge.msdk.mbnative.controller;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.q;
import com.mbridge.msdk.foundation.entity.n;
import com.mbridge.msdk.foundation.tools.ad;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f45621a = "com.mbridge.msdk.mbnative.controller.e";

    public static void a(Context context, String str) {
        if (context != null) {
            try {
                q qVarA = q.a(h.a(context));
                if (TextUtils.isEmpty(str) || qVarA == null || qVarA.a() <= 0) {
                    return;
                }
                List<n> listA = qVarA.a("m_download_end");
                List<n> listA2 = qVarA.a("2000021");
                List<n> listA3 = qVarA.a("m_download_end");
                String strE = n.e(listA2);
                String strA = n.a(listA);
                String strB = n.b(listA3);
                StringBuilder sb2 = new StringBuilder();
                if (!TextUtils.isEmpty(strE)) {
                    sb2.append(strE);
                }
                if (!TextUtils.isEmpty(strA)) {
                    sb2.append(strA);
                }
                if (!TextUtils.isEmpty(strB)) {
                    sb2.append(strB);
                }
                if (TextUtils.isEmpty(sb2.toString())) {
                    return;
                }
                String string = sb2.toString();
                if (TextUtils.isEmpty(string) || TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    new com.mbridge.msdk.foundation.same.report.e.a(context).post(0, com.mbridge.msdk.foundation.same.net.g.d.f().f44626c, com.mbridge.msdk.foundation.same.report.q.a(string, context, str), new com.mbridge.msdk.foundation.same.report.e.b() { // from class: com.mbridge.msdk.mbnative.controller.e.1
                        @Override // com.mbridge.msdk.foundation.same.report.e.b
                        public final void onFailed(String str2) {
                            ad.b(e.f45621a, str2);
                        }

                        @Override // com.mbridge.msdk.foundation.same.report.e.b
                        public final void onSuccess(String str2) {
                            ad.b(e.f45621a, str2);
                        }
                    });
                } catch (Exception e11) {
                    e11.printStackTrace();
                    ad.b(f45621a, e11.getMessage());
                }
            } catch (Exception e12) {
                e12.printStackTrace();
            }
        }
    }
}
