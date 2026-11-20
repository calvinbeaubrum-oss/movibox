package com.transsion.postdetail.comment.ui;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.R$string;
import com.transsion.postdetail.bean.CommentBean;
import com.transsion.postdetail.util.i;
import h9.f;
import h9.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class a extends BaseProviderMultiAdapter<CommentBean> implements j {

    /* JADX INFO: renamed from: com.transsion.postdetail.comment.ui.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class C0586a extends BaseItemProvider<CommentBean> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f54981f = f0.a(32.0f);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f54982g = f0.a(51.0f);

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final int f54983h = f0.a(34.0f);

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public int h() {
            return 0;
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        public int i() {
            return R$layout.item_my_comment_list_layout;
        }

        @Override // com.chad.library.adapter.base.provider.BaseItemProvider
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public void a(BaseViewHolder helper, CommentBean item) {
            Cover cover;
            Intrinsics.g(helper, "helper");
            Intrinsics.g(item, "item");
            ImageView imageView = (ImageView) helper.getView(R$id.avatarIV);
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context contextG = g();
            String avatarUrl = item.getAvatarUrl();
            String str = avatarUrl == null ? "" : avatarUrl;
            int i11 = this.f54981f;
            companion.r(contextG, imageView, str, (4088 & 8) != 0 ? companion.d() : i11, (4088 & 16) != 0 ? companion.c() : i11, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
            ImageView imageView2 = (ImageView) helper.getView(R$id.contentIV);
            imageView2.setImageResource(0);
            List<Cover> imageList = item.getImageList();
            if (imageList != null && (cover = (Cover) CollectionsKt___CollectionsKt.g0(imageList)) != null) {
                Context contextG2 = g();
                String url = cover.getUrl();
                String str2 = url == null ? "" : url;
                int i12 = this.f54982g;
                int i13 = this.f54983h;
                String thumbnail = cover.getThumbnail();
                companion.q(contextG2, imageView2, str2, (8120 & 8) != 0 ? companion.d() : i12, (8120 & 16) != 0 ? companion.c() : i13, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : thumbnail == null ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
            }
            helper.setText(R$id.nameTV, item.getNickName());
            helper.setText(R$id.commentTV, item.getContent());
            TextView textView = (TextView) helper.getView(R$id.timeTV);
            Long createdAt = item.getCreatedAt();
            if (createdAt != null) {
                textView.setText(g().getString(R$string.comment_post_time, i.b(createdAt.longValue())));
            }
            textView.setVisibility(createdAt != null ? 0 : 8);
        }
    }

    public a() {
        super(null, 1, null);
        K0(new C0586a());
    }

    @Override // com.chad.library.adapter.base.BaseProviderMultiAdapter
    public int S0(List<? extends CommentBean> data, int i11) {
        Intrinsics.g(data, "data");
        return 0;
    }

    @Override // h9.j
    public /* synthetic */ f a(BaseQuickAdapter baseQuickAdapter) {
        return h9.i.a(this, baseQuickAdapter);
    }
}
