package androidx.activity;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
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
public final class r {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1<p, Unit> f654a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(boolean z11, Function1<? super p, Unit> function1) {
            super(z11);
            this.f654a = function1;
        }

        @Override // androidx.activity.p
        public void handleOnBackPressed() {
            this.f654a.invoke(this);
        }
    }

    public static final p a(OnBackPressedDispatcher onBackPressedDispatcher, androidx.lifecycle.u uVar, boolean z11, Function1<? super p, Unit> onBackPressed) {
        Intrinsics.g(onBackPressedDispatcher, "<this>");
        Intrinsics.g(onBackPressed, "onBackPressed");
        a aVar = new a(z11, onBackPressed);
        if (uVar != null) {
            onBackPressedDispatcher.i(uVar, aVar);
        } else {
            onBackPressedDispatcher.h(aVar);
        }
        return aVar;
    }

    public static /* synthetic */ p b(OnBackPressedDispatcher onBackPressedDispatcher, androidx.lifecycle.u uVar, boolean z11, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            uVar = null;
        }
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        return a(onBackPressedDispatcher, uVar, z11, function1);
    }
}
