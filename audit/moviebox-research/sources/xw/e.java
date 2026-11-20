package xw;

import android.content.Context;
import com.transsion.search.constant.SearchConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.mvel2.ast.ASTNode;

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
public final class e implements es.b {
    @Override // es.b
    public void a(String keyword, String hotWord, List<String> searchHotWords, Context context) {
        Intrinsics.g(keyword, "keyword");
        Intrinsics.g(hotWord, "hotWord");
        Intrinsics.g(searchHotWords, "searchHotWords");
        Intrinsics.g(context, "context");
        com.alibaba.android.arouter.launcher.a.d().b("/search/activity/search_manager").withInt("type", 3).withString("hot_search_word", hotWord).withString("keyword", keyword).navigation(context);
        SearchConstants.f57439a.c(searchHotWords);
    }

    @Override // es.b
    public void b(String hotWord, List<String> searchHotWords, Context context) {
        Intrinsics.g(hotWord, "hotWord");
        Intrinsics.g(searchHotWords, "searchHotWords");
        Intrinsics.g(context, "context");
        com.alibaba.android.arouter.launcher.a.d().b("/search/activity/search_manager").withInt("type", 3).withString("hot_search_word", hotWord).navigation(context);
        SearchConstants.f57439a.c(searchHotWords);
    }

    @Override // es.b
    public void c(String hotWord, Context context) {
        Intrinsics.g(hotWord, "hotWord");
        Intrinsics.g(context, "context");
        com.alibaba.android.arouter.launcher.a.d().b("/search/activity/search_manager").withInt("type", 3).withString("hot_search_word", hotWord).navigation(context);
    }

    @Override // es.b
    public void d(Context context) {
        Intrinsics.g(context, "context");
        com.alibaba.android.arouter.launcher.a.d().b("/search/activity/search_manager").withInt("type", 1).addFlags(ASTNode.DEOP).navigation(context);
    }
}
