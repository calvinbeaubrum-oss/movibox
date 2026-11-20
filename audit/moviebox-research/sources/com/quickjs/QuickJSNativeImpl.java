package com.quickjs;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
class QuickJSNativeImpl implements g0 {
    public static native long _createRuntime();

    @Override // com.quickjs.g0
    public native JSValue _Undefined(long j11);

    @Override // com.quickjs.g0
    public native void _arrayAdd(long j11, JSValue jSValue, Object obj);

    @Override // com.quickjs.g0
    public native Object _arrayGet(long j11, int i11, JSValue jSValue, int i12);

    @Override // com.quickjs.g0
    public native long _createContext(long j11);

    @Override // com.quickjs.g0
    public native Object _executeFunction(long j11, int i11, JSValue jSValue, String str, JSValue jSValue2);

    @Override // com.quickjs.g0
    public native Object _executeFunction2(long j11, int i11, JSValue jSValue, JSValue jSValue2, JSValue jSValue3);

    @Override // com.quickjs.g0
    public native Object _executeScript(long j11, int i11, String str, String str2, int i12);

    @Override // com.quickjs.g0
    public native Object _get(long j11, int i11, JSValue jSValue, String str);

    @Override // com.quickjs.g0
    public native String[] _getException(long j11);

    @Override // com.quickjs.g0
    public native JSObject _getGlobalObject(long j11);

    @Override // com.quickjs.g0
    public native String[] _getKeys(long j11, JSValue jSValue);

    @Override // com.quickjs.g0
    public native int _getObjectType(long j11, JSValue jSValue);

    @Override // com.quickjs.g0
    public native JSArray _initNewJSArray(long j11);

    @Override // com.quickjs.g0
    public native JSFunction _initNewJSFunction(long j11, int i11, boolean z11);

    @Override // com.quickjs.g0
    public native JSObject _initNewJSObject(long j11);

    @Override // com.quickjs.g0
    public native boolean _isUndefined(long j11, JSValue jSValue);

    @Override // com.quickjs.g0
    public native JSFunction _registerJavaMethod(long j11, JSValue jSValue, String str, int i11, boolean z11);

    @Override // com.quickjs.g0
    public native void _releaseContext(long j11);

    @Override // com.quickjs.g0
    public native void _releasePtr(long j11, long j12, int i11, double d11, long j13);

    @Override // com.quickjs.g0
    public native void _releaseRuntime(long j11);

    @Override // com.quickjs.g0
    public native void _set(long j11, JSValue jSValue, String str, Object obj);
}
