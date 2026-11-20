package com.mbridge.msdk.newreward.function.c.b.b;

import com.mbridge.msdk.MBridgeConstans;
import com.transsion.push.PushConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.c.a.a f46210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f46211b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f46212c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f46213d = 0;

    /* JADX INFO: renamed from: com.mbridge.msdk.newreward.function.c.b.b.b$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f46217a;

        static {
            int[] iArr = new int[com.mbridge.msdk.newreward.function.c.e.values().length];
            f46217a = iArr;
            try {
                iArr[com.mbridge.msdk.newreward.function.c.e.REPORT_V3_RETRY_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46217a[com.mbridge.msdk.newreward.function.c.e.REPORT_V3_RETRY_END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public b(com.mbridge.msdk.newreward.function.c.a.a aVar) {
        this.f46210a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.mbridge.msdk.newreward.function.c.e eVar, e eVar2, String str, boolean z11) {
        if (eVar2 == null) {
            return;
        }
        if (this.f46213d == 0) {
            this.f46213d = System.currentTimeMillis();
        }
        com.mbridge.msdk.newreward.function.c.c cVarD = eVar2.d();
        com.mbridge.msdk.newreward.a.e eVarB = eVar2.b();
        if (cVarD == null || eVarB == null) {
            return;
        }
        try {
            int i11 = 1;
            Map mapA = cVarD.a(PushConstants.SP_KEY_RETRY_COUNT, 1, "type", 2);
            int i12 = AnonymousClass2.f46217a[eVar.ordinal()];
            if (i12 == 1) {
                cVarD.a(eVarB, com.mbridge.msdk.newreward.function.c.e.REPORT_V3_RETRY_START, mapA);
                return;
            }
            if (i12 != 2) {
                return;
            }
            mapA.put("duration", Long.valueOf(System.currentTimeMillis() - this.f46213d));
            if (!z11) {
                mapA.put("reason", str);
            }
            if (!z11) {
                i11 = 2;
            }
            mapA.put("result", Integer.valueOf(i11));
            cVarD.a(eVarB, com.mbridge.msdk.newreward.function.c.e.REPORT_V3_RETRY_END, mapA);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public final void a(final e eVar, final com.mbridge.msdk.newreward.a.b.b bVar) {
        a(com.mbridge.msdk.newreward.function.c.e.REPORT_V3_RETRY_START, eVar, null, false);
        if (eVar == null) {
            return;
        }
        com.mbridge.msdk.newreward.function.c.b bVar2 = new com.mbridge.msdk.newreward.function.c.b();
        bVar2.a(com.mbridge.msdk.newreward.function.c.e.REQ_CAMPAIGN);
        HashMap map = new HashMap();
        com.mbridge.msdk.newreward.a.e eVarB = eVar.b();
        map.put("adapter_model", eVarB);
        map.put("command_manager", eVar.d());
        bVar2.a(map);
        eVarB.a();
        this.f46210a.a(bVar2, new com.mbridge.msdk.newreward.a.b.b() { // from class: com.mbridge.msdk.newreward.function.c.b.b.b.1
            @Override // com.mbridge.msdk.newreward.a.b.b
            public final void a(com.mbridge.msdk.foundation.c.b bVar3) {
                b.this.a(com.mbridge.msdk.newreward.function.c.e.REPORT_V3_RETRY_END, eVar, bVar3 != null ? bVar3.b() : "", false);
                b.this.f46211b = true;
                bVar.a(bVar3);
            }

            @Override // com.mbridge.msdk.newreward.a.b.b
            public final void a(Object obj) {
                b.this.a(com.mbridge.msdk.newreward.function.c.e.REPORT_V3_RETRY_END, eVar, "", true);
                bVar.a(obj);
            }
        });
    }

    public final boolean a() {
        return this.f46211b;
    }
}
