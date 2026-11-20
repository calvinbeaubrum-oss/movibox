package com.mbridge.msdk.newreward.function.c.b.b;

import android.os.SystemClock;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.newreward.function.common.MBridgeTaskManager;
import com.transsion.push.PushConstants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.c.a.a f46199a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f46201c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f46200b = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f46202d = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f46203e = 0;

    /* JADX INFO: renamed from: com.mbridge.msdk.newreward.function.c.b.b.a$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f46209a;

        static {
            int[] iArr = new int[com.mbridge.msdk.newreward.function.c.e.values().length];
            f46209a = iArr;
            try {
                iArr[com.mbridge.msdk.newreward.function.c.e.REPORT_V3_RETRY_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f46209a[com.mbridge.msdk.newreward.function.c.e.REPORT_V3_RETRY_END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public a(com.mbridge.msdk.newreward.function.c.a.a aVar) {
        this.f46199a = aVar;
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
            Map mapA = cVarD.a(PushConstants.SP_KEY_RETRY_COUNT, Integer.valueOf(this.f46202d), "type", 1);
            int i12 = AnonymousClass2.f46209a[eVar.ordinal()];
            if (i12 == 1) {
                cVarD.a(eVarB, com.mbridge.msdk.newreward.function.c.e.REPORT_V3_RETRY_START, mapA);
                return;
            }
            if (i12 != 2) {
                return;
            }
            mapA.put("duration", Long.valueOf(System.currentTimeMillis() - this.f46203e));
            if (z11) {
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

    public final void a(e eVar, com.mbridge.msdk.newreward.a.b.b bVar) {
        a(com.mbridge.msdk.newreward.function.c.e.REPORT_V3_RETRY_START, eVar, "", false);
        b(eVar, bVar);
    }

    public final boolean a() {
        return this.f46200b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005c, code lost:
    
        if (((java.lang.Boolean) r9).booleanValue() == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a(com.mbridge.msdk.foundation.c.b bVar, e eVar, com.mbridge.msdk.newreward.a.e eVar2) {
        if (eVar2 == null || bVar == null || eVar == null || bVar.a() == 2) {
            return false;
        }
        this.f46201c = af.a().a(MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_RETRY_STRATEGY, MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_RETRY_STRATEGY_CAMPAIGN_REQUEST_INTERVAL, AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS);
        int iA = af.a().a(MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_RETRY_STRATEGY, MBridgeCommon.SettingConfig.KEY_SETTING_CONFIG_RETRY_STRATEGY_CAMPAIGN_REQUEST_MAX, 0);
        ad.a("CampaignRetryStrategy", "campaignRequestRetryInvalidTime = " + this.f46201c);
        if (this.f46201c <= 0 || iA <= 0) {
            return false;
        }
        Object objA = bVar.a("can_retry");
        if (objA != null) {
        }
        if (this.f46202d == 0) {
            this.f46203e = System.currentTimeMillis();
        }
        this.f46202d++;
        return SystemClock.elapsedRealtime() - eVar2.e() < ((long) eVar2.G()) - this.f46201c && this.f46202d <= iA;
        return false;
    }

    public final void b(final e eVar, final com.mbridge.msdk.newreward.a.b.b bVar) {
        if (eVar == null) {
            return;
        }
        Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.newreward.function.c.b.b.a.1
            @Override // java.lang.Runnable
            public final void run() {
                com.mbridge.msdk.newreward.function.c.b bVar2 = new com.mbridge.msdk.newreward.function.c.b();
                bVar2.a(com.mbridge.msdk.newreward.function.c.e.REQ_CAMPAIGN);
                HashMap map = new HashMap();
                final com.mbridge.msdk.newreward.a.e eVarB = eVar.b();
                map.put("adapter_model", eVarB);
                map.put("command_manager", eVar.d());
                bVar2.a(map);
                eVarB.a();
                a.this.f46199a.a(bVar2, new com.mbridge.msdk.newreward.a.b.b() { // from class: com.mbridge.msdk.newreward.function.c.b.b.a.1.1
                    @Override // com.mbridge.msdk.newreward.a.b.b
                    public final void a(com.mbridge.msdk.foundation.c.b bVar3) {
                        ad.a("CampaignRetryStrategy", "reqFailed，try retry");
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        if (a.this.a(bVar3, eVar, eVarB)) {
                            eVar.a(bVar3);
                            AnonymousClass1 anonymousClass2 = AnonymousClass1.this;
                            a.this.b(eVar, bVar);
                        } else {
                            a.this.f46200b = true;
                            AnonymousClass1 anonymousClass3 = AnonymousClass1.this;
                            a.this.a(com.mbridge.msdk.newreward.function.c.e.REPORT_V3_RETRY_END, eVar, bVar3 != null ? bVar3.b() : "", false);
                            bVar.a(bVar3);
                        }
                    }

                    @Override // com.mbridge.msdk.newreward.a.b.b
                    public final void a(Object obj) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        a.this.a(com.mbridge.msdk.newreward.function.c.e.REPORT_V3_RETRY_END, eVar, "", true);
                        bVar.a(obj);
                    }
                });
            }
        };
        ad.a("CampaignRetryStrategy", "retryReqCampaign，retryReqCampaign: " + this.f46201c);
        MBridgeTaskManager.directorExecute(runnable, this.f46201c);
    }
}
