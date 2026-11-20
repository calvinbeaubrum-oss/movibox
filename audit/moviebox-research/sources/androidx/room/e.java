package androidx.room;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.i1;

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
public final class e {
    public static final CoroutineDispatcher a(RoomDatabase roomDatabase) {
        Intrinsics.g(roomDatabase, "<this>");
        Map<String, Object> mapK = roomDatabase.k();
        Object objA = mapK.get("QueryDispatcher");
        if (objA == null) {
            objA = i1.a(roomDatabase.o());
            mapK.put("QueryDispatcher", objA);
        }
        Intrinsics.e(objA, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (CoroutineDispatcher) objA;
    }

    public static final CoroutineDispatcher b(RoomDatabase roomDatabase) {
        Intrinsics.g(roomDatabase, "<this>");
        Map<String, Object> mapK = roomDatabase.k();
        Object objA = mapK.get("TransactionDispatcher");
        if (objA == null) {
            objA = i1.a(roomDatabase.s());
            mapK.put("TransactionDispatcher", objA);
        }
        Intrinsics.e(objA, "null cannot be cast to non-null type kotlinx.coroutines.CoroutineDispatcher");
        return (CoroutineDispatcher) objA;
    }
}
