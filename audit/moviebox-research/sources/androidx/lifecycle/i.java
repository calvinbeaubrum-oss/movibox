package androidx.lifecycle;

import java.util.ArrayDeque;
import java.util.Queue;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.a2;

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
public final class i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f8737b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8738c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f8736a = true;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Queue<Runnable> f8739d = new ArrayDeque();

    public static final void d(i this$0, Runnable runnable) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(runnable, "$runnable");
        this$0.f(runnable);
    }

    public final boolean b() {
        return this.f8737b || !this.f8736a;
    }

    public final void c(CoroutineContext context, final Runnable runnable) {
        Intrinsics.g(context, "context");
        Intrinsics.g(runnable, "runnable");
        a2 a2VarQ = kotlinx.coroutines.w0.c().q();
        if (a2VarQ.isDispatchNeeded(context) || b()) {
            a2VarQ.dispatch(context, new Runnable() { // from class: androidx.lifecycle.h
                @Override // java.lang.Runnable
                public final void run() {
                    i.d(this.f8722a, runnable);
                }
            });
        } else {
            f(runnable);
        }
    }

    public final void e() {
        if (this.f8738c) {
            return;
        }
        try {
            this.f8738c = true;
            while ((!this.f8739d.isEmpty()) && b()) {
                Runnable runnablePoll = this.f8739d.poll();
                if (runnablePoll != null) {
                    runnablePoll.run();
                }
            }
            this.f8738c = false;
        } catch (Throwable th2) {
            this.f8738c = false;
            throw th2;
        }
    }

    public final void f(Runnable runnable) {
        if (!this.f8739d.offer(runnable)) {
            throw new IllegalStateException("cannot enqueue any more runnables".toString());
        }
        e();
    }

    public final void g() {
        this.f8737b = true;
        e();
    }

    public final void h() {
        this.f8736a = true;
    }

    public final void i() {
        if (this.f8736a) {
            if (!(!this.f8737b)) {
                throw new IllegalStateException("Cannot resume a finished dispatcher".toString());
            }
            this.f8736a = false;
            e();
        }
    }
}
