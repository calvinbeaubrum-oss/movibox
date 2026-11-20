package oq;

import com.blankj.utilcode.util.n;
import com.transsion.ad.strategy.AdMmkv;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.g;
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
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f72517a = new e();

    public final List<String> a() {
        Object objM163constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            List listL = (List) n.e(AdMmkv.f50558a.b().getString("member_scene_id_whit_list", ""), n.g(String.class));
            if (listL.isEmpty()) {
                listL = g.l();
            }
            objM163constructorimpl = Result.m163constructorimpl(listL);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        if (Result.m166exceptionOrNullimpl(objM163constructorimpl) != null) {
            objM163constructorimpl = g.l();
        }
        return (List) objM163constructorimpl;
    }

    public final boolean b() {
        return AdMmkv.f50558a.b().getBoolean("kv_is_skip_ad", false);
    }

    public final void c(List<String> strings) {
        Intrinsics.g(strings, "strings");
        AdMmkv.f50558a.b().putString("member_scene_id_whit_list", n.j(strings));
    }

    public final void d(boolean z11) {
        AdMmkv.f50558a.b().putBoolean("kv_is_skip_ad", z11);
    }
}
