package androidx.window.java.layout;

import android.app.Activity;
import androidx.core.util.a;
import androidx.window.layout.a0;
import androidx.window.layout.x;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i1;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.q1;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class WindowInfoTrackerCallbackAdapter implements x {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x f13150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReentrantLock f13151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<a<?>, q1> f13152d;

    public WindowInfoTrackerCallbackAdapter(x tracker) {
        Intrinsics.g(tracker, "tracker");
        this.f13150b = tracker;
        this.f13151c = new ReentrantLock();
        this.f13152d = new LinkedHashMap();
    }

    @Override // androidx.window.layout.x
    public kotlinx.coroutines.flow.a<a0> a(Activity activity) {
        Intrinsics.g(activity, "activity");
        return this.f13150b.a(activity);
    }

    public final <T> void b(Executor executor, a<T> aVar, kotlinx.coroutines.flow.a<? extends T> aVar2) {
        ReentrantLock reentrantLock = this.f13151c;
        reentrantLock.lock();
        try {
            if (this.f13152d.get(aVar) == null) {
                this.f13152d.put(aVar, j.d(l0.a(i1.a(executor)), null, null, new WindowInfoTrackerCallbackAdapter$addListener$1$1(aVar2, aVar, null), 3, null));
            }
            Unit unit = Unit.f68710a;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void c(Activity activity, Executor executor, a<a0> consumer) {
        Intrinsics.g(activity, "activity");
        Intrinsics.g(executor, "executor");
        Intrinsics.g(consumer, "consumer");
        b(executor, consumer, this.f13150b.a(activity));
    }

    public final void d(a<?> aVar) {
        ReentrantLock reentrantLock = this.f13151c;
        reentrantLock.lock();
        try {
            q1 q1Var = this.f13152d.get(aVar);
            if (q1Var != null) {
                q1.a.b(q1Var, null, 1, null);
            }
            this.f13152d.remove(aVar);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void e(a<a0> consumer) {
        Intrinsics.g(consumer, "consumer");
        d(consumer);
    }
}
