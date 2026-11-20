package com.transsion.home.adapter.suboperate.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Api;
import com.transsion.home.R$layout;
import com.transsion.home.adapter.suboperate.provider.SubBannerProvider;
import com.transsion.moviedetailapi.bean.BannerData;
import com.transsion.moviedetailapi.bean.OperateItem;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

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
public final class SubViewPagerAdapter extends RecyclerView.Adapter<RecyclerView.a0> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<BannerData> f52052i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f52053j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final SubBannerProvider f52054k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final OperateItem f52055l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f52056m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f52057n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile com.transsion.player.orplayer.f f52058o;

    /* JADX INFO: renamed from: com.transsion.home.adapter.suboperate.adapter.SubViewPagerAdapter$onCreateViewHolder$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function0<com.transsion.player.orplayer.f> {
        public AnonymousClass1(Object obj) {
            super(0, obj, SubViewPagerAdapter.class, "getOrPlayer", "getOrPlayer()Lcom/transsion/player/orplayer/ORPlayer;", 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.transsion.player.orplayer.f invoke() {
            return ((SubViewPagerAdapter) this.receiver).f();
        }
    }

    public SubViewPagerAdapter(List<BannerData> banners, int i11, SubBannerProvider bannerProvider, OperateItem operateItem) {
        Intrinsics.g(banners, "banners");
        Intrinsics.g(bannerProvider, "bannerProvider");
        Intrinsics.g(operateItem, "operateItem");
        this.f52052i = banners;
        this.f52053j = i11;
        this.f52054k = bannerProvider;
        this.f52055l = operateItem;
        this.f52057n = 1;
    }

    private final BannerData e(int i11) {
        int size;
        if (!this.f52052i.isEmpty() && (size = i11 % this.f52052i.size()) >= 0 && size < this.f52052i.size()) {
            return this.f52052i.get(size);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.transsion.player.orplayer.f f() {
        com.transsion.player.orplayer.f fVar = this.f52058o;
        if (fVar != null) {
            return fVar;
        }
        com.transsion.player.orplayer.f fVarA = new com.transsion.player.orplayer.f.a(this.f52054k.g()).b(new iv.d(null, false, 0, 0, 0, 0, 0, 0, 0L, 0, 0, false, false, false, false, false, null, 94207, null)).a();
        this.f52058o = fVarA;
        fVarA.setLooping(true);
        return fVarA;
    }

    public final void g(List<BannerData> list) {
        Intrinsics.g(list, "<set-?>");
        this.f52052i = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i11) {
        BannerData bannerDataE = e(i11);
        return (bannerDataE != null ? bannerDataE.getAdData() : null) != null ? this.f52057n : this.f52056m;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.a0 holder, int i11) throws IOException {
        Intrinsics.g(holder, "holder");
        if (this.f52052i.isEmpty()) {
            return;
        }
        int size = i11 % this.f52052i.size();
        if (getItemViewType(i11) == this.f52057n) {
            SubBannerADViewHolder subBannerADViewHolder = holder instanceof SubBannerADViewHolder ? (SubBannerADViewHolder) holder : null;
            if (subBannerADViewHolder != null) {
                subBannerADViewHolder.i(e(i11), size);
                return;
            }
            return;
        }
        SubBannerViewHolder subBannerViewHolder = holder instanceof SubBannerViewHolder ? (SubBannerViewHolder) holder : null;
        if (subBannerViewHolder != null) {
            subBannerViewHolder.f(e(i11), size);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.a0 onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        if (i11 == this.f52057n) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_sub_banner_ad, parent, false);
            Intrinsics.f(view, "view");
            return new SubBannerADViewHolder(view, new AnonymousClass1(this));
        }
        View view2 = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_sub_view_pager, parent, false);
        Intrinsics.f(view2, "view");
        return new SubBannerViewHolder(view2, this.f52053j, this.f52054k, this.f52055l);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Intrinsics.g(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        com.transsion.player.orplayer.f fVar = this.f52058o;
        if (fVar != null) {
            fVar.release();
        }
        this.f52058o = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewRecycled(RecyclerView.a0 holder) {
        Intrinsics.g(holder, "holder");
        super.onViewRecycled(holder);
        boolean z11 = holder instanceof SubBannerADViewHolder;
        if ((z11 ? (SubBannerADViewHolder) holder : null) != null) {
            SubBannerADViewHolder subBannerADViewHolder = z11 ? (SubBannerADViewHolder) holder : null;
            if (subBannerADViewHolder != null) {
                subBannerADViewHolder.n();
            }
        }
    }
}
