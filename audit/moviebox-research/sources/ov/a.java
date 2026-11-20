package ov;

import androidx.media3.common.n0;
import androidx.media3.common.q0;
import androidx.media3.common.y;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.g1;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class a {
    public static final n0 a(q0 q0Var, d mediaTrackGroup) {
        Intrinsics.g(q0Var, "<this>");
        Intrinsics.g(mediaTrackGroup, "mediaTrackGroup");
        g1<q0.a> it = q0Var.a().iterator();
        while (it.hasNext()) {
            q0.a next = it.next();
            if (Intrinsics.b(next.a().f9331b, mediaTrackGroup.c()) && next.a().f9332c == mediaTrackGroup.e()) {
                return next.a();
            }
        }
        return null;
    }

    public static final b b(y yVar) {
        Intrinsics.g(yVar, "<this>");
        return new b(yVar.f9489a, yVar.f9490b, yVar.f9492d, yVar.f9493e, yVar.f9495g, yVar.f9496h, yVar.f9497i, yVar.f9498j, yVar.f9506r, yVar.f9507s, yVar.f9508t, yVar.f9509u, yVar.f9510v);
    }

    public static final c c(q0 q0Var) {
        Intrinsics.g(q0Var, "<this>");
        if (q0Var.b()) {
            return new c(null, 1, null);
        }
        int size = q0Var.a().size();
        d[] dVarArr = new d[size];
        for (int i11 = 0; i11 < size; i11++) {
            q0.a aVar = q0Var.a().get(i11);
            Intrinsics.f(aVar, "this.groups[it]");
            dVarArr[i11] = d(aVar);
        }
        ImmutableList immutableListCopyOf = ImmutableList.copyOf(dVarArr);
        Intrinsics.f(immutableListCopyOf, "copyOf(arrayList)");
        return new c(immutableListCopyOf);
    }

    public static final d d(q0.a aVar) {
        Intrinsics.g(aVar, "<this>");
        int i11 = aVar.f9435a;
        b[] bVarArr = new b[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            y yVarB = aVar.b(i12);
            Intrinsics.f(yVarB, "this.getTrackFormat(it)");
            bVarArr[i12] = b(yVarB);
        }
        return new d(aVar.f9435a, aVar.a().f9331b, aVar.a().f9332c, aVar.e(), bVarArr);
    }
}
