package r6;

import android.content.Context;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public abstract class g<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t6.c f75148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Context f75149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f75150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedHashSet<p6.a<T>> f75151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public T f75152e;

    public g(Context context, t6.c taskExecutor) {
        Intrinsics.g(context, "context");
        Intrinsics.g(taskExecutor, "taskExecutor");
        this.f75148a = taskExecutor;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.f(applicationContext, "context.applicationContext");
        this.f75149b = applicationContext;
        this.f75150c = new Object();
        this.f75151d = new LinkedHashSet<>();
    }

    public static final void b(List listenersList, g this$0) {
        Intrinsics.g(listenersList, "$listenersList");
        Intrinsics.g(this$0, "this$0");
        Iterator<T> it = listenersList.iterator();
        while (it.hasNext()) {
            ((p6.a) it.next()).a(this$0.f75152e);
        }
    }

    public final void c(p6.a<T> listener) {
        Intrinsics.g(listener, "listener");
        synchronized (this.f75150c) {
            try {
                if (this.f75151d.add(listener)) {
                    if (this.f75151d.size() == 1) {
                        this.f75152e = e();
                        androidx.work.j.e().a(h.f75153a, getClass().getSimpleName() + ": initial state = " + this.f75152e);
                        h();
                    }
                    listener.a(this.f75152e);
                }
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final Context d() {
        return this.f75149b;
    }

    public abstract T e();

    public final void f(p6.a<T> listener) {
        Intrinsics.g(listener, "listener");
        synchronized (this.f75150c) {
            try {
                if (this.f75151d.remove(listener) && this.f75151d.isEmpty()) {
                    i();
                }
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void g(T t11) {
        synchronized (this.f75150c) {
            T t12 = this.f75152e;
            if (t12 == null || !Intrinsics.b(t12, t11)) {
                this.f75152e = t11;
                final List listJ0 = CollectionsKt___CollectionsKt.J0(this.f75151d);
                this.f75148a.a().execute(new Runnable() { // from class: r6.f
                    @Override // java.lang.Runnable
                    public final void run() {
                        g.b(listJ0, this);
                    }
                });
                Unit unit = Unit.f68710a;
            }
        }
    }

    public abstract void h();

    public abstract void i();
}
