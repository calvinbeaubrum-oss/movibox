package androidx.lifecycle;

import android.os.Bundle;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class SavedStateHandlesProvider implements f6.c.InterfaceC0670c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f6.c f8686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f8687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Bundle f8688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f8689d;

    public SavedStateHandlesProvider(f6.c savedStateRegistry, final y0 viewModelStoreOwner) {
        Intrinsics.g(savedStateRegistry, "savedStateRegistry");
        Intrinsics.g(viewModelStoreOwner, "viewModelStoreOwner");
        this.f8686a = savedStateRegistry;
        this.f8689d = LazyKt__LazyJVMKt.b(new Function0<p0>() { // from class: androidx.lifecycle.SavedStateHandlesProvider$viewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final p0 invoke() {
                return o0.e(viewModelStoreOwner);
            }
        });
    }

    public final Bundle a(String key) {
        Intrinsics.g(key, "key");
        c();
        Bundle bundle = this.f8688c;
        Bundle bundle2 = bundle != null ? bundle.getBundle(key) : null;
        Bundle bundle3 = this.f8688c;
        if (bundle3 != null) {
            bundle3.remove(key);
        }
        Bundle bundle4 = this.f8688c;
        if (bundle4 != null && bundle4.isEmpty()) {
            this.f8688c = null;
        }
        return bundle2;
    }

    public final p0 b() {
        return (p0) this.f8689d.getValue();
    }

    public final void c() {
        if (this.f8687b) {
            return;
        }
        Bundle bundleB = this.f8686a.b("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f8688c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (bundleB != null) {
            bundle.putAll(bundleB);
        }
        this.f8688c = bundle;
        this.f8687b = true;
        b();
    }

    @Override // f6.c.InterfaceC0670c
    public Bundle saveState() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f8688c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry<String, l0> entry : b().b().entrySet()) {
            String key = entry.getKey();
            Bundle bundleSaveState = entry.getValue().c().saveState();
            if (!Intrinsics.b(bundleSaveState, Bundle.EMPTY)) {
                bundle.putBundle(key, bundleSaveState);
            }
        }
        this.f8687b = false;
        return bundle;
    }
}
