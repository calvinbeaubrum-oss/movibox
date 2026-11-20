package androidx.lifecycle;

import android.os.Bundle;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
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
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final n f8753a = new n();

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements f6.c.a {
        @Override // f6.c.a
        public void a(f6.e owner) {
            Intrinsics.g(owner, "owner");
            if (!(owner instanceof y0)) {
                throw new IllegalStateException("Internal error: OnRecreation should be registered only on components that implement ViewModelStoreOwner".toString());
            }
            x0 viewModelStore = ((y0) owner).getViewModelStore();
            f6.c savedStateRegistry = owner.getSavedStateRegistry();
            Iterator<String> it = viewModelStore.c().iterator();
            while (it.hasNext()) {
                t0 t0VarB = viewModelStore.b(it.next());
                Intrinsics.d(t0VarB);
                n.a(t0VarB, savedStateRegistry, owner.getLifecycle());
            }
            if (!viewModelStore.c().isEmpty()) {
                savedStateRegistry.i(a.class);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Lifecycle f8754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f6.c f8755b;

        public b(Lifecycle lifecycle, f6.c cVar) {
            this.f8754a = lifecycle;
            this.f8755b = cVar;
        }

        @Override // androidx.lifecycle.r
        public void onStateChanged(u source, Lifecycle.Event event) {
            Intrinsics.g(source, "source");
            Intrinsics.g(event, "event");
            if (event == Lifecycle.Event.ON_START) {
                this.f8754a.d(this);
                this.f8755b.i(a.class);
            }
        }
    }

    @JvmStatic
    public static final void a(t0 viewModel, f6.c registry, Lifecycle lifecycle) {
        Intrinsics.g(viewModel, "viewModel");
        Intrinsics.g(registry, "registry");
        Intrinsics.g(lifecycle, "lifecycle");
        n0 n0Var = (n0) viewModel.getCloseable("androidx.lifecycle.savedstate.vm.tag");
        if (n0Var == null || n0Var.c()) {
            return;
        }
        n0Var.a(registry, lifecycle);
        f8753a.c(registry, lifecycle);
    }

    @JvmStatic
    public static final n0 b(f6.c registry, Lifecycle lifecycle, String str, Bundle bundle) {
        Intrinsics.g(registry, "registry");
        Intrinsics.g(lifecycle, "lifecycle");
        Intrinsics.d(str);
        n0 n0Var = new n0(str, l0.f8745f.a(registry.b(str), bundle));
        n0Var.a(registry, lifecycle);
        f8753a.c(registry, lifecycle);
        return n0Var;
    }

    public final void c(f6.c cVar, Lifecycle lifecycle) {
        Lifecycle.State stateB = lifecycle.b();
        if (stateB == Lifecycle.State.INITIALIZED || stateB.isAtLeast(Lifecycle.State.STARTED)) {
            cVar.i(a.class);
        } else {
            lifecycle.a(new b(lifecycle, cVar));
        }
    }
}
