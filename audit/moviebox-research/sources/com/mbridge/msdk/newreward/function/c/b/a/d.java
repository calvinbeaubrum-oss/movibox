package com.mbridge.msdk.newreward.function.c.b.a;

import android.text.TextUtils;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import com.mbridge.msdk.newreward.function.common.MBridgeOffsetManager;
import com.mbridge.msdk.newreward.function.d.c.n;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements com.mbridge.msdk.newreward.a.c.a.InterfaceC0504a, com.mbridge.msdk.newreward.function.c.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.mbridge.msdk.newreward.function.c.a.a f46172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    com.mbridge.msdk.newreward.a.b.b f46173b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    com.mbridge.msdk.newreward.function.c.c f46174c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    com.mbridge.msdk.newreward.a.e f46175d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    com.mbridge.msdk.newreward.function.c.b.b.c f46176e;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Map f46180i;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f46177f = UUID.randomUUID().toString();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private String f46178g = UUID.randomUUID().toString();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f46179h = 10000;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private volatile boolean f46181j = false;

    /* JADX INFO: compiled from: source.java */
    public final class a implements com.mbridge.msdk.newreward.a.b.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.mbridge.msdk.newreward.function.c.b f46183b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Map f46184c;

        public a(com.mbridge.msdk.newreward.function.c.b bVar, Map map) {
            this.f46183b = bVar;
            this.f46184c = map;
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.mbridge.msdk.newreward.a.b.b
        public final void a(com.mbridge.msdk.foundation.c.b bVar) {
            d dVar = d.this;
            int i11 = 1;
            com.mbridge.msdk.newreward.function.c.b.b.e eVar = new com.mbridge.msdk.newreward.function.c.b.b.e(bVar, dVar.f46175d, dVar.f46174c, 1);
            if (d.this.f46176e.a(eVar)) {
                d.this.f46176e.a(eVar, this);
                return;
            }
            if (d.this.f46181j) {
                return;
            }
            d.this.f46181j = true;
            com.mbridge.msdk.newreward.a.c.a.a().a(d.this.f46178g);
            com.mbridge.msdk.newreward.a.c.a.a().a(d.this.f46177f);
            try {
                d dVar2 = d.this;
                com.mbridge.msdk.newreward.function.c.c cVar = dVar2.f46174c;
                com.mbridge.msdk.newreward.a.e eVar2 = dVar2.f46175d;
                com.mbridge.msdk.newreward.function.c.e eVar3 = com.mbridge.msdk.newreward.function.c.e.REPORT_LOAD_V3_RES_FAIL;
                Object[] objArr = new Object[14];
                objArr[0] = "auto_load";
                objArr[1] = Integer.valueOf(eVar2.z() ? 2 : 1);
                objArr[2] = "result";
                if (!bVar.m()) {
                    i11 = 2;
                }
                objArr[3] = Integer.valueOf(i11);
                objArr[4] = TrackingKey.CODE;
                objArr[5] = Integer.valueOf(bVar.i());
                objArr[6] = "reason";
                objArr[7] = bVar.b();
                objArr[8] = "timeout";
                objArr[9] = Integer.valueOf(d.this.f46175d.G());
                objArr[10] = "hst";
                objArr[11] = bVar.j();
                objArr[12] = "err_desc";
                objArr[13] = bVar.l();
                cVar.a(eVar2, eVar3, cVar.a(objArr));
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            ((MBridgeOffsetManager) d.this.f46174c.a((Object) null, com.mbridge.msdk.newreward.function.c.e.CREATE_OFFSET)).resetOffset();
            if (bVar != null) {
                try {
                    if (bVar.a("campaign_request_error_type") != null) {
                        com.mbridge.msdk.newreward.function.e.c.a().b().a(d.this.f46175d.n(), d.this.f46175d.u(), d.this.f46175d.y(), d.this.f46175d.x(), ((Integer) bVar.a("campaign_request_error_type")).intValue());
                    }
                } catch (Exception unused) {
                }
            }
            d.this.f46173b.a(bVar);
        }

        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // com.mbridge.msdk.newreward.a.b.b
        public final void a(Object obj) {
            com.mbridge.msdk.foundation.c.b bVarA;
            if (d.this.f46181j) {
                return;
            }
            d.this.f46181j = true;
            com.mbridge.msdk.newreward.a.c.a.a().a(d.this.f46178g);
            com.mbridge.msdk.newreward.function.d.a.b bVar = (com.mbridge.msdk.newreward.function.d.a.b) obj;
            d dVar = d.this;
            com.mbridge.msdk.newreward.function.c.c cVar = dVar.f46174c;
            com.mbridge.msdk.newreward.a.e eVar = dVar.f46175d;
            com.mbridge.msdk.newreward.function.c.e eVar2 = com.mbridge.msdk.newreward.function.c.e.REPORT_LOAD_V3_RES_SUCCESS;
            Object[] objArr = new Object[12];
            objArr[0] = "metrics_data";
            objArr[1] = bVar;
            objArr[2] = "auto_load";
            objArr[3] = Integer.valueOf(eVar.z() ? 2 : 1);
            objArr[4] = "result";
            objArr[5] = 1;
            objArr[6] = "cache";
            objArr[7] = 2;
            objArr[8] = "timeout";
            objArr[9] = Integer.valueOf(d.this.f46175d.G());
            objArr[10] = "hst";
            objArr[11] = bVar != null ? bVar.H() : "";
            cVar.a(eVar, eVar2, cVar.a(objArr));
            d dVar2 = d.this;
            dVar2.f46173b.a(dVar2.f46174c.a("type", 1, "object", bVar));
            ((MBridgeOffsetManager) d.this.f46174c.a((Object) null, com.mbridge.msdk.newreward.function.c.e.CREATE_OFFSET)).increaseOffset(bVar.s().size());
            d dVar3 = d.this;
            com.mbridge.msdk.newreward.function.c.c cVar2 = dVar3.f46174c;
            cVar2.d(cVar2.a("adapter_model", dVar3.f46175d, "campaign", bVar));
            try {
                d dVar4 = d.this;
                com.mbridge.msdk.newreward.function.c.c cVar3 = dVar4.f46174c;
                cVar3.c(cVar3.a("adapter_model", dVar4.f46175d, "campaign", bVar));
                this.f46183b.a(com.mbridge.msdk.newreward.function.c.e.REQ_DOWN_CAMPAIGN);
                this.f46184c.put("campaign", bVar);
                this.f46183b.a(this.f46184c);
                d dVar5 = d.this;
                dVar5.f46172a.a(this.f46183b, new b());
            } catch (MBridgeError e11) {
                com.mbridge.msdk.newreward.a.c.a.a().a(d.this.f46177f);
                com.mbridge.msdk.newreward.function.e.c.a().b().a(bVar.a(), bVar.b(), bVar.c(), bVar.e(), 403);
                if (e11.getErrorMessage().contains("APP ALREADY INSTALLED")) {
                    bVarA = com.mbridge.msdk.foundation.c.a.a(e11.getErrorCode(), 880021, "errorCode: 3507 errorMessage: data load failed, errorMsg is " + e11.getErrorMessage());
                } else {
                    bVarA = com.mbridge.msdk.foundation.c.a.a(e11.getErrorCode(), 880003, "errorCode: 3507 errorMessage: data load failed, errorMsg is " + e11.getErrorMessage());
                }
                d.this.f46173b.a(bVarA);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements com.mbridge.msdk.newreward.a.b.b {
        private b() {
        }

        @Override // com.mbridge.msdk.newreward.a.b.b
        public final void a(com.mbridge.msdk.foundation.c.b bVar) {
            d dVar = d.this;
            com.mbridge.msdk.newreward.function.c.b.b.e eVar = new com.mbridge.msdk.newreward.function.c.b.b.e(bVar, dVar.f46175d, dVar.f46174c, 2);
            com.mbridge.msdk.newreward.function.c.b.b.c cVar = d.this.f46176e;
            if (cVar != null && cVar.a(eVar)) {
                d.this.f46176e.a(eVar, this);
                return;
            }
            com.mbridge.msdk.newreward.a.c.a.a().a(d.this.f46177f);
            com.mbridge.msdk.newreward.function.e.c.a().b().a(d.this.f46175d.n(), d.this.f46175d.u(), d.this.f46175d.y(), d.this.f46175d.x(), 404);
            d.this.f46173b.a(bVar);
        }

        @Override // com.mbridge.msdk.newreward.a.b.b
        public final void a(Object obj) {
            com.mbridge.msdk.newreward.a.c.a.a().a(d.this.f46177f);
            d dVar = d.this;
            dVar.f46173b.a(dVar.f46174c.a("type", 2, "object", obj));
        }
    }

    private String a() {
        StringBuilder sb2 = new StringBuilder();
        try {
            com.mbridge.msdk.newreward.a.e eVar = this.f46175d;
            if (eVar != null && eVar.v() != null) {
                com.mbridge.msdk.newreward.function.d.a.b bVarB = this.f46175d.v().b();
                if (bVarB == null || bVarB.s() == null || bVarB.s().size() <= 0) {
                    sb2.append(" load timeout ");
                } else {
                    for (com.mbridge.msdk.newreward.function.d.a.a aVar : bVarB.s()) {
                        if (aVar != null) {
                            n nVarD = aVar.d();
                            if (nVarD != null && !nVarD.c()) {
                                sb2.append(" video timeout ");
                            }
                            com.mbridge.msdk.newreward.function.d.c.d<?> dVarC = aVar.c();
                            if (dVarC != null && !dVarC.c()) {
                                sb2.append(" video_template timeout ");
                            }
                            com.mbridge.msdk.newreward.function.d.c.d<?> dVarF = aVar.f();
                            if (dVarF != null && !dVarF.c()) {
                                sb2.append(" ec_template timeout ");
                            }
                        }
                    }
                }
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
        return sb2.toString();
    }

    private int b() {
        com.mbridge.msdk.newreward.function.f.e eVarP;
        com.mbridge.msdk.videocommon.d.c cVarB;
        try {
            com.mbridge.msdk.newreward.a.e eVar = this.f46175d;
            if (eVar == null || (eVarP = eVar.p()) == null || (cVarB = eVarP.b()) == null) {
                return 60000;
            }
            return cVarB.F() * 1000;
        } catch (Exception unused) {
            return 60000;
        }
    }

    public final void a(com.mbridge.msdk.newreward.function.c.a.a aVar) {
        this.f46172a = aVar;
        this.f46176e = new com.mbridge.msdk.newreward.function.c.b.b.c(aVar);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.mbridge.msdk.newreward.function.c.b.a
    public final void a(com.mbridge.msdk.newreward.function.c.b bVar, com.mbridge.msdk.newreward.a.b.b bVar2) {
        try {
            this.f46173b = bVar2;
            int iB = b();
            com.mbridge.msdk.newreward.a.c.a.a().a(this.f46177f, iB, this);
            bVar.a(com.mbridge.msdk.newreward.function.c.e.REQ_CAMPAIGN);
            Map map = (Map) bVar.b();
            this.f46180i = map;
            this.f46174c = (com.mbridge.msdk.newreward.function.c.c) map.get("command_manager");
            com.mbridge.msdk.newreward.a.e eVar = (com.mbridge.msdk.newreward.a.e) this.f46180i.get("adapter_model");
            this.f46175d = eVar;
            eVar.f(iB);
            com.mbridge.msdk.newreward.function.c.c cVar = this.f46174c;
            com.mbridge.msdk.newreward.a.e eVar2 = this.f46175d;
            com.mbridge.msdk.newreward.function.c.e eVar3 = com.mbridge.msdk.newreward.function.c.e.REPORT_LOAD_V3_START;
            Object[] objArr = new Object[4];
            objArr[0] = "auto_load";
            objArr[1] = Integer.valueOf(eVar2.z() ? 2 : 1);
            objArr[2] = "hst";
            objArr[3] = com.mbridge.msdk.foundation.same.net.g.d.f().a(this.f46175d.A());
            cVar.a(eVar2, eVar3, cVar.a(objArr));
            this.f46172a.a(bVar, new a(bVar, this.f46180i));
            long jA = af.a().a(MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_RETRY_STRATEGY, MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_RETRY_STRATEGY_CAMPAIGN_RETRY_TIMEOUT, 0);
            this.f46179h = jA;
            if (jA > 0) {
                com.mbridge.msdk.newreward.a.c.a.a().a(this.f46178g, this.f46179h, this);
            }
            com.mbridge.msdk.newreward.function.e.c.a().b().a(this.f46175d.n(), this.f46175d.u(), this.f46175d.y(), this.f46175d.x(), !TextUtils.isEmpty(this.f46175d.A()), this.f46175d.A(), this.f46175d.J());
        } catch (Exception e11) {
            ad.a("LoadControllerReceiver", "action", e11);
            if (this.f46175d != null) {
                com.mbridge.msdk.newreward.function.e.c.a().b().a(this.f46175d.n(), this.f46175d.u(), this.f46175d.y(), this.f46175d.x(), 8);
            }
            com.mbridge.msdk.newreward.a.c.a.a().a(this.f46178g);
            com.mbridge.msdk.newreward.a.c.a.a().a(this.f46177f);
            if (bVar2 != null) {
                bVar2.a(new com.mbridge.msdk.foundation.c.b(880020, e11.getMessage()));
            }
        }
    }

    @Override // com.mbridge.msdk.newreward.a.c.a.InterfaceC0504a
    public final void a(String str, long j11) {
        if (TextUtils.equals(str, this.f46177f)) {
            com.mbridge.msdk.newreward.function.e.c.a().b().a(this.f46175d.n(), this.f46175d.u(), this.f46175d.y(), this.f46175d.x(), 405);
            String strA = a();
            this.f46173b.a(new com.mbridge.msdk.foundation.c.b(880010, "errorCode: 3401 errorMessage: " + strA));
            return;
        }
        if (!TextUtils.equals(str, this.f46178g) || this.f46176e == null) {
            return;
        }
        com.mbridge.msdk.newreward.function.c.b.b.e eVar = new com.mbridge.msdk.newreward.function.c.b.b.e(null, this.f46175d, this.f46174c, 3);
        com.mbridge.msdk.newreward.function.c.b bVar = new com.mbridge.msdk.newreward.function.c.b();
        bVar.a(com.mbridge.msdk.newreward.function.c.e.REQ_CAMPAIGN);
        com.mbridge.msdk.newreward.function.c.c cVar = this.f46174c;
        bVar.a(cVar.a("adapter_model", this.f46175d, "command_manager", cVar));
        this.f46176e.a(eVar, new a(bVar, this.f46180i));
    }
}
