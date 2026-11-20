package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.text.TextUtils;
import com.hisavana.common.constant.ComConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class b implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f44738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f44739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f44740c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final CampaignEx f44741d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Context f44742e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final c f44743f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final long f44744g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ConcurrentHashMap<String, Object> f44745h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Executor f44746i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f44747j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final String f44748k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final ConcurrentHashMap<String, String> f44749l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final String f44750m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final n f44751n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final String f44752o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final String f44753p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f44754q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final com.mbridge.msdk.foundation.same.net.l f44755r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final long f44756s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final String f44757t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private String f44758u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private boolean f44759v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private String f44760w;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ConcurrentHashMap<String, Object> f44764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f44765b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final ConcurrentHashMap<String, String> f44766c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f44767d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final String f44768e;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private CampaignEx f44771h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private Context f44772i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private c f44773j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private long f44774k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        private Executor f44775l;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        private n f44780q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        private String f44781r;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        private com.mbridge.msdk.foundation.same.net.l f44783t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        private long f44784u;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f44769f = "";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private String f44770g = "";

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        private boolean f44776m = false;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        private boolean f44777n = false;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        private String f44778o = "";

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        private String f44779p = "";

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        private boolean f44782s = false;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private String f44785v = "";

        public a(String str, String str2, String str3, int i11, int i12) {
            this.f44781r = str;
            this.f44767d = str2;
            if (TextUtils.isEmpty(str3)) {
                this.f44765b = UUID.randomUUID().toString();
            } else {
                this.f44765b = str3;
            }
            this.f44784u = System.currentTimeMillis();
            this.f44768e = UUID.randomUUID().toString();
            this.f44764a = new ConcurrentHashMap<>(v.a(i11));
            this.f44766c = new ConcurrentHashMap<>(v.a(i12));
        }

        public final a a(long j11) {
            this.f44784u = j11;
            return this;
        }

        public final a a(Context context) {
            this.f44772i = context;
            return this;
        }

        public final a a(String str) {
            this.f44769f = str;
            return this;
        }

        public final a a(Map<String, String> map) {
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (entry != null && !TextUtils.isEmpty(entry.getKey()) && !TextUtils.isEmpty(entry.getValue())) {
                        if (entry.getKey().equals(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B)) {
                            ad.b("CommonReport", entry.getValue());
                        }
                        this.f44766c.put(entry.getKey(), entry.getValue());
                    }
                }
            }
            return this;
        }

        public final a a(Executor executor) {
            this.f44775l = executor;
            return this;
        }

        public final a a(boolean z11) {
            this.f44782s = z11;
            return this;
        }

        public final b a() {
            if (this.f44775l == null) {
                this.f44775l = Executors.newSingleThreadExecutor(new ThreadFactory() { // from class: com.mbridge.msdk.foundation.same.report.b.a.1
                    @Override // java.util.concurrent.ThreadFactory
                    public final Thread newThread(Runnable runnable) {
                        return new Thread(runnable, "mb-common-report-thread");
                    }
                });
            }
            if (this.f44772i == null) {
                this.f44772i = com.mbridge.msdk.foundation.controller.c.m().c();
            }
            if (this.f44773j == null) {
                this.f44773j = new d();
            }
            if (this.f44780q == null) {
                if (af.a().a("metrics", "e_t_l", af.a().a("e_t_l", 1)) == 1) {
                    this.f44780q = new i();
                } else {
                    this.f44780q = new e();
                }
            }
            if (this.f44783t == null) {
                this.f44783t = new com.mbridge.msdk.foundation.same.net.b(ComConstants.AD_TIMEOUT_MILLIS, 1);
            }
            return new b(this);
        }

        public final a b(String str) {
            this.f44770g = str;
            return this;
        }

        public final a c(String str) {
            this.f44785v = str;
            return this;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass()) {
                try {
                    a aVar = (a) obj;
                    return Objects.equals(this.f44765b, aVar.f44765b) && Objects.equals(this.f44768e, aVar.f44768e);
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public final int hashCode() {
            return Objects.hash(this.f44765b, this.f44768e);
        }
    }

    /* JADX INFO: renamed from: com.mbridge.msdk.foundation.same.report.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public interface InterfaceC0492b {
        void a(b bVar);

        void a(b bVar, int i11, String str);
    }

    public b(a aVar) {
        this.f44759v = false;
        this.f44740c = aVar;
        this.f44752o = aVar.f44781r;
        this.f44753p = aVar.f44767d;
        this.f44748k = aVar.f44765b;
        this.f44746i = aVar.f44775l;
        this.f44745h = aVar.f44764a;
        this.f44749l = aVar.f44766c;
        this.f44743f = aVar.f44773j;
        this.f44751n = aVar.f44780q;
        this.f44744g = aVar.f44774k;
        this.f44747j = aVar.f44777n;
        this.f44742e = aVar.f44772i;
        this.f44739b = aVar.f44770g;
        this.f44757t = aVar.f44785v;
        this.f44750m = aVar.f44778o;
        this.f44738a = aVar.f44769f;
        this.f44754q = aVar.f44782s;
        this.f44755r = aVar.f44783t;
        this.f44741d = aVar.f44771h;
        this.f44756s = aVar.f44784u;
        this.f44759v = aVar.f44776m;
        this.f44760w = aVar.f44779p;
    }

    public static a a(String str, String str2) {
        return new a(str, str2, "", 1, 1);
    }

    public final String a() {
        return this.f44738a;
    }

    public final void a(String str) {
        this.f44758u = str;
    }

    public final String b() {
        return this.f44739b;
    }

    public final Context c() {
        return this.f44742e;
    }

    public final String d() {
        return this.f44758u;
    }

    public final long e() {
        return this.f44744g;
    }

    public final ConcurrentHashMap<String, String> f() {
        return this.f44749l;
    }

    public final String g() {
        return this.f44760w;
    }

    public final String h() {
        return this.f44752o;
    }

    public final int hashCode() {
        return this.f44740c.hashCode();
    }

    public final com.mbridge.msdk.foundation.same.net.l i() {
        return this.f44755r;
    }

    public final long j() {
        return this.f44756s;
    }

    public final String k() {
        return this.f44757t;
    }

    public final boolean l() {
        return this.f44759v;
    }

    public final boolean m() {
        return this.f44754q;
    }

    public final boolean n() {
        return this.f44747j;
    }

    public final void o() {
        final InterfaceC0492b interfaceC0492b = null;
        this.f44746i.execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.report.b.1
            @Override // java.lang.Runnable
            public final void run() {
                b bVar = this;
                if (bVar == null) {
                    ad.b("CommonReport", "reportEvent is null !!!");
                    return;
                }
                c cVar = bVar.f44743f;
                if (cVar == null) {
                    ad.b("CommonReport", "decorate is null !!!");
                    return;
                }
                n nVar = this.f44751n;
                if (nVar == null) {
                    ad.b("CommonReport", "report is null !!!");
                    return;
                }
                try {
                    com.mbridge.msdk.foundation.same.net.h.e eVarA = cVar.a(this);
                    if (eVarA != null) {
                        nVar.a(this.f44742e, interfaceC0492b, this, eVarA);
                        return;
                    }
                    if (MBridgeConstans.DEBUG) {
                        ad.b("CommonReport", "requestParams is null !!!");
                    }
                    InterfaceC0492b interfaceC0492b2 = interfaceC0492b;
                    if (interfaceC0492b2 != null) {
                        interfaceC0492b2.a(this, 0, "requestParams is null");
                    }
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        ad.a("CommonReport", "report error", e11);
                    }
                    InterfaceC0492b interfaceC0492b3 = interfaceC0492b;
                    if (interfaceC0492b3 != null) {
                        interfaceC0492b3.a(this, 0, e11.getMessage());
                    }
                }
            }
        });
    }

    public final Executor p() {
        return this.f44746i;
    }
}
