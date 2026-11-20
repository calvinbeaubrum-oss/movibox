package com.mbridge.msdk.newreward.function.c;

import com.mbridge.msdk.newreward.function.common.MBridgeError;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f46242a;

    public final Object a(Object obj, e eVar) {
        if (this.f46242a == null) {
            return null;
        }
        b bVar = new b();
        bVar.a(obj);
        bVar.a(eVar);
        return this.f46242a.a(bVar).a();
    }

    public final Map a(Object... objArr) {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        if (objArr.length % 2 != 0) {
            return concurrentHashMap;
        }
        for (int i11 = 0; i11 < objArr.length; i11++) {
            if (i11 % 2 == 0) {
                Object obj = objArr[i11];
                Object obj2 = objArr[i11 + 1];
                if (obj == null) {
                    obj = "";
                }
                if (obj2 == null) {
                    obj2 = "";
                }
                concurrentHashMap.put(obj, obj2);
            }
        }
        return concurrentHashMap;
    }

    public final void a(a aVar) {
        this.f46242a = aVar;
    }

    public final void a(Object obj) {
        if (this.f46242a == null) {
            return;
        }
        b bVar = new b();
        bVar.a(e.SHOW);
        bVar.a(obj);
        this.f46242a.a(bVar);
    }

    public final void a(Object obj, com.mbridge.msdk.newreward.a.b.b bVar) {
        if (this.f46242a == null) {
            return;
        }
        b bVar2 = new b();
        bVar2.a(obj);
        bVar2.a(e.NORMAL_LOAD);
        this.f46242a.a(bVar2, bVar);
    }

    public final void a(Object obj, e eVar, com.mbridge.msdk.newreward.a.b.b bVar) {
        if (this.f46242a == null) {
            return;
        }
        b bVar2 = new b();
        bVar2.a(obj);
        bVar2.a(eVar);
        this.f46242a.a(bVar2, bVar);
    }

    public final void a(Object obj, e eVar, Object obj2) {
        b bVar = new b();
        bVar.a(obj2);
        bVar.a(eVar);
        new com.mbridge.msdk.newreward.function.c.a.b(obj).a(bVar);
    }

    public final Object b(Object obj) {
        if (this.f46242a == null) {
            return null;
        }
        b bVar = new b();
        bVar.a(obj);
        bVar.a(e.CANDIDATE_LOAD_ACTION);
        return this.f46242a.a(bVar).a();
    }

    public final Object b(Object obj, e eVar) {
        if (this.f46242a == null) {
            return Boolean.FALSE;
        }
        b bVar = new b();
        bVar.a(eVar);
        bVar.a(obj);
        return this.f46242a.a(bVar).a();
    }

    public final void b(Object obj, com.mbridge.msdk.newreward.a.b.b bVar) {
        if (this.f46242a == null) {
            return;
        }
        b bVar2 = new b();
        bVar2.a(obj);
        bVar2.a(e.SMART_LOAD);
        this.f46242a.a(bVar2, bVar);
    }

    public final Object c(Object obj, e eVar) {
        if (this.f46242a == null) {
            return Boolean.FALSE;
        }
        b bVar = new b();
        bVar.a(eVar);
        bVar.a(obj);
        return this.f46242a.a(bVar).a();
    }

    public final void c(Object obj) throws MBridgeError {
        if (this.f46242a == null) {
            return;
        }
        b bVar = new b();
        bVar.a(e.CHECK_CAMPAIGN);
        bVar.a(obj);
        d dVarA = this.f46242a.a(bVar);
        if (!dVarA.b()) {
            throw ((MBridgeError) dVarA.a());
        }
    }

    public final void c(Object obj, com.mbridge.msdk.newreward.a.b.b bVar) {
        if (this.f46242a == null) {
            return;
        }
        b bVar2 = new b();
        bVar2.a(obj);
        bVar2.a((e) ((Map) obj).get("command_type"));
        this.f46242a.a(bVar2, bVar);
    }

    public final void d(Object obj) {
        if (this.f46242a == null) {
            return;
        }
        b bVar = new b();
        bVar.a(obj);
        bVar.a(e.HANDLER_ALREADY_INSTALL_CAMPAIGN);
        this.f46242a.a(bVar);
    }

    public final void e(Object obj) {
        b bVar = new b();
        bVar.a(obj);
        bVar.a(e.START_LOAD_CHECK);
        this.f46242a.a(bVar);
    }
}
