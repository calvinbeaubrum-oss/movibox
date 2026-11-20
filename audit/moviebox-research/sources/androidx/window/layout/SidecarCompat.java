package androidx.window.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.IBinder;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.window.core.Version;
import androidx.window.sidecar.SidecarDeviceState;
import androidx.window.sidecar.SidecarDisplayFeature;
import androidx.window.sidecar.SidecarInterface;
import androidx.window.sidecar.SidecarProvider;
import androidx.window.sidecar.SidecarWindowLayoutInfo;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class SidecarCompat implements n {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f13159f = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SidecarInterface f13160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SidecarAdapter f13161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<IBinder, Activity> f13162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<Activity, ComponentCallbacks> f13163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public n.a f13164e;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class DistinctSidecarElementCallback implements SidecarInterface.SidecarCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SidecarAdapter f13165a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SidecarInterface.SidecarCallback f13166b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ReentrantLock f13167c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public SidecarDeviceState f13168d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final WeakHashMap<IBinder, SidecarWindowLayoutInfo> f13169e;

        public DistinctSidecarElementCallback(SidecarAdapter sidecarAdapter, SidecarInterface.SidecarCallback callbackInterface) {
            Intrinsics.g(sidecarAdapter, "sidecarAdapter");
            Intrinsics.g(callbackInterface, "callbackInterface");
            this.f13165a = sidecarAdapter;
            this.f13166b = callbackInterface;
            this.f13167c = new ReentrantLock();
            this.f13169e = new WeakHashMap<>();
        }

        public void onDeviceStateChanged(SidecarDeviceState newDeviceState) {
            Intrinsics.g(newDeviceState, "newDeviceState");
            ReentrantLock reentrantLock = this.f13167c;
            reentrantLock.lock();
            try {
                if (this.f13165a.a(this.f13168d, newDeviceState)) {
                    return;
                }
                this.f13168d = newDeviceState;
                this.f13166b.onDeviceStateChanged(newDeviceState);
                Unit unit = Unit.f68710a;
            } finally {
                reentrantLock.unlock();
            }
        }

        public void onWindowLayoutChanged(IBinder token, SidecarWindowLayoutInfo newLayout) {
            Intrinsics.g(token, "token");
            Intrinsics.g(newLayout, "newLayout");
            synchronized (this.f13167c) {
                if (this.f13165a.d(this.f13169e.get(token), newLayout)) {
                    return;
                }
                this.f13169e.put(token, newLayout);
                this.f13166b.onWindowLayoutChanged(token, newLayout);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class TranslatingCallback implements SidecarInterface.SidecarCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SidecarCompat f13170a;

        public TranslatingCallback(SidecarCompat this$0) {
            Intrinsics.g(this$0, "this$0");
            this.f13170a = this$0;
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onDeviceStateChanged(SidecarDeviceState newDeviceState) {
            SidecarInterface sidecarInterfaceG;
            Intrinsics.g(newDeviceState, "newDeviceState");
            Collection<Activity> collectionValues = this.f13170a.f13162c.values();
            SidecarCompat sidecarCompat = this.f13170a;
            for (Activity activity : collectionValues) {
                IBinder iBinderA = SidecarCompat.f13159f.a(activity);
                SidecarWindowLayoutInfo windowLayoutInfo = null;
                if (iBinderA != null && (sidecarInterfaceG = sidecarCompat.g()) != null) {
                    windowLayoutInfo = sidecarInterfaceG.getWindowLayoutInfo(iBinderA);
                }
                n.a aVar = sidecarCompat.f13164e;
                if (aVar != null) {
                    aVar.a(activity, sidecarCompat.f13161b.e(windowLayoutInfo, newDeviceState));
                }
            }
        }

        @SuppressLint({"SyntheticAccessor"})
        public void onWindowLayoutChanged(IBinder windowToken, SidecarWindowLayoutInfo newLayout) {
            Intrinsics.g(windowToken, "windowToken");
            Intrinsics.g(newLayout, "newLayout");
            Activity activity = (Activity) this.f13170a.f13162c.get(windowToken);
            if (activity == null) {
                Log.w("SidecarCompat", "Unable to resolve activity from window token. Missing a call to #onWindowLayoutChangeListenerAdded()?");
                return;
            }
            SidecarAdapter sidecarAdapter = this.f13170a.f13161b;
            SidecarInterface sidecarInterfaceG = this.f13170a.g();
            SidecarDeviceState deviceState = sidecarInterfaceG == null ? null : sidecarInterfaceG.getDeviceState();
            if (deviceState == null) {
                deviceState = new SidecarDeviceState();
            }
            a0 a0VarE = sidecarAdapter.e(newLayout, deviceState);
            n.a aVar = this.f13170a.f13164e;
            if (aVar == null) {
                return;
            }
            aVar.a(activity, a0VarE);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IBinder a(Activity activity) {
            Window window;
            WindowManager.LayoutParams attributes;
            if (activity == null || (window = activity.getWindow()) == null || (attributes = window.getAttributes()) == null) {
                return null;
            }
            return attributes.token;
        }

        public final SidecarInterface b(Context context) {
            Intrinsics.g(context, "context");
            return SidecarProvider.getSidecarImpl(context.getApplicationContext());
        }

        public final Version c() {
            try {
                String apiVersion = SidecarProvider.getApiVersion();
                if (TextUtils.isEmpty(apiVersion)) {
                    return null;
                }
                return Version.f13122g.b(apiVersion);
            } catch (NoClassDefFoundError | UnsupportedOperationException unused) {
                return null;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements n.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n.a f13171a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ReentrantLock f13172b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final WeakHashMap<Activity, a0> f13173c;

        public b(n.a callbackInterface) {
            Intrinsics.g(callbackInterface, "callbackInterface");
            this.f13171a = callbackInterface;
            this.f13172b = new ReentrantLock();
            this.f13173c = new WeakHashMap<>();
        }

        @Override // androidx.window.layout.n.a
        public void a(Activity activity, a0 newLayout) {
            Intrinsics.g(activity, "activity");
            Intrinsics.g(newLayout, "newLayout");
            ReentrantLock reentrantLock = this.f13172b;
            reentrantLock.lock();
            try {
                if (Intrinsics.b(newLayout, this.f13173c.get(activity))) {
                    reentrantLock.unlock();
                    return;
                }
                this.f13173c.put(activity, newLayout);
                reentrantLock.unlock();
                this.f13171a.a(activity, newLayout);
            } catch (Throwable th2) {
                reentrantLock.unlock();
                throw th2;
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SidecarCompat f13174a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final WeakReference<Activity> f13175b;

        public c(SidecarCompat sidecarCompat, Activity activity) {
            Intrinsics.g(sidecarCompat, "sidecarCompat");
            Intrinsics.g(activity, "activity");
            this.f13174a = sidecarCompat;
            this.f13175b = new WeakReference<>(activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            Intrinsics.g(view, "view");
            view.removeOnAttachStateChangeListener(this);
            Activity activity = this.f13175b.get();
            IBinder iBinderA = SidecarCompat.f13159f.a(activity);
            if (activity == null || iBinderA == null) {
                return;
            }
            this.f13174a.i(iBinderA, activity);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            Intrinsics.g(view, "view");
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements ComponentCallbacks {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Activity f13177b;

        public d(Activity activity) {
            this.f13177b = activity;
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration newConfig) {
            Intrinsics.g(newConfig, "newConfig");
            n.a aVar = SidecarCompat.this.f13164e;
            if (aVar == null) {
                return;
            }
            Activity activity = this.f13177b;
            aVar.a(activity, SidecarCompat.this.h(activity));
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SidecarCompat(Context context) {
        this(f13159f.b(context), new SidecarAdapter(null, 1, null));
        Intrinsics.g(context, "context");
    }

    public SidecarCompat(SidecarInterface sidecarInterface, SidecarAdapter sidecarAdapter) {
        Intrinsics.g(sidecarAdapter, "sidecarAdapter");
        this.f13160a = sidecarInterface;
        this.f13161b = sidecarAdapter;
        this.f13162c = new LinkedHashMap();
        this.f13163d = new LinkedHashMap();
    }

    @Override // androidx.window.layout.n
    public void a(n.a extensionCallback) {
        Intrinsics.g(extensionCallback, "extensionCallback");
        this.f13164e = new b(extensionCallback);
        SidecarInterface sidecarInterface = this.f13160a;
        if (sidecarInterface == null) {
            return;
        }
        sidecarInterface.setSidecarCallback(new DistinctSidecarElementCallback(this.f13161b, new TranslatingCallback(this)));
    }

    @Override // androidx.window.layout.n
    public void b(Activity activity) {
        Intrinsics.g(activity, "activity");
        IBinder iBinderA = f13159f.a(activity);
        if (iBinderA != null) {
            i(iBinderA, activity);
        } else {
            activity.getWindow().getDecorView().addOnAttachStateChangeListener(new c(this, activity));
        }
    }

    @Override // androidx.window.layout.n
    public void c(Activity activity) {
        SidecarInterface sidecarInterface;
        Intrinsics.g(activity, "activity");
        IBinder iBinderA = f13159f.a(activity);
        if (iBinderA == null) {
            return;
        }
        SidecarInterface sidecarInterface2 = this.f13160a;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerRemoved(iBinderA);
        }
        k(activity);
        boolean z11 = this.f13162c.size() == 1;
        this.f13162c.remove(iBinderA);
        if (!z11 || (sidecarInterface = this.f13160a) == null) {
            return;
        }
        sidecarInterface.onDeviceStateListenersChanged(true);
    }

    public final SidecarInterface g() {
        return this.f13160a;
    }

    public final a0 h(Activity activity) {
        Intrinsics.g(activity, "activity");
        IBinder iBinderA = f13159f.a(activity);
        if (iBinderA == null) {
            return new a0(kotlin.collections.g.l());
        }
        SidecarInterface sidecarInterface = this.f13160a;
        SidecarWindowLayoutInfo windowLayoutInfo = sidecarInterface == null ? null : sidecarInterface.getWindowLayoutInfo(iBinderA);
        SidecarAdapter sidecarAdapter = this.f13161b;
        SidecarInterface sidecarInterface2 = this.f13160a;
        SidecarDeviceState deviceState = sidecarInterface2 != null ? sidecarInterface2.getDeviceState() : null;
        if (deviceState == null) {
            deviceState = new SidecarDeviceState();
        }
        return sidecarAdapter.e(windowLayoutInfo, deviceState);
    }

    public final void i(IBinder windowToken, Activity activity) {
        SidecarInterface sidecarInterface;
        Intrinsics.g(windowToken, "windowToken");
        Intrinsics.g(activity, "activity");
        this.f13162c.put(windowToken, activity);
        SidecarInterface sidecarInterface2 = this.f13160a;
        if (sidecarInterface2 != null) {
            sidecarInterface2.onWindowLayoutChangeListenerAdded(windowToken);
        }
        if (this.f13162c.size() == 1 && (sidecarInterface = this.f13160a) != null) {
            sidecarInterface.onDeviceStateListenersChanged(false);
        }
        n.a aVar = this.f13164e;
        if (aVar != null) {
            aVar.a(activity, h(activity));
        }
        j(activity);
    }

    public final void j(Activity activity) {
        if (this.f13163d.get(activity) == null) {
            d dVar = new d(activity);
            this.f13163d.put(activity, dVar);
            activity.registerComponentCallbacks(dVar);
        }
    }

    public final void k(Activity activity) {
        activity.unregisterComponentCallbacks(this.f13163d.get(activity));
        this.f13163d.remove(activity);
    }

    @SuppressLint({"BanUncheckedReflection"})
    public boolean l() {
        Class<?> cls;
        Class<?> cls2;
        Class<?> cls3;
        Class<?> cls4;
        try {
            SidecarInterface sidecarInterface = this.f13160a;
            Class<?> returnType = null;
            Method method = (sidecarInterface == null || (cls = sidecarInterface.getClass()) == null) ? null : cls.getMethod("setSidecarCallback", SidecarInterface.SidecarCallback.class);
            Class<?> returnType2 = method == null ? null : method.getReturnType();
            Class cls5 = Void.TYPE;
            if (!Intrinsics.b(returnType2, cls5)) {
                throw new NoSuchMethodException(Intrinsics.p("Illegal return type for 'setSidecarCallback': ", returnType2));
            }
            SidecarInterface sidecarInterface2 = this.f13160a;
            if (sidecarInterface2 != null) {
                sidecarInterface2.getDeviceState();
            }
            SidecarInterface sidecarInterface3 = this.f13160a;
            if (sidecarInterface3 != null) {
                sidecarInterface3.onDeviceStateListenersChanged(true);
            }
            SidecarInterface sidecarInterface4 = this.f13160a;
            Method method2 = (sidecarInterface4 == null || (cls2 = sidecarInterface4.getClass()) == null) ? null : cls2.getMethod("getWindowLayoutInfo", IBinder.class);
            Class<?> returnType3 = method2 == null ? null : method2.getReturnType();
            if (!Intrinsics.b(returnType3, SidecarWindowLayoutInfo.class)) {
                throw new NoSuchMethodException(Intrinsics.p("Illegal return type for 'getWindowLayoutInfo': ", returnType3));
            }
            SidecarInterface sidecarInterface5 = this.f13160a;
            Method method3 = (sidecarInterface5 == null || (cls3 = sidecarInterface5.getClass()) == null) ? null : cls3.getMethod("onWindowLayoutChangeListenerAdded", IBinder.class);
            Class<?> returnType4 = method3 == null ? null : method3.getReturnType();
            if (!Intrinsics.b(returnType4, cls5)) {
                throw new NoSuchMethodException(Intrinsics.p("Illegal return type for 'onWindowLayoutChangeListenerAdded': ", returnType4));
            }
            SidecarInterface sidecarInterface6 = this.f13160a;
            Method method4 = (sidecarInterface6 == null || (cls4 = sidecarInterface6.getClass()) == null) ? null : cls4.getMethod("onWindowLayoutChangeListenerRemoved", IBinder.class);
            if (method4 != null) {
                returnType = method4.getReturnType();
            }
            if (!Intrinsics.b(returnType, cls5)) {
                throw new NoSuchMethodException(Intrinsics.p("Illegal return type for 'onWindowLayoutChangeListenerRemoved': ", returnType));
            }
            SidecarDeviceState sidecarDeviceState = new SidecarDeviceState();
            try {
                sidecarDeviceState.posture = 3;
            } catch (NoSuchFieldError unused) {
                SidecarDeviceState.class.getMethod("setPosture", Integer.TYPE).invoke(sidecarDeviceState, 3);
                Object objInvoke = SidecarDeviceState.class.getMethod("getPosture", new Class[0]).invoke(sidecarDeviceState, new Object[0]);
                if (objInvoke == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
                if (((Integer) objInvoke).intValue() != 3) {
                    throw new Exception("Invalid device posture getter/setter");
                }
            }
            SidecarDisplayFeature sidecarDisplayFeature = new SidecarDisplayFeature();
            Rect rect = sidecarDisplayFeature.getRect();
            Intrinsics.f(rect, "displayFeature.rect");
            sidecarDisplayFeature.setRect(rect);
            sidecarDisplayFeature.getType();
            sidecarDisplayFeature.setType(1);
            SidecarWindowLayoutInfo sidecarWindowLayoutInfo = new SidecarWindowLayoutInfo();
            try {
                List list = sidecarWindowLayoutInfo.displayFeatures;
            } catch (NoSuchFieldError unused2) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(sidecarDisplayFeature);
                SidecarWindowLayoutInfo.class.getMethod("setDisplayFeatures", List.class).invoke(sidecarWindowLayoutInfo, arrayList);
                Object objInvoke2 = SidecarWindowLayoutInfo.class.getMethod("getDisplayFeatures", new Class[0]).invoke(sidecarWindowLayoutInfo, new Object[0]);
                if (objInvoke2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.List<androidx.window.sidecar.SidecarDisplayFeature>");
                }
                if (!Intrinsics.b(arrayList, (List) objInvoke2)) {
                    throw new Exception("Invalid display feature getter/setter");
                }
            }
            return true;
        } catch (Throwable unused3) {
            return false;
        }
    }
}
