package com.mbridge.msdk.newreward.a.b;

import android.os.SystemClock;
import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.newreward.function.common.MBridgeTaskManager;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class c implements com.mbridge.msdk.newreward.a.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.mbridge.msdk.newreward.a.e f46006a;

    /* JADX INFO: compiled from: source.java */
    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.function.d.a.b f46007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.function.d.b.b f46008b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f46009c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f46010d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.a.b.b f46011e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private final String f46012f;

        public a(com.mbridge.msdk.newreward.function.d.a.b bVar, com.mbridge.msdk.newreward.function.d.b.b bVar2, boolean z11, int i11, com.mbridge.msdk.newreward.a.b.b bVar3, String str) {
            this.f46007a = bVar;
            this.f46008b = bVar2;
            this.f46009c = z11;
            this.f46010d = i11;
            this.f46011e = bVar3;
            this.f46012f = str;
        }

        private com.mbridge.msdk.foundation.c.b a(int i11) {
            String strD;
            boolean z11;
            String strC = "load exception with no mCampaignRequestError";
            com.mbridge.msdk.foundation.c.b bVarA = null;
            int iA = 0;
            int i12 = 880002;
            try {
                com.mbridge.msdk.newreward.function.d.b.b bVar = this.f46008b;
                if (bVar != null) {
                    String strF = "";
                    if (bVar.c() == 9) {
                        iA = this.f46008b.a();
                        strC = this.f46008b.b();
                        i12 = this.f46008b.c() == -1 ? 880017 : 880003;
                        z11 = true;
                        strF = this.f46008b.f();
                        strD = "";
                    } else if (this.f46008b.c() == 10) {
                        try {
                            strC = this.f46008b.d();
                            strD = "";
                            iA = 880023;
                            i12 = 880023;
                            z11 = false;
                        } catch (Exception e11) {
                            e = e11;
                            iA = 880023;
                            e.printStackTrace();
                        }
                    } else {
                        switch (this.f46008b.c()) {
                            case 0:
                            case 5:
                                i12 = 880020;
                                break;
                            case 6:
                            case 7:
                                i12 = 880003;
                                break;
                        }
                        if (this.f46008b.e() != null) {
                            int iB = this.f46008b.e().b();
                            try {
                                strC = this.f46008b.e().c();
                                iA = iB;
                                strD = this.f46008b.d();
                            } catch (Exception e12) {
                                e = e12;
                                iA = iB;
                                e.printStackTrace();
                            }
                        } else {
                            strD = "";
                        }
                        z11 = false;
                    }
                    bVarA = com.mbridge.msdk.foundation.c.a.a(iA, i12, strC);
                    bVarA.a("can_retry", Boolean.valueOf(this.f46009c));
                    bVarA.a("campaign_request_error_type", Integer.valueOf(i11));
                    bVarA.a("campaign_request_error", this.f46008b);
                    bVarA.b(z11);
                    if (!TextUtils.isEmpty(strF)) {
                        bVarA.d(strF);
                    }
                    if (!TextUtils.isEmpty(strD)) {
                        bVarA.e(strD);
                    }
                    bVarA.c(this.f46012f);
                }
            } catch (Exception e13) {
                e = e13;
            }
            return bVarA == null ? com.mbridge.msdk.foundation.c.a.a(iA, i12, strC) : bVarA;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.mbridge.msdk.newreward.a.b.b bVar = this.f46011e;
            if (bVar == null || this.f46008b == null) {
                return;
            }
            try {
                bVar.a(a(this.f46010d));
            } catch (Exception e11) {
                ad.a("ReqCampaignService", "run: ", e11);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.function.d.a.b f46013a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.a.b.b f46014b;

        public b(com.mbridge.msdk.newreward.function.d.a.b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
            this.f46013a = bVar;
            this.f46014b = bVar2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            com.mbridge.msdk.newreward.function.d.a.b bVar;
            com.mbridge.msdk.newreward.a.b.b bVar2 = this.f46014b;
            if (bVar2 == null || (bVar = this.f46013a) == null) {
                return;
            }
            try {
                bVar2.a(bVar);
            } catch (Exception e11) {
                ad.a("ReqCampaignService", "run: ", e11);
            }
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.newreward.a.b.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0503c implements com.mbridge.msdk.newreward.function.d.b.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.a.b.b f46015a;

        public C0503c(com.mbridge.msdk.newreward.a.b.b bVar) {
            this.f46015a = bVar;
        }

        @Override // com.mbridge.msdk.newreward.function.d.b.c
        public final void a(com.mbridge.msdk.newreward.function.d.a.b bVar, com.mbridge.msdk.newreward.function.d.b.a aVar) {
            MBridgeTaskManager.commonExecute(new b(bVar, this.f46015a));
        }

        @Override // com.mbridge.msdk.newreward.function.d.b.c
        public final void a(com.mbridge.msdk.newreward.function.d.a.b bVar, com.mbridge.msdk.newreward.function.d.b.a aVar, long j11, com.mbridge.msdk.newreward.function.d.b.b bVar2) {
            MBridgeTaskManager.commonExecute(new a(bVar, bVar2, false, 405, this.f46015a, aVar.i()));
        }

        @Override // com.mbridge.msdk.newreward.function.d.b.c
        public final void a(com.mbridge.msdk.newreward.function.d.a.b bVar, com.mbridge.msdk.newreward.function.d.b.a aVar, com.mbridge.msdk.newreward.function.d.b.b bVar2) {
            MBridgeTaskManager.commonExecute(new a(bVar, bVar2, false, 402, this.f46015a, aVar.i()));
        }

        @Override // com.mbridge.msdk.newreward.function.d.b.c
        public final void b(com.mbridge.msdk.newreward.function.d.a.b bVar, com.mbridge.msdk.newreward.function.d.b.a aVar, com.mbridge.msdk.newreward.function.d.b.b bVar2) {
            MBridgeTaskManager.commonExecute(new a(bVar, bVar2, true, 401, this.f46015a, aVar.i()));
        }
    }

    public c(com.mbridge.msdk.newreward.a.e eVar) {
        this.f46006a = eVar;
    }

    @Override // com.mbridge.msdk.newreward.a.b.a
    public final void a(Object obj, com.mbridge.msdk.newreward.a.b.b bVar) throws IOException {
        int iD;
        if (obj == null) {
            throw new IOException("ReqCampaignService doReq: params is null");
        }
        try {
            long jE = this.f46006a.e();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (jE <= 0) {
                this.f46006a.b(jElapsedRealtime);
                jE = jElapsedRealtime;
            }
            com.mbridge.msdk.newreward.function.g.d dVar = (com.mbridge.msdk.newreward.function.g.d) obj;
            int iB = dVar.b();
            String strC = dVar.c();
            String strD = dVar.d();
            String strE = dVar.e();
            long jG = ((long) this.f46006a.G()) - (jElapsedRealtime - jE);
            Map<String, String> mapF = dVar.f();
            com.mbridge.msdk.newreward.function.d.b.h hVar = new com.mbridge.msdk.newreward.function.d.b.h(iB, strC, strD, Math.max(jG, 0L), strE);
            hVar.a(mapF);
            hVar.b(this.f46006a.x());
            hVar.a((com.mbridge.msdk.newreward.function.d.b.c) new C0503c(bVar));
            byte[] bArrO = hVar.o();
            int length = bArrO != null ? bArrO.length : 0;
            hVar.a(com.mbridge.msdk.foundation.same.net.h.e.f44663h, String.valueOf(length));
            if (bArrO != null && (iD = com.mbridge.msdk.foundation.same.net.g.d.f().d()) > 0 && length > iD) {
                hVar.a(1);
                hVar.b(HttpHeaders.CONTENT_TYPE, "application/x-www-form-urlencoded");
            }
            com.mbridge.msdk.newreward.function.d.b.f.a().b().a(hVar);
        } catch (Exception e11) {
            throw new IOException(e11);
        }
    }
}
