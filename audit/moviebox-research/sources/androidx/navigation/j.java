package androidx.navigation;

import android.content.Context;
import androidx.activity.OnBackPressedDispatcher;
import androidx.lifecycle.u;
import androidx.lifecycle.x0;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public class j extends NavController {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(Context context) {
        super(context);
        Intrinsics.g(context, "context");
    }

    @Override // androidx.navigation.NavController
    public final void d0(u owner) {
        Intrinsics.g(owner, "owner");
        super.d0(owner);
    }

    @Override // androidx.navigation.NavController
    public final void e0(OnBackPressedDispatcher dispatcher) {
        Intrinsics.g(dispatcher, "dispatcher");
        super.e0(dispatcher);
    }

    @Override // androidx.navigation.NavController
    public final void f0(x0 viewModelStore) {
        Intrinsics.g(viewModelStore, "viewModelStore");
        super.f0(viewModelStore);
    }

    @Override // androidx.navigation.NavController
    public final void r(boolean z11) {
        super.r(z11);
    }
}
