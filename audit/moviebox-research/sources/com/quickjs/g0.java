package com.quickjs;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public interface g0 {
    JSValue _Undefined(long j11);

    void _arrayAdd(long j11, JSValue jSValue, Object obj);

    Object _arrayGet(long j11, int i11, JSValue jSValue, int i12);

    long _createContext(long j11);

    Object _executeFunction(long j11, int i11, JSValue jSValue, String str, JSValue jSValue2);

    Object _executeFunction2(long j11, int i11, JSValue jSValue, JSValue jSValue2, JSValue jSValue3);

    Object _executeScript(long j11, int i11, String str, String str2, int i12);

    Object _get(long j11, int i11, JSValue jSValue, String str);

    String[] _getException(long j11);

    JSObject _getGlobalObject(long j11);

    String[] _getKeys(long j11, JSValue jSValue);

    int _getObjectType(long j11, JSValue jSValue);

    JSArray _initNewJSArray(long j11);

    JSFunction _initNewJSFunction(long j11, int i11, boolean z11);

    JSObject _initNewJSObject(long j11);

    boolean _isUndefined(long j11, JSValue jSValue);

    JSFunction _registerJavaMethod(long j11, JSValue jSValue, String str, int i11, boolean z11);

    void _releaseContext(long j11);

    void _releasePtr(long j11, long j12, int i11, double d11, long j13);

    void _releaseRuntime(long j11);

    void _set(long j11, JSValue jSValue, String str, Object obj);
}
