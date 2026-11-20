package com.transsion.home.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import com.alibaba.android.arouter.facade.Postcard;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.transsion.banner.view.HRecyclerView;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import com.transsion.home.p003enum.HomeTabType;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.OperateItem;
import com.transsion.moviedetailapi.bean.PostItemType;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.DownloadManagerApi;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.v;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
public final class OpRankingView extends LinearLayoutCompat {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public RankingAdapter f52676q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f52677r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final TreeSet<Integer> f52678s;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OpRankingView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public OpRankingView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpRankingView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        LayoutInflater.from(context).inflate(R$layout.post_list_item_ranking_view, (ViewGroup) this, true);
        setOrientation(1);
        this.f52678s = v.e(new Integer[0]);
    }

    private final void v(Subject subject) {
        Integer subjectType = subject.getSubjectType();
        int value = SubjectType.SHORT_TV.getValue();
        if (subjectType == null || subjectType.intValue() != value) {
            Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/movie/detail");
            Integer subjectType2 = subject.getSubjectType();
            postcardB.withInt("subject_type", subjectType2 != null ? subjectType2.intValue() : SubjectType.MOVIE.getValue()).withString("id", subject.getSubjectId()).withString("module_name", "opt_ranking").withString("ops", subject.getOps()).navigation();
        } else {
            DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
            Context context = getContext();
            Intrinsics.e(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            downloadManagerApiA.a2((FragmentActivity) context, HomeTabType.TAB_CODE_TRENDING, (384 & 4) != 0 ? "" : "", subject.getOps(), (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : false, (384 & 64) != 0 ? null : subject, (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
        }
    }

    public static final void w(List sub, OpRankingView this$0, OperateItem operateItem, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(sub, "$sub");
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        Subject subject = (Subject) sub.get(i11);
        this$0.v((Subject) sub.get(i11));
        pr.a.f74040a.f(HomeTabType.TAB_CODE_TRENDING, "opt", PostItemType.OP_RANKING.getValue(), (1424 & 8) != 0 ? null : subject.getSubjectId(), (1424 & 16) != 0 ? null : null, (1424 & 32) != 0 ? null : subject.getOps(), (1424 & 64) != 0 ? null : subject.getHasResource(), (1424 & 128) != 0 ? null : null, (1424 & 256) != 0 ? null : null, (1424 & 512) != 0 ? null : Integer.valueOf(i11), (1424 & 1024) != 0 ? null : null, (1424 & 2048) != 0 ? Boolean.FALSE : Boolean.valueOf(subject.getBuiltIn()), (1424 & 4096) != 0 ? null : subject.getTag(), (1424 & 8192) != 0 ? null : operateItem.getTitle(), (1424 & 16384) != 0 ? null : operateItem.getOpId());
    }

    public final SortedSet<Integer> calcExposureLines(GridLayoutManager gridLayoutManager) {
        List<Subject> listD;
        Intrinsics.g(gridLayoutManager, "gridLayoutManager");
        int i11 = 0;
        if (gridLayoutManager.getChildCount() == 0) {
            RankingAdapter rankingAdapter = this.f52676q;
            if (rankingAdapter != null && (listD = rankingAdapter.D()) != null) {
                for (Object obj : listD) {
                    int i12 = i11 + 1;
                    if (i11 < 0) {
                        kotlin.collections.g.u();
                    }
                    this.f52678s.add(Integer.valueOf(i11));
                    i11 = i12;
                }
            }
        } else {
            int i13 = this.f52677r;
            while (i11 < i13) {
                View viewFindViewByPosition = gridLayoutManager.findViewByPosition(i11 * 3);
                if (viewFindViewByPosition != null && viewFindViewByPosition.getGlobalVisibleRect(new Rect())) {
                    this.f52678s.add(Integer.valueOf(i11));
                }
                i11++;
            }
        }
        return this.f52678s;
    }

    public final void setDatas(final OperateItem operateItem) {
        List<Subject> rankings;
        if (operateItem == null) {
            return;
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) findViewById(R$id.tv_title);
        if (appCompatTextView != null) {
            appCompatTextView.setText(operateItem.getTitle());
        }
        HRecyclerView hRecyclerView = (HRecyclerView) findViewById(R$id.recycler_view);
        if (hRecyclerView == null || (rankings = operateItem.getRankings()) == null) {
            return;
        }
        final Context context = hRecyclerView.getContext();
        hRecyclerView.setLayoutManager(new NpaGridLayoutManager(context) { // from class: com.transsion.home.view.OpRankingView$setDatas$2$1$1
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.m
            public boolean canScrollHorizontally() {
                return false;
            }

            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.m
            public boolean canScrollVertically() {
                return false;
            }
        });
        if (hRecyclerView.getItemDecorationCount() < 1) {
            hRecyclerView.addItemDecoration(new ro.b(f0.a(4.0f), f0.a(4.0f), f0.a(16.0f), f0.a(16.0f)));
        }
        int size = rankings.size() / 3;
        this.f52677r = size;
        final List<Subject> listSubList = rankings.subList(0, size * 3);
        RankingAdapter rankingAdapter = new RankingAdapter(CollectionsKt___CollectionsKt.M0(listSubList));
        rankingAdapter.B0(new f9.d() { // from class: com.transsion.home.view.e
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                OpRankingView.w(listSubList, this, operateItem, baseQuickAdapter, view, i11);
            }
        });
        hRecyclerView.setAdapter(rankingAdapter);
        this.f52676q = rankingAdapter;
    }
}
