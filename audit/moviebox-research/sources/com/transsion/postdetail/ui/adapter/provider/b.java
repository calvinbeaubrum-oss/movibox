package com.transsion.postdetail.ui.adapter.provider;

import androidx.fragment.app.Fragment;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.ui.view.ImmVideoItemView;
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
public final class b extends BaseItemProvider<PostSubjectItem> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Fragment f55578f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f55579g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f55580h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f55581i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f55582j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final String f55583k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f55584l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f55585m;

    public b(Fragment fragment, boolean z11, String str, String str2, boolean z12, String commentId) {
        Intrinsics.g(fragment, "fragment");
        Intrinsics.g(commentId, "commentId");
        this.f55578f = fragment;
        this.f55579g = z11;
        this.f55580h = str;
        this.f55581i = str2;
        this.f55582j = z12;
        this.f55583k = commentId;
        this.f55584l = 1;
        this.f55585m = R$layout.item_immersion_video;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return this.f55584l;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return this.f55585m;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder holder, PostSubjectItem item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        ((ImmVideoItemView) holder.getView(R$id.view_video_item)).setData(item, this.f55578f, Integer.valueOf(holder.getAdapterPosition()), this.f55579g, this.f55580h, this.f55581i, this.f55582j, this.f55583k);
    }
}
