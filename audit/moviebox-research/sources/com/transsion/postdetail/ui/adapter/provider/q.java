package com.transsion.postdetail.ui.adapter.provider;

import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.helper.ShortTvImmVideoHelper;
import com.transsion.postdetail.ui.view.ShortTvImmVideoItemView;
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
public final class q extends BaseItemProvider<Subject> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Fragment f55594f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f55595g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f55596h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f55597i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f55598j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f55599k;

    public q(Fragment fragment, String str, String str2, boolean z11) {
        Intrinsics.g(fragment, "fragment");
        this.f55594f = fragment;
        this.f55595g = str;
        this.f55596h = str2;
        this.f55597i = z11;
        this.f55598j = 1;
        this.f55599k = R$layout.item_short_tv_immersion_video;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return this.f55598j;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return this.f55599k;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public BaseViewHolder n(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        ShortTvImmVideoHelper.a aVar = ShortTvImmVideoHelper.f55051k;
        if (!aVar.a().j().isEmpty()) {
            View view = (View) kotlin.collections.k.H(aVar.a().j());
            if (view.getParent() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                return new BaseViewHolder(view);
            }
        }
        return super.n(parent, i11);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder holder, Subject item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        ((ShortTvImmVideoItemView) holder.getView(R$id.video_item)).setData(item, this.f55594f, Integer.valueOf(holder.getAdapterPosition()), this.f55595g, this.f55596h, this.f55597i);
    }
}
