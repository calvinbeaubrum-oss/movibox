package kb;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.minicover.NativeComponentProxy;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import zc.i;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@SourceDebugExtension
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f68517a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f68518b = "NativeComponentManager";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, CopyOnWriteArrayList<String>> f68519c = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap<String, CopyOnWriteArrayList<String>> f68520d = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<String, pc.a> f68521e = new ConcurrentHashMap<>();

    public final void a(String appId, String renderId) {
        Intrinsics.g(appId, "appId");
        Intrinsics.g(renderId, "renderId");
        try {
            ConcurrentHashMap<String, CopyOnWriteArrayList<String>> concurrentHashMap = f68519c;
            CopyOnWriteArrayList<String> copyOnWriteArrayList = concurrentHashMap.get(appId);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            }
            if (!copyOnWriteArrayList.contains(renderId)) {
                copyOnWriteArrayList.add(renderId);
            }
            concurrentHashMap.put(appId, copyOnWriteArrayList);
        } catch (Throwable th2) {
            Log.e(f68518b, "addAppId: " + th2);
        }
    }

    public final pc.a b(Context context, String viewId, String renderId, String componentName, i iRender) {
        Intrinsics.g(context, "context");
        Intrinsics.g(viewId, "viewId");
        Intrinsics.g(renderId, "renderId");
        Intrinsics.g(componentName, "componentName");
        Intrinsics.g(iRender, "iRender");
        ConcurrentHashMap<String, CopyOnWriteArrayList<String>> concurrentHashMap = f68520d;
        CopyOnWriteArrayList<String> copyOnWriteArrayList = concurrentHashMap.get(renderId);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        }
        if (!copyOnWriteArrayList.contains(viewId)) {
            copyOnWriteArrayList.add(viewId);
        }
        concurrentHashMap.put(renderId, copyOnWriteArrayList);
        ConcurrentHashMap<String, pc.a> concurrentHashMap2 = f68521e;
        if (concurrentHashMap2.get(viewId) != null) {
            TmcLogger.c(f68518b, "nativeComponent not null " + viewId);
            return null;
        }
        pc.a aVarD = d(context, componentName, renderId, viewId, iRender);
        if (aVarD != null) {
            concurrentHashMap2.put(viewId, aVarD);
            return aVarD;
        }
        TmcLogger.c(f68518b, "component null " + viewId);
        return null;
    }

    public final pc.a c(String viewId) {
        Intrinsics.g(viewId, "viewId");
        return f68521e.get(viewId);
    }

    public final pc.a d(Context context, String str, String str2, String str3, i iVar) {
        int iHashCode = str.hashCode();
        if (iHashCode != -1616353213) {
            if (iHashCode != -1191927585) {
                if (iHashCode == 1304059941 && str.equals("native-image")) {
                    return ((NativeComponentProxy) tc.a.a(NativeComponentProxy.class)).getComponentNativeImgInstance(context, str2, str3, iVar);
                }
            } else if (str.equals("native-tab")) {
                return ((NativeComponentProxy) tc.a.a(NativeComponentProxy.class)).getComponentNativeTabInstance(context, str2, str3, iVar);
            }
        } else if (str.equals("native-webview")) {
            return ((NativeComponentProxy) tc.a.a(NativeComponentProxy.class)).getComponentNativeWebViewInstance(context, str2, str3, iVar);
        }
        return null;
    }

    public final void e(String str, String str2) {
        j(str, str2);
    }

    public final void f(String renderId) {
        Intrinsics.g(renderId, "renderId");
        try {
            CopyOnWriteArrayList<String> copyOnWriteArrayList = f68520d.get(renderId);
            if (copyOnWriteArrayList != null) {
                Iterator<T> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    pc.a aVar = f68521e.get((String) it.next());
                    if (aVar != null) {
                        aVar.onPause();
                    }
                }
            }
        } catch (Throwable th2) {
            TmcLogger.g(f68518b, "onPauseForRenderId", th2);
        }
    }

    public final void g(String renderId) {
        Intrinsics.g(renderId, "renderId");
        try {
            CopyOnWriteArrayList<String> copyOnWriteArrayList = f68520d.get(renderId);
            if (copyOnWriteArrayList != null) {
                Iterator<T> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    pc.a aVar = f68521e.get((String) it.next());
                    if (aVar != null) {
                        aVar.onResume();
                    }
                }
            }
        } catch (Throwable th2) {
            Log.e(f68518b, "onResumeForRenderId: " + th2);
        }
    }

    public final void h(String renderId) {
        Intrinsics.g(renderId, "renderId");
        try {
            CopyOnWriteArrayList<String> copyOnWriteArrayList = f68520d.get(renderId);
            if (copyOnWriteArrayList != null) {
                Iterator<T> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    pc.a aVar = f68521e.get((String) it.next());
                    if (aVar != null) {
                        aVar.onStop();
                    }
                }
            }
        } catch (Throwable th2) {
            TmcLogger.g(f68518b, "onStopForRenderId", th2);
        }
    }

    public final void i(String appId) {
        Intrinsics.g(appId, "appId");
        try {
            CopyOnWriteArrayList<String> copyOnWriteArrayList = f68519c.get(appId);
            if (copyOnWriteArrayList != null) {
                Iterator<T> it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    f68517a.j(appId, (String) it.next());
                }
            }
            f68519c.remove(appId);
        } catch (Throwable th2) {
            Log.e(f68518b, "removeForAppId: " + th2);
        }
    }

    public final void j(String str, String str2) {
        i iVarH;
        if (str2 != null) {
            try {
                if (str2.length() == 0) {
                    return;
                }
                CopyOnWriteArrayList<String> copyOnWriteArrayList = f68520d.get(str2);
                if (copyOnWriteArrayList != null) {
                    for (String str3 : copyOnWriteArrayList) {
                        ConcurrentHashMap<String, pc.a> concurrentHashMap = f68521e;
                        pc.a aVar = concurrentHashMap.get(str3);
                        if (aVar != null && (iVarH = aVar.h()) != null) {
                            ViewParent parent = aVar.g().getParent();
                            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                            if (viewGroup != null) {
                                viewGroup.removeView(aVar.g());
                            }
                            aVar.c();
                            aVar.f();
                            oc.a.h(oc.a.f72395a, iVarH, "removeNativeCover", aVar.a(), aVar.a(), null, null, 48, null);
                        }
                        concurrentHashMap.remove(str3);
                    }
                }
                f68520d.remove(str2);
                CopyOnWriteArrayList<String> copyOnWriteArrayList2 = f68519c.get(str);
                if (copyOnWriteArrayList2 != null) {
                    copyOnWriteArrayList2.remove(str2);
                }
            } catch (Throwable th2) {
                TmcLogger.h(f68518b, th2);
            }
        }
    }

    public final String k(WebView webView, String viewId, String renderId) {
        Intrinsics.g(viewId, "viewId");
        Intrinsics.g(renderId, "renderId");
        String strA = "";
        try {
            ConcurrentHashMap<String, pc.a> concurrentHashMap = f68521e;
            pc.a aVar = concurrentHashMap.get(viewId);
            if (aVar != null) {
                strA = aVar.a();
                ViewParent parent = aVar.g().getParent();
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                if (viewGroup != null) {
                    viewGroup.removeView(aVar.g());
                }
                aVar.c();
                aVar.f();
            }
            CopyOnWriteArrayList<String> copyOnWriteArrayList = f68520d.get(renderId);
            if (copyOnWriteArrayList != null) {
                copyOnWriteArrayList.remove(viewId);
            }
            concurrentHashMap.remove(viewId);
        } catch (Throwable th2) {
            Log.e(f68518b, "removeNativeComponent: " + th2);
        }
        return strA;
    }

    public final boolean l(String renderId) {
        Intrinsics.g(renderId, "renderId");
        CopyOnWriteArrayList<String> copyOnWriteArrayList = f68520d.get(renderId);
        boolean zBooleanValue = false;
        if (copyOnWriteArrayList != null) {
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                pc.a aVar = f68521e.get((String) it.next());
                Boolean boolValueOf = aVar != null ? Boolean.valueOf(aVar.m()) : null;
                if (Intrinsics.b(boolValueOf, Boolean.TRUE)) {
                    zBooleanValue = boolValueOf.booleanValue();
                }
            }
        }
        return zBooleanValue;
    }
}
