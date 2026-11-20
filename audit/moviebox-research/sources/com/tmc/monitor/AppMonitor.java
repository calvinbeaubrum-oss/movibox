package com.tmc.monitor;

import android.os.Bundle;
import android.text.TextUtils;
import com.tmc.network.NetworkConfig;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import no.b;
import no.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public class AppMonitor {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Set<Class<?>> f49345b = new CopyOnWriteArraySet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Map<Class<?>, List<Field>> f49346c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Map<Field, String> f49347d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f49348a;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static AppMonitor f49349a = new AppMonitor();
    }

    public AppMonitor() {
        this.f49348a = 3755;
        NetworkConfig networkConfig = NetworkConfig.INSTANCE;
        if (networkConfig.getAppMonitorId() != -1) {
            this.f49348a = networkConfig.getAppMonitorId();
        }
    }

    public static AppMonitor d() {
        return a.f49349a;
    }

    public final void b(c cVar) {
        List<Field> list;
        try {
            Class<?> cls = cVar.getClass();
            if (!f49345b.contains(cls)) {
                e(cls);
            }
            b bVar = (b) cls.getAnnotation(b.class);
            if (bVar == null) {
                return;
            }
            String strId = bVar.id();
            String strName = bVar.name();
            if (TextUtils.isEmpty(strId) || (list = f49346c.get(cls)) == null) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("object_id", strId);
            bundle.putString("object_name", strName);
            for (Field field : list) {
                String str = f49347d.get(field);
                Class<?> type = field.getType();
                if (type.isAssignableFrom(Integer.TYPE)) {
                    bundle.putInt(str, field.getInt(cVar));
                } else if (type.isAssignableFrom(Long.TYPE)) {
                    bundle.putLong(str, field.getLong(cVar));
                } else if (type.isAssignableFrom(Boolean.TYPE)) {
                    bundle.putBoolean(str, field.getBoolean(cVar));
                } else if (type.isAssignableFrom(Character.TYPE)) {
                    bundle.putChar(str, field.getChar(cVar));
                } else if (type.isAssignableFrom(Byte.TYPE)) {
                    bundle.putByte(str, field.getByte(cVar));
                } else if (type.isAssignableFrom(Short.TYPE)) {
                    bundle.putShort(str, field.getShort(cVar));
                } else if (type.isAssignableFrom(Float.TYPE)) {
                    bundle.putFloat(str, field.getFloat(cVar));
                } else if (type.isAssignableFrom(Double.TYPE)) {
                    bundle.putDouble(str, field.getDouble(cVar));
                } else if (type.isAssignableFrom(String.class)) {
                    bundle.putString(str, (String) field.get(cVar));
                } else {
                    po.b.f73956a.c(" error type = " + type + ", fieldName = " + str);
                }
            }
            po.b.f73956a.c(" Bundle data = " + bundle.toString());
            new dr.a("network", this.f49348a).c(bundle, null).b();
        } catch (Throwable th2) {
            po.b.f73956a.e(th2);
        }
    }

    public void c(final c cVar) {
        if (cVar != null) {
            try {
                NetworkConfig networkConfig = NetworkConfig.INSTANCE;
                if (networkConfig.isNetworkMonitorEnable()) {
                    if (((int) (Math.random() * 1000.0d)) <= networkConfig.getAppMonitorRandom()) {
                        po.c.f73961c.a().a(new Runnable() { // from class: com.tmc.monitor.AppMonitor.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AppMonitor.this.b(cVar);
                            }
                        });
                        return;
                    }
                    po.b.f73956a.c("abort report. data = " + cVar.toString());
                }
            } catch (Throwable th2) {
                po.b.f73956a.e(th2);
            }
        }
    }

    public final void e(Class<?> cls) {
        if (cls != null) {
            try {
                if (f49345b.contains(cls) || ((b) cls.getAnnotation(b.class)) == null) {
                    return;
                }
                Field[] declaredFields = cls.getDeclaredFields();
                ArrayList arrayList = new ArrayList();
                for (Field field : declaredFields) {
                    if (((no.a) field.getAnnotation(no.a.class)) != null) {
                        field.setAccessible(true);
                        arrayList.add(field);
                        f49347d.put(field, field.getName());
                    }
                }
                f49346c.put(cls, arrayList);
                f49345b.add(cls);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }
}
