package com.transsion.postdetail.ui.view;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.android.arouter.facade.Postcard;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.memberapi.IMemberApi;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.viewmodel.LocalVideoDetailViewModel;
import com.transsion.wrapperad.view.NativeSlideshowView;
import com.transsnet.downloader.DownloadManagerApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class LocalVideoMiddleHeaderView extends ConstraintLayout implements su.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tv.z f56012a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f56013b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f56014c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public com.transsion.postdetail.ui.adapter.a f56015d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Function1<? super DownloadBean, Unit> f56016f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Function0<Unit> f56017g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public DownloadBean f56018h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f56019i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f56020j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public NativeSlideshowView f56021k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final int f56022l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f56023m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final int f56024n;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends DiffUtil.e<DownloadBean> {
        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean areContentsTheSame(DownloadBean oldItem, DownloadBean newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            return Intrinsics.b(oldItem.getResourceId(), newItem.getResourceId()) && oldItem.getStatus() == newItem.getStatus() && oldItem.getProgress() == newItem.getProgress() && Intrinsics.b(oldItem.getUpdateTimeStamp(), newItem.getUpdateTimeStamp());
        }

        @Override // androidx.recyclerview.widget.DiffUtil.e
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public boolean areItemsTheSame(DownloadBean oldItem, DownloadBean newItem) {
            Intrinsics.g(oldItem, "oldItem");
            Intrinsics.g(newItem, "newItem");
            return Intrinsics.b(oldItem.getResourceId(), newItem.getResourceId());
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends RecyclerView.l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f56025a;

        public b(int i11) {
            this.f56025a = i11;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.x state) {
            Intrinsics.g(outRect, "outRect");
            Intrinsics.g(view, "view");
            Intrinsics.g(parent, "parent");
            Intrinsics.g(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            RecyclerView.Adapter adapter = parent.getAdapter();
            if (adapter != null) {
                if (childAdapterPosition == 0) {
                    if (so.c.f()) {
                        outRect.right = 0;
                        outRect.left = this.f56025a;
                        return;
                    } else {
                        outRect.left = 0;
                        outRect.right = this.f56025a;
                        return;
                    }
                }
                if (childAdapterPosition != adapter.getItemCount() - 1) {
                    int i11 = this.f56025a;
                    outRect.right = i11;
                    outRect.left = i11;
                } else if (so.c.f()) {
                    int i12 = this.f56025a;
                    outRect.right = i12;
                    outRect.left = i12 * 3;
                } else {
                    int i13 = this.f56025a;
                    outRect.left = i13;
                    outRect.right = i13 * 3;
                }
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f56026a;

        public c(Function1 function) {
            Intrinsics.g(function, "function");
            this.f56026a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f56026a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.lifecycle.d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f56026a.invoke(obj);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocalVideoMiddleHeaderView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocalVideoMiddleHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalVideoMiddleHeaderView(Context context, AttributeSet attributeSet, int i11) {
        JsonElement jsonElement;
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f56013b = (com.blankj.utilcode.util.d0.e() / 2) - com.blankj.utilcode.util.f0.a(80.0f);
        this.f56014c = LazyKt__LazyJVMKt.b(new Function0<LocalVideoDetailViewModel>() { // from class: com.transsion.postdetail.ui.view.LocalVideoMiddleHeaderView$viewModel$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final LocalVideoDetailViewModel invoke() {
                Context context2 = this.this$0.getContext();
                Intrinsics.e(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                return (LocalVideoDetailViewModel) new v0((FragmentActivity) context2, new v0.d()).a(LocalVideoDetailViewModel.class);
            }
        });
        int asInt = 15;
        this.f56019i = 15;
        this.f56020j = LazyKt__LazyJVMKt.b(new Function0<Handler>() { // from class: com.transsion.postdetail.ui.view.LocalVideoMiddleHeaderView$mHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        View.inflate(getContext(), R$layout.layout_local_video_middle_header, this);
        tv.z zVarA = tv.z.a(this);
        Intrinsics.f(zVarA, "bind(this)");
        this.f56012a = zVarA;
        JsonObject jsonObjectB = wq.d.f79584a.b("MediaPlayerMidDescScene");
        if (jsonObjectB != null && (jsonElement = jsonObjectB.get("refreshTime")) != null) {
            asInt = jsonElement.getAsInt();
        }
        this.f56019i = asInt;
        ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).w(this);
        this.f56022l = 128;
        this.f56023m = 2;
        this.f56024n = 1;
    }

    private final void g() {
        this.f56012a.f78046k.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LocalVideoMiddleHeaderView.h(this.f56142a, view);
            }
        });
        this.f56012a.f78042g.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LocalVideoMiddleHeaderView.i(this.f56144a, view);
            }
        });
        this.f56012a.f78043h.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.l
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LocalVideoMiddleHeaderView.j(this.f56146a, view);
            }
        });
        this.f56012a.f78038b.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LocalVideoMiddleHeaderView.k(this.f56147a, view);
            }
        });
    }

    private final String getClassTag() {
        return LocalVideoMiddleHeaderView.class.getSimpleName();
    }

    private final Handler getMHandler() {
        return (Handler) this.f56020j.getValue();
    }

    private final LocalVideoDetailViewModel getViewModel() {
        return (LocalVideoDetailViewModel) this.f56014c.getValue();
    }

    public static final void h(LocalVideoMiddleHeaderView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Function0<Unit> function0 = this$0.f56017g;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public static final void i(LocalVideoMiddleHeaderView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/movie/detail");
        DownloadBean downloadBean = this$0.f56018h;
        Postcard postcardWithInt = postcardB.withInt("subject_type", downloadBean != null ? downloadBean.getSubjectType() : SubjectType.MOVIE.getValue());
        DownloadBean downloadBean2 = this$0.f56018h;
        postcardWithInt.withString("id", downloadBean2 != null ? downloadBean2.getSubjectId() : null).withBoolean("autoPlay", true).navigation();
    }

    public static final void j(LocalVideoMiddleHeaderView this$0, View view) {
        String sourceUrl;
        Intrinsics.g(this$0, "this$0");
        DownloadBean downloadBean = this$0.f56018h;
        if (downloadBean != null) {
            DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
            Context context = this$0.getContext();
            Intrinsics.e(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
            FragmentActivity fragmentActivity = (FragmentActivity) context;
            Subject subjectF = this$0.getViewModel().f().f();
            Subject subjectA = subjectF == null ? gv.a.a(downloadBean) : subjectF;
            DownloadBean downloadBean2 = this$0.f56018h;
            String ops = downloadBean2 != null ? downloadBean2.getOps() : null;
            DownloadBean downloadBean3 = this$0.f56018h;
            if (downloadBean3 == null || (sourceUrl = downloadBean3.getSourceUrl()) == null) {
                sourceUrl = "";
            }
            String str = sourceUrl;
            DownloadBean downloadBeanF = this$0.getViewModel().d().f();
            DownloadManagerApi.S1(downloadManagerApiA, fragmentActivity, subjectA, "local_video_detail_middle", null, ops, str, null, null, null, false, downloadBeanF != null ? downloadBeanF.getSe() : 0, false, 968, null);
        }
    }

    public static final void k(LocalVideoMiddleHeaderView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        Postcard postcardWithString = com.alibaba.android.arouter.launcher.a.d().b("/profile/user_center_labels_feedback").withString("feedback_from_page", "SUBJECT_PLAY");
        DownloadBean downloadBean = this$0.f56018h;
        postcardWithString.withString("subject_id", downloadBean != null ? downloadBean.getSubjectId() : null).navigation();
    }

    public static final void m(LocalVideoMiddleHeaderView this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS) || adapter.D().isEmpty()) {
            return;
        }
        Object obj = adapter.D().get(i11);
        Intrinsics.e(obj, "null cannot be cast to non-null type com.transsion.baselib.db.download.DownloadBean");
        this$0.p((DownloadBean) obj, i11);
    }

    private final void n() {
        String cover;
        String thumbnail;
        setPadding(0, 0, 0, gs.a.a(16));
        DownloadBean downloadBean = this.f56018h;
        if (downloadBean == null || !downloadBean.isInnerSubjectRes()) {
            BLLinearLayout bLLinearLayout = this.f56012a.f78042g;
            Intrinsics.f(bLLinearLayout, "viewBinding.llDetail");
            so.c.g(bLLinearLayout);
            BLLinearLayout bLLinearLayout2 = this.f56012a.f78043h;
            Intrinsics.f(bLLinearLayout2, "viewBinding.llDownload");
            so.c.g(bLLinearLayout2);
        } else {
            DownloadBean downloadBean2 = this.f56018h;
            if (downloadBean2 != null && (cover = downloadBean2.getCover()) != null && !Intrinsics.b(this.f56012a.f78041f.getTag(), cover)) {
                this.f56012a.f78041f.setTag(cover);
                ImageHelper.Companion companion = ImageHelper.f51371a;
                Context context = getContext();
                Intrinsics.f(context, "context");
                ShapeableImageView shapeableImageView = this.f56012a.f78041f;
                Intrinsics.f(shapeableImageView, "viewBinding.ivCover");
                DownloadBean downloadBean3 = this.f56018h;
                if (downloadBean3 == null || (thumbnail = downloadBean3.getThumbnail()) == null) {
                    thumbnail = "";
                }
                companion.q(context, shapeableImageView, cover, (8120 & 8) != 0 ? companion.d() : 0, (8120 & 16) != 0 ? companion.c() : 0, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
            }
        }
        DownloadBean downloadBean4 = this.f56018h;
        if (downloadBean4 == null || !downloadBean4.isSeries()) {
            AppCompatTextView appCompatTextView = this.f56012a.f78045j;
            Intrinsics.f(appCompatTextView, "viewBinding.tvEpTitle");
            so.c.g(appCompatTextView);
            RecyclerView recyclerView = this.f56012a.f78044i;
            Intrinsics.f(recyclerView, "viewBinding.recyclerViewEp");
            so.c.g(recyclerView);
            AppCompatTextView appCompatTextView2 = this.f56012a.f78040d;
            Intrinsics.f(appCompatTextView2, "viewBinding.innerTvName");
            so.c.g(appCompatTextView2);
            AppCompatTextView appCompatTextView3 = this.f56012a.f78039c;
            Intrinsics.f(appCompatTextView3, "viewBinding.innerTvInfo");
            so.c.g(appCompatTextView3);
            AppCompatImageView appCompatImageView = this.f56012a.f78038b;
            Intrinsics.f(appCompatImageView, "viewBinding.innerIcon");
            so.c.g(appCompatImageView);
        }
        l();
    }

    private final void o() {
        androidx.lifecycle.c0<List<DownloadBean>> c0VarH = getViewModel().h();
        Context context = getContext();
        Intrinsics.e(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        c0VarH.j((FragmentActivity) context, new c(new Function1<List<? extends DownloadBean>, Unit>() { // from class: com.transsion.postdetail.ui.view.LocalVideoMiddleHeaderView$initViewModel$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends DownloadBean> list) {
                invoke2(list);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends DownloadBean> list) {
                this.this$0.s(list);
                List<? extends DownloadBean> list2 = list;
                if (list2 == null || list2.isEmpty()) {
                    AppCompatTextView appCompatTextView = this.this$0.f56012a.f78045j;
                    Intrinsics.f(appCompatTextView, "viewBinding.tvEpTitle");
                    so.c.g(appCompatTextView);
                    RecyclerView recyclerView = this.this$0.f56012a.f78044i;
                    Intrinsics.f(recyclerView, "viewBinding.recyclerViewEp");
                    so.c.g(recyclerView);
                    AppCompatTextView appCompatTextView2 = this.this$0.f56012a.f78040d;
                    Intrinsics.f(appCompatTextView2, "viewBinding.innerTvName");
                    so.c.g(appCompatTextView2);
                    AppCompatTextView appCompatTextView3 = this.this$0.f56012a.f78039c;
                    Intrinsics.f(appCompatTextView3, "viewBinding.innerTvInfo");
                    so.c.g(appCompatTextView3);
                    AppCompatImageView appCompatImageView = this.this$0.f56012a.f78038b;
                    Intrinsics.f(appCompatImageView, "viewBinding.innerIcon");
                    so.c.g(appCompatImageView);
                    return;
                }
                DownloadBean downloadBean = this.this$0.f56018h;
                String uploadBy = downloadBean != null ? downloadBean.getUploadBy() : null;
                if (uploadBy == null || uploadBy.length() == 0) {
                    AppCompatTextView appCompatTextView4 = this.this$0.f56012a.f78040d;
                    Intrinsics.f(appCompatTextView4, "viewBinding.innerTvName");
                    so.c.g(appCompatTextView4);
                    AppCompatTextView appCompatTextView5 = this.this$0.f56012a.f78039c;
                    Intrinsics.f(appCompatTextView5, "viewBinding.innerTvInfo");
                    so.c.g(appCompatTextView5);
                } else {
                    AppCompatTextView appCompatTextView6 = this.this$0.f56012a.f78040d;
                    Intrinsics.f(appCompatTextView6, "viewBinding.innerTvName");
                    so.c.k(appCompatTextView6);
                    AppCompatTextView appCompatTextView7 = this.this$0.f56012a.f78039c;
                    Intrinsics.f(appCompatTextView7, "viewBinding.innerTvInfo");
                    so.c.k(appCompatTextView7);
                    AppCompatTextView appCompatTextView8 = this.this$0.f56012a.f78040d;
                    DownloadBean downloadBean2 = this.this$0.f56018h;
                    appCompatTextView8.setText(downloadBean2 != null ? downloadBean2.getUploadBy() : null);
                }
                AppCompatImageView appCompatImageView2 = this.this$0.f56012a.f78038b;
                Intrinsics.f(appCompatImageView2, "viewBinding.innerIcon");
                so.c.k(appCompatImageView2);
                AppCompatTextView appCompatTextView9 = this.this$0.f56012a.f78045j;
                Intrinsics.f(appCompatTextView9, "viewBinding.tvEpTitle");
                so.c.k(appCompatTextView9);
                RecyclerView recyclerView2 = this.this$0.f56012a.f78044i;
                Intrinsics.f(recyclerView2, "viewBinding.recyclerViewEp");
                so.c.k(recyclerView2);
                if (list.size() > 3) {
                    BLTextView bLTextView = this.this$0.f56012a.f78046k;
                    Intrinsics.f(bLTextView, "viewBinding.tvMore");
                    so.c.k(bLTextView);
                }
            }
        }));
        androidx.lifecycle.c0<DownloadBean> c0VarE = getViewModel().e();
        Context context2 = getContext();
        Intrinsics.e(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        c0VarE.j((FragmentActivity) context2, new c(new Function1<DownloadBean, Unit>() { // from class: com.transsion.postdetail.ui.view.LocalVideoMiddleHeaderView$initViewModel$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DownloadBean downloadBean) {
                invoke2(downloadBean);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DownloadBean downloadBean) {
                com.transsion.postdetail.ui.adapter.a aVar;
                List<DownloadBean> listD;
                List<DownloadBean> listD2;
                int size = 0;
                if (downloadBean != null) {
                    downloadBean.setPlaying(false);
                }
                com.transsion.postdetail.ui.adapter.a aVar2 = this.this$0.f56015d;
                int i11 = -1;
                if (aVar2 != null && (listD2 = aVar2.D()) != null) {
                    Iterator<DownloadBean> it = listD2.iterator();
                    int i12 = 0;
                    while (it.hasNext()) {
                        if (Intrinsics.b(it.next().getResourceId(), downloadBean != null ? downloadBean.getResourceId() : null)) {
                            i11 = i12;
                            break;
                        }
                        i12++;
                    }
                }
                if (i11 >= 0) {
                    com.transsion.postdetail.ui.adapter.a aVar3 = this.this$0.f56015d;
                    if (aVar3 != null && (listD = aVar3.D()) != null) {
                        size = listD.size();
                    }
                    if (i11 >= size || (aVar = this.this$0.f56015d) == null) {
                        return;
                    }
                    aVar.notifyItemChanged(i11, Boolean.FALSE);
                }
            }
        }));
        androidx.lifecycle.c0<DownloadBean> c0VarD = getViewModel().d();
        Context context3 = getContext();
        Intrinsics.e(context3, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        c0VarD.j((FragmentActivity) context3, new c(new Function1<DownloadBean, Unit>() { // from class: com.transsion.postdetail.ui.view.LocalVideoMiddleHeaderView$initViewModel$3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DownloadBean downloadBean) {
                invoke2(downloadBean);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DownloadBean bean) {
                com.transsion.postdetail.ui.adapter.a aVar;
                List<DownloadBean> listD;
                List<DownloadBean> listD2;
                if (bean != null) {
                    bean.setPlaying(true);
                }
                com.transsion.postdetail.ui.adapter.a aVar2 = this.this$0.f56015d;
                int i11 = -1;
                int size = 0;
                if (aVar2 != null && (listD2 = aVar2.D()) != null) {
                    Iterator<DownloadBean> it = listD2.iterator();
                    int i12 = 0;
                    while (it.hasNext()) {
                        if (Intrinsics.b(it.next().getResourceId(), bean != null ? bean.getResourceId() : null)) {
                            i11 = i12;
                            break;
                        }
                        i12++;
                    }
                }
                if (i11 >= 0) {
                    com.transsion.postdetail.ui.adapter.a aVar3 = this.this$0.f56015d;
                    if (aVar3 != null && (listD = aVar3.D()) != null) {
                        size = listD.size();
                    }
                    if (i11 < size && (aVar = this.this$0.f56015d) != null) {
                        aVar.notifyItemChanged(i11, Boolean.TRUE);
                    }
                }
                LocalVideoMiddleHeaderView localVideoMiddleHeaderView = this.this$0;
                Intrinsics.f(bean, "bean");
                localVideoMiddleHeaderView.q(bean);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q(DownloadBean downloadBean) {
        List<DownloadBean> listD;
        List<DownloadBean> listD2;
        com.transsion.postdetail.ui.adapter.a aVar = this.f56015d;
        int i11 = -1;
        int size = 0;
        if (aVar != null && (listD2 = aVar.D()) != null) {
            Iterator<DownloadBean> it = listD2.iterator();
            int i12 = 0;
            while (it.hasNext()) {
                if (Intrinsics.b(it.next().getResourceId(), downloadBean.getResourceId())) {
                    i11 = i12;
                    break;
                }
                i12++;
            }
        }
        if (i11 > 0) {
            com.transsion.postdetail.ui.adapter.a aVar2 = this.f56015d;
            if (aVar2 != null && (listD = aVar2.D()) != null) {
                size = listD.size();
            }
            if (i11 < size) {
                r(i11);
            }
        }
    }

    private final void r(int i11) {
        if (i11 < 0) {
            return;
        }
        try {
            this.f56012a.f78044i.scrollToPosition(i11);
            RecyclerView.m layoutManager = this.f56012a.f78044i.getLayoutManager();
            if (layoutManager instanceof LinearLayoutManager) {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                int i12 = this.f56013b;
                if (i12 <= 0) {
                    i12 = 0;
                }
                linearLayoutManager.scrollToPositionWithOffset(i11, i12);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(List<? extends DownloadBean> list) {
        com.transsion.postdetail.ui.adapter.a aVar = this.f56015d;
        if (aVar != null) {
            aVar.w0(list);
        }
        DownloadBean downloadBean = this.f56018h;
        if (downloadBean != null) {
            q(downloadBean);
        }
    }

    public final void destroy() {
        getMHandler().removeCallbacksAndMessages(null);
        NativeSlideshowView nativeSlideshowView = this.f56021k;
        if (nativeSlideshowView != null) {
            nativeSlideshowView.destroy();
        }
        ((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).V0(this);
    }

    public final int getDefault() {
        return this.f56024n;
    }

    public final DownloadBean getDownloadBean(String resourceId) {
        List<DownloadBean> listD;
        Intrinsics.g(resourceId, "resourceId");
        com.transsion.postdetail.ui.adapter.a aVar = this.f56015d;
        Object obj = null;
        if (aVar == null || (listD = aVar.D()) == null) {
            return null;
        }
        for (Object obj2 : listD) {
            if (Intrinsics.b(((DownloadBean) obj2).getResourceId(), resourceId)) {
                obj = obj2;
                break;
            }
        }
        return (DownloadBean) obj;
    }

    public final int getMaxStep() {
        return this.f56022l;
    }

    public final int getStep() {
        return this.f56023m;
    }

    public final void init(DownloadBean downloadBean, NativeSlideshowView nativeSlideshowView) {
        this.f56021k = nativeSlideshowView;
        this.f56018h = downloadBean;
        if (nativeSlideshowView != null) {
            nativeSlideshowView.setSceneId("MediaPlayerMidDescScene");
        }
        if (nativeSlideshowView != null) {
            com.transsion.ad.strategy.b bVar = com.transsion.ad.strategy.b.f50584a;
            DownloadBean downloadBean2 = this.f56018h;
            nativeSlideshowView.setCtxMap(bVar.a(downloadBean2 != null ? downloadBean2.getGenre() : null));
        }
        if (nativeSlideshowView != null) {
            nativeSlideshowView.initAd();
        }
        n();
        o();
        g();
    }

    public final void l() {
        com.transsion.postdetail.ui.adapter.a aVar = new com.transsion.postdetail.ui.adapter.a(new ArrayList(), false, 2, null);
        aVar.B0(new f9.d() { // from class: com.transsion.postdetail.ui.view.i
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                LocalVideoMiddleHeaderView.m(this.f56140a, baseQuickAdapter, view, i11);
            }
        });
        aVar.o0(new a());
        this.f56015d = aVar;
        RecyclerView recyclerView = this.f56012a.f78044i;
        int iA = gs.a.a(4);
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(recyclerView.getContext(), 0, false));
        recyclerView.setAdapter(this.f56015d);
        recyclerView.addItemDecoration(new b(iA));
    }

    @Override // su.e
    public void onMemberStateChange() {
        NativeSlideshowView nativeSlideshowView;
        if (!((IMemberApi) com.alibaba.android.arouter.launcher.a.d().h(IMemberApi.class)).m() || (nativeSlideshowView = this.f56021k) == null) {
            return;
        }
        nativeSlideshowView.setVisibility(8);
    }

    public final void p(DownloadBean downloadBean, int i11) {
        Function1<? super DownloadBean, Unit> function1 = this.f56016f;
        if (function1 != null) {
            function1.invoke(downloadBean);
        }
    }

    public final void setAllListClickCallback(Function0<Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f56017g = callback;
    }

    public final void setItemClickCallback(Function1<? super DownloadBean, Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f56016f = callback;
    }

    public final void updateDownloadBean(DownloadBean downloadBean) {
        this.f56018h = downloadBean;
    }
}
