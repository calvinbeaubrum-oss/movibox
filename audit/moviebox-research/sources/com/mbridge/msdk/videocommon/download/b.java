package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.ad;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile b f48535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ThreadPoolExecutor f48536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f48537c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ConcurrentHashMap<String, j> f48538d = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ConcurrentHashMap<String, CopyOnWriteArrayList<Map<String, a>>> f48539e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> f48540f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ConcurrentHashMap<String, CopyOnWriteArrayList<a>> f48541g;

    private b() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 15, 15L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
        this.f48536b = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static b getInstance() {
        if (f48535a == null) {
            synchronized (b.class) {
                try {
                    if (f48535a == null) {
                        f48535a = new b();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f48535a;
    }

    public final a a(String str, String str2) {
        j jVarC = c(str);
        if (jVarC != null) {
            return jVarC.a(str2);
        }
        return null;
    }

    public final CopyOnWriteArrayList<CampaignEx> a(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> concurrentHashMap = this.f48540f;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.f48540f.get(str);
    }

    public final void a() {
        ConcurrentHashMap<String, j> concurrentHashMap = this.f48538d;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, j> entry : concurrentHashMap.entrySet()) {
                j value = entry.getValue();
                String key = entry.getKey();
                try {
                    com.mbridge.msdk.videocommon.d.c cVarA = com.mbridge.msdk.videocommon.d.b.a().a(com.mbridge.msdk.foundation.controller.c.m().k(), key);
                    if (cVarA != null) {
                        if (cVarA.w() == 2) {
                            value.b();
                        } else {
                            value.a();
                        }
                    }
                } catch (Exception e11) {
                    ad.b("DownLoadManager", e11.getMessage());
                    try {
                        if (!TextUtils.isEmpty(key)) {
                            k kVarD = com.mbridge.msdk.c.h.a().d(com.mbridge.msdk.foundation.controller.c.m().k(), key);
                            if (kVarD == null) {
                                kVarD = k.e(key);
                            }
                            if (kVarD.k() == 2) {
                                value.b();
                            } else {
                                value.a();
                            }
                        }
                    } catch (Exception e12) {
                        ad.b("DownLoadManager", e12.getMessage());
                    }
                }
            }
        }
    }

    public final void a(String str, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> concurrentHashMap = this.f48540f;
        if (concurrentHashMap == null) {
            this.f48540f = new ConcurrentHashMap<>();
        } else {
            concurrentHashMap.clear();
        }
        this.f48540f.put(str, copyOnWriteArrayList);
    }

    public final void a(boolean z11) {
        this.f48537c = z11;
        ConcurrentHashMap<String, j> concurrentHashMap = this.f48538d;
        if (concurrentHashMap != null) {
            Iterator<Map.Entry<String, j>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                j value = it.next().getValue();
                if (value != null) {
                    value.b();
                }
            }
        }
    }

    public final boolean a(int i11, String str, boolean z11) {
        try {
            j jVarC = c(str);
            return (jVarC == null || jVarC.a(i11, z11) == null) ? false : true;
        } catch (Exception e11) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            e11.printStackTrace();
            return false;
        }
    }

    public final boolean a(int i11, String str, boolean z11, int i12, boolean z12, int i13, List<CampaignEx> list) {
        return a(i11, str, z11, i12, z12, i13, list, false, null);
    }

    /* JADX WARN: Code duplicated, block: B:92:0x0190  */
    public final boolean a(int i11, String str, boolean z11, int i12, boolean z12, int i13, List<CampaignEx> list, boolean z13, com.mbridge.msdk.foundation.same.report.d.d dVar) {
        j jVarC;
        boolean z14;
        CampaignEx campaignEx;
        boolean z15 = false;
        if (list != null) {
            try {
                if (list.size() != 0 && (jVarC = c(str)) != null) {
                    List<a> listA = jVarC.a(str, i11, z11, list, z13, dVar);
                    if (listA != null && listA.size() != 0) {
                        if (z12) {
                            if (list.size() <= 0 || (campaignEx = list.get(0)) == null || campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(0)) {
                                z14 = false;
                            } else {
                                ad.c("DownLoadManager", "Is not check video download status with TPL");
                                z14 = true;
                            }
                            try {
                                if (i13 == 0) {
                                    ArrayList arrayList = new ArrayList();
                                    for (a aVar : listA) {
                                        for (CampaignEx campaignEx2 : list) {
                                            if (aVar != null && aVar.l() != null && campaignEx2 != null && campaignEx2.getId().equals(aVar.l().getId()) && campaignEx2.getRequestId().equals(aVar.l().getRequestId())) {
                                                arrayList.add(aVar);
                                            }
                                        }
                                    }
                                    if (arrayList.size() > 0) {
                                        z15 = true;
                                    } else {
                                        z15 = z14;
                                    }
                                } else {
                                    ArrayList arrayList2 = new ArrayList();
                                    for (a aVar2 : listA) {
                                        for (CampaignEx campaignEx3 : list) {
                                            if (aVar2 != null && aVar2.l() != null && campaignEx3 != null && campaignEx3.getId().equals(aVar2.l().getId()) && campaignEx3.getRequestId().equals(aVar2.l().getRequestId())) {
                                                arrayList2.add(aVar2);
                                            }
                                        }
                                    }
                                    if (arrayList2.size() >= i12) {
                                        z15 = true;
                                    }
                                }
                            } catch (Exception e11) {
                                e = e11;
                                z15 = z14;
                                if (MBridgeConstans.DEBUG) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            ArrayList arrayList3 = new ArrayList();
                            for (a aVar3 : listA) {
                                for (CampaignEx campaignEx4 : list) {
                                    if (aVar3 != null && aVar3.l() != null && campaignEx4 != null && campaignEx4.getId().equals(aVar3.l().getId()) && campaignEx4.getRequestId().equals(aVar3.l().getRequestId())) {
                                        arrayList3.add(aVar3);
                                    }
                                }
                            }
                            if (arrayList3.size() > 0) {
                                z15 = true;
                            }
                        }
                    }
                    if (z15) {
                        ConcurrentHashMap<String, CopyOnWriteArrayList<Map<String, a>>> concurrentHashMap = this.f48539e;
                        if (concurrentHashMap == null) {
                            this.f48539e = new ConcurrentHashMap<>();
                        } else if (concurrentHashMap.containsKey(str)) {
                            this.f48539e.remove(str);
                        }
                        ConcurrentHashMap<String, CopyOnWriteArrayList<a>> concurrentHashMap2 = this.f48541g;
                        if (concurrentHashMap2 == null) {
                            this.f48541g = new ConcurrentHashMap<>();
                        } else if (concurrentHashMap2.containsKey(str)) {
                            this.f48541g.remove(str);
                        }
                        ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> concurrentHashMap3 = this.f48540f;
                        if (concurrentHashMap3 == null) {
                            this.f48540f = new ConcurrentHashMap<>();
                        } else if (concurrentHashMap3.containsKey(str)) {
                            this.f48540f.remove(str);
                        }
                        if (listA != null && listA.size() > 0) {
                            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
                            CopyOnWriteArrayList<a> copyOnWriteArrayList3 = new CopyOnWriteArrayList<>();
                            for (a aVar4 : listA) {
                                ConcurrentHashMap concurrentHashMap4 = new ConcurrentHashMap();
                                CampaignEx campaignExL = aVar4.l();
                                concurrentHashMap4.put(campaignExL.getId() + campaignExL.getVideoUrlEncode() + campaignExL.getBidToken(), aVar4);
                                copyOnWriteArrayList.add(concurrentHashMap4);
                                copyOnWriteArrayList2.add(campaignExL);
                                copyOnWriteArrayList3.add(aVar4);
                            }
                            this.f48539e.put(str, (CopyOnWriteArrayList<Map<String, a>>) copyOnWriteArrayList);
                            this.f48540f.put(str, copyOnWriteArrayList2);
                            this.f48541g.put(str, copyOnWriteArrayList3);
                        }
                    }
                }
            } catch (Exception e12) {
                e = e12;
            }
        }
        return z15;
    }

    public final int b(String str, String str2) {
        CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayListC;
        a value;
        CampaignEx campaignExL;
        ConcurrentHashMap<String, j> concurrentHashMap = this.f48538d;
        if (concurrentHashMap != null) {
            Iterator<Map.Entry<String, j>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                j value2 = it.next().getValue();
                if (value2 != null && (copyOnWriteArrayListC = value2.c()) != null) {
                    int size = copyOnWriteArrayListC.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        Map<String, a> map = copyOnWriteArrayListC.get(i11);
                        if (map != null) {
                            Iterator<Map.Entry<String, a>> it2 = map.entrySet().iterator();
                            if (it2.hasNext() && (value = it2.next().getValue()) != null && (campaignExL = value.l()) != null) {
                                String videoUrlEncode = campaignExL.getVideoUrlEncode();
                                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(videoUrlEncode) && str2.equals(videoUrlEncode)) {
                                    return value.k();
                                }
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }

    public final CopyOnWriteArrayList<a> b(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<a>> concurrentHashMap = this.f48541g;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.f48541g.get(str);
    }

    public final void b(String str, CopyOnWriteArrayList<a> copyOnWriteArrayList) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<a>> concurrentHashMap = this.f48541g;
        if (concurrentHashMap == null) {
            this.f48541g = new ConcurrentHashMap<>();
        } else {
            concurrentHashMap.clear();
        }
        this.f48541g.put(str, copyOnWriteArrayList);
    }

    public final void b(boolean z11) {
        if (!z11) {
            this.f48537c = false;
        } else if (this.f48537c) {
            return;
        }
        ConcurrentHashMap<String, j> concurrentHashMap = this.f48538d;
        if (concurrentHashMap != null) {
            Iterator<Map.Entry<String, j>> it = concurrentHashMap.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().a();
            }
        }
    }

    public final j c(String str) {
        ConcurrentHashMap<String, j> concurrentHashMap = this.f48538d;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.f48538d.get(str);
    }

    public j createUnitCache(Context context, String str, CampaignEx campaignEx, int i11, com.mbridge.msdk.videocommon.listener.a aVar) {
        j jVar;
        if (TextUtils.isEmpty(str) || campaignEx == null) {
            return null;
        }
        if (this.f48538d.containsKey(str)) {
            jVar = this.f48538d.get(str);
            if (jVar == null) {
                jVar = new j(context, campaignEx, this.f48536b, str, i11);
                this.f48538d.put(str, jVar);
            }
            if (i11 == 94 || i11 == 287) {
                jVar.a(campaignEx.getRequestId(), aVar);
            } else {
                jVar.a(aVar);
            }
            jVar.a(campaignEx);
        } else {
            jVar = new j(context, campaignEx, this.f48536b, str, i11);
            if (aVar != null) {
                jVar.a(aVar);
            }
            this.f48538d.put(str, jVar);
        }
        return jVar;
    }

    public j createUnitCache(Context context, String str, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, int i11, com.mbridge.msdk.videocommon.listener.a aVar) {
        j jVar;
        if (TextUtils.isEmpty(str) || copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
            return null;
        }
        if (this.f48538d.containsKey(str)) {
            jVar = this.f48538d.get(str);
            if (jVar == null) {
                jVar = new j(context, copyOnWriteArrayList, this.f48536b, str, i11);
                this.f48538d.put(str, jVar);
            }
            if (i11 == 94 || i11 == 287) {
                jVar.a(copyOnWriteArrayList.get(0).getRequestId(), aVar);
            } else {
                jVar.a(aVar);
            }
            jVar.a(copyOnWriteArrayList);
        } else {
            jVar = new j(context, copyOnWriteArrayList, this.f48536b, str, i11);
            if (aVar != null) {
                jVar.a(aVar);
            }
            this.f48538d.put(str, jVar);
        }
        return jVar;
    }

    public void load(String str) {
        j jVarC = c(str);
        if (jVarC != null) {
            jVarC.a();
        }
    }
}
