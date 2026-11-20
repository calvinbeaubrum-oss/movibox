package com.mbridge.msdk.click;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpHost;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ah;
import java.net.URI;
import java.util.concurrent.Semaphore;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class k extends com.mbridge.msdk.foundation.same.e.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f43149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f43150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f43151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f43152e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private CampaignEx f43153f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f43154g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f43155h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f43156i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f43157j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private com.mbridge.msdk.click.entity.a f43158k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private JumpLoaderResult f43159l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private f f43160m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private j f43161n;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Semaphore f43148a = new Semaphore(0);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final m.a f43162o = new m.a() { // from class: com.mbridge.msdk.click.k.1
        private void a() {
            synchronized (this) {
                try {
                    k.this.f43159l.setSuccess(true);
                    if (k.this.f43161n != null) {
                        k.this.f43161n.a(k.this.f43159l);
                    }
                    k.c(k.this);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }

        @Override // com.mbridge.msdk.click.m.a
        public final void a(int i11, String str, String str2, String str3) {
            if (!TextUtils.isEmpty(str2)) {
                k.this.f43159l.setExceptionMsg(str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                k.this.f43159l.setContent(str3);
            }
            k.a(k.this, str);
            a();
        }

        @Override // com.mbridge.msdk.click.m.a
        public final void a(String str, boolean z11, String str2) {
            k.a(k.this, str);
            k.this.f43159l.setContent(str2);
            a();
        }

        @Override // com.mbridge.msdk.click.m.a
        public final boolean a(String str) {
            boolean zA = k.a(k.this, str);
            if (zA) {
                a();
            }
            return zA;
        }

        @Override // com.mbridge.msdk.click.m.a
        public final boolean b(String str) {
            boolean zA = k.a(k.this, str);
            if (zA) {
                a();
            }
            return zA;
        }

        @Override // com.mbridge.msdk.click.m.a
        public final boolean c(String str) {
            return false;
        }
    };

    public k(com.mbridge.msdk.click.entity.b bVar) {
        this.f43149b = bVar.a();
        this.f43150c = bVar.b();
        this.f43151d = bVar.c();
        this.f43152e = bVar.d();
        this.f43153f = bVar.e();
        this.f43154g = bVar.f();
        this.f43155h = bVar.g();
        this.f43156i = bVar.i();
        this.f43157j = bVar.h();
    }

    /* JADX WARN: Code duplicated, block: B:66:0x0162 A[LOOP:0: B:16:0x003d->B:66:0x0162, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:72:0x015b A[SYNTHETIC] */
    private JumpLoaderResult a(String str) {
        String scheme;
        String str2;
        int i11;
        String strB = b(str);
        JumpLoaderResult jumpLoaderResult = new JumpLoaderResult();
        l lVar = new l();
        h hVar = new h();
        String host = "";
        try {
            if (URLUtil.isNetworkUrl(strB)) {
                URI uriCreate = URI.create(strB);
                scheme = uriCreate.getScheme();
                try {
                    host = uriCreate.getHost();
                } catch (Exception e11) {
                    e = e11;
                    ad.b("SocketRequestTask", e.getMessage());
                }
                str2 = host;
                host = scheme;
            } else {
                str2 = "";
            }
        } catch (Exception e12) {
            e = e12;
            scheme = "";
        }
        String strB2 = strB;
        for (int i12 = 0; i12 < 10; i12++) {
            if (this.mState != com.mbridge.msdk.foundation.same.e.a.b.RUNNING) {
                return null;
            }
            if (strB2.startsWith("tcp")) {
                this.f43158k = lVar.a(strB2, this.f43153f, this.f43154g, this.f43155h);
                i11 = 3;
            } else {
                this.f43158k = hVar.a(strB2, this.f43154g, this.f43155h, this.f43153f);
                i11 = 1;
            }
            com.mbridge.msdk.click.entity.a aVar = this.f43158k;
            if (aVar == null) {
                jumpLoaderResult.setUrl(strB2);
                jumpLoaderResult.setSuccess(false);
                break;
            }
            if (!TextUtils.isEmpty(aVar.f43128h)) {
                jumpLoaderResult.setUrl(strB2);
                jumpLoaderResult.setExceptionMsg(this.f43158k.f43128h);
                jumpLoaderResult.setType(i11);
                jumpLoaderResult.setHeader(this.f43158k.a());
                jumpLoaderResult.setSuccess(false);
                if (i12 != 0) {
                    break;
                }
                com.mbridge.msdk.click.a.a.a().a(strB2, this.f43158k.f43128h, this.f43153f, this.f43152e, this.f43154g, this.f43155h, this.f43156i);
                break;
            }
            int i13 = this.f43158k.f43126f;
            if (i13 == 200) {
                jumpLoaderResult.setjumpDone(true);
                jumpLoaderResult.setUrl(strB2);
                jumpLoaderResult.setSuccess(true);
                String str3 = this.f43158k.f43127g;
                jumpLoaderResult.setContent(str3 != null ? str3 : null);
                break;
            }
            if (i13 != 301 && i13 != 302 && i13 != 307) {
                jumpLoaderResult.setjumpDone(false);
                jumpLoaderResult.setUrl(strB2);
                if (i12 != 0) {
                    break;
                }
                com.mbridge.msdk.click.a.a.a().a(strB2, this.f43158k.f43128h, this.f43153f, this.f43152e, this.f43154g, this.f43155h, this.f43156i);
                break;
            }
            jumpLoaderResult.setSuccess(true);
            jumpLoaderResult.setIs302Jump(true);
            if (TextUtils.isEmpty(this.f43158k.f43121a)) {
                jumpLoaderResult.setjumpDone(true);
                jumpLoaderResult.setUrl(strB2);
                break;
            }
            String str4 = this.f43158k.f43121a;
            if (str4.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                if (ah.a.b(str4)) {
                    jumpLoaderResult.setjumpDone(true);
                    jumpLoaderResult.setUrl(str4);
                    break;
                }
                strB2 = b(str4);
            } else {
                if (!str4.startsWith("/") || TextUtils.isEmpty(host) || TextUtils.isEmpty(str2)) {
                    jumpLoaderResult.setjumpDone(true);
                    jumpLoaderResult.setUrl(str4);
                    break;
                }
                str4 = host + "://" + str2 + str4;
                host = null;
                str2 = null;
                if (ah.a.b(str4)) {
                    jumpLoaderResult.setjumpDone(true);
                    jumpLoaderResult.setUrl(str4);
                    break;
                }
                strB2 = b(str4);
            }
        }
        return jumpLoaderResult;
    }

    public static /* synthetic */ boolean a(k kVar, String str) {
        CampaignEx campaignEx = kVar.f43153f;
        JumpLoaderResult jumpLoaderResult = kVar.f43159l;
        if (!ah.a.b(jumpLoaderResult.getUrl())) {
            jumpLoaderResult.setCode(2);
            jumpLoaderResult.setUrl(str);
            return false;
        }
        jumpLoaderResult.setCode(1);
        jumpLoaderResult.setUrl(str);
        jumpLoaderResult.setjumpDone(true);
        return true;
    }

    private String b(String str) {
        if (this.f43157j) {
            String strA = com.mbridge.msdk.c.b.a(this.f43149b, str);
            if (!TextUtils.isEmpty(strA)) {
                str = str + strA;
            }
        }
        com.mbridge.msdk.f.b.a();
        return str;
    }

    public static /* synthetic */ void c(k kVar) {
        kVar.f43148a.release();
    }

    public final void a(f fVar) {
        this.f43160m = fVar;
    }

    public final void a(j jVar) {
        this.f43161n = jVar;
    }

    @Override // com.mbridge.msdk.foundation.same.e.a
    public final void cancelTask() {
    }

    @Override // com.mbridge.msdk.foundation.same.e.a
    public final void pauseTask(boolean z11) {
    }

    @Override // com.mbridge.msdk.foundation.same.e.a
    public final void runTask() {
        f fVar = this.f43160m;
        if (fVar != null) {
            fVar.a(null);
        }
        JumpLoaderResult jumpLoaderResult = new JumpLoaderResult();
        this.f43159l = jumpLoaderResult;
        jumpLoaderResult.setUrl(this.f43150c);
        JumpLoaderResult jumpLoaderResultA = a(this.f43150c);
        this.f43159l = jumpLoaderResultA;
        if (!TextUtils.isEmpty(jumpLoaderResultA.getExceptionMsg())) {
            this.f43159l.setSuccess(true);
        }
        if (this.mState != com.mbridge.msdk.foundation.same.e.a.b.RUNNING) {
            j jVar = this.f43161n;
            if (jVar != null) {
                jVar.a(this.f43159l);
                return;
            }
            return;
        }
        if (!this.f43159l.isSuccess()) {
            j jVar2 = this.f43161n;
            if (jVar2 != null) {
                jVar2.a(this.f43159l);
                return;
            }
            return;
        }
        com.mbridge.msdk.click.entity.a aVar = this.f43158k;
        if (aVar != null) {
            this.f43159l.setStatusCode(aVar.f43126f);
        }
        JumpLoaderResult jumpLoaderResult2 = this.f43159l;
        com.mbridge.msdk.click.entity.a aVar2 = this.f43158k;
        String str = this.f43151d;
        String str2 = this.f43152e;
        Context context = this.f43149b;
        m.a aVar3 = this.f43162o;
        j jVar3 = this.f43161n;
        Semaphore semaphore = this.f43148a;
        if (!ah.a.b(jumpLoaderResult2.getUrl()) && 200 == aVar2.f43126f && !TextUtils.isEmpty(jumpLoaderResult2.getContent()) && !jumpLoaderResult2.getContent().contains("EXCEPTION_CAMPAIGN_NOT_ACTIVE")) {
            jumpLoaderResult2.setType(2);
            if (TextUtils.isEmpty(jumpLoaderResult2.getContent())) {
                try {
                    new m().a(str, str2, context, jumpLoaderResult2.getUrl(), aVar3);
                } catch (Exception unused) {
                    if (MBridgeConstans.DEBUG) {
                        ad.b("TAG", "webview spider start error");
                    }
                }
            } else {
                new m().a(str, str2, context, jumpLoaderResult2.getUrl(), jumpLoaderResult2.getContent(), aVar3);
            }
            semaphore.acquireUninterruptibly();
            return;
        }
        if (aVar2 != null) {
            jumpLoaderResult2.setType(1);
            jumpLoaderResult2.setExceptionMsg(aVar2.f43128h);
            jumpLoaderResult2.setStatusCode(aVar2.f43126f);
            jumpLoaderResult2.setHeader(aVar2.a());
            jumpLoaderResult2.setContent(aVar2.f43127g);
        }
        String url = jumpLoaderResult2.getUrl();
        if (ah.a.b(url)) {
            jumpLoaderResult2.setCode(1);
            jumpLoaderResult2.setUrl(url);
            jumpLoaderResult2.setjumpDone(true);
        } else {
            jumpLoaderResult2.setCode(2);
            jumpLoaderResult2.setUrl(url);
        }
        if (jVar3 != null) {
            jVar3.a(jumpLoaderResult2);
        }
    }
}
