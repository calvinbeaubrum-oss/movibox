package androidx.room;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class d0 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f12836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayDeque<Runnable> f12837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Runnable f12838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f12839d;

    public d0(Executor executor) {
        Intrinsics.g(executor, "executor");
        this.f12836a = executor;
        this.f12837b = new ArrayDeque<>();
        this.f12839d = new Object();
    }

    public static final void b(Runnable command, d0 this$0) {
        Intrinsics.g(command, "$command");
        Intrinsics.g(this$0, "this$0");
        try {
            command.run();
        } finally {
            this$0.c();
        }
    }

    public final void c() {
        synchronized (this.f12839d) {
            try {
                Runnable runnablePoll = this.f12837b.poll();
                Runnable runnable = runnablePoll;
                this.f12838c = runnable;
                if (runnablePoll != null) {
                    this.f12836a.execute(runnable);
                }
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(final Runnable command) {
        Intrinsics.g(command, "command");
        synchronized (this.f12839d) {
            try {
                this.f12837b.offer(new Runnable() { // from class: androidx.room.c0
                    @Override // java.lang.Runnable
                    public final void run() {
                        d0.b(command, this);
                    }
                });
                if (this.f12838c == null) {
                    c();
                }
                Unit unit = Unit.f68710a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
