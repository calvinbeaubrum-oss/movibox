package com.mbridge.msdk.click.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.db.n;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.l;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.report.j;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ao;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f43066a = "mtg_retry_report=1";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f43067b = 10000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f43068c = 3;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f43069d = 50;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f43070e = 600000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static int f43071f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static int f43072g = 1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static int f43073h = 2;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f43074i = 3;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static int f43075j = 4;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int f43076k = 5;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static String f43077l = "RetryReportControl";

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private static int f43078o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private static int f43079p;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ConcurrentHashMap<String, com.mbridge.msdk.click.a.b> f43080m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private c f43081n;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private BroadcastReceiver f43082q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Handler f43083r;

    /* JADX INFO: renamed from: com.mbridge.msdk.click.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0477a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static a f43087a = new a();
    }

    /* JADX INFO: compiled from: source.java */
    public static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            int i11 = message.what;
            if (i11 != 1) {
                if (i11 != 2) {
                    return;
                }
                a.a(a.a());
            } else {
                Object obj = message.obj;
                if (obj instanceof String) {
                    a.a().a((String) obj, com.mbridge.msdk.click.a.b.f43088a);
                }
            }
        }
    }

    private a() {
        this.f43080m = new ConcurrentHashMap<>();
        this.f43081n = new c(f43069d);
        this.f43083r = new b(Looper.getMainLooper());
        g gVarA = h.a().a(com.mbridge.msdk.foundation.controller.c.m().k());
        f43068c = gVarA.af();
        f43067b = gVarA.ah() * 1000;
        f43070e = gVarA.ai() * 1000;
        f43078o = gVarA.ae();
        f43079p = gVarA.ag();
        try {
            if (this.f43082q == null) {
                this.f43082q = new BroadcastReceiver() { // from class: com.mbridge.msdk.click.a.a.2
                    @Override // android.content.BroadcastReceiver
                    public final void onReceive(Context context, Intent intent) {
                        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction())) {
                            a.this.f43083r.sendEmptyMessage(2);
                        }
                    }
                };
                Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
                if (contextC != null) {
                    contextC.registerReceiver(this.f43082q, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static a a() {
        return C0477a.f43087a;
    }

    private static void a(final Context context, final String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            new com.mbridge.msdk.foundation.same.report.e.a(context).post(0, d.f().f44626c, q.a(str, context), new com.mbridge.msdk.foundation.same.report.e.b() { // from class: com.mbridge.msdk.click.a.a.1
                @Override // com.mbridge.msdk.foundation.same.report.e.b
                public final void onFailed(String str2) {
                    l lVar = new l();
                    lVar.a(str);
                    lVar.a(System.currentTimeMillis());
                    lVar.a(0);
                    lVar.b("POST");
                    lVar.c(d.f().f44626c);
                    n.a(com.mbridge.msdk.foundation.db.h.a(context)).a(lVar);
                }

                @Override // com.mbridge.msdk.foundation.same.report.e.b
                public final void onSuccess(String str2) {
                    ad.b(a.f43077l, str2);
                }
            });
        } catch (Exception e11) {
            e11.printStackTrace();
            ad.b(f43077l, e11.getMessage());
        }
    }

    private static void a(Context context, String str, String str2, String str3, String str4, int i11) {
        if (af.a().a("metrics", "e_t_l", af.a().a("e_t_l", 1)) == 1) {
            com.mbridge.msdk.foundation.same.report.l.a().a(context, str, str2, str3, str4, i11);
            return;
        }
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("key=2000105&");
                stringBuffer.append("url=" + URLEncoder.encode(str2, "utf-8") + "&");
                stringBuffer.append("type=" + i11 + "&");
                if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.U)) {
                    stringBuffer.append("b=" + com.mbridge.msdk.foundation.same.a.U + "&");
                }
                if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f44371g)) {
                    stringBuffer.append("c=" + com.mbridge.msdk.foundation.same.a.f44371g + "&");
                }
                if (!TextUtils.isEmpty(str3)) {
                    stringBuffer.append("rid=");
                    stringBuffer.append(str3);
                    stringBuffer.append("&");
                }
                if (!TextUtils.isEmpty(str3)) {
                    stringBuffer.append("rid_n=");
                    stringBuffer.append(str4);
                    stringBuffer.append("&");
                }
                stringBuffer.append("reason=" + URLEncoder.encode(str, "utf-8"));
                if (j.a().b()) {
                    j.a().a(stringBuffer.toString());
                } else {
                    a(context, stringBuffer.toString());
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static /* synthetic */ void a(a aVar) {
        c cVar = aVar.f43081n;
        if (cVar != null) {
            Iterator<String> it = cVar.a().iterator();
            while (it.hasNext()) {
                aVar.a(it.next(), com.mbridge.msdk.click.a.b.f43089b);
            }
        }
    }

    private void a(com.mbridge.msdk.click.a.b bVar) {
        String str;
        String requestIdNotice;
        try {
            CampaignEx campaignExF = bVar.f();
            if (campaignExF != null) {
                String requestId = campaignExF.getRequestId();
                requestIdNotice = campaignExF.getRequestIdNotice();
                str = requestId;
            } else {
                str = "";
                requestIdNotice = str;
            }
            a(com.mbridge.msdk.foundation.controller.c.m().c(), bVar.i().toString(), bVar.g(), str, requestIdNotice, bVar.d());
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private void a(String str) {
        Message messageObtainMessage = this.f43083r.obtainMessage();
        messageObtainMessage.what = 1;
        messageObtainMessage.obj = str;
        this.f43083r.sendMessageDelayed(messageObtainMessage, f43067b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i11) {
        String str2;
        c cVar = this.f43081n;
        if (cVar != null) {
            com.mbridge.msdk.click.a.b bVarB = cVar.b(str);
            this.f43081n.a(str);
            if (bVarB == null) {
                com.mbridge.msdk.click.a.b bVar = this.f43080m.get(str);
                if (bVar == null || System.currentTimeMillis() > bVar.j() + ((long) f43070e) || bVar.h() >= f43068c || i11 == com.mbridge.msdk.click.a.b.f43089b) {
                    return;
                }
                a(str);
                return;
            }
            if (System.currentTimeMillis() > bVarB.j() + ((long) f43070e)) {
                if (i11 != com.mbridge.msdk.click.a.b.f43089b) {
                    a(bVarB);
                    return;
                }
                return;
            }
            bVarB.a(i11);
            this.f43080m.put(str, bVarB);
            if (ao.c(str) == 0) {
                str2 = str + "?" + f43066a;
            } else {
                str2 = str + "&" + f43066a;
            }
            com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.controller.c.m().c(), bVarB.f(), bVarB.e(), str2, bVarB.a(), bVarB.b(), bVarB.d());
        }
    }

    private boolean a(int i11) {
        return i11 == f43075j || i11 == f43074i;
    }

    private boolean b(int i11) {
        return i11 == f43072g || i11 == f43073h;
    }

    public final void a(String str, String str2, CampaignEx campaignEx, String str3, boolean z11, boolean z12, int i11) {
        if ((a(i11) || b(i11) || i11 == f43076k) && !TextUtils.isEmpty(str)) {
            String strReplace = str.replace("?" + f43066a, "").replace("&" + f43066a, "");
            if (this.f43080m == null) {
                this.f43080m = new ConcurrentHashMap<>();
            }
            com.mbridge.msdk.click.a.b bVarRemove = this.f43080m.remove(strReplace);
            if (bVarRemove == null) {
                bVarRemove = new com.mbridge.msdk.click.a.b(str, str2);
                bVarRemove.b(i11);
                bVarRemove.a(z11);
                bVarRemove.b(z12);
                bVarRemove.a(campaignEx);
                bVarRemove.a(str3);
            } else if (bVarRemove.c() != com.mbridge.msdk.click.a.b.f43089b) {
                bVarRemove.b(str2);
            }
            if ((!a(i11) || f43078o == 0) && ((!b(i11) || f43079p == 0) && i11 != f43076k)) {
                a(bVarRemove);
                return;
            }
            if (System.currentTimeMillis() >= bVarRemove.j() + ((long) f43070e)) {
                if (bVarRemove.c() == com.mbridge.msdk.click.a.b.f43088a) {
                    a(bVarRemove);
                    return;
                }
                return;
            }
            if (this.f43081n == null) {
                this.f43081n = new c(f43069d);
            }
            this.f43081n.a(strReplace, bVarRemove);
            if (bVarRemove.c() == com.mbridge.msdk.click.a.b.f43088a) {
                if (bVarRemove.h() <= f43068c) {
                    a(strReplace);
                } else {
                    a(bVarRemove);
                }
            }
        }
    }
}
