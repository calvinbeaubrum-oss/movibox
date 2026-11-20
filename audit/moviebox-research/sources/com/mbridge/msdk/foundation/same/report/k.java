package com.mbridge.msdk.foundation.same.report;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.e.w;
import com.mbridge.msdk.foundation.db.BatchReportDao;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.al;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f44864a = "k";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static String f44865b = "roas";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile k f44866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AtomicInteger f44867d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private BatchReportDao f44868e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f44869f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f44870g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f44871h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile int f44872i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f44873j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Executor f44874k = Executors.newSingleThreadExecutor();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private Handler f44875l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private Stack<Long> f44876m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private com.mbridge.msdk.e.m f44877n;

    private k() {
        com.mbridge.msdk.c.a aVarN;
        this.f44869f = 1;
        this.f44870g = 0L;
        this.f44871h = com.mbridge.msdk.foundation.same.net.g.d.f().F;
        this.f44872i = 0;
        this.f44873j = false;
        com.mbridge.msdk.c.g gVarB = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
        if (gVarB != null && (aVarN = gVarB.n()) != null) {
            this.f44869f = aVarN.a();
            this.f44870g = ((long) aVarN.c()) * 1000;
            this.f44871h = com.mbridge.msdk.foundation.same.net.g.d.f().F;
            this.f44872i = aVarN.b();
            boolean z11 = aVarN.d() == 1;
            this.f44873j = z11;
            if (z11 && this.f44872i != 1) {
                int iA = af.a().a("bcp", "type", af.a().a("t_r_t", 1));
                if (iA != 0 && iA != 1) {
                    iA = 0;
                }
                this.f44877n = com.mbridge.msdk.e.m.a(f44865b, com.mbridge.msdk.foundation.controller.c.m().c(), new w.a().a(new h()).a(new u()).a(iA, iA == 1 ? new com.mbridge.msdk.e.o(new t((byte) 2), com.mbridge.msdk.foundation.same.net.g.d.f().f44634k, com.mbridge.msdk.foundation.same.net.g.d.f().f44638o) : new com.mbridge.msdk.e.o(new com.mbridge.msdk.e.a.a.g(), com.mbridge.msdk.foundation.same.net.g.d.f().F, 0)).e(af.a().a("t_m_e_t", 604800000)).a(af.a().a("t_m_e_s", 50)).d(af.a().a("t_m_r_c", 50)).b(af.a().a("t_m_t", DefaultLoadControl.DEFAULT_MIN_BUFFER_MS)).c(af.a().a("t_m_r_t_s", 2)).a());
                JSONObject jSONObjectA = g.a();
                try {
                    jSONObjectA.put("device_type", z.v(com.mbridge.msdk.foundation.controller.c.m().c()) ? "pad" : "phone");
                    if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_OTHER)) {
                        jSONObjectA.put(com.mbridge.msdk.foundation.same.net.h.e.f44662g, z.n());
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                this.f44877n.a(jSONObjectA);
                this.f44877n.a();
            }
        }
        ad.a(f44864a, "初始化批量上报： " + this.f44871h + " " + this.f44869f + " " + this.f44870g + " " + this.f44872i);
        this.f44867d = new AtomicInteger(0);
        this.f44876m = new Stack<>();
        this.f44868e = BatchReportDao.getInstance(com.mbridge.msdk.foundation.controller.c.m().c());
        HandlerThread handlerThread = new HandlerThread("mb_revenue_batch_report_thread");
        handlerThread.start();
        this.f44875l = new Handler(handlerThread.getLooper()) { // from class: com.mbridge.msdk.foundation.same.report.k.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                int i11 = message.what;
                if (i11 == 1) {
                    Bundle data = message.getData();
                    if (k.this.f44875l == null || k.this.f44868e == null || data == null) {
                        return;
                    }
                    k.this.f44875l.removeMessages(2);
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    ArrayList<BatchReportMessage> batchReportMessages = k.this.f44868e.getBatchReportMessages(jCurrentTimeMillis, 2);
                    k.a(k.this, batchReportMessages, jCurrentTimeMillis);
                    k.this.f44867d.set(0);
                    String str = k.f44864a;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("超时上报触发了，需要上报的数据： ");
                    sb2.append(batchReportMessages != null ? batchReportMessages.size() : 0);
                    ad.a(str, sb2.toString());
                    return;
                }
                if (i11 == 2) {
                    Bundle data2 = message.getData();
                    if (k.this.f44875l == null || k.this.f44868e == null || data2 == null) {
                        return;
                    }
                    k.this.f44875l.removeMessages(1);
                    long j11 = data2.getLong("last_report_time");
                    ArrayList<BatchReportMessage> batchReportMessages2 = k.this.f44868e.getBatchReportMessages(j11, 2);
                    k.a(k.this, batchReportMessages2, j11);
                    String str2 = k.f44864a;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("队列上报触发了，需要上报的数据： ");
                    sb3.append(batchReportMessages2 != null ? batchReportMessages2.size() : 0);
                    ad.a(str2, sb3.toString());
                    return;
                }
                if (i11 == 3) {
                    Bundle data3 = message.getData();
                    if (data3 != null) {
                        k.b(k.this, data3.getParcelableArrayList("report_message"), data3.getLong("last_report_time"));
                        return;
                    }
                    return;
                }
                if (i11 != 4) {
                    return;
                }
                Bundle data4 = message.getData();
                if (k.this.f44875l == null || k.this.f44868e == null || data4 == null || !k.this.f44873j) {
                    return;
                }
                k.this.f44875l.removeMessages(4);
                ArrayList<BatchReportMessage> batchReportMessages3 = k.this.f44868e.getBatchReportMessages(System.currentTimeMillis(), 2);
                if (batchReportMessages3 != null && batchReportMessages3.size() > 0) {
                    for (int i12 = 0; i12 < batchReportMessages3.size(); i12++) {
                        BatchReportMessage batchReportMessage = batchReportMessages3.get(i12);
                        k.a(k.this, batchReportMessage.getReportMessage(), batchReportMessage.getTimestamp());
                    }
                }
                String str3 = k.f44864a;
                StringBuilder sb4 = new StringBuilder();
                sb4.append("切换上报lib，需要上报的数据： ");
                sb4.append(batchReportMessages3 != null ? batchReportMessages3.size() : 0);
                ad.a(str3, sb4.toString());
            }
        };
    }

    public static synchronized k a() {
        try {
            if (f44866c == null) {
                f44866c = new k();
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f44866c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i11, String str) {
        HashMap map = new HashMap();
        map.put("state", i11 + "");
        if (i11 == 2) {
            map.put("reason", str);
        }
        l.a().a("m_ad_rev_s_s", "roas", "", "", map);
    }

    public static /* synthetic */ void a(k kVar, String str) {
        kVar.f44868e.addReportMessage(str, 2);
        Handler handler = kVar.f44875l;
        if (handler != null && !handler.hasMessages(1)) {
            Message messageObtain = Message.obtain();
            messageObtain.what = 1;
            kVar.f44875l.sendMessageDelayed(messageObtain, kVar.f44870g);
        }
        if (kVar.f44867d.incrementAndGet() < kVar.f44869f || kVar.f44875l == null) {
            return;
        }
        Message messageObtain2 = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putLong("last_report_time", System.currentTimeMillis());
        messageObtain2.setData(bundle);
        messageObtain2.what = 2;
        kVar.f44875l.sendMessage(messageObtain2);
        kVar.f44867d.set(0);
    }

    public static /* synthetic */ void a(k kVar, String str, long j11) {
        if (kVar.f44877n != null) {
            com.mbridge.msdk.e.e eVar = new com.mbridge.msdk.e.e("roas");
            eVar.a(true);
            if (j11 != 0) {
                eVar.a(j11);
            }
            eVar.b(1);
            try {
                eVar.a(kVar.b(str));
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            kVar.f44877n.a(eVar);
        }
    }

    public static /* synthetic */ void a(k kVar, ArrayList arrayList, long j11) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        Message messageObtain = Message.obtain();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("report_message", arrayList);
        bundle.putLong("last_report_time", j11);
        messageObtain.setData(bundle);
        messageObtain.what = 3;
        kVar.f44875l.sendMessage(messageObtain);
    }

    private JSONObject b(String str) {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            return jSONObject;
        }
        try {
            for (String str2 : str.split("&")) {
                String[] strArrSplit = str2.split("=");
                if (strArrSplit.length == 2) {
                    jSONObject.put(strArrSplit[0], strArrSplit[1]);
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }

    public static /* synthetic */ void b(k kVar, final ArrayList arrayList, final long j11) {
        if (arrayList == null || arrayList.size() <= 0) {
            ad.a(f44864a, "需要上报的数据条数： 0");
            return;
        }
        ad.a(f44864a, "需要上报的数据条数： " + arrayList.size());
        Context contextC = com.mbridge.msdk.foundation.controller.c.m().c();
        if (contextC == null) {
            return;
        }
        com.mbridge.msdk.foundation.same.net.h.e eVarA = q.a(contextC);
        eVarA.a("app_id", com.mbridge.msdk.foundation.controller.c.m().k());
        eVarA.a("m_sdk", "msdk");
        eVarA.a("lqswt", String.valueOf(1));
        eVarA.a("device_type", z.v(contextC) ? "pad" : "phone");
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.c.j().c(MBridgeConstans.AUTHORITY_OTHER)) {
            eVarA.a(com.mbridge.msdk.foundation.same.net.h.e.f44662g, z.n());
        }
        StringBuilder sb2 = new StringBuilder();
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            try {
                BatchReportMessage batchReportMessage = (BatchReportMessage) arrayList.get(i11);
                if (batchReportMessage != null) {
                    sb2.append(batchReportMessage.getReportMessage() + "&ts=" + batchReportMessage.getTimestamp());
                    if (i11 >= 0 && i11 < size - 1) {
                        sb2.append("\n");
                    }
                }
            } catch (Throwable th2) {
                ad.b(f44864a, th2.getMessage());
            }
        }
        try {
            String strEncode = URLEncoder.encode(sb2.toString(), "utf-8");
            eVarA.a("data", strEncode);
            ad.a(f44864a, "需要批量上报的数据： " + strEncode);
            com.mbridge.msdk.foundation.same.report.e.a aVar = new com.mbridge.msdk.foundation.same.report.e.a(com.mbridge.msdk.foundation.controller.c.m().c());
            kVar.a(0, "");
            aVar.post(0, kVar.f44871h, eVarA, new com.mbridge.msdk.foundation.same.report.e.b() { // from class: com.mbridge.msdk.foundation.same.report.k.2
                @Override // com.mbridge.msdk.foundation.same.report.e.b
                public final void onFailed(String str) {
                    Stack stack;
                    ad.a(k.f44864a, "批量上报失败： " + str);
                    k.this.a(2, str);
                    synchronized (k.this.f44876m) {
                        try {
                            k.this.f44876m.add(Long.valueOf(j11));
                            if (k.this.f44868e != null) {
                                k.this.f44868e.updateMessagesReportState(arrayList);
                            }
                            if (k.this.f44876m.size() >= 5) {
                                ad.a(k.f44864a, "批量上报失败，上报失败的数据超过阈值");
                                try {
                                    try {
                                        k.this.f44876m.pop();
                                        long jLongValue = ((Long) k.this.f44876m.pop()).longValue();
                                        k.this.f44876m.clear();
                                        if (k.this.f44868e != null) {
                                            k.this.f44868e.deleteBatchReportMessagesByTimestamp(jLongValue);
                                        }
                                        stack = k.this.f44876m;
                                    } catch (Throwable th3) {
                                        k.this.f44876m.clear();
                                        throw th3;
                                    }
                                } catch (Exception e11) {
                                    ad.b(k.f44864a, e11.getMessage());
                                    stack = k.this.f44876m;
                                }
                                stack.clear();
                            }
                        } catch (Throwable th4) {
                            throw th4;
                        }
                    }
                }

                @Override // com.mbridge.msdk.foundation.same.report.e.b
                public final void onSuccess(String str) {
                    ad.a(k.f44864a, "批量上报成功");
                    k.this.a(1, "");
                    try {
                        if (k.this.f44868e != null) {
                            k.this.f44868e.deleteBatchReportMessagesByTimestamp(j11);
                        }
                    } catch (Exception e11) {
                        ad.b(k.f44864a, e11.getMessage());
                    }
                    synchronized (k.this.f44876m) {
                        k.this.f44876m.clear();
                    }
                }
            });
        } catch (Exception e11) {
            ad.b(f44864a, e11.getMessage());
        }
    }

    public final synchronized void a(final String str) {
        try {
            if (this.f44872i == 1) {
                return;
            }
            Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.foundation.same.report.k.3
                @Override // java.lang.Runnable
                public final void run() {
                    if (k.this.f44868e == null) {
                        return;
                    }
                    ad.a(k.f44864a, "接收到上报数据： " + str);
                    if (!k.this.f44873j) {
                        if (k.this.f44872i != 1) {
                            k.a(k.this, str);
                        }
                    } else {
                        k.a(k.this, str, 0L);
                        if (((Integer) al.a(com.mbridge.msdk.foundation.controller.c.m().c(), "roas_use_event", 0)).intValue() == 0) {
                            al.b(com.mbridge.msdk.foundation.controller.c.m().c(), "roas_use_event", 1);
                            k.this.f44875l.sendEmptyMessage(4);
                        }
                    }
                }
            };
            com.mbridge.msdk.foundation.controller.d.a();
            Executor executor = this.f44874k;
            if (executor != null) {
                executor.execute(runnable);
            } else {
                runnable.run();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void b() {
        Handler handler = this.f44875l;
        if (handler == null || handler.hasMessages(1) || this.f44872i == 1 || this.f44873j) {
            return;
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        this.f44875l.sendMessageDelayed(messageObtain, 5000L);
    }
}
