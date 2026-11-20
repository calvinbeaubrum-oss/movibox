package com.quickjs;

import java.io.Closeable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class y extends JSObject implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final QuickJS f49013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f49014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<e0> f49015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Integer, JSValue> f49016d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Object[]> f49017f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<Integer, QuickJS.a> f49018g;

    public y(QuickJS quickJS, long j11) {
        super(null, quickJS.e()._getGlobalObject(j11));
        this.f49015c = Collections.synchronizedSet(new HashSet());
        this.f49016d = Collections.synchronizedMap(new WeakHashMap());
        this.f49017f = Collections.synchronizedList(new LinkedList());
        this.f49018g = Collections.synchronizedMap(new HashMap());
        this.f49013a = quickJS;
        this.f49014b = j11;
        this.context = this;
        QuickJS.f48893d.put(Long.valueOf(j11), this);
    }

    public void U(JSValue jSValue) {
        if (jSValue.getClass() != y.class) {
            this.f49016d.put(Integer.valueOf(jSValue.hashCode()), jSValue);
        }
    }

    public void W(e0 e0Var) {
        b0();
        if (this.f49015c.contains(e0Var)) {
            return;
        }
        e0Var.b(this.context);
        this.f49015c.add(e0Var);
    }

    public final void Z() {
        while (!this.f49017f.isEmpty()) {
            Object[] objArr = this.f49017f.get(0);
            getNative()._releasePtr(getContextPtr(), ((Long) objArr[0]).longValue(), ((Integer) objArr[1]).intValue(), ((Double) objArr[2]).doubleValue(), ((Long) objArr[3]).longValue());
            this.f49017f.remove(0);
        }
    }

    public void b0() {
        Z();
        if (h0()) {
            throw new Error("Context disposed error");
        }
    }

    @Override // com.quickjs.JSValue, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        postEventQueue(new Runnable() { // from class: com.quickjs.x
            @Override // java.lang.Runnable
            public final void run() {
                this.f49012a.i0();
            }
        });
    }

    public void d0(JSValue jSValue) {
        if (jSValue == null || jSValue.isUndefined()) {
            return;
        }
        y yVar = jSValue.context;
        if (yVar == null) {
            throw new Error("Invalid target runtime");
        }
        QuickJS quickJS = yVar.f49013a;
        if (quickJS == null || quickJS.g() || quickJS != this.f49013a) {
            throw new Error("Invalid target runtime");
        }
    }

    public Object e0(JSValue.TYPE type, String str, String str2) throws QuickJSScriptException {
        Object obj_executeScript = getNative()._executeScript(getContextPtr(), type.value, str, str2, QuickJS.f48895g);
        QuickJS.b(this.context);
        return obj_executeScript;
    }

    public Object g0(String str, String str2) throws QuickJSScriptException {
        return e0(JSValue.TYPE.UNKNOWN, str, str2);
    }

    @Override // com.quickjs.JSValue
    public long getContextPtr() {
        return this.f49014b;
    }

    @Override // com.quickjs.JSValue
    public g0 getNative() {
        return this.f49013a.e();
    }

    @Override // com.quickjs.JSValue
    public QuickJS getQuickJS() {
        return this.f49013a;
    }

    public boolean h0() {
        if (getQuickJS().g()) {
            return true;
        }
        return this.released;
    }

    public final /* synthetic */ void i0() {
        if (this.released) {
            return;
        }
        Iterator<e0> it = this.f49015c.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
        this.f49015c.clear();
        this.f49018g.clear();
        for (JSValue jSValue : (JSValue[]) this.f49016d.values().toArray(new JSValue[0])) {
            if (jSValue != null) {
                jSValue.close();
            }
        }
        Z();
        super.close();
        getNative()._releaseContext(this.f49014b);
        QuickJS.f48893d.remove(Long.valueOf(getContextPtr()));
    }

    public void j0(JSValue jSValue, boolean z11) {
        if (z11) {
            this.f49017f.add(new Object[]{Long.valueOf(jSValue.tag), Integer.valueOf(jSValue.u_int32), Double.valueOf(jSValue.u_float64), Long.valueOf(jSValue.u_ptr)});
        } else {
            getNative()._releasePtr(getContextPtr(), jSValue.tag, jSValue.u_int32, jSValue.u_float64, jSValue.u_ptr);
        }
        k0(jSValue);
    }

    public void k0(JSValue jSValue) {
        this.f49016d.remove(Integer.valueOf(jSValue.hashCode()));
    }

    public void w(b0 b0Var, JSFunction jSFunction) {
        QuickJS.a aVar = new QuickJS.a();
        aVar.f48906b = b0Var;
        this.f49018g.put(Integer.valueOf(b0Var.hashCode()), aVar);
    }

    public void x(c0 c0Var, JSFunction jSFunction) {
        QuickJS.a aVar = new QuickJS.a();
        aVar.f48905a = c0Var;
        this.f49018g.put(Integer.valueOf(c0Var.hashCode()), aVar);
    }
}
