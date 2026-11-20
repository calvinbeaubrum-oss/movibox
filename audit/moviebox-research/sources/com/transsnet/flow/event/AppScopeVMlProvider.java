package com.transsnet.flow.event;

import androidx.annotation.Keep;
import androidx.lifecycle.t0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes.dex */
@Keep
@Metadata
public final class AppScopeVMlProvider implements y0 {
    public static final AppScopeVMlProvider INSTANCE = new AppScopeVMlProvider();
    private static final x0 eventViewModelStore = new x0();
    private static final Lazy mApplicationProvider$delegate = LazyKt__LazyJVMKt.b(new Function0<v0>() { // from class: com.transsnet.flow.event.AppScopeVMlProvider$mApplicationProvider$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final v0 invoke() {
            return new v0(AppScopeVMlProvider.INSTANCE, v0.a.f8783e.a(a.f61410a.a()));
        }
    });

    private AppScopeVMlProvider() {
    }

    private final v0 getMApplicationProvider() {
        return (v0) mApplicationProvider$delegate.getValue();
    }

    public final <T extends t0> T getApplicationScopeViewModel(Class<T> modelClass) {
        Intrinsics.g(modelClass, "modelClass");
        return (T) getMApplicationProvider().a(modelClass);
    }

    @Override // androidx.lifecycle.y0
    public x0 getViewModelStore() {
        return eventViewModelStore;
    }
}
