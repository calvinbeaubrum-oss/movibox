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
public final class k implements com.mbridge.msdk.newreward.a.b.a {

    /* JADX INFO: compiled from: source.java */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.mbridge.msdk.foundation.c.b f46050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.a.b.b f46051b;

        public a(com.mbridge.msdk.foundation.c.b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
            this.f46050a = bVar;
            this.f46051b = bVar2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.mbridge.msdk.foundation.c.b bVar;
            com.mbridge.msdk.newreward.a.b.b bVar2 = this.f46051b;
            if (bVar2 == null || (bVar = this.f46050a) == null) {
                return;
            }
            bVar2.a(bVar);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private JSONObject f46052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.a.b.b f46053b;

        public b(JSONObject jSONObject, com.mbridge.msdk.newreward.a.b.b bVar) {
            this.f46052a = jSONObject;
            this.f46053b = bVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.mbridge.msdk.videocommon.d.a aVarA;
            if (this.f46053b == null || this.f46052a == null) {
                return;
            }
            try {
                String strK = com.mbridge.msdk.foundation.controller.c.m().k();
                if (ai.a(this.f46052a)) {
                    JSONObject jSONObjectOptJSONObject = this.f46052a.optJSONObject("data");
                    this.f46052a = jSONObjectOptJSONObject;
                    if (jSONObjectOptJSONObject != null) {
                        if (jSONObjectOptJSONObject.optInt("vtag_status", 0) == 1) {
                            String strG = com.mbridge.msdk.videocommon.d.b.a().g(strK);
                            if (!TextUtils.isEmpty(strG)) {
                                this.f46052a = com.mbridge.msdk.c.h.a().a(new JSONObject(strG), this.f46052a);
                            }
                        }
                        this.f46052a.put("current_time", System.currentTimeMillis());
                        com.mbridge.msdk.videocommon.d.b.a().b(strK, this.f46052a.toString());
                        aVarA = com.mbridge.msdk.videocommon.d.a.a(this.f46052a.toString());
                    }
                    this.f46053b.a(aVarA);
                }
                com.mbridge.msdk.videocommon.d.b.a().f(strK);
                aVarA = null;
                this.f46053b.a(aVarA);
            } catch (Throwable th2) {
                ad.b("ReqRewardSettingService", th2.getMessage());
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class c implements com.mbridge.msdk.foundation.same.net.e<JSONObject>, com.mbridge.msdk.newreward.function.d.b.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.a.b.b f46054a;

        public c(com.mbridge.msdk.newreward.a.b.b bVar) {
            this.f46054a = bVar;
        }

        @Override // com.mbridge.msdk.newreward.function.d.b.e
        public final void a(p<JSONObject> pVar, com.mbridge.msdk.newreward.function.d.b.d dVar) {
            com.mbridge.msdk.videocommon.d.b.a().a(false);
            MBridgeTaskManager.commonExecute(new a(new com.mbridge.msdk.foundation.c.b(880002, dVar.a()), this.f46054a));
        }

        @Override // com.mbridge.msdk.newreward.function.d.b.e
        public final void a(JSONObject jSONObject, p<JSONObject> pVar) {
            com.mbridge.msdk.videocommon.d.b.a().a(false);
            MBridgeTaskManager.commonExecute(new b(jSONObject, this.f46054a));
        }

        @Override // com.mbridge.msdk.foundation.same.net.e
        public final void onCancel() {
        }

        @Override // com.mbridge.msdk.foundation.same.net.e
        public final void onError(com.mbridge.msdk.foundation.same.net.b.a aVar) {
            com.mbridge.msdk.videocommon.d.b.a().a(false);
            MBridgeTaskManager.commonExecute(new a(new com.mbridge.msdk.foundation.c.b(880002, aVar.getMessage()), this.f46054a));
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
            com.mbridge.msdk.videocommon.d.b.a().a(false);
            MBridgeTaskManager.commonExecute(new b(kVar.f44691c, this.f46054a));
        }
    }

    @Override // com.mbridge.msdk.newreward.a.b.a
    public final void a(Object obj, com.mbridge.msdk.newreward.a.b.b bVar) throws IOException {
        int iD;
        if (obj == null) {
            throw new IOException("ReqRewardSettingService doReq: params is null");
        }
        com.mbridge.msdk.newreward.function.g.c cVar = (com.mbridge.msdk.newreward.function.g.c) obj;
        cVar.b(com.mbridge.msdk.newreward.function.d.b.g.f46337a);
        if (com.mbridge.msdk.videocommon.d.b.a().d()) {
            return;
        }
        com.mbridge.msdk.videocommon.d.b.a().a(true);
        try {
            com.mbridge.msdk.videocommon.d.a aVarE = com.mbridge.msdk.videocommon.d.b.a().e();
            cVar.b(aVarE == null ? "" : aVarE.a());
        } catch (Throwable th2) {
            ad.b("ReqRewardSettingService", th2.getMessage());
        }
        try {
            String str = com.mbridge.msdk.foundation.same.net.g.d.f().f44641r ? com.mbridge.msdk.foundation.same.net.g.d.f().J : com.mbridge.msdk.foundation.same.net.g.d.f().I;
            if (com.mbridge.msdk.foundation.same.net.g.d.f().f44641r) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uri", str);
                jSONObject.put("data", cVar.d());
                com.mbridge.msdk.foundation.same.net.m.a().a(com.mbridge.msdk.foundation.same.net.g.d.f().f44635l, com.mbridge.msdk.foundation.same.net.g.d.f().f44639p, jSONObject.toString(), true, new c(bVar));
                return;
            }
            com.mbridge.msdk.newreward.function.d.b.g gVar = new com.mbridge.msdk.newreward.function.d.b.g(str);
            gVar.a(cVar.c());
            gVar.a((com.mbridge.msdk.newreward.function.d.b.e) new c(bVar));
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
