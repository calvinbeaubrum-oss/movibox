package com.cloud.tmc.kernel.coreimpl;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.cloud.tmc.kernel.engine.EngineRouter;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.utils.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.ConcurrentHashMap;
import zc.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class DefaultEngineRouter implements EngineRouter {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final String f31154g = "TmcEngine:" + DefaultEngineRouter.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f31155a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, gd.b> f31156b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Stack<gd.b> f31157c = new Stack<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, i> f31158d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Stack<i> f31159e = new Stack<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map<String, List<EngineRouter.a>> f31160f;

    public final void a(i iVar) {
        if (iVar != null) {
            String strB = iVar.b();
            if (TextUtils.isEmpty(strB)) {
                return;
            }
            synchronized (this.f31155a) {
                try {
                    if (!c.b(this.f31160f)) {
                        List<EngineRouter.a> list = this.f31160f.get(strB);
                        if (!c.a(list)) {
                            Iterator<EngineRouter.a> it = list.iterator();
                            while (it.hasNext()) {
                                it.next().a(iVar);
                            }
                        }
                        this.f31160f.remove(strB);
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // com.cloud.tmc.kernel.engine.EngineRouter
    public void destroy() {
        Collection<gd.b> collectionValues = this.f31156b.values();
        Iterator<gd.b> it = collectionValues.iterator();
        while (it.hasNext()) {
            it.next().destroy();
        }
        this.f31156b.clear();
        this.f31158d.clear();
        this.f31159e.clear();
        collectionValues.clear();
        this.f31157c.clear();
        synchronized (this.f31155a) {
            try {
                Map<String, List<EngineRouter.a>> map = this.f31160f;
                if (map != null) {
                    map.clear();
                }
                this.f31160f = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.cloud.tmc.kernel.engine.EngineRouter
    public List<i> getRegisteredRender() {
        ArrayList arrayList;
        synchronized (this.f31159e) {
            arrayList = new ArrayList(this.f31159e);
        }
        return arrayList;
    }

    @Override // com.cloud.tmc.kernel.engine.EngineRouter
    public i getRenderById(String str) {
        synchronized (this.f31159e) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return this.f31158d.get(str);
                }
                if (this.f31159e.size() <= 0) {
                    return null;
                }
                return this.f31159e.peek();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.cloud.tmc.kernel.engine.EngineRouter
    public i getTopRender() {
        if (this.f31159e.size() > 0) {
            return this.f31159e.peek();
        }
        return null;
    }

    @Override // com.cloud.tmc.kernel.engine.EngineRouter
    @Nullable
    public gd.b getWorkerById(String str) {
        synchronized (this.f31157c) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    return this.f31156b.get(str);
                }
                if (this.f31157c.size() <= 0) {
                    return null;
                }
                return this.f31157c.peek();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.cloud.tmc.kernel.engine.EngineRouter
    public void registerRender(String str, i iVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f31159e) {
            try {
                if (this.f31158d.containsKey(str)) {
                    TmcLogger.c(f31154g, "DefaultEngineRouter has sample worker " + str);
                } else {
                    this.f31158d.put(str, iVar);
                    this.f31159e.push(iVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        a(iVar);
    }

    @Override // com.cloud.tmc.kernel.engine.EngineRouter
    public void registerRenderInitListener(String str, EngineRouter.a aVar) {
        synchronized (this.f31155a) {
            try {
                if (this.f31160f == null) {
                    this.f31160f = new HashMap();
                }
                if (!this.f31160f.containsKey(str)) {
                    this.f31160f.put(str, new LinkedList());
                }
                this.f31160f.get(str).add(aVar);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.cloud.tmc.kernel.engine.EngineRouter
    public void registerWorker(gd.b bVar) {
        if (bVar == null) {
            return;
        }
        registerWorker(bVar.getWorkerId(), bVar);
    }

    @Override // com.cloud.tmc.kernel.engine.EngineRouter
    public void registerWorker(String str, gd.b bVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f31157c) {
            try {
                if (this.f31156b.containsKey(str)) {
                    TmcLogger.c(f31154g, "DefaultEngineRouter has sample worker " + str);
                } else {
                    this.f31156b.put(str, bVar);
                    this.f31157c.push(bVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.cloud.tmc.kernel.engine.EngineRouter
    public void resetRenderToTop(i iVar) {
        TmcLogger.c(f31154g, "resetIRenderToTop: " + iVar);
        if (iVar == null) {
            return;
        }
        synchronized (this.f31159e) {
            try {
                if (this.f31159e.remove(iVar)) {
                    this.f31159e.push(iVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.cloud.tmc.kernel.engine.EngineRouter
    public void unRegisterRender(String str) {
        TmcLogger.c(f31154g, "unRegisterIRender: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f31159e) {
            try {
                i iVar = this.f31158d.get(str);
                if (iVar != null) {
                    this.f31158d.remove(str);
                    this.f31159e.remove(iVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // com.cloud.tmc.kernel.engine.EngineRouter
    public void unRegisterWorker(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f31157c) {
            try {
                TmcLogger.c(f31154g, "unRegisterWorker: " + str);
                gd.b bVar = this.f31156b.get(str);
                if (bVar != null) {
                    this.f31156b.remove(str);
                    this.f31157c.remove(bVar);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
