package com.mbridge.msdk.mbbanner.common.c;

import android.content.Context;
import android.os.Handler;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.c.k;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.out.MBridgeIds;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f45277a = "a";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static volatile a f45278h;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f45279b = com.mbridge.msdk.foundation.controller.c.m().c();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.mbridge.msdk.mbbanner.common.util.a f45280c = new com.mbridge.msdk.mbbanner.common.util.a();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Map<String, com.mbridge.msdk.mbbanner.common.a.c> f45281d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, Boolean> f45282e = new ConcurrentHashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Map<String, Handler> f45283f = new ConcurrentHashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<String, Integer> f45284g = new ConcurrentHashMap();

    private a() {
    }

    public static a a() {
        if (f45278h == null) {
            synchronized (a.class) {
                try {
                    if (f45278h == null) {
                        f45278h = new a();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f45278h;
    }

    public final void a(int i11, String str, String str2, com.mbridge.msdk.mbbanner.common.a.b bVar, com.mbridge.msdk.mbbanner.common.b.b bVar2) {
        Handler handler;
        Handler handler2;
        Handler handler3;
        Integer num;
        int iIntValue = (!this.f45284g.containsKey(str2) || (num = this.f45284g.get(str2)) == null) ? 0 : num.intValue();
        if (i11 == 1) {
            if (this.f45283f.containsKey(str2) && (handler = this.f45283f.get(str2)) != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.f45284g.put(str2, Integer.valueOf(i11));
            return;
        }
        if (i11 == 2) {
            if (iIntValue == 1) {
                if (this.f45283f.containsKey(str2) && (handler2 = this.f45283f.get(str2)) != null) {
                    handler2.removeCallbacksAndMessages(null);
                }
                this.f45284g.put(str2, Integer.valueOf(i11));
                return;
            }
            return;
        }
        if (i11 == 3) {
            if (iIntValue == 2 || iIntValue == 4) {
                this.f45284g.put(str2, 1);
                b(str, str2, bVar, bVar2);
                return;
            }
            return;
        }
        if (i11 != 4) {
            return;
        }
        if (iIntValue == 0) {
            this.f45284g.put(str2, 0);
            return;
        }
        if (this.f45283f.containsKey(str2) && (handler3 = this.f45283f.get(str2)) != null) {
            handler3.removeCallbacksAndMessages(null);
        }
        this.f45284g.put(str2, Integer.valueOf(i11));
    }

    public final void a(String str) {
        if (this.f45283f.containsKey(str)) {
            Handler handler = this.f45283f.get(str);
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            this.f45283f.remove(str);
        }
    }

    public final void a(String str, String str2, final com.mbridge.msdk.mbbanner.common.a.b bVar, com.mbridge.msdk.mbbanner.common.b.b bVar2) {
        com.mbridge.msdk.mbbanner.common.a.c cVar;
        Boolean bool;
        MBridgeIds mBridgeIds = new MBridgeIds(str, str2);
        if (this.f45279b == null) {
            com.mbridge.msdk.foundation.c.b bVar3 = new com.mbridge.msdk.foundation.c.b(880025);
            bVar3.a(mBridgeIds);
            this.f45280c.a(bVar2, bVar3);
            return;
        }
        if (bVar == null || bVar2 == null) {
            com.mbridge.msdk.foundation.c.b bVar4 = new com.mbridge.msdk.foundation.c.b(880001);
            bVar4.a(mBridgeIds);
            this.f45280c.a(bVar2, bVar4);
            return;
        }
        Map<String, Boolean> map = this.f45282e;
        if (map != null && map.containsKey(str2) && (bool = this.f45282e.get(str2)) != null && bool.booleanValue()) {
            com.mbridge.msdk.foundation.c.b bVar5 = new com.mbridge.msdk.foundation.c.b(880016, "Current unit is loading!");
            bVar5.a(mBridgeIds);
            this.f45280c.a(bVar2, bVar5);
            return;
        }
        this.f45282e.put(str2, Boolean.TRUE);
        if (this.f45281d.containsKey(str2)) {
            cVar = this.f45281d.get(str2);
        } else {
            k kVarD = h.a().d(com.mbridge.msdk.foundation.controller.c.m().k(), str2);
            if (kVarD == null) {
                kVarD = k.d(str2);
            }
            com.mbridge.msdk.mbbanner.common.a.c cVar2 = new com.mbridge.msdk.mbbanner.common.a.c(str2, "", 0, kVarD.w());
            this.f45281d.put(str2, cVar2);
            cVar = cVar2;
        }
        new b(this.f45279b, cVar, bVar2, this.f45280c).a(str, str2, bVar, new com.mbridge.msdk.mbbanner.common.b.d() { // from class: com.mbridge.msdk.mbbanner.common.c.a.1
            @Override // com.mbridge.msdk.mbbanner.common.b.d
            public final void a(String str3) {
                synchronized (a.a()) {
                    bVar.a("");
                    a.this.f45282e.put(str3, Boolean.FALSE);
                }
            }
        });
    }

    public final void b() {
        Map<String, com.mbridge.msdk.mbbanner.common.a.c> map = this.f45281d;
        if (map != null) {
            map.clear();
        }
        Map<String, Boolean> map2 = this.f45282e;
        if (map2 != null) {
            map2.clear();
        }
        Map<String, Handler> map3 = this.f45283f;
        if (map3 != null) {
            for (Map.Entry<String, Handler> entry : map3.entrySet()) {
                if (entry.getValue() != null) {
                    entry.getValue().removeCallbacksAndMessages(null);
                }
            }
            this.f45283f.clear();
        }
        Map<String, Integer> map4 = this.f45284g;
        if (map4 != null) {
            map4.clear();
        }
    }

    public final void b(final String str, final String str2, final com.mbridge.msdk.mbbanner.common.a.b bVar, final com.mbridge.msdk.mbbanner.common.b.b bVar2) {
        Handler handler;
        final MBridgeIds mBridgeIds = new MBridgeIds(str, str2);
        if (bVar == null || bVar.b() <= 0) {
            ad.b(f45277a, "doUnitRotation: Illegal banner request parameters! && unitId=" + str2);
            return;
        }
        if (this.f45283f.containsKey(str2)) {
            handler = this.f45283f.get(str2);
        } else {
            handler = new Handler();
            this.f45283f.put(str2, handler);
        }
        Handler handler2 = handler;
        Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.mbbanner.common.c.a.2
            @Override // java.lang.Runnable
            public final void run() {
                Boolean bool;
                if (a.this.f45282e == null || !a.this.f45282e.containsKey(str2) || (bool = (Boolean) a.this.f45282e.get(str2)) == null || !bool.booleanValue()) {
                    if (a.this.f45284g.containsKey(str2)) {
                        Integer num = (Integer) a.this.f45284g.get(str2);
                        int iIntValue = num != null ? num.intValue() : 0;
                        if (iIntValue == 2 || iIntValue == 4) {
                            ad.b(a.f45277a, "doUnitRotation: autoRotationStatus=" + iIntValue + " && unitId=" + str2);
                            if (a.this.f45280c != null) {
                                com.mbridge.msdk.foundation.c.b bVar3 = new com.mbridge.msdk.foundation.c.b(880026);
                                bVar3.a(mBridgeIds);
                                a.this.f45280c.a(bVar2, bVar3);
                                return;
                            }
                            return;
                        }
                    }
                    a.this.a(str, str2, bVar, bVar2);
                }
            }
        };
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
            handler2.postDelayed(runnable, bVar.b());
        }
    }
}
