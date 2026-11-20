package com.mbridge.msdk.foundation.same.net.stack;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.same.net.dns.MBDns;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.net.h.e;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.thrid.okhttp.ConnectionPool;
import com.mbridge.msdk.thrid.okhttp.Dispatcher;
import com.mbridge.msdk.thrid.okhttp.EventListener;
import com.mbridge.msdk.thrid.okhttp.OkHttpClient;
import java.io.Serializable;
import java.net.URLEncoder;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f44713a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private OkHttpClient f44714b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private g f44715c;

    /* JADX INFO: compiled from: source.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c f44720a = new c();
    }

    /* JADX INFO: compiled from: source.java */
    public static class b implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f44721a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f44722b = "";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f44723c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f44724d = "";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f44725e = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f44726f = 0;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f44727g = "";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f44728h = "";

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public String f44729i = "";

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public String f44730j = "";

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f44731k;

        public static b a(b bVar) {
            b bVar2 = new b();
            bVar2.f44731k = bVar.f44731k;
            bVar2.f44730j = bVar.f44730j;
            bVar2.f44728h = bVar.f44728h;
            bVar2.f44721a = bVar.f44721a;
            bVar2.f44723c = bVar.f44723c;
            bVar2.f44722b = bVar.f44722b;
            bVar2.f44727g = bVar.f44727g;
            bVar2.f44726f = bVar.f44726f;
            bVar2.f44729i = bVar.f44729i;
            bVar2.f44724d = bVar.f44724d;
            bVar2.f44725e = bVar.f44725e;
            return bVar2;
        }
    }

    private c() {
        this.f44713a = "";
        this.f44714b = null;
    }

    public static c a() {
        return a.f44720a;
    }

    public final void a(b bVar) {
        if (bVar == null) {
            return;
        }
        final b bVarA = b.a(bVar);
        com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.same.net.stack.c.2
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    StringBuilder sb2 = new StringBuilder("key=2000102&");
                    sb2.append("app_id=");
                    sb2.append(com.mbridge.msdk.foundation.controller.c.m().k());
                    sb2.append("&");
                    sb2.append("status=");
                    sb2.append(bVarA.f44731k);
                    sb2.append("&");
                    sb2.append("domain=");
                    sb2.append(bVarA.f44728h);
                    sb2.append("&");
                    sb2.append("method=");
                    sb2.append(bVarA.f44730j);
                    sb2.append("&");
                    if (!TextUtils.isEmpty(bVarA.f44727g)) {
                        sb2.append("dns_r=");
                        sb2.append(bVarA.f44727g);
                        sb2.append("&");
                        sb2.append("dns_d=");
                        sb2.append(bVarA.f44726f);
                        sb2.append("&");
                        sb2.append("host=");
                        sb2.append(bVarA.f44729i);
                        sb2.append("&");
                        if (TextUtils.isEmpty(bVarA.f44724d)) {
                            if (TextUtils.isEmpty(bVarA.f44722b)) {
                                sb2.append("call_d=");
                                sb2.append(bVarA.f44721a);
                                sb2.append("&");
                                sb2.append("connect_d=");
                                sb2.append(bVarA.f44723c);
                                sb2.append("&");
                                sb2.append("connection_d=");
                                sb2.append(bVarA.f44725e);
                            } else {
                                sb2.append("connect_d=");
                                sb2.append(bVarA.f44723c);
                                sb2.append("&");
                                sb2.append("connection_e=");
                                sb2.append(bVarA.f44722b);
                            }
                        } else if (!TextUtils.isEmpty(bVarA.f44724d)) {
                            sb2.append("connect_e=");
                            sb2.append(bVarA.f44724d);
                        } else if (!TextUtils.isEmpty(bVarA.f44722b)) {
                            sb2.append("connect_e=");
                            sb2.append(bVarA.f44722b);
                        }
                    } else if (!TextUtils.isEmpty(bVarA.f44722b)) {
                        sb2.append("connect_e=");
                        sb2.append(bVarA.f44722b);
                    } else if (!TextUtils.isEmpty(bVarA.f44724d)) {
                        sb2.append("connect_e=");
                        sb2.append(bVarA.f44724d);
                    }
                    if (j.a().b()) {
                        j.a().a(sb2.toString());
                        return;
                    }
                    final c cVar = c.this;
                    String string = sb2.toString();
                    Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                    com.mbridge.msdk.foundation.same.report.e.a aVar = new com.mbridge.msdk.foundation.same.report.e.a(contextC);
                    e eVarA = q.a(contextC);
                    eVarA.a("data", URLEncoder.encode(string, "utf-8"));
                    eVarA.a("m_sdk", "msdk");
                    aVar.post(0, d.f().f44626c, eVarA, new com.mbridge.msdk.foundation.same.report.e.b() { // from class: com.mbridge.msdk.foundation.same.net.stack.c.3
                        @Override // com.mbridge.msdk.foundation.same.report.e.b
                        public final void onFailed(String str) {
                            ad.a("OKHTTPClientManager", "report failed");
                        }

                        @Override // com.mbridge.msdk.foundation.same.report.e.b
                        public final void onSuccess(String str) {
                            ad.a("OKHTTPClientManager", "report success");
                        }
                    });
                } catch (Exception e11) {
                    ad.b("OKHTTPClientManager", e11.getMessage());
                }
            }
        });
    }

    public final boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (this.f44715c == null) {
                this.f44715c = h.a().a(com.mbridge.msdk.foundation.controller.c.m().k());
            }
            g gVar = this.f44715c;
            if (gVar == null) {
                return false;
            }
            String strH = gVar.H();
            String str2 = d.f().f44626c;
            if (TextUtils.isEmpty(strH) || !str.startsWith(strH) || TextUtils.equals(strH, str2)) {
                return false;
            }
            this.f44713a = strH;
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public final synchronized OkHttpClient b() {
        try {
            if (this.f44714b == null) {
                Dispatcher dispatcher = new Dispatcher();
                dispatcher.setMaxRequestsPerHost(50);
                dispatcher.setMaxRequests(256);
                OkHttpClient.Builder builder = new OkHttpClient.Builder();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                builder.readTimeout(100L, timeUnit);
                builder.connectTimeout(60L, timeUnit);
                builder.writeTimeout(60L, timeUnit);
                builder.connectionPool(new ConnectionPool(32, 5L, TimeUnit.MINUTES));
                builder.dispatcher(dispatcher);
                builder.eventListener(new EventListener() { // from class: com.mbridge.msdk.foundation.same.net.stack.c.1
                });
                builder.dns(new MBDns());
                this.f44714b = builder.build();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f44714b;
    }

    public final b c() {
        b bVar = new b();
        bVar.f44728h = this.f44713a;
        return bVar;
    }
}
