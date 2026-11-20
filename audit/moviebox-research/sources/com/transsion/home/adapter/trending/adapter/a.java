package com.transsion.home.adapter.trending.adapter;

import android.content.Context;
import android.view.ViewGroup;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.widget.TnTextView;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.bean.AhaGameAllGames;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import java.util.List;
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
public final class a extends BaseQuickAdapter<AhaGameAllGames, BaseViewHolder> {
    public final int H;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(List<AhaGameAllGames> datas) {
        super(R$layout.adapter_game_list, datas);
        Intrinsics.g(datas, "datas");
        this.H = (d0.e() - f0.a(48.0f)) / 4;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: G0, reason: merged with bridge method [inline-methods] */
    public void x(BaseViewHolder holder, AhaGameAllGames item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) holder.getViewOrNull(R$id.item_root);
        if (linearLayoutCompat != null) {
            ViewGroup.LayoutParams layoutParams = linearLayoutCompat.getLayoutParams();
            layoutParams.width = this.H;
            layoutParams.height = -2;
            linearLayoutCompat.setLayoutParams(layoutParams);
        }
        TnTextView tnTextView = (TnTextView) holder.getViewOrNull(R$id.tv_name);
        if (tnTextView != null) {
            tnTextView.setTextWithString(item.getName());
        }
        ShapeableImageView shapeableImageView = (ShapeableImageView) holder.getViewOrNull(R$id.iv_cover);
        if (shapeableImageView != null) {
            ViewGroup.LayoutParams layoutParams2 = shapeableImageView.getLayoutParams();
            int i11 = this.H;
            layoutParams2.width = i11;
            layoutParams2.height = i11;
            shapeableImageView.setLayoutParams(layoutParams2);
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context context = shapeableImageView.getContext();
            Intrinsics.f(context, "context");
            String iconPictureLink = item.getIconPictureLink();
            if (iconPictureLink == null) {
                iconPictureLink = "";
            }
            int i12 = this.H;
            companion.r(context, shapeableImageView, iconPictureLink, (4088 & 8) != 0 ? companion.d() : i12, (4088 & 16) != 0 ? companion.c() : i12, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
        }
    }
}
