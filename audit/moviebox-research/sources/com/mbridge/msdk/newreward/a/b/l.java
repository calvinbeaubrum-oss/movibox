package com.mbridge.msdk.newreward.a.b;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.mbridge.msdk.e.a.p;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.newreward.function.common.MBridgeTaskManager;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class l implements com.mbridge.msdk.newreward.a.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f46055a;

    /* JADX INFO: compiled from: source.java */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.mbridge.msdk.foundation.c.b f46056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.a.b.b f46057b;

        public a(com.mbridge.msdk.foundation.c.b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
            this.f46056a = bVar;
            this.f46057b = bVar2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.mbridge.msdk.foundation.c.b bVar;
            com.mbridge.msdk.newreward.a.b.b bVar2 = this.f46057b;
            if (bVar2 == null || (bVar = this.f46056a) == null) {
                return;
            }
            bVar2.a(bVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements com.mbridge.msdk.foundation.same.net.e<JSONObject>, com.mbridge.msdk.newreward.function.d.b.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f46058a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.a.b.b f46059b;

        public b(String str, com.mbridge.msdk.newreward.a.b.b bVar) {
            this.f46058a = str;
            this.f46059b = bVar;
        }

        @Override // com.mbridge.msdk.newreward.function.d.b.e
        public final void a(p<JSONObject> pVar, com.mbridge.msdk.newreward.function.d.b.d dVar) {
            com.mbridge.msdk.videocommon.d.b.a().b(this.f46058a);
            MBridgeTaskManager.commonExecute(new a(new com.mbridge.msdk.foundation.c.b(880002, dVar.a()), this.f46059b));
        }

        @Override // com.mbridge.msdk.newreward.function.d.b.e
        public final void a(JSONObject jSONObject, p<JSONObject> pVar) {
            com.mbridge.msdk.videocommon.d.b.a().b(this.f46058a);
            MBridgeTaskManager.commonExecute(new c(this.f46058a, jSONObject, this.f46059b));
        }

        @Override // com.mbridge.msdk.foundation.same.net.e
        public final void onCancel() {
        }

        @Override // com.mbridge.msdk.foundation.same.net.e
        public final void onError(com.mbridge.msdk.foundation.same.net.b.a aVar) {
            com.mbridge.msdk.videocommon.d.b.a().b(this.f46058a);
            MBridgeTaskManager.commonExecute(new a(new com.mbridge.msdk.foundation.c.b(880002, aVar.getMessage()), this.f46059b));
        }

        @Override // com.mbridge.msdk.foundation.same.net.e
        public final void onFinish() {
        }

        @Override // com.mbridge.msdk.foundation.same.net.e
        public final void onNetworking() {
        }

        @Override // com.mbridge.msdk.foundation.same.net.e
        public final void onPreExecute() {
        }

        @Override // com.mbridge.msdk.foundation.same.net.e
        public final void onProgressChange(long j11, long j12) {
        }

        @Override // com.mbridge.msdk.foundation.same.net.e
        public final void onRetry() {
        }

        @Override // com.mbridge.msdk.foundation.same.net.e
        public final void onSuccess(com.mbridge.msdk.foundation.same.net.k<JSONObject> kVar) {
            com.mbridge.msdk.videocommon.d.b.a().b(this.f46058a);
            MBridgeTaskManager.commonExecute(new c(this.f46058a, kVar.f44691c, this.f46059b));
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f46060a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private JSONObject f46061b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.a.b.b f46062c;

        public c(String str, JSONObject jSONObject, com.mbridge.msdk.newreward.a.b.b bVar) {
            this.f46060a = str;
            this.f46061b = jSONObject;
            this.f46062c = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.mbridge.msdk.videocommon.d.c cVarC;
            if (this.f46062c == null || this.f46061b == null) {
                return;
            }
            try {
                String strK = com.mbridge.msdk.foundation.controller.c.m().k();
                if (ai.a(this.f46061b)) {
                    JSONObject jSONObjectOptJSONObject = this.f46061b.optJSONObject("data");
                    this.f46061b = jSONObjectOptJSONObject;
                    if (jSONObjectOptJSONObject != null) {
                        if (jSONObjectOptJSONObject.optInt("vtag_status", 0) == 1) {
                            String strD = com.mbridge.msdk.videocommon.d.b.a().d(strK, this.f46060a);
                            if (!TextUtils.isEmpty(strD)) {
                                this.f46061b = com.mbridge.msdk.c.h.a().a(new JSONObject(strD), this.f46061b);
                            }
                        }
                        if (com.mbridge.msdk.videocommon.d.b.e(this.f46061b.toString())) {
                            this.f46061b.put("current_time", System.currentTimeMillis());
                            com.mbridge.msdk.videocommon.d.b.a().a(strK, this.f46060a, this.f46061b.toString());
                        }
                        cVarC = com.mbridge.msdk.videocommon.d.c.c(this.f46061b.toString());
                    }
                    this.f46062c.a(cVarC);
                }
                com.mbridge.msdk.videocommon.d.b.a().c(strK, this.f46060a);
                cVarC = null;
                this.f46062c.a(cVarC);
            } catch (Throwable th2) {
                ad.b("ReqRewardUnitSettingService", th2.getMessage());
            }
        }
    }

    @Override // com.mbridge.msdk.newreward.a.b.a
    public final void a(Object obj, com.mbridge.msdk.newreward.a.b.b bVar) throws IOException {
        int iD;
        if (obj == null) {
            throw new IOException("ReqRewardUnitSettingService doReq: params is null");
        }
        com.mbridge.msdk.newreward.function.g.c cVar = (com.mbridge.msdk.newreward.function.g.c) obj;
        String strK = com.mbridge.msdk.foundation.controller.c.m().k();
        this.f46055a = cVar.b();
        cVar.b(com.mbridge.msdk.newreward.function.d.b.g.f46338b);
        if (com.mbridge.msdk.videocommon.d.b.a().d(this.f46055a)) {
            return;
        }
        com.mbridge.msdk.videocommon.d.b.a().a(this.f46055a);
        try {
            com.mbridge.msdk.videocommon.d.c cVarE = com.mbridge.msdk.videocommon.d.b.a().e(strK, this.f46055a);
            cVar.b(cVarE == null ? "" : cVarE.j());
        } catch (Throwable th2) {
            ad.b("ReqRewardUnitSettingService", th2.getMessage());
        }
        try {
            String str = com.mbridge.msdk.foundation.same.net.g.d.f().f44641r ? com.mbridge.msdk.foundation.same.net.g.d.f().J : com.mbridge.msdk.foundation.same.net.g.d.f().I;
            if (com.mbridge.msdk.foundation.same.net.g.d.f().f44641r) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uri", str);
                jSONObject.put("data", cVar.d());
                com.mbridge.msdk.foundation.same.net.m.a().a(com.mbridge.msdk.foundation.same.net.g.d.f().f44635l, com.mbridge.msdk.foundation.same.net.g.d.f().f44639p, jSONObject.toString(), true, new b(this.f46055a, bVar));
                return;
            }
            com.mbridge.msdk.newreward.function.d.b.g gVar = new com.mbridge.msdk.newreward.function.d.b.g(str);
            gVar.a(cVar.c());
            gVar.a((com.mbridge.msdk.newreward.function.d.b.e) new b(this.f46055a, bVar));
            byte[] bArrO = gVar.o();
            int length = bArrO != null ? bArrO.length : 0;
            HashMap map = new HashMap();
            map.put(com.mbridge.msdk.foundation.same.net.h.e.f44663h, String.valueOf(length));
            gVar.a((Map<String, String>) map);
            if (bArrO != null && (iD = com.mbridge.msdk.foundation.same.net.g.d.f().d()) > 0 && length > iD) {
                gVar.a(1);
                gVar.a(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
            }
            com.mbridge.msdk.newreward.function.d.b.f.a().a(gVar);
        } catch (Exception e11) {
            throw new IOException(e11);
        }
    }
}
