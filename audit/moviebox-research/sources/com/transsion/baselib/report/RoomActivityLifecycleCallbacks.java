package com.transsion.baselib.report;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public final class RoomActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final RoomActivityLifecycleCallbacks f51239a = new RoomActivityLifecycleCallbacks();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CopyOnWriteArrayList<Activity> f51240b = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LinkedList<Activity> f51241c = new LinkedList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LinkedList<Activity> f51242d = new LinkedList<>();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final LinkedList<Activity> f51243f = new LinkedList<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final LinkedList<Activity> f51244g = new LinkedList<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f51245h = LazyKt__LazyJVMKt.b(new Function0<CopyOnWriteArrayList<a>>() { // from class: com.transsion.baselib.report.RoomActivityLifecycleCallbacks$backgroundStatusChangeListenerList$2
        @Override // kotlin.jvm.functions.Function0
        public final CopyOnWriteArrayList<RoomActivityLifecycleCallbacks.a> invoke() {
            return new CopyOnWriteArrayList<>();
        }
    });

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static int f51246i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static Boolean f51247j;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes7.dex */
    @Metadata
    public interface a {
        void onBackgroundStatusChange(boolean z11);
    }

    public final int a() {
        return f51240b.size();
    }

    public final boolean b(a listener) {
        Intrinsics.g(listener, "listener");
        if (f().contains(listener)) {
            return false;
        }
        return f().add(listener);
    }

    public final void c(boolean z11, Activity activity) {
        o.f51281a.d(z11, activity);
        fp.b.f65208a.i(Boolean.valueOf(z11));
        Iterator<T> it = f().iterator();
        while (it.hasNext()) {
            ((a) it.next()).onBackgroundStatusChange(z11);
        }
    }

    public final void d() {
        CopyOnWriteArrayList<Activity> copyOnWriteArrayList = f51240b;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        for (Activity activity : copyOnWriteArrayList) {
            if (!activity.isFinishing() && !activity.isDestroyed()) {
                try {
                    activity.finish();
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            }
        }
        f51240b.clear();
    }

    public final List<Activity> e() {
        return f51240b;
    }

    public final List<a> f() {
        return (List) f51245h.getValue();
    }

    public final Activity g() {
        return h(0);
    }

    public final Activity h(int i11) {
        CopyOnWriteArrayList<Activity> copyOnWriteArrayList = f51240b;
        if (copyOnWriteArrayList.isEmpty()) {
            return null;
        }
        int size = copyOnWriteArrayList.size();
        int i12 = (size - 1) - i11;
        if (i12 < 0 || i12 >= size) {
            return null;
        }
        return copyOnWriteArrayList.get(i12);
    }

    public final boolean i() {
        return f51246i == 0;
    }

    public final boolean j() {
        return RoomAppMMKV.f51271a.a().getLong("record_latest_foreground_time", 0L) == 0;
    }

    public final boolean k(a listener) {
        Intrinsics.g(listener, "listener");
        return f().remove(listener);
    }

    public final boolean l() {
        String value;
        Long lN;
        Boolean bool = f51247j;
        if (bool != null) {
            return Intrinsics.b(bool, Boolean.TRUE);
        }
        long j11 = RoomAppMMKV.f51271a.a().getLong("record_latest_foreground_time", 0L);
        ConfigBean configBeanB = ConfigManager.f53111c.a().b("pull_notification_deadline", true);
        long jLongValue = (configBeanB == null || (value = configBeanB.getValue()) == null || (lN = kotlin.text.k.n(value)) == null) ? 0L : lN.longValue();
        long jCurrentTimeMillis = (System.currentTimeMillis() - j11) / ((long) 86400000);
        uo.b.a.f(uo.b.f78622a, "Report", "latestForegroundTime=" + j11 + " sleepDays=" + jCurrentTimeMillis + " notificationDeadlineDays=" + jLongValue, false, 4, null);
        Boolean boolValueOf = Boolean.valueOf(j11 > 0 && jCurrentTimeMillis > jLongValue);
        f51247j = boolValueOf;
        return Intrinsics.b(boolValueOf, Boolean.TRUE);
    }

    public final void m(int i11, Activity activity) {
        Intrinsics.g(activity, "activity");
        try {
            CopyOnWriteArrayList<Activity> copyOnWriteArrayList = f51240b;
            ArrayList arrayList = new ArrayList();
            for (Object obj : copyOnWriteArrayList) {
                if (Intrinsics.b(((Activity) obj).getClass(), activity.getClass())) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size() - i11;
            if (size <= 0) {
                return;
            }
            for (int i12 = 0; i12 < size; i12++) {
                ((Activity) arrayList.get(i12)).finish();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void n(Activity activity) {
        if (activity instanceof b) {
            LinkedList<Activity> linkedList = f51243f;
            if (linkedList.contains(activity)) {
                return;
            }
            linkedList.offer(activity);
            if (linkedList.size() > 1) {
                linkedList.pop().finish();
            }
        }
    }

    public final void o(Activity activity) {
        if (activity instanceof d) {
            LinkedList<Activity> linkedList = f51242d;
            if (linkedList.contains(activity)) {
                return;
            }
            linkedList.offer(activity);
            if (linkedList.size() > 1) {
                linkedList.pop().finish();
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.g(activity, "activity");
        Log.e("yy", "onActivityCreated  activity:" + activity);
        if (activity instanceof c) {
            return;
        }
        f51240b.add(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        Intrinsics.g(activity, "activity");
        Log.e("yy", "onActivityDestroyed  activity:" + activity);
        if (activity instanceof c) {
            return;
        }
        f51240b.remove(activity);
        if (activity instanceof f) {
            f51241c.remove(activity);
        }
        if (activity instanceof d) {
            f51242d.remove(activity);
        }
        if (activity instanceof b) {
            f51243f.remove(activity);
        }
        if (activity instanceof g) {
            f51244g.remove(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        Intrinsics.g(activity, "activity");
        Log.e("yy", "onActivityPaused  activity:" + activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        Intrinsics.g(activity, "activity");
        Log.e("yy", "onActivityResumed  activity:" + activity);
        p(activity);
        o(activity);
        n(activity);
        q(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        Intrinsics.g(activity, "activity");
        Intrinsics.g(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        Intrinsics.g(activity, "activity");
        Log.e("yy", "onActivityStarted  activity:" + activity);
        if (activity instanceof c) {
            return;
        }
        int i11 = f51246i + 1;
        f51246i = i11;
        if (i11 == 1) {
            c(false, activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        Intrinsics.g(activity, "activity");
        Log.e("yy", "onActivityStopped  activity:" + activity);
        if (activity instanceof c) {
            return;
        }
        int i11 = f51246i - 1;
        f51246i = i11;
        if (i11 == 0) {
            c(true, activity);
        }
    }

    public final void p(Activity activity) {
        if (activity instanceof f) {
            LinkedList<Activity> linkedList = f51241c;
            if (linkedList.contains(activity)) {
                return;
            }
            linkedList.offer(activity);
            if (linkedList.size() > 3) {
                linkedList.pop().finish();
            }
        }
    }

    public final void q(Activity activity) {
        if (activity instanceof g) {
            LinkedList<Activity> linkedList = f51244g;
            if (linkedList.contains(activity)) {
                return;
            }
            linkedList.offer(activity);
            if (linkedList.size() > 1) {
                linkedList.pop().finish();
            }
        }
    }
}
