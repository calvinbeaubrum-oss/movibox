package androidx.window.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import androidx.window.extensions.layout.WindowLayoutComponent;
import androidx.window.extensions.layout.WindowLayoutInfo;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
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
public final class p implements v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WindowLayoutComponent f13190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ReentrantLock f13191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<Activity, a> f13192c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<androidx.core.util.a<a0>, Activity> f13193d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SuppressLint({"NewApi"})
    public static final class a implements Consumer<WindowLayoutInfo> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Activity f13194a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ReentrantLock f13195b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public a0 f13196c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Set<androidx.core.util.a<a0>> f13197d;

        public a(Activity activity) {
            Intrinsics.g(activity, "activity");
            this.f13194a = activity;
            this.f13195b = new ReentrantLock();
            this.f13197d = new LinkedHashSet();
        }

        @Override // java.util.function.Consumer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(WindowLayoutInfo value) {
            Intrinsics.g(value, "value");
            ReentrantLock reentrantLock = this.f13195b;
            reentrantLock.lock();
            try {
                this.f13196c = q.f13198a.b(this.f13194a, value);
                Iterator<T> it = this.f13197d.iterator();
                while (it.hasNext()) {
                    ((androidx.core.util.a) it.next()).accept(this.f13196c);
                }
                Unit unit = Unit.f68710a;
            } finally {
                reentrantLock.unlock();
            }
        }

        public final void b(androidx.core.util.a<a0> listener) {
            Intrinsics.g(listener, "listener");
            ReentrantLock reentrantLock = this.f13195b;
            reentrantLock.lock();
            try {
                a0 a0Var = this.f13196c;
                if (a0Var != null) {
                    listener.accept(a0Var);
                }
                this.f13197d.add(listener);
            } finally {
                reentrantLock.unlock();
            }
        }

        public final boolean c() {
            return this.f13197d.isEmpty();
        }

        public final void d(androidx.core.util.a<a0> listener) {
            Intrinsics.g(listener, "listener");
            ReentrantLock reentrantLock = this.f13195b;
            reentrantLock.lock();
            try {
                this.f13197d.remove(listener);
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public p(WindowLayoutComponent component) {
        Intrinsics.g(component, "component");
        this.f13190a = component;
        this.f13191b = new ReentrantLock();
        this.f13192c = new LinkedHashMap();
        this.f13193d = new LinkedHashMap();
    }

    @Override // androidx.window.layout.v
    public void a(Activity activity, Executor executor, androidx.core.util.a<a0> callback) {
        Unit unit;
        Intrinsics.g(activity, "activity");
        Intrinsics.g(executor, "executor");
        Intrinsics.g(callback, "callback");
        ReentrantLock reentrantLock = this.f13191b;
        reentrantLock.lock();
        try {
            a aVar = this.f13192c.get(activity);
            if (aVar == null) {
                unit = null;
            } else {
                aVar.b(callback);
                this.f13193d.put(callback, activity);
                unit = Unit.f68710a;
            }
            if (unit == null) {
                a aVar2 = new a(activity);
                this.f13192c.put(activity, aVar2);
                this.f13193d.put(callback, activity);
                aVar2.b(callback);
                this.f13190a.addWindowLayoutInfoListener(activity, o.a(aVar2));
            }
            Unit unit2 = Unit.f68710a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // androidx.window.layout.v
    public void b(androidx.core.util.a<a0> callback) {
        Intrinsics.g(callback, "callback");
        ReentrantLock reentrantLock = this.f13191b;
        reentrantLock.lock();
        try {
            Activity activity = this.f13193d.get(callback);
            if (activity == null) {
                return;
            }
            a aVar = this.f13192c.get(activity);
            if (aVar == null) {
                return;
            }
            aVar.d(callback);
            if (aVar.c()) {
                this.f13190a.removeWindowLayoutInfoListener(o.a(aVar));
            }
            Unit unit = Unit.f68710a;
        } finally {
            reentrantLock.unlock();
        }
    }
}
