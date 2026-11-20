package com.mbridge.msdk.newreward.a;

import android.os.SystemClock;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.hisavana.common.tracking.TrackingKey;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newout.RewardVideoListener;
import com.mbridge.msdk.newreward.function.common.MBridgeCommon;
import com.mbridge.msdk.newreward.function.common.MBridgeDailyPlayModel;
import com.mbridge.msdk.newreward.function.common.MBridgeSharedPreferenceModel;
import com.mbridge.msdk.out.MBridgeIds;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Deque<e> f46077a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private RewardVideoListener f46079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.f.e f46080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.mbridge.msdk.newreward.function.c.c f46081e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MBridgeIds f46082f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map f46083g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private com.mbridge.msdk.newreward.b.b f46084h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f46078b = new Object();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f46085i = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f46086j = 1;

    public d() {
        if (this.f46077a == null) {
            this.f46077a = new ConcurrentLinkedDeque();
        }
    }

    private int a(int i11) {
        int i12 = 0;
        if (this.f46077a.size() == 0) {
            return 0;
        }
        for (e eVar : this.f46077a) {
            if (i11 != 1) {
                if (i11 == 2 && eVar.v().c()) {
                    i12++;
                }
            } else if (eVar.q() == 1) {
                i12++;
            }
        }
        return i12;
    }

    private void a(e eVar, com.mbridge.msdk.foundation.c.b bVar) {
        eVar.b(2);
        eVar.c(true);
        com.mbridge.msdk.newreward.function.c.c cVar = this.f46081e;
        cVar.a(eVar, com.mbridge.msdk.newreward.function.c.e.REPORT_LOAD_FAILED, cVar.a("metrics_data", bVar));
    }

    private void a(e eVar, com.mbridge.msdk.newreward.function.c.e eVar2) {
        if (eVar == null) {
            return;
        }
        List<CampaignEx> listA = eVar.v() != null ? eVar.v().a() : null;
        try {
            com.mbridge.msdk.newreward.function.c.c cVar = this.f46081e;
            Object[] objArr = new Object[6];
            objArr[0] = "metrics_data";
            objArr[1] = listA;
            int i11 = 2;
            objArr[2] = "auto_load";
            if (!eVar.z()) {
                i11 = 1;
            }
            objArr[3] = Integer.valueOf(i11);
            objArr[4] = "cache";
            objArr[5] = 1;
            cVar.a(eVar, eVar2, cVar.a(objArr));
        } catch (Exception e11) {
            if (MBridgeConstans.DEBUG) {
                e11.printStackTrace();
            }
        }
    }

    private void a(String str) {
        com.mbridge.msdk.newreward.b.b bVar = this.f46084h;
        if (bVar == null) {
            return;
        }
        com.mbridge.msdk.newreward.function.c.c cVar = this.f46081e;
        cVar.a(bVar, com.mbridge.msdk.newreward.function.c.e.REPORT_SHOW_FAIL, cVar.a("reason", str));
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0039  */
    private boolean b(e eVar) {
        long jM;
        boolean z11 = false;
        z11 = false;
        z11 = false;
        try {
            Deque<e> deque = this.f46077a;
            if (deque == null || deque.peek() == null) {
                jM = 0;
            } else {
                String strO = this.f46077a.peek().o();
                if (TextUtils.isEmpty(strO) || !strO.equals("-1")) {
                    jM = 0;
                } else {
                    jM = this.f46077a.peek().m();
                }
            }
            com.mbridge.msdk.newreward.function.c.c cVar = this.f46081e;
            Map map = (Map) cVar.b(cVar.a("adapter_model", eVar, "last_response_empty_time", Long.valueOf(jM)), com.mbridge.msdk.newreward.function.c.e.CHECK_IS_REQUEST_CONTROL);
            if (map != null && map.size() > 0) {
                try {
                    this.f46079c.onVideoLoadFail(new MBridgeIds(), (String) map.get(NotificationCompat.CATEGORY_MESSAGE));
                    int i11 = TextUtils.isEmpty((CharSequence) map.get(TrackingKey.ERROR_CODE)) ? 0 : Integer.parseInt((String) map.get(TrackingKey.ERROR_CODE));
                    a(eVar, com.mbridge.msdk.foundation.c.a.a(i11, i11 == -1 ? 880018 : 880002, (String) map.get(NotificationCompat.CATEGORY_MESSAGE)));
                    z11 = true;
                } catch (Exception e11) {
                    e = e11;
                    z11 = true;
                    if (MBridgeConstans.DEBUG) {
                        e.printStackTrace();
                    }
                }
            }
            if (z11) {
                com.mbridge.msdk.foundation.same.report.d.c.a().c(eVar.x());
            }
        } catch (Exception e12) {
            e = e12;
        }
        return z11;
    }

    @Override // com.mbridge.msdk.newreward.a.c
    public final List<e> a() {
        ArrayList arrayList = new ArrayList();
        Deque<e> deque = this.f46077a;
        if (deque != null && deque.size() != 0) {
            Iterator<e> it = this.f46077a.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next());
            }
        }
        return arrayList;
    }

    public final void a(e eVar) {
        Deque<e> deque;
        if (eVar == null || (deque = this.f46077a) == null) {
            return;
        }
        deque.addFirst(eVar);
    }

    /* JADX WARN: Code duplicated, block: B:109:0x01a5 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:110:0x0174 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:113:0x015e A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:36:0x00fc A[Catch: all -> 0x0053, TryCatch #1 {all -> 0x0053, blocks: (B:16:0x004b, B:18:0x0051, B:22:0x0056, B:61:0x01a5, B:62:0x01ab, B:64:0x01b1, B:66:0x01c1, B:68:0x01c7, B:70:0x01d8, B:72:0x01f2, B:74:0x01f8, B:75:0x01fc, B:77:0x0202, B:83:0x0218, B:85:0x0220, B:86:0x0226, B:87:0x0237, B:80:0x0211, B:82:0x0215, B:25:0x005f, B:27:0x0069, B:29:0x0073, B:31:0x00b3, B:33:0x00e7, B:35:0x00ef, B:58:0x0181, B:60:0x0187, B:36:0x00fc, B:38:0x011a, B:41:0x0124, B:43:0x012e, B:45:0x0138, B:47:0x013e, B:49:0x0148, B:50:0x0158, B:51:0x015e, B:53:0x0164, B:55:0x0174, B:57:0x017a), top: B:97:0x004b, outer: #2, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:38:0x011a A[Catch: all -> 0x0053, TryCatch #1 {all -> 0x0053, blocks: (B:16:0x004b, B:18:0x0051, B:22:0x0056, B:61:0x01a5, B:62:0x01ab, B:64:0x01b1, B:66:0x01c1, B:68:0x01c7, B:70:0x01d8, B:72:0x01f2, B:74:0x01f8, B:75:0x01fc, B:77:0x0202, B:83:0x0218, B:85:0x0220, B:86:0x0226, B:87:0x0237, B:80:0x0211, B:82:0x0215, B:25:0x005f, B:27:0x0069, B:29:0x0073, B:31:0x00b3, B:33:0x00e7, B:35:0x00ef, B:58:0x0181, B:60:0x0187, B:36:0x00fc, B:38:0x011a, B:41:0x0124, B:43:0x012e, B:45:0x0138, B:47:0x013e, B:49:0x0148, B:50:0x0158, B:51:0x015e, B:53:0x0164, B:55:0x0174, B:57:0x017a), top: B:97:0x004b, outer: #2, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:43:0x012e A[Catch: all -> 0x0053, TryCatch #1 {all -> 0x0053, blocks: (B:16:0x004b, B:18:0x0051, B:22:0x0056, B:61:0x01a5, B:62:0x01ab, B:64:0x01b1, B:66:0x01c1, B:68:0x01c7, B:70:0x01d8, B:72:0x01f2, B:74:0x01f8, B:75:0x01fc, B:77:0x0202, B:83:0x0218, B:85:0x0220, B:86:0x0226, B:87:0x0237, B:80:0x0211, B:82:0x0215, B:25:0x005f, B:27:0x0069, B:29:0x0073, B:31:0x00b3, B:33:0x00e7, B:35:0x00ef, B:58:0x0181, B:60:0x0187, B:36:0x00fc, B:38:0x011a, B:41:0x0124, B:43:0x012e, B:45:0x0138, B:47:0x013e, B:49:0x0148, B:50:0x0158, B:51:0x015e, B:53:0x0164, B:55:0x0174, B:57:0x017a), top: B:97:0x004b, outer: #2, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0158 A[Catch: all -> 0x0053, TryCatch #1 {all -> 0x0053, blocks: (B:16:0x004b, B:18:0x0051, B:22:0x0056, B:61:0x01a5, B:62:0x01ab, B:64:0x01b1, B:66:0x01c1, B:68:0x01c7, B:70:0x01d8, B:72:0x01f2, B:74:0x01f8, B:75:0x01fc, B:77:0x0202, B:83:0x0218, B:85:0x0220, B:86:0x0226, B:87:0x0237, B:80:0x0211, B:82:0x0215, B:25:0x005f, B:27:0x0069, B:29:0x0073, B:31:0x00b3, B:33:0x00e7, B:35:0x00ef, B:58:0x0181, B:60:0x0187, B:36:0x00fc, B:38:0x011a, B:41:0x0124, B:43:0x012e, B:45:0x0138, B:47:0x013e, B:49:0x0148, B:50:0x0158, B:51:0x015e, B:53:0x0164, B:55:0x0174, B:57:0x017a), top: B:97:0x004b, outer: #2, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:53:0x0164 A[Catch: all -> 0x0053, TryCatch #1 {all -> 0x0053, blocks: (B:16:0x004b, B:18:0x0051, B:22:0x0056, B:61:0x01a5, B:62:0x01ab, B:64:0x01b1, B:66:0x01c1, B:68:0x01c7, B:70:0x01d8, B:72:0x01f2, B:74:0x01f8, B:75:0x01fc, B:77:0x0202, B:83:0x0218, B:85:0x0220, B:86:0x0226, B:87:0x0237, B:80:0x0211, B:82:0x0215, B:25:0x005f, B:27:0x0069, B:29:0x0073, B:31:0x00b3, B:33:0x00e7, B:35:0x00ef, B:58:0x0181, B:60:0x0187, B:36:0x00fc, B:38:0x011a, B:41:0x0124, B:43:0x012e, B:45:0x0138, B:47:0x013e, B:49:0x0148, B:50:0x0158, B:51:0x015e, B:53:0x0164, B:55:0x0174, B:57:0x017a), top: B:97:0x004b, outer: #2, inners: #0 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x0187 A[Catch: all -> 0x0053, TryCatch #1 {all -> 0x0053, blocks: (B:16:0x004b, B:18:0x0051, B:22:0x0056, B:61:0x01a5, B:62:0x01ab, B:64:0x01b1, B:66:0x01c1, B:68:0x01c7, B:70:0x01d8, B:72:0x01f2, B:74:0x01f8, B:75:0x01fc, B:77:0x0202, B:83:0x0218, B:85:0x0220, B:86:0x0226, B:87:0x0237, B:80:0x0211, B:82:0x0215, B:25:0x005f, B:27:0x0069, B:29:0x0073, B:31:0x00b3, B:33:0x00e7, B:35:0x00ef, B:58:0x0181, B:60:0x0187, B:36:0x00fc, B:38:0x011a, B:41:0x0124, B:43:0x012e, B:45:0x0138, B:47:0x013e, B:49:0x0148, B:50:0x0158, B:51:0x015e, B:53:0x0164, B:55:0x0174, B:57:0x017a), top: B:97:0x004b, outer: #2, inners: #0 }] */
    @Override // com.mbridge.msdk.newreward.a.c
    public final void a(e eVar, b bVar) {
        Iterator<e> it;
        com.mbridge.msdk.newreward.function.d.a.b bVarB;
        e eVarPeek;
        if (eVar == null || bVar == null) {
            return;
        }
        eVar.a(this.f46080d);
        eVar.a(this.f46079c);
        com.mbridge.msdk.newreward.function.c.c cVar = this.f46081e;
        if (cVar != null) {
            cVar.a(eVar, com.mbridge.msdk.newreward.function.c.e.REPORT_LOAD_START, (Object) null);
        }
        int integer = MBridgeSharedPreferenceModel.getInstance().getInteger(String.format(MBridgeCommon.SharedPreference.KEY_VCN, this.f46084h.c()), 1);
        this.f46085i = integer;
        if (integer <= 0) {
            this.f46085i = 1;
        }
        if (a(1) >= this.f46086j) {
            this.f46079c.onVideoLoadFail(new MBridgeIds(), "current unit is loading");
            a(eVar, com.mbridge.msdk.foundation.c.a.b(880016, "errorCode: 3501 errorMessage: current unit is loading"));
            return;
        }
        try {
            synchronized (this.f46078b) {
                try {
                    if (b(eVar)) {
                        return;
                    }
                    if (!eVar.j()) {
                        if (TextUtils.isEmpty(eVar.A()) || !com.mbridge.msdk.newreward.function.h.a.c(eVar.A())) {
                            int integer2 = MBridgeSharedPreferenceModel.getInstance().getInteger(String.format(MBridgeCommon.SharedPreference.KEY_VCN, eVar.y()), 1);
                            if (this.f46077a.size() != 0 && this.f46077a.size() >= integer2) {
                                if (TextUtils.isEmpty(eVar.A()) || (eVarPeek = this.f46077a.peek()) == null || eVarPeek.v() == null || eVarPeek.v().b() == null) {
                                    it = this.f46077a.iterator();
                                    while (true) {
                                        if (it.hasNext()) {
                                            bVarB = it.next().v().b();
                                            if (bVarB == null && bVarB.E() == 1) {
                                                eVar.v().a(bVarB);
                                            }
                                        }
                                    }
                                } else {
                                    eVar.v().a(eVarPeek.v().b());
                                }
                                if (d()) {
                                    a(eVar, com.mbridge.msdk.newreward.function.c.e.REPORT_LOAD_V3_CAMPAIGN_SUCCESS);
                                    this.f46079c.onLoadSuccess(this.f46082f);
                                    eVar.b(true);
                                    a(eVar, com.mbridge.msdk.newreward.function.c.e.REPORT_LOAD_VIDEO_CAMPAIGN_SUCCESS);
                                    this.f46079c.onVideoLoadSuccess(this.f46082f);
                                    eVar.c(true);
                                }
                            }
                        } else {
                            com.mbridge.msdk.newreward.function.c.c cVar2 = this.f46081e;
                            if (((Boolean) cVar2.b(cVar2.a("adapter_model", eVar, "command_manager", cVar2, "candidate_type", 1, "reason", new com.mbridge.msdk.foundation.c.b(880038)))).booleanValue()) {
                                eVar.f(true);
                                com.mbridge.msdk.newreward.function.c.c cVar3 = this.f46081e;
                                com.mbridge.msdk.newreward.function.a.b bVar2 = (com.mbridge.msdk.newreward.function.a.b) cVar3.b(cVar3.a("adapter_model", eVar, "command_manager", cVar3, "candidate_type", 2, "reason", new com.mbridge.msdk.foundation.c.b(880038)));
                                if (bVar2 == null || bVar2.h() != com.mbridge.msdk.newreward.function.a.b.f46152d) {
                                    int integer3 = MBridgeSharedPreferenceModel.getInstance().getInteger(String.format(MBridgeCommon.SharedPreference.KEY_VCN, eVar.y()), 1);
                                    if (this.f46077a.size() != 0) {
                                        if (TextUtils.isEmpty(eVar.A())) {
                                            it = this.f46077a.iterator();
                                            while (true) {
                                                if (it.hasNext()) {
                                                    bVarB = it.next().v().b();
                                                    if (bVarB == null) {
                                                    }
                                                }
                                            }
                                        } else {
                                            it = this.f46077a.iterator();
                                            while (true) {
                                                if (it.hasNext()) {
                                                    bVarB = it.next().v().b();
                                                    if (bVarB == null) {
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    eVar.v().a(bVar2.a());
                                }
                                if (d()) {
                                    a(eVar, com.mbridge.msdk.newreward.function.c.e.REPORT_LOAD_V3_CAMPAIGN_SUCCESS);
                                    this.f46079c.onLoadSuccess(this.f46082f);
                                    eVar.b(true);
                                    a(eVar, com.mbridge.msdk.newreward.function.c.e.REPORT_LOAD_VIDEO_CAMPAIGN_SUCCESS);
                                    this.f46079c.onVideoLoadSuccess(this.f46082f);
                                    eVar.c(true);
                                }
                            } else {
                                int integer4 = MBridgeSharedPreferenceModel.getInstance().getInteger(String.format(MBridgeCommon.SharedPreference.KEY_VCN, eVar.y()), 1);
                                if (this.f46077a.size() != 0) {
                                    if (TextUtils.isEmpty(eVar.A())) {
                                        it = this.f46077a.iterator();
                                        while (true) {
                                            if (it.hasNext()) {
                                                bVarB = it.next().v().b();
                                                if (bVarB == null) {
                                                }
                                            }
                                        }
                                    } else {
                                        it = this.f46077a.iterator();
                                        while (true) {
                                            if (it.hasNext()) {
                                                bVarB = it.next().v().b();
                                                if (bVarB == null) {
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    for (e eVar2 : this.f46077a) {
                        if (!eVar2.v().c() && eVar2.q() == 2) {
                            this.f46077a.remove(eVar2);
                            com.mbridge.msdk.foundation.same.report.d.c.a().c(eVar2.x());
                        }
                    }
                    try {
                        List<String> listE = com.mbridge.msdk.newreward.function.e.c.a().b().e(eVar.n(), eVar.u(), eVar.y());
                        if (listE != null && listE.size() > 0) {
                            Iterator<String> it2 = listE.iterator();
                            while (it2.hasNext()) {
                                com.mbridge.msdk.foundation.same.report.d.c.a().c(it2.next());
                            }
                        }
                    } catch (Exception e11) {
                        if (MBridgeConstans.DEBUG) {
                            e11.printStackTrace();
                        }
                    }
                    while (a(2) > this.f46085i) {
                        this.f46077a.pollFirst();
                    }
                    this.f46077a.add(eVar);
                    eVar.f46091a = bVar;
                    eVar.a(SystemClock.elapsedRealtime());
                    bVar.a(eVar);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Exception e12) {
            this.f46079c.onVideoLoadFail(new MBridgeIds(), e12.getMessage());
            a(eVar, com.mbridge.msdk.foundation.c.a.b(880020, "errorCode: 3501 errorMessage: " + e12.getMessage()));
            com.mbridge.msdk.newreward.function.e.c.a().b().a(eVar.n(), eVar.u(), eVar.y(), eVar.x(), 406);
        }
    }

    @Override // com.mbridge.msdk.newreward.a.c
    public final void a(Object obj) {
        this.f46079c = (RewardVideoListener) obj;
    }

    @Override // com.mbridge.msdk.newreward.a.c
    public final void a(Object... objArr) {
        com.mbridge.msdk.newreward.function.c.c cVar = (com.mbridge.msdk.newreward.function.c.c) objArr[0];
        this.f46081e = cVar;
        com.mbridge.msdk.newreward.b.b bVar = (com.mbridge.msdk.newreward.b.b) objArr[1];
        this.f46084h = bVar;
        final Map mapA = cVar.a("mb_ad_type", Integer.valueOf(bVar.e()), "mb_ad_is_header_bidding", Boolean.valueOf(this.f46084h.f()), "mb_ad_pid", this.f46084h.d(), "mb_ad_unit_id", this.f46084h.c());
        this.f46082f = (MBridgeIds) this.f46081e.a(mapA, com.mbridge.msdk.newreward.function.c.e.CREATE_BIDS);
        com.mbridge.msdk.newreward.function.c.c cVar2 = this.f46081e;
        cVar2.c(cVar2.a("mb_ad_unit_id", this.f46084h.c(), "command_type", com.mbridge.msdk.newreward.function.c.e.UNIT_INIT), new com.mbridge.msdk.newreward.a.b.b() { // from class: com.mbridge.msdk.newreward.a.d.1
            @Override // com.mbridge.msdk.newreward.a.b.b
            public final void a(com.mbridge.msdk.foundation.c.b bVar2) {
            }

            @Override // com.mbridge.msdk.newreward.a.b.b
            public final void a(Object obj) {
            }
        });
        com.mbridge.msdk.newreward.function.e.c.a().b().a(this.f46084h.e(), this.f46084h.d(), this.f46084h.c());
        this.f46081e.a((Object) mapA, com.mbridge.msdk.newreward.function.c.e.REQ_SETTING, new com.mbridge.msdk.newreward.a.b.b() { // from class: com.mbridge.msdk.newreward.a.d.2
            @Override // com.mbridge.msdk.newreward.a.b.b
            public final void a(com.mbridge.msdk.foundation.c.b bVar2) {
            }

            @Override // com.mbridge.msdk.newreward.a.b.b
            public final void a(Object obj) {
                d.this.f46080d = (com.mbridge.msdk.newreward.function.f.e) obj;
                d.this.f46083g = mapA;
                if (d.this.f46084h != null) {
                    d.this.f46084h.a(d.this.f46080d);
                }
                ((MBridgeDailyPlayModel) d.this.f46081e.a(mapA, com.mbridge.msdk.newreward.function.c.e.CREATE_DAILY)).setMaxPlayCount(d.this.f46080d.b() == null ? 0 : d.this.f46080d.b().d());
            }
        });
        Map map = this.f46083g;
        map.put("command_type", com.mbridge.msdk.newreward.function.c.e.RESTORE_DB);
        this.f46081e.c(map, new com.mbridge.msdk.newreward.a.b.b() { // from class: com.mbridge.msdk.newreward.a.d.3
            @Override // com.mbridge.msdk.newreward.a.b.b
            public final void a(com.mbridge.msdk.foundation.c.b bVar2) {
            }

            @Override // com.mbridge.msdk.newreward.a.b.b
            public final void a(Object obj) {
                d.this.b(obj);
            }
        });
        com.mbridge.msdk.newreward.function.c.c cVar3 = this.f46081e;
        cVar3.e(cVar3.a("controller_model", this.f46084h, "command_manager", cVar3, "adapter_manager", this));
        int iA = af.a().a(MBridgeCommon.SharedPreference.KEY_LOADING_CAPACITY, 1);
        this.f46086j = iA;
        if (iA <= 0) {
            this.f46086j = 1;
        }
    }

    @Override // com.mbridge.msdk.newreward.a.c
    public final e b() {
        e eVarPeek;
        Deque<e> deque = this.f46077a;
        if (deque == null || deque.size() == 0 || (eVarPeek = this.f46077a.peek()) == null) {
            return null;
        }
        return eVarPeek;
    }

    public final void b(Object obj) {
        for (com.mbridge.msdk.newreward.function.d.a.b bVar : (List) obj) {
            e eVar = new e(false, ((Integer) this.f46083g.get("mb_ad_type")).intValue(), bVar.f(), bVar.c(), bVar.g());
            com.mbridge.msdk.newreward.function.f.a aVar = new com.mbridge.msdk.newreward.function.f.a();
            aVar.a(bVar);
            eVar.a(aVar);
            eVar.a(this.f46080d);
            eVar.b(2);
            eVar.f46091a = new f(this.f46081e);
            eVar.a(this.f46079c);
            this.f46077a.add(eVar);
        }
    }

    @Override // com.mbridge.msdk.newreward.a.c
    public final void c() {
        Deque<e> deque;
        synchronized (this.f46078b) {
            try {
                if (this.f46077a.size() == 0) {
                    this.f46084h.a(com.mbridge.msdk.newreward.function.h.b.a(""));
                    this.f46081e.a(this.f46084h, com.mbridge.msdk.newreward.function.c.e.REPORT_SHOW_START, (Object) null);
                    this.f46079c.onShowFail(this.f46082f, "no adapter_model");
                    a("no adapter_model");
                    return;
                }
                while (a(2) > this.f46085i) {
                    this.f46077a.pollFirst();
                }
                ConcurrentLinkedDeque concurrentLinkedDeque = new ConcurrentLinkedDeque();
                int i11 = 0;
                while (this.f46077a.size() != 0) {
                    try {
                        e eVarPeek = this.f46077a.peek();
                        i11++;
                        if (eVarPeek.v().c()) {
                            if (i11 != 1 && (deque = this.f46077a) != null && deque.peek() != null) {
                                com.mbridge.msdk.newreward.function.c.c cVar = this.f46081e;
                                cVar.c(cVar.a("adapter_model", eVarPeek, "queue_first_adapter_model", this.f46077a.peek()), com.mbridge.msdk.newreward.function.c.e.UPDATE_CAM_TOKEN_RULE);
                            }
                            eVarPeek.f46091a.b(eVarPeek);
                            this.f46084h.a(eVarPeek);
                            this.f46077a.poll();
                            break;
                        }
                        if (eVarPeek.q() != 2 || eVarPeek.v().c()) {
                            if (this.f46077a.size() == 1) {
                                this.f46084h.a(eVarPeek);
                                this.f46079c.onShowFail(this.f46082f, "all campaign is loading");
                                a("all campaign is loading");
                            }
                            concurrentLinkedDeque.push(this.f46077a.poll());
                        } else {
                            if (this.f46077a.size() == 1) {
                                this.f46084h.a(eVarPeek);
                                this.f46079c.onShowFail(this.f46082f, "no isReadyCampaign");
                                a("no isReadyCampaign");
                            }
                            this.f46077a.poll();
                        }
                    } catch (Exception e11) {
                        if (this.f46077a.size() == 1) {
                            this.f46084h.a(com.mbridge.msdk.newreward.function.h.b.a(""));
                            this.f46079c.onShowFail(this.f46082f, e11.getMessage());
                            a(e11.getMessage());
                            break;
                        }
                    }
                }
                while (concurrentLinkedDeque.size() != 0) {
                    this.f46077a.push((e) concurrentLinkedDeque.poll());
                }
                com.mbridge.msdk.newreward.b.b bVar = this.f46084h;
                if (bVar != null) {
                    if (bVar.a() != null) {
                        this.f46081e.a(this.f46084h.a(), com.mbridge.msdk.newreward.function.c.e.REPORT_SHOW_START, (Object) null);
                    } else {
                        this.f46081e.a(this.f46084h, com.mbridge.msdk.newreward.function.c.e.REPORT_SHOW_START, (Object) null);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.mbridge.msdk.newreward.a.c
    public final boolean d() {
        Iterator<e> it = this.f46077a.iterator();
        while (it.hasNext()) {
            if (it.next().v().c()) {
                return true;
            }
        }
        return false;
    }
}
