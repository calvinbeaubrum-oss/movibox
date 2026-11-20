package lc;

import android.text.TextUtils;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.service.ConfigService;
import com.cloud.tmc.kernel.utils.g;
import com.google.gson.JsonArray;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, jc.a> f70209a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<Class<? extends BridgeExtension>> f70210b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, c> f70211c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Set<String> f70212d = null;

    public final void a(Class<? extends BridgeExtension> cls) {
        if (cls == null) {
            throw new IllegalArgumentException("extension is null");
        }
        if (this.f70210b.contains(cls)) {
            throw new IllegalArgumentException("extension has registered");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public jc.a b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (this.f70209a.get(str) == null) {
            synchronized (this.f70209a) {
                try {
                    if (this.f70209a.get(str) == null && this.f70211c.containsKey(str)) {
                        TmcLogger.c("TmcKernel:BridgeExtensionRegistry", "findActionMeta lazy init " + str);
                        c cVar = this.f70211c.get(str);
                        Class<? extends com.cloud.tmc.kernel.extension.c> clsA = com.cloud.tmc.kernel.utils.b.a(cVar.f70219a, cVar.f70220b);
                        if (clsA == null) {
                            return null;
                        }
                        f(clsA);
                        this.f70211c.remove(str);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return this.f70209a.get(str);
    }

    public final Set<String> c() {
        if (this.f70212d == null) {
            synchronized (this) {
                try {
                    if (this.f70212d != null) {
                        ConfigService configService = (ConfigService) tc.a.a(ConfigService.class);
                        JsonArray jsonArrayA = configService != null ? g.a(configService.getConfigJsonObject("h5_jsapiandPluginsConfig"), "extensions", null) : null;
                        if (jsonArrayA == null || jsonArrayA.size() == 0) {
                            this.f70212d = Collections.emptySet();
                        } else {
                            this.f70212d = new HashSet();
                            int size = jsonArrayA.size();
                            for (int i11 = 0; i11 < size; i11++) {
                                this.f70212d.add(jsonArrayA.get(i11).getAsString());
                            }
                        }
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return this.f70212d;
    }

    public int d() {
        return this.f70209a.size() + this.f70211c.size();
    }

    public final List<jc.a> e(Class<? extends BridgeExtension> cls) {
        Method[] declaredMethods;
        ArrayList arrayList = new ArrayList();
        if (cls != null && cls.getDeclaredMethods() != null) {
            if (cls.getSuperclass() == null || !BridgeExtension.class.isAssignableFrom(cls.getSuperclass())) {
                declaredMethods = cls.getDeclaredMethods();
            } else {
                TmcLogger.c("TmcKernel:BridgeExtensionRegistry", "initActionMeta found has super BridgeExtension, getAllMethods!");
                declaredMethods = cls.getMethods();
            }
            Set<String> setC = c();
            for (Method method : declaredMethods) {
                try {
                    if (!method.isAccessible()) {
                        method.setAccessible(true);
                    }
                    zb.a aVar = (zb.a) method.getAnnotation(zb.a.class);
                    if (aVar != null) {
                        String strValue = aVar.value();
                        if (strValue == null || strValue.length() <= 0) {
                            strValue = method.getName();
                        }
                        if (setC == null || !setC.contains(strValue)) {
                            jc.a aVar2 = new jc.a();
                            aVar2.f67978c = method;
                            aVar2.f67977b = cls;
                            aVar2.f67976a = strValue;
                            if (!this.f70209a.containsKey(strValue)) {
                                arrayList.add(aVar2);
                            } else if (aVar.canOverride()) {
                                this.f70209a.remove(strValue);
                                TmcLogger.o("TmcKernel:BridgeExtensionRegistry", "initActionMeta BridgeExtension action [" + strValue + "] override by " + cls.getName());
                                arrayList.add(aVar2);
                            } else {
                                TmcLogger.o("TmcKernel:BridgeExtensionRegistry", "BridgeExtension action [" + strValue + "] is not allow duplicate register");
                            }
                        } else {
                            TmcLogger.c("TmcKernel:BridgeExtensionRegistry", "ignore action:\t" + strValue);
                        }
                    }
                } catch (Throwable th2) {
                    TmcLogger.p("TmcKernel:BridgeExtensionRegistry", "initActionMeta " + method + " exception!", th2);
                }
            }
        }
        return arrayList;
    }

    public void f(Class<? extends BridgeExtension> cls) {
        a(cls);
        List<jc.a> listE = e(cls);
        if (listE == null || listE.isEmpty()) {
            TmcLogger.o("TmcKernel:BridgeExtensionRegistry", "action method not found in bridgeExtension: " + cls);
            return;
        }
        for (jc.a aVar : listE) {
            TmcLogger.c("TmcKernel:BridgeExtensionRegistry", "register " + aVar);
            this.f70209a.put(aVar.f67976a, aVar);
        }
        this.f70210b.add(cls);
    }
}
