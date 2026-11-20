package fg;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.backends.TransportBackendDiscovery;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class i implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f64873a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f64874b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, k> f64875c;

    /* JADX INFO: compiled from: source.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f64876a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, String> f64877b = null;

        public a(Context context) {
            this.f64876a = context;
        }

        public static Bundle d(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) TransportBackendDiscovery.class), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("BackendRegistry", "Application info not found.");
                return null;
            }
        }

        public final Map<String, String> a(Context context) {
            Bundle bundleD = d(context);
            if (bundleD == null) {
                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                return Collections.emptyMap();
            }
            HashMap map = new HashMap();
            for (String str : bundleD.keySet()) {
                Object obj = bundleD.get(str);
                if ((obj instanceof String) && str.startsWith("backend:")) {
                    for (String str2 : ((String) obj).split(",", -1)) {
                        String strTrim = str2.trim();
                        if (!strTrim.isEmpty()) {
                            map.put(strTrim, str.substring(8));
                        }
                    }
                }
            }
            return map;
        }

        @Nullable
        public c b(String str) {
            String str2 = c().get(str);
            if (str2 == null) {
                return null;
            }
            try {
                return (c) Class.forName(str2).asSubclass(c.class).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            } catch (ClassNotFoundException e11) {
                Log.w("BackendRegistry", String.format("Class %s is not found.", str2), e11);
                return null;
            } catch (IllegalAccessException e12) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", str2), e12);
                return null;
            } catch (InstantiationException e13) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", str2), e13);
                return null;
            } catch (NoSuchMethodException e14) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", str2), e14);
                return null;
            } catch (InvocationTargetException e15) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", str2), e15);
                return null;
            }
        }

        public final Map<String, String> c() {
            if (this.f64877b == null) {
                this.f64877b = a(this.f64876a);
            }
            return this.f64877b;
        }
    }

    public i(Context context, g gVar) {
        this(new a(context), gVar);
    }

    public i(a aVar, g gVar) {
        this.f64875c = new HashMap();
        this.f64873a = aVar;
        this.f64874b = gVar;
    }

    @Override // fg.d
    @Nullable
    public synchronized k a(String str) {
        if (this.f64875c.containsKey(str)) {
            return this.f64875c.get(str);
        }
        c cVarB = this.f64873a.b(str);
        if (cVarB == null) {
            return null;
        }
        k kVarCreate = cVarB.create(this.f64874b.a(str));
        this.f64875c.put(str, kVarCreate);
        return kVarCreate;
    }
}
