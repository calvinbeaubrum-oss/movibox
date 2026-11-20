package rs;

import android.widget.ImageView;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.ad.ps.model.ItemDetail;
import com.transsion.ad.ps.model.RecommendInfo;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.commercialization.R$id;
import com.transsion.commercialization.R$layout;
import com.transsion.commercialization.pslink.PsLinkDownLoadButton;
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
public final class c extends BaseItemProvider<RecommendInfo> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f75724f = f0.a(64.0f);

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return 1;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.item_adapter_ps_link_linear_layout;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, RecommendInfo item) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        int i11 = R$id.tvName;
        ItemDetail detail = item.getDetail();
        helper.setText(i11, detail != null ? detail.getName() : null);
        helper.setText(R$id.tvStarNum, item.getStar() + " ");
        helper.setText(R$id.tvSizeNum, tp.a.a(item.getSize(), 1));
        int i12 = R$id.tvDescription;
        ItemDetail detail2 = item.getDetail();
        helper.setText(i12, detail2 != null ? detail2.getSimpleDescription() : null);
        ImageHelper.Companion companion = ImageHelper.f51371a;
        String iconUrl = item.getIconUrl();
        if (iconUrl == null) {
            iconUrl = "";
        }
        int i13 = this.f75724f;
        companion.r(g(), (ImageView) helper.getView(R$id.ivIcon), companion.e(iconUrl, (124 & 2) != 0 ? 0 : i13, (124 & 4) != 0 ? 0 : i13, (124 & 8) != 0, (124 & 16) != 0 ? false : true, (124 & 32) == 0 ? false : false, (124 & 64) != 0 ? 25 : 0), (4088 & 8) != 0 ? companion.d() : 0, (4088 & 16) != 0 ? companion.c() : 0, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
        ((PsLinkDownLoadButton) helper.getView(R$id.tvButton)).setItemInfo(item);
    }
}
