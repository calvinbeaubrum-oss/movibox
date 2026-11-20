package com.alibaba.android.arouter.core;

import android.content.Context;
import android.net.Uri;
import com.alibaba.android.arouter.exception.HandlerException;
import com.alibaba.android.arouter.exception.NoRouteFoundException;
import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.enums.RouteType;
import com.alibaba.android.arouter.facade.enums.TypeKind;
import com.alibaba.android.arouter.facade.model.RouteMeta;
import com.alibaba.android.arouter.facade.template.IInterceptorGroup;
import com.alibaba.android.arouter.facade.template.ILogger;
import com.alibaba.android.arouter.facade.template.IProvider;
import com.alibaba.android.arouter.facade.template.IProviderGroup;
import com.alibaba.android.arouter.facade.template.IRouteGroup;
import com.alibaba.android.arouter.facade.template.IRouteRoot;
import com.alibaba.android.arouter.utils.ClassUtils;
import com.alibaba.android.arouter.utils.c;
import com.alibaba.android.arouter.utils.d;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Context f15348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static ThreadPoolExecutor f15349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f15350c;

    /* JADX INFO: renamed from: com.alibaba.android.arouter.core.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static /* synthetic */ class C0160a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f15351a;

        static {
            int[] iArr = new int[RouteType.values().length];
            f15351a = iArr;
            try {
                iArr[RouteType.PROVIDER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f15351a[RouteType.FRAGMENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static synchronized void a(String str, IRouteGroup iRouteGroup) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        try {
            if (b.f15352a.containsKey(str)) {
                b.f15352a.get(str).getConstructor(new Class[0]).newInstance(new Object[0]).loadInto(b.f15353b);
                b.f15352a.remove(str);
            }
            if (iRouteGroup != null) {
                iRouteGroup.loadInto(b.f15353b);
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static Postcard b(String str) {
        RouteMeta routeMeta = b.f15355d.get(str);
        if (routeMeta == null) {
            return null;
        }
        return new Postcard(routeMeta.getPath(), routeMeta.getGroup());
    }

    public static synchronized void c(Postcard postcard) {
        try {
            if (postcard == null) {
                throw new NoRouteFoundException("ARouter::No postcard!");
            }
            RouteMeta routeMeta = b.f15353b.get(postcard.getPath());
            if (routeMeta != null) {
                postcard.setDestination(routeMeta.getDestination());
                postcard.setType(routeMeta.getType());
                postcard.setPriority(routeMeta.getPriority());
                postcard.setExtra(routeMeta.getExtra());
                Uri uri = postcard.getUri();
                if (uri != null) {
                    Map<String, String> mapC = d.c(uri);
                    Map<String, Integer> paramsType = routeMeta.getParamsType();
                    if (com.alibaba.android.arouter.utils.b.b(paramsType)) {
                        for (Map.Entry<String, Integer> entry : paramsType.entrySet()) {
                            f(postcard, entry.getValue(), entry.getKey(), mapC.get(entry.getKey()));
                        }
                        postcard.getExtras().putStringArray("wmHzgD4lOj5o4241", (String[]) paramsType.keySet().toArray(new String[0]));
                    }
                    postcard.withString("NTeRQWvye18AkPd6G", uri.toString());
                }
                int i11 = C0160a.f15351a[routeMeta.getType().ordinal()];
                if (i11 == 1) {
                    Class<?> destination = routeMeta.getDestination();
                    IProvider iProvider = b.f15354c.get(destination);
                    if (iProvider == null) {
                        try {
                            iProvider = (IProvider) destination.getConstructor(new Class[0]).newInstance(new Object[0]);
                            iProvider.init(f15348a);
                            b.f15354c.put(destination, iProvider);
                        } catch (Exception e11) {
                            com.alibaba.android.arouter.launcher.a.f15376c.error(ILogger.defaultTag, "Init provider failed!", e11);
                            throw new HandlerException("Init provider failed!");
                        }
                    }
                    postcard.setProvider(iProvider);
                    postcard.greenChannel();
                } else if (i11 == 2) {
                    postcard.greenChannel();
                }
            } else {
                if (!b.f15352a.containsKey(postcard.getGroup())) {
                    throw new NoRouteFoundException("ARouter::There is no route match the path [" + postcard.getPath() + "], in group [" + postcard.getGroup() + "]");
                }
                try {
                    if (com.alibaba.android.arouter.launcher.a.c()) {
                        com.alibaba.android.arouter.launcher.a.f15376c.debug(ILogger.defaultTag, String.format(Locale.getDefault(), "The group [%s] starts loading, trigger by [%s]", postcard.getGroup(), postcard.getPath()));
                    }
                    a(postcard.getGroup(), null);
                    if (com.alibaba.android.arouter.launcher.a.c()) {
                        com.alibaba.android.arouter.launcher.a.f15376c.debug(ILogger.defaultTag, String.format(Locale.getDefault(), "The group [%s] has already been loaded, trigger by [%s]", postcard.getGroup(), postcard.getPath()));
                    }
                    c(postcard);
                } catch (Exception e12) {
                    throw new HandlerException("ARouter::Fatal exception when loading group meta. [" + e12.getMessage() + "]");
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static synchronized void d(Context context, ThreadPoolExecutor threadPoolExecutor) throws HandlerException {
        Set<String> setA;
        try {
            f15348a = context;
            f15349b = threadPoolExecutor;
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                e();
                if (f15350c) {
                    com.alibaba.android.arouter.launcher.a.f15376c.info(ILogger.defaultTag, "Load router map by arouter-auto-register plugin.");
                } else {
                    if (com.alibaba.android.arouter.launcher.a.c() || c.b(context)) {
                        com.alibaba.android.arouter.launcher.a.f15376c.info(ILogger.defaultTag, "Run with debug mode or new install, rebuild router map.");
                        setA = ClassUtils.a(f15348a, "com.alibaba.android.arouter.routes");
                        if (!setA.isEmpty()) {
                            context.getSharedPreferences("SP_AROUTER_CACHE", 0).edit().putStringSet("ROUTER_MAP", setA).apply();
                        }
                        c.c(context);
                    } else {
                        com.alibaba.android.arouter.launcher.a.f15376c.info(ILogger.defaultTag, "Load router map from cache.");
                        setA = new HashSet<>(context.getSharedPreferences("SP_AROUTER_CACHE", 0).getStringSet("ROUTER_MAP", new HashSet()));
                    }
                    com.alibaba.android.arouter.launcher.a.f15376c.info(ILogger.defaultTag, "Find router map finished, map size = " + setA.size() + ", cost " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms.");
                    jCurrentTimeMillis = System.currentTimeMillis();
                    for (String str : setA) {
                        if (str.startsWith("com.alibaba.android.arouter.routes.ARouter$$Root")) {
                            ((IRouteRoot) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0])).loadInto(b.f15352a);
                        } else if (str.startsWith("com.alibaba.android.arouter.routes.ARouter$$Interceptors")) {
                            ((IInterceptorGroup) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0])).loadInto(b.f15356e);
                        } else if (str.startsWith("com.alibaba.android.arouter.routes.ARouter$$Providers")) {
                            ((IProviderGroup) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0])).loadInto(b.f15355d);
                        }
                    }
                }
                com.alibaba.android.arouter.launcher.a.f15376c.info(ILogger.defaultTag, "Load root element finished, cost " + (System.currentTimeMillis() - jCurrentTimeMillis) + " ms.");
                if (b.f15352a.size() == 0) {
                    com.alibaba.android.arouter.launcher.a.f15376c.error(ILogger.defaultTag, "No mapping files were found, check your configuration please!");
                }
                if (com.alibaba.android.arouter.launcher.a.c()) {
                    com.alibaba.android.arouter.launcher.a.f15376c.debug(ILogger.defaultTag, String.format(Locale.getDefault(), "LogisticsCenter has already been loaded, GroupIndex[%d], InterceptorIndex[%d], ProviderIndex[%d]", Integer.valueOf(b.f15352a.size()), Integer.valueOf(b.f15356e.size()), Integer.valueOf(b.f15355d.size())));
                }
            } catch (Exception e11) {
                throw new HandlerException("ARouter::ARouter init logistics center exception! [" + e11.getMessage() + "]");
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static void e() {
        f15350c = false;
    }

    public static void f(Postcard postcard, Integer num, String str, String str2) {
        if (d.b(str) || d.b(str2)) {
            return;
        }
        try {
            if (num == null) {
                postcard.withString(str, str2);
            } else if (num.intValue() == TypeKind.BOOLEAN.ordinal()) {
                postcard.withBoolean(str, Boolean.parseBoolean(str2));
            } else if (num.intValue() == TypeKind.BYTE.ordinal()) {
                postcard.withByte(str, Byte.parseByte(str2));
            } else if (num.intValue() == TypeKind.SHORT.ordinal()) {
                postcard.withShort(str, Short.parseShort(str2));
            } else if (num.intValue() == TypeKind.INT.ordinal()) {
                postcard.withInt(str, Integer.parseInt(str2));
            } else if (num.intValue() == TypeKind.LONG.ordinal()) {
                postcard.withLong(str, Long.parseLong(str2));
            } else if (num.intValue() == TypeKind.FLOAT.ordinal()) {
                postcard.withFloat(str, Float.parseFloat(str2));
            } else if (num.intValue() == TypeKind.DOUBLE.ordinal()) {
                postcard.withDouble(str, Double.parseDouble(str2));
            } else if (num.intValue() == TypeKind.STRING.ordinal()) {
                postcard.withString(str, str2);
            } else if (num.intValue() != TypeKind.PARCELABLE.ordinal()) {
                if (num.intValue() == TypeKind.OBJECT.ordinal()) {
                    postcard.withString(str, str2);
                } else {
                    postcard.withString(str, str2);
                }
            }
        } catch (Throwable th2) {
            com.alibaba.android.arouter.launcher.a.f15376c.warning(ILogger.defaultTag, "LogisticsCenter setValue failed! " + th2.getMessage());
        }
    }
}
