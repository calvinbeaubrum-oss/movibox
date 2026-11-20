package com.transsion.home.adapter.suboperate.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.tn.lib.widget.R$string;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.gslb.Utils;
import com.transsion.home.R$id;
import com.transsion.home.adapter.suboperate.provider.SubBannerProvider;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.moviedetailapi.bean.BannerData;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsnet.downloader.DownloadManagerApi;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class SubBannerViewHolder extends RecyclerView.a0 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f52038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final SubBannerProvider f52039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final OperateItem f52040d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f52041f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f52042g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ImageView f52043h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubBannerViewHolder(View itemView, int i11, SubBannerProvider bannerProvider, OperateItem operateItem) {
        super(itemView);
        Intrinsics.g(itemView, "itemView");
        Intrinsics.g(bannerProvider, "bannerProvider");
        Intrinsics.g(operateItem, "operateItem");
        this.f52038b = i11;
        this.f52039c = bannerProvider;
        this.f52040d = operateItem;
        View viewFindViewById = itemView.findViewById(R$id.home_sub_pager_items_status);
        Intrinsics.f(viewFindViewById, "itemView.findViewById(R.…e_sub_pager_items_status)");
        this.f52041f = viewFindViewById;
        View viewFindViewById2 = itemView.findViewById(R$id.home_sub_pager_items_top_mask);
        Intrinsics.f(viewFindViewById2, "itemView.findViewById(R.…sub_pager_items_top_mask)");
        this.f52042g = viewFindViewById2;
        View viewFindViewById3 = itemView.findViewById(R$id.home_sub_pager_item_image);
        Intrinsics.f(viewFindViewById3, "itemView.findViewById(R.…ome_sub_pager_item_image)");
        this.f52043h = (ImageView) viewFindViewById3;
    }

    public static final void g(BannerData bannerData, SubBannerViewHolder this$0, int i11, View view) {
        Intrinsics.g(this$0, "this$0");
        String deepLink = bannerData.getDeepLink();
        if (deepLink != null) {
            if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
                zp.b.f82110a.d(R$string.no_network_toast);
                return;
            }
            Uri uriD = com.transsion.baselib.helper.b.f51184a.d(Uri.parse(deepLink + "&module_name=opt_banner_free&autoPlay=true&ops=" + bannerData.getOps()));
            if (uriD != null) {
                com.alibaba.android.arouter.launcher.a.d().a(uriD).navigation();
            }
            this$0.k(bannerData, i11, DownloadManagerApi.n2(DownloadManagerApi.f60274j.a(), bannerData.getSubjectId(), null, false, false, 12, null) ? "play_subject" : "download_subject");
        }
    }

    private final GradientDrawable h(String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setGradientType(0);
        gradientDrawable.setColors(new int[]{Color.parseColor(kotlin.text.l.F(str, Utils.SEPARATOR, "#ff", false, 4, null)), Color.parseColor(kotlin.text.l.F(str, Utils.SEPARATOR, "#ff", false, 4, null)), Color.parseColor(kotlin.text.l.F(str, Utils.SEPARATOR, "#00", false, 4, null))});
        gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
        return gradientDrawable;
    }

    private final void k(BannerData bannerData, int i11, String str) {
        HashMap map = new HashMap();
        map.put("event_type", "click_banner_poster");
        map.put("sequence", String.valueOf(i11));
        map.put("module_name", str);
        map.put("tabId", String.valueOf(this.f52038b));
        if (bannerData != null) {
            ot.b.b(bannerData, map);
        }
        ot.b.a(this.f52040d, map);
        com.transsion.baselib.helper.a.f51183a.e(SubTabFragment.f52541r.a(this.f52038b), map);
    }

    public final void f(final BannerData bannerData, final int i11) {
        String thumbnail;
        String url;
        if (bannerData == null) {
            return;
        }
        tp.f fVar = tp.f.f77260a;
        Context context = this.f52043h.getContext();
        Intrinsics.f(context, "imageView.context");
        int iE = fVar.e(context);
        if (bannerData.getBuiltIn()) {
            kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new SubBannerViewHolder$bindData$1(bannerData, this, null), 3, null);
        } else {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context context2 = this.f52043h.getContext();
            Intrinsics.f(context2, "imageView.context");
            ImageView imageView = this.f52043h;
            Image image = bannerData.getImage();
            String str = (image == null || (url = image.getUrl()) == null) ? "" : url;
            Image image2 = bannerData.getImage();
            companion.q(context2, imageView, str, (8120 & 8) != 0 ? companion.d() : iE, (8120 & 16) != 0 ? companion.c() : iE, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : (image2 == null || (thumbnail = image2.getThumbnail()) == null) ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
        }
        this.f52041f.getLayoutParams().height = com.blankj.utilcode.util.d.c();
        Image image3 = bannerData.getImage();
        String averageHueDark = image3 != null ? image3.getAverageHueDark() : null;
        if (averageHueDark != null && StringsKt__StringsKt.Q(averageHueDark, Utils.SEPARATOR, false, 2, null)) {
            this.f52041f.setBackgroundColor(Color.parseColor(averageHueDark));
            this.f52042g.setBackground(h(averageHueDark));
        }
        j(bannerData, i11);
        this.f52043h.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.adapter.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubBannerViewHolder.g(bannerData, this, i11, view);
            }
        });
    }

    public final ImageView i() {
        return this.f52043h;
    }

    public final void j(BannerData bannerData, int i11) {
        if (this.f52039c.K(bannerData != null ? bannerData.getSubjectId() : null)) {
            HashMap map = new HashMap();
            map.put("event_type", "browse_banner");
            map.put("sequence", String.valueOf(i11));
            map.put("tabId", String.valueOf(this.f52038b));
            if (bannerData != null) {
                ot.b.b(bannerData, map);
            }
            ot.b.a(this.f52040d, map);
            com.transsion.baselib.helper.a.f51183a.d(SubTabFragment.f52541r.a(this.f52038b), map);
        }
    }
}
