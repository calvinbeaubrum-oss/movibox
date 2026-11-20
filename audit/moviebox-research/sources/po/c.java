package po;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f73961c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ExecutorService f73962a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ScheduledExecutorService f73963b;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final c a() {
            return b.f73964a.a();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f73964a = new b();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f73965b = new c(null);

        public final c a() {
            return f73965b;
        }
    }

    public c() {
        c();
    }

    public /* synthetic */ c(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final void a(Runnable runnable) {
        ExecutorService executorService;
        try {
            ExecutorService executorService2 = this.f73962a;
            Boolean boolValueOf = executorService2 == null ? null : Boolean.valueOf(executorService2.isShutdown());
            Intrinsics.d(boolValueOf);
            if (!boolValueOf.booleanValue() && (executorService = this.f73962a) != null) {
                executorService.execute(runnable);
            }
        } catch (RejectedExecutionException e11) {
            po.b.f73956a.e(e11);
        }
    }

    public final void b(Runnable runnable) {
        try {
            ScheduledExecutorService scheduledExecutorService = this.f73963b;
            if (scheduledExecutorService != null && scheduledExecutorService.isShutdown()) {
                return;
            }
            ScheduledExecutorService scheduledExecutorService2 = this.f73963b;
            if (scheduledExecutorService2 == null) {
                return;
            }
            scheduledExecutorService2.execute(runnable);
        } catch (Throwable th2) {
            po.b.f73956a.e(th2);
        }
    }

    public final void c() {
        if (this.f73962a == null) {
            this.f73962a = Executors.newCachedThreadPool();
        }
        if (this.f73963b == null) {
            this.f73963b = Executors.newSingleThreadScheduledExecutor();
        }
    }

    public final void d(Runnable runnable, long j11, TimeUnit unit) {
        Intrinsics.g(unit, "unit");
        try {
            ScheduledExecutorService scheduledExecutorService = this.f73963b;
            if (scheduledExecutorService != null && scheduledExecutorService.isShutdown()) {
                return;
            }
            ScheduledExecutorService scheduledExecutorService2 = this.f73963b;
            if (scheduledExecutorService2 == null) {
                return;
            }
            scheduledExecutorService2.schedule(runnable, j11, unit);
        } catch (Throwable th2) {
            po.b.f73956a.e(th2);
        }
    }
}
