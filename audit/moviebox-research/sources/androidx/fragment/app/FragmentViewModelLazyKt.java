package androidx.fragment.app;

import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.t0;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

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
public final class FragmentViewModelLazyKt {
    public static final <VM extends t0> Lazy<VM> a(final Fragment fragment, KClass<VM> viewModelClass, Function0<? extends x0> storeProducer, Function0<? extends v0.c> function0) {
        Intrinsics.g(fragment, "<this>");
        Intrinsics.g(viewModelClass, "viewModelClass");
        Intrinsics.g(storeProducer, "storeProducer");
        if (function0 == null) {
            function0 = new Function0<v0.c>() { // from class: androidx.fragment.app.FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final v0.c invoke() {
                    v0.c defaultViewModelProviderFactory = fragment.getDefaultViewModelProviderFactory();
                    Intrinsics.f(defaultViewModelProviderFactory, "defaultViewModelProviderFactory");
                    return defaultViewModelProviderFactory;
                }
            };
        }
        return new ViewModelLazy(viewModelClass, storeProducer, function0);
    }
}
