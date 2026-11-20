package zw;

import android.content.Context;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.search.R$id;
import com.transsion.search.R$layout;
import com.transsion.search.bean.SearchSubject;
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
public final class a extends BaseItemProvider<SearchSubject> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f82183f = f0.a(72.0f);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f82184g = f0.a(96.0f);

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return 1;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.item_associate_subject;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, SearchSubject item) {
        String url;
        Cover cover;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        ShapeableImageView shapeableImageView = (ShapeableImageView) helper.getViewOrNull(R$id.ivCover);
        if (shapeableImageView != null) {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            VerticalRank verticalRank = item.getVerticalRank();
            if (verticalRank == null || (cover = verticalRank.getCover()) == null || (url = cover.getUrl()) == null) {
                url = "";
            }
            String strE = companion.e(url, (124 & 2) != 0 ? 0 : this.f82183f, (124 & 4) != 0 ? 0 : this.f82184g, (124 & 8) != 0, (124 & 16) != 0 ? false : false, (124 & 32) == 0 ? false : false, (124 & 64) != 0 ? 25 : 0);
            Context context = shapeableImageView.getContext();
            Intrinsics.f(context, "context");
            companion.r(context, shapeableImageView, strE, (4088 & 8) != 0 ? companion.d() : 0, (4088 & 16) != 0 ? companion.c() : 0, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) helper.getViewOrNull(R$id.tvTitle);
        if (appCompatTextView != null) {
            VerticalRank verticalRank2 = item.getVerticalRank();
            appCompatTextView.setText(verticalRank2 != null ? verticalRank2.getTitle() : null);
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) helper.getViewOrNull(R$id.tvDes);
        if (appCompatTextView2 != null) {
            VerticalRank verticalRank3 = item.getVerticalRank();
            appCompatTextView2.setText(verticalRank3 != null ? verticalRank3.getDescription() : null);
        }
        View viewOrNull = helper.getViewOrNull(R$id.divider);
        if (viewOrNull != null) {
            if (item.getShowDivider()) {
                so.c.k(viewOrNull);
            } else {
                so.c.g(viewOrNull);
            }
        }
    }
}
