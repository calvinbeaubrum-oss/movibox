package com.transsion.home.fragment;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.c0;
import androidx.lifecycle.d0;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.sdk.android.oss.common.RequestParameters;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.banner.R$mipmap;
import com.transsion.baseui.R$string;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.bean.RankAllData;
import com.transsion.home.p003enum.HomeTabId;
import com.transsion.home.utils.HomeUtilsKt;
import com.transsion.home.viewmodel.RankAllViewModel;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.usercenter.R$color;
import com.transsnet.downloader.widget.DownloadView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Function;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;

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
public final class RankListFragment extends BaseFragment<lt.o> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RankAllViewModel f52434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public BaseQuickAdapter<Subject, BaseViewHolder> f52435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public TextView f52436c;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends BaseQuickAdapter<Subject, BaseViewHolder> implements h9.j {
        public a() {
            super(R$layout.item_movie_rank_education_subject, null, 2, null);
        }

        public static final void I0(a this$0, Subject item, int i11, View view) {
            Intrinsics.g(this$0, "this$0");
            Intrinsics.g(item, "$item");
            this$0.N0(item, i11);
        }

        private final int K0(int i11) {
            if (i11 == 0) {
                return R$mipmap.ic_rank_01;
            }
            if (i11 != 1) {
                return i11 != 2 ? R$mipmap.ic_rank_defalut : R$mipmap.ic_rank_03;
            }
            return R$mipmap.ic_rank_02;
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* JADX INFO: renamed from: H0, reason: merged with bridge method [inline-methods] */
        public void x(BaseViewHolder holder, final Subject item) {
            String strValueOf;
            String thumbnail;
            String url;
            Intrinsics.g(holder, "holder");
            Intrinsics.g(item, "item");
            ImageView imageView = (ImageView) holder.getView(R$id.rank_item_image);
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context context = imageView.getContext();
            Intrinsics.f(context, "imageView.context");
            Cover cover = item.getCover();
            String str = (cover == null || (url = cover.getUrl()) == null) ? "" : url;
            Cover cover2 = item.getCover();
            companion.q(context, imageView, str, (8120 & 8) != 0 ? companion.d() : 0, (8120 & 16) != 0 ? companion.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
            final int iB = com.transsion.baselib.utils.i.b(D(), item);
            AppCompatImageView appCompatImageView = (AppCompatImageView) holder.getViewOrNull(R$id.rank_item_rank_tag);
            if (appCompatImageView != null) {
                appCompatImageView.setImageResource(K0(iB));
            }
            if (iB > 2) {
                if (iB < 9) {
                    strValueOf = "0" + (iB + 1);
                } else {
                    strValueOf = String.valueOf(iB + 1);
                }
                holder.setText(R$id.rank_item_tag_rank, strValueOf);
            } else {
                holder.setText(R$id.rank_item_tag_rank, "");
            }
            TextView textView = (TextView) holder.getView(R$id.rank_item_rank_duration);
            Integer durationSeconds = item.getDurationSeconds();
            textView.setText(J0(durationSeconds != null ? durationSeconds.intValue() : 0));
            TextView textView2 = (TextView) holder.getView(R$id.rank_item_title);
            textView2.setText(item.getTitle());
            textView2.setGravity(ot.a.d());
            ((TextView) holder.getView(R$id.rank_item_des)).setText(item.getViewers() + " students");
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.o
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RankListFragment.a.I0(this.f52453a, item, iB, view);
                }
            });
            L0(item, iB);
        }

        public final String J0(int i11) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
            String str = String.format("%02d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i11 / 3600), Integer.valueOf((i11 % 3600) / 60), Integer.valueOf(i11 % 60)}, 3));
            Intrinsics.f(str, "format(...)");
            return str;
        }

        public final void L0(Subject subject, int i11) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            ot.b.c(subject, linkedHashMap);
            linkedHashMap.put("event_type", "rank_item_browse");
            linkedHashMap.put(RequestParameters.POSITION, String.valueOf(i11));
            com.transsion.baselib.report.m.f51277a.t("rank_all_page", "browse", linkedHashMap);
        }

        public final void M0(Subject subject, int i11) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            ot.b.c(subject, linkedHashMap);
            linkedHashMap.put(RequestParameters.POSITION, String.valueOf(i11));
            linkedHashMap.put("event_type", "rank_item_click");
            linkedHashMap.put("click_type", "poster_click");
            com.transsion.baselib.report.m.f51277a.m("rank_all_page", "click", linkedHashMap);
        }

        public final void N0(Subject subject, int i11) {
            HomeUtilsKt.b(subject, "rank_all");
            M0(subject, i11);
        }

        @Override // h9.j
        public /* synthetic */ h9.f a(BaseQuickAdapter baseQuickAdapter) {
            return h9.i.a(this, baseQuickAdapter);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends BaseQuickAdapter<Subject, BaseViewHolder> implements h9.j {
        public b() {
            super(R$layout.item_movie_rank_subject, null, 2, null);
        }

        public static final void K0(TextView descriptorTextView, TextView titleTexView, Subject item) {
            Intrinsics.g(descriptorTextView, "$descriptorTextView");
            Intrinsics.g(titleTexView, "$titleTexView");
            Intrinsics.g(item, "$item");
            descriptorTextView.setMaxLines(titleTexView.getLineCount() > 1 ? 2 : 3);
            descriptorTextView.setText(item.getDescription());
        }

        public static final void L0(b this$0, Subject item, int i11, View view) {
            Intrinsics.g(this$0, "this$0");
            Intrinsics.g(item, "$item");
            this$0.S0(item, i11);
        }

        public static final void M0(b this$0, Subject item, int i11, View view) {
            Intrinsics.g(this$0, "this$0");
            Intrinsics.g(item, "$item");
            this$0.R0(item, i11);
        }

        private final int N0(int i11) {
            if (i11 == 0) {
                return R$mipmap.ic_rank_01;
            }
            if (i11 != 1) {
                return i11 != 2 ? R$mipmap.ic_rank_defalut : R$mipmap.ic_rank_03;
            }
            return R$mipmap.ic_rank_02;
        }

        private final void O0(Subject subject, int i11) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            ot.b.c(subject, linkedHashMap);
            linkedHashMap.put("event_type", "rank_item_browse");
            linkedHashMap.put(RequestParameters.POSITION, String.valueOf(i11));
            com.transsion.baselib.report.m.f51277a.t("rank_all_page", "browse", linkedHashMap);
        }

        private final void S0(Subject subject, int i11) {
            HomeUtilsKt.b(subject, "rank_all");
            P0(subject, i11, "poster_click");
        }

        @Override // com.chad.library.adapter.base.BaseQuickAdapter
        /* JADX INFO: renamed from: J0, reason: merged with bridge method [inline-methods] */
        public void x(BaseViewHolder holder, final Subject item) {
            String strValueOf;
            String thumbnail;
            String url;
            Intrinsics.g(holder, "holder");
            Intrinsics.g(item, "item");
            ImageView imageView = (ImageView) holder.getView(R$id.rank_item_image);
            ImageHelper.Companion companion = ImageHelper.f51371a;
            Context context = imageView.getContext();
            Intrinsics.f(context, "imageView.context");
            Cover cover = item.getCover();
            String str = (cover == null || (url = cover.getUrl()) == null) ? "" : url;
            Cover cover2 = item.getCover();
            companion.q(context, imageView, str, (8120 & 8) != 0 ? companion.d() : 0, (8120 & 16) != 0 ? companion.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : (cover2 == null || (thumbnail = cover2.getThumbnail()) == null) ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
            final int iB = com.transsion.baselib.utils.i.b(D(), item);
            AppCompatImageView appCompatImageView = (AppCompatImageView) holder.getViewOrNull(R$id.rank_item_rank_tag);
            if (appCompatImageView != null) {
                appCompatImageView.setImageResource(N0(iB));
            }
            holder.setText(R$id.rank_item_corner, item.getCorner());
            if (iB > 2) {
                if (iB < 9) {
                    strValueOf = "0" + (iB + 1);
                } else {
                    strValueOf = String.valueOf(iB + 1);
                }
                holder.setText(R$id.rank_item_tag_rank, strValueOf);
            } else {
                holder.setText(R$id.rank_item_tag_rank, "");
            }
            final TextView textView = (TextView) holder.getView(R$id.rank_item_title);
            final TextView textView2 = (TextView) holder.getView(R$id.rank_item_des);
            textView.setText(item.getTitle());
            textView.setGravity(ot.a.d());
            textView.post(new Runnable() { // from class: com.transsion.home.fragment.p
                @Override // java.lang.Runnable
                public final void run() {
                    RankListFragment.b.K0(textView2, textView, item);
                }
            });
            Q0(item, (DownloadView) holder.getView(R$id.rank_item_download));
            holder.setText(R$id.rank_item_imdb, item.getImdbRate());
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.q
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RankListFragment.b.L0(this.f52459a, item, iB, view);
                }
            });
            holder.getView(R$id.rank_item_download).setOnClickListener(new View.OnClickListener() { // from class: com.transsion.home.fragment.r
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    RankListFragment.b.M0(this.f52462a, item, iB, view);
                }
            });
            O0(item, iB);
        }

        public final void P0(Subject subject, int i11, String str) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            ot.b.c(subject, linkedHashMap);
            linkedHashMap.put(RequestParameters.POSITION, String.valueOf(i11));
            linkedHashMap.put("event_type", "rank_item_click");
            linkedHashMap.put("click_type", str);
            com.transsion.baselib.report.m.f51277a.m("rank_all_page", "click", linkedHashMap);
        }

        public final void Q0(Subject subject, DownloadView downloadView) {
            if (subject == null || !Intrinsics.b(subject.getHasResource(), Boolean.TRUE)) {
                so.c.h(downloadView);
                return;
            }
            so.c.k(downloadView);
            if (com.transsion.baselib.utils.m.f51320a.b()) {
                Integer subjectType = subject.getSubjectType();
                int value = SubjectType.SHORT_TV.getValue();
                if (subjectType == null || subjectType.intValue() != value) {
                    downloadView.setShowPlayType();
                    return;
                }
            }
            DownloadView.setShowType$default(downloadView, subject.getSubjectId(), null, null, false, R$string.download_movie, 14, null);
        }

        public final void R0(Subject subject, int i11) {
            P0(subject, i11, HomeUtilsKt.c(subject, "rank_all_page", getContext(), "rank_all"));
        }

        @Override // h9.j
        public /* synthetic */ h9.f a(BaseQuickAdapter baseQuickAdapter) {
            return h9.i.a(this, baseQuickAdapter);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f52437a;

        public c(Function1 function) {
            Intrinsics.g(function, "function");
            this.f52437a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f52437a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f52437a.invoke(obj);
        }
    }

    /* JADX INFO: renamed from: com.transsion.home.fragment.RankListFragment$lazyLoadData$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class AnonymousClass2 extends Lambda implements Function1<RankAllData, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        public static final void b(RankListFragment this$0, RankAllData rankAllData) {
            BaseQuickAdapter baseQuickAdapter;
            h9.f fVarQ;
            h9.f fVarQ2;
            BaseQuickAdapter baseQuickAdapter2;
            h9.f fVarQ3;
            Intrinsics.g(this$0, "this$0");
            BaseQuickAdapter baseQuickAdapter3 = this$0.f52435b;
            if (baseQuickAdapter3 != null && (fVarQ2 = baseQuickAdapter3.Q()) != null && fVarQ2.q() && (baseQuickAdapter2 = this$0.f52435b) != null && (fVarQ3 = baseQuickAdapter2.Q()) != null) {
                fVarQ3.r();
            }
            Pager pager = rankAllData.getPager();
            if ((pager != null && Intrinsics.b(pager.getHasMore(), Boolean.TRUE)) || (baseQuickAdapter = this$0.f52435b) == null || (fVarQ = baseQuickAdapter.Q()) == null) {
                return;
            }
            h9.f.t(fVarQ, false, 1, null);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RankAllData rankAllData) {
            invoke2(rankAllData);
            return Unit.f68710a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(final RankAllData rankAllData) {
            ConstraintLayout root;
            h9.f fVarQ;
            if (rankAllData == null) {
                BaseQuickAdapter baseQuickAdapter = RankListFragment.this.f52435b;
                if (baseQuickAdapter == null || (fVarQ = baseQuickAdapter.Q()) == null) {
                    return;
                }
                fVarQ.u();
                return;
            }
            BaseQuickAdapter baseQuickAdapter2 = RankListFragment.this.f52435b;
            if (baseQuickAdapter2 != null) {
                List subjects = rankAllData.getSubjects();
                baseQuickAdapter2.m(subjects != null ? subjects : new ArrayList());
            }
            lt.o mViewBinding = RankListFragment.this.getMViewBinding();
            if (mViewBinding == null || (root = mViewBinding.getRoot()) == null) {
                return;
            }
            final RankListFragment rankListFragment = RankListFragment.this;
            root.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.s
                @Override // java.lang.Runnable
                public final void run() {
                    RankListFragment.AnonymousClass2.b(rankListFragment, rankAllData);
                }
            }, 300L);
        }
    }

    public static final void k0(final RankListFragment this$0) {
        RecyclerView recyclerView;
        Intrinsics.g(this$0, "this$0");
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            RankAllViewModel rankAllViewModel = this$0.f52434a;
            if (rankAllViewModel != null) {
                rankAllViewModel.k();
                return;
            }
            return;
        }
        zp.b.f82110a.d(com.tn.lib.widget.R$string.no_network_toast);
        lt.o mViewBinding = this$0.getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f70490b) == null) {
            return;
        }
        recyclerView.postDelayed(new Runnable() { // from class: com.transsion.home.fragment.n
            @Override // java.lang.Runnable
            public final void run() {
                RankListFragment.l0(this.f52452a);
            }
        }, 500L);
    }

    public static final void l0(RankListFragment this$0) {
        h9.f fVarQ;
        Intrinsics.g(this$0, "this$0");
        BaseQuickAdapter<Subject, BaseViewHolder> baseQuickAdapter = this$0.f52435b;
        if (baseQuickAdapter == null || (fVarQ = baseQuickAdapter.Q()) == null) {
            return;
        }
        fVarQ.u();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void hideLoading() {
        ConstraintLayout constraintLayout;
        lt.o mViewBinding = getMViewBinding();
        if (mViewBinding == null || (constraintLayout = mViewBinding.f70491c) == null) {
            return;
        }
        so.c.h(constraintLayout);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        RecyclerView recyclerView;
        Bundle arguments;
        Intrinsics.g(view, "view");
        Fragment parentFragment = getParentFragment();
        Integer numValueOf = (parentFragment == null || (arguments = parentFragment.getArguments()) == null) ? null : Integer.valueOf(arguments.getInt("tabId"));
        this.f52435b = (numValueOf != null && numValueOf.intValue() == HomeTabId.Education.getValue()) ? new a() : new b();
        lt.o mViewBinding = getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f70490b) == null) {
            return;
        }
        recyclerView.setAdapter(this.f52435b);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new ro.e(0.0f, 16.0f, 0.0f, 5, null));
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public lt.o getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        FragmentActivity activity = getActivity();
        if (activity != null) {
            this.f52434a = (RankAllViewModel) new v0(activity).a(RankAllViewModel.class);
        }
        lt.o oVarC = lt.o.c(inflater);
        Intrinsics.f(oVarC, "inflate(inflater)");
        return oVarC;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        c0<RankAllData> c0VarH;
        h9.f fVarQ;
        BaseQuickAdapter<Subject, BaseViewHolder> baseQuickAdapter = this.f52435b;
        if (baseQuickAdapter != null && (fVarQ = baseQuickAdapter.Q()) != null) {
            fVarQ.C(new f9.f() { // from class: com.transsion.home.fragment.m
                @Override // f9.f
                public final void a() {
                    RankListFragment.k0(this.f52451a);
                }
            });
        }
        RankAllViewModel rankAllViewModel = this.f52434a;
        if (rankAllViewModel == null || (c0VarH = rankAllViewModel.h()) == null) {
            return;
        }
        c0VarH.j(this, new c(new AnonymousClass2()));
    }

    public final void m0(View errorView) {
        Intrinsics.g(errorView, "errorView");
        BaseQuickAdapter<Subject, BaseViewHolder> baseQuickAdapter = this.f52435b;
        if (baseQuickAdapter != null) {
            baseQuickAdapter.w0(null);
        }
        BaseQuickAdapter<Subject, BaseViewHolder> baseQuickAdapter2 = this.f52435b;
        if (baseQuickAdapter2 != null) {
            baseQuickAdapter2.r0(errorView);
        }
    }

    public final void n0(RankAllData rankAllData) {
        h9.f fVarQ;
        RecyclerView recyclerView;
        Pager pager;
        BaseQuickAdapter<Subject, BaseViewHolder> baseQuickAdapter = this.f52435b;
        if (baseQuickAdapter != null) {
            baseQuickAdapter.w0(rankAllData != null ? rankAllData.getSubjects() : null);
        }
        TextView textView = this.f52436c;
        if (textView == null) {
            TextView textView2 = new TextView(getContext());
            textView2.setText(rankAllData != null ? rankAllData.getTitle() : null);
            textView2.setPadding(f0.a(12.0f), f0.a(16.0f), f0.a(12.0f), 0);
            textView2.setTextSize(2, 16.0f);
            textView2.setTextColor(z2.a.getColor(textView2.getContext(), R$color.pair_text_191F2B));
            textView2.setMaxLines(2);
            textView2.setGravity(ot.a.d());
            textView2.setEllipsize(TextUtils.TruncateAt.END);
            textView2.setTypeface(Typeface.create("ans-serif", 1));
            BaseQuickAdapter<Subject, BaseViewHolder> baseQuickAdapter2 = this.f52435b;
            if (baseQuickAdapter2 != null) {
                BaseQuickAdapter.q(baseQuickAdapter2, textView2, 0, 0, 6, null);
            }
            this.f52436c = textView2;
        } else if (textView != null) {
            textView.setText(rankAllData != null ? rankAllData.getTitle() : null);
        }
        if (rankAllData == null || (pager = rankAllData.getPager()) == null || !Intrinsics.b(pager.getHasMore(), Boolean.TRUE)) {
            BaseQuickAdapter<Subject, BaseViewHolder> baseQuickAdapter3 = this.f52435b;
            if (baseQuickAdapter3 != null && (fVarQ = baseQuickAdapter3.Q()) != null) {
                h9.f.t(fVarQ, false, 1, null);
            }
        } else {
            BaseQuickAdapter<Subject, BaseViewHolder> baseQuickAdapter4 = this.f52435b;
            h9.f fVarQ2 = baseQuickAdapter4 != null ? baseQuickAdapter4.Q() : null;
            if (fVarQ2 != null) {
                fVarQ2.y(true);
            }
            BaseQuickAdapter<Subject, BaseViewHolder> baseQuickAdapter5 = this.f52435b;
            h9.f fVarQ3 = baseQuickAdapter5 != null ? baseQuickAdapter5.Q() : null;
            if (fVarQ3 != null) {
                fVarQ3.x(true);
            }
        }
        lt.o mViewBinding = getMViewBinding();
        if (mViewBinding == null || (recyclerView = mViewBinding.f70490b) == null) {
            return;
        }
        recyclerView.scrollToPosition(0);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void startLoading() {
        ConstraintLayout constraintLayout;
        lt.o mViewBinding = getMViewBinding();
        if (mViewBinding == null || (constraintLayout = mViewBinding.f70491c) == null) {
            return;
        }
        so.c.k(constraintLayout);
    }
}
