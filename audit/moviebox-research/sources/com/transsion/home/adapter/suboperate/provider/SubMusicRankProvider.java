package com.transsion.home.adapter.suboperate.provider;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.d0;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.google.android.material.imageview.ShapeableImageView;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.fragment.tab.SubTabFragment;
import com.transsion.home.utils.HomeUtilsKt;
import com.transsion.moviedetailapi.bean.AppointSubject;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
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
public final class SubMusicRankProvider extends BaseItemProvider<OperateItem> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f52146f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f52147g;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Integer f52148a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<Subject> f52149b;

        public a(Integer num, List<Subject> subjects) {
            Intrinsics.g(subjects, "subjects");
            this.f52148a = num;
            this.f52149b = subjects;
        }

        public final Integer a() {
            return this.f52148a;
        }

        public final List<Subject> b() {
            return this.f52149b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics.b(this.f52148a, aVar.f52148a) && Intrinsics.b(this.f52149b, aVar.f52149b);
        }

        public int hashCode() {
            Integer num = this.f52148a;
            return ((num == null ? 0 : num.hashCode()) * 31) + this.f52149b.hashCode();
        }

        public String toString() {
            return "MusicRankData(index=" + this.f52148a + ", subjects=" + this.f52149b + ")";
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class b extends BaseQuickAdapter<a, BaseViewHolder> {
        public final OperateItem H;
        public final int I;
        public final boolean J;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i11, OperateItem operateItem, int i12, boolean z11) {
            super(i11, null, 2, null);
            Intrinsics.g(operateItem, "operateItem");
            this.H = operateItem;
            this.I = i12;
            this.J = z11;
        }

        public /* synthetic */ b(int i11, OperateItem operateItem, int i12, boolean z11, int i13, DefaultConstructorMarker defaultConstructorMarker) {
            this((i13 & 1) != 0 ? R$layout.item_provider_ranklist : i11, operateItem, i12, z11);
        }

        public static final void I0(Subject subject, b this$0, a item, int i11, View view) {
            Intrinsics.g(subject, "$subject");
            Intrinsics.g(this$0, "this$0");
            Intrinsics.g(item, "$item");
            HomeUtilsKt.b(subject, "opt_ranking_list");
            this$0.M0(item, i11);
        }

        private final View J0(Context context, Subject subject, ViewGroup viewGroup, int i11) {
            String url;
            View view = LayoutInflater.from(context).inflate(R$layout.item_provider_music_rank_item, viewGroup, false);
            View viewFindViewById = view.findViewById(R$id.ivCover);
            Intrinsics.f(viewFindViewById, "view.findViewById(R.id.ivCover)");
            ShapeableImageView shapeableImageView = (ShapeableImageView) viewFindViewById;
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Cover cover = subject.getCover();
            if (cover == null || (url = cover.getUrl()) == null) {
                url = "";
            }
            companion.r(context, shapeableImageView, url, (4088 & 8) != 0 ? companion.d() : 0, (4088 & 16) != 0 ? companion.c() : 0, (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
            ((TextView) view.findViewById(R$id.tvTitle)).setText(subject.getTitle());
            ((TextView) view.findViewById(R$id.tvRankNum)).setText(String.valueOf(i11 + 1));
            Intrinsics.f(view, "view");
            return view;
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
        public void x(BaseViewHolder holder, final a item) {
            Intrinsics.g(holder, "holder");
            Intrinsics.g(item, "item");
            ViewGroup viewGroup = (LinearLayout) holder.getView(R$id.sub_operation_rankinglist_root);
            viewGroup.removeAllViews();
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            Intrinsics.e(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.width = K0();
            marginLayoutParams.rightMargin = gs.a.a(8);
            viewGroup.setLayoutParams(marginLayoutParams);
            viewGroup.setBackground(null);
            Integer numA = item.a();
            final int i11 = 0;
            int iIntValue = numA != null ? numA.intValue() : 0;
            for (Object obj : item.b()) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    kotlin.collections.g.u();
                }
                final Subject subject = (Subject) obj;
                View viewJ0 = J0(getContext(), subject, viewGroup, (iIntValue * 3) + i11);
                viewGroup.addView(viewJ0);
                viewJ0.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.provider.p
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        SubMusicRankProvider.b.I0(subject, this, item, i11, view);
                    }
                });
                L0(item, i11);
                i11 = i12;
            }
        }

        public final int K0() {
            return (d0.e() - gs.a.a(68)) / (this.J ? 2 : 1);
        }

        public final void L0(a aVar, int i11) {
            Subject subject = aVar.b().get(i11);
            HashMap map = new HashMap();
            map.put("event_type", "browse_music_rank_list_item");
            map.put("sequence", String.valueOf(i11));
            map.put("tabId", String.valueOf(this.I));
            ot.b.a(this.H, map);
            ot.b.c(subject, map);
            com.transsion.baselib.helper.a.f51183a.d(SubTabFragment.f52541r.a(this.I), map);
        }

        public final void M0(a aVar, int i11) {
            Subject subject = aVar.b().get(i11);
            HashMap map = new HashMap();
            map.put("event_type", "click_music_rank_list_item");
            map.put("sequence", String.valueOf(i11));
            map.put("tabId", String.valueOf(this.I));
            ot.b.a(this.H, map);
            ot.b.c(subject, map);
            com.transsion.baselib.helper.a.f51183a.e(SubTabFragment.f52541r.a(this.I), map);
        }
    }

    public SubMusicRankProvider(int i11, boolean z11) {
        this.f52146f = i11;
        this.f52147g = z11;
    }

    public static final void y(Function0 onMoreClick, View view) {
        Intrinsics.g(onMoreClick, "$onMoreClick");
        onMoreClick.invoke();
    }

    public static final void z(Function0 onMoreClick, View view) {
        Intrinsics.g(onMoreClick, "$onMoreClick");
        onMoreClick.invoke();
    }

    public final void A(OperateItem operateItem) {
        List<OperateItem> listD;
        HashMap map = new HashMap();
        map.put("event_type", "browse_music_rank_more");
        BaseProviderMultiAdapter<OperateItem> baseProviderMultiAdapterC = c();
        map.put("sequence", String.valueOf((baseProviderMultiAdapterC == null || (listD = baseProviderMultiAdapterC.D()) == null) ? null : Integer.valueOf(listD.indexOf(operateItem))));
        String deepLink = operateItem.getDeepLink();
        if (deepLink == null) {
            deepLink = "";
        }
        map.put("deepLink", deepLink);
        String title = operateItem.getTitle();
        map.put(CampaignEx.JSON_KEY_TITLE, title != null ? title : "");
        map.put("tabId", String.valueOf(this.f52146f));
        ot.b.a(operateItem, map);
        map.put("opt_type", PostItemType.RANKING_LIST_MUSIC.getValue() + "_MORE");
        com.transsion.baselib.helper.a.f51183a.d(SubTabFragment.f52541r.a(this.f52146f), map);
    }

    public final void B(OperateItem operateItem) {
        List<OperateItem> listD;
        HashMap map = new HashMap();
        map.put("event_type", "click_music_rank_more");
        BaseProviderMultiAdapter<OperateItem> baseProviderMultiAdapterC = c();
        map.put("sequence", String.valueOf((baseProviderMultiAdapterC == null || (listD = baseProviderMultiAdapterC.D()) == null) ? null : Integer.valueOf(listD.indexOf(operateItem))));
        String deepLink = operateItem.getDeepLink();
        if (deepLink == null) {
            deepLink = "";
        }
        map.put("deepLink", deepLink);
        String title = operateItem.getTitle();
        map.put(CampaignEx.JSON_KEY_TITLE, title != null ? title : "");
        map.put("tabId", String.valueOf(this.f52146f));
        ot.b.a(operateItem, map);
        map.put("opt_type", PostItemType.RANKING_LIST_MUSIC.getValue() + "_MORE");
        com.transsion.baselib.helper.a.f51183a.e(SubTabFragment.f52541r.a(this.f52146f), map);
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int h() {
        return PostItemType.RANKING_LIST_MUSIC.ordinal();
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    public int i() {
        return R$layout.post_list_item_op_movie_rank;
    }

    @Override // com.chad.library.adapter.base.provider.BaseItemProvider
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public void a(BaseViewHolder helper, final OperateItem item) {
        Intrinsics.g(helper, "helper");
        Intrinsics.g(item, "item");
        TextView textView = (TextView) helper.getView(R$id.main_operation_movie_rank_title);
        textView.setText(item.getTitle());
        TextView textView2 = (TextView) helper.getView(R$id.main_operation_movie_more_text);
        String deepLink = item.getDeepLink();
        if (deepLink == null || deepLink.length() == 0) {
            so.c.h(textView2);
        } else {
            final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.transsion.home.adapter.suboperate.provider.SubMusicRankProvider$convert$onMoreClick$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    String deepLink2 = item.getDeepLink();
                    if (deepLink2 == null || !StringsKt__StringsKt.Q(deepLink2, "&showType=", false, 2, null)) {
                        String deepLink3 = item.getDeepLink();
                        if (deepLink3 != null) {
                            com.transsion.baselib.utils.i.d(deepLink3, "&showType=2");
                        }
                    } else {
                        String deepLink4 = item.getDeepLink();
                        if (deepLink4 != null) {
                            com.transsion.baselib.utils.i.e(deepLink4, null, 1, null);
                        }
                    }
                    this.B(item);
                }
            };
            so.c.k(textView2);
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.provider.n
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubMusicRankProvider.y(function0, view);
                }
            });
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.adapter.suboperate.provider.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    SubMusicRankProvider.z(function0, view);
                }
            });
            A(item);
        }
        RecyclerView recyclerView = (RecyclerView) helper.getView(R$id.main_operation_movie_rank_recycler);
        b bVar = new b(0, item, this.f52146f, this.f52147g, 1, null);
        recyclerView.setAdapter(bVar);
        recyclerView.setLayoutManager(new LinearLayoutManager(g(), 0, false));
        if (!this.f52147g) {
            recyclerView.setOnFlingListener(null);
            new androidx.recyclerview.widget.m().attachToRecyclerView(recyclerView);
        }
        ArrayList arrayList = new ArrayList();
        List<AppointSubject> subjects = item.getSubjects();
        if (subjects != null) {
            int iG = kotlin.ranges.a.g(subjects.size(), 9);
            a aVar = null;
            for (int i11 = 0; i11 < iG; i11++) {
                if (aVar == null) {
                    aVar = new a(Integer.valueOf(i11 / 3), new ArrayList());
                }
                aVar.b().add(subjects.get(i11));
                if (aVar.b().size() == 3) {
                    arrayList.add(aVar);
                    aVar = null;
                }
            }
            bVar.w0(arrayList);
        }
    }
}
