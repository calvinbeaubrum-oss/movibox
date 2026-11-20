package gb;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.invoke.ExtensionInvokerFactory;
import com.cloud.tmc.integration.invoke.b;
import com.cloud.tmc.kernel.bridge.NativeCallContext;
import com.cloud.tmc.kernel.extension.BridgeExtension;
import com.cloud.tmc.kernel.extension.e;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.security.AccessControlException;
import fb.d;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f65470b = "TmcEngine:" + a.class.getSimpleName();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile a f65471c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f65472a;

    public static a f() {
        if (f65471c == null) {
            synchronized (a.class) {
                try {
                    if (f65471c == null) {
                        f65471c = new a();
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
        return f65471c;
    }

    public void a(e eVar) {
        this.f65472a = eVar;
    }

    public boolean b(NativeCallContext nativeCallContext, mc.a aVar, boolean z11) {
        return c(nativeCallContext, aVar, z11, this.f65472a);
    }

    public boolean c(NativeCallContext nativeCallContext, mc.a aVar, boolean z11, e eVar) {
        return d(nativeCallContext, aVar, z11, eVar, null);
    }

    public boolean d(NativeCallContext nativeCallContext, mc.a aVar, boolean z11, e eVar, @Nullable rc.a aVar2) {
        if (TextUtils.isEmpty(nativeCallContext.getName())) {
            TmcLogger.o(f65470b, "BridgeDispatcher dispatch context.getName() == null!");
            return false;
        }
        jc.a aVarA = eVar.a(nativeCallContext.getName());
        if (aVarA == null) {
            TmcLogger.o(f65470b, "BridgeDispatcher dispatch findActionMeta == null!\t" + nativeCallContext.getName());
            return false;
        }
        try {
            BridgeExtension bridgeExtensionG = eVar.g(nativeCallContext.getNode(), nativeCallContext.getName());
            if (bridgeExtensionG == null) {
                TmcLogger.o(f65470b, "BridgeDispatcher dispatch getBridgeExtensionByAction == null!");
                return false;
            }
            d dVar = new d(nativeCallContext, aVar, eVar);
            ed.a aVar3 = new ed.a();
            aVar3.a(dVar);
            if (aVar != null) {
                aVar.f();
            }
            ExtensionInvokerFactory extensionInvokerFactory = (ExtensionInvokerFactory) tc.a.a(ExtensionInvokerFactory.class);
            com.cloud.tmc.integration.invoke.d dVarCreatePermissionExtensionInvoker = z11 ? extensionInvokerFactory.createPermissionExtensionInvoker(aVar3, new com.cloud.tmc.integration.invoke.e(aVar, extensionInvokerFactory.createScheduleExtensionInvoker(new b(nativeCallContext.getNode(), nativeCallContext, aVar)))) : extensionInvokerFactory.createScheduleExtensionInvoker(new b(nativeCallContext.getNode(), nativeCallContext, aVar, aVar2));
            dVarCreatePermissionExtensionInvoker.a(bridgeExtensionG);
            try {
                Method method = aVarA.f67978c;
                dVarCreatePermissionExtensionInvoker.invoke(bridgeExtensionG, method, new Object[method.getParameterTypes().length]);
                return true;
            } catch (AccessControlException e11) {
                if (aVar != null) {
                    aVar.m();
                }
                TmcLogger.g(f65470b, "bridge extension fail AccessControlException:", e11);
                return true;
            } catch (Throwable th2) {
                if (aVar != null) {
                    aVar.l(3, th2.getMessage());
                }
                TmcLogger.g(f65470b, "bridge extension fail Throwable:", th2);
                return true;
            }
        } catch (Throwable th3) {
            TmcLogger.g(f65470b, "dispatch BridgeExtension error", th3);
            return false;
        }
    }

    public e e() {
        return this.f65472a;
    }
}
