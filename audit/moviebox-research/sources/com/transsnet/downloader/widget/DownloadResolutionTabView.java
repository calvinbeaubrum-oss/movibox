package com.transsnet.downloader.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.Postcard;
import com.blankj.utilcode.util.f0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.noober.background.view.BLConstraintLayout;
import com.noober.background.view.BLTextView;
import com.tn.lib.view.layoutmanager.NpaGridLayoutManager;
import com.tn.lib.widget.R$string;
import com.transsion.memberapi.IMemberApi;
import com.transsion.memberapi.MemberCheckResult;
import com.transsion.moviedetailapi.bean.DownloadResolutionItem;
import com.transsion.moviedetailapi.bean.DubsInfo;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsnet.downloader.R$layout;
import h00.v0;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SuppressLint({"ViewConstructor"})
@SourceDebugExtension
public final class DownloadResolutionTabView extends BLConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f61320a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v0 f61321b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f61322c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.transsnet.downloader.adapter.m f61323d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function2<? super Integer, ? super DownloadResolutionItem, Unit> f61324f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function2<? super Integer, ? super DubsInfo, Unit> f61325g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Function0<Unit> f61326h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function0<Unit> f61327i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f61328j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f61329k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Subject f61330l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f61331m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Integer f61332n;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements su.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseQuickAdapter<?, ?> f61334b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f61335c;

        public a(BaseQuickAdapter<?, ?> baseQuickAdapter, int i11) {
            this.f61334b = baseQuickAdapter;
            this.f61335c = i11;
        }

        @Override // su.a
        public void a(MemberCheckResult memberCheckResult) {
            su.a.C0841a.f(this, memberCheckResult);
        }

        @Override // su.a
        public void b(MemberCheckResult memberCheckResult) {
            su.a.C0841a.d(this, memberCheckResult);
        }

        @Override // su.a
        public void c(MemberCheckResult memberCheckResult) {
            su.a.C0841a.e(this, memberCheckResult);
        }

        @Override // su.a
        public void d() {
            su.a.C0841a.c(this);
            DownloadResolutionTabView downloadResolutionTabView = DownloadResolutionTabView.this;
            BaseQuickAdapter<?, ?> adapter = this.f61334b;
            Intrinsics.f(adapter, "adapter");
            downloadResolutionTabView.i(adapter, this.f61335c);
        }

        @Override // su.a
        public void e(MemberCheckResult memberCheckResult) {
            su.a.C0841a.a(this, memberCheckResult);
        }

        @Override // su.a
        public void onFail(String errorMsg) {
            Intrinsics.g(errorMsg, "errorMsg");
            su.a.C0841a.b(this, errorMsg);
            uo.b.a.f(uo.b.f78622a, "co_mem", "DownloadResolutionTabView --> initRvAndAdapter() --> 剧集选择分辨率 -->  " + errorMsg, false, 4, null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadResolutionTabView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DownloadResolutionTabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadResolutionTabView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f61320a = "DownloadResolutionTabView";
        this.f61322c = f0.a(16.0f);
        this.f61328j = -1;
        this.f61329k = -1;
        this.f61331m = 1;
        View.inflate(context, R$layout.layout_download_re_resolution_tab, this);
        v0 v0VarA = v0.a(this);
        Intrinsics.f(v0VarA, "bind(this)");
        this.f61321b = v0VarA;
        h();
    }

    private final void f() {
        com.transsnet.downloader.adapter.m mVar = new com.transsnet.downloader.adapter.m();
        mVar.B0(new f9.d() { // from class: com.transsnet.downloader.widget.n
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                DownloadResolutionTabView.g(this.f61391a, baseQuickAdapter, view, i11);
            }
        });
        this.f61323d = mVar;
        RecyclerView recyclerView = this.f61321b.f66062i;
        recyclerView.setLayoutManager(new NpaGridLayoutManager(recyclerView.getContext(), 4));
        if (recyclerView.getItemDecorationCount() == 0) {
            recyclerView.addItemDecoration(new ro.a(gs.a.a(8), 0, 0, 0));
        }
        recyclerView.setAdapter(this.f61323d);
    }

    public static final void g(DownloadResolutionTabView this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        if (i11 == this$0.f61328j) {
            return;
        }
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(R$string.no_network_tips);
            return;
        }
        Object item = adapter.getItem(i11);
        DownloadResolutionItem downloadResolutionItem = item instanceof DownloadResolutionItem ? (DownloadResolutionItem) item : null;
        if (downloadResolutionItem != null) {
            ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).i(Integer.valueOf(downloadResolutionItem.getResolution()), this$0.new a(adapter, i11));
        }
    }

    /* JADX WARN: Code duplicated, block: B:6:0x0013  */
    private final void h() {
        ConstraintLayout.b bVar;
        if (getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            bVar = (ConstraintLayout.b) layoutParams;
            if (bVar == null) {
                bVar = new ConstraintLayout.b(-1, -2);
            }
        } else {
            bVar = new ConstraintLayout.b(-1, -2);
        }
        bVar.setMarginStart(this.f61322c);
        bVar.setMarginEnd(this.f61322c);
        setLayoutParams(bVar);
        f();
        j();
    }

    public static final void k(DownloadResolutionTabView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Postcard postcardWithString = com.alibaba.android.arouter.launcher.a.d().b("/profile/user_center_labels_feedback").withString("feedback_from_page", "SUBJECT_DETAIL");
        Subject subject = this$0.f61330l;
        postcardWithString.withString("subject_id", subject != null ? subject.getSubjectId() : null).navigation();
    }

    public static final void l(DownloadResolutionTabView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        uo.b.a.f(uo.b.f78622a, "DownloadDialog", "innerTvTitle click then switch audio track", false, 4, null);
        Function0<Unit> function0 = this$0.f61326h;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public static final void m(DownloadResolutionTabView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        uo.b.a.f(uo.b.f78622a, "DownloadDialog", "Switch seasons", false, 4, null);
        com.blankj.utilcode.util.a.b();
        Function0<Unit> function0 = this$0.f61327i;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void i(BaseQuickAdapter<?, ?> baseQuickAdapter, int i11) {
        try {
            Object item = baseQuickAdapter.getItem(this.f61328j);
            DownloadResolutionItem downloadResolutionItem = item instanceof DownloadResolutionItem ? (DownloadResolutionItem) item : null;
            if (downloadResolutionItem != null) {
                downloadResolutionItem.setSelected(false);
            }
            baseQuickAdapter.notifyItemChanged(this.f61328j, Boolean.FALSE);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        Object item2 = baseQuickAdapter.getItem(i11);
        DownloadResolutionItem downloadResolutionItem2 = item2 instanceof DownloadResolutionItem ? (DownloadResolutionItem) item2 : null;
        if (downloadResolutionItem2 != null) {
            downloadResolutionItem2.setSelected(true);
        }
        baseQuickAdapter.notifyItemChanged(i11, Boolean.TRUE);
        this.f61328j = i11;
        Function2<? super Integer, ? super DownloadResolutionItem, Unit> function2 = this.f61324f;
        if (function2 != null) {
            Integer numValueOf = Integer.valueOf(i11);
            Intrinsics.d(downloadResolutionItem2);
            function2.invoke(numValueOf, downloadResolutionItem2);
        }
    }

    public final void j() {
        this.f61321b.f66056b.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.widget.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadResolutionTabView.k(this.f61392a, view);
            }
        });
        this.f61321b.f66063j.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.widget.p
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadResolutionTabView.l(this.f61393a, view);
            }
        });
        this.f61321b.f66060g.setOnClickListener(new View.OnClickListener() { // from class: com.transsnet.downloader.widget.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                DownloadResolutionTabView.m(this.f61394a, view);
            }
        });
    }

    public final void n(int i11) {
        this.f61331m = i11;
        Subject subject = this.f61330l;
        if (subject != null && subject.isTvType()) {
            BLTextView bLTextView = this.f61321b.f66060g;
            Context context = getContext();
            bLTextView.setText(context != null ? context.getString(com.transsnet.downloader.R$string.download_video_detail_season_index, com.transsion.moviedetailapi.helper.b.a(i11)) : null);
            return;
        }
        Subject subject2 = this.f61330l;
        if (subject2 == null || !subject2.isEduType()) {
            BLTextView bLTextView2 = this.f61321b.f66060g;
            Intrinsics.f(bLTextView2, "viewBinding.ivSeasons");
            so.c.g(bLTextView2);
        } else {
            BLTextView bLTextView3 = this.f61321b.f66060g;
            Context context2 = getContext();
            bLTextView3.setText(context2 != null ? context2.getString(com.transsnet.downloader.R$string.download_video_detail_unit_index, com.transsion.moviedetailapi.helper.b.a(i11)) : null);
        }
    }

    public final void setAudioClickListener(Function0<Unit> listener) {
        Intrinsics.g(listener, "listener");
        this.f61326h = listener;
    }

    public final void setAudioContentData(List<DubsInfo> data, int i11) {
        Intrinsics.g(data, "data");
        uo.b.a.f(uo.b.f78622a, "DownloadDialog", "setAudioContentData size:" + data.size(), false, 4, null);
        this.f61329k = i11;
        BLTextView bLTextView = this.f61321b.f66063j;
        Intrinsics.f(bLTextView, "viewBinding.tvLanguage");
        bLTextView.setVisibility((data.isEmpty() ^ true) && data.size() > 1 ? 0 : 8);
        if (i11 < 0 || i11 >= data.size()) {
            return;
        }
        this.f61321b.f66063j.setText(data.get(i11).getLanName());
    }

    public final void setAudioItemClickListener(Function2<? super Integer, ? super DubsInfo, Unit> listener) {
        Intrinsics.g(listener, "listener");
        this.f61325g = listener;
    }

    public final void setResolutionContentData(List<DownloadResolutionItem> data, int i11) {
        Intrinsics.g(data, "data");
        RecyclerView recyclerView = this.f61321b.f66062i;
        Intrinsics.f(recyclerView, "viewBinding.qualityRecyclerView");
        so.c.k(recyclerView);
        View view = this.f61321b.f66065l;
        Intrinsics.f(view, "viewBinding.vLine");
        so.c.k(view);
        this.f61328j = i11;
        com.transsnet.downloader.adapter.m mVar = this.f61323d;
        if (mVar != null) {
            List<DownloadResolutionItem> list = data;
            mVar.w0(list);
            if (!list.isEmpty()) {
                i(mVar, i11);
            }
        }
    }

    public final void setResolutionItemClickListener(Function2<? super Integer, ? super DownloadResolutionItem, Unit> listener) {
        Intrinsics.g(listener, "listener");
        this.f61324f = listener;
    }

    public final void setSeason(int i11) {
        n(i11);
    }

    public final void setSeasonClickListener(Function0<Unit> listener) {
        Intrinsics.g(listener, "listener");
        this.f61327i = listener;
    }

    public final void setSeasons(int i11) {
        this.f61332n = Integer.valueOf(i11);
        if (i11 <= 1) {
            BLTextView bLTextView = this.f61321b.f66060g;
            Intrinsics.f(bLTextView, "viewBinding.ivSeasons");
            so.c.g(bLTextView);
        } else {
            BLTextView bLTextView2 = this.f61321b.f66060g;
            Intrinsics.f(bLTextView2, "viewBinding.ivSeasons");
            so.c.k(bLTextView2);
        }
    }

    public final void setSubject(Subject subject) {
        ResourceDetectors resourceDetectors;
        Intrinsics.g(subject, "subject");
        this.f61330l = subject;
        List<ResourceDetectors> resourceDetectors2 = subject.getResourceDetectors();
        if (resourceDetectors2 == null || (resourceDetectors = (ResourceDetectors) CollectionsKt___CollectionsKt.g0(resourceDetectors2)) == null) {
            return;
        }
        this.f61321b.f66058d.setText(resourceDetectors.getUploadBy());
    }

    public final void updateAudioTrack(String str) {
        this.f61321b.f66063j.setText(str);
    }
}
