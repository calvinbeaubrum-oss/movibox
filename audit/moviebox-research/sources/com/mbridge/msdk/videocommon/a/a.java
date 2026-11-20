package com.mbridge.msdk.videocommon.a;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a.d;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.videocommon.d.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f48443a = "com.mbridge.msdk.videocommon.a.a";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static a f48444b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private f f48445c;

    private a() {
        try {
            Context contextC = c.m().c();
            if (contextC != null) {
                this.f48445c = f.a(h.a(contextC));
            } else {
                ad.b(f48443a, "RewardCampaignCache get Context is null");
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public static a a() {
        if (f48444b == null) {
            synchronized (a.class) {
                try {
                    if (f48444b == null) {
                        f48444b = new a();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f48444b;
    }

    public final List<com.mbridge.msdk.foundation.entity.c> a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.f48445c.d(str);
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    public final List<CampaignEx> a(String str, int i11, boolean z11) {
        return a(str, i11, z11, "");
    }

    public final List<CampaignEx> a(List<CampaignEx> list) {
        ArrayList arrayList = null;
        if (list == null) {
            return null;
        }
        try {
            com.mbridge.msdk.videocommon.d.a aVarB = b.a().b();
            long jF = aVarB != null ? aVarB.f() : 0L;
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (list.size() <= 0) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                for (CampaignEx campaignEx : list) {
                    if (campaignEx != null) {
                        long plct = campaignEx.getPlct() * 1000;
                        long timestamp = jCurrentTimeMillis - campaignEx.getTimestamp();
                        if ((plct > 0 && plct >= timestamp) || (plct <= 0 && jF >= timestamp)) {
                            arrayList2.add(campaignEx);
                        }
                    }
                }
                return arrayList2;
            } catch (Exception e11) {
                e = e11;
                arrayList = arrayList2;
            }
        } catch (Exception e12) {
            e = e12;
        }
        e.printStackTrace();
        return arrayList;
    }

    public final CopyOnWriteArrayList<CampaignEx> a(String str, int i11) {
        List<CampaignEx> listA;
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = null;
        try {
            if (TextUtils.isEmpty(str) || (listA = this.f48445c.a(str, 0, 0, i11)) == null) {
                return null;
            }
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
            try {
                for (CampaignEx campaignEx : listA) {
                    if (campaignEx != null) {
                        copyOnWriteArrayList2.add(campaignEx);
                    }
                }
                return copyOnWriteArrayList2;
            } catch (Exception e11) {
                e = e11;
                copyOnWriteArrayList = copyOnWriteArrayList2;
            }
        } catch (Exception e12) {
            e = e12;
        }
        e.printStackTrace();
        return copyOnWriteArrayList;
    }

    public final CopyOnWriteArrayList<CampaignEx> a(String str, int i11, boolean z11, String str2) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = null;
        try {
            com.mbridge.msdk.videocommon.d.a aVarB = b.a().b();
            long jF = aVarB != null ? aVarB.f() : 0L;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            List<CampaignEx> listA = z11 ? this.f48445c.a(str, 0, 0, i11, str2) : this.f48445c.a(str, 0, 0, i11, false);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (listA == null) {
                return null;
            }
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
            try {
                for (CampaignEx campaignEx : listA) {
                    if (campaignEx != null && (campaignEx.getReadyState() == 0 || campaignEx.getLoadTimeoutState() == 1)) {
                        long plct = campaignEx.getPlct() * 1000;
                        long timestamp = jCurrentTimeMillis - campaignEx.getTimestamp();
                        if ((plct > 0 && plct >= timestamp) || (plct <= 0 && jF >= timestamp)) {
                            copyOnWriteArrayList2.add(campaignEx);
                        }
                    }
                }
                return copyOnWriteArrayList2;
            } catch (Exception e11) {
                e = e11;
                copyOnWriteArrayList = copyOnWriteArrayList2;
            }
        } catch (Exception e12) {
            e = e12;
        }
        e.printStackTrace();
        return copyOnWriteArrayList;
    }

    public final synchronized void a(long j11, String str) {
        try {
            this.f48445c.a(j11, str);
        } catch (Exception e11) {
            e11.printStackTrace();
            ad.b(f48443a, e11.getMessage());
        }
    }

    public final void a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(campaignEx.getId())) {
                    return;
                }
                this.f48445c.b(campaignEx.getId(), campaignEx.getRequestId());
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public final void a(CampaignEx campaignEx, String str) {
        if (campaignEx != null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                if (campaignEx.isBidCampaign()) {
                    d.c(str, campaignEx.getRequestId());
                }
                this.f48445c.a(campaignEx.getId(), str, campaignEx.isBidCampaign(), campaignEx.getRequestId());
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public final void a(String str, String str2) {
        if (this.f48445c == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f48445c.f(str, str2);
    }

    public final void a(String str, String str2, List<CampaignEx> list) {
        try {
            if (TextUtils.isEmpty(str2) || list == null || list.size() <= 0) {
                return;
            }
            this.f48445c.a(list, str, str2, 0);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void a(String str, List<CampaignEx> list) {
        f fVar;
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0 || (fVar = this.f48445c) == null) {
            return;
        }
        fVar.b(str, list);
    }

    public final void a(String str, List<CampaignEx> list, String str2) {
        f fVar;
        try {
            if (TextUtils.isEmpty(str) || list == null || list.size() <= 0 || (fVar = this.f48445c) == null) {
                return;
            }
            fVar.a(str, list, str2);
        } catch (Exception e11) {
            ad.b(f48443a, e11.getMessage());
        }
    }

    public final void a(String str, List<CampaignEx> list, String str2, int i11) {
        f fVar;
        if (TextUtils.isEmpty(str) || list == null || list.size() <= 0 || TextUtils.isEmpty(str2) || (fVar = this.f48445c) == null) {
            return;
        }
        fVar.a(str, list, str2, i11);
    }

    public final int b(String str, int i11, boolean z11, String str2) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            ArrayList arrayList = new ArrayList();
            List<CampaignEx> listA = z11 ? this.f48445c.a(str, 0, 0, i11, str2) : this.f48445c.a(str, 0, 0, i11, false);
            if (listA == null) {
                return 0;
            }
            for (CampaignEx campaignEx : listA) {
                if (campaignEx != null && campaignEx.getReadyState() == 0) {
                    arrayList.add(campaignEx);
                }
            }
            return arrayList.size();
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public final List<CampaignEx> b(String str, int i11, boolean z11) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return this.f48445c.a(str, 0, 0, i11, z11);
        } catch (Exception e11) {
            ad.b(f48443a, e11.getLocalizedMessage());
            return null;
        }
    }

    public final void b(String str) {
        ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.c> concurrentHashMapF;
        try {
            if (TextUtils.isEmpty(str) || (concurrentHashMapF = this.f48445c.f(str)) == null || concurrentHashMapF.size() <= 0) {
                return;
            }
            g gVarB = com.mbridge.msdk.c.h.a().b(c.m().k());
            if (gVarB == null) {
                com.mbridge.msdk.c.h.a();
                gVarB = i.a();
            }
            long jAc = gVarB != null ? gVarB.ac() : 0L;
            long jCurrentTimeMillis = System.currentTimeMillis();
            for (com.mbridge.msdk.foundation.entity.c cVar : concurrentHashMapF.values()) {
                if (cVar != null) {
                    long jE = cVar.e();
                    if (jE <= 0) {
                        jE = jAc;
                    }
                    if (cVar.f() + (jE * 1000) < jCurrentTimeMillis && !TextUtils.isEmpty(cVar.a())) {
                        ad.b("HBOPTIMIZE", "不在有效期范围内 删除" + cVar.a());
                        c(str, cVar.a());
                    }
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void b(String str, int i11) {
        int size;
        try {
            List<com.mbridge.msdk.foundation.entity.c> listD = this.f48445c.d(str);
            if (listD == null || listD.size() <= 0 || (size = listD.size() - i11) <= 0) {
                return;
            }
            for (int i12 = 0; i12 < size; i12++) {
                c(str, listD.get(i12).a());
                d.c(str, listD.get(i12).a());
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void b(String str, String str2) {
        f fVar = this.f48445c;
        if (fVar != null) {
            fVar.e(str, str2);
        }
    }

    public final List<CampaignEx> c(String str, int i11, boolean z11, String str2) {
        long jAc;
        ArrayList arrayList = null;
        try {
            g gVarB = com.mbridge.msdk.c.h.a().b(c.m().k());
            if (gVarB != null) {
                jAc = gVarB.ac();
            } else {
                com.mbridge.msdk.c.h.a();
                jAc = i.a().ac();
            }
            long j11 = jAc * 1000;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            List<CampaignEx> listA = z11 ? this.f48445c.a(str, 0, 0, i11, str2) : this.f48445c.a(str, 0, 0, i11, false);
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (listA == null) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                for (CampaignEx campaignEx : listA) {
                    if (campaignEx != null && campaignEx.getReadyState() == 0) {
                        long plctb = campaignEx.getPlctb() * 1000;
                        long timestamp = jCurrentTimeMillis - campaignEx.getTimestamp();
                        if ((plctb <= 0 && j11 >= timestamp) || (plctb > 0 && plctb >= timestamp)) {
                            arrayList2.add(campaignEx);
                        }
                    }
                }
                return arrayList2;
            } catch (Exception e11) {
                e = e11;
                arrayList = arrayList2;
            }
        } catch (Exception e12) {
            e = e12;
        }
        e.printStackTrace();
        return arrayList;
    }

    public final synchronized void c(String str, int i11) {
        try {
            try {
                g gVarB = com.mbridge.msdk.c.h.a().b(c.m().k());
                if (gVarB == null) {
                    com.mbridge.msdk.c.h.a();
                    gVarB = i.a();
                }
                int iJ = gVarB.j();
                if (iJ == 0) {
                    return;
                }
                List<CampaignEx> listB = this.f48445c.b(str, i11, iJ == 2);
                if (listB != null && listB.size() > 0) {
                    for (CampaignEx campaignEx : listB) {
                        String requestIdNotice = campaignEx.getRequestIdNotice();
                        String id2 = campaignEx.getId();
                        com.mbridge.msdk.videocommon.a.b(campaignEx.getCampaignUnitId() + "_" + id2 + "_" + requestIdNotice + "_" + campaignEx.getCMPTEntryUrl());
                    }
                }
                this.f48445c.a(str, i11, iJ == 2);
            } catch (Exception e11) {
                ad.b(f48443a, e11.getMessage());
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized void c(String str, String str2) {
        try {
            this.f48445c.c(str2, str);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
