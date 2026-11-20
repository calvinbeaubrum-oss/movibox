package androidx.window.layout;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import androidx.window.core.Version;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
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
public final class t implements v {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static volatile t f13212d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n f13214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<c> f13215b = new CopyOnWriteArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f13211c = new a(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ReentrantLock f13213e = new ReentrantLock();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final t a(Context context) {
            Intrinsics.g(context, "context");
            if (t.f13212d == null) {
                ReentrantLock reentrantLock = t.f13213e;
                reentrantLock.lock();
                try {
                    if (t.f13212d == null) {
                        t.f13212d = new t(t.f13211c.b(context));
                    }
                    Unit unit = Unit.f68710a;
                    reentrantLock.unlock();
                } catch (Throwable th2) {
                    reentrantLock.unlock();
                    throw th2;
                }
            }
            t tVar = t.f13212d;
            Intrinsics.d(tVar);
            return tVar;
        }

        public final n b(Context context) {
            Intrinsics.g(context, "context");
            try {
                if (!c(SidecarCompat.f13159f.c())) {
                    return null;
                }
                SidecarCompat sidecarCompat = new SidecarCompat(context);
                if (sidecarCompat.l()) {
                    return sidecarCompat;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }

        public final boolean c(Version version) {
            return version != null && version.compareTo(Version.f13122g.a()) >= 0;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public final class b implements n.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ t f13216a;

        public b(t this$0) {
            Intrinsics.g(this$0, "this$0");
            this.f13216a = this$0;
        }

        @Override // androidx.window.layout.n.a
        @SuppressLint({"SyntheticAccessor"})
        public void a(Activity activity, a0 newLayout) {
            Intrinsics.g(activity, "activity");
            Intrinsics.g(newLayout, "newLayout");
            for (c cVar : this.f13216a.h()) {
                if (Intrinsics.b(cVar.d(), activity)) {
                    cVar.b(newLayout);
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Activity f13217a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f13218b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final androidx.core.util.a<a0> f13219c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public a0 f13220d;

        public c(Activity activity, Executor executor, androidx.core.util.a<a0> callback) {
            Intrinsics.g(activity, "activity");
            Intrinsics.g(executor, "executor");
            Intrinsics.g(callback, "callback");
            this.f13217a = activity;
            this.f13218b = executor;
            this.f13219c = callback;
        }

        public static final void c(c this$0, a0 newLayoutInfo) {
            Intrinsics.g(this$0, "this$0");
            Intrinsics.g(newLayoutInfo, "$newLayoutInfo");
            this$0.f13219c.accept(newLayoutInfo);
        }

        public final void b(final a0 newLayoutInfo) {
            Intrinsics.g(newLayoutInfo, "newLayoutInfo");
            this.f13220d = newLayoutInfo;
            this.f13218b.execute(new Runnable() { // from class: androidx.window.layout.u
                @Override // java.lang.Runnable
                public final void run() {
                    t.c.c(this.f13221a, newLayoutInfo);
                }
            });
        }

        public final Activity d() {
            return this.f13217a;
        }

        public final androidx.core.util.a<a0> e() {
            return this.f13219c;
        }

        public final a0 f() {
            return this.f13220d;
        }
    }

    public t(n nVar) {
        this.f13214a = nVar;
        n nVar2 = this.f13214a;
        if (nVar2 == null) {
            return;
        }
        nVar2.a(new b(this));
    }

    @Override // androidx.window.layout.v
    public void a(Activity activity, Executor executor, androidx.core.util.a<a0> callback) {
        a0 a0VarF;
        Object next;
        Intrinsics.g(activity, "activity");
        Intrinsics.g(executor, "executor");
        Intrinsics.g(callback, "callback");
        ReentrantLock reentrantLock = f13213e;
        reentrantLock.lock();
        try {
            n nVarG = g();
            if (nVarG == null) {
                callback.accept(new a0(kotlin.collections.g.l()));
                return;
            }
            boolean zI = i(activity);
            c cVar = new c(activity, executor, callback);
            h().add(cVar);
            if (zI) {
                Iterator<T> it = h().iterator();
                do {
                    a0VarF = null;
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.b(activity, ((c) next).d()));
                c cVar2 = (c) next;
                if (cVar2 != null) {
                    a0VarF = cVar2.f();
                }
                if (a0VarF != null) {
                    cVar.b(a0VarF);
                }
            } else {
                nVarG.b(activity);
            }
            Unit unit = Unit.f68710a;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // androidx.window.layout.v
    public void b(androidx.core.util.a<a0> callback) {
        Intrinsics.g(callback, "callback");
        synchronized (f13213e) {
            try {
                if (g() == null) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                for (c callbackWrapper : h()) {
                    if (callbackWrapper.e() == callback) {
                        Intrinsics.f(callbackWrapper, "callbackWrapper");
                        arrayList.add(callbackWrapper);
                    }
                }
                h().removeAll(arrayList);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    f(((c) it.next()).d());
                }
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void f(Activity activity) {
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.f13215b;
        if (!(copyOnWriteArrayList instanceof Collection) || !copyOnWriteArrayList.isEmpty()) {
            Iterator<T> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (Intrinsics.b(((c) it.next()).d(), activity)) {
                    return;
                }
            }
        }
        n nVar = this.f13214a;
        if (nVar == null) {
            return;
        }
        nVar.c(activity);
    }

    public final n g() {
        return this.f13214a;
    }

    public final CopyOnWriteArrayList<c> h() {
        return this.f13215b;
    }

    public final boolean i(Activity activity) {
        CopyOnWriteArrayList<c> copyOnWriteArrayList = this.f13215b;
        if ((copyOnWriteArrayList instanceof Collection) && copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator<T> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            if (Intrinsics.b(((c) it.next()).d(), activity)) {
                return true;
            }
        }
        return false;
    }
}
