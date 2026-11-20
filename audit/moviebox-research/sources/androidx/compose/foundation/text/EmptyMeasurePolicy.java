package androidx.compose.foundation.text;

import androidx.compose.ui.layout.k0;
import androidx.compose.ui.layout.t;
import androidx.compose.ui.layout.u;
import androidx.compose.ui.layout.w;
import androidx.compose.ui.layout.x;
import androidx.compose.ui.layout.y;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

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
public final class EmptyMeasurePolicy implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final EmptyMeasurePolicy f2861a = new EmptyMeasurePolicy();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Function1<k0.a, Unit> f2862b = new Function1<k0.a, Unit>() { // from class: androidx.compose.foundation.text.EmptyMeasurePolicy$placementBlock$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(k0.a aVar) {
            invoke2(aVar);
            return Unit.f68710a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(k0.a aVar) {
        }
    };

    @Override // androidx.compose.ui.layout.u
    public w c(y yVar, List<? extends t> list, long j11) {
        return x.b(yVar, q2.b.l(j11), q2.b.k(j11), null, f2862b, 4, null);
    }
}
