package hx;

import android.content.Context;
import android.widget.ImageView;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R$color;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.search.R$drawable;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.bean.SuggestEntity;
import com.transsion.search.bean.VerticalRank;
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
public final class b extends BaseItemProvider<SuggestEntity> {
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return 2;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.fragment_search_suggest_list_cover_layout;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, SuggestEntity item) {
        String strV0;
        Cover cover;
        String url;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context contextG = g();
        ImageView imageView = (ImageView) helper.getView(R$id.ivCover);
        VerticalRank verticalRank = item.getVerticalRank();
        companion.o(contextG, imageView, (verticalRank == null || (cover = verticalRank.getCover()) == null || (url = cover.getUrl()) == null) ? "" : url, (32704 & 8) != 0 ? R$color.skeleton : R$drawable.ic_list_cover, (32704 & 16) != 0 ? companion.d() : 0, (32704 & 32) != 0 ? companion.c() : 0, (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : null, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
        int i11 = R$id.tvTitle;
        com.transsion.search.fragment.suggest.b.a aVar = com.transsion.search.fragment.suggest.b.J;
        BaseProviderMultiAdapter<SuggestEntity> baseProviderMultiAdapterC = c();
        com.transsion.search.fragment.suggest.b bVar = baseProviderMultiAdapterC instanceof com.transsion.search.fragment.suggest.b ? (com.transsion.search.fragment.suggest.b) baseProviderMultiAdapterC : null;
        if (bVar == null || (strV0 = bVar.V0()) == null) {
            strV0 = "";
        }
        VerticalRank verticalRank2 = item.getVerticalRank();
        helper.setText(i11, aVar.a(strV0, verticalRank2 != null ? verticalRank2.getTitle() : null));
        int i12 = R$id.tvDes;
        VerticalRank verticalRank3 = item.getVerticalRank();
        helper.setText(i12, verticalRank3 != null ? verticalRank3.getDescription() : null);
    }
}
