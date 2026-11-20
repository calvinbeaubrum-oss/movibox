package com.transsion.shorttv.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Insets;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Space;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.d0;
import androidx.lifecycle.r;
import androidx.lifecycle.u;
import androidx.lifecycle.v0;
import com.applovin.sdk.AppLovinEventTypes;
import com.blankj.utilcode.util.f0;
import com.blankj.utilcode.util.i;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.pager.PagerLayoutManager;
import com.tn.lib.view.expand.ExpandView;
import com.tn.lib.widget.TnTextView;
import com.transsion.baselib.db.video.ShortTVPlayBean;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.baseui.util.j;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.FirstFrame;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.moviedetailapi.helper.ListVideoPreloadHelper;
import com.transsion.player.MediaSource;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.global.TnPlayerType;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.share.bean.PostType;
import com.transsion.share.share.ShareDialogFragment;
import com.transsion.shorttv.R$id;
import com.transsion.shorttv.R$layout;
import com.transsion.shorttv.R$string;
import com.transsion.shorttv.ShortTvBaseListFragment;
import com.transsion.shorttv.ShortTvViewModel;
import com.transsion.shorttv.dot.VideoDotLayer;
import com.transsnet.downloader.DownloadManagerApi;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class ShortTvVideoItemView extends ConstraintLayout implements com.transsion.player.orplayer.e, View.OnClickListener, r, com.transsion.shorttv.a {
    public final d0<Boolean> A;
    public final b B;
    public boolean C;
    public boolean D;
    public final Runnable E;
    public boolean F;
    public final Handler G;
    public final Runnable H;
    public View I;
    public final rx.e J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f57898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final nx.c f57899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ShareDialogFragment f57900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public qx.d f57901d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Subject f57902f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ShortTvBaseListFragment f57903g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Boolean f57904h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Integer f57905i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f57906j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.transsion.player.orplayer.f f57907k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ORPlayerView f57908l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PagerLayoutManager f57909m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public GestureDetector f57910n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public VideoDotLayer f57911o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f57912p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f57913q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f57914r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public long f57915s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f57916t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f57917u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f57918v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f57919w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f57920x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public ShortTvViewModel f57921y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final d0<Boolean> f57922z;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f57923a;

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
            f57923a = iArr;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements d0<com.transsion.shorttv.favorite.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.transsion.shorttv.favorite.a f57924a;

        public b() {
        }

        @Override // androidx.lifecycle.d0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(com.transsion.shorttv.favorite.a aVar) {
            if (Intrinsics.b(this.f57924a, aVar)) {
                return;
            }
            ShortTvVideoItemView.this.i(aVar);
        }

        public final void b(com.transsion.shorttv.favorite.a aVar) {
            this.f57924a = aVar;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c extends GestureDetector.SimpleOnGestureListener {
        public c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent e11) {
            Intrinsics.g(e11, "e");
            ShortTvVideoItemView.this.p();
            return super.onSingleTapUp(e11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class d implements is.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f57927a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f57928b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f57929c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f57930d = "";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f57931e = f0.a(1.5f);

        public d() {
        }

        @Override // is.c.a
        public void a() {
        }

        @Override // is.c.a
        public void b(float f11, float f12) {
            int i11 = 0;
            if (!ShortTvVideoItemView.this.f57913q) {
                PagerLayoutManager pagerLayoutManager = ShortTvVideoItemView.this.f57909m;
                if (pagerLayoutManager != null) {
                    pagerLayoutManager.o(false);
                }
                this.f57927a = ShortTvVideoItemView.this.f57899b.f72191o.getProgress();
                AppCompatTextView appCompatTextView = ShortTvVideoItemView.this.f57899b.f72200x;
                Intrinsics.f(appCompatTextView, "viewBinding.tvProgressDes");
                so.c.k(appCompatTextView);
                AppCompatSeekBar appCompatSeekBar = ShortTvVideoItemView.this.f57899b.f72193q;
                Intrinsics.f(appCompatSeekBar, "viewBinding.seekBar");
                so.c.k(appCompatSeekBar);
                ProgressBar progressBar = ShortTvVideoItemView.this.f57899b.f72191o;
                Intrinsics.f(progressBar, "viewBinding.progressBar");
                so.c.g(progressBar);
                this.f57929c = ShortTvVideoItemView.this.f57899b.f72191o.getWidth();
                int max = ShortTvVideoItemView.this.f57899b.f72191o.getMax();
                this.f57928b = max;
                this.f57930d = com.transsion.shorttv.utils.c.a(max);
            }
            ShortTvVideoItemView.this.f57913q = true;
            float f13 = f12 - f11;
            int i12 = this.f57928b;
            int i13 = (int) (this.f57927a + ((f13 * i12) / this.f57929c));
            if (i13 >= 0) {
                i11 = i13 > i12 ? i12 : i13;
            }
            ShortTvVideoItemView.this.f57899b.f72200x.setText(com.transsion.shorttv.utils.c.a(i11) + " / " + this.f57930d);
            ShortTvVideoItemView.this.y((long) i11);
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
            PagerLayoutManager pagerLayoutManager = ShortTvVideoItemView.this.f57909m;
            if (pagerLayoutManager != null) {
                pagerLayoutManager.o(true);
            }
            if (ShortTvVideoItemView.this.f57913q) {
                ShortTvVideoItemView.this.f57913q = false;
                AppCompatTextView appCompatTextView = ShortTvVideoItemView.this.f57899b.f72200x;
                Intrinsics.f(appCompatTextView, "viewBinding.tvProgressDes");
                so.c.g(appCompatTextView);
                AppCompatSeekBar appCompatSeekBar = ShortTvVideoItemView.this.f57899b.f72193q;
                Intrinsics.f(appCompatSeekBar, "viewBinding.seekBar");
                so.c.g(appCompatSeekBar);
                ProgressBar progressBar = ShortTvVideoItemView.this.f57899b.f72191o;
                Intrinsics.f(progressBar, "viewBinding.progressBar");
                so.c.k(progressBar);
                long progress = ShortTvVideoItemView.this.f57899b.f72191o.getProgress();
                qx.d dVar = ShortTvVideoItemView.this.f57901d;
                if (dVar == null || !qx.f.a(dVar)) {
                    uo.b.a.f(uo.b.f78622a, ShortTvVideoItemView.this.f57898a, "数据还没有拉下来，不进行seek", false, 4, null);
                    return;
                }
                com.transsion.player.orplayer.f fVar2 = ShortTvVideoItemView.this.f57907k;
                if (fVar2 != null) {
                    fVar2.seekTo(progress);
                }
                com.transsion.player.orplayer.f fVar3 = ShortTvVideoItemView.this.f57907k;
                if (fVar3 == null || fVar3.isPlaying() || (fVar = ShortTvVideoItemView.this.f57907k) == null) {
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
        @Override // com.transsion.share.share.e
        public void a(String id2, PostType postType) {
            Intrinsics.g(id2, "id");
        }

        @Override // com.transsion.share.share.e
        public void b(String str) {
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

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f implements ExpandView.c {
        public f() {
        }

        @Override // com.tn.lib.view.expand.ExpandView.c
        public void a(ExpandView expandView) {
            ShortTvVideoItemView.this.g();
        }

        @Override // com.tn.lib.view.expand.ExpandView.c
        public void b(ExpandView expandView) {
            ShortTvVideoItemView.this.v();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class g implements rx.e {
        public g() {
        }

        @Override // rx.e
        public void a(rx.g result) {
            Intrinsics.g(result, "result");
            ShortTvViewModel shortTvViewModel = ShortTvVideoItemView.this.f57921y;
            if (shortTvViewModel != null) {
                shortTvViewModel.L(result);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class h implements RequestListener<Drawable> {
        public h() {
        }

        @Override // com.bumptech.glide.request.RequestListener
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z11) {
            uo.b.a.f(uo.b.f78622a, ShortTvVideoItemView.this.f57898a, "onResourceReady  " + ShortTvVideoItemView.this, false, 4, null);
            return false;
        }

        @Override // com.bumptech.glide.request.RequestListener
        public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z11) {
            uo.b.a.f(uo.b.f78622a, ShortTvVideoItemView.this.f57898a, "onLoadFailed  " + ShortTvVideoItemView.this, false, 4, null);
            return false;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTvVideoItemView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ShortTvVideoItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShortTvVideoItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f57898a = "ShowTv-Imm";
        this.f57920x = "";
        View.inflate(getContext(), R$layout.short_tv_layout_video_item_view, this);
        nx.c cVarA = nx.c.a(this);
        Intrinsics.f(cVarA, "bind(this)");
        this.f57899b = cVarA;
        cVarA.f72197u.setText("");
        cVarA.f72195s.setPadding(0, com.blankj.utilcode.util.d.c(), 0, 0);
        cVarA.f72183g.setOnClickListener(this);
        cVarA.f72198v.setOnClickListener(this);
        cVarA.f72197u.setOnClickListener(this);
        cVarA.f72188l.setOnClickListener(this);
        cVarA.f72187k.setOnClickListener(this);
        cVarA.f72185i.setOnClickListener(this);
        cVarA.f72189m.setOnClickListener(this);
        cVarA.f72199w.setOnClickListener(this);
        this.f57916t = f0.a(48.0f);
        this.f57917u = f0.a(64.0f);
        this.f57918v = f0.a(24.0f);
        this.f57919w = f0.a(32.0f);
        l(context);
        this.f57922z = new d0() { // from class: com.transsion.shorttv.widget.d
            @Override // androidx.lifecycle.d0
            public final void onChanged(Object obj) {
                ShortTvVideoItemView.o(this.f57953a, ((Boolean) obj).booleanValue());
            }
        };
        this.A = new d0() { // from class: com.transsion.shorttv.widget.e
            @Override // androidx.lifecycle.d0
            public final void onChanged(Object obj) {
                ShortTvVideoItemView.h(this.f57954a, (Boolean) obj);
            }
        };
        this.B = new b();
        this.E = new Runnable() { // from class: com.transsion.shorttv.widget.ShortTvVideoItemView$special$$inlined$Runnable$1
            @Override // java.lang.Runnable
            public final void run() {
                this.this$0.u();
            }
        };
        Looper looperMyLooper = Looper.myLooper();
        Intrinsics.d(looperMyLooper);
        this.G = new Handler(looperMyLooper);
        this.H = new Runnable() { // from class: com.transsion.shorttv.widget.ShortTvVideoItemView$special$$inlined$Runnable$2
            @Override // java.lang.Runnable
            public final void run() {
                this.this$0.j();
            }
        };
        this.J = new g();
    }

    public static final void h(ShortTvVideoItemView this$0, Boolean bool) {
        Intrinsics.g(this$0, "this$0");
        this$0.x();
    }

    private final void l(Context context) {
        this.f57910n = new GestureDetector(context, new c());
        m();
    }

    private final void m() {
        new is.c(getContext(), this.f57899b.A).s(new d());
        this.f57899b.f72193q.setOnTouchListener(new View.OnTouchListener() { // from class: com.transsion.shorttv.widget.f
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ShortTvVideoItemView.n(view, motionEvent);
            }
        });
    }

    public static final boolean n(View view, MotionEvent motionEvent) {
        return true;
    }

    public static final void o(ShortTvVideoItemView this$0, boolean z11) {
        Intrinsics.g(this$0, "this$0");
        if (z11) {
            Group group = this$0.f57899b.f72182f;
            Intrinsics.f(group, "viewBinding.groupContent");
            so.c.k(group);
            this$0.f57899b.f72194r.show();
            return;
        }
        Group group2 = this$0.f57899b.f72182f;
        Intrinsics.f(group2, "viewBinding.groupContent");
        so.c.h(group2);
        this$0.f57899b.f72194r.hide();
    }

    private final void q(View view) {
        ShortTvBaseListFragment shortTvBaseListFragment;
        FragmentManager childFragmentManager;
        ShareDialogFragment shareDialogFragment;
        px.a aVarC;
        String pageName;
        String strD;
        com.transsion.shorttv.dot.b bVar = com.transsion.shorttv.dot.b.f57848a;
        qx.d dVar = this.f57901d;
        ShareDialogFragment shareDialogFragmentB = null;
        shareDialogFragmentB = null;
        String strD2 = dVar != null ? dVar.d() : null;
        qx.d dVar2 = this.f57901d;
        com.transsion.shorttv.dot.b.e(bVar, strD2, dVar2 != null ? Integer.valueOf(dVar2.b()) : null, null, 4, null);
        if (this.f57900c == null) {
            ShortTvViewModel shortTvViewModel = this.f57921y;
            if (shortTvViewModel != null && (aVarC = shortTvViewModel.C()) != null) {
                qx.d dVar3 = this.f57901d;
                String str = (dVar3 == null || (strD = dVar3.d()) == null) ? "" : strD;
                Subject subject = this.f57902f;
                String title = subject != null ? subject.getTitle() : null;
                ShortTvBaseListFragment shortTvBaseListFragment2 = this.f57903g;
                shareDialogFragmentB = px.a.C0811a.b(aVarC, null, str, null, title, (shortTvBaseListFragment2 == null || (pageName = shortTvBaseListFragment2.getPageName()) == null) ? "" : pageName, 5, null);
            }
            this.f57900c = shareDialogFragmentB;
            if (shareDialogFragmentB != null) {
                shareDialogFragmentB.E0(new e());
            }
        }
        try {
            ShortTvBaseListFragment shortTvBaseListFragment3 = this.f57903g;
            if (shortTvBaseListFragment3 == null || !shortTvBaseListFragment3.isAdded() || (shortTvBaseListFragment = this.f57903g) == null || (childFragmentManager = shortTvBaseListFragment.getChildFragmentManager()) == null) {
                return;
            }
            childFragmentManager.executePendingTransactions();
            ShareDialogFragment shareDialogFragment2 = this.f57900c;
            if ((shareDialogFragment2 == null || !shareDialogFragment2.isAdded()) && childFragmentManager.findFragmentByTag(AppLovinEventTypes.USER_SHARED_LINK) == null && (shareDialogFragment = this.f57900c) != null) {
                shareDialogFragment.show(childFragmentManager, AppLovinEventTypes.USER_SHARED_LINK);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    private final void setLoading(boolean z11) {
        this.F = z11;
        if (z11) {
            ShortTvBaseListFragment shortTvBaseListFragment = this.f57903g;
            Intrinsics.e(shortTvBaseListFragment, "null cannot be cast to non-null type com.transsion.shorttv.ShortTvBaseListFragment");
            shortTvBaseListFragment.startLoading();
        } else {
            ShortTvBaseListFragment shortTvBaseListFragment2 = this.f57903g;
            Intrinsics.e(shortTvBaseListFragment2, "null cannot be cast to non-null type com.transsion.shorttv.ShortTvBaseListFragment");
            shortTvBaseListFragment2.hideLoading();
        }
    }

    public static final void t(ShortTvVideoItemView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        uo.b.a.f(uo.b.f78622a, this$0.f57898a, "打开短剧 Tab", false, 4, null);
        com.alibaba.android.arouter.launcher.a.d().b("/main/tab").withInt("tabIndex", 0).withString("topTab", "ShortTV_Discover").navigation();
    }

    public final void A(Integer num, Integer num2) {
        if (num == null || num2 == null || num.intValue() == 0) {
            return;
        }
        FrameLayout frameLayout = this.f57899b.f72181d;
        Intrinsics.f(frameLayout, "viewBinding.flContainer");
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        ((ViewGroup.MarginLayoutParams) bVar).width = com.blankj.utilcode.util.d0.e();
        ((ViewGroup.MarginLayoutParams) bVar).height = (num2.intValue() * ((ViewGroup.MarginLayoutParams) bVar).width) / num.intValue();
        frameLayout.setLayoutParams(bVar);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00e4  */
    public final void B(qx.d dVar) {
        Unit unit;
        ShortTVItem shortTVItemC;
        Media video;
        String str;
        FragmentActivity activity;
        y(0L);
        if (dVar != null) {
            int iB = dVar.b();
            if (iB == 0) {
                this.f57899b.f72201y.setText(getContext().getString(R$string.short_tv_trailer));
            } else {
                TnTextView tnTextView = this.f57899b.f72201y;
                StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
                String str2 = String.format("EP%s", Arrays.copyOf(new Object[]{com.transsion.shorttv.utils.b.a(Integer.valueOf(iB))}, 1));
                Intrinsics.f(str2, "format(...)");
                tnTextView.setText(str2);
            }
        }
        if (dVar == null || (shortTVItemC = dVar.c()) == null || (video = shortTVItemC.getVideo()) == null) {
            unit = null;
        } else {
            FirstFrame firstFrame = video.getFirstFrame();
            if (firstFrame == null || (url = firstFrame.getUrl()) == null) {
                Cover cover = video.getCover();
                if (cover != null) {
                    String url = cover.getUrl();
                    str = url;
                } else {
                    str = null;
                }
            } else {
                str = url;
            }
            if (str != null) {
                ImageHelper.Companion companion = ImageHelper.f51371a;
                ListVideoPreloadHelper.a aVar = ListVideoPreloadHelper.f53890f;
                String strE = companion.e(str, (124 & 2) != 0 ? 0 : aVar.a(), (124 & 4) != 0 ? 0 : aVar.a(), (124 & 8) != 0, (124 & 16) != 0 ? false : false, (124 & 32) == 0 ? false : false, (124 & 64) != 0 ? 25 : 0);
                if (Intrinsics.b(strE, this.f57899b.f72184h.getTag())) {
                    return;
                }
                ShortTvBaseListFragment shortTvBaseListFragment = this.f57903g;
                if (shortTvBaseListFragment != null && (activity = shortTvBaseListFragment.getActivity()) != null) {
                    Intrinsics.f(activity, "fragment?.activity ?: return@let");
                    uo.b.a.f(uo.b.f78622a, this.f57898a, "into  " + this, false, 4, null);
                    this.f57899b.f72184h.setTag(strE);
                    Glide.with(activity).load2(strE).addListener(new h()).into(this.f57899b.f72184h);
                }
                unit = Unit.f68710a;
            } else {
                unit = null;
            }
        }
        if (unit == null) {
            this.f57899b.f72184h.setImageDrawable(null);
        }
    }

    public void app2Background() {
        qx.d dVar = this.f57901d;
        boolean zE = dVar != null ? dVar.e() : false;
        VideoDotLayer videoDotLayer = this.f57911o;
        if (videoDotLayer != null) {
            videoDotLayer.k(zE, true);
        }
    }

    public final void f(ORPlayerView oRPlayerView, Video video) {
        ViewParent parent = oRPlayerView.getParent();
        if (!Intrinsics.b(parent, this.f57899b.f72181d)) {
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(oRPlayerView);
            }
            this.f57899b.f72181d.addView(oRPlayerView, new FrameLayout.LayoutParams(-1, -1));
        }
        if (video != null) {
            A(video.getWidth(), video.getHeight());
        }
    }

    public final void g() {
        AppCompatImageView appCompatImageView = this.f57899b.f72188l;
        Intrinsics.f(appCompatImageView, "viewBinding.ivShare");
        if (appCompatImageView.getVisibility() == 0) {
            this.G.removeCallbacks(this.H);
            this.G.postDelayed(this.H, 3000L);
        }
    }

    public FrameLayout getPlayerContainer() {
        FrameLayout frameLayout = this.f57899b.f72181d;
        Intrinsics.f(frameLayout, "viewBinding.flContainer");
        return frameLayout;
    }

    @Override // com.transsion.shorttv.a
    public long getProgress() {
        return this.f57899b.f72193q.getProgress();
    }

    public ShortTvViewModel getViewModel(FragmentActivity activity) {
        Intrinsics.g(activity, "activity");
        return (ShortTvViewModel) new v0(activity).a(ShortTvViewModel.class);
    }

    public final void i(com.transsion.shorttv.favorite.a aVar) {
        Integer numValueOf;
        if (aVar instanceof com.transsion.shorttv.favorite.d) {
            numValueOf = Integer.valueOf(com.tn.lib.widget.R$string.failed_toast);
        } else if (aVar instanceof com.transsion.shorttv.favorite.c) {
            numValueOf = Integer.valueOf(com.transsnet.downloader.R$string.short_tv_favorite_remove_toast);
        } else {
            numValueOf = aVar instanceof com.transsion.shorttv.favorite.b ? Integer.valueOf(com.transsnet.downloader.R$string.short_tv_favorite_toast) : null;
        }
        if (numValueOf != null) {
            zp.b.f82110a.d(numValueOf.intValue());
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        com.transsion.player.orplayer.e.a.a(this);
    }

    public final void j() {
        this.G.removeCallbacks(this.H);
        ShortTvViewModel shortTvViewModel = this.f57921y;
        if (shortTvViewModel != null) {
            shortTvViewModel.P(false);
        }
    }

    public final void k() {
        View view = this.I;
        if (view != null) {
            so.c.g(view);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onAliyunDecodeErrorChangeSoftwareDecoder(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.b(this, mediaSource);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        u viewLifecycleOwner;
        LiveData<com.transsion.shorttv.favorite.a> liveDataS;
        LiveData<com.transsion.shorttv.favorite.a> liveDataS2;
        LiveData<Boolean> liveDataR;
        LiveData<Boolean> liveDataG;
        super.onAttachedToWindow();
        ShortTvBaseListFragment shortTvBaseListFragment = this.f57903g;
        if (shortTvBaseListFragment == null || (viewLifecycleOwner = shortTvBaseListFragment.getViewLifecycleOwner()) == null) {
            return;
        }
        ShortTvViewModel shortTvViewModel = this.f57921y;
        if (shortTvViewModel != null && (liveDataG = shortTvViewModel.G()) != null) {
            liveDataG.j(viewLifecycleOwner, this.f57922z);
        }
        ShortTvViewModel shortTvViewModel2 = this.f57921y;
        if (shortTvViewModel2 != null && (liveDataR = shortTvViewModel2.r()) != null) {
            liveDataR.j(viewLifecycleOwner, this.A);
        }
        b bVar = this.B;
        ShortTvViewModel shortTvViewModel3 = this.f57921y;
        bVar.b((shortTvViewModel3 == null || (liveDataS2 = shortTvViewModel3.s()) == null) ? null : liveDataS2.f());
        ShortTvViewModel shortTvViewModel4 = this.f57921y;
        if (shortTvViewModel4 == null || (liveDataS = shortTvViewModel4.s()) == null) {
            return;
        }
        liveDataS.j(viewLifecycleOwner, this.B);
    }

    @Override // com.transsion.player.orplayer.e
    public void onBufferedPosition(long j11, MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.c(this, j11, mediaSource);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ShortTvBaseListFragment shortTvBaseListFragment;
        FragmentActivity activity;
        LiveData<Subject> liveDataH;
        Subject subjectF;
        ShortTvBaseListFragment shortTvBaseListFragment2;
        FragmentActivity activity2;
        LiveData<Subject> liveDataH2;
        Subject subjectF2;
        String pageName;
        if (com.transsion.baseui.util.c.f51452a.a(view != null ? view.getId() : 0, 500L)) {
            return;
        }
        Integer numValueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i11 = R$id.tv_episode;
        if (numValueOf != null && numValueOf.intValue() == i11) {
            showEpisodeListDialog();
            return;
        }
        int i12 = R$id.tv_favorite;
        if (numValueOf != null && numValueOf.intValue() == i12) {
            ShortTvViewModel shortTvViewModel = this.f57921y;
            if (shortTvViewModel == null || (liveDataH2 = shortTvViewModel.H()) == null || (subjectF2 = liveDataH2.f()) == null) {
                return;
            }
            tp.e eVar = tp.e.f77259a;
            Context context = getContext();
            Intrinsics.f(context, "context");
            if (!eVar.a(context)) {
                u();
                return;
            }
            if (this.f57901d != null) {
                com.transsion.shorttv.dot.b bVar = com.transsion.shorttv.dot.b.f57848a;
                String subjectId = subjectF2.getSubjectId();
                ShortTVFavInfo shortTVFavInfo = subjectF2.getShortTVFavInfo();
                boolean hasFavorite = shortTVFavInfo != null ? shortTVFavInfo.getHasFavorite() : false;
                ShortTvBaseListFragment shortTvBaseListFragment3 = this.f57903g;
                if (shortTvBaseListFragment3 == null || (pageName = shortTvBaseListFragment3.getPageName()) == null) {
                    pageName = "";
                }
                bVar.c(subjectId, "", hasFavorite, pageName);
            }
            ShortTvViewModel shortTvViewModel2 = this.f57921y;
            if (shortTvViewModel2 != null) {
                shortTvViewModel2.q(subjectF2);
                return;
            }
            return;
        }
        int i13 = R$id.iv_play_status;
        if (numValueOf != null && numValueOf.intValue() == i13) {
            p();
            return;
        }
        int i14 = R$id.iv_share;
        if (numValueOf != null && numValueOf.intValue() == i14) {
            q(view);
            return;
        }
        int i15 = R$id.iv_download;
        if (numValueOf == null || numValueOf.intValue() != i15) {
            int i16 = R$id.iv_short_cover;
            if (numValueOf == null || numValueOf.intValue() != i16) {
                int i17 = R$id.tv_name;
                if (numValueOf == null || numValueOf.intValue() != i17) {
                    int i18 = R$id.iv_back;
                    if (numValueOf == null || numValueOf.intValue() != i18 || (shortTvBaseListFragment = this.f57903g) == null || (activity = shortTvBaseListFragment.getActivity()) == null) {
                        return;
                    }
                    activity.finish();
                    return;
                }
            }
        }
        ShortTvViewModel shortTvViewModel3 = this.f57921y;
        if (shortTvViewModel3 == null || (liveDataH = shortTvViewModel3.H()) == null || (subjectF = liveDataH.f()) == null || (shortTvBaseListFragment2 = this.f57903g) == null || (activity2 = shortTvBaseListFragment2.getActivity()) == null) {
            return;
        }
        Intrinsics.f(activity2, "fragment?.activity ?: return");
        DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
        ShortTvBaseListFragment shortTvBaseListFragment4 = this.f57903g;
        downloadManagerApiA.a2(activity2, shortTvBaseListFragment4 != null ? shortTvBaseListFragment4.getPageName() : null, (384 & 4) != 0 ? "" : "", subjectF.getOps(), (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : view.getId() == R$id.iv_download, (384 & 64) != 0 ? null : subjectF, (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : Boolean.valueOf(view.getId() != R$id.iv_download));
    }

    @Override // com.transsion.player.orplayer.e
    public void onCompletion(MediaSource mediaSource) {
        uo.b.a.o(uo.b.f78622a, this.f57898a, new String[]{"onCompletion， play next"}, false, 4, null);
        VideoDotLayer videoDotLayer = this.f57911o;
        if (videoDotLayer != null) {
            com.transsion.player.orplayer.e.a.e(videoDotLayer, null, 1, null);
        }
        y(0L);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        LiveData<com.transsion.shorttv.favorite.a> liveDataS;
        LiveData<Boolean> liveDataR;
        LiveData<Boolean> liveDataG;
        super.onDetachedFromWindow();
        ShortTvViewModel shortTvViewModel = this.f57921y;
        if (shortTvViewModel != null && (liveDataG = shortTvViewModel.G()) != null) {
            liveDataG.o(this.f57922z);
        }
        ShortTvViewModel shortTvViewModel2 = this.f57921y;
        if (shortTvViewModel2 != null && (liveDataR = shortTvViewModel2.r()) != null) {
            liveDataR.o(this.A);
        }
        this.G.removeCallbacksAndMessages(null);
        ShortTvViewModel shortTvViewModel3 = this.f57921y;
        if (shortTvViewModel3 != null && (liveDataS = shortTvViewModel3.s()) != null) {
            liveDataS.o(this.B);
        }
        ShortTvViewModel shortTvViewModel4 = this.f57921y;
        if (shortTvViewModel4 != null) {
            shortTvViewModel4.o();
        }
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
        VideoDotLayer videoDotLayer = this.f57911o;
        if (videoDotLayer != null) {
            com.transsion.player.orplayer.e.a.i(videoDotLayer, null, 1, null);
        }
        setLoading(true);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingEnd(MediaSource mediaSource) {
        VideoDotLayer videoDotLayer = this.f57911o;
        if (videoDotLayer != null) {
            com.transsion.player.orplayer.e.a.k(videoDotLayer, null, 1, null);
        }
        setLoading(false);
        removeCallbacks(this.E);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingProgress(int i11, float f11, MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.l(this, i11, f11, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoopingStart() {
    }

    public final void onMediaItemTransition() {
        uo.b.a.f(uo.b.f78622a, this.f57898a, "onMediaItemTransition: " + this.f57899b.f72191o.getMax() + "  : " + this, false, 4, null);
        VideoDotLayer videoDotLayer = this.f57911o;
        if (videoDotLayer != null) {
            com.transsion.player.orplayer.e.a.e(videoDotLayer, null, 1, null);
        }
        reset();
    }

    @Override // com.transsion.player.orplayer.e
    public void onMediaItemTransition(String str) {
        com.transsion.player.orplayer.e.a.o(this, str);
    }

    @Override // com.transsion.shorttv.a
    public void onPageRelease(int i11) {
        onPlayerReset();
    }

    @Override // com.transsion.shorttv.a
    public void onPageSelected(com.transsion.player.orplayer.f fVar, ORPlayerView oRPlayerView, qx.d dVar) {
        ShortTvViewModel shortTvViewModel;
        this.f57907k = fVar;
        this.f57908l = oRPlayerView;
        if (dVar != null && (shortTvViewModel = this.f57921y) != null) {
            shortTvViewModel.O(dVar.b());
        }
        updateShortTvInfo(fVar, oRPlayerView, dVar);
        if (this.f57899b.f72188l.getVisibility() == 4 || this.f57899b.f72188l.getVisibility() == 8) {
            this.f57899b.f72194r.hide();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayError(PlayError errorInfo, MediaSource mediaSource) {
        Integer errorCode;
        Intrinsics.g(errorInfo, "errorInfo");
        VideoDotLayer videoDotLayer = this.f57911o;
        if (videoDotLayer != null) {
            com.transsion.player.orplayer.e.a.q(videoDotLayer, errorInfo, null, 2, null);
        }
        uo.b.f78622a.h("i_media", this.f57898a + " --> IPlayerListener --> onPlayError()  errorCode:" + errorInfo.getErrorCode() + " errorMessage:" + errorInfo.getErrorMessage() + " url:" + (mediaSource != null ? mediaSource.j() : null) + " --> 短播放失败了", true);
        setLoading(false);
        Integer errorCode2 = errorInfo.getErrorCode();
        if ((errorCode2 != null && errorCode2.intValue() == 2001) || ((errorCode = errorInfo.getErrorCode()) != null && errorCode.intValue() == 2002)) {
            u();
        }
    }

    public void onPlayErrorChangePayer(TnPlayerType tnPlayerType, MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.r(this, tnPlayerType, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerRelease(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.s(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerReset() {
        ShortTvViewModel shortTvViewModel;
        LiveData<Subject> liveDataH;
        uo.b.a aVar = uo.b.f78622a;
        uo.b.a.f(aVar, this.f57898a, "player- onPlayerReset data: " + this.f57901d, false, 4, null);
        setKeepScreenOn(false);
        this.f57912p = false;
        ShortTvBaseListFragment shortTvBaseListFragment = this.f57903g;
        if (shortTvBaseListFragment != null) {
            shortTvBaseListFragment.i1(false);
        }
        this.C = false;
        this.D = false;
        qx.d dVar = this.f57901d;
        boolean zE = dVar != null ? dVar.e() : false;
        VideoDotLayer videoDotLayer = this.f57911o;
        if (videoDotLayer != null) {
            videoDotLayer.k(zE, false);
        }
        if (zE && (shortTvViewModel = this.f57921y) != null) {
            shortTvViewModel.S((shortTvViewModel == null || (liveDataH = shortTvViewModel.H()) == null) ? null : liveDataH.f(), this.f57901d, this.f57899b.f72193q.getProgress());
        }
        AppCompatImageView appCompatImageView = this.f57899b.f72184h;
        Intrinsics.f(appCompatImageView, "viewBinding.ivCover");
        so.c.k(appCompatImageView);
        uo.b.a.f(aVar, this.f57898a, "onPlayerReset   visible  " + this, false, 4, null);
        AppCompatImageView appCompatImageView2 = this.f57899b.f72187k;
        Intrinsics.f(appCompatImageView2, "viewBinding.ivPlayStatus");
        so.c.g(appCompatImageView2);
        com.transsion.player.orplayer.f fVar = this.f57907k;
        if (fVar != null) {
            fVar.removePlayerListener(this);
        }
        this.f57907k = null;
        this.f57908l = null;
        this.f57909m = null;
        this.f57915s = 0L;
        y(0L);
        z(100L);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPrepare(MediaSource mediaSource) {
        ShortTvBaseListFragment shortTvBaseListFragment;
        LiveData<ShortTVPlayBean> liveDataT;
        ShortTVPlayBean shortTVPlayBeanF;
        qx.d dVar;
        ShortTVItem shortTVItemC;
        if (this.D) {
            return;
        }
        this.D = true;
        com.transsion.player.orplayer.f fVar = this.f57907k;
        z(fVar != null ? fVar.getDuration() : 0L);
        ShortTvViewModel shortTvViewModel = this.f57921y;
        if (shortTvViewModel != null && (liveDataT = shortTvViewModel.t()) != null && (shortTVPlayBeanF = liveDataT.f()) != null && (dVar = this.f57901d) != null && (shortTVItemC = dVar.c()) != null && shortTVPlayBeanF.getEp() == shortTVItemC.getEp()) {
            long progress = shortTVPlayBeanF.getProgress();
            uo.b.a.f(uo.b.f78622a, this.f57898a, "player- onPrepare, duration = " + this.f57899b.f72193q.getProgress() + ", progress = " + progress + "  this = " + this, false, 4, null);
            if (progress > 0) {
                this.f57915s = progress;
                com.transsion.player.orplayer.f fVar2 = this.f57907k;
                if (fVar2 != null) {
                    fVar2.seekTo(progress);
                }
            }
            ShortTvViewModel shortTvViewModel2 = this.f57921y;
            if (shortTvViewModel2 != null) {
                shortTvViewModel2.p();
            }
        }
        if (!this.f57912p && !this.f57914r && (shortTvBaseListFragment = this.f57903g) != null && shortTvBaseListFragment.isVisible()) {
            uo.b.a.f(uo.b.f78622a, this.f57898a, "player- onPrepare， play~", false, 4, null);
        }
        setKeepScreenOn(true);
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long j11, MediaSource mediaSource) {
        com.transsion.player.orplayer.f fVar;
        com.transsion.player.orplayer.f fVar2;
        ShortTVItem shortTVItemC;
        if (this.f57913q) {
            return;
        }
        if (mediaSource != null) {
            String strE = mediaSource.e();
            qx.d dVar = this.f57901d;
            if (!Intrinsics.b(strE, (dVar == null || (shortTVItemC = dVar.c()) == null) ? null : shortTVItemC.getId())) {
                uo.b.a.f(uo.b.f78622a, this.f57898a, "onProgress- vid 不同, return", false, 4, null);
                return;
            }
        }
        long max = this.f57899b.f72193q.getMax();
        if (max <= 0 || max == 100 || (fVar2 = this.f57907k) == null || max != fVar2.getDuration()) {
            com.transsion.player.orplayer.f fVar3 = this.f57907k;
            long duration = fVar3 != null ? fVar3.getDuration() : 0L;
            if (duration <= 0) {
                uo.b.a.f(uo.b.f78622a, this.f57898a, "onProgress- duration <= 0, return", false, 4, null);
                return;
            }
            z(duration);
        }
        VideoDotLayer videoDotLayer = this.f57911o;
        if (videoDotLayer != null) {
            com.transsion.player.orplayer.e.a.y(videoDotLayer, j11, null, 2, null);
        }
        y(j11);
        setLoading(false);
        if (j11 > 0) {
            AppCompatImageView appCompatImageView = this.f57899b.f72184h;
            Intrinsics.f(appCompatImageView, "viewBinding.ivCover");
            if (appCompatImageView.getVisibility() == 0 && (fVar = this.f57907k) != null && fVar.isPlaying()) {
                uo.b.a.f(uo.b.f78622a, this.f57898a, "onProgress-progress>= cover gone", false, 4, null);
                AppCompatImageView appCompatImageView2 = this.f57899b.f72184h;
                Intrinsics.f(appCompatImageView2, "viewBinding.ivCover");
                so.c.g(appCompatImageView2);
            }
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        uo.b.a aVar = uo.b.f78622a;
        String str = this.f57898a;
        AppCompatImageView appCompatImageView = this.f57899b.f72184h;
        Intrinsics.f(appCompatImageView, "viewBinding.ivCover");
        uo.b.a.f(aVar, str, "player-   viewBinding.ivCover.isVisible:" + (appCompatImageView.getVisibility() == 0) + " onRenderFirstFrame" + this, false, 4, null);
        if (!this.C) {
            this.C = true;
            VideoDotLayer videoDotLayer = this.f57911o;
            if (videoDotLayer != null) {
                videoDotLayer.onRenderFirstFrame();
            }
        }
        setLoading(false);
        AppCompatImageView appCompatImageView2 = this.f57899b.f72184h;
        Intrinsics.f(appCompatImageView2, "viewBinding.ivCover");
        so.c.g(appCompatImageView2);
    }

    @Override // com.transsion.player.orplayer.e
    public void onSetDataSource() {
    }

    @Override // androidx.lifecycle.r
    public void onStateChanged(u source, Lifecycle.Event event) {
        com.transsion.player.orplayer.f fVar;
        ShortTvBaseListFragment shortTvBaseListFragment;
        Lifecycle lifecycle;
        Intrinsics.g(source, "source");
        Intrinsics.g(event, "event");
        int i11 = a.f57923a[event.ordinal()];
        if (i11 == 1) {
            this.f57914r = true;
            uo.b.a.f(uo.b.f78622a, this.f57898a, "player- onPause", false, 4, null);
            if (com.transsion.videofloat.a.f60027a.c(this.f57907k) || (fVar = this.f57907k) == null) {
                return;
            }
            fVar.pause();
            return;
        }
        if (i11 == 2) {
            this.f57914r = false;
            if (this.f57912p || (shortTvBaseListFragment = this.f57903g) == null || !shortTvBaseListFragment.isVisible()) {
                return;
            }
            uo.b.a.f(uo.b.f78622a, this.f57898a, "ON_RESUME", false, 4, null);
            r();
            return;
        }
        if (i11 != 5) {
            return;
        }
        ShortTvBaseListFragment shortTvBaseListFragment2 = this.f57903g;
        if (shortTvBaseListFragment2 != null && (lifecycle = shortTvBaseListFragment2.getLifecycle()) != null) {
            lifecycle.d(this);
        }
        VideoDotLayer videoDotLayer = this.f57911o;
        if (videoDotLayer != null) {
            videoDotLayer.o();
        }
        com.transsion.player.orplayer.f fVar2 = this.f57907k;
        if (fVar2 != null) {
            fVar2.removePlayerListener(this);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.g(event, "event");
        GestureDetector gestureDetector = this.f57910n;
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
        uo.b.a.f(uo.b.f78622a, this.f57898a, "player- onVideoPause", false, 4, null);
        if (this.f57912p) {
            AppCompatImageView appCompatImageView = this.f57899b.f72187k;
            Intrinsics.f(appCompatImageView, "viewBinding.ivPlayStatus");
            appCompatImageView.setVisibility(0);
        }
        VideoDotLayer videoDotLayer = this.f57911o;
        if (videoDotLayer != null) {
            com.transsion.player.orplayer.e.a.F(videoDotLayer, null, 1, null);
        }
        setKeepScreenOn(false);
        v();
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i11, int i12) {
        A(Integer.valueOf(i11), Integer.valueOf(i12));
        uo.b.a.f(uo.b.f78622a, this.f57898a, "onVideoSizeChanged " + this, false, 4, null);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(MediaSource mediaSource) {
        uo.b.a.f(uo.b.f78622a, this.f57898a, "player- onVideoStart", false, 4, null);
        onPrepare(mediaSource);
        VideoDotLayer videoDotLayer = this.f57911o;
        if (videoDotLayer != null) {
            com.transsion.player.orplayer.e.a.I(videoDotLayer, null, 1, null);
        }
        AppCompatImageView appCompatImageView = this.f57899b.f72187k;
        Intrinsics.f(appCompatImageView, "viewBinding.ivPlayStatus");
        appCompatImageView.setVisibility(8);
        setLoading(false);
        setKeepScreenOn(true);
        g();
    }

    public final void p() {
        if (this.F) {
            AppCompatImageView appCompatImageView = this.f57899b.f72188l;
            Intrinsics.f(appCompatImageView, "viewBinding.ivShare");
            if (appCompatImageView.getVisibility() == 0) {
                j();
                return;
            } else {
                v();
                return;
            }
        }
        com.transsion.player.orplayer.f fVar = this.f57907k;
        if (fVar == null || !fVar.isPlaying()) {
            AppCompatImageView appCompatImageView2 = this.f57899b.f72188l;
            Intrinsics.f(appCompatImageView2, "viewBinding.ivShare");
            if (appCompatImageView2.getVisibility() != 0) {
                v();
            }
            VideoDotLayer videoDotLayer = this.f57911o;
            if (videoDotLayer != null) {
                videoDotLayer.i();
            }
            r();
            this.f57912p = false;
            ShortTvBaseListFragment shortTvBaseListFragment = this.f57903g;
            if (shortTvBaseListFragment == null) {
                return;
            }
            shortTvBaseListFragment.i1(false);
            return;
        }
        AppCompatImageView appCompatImageView3 = this.f57899b.f72188l;
        Intrinsics.f(appCompatImageView3, "viewBinding.ivShare");
        if (appCompatImageView3.getVisibility() != 0) {
            v();
            g();
            return;
        }
        this.f57912p = true;
        ShortTvBaseListFragment shortTvBaseListFragment2 = this.f57903g;
        if (shortTvBaseListFragment2 != null) {
            shortTvBaseListFragment2.i1(true);
        }
        VideoDotLayer videoDotLayer2 = this.f57911o;
        if (videoDotLayer2 != null) {
            videoDotLayer2.h();
        }
        com.transsion.player.orplayer.f fVar2 = this.f57907k;
        if (fVar2 != null) {
            fVar2.pause();
        }
        v();
    }

    public final void r() {
        com.transsion.player.orplayer.f fVar;
        uo.b.a aVar = uo.b.f78622a;
        uo.b.a.f(aVar, this.f57898a, "playVideo   data:" + this.f57901d + "  orPlayer:" + this.f57907k, false, 4, null);
        qx.d dVar = this.f57901d;
        if (dVar == null || this.f57907k == null || qx.f.b(dVar)) {
            return;
        }
        if (!dVar.e()) {
            uo.b.a.f(aVar, this.f57898a, "player- no free now, show pay dialog", false, 4, null);
            setLoading(false);
            return;
        }
        com.transsion.player.orplayer.f fVar2 = this.f57907k;
        if (fVar2 != null && fVar2.isComplete() && (fVar = this.f57907k) != null) {
            fVar.seekTo(0L);
        }
        com.transsion.player.orplayer.f fVar3 = this.f57907k;
        if (fVar3 != null) {
            fVar3.play();
        }
        uo.b.a.f(aVar, this.f57898a, "player- startplay    ", false, 4, null);
    }

    public final void reset() {
        ShortTvViewModel shortTvViewModel;
        LiveData<Subject> liveDataH;
        uo.b.a.f(uo.b.f78622a, this.f57898a, "playNewMedia data: " + this.f57901d, false, 4, null);
        setKeepScreenOn(false);
        this.f57912p = false;
        ShortTvBaseListFragment shortTvBaseListFragment = this.f57903g;
        if (shortTvBaseListFragment != null) {
            shortTvBaseListFragment.i1(false);
        }
        this.C = false;
        qx.d dVar = this.f57901d;
        boolean zE = dVar != null ? dVar.e() : false;
        VideoDotLayer videoDotLayer = this.f57911o;
        if (videoDotLayer != null) {
            videoDotLayer.k(zE, false);
        }
        if (zE && (shortTvViewModel = this.f57921y) != null) {
            shortTvViewModel.S((shortTvViewModel == null || (liveDataH = shortTvViewModel.H()) == null) ? null : liveDataH.f(), this.f57901d, this.f57899b.f72193q.getProgress());
        }
        AppCompatImageView appCompatImageView = this.f57899b.f72187k;
        Intrinsics.f(appCompatImageView, "viewBinding.ivPlayStatus");
        so.c.g(appCompatImageView);
        this.f57915s = 0L;
        y(0L);
        z(100L);
    }

    public final void s(String str, Subject subject, ShortTVItem shortTVItem, boolean z11) {
        String description;
        ExpandView expandView = this.f57899b.f72180c;
        expandView.setExpandListener(new f());
        String description2 = (shortTVItem == null || (description = shortTVItem.getDescription()) == null || description.length() <= 0) ? subject.getDescription() : shortTVItem.getDescription();
        StringCompanionObject stringCompanionObject = StringCompanionObject.f68912a;
        String str2 = String.format("EP%s | %s", Arrays.copyOf(new Object[]{str, description2}, 2));
        Intrinsics.f(str2, "format(...)");
        expandView.l(str2);
        this.f57899b.f72196t.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.shorttv.widget.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ShortTvVideoItemView.t(this.f57955a, view);
            }
        });
        if (z11) {
            Group group = this.f57899b.f72182f;
            Intrinsics.f(group, "viewBinding.groupContent");
            if (group.getVisibility() == 0) {
                AppCompatTextView appCompatTextView = this.f57899b.f72196t;
                Intrinsics.f(appCompatTextView, "viewBinding.tvAllShortTv");
                so.c.k(appCompatTextView);
                return;
            }
        }
        AppCompatTextView appCompatTextView2 = this.f57899b.f72196t;
        Intrinsics.f(appCompatTextView2, "viewBinding.tvAllShortTv");
        so.c.g(appCompatTextView2);
    }

    /* JADX WARN: Code duplicated, block: B:85:0x024d  */
    @Override // com.transsion.shorttv.a
    public void setData(qx.d item, ShortTvBaseListFragment fragment, Integer num, boolean z11, String str, String str2, boolean z12, boolean z13) {
        WindowInsets rootWindowInsets;
        Insets insets;
        boolean z14;
        LiveData<Subject> liveDataH;
        Subject subjectF;
        Media video;
        Video videoAddress;
        FragmentActivity activity;
        Intrinsics.g(item, "item");
        Intrinsics.g(fragment, "fragment");
        uo.b.a.f(uo.b.f78622a, this.f57898a, "setData position:" + num + "  ep:" + item.b() + " item:" + item + " " + this, false, 4, null);
        this.f57903g = fragment;
        this.f57904h = Boolean.valueOf(z11);
        this.f57906j = str;
        this.f57905i = num;
        int[] referenceIds = this.f57899b.f72182f.getReferencedIds();
        if (!z13) {
            Intrinsics.f(referenceIds, "referenceIds");
            ArrayList arrayList = new ArrayList();
            for (int i11 : referenceIds) {
                if (i11 != R$id.tv_all_short_tv) {
                    arrayList.add(Integer.valueOf(i11));
                }
            }
            referenceIds = CollectionsKt___CollectionsKt.I0(arrayList);
        }
        this.f57899b.f72182f.setReferencedIds(referenceIds);
        this.f57899b.f72194r.setData(item.c());
        fragment.getLifecycle().a(this);
        this.f57901d = item;
        if (!z12) {
            this.f57911o = new VideoDotLayer(fragment);
        }
        VideoDotLayer videoDotLayer = this.f57911o;
        if (videoDotLayer != null) {
            videoDotLayer.r(str);
        }
        VideoDotLayer videoDotLayer2 = this.f57911o;
        if (videoDotLayer2 != null) {
            videoDotLayer2.q(str2);
        }
        VideoDotLayer videoDotLayer3 = this.f57911o;
        if (videoDotLayer3 != null) {
            videoDotLayer3.w(fragment.getPageName());
        }
        VideoDotLayer videoDotLayer4 = this.f57911o;
        if (videoDotLayer4 != null) {
            videoDotLayer4.s(item.a());
        }
        FragmentActivity activity2 = fragment.getActivity();
        if (activity2 != null) {
            this.f57921y = getViewModel(activity2);
        }
        x();
        ShortTvViewModel shortTvViewModel = this.f57921y;
        if (shortTvViewModel != null && (liveDataH = shortTvViewModel.H()) != null && (subjectF = liveDataH.f()) != null) {
            PostSubjectItem postSubjectItem = new PostSubjectItem(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, false, null, false, null, false, 1073741823, null);
            postSubjectItem.setSubject(subjectF);
            postSubjectItem.setOps(subjectF.getOps());
            postSubjectItem.setItemType("7");
            VideoDotLayer videoDotLayer5 = this.f57911o;
            if (videoDotLayer5 != null) {
                videoDotLayer5.d("", postSubjectItem);
            }
            this.f57902f = subjectF;
            qx.d dVar = this.f57901d;
            String strA = com.transsion.shorttv.utils.b.a(dVar != null ? Integer.valueOf(dVar.b()) : null);
            Subject subject = this.f57902f;
            this.f57899b.f72197u.setText("EP" + strA + " / EP" + (subject != null ? com.transsion.shorttv.utils.b.a(Integer.valueOf(subject.getTotalEpisode())) : null));
            Cover cover = subjectF.getCover();
            if (cover != null && (activity = fragment.getActivity()) != null) {
                Intrinsics.f(activity, "fragment.activity ?: return@let");
                ImageHelper.Companion companion = ImageHelper.f51371a;
                ShapeableImageView shapeableImageView = this.f57899b.f72189m;
                Intrinsics.f(shapeableImageView, "viewBinding.ivShortCover");
                String url = cover.getUrl();
                String str3 = url == null ? "" : url;
                int iE = i.e(21.0f);
                int iE2 = i.e(30.0f);
                String thumbnail = cover.getThumbnail();
                companion.q(activity, shapeableImageView, str3, (8120 & 8) != 0 ? companion.d() : iE, (8120 & 16) != 0 ? companion.c() : iE2, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : thumbnail == null ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : true, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
            }
            ShortTVItem shortTVItemC = item.c();
            if (shortTVItemC != null && (video = shortTVItemC.getVideo()) != null && (videoAddress = video.getVideoAddress()) != null) {
                A(videoAddress.getWidth(), videoAddress.getHeight());
            }
            this.f57899b.f72199w.setText(subjectF.getTitle());
            s(strA, subjectF, item.c(), z13);
        }
        if (Build.VERSION.SDK_INT >= 30) {
            Context context = getContext();
            Intrinsics.e(context, "null cannot be cast to non-null type android.app.Activity");
            Window window = ((Activity) context).getWindow();
            if (window != null && (rootWindowInsets = window.getDecorView().getRootWindowInsets()) != null && (insets = rootWindowInsets.getInsets(WindowInsets.Type.tappableElement())) != null) {
                if (com.blankj.utilcode.util.d.e(window)) {
                    z14 = com.blankj.utilcode.util.d.a() > 1;
                }
                int iE3 = i.e(16.0f);
                if (z14 || insets.top <= 0) {
                    Space space = this.f57899b.f72192p;
                    Intrinsics.f(space, "viewBinding.progressGuideline");
                    ViewGroup.LayoutParams layoutParams = space.getLayoutParams();
                    if (layoutParams == null) {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                    }
                    ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
                    ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : null;
                    int i12 = marginLayoutParams != null ? marginLayoutParams.leftMargin : 0;
                    ViewGroup.LayoutParams layoutParams3 = getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : null;
                    int i13 = marginLayoutParams2 != null ? marginLayoutParams2.topMargin : 0;
                    ViewGroup.LayoutParams layoutParams4 = getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams4 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams4 : null;
                    bVar.setMargins(i12, i13, marginLayoutParams3 != null ? marginLayoutParams3.rightMargin : 0, iE3);
                    space.setLayoutParams(bVar);
                } else {
                    Space space2 = this.f57899b.f72192p;
                    Intrinsics.f(space2, "viewBinding.progressGuideline");
                    ViewGroup.LayoutParams layoutParams5 = space2.getLayoutParams();
                    if (layoutParams5 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                    }
                    ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams5;
                    ViewGroup.LayoutParams layoutParams6 = getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams4 = layoutParams6 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams6 : null;
                    int i14 = marginLayoutParams4 != null ? marginLayoutParams4.leftMargin : 0;
                    ViewGroup.LayoutParams layoutParams7 = getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams5 = layoutParams7 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams7 : null;
                    int i15 = marginLayoutParams5 != null ? marginLayoutParams5.topMargin : 0;
                    ViewGroup.LayoutParams layoutParams8 = getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams6 = layoutParams8 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams8 : null;
                    bVar2.setMargins(i14, i15, marginLayoutParams6 != null ? marginLayoutParams6.rightMargin : 0, kotlin.ranges.a.d(iE3, insets.top));
                    space2.setLayoutParams(bVar2);
                }
            }
        }
        B(item);
        updateLockState(item);
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        com.transsion.player.orplayer.e.a.J(this);
    }

    public void setPagerLayoutManager(PagerLayoutManager pagerLayoutManager) {
        Intrinsics.g(pagerLayoutManager, "pagerLayoutManager");
        this.f57909m = pagerLayoutManager;
    }

    public final void setPlayer(com.transsion.player.orplayer.f orPlayer, ORPlayerView orPlayerView) {
        Intrinsics.g(orPlayer, "orPlayer");
        Intrinsics.g(orPlayerView, "orPlayerView");
        uo.b.a.f(uo.b.f78622a, this.f57898a, "setPlayer: " + orPlayer + "  data: " + this.f57901d, false, 4, null);
        this.f57907k = orPlayer;
        this.f57908l = orPlayerView;
        VideoDotLayer videoDotLayer = this.f57911o;
        if (videoDotLayer != null) {
            videoDotLayer.c(orPlayer, orPlayerView);
        }
        y(0L);
        setLoading(false);
    }

    public final void setVideoUrl(String url) {
        Intrinsics.g(url, "url");
        VideoDotLayer videoDotLayer = this.f57911o;
        if (videoDotLayer != null) {
            videoDotLayer.z(url);
        }
    }

    public final void showEpisodeListDialog() {
        ShortTvBaseListFragment shortTvBaseListFragment = this.f57903g;
        Intrinsics.e(shortTvBaseListFragment, "null cannot be cast to non-null type com.transsion.shorttv.ShortTvBaseListFragment");
        shortTvBaseListFragment.l1();
    }

    public final void u() {
        ShortTvBaseListFragment shortTvBaseListFragment = this.f57903g;
        if (shortTvBaseListFragment != null) {
            shortTvBaseListFragment.n1();
        }
    }

    public void updateLockState(qx.d dVar) {
        if (dVar == null) {
            return;
        }
        if (dVar.e()) {
            k();
        } else {
            w();
        }
    }

    public void updateShortTvInfo(com.transsion.player.orplayer.f fVar, ORPlayerView oRPlayerView, qx.d dVar) {
        ShortTVItem shortTVItemC;
        Media video;
        Video videoAddress;
        String id2;
        Media video2;
        uo.b.a aVar = uo.b.f78622a;
        aVar.c(this.f57898a, "updateShortTvInfo:" + this.f57905i + " ", true);
        if (dVar == null || (shortTVItemC = dVar.c()) == null || (video = shortTVItemC.getVideo()) == null || (videoAddress = video.getVideoAddress()) == null) {
            return;
        }
        if (!dVar.e()) {
            aVar.c(this.f57898a, "onPageSelect position:" + this.f57905i + " item is not free ", true);
            if (fVar != null) {
                fVar.pause();
            }
            w();
            return;
        }
        k();
        if (qx.f.b(dVar)) {
            aVar.c(this.f57898a, "onPageSelect position:" + this.f57905i + " item is null ", true);
            if (fVar != null) {
                fVar.pause();
                return;
            }
            return;
        }
        if (fVar != null) {
            fVar.setPlayerListener(this);
        }
        if (oRPlayerView != null) {
            ShortTVItem shortTVItemC2 = dVar.c();
            f(oRPlayerView, (shortTVItemC2 == null || (video2 = shortTVItemC2.getVideo()) == null) ? null : video2.getVideoAddress());
            uo.b.a.f(aVar, this.f57898a, "addView-----", false, 4, null);
        }
        videoStartPrepare(this.f57920x);
        uo.b.a.f(aVar, this.f57898a, "play url=" + videoAddress.getUrl() + "  width:" + videoAddress.getWidth() + ",height:" + videoAddress.getHeight() + ", duration: " + videoAddress.getDuration() + ", builtIn = false", false, 4, null);
        String url = videoAddress.getUrl();
        if (url != null) {
            uo.b.a.f(aVar, this.f57898a, "seekTo url=" + url + " ", false, 4, null);
            if (fVar != null) {
                ShortTVItem shortTVItemC3 = dVar.c();
                if (shortTVItemC3 == null || (id2 = shortTVItemC3.getId()) == null) {
                    id2 = url;
                }
                fVar.seekTo(id2, 0L);
            }
            setVideoUrl(url);
        }
        if (fVar != null) {
            fVar.play();
        }
    }

    public final void v() {
        this.G.removeCallbacks(this.H);
        ShortTvViewModel shortTvViewModel = this.f57921y;
        if (shortTvViewModel != null) {
            shortTvViewModel.P(true);
        }
    }

    public final void videoStartPrepare(String pageFrom) {
        Intrinsics.g(pageFrom, "pageFrom");
        this.C = false;
        this.f57920x = pageFrom;
        VideoDotLayer videoDotLayer = this.f57911o;
        if (videoDotLayer != null) {
            videoDotLayer.v(pageFrom);
        }
        VideoDotLayer videoDotLayer2 = this.f57911o;
        if (videoDotLayer2 != null) {
            videoDotLayer2.u("immersive_play");
        }
        VideoDotLayer videoDotLayer3 = this.f57911o;
        if (videoDotLayer3 != null) {
            videoDotLayer3.y(SubjectType.SHORT_TV.getValue());
        }
        VideoDotLayer videoDotLayer4 = this.f57911o;
        if (videoDotLayer4 != null) {
            qx.d dVar = this.f57901d;
            videoDotLayer4.t(String.valueOf(dVar != null ? dVar.b() : 0));
        }
        VideoDotLayer videoDotLayer5 = this.f57911o;
        if (videoDotLayer5 != null) {
            videoDotLayer5.n(this, false);
        }
        VideoDotLayer videoDotLayer6 = this.f57911o;
        if (videoDotLayer6 != null) {
            videoDotLayer6.g(0, 0);
        }
        VideoDotLayer videoDotLayer7 = this.f57911o;
        if (videoDotLayer7 != null) {
            videoDotLayer7.x(this.f57905i);
        }
        setLoading(true);
        ShortTvViewModel shortTvViewModel = this.f57921y;
        if (shortTvViewModel != null) {
            shortTvViewModel.M();
        }
    }

    public final void w() {
        rx.a aVarE;
        LiveData<Subject> liveDataH;
        if (this.I == null) {
            ShortTvViewModel shortTvViewModel = this.f57921y;
            View viewD = null;
            subjectF = null;
            Subject subjectF = null;
            viewD = null;
            if (shortTvViewModel != null && (aVarE = shortTvViewModel.E()) != null) {
                ViewStub viewStub = this.f57899b.B;
                Intrinsics.f(viewStub, "viewBinding.vsUnlock");
                qx.d dVar = this.f57901d;
                ShortTvViewModel shortTvViewModel2 = this.f57921y;
                if (shortTvViewModel2 != null && (liveDataH = shortTvViewModel2.H()) != null) {
                    subjectF = liveDataH.f();
                }
                viewD = aVarE.d(viewStub, dVar, subjectF, this.J);
            }
            this.I = viewD;
        }
        View view = this.I;
        if (view != null) {
            so.c.k(view);
        }
    }

    public final void x() {
        LiveData<Subject> liveDataH;
        Subject subjectF;
        ShortTVFavInfo shortTVFavInfo;
        LiveData<Subject> liveDataH2;
        Subject subjectF2;
        ShortTVFavInfo shortTVFavInfo2;
        String favoriteNum;
        ShortTvViewModel shortTvViewModel = this.f57921y;
        this.f57899b.f72198v.setText(j.a((shortTvViewModel == null || (liveDataH2 = shortTvViewModel.H()) == null || (subjectF2 = liveDataH2.f()) == null || (shortTVFavInfo2 = subjectF2.getShortTVFavInfo()) == null || (favoriteNum = shortTVFavInfo2.getFavoriteNum()) == null) ? 0L : Long.parseLong(favoriteNum)));
        AppCompatTextView appCompatTextView = this.f57899b.f72198v;
        ShortTvViewModel shortTvViewModel2 = this.f57921y;
        appCompatTextView.setSelected((shortTvViewModel2 == null || (liveDataH = shortTvViewModel2.H()) == null || (subjectF = liveDataH.f()) == null || (shortTVFavInfo = subjectF.getShortTVFavInfo()) == null) ? false : shortTVFavInfo.getHasFavorite());
    }

    public final void y(long j11) {
        int i11 = (int) j11;
        this.f57899b.f72193q.setProgress(i11);
        this.f57899b.f72191o.setProgress(i11);
    }

    public final void z(long j11) {
        int i11 = (int) j11;
        this.f57899b.f72193q.setMax(i11);
        this.f57899b.f72191o.setMax(i11);
        uo.b.a.f(uo.b.f78622a, this.f57898a, "updateProgressMax: " + j11 + "  : " + this, false, 4, null);
    }
}
