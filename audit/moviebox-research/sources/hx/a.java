package hx;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.bean.SuggestEntity;
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
public final class a extends BaseItemProvider<SuggestEntity> {
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return 0;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.fragment_search_suggest_copy_writing_layout;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, SuggestEntity item) {
        String strV0;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        int i11 = R$id.tvSearchSuggest;
        com.transsion.search.fragment.suggest.b.a aVar = com.transsion.search.fragment.suggest.b.J;
        BaseProviderMultiAdapter<SuggestEntity> baseProviderMultiAdapterC = c();
        com.transsion.search.fragment.suggest.b bVar = baseProviderMultiAdapterC instanceof com.transsion.search.fragment.suggest.b ? (com.transsion.search.fragment.suggest.b) baseProviderMultiAdapterC : null;
        if (bVar == null || (strV0 = bVar.V0()) == null) {
            strV0 = "";
        }
        helper.setText(i11, aVar.a(strV0, item.getWord()));
    }
}
