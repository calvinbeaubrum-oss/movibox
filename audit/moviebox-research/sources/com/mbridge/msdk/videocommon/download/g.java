package com.mbridge.msdk.videocommon.download;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.download.ResourceManager;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.ao;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f48553a = "ResourceManager";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f48554b;

    /* JADX INFO: renamed from: com.mbridge.msdk.videocommon.download.g$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public class AnonymousClass1 extends com.mbridge.msdk.foundation.same.e.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ g f48555a;

        @Override // com.mbridge.msdk.foundation.same.e.a
        public final void cancelTask() {
        }

        @Override // com.mbridge.msdk.foundation.same.e.a
        public final void pauseTask(boolean z11) {
        }

        @Override // com.mbridge.msdk.foundation.same.e.a
        public final void runTask() {
            ab.a(this.f48555a.f48554b);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static g f48556a = new g(null);
    }

    private g() {
        this.f48554b = com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_RES);
    }

    public /* synthetic */ g(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static g a() {
        return a.f48556a;
    }

    public final String a(String str) throws Throwable {
        String strSubstring;
        String str2 = "";
        try {
            String str3 = this.f48554b + "/" + SameMD5.getMD5(ao.b(str));
            List<String> queryParameters = Uri.parse(str).getQueryParameters(ResourceManager.KEY_INDEX_HTML);
            if (queryParameters == null || queryParameters.size() <= 0) {
                return null;
            }
            String str4 = queryParameters.get(0);
            if (TextUtils.isEmpty(str4)) {
                return null;
            }
            String str5 = str3 + "/" + str4 + "/" + str4 + ".html";
            if (!ab.d(str5)) {
                return null;
            }
            try {
                com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
                if (gVarB != null && !TextUtils.isEmpty(gVarB.V())) {
                    File file = new File(str5);
                    ab.a(com.mbridge.msdk.a.b.c(jn.b.a(MBridgeConstans.OMID_JS_SERVICE_CONTENT, ab.b(file))).getBytes(), file);
                }
                strSubstring = str.substring(str.indexOf("?") + 1);
            } catch (Exception unused) {
                strSubstring = "";
            }
            if (!TextUtils.isEmpty(strSubstring)) {
                str2 = "?" + strSubstring;
            }
            return "file://" + str5 + str2;
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            e11.printStackTrace();
            return null;
        }
    }
}
