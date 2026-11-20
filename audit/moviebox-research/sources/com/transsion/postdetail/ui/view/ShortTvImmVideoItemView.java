package com.transsion.postdetail.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import com.applovin.sdk.AppLovinEventTypes;
import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLTextView;
import com.tn.lib.pager.PagerLayoutManager;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Trailer;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.moviedetailapi.helper.ListVideoPreloadHelper;
import com.transsion.player.MediaSource;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.global.TnPlayerType;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.helper.ShortTvImmVideoHelper;
import com.transsion.postdetail.shorttv.ShortTvListActivity;
import com.transsion.postdetail.shorttv.ShortTvPlayListViewModel;
import com.transsion.postdetail.shorttv.config.Constants;
import com.transsion.postdetail.viewmodel.ShortTvDetailViewModel;
import com.transsion.share.bean.PostType;
import com.transsion.share.share.ShareDialogFragment;
import com.transsion.usercenterapi.ReportType;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.downloader.R$string;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.loginapi.ILoginApi;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
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
@SourceDebugExtension
public final class ShortTvImmVideoItemView extends ConstraintLayout implements com.transsion.player.orplayer.e, View.OnClickListener, androidx.lifecycle.r {
    public final int A;
    public final int B;
    public String C;
    public final AtomicBoolean D;
    public long E;
    public boolean F;
    public boolean G;
    public final b H;
    public boolean I;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f56080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final tv.i0 f56081b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ShortTvDetailViewModel f56082c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ShortTvPlayListViewModel f56083d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ShareDialogFragment f56084f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Subject f56085g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Fragment f56086h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Boolean f56087i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f56088j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f56089k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.transsion.player.orplayer.f f56090l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ORPlayerView f56091m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public PagerLayoutManager f56092n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ImmVideoGuideView f56093o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public GestureDetector f56094p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f56095q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public com.transsion.postdetail.layer.b f56096r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f56097s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f56098t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f56099u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public long f56100v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f56101w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f56102x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f56103y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f56104z;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f56105a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f56105a = iArr;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements androidx.lifecycle.d0<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f56106a;

        public b() {
        }

