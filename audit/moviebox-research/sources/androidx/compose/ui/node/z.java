package androidx.compose.ui.node;

import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes2.dex */
@Metadata
@SourceDebugExtension
public final class z {
    public static final int b(LookaheadCapablePlaceable lookaheadCapablePlaceable, androidx.compose.ui.layout.a aVar) {
        LookaheadCapablePlaceable lookaheadCapablePlaceableR0 = lookaheadCapablePlaceable.R0();
        if (!(lookaheadCapablePlaceableR0 != null)) {
            h2.a.b("Child of " + lookaheadCapablePlaceable + " cannot be null when calculating alignment line");
        }
        if (lookaheadCapablePlaceable.Y0().l().containsKey(aVar)) {
            Integer num = lookaheadCapablePlaceable.Y0().l().get(aVar);
            if (num != null) {
                return num.intValue();
            }
            return Integer.MIN_VALUE;
        }
        int iO0 = lookaheadCapablePlaceableR0.O0(aVar);
        if (iO0 == Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        lookaheadCapablePlaceableR0.n1(true);
        lookaheadCapablePlaceable.m1(true);
        lookaheadCapablePlaceable.l1();
        lookaheadCapablePlaceableR0.n1(false);
        lookaheadCapablePlaceable.m1(false);
        return iO0 + (aVar instanceof androidx.compose.ui.layout.i ? q2.p.i(lookaheadCapablePlaceableR0.d1()) : q2.p.h(lookaheadCapablePlaceableR0.d1()));
    }
}
