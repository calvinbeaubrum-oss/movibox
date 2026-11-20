package com.transsion.home.adapter.suboperate.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import com.tn.lib.widget.R$string;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.edcation.CourseManager;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.p003enum.HomeTabId;
import com.transsion.home.utils.HomeUtilsKt;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.BannerData;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.widget.DownloadView;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.k0;
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
public final class SubHorizontalViewPagerAdapter extends RecyclerView.Adapter<a> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final List<BannerData> f52044i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f52045j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final OperateItem f52046k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f52047l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f52048m;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends RecyclerView.a0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ImageView f52049b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final DownloadView f52050c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final TextView f52051d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View itemView) {
            super(itemView);
            Intrinsics.g(itemView, "itemView");
            View viewFindViewById = itemView.findViewById(R$id.home_sub_pager_item_image);
            Intrinsics.f(viewFindViewById, "itemView.findViewById(R.…ome_sub_pager_item_image)");
            this.f52049b = (ImageView) viewFindViewById;
            View viewFindViewById2 = itemView.findViewById(R$id.sub_operation_banner_download);
            Intrinsics.f(viewFindViewById2, "itemView.findViewById(R.…peration_banner_download)");
            this.f52050c = (DownloadView) viewFindViewById2;
            View viewFindViewById3 = itemView.findViewById(R$id.sub_operation_banner_title);
            Intrinsics.f(viewFindViewById3, "itemView.findViewById(R.…b_operation_banner_title)");
            this.f52051d = (TextView) viewFindViewById3;
        }

        public final DownloadView e() {
            return this.f52050c;
        }

        public final ImageView f() {
            return this.f52049b;
        }

        public final TextView g() {
            return this.f52051d;
        }
    }

    /* JADX INFO: renamed from: com.transsion.home.adapter.suboperate.adapter.SubHorizontalViewPagerAdapter$onBindViewHolder$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.home.adapter.suboperate.adapter.SubHorizontalViewPagerAdapter$onBindViewHolder$1", f = "SubHorizontalViewPagerAdapter.kt", l = {RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ BannerData $bannerData;
        final /* synthetic */ a $holder;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(BannerData bannerData, a aVar, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$bannerData = bannerData;
            this.$holder = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$bannerData, this.$holder, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            String url;
            AssetManager assets;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                Image image = this.$bannerData.getImage();
                if (image != null && (url = image.getUrl()) != null) {
                    a aVar = this.$holder;
                    Context context = aVar.f().getContext();
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream((context == null || (assets = context.getAssets()) == null) ? null : assets.open(url));
                    a2 a2VarC = w0.c();
                    SubHorizontalViewPagerAdapter$onBindViewHolder$1$1$1 subHorizontalViewPagerAdapter$onBindViewHolder$1$1$1 = new SubHorizontalViewPagerAdapter$onBindViewHolder$1$1$1(aVar, bitmapDecodeStream, null);
                    this.label = 1;
                    if (kotlinx.coroutines.h.g(a2VarC, subHorizontalViewPagerAdapter$onBindViewHolder$1$1$1, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        }
    }

    public SubHorizontalViewPagerAdapter(List<BannerData> banners, int i11, OperateItem operateItem, int i12, int i13) {
        Intrinsics.g(banners, "banners");
        Intrinsics.g(operateItem, "operateItem");
        this.f52044i = banners;
        this.f52045j = i11;
        this.f52046k = operateItem;
        this.f52047l = i12;
        this.f52048m = i13;
    }

    public static final void i(BannerData bannerData, SubHorizontalViewPagerAdapter this$0, int i11, View view) {
        String deepLink;
        Intrinsics.g(this$0, "this$0");
        if (bannerData == null || (deepLink = bannerData.getDeepLink()) == null) {
            return;
        }
        Uri uriD = com.transsion.baselib.helper.b.f51184a.d(Uri.parse(deepLink + "&module_name=opt_banner_free&autoPlay=true&ops=" + bannerData.getOps()));
        if (uriD != null) {
            com.alibaba.android.arouter.launcher.a.d().a(uriD).navigation();
        }
        this$0.m(bannerData, i11, DownloadManagerApi.n2(DownloadManagerApi.f60274j.a(), bannerData.getSubjectId(), null, false, false, 12, null) ? "play_subject" : "download_subject");
    }

    public static final void j(a holder, BannerData bannerData, SubHorizontalViewPagerAdapter this$0, Context context, int i11, View view) {
        Intrinsics.g(holder, "$holder");
        Intrinsics.g(this$0, "this$0");
        if (holder.e().getShowType() == 2 || holder.e().getShowType() == 3) {
            if (bannerData != null) {
                CourseManager.f51853a.r(bannerData.getSubjectId(), bannerData.getSeenStatus());
                ct.a.b(this$0.f(bannerData), SubTabFragment.f52541r.a(this$0.f52045j), "opt_rank_list");
                return;
            }
            return;
        }
        String strA = SubTabFragment.f52541r.a(this$0.f52045j);
        Subject subject = new Subject(bannerData != null ? bannerData.getSubjectId() : null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, null, null, -2, 4194303, null);
        Intrinsics.f(context, "context");
        this$0.l(bannerData, i11, HomeUtilsKt.c(subject, strA, context, "opt_rank_list"));
    }

    private final void m(BannerData bannerData, int i11, String str) {
        HashMap map = new HashMap();
        map.put("event_type", "click_banner_poster");
        map.put("sequence", String.valueOf(i11));
        map.put("module_name", str);
        map.put("tabId", String.valueOf(this.f52045j));
        if (bannerData != null) {
            ot.b.b(bannerData, map);
        }
        ot.b.a(this.f52046k, map);
        com.transsion.baselib.helper.a.f51183a.e(SubTabFragment.f52541r.a(this.f52045j), map);
    }

    public final Subject f(BannerData bannerData) {
        if (bannerData == null) {
            return null;
        }
        return new Subject(bannerData.getSubjectId(), Integer.valueOf(bannerData.getSubjectType()), null, null, null, null, null, null, null, null, null, null, null, null, null, bannerData.getSeenStatus(), null, null, null, null, null, null, null, null, false, false, null, null, null, null, null, false, false, null, null, 0, false, false, 0L, null, null, 0L, null, 0, false, null, 0, null, null, null, null, null, null, null, -32772, 4194303, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(final a holder, final int i11) {
        Image image;
        String thumbnail;
        Image image2;
        String url;
        String content;
        Intrinsics.g(holder, "holder");
        final Context context = holder.f().getContext();
        final BannerData bannerData = this.f52044i.get(i11 % this.f52044i.size());
        holder.f().getLayoutParams().height = this.f52048m;
        String str = "";
        if (bannerData == null || !bannerData.getBuiltIn()) {
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Intrinsics.f(context, "context");
            ImageView imageViewF = holder.f();
            String str2 = (bannerData == null || (image2 = bannerData.getImage()) == null || (url = image2.getUrl()) == null) ? "" : url;
            int i12 = this.f52047l;
            companion.q(context, imageViewF, str2, (8120 & 8) != 0 ? companion.d() : i12, (8120 & 16) != 0 ? companion.c() : i12, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : (bannerData == null || (image = bannerData.getImage()) == null || (thumbnail = image.getThumbnail()) == null) ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
        } else {
            kotlinx.coroutines.j.d(l0.a(w0.b()), null, null, new AnonymousClass1(bannerData, holder, null), 3, null);
        }
        TextView textViewG = holder.g();
        if (bannerData != null && (content = bannerData.getContent()) != null) {
            str = content;
        }
        textViewG.setText(str);
        n(bannerData, holder.e());
        holder.f().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.adapter.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubHorizontalViewPagerAdapter.i(bannerData, this, i11, view);
            }
        });
        holder.e().setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.adapter.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SubHorizontalViewPagerAdapter.j(holder, bannerData, this, context, i11, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return Api.BaseClientBuilder.API_PRIORITY_OTHER;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a holder, int i11, List<Object> payloads) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(payloads, "payloads");
        if (!(!payloads.isEmpty())) {
            onBindViewHolder(holder, i11);
            return;
        }
        Object obj = payloads.get(payloads.size() - 1);
        if (obj instanceof Integer) {
            o(holder, ((Number) obj).intValue());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_sub_horizontal_view_pager, parent, false);
        Intrinsics.f(view, "view");
        return new a(view);
    }

    public final void l(BannerData bannerData, int i11, String str) {
        HashMap map = new HashMap();
        map.put("event_type", "click_banner");
        map.put("sequence", String.valueOf(i11));
        map.put("module_name", str);
        map.put("tabId", String.valueOf(this.f52045j));
        if (bannerData != null) {
            ot.b.b(bannerData, map);
        }
        ot.b.a(this.f52046k, map);
        com.transsion.baselib.helper.a.f51183a.e(SubTabFragment.f52541r.a(this.f52045j), map);
    }

    public final void n(BannerData bannerData, DownloadView downloadView) {
        Integer seenStatus;
        if (bannerData != null && Intrinsics.b(bannerData.getHasResource(), Boolean.TRUE) && this.f52045j == HomeTabId.Education.getValue()) {
            so.c.k(downloadView);
        } else if (bannerData == null || !Intrinsics.b(bannerData.getHasResource(), Boolean.TRUE)) {
            so.c.g(downloadView);
        } else {
            so.c.k(downloadView);
        }
        if (this.f52045j != HomeTabId.Education.getValue()) {
            if (!com.transsion.baselib.utils.m.f51320a.b() || (bannerData != null && bannerData.getSubjectType() == SubjectType.SHORT_TV.getValue())) {
                DownloadView.setShowType$default(downloadView, bannerData != null ? bannerData.getSubjectId() : null, null, null, false, R$string.download_now, 14, null);
                return;
            } else {
                downloadView.setShowPlayType();
                return;
            }
        }
        if (bannerData == null || (seenStatus = bannerData.getSeenStatus()) == null || seenStatus.intValue() != 1) {
            downloadView.setAddCourse();
        } else {
            downloadView.setCourseAdded();
        }
    }

    public final void o(a aVar, int i11) {
        if (this.f52045j != HomeTabId.Education.getValue()) {
            return;
        }
        if (i11 == 1) {
            aVar.e().setCourseAdded();
        } else {
            aVar.e().setAddCourse();
        }
    }
}
