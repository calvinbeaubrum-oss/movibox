package mp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
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

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f71157b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final c f71158c = new c();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ScheduledExecutorService f71159a = Executors.newScheduledThreadPool(1, new ThreadFactory() { // from class: mp.a
        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            return c.c(runnable);
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final c a() {
            return c.f71158c;
        }
    }

    public static final Thread c(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setName("Delay-Task-Dispatcher");
        thread.setPriority(10);
        return thread;
    }

    public static final void f(ExecutorService pool, Runnable runnable) {
        Intrinsics.g(pool, "$pool");
        Intrinsics.g(runnable, "$runnable");
        pool.execute(runnable);
    }

    public final void e(long j11, final ExecutorService pool, final Runnable runnable) {
        Intrinsics.g(pool, "pool");
        Intrinsics.g(runnable, "runnable");
        if (j11 == 0) {
            pool.execute(runnable);
            return;
        }
        ScheduledExecutorService scheduledExecutorService = this.f71159a;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.schedule(new Runnable() { // from class: mp.b
                @Override // java.lang.Runnable
                public final void run() {
                    c.f(pool, runnable);
                }
            }, j11, TimeUnit.MICROSECONDS);
        }
    }
}
