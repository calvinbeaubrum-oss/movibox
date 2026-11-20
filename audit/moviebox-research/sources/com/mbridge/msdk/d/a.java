package com.mbridge.msdk.d;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.o;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.i;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.ai;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f43220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f43221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LinkedList<i> f43222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private LinkedList<i> f43223d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f43224e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f43225f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private f f43226g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.mbridge.msdk.videocommon.d.a f43227h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private o f43228i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private h f43229j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Handler f43230k;

    /* JADX INFO: renamed from: com.mbridge.msdk.d.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static class C0478a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static a f43234a = new a();
    }

    private a() {
        this.f43221b = false;
        this.f43222c = new LinkedList<>();
        this.f43223d = new LinkedList<>();
        this.f43224e = 0;
        this.f43225f = 0;
        this.f43230k = new Handler() { // from class: com.mbridge.msdk.d.a.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                synchronized (a.this) {
                    try {
                        int i11 = message.what;
                        if (i11 != 1) {
                            if (i11 == 2) {
                                a.c(a.this);
                            }
                        } else {
                            if (a.this.f43221b) {
                                return;
                            }
                            a aVar = a.this;
                            a.a(aVar, aVar.f43220a);
                            sendMessageDelayed(obtainMessage(1), a.this.f43220a);
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
            }
        };
    }

    public static /* synthetic */ void a(a aVar, long j11) {
        LinkedList<i> linkedList = aVar.f43222c;
        if (linkedList == null || linkedList.size() <= 0 || aVar.f43224e == 0 || aVar.f43222c.size() <= aVar.f43224e) {
            LinkedList<i> linkedList2 = aVar.f43223d;
            if (linkedList2 == null || linkedList2.size() <= 0 || aVar.f43225f == 0 || aVar.f43223d.size() == aVar.f43225f) {
                aVar.f43225f = 0;
                aVar.f43224e = 0;
                Handler handler = aVar.f43230k;
                handler.sendMessage(handler.obtainMessage(2));
            }
        }
    }

    private void a(String str, String str2, boolean z11) {
        try {
            Context contextC = c.m().c();
            if (contextC == null) {
                return;
            }
            final com.mbridge.msdk.reward.adapter.c cVar = new com.mbridge.msdk.reward.adapter.c(contextC, str, str2);
            cVar.b(z11);
            cVar.a(new com.mbridge.msdk.reward.adapter.a() { // from class: com.mbridge.msdk.d.a.2
                @Override // com.mbridge.msdk.reward.adapter.a
                public final void a(String str3, com.mbridge.msdk.foundation.same.report.d.b bVar) {
                    a.this.f43230k.sendMessage(a.this.f43230k.obtainMessage(2));
                    cVar.a((com.mbridge.msdk.reward.adapter.a) null);
                }

                @Override // com.mbridge.msdk.reward.adapter.a
                public final void a(List<CampaignEx> list, com.mbridge.msdk.foundation.c.b bVar, com.mbridge.msdk.foundation.same.report.d.b bVar2) {
                    a.this.f43230k.sendMessage(a.this.f43230k.obtainMessage(2));
                    cVar.a((com.mbridge.msdk.reward.adapter.a) null);
                }

                @Override // com.mbridge.msdk.reward.adapter.a
                public final void a(List<CampaignEx> list, com.mbridge.msdk.foundation.same.report.d.b bVar) {
                }
            });
            com.mbridge.msdk.foundation.same.report.d.b bVar = new com.mbridge.msdk.foundation.same.report.d.b();
            bVar.c(SameMD5.getMD5(ai.d()));
            bVar.d(str2);
            if (z11) {
                bVar.b(287);
            } else {
                bVar.b(94);
            }
            bVar.i("0");
            bVar.b("1");
            cVar.a(1, 8000, false, bVar);
        } catch (Exception e11) {
            ad.a("LoopTimer", e11.getMessage(), e11);
        }
    }

    private boolean a(i iVar) {
        boolean z11 = false;
        if (iVar == null || TextUtils.isEmpty(iVar.b())) {
            return false;
        }
        String strB = iVar.b();
        try {
            if (this.f43226g != null) {
                com.mbridge.msdk.videocommon.d.a aVar = this.f43227h;
                int iA = this.f43226g.a(strB, aVar != null ? aVar.f() : 0L);
                if (iA != -1) {
                    if (iA != 1) {
                    }
                } else if (!TextUtils.isEmpty(strB)) {
                    LinkedList<i> linkedList = this.f43222c;
                    if (linkedList == null || !linkedList.contains(strB)) {
                        LinkedList<i> linkedList2 = this.f43223d;
                        if (linkedList2 != null && linkedList2.contains(strB)) {
                            this.f43223d.remove(strB);
                        }
                    } else {
                        this.f43222c.remove(strB);
                    }
                    o oVar = this.f43228i;
                    if (oVar != null) {
                        oVar.a(strB);
                    }
                }
                try {
                    Handler handler = this.f43230k;
                    handler.sendMessage(handler.obtainMessage(2));
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    ad.a("LoopTimer", th.getMessage(), th);
                    return z11;
                }
            }
            return true;
        } catch (Throwable th3) {
            th = th3;
            z11 = true;
        }
    }

    public static /* synthetic */ void c(a aVar) {
        try {
            LinkedList<i> linkedList = aVar.f43222c;
            if (linkedList == null || linkedList.size() <= 0 || aVar.f43224e >= aVar.f43222c.size()) {
                LinkedList<i> linkedList2 = aVar.f43223d;
                if (linkedList2 != null && linkedList2.size() > 0 && aVar.f43225f < aVar.f43223d.size()) {
                    i iVar = aVar.f43223d.get(aVar.f43225f);
                    aVar.f43225f++;
                    if (aVar.a(iVar)) {
                        aVar.a(iVar.a(), iVar.b(), true);
                    }
                }
            } else {
                i iVar2 = aVar.f43222c.get(aVar.f43224e);
                aVar.f43224e++;
                if (aVar.a(iVar2)) {
                    aVar.a(iVar2.a(), iVar2.b(), false);
                }
            }
        } catch (Throwable th2) {
            ad.a("LoopTimer", th2.getMessage(), th2);
        }
    }

    public final void a(long j11) {
        if (this.f43229j == null) {
            this.f43229j = h.a(c.m().c());
        }
        if (this.f43228i == null) {
            this.f43228i = o.a(this.f43229j);
        }
        List<i> listA = this.f43228i.a(287);
        if (listA != null) {
            this.f43223d.addAll(listA);
            for (i iVar : listA) {
                b(iVar.a(), iVar.b());
            }
        }
        List<i> listA2 = this.f43228i.a(94);
        if (listA2 != null) {
            this.f43222c.addAll(listA2);
            for (i iVar2 : listA2) {
                a(iVar2.a(), iVar2.b());
            }
        }
        if (this.f43226g == null) {
            this.f43226g = f.a(this.f43229j);
        }
        if (this.f43227h == null) {
            this.f43227h = com.mbridge.msdk.videocommon.d.b.a().b();
        }
        this.f43220a = j11;
        this.f43221b = false;
        Handler handler = this.f43230k;
        handler.sendMessageDelayed(handler.obtainMessage(1), this.f43220a);
    }

    public final void a(String str, String str2) {
        if (this.f43222c.contains(str2)) {
            return;
        }
        this.f43222c.add(new i(str, str2, 94));
        o oVar = this.f43228i;
        if (oVar != null) {
            oVar.a(str, str2, 94);
        }
    }

    public final void b(String str, String str2) {
        if (this.f43223d.contains(str2)) {
            return;
        }
        this.f43223d.add(new i(str, str2, 287));
        o oVar = this.f43228i;
        if (oVar != null) {
            oVar.a(str, str2, 287);
        }
    }
}
