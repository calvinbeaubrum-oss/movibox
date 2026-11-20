package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.SnapshotStateList;
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
public final /* synthetic */ class u2 {
    public static final <T> SnapshotStateList<T> a() {
        return new SnapshotStateList<>();
    }

    public static final <T> i1<T> b(T t11, q2<T> q2Var) {
        return ActualAndroid_androidKt.c(t11, q2Var);
    }

    public static /* synthetic */ i1 c(Object obj, q2 q2Var, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            q2Var = r2.j();
        }
        return r2.e(obj, q2Var);
    }

    public static final <T> a3<T> d(T t11, i iVar, int i11) {
        if (k.J()) {
            k.S(-1058319986, i11, -1, "androidx.compose.runtime.rememberUpdatedState (SnapshotState.kt:309)");
        }
        Object objY = iVar.y();
        if (objY == i.f3413a.a()) {
            objY = c(t11, null, 2, null);
            iVar.p(objY);
        }
        i1 i1Var = (i1) objY;
        i1Var.setValue(t11);
        if (k.J()) {
            k.R();
        }
        return i1Var;
    }
}
