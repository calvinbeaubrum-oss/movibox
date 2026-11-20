package com.transsion.postdetail.shorttv.adapter;

import android.content.Context;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.Group;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.d0;
import com.blankj.utilcode.util.f0;
import com.blankj.utilcode.util.h0;
import com.blankj.utilcode.util.z;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.tn.lib.widget.R$color;
import com.transsion.ad.view.native_ad.NativeWrapperAdView;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsnet.downloader.R$mipmap;
import com.transsnet.downloader.R$string;
import h9.f;
import h9.i;
import h9.j;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class ShortTVTrendingAdapter extends BaseQuickAdapter<Subject, BaseViewHolder> implements j {
    public final String H;
    public final boolean I;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTVTrendingAdapter(String pageName, boolean z11) {
        super(R$layout.item_short_tv_trending, null, 2, null);
        Intrinsics.g(pageName, "pageName");
        this.H = pageName;
        this.I = z11;
    }

    public static final void I0(BaseViewHolder holder, BaseQuickAdapter baseQuickAdapter, View view, int i11) {
        Intrinsics.g(holder, "$holder");
        Intrinsics.g(baseQuickAdapter, "<anonymous parameter 0>");
        Intrinsics.g(view, "<anonymous parameter 1>");
        holder.itemView.performClick();
    }

    private final void J0(AppCompatImageView appCompatImageView, Subject subject) {
        kotlinx.coroutines.j.d(l0.a(w0.c()), null, null, new ShortTVTrendingAdapter$loadBuiltInCover$1(subject, appCompatImageView, null), 3, null);
    }

    private final void K0(AppCompatImageView appCompatImageView, Subject subject) {
        String thumbnail;
        String url;
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context context = appCompatImageView.getContext();
        Intrinsics.f(context, "context");
        Cover cover = subject.getCover();
        String str = (cover == null || (url = cover.getUrl()) == null) ? "" : url;
        int i11 = R$color.module_04;
        Cover cover2 = subject.getCover();
        companion.q(context, appCompatImageView, str, (8120 & 8) != 0 ? companion.d() : i11, (8120 & 16) != 0 ? companion.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
    public void x(final BaseViewHolder holder, Subject item) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(item, "item");
        if (item.getNonAdDelegate() != null) {
            ((FrameLayout) holder.getView(R$id.flAdContainer)).setVisibility(0);
            ((Group) holder.getView(R$id.group)).setVisibility(8);
            d00.b bVar = d00.b.f62855a;
            Context context = getContext();
            com.transsion.ad.bidding.nativead.c nonAdDelegate = item.getNonAdDelegate();
            zq.b bVarA = bVar.a(context, nonAdDelegate != null ? nonAdDelegate.Q() : null);
            NativeWrapperAdView nativeWrapperAdView = (NativeWrapperAdView) holder.getViewOrNull(R$id.flAdContainer);
            if (nativeWrapperAdView != null) {
                nativeWrapperAdView.bindNativeView(item.getNonAdDelegate(), bVarA);
                return;
            }
            return;
        }
        ((FrameLayout) holder.getView(R$id.flAdContainer)).setVisibility(8);
        ((Group) holder.getView(R$id.group)).setVisibility(0);
        AppCompatImageView appCompatImageView = (AppCompatImageView) holder.getView(R$id.iv_cover);
        if (item.getBuiltIn()) {
            J0(appCompatImageView, item);
        } else {
            K0(appCompatImageView, item);
        }
        TextView textView = (TextView) holder.getView(R$id.tv_title);
        textView.setText(item.getTitle());
        boolean z11 = new StaticLayout(item.getTitle(), textView.getPaint(), d0.e() - f0.a(139.0f), Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getLineCount() > 1;
        TextView textView2 = (TextView) holder.getView(R$id.tv_type);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String releaseDate = item.getReleaseDate();
        if (releaseDate != null && releaseDate.length() != 0) {
            Date dateK = h0.k(item.getReleaseDate(), "yyyy-MM-dd");
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateK);
            spannableStringBuilder.append((CharSequence) String.valueOf(calendar.get(1)));
        }
        String[] strings = z.a(item.getGenre(), ",");
        if (strings != null) {
            Intrinsics.f(strings, "strings");
            for (String str : strings) {
                spannableStringBuilder.append((CharSequence) " · ").append((CharSequence) str);
            }
        }
        String countryName = item.getCountryName();
        if (countryName != null && countryName.length() != 0) {
            spannableStringBuilder.append((CharSequence) " · ").append((CharSequence) item.getCountryName());
        }
        textView2.setText(spannableStringBuilder);
        List<String> tags = item.getTags();
        if (tags == null) {
            tags = new ArrayList<>();
        }
        RecyclerView recyclerView = (RecyclerView) holder.getView(R$id.rv_list);
        if (tags.isEmpty()) {
            so.c.g(recyclerView);
        } else {
            c cVar = new c(CollectionsKt___CollectionsKt.M0(tags));
            cVar.B0(new f9.d() { // from class: com.transsion.postdetail.shorttv.adapter.d
                @Override // f9.d
                public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                    ShortTVTrendingAdapter.I0(holder, baseQuickAdapter, view, i11);
                }
            });
            FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(recyclerView.getContext());
            flexboxLayoutManager.P(0);
            flexboxLayoutManager.Q(1);
            flexboxLayoutManager.R(0);
            recyclerView.setLayoutManager(flexboxLayoutManager);
            if (recyclerView.getItemDecorationCount() <= 0) {
                recyclerView.addItemDecoration(new ro.c(f0.a(4.0f)));
            }
            recyclerView.setAdapter(cVar);
            so.c.k(recyclerView);
        }
        TextView textView3 = (TextView) holder.getView(R$id.tv_desc);
        textView3.setMaxLines(z11 ? 1 : 2);
        String str2 = this.H;
        if (Intrinsics.b(str2, "minitv_explore")) {
            textView3.setText(item.getDescription());
        } else if (Intrinsics.b(str2, "minitv_favorite")) {
            String str3 = item.getTotalEpisode() + " EPs";
            Intrinsics.f(str3, "toString(...)");
            textView3.setText(str3);
        }
        TextView textView4 = (TextView) holder.getView(R$id.btn_download);
        textView4.setText(this.I ? Utils.a().getString(R$string.str_download) : Utils.a().getString(com.transsion.baseui.R$string.play));
        textView4.setCompoundDrawablesWithIntrinsicBounds(this.I ? R$mipmap.ic_download_white : com.transsion.postdetail.R$mipmap.ic_play_white_trending, 0, 0, 0);
    }

    @Override // h9.j
    public /* synthetic */ f a(BaseQuickAdapter baseQuickAdapter) {
        return i.a(this, baseQuickAdapter);
    }
}
