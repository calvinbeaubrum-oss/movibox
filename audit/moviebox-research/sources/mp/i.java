package mp;

import java.util.concurrent.Executor;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class i implements kp.b, kp.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public kp.b f71170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Executor f71171b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public kp.a f71172c;

    public i(kp.b bVar, Executor executor, kp.a aVar) {
        this.f71170a = bVar;
        this.f71171b = executor;
        this.f71172c = aVar;
    }

    public static final void i(i this$0, String threadName) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(threadName, "$threadName");
        kp.b bVar = this$0.f71170a;
        if (bVar != null) {
            bVar.onCompleted(threadName);
        }
    }

    public static final void j(i this$0, String threadName, Throwable throwable) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(threadName, "$threadName");
        Intrinsics.g(throwable, "$throwable");
        kp.b bVar = this$0.f71170a;
        if (bVar != null) {
            bVar.b(threadName, throwable);
        }
    }

    public static final void k(i this$0, Throwable t11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(t11, "$t");
        kp.a aVar = this$0.f71172c;
        if (aVar != null) {
            aVar.c(t11);
        }
    }

    public static final void l(i this$0, String threadName) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(threadName, "$threadName");
        kp.b bVar = this$0.f71170a;
        if (bVar != null) {
            bVar.a(threadName);
        }
    }

    public static final void m(i this$0) {
        Intrinsics.g(this$0, "this$0");
        try {
            kp.a aVar = this$0.f71172c;
            if (aVar != null) {
                aVar.onSuccess();
            }
        } catch (Throwable th2) {
            this$0.c(th2);
        }
    }

    @Override // kp.b
    public void a(final String threadName) {
        Executor executor;
        Intrinsics.g(threadName, "threadName");
        if (this.f71170a == null || (executor = this.f71171b) == null) {
            return;
        }
        executor.execute(new Runnable() { // from class: mp.f
            @Override // java.lang.Runnable
            public final void run() {
                i.l(this.f71165a, threadName);
            }
        });
    }

    @Override // kp.b
    public void b(final String threadName, final Throwable throwable) {
        Executor executor;
        Intrinsics.g(threadName, "threadName");
        Intrinsics.g(throwable, "throwable");
        c(throwable);
        if (this.f71170a == null || (executor = this.f71171b) == null) {
            return;
        }
        executor.execute(new Runnable() { // from class: mp.e
            @Override // java.lang.Runnable
            public final void run() {
                i.j(this.f71162a, threadName, throwable);
            }
        });
    }

    @Override // kp.a
    public void c(final Throwable t11) {
        Executor executor;
        Intrinsics.g(t11, "t");
        if (this.f71172c == null || (executor = this.f71171b) == null) {
            return;
        }
        executor.execute(new Runnable() { // from class: mp.h
            @Override // java.lang.Runnable
            public final void run() {
                i.k(this.f71168a, t11);
            }
        });
    }

    @Override // kp.b
    public void onCompleted(final String threadName) {
        Executor executor;
        Intrinsics.g(threadName, "threadName");
        if (this.f71170a == null || (executor = this.f71171b) == null) {
            return;
        }
        executor.execute(new Runnable() { // from class: mp.d
            @Override // java.lang.Runnable
            public final void run() {
                i.i(this.f71160a, threadName);
            }
        });
    }

    @Override // kp.a
    public void onSuccess() {
        Executor executor;
        if (this.f71172c == null || (executor = this.f71171b) == null) {
            return;
        }
        executor.execute(new Runnable() { // from class: mp.g
            @Override // java.lang.Runnable
            public final void run() {
                i.m(this.f71167a);
            }
        });
    }
}
