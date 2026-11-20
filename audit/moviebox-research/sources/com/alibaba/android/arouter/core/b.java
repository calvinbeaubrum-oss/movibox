package com.alibaba.android.arouter.core;

import com.alibaba.android.arouter.base.UniqueKeyTreeMap;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Map<String, Class<? extends IRouteGroup>> f15352a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Map<String, RouteMeta> f15353b = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Map<Class, IProvider> f15354c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Map<String, RouteMeta> f15355d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Map<Integer, Class<? extends IInterceptor>> f15356e = new UniqueKeyTreeMap("More than one interceptors use same priority [%s]");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static List<IInterceptor> f15357f = new ArrayList();
}
