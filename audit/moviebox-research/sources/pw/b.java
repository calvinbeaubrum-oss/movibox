package pw;

import com.quickjs.JSArray;
import com.quickjs.JSFunction;
import com.quickjs.JSObject;
import com.quickjs.c0;
import com.quickjs.e0;
import com.quickjs.y;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class b extends e0 {
    public static final void d(y yVar, JSObject jSObject, JSArray jSArray) {
        Object obj = jSArray.get(0);
        Intrinsics.e(obj, "null cannot be cast to non-null type com.quickjs.JSFunction");
        yVar.q(jSArray.getString(1), (JSFunction) obj);
    }

    @Override // com.quickjs.e0
    public void a(y yVar) {
    }

    @Override // com.quickjs.e0
    public void b(final y yVar) {
        if (yVar != null) {
            yVar.p(new c0() { // from class: pw.a
                @Override // com.quickjs.c0
                public final void a(JSObject jSObject, JSArray jSArray) {
                    b.d(yVar, jSObject, jSArray);
                }
            }, "addFunction");
        }
    }
}
