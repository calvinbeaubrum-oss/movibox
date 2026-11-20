package com.transsion.home.adapter.trending.provider;

import android.content.Context;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.CornerTextView;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
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
public final class f extends BaseItemProvider<OperateItem> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f52292f;

    public f(int i11) {
        this.f52292f = (d0.e() - f0.a(((i11 - 1) * 8) + 24.0f)) / i11;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return PostItemType.GRID_SUBJECT.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.item_grid_feeds_subject;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, OperateItem item) {
        String url;
        String thumbnail;
        Cover cover;
        Cover cover2;
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        ShapeableImageView shapeableImageView = (ShapeableImageView) helper.getView(R$id.iv_cover);
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context contextG = g();
        Subject feedsSubject = item.getFeedsSubject();
        if (feedsSubject == null || (cover2 = feedsSubject.getCover()) == null || (url = cover2.getUrl()) == null) {
            url = "";
        }
        int i11 = this.f52292f;
        Subject feedsSubject2 = item.getFeedsSubject();
        if (feedsSubject2 == null || (cover = feedsSubject2.getCover()) == null || (thumbnail = cover.getThumbnail()) == null) {
            thumbnail = "";
        }
        companion.q(contextG, shapeableImageView, url, (8120 & 8) != 0 ? companion.d() : i11, (8120 & 16) != 0 ? companion.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
        int i12 = R$id.tv_title;
        Subject feedsSubject3 = item.getFeedsSubject();
        helper.setText(i12, feedsSubject3 != null ? feedsSubject3.getTitle() : null);
        CornerTextView cornerTextView = (CornerTextView) helper.getView(R$id.tv_tips);
        Subject feedsSubject4 = item.getFeedsSubject();
        String corner = feedsSubject4 != null ? feedsSubject4.getCorner() : null;
        Subject feedsSubject5 = item.getFeedsSubject();
        cornerTextView.setTextWithType(corner, feedsSubject5 != null ? feedsSubject5.getSubjectType() : null);
    }
}
