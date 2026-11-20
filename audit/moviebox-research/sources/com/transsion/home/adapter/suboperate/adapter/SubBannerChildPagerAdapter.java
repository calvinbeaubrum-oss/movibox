package com.transsion.home.adapter.suboperate.adapter;

import android.content.Context;
import android.net.Uri;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.google.android.gms.common.api.Api;
import com.tn.lib.widget.R$color;
import com.tn.lib.widget.R$mipmap;
import com.tn.lib.widget.R$string;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.MbAdImage;
import com.transsion.ad.monopoly.plan.MonopolyAdPlanProvider;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.home.R$drawable;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.BannerData;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.DownloadManagerApi;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class SubBannerChildPagerAdapter extends RecyclerView.Adapter<RecyclerView.a0> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<BannerData> f52023i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f52024j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final OperateItem f52025k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f52026l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f52027m;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class SubBannerADChildViewHolder extends RecyclerView.a0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f52028b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ImageView f52029c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f52030d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final TextView f52031f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SubBannerADChildViewHolder(View itemView) {
            super(itemView);
            Intrinsics.g(itemView, "itemView");
            View viewFindViewById = itemView.findViewById(R$id.contentIV);
            Intrinsics.f(viewFindViewById, "itemView.findViewById(R.id.contentIV)");
            this.f52028b = (ImageView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R$id.playIV);
            Intrinsics.f(viewFindViewById2, "itemView.findViewById(R.id.playIV)");
            this.f52029c = (ImageView) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(R$id.titleTV);
            Intrinsics.f(viewFindViewById3, "itemView.findViewById(R.id.titleTV)");
            this.f52030d = (TextView) viewFindViewById3;
            View viewFindViewById4 = itemView.findViewById(R$id.desTV);
            Intrinsics.f(viewFindViewById4, "itemView.findViewById(R.id.desTV)");
            this.f52031f = (TextView) viewFindViewById4;
        }

        public final void e(final AdPlans adPlans) {
            String thumbnail;
            String url;
            Intrinsics.g(adPlans, "adPlans");
            MonopolyAdPlanProvider monopolyAdPlanProvider = MonopolyAdPlanProvider.f50544a;
            AdMaterialList adMaterialListF = monopolyAdPlanProvider.f(adPlans);
            if (adMaterialListF == null) {
                return;
            }
            MbAdImage mbAdImageC = monopolyAdPlanProvider.c(adPlans);
            this.f52028b.setImageResource(R$mipmap.ic_img_placeholder);
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context context = this.f52028b.getContext();
            ImageView imageView = this.f52028b;
            String str = (mbAdImageC == null || (url = mbAdImageC.getUrl()) == null) ? "" : url;
            int i11 = R$mipmap.ic_img_placeholder;
            String str2 = (mbAdImageC == null || (thumbnail = mbAdImageC.getThumbnail()) == null) ? "" : thumbnail;
            int iA = gs.a.a(40);
            int iA2 = gs.a.a(56);
            Intrinsics.f(context, "context");
            companion.o(context, imageView, str, (32704 & 8) != 0 ? R$color.skeleton : i11, (32704 & 16) != 0 ? companion.d() : iA, (32704 & 32) != 0 ? companion.c() : iA2, (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : str2, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
            this.f52030d.setText(adMaterialListF.getTitle());
            this.f52031f.setText(adMaterialListF.getDesc());
            this.f52031f.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            this.f52029c.setImageResource(R$drawable.ic_trending_arrow);
            final AdMaterialList adMaterialListF2 = monopolyAdPlanProvider.f(adPlans);
            View itemView = this.itemView;
            Intrinsics.f(itemView, "itemView");
            so.c.c(itemView, 0L, new Function1<View, Unit>() { // from class: com.transsion.home.adapter.suboperate.adapter.SubBannerChildPagerAdapter$SubBannerADChildViewHolder$bindAdData$1
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
                    com.transsion.ad.strategy.a aVar = com.transsion.ad.strategy.a.f50582a;
                    AdMaterialList adMaterialList = adMaterialListF2;
                    String deeplink = adMaterialList != null ? adMaterialList.getDeeplink() : null;
                    AdMaterialList adMaterialList2 = adMaterialListF2;
                    aVar.a(deeplink, adMaterialList2 != null ? adMaterialList2.getH5Link() : null, adPlans);
                }
            }, 1, null);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class SubViewPagerViewHolder extends RecyclerView.a0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f52032b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final OperateItem f52033c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ImageView f52034d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ImageView f52035f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final TextView f52036g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final TextView f52037h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SubViewPagerViewHolder(View itemView, int i11, OperateItem operateItem) {
            super(itemView);
            Intrinsics.g(itemView, "itemView");
            Intrinsics.g(operateItem, "operateItem");
            this.f52032b = i11;
            this.f52033c = operateItem;
            View viewFindViewById = itemView.findViewById(R$id.contentIV);
            Intrinsics.f(viewFindViewById, "itemView.findViewById(R.id.contentIV)");
            this.f52034d = (ImageView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R$id.playIV);
            Intrinsics.f(viewFindViewById2, "itemView.findViewById(R.id.playIV)");
            this.f52035f = (ImageView) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(R$id.titleTV);
            Intrinsics.f(viewFindViewById3, "itemView.findViewById(R.id.titleTV)");
            this.f52036g = (TextView) viewFindViewById3;
            View viewFindViewById4 = itemView.findViewById(R$id.desTV);
            Intrinsics.f(viewFindViewById4, "itemView.findViewById(R.id.desTV)");
            this.f52037h = (TextView) viewFindViewById4;
        }

        public final void f(final BannerData bannerData, final int i11) {
            String url;
            String thumbnail;
            Cover cover;
            Cover cover2;
            Intrinsics.g(bannerData, "bannerData");
            Subject subject = bannerData.getSubject();
            if (subject == null || (cover2 = subject.getCover()) == null || (url = cover2.getUrl()) == null) {
                Image image = bannerData.getImage();
                url = image != null ? image.getUrl() : null;
            }
            Subject subject2 = bannerData.getSubject();
            if (subject2 == null || (cover = subject2.getCover()) == null || (thumbnail = cover.getThumbnail()) == null) {
                Image image2 = bannerData.getImage();
                thumbnail = image2 != null ? image2.getThumbnail() : null;
            }
            if (bannerData.getBuiltIn()) {
                kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new SubBannerChildPagerAdapter$SubViewPagerViewHolder$bindData$1(url, this, null), 3, null);
            } else {
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context = this.f52034d.getContext();
                ImageView imageView = this.f52034d;
                String str = url == null ? "" : url;
                String str2 = thumbnail == null ? "" : thumbnail;
                int i12 = R$mipmap.ic_img_placeholder;
                int iA = gs.a.a(40);
                int iA2 = gs.a.a(56);
                Intrinsics.f(context, "context");
                companion.o(context, imageView, str, (32704 & 8) != 0 ? R$color.skeleton : i12, (32704 & 16) != 0 ? companion.d() : iA, (32704 & 32) != 0 ? companion.c() : iA2, (32704 & 64) != 0 ? 0 : 0, (32704 & 128) != 0, (32704 & 256) != 0 ? "" : str2, (32704 & 512) != 0, (32704 & 1024) != 0, (32704 & 2048) != 0 ? false : false, (32704 & 4096) != 0 ? false : false, (32704 & 8192) != 0 ? false : false, (32704 & 16384) != 0 ? 25 : 0);
            }
            this.itemView.setClickable(false);
            Subject subject3 = bannerData.getSubject();
            if (subject3 != null) {
                TextView textView = this.f52036g;
                String title = subject3.getTitle();
                textView.setText(title != null ? title : "");
                SpannableString spannableStringH = h(subject3);
                if (spannableStringH.length() > 0) {
                    this.f52037h.setText(spannableStringH);
                    this.f52037h.setCompoundDrawablesWithIntrinsicBounds(com.transsion.moviedetailapi.a.a(subject3.getSubjectType()), 0, 0, 0);
                }
            }
            if (bannerData.getSubject() == null) {
                this.f52036g.setText(bannerData.getContent());
                this.f52037h.setText((CharSequence) null);
            }
            CharSequence text = this.f52037h.getText();
            if (text == null || text.length() == 0) {
                this.f52037h.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            TextView textView2 = this.f52037h;
            CharSequence text2 = textView2.getText();
            textView2.setVisibility((text2 == null || text2.length() == 0) ^ true ? 0 : 8);
            View itemView = this.itemView;
            Intrinsics.f(itemView, "itemView");
            so.c.c(itemView, 0L, new Function1<View, Unit>() { // from class: com.transsion.home.adapter.suboperate.adapter.SubBannerChildPagerAdapter$SubViewPagerViewHolder$bindData$3
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
                    String deepLink = bannerData.getDeepLink();
                    if (deepLink != null) {
                        BannerData bannerData2 = bannerData;
                        SubBannerChildPagerAdapter.SubViewPagerViewHolder subViewPagerViewHolder = this;
                        int i13 = i11;
                        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
                            zp.b.f82110a.d(R$string.no_network_toast);
                            return;
                        }
                        Uri uriD = com.transsion.baselib.helper.b.f51184a.d(Uri.parse(deepLink + "&module_name=opt_banner_free&autoPlay=true&ops=" + bannerData2.getOps()));
                        if (uriD != null) {
                            com.alibaba.android.arouter.launcher.a.d().a(uriD).navigation();
                        }
                        subViewPagerViewHolder.i(bannerData2, i13, DownloadManagerApi.n2(DownloadManagerApi.f60274j.a(), bannerData2.getSubjectId(), null, false, false, 12, null) ? "play_subject" : "download_subject");
                    }
                }
            }, 1, null);
            j(bannerData, this.f52035f);
        }

        public final ImageView g() {
            return this.f52034d;
        }

        public final SpannableString h(Subject subject) {
            int iIndexOf;
            List listD0;
            StringBuilder sb2 = new StringBuilder();
            String releaseDate = subject.getReleaseDate();
            String genre = subject.getGenre();
            String str = (genre == null || (listD0 = StringsKt__StringsKt.D0(genre, new char[]{','}, false, 0, 6, null)) == null) ? null : (String) CollectionsKt___CollectionsKt.g0(listD0);
            if (releaseDate != null && releaseDate.length() != 0) {
                sb2.append(" | ");
                sb2.append(releaseDate);
            }
            if (str != null) {
                sb2.append(" | ");
                sb2.append(str);
            }
            SpannableString spannableString = new SpannableString(sb2);
            if (releaseDate != null && releaseDate.length() != 0) {
                ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Utils.a().getResources().getColor(R$color.white_20));
                ForegroundColorSpan foregroundColorSpan2 = new ForegroundColorSpan(Utils.a().getResources().getColor(R$color.white_60));
                spannableString.setSpan(foregroundColorSpan, 0, 3, 17);
                spannableString.setSpan(foregroundColorSpan2, 3, releaseDate.length() + 3, 17);
            }
            if (str != null && (iIndexOf = sb2.indexOf(str)) >= 3) {
                ForegroundColorSpan foregroundColorSpan3 = new ForegroundColorSpan(Utils.a().getResources().getColor(R$color.white_20));
                ForegroundColorSpan foregroundColorSpan4 = new ForegroundColorSpan(Utils.a().getResources().getColor(R$color.white_60));
                spannableString.setSpan(foregroundColorSpan3, iIndexOf - 3, iIndexOf, 17);
                spannableString.setSpan(foregroundColorSpan4, iIndexOf, sb2.length(), 17);
            }
            return spannableString;
        }

        public final void i(BannerData bannerData, int i11, String str) {
            HashMap map = new HashMap();
            map.put("event_type", "click_banner_poster");
            map.put("sequence", String.valueOf(i11));
            map.put("module_name", str);
            map.put("tabId", String.valueOf(this.f52032b));
            if (bannerData != null) {
                ot.b.b(bannerData, map);
            }
            ot.b.a(this.f52033c, map);
            com.transsion.baselib.helper.a.f51183a.e(SubTabFragment.f52541r.a(this.f52032b), map);
        }

        public final void j(BannerData bannerData, ImageView imageView) {
            if (bannerData == null || !Intrinsics.b(bannerData.getHasResource(), Boolean.TRUE)) {
                imageView.setImageResource(R$drawable.ic_trending_arrow);
            } else if (!com.transsion.baselib.utils.m.f51320a.b() || bannerData.getSubjectType() == SubjectType.SHORT_TV.getValue()) {
                imageView.setImageResource(R$drawable.ic_trending_download);
            } else {
                imageView.setImageResource(R$drawable.ic_trending_play);
            }
        }
    }

    public SubBannerChildPagerAdapter(List<BannerData> banners, int i11, OperateItem operateItem) {
        Intrinsics.g(banners, "banners");
        Intrinsics.g(operateItem, "operateItem");
        this.f52023i = banners;
        this.f52024j = i11;
        this.f52025k = operateItem;
        this.f52027m = 1;
    }

    public final BannerData d(int i11) {
        int size;
        if (!this.f52023i.isEmpty() && (size = i11 % this.f52023i.size()) >= 0 && size < this.f52023i.size()) {
            return this.f52023i.get(size);
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i11) {
        BannerData bannerDataD = d(i11);
        return (bannerDataD != null ? bannerDataD.getAdData() : null) != null ? this.f52027m : this.f52026l;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.a0 holder, int i11) {
        int size;
        BannerData bannerData;
        Intrinsics.g(holder, "holder");
        if (this.f52023i.isEmpty() || (bannerData = this.f52023i.get((size = i11 % this.f52023i.size()))) == null) {
            return;
        }
        if (holder instanceof SubBannerADChildViewHolder) {
            AdPlans adData = bannerData.getAdData();
            Intrinsics.d(adData);
            ((SubBannerADChildViewHolder) holder).e(adData);
        } else if (holder instanceof SubViewPagerViewHolder) {
            ((SubViewPagerViewHolder) holder).f(bannerData, size);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.a0 onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_sub_top_banner_card, parent, false);
        if (i11 == this.f52027m) {
            Intrinsics.f(view, "view");
            return new SubBannerADChildViewHolder(view);
        }
        Intrinsics.f(view, "view");
        return new SubViewPagerViewHolder(view, this.f52024j, this.f52025k);
    }
}
