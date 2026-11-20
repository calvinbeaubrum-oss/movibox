package com.transsion.home.adapter.suboperate.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.BannerData;
import com.transsion.moviedetailapi.bean.CustomData;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.OperateItem;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;

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
public final class SubCustomAdapter extends BaseQuickAdapter<BannerData, BaseViewHolder> {
    public final OperateItem H;
    public final CustomData I;
    public final int J;
    public final boolean K;
    public final int L;
    public final int M;
    public final boolean N;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Code duplicated, block: B:29:0x0067  */
    public SubCustomAdapter(int i11, OperateItem operateItem, CustomData customData, BannerData bannerData, int i12, boolean z11) {
        Boolean hiddenTitle;
        Image image;
        Integer width;
        Image image2;
        Integer height;
        List<BannerData> items;
        BannerData bannerData2;
        super(i11, null, 2, null);
        Intrinsics.g(operateItem, "operateItem");
        String content = null;
        this.H = operateItem;
        this.I = customData;
        this.J = i12;
        this.K = z11;
        int iIntValue = 1;
        boolean zBooleanValue = false;
        int iD = kotlin.ranges.a.d(customData != null ? customData.getRowCount() : 1, 1) + (z11 ? 2 : 0);
        int iB = f0.b(kotlin.ranges.a.g(d0.e(), d0.c()));
        List<BannerData> items2 = customData != null ? customData.getItems() : null;
        if (items2 != null && !items2.isEmpty()) {
            if (customData != null && (items = customData.getItems()) != null && (bannerData2 = items.get(0)) != null) {
                content = bannerData2.getContent();
            }
            if (content == null || content.length() == 0) {
                zBooleanValue = true;
            } else if (customData != null) {
                zBooleanValue = hiddenTitle.booleanValue();
            }
        } else if (customData != null && (hiddenTitle = customData.getHiddenTitle()) != null) {
            zBooleanValue = hiddenTitle.booleanValue();
        }
        this.N = zBooleanValue;
        int iA = f0.a(((((iB - 12) - (iD * 8)) - 12) * 1.0f) / iD);
        this.L = iA;
        float fIntValue = ((bannerData == null || (image2 = bannerData.getImage()) == null || (height = image2.getHeight()) == null) ? 1 : height.intValue()) * 1.0f;
        if (bannerData != null && (image = bannerData.getImage()) != null && (width = image.getWidth()) != null) {
            iIntValue = width.intValue();
        }
        this.M = (int) ((fIntValue / iIntValue) * iA);
    }

    public /* synthetic */ SubCustomAdapter(int i11, OperateItem operateItem, CustomData customData, BannerData bannerData, int i12, boolean z11, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? R$layout.item_sub_operation_variable_item : i11, operateItem, customData, bannerData, i12, z11);
    }

    private final void H0(BannerData bannerData, int i11) {
        HashMap map = new HashMap();
        map.put("event_type", "browse_custom_item");
        map.put("sequence", String.valueOf(i11));
        CustomData customData = this.I;
        map.put("rowCount", String.valueOf(customData != null ? Integer.valueOf(customData.getRowCount()) : null));
        map.put("tabId", String.valueOf(this.J));
        if (bannerData != null) {
            ot.b.b(bannerData, map);
        }
        ot.b.a(this.H, map);
        com.transsion.baselib.helper.a.f51183a.d(SubTabFragment.f52541r.a(this.J), map);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, BannerData item) {
        String url;
        String thumbnail;
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        if (this.L < 10 || this.M < 10) {
            return;
        }
        r(holder, getItemViewType(holder.getBindingAdapterPosition()));
        ImageView imageView = (ImageView) holder.getView(R$id.sub_operation_variable_image);
        TextView textView = (TextView) holder.getView(R$id.sub_operation_variable_item_title);
        imageView.getLayoutParams().width = this.L;
        imageView.getLayoutParams().height = this.M;
        textView.setMaxWidth(this.L);
        if (this.N) {
            so.c.g(textView);
        } else {
            so.c.k(textView);
        }
        if (item.getBuiltIn()) {
            kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new SubCustomAdapter$convert$1(item, imageView, null), 3, null);
        } else {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context context = getContext();
            Image image = item.getImage();
            if (image == null || (url = image.getUrl()) == null) {
                url = "";
            }
            Image image2 = item.getImage();
            if (image2 == null || (thumbnail = image2.getThumbnail()) == null) {
                thumbnail = "";
            }
            companion.q(context, imageView, url, (8120 & 8) != 0 ? companion.d() : 0, (8120 & 16) != 0 ? companion.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
        }
        textView.setText(item.getContent());
        H0(item, D().indexOf(item));
    }
}
