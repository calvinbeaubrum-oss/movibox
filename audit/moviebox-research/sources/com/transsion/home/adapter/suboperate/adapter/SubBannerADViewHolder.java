package com.transsion.home.adapter.suboperate.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.media.MediaMetadataRetriever;
import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.transsion.ad.R$mipmap;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.MbAdImage;
import com.transsion.ad.monopoly.plan.MonopolyAdPlanProvider;
import com.transsion.ad.strategy.MeasureManager;
import com.transsion.gslb.Utils;
import com.transsion.home.R$id;
import com.transsion.home.adapter.trending.BannerADDataHelper;
import com.transsion.moviedetailapi.bean.BannerData;
import com.transsion.player.MediaSource;
import java.io.IOException;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;

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
@SourceDebugExtension
public final class SubBannerADViewHolder extends RecyclerView.a0 implements MeasureManager.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f52008o = new a(null);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final int f52009p = 8;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static boolean f52010q = true;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<com.transsion.player.orplayer.f> f52011b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f52012c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f52013d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f52014f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ImageView f52015g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f52016h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final TextureView f52017i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f52018j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f52019k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile com.transsion.player.orplayer.f f52020l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f52021m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public AdPlans f52022n;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return SubBannerADViewHolder.f52010q;
        }

        public final void b(boolean z11) {
            SubBannerADViewHolder.f52010q = z11;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SubBannerADViewHolder(View itemView, Function0<? extends com.transsion.player.orplayer.f> player) {
        super(itemView);
        Intrinsics.g(itemView, "itemView");
        Intrinsics.g(player, "player");
        this.f52011b = player;
        View viewFindViewById = itemView.findViewById(R$id.home_sub_pager_items_status);
        Intrinsics.f(viewFindViewById, "itemView.findViewById(R.…e_sub_pager_items_status)");
        this.f52013d = viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R$id.home_sub_pager_items_top_mask);
        Intrinsics.f(viewFindViewById2, "itemView.findViewById(R.…sub_pager_items_top_mask)");
        this.f52014f = viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R$id.home_sub_pager_item_image);
        Intrinsics.f(viewFindViewById3, "itemView.findViewById(R.…ome_sub_pager_item_image)");
        this.f52015g = (ImageView) viewFindViewById3;
        View viewFindViewById4 = itemView.findViewById(R$id.home_sub_pager_item_mute);
        Intrinsics.f(viewFindViewById4, "itemView.findViewById(R.…home_sub_pager_item_mute)");
        this.f52016h = (ImageView) viewFindViewById4;
        View viewFindViewById5 = itemView.findViewById(R$id.home_sub_pager_item_texture);
        Intrinsics.f(viewFindViewById5, "itemView.findViewById(R.…e_sub_pager_item_texture)");
        this.f52017i = (TextureView) viewFindViewById5;
    }

    private final void m() {
        com.transsion.player.orplayer.f fVar;
        if (!this.f52021m || (fVar = this.f52020l) == null) {
            return;
        }
        fVar.pause();
    }

    private final void p() {
        AdPlans adPlans;
        if (this.f52018j <= 0 || (adPlans = this.f52022n) == null) {
            return;
        }
        MonopolyAdPlanProvider.f50544a.k("TrendingBannerScene", 1, System.currentTimeMillis() - this.f52018j, adPlans, BannerADDataHelper.f52219a.g());
        this.f52018j = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
        com.transsion.player.orplayer.f fVar = this.f52020l;
        if (fVar != null) {
            fVar.setMute(f52010q);
        }
        if (f52010q) {
            this.f52016h.setImageResource(R$mipmap.ad_volumeoff);
        } else {
            this.f52016h.setImageResource(R$mipmap.ad_volumeon);
        }
    }

    @Override // com.transsion.ad.strategy.MeasureManager.a
    public double getVisibilityThreshold() {
        return MeasureManager.a.C0550a.a(this);
    }

    @Override // com.transsion.ad.strategy.MeasureManager.a
    public View getVisibilityView() {
        View itemView = this.itemView;
        Intrinsics.f(itemView, "itemView");
        return itemView;
    }

    public final void i(BannerData bannerData, int i11) throws IOException {
        AdPlans adData;
        this.f52013d.getLayoutParams().height = com.blankj.utilcode.util.d.c();
        if (bannerData == null || (adData = bannerData.getAdData()) == null) {
            return;
        }
        this.f52022n = adData;
        MonopolyAdPlanProvider monopolyAdPlanProvider = MonopolyAdPlanProvider.f50544a;
        this.f52021m = monopolyAdPlanProvider.h(adData);
        MeasureManager.f50573a.g(this);
        if (this.f52021m) {
            l(adData);
        } else {
            j(adData);
        }
        MbAdImage mbAdImageD = monopolyAdPlanProvider.d(adData);
        String averageHueDark = mbAdImageD != null ? mbAdImageD.getAverageHueDark() : null;
        if (averageHueDark != null && StringsKt__StringsKt.Q(averageHueDark, Utils.SEPARATOR, false, 2, null)) {
            this.f52013d.setBackgroundColor(Color.parseColor(averageHueDark));
            this.f52014f.setBackground(k(averageHueDark));
        }
        final AdMaterialList adMaterialListF = monopolyAdPlanProvider.f(adData);
        if (adMaterialListF != null) {
            View itemView = this.itemView;
            Intrinsics.f(itemView, "itemView");
            so.c.c(itemView, 0L, new Function1<View, Unit>() { // from class: com.transsion.home.adapter.suboperate.adapter.SubBannerADViewHolder$bindData$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View it) {
                    Intrinsics.g(it, "it");
                    MonopolyAdPlanProvider.f50544a.i("TrendingBannerScene", 1, this.this$0.f52022n, BannerADDataHelper.f52219a.g());
                    com.transsion.ad.strategy.a.f50582a.a(adMaterialListF.getDeeplink(), adMaterialListF.getH5Link(), this.this$0.f52022n);
                }
            }, 1, null);
        }
    }

    public final void j(AdPlans adPlans) {
        this.f52016h.setVisibility(8);
        this.f52017i.setVisibility(8);
        tp.f fVar = tp.f.f77260a;
        Context context = this.f52015g.getContext();
        Intrinsics.f(context, "imageView.context");
        int iE = fVar.e(context);
        String strE = MonopolyAdPlanProvider.f50544a.e(adPlans);
        try {
            Result.Companion companion = Result.Companion;
            Result.m163constructorimpl(Glide.with(this.f52015g).load2(strE).placeholder(com.transsion.baseui.R$mipmap.home_ic_default_res).override(iE, iE).into(this.f52015g));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    public final GradientDrawable k(String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setColors(new int[]{Color.parseColor(kotlin.text.l.F(str, Utils.SEPARATOR, "#ff", false, 4, null)), Color.parseColor(kotlin.text.l.F(str, Utils.SEPARATOR, "#ff", false, 4, null)), Color.parseColor(kotlin.text.l.F(str, Utils.SEPARATOR, "#00", false, 4, null))});
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        return gradientDrawable;
    }

    public final void l(AdPlans adPlans) throws IOException {
        com.transsion.player.orplayer.f fVar;
        if (adPlans == null) {
            return;
        }
        so.c.c(this.f52016h, 0L, new Function1<View, Unit>() { // from class: com.transsion.home.adapter.suboperate.adapter.SubBannerADViewHolder$initPlayer$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View it) {
                Intrinsics.g(it, "it");
                SubBannerADViewHolder.a aVar = SubBannerADViewHolder.f52008o;
                aVar.b(!aVar.a());
                this.this$0.q();
            }
        }, 1, null);
        this.f52017i.setVisibility(0);
        com.transsion.player.orplayer.f fVarInvoke = this.f52011b.invoke();
        fVarInvoke.setTextureView(this.f52017i);
        this.f52020l = fVarInvoke;
        String strG = MonopolyAdPlanProvider.f50544a.g(adPlans);
        if (strG != null && (fVar = this.f52020l) != null) {
            fVar.setDataSource(new MediaSource(strG, strG, 0, null, null, 28, null));
        }
        com.transsion.player.orplayer.f fVar2 = this.f52020l;
        if (fVar2 != null) {
            fVar2.prepare();
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(strG, new HashMap());
                this.f52015g.setImageBitmap(mediaMetadataRetriever.getFrameAtTime(0L, 2));
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            mediaMetadataRetriever.release();
            q();
        } catch (Throwable th2) {
            mediaMetadataRetriever.release();
            throw th2;
        }
    }

    public final void n() {
        MeasureManager.f50573a.p(this);
        com.transsion.player.orplayer.f fVar = this.f52020l;
        if (fVar != null) {
            fVar.pause();
            fVar.setTextureView(null);
        }
    }

    public final void o() {
        if (this.f52012c) {
            return;
        }
        this.f52012c = true;
        AdPlans adPlans = this.f52022n;
        if (adPlans != null) {
            MonopolyAdPlanProvider.f50544a.j("TrendingBannerScene", 1, adPlans, BannerADDataHelper.f52219a.g());
        }
    }

    @Override // com.transsion.ad.strategy.MeasureManager.a
    public void onVisibilityChanged(boolean z11) {
        if (this.f52019k == z11) {
            return;
        }
        if (z11) {
            this.f52018j = System.currentTimeMillis();
            r();
            o();
        } else {
            m();
            p();
        }
        this.f52019k = z11;
    }

    public final void r() {
        if (this.f52021m) {
            com.transsion.player.orplayer.f fVar = this.f52020l;
            if (fVar != null) {
                fVar.play();
            }
            com.transsion.player.orplayer.f fVar2 = this.f52020l;
            if (fVar2 != null) {
                fVar2.setMute(f52010q);
            }
        }
    }
}
