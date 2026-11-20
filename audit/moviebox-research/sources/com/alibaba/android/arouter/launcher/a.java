package com.alibaba.android.arouter.launcher;

import android.app.Application;
import android.content.Context;
import android.net.Uri;
import com.alibaba.android.arouter.exception.InitException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.facade.template.ILogger;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile a f15374a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile boolean f15375b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static ILogger f15376c;

    public static boolean c() {
        return _ARouter.i();
    }

    public static a d() {
        if (!f15375b) {
            throw new InitException("ARouter::Init::Invoke init(context) first!");
        }
        if (f15374a == null) {
            synchronized (a.class) {
                try {
                    if (f15374a == null) {
                        f15374a = new a();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f15374a;
    }

    public static void e(Application application) {
        if (f15375b) {
            return;
        }
        ILogger iLogger = _ARouter.f15359a;
        f15376c = iLogger;
        iLogger.info(ILogger.defaultTag, "ARouter init start.");
        f15375b = _ARouter.l(application);
        if (f15375b) {
            _ARouter.e();
        }
        _ARouter.f15359a.info(ILogger.defaultTag, "ARouter init over.");
    }

    public Postcard a(Uri uri) {
        return _ARouter.k().f(uri);
    }

    public Postcard b(String str) {
        return _ARouter.k().g(str);
    }

    public void f(Object obj) {
        _ARouter.m(obj);
    }

    public Object g(Context context, Postcard postcard, int i11, NavigationCallback navigationCallback) {
        return _ARouter.k().n(context, postcard, i11, navigationCallback);
    }

    public <T> T h(Class<? extends T> cls) {
        return (T) _ARouter.k().o(cls);
    }
}
