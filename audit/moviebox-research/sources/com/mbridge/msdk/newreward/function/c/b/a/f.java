package com.mbridge.msdk.newreward.function.c.b.a;

import com.mbridge.msdk.MBridgeConstans;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class f implements com.mbridge.msdk.newreward.function.c.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.newreward.a.e f46188a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.mbridge.msdk.newreward.b.b f46189b;

    /* JADX INFO: renamed from: com.mbridge.msdk.newreward.function.c.b.a.f$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f46190a;

        static {
            int[] iArr = new int[com.mbridge.msdk.newreward.function.c.e.values().length];
            f46190a = iArr;
            try {
                iArr[com.mbridge.msdk.newreward.function.c.e.REPORT_LOAD_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public f(Object obj) {
        if (obj instanceof com.mbridge.msdk.newreward.a.e) {
            this.f46188a = (com.mbridge.msdk.newreward.a.e) obj;
        }
        if (obj instanceof com.mbridge.msdk.newreward.b.b) {
            this.f46189b = (com.mbridge.msdk.newreward.b.b) obj;
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001b  */
    @Override // com.mbridge.msdk.newreward.function.c.b.b
    public final void a(Object obj) {
        Map map;
        if (obj instanceof com.mbridge.msdk.newreward.function.c.b) {
            com.mbridge.msdk.newreward.function.c.b bVar = (com.mbridge.msdk.newreward.function.c.b) obj;
            if (bVar != null) {
                try {
                    if (bVar.b() instanceof Map) {
                        map = (Map) bVar.b();
                    } else {
                        map = null;
                    }
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        e11.printStackTrace();
                        return;
                    }
                    return;
                }
            } else {
                map = null;
            }
            com.mbridge.msdk.newreward.a.e eVar = this.f46188a;
            if (eVar == null || eVar.r() == null) {
                if (this.f46189b != null) {
                    com.mbridge.msdk.newreward.function.f.c cVar = new com.mbridge.msdk.newreward.function.f.c();
                    com.mbridge.msdk.newreward.b.b bVar2 = this.f46189b;
                    if (map == null) {
                        map = new HashMap();
                    }
                    cVar.a(bVar2, map, bVar.a());
                    return;
                }
                return;
            }
            if (AnonymousClass1.f46190a[bVar.a().ordinal()] != 1) {
                com.mbridge.msdk.newreward.function.f.c cVarR = this.f46188a.r();
                com.mbridge.msdk.newreward.a.e eVar2 = this.f46188a;
                if (map == null) {
                    map = new HashMap();
                }
                cVarR.a(eVar2, map, bVar.a());
                return;
            }
            this.f46188a.r();
            com.mbridge.msdk.newreward.a.e eVar3 = this.f46188a;
            if (eVar3 == null) {
                return;
            }
            try {
                com.mbridge.msdk.foundation.same.report.d.b bVarB = com.mbridge.msdk.foundation.same.report.d.c.a().b(eVar3.x());
                if (bVarB == null) {
                    bVarB = new com.mbridge.msdk.foundation.same.report.d.b();
                    bVarB.c(eVar3.x());
                    bVarB.b(eVar3.n());
                    com.mbridge.msdk.foundation.same.report.d.c.a().b().put(eVar3.x(), bVarB);
                }
                bVarB.d(eVar3.y());
                bVarB.e(eVar3.A());
                bVarB.i(eVar3.I() ? "1" : "0");
                com.mbridge.msdk.videocommon.d.a aVarA = eVar3.p().a();
                if (aVarA != null) {
                    bVarB.h(aVarA.b());
                    bVarB.f(aVarA.c());
                }
                com.mbridge.msdk.videocommon.d.c cVarB = eVar3.p().b();
                if (cVarB != null) {
                    bVarB.g(cVarB.l());
                    bVarB.n(cVarB.k());
                }
                bVarB.a("2000123");
                com.mbridge.msdk.foundation.same.report.d.c.a().a(bVarB);
                com.mbridge.msdk.foundation.same.report.d.c.a().a(bVarB.c(), bVarB, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
            } catch (Exception e12) {
                if (MBridgeConstans.DEBUG) {
                    e12.printStackTrace();
                }
            }
        }
    }
}
