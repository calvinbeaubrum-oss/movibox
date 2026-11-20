package com.mbridge.msdk.newreward.a.a;

import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.newreward.a.e;
import com.mbridge.msdk.newreward.function.c.c;
import com.mbridge.msdk.out.MBridgeIds;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class a implements com.mbridge.msdk.newreward.a.b.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static String f45998d = "LoadController";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected c f45999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected MBridgeIds f46000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected e f46001c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RewardVideoListener f46002e;

    public a(c cVar) {
        this.f45999a = cVar;
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
    public final void a(int i11, Object obj) {
        if (i11 != 1) {
            if (i11 != 2) {
                return;
            }
            this.f46001c.b(2);
            if (this.f46001c.g()) {
                return;
            }
            c cVar = this.f45999a;
            cVar.a(this.f46001c, com.mbridge.msdk.newreward.function.c.e.REPORT_LOAD_VIDEO_CAMPAIGN_SUCCESS, cVar.a("cache", 2));
            if (this.f46002e != null) {
                this.f46001c.c(true);
                this.f46002e.onVideoLoadSuccess(this.f46000b);
                return;
            }
            return;
        }
        if (this.f46001c.f()) {
            return;
        }
        c cVar2 = this.f45999a;
        e eVar = this.f46001c;
        com.mbridge.msdk.newreward.function.c.e eVar2 = com.mbridge.msdk.newreward.function.c.e.REPORT_LOAD_V3_CAMPAIGN_SUCCESS;
        Object[] objArr = new Object[6];
        objArr[0] = "metrics_data";
        objArr[1] = obj;
        objArr[2] = "auto_load";
        objArr[3] = Integer.valueOf(eVar.z() ? 2 : 1);
        objArr[4] = "cache";
        objArr[5] = 2;
        cVar2.a(eVar, eVar2, cVar2.a(objArr));
        if (this.f46002e != null) {
            this.f46001c.b(true);
            this.f46002e.onLoadSuccess(this.f46000b);
        }
    }

    public final void a(e eVar) {
        eVar.b(1);
        this.f46001c = eVar;
        this.f46002e = eVar.B();
        MBridgeIds mBridgeIds = (MBridgeIds) this.f45999a.a((Object) null, com.mbridge.msdk.newreward.function.c.e.CREATE_BIDS);
        this.f46000b = mBridgeIds;
        mBridgeIds.setLocalRequestId(this.f46001c.x());
        this.f46000b.setBidToken(this.f46001c.A());
        c cVar = this.f45999a;
        cVar.c(cVar.a("command_type", com.mbridge.msdk.newreward.function.c.e.PRE_HANDLE_LOAD, "command_manager", cVar, "adapter_model", this.f46001c), new com.mbridge.msdk.newreward.a.b.b() { // from class: com.mbridge.msdk.newreward.a.a.a.1
            @Override // com.mbridge.msdk.newreward.a.b.b
            public final void a(com.mbridge.msdk.foundation.c.b bVar) {
                a aVar = a.this;
                aVar.a(aVar.f46000b, bVar);
            }

            @Override // com.mbridge.msdk.newreward.a.b.b
            public final void a(Object obj) {
                a aVar = a.this;
                c cVar2 = aVar.f45999a;
                cVar2.a(cVar2.a("command_manager", cVar2, "adapter_model", aVar.f46001c), a.this);
            }
        });
    }

    public final void a(MBridgeIds mBridgeIds, com.mbridge.msdk.foundation.c.b bVar) {
        this.f46001c.b(2);
        if (this.f46001c.g()) {
            return;
        }
        c cVar = this.f45999a;
        cVar.a(this.f46001c, com.mbridge.msdk.newreward.function.c.e.REPORT_LOAD_FAILED, cVar.a("metrics_data", bVar));
        if (this.f46002e != null) {
            this.f46001c.c(true);
            RewardVideoListener rewardVideoListener = this.f46002e;
            if (rewardVideoListener != null) {
                rewardVideoListener.onVideoLoadFail(mBridgeIds, bVar.b());
            }
        }
    }

    public final void b(final com.mbridge.msdk.foundation.c.b bVar) {
        c cVar = this.f45999a;
        cVar.b(cVar.a("adapter_model", this.f46001c, "command_manager", cVar, "scene", 2, "reason", bVar), new com.mbridge.msdk.newreward.a.b.b() { // from class: com.mbridge.msdk.newreward.a.a.a.2
            @Override // com.mbridge.msdk.newreward.a.b.b
            public final void a(com.mbridge.msdk.foundation.c.b bVar2) {
                a aVar = a.this;
                aVar.a(aVar.f46000b, bVar);
            }

            @Override // com.mbridge.msdk.newreward.a.b.b
            public final void a(Object obj) {
                a.this.a(1, obj);
                a.this.a(2, obj);
            }
        });
    }
}
