package com.transsion.transfer.androidasync.http.server;

import android.text.TextUtils;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.transsion.transfer.androidasync.http.d0;
import com.transsion.transfer.androidasync.http.h0;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.jar.Manifest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class n implements s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Hashtable<String, String> f58796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Hashtable<String, com.transsion.transfer.androidasync.future.f<Manifest>> f58797d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<c> f58798a = new ArrayList<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f58799b = new b();

    /* JADX INFO: compiled from: source.java */
    public abstract class a extends com.transsion.transfer.androidasync.http.server.c {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public Matcher f58800o;

        public a() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements r, s {
        public b() {
        }

        @Override // com.transsion.transfer.androidasync.http.server.s
        public d a(String str, String str2) {
            return n.this.a(str, str2);
        }

        @Override // com.transsion.transfer.androidasync.http.server.r
        public void b(com.transsion.transfer.androidasync.http.server.b bVar, com.transsion.transfer.androidasync.http.server.d dVar) {
            d dVarA = a(bVar.getMethod(), bVar.getPath());
            if (dVarA != null) {
                dVarA.f58809d.b(bVar, dVar);
            } else {
                dVar.d(404);
                dVar.f();
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f58803a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Pattern f58804b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public r f58805c;

        public c() {
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f58806a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f58807b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Matcher f58808c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final r f58809d;

        public d(String str, String str2, Matcher matcher, r rVar, com.transsion.transfer.androidasync.http.server.a aVar) {
            this.f58806a = str;
            this.f58807b = str2;
            this.f58808c = matcher;
            this.f58809d = rVar;
        }
    }

    static {
        Hashtable<String, String> hashtable = new Hashtable<>();
        f58796c = hashtable;
        hashtable.put("js", "application/javascript");
        f58796c.put("json", "application/json");
        f58796c.put("png", "image/png");
        f58796c.put("jpg", "image/jpeg");
        f58796c.put("jpeg", "image/jpeg");
        f58796c.put("html", "text/html");
        f58796c.put("css", "text/css");
        f58796c.put("mp4", MimeTypes.VIDEO_MP4);
        f58796c.put("mov", "video/quicktime");
        f58796c.put("wmv", "video/x-ms-wmv");
        f58796c.put("txt", "text/plain");
        f58797d = new Hashtable<>();
    }

    public static d0 e(String str, com.transsion.transfer.androidasync.http.server.b bVar, com.transsion.transfer.androidasync.http.server.d dVar) {
        String strC = bVar.getHeaders().c("Connection");
        boolean z11 = false;
        if (strC != null) {
            for (String str2 : strC.split(",")) {
                if ("Upgrade".equalsIgnoreCase(str2.trim())) {
                    z11 = true;
                    break;
                }
            }
        }
        if ("websocket".equalsIgnoreCase(bVar.getHeaders().c("Upgrade")) && z11 && TextUtils.equals(str, bVar.getHeaders().c("Sec-WebSocket-Protocol"))) {
            return new h0(bVar, dVar);
        }
        return null;
    }

    public static String g(String str) {
        int iLastIndexOf = str.lastIndexOf(InstructionFileId.DOT);
        if (iLastIndexOf == -1) {
            return null;
        }
        String str2 = f58796c.get(str.substring(iLastIndexOf + 1));
        if (str2 != null) {
            return str2;
        }
        return null;
    }

    public static /* synthetic */ void h(String str, AsyncHttpServer.a aVar, com.transsion.transfer.androidasync.http.server.b bVar, com.transsion.transfer.androidasync.http.server.d dVar) {
        d0 d0VarE = e(str, bVar, dVar);
        if (d0VarE != null) {
            aVar.a(d0VarE, bVar);
        } else {
            dVar.d(404);
            dVar.f();
        }
    }

    @Override // com.transsion.transfer.androidasync.http.server.s
    public d a(String str, String str2) {
        synchronized (this.f58798a) {
            try {
                for (c cVar : this.f58798a) {
                    if (TextUtils.equals(str, cVar.f58803a) || cVar.f58803a == null) {
                        Matcher matcher = cVar.f58804b.matcher(str2);
                        if (matcher.matches()) {
                            r rVar = cVar.f58805c;
                            if (!(rVar instanceof s)) {
                                return new d(str, str2, matcher, rVar, null);
                            }
                            return ((s) cVar.f58805c).a(str, matcher.group(1));
                        }
                    }
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void c(String str, String str2, r rVar) {
        d(str, str2, rVar, null);
    }

    public void d(String str, String str2, r rVar, com.transsion.transfer.androidasync.http.server.a aVar) {
        c cVar = new c();
        cVar.f58804b = Pattern.compile("^" + str2);
        cVar.f58805c = rVar;
        cVar.f58803a = str;
        synchronized (this.f58798a) {
            this.f58798a.add(cVar);
        }
    }

    public void f(String str, r rVar) {
        c("GET", str, rVar);
    }

    public void i(String str, r rVar) {
        c("POST", str, rVar);
    }

    public void j(String str, final String str2, final AsyncHttpServer.a aVar) {
        f(str, new r() { // from class: com.transsion.transfer.androidasync.http.server.l
            @Override // com.transsion.transfer.androidasync.http.server.r
            public final void b(b bVar, d dVar) {
                n.h(str2, aVar, bVar, dVar);
            }
        });
    }
}
