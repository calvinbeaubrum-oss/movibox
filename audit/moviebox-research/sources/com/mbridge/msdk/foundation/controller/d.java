package com.mbridge.msdk.foundation.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.MBridgeSDK;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.entity.l;
import com.mbridge.msdk.foundation.same.net.n;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.foundation.same.report.o;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ag;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.interstitialvideo.out.MBInterstitialVideoHandler;
import com.mbridge.msdk.out.MBRewardVideoHandler;
import com.mbridge.msdk.out.MBridgeSDKFactory;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile d f44077e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f44082f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<String, Object> f44083g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private FastKV f44084h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private String f44086j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private String f44087k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f44088l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Context f44089m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f44090n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private com.mbridge.msdk.b.a f44091o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f44092p;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f44078a = 4;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f44079b = 5;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f44080c = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f44085i = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    Handler f44081d = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.foundation.controller.d.6
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            List list;
            List list2;
            try {
                int i11 = message.what;
                if (i11 == 2) {
                    Object obj = message.obj;
                    if (!(obj instanceof List) || (list = (List) obj) == null || list.size() <= 0) {
                        return;
                    }
                    o oVar = new o(d.this.f44089m, 0);
                    for (int i12 = 0; i12 < list.size(); i12++) {
                        l lVar = (l) list.get(i12);
                        Boolean bool = Boolean.FALSE;
                        if (i12 == list.size() - 1) {
                            bool = Boolean.TRUE;
                        }
                        oVar.a(lVar, bool);
                    }
                    return;
                }
                if (i11 == 7) {
                    Object obj2 = message.obj;
                    if (obj2 == null || !(obj2 instanceof List) || (list2 = (List) obj2) == null) {
                        return;
                    }
                    list2.size();
                    return;
                }
                if (i11 == 9) {
                    g gVar = (g) message.obj;
                    com.mbridge.msdk.foundation.tools.g gVarD = c.m().d();
                    if (gVarD != null && gVarD.b() && gVar != null && gVar.J() == 1) {
                        com.mbridge.msdk.foundation.same.report.b.d.a(d.this.f44089m).b();
                    }
                    if (gVarD == null || !gVarD.a()) {
                        return;
                    }
                    com.mbridge.msdk.foundation.same.report.b.c.a();
                    return;
                }
                if (i11 == 4) {
                    String str = (String) message.obj;
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    if (j.a().b()) {
                        j.a().a(str);
                        return;
                    } else {
                        new o(d.this.f44089m, 0).a("click_duration", str, null, null);
                        return;
                    }
                }
                if (i11 != 5) {
                    return;
                }
                String str2 = (String) message.obj;
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                if (j.a().b()) {
                    j.a().a(str2);
                } else {
                    new o(d.this.f44089m, 0).a("load_duration", str2, null, null);
                }
            } catch (Exception unused) {
                ad.b("SDKController", "REPORT HANDLE ERROR!");
            }
        }
    };

    private d() {
    }

    public static d a() {
        if (f44077e == null) {
            synchronized (d.class) {
                try {
                    if (f44077e == null) {
                        f44077e = new d();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f44077e;
    }

    public static /* synthetic */ void a(d dVar) {
        try {
            com.mbridge.msdk.d.b.class.getDeclaredMethod("start", new Class[0]).invoke(com.mbridge.msdk.d.b.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), new Object[0]);
        } catch (Throwable th2) {
            ad.a("SDKController", th2.getMessage(), th2);
        }
    }

    public static /* synthetic */ void a(d dVar, final String str) {
        if (h.a() == null) {
            return;
        }
        h hVarA = h.a();
        if (hVarA != null) {
            g gVarB = hVarA.b(str);
            if (gVarB != null) {
                MBridgeConstans.OMID_JS_SERVICE_URL = gVarB.W();
                MBridgeConstans.OMID_JS_H5_URL = gVarB.V();
                if (!TextUtils.isEmpty(gVarB.y())) {
                    com.mbridge.msdk.foundation.same.net.g.d.f().f44631h = gVarB.y();
                    com.mbridge.msdk.foundation.same.net.g.d.f().b();
                }
                if (!TextUtils.isEmpty(gVarB.z())) {
                    com.mbridge.msdk.foundation.same.net.g.d.f().f44635l = gVarB.z();
                    com.mbridge.msdk.foundation.same.net.g.d.f().c();
                }
            } else {
                MBridgeConstans.OMID_JS_SERVICE_URL = com.mbridge.msdk.c.a.b.f42896b;
                MBridgeConstans.OMID_JS_H5_URL = com.mbridge.msdk.c.a.b.f42895a;
            }
        }
        if (h.a().d(str) && h.a().a(str, 1, (String) null)) {
            if (com.mbridge.msdk.foundation.a.a.a.a().a("is_first_init", 0) != 0) {
                new com.mbridge.msdk.c.j().a(dVar.f44089m, str, dVar.f44087k);
                return;
            }
            try {
                com.mbridge.msdk.foundation.a.a.a.a().b("is_first_init", 1);
                if (TextUtils.isEmpty(com.mbridge.msdk.foundation.tools.e.c())) {
                    dVar.f44081d.postDelayed(new Runnable() { // from class: com.mbridge.msdk.foundation.controller.d.5
                        @Override // java.lang.Runnable
                        public final void run() {
                            new com.mbridge.msdk.c.j().a(d.this.f44089m, str, d.this.f44087k);
                        }
                    }, 350L);
                } else {
                    new com.mbridge.msdk.c.j().a(dVar.f44089m, str, dVar.f44087k);
                }
            } catch (Throwable unused) {
                new com.mbridge.msdk.c.j().a(dVar.f44089m, str, dVar.f44087k);
            }
        }
    }

    public static /* synthetic */ void b(d dVar) {
        List<com.mbridge.msdk.foundation.entity.a> listK;
        Object objNewInstance;
        Object objNewInstance2;
        try {
            g gVarB = h.a().b(c.m().k());
            if (gVarB == null || (listK = gVarB.k()) == null || listK.size() <= 0) {
                return;
            }
            for (com.mbridge.msdk.foundation.entity.a aVar : listK) {
                if (aVar.a() == 287) {
                    if (dVar.f44089m != null && (objNewInstance = MBInterstitialVideoHandler.class.getConstructor(String.class, String.class).newInstance("", aVar.b())) != null) {
                        MBInterstitialVideoHandler.class.getMethod("loadFormSelfFilling", new Class[0]).invoke(objNewInstance, new Object[0]);
                    }
                } else if (aVar.a() == 94 && (objNewInstance2 = MBRewardVideoHandler.class.getConstructor(String.class, String.class).newInstance("", aVar.b())) != null) {
                    MBRewardVideoHandler.class.getMethod("loadFormSelfFilling", new Class[0]).invoke(objNewInstance2, new Object[0]);
                }
            }
        } catch (Throwable th2) {
            if (MBridgeConstans.DEBUG) {
                th2.printStackTrace();
            }
        }
    }

    public final void a(Map<String, Object> map, int i11) {
        if (MBridgeSDKFactory.getMBridgeSDK().getStatus() != MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED) {
            ad.b("SDKController", "preloaad failed,sdk do not inited");
            return;
        }
        this.f44083g = map;
        this.f44082f = i11;
        c.m().k();
        if (map != null) {
            if (this.f44091o == null) {
                this.f44091o = new com.mbridge.msdk.b.a();
            }
            try {
                Map<String, Object> map2 = this.f44083g;
                if (map2 != null && map2.size() > 0 && this.f44083g.containsKey(MBridgeConstans.PROPERTIES_LAYOUT_TYPE)) {
                    int iIntValue = ((Integer) this.f44083g.get(MBridgeConstans.PROPERTIES_LAYOUT_TYPE)).intValue();
                    if (iIntValue == 0) {
                        Map<String, Object> map3 = this.f44083g;
                        int i12 = this.f44082f;
                        try {
                            com.mbridge.msdk.mbnative.f.a.class.getMethod("preload", Map.class, Integer.TYPE).invoke(com.mbridge.msdk.mbnative.f.a.class.newInstance(), map3, Integer.valueOf(i12));
                        } catch (Exception unused) {
                        }
                    } else if (1 != iIntValue && 2 != iIntValue) {
                        ad.b("SDKController", "unknow layout type in preload");
                    }
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public final void a(Map map, final Context context) {
        Object obj;
        String string;
        if (context != null) {
            if (!TextUtils.isEmpty(MBridgeConstans.DEVELOPER_CUSTOM_PACKAGE)) {
                c.m().f(MBridgeConstans.DEVELOPER_CUSTOM_PACKAGE);
            } else if (map.containsKey(MBridgeConstans.KEY_MBRIDGE_CUSTOM_PACKAGE_NAME) && (obj = map.get(MBridgeConstans.KEY_MBRIDGE_CUSTOM_PACKAGE_NAME)) != null) {
                String str = (String) obj;
                if (!TextUtils.isEmpty(str)) {
                    c.m().f(str);
                }
            }
            if (map != null) {
                if (map.containsKey(MBridgeConstans.ID_MBRIDGE_APPID)) {
                    this.f44086j = (String) map.get(MBridgeConstans.ID_MBRIDGE_APPID);
                }
                if (map.containsKey(MBridgeConstans.ID_MBRIDGE_APPKEY)) {
                    this.f44087k = (String) map.get(MBridgeConstans.ID_MBRIDGE_APPKEY);
                }
                if (map.containsKey(MBridgeConstans.ID_MBRIDGE_WX_APPID)) {
                    this.f44092p = (String) map.get(MBridgeConstans.ID_MBRIDGE_WX_APPID);
                }
                if (map.containsKey(MBridgeConstans.PACKAGE_NAME_MANIFEST)) {
                    this.f44088l = (String) map.get(MBridgeConstans.PACKAGE_NAME_MANIFEST);
                }
                if (map.containsKey(MBridgeConstans.ID_MBRIDGE_STARTUPCRASH)) {
                    this.f44090n = (String) map.get(MBridgeConstans.ID_MBRIDGE_STARTUPCRASH);
                }
            }
            this.f44089m = context.getApplicationContext();
            c.m().b(this.f44089m);
            c.m().d(this.f44086j);
            c.m().e(this.f44087k);
            c.m().a(this.f44092p);
            c.m().c(this.f44088l);
            c.m().a(new a.InterfaceC0484a() { // from class: com.mbridge.msdk.foundation.controller.d.4
            }, this.f44081d);
            try {
                com.mbridge.msdk.foundation.same.net.g.d.f().e();
            } catch (Throwable th2) {
                ad.b("SDKController", th2.getMessage());
            }
            try {
                n.a(this.f44089m);
            } catch (Exception e11) {
                ad.b("SDKController", e11.getMessage());
            }
            if (this.f44085i) {
                return;
            }
            ag.a(this.f44089m);
            Context applicationContext = this.f44089m.getApplicationContext();
            try {
                if (this.f44084h == null) {
                    try {
                        this.f44084h = new FastKV.Builder(com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), x.a("H+tU+FeXHM==")).build();
                    } catch (Exception unused) {
                        this.f44084h = null;
                    }
                }
                FastKV fastKV = this.f44084h;
                String string2 = "";
                if (fastKV != null) {
                    String string3 = fastKV.getString(x.a("H+tU+bfPhM=="), "");
                    String string4 = this.f44084h.getString(x.a("H+tU+Fz8"), "");
                    if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.U) && TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f44371g)) {
                        com.mbridge.msdk.foundation.same.a.U = com.mbridge.msdk.foundation.a.a.a.a().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
                        com.mbridge.msdk.foundation.same.a.f44371g = com.mbridge.msdk.foundation.a.a.a.a().a("c");
                    }
                    if (!TextUtils.isEmpty(string3) || !TextUtils.isEmpty(string4)) {
                        com.mbridge.msdk.foundation.same.a.U = string3;
                        com.mbridge.msdk.foundation.same.a.f44371g = string4;
                        com.mbridge.msdk.foundation.a.a.a.a().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.U);
                        com.mbridge.msdk.foundation.a.a.a.a().a("c", com.mbridge.msdk.foundation.same.a.f44371g);
                    } else if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.U) || !TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f44371g)) {
                        this.f44084h.putString(x.a("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.U);
                        this.f44084h.putString(x.a("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.f44371g);
                    }
                } else {
                    SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(x.a("H+tU+FeXHM=="), 0);
                    if (sharedPreferences != null) {
                        string2 = sharedPreferences.getString(x.a("H+tU+bfPhM=="), "");
                        string = sharedPreferences.getString(x.a("H+tU+Fz8"), "");
                    } else {
                        string = "";
                    }
                    if (TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.U) && TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f44371g)) {
                        com.mbridge.msdk.foundation.same.a.U = com.mbridge.msdk.foundation.a.a.a.a().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B);
                        com.mbridge.msdk.foundation.same.a.f44371g = com.mbridge.msdk.foundation.a.a.a.a().a("c");
                    }
                    if (!TextUtils.isEmpty(string2) || !TextUtils.isEmpty(string)) {
                        com.mbridge.msdk.foundation.same.a.U = string2;
                        com.mbridge.msdk.foundation.same.a.f44371g = string;
                        com.mbridge.msdk.foundation.a.a.a.a().a(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.U);
                        com.mbridge.msdk.foundation.a.a.a.a().a("c", com.mbridge.msdk.foundation.same.a.f44371g);
                    } else if ((!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.U) || !TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f44371g)) && sharedPreferences != null) {
                        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                        editorEdit.putString(x.a("H+tU+bfPhM=="), com.mbridge.msdk.foundation.same.a.U);
                        editorEdit.putString(x.a("H+tU+Fz8"), com.mbridge.msdk.foundation.same.a.f44371g);
                        editorEdit.apply();
                    }
                }
            } catch (Throwable th3) {
                ad.a("SDKController", th3.getMessage(), th3);
            }
            try {
                com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.controller.d.2
                    @Override // java.lang.Runnable
                    public final void run() {
                        Looper.prepare();
                        d.a(d.this);
                        d.b(d.this);
                        Looper.loop();
                    }
                });
                com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() { // from class: com.mbridge.msdk.foundation.controller.d.3
                    @Override // java.lang.Runnable
                    public final void run() {
                        d dVar = d.this;
                        d.a(dVar, dVar.f44086j);
                        if (!TextUtils.isEmpty(d.this.f44086j)) {
                            com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.SDK_APP_ID, d.this.f44086j);
                        }
                        new o(d.this.f44089m).a();
                        d.this.b();
                    }
                });
                q.c();
            } catch (Exception unused2) {
                ad.b("SDKController", "get app setting failed");
            }
            this.f44085i = true;
            z.f(context);
            long jAz = h.a().a(this.f44086j).az();
            if (jAz != 1300) {
                this.f44081d.postDelayed(new Runnable() { // from class: com.mbridge.msdk.foundation.controller.d.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        z.d(context);
                    }
                }, jAz);
            }
        }
    }

    public final void b() {
        if (this.f44089m == null || this.f44081d == null) {
            return;
        }
        try {
            int i11 = af.a().a("e_r_r_c_t_r_l", false) ? 5 : 1;
            com.mbridge.msdk.foundation.same.report.c.a.a();
            Context context = this.f44089m;
            String string = null;
            List<l> listA = (context != null && com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.h.a(context)).a() > 0) ? com.mbridge.msdk.foundation.db.n.a(com.mbridge.msdk.foundation.db.h.a(context)).a(i11) : null;
            if (listA != null && listA.size() > 0) {
                Message messageObtainMessage = this.f44081d.obtainMessage();
                messageObtainMessage.what = 2;
                messageObtainMessage.obj = listA;
                this.f44081d.sendMessage(messageObtainMessage);
            }
            com.mbridge.msdk.foundation.db.h hVarA = com.mbridge.msdk.foundation.db.h.a(this.f44089m);
            com.mbridge.msdk.foundation.db.e eVarA = com.mbridge.msdk.foundation.db.e.a(hVarA);
            if (eVarA.a() >= 20) {
                String strA = com.mbridge.msdk.foundation.entity.e.a(eVarA.a(20));
                Message messageObtain = Message.obtain();
                messageObtain.obj = strA;
                messageObtain.what = 4;
                this.f44081d.sendMessage(messageObtain);
            }
            com.mbridge.msdk.foundation.db.l lVarA = com.mbridge.msdk.foundation.db.l.a(hVarA);
            if (lVarA.a() > 20) {
                List<com.mbridge.msdk.foundation.entity.h> listA2 = lVarA.a(20);
                if (listA2 != null && listA2.size() > 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    for (com.mbridge.msdk.foundation.entity.h hVar : listA2) {
                        if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                            stringBuffer.append("ad_source_id=" + hVar.a());
                            stringBuffer.append("&time=" + hVar.b());
                            stringBuffer.append("&num=" + hVar.c());
                            stringBuffer.append("&unit_id=" + hVar.d());
                            stringBuffer.append("&key=2000006");
                            stringBuffer.append("&fb=" + hVar.e());
                            stringBuffer.append("&network_str=" + hVar.f());
                            stringBuffer.append("&network_type=" + hVar.g());
                        } else {
                            stringBuffer.append("ad_source_id=" + hVar.a());
                            stringBuffer.append("&time=" + hVar.b());
                            stringBuffer.append("&num=" + hVar.c());
                            stringBuffer.append("&unit_id=" + hVar.d());
                            stringBuffer.append("&key=2000006");
                            stringBuffer.append("&fb=" + hVar.e());
                        }
                        if (hVar.h() == 1) {
                            stringBuffer.append("&hb=1");
                        }
                        stringBuffer.append("&timeout=" + hVar.i() + "\n");
                    }
                    string = stringBuffer.toString();
                }
                Message messageObtain2 = Message.obtain();
                messageObtain2.obj = string;
                messageObtain2.what = 5;
                this.f44081d.sendMessage(messageObtain2);
            }
        } catch (Exception unused) {
            if (MBridgeConstans.DEBUG) {
                ad.b("SDKController", "report netstate error !");
            }
        }
    }

    public final void c() {
        Handler handler = this.f44081d;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }
}
