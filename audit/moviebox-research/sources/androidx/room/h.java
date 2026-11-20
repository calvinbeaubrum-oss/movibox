package androidx.room;

import java.util.Iterator;
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
public abstract class h<T> extends SharedSQLiteStatement {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(RoomDatabase database) {
        super(database);
        Intrinsics.g(database, "database");
    }

    public abstract void i(g6.k kVar, T t11);

    public final int j(T t11) {
        g6.k kVarB = b();
        try {
            i(kVarB, t11);
            return kVarB.F();
        } finally {
            h(kVarB);
        }
    }

    public final int k(Iterable<? extends T> entities) {
        Intrinsics.g(entities, "entities");
        g6.k kVarB = b();
        try {
            Iterator<? extends T> it = entities.iterator();
            int iF = 0;
            while (it.hasNext()) {
                i(kVarB, it.next());
                iF += kVarB.F();
            }
            h(kVarB);
            return iF;
        } catch (Throwable th2) {
            h(kVarB);
            throw th2;
        }
    }
}
