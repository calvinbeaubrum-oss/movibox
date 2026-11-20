package com.applovin.impl;

import android.text.TextUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinErrorCodes;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class dn extends yl implements d4.e {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final com.applovin.impl.sdk.network.a f18473h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final d4.e f18474i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private tm.b f18475j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private sj f18476k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private sj f18477l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    protected d4.b f18478m;

    /* JADX INFO: compiled from: source.java */
    public class a implements d4.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.applovin.impl.sdk.j f18479a;

        public a(com.applovin.impl.sdk.j jVar) {
            this.f18479a = jVar;
        }

        @Override // com.applovin.impl.d4.e
        public void a(String str, int i11, String str2, Object obj) {
            long millis;
            boolean z11 = false;
            boolean z12 = i11 < 200 || i11 >= 500;
            boolean z13 = i11 == 429;
            boolean z14 = i11 != -1009 || dn.this.f18473h.q();
            boolean z15 = (i11 == -900 || i11 == -1000) ? false : true;
            if (!z14 || !z15 || (!z12 && !z13 && !dn.this.f18473h.p())) {
                dn dnVar = dn.this;
                dnVar.a(dnVar.f18473h.f(), i11, str2, obj);
                return;
            }
            String strA = dn.this.f18473h.a();
            if (dn.this.f18473h.j() <= 0) {
                if (strA == null || !strA.equals(dn.this.f18473h.f())) {
                    dn dnVar2 = dn.this;
                    dnVar2.a(dnVar2.f18476k);
                } else {
                    dn dnVar3 = dn.this;
                    dnVar3.a(dnVar3.f18477l);
                }
                dn dnVar4 = dn.this;
                dnVar4.a(dnVar4.f18473h.f(), i11, str2, obj);
                return;
            }
            com.applovin.impl.sdk.n nVar = dn.this.f24691c;
            if (com.applovin.impl.sdk.n.a()) {
                dn dnVar5 = dn.this;
                dnVar5.f24691c.k(dnVar5.f24690b, "Unable to send request due to server failure (code " + i11 + "). " + dn.this.f18473h.j() + " attempts left, retrying in " + TimeUnit.MILLISECONDS.toSeconds(dn.this.f18473h.k()) + " seconds...");
            }
            int iJ = dn.this.f18473h.j() - 1;
            dn.this.f18473h.a(iJ);
            if ((((Boolean) this.f18479a.a(sj.f23100y)).booleanValue() && dn.this.f18473h.f().endsWith("4.0/ad")) || iJ == 0) {
                dn dnVar6 = dn.this;
                dnVar6.a(dnVar6.f18476k);
                if (StringUtils.isValidString(strA) && strA.length() >= 4) {
                    com.applovin.impl.sdk.n nVar2 = dn.this.f24691c;
                    if (com.applovin.impl.sdk.n.a()) {
                        dn dnVar7 = dn.this;
                        dnVar7.f24691c.d(dnVar7.f24690b, "Switching to backup endpoint " + strA);
                    }
                    dn.this.f18473h.a(strA);
                    z11 = true;
                }
            }
            if (((Boolean) this.f18479a.a(sj.f23048r3)).booleanValue() && z11) {
                millis = 0;
            } else {
                millis = dn.this.f18473h.n() ? TimeUnit.SECONDS.toMillis((long) Math.pow(2.0d, dn.this.f18473h.c())) : dn.this.f18473h.k();
            }
            tm tmVarJ0 = this.f18479a.j0();
            dn dnVar8 = dn.this;
            tmVarJ0.a(dnVar8, dnVar8.f18475j, millis);
        }

        @Override // com.applovin.impl.d4.e
        public void a(String str, Object obj, int i11) {
            dn.this.f18473h.a(0);
            dn.this.a(str, obj, i11);
        }
    }

    public dn(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar) {
        this(aVar, jVar, false);
    }

    public dn(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.j jVar, boolean z11) {
        super("TaskRepeatRequest", jVar, z11);
        this.f18475j = tm.b.OTHER;
        this.f18476k = null;
        this.f18477l = null;
        if (aVar == null) {
            throw new IllegalArgumentException("No request specified");
        }
        a(aVar.f());
        this.f18473h = aVar;
        this.f18478m = new d4.b();
        this.f18474i = new a(jVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(sj sjVar) {
        if (sjVar != null) {
            b().h0().a(sjVar, sjVar.a());
        }
    }

    public void a(tm.b bVar) {
        this.f18475j = bVar;
    }

    @Override // com.applovin.impl.d4.e
    public abstract void a(String str, int i11, String str2, Object obj);

    @Override // com.applovin.impl.d4.e
    public abstract void a(String str, Object obj, int i11);

    public void b(sj sjVar) {
        this.f18477l = sjVar;
    }

    public void c(sj sjVar) {
        this.f18476k = sjVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d4 d4VarS = b().s();
        if (!b().x0() && !b().u0()) {
            com.applovin.impl.sdk.n.h("AppLovinSdk", "AppLovin SDK is disabled");
            a(this.f18473h.f(), -22, null, null);
        } else if (!StringUtils.isValidString(this.f18473h.f()) || this.f18473h.f().length() < 4) {
            if (com.applovin.impl.sdk.n.a()) {
                this.f24691c.b(this.f24690b, "Task has an invalid or null request endpoint.");
            }
            a(this.f18473h.f(), AppLovinErrorCodes.INVALID_URL, null, null);
        } else {
            if (TextUtils.isEmpty(this.f18473h.h())) {
                this.f18473h.b(this.f18473h.b() != null ? "POST" : "GET");
            }
            d4VarS.a(this.f18473h, this.f18478m, this.f18474i);
        }
    }
}
