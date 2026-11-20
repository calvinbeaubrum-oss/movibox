package com.mbridge.msdk.newreward.function.c.b.b;

import android.os.SystemClock;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.transsion.push.PushConstants;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f46229a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f46230b = 0;

    /* JADX INFO: renamed from: com.mbridge.msdk.newreward.function.c.b.b.d$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f46234a;

        static {
            int[] iArr = new int[com.mbridge.msdk.newreward.function.c.e.values().length];
            f46234a = iArr;
            try {
                iArr[com.mbridge.msdk.newreward.function.c.e.REPORT_V3_RETRY_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46234a[com.mbridge.msdk.newreward.function.c.e.REPORT_V3_RETRY_END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.mbridge.msdk.newreward.function.c.e eVar, e eVar2, String str, boolean z11) {
        if (eVar2 == null) {
            return;
        }
        com.mbridge.msdk.newreward.function.c.c cVarD = eVar2.d();
        com.mbridge.msdk.newreward.a.e eVarB = eVar2.b();
        if (cVarD == null || eVarB == null) {
            return;
        }
        try {
            int i11 = 1;
            Map mapA = cVarD.a(PushConstants.SP_KEY_RETRY_COUNT, Integer.valueOf(this.f46229a), "type", 3);
            int i12 = AnonymousClass2.f46234a[eVar.ordinal()];
            if (i12 == 1) {
                cVarD.a(eVarB, com.mbridge.msdk.newreward.function.c.e.REPORT_V3_RETRY_START, mapA);
                return;
            }
            if (i12 != 2) {
                return;
            }
            mapA.put("duration", Long.valueOf(System.currentTimeMillis() - this.f46230b));
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
        com.mbridge.msdk.newreward.a.e eVarB;
        com.mbridge.msdk.newreward.function.d.a.b bVarB;
        if (eVar == null || (eVarB = eVar.b()) == null || eVarB.v() == null || (bVarB = eVarB.v().b()) == null) {
            return;
        }
        a(com.mbridge.msdk.newreward.function.c.e.REPORT_V3_RETRY_START, eVar, "", false);
        eVarB.b();
        eVarB.w().a(bVarB, new com.mbridge.msdk.newreward.a.b.b() { // from class: com.mbridge.msdk.newreward.function.c.b.b.d.1
            @Override // com.mbridge.msdk.newreward.a.b.b
            public final void a(com.mbridge.msdk.foundation.c.b bVar2) {
                if (bVar != null) {
                    d.this.a(com.mbridge.msdk.newreward.function.c.e.REPORT_V3_RETRY_END, eVar, bVar2 != null ? bVar2.b() : "", false);
                    bVar.a(bVar2);
                }
            }

            @Override // com.mbridge.msdk.newreward.a.b.b
            public final void a(Object obj) {
                if (bVar != null) {
                    d.this.a(com.mbridge.msdk.newreward.function.c.e.REPORT_V3_RETRY_END, eVar, "", true);
                    bVar.a(obj);
                }
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0059, code lost:
    
        if (((java.lang.Boolean) r2).booleanValue() == false) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(e eVar) {
        com.mbridge.msdk.newreward.function.f.a aVarV;
        int iA;
        if (eVar == null || eVar.a() == null || eVar.b() == null || eVar.a().a() == 2 || (aVarV = eVar.b().v()) == null || aVarV.b() == null || eVar.b().w() == null || (iA = af.a().a(MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_RETRY_STRATEGY, MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_RETRY_STRATEGY_DOWNLOAD_RETRY_MAX, 0)) == 0) {
            return false;
        }
        Object objA = eVar.a().a("can_retry");
        if (objA != null) {
        }
        if (this.f46229a == 0) {
            this.f46230b = System.currentTimeMillis();
        }
        this.f46229a++;
        return SystemClock.elapsedRealtime() - eVar.b().d() < ((long) eVar.b().H()) && this.f46229a <= iA;
        return false;
    }
}
