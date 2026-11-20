package iv;

import com.transsion.baselib.report.m;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.s;

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
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f67718a = new c();

    public final void a(String str, String str2, boolean z11) {
        m mVar = m.f51277a;
        if (str == null) {
            str = mVar.f();
        }
        Pair[] pairArr = new Pair[3];
        pairArr[0] = new Pair("module_name", "play_screen");
        pairArr[1] = new Pair("subject_id", str2);
        pairArr[2] = new Pair("type", z11 ? "1" : "0");
        mVar.m(str, "click", s.k(pairArr));
    }
}