        @Override // androidx.lifecycle.d0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(String str) {
            if (Intrinsics.b(this.f56106a, str)) {
                return;
            }
            ShortTvImmVideoItemView.this.f(str);
        }

        public final void b(String str) {
            this.f56106a = str;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends GestureDetector.SimpleOnGestureListener {
        public c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent e11) {
            Intrinsics.g(e11, "e");
            return super.onDoubleTap(e11);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent e11) {
            Intrinsics.g(e11, "e");
            ShortTvImmVideoItemView.this.o();
            return super.onSingleTapUp(e11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements is.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f56109a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f56110b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f56111c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f56112d = "";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f56113e = com.blankj.utilcode.util.f0.a(1.5f);

        public d() {
        }

        @Override // is.c.a
        public void a() {
        }

        @Override // is.c.a
        public void b(float f11, float f12) {
            int i11 = 0;
            if (!ShortTvImmVideoItemView.this.f56098t) {
                PagerLayoutManager pagerLayoutManager = ShortTvImmVideoItemView.this.f56092n;
                if (pagerLayoutManager != null) {
                    pagerLayoutManager.o(false);
                }
                this.f56109a = ShortTvImmVideoItemView.this.f56081b.f77780n.getProgress();
                ShortTvImmVideoItemView.this.setContentVisibility(false);
                AppCompatTextView appCompatTextView = ShortTvImmVideoItemView.this.f56081b.f77788v;
                Intrinsics.f(appCompatTextView, "viewBinding.tvProgressDes");
                so.c.k(appCompatTextView);
                AppCompatSeekBar appCompatSeekBar = ShortTvImmVideoItemView.this.f56081b.f77782p;
                Intrinsics.f(appCompatSeekBar, "viewBinding.seekBar");
                so.c.k(appCompatSeekBar);
                ProgressBar progressBar = ShortTvImmVideoItemView.this.f56081b.f77780n;
                Intrinsics.f(progressBar, "viewBinding.progressBar");
                so.c.g(progressBar);
                this.f56111c = ShortTvImmVideoItemView.this.f56081b.f77780n.getWidth();
                int max = ShortTvImmVideoItemView.this.f56081b.f77780n.getMax();
                this.f56110b = max;
                this.f56112d = com.transsion.postdetail.util.i.c(max);
            }
            ShortTvImmVideoItemView.this.f56098t = true;
            float f13 = f12 - f11;
            int i12 = this.f56110b;
            int i13 = (int) (this.f56109a + ((f13 * i12) / this.f56111c));
            if (i13 >= 0) {
                i11 = i13 > i12 ? i12 : i13;
            }
            ShortTvImmVideoItemView.this.f56081b.f77788v.setText(com.transsion.postdetail.util.i.c(i11) + " / " + this.f56112d);
            ShortTvImmVideoItemView.this.f56081b.f77780n.setProgress(i11);
            ShortTvImmVideoItemView.this.f56081b.f77782p.setProgress(i11);
        }

        @Override // is.c.a
        public void c(float f11, float f12) {
        }

        @Override // is.c.a
        public void d(float f11, float f12) {
        }

        @Override // is.c.a
        public void e() {
            com.transsion.player.orplayer.f fVar;
            PagerLayoutManager pagerLayoutManager = ShortTvImmVideoItemView.this.f56092n;
            if (pagerLayoutManager != null) {
                pagerLayoutManager.o(true);
            }
            if (ShortTvImmVideoItemView.this.f56098t) {
                ShortTvImmVideoItemView.this.f56098t = false;
                ShortTvImmVideoItemView.this.setContentVisibility(true);
                AppCompatTextView appCompatTextView = ShortTvImmVideoItemView.this.f56081b.f77788v;
                Intrinsics.f(appCompatTextView, "viewBinding.tvProgressDes");
                so.c.g(appCompatTextView);
                AppCompatSeekBar appCompatSeekBar = ShortTvImmVideoItemView.this.f56081b.f77782p;
                Intrinsics.f(appCompatSeekBar, "viewBinding.seekBar");
                so.c.g(appCompatSeekBar);
                ProgressBar progressBar = ShortTvImmVideoItemView.this.f56081b.f77780n;
                Intrinsics.f(progressBar, "viewBinding.progressBar");
                so.c.k(progressBar);
                long progress = ShortTvImmVideoItemView.this.f56081b.f77780n.getProgress();
                ShortTvImmVideoItemView shortTvImmVideoItemView = ShortTvImmVideoItemView.this;
                if (shortTvImmVideoItemView.D.compareAndSet(true, false)) {
                    com.transsion.player.orplayer.f fVar2 = ShortTvImmVideoItemView.this.f56090l;
                    if (fVar2 != null) {
                        fVar2.seekTo(progress);
                    }
                    progress = 0;
                }
                shortTvImmVideoItemView.E = progress;
                com.transsion.player.orplayer.f fVar3 = ShortTvImmVideoItemView.this.f56090l;
                if (fVar3 == null || fVar3.isPlaying() || (fVar = ShortTvImmVideoItemView.this.f56090l) == null) {
                    return;
                }
                fVar.play();
            }
        }

        @Override // is.c.a
        public void onDoubleTap(MotionEvent e11) {
            Intrinsics.g(e11, "e");
        }

        @Override // is.c.a
        public void onLongPress(MotionEvent e11) {
            Intrinsics.g(e11, "e");
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e implements com.transsion.share.share.e {
        public e() {
        }

        @Override // com.transsion.share.share.e
        public void a(String id2, PostType postType) {
            Intrinsics.g(id2, "id");
        }

        @Override // com.transsion.share.share.e
        public void b(String str) {
            ShortTvImmVideoItemView.this.g(str);
        }

        @Override // com.transsion.share.share.e
        public void c(String url, String fileName, String fileSize, String fileImage) {
            Intrinsics.g(url, "url");
            Intrinsics.g(fileName, "fileName");
            Intrinsics.g(fileSize, "fileSize");
            Intrinsics.g(fileImage, "fileImage");
        }

        @Override // com.transsion.share.share.e
        public void d(String id2) {
            Intrinsics.g(id2, "id");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTvImmVideoItemView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTvImmVideoItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvImmVideoItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f56080a = "ImmVideoPlayer";
        this.f56095q = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.postdetail.ui.view.ShortTvImmVideoItemView$loginApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ILoginApi invoke() {
                return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
            }
        });
        this.A = com.blankj.utilcode.util.d0.c();
        this.B = com.blankj.utilcode.util.f0.a(170.0f);
        this.C = "";
        this.D = new AtomicBoolean(true);
        this.F = true;
        this.H = new b();
        View.inflate(getContext(), R$layout.layout_short_tv_immersion_video_item_view, this);
        tv.i0 i0VarA = tv.i0.a(this);
        Intrinsics.f(i0VarA, "bind(this)");
        this.f56081b = i0VarA;
        i0VarA.f77787u.setOnClickListener(this);
        i0VarA.f77776j.setOnClickListener(this);
        i0VarA.f77778l.setOnClickListener(this);
        i0VarA.f77789w.setOnClickListener(this);
        i0VarA.f77774h.setOnClickListener(this);
        i0VarA.f77777k.setOnClickListener(this);
        i0VarA.f77790x.setOnClickListener(this);
        i0VarA.f77785s.setOnClickListener(this);
        this.f56101w = com.blankj.utilcode.util.f0.a(48.0f);
        this.f56102x = com.blankj.utilcode.util.f0.a(64.0f);
        this.f56103y = com.blankj.utilcode.util.f0.a(24.0f);
        this.f56104z = com.blankj.utilcode.util.f0.a(32.0f);
        i(context);
        if (ShortTvImmVideoHelper.f55051k.a().k() > 0) {
            ViewGroup.LayoutParams layoutParams = i0VarA.f77781o.getLayoutParams();
            Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            if (((ViewGroup.MarginLayoutParams) bVar).bottomMargin < com.blankj.utilcode.util.f0.a(35.0f)) {
                ((ViewGroup.MarginLayoutParams) bVar).bottomMargin += com.blankj.utilcode.util.f0.a(10.0f);
                i0VarA.f77781o.setLayoutParams(bVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:22:0x0046  */
    public final void f(String str) {
        Integer numValueOf;
        if (str == null) {
            numValueOf = null;
        } else {
            int iHashCode = str.hashCode();
            if (iHashCode != -1550083459) {
                if (iHashCode != -877500447) {
                    if (iHashCode == 525878142 && str.equals("favorite_add")) {
                        numValueOf = Integer.valueOf(R$string.short_tv_favorite_toast);
                    } else {
                        numValueOf = null;
                    }
                } else if (str.equals("favorite_fail")) {
                    numValueOf = Integer.valueOf(com.tn.lib.widget.R$string.failed_toast);
                } else {
                    numValueOf = null;
                }
            } else if (str.equals("favorite_cancel")) {
                numValueOf = Integer.valueOf(R$string.short_tv_favorite_remove_toast);
            } else {
                numValueOf = null;
            }
        }
        if (numValueOf != null) {
            zp.b.f82110a.d(numValueOf.intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(String str) {
        uo.b.a.o(uo.b.f78622a, this.f56080a, new String[]{"finishAfterReport, position = " + this.f56088j}, false, 4, null);
        ShortTvDetailViewModel shortTvDetailViewModel = this.f56082c;
        androidx.lifecycle.c0<Integer> c0VarG = shortTvDetailViewModel != null ? shortTvDetailViewModel.g() : null;
        if (c0VarG == null) {
            return;
        }
        c0VarG.q(this.f56088j);
    }

    private final ILoginApi getLoginApi() {
        return (ILoginApi) this.f56095q.getValue();
    }

    private final void i(Context context) {
        this.f56094p = new GestureDetector(context, new c());
        j();
    }

    private final void j() {
        new is.c(getContext(), this.f56081b.f77792z).s(new d());
        this.f56081b.f77782p.setOnTouchListener(new View.OnTouchListener() { // from class: com.transsion.postdetail.ui.view.l0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ShortTvImmVideoItemView.k(view, motionEvent);
            }
        });
    }

    public static final boolean k(View view, MotionEvent motionEvent) {
        return true;
    }

    private final void l(long j11) {
        if (Intrinsics.b(this.f56087i, Boolean.TRUE)) {
            ShortTvImmVideoHelper.a aVar = ShortTvImmVideoHelper.f55051k;
            if (!aVar.a().p() || j11 < 1000) {
                return;
            }
            aVar.a().x();
            ImmVideoGuideView immVideoGuideViewA = ImmVideoGuideView.Companion.a(this);
            immVideoGuideViewA.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.view.m0
                @Override // java.lang.Runnable
                public final void run() {
                    ShortTvImmVideoItemView.m(this.f56148a);
                }
            }, 5000L);
            this.f56093o = immVideoGuideViewA;
        }
    }

    public static final void m(ShortTvImmVideoItemView this$0) {
        Intrinsics.g(this$0, "this$0");
        ImmVideoGuideView immVideoGuideView = this$0.f56093o;
        if (immVideoGuideView != null) {
            immVideoGuideView.removeGuide();
        }
    }

    private final void n(View view) {
        Fragment fragment;
        FragmentManager childFragmentManager;
        ShareDialogFragment shareDialogFragment;
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 500L)) {
            return;
        }
        if (this.f56084f == null) {
            ILoginApi loginApi = getLoginApi();
            if (loginApi != null) {
                loginApi.P();
            }
            ShareDialogFragment.a aVar = ShareDialogFragment.f57724t;
            PostType postType = PostType.SHORT_TV_TYPE;
            Subject subject = this.f56085g;
            String subjectId = subject != null ? subject.getSubjectId() : null;
            String value = ReportType.SUBJECT.getValue();
            Subject subject2 = this.f56085g;
            String title = subject2 != null ? subject2.getTitle() : null;
            Subject subject3 = this.f56085g;
            ShareDialogFragment shareDialogFragmentA = aVar.a(postType, subjectId, "", value, title, "", false, false, false, "postdetail", subject3 != null ? subject3.getOps() : null, view.getContext().getString(com.transsion.postdetail.R$string.save_video));
            this.f56084f = shareDialogFragmentA;
            if (shareDialogFragmentA != null) {
                shareDialogFragmentA.E0(new e());
            }
        }
        try {
            Fragment fragment2 = this.f56086h;
            if (fragment2 == null || !fragment2.isAdded() || (fragment = this.f56086h) == null || (childFragmentManager = fragment.getChildFragmentManager()) == null) {
                return;
            }
            childFragmentManager.executePendingTransactions();
            ShareDialogFragment shareDialogFragment2 = this.f56084f;
            if ((shareDialogFragment2 == null || !shareDialogFragment2.isAdded()) && childFragmentManager.findFragmentByTag(AppLovinEventTypes.USER_SHARED_LINK) == null && (shareDialogFragment = this.f56084f) != null) {
                shareDialogFragment.show(childFragmentManager, AppLovinEventTypes.USER_SHARED_LINK);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o() {
        ClipLoading clipLoading = this.f56081b.f77770c;
        Intrinsics.f(clipLoading, "viewBinding.clLoading");
        if (clipLoading.getVisibility() == 0) {
            return;
        }
        com.transsion.player.orplayer.f fVar = this.f56090l;
        if (fVar == null || !fVar.isPlaying()) {
            com.transsion.postdetail.layer.b bVar = this.f56096r;
            if (bVar != null) {
                bVar.c();
            }
            com.transsion.player.orplayer.f fVar2 = this.f56090l;
            if (fVar2 != null) {
                fVar2.play();
            }
            this.f56097s = false;
            return;
        }
        com.transsion.postdetail.layer.b bVar2 = this.f56096r;
        if (bVar2 != null) {
            bVar2.b();
        }
        com.transsion.player.orplayer.f fVar3 = this.f56090l;
        if (fVar3 != null) {
            fVar3.pause();
        }
        this.f56097s = true;
    }

    public static final void p(ShortTvImmVideoItemView this$0) {
        com.transsion.player.orplayer.f fVar;
        Intrinsics.g(this$0, "this$0");
        Fragment fragment = this$0.f56086h;
        if (fragment == null || !fragment.isVisible() || (fVar = this$0.f56090l) == null) {
            return;
        }
        fVar.play();
    }

    public static final ShortTvDetailViewModel q(Lazy<ShortTvDetailViewModel> lazy) {
        return lazy.getValue();
    }

    public static final ShortTvPlayListViewModel r(Lazy<ShortTvPlayListViewModel> lazy) {
        return lazy.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v27, types: [T, com.transsion.moviedetailapi.bean.ShortTVFavInfo] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private final void s() {
        Cover cover;
        String url;
        Fragment fragment;
        FragmentActivity activity;
        String thumbnail;
        Cover cover2;
        ShortTVItem shortTVFirstEp;
        Media video;
        Video videoAddress;
        ShapeableImageView shapeableImageView = this.f56081b.f77778l;
        Intrinsics.f(shapeableImageView, "viewBinding.ivVideoAvatar");
        so.c.g(shapeableImageView);
        AppCompatImageView appCompatImageView = this.f56081b.f77774h;
        Intrinsics.f(appCompatImageView, "viewBinding.ivDownload");
        so.c.k(appCompatImageView);
        AppCompatTextView appCompatTextView = this.f56081b.f77790x;
        Intrinsics.f(appCompatTextView, "viewBinding.tvTitle");
        so.c.k(appCompatTextView);
        BLTextView bLTextView = this.f56081b.f77789w;
        Intrinsics.f(bLTextView, "viewBinding.tvShortTvEp");
        so.c.k(bLTextView);
        ShapeableImageView shapeableImageView2 = this.f56081b.f77777k;
        Intrinsics.f(shapeableImageView2, "viewBinding.ivShortCover");
        so.c.k(shapeableImageView2);
        AppCompatTextView appCompatTextView2 = this.f56081b.f77790x;
        Subject subject = this.f56085g;
        appCompatTextView2.setText(subject != null ? subject.getTitle() : null);
        com.transsion.postdetail.util.k kVar = com.transsion.postdetail.util.k.f56221a;
        Subject subject2 = this.f56085g;
        String strA = kVar.a(Integer.valueOf(subject2 != null ? subject2.getTotalEpisode() : 0));
        AppCompatTextView appCompatTextView3 = this.f56081b.f77785s;
        Subject subject3 = this.f56085g;
        appCompatTextView3.setText(subject3 != null ? subject3.getDescription() : null);
        this.f56081b.f77789w.setText(getContext().getString(com.transsion.postdetail.R$string.short_tv_play_all, strA));
        com.transsion.baseui.widget.jumpingbeans.a.a(this.f56081b.f77789w).e(0, this.f56081b.f77789w.getText().toString().length()).g(true).i(100).f(0.05f).h(10000).a();
        ShapeableImageView shapeableImageView3 = this.f56081b.f77777k;
        Subject subject4 = this.f56085g;
        if (subject4 == null || !subject4.getBuiltIn()) {
            Subject subject5 = this.f56085g;
            if (subject5 != null && (cover = subject5.getCover()) != null && (url = cover.getUrl()) != null && (fragment = this.f56086h) != null && (activity = fragment.getActivity()) != null) {
                Intrinsics.f(activity, "fragment?.activity ?: return@let");
                if (!activity.isFinishing()) {
                    ImageHelper.Companion companion = ImageHelper.f51371a;
                    ShapeableImageView shapeableImageView4 = this.f56081b.f77777k;
                    Intrinsics.f(shapeableImageView4, "viewBinding.ivShortCover");
                    int iE = com.blankj.utilcode.util.i.e(21.0f);
                    int iE2 = com.blankj.utilcode.util.i.e(30.0f);
                    Subject subject6 = this.f56085g;
                    if (subject6 == null || (cover2 = subject6.getCover()) == null || (thumbnail = cover2.getThumbnail()) == null) {
                        thumbnail = "";
                    }
                    companion.q(activity, shapeableImageView4, url, (8120 & 8) != 0 ? companion.d() : iE, (8120 & 16) != 0 ? companion.c() : iE2, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : true, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
                }
            }
        } else {
            kotlinx.coroutines.j.d(kotlinx.coroutines.l0.a(w0.c()), null, null, new ShortTvImmVideoItemView$updateShortTVInfo$1(this, null), 3, null);
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Subject subject7 = this.f56085g;
        T shortTVFavInfo = subject7 != null ? subject7.getShortTVFavInfo() : 0;
        objectRef.element = shortTVFavInfo;
        if (shortTVFavInfo == 0) {
            ?? shortTVFavInfo2 = new ShortTVFavInfo(null, false, null, 7, null);
            shortTVFavInfo2.setFavoriteNum("0");
            objectRef.element = shortTVFavInfo2;
            Subject subject8 = this.f56085g;
            if (subject8 != 0) {
                subject8.setShortTVFavInfo(shortTVFavInfo2);
            }
        }
        AppCompatTextView appCompatTextView4 = this.f56081b.f77786t;
        Intrinsics.f(appCompatTextView4, "viewBinding.tvFavorite");
        so.c.k(appCompatTextView4);
        this.f56081b.f77786t.setSelected(((ShortTVFavInfo) objectRef.element).getHasFavorite());
        AppCompatTextView appCompatTextView5 = this.f56081b.f77786t;
        String favoriteNum = ((ShortTVFavInfo) objectRef.element).getFavoriteNum();
        appCompatTextView5.setText(com.transsion.baseui.util.j.a(Long.parseLong(favoriteNum != null ? favoriteNum : "0")));
        this.f56081b.f77786t.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.n0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortTvImmVideoItemView.t(this.f56150a, objectRef, view);
            }
        });
        Context context = getContext();
        Intrinsics.e(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Function1<j00.c, Unit> function1 = new Function1<j00.c, Unit>() { // from class: com.transsion.postdetail.ui.view.ShortTvImmVideoItemView$updateShortTVInfo$5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(j00.c cVar) {
                invoke2(cVar);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(j00.c value) {
                String favoriteNum2;
                ShortTVFavInfo shortTVFavInfo3;
                ShortTVFavInfo shortTVFavInfo4;
                Intrinsics.g(value, "value");
                try {
                    String strC = value.c();
                    Subject subject9 = this.this$0.f56085g;
                    if (Intrinsics.b(strC, subject9 != null ? subject9.getSubjectId() : null)) {
                        Subject subject10 = this.this$0.f56085g;
                        if (subject10 != null && (shortTVFavInfo4 = subject10.getShortTVFavInfo()) != null) {
                            shortTVFavInfo4.update(value);
                        }
                        AppCompatTextView appCompatTextView6 = this.this$0.f56081b.f77786t;
                        Subject subject11 = this.this$0.f56085g;
                        if (subject11 == null || (shortTVFavInfo3 = subject11.getShortTVFavInfo()) == null || (favoriteNum2 = shortTVFavInfo3.getFavoriteNum()) == null) {
                            favoriteNum2 = "0";
                        }
                        appCompatTextView6.setText(com.transsion.baseui.util.j.a(Long.parseLong(favoriteNum2)));
                        this.this$0.f56081b.f77786t.setSelected(value.a());
                    }
                } catch (Exception unused) {
                    uo.b.a.g(uo.b.f78622a, " callback change data fail", false, 2, null);
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = j00.c.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent((AppCompatActivity) context, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
        Subject subject9 = this.f56085g;
        if (subject9 == null || (shortTVFirstEp = subject9.getShortTVFirstEp()) == null || (video = shortTVFirstEp.getVideo()) == null || (videoAddress = video.getVideoAddress()) == null) {
            return;
        }
        v(this, videoAddress.getWidth(), videoAddress.getHeight(), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setContentVisibility(boolean z11) {
        Group group = this.f56081b.f77772f;
        Intrinsics.f(group, "viewBinding.groupContent");
        group.setVisibility(z11 ? 0 : 8);
    }

    private final void setLoading(boolean z11) {
        uo.b.a.j(uo.b.f78622a, "yy", "setLoading:" + z11 + "  " + this, false, 4, null);
        if (z11) {
            ClipLoading clipLoading = this.f56081b.f77770c;
            Intrinsics.f(clipLoading, "viewBinding.clLoading");
            so.c.k(clipLoading);
            ProgressBar progressBar = this.f56081b.f77780n;
            Intrinsics.f(progressBar, "viewBinding.progressBar");
            so.c.g(progressBar);
            this.f56081b.f77770c.start();
            return;
        }
        ProgressBar progressBar2 = this.f56081b.f77780n;
        Intrinsics.f(progressBar2, "viewBinding.progressBar");
        so.c.k(progressBar2);
        ClipLoading clipLoading2 = this.f56081b.f77770c;
        Intrinsics.f(clipLoading2, "viewBinding.clLoading");
        so.c.g(clipLoading2);
        this.f56081b.f77770c.stop();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void t(ShortTvImmVideoItemView this$0, Ref.ObjectRef favoriteInfo, View view) {
        ShortTvPlayListViewModel shortTvPlayListViewModel;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(favoriteInfo, "$favoriteInfo");
        com.transsion.postdetail.shorttv.o oVar = com.transsion.postdetail.shorttv.o.f55416a;
        Subject subject = this$0.f56085g;
        com.transsion.postdetail.shorttv.o.f(oVar, subject != null ? subject.getSubjectId() : null, "", ((ShortTVFavInfo) favoriteInfo.element).getHasFavorite(), "shorttv_detail_video", null, 16, null);
        Subject subject2 = this$0.f56085g;
        if (subject2 == null || (shortTvPlayListViewModel = this$0.f56083d) == null) {
            return;
        }
        shortTvPlayListViewModel.d(subject2);
    }

    public static /* synthetic */ void v(ShortTvImmVideoItemView shortTvImmVideoItemView, Integer num, Integer num2, Integer num3, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            ViewGroup viewGroup = (ViewGroup) shortTvImmVideoItemView.f56081b.getRoot().getParent();
            num3 = viewGroup != null ? Integer.valueOf(viewGroup.getHeight()) : null;
        }
        shortTvImmVideoItemView.u(num, num2, num3);
    }

    public final void addVideoView(View view, Video video, int i11) {
        if (view == null) {
            return;
        }
        this.f56081b.f77771d.addView(view, new FrameLayout.LayoutParams(-1, -1));
        if (video != null) {
            u(video.getWidth(), video.getHeight(), Integer.valueOf(i11));
        }
    }

    public final void app2Background() {
        com.transsion.postdetail.layer.b bVar = this.f56096r;
        if (bVar != null) {
            bVar.d(true);
        }
    }

    public final Integer getPosition() {
        return this.f56088j;
    }

    public final int h(Subject subject) {
        if (subject.getTrailer() != null) {
            return 0;
        }
        ShortTVItem shortTVFirstEp = subject.getShortTVFirstEp();
        if (shortTVFirstEp != null) {
            return shortTVFirstEp.getEp();
        }
        return 1;
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        com.transsion.player.orplayer.e.a.a(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onAliyunDecodeErrorChangeSoftwareDecoder(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.b(this, mediaSource);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        androidx.lifecycle.u viewLifecycleOwner;
        androidx.lifecycle.c0<String> c0VarF;
        androidx.lifecycle.c0<String> c0VarF2;
        super.onAttachedToWindow();
        Fragment fragment = this.f56086h;
        if (fragment == null || (viewLifecycleOwner = fragment.getViewLifecycleOwner()) == null) {
            return;
        }
        b bVar = this.H;
        ShortTvPlayListViewModel shortTvPlayListViewModel = this.f56083d;
        bVar.b((shortTvPlayListViewModel == null || (c0VarF2 = shortTvPlayListViewModel.f()) == null) ? null : c0VarF2.f());
        ShortTvPlayListViewModel shortTvPlayListViewModel2 = this.f56083d;
        if (shortTvPlayListViewModel2 == null || (c0VarF = shortTvPlayListViewModel2.f()) == null) {
            return;
        }
        c0VarF.j(viewLifecycleOwner, this.H);
    }

    @Override // com.transsion.player.orplayer.e
    public void onBufferedPosition(long j11, MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.c(this, j11, mediaSource);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Context context;
        Subject subject;
        Integer numValueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i11 = R$id.iv_share;
        if (numValueOf != null && numValueOf.intValue() == i11) {
            n(view);
            return;
        }
        int i12 = R$id.tv_short_tv_ep;
        if (numValueOf != null && numValueOf.intValue() == i12) {
            Fragment fragment = this.f56086h;
            if (fragment == null || (context = fragment.getContext()) == null || (subject = this.f56085g) == null) {
                return;
            }
            ShortTvListActivity.f55358h.a(context, subject, Integer.valueOf(h(subject)), this.f56081b.f77782p.getProgress(), true);
            return;
        }
        int i13 = R$id.iv_download;
        if (numValueOf == null || numValueOf.intValue() != i13) {
            int i14 = R$id.iv_short_cover;
            if (numValueOf == null || numValueOf.intValue() != i14) {
                int i15 = R$id.tv_title;
                if (numValueOf == null || numValueOf.intValue() != i15) {
                    int i16 = R$id.tv_desc;
                    if (numValueOf == null || numValueOf.intValue() != i16) {
                        return;
                    }
                }
            }
        }
        DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
        Context context2 = getContext();
        Intrinsics.e(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        FragmentActivity fragmentActivity = (FragmentActivity) context2;
        Subject subject2 = this.f56085g;
        downloadManagerApiA.a2(fragmentActivity, "shorttv_detail_video", (384 & 4) != 0 ? "" : "", subject2 != null ? subject2.getOps() : null, (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : view.getId() == R$id.iv_download, (384 & 64) != 0 ? null : this.f56085g, (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : Boolean.valueOf(view.getId() != R$id.iv_download));
    }

    @Override // com.transsion.player.orplayer.e
    public void onCompletion(MediaSource mediaSource) {
        Fragment fragment;
        Context context;
        Subject subject;
        uo.b.a.o(uo.b.f78622a, this.f56080a, new String[]{"player- onCompletion"}, false, 4, null);
        Subject subject2 = this.f56085g;
        if (subject2 != null) {
            Integer subjectType = subject2.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType == null || subjectType.intValue() != value || (fragment = this.f56086h) == null || (context = fragment.getContext()) == null || (subject = this.f56085g) == null || subject.getDeleted()) {
                return;
            }
            com.transsion.postdetail.layer.b bVar = this.f56096r;
            if (bVar != null) {
                bVar.d(false);
            }
            Trailer trailer = subject.getTrailer();
            if ((trailer != null ? trailer.getVideoAddress() : null) != null) {
                ShortTvListActivity.a.b(ShortTvListActivity.f55358h, context, subject, 1, 0L, false, 24, null);
            } else {
                ShortTVItem shortTVFirstEp = subject.getShortTVFirstEp();
                ShortTvListActivity.a.b(ShortTvListActivity.f55358h, context, subject, Integer.valueOf((shortTVFirstEp != null ? shortTVFirstEp.getEp() : 1) + 1), 0L, false, 24, null);
            }
            com.transsion.player.orplayer.f fVar = this.f56090l;
            if (fVar != null) {
                fVar.seekTo(0L);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        androidx.lifecycle.c0<String> c0VarF;
        super.onDetachedFromWindow();
        ShortTvPlayListViewModel shortTvPlayListViewModel = this.f56083d;
        androidx.lifecycle.c0<String> c0VarF2 = shortTvPlayListViewModel != null ? shortTvPlayListViewModel.f() : null;
        if (c0VarF2 != null) {
            c0VarF2.q(null);
        }
        ShortTvPlayListViewModel shortTvPlayListViewModel2 = this.f56083d;
        if (shortTvPlayListViewModel2 == null || (c0VarF = shortTvPlayListViewModel2.f()) == null) {
            return;
        }
        c0VarF.o(this.H);
    }

    @Override // com.transsion.player.orplayer.e
    public void onFocusChange(boolean z11) {
        com.transsion.player.orplayer.e.a.f(this, z11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onIsPlayingChanged(boolean z11) {
        com.transsion.player.orplayer.e.a.g(this, z11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingBegin(MediaSource mediaSource) {
        com.transsion.postdetail.layer.b bVar = this.f56096r;
        if (bVar != null) {
            bVar.h();
        }
        setLoading(true);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingEnd(MediaSource mediaSource) {
        com.transsion.postdetail.layer.b bVar = this.f56096r;
        if (bVar != null) {
            bVar.i();
        }
        setLoading(false);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingProgress(int i11, float f11, MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.l(this, i11, f11, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoopingStart() {
        com.transsion.postdetail.layer.b bVar = this.f56096r;
        if (bVar != null) {
            bVar.j();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onMediaItemTransition(String str) {
        Fragment fragment;
        Context context;
        Subject subject;
        com.transsion.player.orplayer.e.a.o(this, str);
        Subject subject2 = this.f56085g;
        if (subject2 != null) {
            Integer subjectType = subject2.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType == null || subjectType.intValue() != value || (fragment = this.f56086h) == null || (context = fragment.getContext()) == null || (subject = this.f56085g) == null) {
                return;
            }
            com.transsion.postdetail.layer.b bVar = this.f56096r;
            if (bVar != null) {
                bVar.d(false);
            }
            Trailer trailer = subject.getTrailer();
            if ((trailer != null ? trailer.getVideoAddress() : null) != null) {
                ShortTvListActivity.a.b(ShortTvListActivity.f55358h, context, subject, 1, 0L, false, 24, null);
            } else {
                ShortTVItem shortTVFirstEp = subject.getShortTVFirstEp();
                ShortTvListActivity.a.b(ShortTvListActivity.f55358h, context, subject, Integer.valueOf((shortTVFirstEp != null ? shortTVFirstEp.getEp() : 1) + 1), 0L, false, 24, null);
            }
            com.transsion.player.orplayer.f fVar = this.f56090l;
            if (fVar != null) {
                fVar.pause();
            }
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayError(PlayError errorInfo, MediaSource mediaSource) {
        Intrinsics.g(errorInfo, "errorInfo");
        this.D.set(true);
        this.E = 0L;
        com.transsion.postdetail.layer.b bVar = this.f56096r;
        if (bVar != null) {
            bVar.k(errorInfo);
        }
        uo.b.f78622a.h("i_media", this.f56080a + " --> IPlayerListener --> onPlayError()  errorCode:" + errorInfo.getErrorCode() + " errorMessage:" + errorInfo.getErrorMessage() + " url:" + (mediaSource != null ? mediaSource.j() : null) + " --> 短播放失败了", true);
    }

    public void onPlayErrorChangePayer(TnPlayerType tnPlayerType, MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.r(this, tnPlayerType, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerRelease(MediaSource mediaSource) {
        this.D.set(true);
        this.E = 0L;
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerReset() {
        String strA;
        com.transsion.player.orplayer.f fVar;
        ShortTVItem shortTVFirstEp;
        Media video;
        Video videoAddress;
        String url;
        uo.b.a.f(uo.b.f78622a, this.f56080a, "player- onPlayerReset", false, 4, null);
        this.I = false;
        this.G = true;
        this.D.set(true);
        this.E = 0L;
        setKeepScreenOn(false);
        this.f56097s = false;
        com.transsion.postdetail.layer.b bVar = this.f56096r;
        if (bVar != null) {
            com.transsion.postdetail.layer.b.e(bVar, false, 1, null);
        }
        Subject subject = this.f56085g;
        if (subject != null && (shortTVFirstEp = subject.getShortTVFirstEp()) != null && (video = shortTVFirstEp.getVideo()) != null && (videoAddress = video.getVideoAddress()) != null && (url = videoAddress.getUrl()) != null) {
            ShortTvImmVideoHelper.f55051k.a().m().put(url, Long.valueOf(this.f56081b.f77780n.getProgress()));
        }
        com.transsion.player.orplayer.f fVar2 = this.f56090l;
        if (fVar2 != null) {
            fVar2.removePlayerListener(this);
        }
        Subject subject2 = this.f56085g;
        if (subject2 != null && subject2.getDeleted() && (strA = com.transsion.postdetail.control.a.f55022p.a(subject2)) != null && (fVar = this.f56090l) != null) {
            ShortTVItem shortTVFirstEp2 = subject2.getShortTVFirstEp();
            fVar.removeDataSource(new MediaSource(shortTVFirstEp2 != null ? shortTVFirstEp2.getId() : null, strA, 0, null, null, 24, null));
        }
        AppCompatImageView appCompatImageView = this.f56081b.f77773g;
        Intrinsics.f(appCompatImageView, "viewBinding.ivCover");
        so.c.k(appCompatImageView);
        AppCompatImageView appCompatImageView2 = this.f56081b.f77775i;
        Intrinsics.f(appCompatImageView2, "viewBinding.ivPause");
        so.c.g(appCompatImageView2);
        AppCompatSeekBar appCompatSeekBar = this.f56081b.f77782p;
        Intrinsics.f(appCompatSeekBar, "viewBinding.seekBar");
        so.c.g(appCompatSeekBar);
        ImmVideoGuideView immVideoGuideView = this.f56093o;
        if (immVideoGuideView != null) {
            immVideoGuideView.removeGuide();
        }
        this.f56090l = null;
        this.f56091m = null;
        this.f56092n = null;
        this.f56100v = 0L;
    }

    @Override // com.transsion.player.orplayer.e
    public void onPrepare(MediaSource mediaSource) {
        Fragment fragment;
        ShortTVItem shortTVFirstEp;
        Media video;
        Video videoAddress;
        String url;
        if (this.I) {
            return;
        }
        this.I = true;
        com.transsion.player.orplayer.f fVar = this.f56090l;
        int duration = fVar != null ? (int) fVar.getDuration() : 0;
        uo.b.a aVar = uo.b.f78622a;
        uo.b.a.g(aVar, "shorttv.here.duration: " + duration, false, 2, null);
        this.f56081b.f77780n.setMax(duration);
        this.f56081b.f77782p.setMax(duration);
        Subject subject = this.f56085g;
        if (subject != null && (shortTVFirstEp = subject.getShortTVFirstEp()) != null && (video = shortTVFirstEp.getVideo()) != null && (videoAddress = video.getVideoAddress()) != null && (url = videoAddress.getUrl()) != null) {
            Long l11 = ShortTvImmVideoHelper.f55051k.a().m().get(url);
            long jLongValue = l11 != null ? l11.longValue() : 0L;
            uo.b.a.f(aVar, this.f56080a, "player- onPrepare, duration = " + this.f56081b.f77780n.getMax() + ", progress = " + jLongValue, false, 4, null);
            if (jLongValue >= 0) {
                this.f56100v = jLongValue;
                int i11 = (int) jLongValue;
                this.f56081b.f77780n.setProgress(i11);
                this.f56081b.f77782p.setProgress(i11);
                com.transsion.player.orplayer.f fVar2 = this.f56090l;
                if (fVar2 != null) {
                    fVar2.seekTo(jLongValue);
                }
            }
        }
        if (!this.f56097s && !this.f56099u && (fragment = this.f56086h) != null && fragment.isVisible()) {
            uo.b.a.f(aVar, this.f56080a, "player- onPrepare， play~", false, 4, null);
            com.transsion.player.orplayer.f fVar3 = this.f56090l;
            if (fVar3 != null) {
                fVar3.play();
            }
        }
        setKeepScreenOn(true);
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long j11, MediaSource mediaSource) {
        ShortTVItem shortTVFirstEp;
        if (this.D.get() && !this.f56098t) {
            if (Constants.f55400a.a() && mediaSource != null) {
                String strE = mediaSource.e();
                Subject subject = this.f56085g;
                if (!Intrinsics.b(strE, (subject == null || (shortTVFirstEp = subject.getShortTVFirstEp()) == null) ? null : shortTVFirstEp.getId())) {
                    uo.b.a.f(uo.b.f78622a, this.f56080a, "onProgress- vid 不同, return", false, 4, null);
                    return;
                }
            }
            com.transsion.postdetail.layer.b bVar = this.f56096r;
            if (bVar != null) {
                bVar.l(j11);
            }
            int i11 = (int) j11;
            this.f56081b.f77780n.setProgress(i11);
            this.f56081b.f77782p.setProgress(i11);
            l(j11);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        uo.b.a.f(uo.b.f78622a, this.f56080a, "player- onRenderFirstFrame", false, 4, null);
        AppCompatImageView appCompatImageView = this.f56081b.f77773g;
        Intrinsics.f(appCompatImageView, "viewBinding.ivCover");
        so.c.g(appCompatImageView);
        com.transsion.postdetail.layer.b bVar = this.f56096r;
        if (bVar != null) {
            bVar.m();
        }
        setLoading(false);
    }

    @Override // com.transsion.player.orplayer.e
    public void onSetDataSource() {
        this.G = false;
        this.D.set(true);
        this.E = 0L;
        setLoading(true);
    }

    @Override // androidx.lifecycle.r
    public void onStateChanged(androidx.lifecycle.u source, Lifecycle.Event event) {
        ShortTVItem shortTVFirstEp;
        Media video;
        Video videoAddress;
        String url;
        Lifecycle lifecycle;
        Intrinsics.g(source, "source");
        Intrinsics.g(event, "event");
        int i11 = a.f56105a[event.ordinal()];
        if (i11 == 1) {
            this.f56099u = true;
            uo.b.a.f(uo.b.f78622a, this.f56080a, "player- onPause", false, 4, null);
            com.transsion.player.orplayer.f fVar = this.f56090l;
            if (fVar != null) {
                fVar.pause();
                return;
            }
            return;
        }
        if (i11 == 2) {
            this.f56099u = false;
            if (this.f56097s) {
                return;
            }
            Fragment fragment = this.f56086h;
            if (fragment != null && !fragment.isVisible()) {
                post(new Runnable() { // from class: com.transsion.postdetail.ui.view.k0
                    @Override // java.lang.Runnable
                    public final void run() {
                        ShortTvImmVideoItemView.p(this.f56145a);
                    }
                });
                return;
            }
            com.transsion.player.orplayer.f fVar2 = this.f56090l;
            if (fVar2 != null) {
                fVar2.play();
                return;
            }
            return;
        }
        if (i11 == 3) {
            Subject subject = this.f56085g;
            if (subject == null || (shortTVFirstEp = subject.getShortTVFirstEp()) == null || (video = shortTVFirstEp.getVideo()) == null || (videoAddress = video.getVideoAddress()) == null || (url = videoAddress.getUrl()) == null) {
                return;
            }
            ShortTvImmVideoHelper.f55051k.a().m().put(url, Long.valueOf(this.f56081b.f77780n.getProgress()));
            return;
        }
        if (i11 != 5) {
            return;
        }
        Fragment fragment2 = this.f56086h;
        if (fragment2 != null && (lifecycle = fragment2.getLifecycle()) != null) {
            lifecycle.d(this);
        }
        com.transsion.postdetail.layer.b bVar = this.f56096r;
        if (bVar != null) {
            bVar.p();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.g(event, "event");
        GestureDetector gestureDetector = this.f56094p;
        if (gestureDetector == null || !gestureDetector.onTouchEvent(event)) {
            return super.onTouchEvent(event);
        }
        return true;
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksAudioBitrateChange(int i11) {
        com.transsion.player.orplayer.e.a.B(this, i11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksChange(ov.c cVar) {
        com.transsion.player.orplayer.e.a.C(this, cVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksVideoBitrateChange(int i11) {
        com.transsion.player.orplayer.e.a.D(this, i11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoPause(MediaSource mediaSource) {
        uo.b.a.f(uo.b.f78622a, this.f56080a, "player- onVideoPause", false, 4, null);
        AppCompatImageView appCompatImageView = this.f56081b.f77775i;
        Intrinsics.f(appCompatImageView, "viewBinding.ivPause");
        so.c.k(appCompatImageView);
        AppCompatSeekBar appCompatSeekBar = this.f56081b.f77782p;
        Intrinsics.f(appCompatSeekBar, "viewBinding.seekBar");
        so.c.k(appCompatSeekBar);
        ProgressBar progressBar = this.f56081b.f77780n;
        Intrinsics.f(progressBar, "viewBinding.progressBar");
        so.c.g(progressBar);
        com.transsion.postdetail.layer.b bVar = this.f56096r;
        if (bVar != null) {
            bVar.n();
        }
        setKeepScreenOn(false);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i11, int i12) {
        com.transsion.player.orplayer.e.a.G(this, i11, i12);
        v(this, Integer.valueOf(i11), Integer.valueOf(i12), null, 4, null);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(MediaSource mediaSource) {
        uo.b.a.f(uo.b.f78622a, this.f56080a, "player- onVideoStart", false, 4, null);
        com.transsion.postdetail.layer.b bVar = this.f56096r;
        if (bVar != null) {
            bVar.o();
        }
        AppCompatImageView appCompatImageView = this.f56081b.f77775i;
        Intrinsics.f(appCompatImageView, "viewBinding.ivPause");
        so.c.g(appCompatImageView);
        AppCompatSeekBar appCompatSeekBar = this.f56081b.f77782p;
        Intrinsics.f(appCompatSeekBar, "viewBinding.seekBar");
        so.c.g(appCompatSeekBar);
        setLoading(false);
        setKeepScreenOn(true);
    }

    public final void setData(Subject item, final Fragment fragment, Integer num, String str, String str2, boolean z11) {
        Intrinsics.g(item, "item");
        Intrinsics.g(fragment, "fragment");
        com.transsion.postdetail.layer.b bVar = new com.transsion.postdetail.layer.b();
        this.f56096r = bVar;
        bVar.s(str);
        com.transsion.postdetail.layer.b bVar2 = this.f56096r;
        if (bVar2 != null) {
            bVar2.r(str2);
        }
        com.transsion.postdetail.layer.b bVar3 = this.f56096r;
        if (bVar3 != null) {
            bVar3.y(SubjectType.SHORT_TV.getValue());
        }
        PostSubjectItem postSubjectItem = new PostSubjectItem(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, false, null, false, null, false, 1073741823, null);
        postSubjectItem.setSubject(item);
        postSubjectItem.setOps(item.getOps());
        postSubjectItem.setItemType("7");
        com.transsion.postdetail.layer.b bVar4 = this.f56096r;
        if (bVar4 != null) {
            bVar4.x("", postSubjectItem);
        }
        this.f56086h = fragment;
        this.f56087i = this.f56087i;
        this.f56089k = str;
        this.f56088j = num;
        this.F = z11;
        fragment.getLifecycle().a(this);
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.postdetail.ui.view.ShortTvImmVideoItemView$setData$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return fragment;
            }
        };
        this.f56082c = q(FragmentViewModelLazyKt.a(fragment, Reflection.b(ShortTvDetailViewModel.class), new Function0<x0>() { // from class: com.transsion.postdetail.ui.view.ShortTvImmVideoItemView$setData$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = ((y0) function0.invoke()).getViewModelStore();
                Intrinsics.f(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.ui.view.ShortTvImmVideoItemView$setData$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                Object objInvoke = function0.invoke();
                androidx.lifecycle.m mVar = objInvoke instanceof androidx.lifecycle.m ? (androidx.lifecycle.m) objInvoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = fragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.f(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        }));
        final Function0<Fragment> function1 = new Function0<Fragment>() { // from class: com.transsion.postdetail.ui.view.ShortTvImmVideoItemView$setData$$inlined$viewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return fragment;
            }
        };
        this.f56083d = r(FragmentViewModelLazyKt.a(fragment, Reflection.b(ShortTvPlayListViewModel.class), new Function0<x0>() { // from class: com.transsion.postdetail.ui.view.ShortTvImmVideoItemView$setData$$inlined$viewModels$default$5
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final x0 invoke() {
                x0 viewModelStore = ((y0) function1.invoke()).getViewModelStore();
                Intrinsics.f(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.ui.view.ShortTvImmVideoItemView$setData$$inlined$viewModels$default$6
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final v0.c invoke() {
                Object objInvoke = function1.invoke();
                androidx.lifecycle.m mVar = objInvoke instanceof androidx.lifecycle.m ? (androidx.lifecycle.m) objInvoke : null;
                v0.c defaultViewModelProviderFactory = mVar != null ? mVar.getDefaultViewModelProviderFactory() : null;
                if (defaultViewModelProviderFactory == null) {
                    defaultViewModelProviderFactory = fragment.getDefaultViewModelProviderFactory();
                }
                Intrinsics.f(defaultViewModelProviderFactory, "(ownerProducer() as? Has…tViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        }));
        this.f56085g = item;
        w(item);
        if (z11) {
            ViewGroup.LayoutParams layoutParams = this.f56081b.f77781o.getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.b) {
                ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) layoutParams)).bottomMargin = com.blankj.utilcode.util.f0.a(16.0f);
            }
        }
        s();
        this.f56081b.f77783q.setData(item.getShortTVFirstEp());
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        com.transsion.player.orplayer.e.a.J(this);
        this.D.set(true);
        long j11 = this.E;
        if (j11 > 0) {
            uo.b.a.o(uo.b.f78622a, this.f56080a, new String[]{"seek OnSeekComplete，nextSeekTo:" + j11}, false, 4, null);
            com.transsion.player.orplayer.f fVar = this.f56090l;
            if (fVar != null) {
                fVar.seekTo(this.E);
            }
            this.E = 0L;
        }
    }

    public final void setPagerLayoutManager(PagerLayoutManager pagerLayoutManager) {
        Intrinsics.g(pagerLayoutManager, "pagerLayoutManager");
        this.f56092n = pagerLayoutManager;
    }

    public final void setPlayer(com.transsion.player.orplayer.f orPlayer, ORPlayerView orPlayerView) {
        Intrinsics.g(orPlayer, "orPlayer");
        Intrinsics.g(orPlayerView, "orPlayerView");
        this.f56090l = orPlayer;
        this.f56091m = orPlayerView;
        com.transsion.postdetail.layer.b bVar = this.f56096r;
        if (bVar != null) {
            bVar.v(orPlayer);
        }
    }

    public final void setPosition(Integer num) {
        this.f56088j = num;
    }

    public final void setVideoUrl(String url) {
        Intrinsics.g(url, "url");
        com.transsion.postdetail.layer.b bVar = this.f56096r;
        if (bVar != null) {
            bVar.A(url);
        }
    }

    public final void u(Integer num, Integer num2, Integer num3) {
        int iE;
        if (num == null || num3 == null || num2 == null || num.intValue() == 0) {
            return;
        }
        FrameLayout frameLayout = this.f56081b.f77771d;
        Intrinsics.f(frameLayout, "viewBinding.flContainer");
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        int iIntValue = (num2.intValue() * com.blankj.utilcode.util.d0.e()) / num.intValue();
        if (kotlin.ranges.a.r(1, iIntValue).v(num3.intValue())) {
            iE = (num3.intValue() * num.intValue()) / num2.intValue();
            iIntValue = num3.intValue();
        } else {
            iE = com.blankj.utilcode.util.d0.e();
        }
        if (iE != ((ViewGroup.MarginLayoutParams) bVar).width || iIntValue != ((ViewGroup.MarginLayoutParams) bVar).height) {
            ((ViewGroup.MarginLayoutParams) bVar).width = iE;
            ((ViewGroup.MarginLayoutParams) bVar).height = iIntValue;
        }
        frameLayout.setLayoutParams(bVar);
    }

    public final void videoStartPrepare(String pageFrom) {
        Intrinsics.g(pageFrom, "pageFrom");
        this.C = pageFrom;
        com.transsion.postdetail.layer.b bVar = this.f56096r;
        if (bVar != null) {
            bVar.t(pageFrom);
        }
        com.transsion.postdetail.layer.b bVar2 = this.f56096r;
        if (bVar2 != null) {
            bVar2.g();
        }
        com.transsion.postdetail.layer.b bVar3 = this.f56096r;
        if (bVar3 != null) {
            bVar3.a(0, 0);
        }
        com.transsion.postdetail.layer.b bVar4 = this.f56096r;
        if (bVar4 != null) {
            bVar4.w(this.f56088j);
        }
    }

    public final void w(Subject subject) {
        Media video;
        Cover cover;
        String url;
        Fragment fragment;
        FragmentActivity activity;
        Media video2;
        Cover cover2;
        if (subject.getBuiltIn()) {
            String url2 = null;
            kotlinx.coroutines.j.d(kotlinx.coroutines.l0.a(w0.c()), null, null, new ShortTvImmVideoItemView$updateVideoInfo$1(subject, this, null), 3, null);
            uo.b.a aVar = uo.b.f78622a;
            String str = this.f56080a;
            ShortTVItem shortTVFirstEp = subject.getShortTVFirstEp();
            if (shortTVFirstEp != null && (video2 = shortTVFirstEp.getVideo()) != null && (cover2 = video2.getCover()) != null) {
                url2 = cover2.getUrl();
            }
            uo.b.a.f(aVar, str, "set info - cover = " + url2, false, 4, null);
            return;
        }
        ShortTVItem shortTVFirstEp2 = subject.getShortTVFirstEp();
        if (shortTVFirstEp2 == null || (video = shortTVFirstEp2.getVideo()) == null || (cover = video.getCover()) == null || (url = cover.getUrl()) == null || (fragment = this.f56086h) == null || (activity = fragment.getActivity()) == null) {
            return;
        }
        Intrinsics.f(activity, "fragment?.activity ?: return@let");
        if (activity.isFinishing()) {
            return;
        }
        ImageHelper.Companion companion = ImageHelper.f51371a;
        ListVideoPreloadHelper.a aVar2 = ListVideoPreloadHelper.f53890f;
        Glide.with(activity).load2(companion.e(url, (124 & 2) != 0 ? 0 : aVar2.a(), (124 & 4) != 0 ? 0 : aVar2.a(), (124 & 8) != 0, (124 & 16) != 0 ? false : false, (124 & 32) == 0 ? false : false, (124 & 64) != 0 ? 25 : 0)).into(this.f56081b.f77773g);
    }
}
