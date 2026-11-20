package com.mbridge.msdk.click;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.cloud.tmc.miniapp.prepare.steps.PrepareException;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.MIMManager;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.ao;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.out.BaseTrackingListener;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.LoadingActivity;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.scheme.applet.AppletModelManager;
import com.mbridge.msdk.scheme.applet.AppletSchemeCallBack;
import com.mbridge.msdk.scheme.applet.AppletsModel;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.mvel2.ast.ASTNode;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f43033a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<String, Long> f43034b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Set<String> f43035c = new HashSet();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f43036d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f43037e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.mbridge.msdk.foundation.db.h f43038f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Context f43039g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private d f43040h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.report.o f43042j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private com.mbridge.msdk.c.g f43043k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f43044l;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f43047o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private i f43048p;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private NativeListener.NativeTrackingListener f43041i = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f43045m = false;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f43046n = true;

    public a(Context context, String str) {
        this.f43038f = null;
        this.f43039g = null;
        com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(str);
        this.f43043k = gVarB;
        if (gVarB == null) {
            com.mbridge.msdk.c.h.a();
            this.f43043k = com.mbridge.msdk.c.i.a();
        }
        this.f43044l = this.f43043k.aJ();
        Context applicationContext = context.getApplicationContext();
        this.f43039g = applicationContext;
        this.f43036d = str;
        if (this.f43038f == null) {
            this.f43038f = com.mbridge.msdk.foundation.db.h.a(applicationContext);
        }
        this.f43042j = new com.mbridge.msdk.foundation.same.report.o(this.f43039g);
    }

    private AppletSchemeCallBack a(NativeListener.NativeTrackingListener nativeTrackingListener, CampaignEx campaignEx, AppletsModel appletsModel, a aVar) {
        return new g(nativeTrackingListener, campaignEx, appletsModel, aVar);
    }

    public static /* synthetic */ String a(int i11) {
        if (i11 == 1) {
            return "2000136";
        }
        if (i11 == 2) {
            return "2000137";
        }
        if (i11 != 3) {
            return i11 != 4 ? "" : "2000138";
        }
        return "2000139";
    }

    private void a(int i11, String str, CampaignEx campaignEx, NativeListener.NativeTrackingListener nativeTrackingListener, List<String> list) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (i11 == 2) {
                    ah.a(this.f43039g, str, campaignEx, nativeTrackingListener, list);
                } else {
                    ah.a(this.f43039g, str, nativeTrackingListener, campaignEx, list);
                }
            }
        } catch (Throwable th2) {
            if (MBridgeConstans.DEBUG) {
                ad.a("CommonClickControl", th2.getMessage(), th2);
            }
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, boolean z11, boolean z12) {
        if (context == null) {
            return;
        }
        new d(context.getApplicationContext()).a(str, campaignEx, null, str2, z11, z12, com.mbridge.msdk.click.a.a.f43071f);
    }

    public static void a(Context context, final CampaignEx campaignEx, String str, final String str2, boolean z11, boolean z12, final int i11) {
        final int i12;
        if (context == null) {
            return;
        }
        if (TextUtils.isEmpty(str2)) {
            i12 = -1;
        } else {
            i12 = str2.startsWith("tcp") ? 1 : 0;
        }
        new d(context.getApplicationContext()).a(str, campaignEx, new f() { // from class: com.mbridge.msdk.click.a.1
            @Override // com.mbridge.msdk.click.f
            public final void a(Object obj) {
            }

            @Override // com.mbridge.msdk.click.f
            public final void a(Object obj, String str3) {
                try {
                    String strA = a.a(i11);
                    com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
                    dVar.a("result", 2);
                    if (obj instanceof JumpLoaderResult) {
                        JumpLoaderResult jumpLoaderResult = (JumpLoaderResult) obj;
                        String exceptionMsg = jumpLoaderResult.getExceptionMsg();
                        if (!TextUtils.isEmpty(exceptionMsg)) {
                            str3 = exceptionMsg;
                        }
                        dVar.a("reason", str3);
                        dVar.a("status_code", Integer.valueOf(jumpLoaderResult.getStatusCode()));
                    }
                    dVar.a(TrackingKey.CODE, "");
                    dVar.a("failingURL", ao.d(str2));
                    dVar.a("net_ty", String.valueOf(i12));
                    com.mbridge.msdk.foundation.same.report.d.c.a().a(strA, campaignEx, dVar);
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        ad.b("CommonClickControl", e11.getMessage());
                    }
                }
            }

            @Override // com.mbridge.msdk.click.f
            public final void b(Object obj) {
                try {
                    com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
                    dVar.a("result", 2);
                    dVar.a("net_ty", String.valueOf(i12));
                    if (obj != null && (obj instanceof JumpLoaderResult)) {
                        JumpLoaderResult jumpLoaderResult = (JumpLoaderResult) obj;
                        String str3 = jumpLoaderResult.getStatusCode() + "";
                        dVar.a("status_code", str3);
                        if (str3.startsWith("2")) {
                            dVar.a("result", 1);
                        } else {
                            String exceptionMsg = jumpLoaderResult.getExceptionMsg();
                            if (TextUtils.isEmpty(exceptionMsg)) {
                                exceptionMsg = "UNKNOWN EXCEPTION and Status Code is : " + str3;
                            }
                            dVar.a("failingURL", ao.d(str2));
                            dVar.a("reason", exceptionMsg);
                        }
                    }
                    com.mbridge.msdk.foundation.same.report.d.c.a().a(a.a(i11), campaignEx, dVar);
                } catch (Exception e11) {
                    if (MBridgeConstans.DEBUG) {
                        ad.b("CommonClickControl", e11.getMessage());
                    }
                }
            }
        }, str2, z11, z12, i11);
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String[] strArr, boolean z11, boolean z12) {
        if (context == null || campaignEx == null || TextUtils.isEmpty(str) || strArr == null) {
            return;
        }
        d dVar = new d(context.getApplicationContext());
        for (String str2 : strArr) {
            dVar.a(str, campaignEx, new f() { // from class: com.mbridge.msdk.click.a.2
                @Override // com.mbridge.msdk.click.f
                public final void a(Object obj) {
                }

                @Override // com.mbridge.msdk.click.f
                public final void a(Object obj, String str3) {
                }

                @Override // com.mbridge.msdk.click.f
                public final void b(Object obj) {
                }
            }, str2, z11, z12, com.mbridge.msdk.click.a.a.f43071f);
        }
    }

    private void a(Context context, CampaignEx campaignEx, List<String> list) {
        if (context == null) {
            q.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, 2, "context is null", this.f43036d);
            return;
        }
        boolean z11 = z.y() == 1;
        boolean z12 = z.u(context) == 1;
        if (!z11 || !z12) {
            q.a(context, campaignEx, 2, "integrated:" + z11 + "-hasWx:" + z12, this.f43036d);
            a(campaignEx, list);
            return;
        }
        String ghId = campaignEx.getGhId();
        String ghPath = campaignEx.getGhPath();
        String bindId = campaignEx.getBindId();
        String strH = com.mbridge.msdk.foundation.controller.c.m().h();
        if (TextUtils.isEmpty(ghId)) {
            a(campaignEx, list);
            q.a(context, campaignEx, 2, "ghid is empty", this.f43036d);
            return;
        }
        try {
            if (!TextUtils.isEmpty(strH)) {
                bindId = strH;
            }
            Object objB = z.b(bindId);
            Class<?> cls = Class.forName("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Req");
            Object objNewInstance = cls.newInstance();
            cls.getField("userName").set(objNewInstance, ghId);
            cls.getField(MBridgeConstans.DYNAMIC_VIEW_WX_PATH).set(objNewInstance, ghPath);
            cls.getField("miniprogramType").set(objNewInstance, cls.getField("MINIPTOGRAM_TYPE_RELEASE").get(null));
            Class.forName("com.tencent.mm.opensdk.openapi.IWXAPI").getMethod("sendReq", Class.forName("com.tencent.mm.opensdk.modelbase.BaseReq")).invoke(objB, objNewInstance);
            q.a(context, campaignEx, 1, "", this.f43036d);
        } catch (Throwable th2) {
            q.a(context, campaignEx, 2, th2.getMessage(), this.f43036d);
            a(campaignEx, list);
        }
    }

    public static /* synthetic */ void a(a aVar, CampaignEx campaignEx) {
        try {
            Intent intent = new Intent(aVar.f43039g, (Class<?>) LoadingActivity.class);
            intent.setFlags(ASTNode.DEOP);
            intent.putExtra("icon_url", campaignEx.getIconUrl());
            aVar.f43039g.startActivity(intent);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.a("CommonClickControl", "Exception", e11);
            }
        }
    }

    public static /* synthetic */ void a(a aVar, final boolean z11, final Campaign campaign) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.mbridge.msdk.click.a.5
            @Override // java.lang.Runnable
            public final void run() {
                if (z11 && !a.f43033a && MBridgeConstans.NATIVE_SHOW_LOADINGPAGER) {
                    a.f(a.this);
                }
                if (a.this.f43041i == null || a.f43033a || !MBridgeConstans.NATIVE_SHOW_LOADINGPAGER) {
                    return;
                }
                a.this.f43041i.onDismissLoading(campaign);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JumpLoaderResult jumpLoaderResult, CampaignEx campaignEx, boolean z11) {
        a(jumpLoaderResult, campaignEx, 1, z11);
    }

    private void a(CampaignEx campaignEx, int i11, int i12, List<String> list) {
        try {
            com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
            dVar.a("type", Integer.valueOf(i11));
            dVar.a("result", Integer.valueOf(i12));
            if (list != null) {
                dVar.a("click_path", list.toString());
            }
            com.mbridge.msdk.foundation.same.report.d.c.a().a("2000150", campaignEx, dVar);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.b("CommonClickControl", e11.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:47:0x00d1 A[Catch: Exception -> 0x0028, TryCatch #0 {Exception -> 0x0028, blocks: (B:3:0x000a, B:10:0x0017, B:12:0x0021, B:17:0x002b, B:20:0x0039, B:22:0x003f, B:25:0x0053, B:27:0x0057, B:29:0x0069, B:32:0x0073, B:34:0x007d, B:36:0x0087, B:39:0x0097, B:47:0x00d1, B:48:0x00e0, B:51:0x00e6, B:74:0x0155, B:76:0x0163, B:78:0x016b, B:82:0x0173, B:77:0x0168, B:43:0x00a8, B:45:0x00b2, B:55:0x00f4, B:57:0x010b, B:60:0x0111, B:63:0x011d, B:65:0x0123, B:67:0x0127, B:69:0x012d, B:71:0x013f, B:73:0x014e, B:84:0x017d, B:86:0x0184), top: B:90:0x000a }] */
    public void a(CampaignEx campaignEx, JumpLoaderResult jumpLoaderResult, boolean z11, boolean z12, Boolean bool, List<String> list) {
        boolean z13;
        try {
            if (this.f43046n) {
                if (campaignEx == null || jumpLoaderResult == null) {
                    if (z11) {
                        a(jumpLoaderResult, campaignEx, true);
                        NativeListener.NativeTrackingListener nativeTrackingListener = this.f43041i;
                        if (nativeTrackingListener != null) {
                            nativeTrackingListener.onRedirectionFailed(null, null);
                            return;
                        }
                        return;
                    }
                    return;
                }
                int iB = b();
                int code = jumpLoaderResult.getCode();
                if (bool == null || bool.booleanValue()) {
                    if (TextUtils.isEmpty(jumpLoaderResult.getUrl()) && z11) {
                        int linkType = campaignEx.getLinkType();
                        if (linkType == 2) {
                            a(campaignEx, jumpLoaderResult, z11, b(), list);
                            return;
                        }
                        if (linkType == 3) {
                            a(campaignEx, jumpLoaderResult, z11, list);
                            return;
                        }
                        ah.a(this.f43039g, campaignEx.getClickURL(), this.f43041i, campaignEx, list);
                        a(jumpLoaderResult, campaignEx, true);
                        NativeListener.NativeTrackingListener nativeTrackingListener2 = this.f43041i;
                        if (nativeTrackingListener2 != null) {
                            nativeTrackingListener2.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
                            return;
                        }
                        return;
                    }
                    if (code == 1) {
                        if (TextUtils.isEmpty(campaignEx.getPackageName()) || TextUtils.isEmpty(jumpLoaderResult.getUrl()) || !jumpLoaderResult.getUrl().contains(campaignEx.getPackageName()) || !z11) {
                            if (z11) {
                                if (TextUtils.isEmpty(campaignEx.getPackageName())) {
                                    a(iB, jumpLoaderResult.getUrl(), campaignEx, this.f43041i, list);
                                } else {
                                    if (!ah.a.a(this.f43039g, "market://details?id=" + campaignEx.getPackageName(), this.f43041i)) {
                                        a(iB, jumpLoaderResult.getUrl(), campaignEx, this.f43041i, list);
                                    }
                                }
                            }
                        } else if (!ah.a.a(this.f43039g, jumpLoaderResult.getUrl(), this.f43041i)) {
                            a(iB, jumpLoaderResult.getUrl(), campaignEx, this.f43041i, list);
                        }
                        NativeListener.NativeTrackingListener nativeTrackingListener3 = this.f43041i;
                        if (nativeTrackingListener3 != null && z11) {
                            nativeTrackingListener3.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
                        }
                        z13 = true;
                    } else if (code == 3) {
                        if (z11) {
                            z13 = true;
                            b.a(this.f43039g, campaignEx, this.f43036d, jumpLoaderResult, bool, this.f43041i, list);
                        } else {
                            z13 = true;
                        }
                        NativeListener.NativeTrackingListener nativeTrackingListener4 = this.f43041i;
                        if (nativeTrackingListener4 != null && z11) {
                            nativeTrackingListener4.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
                        }
                    } else {
                        z13 = true;
                        if (z11) {
                            if (3 == campaignEx.getLinkType()) {
                                a(campaignEx, jumpLoaderResult, z11, list);
                                return;
                            } else {
                                if (2 == campaignEx.getLinkType()) {
                                    a(campaignEx, jumpLoaderResult, z11, b(), list);
                                    return;
                                }
                                ah.a(this.f43039g, jumpLoaderResult.getUrl(), this.f43041i, campaignEx, list);
                                NativeListener.NativeTrackingListener nativeTrackingListener5 = this.f43041i;
                                if (nativeTrackingListener5 != null) {
                                    nativeTrackingListener5.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
                                }
                            }
                        }
                    }
                    if (a(campaignEx.getLinkType(), jumpLoaderResult.getUrl())) {
                        a(jumpLoaderResult, campaignEx, false);
                    } else {
                        a(jumpLoaderResult, campaignEx, z13);
                    }
                    NativeListener.NativeTrackingListener nativeTrackingListener6 = this.f43041i;
                    if (nativeTrackingListener6 == null || z11 || !z12) {
                        return;
                    }
                    nativeTrackingListener6.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private void a(CampaignEx campaignEx, List<String> list) {
        if (b() == 2) {
            ah.a(this.f43039g, campaignEx.getClickURL(), campaignEx, this.f43041i, list);
        } else {
            ah.a(this.f43039g, campaignEx.getClickURL(), this.f43041i, campaignEx, list);
        }
    }

    private void a(final CampaignEx campaignEx, final boolean z11, final Boolean bool, final List<String> list) {
        final boolean z12;
        try {
            this.f43037e = System.currentTimeMillis();
            NativeListener.NativeTrackingListener nativeTrackingListener = this.f43041i;
            if (nativeTrackingListener == null || z11) {
                z12 = true;
            } else {
                nativeTrackingListener.onStartRedirection(campaignEx, campaignEx.getClickURL());
                z12 = !this.f43041i.onInterceptDefaultLoadingDialog();
            }
            final boolean z13 = true;
            this.f43047o = false;
            if (campaignEx.getJumpResult() != null) {
                if (!z11) {
                    a(campaignEx, campaignEx.getJumpResult(), true, this.f43045m, bool, list);
                }
                this.f43047o = true;
                this.f43045m = false;
                z13 = false;
            }
            if (!com.mbridge.msdk.foundation.db.d.a(this.f43038f).a(campaignEx.getId(), this.f43036d) || campaignEx.getJumpResult() == null) {
                com.mbridge.msdk.foundation.db.d dVarA = com.mbridge.msdk.foundation.db.d.a(this.f43038f);
                dVarA.a();
                JumpLoaderResult jumpLoaderResultB = dVarA.b(campaignEx.getId(), this.f43036d);
                if (jumpLoaderResultB == null || z11) {
                    if (campaignEx.getClick_mode().equals(PrepareException.ERROR_NO_URL) && !campaignEx.getPackageName().isEmpty() && campaignEx.getLinkType() == 2 && !z11) {
                        boolean zA = ah.a.a(this.f43039g, "market://details?id=" + campaignEx.getPackageName(), this.f43041i);
                        if (list != null) {
                            list.add("google_play");
                        }
                        if (zA) {
                            a(campaignEx, 1, 1, list);
                        }
                        NativeListener.NativeTrackingListener nativeTrackingListener2 = this.f43041i;
                        if (nativeTrackingListener2 != null && z13) {
                            nativeTrackingListener2.onDismissLoading(campaignEx);
                            this.f43041i.onFinishRedirection(campaignEx, null);
                        }
                        this.f43047o = true;
                        z13 = false;
                    }
                    if (z11) {
                        this.f43047o = true;
                        this.f43045m = false;
                        z13 = false;
                    }
                } else {
                    campaignEx.setJumpResult(jumpLoaderResultB);
                    if (z13) {
                        a(campaignEx, jumpLoaderResultB, z13, this.f43045m, bool, list);
                        this.f43047o = true;
                        this.f43045m = false;
                        z13 = false;
                    }
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.mbridge.msdk.click.a.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        if (z12 && !a.f43033a && !a.this.f43047o && MBridgeConstans.NATIVE_SHOW_LOADINGPAGER && !z11) {
                            a.a(a.this, campaignEx);
                        }
                        if (z12 || a.this.f43041i == null || a.f43033a || a.this.f43047o || !MBridgeConstans.NATIVE_SHOW_LOADINGPAGER) {
                            return;
                        }
                        a.this.f43041i.onShowLoading(campaignEx);
                    }
                });
                d dVar = this.f43040h;
                if (dVar != null) {
                    dVar.a();
                }
                Set<String> set = f43035c;
                if (set != null && set.contains(campaignEx.getId())) {
                    NativeListener.NativeTrackingListener nativeTrackingListener3 = this.f43041i;
                    if (nativeTrackingListener3 != null) {
                        nativeTrackingListener3.onDismissLoading(campaignEx);
                        this.f43041i.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                        return;
                    }
                    return;
                }
                Set<String> set2 = f43035c;
                if (set2 != null) {
                    set2.add(campaignEx.getId());
                }
                d dVar2 = new d(this.f43039g);
                this.f43040h = dVar2;
                final boolean z14 = z12;
                dVar2.a(this.f43036d, campaignEx, new f() { // from class: com.mbridge.msdk.click.a.4
                    @Override // com.mbridge.msdk.click.f
                    public final void a(Object obj) {
                    }

                    /* JADX WARN: Code duplicated, block: B:29:0x0065  */
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r6v10, types: [int] */
                    /* JADX WARN: Type inference failed for: r6v21 */
                    /* JADX WARN: Type inference failed for: r6v9 */
                    @Override // com.mbridge.msdk.click.f
                    public final void a(Object obj, String str) {
                        ?? StartsWith;
                        Set<String> set3 = a.f43035c;
                        if (set3 != null) {
                            set3.remove(campaignEx.getId());
                        }
                        JumpLoaderResult jumpLoaderResult = null;
                        if (obj != null) {
                            try {
                                if (obj instanceof JumpLoaderResult) {
                                    JumpLoaderResult jumpLoaderResult2 = (JumpLoaderResult) obj;
                                    try {
                                        a.this.a((JumpLoaderResult) obj, campaignEx, true);
                                        jumpLoaderResult = jumpLoaderResult2;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        jumpLoaderResult = jumpLoaderResult2;
                                        ad.b("CommonClickControl", th.getMessage());
                                    }
                                }
                            } catch (Throwable th3) {
                                th = th3;
                            }
                        }
                        if (a.this.f43041i != null) {
                            a.this.f43041i.onRedirectionFailed(campaignEx, str);
                        }
                        a.a(a.this, z14, campaignEx);
                        try {
                            CampaignEx campaignEx2 = campaignEx;
                            if (campaignEx2 != null) {
                                String clickURL = campaignEx2.getClickURL();
                                if (TextUtils.isEmpty(clickURL)) {
                                    StartsWith = -1;
                                } else {
                                    StartsWith = clickURL.startsWith("tcp");
                                }
                            } else {
                                StartsWith = -1;
                            }
                            com.mbridge.msdk.foundation.same.report.d.d dVar3 = new com.mbridge.msdk.foundation.same.report.d.d();
                            dVar3.a("result", "2");
                            dVar3.a("net_ty", Integer.valueOf((int) StartsWith));
                            if (jumpLoaderResult != null) {
                                dVar3.a("status_code", Integer.valueOf(jumpLoaderResult.getStatusCode()));
                            }
                            com.mbridge.msdk.foundation.same.report.d.c.a().a("2000138", campaignEx, dVar3);
                        } catch (Throwable th4) {
                            if (MBridgeConstans.DEBUG) {
                                ad.b("CommonClickControl", th4.getMessage());
                            }
                        }
                    }

                    /* JADX WARN: Code duplicated, block: B:28:0x007c  */
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Type inference failed for: r1v14 */
                    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
                    /* JADX WARN: Type inference failed for: r1v23 */
                    @Override // com.mbridge.msdk.click.f
                    public final void b(Object obj) {
                        Throwable th2;
                        JumpLoaderResult jumpLoaderResult;
                        ?? StartsWith;
                        Set<String> set3 = a.f43035c;
                        if (set3 != null) {
                            set3.remove(campaignEx.getId());
                        }
                        JumpLoaderResult jumpLoaderResult2 = null;
                        if (obj != null) {
                            try {
                                if (obj instanceof JumpLoaderResult) {
                                    jumpLoaderResult = (JumpLoaderResult) obj;
                                    try {
                                        campaignEx.setJumpResult(jumpLoaderResult);
                                        a aVar = a.this;
                                        aVar.a(campaignEx, jumpLoaderResult, z13, aVar.f43045m, bool, (List<String>) list);
                                        if (jumpLoaderResult.isjumpDone()) {
                                            com.mbridge.msdk.foundation.db.d.a(a.this.f43038f).a(campaignEx, a.this.f43036d);
                                        }
                                        a.a(a.this, z14, campaignEx);
                                        jumpLoaderResult2 = jumpLoaderResult;
                                    } catch (Throwable th3) {
                                        th2 = th3;
                                        ad.b("CommonClickControl", th2.getMessage());
                                    }
                                }
                            } catch (Throwable th4) {
                                th2 = th4;
                                jumpLoaderResult = null;
                            }
                        }
                        jumpLoaderResult = jumpLoaderResult2;
                        try {
                            CampaignEx campaignEx2 = campaignEx;
                            if (campaignEx2 != null) {
                                String clickURL = campaignEx2.getClickURL();
                                if (TextUtils.isEmpty(clickURL)) {
                                    StartsWith = -1;
                                } else {
                                    StartsWith = clickURL.startsWith("tcp");
                                }
                            } else {
                                StartsWith = -1;
                            }
                            com.mbridge.msdk.foundation.same.report.d.d dVar3 = new com.mbridge.msdk.foundation.same.report.d.d();
                            dVar3.a("result", "1");
                            if (jumpLoaderResult != null) {
                                dVar3.a("status_code", Integer.valueOf(jumpLoaderResult.getStatusCode()));
                            }
                            dVar3.a("net_ty", Integer.valueOf((int) StartsWith));
                            com.mbridge.msdk.foundation.same.report.d.c.a().a("2000138", campaignEx, dVar3);
                        } catch (Throwable th5) {
                            if (MBridgeConstans.DEBUG) {
                                ad.b("CommonClickControl", th5.getMessage());
                            }
                        }
                    }
                });
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0015  */
    private boolean a(int i11, String str) {
        boolean z11 = true;
        boolean z12 = false;
        try {
            if (i11 == 2) {
                if (!ah.a.b(str)) {
                    z11 = false;
                }
            } else if (TextUtils.isEmpty(str)) {
                z11 = false;
            }
            z12 = z11;
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return z12;
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00a6  */
    private boolean a(CampaignEx campaignEx, JumpLoaderResult jumpLoaderResult, boolean z11, int i11, List<String> list) {
        boolean z12 = true;
        boolean z13 = false;
        if (z11) {
            try {
                int i12 = Integer.parseInt(campaignEx.getLandingType());
                if (i12 == 1) {
                    ah.a(this.f43039g, jumpLoaderResult.getUrl(), this.f43041i, campaignEx, list);
                } else if (i12 == 2) {
                    ah.a(this.f43039g, jumpLoaderResult.getUrl(), campaignEx, this.f43041i, list);
                } else if (campaignEx.getPackageName() != null) {
                    if (ah.a.a(this.f43039g, "market://details?id=" + campaignEx.getPackageName(), this.f43041i)) {
                        if (list != null) {
                            try {
                                list.add("google_play");
                            } catch (Throwable th2) {
                                th = th2;
                                if (MBridgeConstans.DEBUG) {
                                    ad.a("CommonClickControl", th.getMessage(), th);
                                }
                                return z12;
                            }
                        }
                        a(campaignEx, 1, 1, list);
                    } else {
                        a(i11, jumpLoaderResult.getUrl(), campaignEx, this.f43041i, list);
                    }
                } else {
                    a(i11, jumpLoaderResult.getUrl(), campaignEx, this.f43041i, list);
                }
                z13 = true;
            } catch (Throwable th3) {
                th = th3;
                z12 = false;
            }
        }
        try {
            if (z13) {
                a(jumpLoaderResult, campaignEx, true);
                NativeListener.NativeTrackingListener nativeTrackingListener = this.f43041i;
                if (nativeTrackingListener != null) {
                    nativeTrackingListener.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
                }
            } else {
                a(jumpLoaderResult, campaignEx, true);
                NativeListener.NativeTrackingListener nativeTrackingListener2 = this.f43041i;
                if (nativeTrackingListener2 != null && z11) {
                    nativeTrackingListener2.onRedirectionFailed(campaignEx, jumpLoaderResult.getUrl());
                }
            }
            return z13;
        } catch (Throwable th4) {
            th = th4;
            z12 = z13;
            if (MBridgeConstans.DEBUG) {
                ad.a("CommonClickControl", th.getMessage(), th);
            }
            return z12;
        }
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002b A[Catch: all -> 0x0018, TryCatch #0 {all -> 0x0018, blocks: (B:4:0x0004, B:6:0x000a, B:9:0x001a, B:10:0x0026, B:12:0x002b, B:14:0x002f, B:15:0x0037, B:17:0x003d, B:18:0x0040, B:20:0x0044), top: B:26:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:14:0x002f A[Catch: all -> 0x0018, TryCatch #0 {all -> 0x0018, blocks: (B:4:0x0004, B:6:0x000a, B:9:0x001a, B:10:0x0026, B:12:0x002b, B:14:0x002f, B:15:0x0037, B:17:0x003d, B:18:0x0040, B:20:0x0044), top: B:26:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:15:0x0037 A[Catch: all -> 0x0018, TryCatch #0 {all -> 0x0018, blocks: (B:4:0x0004, B:6:0x000a, B:9:0x001a, B:10:0x0026, B:12:0x002b, B:14:0x002f, B:15:0x0037, B:17:0x003d, B:18:0x0040, B:20:0x0044), top: B:26:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x003d A[Catch: all -> 0x0018, TryCatch #0 {all -> 0x0018, blocks: (B:4:0x0004, B:6:0x000a, B:9:0x001a, B:10:0x0026, B:12:0x002b, B:14:0x002f, B:15:0x0037, B:17:0x003d, B:18:0x0040, B:20:0x0044), top: B:26:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:20:0x0044 A[Catch: all -> 0x0018, TRY_LEAVE, TryCatch #0 {all -> 0x0018, blocks: (B:4:0x0004, B:6:0x000a, B:9:0x001a, B:10:0x0026, B:12:0x002b, B:14:0x002f, B:15:0x0037, B:17:0x003d, B:18:0x0040, B:20:0x0044), top: B:26:0x0004 }] */
    private boolean a(CampaignEx campaignEx, JumpLoaderResult jumpLoaderResult, boolean z11, List<String> list) {
        NativeListener.NativeTrackingListener nativeTrackingListener;
        NativeListener.NativeTrackingListener nativeTrackingListener2;
        boolean z12 = false;
        if (z11) {
            try {
                if (com.mbridge.msdk.f.b.a()) {
                    b.a(this.f43039g, this.f43036d, campaignEx, campaignEx.getNoticeUrl(), com.mbridge.msdk.foundation.same.a.L);
                }
                ah.a(this.f43039g, campaignEx.getClickURL(), this.f43041i, campaignEx, list);
                z12 = true;
                a(jumpLoaderResult, campaignEx, true);
                if (z12) {
                    nativeTrackingListener2 = this.f43041i;
                    if (nativeTrackingListener2 != null) {
                        nativeTrackingListener2.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
                    }
                } else {
                    if (com.mbridge.msdk.f.b.a()) {
                        a(jumpLoaderResult, campaignEx, true);
                    }
                    nativeTrackingListener = this.f43041i;
                    if (nativeTrackingListener != null) {
                        nativeTrackingListener.onRedirectionFailed(campaignEx, jumpLoaderResult.getUrl());
                    }
                }
            } catch (Throwable th2) {
                if (MBridgeConstans.DEBUG) {
                    ad.a("CommonClickControl", th2.getMessage(), th2);
                }
            }
        } else {
            a(jumpLoaderResult, campaignEx, true);
            if (z12) {
                nativeTrackingListener2 = this.f43041i;
                if (nativeTrackingListener2 != null) {
                    nativeTrackingListener2.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
                }
            } else {
                if (com.mbridge.msdk.f.b.a()) {
                    a(jumpLoaderResult, campaignEx, true);
                }
                nativeTrackingListener = this.f43041i;
                if (nativeTrackingListener != null) {
                    nativeTrackingListener.onRedirectionFailed(campaignEx, jumpLoaderResult.getUrl());
                }
            }
        }
        return z12;
    }

    private int b() {
        try {
            com.mbridge.msdk.c.g gVar = this.f43043k;
            if (gVar != null) {
                return gVar.X();
            }
            return 1;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 1;
        }
    }

    private boolean b(CampaignEx campaignEx) {
        Long l11;
        if (campaignEx == null) {
            return true;
        }
        try {
            if (2 != campaignEx.getLinkType() && 3 != campaignEx.getLinkType()) {
                return true;
            }
            String id2 = campaignEx.getId();
            Map<String, Long> map = f43034b;
            if (map == null) {
                return true;
            }
            if (map.containsKey(id2) && (l11 = f43034b.get(id2)) != null) {
                if (l11.longValue() > System.currentTimeMillis() || f43035c.contains(campaignEx.getId())) {
                    return false;
                }
            }
            f43034b.put(campaignEx.getId(), Long.valueOf(System.currentTimeMillis() + ((long) (campaignEx.getClickTimeOutInterval() * 1000))));
            return true;
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return true;
            }
            e11.printStackTrace();
            return true;
        }
    }

    public static /* synthetic */ void f(a aVar) {
        try {
            Intent intent = new Intent();
            intent.setAction("ExitApp");
            aVar.f43039g.sendBroadcast(intent);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.a("CommonClickControl", "Exception", e11);
            }
        }
    }

    public final void a() {
        try {
            this.f43041i = null;
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void a(JumpLoaderResult jumpLoaderResult, CampaignEx campaignEx, int i11, boolean z11) {
        if (campaignEx == null || jumpLoaderResult == null) {
            return;
        }
        try {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f43037e;
            com.mbridge.msdk.foundation.entity.e eVar = new com.mbridge.msdk.foundation.entity.e();
            int iL = z.l(this.f43039g);
            eVar.a(iL);
            eVar.c(z.a(this.f43039g, iL));
            eVar.b(campaignEx.getRequestId());
            eVar.k(campaignEx.getRequestIdNotice());
            eVar.b(i11);
            eVar.i(jCurrentTimeMillis + "");
            eVar.j(campaignEx.getId());
            eVar.c(jumpLoaderResult.getType());
            if (!TextUtils.isEmpty(jumpLoaderResult.getUrl())) {
                eVar.h(URLEncoder.encode(jumpLoaderResult.getUrl(), "utf-8"));
            }
            eVar.e((this.f43037e / 1000) + "");
            eVar.d(Integer.parseInt(campaignEx.getLandingType()));
            eVar.e(campaignEx.getLinkType());
            eVar.a(this.f43036d);
            eVar.c(jumpLoaderResult.getType());
            if (!TextUtils.isEmpty(jumpLoaderResult.getUrl())) {
                eVar.h(URLEncoder.encode(jumpLoaderResult.getUrl(), "utf-8"));
            }
            if (this.f43044l) {
                eVar.f(jumpLoaderResult.getStatusCode());
                if (!TextUtils.isEmpty(jumpLoaderResult.getHeader())) {
                    eVar.f(URLEncoder.encode(jumpLoaderResult.getHeader(), "utf-8"));
                }
                if (!TextUtils.isEmpty(jumpLoaderResult.getContent())) {
                    eVar.g(URLEncoder.encode(jumpLoaderResult.getContent(), "UTF-8"));
                }
                if (!TextUtils.isEmpty(jumpLoaderResult.getExceptionMsg())) {
                    eVar.d(URLEncoder.encode(jumpLoaderResult.getExceptionMsg(), "utf-8"));
                }
            }
            if (z11) {
                this.f43042j.a("click_jump_error", eVar, this.f43036d);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(eVar);
            String strA = com.mbridge.msdk.foundation.entity.e.a(arrayList);
            if (an.b(strA)) {
                if (com.mbridge.msdk.foundation.same.report.j.a().b()) {
                    com.mbridge.msdk.foundation.same.report.j.a().a(strA);
                } else {
                    new com.mbridge.msdk.foundation.same.report.o(this.f43039g, 0).a("click_jump_success", strA, null, null);
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final void a(i iVar) {
        this.f43048p = iVar;
    }

    public final void a(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return;
        }
        try {
            if (b(campaignEx)) {
                com.mbridge.msdk.foundation.same.report.d.c.a().a("2000149", campaignEx);
                String noticeUrl = campaignEx.getNoticeUrl();
                com.mbridge.msdk.foundation.db.d dVarA = com.mbridge.msdk.foundation.db.d.a(this.f43038f);
                dVarA.a();
                JumpLoaderResult jumpLoaderResultB = dVarA.b(campaignEx.getId(), this.f43036d);
                if (jumpLoaderResultB != null) {
                    if (jumpLoaderResultB.getNoticeurl() != null) {
                        jumpLoaderResultB.setNoticeurl(null);
                    }
                    campaignEx.setJumpResult(jumpLoaderResultB);
                    dVarA.a(campaignEx, this.f43036d);
                }
                ArrayList arrayList = new ArrayList();
                AppletsModel appletsModel = AppletModelManager.getInstance().get(campaignEx);
                if (ai.b(campaignEx)) {
                    MIMManager.a().a(campaignEx);
                    arrayList.add(CampaignEx.JSON_KEY_DEEP_LINK_URL);
                    if (c.d(this.f43039g, campaignEx.getDeepLinkURL())) {
                        NativeListener.NativeTrackingListener nativeTrackingListener = this.f43041i;
                        if (nativeTrackingListener != null) {
                            nativeTrackingListener.onStartRedirection(campaignEx, campaignEx.getClickURL());
                        }
                        b.a(this.f43039g, this.f43036d, campaignEx, noticeUrl + "&opdptype=1", -1);
                        NativeListener.NativeTrackingListener nativeTrackingListener2 = this.f43041i;
                        if (nativeTrackingListener2 != null) {
                            nativeTrackingListener2.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                        }
                        a(campaignEx, 3, 1, arrayList);
                        return;
                    }
                    noticeUrl = noticeUrl + "&opdptype=0";
                    MIMManager.a().b(campaignEx);
                }
                String str = noticeUrl;
                if (campaignEx.getLinkType() == 12) {
                    NativeListener.NativeTrackingListener nativeTrackingListener3 = this.f43041i;
                    if (nativeTrackingListener3 != null) {
                        nativeTrackingListener3.onStartRedirection(campaignEx, campaignEx.getClickURL());
                    }
                    b.a(this.f43039g, this.f43036d, campaignEx, str, -1);
                    a(this.f43039g, campaignEx, arrayList);
                    NativeListener.NativeTrackingListener nativeTrackingListener4 = this.f43041i;
                    if (nativeTrackingListener4 != null) {
                        nativeTrackingListener4.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                        return;
                    }
                    return;
                }
                if (appletsModel != null && appletsModel.isSupportWxScheme()) {
                    if (appletsModel.isRequestSuccess()) {
                        if (c.d(this.f43039g, appletsModel.getDeepLink())) {
                            NativeListener.NativeTrackingListener nativeTrackingListener5 = this.f43041i;
                            if (nativeTrackingListener5 != null) {
                                nativeTrackingListener5.onStartRedirection(campaignEx, campaignEx.getClickURL());
                            }
                            if (this.f43039g != null) {
                                Intent intent = new Intent();
                                intent.setAction("mb_dp_close_broadcast_receiver");
                                try {
                                    this.f43039g.sendBroadcast(intent);
                                } catch (Exception e11) {
                                    if (MBridgeConstans.DEBUG) {
                                        ad.b("CommonClickControl", e11.getMessage());
                                    }
                                }
                            }
                            b.a(this.f43039g, this.f43036d, campaignEx, str + "&opdptype=1", -1);
                            NativeListener.NativeTrackingListener nativeTrackingListener6 = this.f43041i;
                            if (nativeTrackingListener6 != null) {
                                nativeTrackingListener6.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                                return;
                            }
                            return;
                        }
                        str = str + "&opdptype=0";
                    } else {
                        if (appletsModel.isRequesting()) {
                            NativeListener.NativeTrackingListener nativeTrackingListener7 = this.f43041i;
                            if (nativeTrackingListener7 != null) {
                                nativeTrackingListener7.onStartRedirection(campaignEx, campaignEx.getClickURL());
                            }
                            appletsModel.setAppletSchemeCallBack(a(this.f43041i, campaignEx, appletsModel, this));
                            return;
                        }
                        if (appletsModel.can(1)) {
                            if (!appletsModel.isRequestTimesMaxPerDay()) {
                                NativeListener.NativeTrackingListener nativeTrackingListener8 = this.f43041i;
                                if (nativeTrackingListener8 != null) {
                                    nativeTrackingListener8.onStartRedirection(campaignEx, campaignEx.getClickURL());
                                }
                                appletsModel.requestWxAppletsScheme(1, a(this.f43041i, campaignEx, appletsModel, this));
                                return;
                            }
                            if (!TextUtils.isEmpty(appletsModel.getReBuildClickUrl())) {
                                campaignEx.setClickURL(appletsModel.getReBuildClickUrl());
                            }
                        }
                    }
                }
                if (com.mbridge.msdk.f.b.b()) {
                    b.a(this.f43039g, this.f43036d, campaignEx, str, -1);
                }
                if (!campaignEx.getUserActivation() && c.b(this.f43039g, campaignEx.getPackageName())) {
                    c.a(this.f43039g, campaignEx.getPackageName());
                    if (com.mbridge.msdk.f.b.a()) {
                        b.a(this.f43039g, this.f43036d, campaignEx, str, com.mbridge.msdk.foundation.same.a.M);
                    }
                    NativeListener.NativeTrackingListener nativeTrackingListener9 = this.f43041i;
                    if (nativeTrackingListener9 != null) {
                        nativeTrackingListener9.onStartRedirection(campaignEx, campaignEx.getClickURL());
                    }
                    if (com.mbridge.msdk.f.b.a()) {
                        a(campaignEx, true, Boolean.TRUE, (List<String>) arrayList);
                    } else {
                        a(campaignEx, true, (Boolean) null, (List<String>) arrayList);
                    }
                    NativeListener.NativeTrackingListener nativeTrackingListener10 = this.f43041i;
                    if (nativeTrackingListener10 != null) {
                        nativeTrackingListener10.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                        ah.a(this.f43041i);
                        return;
                    }
                    return;
                }
                int linkType = campaignEx.getLinkType();
                int iB = b();
                if (com.mbridge.msdk.f.b.a() && linkType != 3) {
                    b.a(this.f43039g, this.f43036d, campaignEx, str, -1);
                }
                boolean z11 = linkType == 8 || linkType == 9 || linkType == 4;
                String clickURL = campaignEx.getClickURL();
                if (!TextUtils.isEmpty(clickURL) && (clickURL.startsWith("market://") || clickURL.startsWith("https://play.google.com/"))) {
                    arrayList.add("google_play");
                    NativeListener.NativeTrackingListener nativeTrackingListener11 = this.f43041i;
                    if (nativeTrackingListener11 != null) {
                        nativeTrackingListener11.onStartRedirection(campaignEx, campaignEx.getClickURL());
                    }
                    if (ah.a.a(this.f43039g, campaignEx.getClickURL(), this.f43041i)) {
                        a(jumpLoaderResultB, campaignEx, false);
                        NativeListener.NativeTrackingListener nativeTrackingListener12 = this.f43041i;
                        if (nativeTrackingListener12 != null) {
                            nativeTrackingListener12.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                        }
                        a(campaignEx, 1, 1, arrayList);
                        return;
                    }
                    a(iB, campaignEx.getClickURL(), campaignEx, this.f43041i, arrayList);
                    a(jumpLoaderResultB, campaignEx, false);
                    NativeListener.NativeTrackingListener nativeTrackingListener13 = this.f43041i;
                    if (nativeTrackingListener13 != null) {
                        nativeTrackingListener13.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                        return;
                    }
                    return;
                }
                if (!z11) {
                    if (linkType == 2) {
                        if (com.mbridge.msdk.f.b.a()) {
                            a(campaignEx, false, Boolean.TRUE, (List<String>) arrayList);
                            return;
                        } else {
                            a(campaignEx, false, (Boolean) null, (List<String>) arrayList);
                            return;
                        }
                    }
                    if (linkType == 3) {
                        arrayList.add("apk");
                        if (!com.mbridge.msdk.f.b.a()) {
                            a(campaignEx, false, (Boolean) null, (List<String>) arrayList);
                            return;
                        } else {
                            a(campaignEx, false, Boolean.TRUE, (List<String>) arrayList);
                            a(campaignEx, 2, 1, arrayList);
                            return;
                        }
                    }
                    String clickURL2 = campaignEx.getClickURL();
                    NativeListener.NativeTrackingListener nativeTrackingListener14 = this.f43041i;
                    if (nativeTrackingListener14 != null) {
                        nativeTrackingListener14.onStartRedirection(campaignEx, clickURL2);
                    }
                    if (TextUtils.isEmpty(clickURL2)) {
                        NativeListener.NativeTrackingListener nativeTrackingListener15 = this.f43041i;
                        if (nativeTrackingListener15 != null) {
                            nativeTrackingListener15.onRedirectionFailed(campaignEx, clickURL2);
                        }
                        a(jumpLoaderResultB, campaignEx, true);
                        return;
                    }
                    NativeListener.NativeTrackingListener nativeTrackingListener16 = this.f43041i;
                    if (nativeTrackingListener16 != null) {
                        nativeTrackingListener16.onFinishRedirection(campaignEx, clickURL2);
                    }
                    ah.a(this.f43039g, clickURL2, this.f43041i, campaignEx, arrayList);
                    if (com.mbridge.msdk.f.b.a()) {
                        a(jumpLoaderResultB, campaignEx, false);
                        return;
                    } else {
                        a(jumpLoaderResultB, campaignEx, true);
                        return;
                    }
                }
                String clickURL3 = campaignEx.getClickURL();
                NativeListener.NativeTrackingListener nativeTrackingListener17 = this.f43041i;
                if (nativeTrackingListener17 != null) {
                    nativeTrackingListener17.onStartRedirection(campaignEx, clickURL3);
                }
                if (TextUtils.isEmpty(clickURL3)) {
                    NativeListener.NativeTrackingListener nativeTrackingListener18 = this.f43041i;
                    if (nativeTrackingListener18 != null) {
                        nativeTrackingListener18.onRedirectionFailed(campaignEx, clickURL3);
                    }
                    a(jumpLoaderResultB, campaignEx, true);
                    return;
                }
                if (linkType == 8) {
                    if (campaignEx.getAabEntity() == null || campaignEx.getAabEntity().getHlp() != 1) {
                        ah.a(this.f43039g, clickURL3, campaignEx, this.f43041i, arrayList);
                        NativeListener.NativeTrackingListener nativeTrackingListener19 = this.f43041i;
                        if (nativeTrackingListener19 != null) {
                            nativeTrackingListener19.onFinishRedirection(campaignEx, clickURL3);
                        }
                    } else {
                        BaseTrackingListener baseTrackingListener = this.f43041i;
                        if (baseTrackingListener == null && (baseTrackingListener = this.f43048p) != null) {
                            baseTrackingListener.onStartRedirection(campaignEx, clickURL3);
                        }
                        ah.a(this.f43039g, clickURL3, campaignEx, this, baseTrackingListener, arrayList);
                    }
                    a(jumpLoaderResultB, campaignEx, false);
                    return;
                }
                if (linkType == 9) {
                    ah.a(this.f43039g, clickURL3, this.f43041i, campaignEx, arrayList);
                    a(jumpLoaderResultB, campaignEx, false);
                    NativeListener.NativeTrackingListener nativeTrackingListener20 = this.f43041i;
                    if (nativeTrackingListener20 != null) {
                        nativeTrackingListener20.onFinishRedirection(campaignEx, clickURL3);
                        return;
                    }
                    return;
                }
                if (linkType == 4) {
                    if (iB == 2) {
                        ah.a(this.f43039g, clickURL3, campaignEx, this.f43041i, arrayList);
                    } else {
                        ah.a(this.f43039g, clickURL3, this.f43041i, campaignEx, arrayList);
                    }
                }
                NativeListener.NativeTrackingListener nativeTrackingListener21 = this.f43041i;
                if (nativeTrackingListener21 != null) {
                    nativeTrackingListener21.onFinishRedirection(campaignEx, clickURL3);
                }
                a(jumpLoaderResultB, campaignEx, false);
            }
        } catch (Throwable th2) {
            if (MBridgeConstans.DEBUG) {
                ad.a("CommonClickControl", th2.getMessage(), th2);
            }
        }
    }

    public final void a(CampaignEx campaignEx, NativeListener.NativeAdListener nativeAdListener) {
        if (nativeAdListener != null && campaignEx != null) {
            nativeAdListener.onAdClick(campaignEx);
        }
        a(campaignEx);
    }

    public final void a(Campaign campaign, String str) {
        try {
            if (!TextUtils.isEmpty(str) && campaign != null) {
                CampaignEx campaignEx = campaign instanceof CampaignEx ? (CampaignEx) campaign : null;
                if ((!str.startsWith("market://") && !str.startsWith("https://play.google.com/")) || ah.a.a(this.f43039g, str, this.f43041i) || campaignEx == null) {
                    return;
                }
                if (TextUtils.isEmpty(campaignEx.getPackageName())) {
                    if (b() == 2) {
                        ah.a(this.f43039g, campaignEx.getClickURL(), campaignEx, this.f43041i, new ArrayList());
                        return;
                    } else {
                        ah.a(this.f43039g, campaignEx.getClickURL(), this.f43041i, campaignEx, new ArrayList());
                        return;
                    }
                }
                ah.a.a(this.f43039g, "market://details?id=" + campaignEx.getPackageName(), this.f43041i);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void a(NativeListener.NativeTrackingListener nativeTrackingListener) {
        this.f43041i = nativeTrackingListener;
    }

    public final void a(String str) {
        this.f43036d = str;
    }

    public final void a(boolean z11) {
        this.f43046n = z11;
    }
}
