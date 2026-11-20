package com.quickjs;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class w implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final QuickJS f49006a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HandlerThread f49008c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f49009d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final h0 f49011f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g0 f49007b = new QuickJSNativeImpl();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Thread f49010e = Thread.currentThread();

    /* JADX INFO: compiled from: source.java */
    public interface a<T> {
        T run();
    }

    public w(QuickJS quickJS, HandlerThread handlerThread) {
        this.f49006a = quickJS;
        this.f49008c = handlerThread;
        this.f49009d = Looper.myLooper() != null ? new Handler(Looper.myLooper()) : null;
        this.f49011f = new h0(quickJS);
    }

    public static /* synthetic */ void R(Object[] objArr, a aVar, RuntimeException[] runtimeExceptionArr) {
        try {
            objArr[0] = aVar.run();
        } catch (RuntimeException e11) {
            runtimeExceptionArr[0] = e11;
        }
        synchronized (objArr) {
            objArr[1] = Boolean.TRUE;
            objArr.notifyAll();
        }
    }

    public final /* synthetic */ Object A(long j11, int i11, JSValue jSValue, String str, JSValue jSValue2) {
        return this.f49007b._executeFunction(j11, i11, jSValue, str, jSValue2);
    }

    public final /* synthetic */ Object B(long j11, int i11, JSValue jSValue, JSValue jSValue2, JSValue jSValue3) {
        return this.f49007b._executeFunction2(j11, i11, jSValue, jSValue2, jSValue3);
    }

    public final /* synthetic */ Object C(long j11, int i11, String str, String str2, int i12) {
        return this.f49007b._executeScript(j11, i11, str, str2, i12);
    }

    public final /* synthetic */ Object D(long j11, int i11, JSValue jSValue, String str) {
        return this.f49007b._get(j11, i11, jSValue, str);
    }

    public final /* synthetic */ String[] E(long j11) {
        return this.f49007b._getException(j11);
    }

    public final /* synthetic */ JSObject F(long j11) {
        return this.f49007b._getGlobalObject(j11);
    }

    public final /* synthetic */ String[] G(long j11, JSValue jSValue) {
        return this.f49007b._getKeys(j11, jSValue);
    }

    public final /* synthetic */ Integer H(long j11, JSValue jSValue) {
        return Integer.valueOf(this.f49007b._getObjectType(j11, jSValue));
    }

    public final /* synthetic */ JSArray I(long j11) {
        return this.f49007b._initNewJSArray(j11);
    }

    public final /* synthetic */ JSFunction J(long j11, int i11, boolean z11) {
        return this.f49007b._initNewJSFunction(j11, i11, z11);
    }

    public final /* synthetic */ JSObject K(long j11) {
        return this.f49007b._initNewJSObject(j11);
    }

    public final /* synthetic */ Boolean L(long j11, JSValue jSValue) {
        return Boolean.valueOf(this.f49007b._isUndefined(j11, jSValue));
    }

    public final /* synthetic */ JSFunction M(long j11, JSValue jSValue, String str, int i11, boolean z11) {
        return this.f49007b._registerJavaMethod(j11, jSValue, str, i11, z11);
    }

    public final /* synthetic */ void N(long j11) {
        this.f49007b._releaseContext(j11);
    }

    public final /* synthetic */ void O(long j11, long j12, int i11, double d11, long j13) {
        this.f49007b._releasePtr(j11, j12, i11, d11, j13);
    }

    public final /* synthetic */ void P(long j11) {
        this.f49007b._releaseRuntime(j11);
    }

    public final /* synthetic */ void Q(long j11, JSValue jSValue, String str, Object obj) {
        this.f49007b._set(j11, jSValue, str, obj);
    }

    public final /* synthetic */ void S(Runnable runnable, RuntimeException[] runtimeExceptionArr, boolean z11, Object[] objArr) {
        try {
            if (!this.f49006a.g()) {
                runnable.run();
            }
        } catch (RuntimeException e11) {
            runtimeExceptionArr[0] = e11;
        }
        if (z11) {
            synchronized (objArr) {
                objArr[1] = Boolean.TRUE;
                objArr.notifyAll();
            }
        }
    }

    public final <T> T T(final a<T> aVar) {
        HandlerThread handlerThread;
        if (this.f49006a.g() || ((handlerThread = this.f49008c) != null && handlerThread.isInterrupted())) {
            Log.e("QuickJS", "QuickJS is released");
            return null;
        }
        if (Thread.currentThread() == this.f49010e) {
            return aVar.run();
        }
        Handler handler = this.f49009d;
        if (handler == null) {
            this.f49011f.b();
            return aVar.run();
        }
        final Object[] objArr = new Object[2];
        final RuntimeException[] runtimeExceptionArr = new RuntimeException[1];
        handler.post(new Runnable() { // from class: com.quickjs.j
            @Override // java.lang.Runnable
            public final void run() {
                w.R(objArr, aVar, runtimeExceptionArr);
            }
        });
        synchronized (objArr) {
            try {
                if (objArr[1] == null) {
                    objArr.wait();
                }
            } catch (InterruptedException e11) {
                e11.printStackTrace();
            }
        }
        RuntimeException runtimeException = runtimeExceptionArr[0];
        if (runtimeException == null) {
            return (T) objArr[0];
        }
        throw runtimeException;
    }

    public void U(Runnable runnable) {
        V(runnable, true);
    }

    public void V(final Runnable runnable, final boolean z11) {
        HandlerThread handlerThread;
        if (this.f49006a.g() || ((handlerThread = this.f49008c) != null && handlerThread.isInterrupted())) {
            Log.e("QuickJS", "QuickJS is released");
            return;
        }
        if (Thread.currentThread() == this.f49010e) {
            runnable.run();
            return;
        }
        Handler handler = this.f49009d;
        if (handler == null) {
            this.f49011f.b();
            runnable.run();
            return;
        }
        final Object[] objArr = new Object[2];
        final RuntimeException[] runtimeExceptionArr = new RuntimeException[1];
        handler.post(new Runnable() { // from class: com.quickjs.b
            @Override // java.lang.Runnable
            public final void run() {
                this.f48915a.S(runnable, runtimeExceptionArr, z11, objArr);
            }
        });
        if (z11) {
            synchronized (objArr) {
                try {
                    if (objArr[1] == null) {
                        objArr.wait();
                    }
                } catch (InterruptedException e11) {
                    e11.printStackTrace();
                }
            }
            RuntimeException runtimeException = runtimeExceptionArr[0];
            if (runtimeException != null) {
                throw runtimeException;
            }
        }
    }

    @Override // com.quickjs.g0
    public JSValue _Undefined(final long j11) {
        return (JSValue) T(new a() { // from class: com.quickjs.l
            @Override // com.quickjs.w.a
            public final Object run() {
                return this.f48955a.x(j11);
            }
        });
    }

    @Override // com.quickjs.g0
    public void _arrayAdd(final long j11, final JSValue jSValue, final Object obj) {
        U(new Runnable() { // from class: com.quickjs.t
            @Override // java.lang.Runnable
            public final void run() {
                this.f48996a.y(j11, jSValue, obj);
            }
        });
    }

    @Override // com.quickjs.g0
    public Object _arrayGet(final long j11, final int i11, final JSValue jSValue, final int i12) {
        return T(new a() { // from class: com.quickjs.d
            @Override // com.quickjs.w.a
            public final Object run() {
                return this.f48922a.z(j11, i11, jSValue, i12);
            }
        });
    }

    @Override // com.quickjs.g0
    public long _createContext(long j11) {
        return this.f49007b._createContext(j11);
    }

    @Override // com.quickjs.g0
    public Object _executeFunction(final long j11, final int i11, final JSValue jSValue, final String str, final JSValue jSValue2) {
        return T(new a() { // from class: com.quickjs.k
            @Override // com.quickjs.w.a
            public final Object run() {
                return this.f48949a.A(j11, i11, jSValue, str, jSValue2);
            }
        });
    }

    @Override // com.quickjs.g0
    public Object _executeFunction2(final long j11, final int i11, final JSValue jSValue, final JSValue jSValue2, final JSValue jSValue3) {
        return T(new a() { // from class: com.quickjs.n
            @Override // com.quickjs.w.a
            public final Object run() {
                return this.f48963a.B(j11, i11, jSValue, jSValue2, jSValue3);
            }
        });
    }

    @Override // com.quickjs.g0
    public Object _executeScript(final long j11, final int i11, final String str, final String str2, final int i12) {
        return T(new a() { // from class: com.quickjs.a
            @Override // com.quickjs.w.a
            public final Object run() {
                return this.f48907a.C(j11, i11, str, str2, i12);
            }
        });
    }

    @Override // com.quickjs.g0
    public Object _get(final long j11, final int i11, final JSValue jSValue, final String str) {
        return T(new a() { // from class: com.quickjs.q
            @Override // com.quickjs.w.a
            public final Object run() {
                return this.f48983a.D(j11, i11, jSValue, str);
            }
        });
    }

    @Override // com.quickjs.g0
    public String[] _getException(final long j11) {
        return (String[]) T(new a() { // from class: com.quickjs.f
            @Override // com.quickjs.w.a
            public final Object run() {
                return this.f48930a.E(j11);
            }
        });
    }

    @Override // com.quickjs.g0
    public JSObject _getGlobalObject(final long j11) {
        return (JSObject) T(new a() { // from class: com.quickjs.i
            @Override // com.quickjs.w.a
            public final Object run() {
                return this.f48944a.F(j11);
            }
        });
    }

    @Override // com.quickjs.g0
    public String[] _getKeys(final long j11, final JSValue jSValue) {
        return (String[]) T(new a() { // from class: com.quickjs.h
            @Override // com.quickjs.w.a
            public final Object run() {
                return this.f48938a.G(j11, jSValue);
            }
        });
    }

    @Override // com.quickjs.g0
    public int _getObjectType(final long j11, final JSValue jSValue) {
        return ((Integer) T(new a() { // from class: com.quickjs.e
            @Override // com.quickjs.w.a
            public final Object run() {
                return this.f48927a.H(j11, jSValue);
            }
        })).intValue();
    }

    @Override // com.quickjs.g0
    public JSArray _initNewJSArray(final long j11) {
        return (JSArray) T(new a() { // from class: com.quickjs.u
            @Override // com.quickjs.w.a
            public final Object run() {
                return this.f49000a.I(j11);
            }
        });
    }

    @Override // com.quickjs.g0
    public JSFunction _initNewJSFunction(final long j11, final int i11, final boolean z11) {
        return (JSFunction) T(new a() { // from class: com.quickjs.v
            @Override // com.quickjs.w.a
            public final Object run() {
                return this.f49002a.J(j11, i11, z11);
            }
        });
    }

    @Override // com.quickjs.g0
    public JSObject _initNewJSObject(final long j11) {
        return (JSObject) T(new a() { // from class: com.quickjs.o
            @Override // com.quickjs.w.a
            public final Object run() {
                return this.f48969a.K(j11);
            }
        });
    }

    @Override // com.quickjs.g0
    public boolean _isUndefined(final long j11, final JSValue jSValue) {
        return ((Boolean) T(new a() { // from class: com.quickjs.p
            @Override // com.quickjs.w.a
            public final Object run() {
                return this.f48971a.L(j11, jSValue);
            }
        })).booleanValue();
    }

    @Override // com.quickjs.g0
    public JSFunction _registerJavaMethod(final long j11, final JSValue jSValue, final String str, final int i11, final boolean z11) {
        return (JSFunction) T(new a() { // from class: com.quickjs.m
            @Override // com.quickjs.w.a
            public final Object run() {
                return this.f48957a.M(j11, jSValue, str, i11, z11);
            }
        });
    }

    @Override // com.quickjs.g0
    public void _releaseContext(final long j11) {
        U(new Runnable() { // from class: com.quickjs.s
            @Override // java.lang.Runnable
            public final void run() {
                this.f48994a.N(j11);
            }
        });
    }

    @Override // com.quickjs.g0
    public void _releasePtr(final long j11, final long j12, final int i11, final double d11, final long j13) {
        U(new Runnable() { // from class: com.quickjs.r
            @Override // java.lang.Runnable
            public final void run() {
                this.f48988a.O(j11, j12, i11, d11, j13);
            }
        });
    }

    @Override // com.quickjs.g0
    public void _releaseRuntime(final long j11) {
        U(new Runnable() { // from class: com.quickjs.c
            @Override // java.lang.Runnable
            public final void run() {
                this.f48920a.P(j11);
            }
        });
    }

    @Override // com.quickjs.g0
    public void _set(final long j11, final JSValue jSValue, final String str, final Object obj) {
        U(new Runnable() { // from class: com.quickjs.g
            @Override // java.lang.Runnable
            public final void run() {
                this.f48933a.Q(j11, jSValue, str, obj);
            }
        });
    }

    public void w() {
        HandlerThread handlerThread = this.f49008c;
        if (handlerThread != null) {
            handlerThread.interrupt();
        }
    }

    public final /* synthetic */ JSValue x(long j11) {
        return this.f49007b._Undefined(j11);
    }

    public final /* synthetic */ void y(long j11, JSValue jSValue, Object obj) {
        this.f49007b._arrayAdd(j11, jSValue, obj);
    }

    public final /* synthetic */ Object z(long j11, int i11, JSValue jSValue, int i12) {
        return this.f49007b._arrayGet(j11, i11, jSValue, i12);
    }
}
