package ic;

import com.cloud.tmc.kernel.engine.IEngine;
import com.cloud.tmc.kernel.log.TmcLogger;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f67185b = "TmcEngine:EngineStack";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static c f67186c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<String, Stack<WeakReference<IEngine>>> f67187a = new HashMap();

    public static c a() {
        if (f67186c == null) {
            f67186c = new c();
        }
        return f67186c;
    }

    public final Stack<WeakReference<IEngine>> b(String str) {
        Stack<WeakReference<IEngine>> stack;
        synchronized (this) {
            try {
                stack = this.f67187a.get(str);
                if (stack == null) {
                    stack = new Stack<>();
                    this.f67187a.put(str, stack);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return stack;
    }

    public void c(IEngine iEngine) {
        if (iEngine == null) {
            TmcLogger.c(f67185b, "push  empty engineProxy");
            return;
        }
        TmcLogger.c(f67185b, "push proxy appId=" + iEngine.getAppId() + " ,appinstanceid =" + iEngine.getInstanceId() + " , obj=" + iEngine.hashCode() + " targetType=" + iEngine.getClass());
        synchronized (this) {
            b(iEngine.getEngineType()).push(new WeakReference<>(iEngine));
        }
    }

    public void d(IEngine iEngine) {
        if (iEngine == null) {
            TmcLogger.c(f67185b, "reomve  empty engineProxy");
            return;
        }
        TmcLogger.c(f67185b, "remove proxy appId=" + iEngine.getAppId() + " , obj=" + iEngine.hashCode() + " targetType=" + iEngine.getClass());
        synchronized (this) {
            try {
                Stack<WeakReference<IEngine>> stackB = b(iEngine.getEngineType());
                if (stackB.isEmpty()) {
                    return;
                }
                WeakReference<IEngine> weakReference = null;
                for (WeakReference<IEngine> weakReference2 : stackB) {
                    if (weakReference2 != null && weakReference2.get() == iEngine) {
                        weakReference = weakReference2;
                    }
                }
                if (weakReference != null) {
                    stackB.remove(weakReference);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
