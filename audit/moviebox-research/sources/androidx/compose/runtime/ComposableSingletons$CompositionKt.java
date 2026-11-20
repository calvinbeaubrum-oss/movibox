package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

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
public final class ComposableSingletons$CompositionKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ComposableSingletons$CompositionKt f3236a = new ComposableSingletons$CompositionKt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Function2<i, Integer, Unit> f3237b = androidx.compose.runtime.internal.b.c(954879418, false, new Function2<i, Integer, Unit>() { // from class: androidx.compose.runtime.ComposableSingletons$CompositionKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(i iVar, Integer num) {
            invoke(iVar, num.intValue());
            return Unit.f68710a;
        }

        public final void invoke(i iVar, int i11) {
            if ((i11 & 3) == 2 && iVar.h()) {
                iVar.H();
                return;
            }
            if (k.J()) {
                k.S(954879418, i11, -1, "androidx.compose.runtime.ComposableSingletons$CompositionKt.lambda-1.<anonymous> (Composition.kt:623)");
            }
            if (k.J()) {
                k.R();
            }
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Function2<i, Integer, Unit> f3238c = androidx.compose.runtime.internal.b.c(1918065384, false, new Function2<i, Integer, Unit>() { // from class: androidx.compose.runtime.ComposableSingletons$CompositionKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(i iVar, Integer num) {
            invoke(iVar, num.intValue());
            return Unit.f68710a;
        }

        public final void invoke(i iVar, int i11) {
            if ((i11 & 3) == 2 && iVar.h()) {
                iVar.H();
                return;
            }
            if (k.J()) {
                k.S(1918065384, i11, -1, "androidx.compose.runtime.ComposableSingletons$CompositionKt.lambda-2.<anonymous> (Composition.kt:757)");
            }
            if (k.J()) {
                k.R();
            }
        }
    });

    public final Function2<i, Integer, Unit> a() {
        return f3237b;
    }

    public final Function2<i, Integer, Unit> b() {
        return f3238c;
    }
}
