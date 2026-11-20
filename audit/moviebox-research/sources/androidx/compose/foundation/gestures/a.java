package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.z;
import java.util.List;
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
public final class a implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f2357a = new a();

    @Override // androidx.compose.foundation.gestures.j
    public long a(q2.e eVar, androidx.compose.ui.input.pointer.q qVar, long j11) {
        List<z> listC = qVar.c();
        y1.g gVarD = y1.g.d(y1.g.f81070b.c());
        int size = listC.size();
        for (int i11 = 0; i11 < size; i11++) {
            gVarD = y1.g.d(y1.g.r(gVarD.v(), listC.get(i11).m()));
        }
        return y1.g.s(gVarD.v(), -eVar.N0(q2.i.h(64)));
    }
}
