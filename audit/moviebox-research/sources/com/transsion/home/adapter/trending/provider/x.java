package com.transsion.home.adapter.trending.provider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.blankj.utilcode.util.d0;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baseui.adapter.BaseItemBindingProvider;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.SingleImagePage;
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
public final class x extends BaseItemBindingProvider<OperateItem, lt.y> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f52327g = d0.e() - gs.a.a(24);

    public static final void y(BaseViewHolder helper, OperateItem item, View view) {
        String deepLink;
        Intrinsics.g(helper, "$helper");
        Intrinsics.g(item, "$item");
        pr.a.f74040a.q(helper.getBindingAdapterPosition(), item);
        SingleImagePage page = item.getPage();
        if (page == null || (deepLink = page.getDeepLink()) == null) {
            deepLink = item.getDeepLink();
        }
        if (deepLink != null) {
            com.transsion.baselib.utils.i.e(deepLink, null, 1, null);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return PostItemType.SINGLE_IMAGE.ordinal();
    }

    @Override // com.transsion.baseui.adapter.BaseItemBindingProvider
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void u(lt.y binding, final BaseViewHolder helper, final OperateItem item) {
        Image image;
        String url;
        String thumbnail;
        Image image2;
        Image image3;
        Image image4;
        Integer width;
        Image image5;
        Integer height;
        Intrinsics.g(binding, "binding");
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        binding.f70535c.setText(item.getTitle());
        helper.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.trending.provider.w
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                x.y(helper, item, view);
            }
        });
        SingleImagePage page = item.getPage();
        int iIntValue = (page == null || (image5 = page.getImage()) == null || (height = image5.getHeight()) == null) ? 0 : height.intValue();
        SingleImagePage page2 = item.getPage();
        int iIntValue2 = (page2 == null || (image4 = page2.getImage()) == null || (width = image4.getWidth()) == null) ? 1 : width.intValue();
        int i11 = this.f52327g;
        float f11 = ((i11 * iIntValue) * 1.0f) / iIntValue2;
        uo.b.a aVar = uo.b.f78622a;
        SingleImagePage page3 = item.getPage();
        uo.b.a.f(aVar, "SingleImage", "imgH:" + iIntValue + ",imgW:" + iIntValue2 + " imageViewHeight:" + f11 + ", imageViewWidth:" + i11 + "， url:" + ((page3 == null || (image3 = page3.getImage()) == null) ? null : image3.getUrl()), false, 4, null);
        ViewGroup.LayoutParams layoutParams = binding.f70534b.getLayoutParams();
        layoutParams.height = (int) f11;
        binding.f70534b.setLayoutParams(layoutParams);
        SingleImagePage page4 = item.getPage();
        if (page4 == null || (image = page4.getImage()) == null || (url = image.getUrl()) == null) {
            return;
        }
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context context = binding.f70534b.getContext();
        ShapeableImageView ivCover = binding.f70534b;
        SingleImagePage page5 = item.getPage();
        if (page5 == null || (image2 = page5.getImage()) == null || (thumbnail = image2.getThumbnail()) == null) {
            thumbnail = "";
        }
        String str = thumbnail;
        int i12 = this.f52327g;
        Intrinsics.f(context, "context");
        Intrinsics.f(ivCover, "ivCover");
        companion.q(context, ivCover, url, (8120 & 8) != 0 ? companion.d() : i12, (8120 & 16) != 0 ? companion.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : str, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
    }

    @Override // com.transsion.baseui.adapter.BaseItemBindingProvider
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public lt.y v(LayoutInflater inflater, ViewGroup parent) {
        Intrinsics.g(inflater, "inflater");
        Intrinsics.g(parent, "parent");
        lt.y yVarC = lt.y.c(LayoutInflater.from(g()), parent, false);
        Intrinsics.f(yVarC, "inflate(LayoutInflater.f…(context), parent, false)");
        return yVarC;
    }
}
