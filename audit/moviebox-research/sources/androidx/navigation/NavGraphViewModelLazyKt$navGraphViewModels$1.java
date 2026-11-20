package androidx.navigation;

import androidx.lifecycle.v0;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

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
public final class NavGraphViewModelLazyKt$navGraphViewModels$1 extends Lambda implements Function0<v0.c> {
    final /* synthetic */ Lazy<NavBackStackEntry> $backStackEntry$delegate;
    final /* synthetic */ Function0<v0.c> $factoryProducer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NavGraphViewModelLazyKt$navGraphViewModels$1(Function0<? extends v0.c> function0, Lazy<NavBackStackEntry> lazy) {
        super(0);
        this.$factoryProducer = function0;
        this.$backStackEntry$delegate = lazy;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final v0.c invoke() {
        Function0<v0.c> function0 = this.$factoryProducer;
        v0.c cVarInvoke = function0 == null ? null : function0.invoke();
        return cVarInvoke == null ? i.c(this.$backStackEntry$delegate).getDefaultViewModelProviderFactory() : cVarInvoke;
    }
}
