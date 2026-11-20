package rj;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.InvalidRegistrarException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes5.dex */
public final class g<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final T f75539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c<T> f75540b;

    /* JADX INFO: compiled from: source.java */
    public static class b implements c<Context> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Class<? extends Service> f75541a;

        public b(Class<? extends Service> cls) {
            this.f75541a = cls;
        }

        public final Bundle b(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("ComponentDiscovery", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, this.f75541a), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("ComponentDiscovery", this.f75541a + " has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("ComponentDiscovery", "Application info not found.");
                return null;
            }
        }

        @Override // rj.g.c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public List<String> a(Context context) {
            Bundle bundleB = b(context);
            if (bundleB == null) {
                Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String str : bundleB.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(bundleB.get(str)) && str.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str.substring(31));
                }
            }
            return arrayList;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public interface c<T> {
        List<String> a(T t11);
    }

    public g(T t11, c<T> cVar) {
        this.f75539a = t11;
        this.f75540b = cVar;
    }

    public static g<Context> c(Context context, Class<? extends Service> cls) {
        return new g<>(context, new b(cls));
    }

    @Nullable
    public static ComponentRegistrar d(String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                return (ComponentRegistrar) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            }
            throw new InvalidRegistrarException(String.format("Class %s is not an instance of %s", str, "com.google.firebase.components.ComponentRegistrar"));
        } catch (ClassNotFoundException unused) {
            Log.w("ComponentDiscovery", String.format("Class %s is not an found.", str));
            return null;
        } catch (IllegalAccessException e11) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s.", str), e11);
        } catch (InstantiationException e12) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s.", str), e12);
        } catch (NoSuchMethodException e13) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s", str), e13);
        } catch (InvocationTargetException e14) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s", str), e14);
        }
    }

    public List<bl.b<ComponentRegistrar>> b() {
        ArrayList arrayList = new ArrayList();
        for (final String str : this.f75540b.a(this.f75539a)) {
            arrayList.add(new bl.b() { // from class: rj.f
                @Override // bl.b
                public final Object get() {
                    return g.d(str);
                }
            });
        }
        return arrayList;
    }
}
