package com.applovin.impl;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ye {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashMap f24658b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final HashMap f24659c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final HashMap f24660d = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.j f24661a;

    public ye(com.applovin.impl.sdk.j jVar) {
        this.f24661a = jVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long a(Long l11) {
        return Long.valueOf(l11 != null ? 1 + l11.longValue() : 1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Long a(Long l11, Long l12) {
        return l11;
    }

    private HashMap a(xe.a aVar) {
        if (aVar == xe.a.AD_UNIT_ID) {
            return f24658b;
        }
        return aVar == xe.a.AD_FORMAT ? f24659c : f24660d;
    }

    private boolean a(we weVar, xe xeVar, we.a aVar) {
        if (weVar == null) {
            this.f24661a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f24661a.J().b("MediationStatsManager", "Failed to update stat, no stat provided");
            }
            return false;
        }
        if (xeVar == null) {
            this.f24661a.J();
            if (com.applovin.impl.sdk.n.a()) {
                this.f24661a.J().b("MediationStatsManager", "Failed to update stat, no dimension key provided");
            }
            return false;
        }
        if (aVar != null) {
            return true;
        }
        this.f24661a.J();
        if (com.applovin.impl.sdk.n.a()) {
            this.f24661a.J().b("MediationStatsManager", "Failed to update stat, no stat updater provided");
        }
        return false;
    }

    private void b(we weVar, xe xeVar, we.a aVar) {
        HashMap map;
        if (a(weVar, xeVar, aVar)) {
            String strB = xeVar.b();
            HashMap mapA = a(xeVar.a());
            synchronized (mapA) {
                try {
                    if (mapA.containsKey(strB)) {
                        map = (HashMap) mapA.get(strB);
                    } else {
                        HashMap map2 = new HashMap();
                        mapA.put(strB, map2);
                        map = map2;
                    }
                    map.put(weVar, aVar.a(map.get(weVar)));
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public Map a(we weVar, xe.a aVar) {
        HashMap mapA = a(aVar);
        HashMap map = new HashMap();
        synchronized (mapA) {
            try {
                for (String str : mapA.keySet()) {
                    map.put(str, ((HashMap) mapA.get(str)).get(weVar));
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return map;
    }

    public void a(we weVar, xe xeVar) {
        b(weVar, xeVar, new we.a() { // from class: com.applovin.impl.y90
            @Override // com.applovin.impl.we.a
            public final Object a(Object obj) {
                return ye.a((Long) obj);
            }
        });
    }

    public void a(we weVar, xe xeVar, final Long l11) {
        b(weVar, xeVar, new we.a() { // from class: com.applovin.impl.x90
            @Override // com.applovin.impl.we.a
            public final Object a(Object obj) {
                return ye.a(l11, (Long) obj);
            }
        });
    }
}
