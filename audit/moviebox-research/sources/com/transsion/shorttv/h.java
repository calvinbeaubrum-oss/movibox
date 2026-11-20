package com.transsion.shorttv;

import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.shorttv.widget.ImmVideoHelper;
import com.transsion.shorttv.widget.ShortTvVideoItemView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.k;
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
public final class h extends BaseItemProvider<qx.e> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ShortTvBaseListFragment f57877f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f57878g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f57879h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f57880i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f57881j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final int f57882k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f57883l;

    public h(ShortTvBaseListFragment fragment, boolean z11, String str, String str2, boolean z12) {
        Intrinsics.g(fragment, "fragment");
        this.f57877f = fragment;
        this.f57878g = z11;
        this.f57879h = str;
        this.f57880i = str2;
        this.f57881j = z12;
        this.f57882k = 1;
        this.f57883l = R$layout.short_tv_item_video;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return this.f57882k;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return this.f57883l;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public BaseViewHolder n(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        ImmVideoHelper.a aVar = ImmVideoHelper.f57891d;
        if (!aVar.a().d().isEmpty()) {
            View view = (View) k.H(aVar.a().d());
            if (view.getParent() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
                return new BaseViewHolder(view);
            }
        }
        return super.n(parent, i11);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder holder, qx.e item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        if (item instanceof qx.d) {
            ShortTvVideoItemView shortTvVideoItemView = (ShortTvVideoItemView) holder.getView(R$id.view_video_item);
            qx.d dVar = (qx.d) item;
            ShortTvBaseListFragment shortTvBaseListFragment = this.f57877f;
            BaseProviderMultiAdapter<qx.e> baseProviderMultiAdapterC = c();
            a.C0596a.a(shortTvVideoItemView, dVar, shortTvBaseListFragment, baseProviderMultiAdapterC != null ? Integer.valueOf(baseProviderMultiAdapterC.P(item)) : null, this.f57878g, this.f57879h, this.f57880i, false, this.f57881j, 64, null);
        }
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public void b(BaseViewHolder helper, qx.e item, List<? extends Object> payloads) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        Intrinsics.g(payloads, "payloads");
        super.b(helper, item, payloads);
        if (item instanceof qx.d) {
            Object objG0 = CollectionsKt___CollectionsKt.g0(payloads);
            ShortTvVideoItemView shortTvVideoItemView = (ShortTvVideoItemView) helper.getView(R$id.view_video_item);
            if (!(objG0 instanceof Integer)) {
                if (objG0 instanceof Boolean) {
                    shortTvVideoItemView.updateLockState((qx.d) item);
                }
            } else {
                qx.d dVar = (qx.d) item;
                ShortTvBaseListFragment shortTvBaseListFragment = this.f57877f;
                BaseProviderMultiAdapter<qx.e> baseProviderMultiAdapterC = c();
                shortTvVideoItemView.setData(dVar, shortTvBaseListFragment, baseProviderMultiAdapterC != null ? Integer.valueOf(baseProviderMultiAdapterC.P(item)) : null, this.f57878g, this.f57879h, this.f57880i, true, this.f57881j);
            }
        }
    }
}
