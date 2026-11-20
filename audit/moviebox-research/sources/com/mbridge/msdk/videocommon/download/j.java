package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.download.download.HTMLResourceManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.newreward.function.common.MBridgeError;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class j {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.listener.a f48575e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> f48577g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private Context f48580j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private ExecutorService f48581k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private String f48583m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.d.c f48584n;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f48586p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private i f48587q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private boolean f48588r;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<CampaignEx> f48573c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f48574d = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f48576f = "";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private c f48578h = new c() { // from class: com.mbridge.msdk.videocommon.download.j.1
        @Override // com.mbridge.msdk.videocommon.download.c
        public final void a(long j11, int i11) {
            if (i11 == 5 || i11 == 4) {
                j.this.f48574d = true;
                j.this.a();
            }
            if (i11 == 2) {
                j.this.f48574d = true;
            }
        }
    };

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private CopyOnWriteArrayList<Map<String, a>> f48579i = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f48582l = 3600;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f48585o = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    k f48571a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    k f48572b = null;

    public j(Context context, CampaignEx campaignEx, ExecutorService executorService, String str, int i11) {
        this.f48586p = 1;
        try {
            boolean zA = h.a.f48559a.a(i11);
            this.f48588r = zA;
            if (zA) {
                this.f48583m = str;
                this.f48586p = i11;
                this.f48587q = new i(campaignEx, str, i11);
                return;
            }
        } catch (Exception unused) {
            this.f48587q = null;
            this.f48588r = false;
        }
        this.f48580j = com.mbridge.msdk.foundation.controller.c.m().c();
        List<CampaignEx> list = this.f48573c;
        if (list != null && campaignEx != null) {
            list.add(campaignEx);
        }
        this.f48581k = executorService;
        this.f48583m = str;
        this.f48586p = i11;
        b(this.f48573c);
    }

    public j(Context context, List<CampaignEx> list, ExecutorService executorService, String str, int i11) {
        this.f48586p = 1;
        try {
            boolean zA = h.a.f48559a.a(i11);
            this.f48588r = zA;
            if (zA) {
                this.f48583m = str;
                this.f48586p = i11;
                this.f48587q = new i(list, str, i11);
                return;
            }
        } catch (Exception unused) {
            this.f48587q = null;
            this.f48588r = false;
        }
        this.f48580j = com.mbridge.msdk.foundation.controller.c.m().c();
        List<CampaignEx> list2 = this.f48573c;
        if (list2 != null && list != null) {
            list2.addAll(list);
        }
        this.f48581k = executorService;
        this.f48583m = str;
        this.f48586p = i11;
        b(this.f48573c);
    }

    private boolean a(int i11, CampaignEx campaignEx, String str) {
        if (campaignEx.isDynamicView()) {
            return true;
        }
        if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(1)) {
            ad.c("UnitCacheCtroller", "Is not check template download status");
            return true;
        }
        if (!TextUtils.isEmpty(str) && campaignEx.getLoadTimeoutState() == 0) {
            ad.a("UnitCacheCtroller", "check template 下载情况：" + H5DownLoadManager.getInstance().getH5ResAddress(str));
            if (H5DownLoadManager.getInstance().getH5ResAddress(str) == null) {
                return false;
            }
        }
        return true;
    }

    public static boolean a(a aVar, int i11) {
        long jM = aVar.m();
        long j11 = aVar.j();
        if (TextUtils.isEmpty(aVar.e())) {
            ad.a("UnitCacheCtroller", "checkVideoDownload video done return true");
            return true;
        }
        if (i11 == 0) {
            if (aVar.l() != null && !TextUtils.isEmpty(aVar.l().getVideoUrlEncode())) {
                return true;
            }
        } else if (j11 > 0 && jM * 100 >= j11 * ((long) i11)) {
            if (i11 != 100 || aVar.k() == 5) {
                return true;
            }
            aVar.s();
            return false;
        }
        return false;
    }

    private static boolean a(a aVar, int i11, boolean z11) {
        long jM = aVar.m();
        long j11 = aVar.j();
        if (TextUtils.isEmpty(aVar.e())) {
            ad.a("UnitCacheCtroller", "checkVideoDownload video done return true");
            return true;
        }
        CampaignEx campaignExL = aVar.l();
        if (campaignExL != null) {
            if (campaignExL.getRsIgnoreCheckRule() != null && campaignExL.getRsIgnoreCheckRule().size() > 0 && campaignExL.getRsIgnoreCheckRule().contains(0)) {
                ad.c("UnitCacheCtroller", "Is not check video download status");
                return true;
            }
            if (campaignExL.getIsTimeoutCheckVideoStatus() == 1 && campaignExL.getVideoCheckType() == 1) {
                return true;
            }
            if (z11 && campaignExL.getVideoCheckType() == 1) {
                if (i11 == 0) {
                    return true;
                }
                if ((j11 != 0 || jM != 0) && jM >= ((long) (i11 / 100)) * j11) {
                    campaignExL.setIsTimeoutCheckVideoStatus(1);
                    return true;
                }
            }
        }
        return a(aVar, i11);
    }

    private boolean a(String str, CampaignEx campaignEx) {
        try {
            if (campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(2)) {
                return (campaignEx.isDynamicView() && !ai.l(str)) || an.a(str) || b(str, campaignEx);
            }
            ad.c("UnitCacheCtroller", "Is not check endCard download status : " + str);
            return true;
        } catch (Throwable th2) {
            ad.a("UnitCacheCtroller", th2.getMessage(), th2);
            return false;
        }
    }

    private boolean a(CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList) {
        try {
            for (Map<String, a> map : copyOnWriteArrayList) {
                if (map != null) {
                    Iterator<Map.Entry<String, a>> it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        if (it.next().getValue().k() == 1) {
                            return true;
                        }
                    }
                }
            }
            return false;
        } catch (Throwable th2) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            th2.printStackTrace();
            return false;
        }
    }

    private int b(CampaignEx campaignEx) {
        if (campaignEx != null) {
            return campaignEx.getReady_rate() != -1 ? campaignEx.getReady_rate() : e(campaignEx);
        }
        return -1;
    }

    /* JADX WARN: Code duplicated, block: B:115:0x00b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x00bc A[Catch: Exception -> 0x00f2, TryCatch #3 {Exception -> 0x00f2, blocks: (B:34:0x00b2, B:36:0x00bc, B:38:0x00c5, B:39:0x00cb, B:41:0x00d3, B:42:0x00e7, B:44:0x00eb), top: B:115:0x00b2 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x00c5 A[Catch: Exception -> 0x00f2, TryCatch #3 {Exception -> 0x00f2, blocks: (B:34:0x00b2, B:36:0x00bc, B:38:0x00c5, B:39:0x00cb, B:41:0x00d3, B:42:0x00e7, B:44:0x00eb), top: B:115:0x00b2 }] */
    /* JADX WARN: Code duplicated, block: B:41:0x00d3 A[Catch: Exception -> 0x00f2, TryCatch #3 {Exception -> 0x00f2, blocks: (B:34:0x00b2, B:36:0x00bc, B:38:0x00c5, B:39:0x00cb, B:41:0x00d3, B:42:0x00e7, B:44:0x00eb), top: B:115:0x00b2 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x00eb A[Catch: Exception -> 0x00f2, TRY_LEAVE, TryCatch #3 {Exception -> 0x00f2, blocks: (B:34:0x00b2, B:36:0x00bc, B:38:0x00c5, B:39:0x00cb, B:41:0x00d3, B:42:0x00e7, B:44:0x00eb), top: B:115:0x00b2 }] */
    private void b(List<CampaignEx> list) {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList;
        com.mbridge.msdk.videocommon.d.a aVarB;
        com.mbridge.msdk.videocommon.d.c cVar;
        if (list == null || list.size() == 0) {
            return;
        }
        if (list.get(0) != null) {
            this.f48576f = list.get(0).getCurrentLocalRid();
        }
        e();
        d();
        int i11 = this.f48586p;
        if (i11 == 1) {
            try {
                if (!TextUtils.isEmpty(this.f48583m)) {
                    k kVarD = com.mbridge.msdk.c.h.a().d(com.mbridge.msdk.foundation.controller.c.m().k(), this.f48583m);
                    this.f48571a = kVarD;
                    if (kVarD == null) {
                        this.f48571a = k.d(this.f48583m);
                    }
                    k kVar = this.f48571a;
                    if (kVar != null) {
                        this.f48582l = kVar.j();
                        this.f48585o = this.f48571a.k();
                    }
                }
            } catch (Exception unused) {
                ad.b("UnitCacheCtroller", "make sure your had put native video jar into your project");
                return;
            }
        } else if (i11 == 287) {
            try {
                aVarB = com.mbridge.msdk.videocommon.d.b.a().b();
                if (aVarB == null) {
                    com.mbridge.msdk.videocommon.d.b.a().c();
                }
                if (aVarB != null) {
                    this.f48582l = aVarB.g();
                }
                if (!TextUtils.isEmpty(this.f48583m)) {
                    this.f48584n = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f48583m);
                }
                cVar = this.f48584n;
                if (cVar != null) {
                    this.f48585o = cVar.w();
                }
            } catch (Exception unused2) {
                ad.b("UnitCacheCtroller", "make sure your had put reward jar into your project");
                return;
            }
        } else if (i11 == 298) {
            k kVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k(), this.f48583m);
            this.f48572b = kVarB;
            if (kVarB == null) {
                this.f48572b = com.mbridge.msdk.c.h.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f48583m);
            }
            k kVar2 = this.f48572b;
            if (kVar2 != null) {
                this.f48582l = kVar2.j();
                this.f48585o = this.f48572b.k();
            }
        } else if (i11 == 94) {
            aVarB = com.mbridge.msdk.videocommon.d.b.a().b();
            if (aVarB == null) {
                com.mbridge.msdk.videocommon.d.b.a().c();
            }
            if (aVarB != null) {
                this.f48582l = aVarB.g();
            }
            if (!TextUtils.isEmpty(this.f48583m)) {
                this.f48584n = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f48583m);
            }
            cVar = this.f48584n;
            if (cVar != null) {
                this.f48585o = cVar.w();
            }
        } else if (i11 == 95) {
            try {
                if (!TextUtils.isEmpty(this.f48583m)) {
                    k kVarD2 = com.mbridge.msdk.c.h.a().d(com.mbridge.msdk.foundation.controller.c.m().k(), this.f48583m);
                    if (kVarD2 == null) {
                        kVarD2 = k.e(this.f48583m);
                    }
                    if (kVarD2 != null) {
                        this.f48582l = kVarD2.j();
                        this.f48585o = kVarD2.k();
                    }
                }
            } catch (Exception unused3) {
                ad.b("UnitCacheCtroller", "make sure your had put feeds jar into your project");
                return;
            }
        }
        for (int i12 = 0; i12 < list.size(); i12++) {
            CampaignEx campaignEx = list.get(i12);
            if (campaignEx != null) {
                int i13 = this.f48586p;
                String str = (i13 == 94 || i13 == 287) ? campaignEx.getRequestId() + campaignEx.getId() + campaignEx.getVideoUrlEncode() : campaignEx.getId() + campaignEx.getVideoUrlEncode() + campaignEx.getBidToken();
                if ((c(campaignEx) || !TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) && (copyOnWriteArrayList = this.f48579i) != null) {
                    synchronized (copyOnWriteArrayList) {
                        int i14 = 0;
                        while (true) {
                            try {
                                if (i14 >= this.f48579i.size()) {
                                    a aVar = new a(this.f48580j, campaignEx, this.f48583m, this.f48585o);
                                    aVar.a(this.f48585o);
                                    aVar.d(this.f48586p);
                                    HashMap map = new HashMap();
                                    map.put(str, aVar);
                                    this.f48579i.add(map);
                                    break;
                                }
                                Map<String, a> map2 = this.f48579i.get(i14);
                                if (map2 != null && map2.containsKey(str)) {
                                    a aVar2 = map2.get(str);
                                    if (aVar2 != null) {
                                        aVar2.a(campaignEx);
                                        aVar2.a(this.f48585o);
                                        aVar2.e(false);
                                        map2.remove(str);
                                        map2.put(str, aVar2);
                                        this.f48579i.set(i14, map2);
                                    }
                                    f(campaignEx);
                                    break;
                                }
                                i14++;
                            } catch (Throwable th2) {
                                if (MBridgeConstans.DEBUG) {
                                    ad.b("UnitCacheCtroller", th2.getMessage());
                                }
                            }
                        }
                        try {
                        } catch (Throwable th3) {
                            throw th3;
                        }
                    }
                }
            }
        }
        List<CampaignEx> list2 = this.f48573c;
        if (list2 == null || list2.size() <= 0) {
            return;
        }
        this.f48573c.clear();
    }

    private boolean b(String str, CampaignEx campaignEx) {
        if (campaignEx.isMraid() || TextUtils.isEmpty(str)) {
            return true;
        }
        if (campaignEx.getLoadTimeoutState() == 1 && !c(campaignEx)) {
            return true;
        }
        if (campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(2)) {
            return an.b(H5DownLoadManager.getInstance().getH5ResAddress(str)) || an.b(HTMLResourceManager.getInstance().getHtmlContentFromUrl(str));
        }
        ad.c("UnitCacheCtroller", "Is not check endCard download status : " + str);
        return true;
    }

    private boolean c(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return false;
        }
        try {
            return campaignEx.getPlayable_ads_without_video() == 2;
        } catch (Throwable th2) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            th2.printStackTrace();
            return false;
        }
    }

    private int d(CampaignEx campaignEx) {
        try {
            k kVar = this.f48571a;
            if (kVar != null) {
                return kVar.p();
            }
            return 100;
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return 100;
            }
            ad.b("UnitCacheCtroller", e11.getMessage());
            return 100;
        }
    }

    private void d() {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList;
        if ((this.f48588r && this.f48587q != null) || af.a().a("u_n_c_e_d", true) || (copyOnWriteArrayList = this.f48579i) == null) {
            return;
        }
        try {
            synchronized (copyOnWriteArrayList) {
                try {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    int i11 = 0;
                    while (i11 < this.f48579i.size()) {
                        Map<String, a> map = this.f48579i.get(i11);
                        Iterator<Map.Entry<String, a>> it = map.entrySet().iterator();
                        while (it.hasNext()) {
                            a value = it.next().getValue();
                            if (value != null) {
                                if (jCurrentTimeMillis - value.g() > this.f48582l * 1000 && value.k() == 1) {
                                    value.b(MBridgeError.ERROR_MESSAGE_DOWNLOAD_DOWNLOAD_TIMEOUT);
                                    value.a(this.f48585o);
                                    value.s();
                                    this.f48579i.remove(map);
                                    i11--;
                                }
                                if (value.k() != 1 && value.k() != 5 && value.k() != 0) {
                                    value.s();
                                    this.f48579i.remove(map);
                                    i11--;
                                }
                            }
                        }
                        i11++;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    private int e(CampaignEx campaignEx) {
        try {
            if (campaignEx.getAdType() == 298) {
                if (this.f48572b == null) {
                    this.f48572b = com.mbridge.msdk.c.h.a().c(com.mbridge.msdk.foundation.controller.c.m().k(), this.f48583m);
                }
                return this.f48572b.p();
            }
            if (campaignEx.getAdType() == 42) {
                return d(null);
            }
            if (this.f48584n == null) {
                this.f48584n = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f48583m, false);
            }
            return this.f48584n.r();
        } catch (Throwable th2) {
            ad.a("UnitCacheCtroller", th2.getMessage(), th2);
            return 100;
        }
    }

    private void e() {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList = this.f48579i;
        if (copyOnWriteArrayList != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    int i11 = 0;
                    while (i11 < this.f48579i.size()) {
                        try {
                            Map<String, a> map = this.f48579i.get(i11);
                            Iterator<Map.Entry<String, a>> it = map.entrySet().iterator();
                            while (it.hasNext()) {
                                a value = it.next().getValue();
                                if (value != null && value.l() != null && value.f()) {
                                    value.r();
                                    this.f48579i.remove(map);
                                    i11--;
                                }
                            }
                            i11++;
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
            } catch (Throwable unused) {
                ad.b("UnitCacheCtroller", "cleanDisplayTask ERROR");
            }
        }
    }

    private void f(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                com.mbridge.msdk.foundation.same.report.d.d dVar = new com.mbridge.msdk.foundation.same.report.d.d();
                dVar.a("cache", 1);
                dVar.a(CampaignEx.JSON_KEY_READY_RATE, Integer.valueOf(b(campaignEx)));
                if (b(campaignEx) == 100) {
                    dVar.a("resumed_breakpoint", "2");
                } else {
                    dVar.a("resumed_breakpoint", "1");
                }
                dVar.a("resource_type", 4);
                dVar.a("scenes", "1");
                dVar.a("url", campaignEx.getVideoUrlEncode());
                com.mbridge.msdk.foundation.same.report.d.c.a().a("m_download_start", campaignEx, dVar);
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:104:0x01a4 A[Catch: all -> 0x0033, DONT_GENERATE, TRY_ENTER, TryCatch #0 {, blocks: (B:11:0x0019, B:15:0x0025, B:17:0x0031, B:32:0x0077, B:33:0x007c, B:35:0x0084, B:36:0x0094, B:38:0x009a, B:40:0x00a8, B:43:0x00b2, B:44:0x00bc, B:46:0x00c2, B:53:0x00df, B:56:0x00e7, B:59:0x00ee, B:61:0x00fe, B:62:0x0106, B:86:0x0155, B:88:0x0167, B:90:0x0171, B:94:0x0178, B:96:0x017e, B:98:0x0194, B:100:0x019c, B:102:0x019e, B:104:0x01a4, B:106:0x01a6, B:110:0x01aa, B:112:0x01b7, B:114:0x01c1, B:116:0x01ce, B:123:0x01f2, B:125:0x01f8, B:127:0x01fe, B:129:0x0209, B:131:0x020b, B:139:0x0221, B:141:0x022c, B:145:0x0237, B:147:0x023b, B:149:0x0245, B:151:0x024b, B:153:0x024d, B:156:0x0257, B:158:0x0261, B:160:0x0267, B:66:0x0113, B:68:0x0119, B:70:0x0123, B:73:0x0131, B:75:0x0137, B:77:0x013d, B:78:0x0141, B:80:0x0147, B:82:0x0149, B:84:0x0153, B:169:0x028b, B:23:0x0039, B:25:0x0045, B:31:0x005d, B:164:0x027e, B:165:0x0285, B:29:0x004f, B:168:0x0288), top: B:175:0x0019, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x01a6 A[Catch: all -> 0x0033, DONT_GENERATE, TRY_LEAVE, TryCatch #0 {, blocks: (B:11:0x0019, B:15:0x0025, B:17:0x0031, B:32:0x0077, B:33:0x007c, B:35:0x0084, B:36:0x0094, B:38:0x009a, B:40:0x00a8, B:43:0x00b2, B:44:0x00bc, B:46:0x00c2, B:53:0x00df, B:56:0x00e7, B:59:0x00ee, B:61:0x00fe, B:62:0x0106, B:86:0x0155, B:88:0x0167, B:90:0x0171, B:94:0x0178, B:96:0x017e, B:98:0x0194, B:100:0x019c, B:102:0x019e, B:104:0x01a4, B:106:0x01a6, B:110:0x01aa, B:112:0x01b7, B:114:0x01c1, B:116:0x01ce, B:123:0x01f2, B:125:0x01f8, B:127:0x01fe, B:129:0x0209, B:131:0x020b, B:139:0x0221, B:141:0x022c, B:145:0x0237, B:147:0x023b, B:149:0x0245, B:151:0x024b, B:153:0x024d, B:156:0x0257, B:158:0x0261, B:160:0x0267, B:66:0x0113, B:68:0x0119, B:70:0x0123, B:73:0x0131, B:75:0x0137, B:77:0x013d, B:78:0x0141, B:80:0x0147, B:82:0x0149, B:84:0x0153, B:169:0x028b, B:23:0x0039, B:25:0x0045, B:31:0x005d, B:164:0x027e, B:165:0x0285, B:29:0x004f, B:168:0x0288), top: B:175:0x0019, inners: #1 }] */
    /* JADX WARN: Code duplicated, block: B:112:0x01b7 A[Catch: all -> 0x0033, Exception -> 0x0036, TryCatch #1 {Exception -> 0x0036, blocks: (B:11:0x0019, B:15:0x0025, B:32:0x0077, B:33:0x007c, B:35:0x0084, B:36:0x0094, B:38:0x009a, B:40:0x00a8, B:43:0x00b2, B:44:0x00bc, B:46:0x00c2, B:53:0x00df, B:56:0x00e7, B:59:0x00ee, B:61:0x00fe, B:62:0x0106, B:86:0x0155, B:88:0x0167, B:94:0x0178, B:96:0x017e, B:98:0x0194, B:102:0x019e, B:110:0x01aa, B:112:0x01b7, B:114:0x01c1, B:116:0x01ce, B:123:0x01f2, B:125:0x01f8, B:127:0x01fe, B:131:0x020b, B:139:0x0221, B:141:0x022c, B:145:0x0237, B:147:0x023b, B:149:0x0245, B:153:0x024d, B:156:0x0257, B:158:0x0261, B:66:0x0113, B:68:0x0119, B:70:0x0123, B:73:0x0131, B:75:0x0137, B:77:0x013d, B:78:0x0141, B:82:0x0149, B:23:0x0039, B:25:0x0045, B:31:0x005d, B:164:0x027e, B:29:0x004f), top: B:175:0x0019, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:114:0x01c1 A[Catch: all -> 0x0033, Exception -> 0x0036, TryCatch #1 {Exception -> 0x0036, blocks: (B:11:0x0019, B:15:0x0025, B:32:0x0077, B:33:0x007c, B:35:0x0084, B:36:0x0094, B:38:0x009a, B:40:0x00a8, B:43:0x00b2, B:44:0x00bc, B:46:0x00c2, B:53:0x00df, B:56:0x00e7, B:59:0x00ee, B:61:0x00fe, B:62:0x0106, B:86:0x0155, B:88:0x0167, B:94:0x0178, B:96:0x017e, B:98:0x0194, B:102:0x019e, B:110:0x01aa, B:112:0x01b7, B:114:0x01c1, B:116:0x01ce, B:123:0x01f2, B:125:0x01f8, B:127:0x01fe, B:131:0x020b, B:139:0x0221, B:141:0x022c, B:145:0x0237, B:147:0x023b, B:149:0x0245, B:153:0x024d, B:156:0x0257, B:158:0x0261, B:66:0x0113, B:68:0x0119, B:70:0x0123, B:73:0x0131, B:75:0x0137, B:77:0x013d, B:78:0x0141, B:82:0x0149, B:23:0x0039, B:25:0x0045, B:31:0x005d, B:164:0x027e, B:29:0x004f), top: B:175:0x0019, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:116:0x01ce A[Catch: all -> 0x0033, Exception -> 0x0036, TryCatch #1 {Exception -> 0x0036, blocks: (B:11:0x0019, B:15:0x0025, B:32:0x0077, B:33:0x007c, B:35:0x0084, B:36:0x0094, B:38:0x009a, B:40:0x00a8, B:43:0x00b2, B:44:0x00bc, B:46:0x00c2, B:53:0x00df, B:56:0x00e7, B:59:0x00ee, B:61:0x00fe, B:62:0x0106, B:86:0x0155, B:88:0x0167, B:94:0x0178, B:96:0x017e, B:98:0x0194, B:102:0x019e, B:110:0x01aa, B:112:0x01b7, B:114:0x01c1, B:116:0x01ce, B:123:0x01f2, B:125:0x01f8, B:127:0x01fe, B:131:0x020b, B:139:0x0221, B:141:0x022c, B:145:0x0237, B:147:0x023b, B:149:0x0245, B:153:0x024d, B:156:0x0257, B:158:0x0261, B:66:0x0113, B:68:0x0119, B:70:0x0123, B:73:0x0131, B:75:0x0137, B:77:0x013d, B:78:0x0141, B:82:0x0149, B:23:0x0039, B:25:0x0045, B:31:0x005d, B:164:0x027e, B:29:0x004f), top: B:175:0x0019, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:118:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:122:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:125:0x01f8 A[Catch: all -> 0x0033, Exception -> 0x0036, TryCatch #1 {Exception -> 0x0036, blocks: (B:11:0x0019, B:15:0x0025, B:32:0x0077, B:33:0x007c, B:35:0x0084, B:36:0x0094, B:38:0x009a, B:40:0x00a8, B:43:0x00b2, B:44:0x00bc, B:46:0x00c2, B:53:0x00df, B:56:0x00e7, B:59:0x00ee, B:61:0x00fe, B:62:0x0106, B:86:0x0155, B:88:0x0167, B:94:0x0178, B:96:0x017e, B:98:0x0194, B:102:0x019e, B:110:0x01aa, B:112:0x01b7, B:114:0x01c1, B:116:0x01ce, B:123:0x01f2, B:125:0x01f8, B:127:0x01fe, B:131:0x020b, B:139:0x0221, B:141:0x022c, B:145:0x0237, B:147:0x023b, B:149:0x0245, B:153:0x024d, B:156:0x0257, B:158:0x0261, B:66:0x0113, B:68:0x0119, B:70:0x0123, B:73:0x0131, B:75:0x0137, B:77:0x013d, B:78:0x0141, B:82:0x0149, B:23:0x0039, B:25:0x0045, B:31:0x005d, B:164:0x027e, B:29:0x004f), top: B:175:0x0019, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:127:0x01fe A[Catch: all -> 0x0033, Exception -> 0x0036, TRY_LEAVE, TryCatch #1 {Exception -> 0x0036, blocks: (B:11:0x0019, B:15:0x0025, B:32:0x0077, B:33:0x007c, B:35:0x0084, B:36:0x0094, B:38:0x009a, B:40:0x00a8, B:43:0x00b2, B:44:0x00bc, B:46:0x00c2, B:53:0x00df, B:56:0x00e7, B:59:0x00ee, B:61:0x00fe, B:62:0x0106, B:86:0x0155, B:88:0x0167, B:94:0x0178, B:96:0x017e, B:98:0x0194, B:102:0x019e, B:110:0x01aa, B:112:0x01b7, B:114:0x01c1, B:116:0x01ce, B:123:0x01f2, B:125:0x01f8, B:127:0x01fe, B:131:0x020b, B:139:0x0221, B:141:0x022c, B:145:0x0237, B:147:0x023b, B:149:0x0245, B:153:0x024d, B:156:0x0257, B:158:0x0261, B:66:0x0113, B:68:0x0119, B:70:0x0123, B:73:0x0131, B:75:0x0137, B:77:0x013d, B:78:0x0141, B:82:0x0149, B:23:0x0039, B:25:0x0045, B:31:0x005d, B:164:0x027e, B:29:0x004f), top: B:175:0x0019, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:131:0x020b A[Catch: all -> 0x0033, Exception -> 0x0036, TRY_ENTER, TryCatch #1 {Exception -> 0x0036, blocks: (B:11:0x0019, B:15:0x0025, B:32:0x0077, B:33:0x007c, B:35:0x0084, B:36:0x0094, B:38:0x009a, B:40:0x00a8, B:43:0x00b2, B:44:0x00bc, B:46:0x00c2, B:53:0x00df, B:56:0x00e7, B:59:0x00ee, B:61:0x00fe, B:62:0x0106, B:86:0x0155, B:88:0x0167, B:94:0x0178, B:96:0x017e, B:98:0x0194, B:102:0x019e, B:110:0x01aa, B:112:0x01b7, B:114:0x01c1, B:116:0x01ce, B:123:0x01f2, B:125:0x01f8, B:127:0x01fe, B:131:0x020b, B:139:0x0221, B:141:0x022c, B:145:0x0237, B:147:0x023b, B:149:0x0245, B:153:0x024d, B:156:0x0257, B:158:0x0261, B:66:0x0113, B:68:0x0119, B:70:0x0123, B:73:0x0131, B:75:0x0137, B:77:0x013d, B:78:0x0141, B:82:0x0149, B:23:0x0039, B:25:0x0045, B:31:0x005d, B:164:0x027e, B:29:0x004f), top: B:175:0x0019, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:133:0x0218  */
    /* JADX WARN: Code duplicated, block: B:141:0x022c A[Catch: all -> 0x0033, Exception -> 0x0036, TryCatch #1 {Exception -> 0x0036, blocks: (B:11:0x0019, B:15:0x0025, B:32:0x0077, B:33:0x007c, B:35:0x0084, B:36:0x0094, B:38:0x009a, B:40:0x00a8, B:43:0x00b2, B:44:0x00bc, B:46:0x00c2, B:53:0x00df, B:56:0x00e7, B:59:0x00ee, B:61:0x00fe, B:62:0x0106, B:86:0x0155, B:88:0x0167, B:94:0x0178, B:96:0x017e, B:98:0x0194, B:102:0x019e, B:110:0x01aa, B:112:0x01b7, B:114:0x01c1, B:116:0x01ce, B:123:0x01f2, B:125:0x01f8, B:127:0x01fe, B:131:0x020b, B:139:0x0221, B:141:0x022c, B:145:0x0237, B:147:0x023b, B:149:0x0245, B:153:0x024d, B:156:0x0257, B:158:0x0261, B:66:0x0113, B:68:0x0119, B:70:0x0123, B:73:0x0131, B:75:0x0137, B:77:0x013d, B:78:0x0141, B:82:0x0149, B:23:0x0039, B:25:0x0045, B:31:0x005d, B:164:0x027e, B:29:0x004f), top: B:175:0x0019, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:143:0x0232  */
    /* JADX WARN: Code duplicated, block: B:145:0x0237 A[Catch: all -> 0x0033, Exception -> 0x0036, TryCatch #1 {Exception -> 0x0036, blocks: (B:11:0x0019, B:15:0x0025, B:32:0x0077, B:33:0x007c, B:35:0x0084, B:36:0x0094, B:38:0x009a, B:40:0x00a8, B:43:0x00b2, B:44:0x00bc, B:46:0x00c2, B:53:0x00df, B:56:0x00e7, B:59:0x00ee, B:61:0x00fe, B:62:0x0106, B:86:0x0155, B:88:0x0167, B:94:0x0178, B:96:0x017e, B:98:0x0194, B:102:0x019e, B:110:0x01aa, B:112:0x01b7, B:114:0x01c1, B:116:0x01ce, B:123:0x01f2, B:125:0x01f8, B:127:0x01fe, B:131:0x020b, B:139:0x0221, B:141:0x022c, B:145:0x0237, B:147:0x023b, B:149:0x0245, B:153:0x024d, B:156:0x0257, B:158:0x0261, B:66:0x0113, B:68:0x0119, B:70:0x0123, B:73:0x0131, B:75:0x0137, B:77:0x013d, B:78:0x0141, B:82:0x0149, B:23:0x0039, B:25:0x0045, B:31:0x005d, B:164:0x027e, B:29:0x004f), top: B:175:0x0019, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:147:0x023b A[Catch: all -> 0x0033, Exception -> 0x0036, TryCatch #1 {Exception -> 0x0036, blocks: (B:11:0x0019, B:15:0x0025, B:32:0x0077, B:33:0x007c, B:35:0x0084, B:36:0x0094, B:38:0x009a, B:40:0x00a8, B:43:0x00b2, B:44:0x00bc, B:46:0x00c2, B:53:0x00df, B:56:0x00e7, B:59:0x00ee, B:61:0x00fe, B:62:0x0106, B:86:0x0155, B:88:0x0167, B:94:0x0178, B:96:0x017e, B:98:0x0194, B:102:0x019e, B:110:0x01aa, B:112:0x01b7, B:114:0x01c1, B:116:0x01ce, B:123:0x01f2, B:125:0x01f8, B:127:0x01fe, B:131:0x020b, B:139:0x0221, B:141:0x022c, B:145:0x0237, B:147:0x023b, B:149:0x0245, B:153:0x024d, B:156:0x0257, B:158:0x0261, B:66:0x0113, B:68:0x0119, B:70:0x0123, B:73:0x0131, B:75:0x0137, B:77:0x013d, B:78:0x0141, B:82:0x0149, B:23:0x0039, B:25:0x0045, B:31:0x005d, B:164:0x027e, B:29:0x004f), top: B:175:0x0019, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:155:0x0255 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:156:0x0257 A[Catch: all -> 0x0033, Exception -> 0x0036, TryCatch #1 {Exception -> 0x0036, blocks: (B:11:0x0019, B:15:0x0025, B:32:0x0077, B:33:0x007c, B:35:0x0084, B:36:0x0094, B:38:0x009a, B:40:0x00a8, B:43:0x00b2, B:44:0x00bc, B:46:0x00c2, B:53:0x00df, B:56:0x00e7, B:59:0x00ee, B:61:0x00fe, B:62:0x0106, B:86:0x0155, B:88:0x0167, B:94:0x0178, B:96:0x017e, B:98:0x0194, B:102:0x019e, B:110:0x01aa, B:112:0x01b7, B:114:0x01c1, B:116:0x01ce, B:123:0x01f2, B:125:0x01f8, B:127:0x01fe, B:131:0x020b, B:139:0x0221, B:141:0x022c, B:145:0x0237, B:147:0x023b, B:149:0x0245, B:153:0x024d, B:156:0x0257, B:158:0x0261, B:66:0x0113, B:68:0x0119, B:70:0x0123, B:73:0x0131, B:75:0x0137, B:77:0x013d, B:78:0x0141, B:82:0x0149, B:23:0x0039, B:25:0x0045, B:31:0x005d, B:164:0x027e, B:29:0x004f), top: B:175:0x0019, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:180:0x019e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:181:0x019c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:182:0x0209 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:193:0x01a9 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:194:0x0192 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:195:0x017e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:86:0x0155 A[Catch: all -> 0x0033, Exception -> 0x0036, TRY_ENTER, TryCatch #1 {Exception -> 0x0036, blocks: (B:11:0x0019, B:15:0x0025, B:32:0x0077, B:33:0x007c, B:35:0x0084, B:36:0x0094, B:38:0x009a, B:40:0x00a8, B:43:0x00b2, B:44:0x00bc, B:46:0x00c2, B:53:0x00df, B:56:0x00e7, B:59:0x00ee, B:61:0x00fe, B:62:0x0106, B:86:0x0155, B:88:0x0167, B:94:0x0178, B:96:0x017e, B:98:0x0194, B:102:0x019e, B:110:0x01aa, B:112:0x01b7, B:114:0x01c1, B:116:0x01ce, B:123:0x01f2, B:125:0x01f8, B:127:0x01fe, B:131:0x020b, B:139:0x0221, B:141:0x022c, B:145:0x0237, B:147:0x023b, B:149:0x0245, B:153:0x024d, B:156:0x0257, B:158:0x0261, B:66:0x0113, B:68:0x0119, B:70:0x0123, B:73:0x0131, B:75:0x0137, B:77:0x013d, B:78:0x0141, B:82:0x0149, B:23:0x0039, B:25:0x0045, B:31:0x005d, B:164:0x027e, B:29:0x004f), top: B:175:0x0019, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x0167 A[Catch: all -> 0x0033, Exception -> 0x0036, TRY_LEAVE, TryCatch #1 {Exception -> 0x0036, blocks: (B:11:0x0019, B:15:0x0025, B:32:0x0077, B:33:0x007c, B:35:0x0084, B:36:0x0094, B:38:0x009a, B:40:0x00a8, B:43:0x00b2, B:44:0x00bc, B:46:0x00c2, B:53:0x00df, B:56:0x00e7, B:59:0x00ee, B:61:0x00fe, B:62:0x0106, B:86:0x0155, B:88:0x0167, B:94:0x0178, B:96:0x017e, B:98:0x0194, B:102:0x019e, B:110:0x01aa, B:112:0x01b7, B:114:0x01c1, B:116:0x01ce, B:123:0x01f2, B:125:0x01f8, B:127:0x01fe, B:131:0x020b, B:139:0x0221, B:141:0x022c, B:145:0x0237, B:147:0x023b, B:149:0x0245, B:153:0x024d, B:156:0x0257, B:158:0x0261, B:66:0x0113, B:68:0x0119, B:70:0x0123, B:73:0x0131, B:75:0x0137, B:77:0x013d, B:78:0x0141, B:82:0x0149, B:23:0x0039, B:25:0x0045, B:31:0x005d, B:164:0x027e, B:29:0x004f), top: B:175:0x0019, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:94:0x0178 A[Catch: all -> 0x0033, Exception -> 0x0036, TRY_ENTER, TryCatch #1 {Exception -> 0x0036, blocks: (B:11:0x0019, B:15:0x0025, B:32:0x0077, B:33:0x007c, B:35:0x0084, B:36:0x0094, B:38:0x009a, B:40:0x00a8, B:43:0x00b2, B:44:0x00bc, B:46:0x00c2, B:53:0x00df, B:56:0x00e7, B:59:0x00ee, B:61:0x00fe, B:62:0x0106, B:86:0x0155, B:88:0x0167, B:94:0x0178, B:96:0x017e, B:98:0x0194, B:102:0x019e, B:110:0x01aa, B:112:0x01b7, B:114:0x01c1, B:116:0x01ce, B:123:0x01f2, B:125:0x01f8, B:127:0x01fe, B:131:0x020b, B:139:0x0221, B:141:0x022c, B:145:0x0237, B:147:0x023b, B:149:0x0245, B:153:0x024d, B:156:0x0257, B:158:0x0261, B:66:0x0113, B:68:0x0119, B:70:0x0123, B:73:0x0131, B:75:0x0137, B:77:0x013d, B:78:0x0141, B:82:0x0149, B:23:0x0039, B:25:0x0045, B:31:0x005d, B:164:0x027e, B:29:0x004f), top: B:175:0x0019, outer: #0 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x0194 A[Catch: all -> 0x0033, Exception -> 0x0036, TRY_LEAVE, TryCatch #1 {Exception -> 0x0036, blocks: (B:11:0x0019, B:15:0x0025, B:32:0x0077, B:33:0x007c, B:35:0x0084, B:36:0x0094, B:38:0x009a, B:40:0x00a8, B:43:0x00b2, B:44:0x00bc, B:46:0x00c2, B:53:0x00df, B:56:0x00e7, B:59:0x00ee, B:61:0x00fe, B:62:0x0106, B:86:0x0155, B:88:0x0167, B:94:0x0178, B:96:0x017e, B:98:0x0194, B:102:0x019e, B:110:0x01aa, B:112:0x01b7, B:114:0x01c1, B:116:0x01ce, B:123:0x01f2, B:125:0x01f8, B:127:0x01fe, B:131:0x020b, B:139:0x0221, B:141:0x022c, B:145:0x0237, B:147:0x023b, B:149:0x0245, B:153:0x024d, B:156:0x0257, B:158:0x0261, B:66:0x0113, B:68:0x0119, B:70:0x0123, B:73:0x0131, B:75:0x0137, B:77:0x013d, B:78:0x0141, B:82:0x0149, B:23:0x0039, B:25:0x0045, B:31:0x005d, B:164:0x027e, B:29:0x004f), top: B:175:0x0019, outer: #0 }] */
    public final a a(int i11, boolean z11) {
        List<CampaignEx> listA;
        List<CampaignEx> list;
        boolean zIsEmpty;
        int iK;
        int i12;
        long jG;
        int i13;
        i iVar;
        i11 = i11;
        if (this.f48588r && (iVar = this.f48587q) != null) {
            return iVar.b();
        }
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList = this.f48579i;
        if (copyOnWriteArrayList == null) {
            return null;
        }
        synchronized (copyOnWriteArrayList) {
            try {
                int i14 = this.f48586p;
                int i15 = 94;
                if (i14 == 94 || i14 == 287) {
                    listA = com.mbridge.msdk.videocommon.a.a.a().a(this.f48583m, 1, z11);
                    if ((listA == null || listA.size() == 0) && (i11 == 94 || i11 == 287)) {
                        listA = com.mbridge.msdk.videocommon.a.a.a().c(this.f48583m, 1, z11, "");
                    }
                    if (listA == null) {
                        ad.a("UnitCacheCtroller", "UnitCache isReady campaignList = 0");
                        return null;
                    }
                    ad.a("UnitCacheCtroller", "UnitCache isReady campaignList = " + listA.size());
                } else {
                    listA = com.mbridge.msdk.videocommon.a.a.a().a(this.f48583m, 1);
                    if (listA == null) {
                        return null;
                    }
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                int i16 = 0;
                while (i16 < this.f48579i.size()) {
                    Map<String, a> map = this.f48579i.get(i16);
                    Iterator<Map.Entry<String, a>> it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        a value = it.next().getValue();
                        if (value != null && value.l() != null) {
                            CampaignEx campaignExL = value.l();
                            Iterator<CampaignEx> it2 = listA.iterator();
                            boolean z12 = false;
                            while (it2.hasNext()) {
                                if (campaignExL.getId().equals(it2.next().getId())) {
                                    z12 = true;
                                }
                            }
                            if (z12 && ((!z11 || campaignExL.isBidCampaign()) && (z11 || !campaignExL.isBidCampaign()))) {
                                String str = campaignExL.getendcard_url();
                                String videoUrlEncode = campaignExL.getVideoUrlEncode();
                                String strE = campaignExL.getRewardTemplateMode() != null ? campaignExL.getRewardTemplateMode().e() : "";
                                campaignExL.getRewardTemplateMode();
                                if (this.f48586p == i15 || i11 == 287) {
                                    if (TextUtils.isEmpty(strE) || strE.contains(CampaignEx.KEY_IS_CMPT_ENTRY) || a(this.f48586p, campaignExL, strE)) {
                                        if (!b(str, campaignExL)) {
                                            zIsEmpty = TextUtils.isEmpty(value.q());
                                            iK = value.k();
                                            if (this.f48586p != 298 && a(value, b(campaignExL))) {
                                                return value;
                                            }
                                            if (iK != 5) {
                                                if (af.a().a("u_n_c_e_d", true)) {
                                                    list = listA;
                                                    if (this.f48586p == 95) {
                                                        if (!af.a().a("u_n_c_e_d", true)) {
                                                        }
                                                        if (iK == 1) {
                                                            if (value.f()) {
                                                                i15 = 94;
                                                            } else if (!MBridgeConstans.IS_DOWANLOAD_FINSH_PLAY) {
                                                                return value;
                                                            }
                                                        }
                                                        i12 = this.f48586p;
                                                        i15 = 94;
                                                        return i12 != 94 ? value : value;
                                                        listA = list;
                                                    } else {
                                                        if (value.f()) {
                                                            return value;
                                                        }
                                                        value.r();
                                                        this.f48579i.remove(map);
                                                    }
                                                    i16--;
                                                } else {
                                                    jG = value.g();
                                                    if (value.k() == 1) {
                                                        list = listA;
                                                        if (jCurrentTimeMillis - jG > this.f48582l * 1000) {
                                                            value.b(MBridgeError.ERROR_MESSAGE_DOWNLOAD_DOWNLOAD_TIMEOUT);
                                                            value.s();
                                                            this.f48579i.remove(map);
                                                            i16--;
                                                            i13 = this.f48586p;
                                                            if (i13 != 1 && i13 != 94) {
                                                            }
                                                        }
                                                    } else {
                                                        list = listA;
                                                    }
                                                    if (this.f48586p == 95) {
                                                        if (!af.a().a("u_n_c_e_d", true) || (iK != 4 && iK != 2)) {
                                                            if (iK == 1) {
                                                                if (value.f()) {
                                                                    i15 = 94;
                                                                } else if (!MBridgeConstans.IS_DOWANLOAD_FINSH_PLAY && a(value, b(campaignExL)) && a(str, campaignExL)) {
                                                                    return value;
                                                                }
                                                            }
                                                            i12 = this.f48586p;
                                                            i15 = 94;
                                                            if ((i12 != 94 || i12 == 287) && a(value, b(campaignExL)) && a(str, campaignExL)) {
                                                            }
                                                            listA = list;
                                                        }
                                                        this.f48579i.remove(map);
                                                        value.s();
                                                    } else {
                                                        if (value.f()) {
                                                            return value;
                                                        }
                                                        value.r();
                                                        this.f48579i.remove(map);
                                                    }
                                                    i16--;
                                                }
                                                listA = list;
                                                i15 = 94;
                                            } else if (value.f()) {
                                                value.r();
                                                this.f48579i.remove(map);
                                                i16--;
                                                i15 = 94;
                                            } else {
                                                if (zIsEmpty) {
                                                    if (a(str, campaignExL)) {
                                                        return value;
                                                    }
                                                    return null;
                                                }
                                                value.a(0, 0);
                                                if (this.f48586p == 95) {
                                                    return value;
                                                }
                                            }
                                        } else if (value.f()) {
                                            value.r();
                                        } else {
                                            if (an.a(videoUrlEncode)) {
                                                return value;
                                            }
                                            if (a(value, b(campaignExL))) {
                                                return value;
                                            }
                                            zIsEmpty = TextUtils.isEmpty(value.q());
                                            iK = value.k();
                                            if (this.f48586p != 298) {
                                            }
                                            if (iK != 5) {
                                                if (af.a().a("u_n_c_e_d", true)) {
                                                    jG = value.g();
                                                    if (value.k() == 1) {
                                                        list = listA;
                                                        if (jCurrentTimeMillis - jG > this.f48582l * 1000) {
                                                            value.b(MBridgeError.ERROR_MESSAGE_DOWNLOAD_DOWNLOAD_TIMEOUT);
                                                            value.s();
                                                            this.f48579i.remove(map);
                                                            i16--;
                                                            i13 = this.f48586p;
                                                            if (i13 != 1) {
                                                            }
                                                        }
                                                    } else {
                                                        list = listA;
                                                    }
                                                    if (this.f48586p == 95) {
                                                        if (!af.a().a("u_n_c_e_d", true)) {
                                                        }
                                                        if (iK == 1) {
                                                            if (value.f()) {
                                                                i15 = 94;
                                                            } else if (!MBridgeConstans.IS_DOWANLOAD_FINSH_PLAY) {
                                                                return value;
                                                            }
                                                        }
                                                        i12 = this.f48586p;
                                                        i15 = 94;
                                                        if (i12 != 94) {
                                                        }
                                                        listA = list;
                                                    } else {
                                                        if (value.f()) {
                                                            return value;
                                                        }
                                                        value.r();
                                                        this.f48579i.remove(map);
                                                    }
                                                    i16--;
                                                } else {
                                                    list = listA;
                                                    if (this.f48586p == 95) {
                                                        if (!af.a().a("u_n_c_e_d", true)) {
                                                        }
                                                        if (iK == 1) {
                                                            if (value.f()) {
                                                                i15 = 94;
                                                            } else if (!MBridgeConstans.IS_DOWANLOAD_FINSH_PLAY) {
                                                                return value;
                                                            }
                                                        }
                                                        i12 = this.f48586p;
                                                        i15 = 94;
                                                        if (i12 != 94) {
                                                        }
                                                        listA = list;
                                                    } else {
                                                        if (value.f()) {
                                                            return value;
                                                        }
                                                        value.r();
                                                        this.f48579i.remove(map);
                                                    }
                                                    i16--;
                                                }
                                                listA = list;
                                                i15 = 94;
                                            } else if (value.f()) {
                                                value.r();
                                                this.f48579i.remove(map);
                                                i16--;
                                                i15 = 94;
                                            } else {
                                                if (zIsEmpty) {
                                                    if (a(str, campaignExL)) {
                                                        return value;
                                                    }
                                                    return null;
                                                }
                                                value.a(0, 0);
                                                if (this.f48586p == 95) {
                                                    return value;
                                                }
                                            }
                                        }
                                    }
                                    list = listA;
                                    i15 = 94;
                                } else {
                                    zIsEmpty = TextUtils.isEmpty(value.q());
                                    iK = value.k();
                                    if (this.f48586p != 298) {
                                    }
                                    if (iK != 5) {
                                        if (af.a().a("u_n_c_e_d", true)) {
                                            jG = value.g();
                                            if (value.k() == 1) {
                                                list = listA;
                                                if (jCurrentTimeMillis - jG > this.f48582l * 1000) {
                                                    value.b(MBridgeError.ERROR_MESSAGE_DOWNLOAD_DOWNLOAD_TIMEOUT);
                                                    value.s();
                                                    this.f48579i.remove(map);
                                                    i16--;
                                                    i13 = this.f48586p;
                                                    if (i13 != 1) {
                                                    }
                                                }
                                            } else {
                                                list = listA;
                                            }
                                            if (this.f48586p == 95) {
                                                if (!af.a().a("u_n_c_e_d", true)) {
                                                }
                                                if (iK == 1) {
                                                    if (value.f()) {
                                                        i15 = 94;
                                                    } else if (!MBridgeConstans.IS_DOWANLOAD_FINSH_PLAY) {
                                                        return value;
                                                    }
                                                }
                                                i12 = this.f48586p;
                                                i15 = 94;
                                                if (i12 != 94) {
                                                }
                                                listA = list;
                                            } else {
                                                if (value.f()) {
                                                    return value;
                                                }
                                                value.r();
                                                this.f48579i.remove(map);
                                            }
                                            i16--;
                                        } else {
                                            list = listA;
                                            if (this.f48586p == 95) {
                                                if (!af.a().a("u_n_c_e_d", true)) {
                                                }
                                                if (iK == 1) {
                                                    if (value.f()) {
                                                        i15 = 94;
                                                    } else if (!MBridgeConstans.IS_DOWANLOAD_FINSH_PLAY) {
                                                        return value;
                                                    }
                                                }
                                                i12 = this.f48586p;
                                                i15 = 94;
                                                if (i12 != 94) {
                                                }
                                                listA = list;
                                            } else {
                                                if (value.f()) {
                                                    return value;
                                                }
                                                value.r();
                                                this.f48579i.remove(map);
                                            }
                                            i16--;
                                        }
                                        listA = list;
                                        i15 = 94;
                                    } else if (value.f()) {
                                        value.r();
                                        this.f48579i.remove(map);
                                        i16--;
                                        i15 = 94;
                                    } else {
                                        if (zIsEmpty) {
                                            if (a(str, campaignExL)) {
                                                return value;
                                            }
                                            return null;
                                        }
                                        value.a(0, 0);
                                        if (this.f48586p == 95) {
                                            return value;
                                        }
                                        list = listA;
                                        i15 = 94;
                                    }
                                }
                            }
                            listA = list;
                        }
                        list = listA;
                        listA = list;
                    }
                    i16++;
                    listA = listA;
                    i11 = i11;
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            return null;
        }
    }

    public final a a(String str) {
        i iVar;
        if (this.f48588r && (iVar = this.f48587q) != null) {
            return iVar.a(str);
        }
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList = this.f48579i;
        if (copyOnWriteArrayList == null) {
            return null;
        }
        synchronized (copyOnWriteArrayList) {
            try {
                try {
                    for (Map<String, a> map : this.f48579i) {
                        if (map != null && map.containsKey(str)) {
                            return map.get(str);
                        }
                    }
                } catch (Throwable unused) {
                    ad.b("UnitCacheCtroller", "failed to get campaignTast by cid");
                }
                return null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:145:0x0241 A[PHI: r6
  0x0241: PHI (r6v34 java.lang.String) = (r6v33 java.lang.String), (r6v33 java.lang.String), (r6v36 java.lang.String) binds: [B:133:0x021b, B:138:0x0228, B:144:0x023e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:147:0x0245  */
    /* JADX WARN: Code duplicated, block: B:149:0x0249 A[Catch: all -> 0x00c0, Exception -> 0x00c3, TryCatch #0 {all -> 0x00c0, blocks: (B:11:0x0025, B:12:0x002a, B:14:0x0032, B:15:0x0042, B:17:0x0048, B:19:0x0056, B:22:0x0064, B:23:0x006e, B:25:0x0074, B:28:0x007e, B:30:0x0088, B:32:0x0092, B:34:0x00a0, B:36:0x00ae, B:38:0x00b8, B:49:0x00d5, B:54:0x00e4, B:57:0x00eb, B:59:0x00fb, B:61:0x0105, B:92:0x016e, B:95:0x017f, B:97:0x0185, B:99:0x0194, B:101:0x019c, B:103:0x01a7, B:105:0x01ae, B:107:0x01b2, B:111:0x01b6, B:113:0x01c3, B:115:0x01cd, B:117:0x01db, B:134:0x021d, B:137:0x0226, B:139:0x022a, B:141:0x0234, B:143:0x023a, B:149:0x0249, B:151:0x0253, B:153:0x0259, B:131:0x020a, B:67:0x0118, B:69:0x011e, B:71:0x0128, B:78:0x013b, B:80:0x0141, B:82:0x0147, B:83:0x014d, B:85:0x0153, B:86:0x0157, B:88:0x0161, B:161:0x0274, B:162:0x0277), top: B:175:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:151:0x0253 A[Catch: all -> 0x00c0, Exception -> 0x00c3, TryCatch #0 {all -> 0x00c0, blocks: (B:11:0x0025, B:12:0x002a, B:14:0x0032, B:15:0x0042, B:17:0x0048, B:19:0x0056, B:22:0x0064, B:23:0x006e, B:25:0x0074, B:28:0x007e, B:30:0x0088, B:32:0x0092, B:34:0x00a0, B:36:0x00ae, B:38:0x00b8, B:49:0x00d5, B:54:0x00e4, B:57:0x00eb, B:59:0x00fb, B:61:0x0105, B:92:0x016e, B:95:0x017f, B:97:0x0185, B:99:0x0194, B:101:0x019c, B:103:0x01a7, B:105:0x01ae, B:107:0x01b2, B:111:0x01b6, B:113:0x01c3, B:115:0x01cd, B:117:0x01db, B:134:0x021d, B:137:0x0226, B:139:0x022a, B:141:0x0234, B:143:0x023a, B:149:0x0249, B:151:0x0253, B:153:0x0259, B:131:0x020a, B:67:0x0118, B:69:0x011e, B:71:0x0128, B:78:0x013b, B:80:0x0141, B:82:0x0147, B:83:0x014d, B:85:0x0153, B:86:0x0157, B:88:0x0161, B:161:0x0274, B:162:0x0277), top: B:175:0x0025 }] */
    /* JADX WARN: Code duplicated, block: B:154:0x025d  */
    public final List<a> a(String str, int i11, boolean z11, List<CampaignEx> list, boolean z12, com.mbridge.msdk.foundation.same.report.d.d dVar) {
        long j11;
        Iterator<Map.Entry<String, a>> it;
        String str2;
        i iVar;
        if (this.f48588r && (iVar = this.f48587q) != null) {
            return iVar.a(list, z12);
        }
        ArrayList arrayList = new ArrayList();
        String str3 = "";
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList = this.f48579i;
        if (copyOnWriteArrayList != null) {
            synchronized (copyOnWriteArrayList) {
                try {
                    try {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        int i12 = 0;
                        while (i12 < this.f48579i.size()) {
                            Map<String, a> map = this.f48579i.get(i12);
                            Iterator<Map.Entry<String, a>> it2 = map.entrySet().iterator();
                            while (it2.hasNext()) {
                                try {
                                    a value = it2.next().getValue();
                                    if (value == null || value.l() == null) {
                                        j11 = jCurrentTimeMillis;
                                        it = it2;
                                        str3 = "task or task's campaign is NULL";
                                        it2 = it;
                                        jCurrentTimeMillis = j11;
                                    } else {
                                        CampaignEx campaignExL = value.l();
                                        boolean z13 = false;
                                        for (CampaignEx campaignEx : list) {
                                            if (campaignExL != null && campaignEx != null && !TextUtils.isEmpty(campaignExL.getRequestId()) && !TextUtils.isEmpty(campaignEx.getRequestId()) && campaignExL.getId().equals(campaignEx.getId()) && campaignExL.getRequestId().equals(campaignEx.getRequestId())) {
                                                if (!TextUtils.isEmpty(campaignEx.getNLRid())) {
                                                    campaignExL.setNLRid(campaignEx.getNLRid());
                                                }
                                                z13 = true;
                                            }
                                        }
                                        if (z13) {
                                            if (!z11 || campaignExL.isBidCampaign()) {
                                                if (z11 || !campaignExL.isBidCampaign()) {
                                                    String str4 = campaignExL.getendcard_url();
                                                    String videoUrlEncode = campaignExL.getVideoUrlEncode();
                                                    String strE = campaignExL.getRewardTemplateMode() != null ? campaignExL.getRewardTemplateMode().e() : "";
                                                    campaignExL.getRewardTemplateMode();
                                                    str2 = str3;
                                                    it = it2;
                                                    if (i11 != 94 && i11 != 287) {
                                                        str3 = str2;
                                                    } else if (!TextUtils.isEmpty(strE) && !strE.contains(CampaignEx.KEY_IS_CMPT_ENTRY) && !a(i11, campaignExL, strE)) {
                                                        str3 = "template is null or download is not ready";
                                                    } else if (!b(str4, campaignExL)) {
                                                        str3 = "endcard is downloading or fail";
                                                    } else if (value.f()) {
                                                        value.r();
                                                        str3 = "task is displayed";
                                                    } else {
                                                        if (an.a(videoUrlEncode)) {
                                                            arrayList.add(value);
                                                        } else if (a(value, b(campaignExL), z12)) {
                                                            arrayList.add(value);
                                                        } else {
                                                            str3 = "video and image list is downloading or fail";
                                                        }
                                                        str3 = str2;
                                                    }
                                                    boolean zIsEmpty = TextUtils.isEmpty(value.q());
                                                    int iK = value.k();
                                                    str2 = str3;
                                                    if (iK == 5) {
                                                        try {
                                                            if (value.f()) {
                                                                value.r();
                                                                this.f48579i.remove(map);
                                                                i12--;
                                                                str3 = "task is displayed";
                                                            } else {
                                                                if (!zIsEmpty) {
                                                                    value.a(0, 0);
                                                                    if (i11 == 95) {
                                                                        arrayList.add(value);
                                                                    } else {
                                                                        str3 = "resource path is not effective";
                                                                        it2 = it;
                                                                    }
                                                                } else {
                                                                    if (!a(str4, campaignExL)) {
                                                                        return null;
                                                                    }
                                                                    arrayList.add(value);
                                                                }
                                                                str3 = str2;
                                                            }
                                                        } catch (Exception e11) {
                                                            e = e11;
                                                            str3 = str2;
                                                            e.printStackTrace();
                                                            if (arrayList.size() == 0) {
                                                                dVar.a("is_ready_fail_reason", str3);
                                                            }
                                                            return arrayList;
                                                        }
                                                    } else {
                                                        int i13 = 1;
                                                        if (af.a().a("u_n_c_e_d", true)) {
                                                            j11 = jCurrentTimeMillis;
                                                            str3 = str2;
                                                        } else {
                                                            long jG = value.g();
                                                            if (value.k() == 1) {
                                                                j11 = jCurrentTimeMillis;
                                                                if (jCurrentTimeMillis - jG > this.f48582l * 1000) {
                                                                    value.b(MBridgeError.ERROR_MESSAGE_DOWNLOAD_DOWNLOAD_TIMEOUT);
                                                                    value.s();
                                                                    this.f48579i.remove(map);
                                                                    i12--;
                                                                    str3 = "video download time over dlct";
                                                                    if (i11 != 1 && i11 != 94) {
                                                                    }
                                                                    it2 = it;
                                                                    jCurrentTimeMillis = j11;
                                                                }
                                                                if (iK != 4 || iK == 2) {
                                                                    this.f48579i.remove(map);
                                                                    value.s();
                                                                    i12--;
                                                                    str3 = "video download stop or pause";
                                                                } else {
                                                                    i13 = 1;
                                                                }
                                                                it2 = it;
                                                                jCurrentTimeMillis = j11;
                                                            } else {
                                                                j11 = jCurrentTimeMillis;
                                                            }
                                                            str3 = str2;
                                                            if (iK != 4) {
                                                            }
                                                            this.f48579i.remove(map);
                                                            value.s();
                                                            i12--;
                                                            str3 = "video download stop or pause";
                                                            it2 = it;
                                                            jCurrentTimeMillis = j11;
                                                        }
                                                        if (iK != i13) {
                                                            if (i11 != 94 || i11 == 287) {
                                                                if (!a(value, b(campaignExL), z12) && a(str4, campaignExL)) {
                                                                    arrayList.add(value);
                                                                }
                                                            }
                                                        } else if (value.f()) {
                                                            str3 = "video was displayed";
                                                        } else if (MBridgeConstans.IS_DOWANLOAD_FINSH_PLAY) {
                                                            if (i11 != 94) {
                                                                str3 = !a(value, b(campaignExL), z12) ? "video or endcard or image list is downloading or fail" : "video or endcard or image list is downloading or fail";
                                                            } else if (!a(value, b(campaignExL), z12)) {
                                                            }
                                                        } else if (a(value, b(campaignExL), z12) && a(str4, campaignExL)) {
                                                            arrayList.add(value);
                                                        } else {
                                                            str3 = "video or endcard or image list is downloading or fail";
                                                            if (i11 != 94) {
                                                                if (!a(value, b(campaignExL), z12)) {
                                                                }
                                                            } else if (!a(value, b(campaignExL), z12)) {
                                                            }
                                                        }
                                                        it2 = it;
                                                        jCurrentTimeMillis = j11;
                                                    }
                                                }
                                                it2 = it;
                                            }
                                            str2 = str3;
                                            it = it2;
                                            str3 = str2;
                                            it2 = it;
                                        } else {
                                            str3 = "campaign is not available";
                                        }
                                    }
                                } catch (Exception e12) {
                                    e = e12;
                                }
                            }
                            i12++;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                } catch (Exception e13) {
                    e = e13;
                }
            }
        }
        try {
            if (arrayList.size() == 0 && dVar != null) {
                dVar.a("is_ready_fail_reason", str3);
            }
        } catch (Throwable th3) {
            ad.b("UnitCacheCtroller", th3.getMessage());
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:56:0x00da  */
    public final void a() {
        int iS;
        i iVar;
        if (this.f48588r && (iVar = this.f48587q) != null) {
            iVar.a();
            return;
        }
        d();
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList = this.f48579i;
        if (copyOnWriteArrayList != null) {
            synchronized (copyOnWriteArrayList) {
                try {
                    if (!a(this.f48579i)) {
                        this.f48574d = true;
                    }
                    for (Map<String, a> map : this.f48579i) {
                        if (map != null) {
                            Iterator<Map.Entry<String, a>> it = map.entrySet().iterator();
                            while (it.hasNext()) {
                                a value = it.next().getValue();
                                if (value != null && !value.f()) {
                                    if (this.f48586p == 95) {
                                        this.f48574d = true;
                                    }
                                    int iK = value.k();
                                    final CampaignEx campaignExL = value.l();
                                    if (campaignExL != null && iK == 0) {
                                        iK = b.getInstance().b(campaignExL.getId(), campaignExL.getVideoUrlEncode());
                                    }
                                    int i11 = iK;
                                    value.a(new com.mbridge.msdk.videocommon.listener.a() { // from class: com.mbridge.msdk.videocommon.download.j.2
                                        @Override // com.mbridge.msdk.videocommon.listener.a
                                        public final void a(String str) {
                                            com.mbridge.msdk.videocommon.listener.a aVar;
                                            if (j.this.f48575e != null) {
                                                j.this.f48575e.a(str);
                                            }
                                            if (j.this.f48577g == null || j.this.f48577g.size() <= 0 || campaignExL == null || (aVar = (com.mbridge.msdk.videocommon.listener.a) j.this.f48577g.get(campaignExL.getRequestId())) == null) {
                                                return;
                                            }
                                            aVar.a(str);
                                        }

                                        @Override // com.mbridge.msdk.videocommon.listener.a
                                        public final void a(String str, String str2) {
                                            com.mbridge.msdk.videocommon.listener.a aVar;
                                            if (j.this.f48575e != null) {
                                                j.this.f48575e.a(str, str2);
                                            }
                                            CampaignEx campaignEx = campaignExL;
                                            if (campaignEx != null && campaignEx.getRsIgnoreCheckRule() != null && campaignExL.getRsIgnoreCheckRule().size() > 0 && campaignExL.getRsIgnoreCheckRule().contains(0)) {
                                                ad.c("UnitCacheCtroller", "Is not check video download status");
                                            } else {
                                                if (j.this.f48577g == null || j.this.f48577g.size() <= 0 || campaignExL == null || (aVar = (com.mbridge.msdk.videocommon.listener.a) j.this.f48577g.get(campaignExL.getRequestId())) == null) {
                                                    return;
                                                }
                                                aVar.a(str, str2);
                                            }
                                        }
                                    });
                                    int iB = b(campaignExL);
                                    if (this.f48586p == 1) {
                                        if (this.f48571a == null) {
                                            this.f48571a = k.d(this.f48583m);
                                        }
                                        iB = d(campaignExL);
                                    }
                                    int i12 = iB;
                                    value.c(i12);
                                    int i13 = this.f48586p;
                                    if (i13 == 94 || i13 == 287 || i13 == 95) {
                                        if (this.f48584n == null) {
                                            this.f48584n = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), this.f48583m, this.f48586p == 287);
                                        }
                                        com.mbridge.msdk.videocommon.d.c cVar = this.f48584n;
                                        iS = cVar != null ? cVar.s() : 0;
                                    } else {
                                        if (i13 != 298) {
                                            iS = 0;
                                        } else {
                                            if (this.f48572b == null) {
                                                this.f48572b = com.mbridge.msdk.c.h.a().c(com.mbridge.msdk.foundation.controller.c.m().k(), this.f48583m);
                                            }
                                            k kVar = this.f48572b;
                                            if (kVar != null) {
                                                iS = kVar.g();
                                            } else {
                                                iS = 0;
                                            }
                                        }
                                        if (this.f48586p == 1) {
                                            if (this.f48571a == null) {
                                                this.f48571a = com.mbridge.msdk.c.h.a().c(com.mbridge.msdk.foundation.controller.c.m().k(), this.f48583m);
                                            }
                                            k kVar2 = this.f48571a;
                                            if (kVar2 != null) {
                                                iS = kVar2.g();
                                            }
                                        }
                                    }
                                    value.b(iS);
                                    int videoCtnType = campaignExL != null ? campaignExL.getVideoCtnType() : 1;
                                    value.e(videoCtnType);
                                    ad.b("UnitCacheCtroller", "ready_rate : " + i12 + " cd_rate : " + iS + " videoCtnType : " + videoCtnType);
                                    if (a(value, b(campaignExL))) {
                                        String videoUrlEncode = campaignExL != null ? campaignExL.getVideoUrlEncode() : "";
                                        com.mbridge.msdk.videocommon.listener.a aVar = this.f48575e;
                                        if (aVar != null) {
                                            int i14 = this.f48586p;
                                            if (i14 == 297 || i14 == 298) {
                                                try {
                                                    aVar.a(videoUrlEncode);
                                                } catch (Exception e11) {
                                                    if (MBridgeConstans.DEBUG) {
                                                        ad.b("UnitCacheCtroller", e11.getMessage());
                                                    }
                                                }
                                            }
                                        }
                                        ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> concurrentHashMap = this.f48577g;
                                        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
                                            com.mbridge.msdk.videocommon.listener.a aVar2 = this.f48577g.get(campaignExL != null ? campaignExL.getRequestId() : "");
                                            if (aVar2 != null && campaignExL != null) {
                                                try {
                                                    aVar2.a(videoUrlEncode);
                                                } catch (Exception e12) {
                                                    if (MBridgeConstans.DEBUG) {
                                                        ad.b("UnitCacheCtroller", e12.getMessage());
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (i11 != 1 && (i11 != 5 || !a(value, i12))) {
                                        if (i11 == 4) {
                                            continue;
                                        } else {
                                            if (z.l(this.f48580j) != 9 && this.f48585o == 2) {
                                                return;
                                            }
                                            if (i11 == 2 || this.f48574d) {
                                                value.a(this.f48578h);
                                                if (a(value, i12)) {
                                                    int i15 = this.f48586p;
                                                    if (i15 == 94 || i15 == 287) {
                                                        value.o();
                                                    }
                                                } else {
                                                    int i16 = this.f48586p;
                                                    if (i16 == 1 || i16 == 95 || i16 == 298) {
                                                        this.f48574d = false;
                                                    }
                                                    value.o();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public final void a(CampaignEx campaignEx) {
        i iVar;
        if (this.f48588r && (iVar = this.f48587q) != null) {
            iVar.a(campaignEx);
            return;
        }
        List<CampaignEx> list = this.f48573c;
        if (list != null && campaignEx != null) {
            list.add(campaignEx);
        }
        b(this.f48573c);
    }

    public final void a(com.mbridge.msdk.videocommon.listener.a aVar) {
        i iVar;
        if (!this.f48588r || (iVar = this.f48587q) == null) {
            this.f48575e = aVar;
        } else {
            iVar.a(aVar);
        }
    }

    public final void a(String str, com.mbridge.msdk.videocommon.listener.a aVar) {
        i iVar;
        if (this.f48588r && (iVar = this.f48587q) != null) {
            iVar.a(str, aVar);
            return;
        }
        if (this.f48577g == null) {
            this.f48577g = new ConcurrentHashMap<>();
        }
        if (aVar == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f48577g.put(str, aVar);
    }

    public final void a(List<CampaignEx> list) {
        i iVar;
        if (this.f48588r && (iVar = this.f48587q) != null) {
            iVar.a(list);
            return;
        }
        List<CampaignEx> list2 = this.f48573c;
        if (list2 != null && list != null) {
            list2.addAll(list);
        }
        b(this.f48573c);
    }

    public final boolean a(List<CampaignEx> list, String str) {
        if (list == null || list.size() == 0) {
            return false;
        }
        for (int i11 = 0; i11 < list.size(); i11++) {
            CampaignEx campaignEx = list.get(i11);
            if (campaignEx == null || !a(new a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx, str, this.f48585o), b(campaignEx), false) || !a(campaignEx.getendcard_url(), campaignEx)) {
                return false;
            }
        }
        return true;
    }

    public final a b(int i11, boolean z11) {
        i iVar;
        if (this.f48588r && (iVar = this.f48587q) != null) {
            return iVar.c();
        }
        try {
            return a(i11, z11);
        } catch (Throwable th2) {
            ad.a("UnitCacheCtroller", th2.getMessage(), th2);
            return null;
        }
    }

    public final void b() {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList;
        if ((!this.f48588r || this.f48587q == null) && (copyOnWriteArrayList = this.f48579i) != null) {
            try {
                synchronized (copyOnWriteArrayList) {
                    try {
                        for (Map<String, a> map : this.f48579i) {
                            if (map != null) {
                                Iterator<Map.Entry<String, a>> it = map.entrySet().iterator();
                                while (it.hasNext()) {
                                    a value = it.next().getValue();
                                    if (value != null && value.k() == 1) {
                                        value.b("playing and stop download");
                                        value.s();
                                        this.f48579i.remove(map);
                                        return;
                                    }
                                }
                            }
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                if (MBridgeConstans.DEBUG) {
                    ad.b("UnitCacheCtroller", th3.getMessage());
                }
            }
        }
    }

    public final void b(String str) {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList;
        i iVar;
        if (this.f48588r && (iVar = this.f48587q) != null) {
            iVar.b(str);
            return;
        }
        try {
            synchronized (this.f48579i) {
                try {
                    if (!TextUtils.isEmpty(str) && (copyOnWriteArrayList = this.f48579i) != null && copyOnWriteArrayList.size() > 0) {
                        for (Map<String, a> map : this.f48579i) {
                            if (map != null) {
                                for (Map.Entry<String, a> entry : map.entrySet()) {
                                    if (entry != null && TextUtils.equals(entry.getKey(), str)) {
                                        this.f48579i.remove(map);
                                    }
                                }
                            }
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                ad.b("UnitCacheCtroller", e11.getMessage());
            }
        }
    }

    public final CopyOnWriteArrayList<Map<String, a>> c() {
        i iVar;
        return (!this.f48588r || (iVar = this.f48587q) == null) ? this.f48579i : iVar.d();
    }
}
