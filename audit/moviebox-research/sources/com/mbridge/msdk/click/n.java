package com.mbridge.msdk.click;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ah;
import java.net.URI;
import java.util.concurrent.Semaphore;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class n extends e implements com.mbridge.msdk.foundation.same.e.a.InterfaceC0489a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f f43198a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private JumpLoaderResult f43199b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f43201d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Context f43202e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.e.b f43203f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private com.mbridge.msdk.click.entity.a f43204g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f43200c = true;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Handler f43205h = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: source.java */
    public class a extends com.mbridge.msdk.foundation.same.e.a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Context f43210c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private String f43211d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f43212e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f43213f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private CampaignEx f43214g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f43215h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private boolean f43216i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private int f43217j;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Semaphore f43209b = new Semaphore(0);

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private m.a f43218k = new m.a() { // from class: com.mbridge.msdk.click.n.a.1
            private void a() {
                synchronized (n.this) {
                    n.this.f43199b.setSuccess(true);
                    a.a(a.this);
                }
            }

            @Override // com.mbridge.msdk.click.m.a
            public final void a(int i11, String str, String str2, String str3) {
                if (!TextUtils.isEmpty(str2)) {
                    n.this.f43199b.setExceptionMsg(str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    n.this.f43199b.setContent(str3);
                }
                a.a(a.this, str);
                a();
            }

            @Override // com.mbridge.msdk.click.m.a
            public final void a(String str, boolean z11, String str2) {
                a.a(a.this, str);
                n.this.f43199b.setContent(str2);
                a();
            }

            @Override // com.mbridge.msdk.click.m.a
            public final boolean a(String str) {
                boolean zA = a.a(a.this, str);
                if (zA) {
                    a();
                }
                return zA;
            }

            @Override // com.mbridge.msdk.click.m.a
            public final boolean b(String str) {
                boolean zA = a.a(a.this, str);
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

        public a(Context context, String str, String str2, String str3, CampaignEx campaignEx, boolean z11, boolean z12, int i11) {
            this.f43210c = context;
            this.f43211d = str;
            this.f43212e = str2;
            this.f43213f = str3;
            this.f43214g = campaignEx;
            this.f43215h = z11;
            this.f43216i = z12;
            this.f43217j = i11;
        }

        private JumpLoaderResult a(String str, boolean z11, boolean z12, CampaignEx campaignEx, int i11) {
            String scheme;
            String str2;
            String str3 = str;
            String host = "";
            if (n.this.f43201d) {
                String strA = com.mbridge.msdk.c.b.a(this.f43210c, str3);
                if (!TextUtils.isEmpty(strA)) {
                    str3 = str3 + strA;
                }
            }
            String str4 = str3;
            com.mbridge.msdk.f.b.a();
            JumpLoaderResult jumpLoaderResult = new JumpLoaderResult();
            h hVar = new h();
            try {
                if (a(str4)) {
                    str2 = "";
                } else {
                    URI uriCreate = URI.create(str4);
                    scheme = uriCreate.getScheme();
                    try {
                        host = uriCreate.getHost();
                    } catch (Exception e11) {
                        e = e11;
                        e.printStackTrace();
                    }
                    str2 = host;
                    host = scheme;
                }
            } catch (Exception e12) {
                e = e12;
                scheme = "";
            }
            String str5 = str4;
            String scheme2 = host;
            String host2 = str2;
            for (int i12 = 0; i12 < 10; i12++) {
                if (!n.this.f43200c) {
                    return null;
                }
                n.this.f43204g = hVar.a(str5, z11, z12, campaignEx);
                if (n.this.f43204g == null) {
                    jumpLoaderResult.setUrl(str5);
                    jumpLoaderResult.setSuccess(false);
                    jumpLoaderResult.setMsg("request url is invalided");
                    break;
                }
                if (!TextUtils.isEmpty(n.this.f43204g.f43128h)) {
                    jumpLoaderResult.setUrl(str5);
                    jumpLoaderResult.setExceptionMsg(n.this.f43204g.f43128h);
                    jumpLoaderResult.setType(1);
                    jumpLoaderResult.setHeader(n.this.f43204g.a());
                    jumpLoaderResult.setSuccess(false);
                    if (i12 != 0) {
                        break;
                    }
                    com.mbridge.msdk.click.a.a.a().a(str5, n.this.f43204g.f43128h, campaignEx, this.f43213f, z11, z12, i11);
                    break;
                }
                jumpLoaderResult.setSuccess(true);
                int i13 = n.this.f43204g.f43126f;
                if (i13 != 301 && i13 != 302 && i13 != 307) {
                    if (n.this.f43204g.f43126f != 200) {
                        jumpLoaderResult.setjumpDone(false);
                        jumpLoaderResult.setUrl(str5);
                        if (i12 != 0) {
                            break;
                        }
                        com.mbridge.msdk.click.a.a.a().a(str5, "error code:" + n.this.f43204g.f43126f, campaignEx, this.f43213f, z11, z12, i11);
                        break;
                    }
                    jumpLoaderResult.setjumpDone(true);
                    jumpLoaderResult.setUrl(str5);
                    jumpLoaderResult.setContent(n.this.f43204g.f43127g);
                    break;
                }
                jumpLoaderResult.setIs302Jump(true);
                if (TextUtils.isEmpty(n.this.f43204g.f43121a)) {
                    jumpLoaderResult.setjumpDone(true);
                    jumpLoaderResult.setUrl(str5);
                    break;
                }
                str5 = n.this.f43204g.f43121a;
                if (a(str5)) {
                    if (!str5.startsWith("/") || TextUtils.isEmpty(scheme2) || TextUtils.isEmpty(host2)) {
                        jumpLoaderResult.setjumpDone(true);
                        jumpLoaderResult.setUrl(str5);
                        break;
                    }
                    str5 = scheme2 + "://" + host2 + str5;
                    host2 = null;
                    scheme2 = null;
                } else if (!a(str5)) {
                    try {
                        URI uriCreate2 = URI.create(str5);
                        scheme2 = uriCreate2.getScheme();
                        host2 = uriCreate2.getHost();
                    } catch (Exception e13) {
                        e13.printStackTrace();
                    }
                }
                if (ah.a.b(str5)) {
                    jumpLoaderResult.setjumpDone(true);
                    jumpLoaderResult.setUrl(str5);
                    break;
                }
                if (n.this.f43201d) {
                    String strA2 = com.mbridge.msdk.c.b.a(this.f43210c, str5);
                    if (!TextUtils.isEmpty(strA2)) {
                        str5 = str5 + strA2;
                    }
                }
                com.mbridge.msdk.f.b.a();
            }
            return jumpLoaderResult;
        }

        public static /* synthetic */ void a(a aVar) {
            aVar.f43209b.release();
        }

        public static /* synthetic */ boolean a(a aVar, String str) {
            return o.a(str, aVar.f43214g, n.this.f43199b);
        }

        private boolean a(String str) {
            return !URLUtil.isNetworkUrl(str);
        }

        @Override // com.mbridge.msdk.foundation.same.e.a
        public final void cancelTask() {
        }

        @Override // com.mbridge.msdk.foundation.same.e.a
        public final void pauseTask(boolean z11) {
        }

        @Override // com.mbridge.msdk.foundation.same.e.a
        public final void runTask() {
            if (n.this.f43198a != null) {
                n.this.f43198a.a(null);
            }
            n.this.f43199b = new JumpLoaderResult();
            n.this.f43199b.setUrl(this.f43211d);
            n.this.f43199b = a(this.f43211d, this.f43215h, this.f43216i, this.f43214g, this.f43217j);
            if (!TextUtils.isEmpty(n.this.f43199b.getExceptionMsg())) {
                n.this.f43199b.setSuccess(true);
            }
            if (n.this.f43200c && n.this.f43199b.isSuccess()) {
                if (n.this.f43204g != null) {
                    n.this.f43199b.setStatusCode(n.this.f43204g.f43126f);
                }
                CampaignEx campaignEx = this.f43214g;
                JumpLoaderResult jumpLoaderResult = n.this.f43199b;
                com.mbridge.msdk.click.entity.a aVar = n.this.f43204g;
                String str = this.f43212e;
                String str2 = this.f43213f;
                Context context = this.f43210c;
                m.a aVar2 = this.f43218k;
                Semaphore semaphore = this.f43209b;
                if (ah.a.b(jumpLoaderResult.getUrl()) || 200 != aVar.f43126f || TextUtils.isEmpty(jumpLoaderResult.getContent()) || jumpLoaderResult.getContent().contains("EXCEPTION_CAMPAIGN_NOT_ACTIVE")) {
                    if (aVar != null) {
                        jumpLoaderResult.setType(1);
                        jumpLoaderResult.setExceptionMsg(aVar.f43128h);
                        jumpLoaderResult.setStatusCode(aVar.f43126f);
                        jumpLoaderResult.setHeader(aVar.a());
                        jumpLoaderResult.setContent(aVar.f43127g);
                    }
                    o.a(jumpLoaderResult.getUrl(), campaignEx, jumpLoaderResult);
                    return;
                }
                jumpLoaderResult.setType(2);
                if (TextUtils.isEmpty(jumpLoaderResult.getContent())) {
                    try {
                        new m().a(str, str2, context, jumpLoaderResult.getUrl(), aVar2);
                    } catch (Exception e11) {
                        if (MBridgeConstans.DEBUG) {
                            ad.b("WebViewSpiderLoaderDiff", e11.getMessage());
                        }
                    }
                } else {
                    new m().a(str, str2, context, jumpLoaderResult.getUrl(), jumpLoaderResult.getContent(), aVar2);
                }
                semaphore.acquireUninterruptibly();
            }
        }
    }

    public n(Context context) {
        this.f43202e = context;
        this.f43203f = new com.mbridge.msdk.foundation.same.e.b(context, 2);
    }

    @Override // com.mbridge.msdk.click.e
    public final void a() {
        this.f43200c = false;
    }

    @Override // com.mbridge.msdk.foundation.same.e.a.InterfaceC0489a
    public final void a(com.mbridge.msdk.foundation.same.e.a.b bVar) {
        if (bVar == com.mbridge.msdk.foundation.same.e.a.b.FINISH && this.f43200c) {
            this.f43205h.post(new Runnable() { // from class: com.mbridge.msdk.click.n.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (n.this.f43198a != null) {
                        if (n.this.f43199b.isSuccess()) {
                            n.this.f43198a.b(n.this.f43199b);
                        } else {
                            n.this.f43198a.a(n.this.f43199b, n.this.f43199b.getMsg());
                        }
                    }
                }
            });
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a(String str, f fVar, boolean z11, String str2, String str3, CampaignEx campaignEx, boolean z12, boolean z13, int i11) {
        com.mbridge.msdk.foundation.same.e.a aVar;
        this.f43198a = fVar;
        this.f43201d = z11;
        com.mbridge.msdk.click.entity.b bVar = new com.mbridge.msdk.click.entity.b();
        bVar.a(this.f43202e);
        bVar.a(str);
        bVar.c(z11);
        bVar.b(str2);
        bVar.c(str3);
        bVar.a(campaignEx);
        bVar.a(z12);
        bVar.b(z13);
        bVar.a(i11);
        if (str.startsWith("tcp")) {
            k kVar = new k(bVar);
            kVar.a(this.f43198a);
            kVar.a(new j() { // from class: com.mbridge.msdk.click.n.1
                @Override // com.mbridge.msdk.click.j
                public final void a(JumpLoaderResult jumpLoaderResult) {
                    n.this.f43199b = jumpLoaderResult;
                }
            });
            aVar = kVar;
        } else {
            aVar = new a(this.f43202e, str, str2, str3, campaignEx, z12, z13, i11);
        }
        this.f43203f.a(aVar, this);
    }
}
