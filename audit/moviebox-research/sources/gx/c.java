package gx;

import android.content.Context;
import android.widget.ImageView;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.widget.R$string;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.bean.VerticalRank;
import com.transsion.search.fragment.result.ResultType;
import com.transsion.search.fragment.result.ResultWrapData;
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
public final class c extends BaseItemProvider<ResultWrapData> {
    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return ResultType.VERTICAL_RANK.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.provider_result_rank;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, ResultWrapData item) {
        Integer count;
        Cover cover;
        String thumbnail;
        Cover cover2;
        String url;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context contextG = g();
        ImageView imageView = (ImageView) helper.getView(R$id.search_result_provider_rank_cover);
        VerticalRank verticalRank = item.getVerticalRank();
        String string = "";
        String str = (verticalRank == null || (cover2 = verticalRank.getCover()) == null || (url = cover2.getUrl()) == null) ? "" : url;
        VerticalRank verticalRank2 = item.getVerticalRank();
        companion.q(contextG, imageView, str, (8120 & 8) != 0 ? companion.d() : 0, (8120 & 16) != 0 ? companion.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : (verticalRank2 == null || (cover = verticalRank2.getCover()) == null || (thumbnail = cover.getThumbnail()) == null) ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
        int i11 = R$id.search_result_provider_rank_title;
        VerticalRank verticalRank3 = item.getVerticalRank();
        helper.setText(i11, verticalRank3 != null ? verticalRank3.getTitle() : null);
        VerticalRank verticalRank4 = item.getVerticalRank();
        int iIntValue = (verticalRank4 == null || (count = verticalRank4.getCount()) == null) ? 0 : count.intValue();
        if (iIntValue <= 0) {
            VerticalRank verticalRank5 = item.getVerticalRank();
            if (verticalRank5 == null || (description = verticalRank5.getDescription()) == null) {
            }
            Intrinsics.f(description, "if (count > 0) {\n       …scription ?: \"\"\n        }");
            helper.setText(R$id.search_result_provider_rank_subtitle, description);
        }
        string = g().getString(R$string.sources, Integer.valueOf(iIntValue));
        String description = string;
        Intrinsics.f(description, "if (count > 0) {\n       …scription ?: \"\"\n        }");
        helper.setText(R$id.search_result_provider_rank_subtitle, description);
    }
}
