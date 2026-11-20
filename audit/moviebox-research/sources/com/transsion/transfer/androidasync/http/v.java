package com.transsion.transfer.androidasync.http;

import android.text.TextUtils;
import com.alibaba.sdk.android.oss.common.utils.HttpHeaders;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.IOException;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class v extends c0 {

    /* JADX INFO: compiled from: source.java */
    public class a implements fy.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ fy.a f58840a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.transsion.transfer.androidasync.p f58841b;

        public a(fy.a aVar, com.transsion.transfer.androidasync.p pVar) {
            this.f58840a = aVar;
            this.f58841b = pVar;
        }

        @Override // fy.a
        public void i(Exception exc) {
            com.transsion.transfer.androidasync.c0.b(this.f58840a, exc);
            com.transsion.transfer.androidasync.p pVar = this.f58841b;
            if (pVar != null) {
                pVar.g(false);
                this.f58841b.n(0);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements com.transsion.transfer.androidasync.x.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Headers f58843a = new Headers();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f58844b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ g.c f58845c;

        public b(g.c cVar) {
            this.f58845c = cVar;
        }

        @Override // com.transsion.transfer.androidasync.x.a
        public void a(String str) {
            try {
                String strTrim = str.trim();
                if (this.f58844b == null) {
                    this.f58844b = strTrim;
                    return;
                }
                if (!TextUtils.isEmpty(strTrim)) {
                    this.f58843a.b(strTrim);
                    return;
                }
                String[] strArrSplit = this.f58844b.split(" ", 3);
                if (strArrSplit.length < 2) {
                    throw new Exception(new IOException("Not HTTP"));
                }
                this.f58845c.f58665g.v(this.f58843a);
                String str2 = strArrSplit[0];
                this.f58845c.f58665g.l(str2);
                this.f58845c.f58665g.d(Integer.parseInt(strArrSplit[1]));
                this.f58845c.f58665g.r(strArrSplit.length == 3 ? strArrSplit[2] : "");
                this.f58845c.f58667i.i(null);
                com.transsion.transfer.androidasync.l lVarSocket = this.f58845c.f58665g.socket();
                if (lVarSocket == null) {
                    return;
                }
                com.transsion.transfer.androidasync.r rVarC = (this.f58845c.f58669b.q() && !v.i(this.f58845c.f58665g.b())) ? HttpUtil.c(lVarSocket, Protocol.get(str2), this.f58843a, false) : HttpUtil.EndEmitter.O(lVarSocket.a(), null);
                this.f58845c.f58665g.n(rVarC);
            } catch (Exception e11) {
                this.f58845c.f58667i.i(e11);
            }
        }
    }

    public static boolean i(int i11) {
        return (i11 >= 100 && i11 <= 199) || i11 == 204 || i11 == 304;
    }

    @Override // com.transsion.transfer.androidasync.http.c0, com.transsion.transfer.androidasync.http.g
    public void c(g.f fVar) {
        Protocol protocol = Protocol.get(fVar.f58662e);
        if ((protocol == null || protocol == Protocol.HTTP_1_0 || protocol == Protocol.HTTP_1_1) && (fVar.f58665g.F() instanceof iy.a)) {
            fVar.f58665g.F().f();
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
    @Override // com.transsion.transfer.androidasync.http.c0, com.transsion.transfer.androidasync.http.g
    public boolean f(g.c cVar) {
        com.transsion.transfer.androidasync.p pVar;
        com.transsion.transfer.androidasync.u uVar;
        Protocol protocol = Protocol.get(cVar.f58662e);
        if (protocol != null && protocol != Protocol.HTTP_1_0 && protocol != Protocol.HTTP_1_1) {
            return super.f(cVar);
        }
        j jVar = cVar.f58669b;
        gy.a aVarE = jVar.e();
        if (aVarE != null) {
            if (aVarE.length() >= 0) {
                jVar.h().f(HttpHeaders.CONTENT_LENGTH, String.valueOf(aVarE.length()));
                cVar.f58665g.h(cVar.f58664f);
            } else if (CampaignEx.JSON_NATIVE_VIDEO_CLOSE.equals(jVar.h().c("Connection"))) {
                cVar.f58665g.h(cVar.f58664f);
            } else {
                jVar.h().f("Transfer-Encoding", "Chunked");
                cVar.f58665g.h(new iy.a(cVar.f58664f));
            }
        }
        String strG = jVar.h().g(jVar.n().toString());
        byte[] bytes = strG.getBytes();
        if (aVarE == null || aVarE.length() < 0 || aVarE.length() + bytes.length >= 1024) {
            pVar = null;
            uVar = cVar.f58664f;
        } else {
            com.transsion.transfer.androidasync.p pVar2 = new com.transsion.transfer.androidasync.p(cVar.f58665g.F());
            pVar2.g(true);
            cVar.f58665g.h(pVar2);
            pVar = pVar2;
            uVar = pVar2;
        }
        jVar.u("\n" + strG);
        com.transsion.transfer.androidasync.c0.h(uVar, bytes, new a(cVar.f58666h, pVar));
        b bVar = new b(cVar);
        com.transsion.transfer.androidasync.x xVar = new com.transsion.transfer.androidasync.x();
        cVar.f58664f.o(xVar);
        xVar.a(bVar);
        return true;
    }
}
