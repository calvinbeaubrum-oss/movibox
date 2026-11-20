package androidx.lifecycle;

import android.os.Handler;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class ServiceLifecycleDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f8690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f8691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public DispatchRunnable f8692c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class DispatchRunnable implements Runnable {
        private final Lifecycle.Event event;
        private final w registry;
        private boolean wasExecuted;

        public DispatchRunnable(w registry, Lifecycle.Event event) {
            Intrinsics.g(registry, "registry");
            Intrinsics.g(event, "event");
            this.registry = registry;
            this.event = event;
        }

        public final Lifecycle.Event getEvent() {
            return this.event;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.wasExecuted) {
                return;
            }
            this.registry.i(this.event);
            this.wasExecuted = true;
        }
    }

    public ServiceLifecycleDispatcher(u provider) {
        Intrinsics.g(provider, "provider");
        this.f8690a = new w(provider);
        this.f8691b = new Handler();
    }

    public Lifecycle a() {
        return this.f8690a;
    }

    public void b() {
        f(Lifecycle.Event.ON_START);
    }

    public void c() {
        f(Lifecycle.Event.ON_CREATE);
    }

    public void d() {
        f(Lifecycle.Event.ON_STOP);
        f(Lifecycle.Event.ON_DESTROY);
    }

    public void e() {
        f(Lifecycle.Event.ON_START);
    }

    public final void f(Lifecycle.Event event) {
        DispatchRunnable dispatchRunnable = this.f8692c;
        if (dispatchRunnable != null) {
            dispatchRunnable.run();
        }
        DispatchRunnable dispatchRunnable2 = new DispatchRunnable(this.f8690a, event);
        this.f8692c = dispatchRunnable2;
        Handler handler = this.f8691b;
        Intrinsics.d(dispatchRunnable2);
        handler.postAtFrontOfQueue(dispatchRunnable2);
    }
}
