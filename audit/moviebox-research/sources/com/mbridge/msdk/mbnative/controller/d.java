package com.mbridge.msdk.mbnative.controller;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.c.j;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.CampaignUnit;
import com.mbridge.msdk.foundation.entity.k;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ab;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.nativex.view.MBMediaView;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.PreloadListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class d extends com.mbridge.msdk.mbnative.controller.b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f45565e = "d";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static Map<String, Map<Long, Object>> f45566f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static Map<String, Boolean> f45567g = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static Map<String, k> f45568h = new HashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static Map<String, Integer> f45569i = new HashMap();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static Map<String, Integer> f45570j = new HashMap();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static d f45571k = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private static int f45572u = -1;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private static int f45573v = -2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected List<Integer> f45576d;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private j f45577l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private com.mbridge.msdk.click.a f45578m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.mbridge.msdk.c.k f45579n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private String f45580o;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private Map<String, Object> f45582q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private List<Integer> f45583r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private List<Integer> f45584s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private boolean f45585t;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private boolean f45586w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private int f45587x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private int f45588y;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Queue<Integer> f45574b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Queue<Long> f45575c = null;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f45581p = 0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private com.mbridge.msdk.foundation.same.e.b f45589z = new com.mbridge.msdk.foundation.same.e.b(com.mbridge.msdk.foundation.controller.c.m().c());

    /* JADX INFO: compiled from: source.java */
    public class a extends com.mbridge.msdk.mbnative.f.a.b implements com.mbridge.msdk.foundation.same.e.d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f45592b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f45593c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f45594d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f45595e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f45596f;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private Runnable f45599i;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        private com.mbridge.msdk.b.a.a f45601k;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private List<String> f45597g = null;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f45598h = false;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        private boolean f45600j = true;

        public a(int i11) {
            this.f45592b = i11;
        }

        public static /* synthetic */ void a(a aVar, final CampaignEx campaignEx, com.mbridge.msdk.foundation.same.report.d.b bVar, final com.mbridge.msdk.foundation.same.report.d.a.a aVar2) {
            try {
                final Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                com.mbridge.msdk.foundation.same.b.a(campaignEx, contextC, bVar, new com.mbridge.msdk.foundation.same.b.a() { // from class: com.mbridge.msdk.mbnative.controller.d.a.2
                    @Override // com.mbridge.msdk.foundation.same.b.a
                    public final void a(String str, com.mbridge.msdk.foundation.same.report.d.b bVar2) {
                        com.mbridge.msdk.mbnative.e.a.a(str, bVar2, campaignEx, contextC, aVar2);
                    }
                });
            } catch (Exception e11) {
                if (MBridgeConstans.DEBUG) {
                    e11.printStackTrace();
                }
            }
        }

        public final void a(int i11) {
            this.f45596f = i11;
        }

        @Override // com.mbridge.msdk.mbnative.f.a.b
        public final void a(final int i11, final String str) {
            d.this.a(new Thread(new Runnable() { // from class: com.mbridge.msdk.mbnative.controller.d.a.3
                @Override // java.lang.Runnable
                public final void run() {
                    boolean z11;
                    if (MBridgeConstans.PRELOAD_RESULT_IN_SUBTHREAD && Looper.myLooper() == null) {
                        Looper.prepare();
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (!a.this.f45598h) {
                        if (a.this.f45599i != null) {
                            a aVar = a.this;
                            d.this.f45553a.removeCallbacks(aVar.f45599i);
                        }
                        if (a.this.b() == 1 || a.this.f45600j) {
                            a aVar2 = a.this;
                            d dVar = d.this;
                            String str2 = str;
                            int iB = aVar2.b();
                            a aVar3 = a.this;
                            dVar.a(str2, iB, aVar3.unitId, aVar3.placementId, aVar3.f45601k);
                        }
                    } else if (a.this.f45600j) {
                        a aVar4 = a.this;
                        d dVar2 = d.this;
                        String str3 = str;
                        int iB2 = aVar4.b();
                        a aVar5 = a.this;
                        dVar2.a(str3, iB2, aVar5.unitId, aVar5.placementId, aVar5.f45601k);
                    }
                    if (i11 == -1) {
                        d.b(a.this.f45592b, a.this.unitId);
                    }
                    if (Looper.myLooper() == null || !z11) {
                        return;
                    }
                    Looper.loop();
                }
            }));
        }

        public final void a(com.mbridge.msdk.b.a.a aVar) {
            this.f45601k = aVar;
        }

        public final void a(Runnable runnable) {
            this.f45599i = runnable;
        }

        public final void a(List<String> list) {
            this.f45597g = list;
        }

        @Override // com.mbridge.msdk.mbnative.f.a.b
        public final void a(List<com.mbridge.msdk.foundation.same.net.d.b> list, final CampaignUnit campaignUnit) {
            d.this.f45586w = true;
            d.this.a(true, this.f45601k, (String) null);
            d.this.a(new Thread(new Runnable() { // from class: com.mbridge.msdk.mbnative.controller.d.a.1
                @Override // java.lang.Runnable
                public final void run() {
                    boolean z11;
                    if (MBridgeConstans.PRELOAD_RESULT_IN_SUBTHREAD && Looper.myLooper() == null) {
                        Looper.prepare();
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (a.this.f45599i != null) {
                        a aVar = a.this;
                        d.this.f45553a.removeCallbacks(aVar.f45599i);
                    }
                    if (com.mbridge.msdk.f.b.a()) {
                        d dVar = d.this;
                    }
                    if (d.f45566f.containsKey("0_" + a.this.unitId)) {
                        d.f45566f.remove("0_" + a.this.unitId);
                    }
                    if (a.this.f45596f > 0) {
                        if (campaignUnit.ads.size() > a.this.f45596f) {
                            a aVar2 = a.this;
                            aVar2.f45593c = aVar2.f45596f;
                        } else {
                            a.this.f45593c = campaignUnit.ads.size();
                        }
                    } else if (a.this.f45596f == -1) {
                        a.this.f45593c = 0;
                    } else if (a.this.f45596f == -3) {
                        a.this.f45593c = campaignUnit.ads.size();
                    } else if (a.this.f45596f == -2) {
                        if (campaignUnit.getTemplate() == 3) {
                            if (a.this.f45595e != 0) {
                                a aVar3 = a.this;
                                aVar3.f45593c = aVar3.f45595e;
                            }
                        } else if (a.this.f45594d != 0) {
                            a aVar4 = a.this;
                            aVar4.f45593c = aVar4.f45594d;
                        }
                        if (a.this.f45593c <= 0) {
                            a.this.f45593c = ((Integer) d.f45569i.get(a.this.unitId)).intValue();
                        }
                    }
                    if (campaignUnit.ads.size() < a.this.f45593c) {
                        a.this.f45593c = campaignUnit.ads.size();
                    }
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    for (int i11 = 0; i11 < campaignUnit.ads.size(); i11++) {
                        CampaignEx campaignEx = campaignUnit.ads.get(i11);
                        campaignEx.setCampaignUnitId(a.this.unitId);
                        boolean zC = ai.c(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx.getPackageName());
                        d dVar2 = d.this;
                        com.mbridge.msdk.foundation.controller.c.m().c();
                        if (arrayList.size() < a.this.f45593c && campaignEx.getOfferType() != 99) {
                            if (ai.c(campaignEx)) {
                                campaignEx.setRtinsType(zC ? 1 : 2);
                            }
                            if (com.mbridge.msdk.foundation.same.b.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignEx)) {
                                arrayList.add(campaignEx);
                                if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
                                    arrayList2.add(campaignEx);
                                }
                            } else {
                                ai.a(a.this.unitId, campaignEx, com.mbridge.msdk.foundation.same.a.f44388x);
                            }
                            a.a(a.this, campaignEx, null, null);
                        }
                        d dVar3 = d.this;
                        dVar3.a(dVar3.f45585t, campaignEx);
                    }
                    a aVar5 = a.this;
                    d.a(d.this, arrayList2, aVar5.unitId);
                    com.mbridge.msdk.mbnative.a.b<String, List<Campaign>> bVarA = com.mbridge.msdk.mbnative.a.c.a(campaignUnit.getAds().get(0) != null ? campaignUnit.getAds().get(0).getType() : 1);
                    if (bVarA != null) {
                        bVarA.a(a.this.unitId, arrayList);
                    }
                    d.a(a.this.f45592b, a.this.unitId);
                    if (Looper.myLooper() != null && z11) {
                        Looper.loop();
                    }
                    if (campaignUnit.getAds().get(0) != null) {
                        com.mbridge.msdk.click.c.a(com.mbridge.msdk.foundation.controller.c.m().c(), campaignUnit.getAds().get(0).getMaitve(), campaignUnit.getAds().get(0).getMaitve_src());
                    }
                }
            }));
        }

        @Override // com.mbridge.msdk.foundation.same.e.d
        public final void a(boolean z11) {
            this.f45598h = z11;
        }

        public final void b(int i11) {
            this.f45594d = i11;
        }

        @Override // com.mbridge.msdk.mbnative.f.a.b
        public final void b(final List<Frame> list) {
            d.this.a(new Thread(new Runnable() { // from class: com.mbridge.msdk.mbnative.controller.d.a.4
                @Override // java.lang.Runnable
                public final void run() {
                    boolean z11;
                    if (MBridgeConstans.PRELOAD_RESULT_IN_SUBTHREAD && Looper.myLooper() == null) {
                        Looper.prepare();
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (!a.this.f45598h && a.this.f45599i != null) {
                        a aVar = a.this;
                        d.this.f45553a.removeCallbacks(aVar.f45599i);
                    }
                    List list2 = list;
                    if (list2 != null && list2.size() > 0) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            for (CampaignEx campaignEx : ((Frame) it.next()).getCampaigns()) {
                                d dVar = d.this;
                                dVar.a(dVar.f45585t, campaignEx);
                            }
                        }
                        HashMap map = new HashMap();
                        map.put(Long.valueOf(System.currentTimeMillis()), list);
                        if (d.f45566f.containsKey("1_" + a.this.unitId)) {
                            d.f45566f.remove("1_" + a.this.unitId);
                        }
                        d.f45566f.put("1_" + a.this.unitId, map);
                    }
                    if (Looper.myLooper() == null || !z11) {
                        return;
                    }
                    Looper.loop();
                }
            }));
        }

        public final void b(boolean z11) {
            this.f45600j = z11;
        }

        public final void c(int i11) {
            this.f45595e = i11;
        }

        public final void d(int i11) {
            this.f45593c = i11;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public class b implements Runnable {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f45614b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private com.mbridge.msdk.foundation.same.e.d f45615c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f45616d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f45617e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private String f45618f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private com.mbridge.msdk.b.a.a f45619g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private boolean f45620h = false;

        public b(int i11, com.mbridge.msdk.foundation.same.e.d dVar, int i12, String str, String str2) {
            this.f45614b = i11;
            this.f45615c = dVar;
            this.f45616d = i12;
            this.f45617e = str;
            this.f45618f = str2;
        }

        public final void a(com.mbridge.msdk.b.a.a aVar) {
            this.f45619g = aVar;
        }

        public final void a(String str) {
            this.f45617e = str;
        }

        public final void a(boolean z11) {
            this.f45620h = z11;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f45615c.a(true);
            int i11 = this.f45614b;
            if (i11 != 1) {
                if (i11 != 2) {
                    return;
                }
                d.this.a("REQUEST_TIMEOUT", this.f45616d, this.f45617e, this.f45618f, this.f45619g);
            } else {
                d.this.f45586w = true;
                if (this.f45620h || this.f45616d == 1) {
                    d.this.a("REQUEST_TIMEOUT", this.f45616d, this.f45617e, this.f45618f, this.f45619g);
                }
            }
        }
    }

    public d() {
        if (Looper.myLooper() == null) {
            Looper.prepare();
        }
        this.f45553a = new Handler() { // from class: com.mbridge.msdk.mbnative.controller.d.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
            }
        };
    }

    private int a(String str) {
        if (str == null) {
            return 0;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() > 0) {
                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                    JSONObject jSONObject = (JSONObject) jSONArray.opt(i11);
                    if (2 == jSONObject.optInt("id", 0)) {
                        return jSONObject.optInt("ad_num");
                    }
                }
            }
        } catch (Exception e11) {
            ad.b(f45565e, com.mbridge.msdk.mbnative.b.a.a(e11));
        }
        return 0;
    }

    public static Map<String, Map<Long, Object>> a() {
        return f45566f;
    }

    private void a(int i11, long j11, String str, String str2, Map<String, Object> map, int i12, com.mbridge.msdk.c.k kVar, com.mbridge.msdk.b.a.a aVar) {
        com.mbridge.msdk.mbnative.a.b<String, List<Campaign>> bVarA;
        if (i11 != 1 && (bVarA = com.mbridge.msdk.mbnative.a.c.a(i11)) != null) {
            List<Campaign> listB = bVarA.b(str, this.f45588y);
            if (listB != null && listB.size() > 0) {
                a(true, aVar, (String) null);
                return;
            }
        }
        if (i11 == 1) {
            a(i11, j11, i12, kVar, str, str2, true, aVar);
        } else if (i11 != 2) {
            a(i11, j11, i12, kVar, str, str2, aVar, false);
        } else {
            a(2, j11, i12, kVar, str, str2, aVar, false);
        }
    }

    private void a(int i11, com.mbridge.msdk.c.k kVar, String str, String str2, com.mbridge.msdk.b.a.a aVar) {
        Queue<Integer> queue = this.f45574b;
        if (queue == null || queue.size() <= 0) {
            return;
        }
        try {
            int iIntValue = this.f45574b.poll().intValue();
            long jLongValue = MBridgeConstans.REQUEST_TIME_OUT;
            Queue<Long> queue2 = this.f45575c;
            if (queue2 != null && queue2.size() > 0) {
                jLongValue = this.f45575c.poll().longValue();
            }
            ad.c(f45565e, "preload start queue adsource = " + iIntValue);
            a(iIntValue, jLongValue, str, str2, this.f45582q, i11, kVar, aVar);
        } catch (Throwable unused) {
            ad.b(f45565e, "queue poll exception");
        }
    }

    public static void a(int i11, String str) {
        k kVar = f45568h.containsKey(str) ? f45568h.get(str) : new k();
        int iIntValue = f45569i.get(str).intValue();
        int iIntValue2 = f45570j.containsKey(str) ? f45570j.get(str).intValue() : 1;
        if (i11 == 1) {
            int iA = iIntValue + kVar.a();
            kVar.a(iA <= iIntValue2 ? iA : 0);
        } else if (i11 == 2) {
            int iB = iIntValue + kVar.b();
            kVar.b(iB <= iIntValue2 ? iB : 0);
        }
        f45568h.put(str, kVar);
    }

    public static /* synthetic */ void a(d dVar, List list, String str) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    try {
                        int i11 = MBMediaView.f45890a0;
                        Object objInvoke = com.mbridge.msdk.videocommon.download.b.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                        if (objInvoke != null) {
                            com.mbridge.msdk.videocommon.download.b.class.getMethod("createUnitCache", Context.class, String.class, CopyOnWriteArrayList.class, Integer.TYPE, com.mbridge.msdk.videocommon.listener.a.class).invoke(objInvoke, com.mbridge.msdk.foundation.controller.c.m().c(), str, new CopyOnWriteArrayList(list), 1, null);
                            com.mbridge.msdk.videocommon.download.b.class.getMethod("load", String.class).invoke(objInvoke, str);
                        }
                    } catch (Exception unused) {
                        ad.b(f45565e, "please import the videocommon aar");
                    }
                }
            } catch (Exception e11) {
                ad.b(f45565e, com.mbridge.msdk.mbnative.b.a.a(e11));
            }
        }
    }

    public static Map<String, Boolean> b() {
        return f45567g;
    }

    public static void b(int i11, String str) {
        if (f45568h.containsKey(str)) {
            k kVar = f45568h.get(str);
            if (i11 == 1) {
                kVar.a(0);
            } else if (i11 == 2) {
                kVar.b(0);
            }
            f45568h.put(str, kVar);
        }
    }

    public static Map<String, k> c() {
        return f45568h;
    }

    public static Map<String, Integer> d() {
        return f45569i;
    }

    public static Map<String, Integer> e() {
        return f45570j;
    }

    /* JADX WARN: Code duplicated, block: B:126:0x02b6 A[Catch: Exception -> 0x009a, TryCatch #1 {Exception -> 0x009a, blocks: (B:3:0x001a, B:6:0x0067, B:8:0x006d, B:10:0x0075, B:12:0x007d, B:14:0x0085, B:16:0x008f, B:19:0x009d, B:21:0x00a7, B:22:0x00b1, B:24:0x00bb, B:26:0x00c5, B:28:0x00cb, B:29:0x00d4, B:31:0x00ed, B:32:0x00f4, B:34:0x00fa, B:35:0x00ff, B:37:0x0126, B:38:0x012b, B:45:0x0146, B:48:0x014e, B:50:0x0156, B:52:0x015c, B:54:0x0161, B:56:0x0165, B:60:0x0179, B:62:0x0181, B:64:0x0187, B:68:0x0192, B:69:0x01a4, B:71:0x01a8, B:72:0x01be, B:74:0x01c6, B:76:0x01d5, B:77:0x01eb, B:80:0x01fc, B:82:0x0202, B:86:0x020f, B:88:0x0216, B:90:0x021c, B:115:0x0267, B:116:0x0274, B:124:0x028d, B:126:0x02b6, B:127:0x02bc, B:129:0x02c4, B:131:0x02d6, B:132:0x02df, B:134:0x02e7, B:140:0x02f7, B:144:0x0307, B:149:0x0314, B:153:0x0340, B:155:0x037b, B:156:0x0380, B:158:0x0388, B:160:0x0392, B:161:0x03b2, B:163:0x03bc, B:165:0x03c6, B:166:0x03e6, B:170:0x041c, B:172:0x0448, B:176:0x045d, B:175:0x0454, B:169:0x0419, B:152:0x032c, B:141:0x02fc, B:142:0x0301, B:98:0x0229, B:100:0x022f, B:109:0x0250, B:119:0x027f, B:177:0x0465), top: B:183:0x001a }] */
    /* JADX WARN: Code duplicated, block: B:129:0x02c4 A[Catch: Exception -> 0x009a, TryCatch #1 {Exception -> 0x009a, blocks: (B:3:0x001a, B:6:0x0067, B:8:0x006d, B:10:0x0075, B:12:0x007d, B:14:0x0085, B:16:0x008f, B:19:0x009d, B:21:0x00a7, B:22:0x00b1, B:24:0x00bb, B:26:0x00c5, B:28:0x00cb, B:29:0x00d4, B:31:0x00ed, B:32:0x00f4, B:34:0x00fa, B:35:0x00ff, B:37:0x0126, B:38:0x012b, B:45:0x0146, B:48:0x014e, B:50:0x0156, B:52:0x015c, B:54:0x0161, B:56:0x0165, B:60:0x0179, B:62:0x0181, B:64:0x0187, B:68:0x0192, B:69:0x01a4, B:71:0x01a8, B:72:0x01be, B:74:0x01c6, B:76:0x01d5, B:77:0x01eb, B:80:0x01fc, B:82:0x0202, B:86:0x020f, B:88:0x0216, B:90:0x021c, B:115:0x0267, B:116:0x0274, B:124:0x028d, B:126:0x02b6, B:127:0x02bc, B:129:0x02c4, B:131:0x02d6, B:132:0x02df, B:134:0x02e7, B:140:0x02f7, B:144:0x0307, B:149:0x0314, B:153:0x0340, B:155:0x037b, B:156:0x0380, B:158:0x0388, B:160:0x0392, B:161:0x03b2, B:163:0x03bc, B:165:0x03c6, B:166:0x03e6, B:170:0x041c, B:172:0x0448, B:176:0x045d, B:175:0x0454, B:169:0x0419, B:152:0x032c, B:141:0x02fc, B:142:0x0301, B:98:0x0229, B:100:0x022f, B:109:0x0250, B:119:0x027f, B:177:0x0465), top: B:183:0x001a }] */
    /* JADX WARN: Code duplicated, block: B:131:0x02d6 A[Catch: Exception -> 0x009a, TryCatch #1 {Exception -> 0x009a, blocks: (B:3:0x001a, B:6:0x0067, B:8:0x006d, B:10:0x0075, B:12:0x007d, B:14:0x0085, B:16:0x008f, B:19:0x009d, B:21:0x00a7, B:22:0x00b1, B:24:0x00bb, B:26:0x00c5, B:28:0x00cb, B:29:0x00d4, B:31:0x00ed, B:32:0x00f4, B:34:0x00fa, B:35:0x00ff, B:37:0x0126, B:38:0x012b, B:45:0x0146, B:48:0x014e, B:50:0x0156, B:52:0x015c, B:54:0x0161, B:56:0x0165, B:60:0x0179, B:62:0x0181, B:64:0x0187, B:68:0x0192, B:69:0x01a4, B:71:0x01a8, B:72:0x01be, B:74:0x01c6, B:76:0x01d5, B:77:0x01eb, B:80:0x01fc, B:82:0x0202, B:86:0x020f, B:88:0x0216, B:90:0x021c, B:115:0x0267, B:116:0x0274, B:124:0x028d, B:126:0x02b6, B:127:0x02bc, B:129:0x02c4, B:131:0x02d6, B:132:0x02df, B:134:0x02e7, B:140:0x02f7, B:144:0x0307, B:149:0x0314, B:153:0x0340, B:155:0x037b, B:156:0x0380, B:158:0x0388, B:160:0x0392, B:161:0x03b2, B:163:0x03bc, B:165:0x03c6, B:166:0x03e6, B:170:0x041c, B:172:0x0448, B:176:0x045d, B:175:0x0454, B:169:0x0419, B:152:0x032c, B:141:0x02fc, B:142:0x0301, B:98:0x0229, B:100:0x022f, B:109:0x0250, B:119:0x027f, B:177:0x0465), top: B:183:0x001a }] */
    /* JADX WARN: Code duplicated, block: B:143:0x0306  */
    /* JADX WARN: Code duplicated, block: B:147:0x0311  */
    /* JADX WARN: Code duplicated, block: B:149:0x0314 A[Catch: Exception -> 0x009a, TRY_ENTER, TryCatch #1 {Exception -> 0x009a, blocks: (B:3:0x001a, B:6:0x0067, B:8:0x006d, B:10:0x0075, B:12:0x007d, B:14:0x0085, B:16:0x008f, B:19:0x009d, B:21:0x00a7, B:22:0x00b1, B:24:0x00bb, B:26:0x00c5, B:28:0x00cb, B:29:0x00d4, B:31:0x00ed, B:32:0x00f4, B:34:0x00fa, B:35:0x00ff, B:37:0x0126, B:38:0x012b, B:45:0x0146, B:48:0x014e, B:50:0x0156, B:52:0x015c, B:54:0x0161, B:56:0x0165, B:60:0x0179, B:62:0x0181, B:64:0x0187, B:68:0x0192, B:69:0x01a4, B:71:0x01a8, B:72:0x01be, B:74:0x01c6, B:76:0x01d5, B:77:0x01eb, B:80:0x01fc, B:82:0x0202, B:86:0x020f, B:88:0x0216, B:90:0x021c, B:115:0x0267, B:116:0x0274, B:124:0x028d, B:126:0x02b6, B:127:0x02bc, B:129:0x02c4, B:131:0x02d6, B:132:0x02df, B:134:0x02e7, B:140:0x02f7, B:144:0x0307, B:149:0x0314, B:153:0x0340, B:155:0x037b, B:156:0x0380, B:158:0x0388, B:160:0x0392, B:161:0x03b2, B:163:0x03bc, B:165:0x03c6, B:166:0x03e6, B:170:0x041c, B:172:0x0448, B:176:0x045d, B:175:0x0454, B:169:0x0419, B:152:0x032c, B:141:0x02fc, B:142:0x0301, B:98:0x0229, B:100:0x022f, B:109:0x0250, B:119:0x027f, B:177:0x0465), top: B:183:0x001a }] */
    /* JADX WARN: Code duplicated, block: B:150:0x0329  */
    /* JADX WARN: Code duplicated, block: B:152:0x032c A[Catch: Exception -> 0x009a, TryCatch #1 {Exception -> 0x009a, blocks: (B:3:0x001a, B:6:0x0067, B:8:0x006d, B:10:0x0075, B:12:0x007d, B:14:0x0085, B:16:0x008f, B:19:0x009d, B:21:0x00a7, B:22:0x00b1, B:24:0x00bb, B:26:0x00c5, B:28:0x00cb, B:29:0x00d4, B:31:0x00ed, B:32:0x00f4, B:34:0x00fa, B:35:0x00ff, B:37:0x0126, B:38:0x012b, B:45:0x0146, B:48:0x014e, B:50:0x0156, B:52:0x015c, B:54:0x0161, B:56:0x0165, B:60:0x0179, B:62:0x0181, B:64:0x0187, B:68:0x0192, B:69:0x01a4, B:71:0x01a8, B:72:0x01be, B:74:0x01c6, B:76:0x01d5, B:77:0x01eb, B:80:0x01fc, B:82:0x0202, B:86:0x020f, B:88:0x0216, B:90:0x021c, B:115:0x0267, B:116:0x0274, B:124:0x028d, B:126:0x02b6, B:127:0x02bc, B:129:0x02c4, B:131:0x02d6, B:132:0x02df, B:134:0x02e7, B:140:0x02f7, B:144:0x0307, B:149:0x0314, B:153:0x0340, B:155:0x037b, B:156:0x0380, B:158:0x0388, B:160:0x0392, B:161:0x03b2, B:163:0x03bc, B:165:0x03c6, B:166:0x03e6, B:170:0x041c, B:172:0x0448, B:176:0x045d, B:175:0x0454, B:169:0x0419, B:152:0x032c, B:141:0x02fc, B:142:0x0301, B:98:0x0229, B:100:0x022f, B:109:0x0250, B:119:0x027f, B:177:0x0465), top: B:183:0x001a }] */
    /* JADX WARN: Code duplicated, block: B:155:0x037b A[Catch: Exception -> 0x009a, TryCatch #1 {Exception -> 0x009a, blocks: (B:3:0x001a, B:6:0x0067, B:8:0x006d, B:10:0x0075, B:12:0x007d, B:14:0x0085, B:16:0x008f, B:19:0x009d, B:21:0x00a7, B:22:0x00b1, B:24:0x00bb, B:26:0x00c5, B:28:0x00cb, B:29:0x00d4, B:31:0x00ed, B:32:0x00f4, B:34:0x00fa, B:35:0x00ff, B:37:0x0126, B:38:0x012b, B:45:0x0146, B:48:0x014e, B:50:0x0156, B:52:0x015c, B:54:0x0161, B:56:0x0165, B:60:0x0179, B:62:0x0181, B:64:0x0187, B:68:0x0192, B:69:0x01a4, B:71:0x01a8, B:72:0x01be, B:74:0x01c6, B:76:0x01d5, B:77:0x01eb, B:80:0x01fc, B:82:0x0202, B:86:0x020f, B:88:0x0216, B:90:0x021c, B:115:0x0267, B:116:0x0274, B:124:0x028d, B:126:0x02b6, B:127:0x02bc, B:129:0x02c4, B:131:0x02d6, B:132:0x02df, B:134:0x02e7, B:140:0x02f7, B:144:0x0307, B:149:0x0314, B:153:0x0340, B:155:0x037b, B:156:0x0380, B:158:0x0388, B:160:0x0392, B:161:0x03b2, B:163:0x03bc, B:165:0x03c6, B:166:0x03e6, B:170:0x041c, B:172:0x0448, B:176:0x045d, B:175:0x0454, B:169:0x0419, B:152:0x032c, B:141:0x02fc, B:142:0x0301, B:98:0x0229, B:100:0x022f, B:109:0x0250, B:119:0x027f, B:177:0x0465), top: B:183:0x001a }] */
    /* JADX WARN: Code duplicated, block: B:158:0x0388 A[Catch: Exception -> 0x009a, TryCatch #1 {Exception -> 0x009a, blocks: (B:3:0x001a, B:6:0x0067, B:8:0x006d, B:10:0x0075, B:12:0x007d, B:14:0x0085, B:16:0x008f, B:19:0x009d, B:21:0x00a7, B:22:0x00b1, B:24:0x00bb, B:26:0x00c5, B:28:0x00cb, B:29:0x00d4, B:31:0x00ed, B:32:0x00f4, B:34:0x00fa, B:35:0x00ff, B:37:0x0126, B:38:0x012b, B:45:0x0146, B:48:0x014e, B:50:0x0156, B:52:0x015c, B:54:0x0161, B:56:0x0165, B:60:0x0179, B:62:0x0181, B:64:0x0187, B:68:0x0192, B:69:0x01a4, B:71:0x01a8, B:72:0x01be, B:74:0x01c6, B:76:0x01d5, B:77:0x01eb, B:80:0x01fc, B:82:0x0202, B:86:0x020f, B:88:0x0216, B:90:0x021c, B:115:0x0267, B:116:0x0274, B:124:0x028d, B:126:0x02b6, B:127:0x02bc, B:129:0x02c4, B:131:0x02d6, B:132:0x02df, B:134:0x02e7, B:140:0x02f7, B:144:0x0307, B:149:0x0314, B:153:0x0340, B:155:0x037b, B:156:0x0380, B:158:0x0388, B:160:0x0392, B:161:0x03b2, B:163:0x03bc, B:165:0x03c6, B:166:0x03e6, B:170:0x041c, B:172:0x0448, B:176:0x045d, B:175:0x0454, B:169:0x0419, B:152:0x032c, B:141:0x02fc, B:142:0x0301, B:98:0x0229, B:100:0x022f, B:109:0x0250, B:119:0x027f, B:177:0x0465), top: B:183:0x001a }] */
    /* JADX WARN: Code duplicated, block: B:163:0x03bc A[Catch: Exception -> 0x009a, TryCatch #1 {Exception -> 0x009a, blocks: (B:3:0x001a, B:6:0x0067, B:8:0x006d, B:10:0x0075, B:12:0x007d, B:14:0x0085, B:16:0x008f, B:19:0x009d, B:21:0x00a7, B:22:0x00b1, B:24:0x00bb, B:26:0x00c5, B:28:0x00cb, B:29:0x00d4, B:31:0x00ed, B:32:0x00f4, B:34:0x00fa, B:35:0x00ff, B:37:0x0126, B:38:0x012b, B:45:0x0146, B:48:0x014e, B:50:0x0156, B:52:0x015c, B:54:0x0161, B:56:0x0165, B:60:0x0179, B:62:0x0181, B:64:0x0187, B:68:0x0192, B:69:0x01a4, B:71:0x01a8, B:72:0x01be, B:74:0x01c6, B:76:0x01d5, B:77:0x01eb, B:80:0x01fc, B:82:0x0202, B:86:0x020f, B:88:0x0216, B:90:0x021c, B:115:0x0267, B:116:0x0274, B:124:0x028d, B:126:0x02b6, B:127:0x02bc, B:129:0x02c4, B:131:0x02d6, B:132:0x02df, B:134:0x02e7, B:140:0x02f7, B:144:0x0307, B:149:0x0314, B:153:0x0340, B:155:0x037b, B:156:0x0380, B:158:0x0388, B:160:0x0392, B:161:0x03b2, B:163:0x03bc, B:165:0x03c6, B:166:0x03e6, B:170:0x041c, B:172:0x0448, B:176:0x045d, B:175:0x0454, B:169:0x0419, B:152:0x032c, B:141:0x02fc, B:142:0x0301, B:98:0x0229, B:100:0x022f, B:109:0x0250, B:119:0x027f, B:177:0x0465), top: B:183:0x001a }] */
    /* JADX WARN: Code duplicated, block: B:168:0x0417 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:169:0x0419 A[Catch: Exception -> 0x009a, TryCatch #1 {Exception -> 0x009a, blocks: (B:3:0x001a, B:6:0x0067, B:8:0x006d, B:10:0x0075, B:12:0x007d, B:14:0x0085, B:16:0x008f, B:19:0x009d, B:21:0x00a7, B:22:0x00b1, B:24:0x00bb, B:26:0x00c5, B:28:0x00cb, B:29:0x00d4, B:31:0x00ed, B:32:0x00f4, B:34:0x00fa, B:35:0x00ff, B:37:0x0126, B:38:0x012b, B:45:0x0146, B:48:0x014e, B:50:0x0156, B:52:0x015c, B:54:0x0161, B:56:0x0165, B:60:0x0179, B:62:0x0181, B:64:0x0187, B:68:0x0192, B:69:0x01a4, B:71:0x01a8, B:72:0x01be, B:74:0x01c6, B:76:0x01d5, B:77:0x01eb, B:80:0x01fc, B:82:0x0202, B:86:0x020f, B:88:0x0216, B:90:0x021c, B:115:0x0267, B:116:0x0274, B:124:0x028d, B:126:0x02b6, B:127:0x02bc, B:129:0x02c4, B:131:0x02d6, B:132:0x02df, B:134:0x02e7, B:140:0x02f7, B:144:0x0307, B:149:0x0314, B:153:0x0340, B:155:0x037b, B:156:0x0380, B:158:0x0388, B:160:0x0392, B:161:0x03b2, B:163:0x03bc, B:165:0x03c6, B:166:0x03e6, B:170:0x041c, B:172:0x0448, B:176:0x045d, B:175:0x0454, B:169:0x0419, B:152:0x032c, B:141:0x02fc, B:142:0x0301, B:98:0x0229, B:100:0x022f, B:109:0x0250, B:119:0x027f, B:177:0x0465), top: B:183:0x001a }] */
    /* JADX WARN: Code duplicated, block: B:172:0x0448 A[Catch: Exception -> 0x009a, TryCatch #1 {Exception -> 0x009a, blocks: (B:3:0x001a, B:6:0x0067, B:8:0x006d, B:10:0x0075, B:12:0x007d, B:14:0x0085, B:16:0x008f, B:19:0x009d, B:21:0x00a7, B:22:0x00b1, B:24:0x00bb, B:26:0x00c5, B:28:0x00cb, B:29:0x00d4, B:31:0x00ed, B:32:0x00f4, B:34:0x00fa, B:35:0x00ff, B:37:0x0126, B:38:0x012b, B:45:0x0146, B:48:0x014e, B:50:0x0156, B:52:0x015c, B:54:0x0161, B:56:0x0165, B:60:0x0179, B:62:0x0181, B:64:0x0187, B:68:0x0192, B:69:0x01a4, B:71:0x01a8, B:72:0x01be, B:74:0x01c6, B:76:0x01d5, B:77:0x01eb, B:80:0x01fc, B:82:0x0202, B:86:0x020f, B:88:0x0216, B:90:0x021c, B:115:0x0267, B:116:0x0274, B:124:0x028d, B:126:0x02b6, B:127:0x02bc, B:129:0x02c4, B:131:0x02d6, B:132:0x02df, B:134:0x02e7, B:140:0x02f7, B:144:0x0307, B:149:0x0314, B:153:0x0340, B:155:0x037b, B:156:0x0380, B:158:0x0388, B:160:0x0392, B:161:0x03b2, B:163:0x03bc, B:165:0x03c6, B:166:0x03e6, B:170:0x041c, B:172:0x0448, B:176:0x045d, B:175:0x0454, B:169:0x0419, B:152:0x032c, B:141:0x02fc, B:142:0x0301, B:98:0x0229, B:100:0x022f, B:109:0x0250, B:119:0x027f, B:177:0x0465), top: B:183:0x001a }] */
    /* JADX WARN: Code duplicated, block: B:173:0x044f  */
    /* JADX WARN: Code duplicated, block: B:175:0x0454 A[Catch: Exception -> 0x009a, TryCatch #1 {Exception -> 0x009a, blocks: (B:3:0x001a, B:6:0x0067, B:8:0x006d, B:10:0x0075, B:12:0x007d, B:14:0x0085, B:16:0x008f, B:19:0x009d, B:21:0x00a7, B:22:0x00b1, B:24:0x00bb, B:26:0x00c5, B:28:0x00cb, B:29:0x00d4, B:31:0x00ed, B:32:0x00f4, B:34:0x00fa, B:35:0x00ff, B:37:0x0126, B:38:0x012b, B:45:0x0146, B:48:0x014e, B:50:0x0156, B:52:0x015c, B:54:0x0161, B:56:0x0165, B:60:0x0179, B:62:0x0181, B:64:0x0187, B:68:0x0192, B:69:0x01a4, B:71:0x01a8, B:72:0x01be, B:74:0x01c6, B:76:0x01d5, B:77:0x01eb, B:80:0x01fc, B:82:0x0202, B:86:0x020f, B:88:0x0216, B:90:0x021c, B:115:0x0267, B:116:0x0274, B:124:0x028d, B:126:0x02b6, B:127:0x02bc, B:129:0x02c4, B:131:0x02d6, B:132:0x02df, B:134:0x02e7, B:140:0x02f7, B:144:0x0307, B:149:0x0314, B:153:0x0340, B:155:0x037b, B:156:0x0380, B:158:0x0388, B:160:0x0392, B:161:0x03b2, B:163:0x03bc, B:165:0x03c6, B:166:0x03e6, B:170:0x041c, B:172:0x0448, B:176:0x045d, B:175:0x0454, B:169:0x0419, B:152:0x032c, B:141:0x02fc, B:142:0x0301, B:98:0x0229, B:100:0x022f, B:109:0x0250, B:119:0x027f, B:177:0x0465), top: B:183:0x001a }] */
    /* JADX WARN: Instruction removed from duplicated block: B:149:0x0314, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:152:0x032c, please report this as an issue */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    @Override // com.mbridge.msdk.mbnative.controller.b
    public final void a(int i11, long j11, int i12, com.mbridge.msdk.c.k kVar, String str, String str2, com.mbridge.msdk.b.a.a aVar, boolean z11) {
        int i13;
        int i14;
        int iOptInt;
        int iA;
        int i15;
        String strA;
        a aVar2;
        k kVar2;
        JSONArray jSONArrayB;
        String str3;
        int iOptInt2;
        String string;
        List<Campaign> listB;
        List<Campaign> listB2;
        try {
            com.mbridge.msdk.foundation.db.f.a(h.a(com.mbridge.msdk.foundation.controller.c.m().c())).a();
            int iE = this.f45579n.e();
            int iD = this.f45579n.d();
            com.mbridge.msdk.mbnative.f.a.a aVar3 = new com.mbridge.msdk.mbnative.f.a.a(com.mbridge.msdk.foundation.controller.c.m().c());
            com.mbridge.msdk.foundation.same.net.h.e eVar = new com.mbridge.msdk.foundation.same.net.h.e();
            String strK = com.mbridge.msdk.foundation.controller.c.m().k();
            String strB = com.mbridge.msdk.foundation.controller.c.m().b();
            Map<String, Object> map = this.f45582q;
            if (map != null && map.containsKey("app_id") && this.f45582q.containsKey(MBridgeConstans.APP_KEY) && this.f45582q.containsKey(MBridgeConstans.KEY_WORD) && this.f45582q.get(MBridgeConstans.KEY_WORD) != null) {
                if (this.f45582q.get("app_id") instanceof String) {
                    strK = (String) this.f45582q.get("app_id");
                }
                if (this.f45582q.get(MBridgeConstans.APP_KEY) instanceof String) {
                    strB = (String) this.f45582q.get(MBridgeConstans.APP_KEY);
                }
                String str4 = this.f45582q.get(MBridgeConstans.KEY_WORD) instanceof String ? (String) this.f45582q.get(MBridgeConstans.KEY_WORD) : null;
                if (!TextUtils.isEmpty(str4)) {
                    eVar.a("smart", x.b(str4));
                }
            }
            String str5 = strK;
            String str6 = strB;
            eVar.a("app_id", str5);
            eVar.a(MBridgeConstans.PROPERTIES_UNIT_ID, str);
            eVar.a("req_type", "1");
            if (!TextUtils.isEmpty(this.f45580o)) {
                eVar.a("category", this.f45580o);
            }
            if (!TextUtils.isEmpty(str2)) {
                eVar.a(MBridgeConstans.PLACEMENT_ID, str2);
            }
            eVar.a("sign", SameMD5.getMD5(str5 + str6));
            eVar.a("only_impression", "1");
            String strD = ai.d(str);
            if (!TextUtils.isEmpty(strD)) {
                eVar.a("j", strD);
            }
            int iIntValue = f45569i.get(str).intValue();
            if (iE == f45572u || iE == 0 || iIntValue == 0) {
                a("The request was refused", i12, str, str2, aVar);
                return;
            }
            if (i12 == 0) {
                com.mbridge.msdk.mbnative.a.b<String, List<Campaign>> bVarA = com.mbridge.msdk.mbnative.a.c.a(i11);
                if (z11) {
                    if (bVarA != null && (listB2 = bVarA.b(str, iIntValue)) != null && listB2.size() > 0) {
                        a(true, aVar, (String) null);
                        return;
                    } else {
                        if (this.f45586w) {
                            a("", i12, str, str2, aVar);
                            return;
                        }
                        return;
                    }
                }
                if (i11 != 1 && bVarA != null && (listB = bVarA.b(str, iIntValue)) != null && listB.size() > 0) {
                    a(true, aVar, (String) null);
                    return;
                }
            }
            if (iIntValue != 0) {
                eVar.a("ad_num", iIntValue + "");
            }
            if (this.f45581p != 0) {
                eVar.a("frame_num", this.f45581p + "");
            }
            if (this.f45582q.containsKey(MBridgeConstans.NATIVE_INFO)) {
                String str7 = (String) this.f45582q.get(MBridgeConstans.NATIVE_INFO);
                if (TextUtils.isEmpty(str7)) {
                    i13 = iIntValue;
                    i14 = 0;
                    iOptInt = 0;
                } else {
                    ad.b(f45565e, "nativeinfo" + str7);
                    try {
                        JSONArray jSONArray = new JSONArray(str7);
                        if (jSONArray.length() > 0) {
                            str3 = str7;
                            int i16 = 0;
                            iOptInt = 0;
                            iOptInt2 = 0;
                            while (i16 < jSONArray.length()) {
                                try {
                                    JSONObject jSONObject = (JSONObject) jSONArray.opt(i16);
                                    int i17 = iOptInt;
                                    i13 = iIntValue;
                                    try {
                                        int iOptInt3 = jSONObject.optInt("id", 0);
                                        if (2 == iOptInt3) {
                                            iOptInt = jSONObject.optInt("ad_num");
                                            if (iE > 0) {
                                                try {
                                                    jSONObject.put("ad_num", iE);
                                                } catch (JSONException e11) {
                                                    e = e11;
                                                    ad.b(f45565e, com.mbridge.msdk.mbnative.b.a.a(e));
                                                    i14 = iOptInt2;
                                                    string = str3;
                                                    eVar.a(MBridgeConstans.NATIVE_INFO, string);
                                                    iE = i13;
                                                    eVar.a("ad_num", iE + "");
                                                    eVar.a("ping_mode", "1");
                                                    if (com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k()) == null) {
                                                        com.mbridge.msdk.c.h.a();
                                                        i.a();
                                                    }
                                                    if (!NativeController.a(this.f45582q)) {
                                                        jSONArrayB = ai.b(com.mbridge.msdk.foundation.controller.c.m().c(), str);
                                                        if (jSONArrayB.length() > 0) {
                                                            eVar.a(com.mbridge.msdk.foundation.same.net.h.e.f44660e, ai.a(jSONArrayB));
                                                        }
                                                    }
                                                    if (f45568h.containsKey(str)) {
                                                        iA = 0;
                                                    } else {
                                                        iA = 0;
                                                    }
                                                    if (this.f45582q.containsKey(MBridgeConstans.NATIVE_INFO)) {
                                                        i15 = 1;
                                                        if (i11 == 1) {
                                                            eVar.a("tnum", this.f45587x + "");
                                                        }
                                                        eVar.a("offset", iA + "");
                                                        eVar.a("ad_type", "42");
                                                        eVar.a(CampaignEx.JSON_KEY_AD_SOURCE_ID, i11 + "");
                                                        strA = com.mbridge.msdk.foundation.same.a.d.a(str, "native");
                                                        if (!TextUtils.isEmpty(strA)) {
                                                            eVar.a(com.mbridge.msdk.foundation.same.net.h.e.f44659d, strA);
                                                        }
                                                        if (this.f45582q.containsKey(MBridgeConstans.NATIVE_VIDEO_WIDTH)) {
                                                            eVar.a("video_width", ((Integer) this.f45582q.get(MBridgeConstans.NATIVE_VIDEO_WIDTH)).intValue() + "");
                                                        }
                                                        if (this.f45582q.containsKey(MBridgeConstans.NATIVE_VIDEO_HEIGHT)) {
                                                            eVar.a("video_height", ((Integer) this.f45582q.get(MBridgeConstans.NATIVE_VIDEO_HEIGHT)).intValue() + "");
                                                        }
                                                        eVar.a("video_version", MBridgeConstans.NATIVE_VIDEO_VERSION);
                                                        aVar2 = new a(i11);
                                                        aVar2.setUnitId(str);
                                                        aVar2.setPlacementId(str2);
                                                        aVar2.setAdType(42);
                                                        aVar2.d(i13);
                                                        aVar2.b(iOptInt);
                                                        aVar2.c(i14);
                                                        aVar2.a(iD);
                                                        aVar2.a(aVar);
                                                        if (i11 == 1) {
                                                            aVar2.b(true);
                                                        } else {
                                                            aVar2.b(true);
                                                        }
                                                        aVar2.a(NativeController.b(this.f45582q));
                                                        b bVar = new b(1, aVar2, i12, str, str2);
                                                        aVar2.a(bVar);
                                                        aVar2.e(i12);
                                                        bVar.a(aVar);
                                                        bVar.a(z11);
                                                        bVar.a(str);
                                                        if (i12 == 0) {
                                                            aVar3.choiceV3OrV5BySetting(1, eVar, aVar2, "");
                                                        } else if (i12 == 1) {
                                                            aVar3.getLoadOrSetting(1, com.mbridge.msdk.foundation.same.net.g.d.f().N, eVar, aVar2);
                                                        }
                                                        this.f45553a.postDelayed(bVar, j11);
                                                    }
                                                    i15 = 1;
                                                    if (i11 == i15) {
                                                        eVar.a("tnum", this.f45588y + "");
                                                    }
                                                    eVar.a("offset", iA + "");
                                                    eVar.a("ad_type", "42");
                                                    eVar.a(CampaignEx.JSON_KEY_AD_SOURCE_ID, i11 + "");
                                                    strA = com.mbridge.msdk.foundation.same.a.d.a(str, "native");
                                                    if (!TextUtils.isEmpty(strA)) {
                                                        eVar.a(com.mbridge.msdk.foundation.same.net.h.e.f44659d, strA);
                                                    }
                                                    if (this.f45582q.containsKey(MBridgeConstans.NATIVE_VIDEO_WIDTH)) {
                                                        eVar.a("video_width", ((Integer) this.f45582q.get(MBridgeConstans.NATIVE_VIDEO_WIDTH)).intValue() + "");
                                                    }
                                                    if (this.f45582q.containsKey(MBridgeConstans.NATIVE_VIDEO_HEIGHT)) {
                                                        eVar.a("video_height", ((Integer) this.f45582q.get(MBridgeConstans.NATIVE_VIDEO_HEIGHT)).intValue() + "");
                                                    }
                                                    eVar.a("video_version", MBridgeConstans.NATIVE_VIDEO_VERSION);
                                                    aVar2 = new a(i11);
                                                    aVar2.setUnitId(str);
                                                    aVar2.setPlacementId(str2);
                                                    aVar2.setAdType(42);
                                                    aVar2.d(i13);
                                                    aVar2.b(iOptInt);
                                                    aVar2.c(i14);
                                                    aVar2.a(iD);
                                                    aVar2.a(aVar);
                                                    if (i11 == 1) {
                                                        aVar2.b(true);
                                                    } else {
                                                        aVar2.b(true);
                                                    }
                                                    aVar2.a(NativeController.b(this.f45582q));
                                                    b bVar2 = new b(1, aVar2, i12, str, str2);
                                                    aVar2.a(bVar2);
                                                    aVar2.e(i12);
                                                    bVar2.a(aVar);
                                                    bVar2.a(z11);
                                                    bVar2.a(str);
                                                    if (i12 == 0) {
                                                        aVar3.choiceV3OrV5BySetting(1, eVar, aVar2, "");
                                                    } else if (i12 == 1) {
                                                        aVar3.getLoadOrSetting(1, com.mbridge.msdk.foundation.same.net.g.d.f().N, eVar, aVar2);
                                                    }
                                                    this.f45553a.postDelayed(bVar2, j11);
                                                }
                                            } else {
                                                continue;
                                            }
                                        } else {
                                            if (3 == iOptInt3) {
                                                iOptInt2 = jSONObject.optInt("ad_num");
                                                if (iE > 0) {
                                                    jSONObject.put("ad_num", iE);
                                                }
                                            }
                                            iOptInt = i17;
                                        }
                                        i16++;
                                        iIntValue = i13;
                                    } catch (JSONException e12) {
                                        e = e12;
                                        iOptInt = i17;
                                    }
                                } catch (JSONException e13) {
                                    e = e13;
                                    i13 = iIntValue;
                                }
                            }
                            i13 = iIntValue;
                            i14 = iOptInt2;
                        } else {
                            i13 = iIntValue;
                            str3 = str7;
                            i14 = 0;
                            iOptInt = 0;
                        }
                        try {
                            this.f45587x = Math.max(iOptInt, i14);
                            string = jSONArray.toString();
                        } catch (JSONException e14) {
                            e = e14;
                            iOptInt2 = i14;
                            ad.b(f45565e, com.mbridge.msdk.mbnative.b.a.a(e));
                            i14 = iOptInt2;
                            string = str3;
                        }
                    } catch (JSONException e15) {
                        e = e15;
                        i13 = iIntValue;
                        str3 = str7;
                        iOptInt = 0;
                        iOptInt2 = 0;
                    }
                    eVar.a(MBridgeConstans.NATIVE_INFO, string);
                }
                iE = i13;
            } else {
                i13 = iIntValue;
                if (iE == f45573v || iE == 0) {
                    iE = i13;
                }
                i14 = 0;
                iOptInt = 0;
            }
            eVar.a("ad_num", iE + "");
            eVar.a("ping_mode", "1");
            if (com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k()) == null) {
                com.mbridge.msdk.c.h.a();
                i.a();
            }
            if (!NativeController.a(this.f45582q)) {
                jSONArrayB = ai.b(com.mbridge.msdk.foundation.controller.c.m().c(), str);
                if (jSONArrayB.length() > 0) {
                    eVar.a(com.mbridge.msdk.foundation.same.net.h.e.f44660e, ai.a(jSONArrayB));
                }
            }
            if (f45568h.containsKey(str) || (kVar2 = f45568h.get(str)) == null) {
                iA = 0;
            } else {
                iA = (i11 == 1 || i11 != 2) ? kVar2.a() : kVar2.b();
            }
            if (this.f45582q.containsKey(MBridgeConstans.NATIVE_INFO)) {
                i15 = 1;
                if (i11 == 1) {
                    eVar.a("tnum", this.f45587x + "");
                }
                eVar.a("offset", iA + "");
                eVar.a("ad_type", "42");
                eVar.a(CampaignEx.JSON_KEY_AD_SOURCE_ID, i11 + "");
                strA = com.mbridge.msdk.foundation.same.a.d.a(str, "native");
                if (!TextUtils.isEmpty(strA)) {
                    eVar.a(com.mbridge.msdk.foundation.same.net.h.e.f44659d, strA);
                }
                if (this.f45582q.containsKey(MBridgeConstans.NATIVE_VIDEO_WIDTH) && (this.f45582q.get(MBridgeConstans.NATIVE_VIDEO_WIDTH) instanceof Integer)) {
                    eVar.a("video_width", ((Integer) this.f45582q.get(MBridgeConstans.NATIVE_VIDEO_WIDTH)).intValue() + "");
                }
                if (this.f45582q.containsKey(MBridgeConstans.NATIVE_VIDEO_HEIGHT) && (this.f45582q.get(MBridgeConstans.NATIVE_VIDEO_HEIGHT) instanceof Integer)) {
                    eVar.a("video_height", ((Integer) this.f45582q.get(MBridgeConstans.NATIVE_VIDEO_HEIGHT)).intValue() + "");
                }
                eVar.a("video_version", MBridgeConstans.NATIVE_VIDEO_VERSION);
                aVar2 = new a(i11);
                aVar2.setUnitId(str);
                aVar2.setPlacementId(str2);
                aVar2.setAdType(42);
                aVar2.d(i13);
                aVar2.b(iOptInt);
                aVar2.c(i14);
                aVar2.a(iD);
                aVar2.a(aVar);
                if (i11 == 1 || z11) {
                    aVar2.b(true);
                }
                aVar2.a(NativeController.b(this.f45582q));
                b bVar3 = new b(1, aVar2, i12, str, str2);
                aVar2.a(bVar3);
                aVar2.e(i12);
                bVar3.a(aVar);
                bVar3.a(z11);
                bVar3.a(str);
                if (i12 == 0) {
                    aVar3.choiceV3OrV5BySetting(1, eVar, aVar2, "");
                } else if (i12 == 1) {
                    aVar3.getLoadOrSetting(1, com.mbridge.msdk.foundation.same.net.g.d.f().N, eVar, aVar2);
                }
                this.f45553a.postDelayed(bVar3, j11);
            }
            i15 = 1;
            if (i11 == i15) {
                eVar.a("tnum", this.f45588y + "");
            }
            eVar.a("offset", iA + "");
            eVar.a("ad_type", "42");
            eVar.a(CampaignEx.JSON_KEY_AD_SOURCE_ID, i11 + "");
            strA = com.mbridge.msdk.foundation.same.a.d.a(str, "native");
            if (!TextUtils.isEmpty(strA)) {
                eVar.a(com.mbridge.msdk.foundation.same.net.h.e.f44659d, strA);
            }
            if (this.f45582q.containsKey(MBridgeConstans.NATIVE_VIDEO_WIDTH)) {
                eVar.a("video_width", ((Integer) this.f45582q.get(MBridgeConstans.NATIVE_VIDEO_WIDTH)).intValue() + "");
            }
            if (this.f45582q.containsKey(MBridgeConstans.NATIVE_VIDEO_HEIGHT)) {
                eVar.a("video_height", ((Integer) this.f45582q.get(MBridgeConstans.NATIVE_VIDEO_HEIGHT)).intValue() + "");
            }
            eVar.a("video_version", MBridgeConstans.NATIVE_VIDEO_VERSION);
            aVar2 = new a(i11);
            aVar2.setUnitId(str);
            aVar2.setPlacementId(str2);
            aVar2.setAdType(42);
            aVar2.d(i13);
            aVar2.b(iOptInt);
            aVar2.c(i14);
            aVar2.a(iD);
            aVar2.a(aVar);
            if (i11 == 1) {
                aVar2.b(true);
            } else {
                aVar2.b(true);
            }
            aVar2.a(NativeController.b(this.f45582q));
            b bVar4 = new b(1, aVar2, i12, str, str2);
            aVar2.a(bVar4);
            aVar2.e(i12);
            bVar4.a(aVar);
            bVar4.a(z11);
            bVar4.a(str);
            if (i12 == 0) {
                aVar3.choiceV3OrV5BySetting(1, eVar, aVar2, "");
            } else if (i12 == 1) {
                aVar3.getLoadOrSetting(1, com.mbridge.msdk.foundation.same.net.g.d.f().N, eVar, aVar2);
            }
            this.f45553a.postDelayed(bVar4, j11);
        } catch (Exception e16) {
            String str8 = f45565e;
            ad.b(str8, com.mbridge.msdk.mbnative.b.a.a(e16));
            ad.b(str8, e16.getMessage());
        }
    }

    public final void a(String str, int i11, String str2, String str3, com.mbridge.msdk.b.a.a aVar) {
        Log.e(f45565e, str);
        try {
            Queue<Integer> queue = this.f45574b;
            if (queue == null || queue.size() > 0) {
                if (this.f45574b != null) {
                    a(i11, this.f45579n, str2, str3, aVar);
                    return;
                }
            }
            a(false, aVar, str);
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    public final void a(Thread thread) {
        if (MBridgeConstans.PRELOAD_RESULT_IN_SUBTHREAD) {
            thread.start();
        } else {
            thread.run();
        }
    }

    public final void a(Map<String, Object> map, int i11) {
        String str;
        String str2;
        com.mbridge.msdk.b.a.a aVar;
        String str3;
        com.mbridge.msdk.mbnative.a.b<String, List<Campaign>> bVarA;
        List<Campaign> listB;
        Object obj;
        try {
            this.f45582q = map;
            this.f45586w = false;
            if (map.containsKey(MBridgeConstans.PROPERTIES_UNIT_ID)) {
                String str4 = (String) map.get(MBridgeConstans.PROPERTIES_UNIT_ID);
                if (f45566f.containsKey(((i11 + 1) % 2) + "_" + str4)) {
                    if (!f45566f.containsKey(i11 + "_" + str4)) {
                        return;
                    }
                }
                if (TextUtils.isEmpty(str4)) {
                    return;
                }
                if (map.containsKey(MBridgeConstans.PREIMAGE)) {
                    this.f45585t = ((Boolean) map.get(MBridgeConstans.PREIMAGE)).booleanValue();
                }
                com.mbridge.msdk.click.a aVar2 = this.f45578m;
                if (aVar2 == null) {
                    this.f45578m = new com.mbridge.msdk.click.a(com.mbridge.msdk.foundation.controller.c.m().c(), str4);
                } else {
                    aVar2.a(str4);
                }
                if (map.containsKey(MBridgeConstans.PROPERTIES_AD_FRAME_NUM)) {
                    this.f45581p = ((Integer) map.get(MBridgeConstans.PROPERTIES_AD_FRAME_NUM)).intValue();
                }
                if (map.containsKey(MBridgeConstans.PROPERTIES_API_REUQEST_CATEGORY)) {
                    this.f45580o = (String) map.get(MBridgeConstans.PROPERTIES_API_REUQEST_CATEGORY);
                }
                if (f45567g.containsKey(str4) && f45567g.get(str4).booleanValue()) {
                    Map<String, Map<Long, Object>> map2 = f45566f;
                    Map<Long, Object> map3 = map2.get(i11 + "_" + str4);
                    g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
                    if (map3 != null && map3.size() > 0) {
                        Long next = map3.keySet().iterator().next();
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        if (gVarB == null) {
                            com.mbridge.msdk.c.h.a();
                            gVarB = i.a();
                        }
                        if (jCurrentTimeMillis - next.longValue() >= gVarB.ab() * 1000) {
                            map2.remove(str4);
                        } else if (i11 == 1) {
                            return;
                        }
                    }
                }
                f45567g.put(str4, Boolean.TRUE);
                this.f45588y = 1;
                try {
                    if (map.containsKey("ad_num")) {
                        int iIntValue = ((Integer) map.get("ad_num")).intValue();
                        this.f45588y = iIntValue;
                        if (iIntValue < 1) {
                            this.f45588y = 1;
                        }
                        if (this.f45588y > 10) {
                            this.f45588y = 10;
                        }
                    }
                } catch (Exception unused) {
                    ad.b(f45565e, "ADNUM MUST BE INTEGER");
                }
                f45569i.put(str4, Integer.valueOf(this.f45588y));
                com.mbridge.msdk.b.a.a aVar3 = (!map.containsKey(MBridgeConstans.PRELOAD_RESULT_LISTENER) || (obj = map.get(MBridgeConstans.PRELOAD_RESULT_LISTENER)) == null) ? null : new com.mbridge.msdk.b.a.a((PreloadListener) obj);
                String strK = com.mbridge.msdk.foundation.controller.c.m().k();
                String strB = com.mbridge.msdk.foundation.controller.c.m().b();
                if (map.containsKey("app_id") && map.containsKey(MBridgeConstans.APP_KEY) && map.containsKey(MBridgeConstans.KEY_WORD)) {
                    strK = (String) map.get("app_id");
                    strB = (String) map.get(MBridgeConstans.APP_KEY);
                }
                if (this.f45577l == null) {
                    this.f45577l = new j();
                }
                this.f45577l.a(com.mbridge.msdk.foundation.controller.c.m().c(), strK, strB, str4);
                com.mbridge.msdk.c.k kVarD = com.mbridge.msdk.c.h.a().d(strK, str4);
                this.f45579n = kVarD;
                if (kVarD == null) {
                    this.f45579n = com.mbridge.msdk.c.k.d(str4);
                }
                if (map.containsKey(MBridgeConstans.PLACEMENT_ID) && map.get(MBridgeConstans.PLACEMENT_ID) != null) {
                    String str5 = (String) map.get(MBridgeConstans.PLACEMENT_ID);
                    str = TextUtils.isEmpty(str5) ? "" : str5;
                }
                this.f45583r = this.f45579n.b();
                this.f45576d = this.f45579n.c();
                this.f45584s = this.f45579n.c();
                List<Integer> list = this.f45583r;
                if (list == null || list.size() <= 0) {
                    com.mbridge.msdk.b.a.a aVar4 = aVar3;
                    if (aVar4 != null) {
                        aVar4.onPreloadFaild("do not have sorceList");
                        return;
                    }
                    return;
                }
                this.f45574b = new LinkedList();
                Iterator<Integer> it = this.f45583r.iterator();
                while (it.hasNext()) {
                    this.f45574b.add(it.next());
                }
                List<Integer> list2 = this.f45584s;
                if (list2 != null && list2.size() > 0) {
                    this.f45575c = new LinkedList();
                    Iterator<Integer> it2 = this.f45584s.iterator();
                    while (it2.hasNext()) {
                        this.f45575c.add(Long.valueOf(it2.next().intValue() * 1000));
                    }
                }
                if (this.f45583r.contains(1) && i11 == 0) {
                    try {
                        str2 = "";
                        com.mbridge.msdk.b.a.a aVar5 = aVar3;
                        str3 = str4;
                        try {
                            a(1, this.f45576d.get(this.f45583r.indexOf(1)).intValue() * 1000, i11, this.f45579n, str4, str, false, aVar5);
                            com.mbridge.msdk.mbnative.a.b<String, List<Campaign>> bVarA2 = com.mbridge.msdk.mbnative.a.c.a(1);
                            if (bVarA2 == null || (listB = bVarA2.b(str3, 0)) == null || listB.size() <= 0) {
                                aVar = aVar5;
                            } else {
                                aVar = aVar5;
                                try {
                                    a(true, aVar, (String) null);
                                } catch (Exception unused2) {
                                }
                            }
                        } catch (Exception unused3) {
                        }
                    } catch (Exception unused4) {
                        str2 = "";
                        aVar = aVar3;
                        str3 = str4;
                    }
                } else {
                    str2 = "";
                    aVar = aVar3;
                    str3 = str4;
                }
                a(i11, this.f45579n, str3, str, aVar);
                com.mbridge.msdk.c.k kVar = this.f45579n;
                f45570j.put(str3, Integer.valueOf(kVar != null ? kVar.w() * this.f45588y : 1));
                try {
                    int i12 = MBMediaView.f45890a0;
                    e.a(com.mbridge.msdk.foundation.controller.c.m().c(), str3);
                    ab.a();
                    if (TextUtils.isEmpty(str3)) {
                        return;
                    }
                    com.mbridge.msdk.foundation.db.f.a(h.a(com.mbridge.msdk.foundation.controller.c.m().c())).a();
                    int iA = a(map.containsKey(MBridgeConstans.NATIVE_INFO) ? (String) map.get(MBridgeConstans.NATIVE_INFO) : null);
                    if (iA <= 0) {
                        iA = this.f45588y;
                    }
                    com.mbridge.msdk.c.k kVarD2 = com.mbridge.msdk.c.h.a().d(str2, str3);
                    this.f45579n = kVarD2;
                    if (kVarD2 == null) {
                        this.f45579n = com.mbridge.msdk.c.k.d(str3);
                    }
                    List<Integer> listB2 = this.f45579n.b();
                    this.f45583r = listB2;
                    List<Campaign> listB3 = (listB2 == null || listB2.size() <= 0 || !this.f45583r.contains(1) || (bVarA = com.mbridge.msdk.mbnative.a.c.a(1)) == null) ? null : bVarA.b(str3, iA);
                    if (listB3 != null) {
                        ArrayList arrayList = new ArrayList();
                        for (int i13 = 0; i13 < listB3.size(); i13++) {
                            CampaignEx campaignEx = (CampaignEx) listB3.get(i13);
                            if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
                                arrayList.add(campaignEx);
                            }
                        }
                        if (arrayList.size() > 0) {
                            Object objInvoke = com.mbridge.msdk.videocommon.download.b.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
                            com.mbridge.msdk.videocommon.download.b.class.getMethod("createUnitCache", Context.class, String.class, CopyOnWriteArrayList.class, Integer.TYPE, com.mbridge.msdk.videocommon.listener.a.class).invoke(objInvoke, com.mbridge.msdk.foundation.controller.c.m().c(), str3, new CopyOnWriteArrayList(arrayList), 1, null);
                            com.mbridge.msdk.videocommon.download.b.class.getMethod("load", String.class).invoke(objInvoke, str3);
                        }
                    }
                } catch (Throwable unused5) {
                    ad.b(f45565e, "init cam cache failed");
                }
            }
        } catch (Exception e11) {
            ad.b(f45565e, com.mbridge.msdk.mbnative.b.a.a(e11));
        }
    }

    public final void a(boolean z11, com.mbridge.msdk.b.a.a aVar, String str) {
        if (z11) {
            if (aVar == null || aVar.a()) {
                return;
            }
            aVar.a(true);
            aVar.onPreloadSucceed();
            return;
        }
        if (aVar == null || aVar.a()) {
            return;
        }
        aVar.a(true);
        aVar.onPreloadFaild(str);
    }

    public final void a(boolean z11, Campaign campaign) {
        if (campaign == null) {
            return;
        }
        if (z11 && campaign.getIconDrawable() == null) {
            campaign.loadIconUrlAsyncWithBlock(null);
        }
        if (z11 && campaign.getBigDrawable() == null) {
            campaign.loadImageUrlAsyncWithBlock(null);
        }
    }
}
