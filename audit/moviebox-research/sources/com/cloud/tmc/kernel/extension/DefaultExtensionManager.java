package com.cloud.tmc.kernel.extension;

import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.node.Node;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class DefaultExtensionManager implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public f f31187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Class<? extends c>, d> f31188b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Class<? extends c>, Comparator> f31189c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, c> f31190d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<Node, Map<String, c>> f31191e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<Node, Map<Class<? extends c>, List<c>>> f31192f = new HashMap();

    public DefaultExtensionManager(f fVar) {
        this.f31187a = fVar;
    }

    public static c h(Class<? extends c> cls) throws IllegalAccessException, InstantiationException {
        TmcLogger.c("TmcKernel:ExtensionManager", "createExtensionInstance " + cls.getName());
        c cVarNewInstance = cls.newInstance();
        cVarNewInstance.onInitialized();
        return cVarNewInstance;
    }

    public static c k(Map<String, c> map, Class<? extends c> cls) {
        if (map == null || cls == null) {
            return null;
        }
        c cVarH = map.get(cls.getName());
        if (cVarH != null) {
            return cVarH;
        }
        try {
            cVarH = h(cls);
            map.put(cls.getName(), cVarH);
            return cVarH;
        } catch (Throwable th2) {
            TmcLogger.g("TmcKernel:ExtensionManager", cls + " failed to initialize", th2);
            return cVarH;
        }
    }

    @Override // com.cloud.tmc.kernel.extension.e
    public jc.a a(String str) {
        return this.f31187a.a(str);
    }

    @Override // com.cloud.tmc.kernel.extension.e
    public List<c> b(Node node, Class<? extends c> cls) {
        if (this.f31187a == null) {
            throw new RuntimeException("ExtensionRegistry not setup");
        }
        TmcLogger.c("TmcKernel:ExtensionManager", "getExtensionByPoint " + cls.getName());
        List<c> arrayList = new ArrayList<>();
        List<? extends c> listI = i(node, cls);
        if (listI != null) {
            arrayList.addAll(listI);
        }
        List<c> listJ = j(node, cls);
        if (listJ != null) {
            arrayList.addAll(listJ);
        }
        if (arrayList.isEmpty()) {
            TmcLogger.o("TmcKernel:ExtensionManager", "cannot find extension by point: " + cls);
            return null;
        }
        d dVar = this.f31188b.get(cls);
        if (dVar != null) {
            arrayList = dVar.a(arrayList);
        }
        Comparator comparator = this.f31189c.get(cls);
        if (comparator != null) {
            Collections.sort(arrayList, comparator);
        } else if (h.class.isAssignableFrom(cls)) {
            Collections.sort(arrayList, new Comparator<c>() { // from class: com.cloud.tmc.kernel.extension.DefaultExtensionManager.1
                @Override // java.util.Comparator
                public int compare(c cVar, c cVar2) {
                    return (g.class.isAssignableFrom(cVar2.getClass()) ? ((g) cVar2).priority() : 0) - (g.class.isAssignableFrom(cVar.getClass()) ? ((g) cVar).priority() : 0);
                }
            });
        }
        return arrayList;
    }

    @Override // com.cloud.tmc.kernel.extension.e
    public synchronized void c(Node node) {
        try {
            TmcLogger.c("TmcKernel:ExtensionManager", "exitNode " + node);
            Map<String, c> mapRemove = this.f31191e.remove(node);
            if (mapRemove != null) {
                for (c cVar : mapRemove.values()) {
                    TmcLogger.d("TmcKernel:ExtensionManager", "exitNode finalize" + cVar);
                    cVar.onFinalized();
                }
                mapRemove.clear();
            }
            Map<Class<? extends c>, List<c>> mapRemove2 = this.f31192f.remove(node);
            if (mapRemove2 != null) {
                Iterator<List<c>> it = mapRemove2.values().iterator();
                while (it.hasNext()) {
                    for (c cVar2 : it.next()) {
                        TmcLogger.d("TmcKernel:ExtensionManager", "exitNode finalize" + cVar2);
                        cVar2.onFinalized();
                    }
                }
                mapRemove2.clear();
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.cloud.tmc.kernel.extension.e
    public synchronized void d(Node node) {
        TmcLogger.c("TmcKernel:ExtensionManager", "enterNode " + node);
        this.f31191e.put(node, new HashMap());
    }

    @Override // com.cloud.tmc.kernel.extension.e
    public f e() {
        return this.f31187a;
    }

    @Override // com.cloud.tmc.kernel.extension.e
    public synchronized BridgeExtension f(String str) {
        BridgeExtension bridgeExtension;
        jc.a aVarA = this.f31187a.a(str);
        if (aVarA == null) {
            return null;
        }
        BridgeExtension bridgeExtension2 = (BridgeExtension) this.f31190d.get(aVarA.f67977b.getName());
        if (bridgeExtension2 != null) {
            return bridgeExtension2;
        }
        try {
            bridgeExtension = (BridgeExtension) h(aVarA.f67977b);
            try {
                this.f31190d.put(aVarA.f67977b.getName(), bridgeExtension);
            } catch (Throwable th2) {
                th = th2;
                bridgeExtension2 = bridgeExtension;
                TmcLogger.h("TmcKernel:ExtensionManager", th);
                bridgeExtension = bridgeExtension2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
        return bridgeExtension;
    }

    @Override // com.cloud.tmc.kernel.extension.e
    public synchronized BridgeExtension g(Node node, String str) throws IllegalAccessException, InstantiationException {
        try {
            if (node == null) {
                return f(str);
            }
            jc.a aVarA = this.f31187a.a(str);
            if (aVarA != null) {
                Class<? extends com.cloud.tmc.kernel.node.d> clsC = this.f31187a.c(aVarA.f67977b);
                if (clsC == null) {
                    return f(str);
                }
                if (!clsC.isAssignableFrom(node.getClass())) {
                    return g(node.getParentNode(), str);
                }
                Map map = this.f31191e.get(node);
                if (map != null) {
                    if (map.get(aVarA.f67977b.getName()) != null) {
                        return (BridgeExtension) map.get(aVarA.f67977b.getName());
                    }
                    BridgeExtension bridgeExtension = (BridgeExtension) h(aVarA.f67977b);
                    map.put(aVarA.f67977b.getName(), bridgeExtension);
                    return bridgeExtension;
                }
            }
            return null;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized List<? extends c> i(Node node, Class<? extends c> cls) {
        c cVarK;
        try {
            List<Class<? extends c>> listE = this.f31187a.e(cls.getName());
            if (listE == null) {
                return null;
            }
            LinkedList linkedList = new LinkedList();
            for (Class<? extends c> cls2 : listE) {
                Class<? extends com.cloud.tmc.kernel.node.d> clsC = this.f31187a.c(cls2);
                if (clsC == null) {
                    c cVarK2 = k(this.f31190d, cls2);
                    if (cVarK2 != null) {
                        linkedList.add(cVarK2);
                    }
                } else {
                    Node parentNode = node;
                    while (parentNode != null && !clsC.isAssignableFrom(parentNode.getClass())) {
                        parentNode = parentNode.getParentNode();
                    }
                    if (parentNode != null && (cVarK = k(this.f31191e.get(parentNode), cls2)) != null) {
                        linkedList.add(cVarK);
                    }
                }
            }
            return linkedList;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final List<c> j(Node node, Class<? extends c> cls) {
        List<c> list;
        ArrayList arrayList = new ArrayList();
        while (node != null) {
            if (this.f31192f.get(node) != null && (list = this.f31192f.get(node).get(cls)) != null) {
                arrayList.addAll(list);
            }
            node = node.getParentNode();
        }
        return arrayList;
    }

    public Map<Node, Map<String, c>> l() {
        return this.f31191e;
    }
}
