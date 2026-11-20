package lc;

import androidx.annotation.Nullable;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.extension.f;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class b implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<Class<? extends com.cloud.tmc.kernel.extension.c>> f70214b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, List<c>> f70215c = new HashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, List<Class<? extends com.cloud.tmc.kernel.extension.c>>> f70216d = new HashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Class<? extends com.cloud.tmc.kernel.node.d>> f70217e = new HashMap();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<c> f70218f = new LinkedList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f70213a = new a();

    @Override // com.cloud.tmc.kernel.extension.f
    public jc.a a(String str) {
        return this.f70213a.b(str);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0029 A[Catch: all -> 0x001e, TRY_LEAVE, TryCatch #1 {all -> 0x001e, blocks: (B:3:0x0001, B:12:0x0021, B:14:0x0029, B:17:0x0046, B:18:0x0048, B:30:0x0078, B:31:0x0080, B:33:0x0086, B:35:0x009a, B:36:0x009f, B:37:0x00ac, B:41:0x00b2, B:9:0x0014, B:5:0x0009, B:19:0x0049, B:21:0x0051, B:22:0x006c, B:27:0x0071, B:28:0x0076), top: B:46:0x0001, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:17:0x0046 A[Catch: all -> 0x001e, TRY_ENTER, TryCatch #1 {all -> 0x001e, blocks: (B:3:0x0001, B:12:0x0021, B:14:0x0029, B:17:0x0046, B:18:0x0048, B:30:0x0078, B:31:0x0080, B:33:0x0086, B:35:0x009a, B:36:0x009f, B:37:0x00ac, B:41:0x00b2, B:9:0x0014, B:5:0x0009, B:19:0x0049, B:21:0x0051, B:22:0x006c, B:27:0x0071, B:28:0x0076), top: B:46:0x0001, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:21:0x0051 A[Catch: all -> 0x006f, TryCatch #2 {, blocks: (B:19:0x0049, B:21:0x0051, B:22:0x006c, B:27:0x0071, B:28:0x0076), top: B:47:0x0049, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:27:0x0071 A[Catch: all -> 0x006f, TRY_ENTER, TryCatch #2 {, blocks: (B:19:0x0049, B:21:0x0051, B:22:0x006c, B:27:0x0071, B:28:0x0076), top: B:47:0x0049, outer: #1 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0086 A[Catch: all -> 0x001e, TryCatch #1 {all -> 0x001e, blocks: (B:3:0x0001, B:12:0x0021, B:14:0x0029, B:17:0x0046, B:18:0x0048, B:30:0x0078, B:31:0x0080, B:33:0x0086, B:35:0x009a, B:36:0x009f, B:37:0x00ac, B:41:0x00b2, B:9:0x0014, B:5:0x0009, B:19:0x0049, B:21:0x0051, B:22:0x006c, B:27:0x0071, B:28:0x0076), top: B:46:0x0001, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:35:0x009a A[Catch: all -> 0x001e, TryCatch #1 {all -> 0x001e, blocks: (B:3:0x0001, B:12:0x0021, B:14:0x0029, B:17:0x0046, B:18:0x0048, B:30:0x0078, B:31:0x0080, B:33:0x0086, B:35:0x009a, B:36:0x009f, B:37:0x00ac, B:41:0x00b2, B:9:0x0014, B:5:0x0009, B:19:0x0049, B:21:0x0051, B:22:0x006c, B:27:0x0071, B:28:0x0076), top: B:46:0x0001, inners: #0, #2 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0049 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x009f A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:14:0x0029, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:21:0x0051, please report this as an issue */
    @Override // com.cloud.tmc.kernel.extension.f
    public synchronized void b(Class<? extends com.cloud.tmc.kernel.extension.c> cls, Class<? extends com.cloud.tmc.kernel.node.d> cls2) {
        List<Class<? extends com.cloud.tmc.kernel.extension.c>> linkedList;
        try {
            if (!BridgeExtension.class.isAssignableFrom(cls)) {
                if (!com.cloud.tmc.kernel.extension.c.class.isAssignableFrom(cls)) {
                    TmcLogger.f("TmcKernel:DefaultExtensionRegistry", "Class " + cls + " is not valid extension");
                    return;
                }
                synchronized (this.f70214b) {
                    if (this.f70214b.contains(cls)) {
                        TmcLogger.f("TmcKernel:DefaultExtensionRegistry", "Extension " + cls + " is already registered");
                        return;
                    }
                    this.f70214b.add(cls);
                    for (Class<? extends com.cloud.tmc.kernel.extension.c> cls3 : f(cls, null)) {
                        linkedList = this.f70216d.get(cls3.getName());
                        if (linkedList == null) {
                            linkedList = new LinkedList<>();
                        }
                        linkedList.add(cls);
                        this.f70216d.put(cls3.getName(), linkedList);
                    }
                    h(cls, cls2);
                    return;
                }
            }
            try {
                this.f70213a.f(cls);
                h(cls, cls2);
                return;
            } catch (Throwable th2) {
                TmcLogger.p("TmcKernel:DefaultExtensionRegistry", cls.getSimpleName(), th2);
                if (!com.cloud.tmc.kernel.extension.c.class.isAssignableFrom(cls)) {
                    TmcLogger.f("TmcKernel:DefaultExtensionRegistry", "Class " + cls + " is not valid extension");
                    return;
                }
                synchronized (this.f70214b) {
                    if (this.f70214b.contains(cls)) {
                        TmcLogger.f("TmcKernel:DefaultExtensionRegistry", "Extension " + cls + " is already registered");
                        return;
                    }
                    this.f70214b.add(cls);
                    while (r0.hasNext()) {
                        linkedList = this.f70216d.get(cls3.getName());
                        if (linkedList == null) {
                            linkedList = new LinkedList<>();
                        }
                        linkedList.add(cls);
                        this.f70216d.put(cls3.getName(), linkedList);
                    }
                    h(cls, cls2);
                    return;
                }
            }
        } catch (Throwable th3) {
            throw th3;
        }
        throw th3;
    }

    @Override // com.cloud.tmc.kernel.extension.f
    public Class<? extends com.cloud.tmc.kernel.node.d> c(Class<? extends com.cloud.tmc.kernel.extension.c> cls) {
        return g(cls.getName());
    }

    @Override // com.cloud.tmc.kernel.extension.f
    public int d() {
        return this.f70213a.d();
    }

    @Override // com.cloud.tmc.kernel.extension.f
    @Nullable
    public List<Class<? extends com.cloud.tmc.kernel.extension.c>> e(String str) {
        List<c> list = this.f70215c.get(str);
        if (list != null) {
            for (c cVar : list) {
                Class<? extends com.cloud.tmc.kernel.extension.c> clsA = com.cloud.tmc.kernel.utils.b.a(cVar.f70219a, cVar.f70220b);
                if (clsA == null) {
                    TmcLogger.f("TmcKernel:DefaultExtensionRegistry", "load meta " + cVar.f70220b + " error!");
                } else {
                    synchronized (this.f70214b) {
                        try {
                            if (!this.f70214b.contains(clsA)) {
                                b(clsA, cVar.f70221c);
                            }
                        } catch (Throwable th2) {
                            throw th2;
                        }
                    }
                }
            }
            this.f70215c.remove(str);
        }
        return this.f70216d.get(str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final List<Class<? extends com.cloud.tmc.kernel.extension.c>> f(Class<? extends com.cloud.tmc.kernel.extension.c> cls, List<Class<? extends com.cloud.tmc.kernel.extension.c>> list) {
        List<Class<? extends com.cloud.tmc.kernel.extension.c>> linkedList = list;
        if (list == null) {
            linkedList = new LinkedList();
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            if (com.cloud.tmc.kernel.extension.c.class.isAssignableFrom(cls2)) {
                linkedList.add(cls2);
            }
        }
        return com.cloud.tmc.kernel.extension.c.class.isAssignableFrom(cls.getSuperclass()) ? f(cls.getSuperclass(), linkedList) : linkedList;
    }

    public Class<? extends com.cloud.tmc.kernel.node.d> g(String str) {
        return this.f70217e.get(str);
    }

    public final void h(Class<? extends com.cloud.tmc.kernel.extension.c> cls, Class<? extends com.cloud.tmc.kernel.node.d> cls2) {
        i(cls.getName(), cls2);
    }

    public final void i(String str, Class<? extends com.cloud.tmc.kernel.node.d> cls) {
        if (this.f70217e.containsKey(str)) {
            return;
        }
        this.f70217e.put(str, cls);
    }
}
