package com.transsion.postdetail.ui.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.lifecycle.y0;
import com.alibaba.android.arouter.facade.Postcard;
import com.applovin.sdk.AppLovinEventTypes;
import com.bumptech.glide.Glide;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.tn.lib.pager.PagerLayoutManager;
import com.tn.lib.util.ActivityStackManager;
import com.tn.lib.view.expand.ExpandView;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.baseui.util.UrlContent;
import com.transsion.baseui.widget.NestedScrollableHost;
import com.transsion.moviedetailapi.IMovieDetailService;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.FirstFrame;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.ResourceDetectors;
import com.transsion.moviedetailapi.bean.ShortTVFavInfo;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Stat;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.User;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.moviedetailapi.helper.ListVideoPreloadHelper;
import com.transsion.player.MediaSource;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.global.TnPlayerType;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.R$string;
import com.transsion.postdetail.helper.ImmVideoHelper;
import com.transsion.postdetail.shorttv.ShortTvListActivity;
import com.transsion.postdetail.shorttv.ShortTvPlayListViewModel;
import com.transsion.postdetail.ui.dialog.ImmVideoCommentDialog;
import com.transsion.postdetail.ui.dialog.PostConfirmDialog;
import com.transsion.postdetail.ui.fragment.CommentFragment;
import com.transsion.postdetail.viewmodel.PostDetailViewModel;
import com.transsion.room.api.IAudioApi;
import com.transsion.room.api.IRoomApi;
import com.transsion.share.bean.PostType;
import com.transsion.share.share.ShareDialogFragment;
import com.transsion.usercenterapi.ReportType;
import com.transsion.web.api.WebPageIdentity;
import com.transsnet.downloader.DownloadManagerApi;
import com.transsnet.flow.event.AppScopeVMlProvider;
import com.transsnet.flow.event.FlowEventBus;
import com.transsnet.flow.event.sync.event.AddToDownloadEvent;
import com.transsnet.flow.event.sync.event.LikeEvent;
import com.transsnet.loginapi.ILoginApi;
import com.transsnet.loginapi.bean.UserInfo;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;
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
public final class ImmVideoItemView extends ConstraintLayout implements com.transsion.player.orplayer.e, View.OnClickListener, androidx.lifecycle.r {
    public final int A;
    public final int B;
    public final int C;
    public final int D;
    public final int E;
    public String F;
    public final AtomicBoolean G;
    public long H;
    public boolean I;
    public boolean J;
    public final androidx.lifecycle.d0<String> K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f55969a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final tv.v f55970b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public PostDetailViewModel f55971c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ShortTvPlayListViewModel f55972d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ShareDialogFragment f55973f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PostSubjectItem f55974g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Fragment f55975h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Boolean f55976i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Integer f55977j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f55978k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f55979l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.transsion.player.orplayer.f f55980m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public ORPlayerView f55981n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public PagerLayoutManager f55982o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public IAudioApi f55983p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public ImmVideoGuideView f55984q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public GestureDetector f55985r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f55986s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public com.transsion.postdetail.layer.b f55987t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ImmVideoCommentDialog f55988u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f55989v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f55990w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f55991x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public long f55992y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f55993z;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f55994a;

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
            f55994a = iArr;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent e11) {
            Intrinsics.g(e11, "e");
            return super.onDoubleTap(e11);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent e11) {
            Intrinsics.g(e11, "e");
            ImmVideoItemView.this.w();
            return super.onSingleTapUp(e11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class c implements is.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f55996a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f55997b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f55998c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f55999d = "";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f56000e = com.blankj.utilcode.util.f0.a(1.5f);

        public c() {
        }

        @Override // is.c.a
        public void a() {
        }

        @Override // is.c.a
        public void b(float f11, float f12) {
            int i11 = 0;
            if (!ImmVideoItemView.this.f55990w) {
                PagerLayoutManager pagerLayoutManager = ImmVideoItemView.this.f55982o;
                if (pagerLayoutManager != null) {
                    pagerLayoutManager.o(false);
                }
                this.f55996a = ImmVideoItemView.this.f55970b.f77971q.getProgress();
                ImmVideoItemView.this.setContentVisibility(false);
                AppCompatTextView appCompatTextView = ImmVideoItemView.this.f55970b.f77978x;
                Intrinsics.f(appCompatTextView, "viewBinding.tvProgressDes");
                so.c.k(appCompatTextView);
                AppCompatSeekBar appCompatSeekBar = ImmVideoItemView.this.f55970b.f77973s;
                Intrinsics.f(appCompatSeekBar, "viewBinding.seekBar");
                so.c.k(appCompatSeekBar);
                ProgressBar progressBar = ImmVideoItemView.this.f55970b.f77971q;
                Intrinsics.f(progressBar, "viewBinding.progressBar");
                so.c.g(progressBar);
                this.f55998c = ImmVideoItemView.this.f55970b.f77971q.getWidth();
                int max = ImmVideoItemView.this.f55970b.f77971q.getMax();
                this.f55997b = max;
                this.f55999d = com.transsion.postdetail.util.i.c(max);
            }
            ImmVideoItemView.this.f55990w = true;
            float f13 = f12 - f11;
            int i12 = this.f55997b;
            int i13 = (int) (this.f55996a + ((f13 * i12) / this.f55998c));
            if (i13 >= 0) {
                i11 = i13 > i12 ? i12 : i13;
            }
            ImmVideoItemView.this.f55970b.f77978x.setText(com.transsion.postdetail.util.i.c(i11) + " / " + this.f55999d);
            ImmVideoItemView.this.f55970b.f77971q.setProgress(i11);
            ImmVideoItemView.this.f55970b.f77973s.setProgress(i11);
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
            PagerLayoutManager pagerLayoutManager = ImmVideoItemView.this.f55982o;
            if (pagerLayoutManager != null) {
                pagerLayoutManager.o(true);
            }
            if (ImmVideoItemView.this.f55990w) {
                ImmVideoItemView.this.f55990w = false;
                ImmVideoItemView.this.setContentVisibility(true);
                AppCompatTextView appCompatTextView = ImmVideoItemView.this.f55970b.f77978x;
                Intrinsics.f(appCompatTextView, "viewBinding.tvProgressDes");
                so.c.g(appCompatTextView);
                AppCompatSeekBar appCompatSeekBar = ImmVideoItemView.this.f55970b.f77973s;
                Intrinsics.f(appCompatSeekBar, "viewBinding.seekBar");
                so.c.g(appCompatSeekBar);
                ProgressBar progressBar = ImmVideoItemView.this.f55970b.f77971q;
                Intrinsics.f(progressBar, "viewBinding.progressBar");
                so.c.k(progressBar);
                long progress = ImmVideoItemView.this.f55970b.f77971q.getProgress();
                ImmVideoItemView immVideoItemView = ImmVideoItemView.this;
                if (immVideoItemView.G.compareAndSet(true, false)) {
                    com.transsion.player.orplayer.f fVar2 = ImmVideoItemView.this.f55980m;
                    if (fVar2 != null) {
                        fVar2.seekTo(progress);
                    }
                    progress = 0;
                }
                immVideoItemView.H = progress;
                com.transsion.player.orplayer.f fVar3 = ImmVideoItemView.this.f55980m;
                if (fVar3 == null || fVar3.isPlaying() || (fVar = ImmVideoItemView.this.f55980m) == null) {
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
    public static final class d implements com.transsion.share.share.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f56002a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ImmVideoItemView f56003b;

        /* JADX INFO: compiled from: source.java */
        @Metadata
        @SourceDebugExtension
        public static final class a implements PostConfirmDialog.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ ImmVideoItemView f56004a;

            public a(ImmVideoItemView immVideoItemView) {
                this.f56004a = immVideoItemView;
            }

            @Override // com.transsion.postdetail.ui.dialog.PostConfirmDialog.a
            public void a() {
                String postId;
                PostDetailViewModel postDetailViewModel;
                PostSubjectItem postSubjectItem = this.f56004a.f55974g;
                if (postSubjectItem == null || (postId = postSubjectItem.getPostId()) == null || (postDetailViewModel = this.f56004a.f55971c) == null) {
                    return;
                }
                postDetailViewModel.h(postId);
            }
        }

        public d(View view, ImmVideoItemView immVideoItemView) {
            this.f56002a = view;
            this.f56003b = immVideoItemView;
        }

        @Override // com.transsion.share.share.e
        public void a(String id2, PostType postType) {
            Fragment fragment;
            FragmentManager childFragmentManager;
            Intrinsics.g(id2, "id");
            PostConfirmDialog postConfirmDialog = new PostConfirmDialog();
            postConfirmDialog.q0(new a(this.f56003b));
            Fragment fragment2 = this.f56003b.f55975h;
            if (fragment2 == null || !fragment2.isAdded() || (fragment = this.f56003b.f55975h) == null || (childFragmentManager = fragment.getChildFragmentManager()) == null) {
                return;
            }
            childFragmentManager.executePendingTransactions();
            if (postConfirmDialog.isAdded() || childFragmentManager.findFragmentByTag("PostConfirmDialog") != null) {
                return;
            }
            postConfirmDialog.show(childFragmentManager, "PostConfirmDialog");
        }

        @Override // com.transsion.share.share.e
        public void b(String str) {
            this.f56003b.i(str);
        }

        @Override // com.transsion.share.share.e
        public void c(String url, String fileName, String fileSize, String fileImage) {
            Subject subject;
            ResourceDetectors resourceDetector;
            String resourceLink;
            Media media;
            Cover cover;
            Integer size;
            Media media2;
            Cover cover2;
            String url2;
            String url3;
            String url4;
            Media media3;
            Intrinsics.g(url, "url");
            Intrinsics.g(fileName, "fileName");
            Intrinsics.g(fileSize, "fileSize");
            Intrinsics.g(fileImage, "fileImage");
            if (com.transsion.baseui.util.c.f51452a.a(this.f56002a.getId(), 500L)) {
                return;
            }
            PostSubjectItem postSubjectItem = this.f56003b.f55974g;
            Video videoA = com.transsion.postdetail.util.l.a((postSubjectItem == null || (media3 = postSubjectItem.getMedia()) == null) ? null : media3.getVideo());
            PostSubjectItem postSubjectItem2 = this.f56003b.f55974g;
            String title = postSubjectItem2 != null ? postSubjectItem2.getTitle() : null;
            if (TextUtils.isEmpty(title)) {
                PostSubjectItem postSubjectItem3 = this.f56003b.f55974g;
                title = postSubjectItem3 != null ? postSubjectItem3.getContent() : null;
            }
            String str = title;
            String str2 = (videoA == null || (url4 = videoA.getUrl()) == null) ? "" : url4;
            String str3 = (videoA == null || (url3 = videoA.getUrl()) == null) ? "" : url3;
            PostSubjectItem postSubjectItem4 = this.f56003b.f55974g;
            String str4 = (postSubjectItem4 == null || (media2 = postSubjectItem4.getMedia()) == null || (cover2 = media2.getCover()) == null || (url2 = cover2.getUrl()) == null) ? "" : url2;
            Long lValueOf = (videoA == null || (size = videoA.getSize()) == null) ? null : Long.valueOf(size.intValue());
            PostSubjectItem postSubjectItem5 = this.f56003b.f55974g;
            String postId = postSubjectItem5 != null ? postSubjectItem5.getPostId() : null;
            PostSubjectItem postSubjectItem6 = this.f56003b.f55974g;
            DownloadBean downloadBean = new DownloadBean(str2, str3, str, str4, lValueOf, postSubjectItem6 != null ? postSubjectItem6.getPostId() : null, null, null, null, null, 0L, 0, 0, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, postId, null, null, null, 0L, 0, 0, null, null, 0L, null, null, 0L, 0, 0L, null, 0, null, null, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -134217792, 1073741823, null);
            PostSubjectItem postSubjectItem7 = this.f56003b.f55974g;
            downloadBean.setThumbnail((postSubjectItem7 == null || (media = postSubjectItem7.getMedia()) == null || (cover = media.getCover()) == null) ? null : cover.getThumbnail());
            PostSubjectItem postSubjectItem8 = this.f56003b.f55974g;
            if (postSubjectItem8 == null || !postSubjectItem8.getBuiltIn()) {
                DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
                Context context = this.f56003b.getContext();
                Intrinsics.e(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentActivity fragmentActivity = (FragmentActivity) context;
                PostSubjectItem postSubjectItem9 = this.f56003b.f55974g;
                String ops = postSubjectItem9 != null ? postSubjectItem9.getOps() : null;
                PostSubjectItem postSubjectItem10 = this.f56003b.f55974g;
                DownloadManagerApi.U1(downloadManagerApiA, fragmentActivity, downloadBean, "postdetail_video", ops, (postSubjectItem10 == null || (subject = postSubjectItem10.getSubject()) == null || (resourceDetector = subject.getResourceDetector()) == null || (resourceLink = resourceDetector.getResourceLink()) == null) ? "" : resourceLink, null, null, 96, null);
            } else {
                this.f56003b.y(downloadBean);
            }
            com.transsion.postdetail.helper.a.f55063a.h(this.f56003b.f55974g, "postdetail_video", this.f56003b.F);
        }

        @Override // com.transsion.share.share.e
        public void d(String id2) {
            Intrinsics.g(id2, "id");
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class e implements CommentFragment.b {
        public e() {
        }

        @Override // com.transsion.postdetail.ui.fragment.CommentFragment.b
        public void a(long j11) {
            PostSubjectItem postSubjectItem = ImmVideoItemView.this.f55974g;
            Stat stat = postSubjectItem != null ? postSubjectItem.getStat() : null;
            if (stat != null) {
                stat.setCommentCount(Long.valueOf(j11));
            }
            ImmVideoItemView.this.B(j11);
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class f implements ExpandView.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.BooleanRef f56006a;

        public f(Ref.BooleanRef booleanRef) {
            this.f56006a = booleanRef;
        }

        @Override // com.tn.lib.view.expand.ExpandView.c
        public void a(ExpandView expandView) {
            this.f56006a.element = true;
        }

        @Override // com.tn.lib.view.expand.ExpandView.c
        public void b(ExpandView expandView) {
            this.f56006a.element = false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class g implements com.transsion.baseui.util.g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<List<UrlContent>> f56007a;

        public g(Ref.ObjectRef<List<UrlContent>> objectRef) {
            this.f56007a = objectRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.transsion.baseui.util.g
        public void a(List<UrlContent> list) {
            Intrinsics.g(list, "list");
            this.f56007a.element = list;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImmVideoItemView(Context context) {
        this(context, null);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ImmVideoItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.g(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImmVideoItemView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        this.f55969a = "ImmVideoPlayer";
        this.f55979l = "";
        this.f55986s = LazyKt__LazyJVMKt.b(new Function0<ILoginApi>() { // from class: com.transsion.postdetail.ui.view.ImmVideoItemView$loginApi$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ILoginApi invoke() {
                return (ILoginApi) com.alibaba.android.arouter.launcher.a.d().h(ILoginApi.class);
            }
        });
        this.D = com.blankj.utilcode.util.d0.c();
        this.E = com.blankj.utilcode.util.f0.a(170.0f);
        this.G = new AtomicBoolean(true);
        this.I = true;
        this.K = new androidx.lifecycle.d0() { // from class: com.transsion.postdetail.ui.view.b
            @Override // androidx.lifecycle.d0
            public final void onChanged(Object obj) {
                ImmVideoItemView.g(this.f56126a, (String) obj);
            }
        };
        View.inflate(getContext(), R$layout.layout_immersion_video_item_view, this);
        tv.v vVarA = tv.v.a(this);
        Intrinsics.f(vVarA, "bind(this)");
        this.f55970b = vVarA;
        vVarA.f77977w.setOnClickListener(this);
        vVarA.f77975u.setOnClickListener(this);
        vVarA.f77965k.setOnClickListener(this);
        vVarA.f77967m.setOnClickListener(this);
        vVarA.f77968n.f77692b.setOnClickListener(this);
        vVarA.f77968n.f77696g.setOnClickListener(this);
        vVarA.f77979y.setOnClickListener(this);
        vVarA.f77963i.setOnClickListener(this);
        vVarA.f77966l.setOnClickListener(this);
        vVarA.f77980z.setOnClickListener(this);
        this.f55993z = com.blankj.utilcode.util.f0.a(48.0f);
        this.A = com.blankj.utilcode.util.f0.a(64.0f);
        this.B = com.blankj.utilcode.util.f0.a(24.0f);
        this.C = com.blankj.utilcode.util.f0.a(32.0f);
        j(context);
        if (ImmVideoHelper.f55024g.a().f() > 0) {
            ViewGroup.LayoutParams layoutParams = vVarA.f77972r.getLayoutParams();
            Intrinsics.e(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
            if (((ViewGroup.MarginLayoutParams) bVar).bottomMargin < com.blankj.utilcode.util.f0.a(35.0f)) {
                ((ViewGroup.MarginLayoutParams) bVar).bottomMargin += com.blankj.utilcode.util.f0.a(10.0f);
                vVarA.f77972r.setLayoutParams(bVar);
            }
        }
    }

    public static final ShortTvPlayListViewModel A(Lazy<ShortTvPlayListViewModel> lazy) {
        return lazy.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void B(long j11) {
        this.f55970b.f77975u.setText(com.transsion.baseui.util.j.a(j11));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void E(ImmVideoItemView this$0, Ref.ObjectRef favoriteInfo, View view) {
        Subject subject;
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(favoriteInfo, "$favoriteInfo");
        com.transsion.postdetail.shorttv.o oVar = com.transsion.postdetail.shorttv.o.f55416a;
        PostSubjectItem postSubjectItem = this$0.f55974g;
        oVar.e((postSubjectItem == null || (subject = postSubjectItem.getSubject()) == null) ? null : subject.getSubjectId(), "", ((ShortTVFavInfo) favoriteInfo.element).getHasFavorite(), "postdetail_video", this$0.F);
        ShortTvPlayListViewModel shortTvPlayListViewModel = this$0.f55972d;
        if (shortTvPlayListViewModel != null) {
            PostSubjectItem postSubjectItem2 = this$0.f55974g;
            shortTvPlayListViewModel.d(postSubjectItem2 != null ? postSubjectItem2.getSubject() : null);
        }
    }

    public static final void g(ImmVideoItemView this$0, String str) {
        Intrinsics.g(this$0, "this$0");
        this$0.h(str);
    }

    private final ILoginApi getLoginApi() {
        return (ILoginApi) this.f55986s.getValue();
    }

    public static final boolean l(View view, MotionEvent motionEvent) {
        return true;
    }

    private final void setBottomRoomModuleData(PostSubjectItem postSubjectItem) {
        String str;
        Cover cover;
        AppCompatTextView appCompatTextView = this.f55970b.f77968n.f77697h;
        Group group = postSubjectItem.getGroup();
        String url = null;
        appCompatTextView.setText(group != null ? group.getName() : null);
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context context = getContext();
        Intrinsics.f(context, "context");
        ShapeableImageView shapeableImageView = this.f55970b.f77968n.f77693c;
        Intrinsics.f(shapeableImageView, "viewBinding.layoutSubjectRoom.ivRoomCover");
        Group group2 = postSubjectItem.getGroup();
        if (group2 == null || (avatar = group2.getAvatar()) == null) {
            Group group3 = postSubjectItem.getGroup();
            if (group3 != null && (cover = group3.getCover()) != null) {
                url = cover.getUrl();
            }
            if (url == null) {
                String avatar = "";
                str = avatar;
            } else {
                str = url;
            }
        } else {
            str = avatar;
        }
        companion.r(context, shapeableImageView, str, (4088 & 8) != 0 ? companion.d() : gs.a.a(32), (4088 & 16) != 0 ? companion.c() : gs.a.a(32), (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
    }

    private final void setBottomSubjectAndRoomVisibility(boolean z11, boolean z12) {
        if (z11) {
            BLLinearLayout root = this.f55970b.f77968n.getRoot();
            Intrinsics.f(root, "viewBinding.layoutSubjectRoom.root");
            so.c.k(root);
            ConstraintLayout constraintLayout = this.f55970b.f77968n.f77692b;
            Intrinsics.f(constraintLayout, "viewBinding.layoutSubjectRoom.clSubjectContent");
            so.c.k(constraintLayout);
            View view = this.f55970b.f77968n.f77703n;
            Intrinsics.f(view, "viewBinding.layoutSubjectRoom.vSubjectRoomLine");
            view.setVisibility(z12 ? 0 : 8);
            LinearLayout linearLayout = this.f55970b.f77968n.f77696g;
            Intrinsics.f(linearLayout, "viewBinding.layoutSubjectRoom.llRoomTag");
            linearLayout.setVisibility(z12 ? 0 : 8);
            return;
        }
        BLLinearLayout root2 = this.f55970b.f77968n.getRoot();
        Intrinsics.f(root2, "viewBinding.layoutSubjectRoom.root");
        root2.setVisibility(z12 ? 0 : 8);
        ConstraintLayout constraintLayout2 = this.f55970b.f77968n.f77692b;
        Intrinsics.f(constraintLayout2, "viewBinding.layoutSubjectRoom.clSubjectContent");
        so.c.g(constraintLayout2);
        View view2 = this.f55970b.f77968n.f77703n;
        Intrinsics.f(view2, "viewBinding.layoutSubjectRoom.vSubjectRoomLine");
        so.c.g(view2);
        LinearLayout linearLayout2 = this.f55970b.f77968n.f77696g;
        Intrinsics.f(linearLayout2, "viewBinding.layoutSubjectRoom.llRoomTag");
        linearLayout2.setVisibility(z12 ? 0 : 8);
    }

    private final void setBottomSubjectModuleData(PostSubjectItem postSubjectItem) {
        String url;
        String title;
        String str;
        Subject subject;
        String genre;
        List listE0;
        Cover cover;
        String thumbnail;
        Cover cover2;
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context context = getContext();
        Intrinsics.f(context, "context");
        ShapeableImageView shapeableImageView = this.f55970b.f77968n.f77694d;
        Intrinsics.f(shapeableImageView, "viewBinding.layoutSubjectRoom.ivSubjectCover");
        Subject subject2 = postSubjectItem.getSubject();
        if (subject2 == null || (cover2 = subject2.getCover()) == null || (url = cover2.getUrl()) == null) {
            url = "";
        }
        int iA = gs.a.a(32);
        int iA2 = gs.a.a(32);
        Subject subject3 = postSubjectItem.getSubject();
        companion.q(context, shapeableImageView, url, (8120 & 8) != 0 ? companion.d() : iA, (8120 & 16) != 0 ? companion.c() : iA2, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : (subject3 == null || (cover = subject3.getCover()) == null || (thumbnail = cover.getThumbnail()) == null) ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
        AppCompatTextView appCompatTextView = this.f55970b.f77968n.f77700k;
        Subject subject4 = postSubjectItem.getSubject();
        if (subject4 == null || (title = subject4.getTitle()) == null) {
            title = "";
        }
        appCompatTextView.setText(title);
        Subject subject5 = postSubjectItem.getSubject();
        this.f55970b.f77968n.f77695f.setImageResource(com.transsion.moviedetailapi.a.a(subject5 != null ? subject5.getSubjectType() : null));
        Subject subject6 = postSubjectItem.getSubject();
        Date dateK = com.blankj.utilcode.util.h0.k(subject6 != null ? subject6.getReleaseDate() : null, "yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateK);
        this.f55970b.f77968n.f77698i.setText(String.valueOf(calendar.get(1)));
        Subject subject7 = postSubjectItem.getSubject();
        String genre2 = subject7 != null ? subject7.getGenre() : null;
        if (genre2 == null || genre2.length() == 0 || (subject = postSubjectItem.getSubject()) == null || (genre = subject.getGenre()) == null || (listE0 = StringsKt__StringsKt.E0(genre, new String[]{", "}, false, 0, 6, null)) == null || (str = (String) CollectionsKt___CollectionsKt.g0(listE0)) == null) {
            str = "";
        }
        AppCompatTextView appCompatTextView2 = this.f55970b.f77968n.f77699j;
        Intrinsics.f(appCompatTextView2, "viewBinding.layoutSubjectRoom.tvSubjectGenre");
        appCompatTextView2.setVisibility(str.length() > 0 ? 0 : 8);
        AppCompatTextView appCompatTextView3 = this.f55970b.f77968n.f77699j;
        Intrinsics.f(appCompatTextView3, "viewBinding.layoutSubjectRoom.tvSubjectGenre");
        appCompatTextView3.setVisibility(str.length() > 0 ? 0 : 8);
        this.f55970b.f77968n.f77699j.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:14:0x0060  */
    /* JADX WARN: Code duplicated, block: B:26:0x00fc  */
    public final void setContentVisibility(boolean z11) {
        Subject subject;
        Subject subject2;
        if (z11) {
            PostSubjectItem postSubjectItem = this.f55974g;
            if (postSubjectItem == null || (subject2 = postSubjectItem.getSubject()) == null) {
                ShapeableImageView shapeableImageView = this.f55970b.f77967m;
                Intrinsics.f(shapeableImageView, "viewBinding.ivVideoAvatar");
                so.c.k(shapeableImageView);
                BLLinearLayout root = this.f55970b.f77968n.getRoot();
                Intrinsics.f(root, "viewBinding.layoutSubjectRoom.root");
                so.c.k(root);
                NestedScrollableHost nestedScrollableHost = this.f55970b.f77970p;
                Intrinsics.f(nestedScrollableHost, "viewBinding.nsPostDes");
                so.c.k(nestedScrollableHost);
            } else {
                Integer subjectType = subject2.getSubjectType();
                int value = SubjectType.SHORT_TV.getValue();
                if (subjectType != null && subjectType.intValue() == value) {
                    BLTextView bLTextView = this.f55970b.f77979y;
                    Intrinsics.f(bLTextView, "viewBinding.tvShortTvEp");
                    so.c.k(bLTextView);
                    AppCompatTextView appCompatTextView = this.f55970b.f77980z;
                    Intrinsics.f(appCompatTextView, "viewBinding.tvTitle");
                    so.c.k(appCompatTextView);
                    AppCompatImageView appCompatImageView = this.f55970b.f77963i;
                    Intrinsics.f(appCompatImageView, "viewBinding.ivDownload");
                    so.c.k(appCompatImageView);
                    ShapeableImageView shapeableImageView2 = this.f55970b.f77966l;
                    Intrinsics.f(shapeableImageView2, "viewBinding.ivShortCover");
                    so.c.k(shapeableImageView2);
                } else {
                    ShapeableImageView shapeableImageView3 = this.f55970b.f77967m;
                    Intrinsics.f(shapeableImageView3, "viewBinding.ivVideoAvatar");
                    so.c.k(shapeableImageView3);
                    BLLinearLayout root2 = this.f55970b.f77968n.getRoot();
                    Intrinsics.f(root2, "viewBinding.layoutSubjectRoom.root");
                    so.c.k(root2);
                    NestedScrollableHost nestedScrollableHost2 = this.f55970b.f77970p;
                    Intrinsics.f(nestedScrollableHost2, "viewBinding.nsPostDes");
                    so.c.k(nestedScrollableHost2);
                }
            }
            ProgressBar progressBar = this.f55970b.f77971q;
            Intrinsics.f(progressBar, "viewBinding.progressBar");
            so.c.k(progressBar);
            AppCompatTextView appCompatTextView2 = this.f55970b.f77977w;
            Intrinsics.f(appCompatTextView2, "viewBinding.tvLike");
            so.c.k(appCompatTextView2);
            AppCompatImageView appCompatImageView2 = this.f55970b.f77965k;
            Intrinsics.f(appCompatImageView2, "viewBinding.ivShare");
            so.c.k(appCompatImageView2);
            AppCompatTextView appCompatTextView3 = this.f55970b.f77975u;
            Intrinsics.f(appCompatTextView3, "viewBinding.tvComment");
            so.c.k(appCompatTextView3);
            AppCompatTextView appCompatTextView4 = this.f55970b.f77976v;
            Intrinsics.f(appCompatTextView4, "viewBinding.tvFavorite");
            so.c.k(appCompatTextView4);
            return;
        }
        PostSubjectItem postSubjectItem2 = this.f55974g;
        if (postSubjectItem2 == null || (subject = postSubjectItem2.getSubject()) == null) {
            ShapeableImageView shapeableImageView4 = this.f55970b.f77967m;
            Intrinsics.f(shapeableImageView4, "viewBinding.ivVideoAvatar");
            so.c.h(shapeableImageView4);
            BLLinearLayout root3 = this.f55970b.f77968n.getRoot();
            Intrinsics.f(root3, "viewBinding.layoutSubjectRoom.root");
            so.c.h(root3);
            NestedScrollableHost nestedScrollableHost3 = this.f55970b.f77970p;
            Intrinsics.f(nestedScrollableHost3, "viewBinding.nsPostDes");
            so.c.h(nestedScrollableHost3);
        } else {
            Integer subjectType2 = subject.getSubjectType();
            int value2 = SubjectType.SHORT_TV.getValue();
            if (subjectType2 != null && subjectType2.intValue() == value2) {
                BLTextView bLTextView2 = this.f55970b.f77979y;
                Intrinsics.f(bLTextView2, "viewBinding.tvShortTvEp");
                so.c.h(bLTextView2);
                AppCompatTextView appCompatTextView5 = this.f55970b.f77980z;
                Intrinsics.f(appCompatTextView5, "viewBinding.tvTitle");
                so.c.h(appCompatTextView5);
                AppCompatImageView appCompatImageView3 = this.f55970b.f77963i;
                Intrinsics.f(appCompatImageView3, "viewBinding.ivDownload");
                so.c.h(appCompatImageView3);
                ShapeableImageView shapeableImageView5 = this.f55970b.f77966l;
                Intrinsics.f(shapeableImageView5, "viewBinding.ivShortCover");
                so.c.h(shapeableImageView5);
            } else {
                ShapeableImageView shapeableImageView6 = this.f55970b.f77967m;
                Intrinsics.f(shapeableImageView6, "viewBinding.ivVideoAvatar");
                so.c.h(shapeableImageView6);
                BLLinearLayout root4 = this.f55970b.f77968n.getRoot();
                Intrinsics.f(root4, "viewBinding.layoutSubjectRoom.root");
                so.c.h(root4);
                NestedScrollableHost nestedScrollableHost4 = this.f55970b.f77970p;
                Intrinsics.f(nestedScrollableHost4, "viewBinding.nsPostDes");
                so.c.h(nestedScrollableHost4);
            }
        }
        ProgressBar progressBar2 = this.f55970b.f77971q;
        Intrinsics.f(progressBar2, "viewBinding.progressBar");
        so.c.h(progressBar2);
        AppCompatTextView appCompatTextView6 = this.f55970b.f77977w;
        Intrinsics.f(appCompatTextView6, "viewBinding.tvLike");
        so.c.h(appCompatTextView6);
        AppCompatImageView appCompatImageView4 = this.f55970b.f77965k;
        Intrinsics.f(appCompatImageView4, "viewBinding.ivShare");
        so.c.h(appCompatImageView4);
        AppCompatTextView appCompatTextView7 = this.f55970b.f77975u;
        Intrinsics.f(appCompatTextView7, "viewBinding.tvComment");
        so.c.h(appCompatTextView7);
        AppCompatTextView appCompatTextView8 = this.f55970b.f77976v;
        Intrinsics.f(appCompatTextView8, "viewBinding.tvFavorite");
        so.c.h(appCompatTextView8);
    }

    private final void setLoading(boolean z11) {
        if (z11) {
            ClipLoading clipLoading = this.f55970b.f77959d;
            Intrinsics.f(clipLoading, "viewBinding.clLoading");
            so.c.k(clipLoading);
            ProgressBar progressBar = this.f55970b.f77971q;
            Intrinsics.f(progressBar, "viewBinding.progressBar");
            so.c.g(progressBar);
            this.f55970b.f77959d.start();
            return;
        }
        ProgressBar progressBar2 = this.f55970b.f77971q;
        Intrinsics.f(progressBar2, "viewBinding.progressBar");
        so.c.k(progressBar2);
        ClipLoading clipLoading2 = this.f55970b.f77959d;
        Intrinsics.f(clipLoading2, "viewBinding.clLoading");
        so.c.g(clipLoading2);
        this.f55970b.f77959d.stop();
    }

    public static final void u(ImmVideoItemView this$0) {
        Intrinsics.g(this$0, "this$0");
        ImmVideoGuideView immVideoGuideView = this$0.f55984q;
        if (immVideoGuideView != null) {
            immVideoGuideView.removeGuide();
        }
    }

    public static final void x(ImmVideoItemView this$0) {
        com.transsion.player.orplayer.f fVar;
        Intrinsics.g(this$0, "this$0");
        Fragment fragment = this$0.f55975h;
        if (fragment == null || !fragment.isVisible() || (fVar = this$0.f55980m) == null) {
            return;
        }
        fVar.play();
    }

    public static final PostDetailViewModel z(Lazy<PostDetailViewModel> lazy) {
        return lazy.getValue();
    }

    public final void C(PostSubjectItem postSubjectItem) {
        Long likeCount;
        AppCompatTextView appCompatTextView = this.f55970b.f77977w;
        Boolean hasLike = postSubjectItem.getHasLike();
        appCompatTextView.setSelected(hasLike != null ? hasLike.booleanValue() : false);
        Stat stat = postSubjectItem.getStat();
        String strA = com.transsion.baseui.util.j.a((stat == null || (likeCount = stat.getLikeCount()) == null) ? 0L : likeCount.longValue());
        if (Intrinsics.b(strA, "0")) {
            strA = "";
        }
        appCompatTextView.setText(strA);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v36, types: [T, com.transsion.moviedetailapi.bean.ShortTVFavInfo] */
    public final void D() {
        Subject subject;
        Subject subject2;
        Cover cover;
        String url;
        String thumbnail;
        Subject subject3;
        Cover cover2;
        Subject subject4;
        Subject subject5;
        Subject subject6;
        ShortTVItem shortTVFirstEp;
        Subject subject7;
        PostSubjectItem postSubjectItem = this.f55974g;
        if (postSubjectItem != null && (subject = postSubjectItem.getSubject()) != null) {
            Integer subjectType = subject.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                BLLinearLayout root = this.f55970b.f77968n.getRoot();
                Intrinsics.f(root, "viewBinding.layoutSubjectRoom.root");
                so.c.g(root);
                ShapeableImageView shapeableImageView = this.f55970b.f77967m;
                Intrinsics.f(shapeableImageView, "viewBinding.ivVideoAvatar");
                so.c.g(shapeableImageView);
                AppCompatImageView appCompatImageView = this.f55970b.f77963i;
                Intrinsics.f(appCompatImageView, "viewBinding.ivDownload");
                so.c.k(appCompatImageView);
                AppCompatTextView appCompatTextView = this.f55970b.f77980z;
                Intrinsics.f(appCompatTextView, "viewBinding.tvTitle");
                so.c.k(appCompatTextView);
                BLTextView bLTextView = this.f55970b.f77979y;
                Intrinsics.f(bLTextView, "viewBinding.tvShortTvEp");
                so.c.k(bLTextView);
                ShapeableImageView shapeableImageView2 = this.f55970b.f77966l;
                Intrinsics.f(shapeableImageView2, "viewBinding.ivShortCover");
                so.c.k(shapeableImageView2);
                AppCompatTextView appCompatTextView2 = this.f55970b.f77980z;
                PostSubjectItem postSubjectItem2 = this.f55974g;
                appCompatTextView2.setText((postSubjectItem2 == null || (subject7 = postSubjectItem2.getSubject()) == null) ? null : subject7.getTitle());
                com.transsion.postdetail.util.k kVar = com.transsion.postdetail.util.k.f56221a;
                PostSubjectItem postSubjectItem3 = this.f55974g;
                kVar.a(Integer.valueOf((postSubjectItem3 == null || (subject6 = postSubjectItem3.getSubject()) == null || (shortTVFirstEp = subject6.getShortTVFirstEp()) == null) ? 1 : shortTVFirstEp.getEp()));
                PostSubjectItem postSubjectItem4 = this.f55974g;
                this.f55970b.f77979y.setText(getContext().getString(R$string.short_tv_play_all, kVar.a(Integer.valueOf((postSubjectItem4 == null || (subject5 = postSubjectItem4.getSubject()) == null) ? 0 : subject5.getTotalEpisode()))));
                com.transsion.baseui.widget.jumpingbeans.a.a(this.f55970b.f77979y).e(0, this.f55970b.f77979y.getText().toString().length()).g(true).i(100).f(0.05f).h(10000).a();
                ShapeableImageView shapeableImageView3 = this.f55970b.f77966l;
                PostSubjectItem postSubjectItem5 = this.f55974g;
                if (postSubjectItem5 == null || !postSubjectItem5.getBuiltIn()) {
                    PostSubjectItem postSubjectItem6 = this.f55974g;
                    if (postSubjectItem6 != null && (subject2 = postSubjectItem6.getSubject()) != null && (cover = subject2.getCover()) != null && (url = cover.getUrl()) != null) {
                        ImageHelper.Companion companion = ImageHelper.f51371a;
                        Context context = getContext();
                        Intrinsics.f(context, "context");
                        ShapeableImageView shapeableImageView4 = this.f55970b.f77966l;
                        Intrinsics.f(shapeableImageView4, "viewBinding.ivShortCover");
                        int iE = com.blankj.utilcode.util.i.e(21.0f);
                        int iE2 = com.blankj.utilcode.util.i.e(30.0f);
                        PostSubjectItem postSubjectItem7 = this.f55974g;
                        if (postSubjectItem7 == null || (subject3 = postSubjectItem7.getSubject()) == null || (cover2 = subject3.getCover()) == null || (thumbnail = cover2.getThumbnail()) == null) {
                            thumbnail = "";
                        }
                        companion.q(context, shapeableImageView4, url, (8120 & 8) != 0 ? companion.d() : iE, (8120 & 16) != 0 ? companion.c() : iE2, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : true, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
                    }
                } else {
                    kotlinx.coroutines.j.d(kotlinx.coroutines.l0.a(w0.c()), null, null, new ImmVideoItemView$updateShortTVInfo$1(this, null), 3, null);
                }
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                PostSubjectItem postSubjectItem8 = this.f55974g;
                T shortTVFavInfo = (postSubjectItem8 == null || (subject4 = postSubjectItem8.getSubject()) == null) ? 0 : subject4.getShortTVFavInfo();
                objectRef.element = shortTVFavInfo;
                if (shortTVFavInfo == 0) {
                    ?? shortTVFavInfo2 = new ShortTVFavInfo(null, false, null, 7, null);
                    shortTVFavInfo2.setFavoriteNum("0");
                    objectRef.element = shortTVFavInfo2;
                    PostSubjectItem postSubjectItem9 = this.f55974g;
                    Subject subject8 = postSubjectItem9 != null ? postSubjectItem9.getSubject() : null;
                    if (subject8 != null) {
                        subject8.setShortTVFavInfo((ShortTVFavInfo) objectRef.element);
                    }
                }
                AppCompatTextView appCompatTextView3 = this.f55970b.f77976v;
                Intrinsics.f(appCompatTextView3, "viewBinding.tvFavorite");
                so.c.k(appCompatTextView3);
                this.f55970b.f77976v.setSelected(((ShortTVFavInfo) objectRef.element).getHasFavorite());
                AppCompatTextView appCompatTextView4 = this.f55970b.f77976v;
                String favoriteNum = ((ShortTVFavInfo) objectRef.element).getFavoriteNum();
                appCompatTextView4.setText(com.transsion.baseui.util.j.a(Long.parseLong(favoriteNum != null ? favoriteNum : "0")));
                this.f55970b.f77976v.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.ui.view.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ImmVideoItemView.E(this.f56132a, objectRef, view);
                    }
                });
                return;
            }
        }
        AppCompatTextView appCompatTextView5 = this.f55970b.f77980z;
        Intrinsics.f(appCompatTextView5, "viewBinding.tvTitle");
        so.c.g(appCompatTextView5);
        BLTextView bLTextView2 = this.f55970b.f77979y;
        Intrinsics.f(bLTextView2, "viewBinding.tvShortTvEp");
        so.c.g(bLTextView2);
        ShapeableImageView shapeableImageView5 = this.f55970b.f77966l;
        Intrinsics.f(shapeableImageView5, "viewBinding.ivShortCover");
        so.c.g(shapeableImageView5);
        AppCompatImageView appCompatImageView2 = this.f55970b.f77963i;
        Intrinsics.f(appCompatImageView2, "viewBinding.ivDownload");
        so.c.g(appCompatImageView2);
        ShapeableImageView shapeableImageView6 = this.f55970b.f77967m;
        Intrinsics.f(shapeableImageView6, "viewBinding.ivVideoAvatar");
        so.c.k(shapeableImageView6);
        AppCompatTextView appCompatTextView6 = this.f55970b.f77976v;
        Intrinsics.f(appCompatTextView6, "viewBinding.tvFavorite");
        so.c.g(appCompatTextView6);
    }

    public final void F(PostSubjectItem postSubjectItem) {
        setBottomSubjectAndRoomVisibility(postSubjectItem.getSubject() != null, postSubjectItem.getGroup() != null);
        if (postSubjectItem.getSubject() != null) {
            setBottomSubjectModuleData(postSubjectItem);
        }
        if (postSubjectItem.getGroup() != null) {
            Group group = postSubjectItem.getGroup();
            String name = group != null ? group.getName() : null;
            if (name == null || name.length() == 0) {
                return;
            }
            setBottomRoomModuleData(postSubjectItem);
        }
    }

    /* JADX WARN: Code duplicated, block: B:45:0x016e  */
    /* JADX WARN: Code duplicated, block: B:73:0x01e6  */
    public final void G(final PostSubjectItem postSubjectItem) {
        String avatar;
        FirstFrame firstFrame;
        String url;
        String string;
        String description;
        Subject subject;
        Subject subject2;
        FirstFrame firstFrame2;
        if (postSubjectItem.getBuiltIn()) {
            kotlinx.coroutines.j.d(kotlinx.coroutines.l0.a(w0.c()), null, null, new ImmVideoItemView$updateVideoInfo$1(postSubjectItem, this, null), 3, null);
            kotlinx.coroutines.j.d(kotlinx.coroutines.l0.a(w0.c()), null, null, new ImmVideoItemView$updateVideoInfo$2(postSubjectItem, this, null), 3, null);
            uo.b.a aVar = uo.b.f78622a;
            String str = this.f55969a;
            Media media = postSubjectItem.getMedia();
            String url2 = (media == null || (firstFrame2 = media.getFirstFrame()) == null) ? null : firstFrame2.getUrl();
            User user = postSubjectItem.getUser();
            uo.b.a.f(aVar, str, "set info - firstFrame = " + url2 + ", avatar = " + (user != null ? user.getAvatar() : null), false, 4, null);
        } else {
            Media media2 = postSubjectItem.getMedia();
            if (media2 != null && (firstFrame = media2.getFirstFrame()) != null && (url = firstFrame.getUrl()) != null) {
                ImageHelper.Companion companion = ImageHelper.f51371a;
                ListVideoPreloadHelper.a aVar2 = ListVideoPreloadHelper.f53890f;
                Glide.with(getContext()).load2(companion.e(url, (124 & 2) != 0 ? 0 : aVar2.a(), (124 & 4) != 0 ? 0 : aVar2.a(), (124 & 8) != 0, (124 & 16) != 0 ? false : false, (124 & 32) == 0 ? false : false, (124 & 64) != 0 ? 25 : 0)).into(this.f55970b.f77962h);
            }
            ImageHelper.Companion companion2 = ImageHelper.f51371a;
            Context context = getContext();
            Intrinsics.f(context, "context");
            ShapeableImageView shapeableImageView = this.f55970b.f77967m;
            Intrinsics.f(shapeableImageView, "viewBinding.ivVideoAvatar");
            User user2 = postSubjectItem.getUser();
            if (user2 == null || (avatar = user2.getAvatar()) == null) {
                avatar = "";
            }
            companion2.r(context, shapeableImageView, avatar, (4088 & 8) != 0 ? companion2.d() : this.f55970b.f77967m.getWidth(), (4088 & 16) != 0 ? companion2.c() : this.f55970b.f77967m.getHeight(), (4088 & 32) != 0, (4088 & 64) != 0, (4088 & 128) != 0, (4088 & 256) != 0 ? false : false, (4088 & 512) != 0 ? false : false, (4088 & 1024) != 0 ? false : false, (4088 & 2048) != 0 ? 25 : 0);
        }
        PostSubjectItem postSubjectItem2 = this.f55974g;
        if (postSubjectItem2 != null && (subject2 = postSubjectItem2.getSubject()) != null) {
            Integer subjectType = subject2.getSubjectType();
            int value = SubjectType.SHORT_TV.getValue();
            if (subjectType != null && subjectType.intValue() == value) {
                this.f55970b.f77980z.setTextSize(18.0f);
                NestedScrollableHost nestedScrollableHost = this.f55970b.f77970p;
                Intrinsics.f(nestedScrollableHost, "viewBinding.nsPostDes");
                so.c.g(nestedScrollableHost);
                return;
            }
        }
        NestedScrollableHost nestedScrollableHost2 = this.f55970b.f77970p;
        Intrinsics.f(nestedScrollableHost2, "viewBinding.nsPostDes");
        so.c.k(nestedScrollableHost2);
        this.f55970b.f77980z.setTextSize(16.0f);
        final ExpandView updateVideoInfo$lambda$7 = this.f55970b.f77960f;
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        updateVideoInfo$lambda$7.setExpandListener(new f(booleanRef));
        if (TextUtils.isEmpty(postSubjectItem.getTitle())) {
            String content = postSubjectItem.getContent();
            if (content != null) {
                string = StringsKt__StringsKt.Z0(content).toString();
            } else {
                string = null;
            }
        } else if (TextUtils.isEmpty(postSubjectItem.getContent())) {
            String title = postSubjectItem.getTitle();
            if (title != null) {
                string = StringsKt__StringsKt.Z0(title).toString();
            } else {
                string = null;
            }
        } else {
            String title2 = postSubjectItem.getTitle();
            String string2 = title2 != null ? StringsKt__StringsKt.Z0(title2).toString() : null;
            String content2 = postSubjectItem.getContent();
            string = string2 + "\n" + (content2 != null ? StringsKt__StringsKt.Z0(content2).toString() : null);
        }
        PostSubjectItem postSubjectItem3 = this.f55974g;
        if (postSubjectItem3 == null || (subject = postSubjectItem3.getSubject()) == null) {
            description = string;
        } else {
            Integer subjectType2 = subject.getSubjectType();
            int value2 = SubjectType.SHORT_TV.getValue();
            if (subjectType2 != null && subjectType2.intValue() == value2) {
                Subject subject3 = postSubjectItem.getSubject();
                description = subject3 != null ? subject3.getDescription() : null;
            } else {
                description = string;
            }
        }
        if (TextUtils.isEmpty(description)) {
            Intrinsics.f(updateVideoInfo$lambda$7, "updateVideoInfo$lambda$7");
            so.c.g(updateVideoInfo$lambda$7);
        } else {
            Intrinsics.f(updateVideoInfo$lambda$7, "updateVideoInfo$lambda$7");
            so.c.k(updateVideoInfo$lambda$7);
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            updateVideoInfo$lambda$7.l(com.transsion.baseui.util.k.b(updateVideoInfo$lambda$7, description, false, new g(objectRef), new Function2<View, String, Unit>() { // from class: com.transsion.postdetail.ui.view.ImmVideoItemView$updateVideoInfo$4$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(View view, String str2) {
                    invoke2(view, str2);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view, String str2) {
                    String subjectId;
                    String resourceLink;
                    ResourceDetectors resourceDetector;
                    List<UrlContent> list;
                    int length = updateVideoInfo$lambda$7.getText().length();
                    if (booleanRef.element && (list = objectRef.element) != null) {
                        boolean z11 = false;
                        for (UrlContent urlContent : list) {
                            int indexOfUrl = urlContent.getIndexOfUrl();
                            int indexOfUrl2 = urlContent.getIndexOfUrl() + urlContent.getUrl().length();
                            if (indexOfUrl <= length && indexOfUrl2 >= length && indexOfUrl <= length && length < indexOfUrl2 + 1) {
                                z11 = true;
                            }
                        }
                        if (z11) {
                            updateVideoInfo$lambda$7.performClick();
                            return;
                        }
                    }
                    Subject subject4 = postSubjectItem.getSubject();
                    if (subject4 == null || (subjectId = subject4.getSubjectId()) == null || subjectId.length() <= 0) {
                        com.alibaba.android.arouter.launcher.a.d().b(WebPageIdentity.WEB_VIEW).withString("url", str2).navigation();
                        return;
                    }
                    DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
                    Context context2 = updateVideoInfo$lambda$7.getContext();
                    Intrinsics.e(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                    FragmentActivity fragmentActivity = (FragmentActivity) context2;
                    Subject subject5 = postSubjectItem.getSubject();
                    Intrinsics.d(str2);
                    PostSubjectItem postSubjectItem4 = this.f55974g;
                    String ops = postSubjectItem4 != null ? postSubjectItem4.getOps() : null;
                    Subject subject6 = postSubjectItem.getSubject();
                    if (subject6 == null || (resourceDetector = subject6.getResourceDetector()) == null || (resourceLink = resourceDetector.getResourceLink()) == null) {
                        resourceLink = "";
                    }
                    String str3 = resourceLink;
                    User user3 = postSubjectItem.getUser();
                    downloadManagerApiA.W1(fragmentActivity, subject5, str2, "post_video_detail", ops, str3, user3 != null ? user3.getNickname() : null);
                }
            }));
        }
    }

    public final void app2Background() {
        com.transsion.postdetail.layer.b bVar = this.f55987t;
        if (bVar != null) {
            bVar.d(true);
        }
    }

    public final FrameLayout getPlayerContainer() {
        FrameLayout frameLayout = this.f55970b.f77961g;
        Intrinsics.f(frameLayout, "viewBinding.flContainer");
        return frameLayout;
    }

    public final Integer getPosition() {
        return this.f55977j;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0046  */
    public final void h(String str) {
        Integer numValueOf;
        if (str == null) {
            numValueOf = null;
        } else {
            int iHashCode = str.hashCode();
            if (iHashCode != -1550083459) {
                if (iHashCode != -877500447) {
                    if (iHashCode == 525878142 && str.equals("favorite_add")) {
                        numValueOf = Integer.valueOf(com.transsnet.downloader.R$string.short_tv_favorite_toast);
                    } else {
                        numValueOf = null;
                    }
                } else if (str.equals("favorite_fail")) {
                    numValueOf = Integer.valueOf(com.tn.lib.widget.R$string.failed_toast);
                } else {
                    numValueOf = null;
                }
            } else if (str.equals("favorite_cancel")) {
                numValueOf = Integer.valueOf(com.transsnet.downloader.R$string.short_tv_favorite_remove_toast);
            } else {
                numValueOf = null;
            }
        }
        if (numValueOf != null) {
            zp.b.f82110a.d(numValueOf.intValue());
        }
    }

    public final void i(String str) {
        uo.b.a.o(uo.b.f78622a, this.f55969a, new String[]{"finishAfterReport, position = " + this.f55977j}, false, 4, null);
        PostDetailViewModel postDetailViewModel = this.f55971c;
        androidx.lifecycle.c0<Integer> c0VarS = postDetailViewModel != null ? postDetailViewModel.s() : null;
        if (c0VarS == null) {
            return;
        }
        c0VarS.q(this.f55977j);
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        com.transsion.player.orplayer.e.a.a(this);
    }

    public final void j(Context context) {
        this.f55985r = new GestureDetector(context, new b());
        q();
        p();
        k();
    }

    public final void k() {
        new is.c(getContext(), this.f55970b.B).s(new c());
        this.f55970b.f77973s.setOnTouchListener(new View.OnTouchListener() { // from class: com.transsion.postdetail.ui.view.f
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return ImmVideoItemView.l(view, motionEvent);
            }
        });
    }

    public final void m(View view) {
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 500L)) {
            return;
        }
        UserInfo userInfo = new UserInfo();
        PostSubjectItem postSubjectItem = this.f55974g;
        User user = postSubjectItem != null ? postSubjectItem.getUser() : null;
        userInfo.setUserId(user != null ? user.getUserId() : null);
        userInfo.setNickname(user != null ? user.getNickname() : null);
        userInfo.setUsername(user != null ? user.getUsername() : null);
        userInfo.setAvatar(user != null ? user.getAvatar() : null);
        com.alibaba.android.arouter.launcher.a.d().b("/profile/user_center").withSerializable("userInfo", userInfo).navigation();
        com.transsion.postdetail.helper.a.f55063a.c(this.f55974g, "postdetail_video", this.F);
    }

    public final void n(View view) {
        Group group;
        Integer num;
        FragmentActivity fragmentActivityRequireActivity;
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 500L)) {
            return;
        }
        if (!TextUtils.equals(ActivityStackManager.f49449b.a().b(), ((IRoomApi) com.alibaba.android.arouter.launcher.a.d().h(IRoomApi.class)).R0()) || (num = this.f55977j) == null || num.intValue() != 0) {
            Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/room/detail");
            PostSubjectItem postSubjectItem = this.f55974g;
            postcardB.withString("id", (postSubjectItem == null || (group = postSubjectItem.getGroup()) == null) ? null : group.getGroupId()).navigation();
            com.transsion.postdetail.helper.a.f55063a.j(this.f55974g, "postdetail_video", this.F);
            return;
        }
        Fragment fragment = this.f55975h;
        if (fragment == null || (fragmentActivityRequireActivity = fragment.requireActivity()) == null) {
            return;
        }
        fragmentActivityRequireActivity.finish();
    }

    /* JADX WARN: Code duplicated, block: B:36:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:43:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:49:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:52:0x00e8  */
    public final void o(View view) {
        PostSubjectItem postSubjectItem;
        int value;
        PostSubjectItem postSubjectItem2;
        String subjectId;
        Subject subject;
        Subject subject2;
        Integer subjectType;
        Subject subject3;
        Subject subject4;
        Integer num;
        FragmentActivity fragmentActivityRequireActivity;
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 500L)) {
            return;
        }
        if (TextUtils.equals(ActivityStackManager.f49449b.a().b(), ((IMovieDetailService) com.alibaba.android.arouter.launcher.a.d().h(IMovieDetailService.class)).Q0()) && (num = this.f55977j) != null && num.intValue() == 0) {
            Fragment fragment = this.f55975h;
            if (fragment == null || (fragmentActivityRequireActivity = fragment.requireActivity()) == null) {
                return;
            }
            fragmentActivityRequireActivity.finish();
            return;
        }
        PostSubjectItem postSubjectItem3 = this.f55974g;
        if (postSubjectItem3 == null || (subject3 = postSubjectItem3.getSubject()) == null) {
            Postcard postcardB = com.alibaba.android.arouter.launcher.a.d().b("/movie/detail");
            postSubjectItem = this.f55974g;
            if (postSubjectItem != null || (subject2 = postSubjectItem.getSubject()) == null || (subjectType = subject2.getSubjectType()) == null) {
                value = SubjectType.MOVIE.getValue();
            } else {
                value = subjectType.intValue();
            }
            Postcard postcardWithInt = postcardB.withInt("subject_type", value);
            postSubjectItem2 = this.f55974g;
            if (postSubjectItem2 != null || (subject = postSubjectItem2.getSubject()) == null) {
                subjectId = null;
            } else {
                subjectId = subject.getSubjectId();
            }
            Postcard postcardWithString = postcardWithInt.withString("id", subjectId);
            PostSubjectItem postSubjectItem4 = this.f55974g;
            postcardWithString.withString("ops", postSubjectItem4 != null ? postSubjectItem4.getOps() : null).navigation();
        } else {
            Integer subjectType2 = subject3.getSubjectType();
            int value2 = SubjectType.SHORT_TV.getValue();
            if (subjectType2 != null && subjectType2.intValue() == value2) {
                DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
                Context context = getContext();
                Intrinsics.e(context, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
                FragmentActivity fragmentActivity = (FragmentActivity) context;
                PostSubjectItem postSubjectItem5 = this.f55974g;
                String ops = (postSubjectItem5 == null || (subject4 = postSubjectItem5.getSubject()) == null) ? null : subject4.getOps();
                PostSubjectItem postSubjectItem6 = this.f55974g;
                downloadManagerApiA.a2(fragmentActivity, "postdetail_video", (384 & 4) != 0 ? "" : "", ops, (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : false, (384 & 64) != 0 ? null : postSubjectItem6 != null ? postSubjectItem6.getSubject() : null, (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
            } else {
                Postcard postcardB2 = com.alibaba.android.arouter.launcher.a.d().b("/movie/detail");
                postSubjectItem = this.f55974g;
                if (postSubjectItem != null) {
                    value = SubjectType.MOVIE.getValue();
                } else {
                    value = SubjectType.MOVIE.getValue();
                }
                Postcard postcardWithInt2 = postcardB2.withInt("subject_type", value);
                postSubjectItem2 = this.f55974g;
                if (postSubjectItem2 != null) {
                    subjectId = null;
                } else {
                    subjectId = null;
                }
                Postcard postcardWithString2 = postcardWithInt2.withString("id", subjectId);
                PostSubjectItem postSubjectItem7 = this.f55974g;
                postcardWithString2.withString("ops", postSubjectItem7 != null ? postSubjectItem7.getOps() : null).navigation();
            }
        }
        com.transsion.postdetail.helper.a.f55063a.A(this.f55974g, "postdetail_video", this.F);
    }

    @Override // com.transsion.player.orplayer.e
    public void onAliyunDecodeErrorChangeSoftwareDecoder(MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.b(this, mediaSource);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        androidx.lifecycle.u viewLifecycleOwner;
        ShortTvPlayListViewModel shortTvPlayListViewModel;
        androidx.lifecycle.c0<String> c0VarF;
        super.onAttachedToWindow();
        Fragment fragment = this.f55975h;
        if (fragment == null || (viewLifecycleOwner = fragment.getViewLifecycleOwner()) == null || (shortTvPlayListViewModel = this.f55972d) == null || (c0VarF = shortTvPlayListViewModel.f()) == null) {
            return;
        }
        c0VarF.j(viewLifecycleOwner, this.K);
    }

    @Override // com.transsion.player.orplayer.e
    public void onBufferedPosition(long j11, MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.c(this, j11, mediaSource);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Subject subject;
        Context context;
        PostSubjectItem postSubjectItem;
        Subject subject2;
        Integer numValueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i11 = R$id.tv_like;
        if (numValueOf != null && numValueOf.intValue() == i11) {
            s(view);
            return;
        }
        int i12 = R$id.tv_comment;
        if (numValueOf != null && numValueOf.intValue() == i12) {
            r(view);
            return;
        }
        int i13 = R$id.iv_share;
        if (numValueOf != null && numValueOf.intValue() == i13) {
            v(view);
            return;
        }
        int i14 = R$id.iv_video_avatar;
        if (numValueOf != null && numValueOf.intValue() == i14) {
            m(view);
            return;
        }
        int i15 = R$id.ev_post_des;
        if (numValueOf != null && numValueOf.intValue() == i15) {
            return;
        }
        int i16 = R$id.cl_subject_content;
        if (numValueOf != null && numValueOf.intValue() == i16) {
            o(view);
            return;
        }
        int i17 = R$id.ll_room_tag;
        if (numValueOf != null && numValueOf.intValue() == i17) {
            n(view);
            return;
        }
        int i18 = R$id.tvShortTvEp;
        if (numValueOf != null && numValueOf.intValue() == i18) {
            Fragment fragment = this.f55975h;
            if (fragment == null || (context = fragment.getContext()) == null || (postSubjectItem = this.f55974g) == null || (subject2 = postSubjectItem.getSubject()) == null) {
                return;
            }
            PostSubjectItem postSubjectItem2 = this.f55974g;
            subject2.setOps(postSubjectItem2 != null ? postSubjectItem2.getOps() : null);
            ShortTvListActivity.a.b(ShortTvListActivity.f55358h, context, subject2, 1, this.f55970b.f77973s.getProgress(), false, 16, null);
            return;
        }
        int i19 = R$id.iv_download;
        if (numValueOf == null || numValueOf.intValue() != i19) {
            int i21 = R$id.iv_short_cover;
            if (numValueOf == null || numValueOf.intValue() != i21) {
                int i22 = R$id.tv_title;
                if (numValueOf == null || numValueOf.intValue() != i22) {
                    return;
                }
            }
        }
        DownloadManagerApi downloadManagerApiA = DownloadManagerApi.f60274j.a();
        Context context2 = getContext();
        Intrinsics.e(context2, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        FragmentActivity fragmentActivity = (FragmentActivity) context2;
        PostSubjectItem postSubjectItem3 = this.f55974g;
        String ops = (postSubjectItem3 == null || (subject = postSubjectItem3.getSubject()) == null) ? null : subject.getOps();
        boolean z11 = view.getId() == R$id.iv_download;
        PostSubjectItem postSubjectItem4 = this.f55974g;
        downloadManagerApiA.a2(fragmentActivity, "postdetail_video", (384 & 4) != 0 ? "" : "", ops, (384 & 16) != 0 ? null : "download_subject", (384 & 32) != 0 ? false : z11, (384 & 64) != 0 ? null : postSubjectItem4 != null ? postSubjectItem4.getSubject() : null, (384 & 128) != 0 ? null : null, (384 & 256) != 0 ? Boolean.FALSE : null);
    }

    @Override // com.transsion.player.orplayer.e
    public void onCompletion(MediaSource mediaSource) {
        Subject subject;
        Fragment fragment;
        Context context;
        PostSubjectItem postSubjectItem;
        Subject subject2;
        uo.b.a.o(uo.b.f78622a, this.f55969a, new String[]{"player- onCompletion"}, false, 4, null);
        PostSubjectItem postSubjectItem2 = this.f55974g;
        if (postSubjectItem2 == null || (subject = postSubjectItem2.getSubject()) == null) {
            return;
        }
        Integer subjectType = subject.getSubjectType();
        int value = SubjectType.SHORT_TV.getValue();
        if (subjectType == null || subjectType.intValue() != value || (fragment = this.f55975h) == null || (context = fragment.getContext()) == null || (postSubjectItem = this.f55974g) == null || (subject2 = postSubjectItem.getSubject()) == null) {
            return;
        }
        PostSubjectItem postSubjectItem3 = this.f55974g;
        subject2.setOps(postSubjectItem3 != null ? postSubjectItem3.getOps() : null);
        ShortTvListActivity.a.b(ShortTvListActivity.f55358h, context, subject2, 2, 0L, false, 24, null);
        com.transsion.player.orplayer.f fVar = this.f55980m;
        if (fVar != null) {
            fVar.seekTo(0L);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        androidx.lifecycle.c0<String> c0VarF;
        super.onDetachedFromWindow();
        ShortTvPlayListViewModel shortTvPlayListViewModel = this.f55972d;
        androidx.lifecycle.c0<String> c0VarF2 = shortTvPlayListViewModel != null ? shortTvPlayListViewModel.f() : null;
        if (c0VarF2 != null) {
            c0VarF2.q(null);
        }
        ShortTvPlayListViewModel shortTvPlayListViewModel2 = this.f55972d;
        if (shortTvPlayListViewModel2 == null || (c0VarF = shortTvPlayListViewModel2.f()) == null) {
            return;
        }
        c0VarF.o(this.K);
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
        com.transsion.postdetail.layer.b bVar = this.f55987t;
        if (bVar != null) {
            bVar.h();
        }
        setLoading(true);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingEnd(MediaSource mediaSource) {
        com.transsion.postdetail.layer.b bVar = this.f55987t;
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
        com.transsion.postdetail.layer.b bVar = this.f55987t;
        if (bVar != null) {
            bVar.j();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onMediaItemTransition(String str) {
        com.transsion.player.orplayer.e.a.o(this, str);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayError(PlayError errorInfo, MediaSource mediaSource) {
        Intrinsics.g(errorInfo, "errorInfo");
        this.G.set(true);
        this.H = 0L;
        com.transsion.postdetail.layer.b bVar = this.f55987t;
        if (bVar != null) {
            bVar.k(errorInfo);
        }
        uo.b.f78622a.h("i_media", this.f55969a + " --> IPlayerListener --> onPlayError()  errorCode:" + errorInfo.getErrorCode() + " errorMessage:" + errorInfo.getErrorMessage() + " url:" + (mediaSource != null ? mediaSource.j() : null) + " --> 短播放失败了", true);
    }

    public void onPlayErrorChangePayer(TnPlayerType tnPlayerType, MediaSource mediaSource) {
        com.transsion.player.orplayer.e.a.r(this, tnPlayerType, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerRelease(MediaSource mediaSource) {
        this.G.set(true);
        this.H = 0L;
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerReset() {
        String postId;
        uo.b.a.f(uo.b.f78622a, this.f55969a, "player- onPlayerReset", false, 4, null);
        this.J = true;
        this.G.set(true);
        this.H = 0L;
        setKeepScreenOn(false);
        this.f55989v = false;
        com.transsion.postdetail.layer.b bVar = this.f55987t;
        if (bVar != null) {
            com.transsion.postdetail.layer.b.e(bVar, false, 1, null);
        }
        PostSubjectItem postSubjectItem = this.f55974g;
        if (postSubjectItem != null && (postId = postSubjectItem.getPostId()) != null) {
            ImmVideoHelper.f55024g.a().h().put(postId, Long.valueOf(this.f55970b.f77971q.getProgress()));
        }
        AppCompatImageView appCompatImageView = this.f55970b.f77962h;
        Intrinsics.f(appCompatImageView, "viewBinding.ivCover");
        so.c.k(appCompatImageView);
        AppCompatImageView appCompatImageView2 = this.f55970b.f77964j;
        Intrinsics.f(appCompatImageView2, "viewBinding.ivPause");
        so.c.g(appCompatImageView2);
        AppCompatSeekBar appCompatSeekBar = this.f55970b.f77973s;
        Intrinsics.f(appCompatSeekBar, "viewBinding.seekBar");
        so.c.g(appCompatSeekBar);
        this.f55970b.f77960f.reset();
        ImmVideoGuideView immVideoGuideView = this.f55984q;
        if (immVideoGuideView != null) {
            immVideoGuideView.removeGuide();
        }
        this.f55980m = null;
        this.f55981n = null;
        this.f55982o = null;
        this.f55992y = 0L;
    }

    @Override // com.transsion.player.orplayer.e
    public void onPrepare(MediaSource mediaSource) {
        Fragment fragment;
        String postId;
        com.transsion.player.orplayer.f fVar = this.f55980m;
        boolean z11 = false;
        int duration = fVar != null ? (int) fVar.getDuration() : 0;
        this.f55970b.f77971q.setMax(duration);
        this.f55970b.f77973s.setMax(duration);
        PostSubjectItem postSubjectItem = this.f55974g;
        if (postSubjectItem != null && (postId = postSubjectItem.getPostId()) != null) {
            Long lB = com.transsion.postdetail.video.d.f56247a.b(postId);
            if (lB != null) {
                long jLongValue = lB.longValue();
                if (jLongValue > 0) {
                    uo.b.a.s(uo.b.f78622a, "PostFeedVideo", "immvideo seek:" + jLongValue, false, 4, null);
                    com.transsion.player.orplayer.f fVar2 = this.f55980m;
                    if (fVar2 != null) {
                        fVar2.seekTo(jLongValue);
                    }
                    z11 = true;
                }
            }
            Long l11 = ImmVideoHelper.f55024g.a().h().get(postId);
            long jLongValue2 = l11 != null ? l11.longValue() : 0L;
            uo.b.a.f(uo.b.f78622a, this.f55969a, "player- onPrepare, duration = " + this.f55970b.f77971q.getMax() + ", progress = " + jLongValue2, false, 4, null);
            if (jLongValue2 > 0 && !z11) {
                this.f55992y = jLongValue2;
                int i11 = (int) jLongValue2;
                this.f55970b.f77971q.setProgress(i11);
                this.f55970b.f77973s.setProgress(i11);
                com.transsion.player.orplayer.f fVar3 = this.f55980m;
                if (fVar3 != null) {
                    fVar3.seekTo(jLongValue2);
                }
            }
        }
        if (!this.f55989v && !this.f55991x && (fragment = this.f55975h) != null && fragment.isVisible()) {
            uo.b.a.f(uo.b.f78622a, this.f55969a, "player- onPrepare， play~", false, 4, null);
            com.transsion.player.orplayer.f fVar4 = this.f55980m;
            if (fVar4 != null) {
                fVar4.play();
            }
        }
        setKeepScreenOn(true);
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long j11, MediaSource mediaSource) {
        if (this.G.get() && !this.f55990w) {
            com.transsion.postdetail.layer.b bVar = this.f55987t;
            if (bVar != null) {
                bVar.l(j11);
            }
            int i11 = (int) j11;
            this.f55970b.f77971q.setProgress(i11);
            this.f55970b.f77973s.setProgress(i11);
            t(j11);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        uo.b.a.f(uo.b.f78622a, this.f55969a, "player- onRenderFirstFrame", false, 4, null);
        AppCompatImageView appCompatImageView = this.f55970b.f77962h;
        Intrinsics.f(appCompatImageView, "viewBinding.ivCover");
        so.c.g(appCompatImageView);
        com.transsion.postdetail.layer.b bVar = this.f55987t;
        if (bVar != null) {
            bVar.m();
        }
        setLoading(false);
    }

    @Override // com.transsion.player.orplayer.e
    public void onSetDataSource() {
        this.J = false;
        this.G.set(true);
        this.H = 0L;
        setLoading(true);
    }

    @Override // androidx.lifecycle.r
    public void onStateChanged(androidx.lifecycle.u source, Lifecycle.Event event) {
        String postId;
        String postId2;
        Lifecycle lifecycle;
        Intrinsics.g(source, "source");
        Intrinsics.g(event, "event");
        int i11 = a.f55994a[event.ordinal()];
        if (i11 == 1) {
            this.f55991x = true;
            uo.b.a aVar = uo.b.f78622a;
            uo.b.a.f(aVar, this.f55969a, "player- onPause", false, 4, null);
            com.transsion.player.orplayer.f fVar = this.f55980m;
            if (fVar != null) {
                fVar.pause();
            }
            PostSubjectItem postSubjectItem = this.f55974g;
            if (postSubjectItem == null || (postId = postSubjectItem.getPostId()) == null) {
                return;
            }
            uo.b.a.s(aVar, "PostFeedVideo", "immvideo savePlayProgress:" + this.f55970b.f77971q.getProgress(), false, 4, null);
            com.transsion.postdetail.video.d.f56247a.c(postId, (long) this.f55970b.f77971q.getProgress());
            return;
        }
        if (i11 == 2) {
            this.f55991x = false;
            if (this.f55989v) {
                return;
            }
            Fragment fragment = this.f55975h;
            if (fragment != null && !fragment.isVisible()) {
                post(new Runnable() { // from class: com.transsion.postdetail.ui.view.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        ImmVideoItemView.x(this.f56130a);
                    }
                });
                return;
            }
            com.transsion.player.orplayer.f fVar2 = this.f55980m;
            if (fVar2 != null) {
                fVar2.play();
                return;
            }
            return;
        }
        if (i11 == 3) {
            PostSubjectItem postSubjectItem2 = this.f55974g;
            if (postSubjectItem2 == null || (postId2 = postSubjectItem2.getPostId()) == null) {
                return;
            }
            ImmVideoHelper.f55024g.a().h().put(postId2, Long.valueOf(this.f55970b.f77971q.getProgress()));
            return;
        }
        if (i11 != 5) {
            return;
        }
        Fragment fragment2 = this.f55975h;
        if (fragment2 != null && (lifecycle = fragment2.getLifecycle()) != null) {
            lifecycle.d(this);
        }
        com.transsion.postdetail.layer.b bVar = this.f55987t;
        if (bVar != null) {
            bVar.p();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.g(event, "event");
        GestureDetector gestureDetector = this.f55985r;
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
        uo.b.a.f(uo.b.f78622a, this.f55969a, "player- onVideoPause", false, 4, null);
        AppCompatImageView appCompatImageView = this.f55970b.f77964j;
        Intrinsics.f(appCompatImageView, "viewBinding.ivPause");
        so.c.k(appCompatImageView);
        AppCompatSeekBar appCompatSeekBar = this.f55970b.f77973s;
        Intrinsics.f(appCompatSeekBar, "viewBinding.seekBar");
        so.c.k(appCompatSeekBar);
        ProgressBar progressBar = this.f55970b.f77971q;
        Intrinsics.f(progressBar, "viewBinding.progressBar");
        so.c.g(progressBar);
        com.transsion.postdetail.layer.b bVar = this.f55987t;
        if (bVar != null) {
            bVar.n();
        }
        setKeepScreenOn(false);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i11, int i12) {
        com.transsion.player.orplayer.e.a.G(this, i11, i12);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(MediaSource mediaSource) {
        uo.b.a.f(uo.b.f78622a, this.f55969a, "player- onVideoStart", false, 4, null);
        com.transsion.postdetail.layer.b bVar = this.f55987t;
        if (bVar != null) {
            bVar.o();
        }
        AppCompatImageView appCompatImageView = this.f55970b.f77964j;
        Intrinsics.f(appCompatImageView, "viewBinding.ivPause");
        so.c.g(appCompatImageView);
        AppCompatSeekBar appCompatSeekBar = this.f55970b.f77973s;
        Intrinsics.f(appCompatSeekBar, "viewBinding.seekBar");
        so.c.g(appCompatSeekBar);
        setLoading(false);
        setKeepScreenOn(true);
        IAudioApi iAudioApi = this.f55983p;
        if (iAudioApi != null) {
            iAudioApi.pause();
        }
    }

    public final void p() {
        Context context = getContext();
        Intrinsics.e(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        AppCompatActivity appCompatActivity = (AppCompatActivity) context;
        Function1<AddToDownloadEvent, Unit> function1 = new Function1<AddToDownloadEvent, Unit>() { // from class: com.transsion.postdetail.ui.view.ImmVideoItemView$observeAddToDownload$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AddToDownloadEvent addToDownloadEvent) {
                invoke2(addToDownloadEvent);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AddToDownloadEvent value) {
                Subject subject;
                Intrinsics.g(value, "value");
                try {
                    String subjectId = value.getSubjectId();
                    PostSubjectItem postSubjectItem = this.this$0.f55974g;
                    TextUtils.equals(subjectId, (postSubjectItem == null || (subject = postSubjectItem.getSubject()) == null) ? null : subject.getSubjectId());
                } catch (Exception unused) {
                    uo.b.a.g(uo.b.f78622a, " callback change data fail", false, 2, null);
                }
            }
        };
        AppScopeVMlProvider appScopeVMlProvider = AppScopeVMlProvider.INSTANCE;
        FlowEventBus flowEventBus = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name = AddToDownloadEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        Lifecycle.State state = Lifecycle.State.CREATED;
        flowEventBus.observeEvent(appCompatActivity, name, state, w0.c().q(), false, function1);
        Context context2 = getContext();
        Intrinsics.e(context2, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Function1<j00.c, Unit> function2 = new Function1<j00.c, Unit>() { // from class: com.transsion.postdetail.ui.view.ImmVideoItemView$observeAddToDownload$2
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
                Subject subject;
                ShortTVFavInfo shortTVFavInfo;
                Subject subject2;
                Intrinsics.g(value, "value");
                try {
                    String strC = value.c();
                    PostSubjectItem postSubjectItem = this.this$0.f55974g;
                    if (TextUtils.equals(strC, (postSubjectItem == null || (subject2 = postSubjectItem.getSubject()) == null) ? null : subject2.getSubjectId())) {
                        PostSubjectItem postSubjectItem2 = this.this$0.f55974g;
                        if (postSubjectItem2 != null && (subject = postSubjectItem2.getSubject()) != null && (shortTVFavInfo = subject.getShortTVFavInfo()) != null) {
                            shortTVFavInfo.setFavoriteNum(value.b());
                            shortTVFavInfo.setHasFavorite(value.a());
                        }
                        this.this$0.f55970b.f77976v.setSelected(value.a());
                        AppCompatTextView appCompatTextView = this.this$0.f55970b.f77976v;
                        String strB = value.b();
                        appCompatTextView.setText(com.transsion.baseui.util.j.a(strB != null ? Long.parseLong(strB) : 0L));
                    }
                } catch (Exception unused) {
                    uo.b.a.g(uo.b.f78622a, " callback change data fail", false, 2, null);
                }
            }
        };
        FlowEventBus flowEventBus2 = (FlowEventBus) appScopeVMlProvider.getApplicationScopeViewModel(FlowEventBus.class);
        String name2 = j00.c.class.getName();
        Intrinsics.f(name2, "T::class.java.name");
        flowEventBus2.observeEvent((AppCompatActivity) context2, name2, state, w0.c().q(), false, function2);
    }

    public final void q() {
        Context context = getContext();
        Intrinsics.e(context, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Function1<LikeEvent, Unit> function1 = new Function1<LikeEvent, Unit>() { // from class: com.transsion.postdetail.ui.view.ImmVideoItemView$observeLike$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(LikeEvent likeEvent) {
                invoke2(likeEvent);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(LikeEvent value) {
                Stat stat;
                Long likeCount;
                Stat stat2;
                Long likeCount2;
                Intrinsics.g(value, "value");
                try {
                    String subjectId = value.getSubjectId();
                    PostSubjectItem postSubjectItem = this.this$0.f55974g;
                    if (TextUtils.equals(subjectId, postSubjectItem != null ? postSubjectItem.getPostId() : null)) {
                        PostSubjectItem postSubjectItem2 = this.this$0.f55974g;
                        if (postSubjectItem2 != null) {
                            postSubjectItem2.setHasLike(Boolean.valueOf(value.getLike()));
                        }
                        if (value.getLike()) {
                            PostSubjectItem postSubjectItem3 = this.this$0.f55974g;
                            Stat stat3 = postSubjectItem3 != null ? postSubjectItem3.getStat() : null;
                            if (stat3 != null) {
                                PostSubjectItem postSubjectItem4 = this.this$0.f55974g;
                                stat3.setLikeCount((postSubjectItem4 == null || (stat2 = postSubjectItem4.getStat()) == null || (likeCount2 = stat2.getLikeCount()) == null) ? null : Long.valueOf(likeCount2.longValue() + 1));
                            }
                        } else {
                            PostSubjectItem postSubjectItem5 = this.this$0.f55974g;
                            Stat stat4 = postSubjectItem5 != null ? postSubjectItem5.getStat() : null;
                            if (stat4 != null) {
                                PostSubjectItem postSubjectItem6 = this.this$0.f55974g;
                                stat4.setLikeCount((postSubjectItem6 == null || (stat = postSubjectItem6.getStat()) == null || (likeCount = stat.getLikeCount()) == null) ? null : Long.valueOf(likeCount.longValue() - 1));
                            }
                        }
                        PostSubjectItem postSubjectItem7 = this.this$0.f55974g;
                        if (postSubjectItem7 != null) {
                            this.this$0.C(postSubjectItem7);
                        }
                    }
                } catch (Exception unused) {
                    uo.b.a.g(uo.b.f78622a, " callback change data fail", false, 2, null);
                }
            }
        };
        FlowEventBus flowEventBus = (FlowEventBus) AppScopeVMlProvider.INSTANCE.getApplicationScopeViewModel(FlowEventBus.class);
        String name = LikeEvent.class.getName();
        Intrinsics.f(name, "T::class.java.name");
        flowEventBus.observeEvent((AppCompatActivity) context, name, Lifecycle.State.CREATED, w0.c().q(), false, function1);
    }

    public final void r(View view) {
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 500L)) {
            return;
        }
        showCommentDialog();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.transsion.postdetail.viewmodel.PostDetailViewModel] */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [int] */
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
    public final void s(View view) {
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 500L)) {
            return;
        }
        if (!com.tn.lib.util.networkinfo.f.f49475a.e()) {
            zp.b.f82110a.d(com.tn.lib.widget.R$string.no_network_tips);
            return;
        }
        PostSubjectItem postSubjectItem = this.f55974g;
        ?? B = postSubjectItem != null ? Intrinsics.b(postSubjectItem.getHasLike(), Boolean.TRUE) : 0;
        ?? r11 = this.f55971c;
        if (r11 != 0) {
            PostSubjectItem postSubjectItem2 = this.f55974g;
            r11.v(postSubjectItem2 != null ? postSubjectItem2.getPostId() : null, B);
        }
        com.transsion.postdetail.helper.a aVar = com.transsion.postdetail.helper.a.f55063a;
        PostSubjectItem postSubjectItem3 = this.f55974g;
        aVar.m(postSubjectItem3, postSubjectItem3 != null ? Intrinsics.b(postSubjectItem3.getHasLike(), Boolean.TRUE) : false, "postdetail_video", this.F);
    }

    public final void setData(PostSubjectItem item, final Fragment fragment, Integer num, boolean z11, String str, String str2, boolean z12, String commentId) {
        Long commentCount;
        Integer subjectType;
        Intrinsics.g(item, "item");
        Intrinsics.g(fragment, "fragment");
        Intrinsics.g(commentId, "commentId");
        com.transsion.postdetail.layer.b bVar = new com.transsion.postdetail.layer.b();
        this.f55987t = bVar;
        bVar.s(str);
        com.transsion.postdetail.layer.b bVar2 = this.f55987t;
        if (bVar2 != null) {
            bVar2.r(str2);
        }
        com.transsion.postdetail.layer.b bVar3 = this.f55987t;
        if (bVar3 != null) {
            String postId = item.getPostId();
            if (postId == null) {
                postId = "";
            }
            bVar3.x(postId, item);
        }
        com.transsion.postdetail.layer.b bVar4 = this.f55987t;
        if (bVar4 != null) {
            Subject subject = item.getSubject();
            bVar4.y((subject == null || (subjectType = subject.getSubjectType()) == null) ? 0 : subjectType.intValue());
        }
        this.f55975h = fragment;
        this.f55976i = Boolean.valueOf(z11);
        this.f55978k = str;
        this.f55977j = num;
        this.I = z12;
        this.f55979l = commentId;
        fragment.getLifecycle().a(this);
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.transsion.postdetail.ui.view.ImmVideoItemView$setData$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return fragment;
            }
        };
        this.f55971c = z(FragmentViewModelLazyKt.a(fragment, Reflection.b(PostDetailViewModel.class), new Function0<x0>() { // from class: com.transsion.postdetail.ui.view.ImmVideoItemView$setData$$inlined$viewModels$default$2
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
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.ui.view.ImmVideoItemView$setData$$inlined$viewModels$default$3
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
        final Function0<Fragment> function1 = new Function0<Fragment>() { // from class: com.transsion.postdetail.ui.view.ImmVideoItemView$setData$$inlined$viewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return fragment;
            }
        };
        this.f55972d = A(FragmentViewModelLazyKt.a(fragment, Reflection.b(ShortTvPlayListViewModel.class), new Function0<x0>() { // from class: com.transsion.postdetail.ui.view.ImmVideoItemView$setData$$inlined$viewModels$default$5
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
        }, new Function0<v0.c>() { // from class: com.transsion.postdetail.ui.view.ImmVideoItemView$setData$$inlined$viewModels$default$6
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
        this.f55974g = item;
        G(item);
        C(item);
        Stat stat = item.getStat();
        B((stat == null || (commentCount = stat.getCommentCount()) == null) ? 0L : commentCount.longValue());
        F(item);
        if (z12) {
            ViewGroup.LayoutParams layoutParams = this.f55970b.f77972r.getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.b) {
                ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.b) layoutParams)).bottomMargin = com.blankj.utilcode.util.f0.a(16.0f);
            }
        }
        D();
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        com.transsion.player.orplayer.e.a.J(this);
        this.G.set(true);
        long j11 = this.H;
        if (j11 > 0) {
            uo.b.a.o(uo.b.f78622a, this.f55969a, new String[]{"seek OnSeekComplete，nextSeekTo:" + j11}, false, 4, null);
            com.transsion.player.orplayer.f fVar = this.f55980m;
            if (fVar != null) {
                fVar.seekTo(this.H);
            }
            this.H = 0L;
        }
    }

    public final void setPagerLayoutManager(PagerLayoutManager pagerLayoutManager) {
        Intrinsics.g(pagerLayoutManager, "pagerLayoutManager");
        this.f55982o = pagerLayoutManager;
    }

    public final void setPlayer(com.transsion.player.orplayer.f orPlayer, ORPlayerView orPlayerView) {
        Intrinsics.g(orPlayer, "orPlayer");
        Intrinsics.g(orPlayerView, "orPlayerView");
        this.f55980m = orPlayer;
        this.f55981n = orPlayerView;
        com.transsion.postdetail.layer.b bVar = this.f55987t;
        if (bVar != null) {
            bVar.v(orPlayer);
        }
    }

    public final void setPosition(Integer num) {
        this.f55977j = num;
    }

    public final void setVideoUrl(String url) {
        Intrinsics.g(url, "url");
        com.transsion.postdetail.layer.b bVar = this.f55987t;
        if (bVar != null) {
            bVar.A(url);
        }
    }

    public final void showCommentDialog() {
        FragmentManager childFragmentManager;
        Fragment fragment = this.f55975h;
        if (fragment != null && (childFragmentManager = fragment.getChildFragmentManager()) != null) {
            ImmVideoCommentDialog immVideoCommentDialogB = ImmVideoCommentDialog.a.b(ImmVideoCommentDialog.f55600n, this.f55974g, this.f55979l, "postdetail_video", null, 8, null);
            this.f55988u = immVideoCommentDialogB;
            if (immVideoCommentDialogB != null) {
                immVideoCommentDialogB.show(childFragmentManager, "immComment");
            }
        }
        ImmVideoCommentDialog immVideoCommentDialog = this.f55988u;
        if (immVideoCommentDialog != null) {
            immVideoCommentDialog.y0(new e());
        }
        com.transsion.postdetail.helper.a.f55063a.e(this.f55974g, "postdetail_video", this.F);
    }

    public final void t(long j11) {
        if (Intrinsics.b(this.f55976i, Boolean.TRUE)) {
            ImmVideoHelper.a aVar = ImmVideoHelper.f55024g;
            if (!aVar.a().k() || j11 < 1000) {
                return;
            }
            aVar.a().p();
            ImmVideoGuideView immVideoGuideViewA = ImmVideoGuideView.Companion.a(this);
            immVideoGuideViewA.postDelayed(new Runnable() { // from class: com.transsion.postdetail.ui.view.c
                @Override // java.lang.Runnable
                public final void run() {
                    ImmVideoItemView.u(this.f56128a);
                }
            }, 5000L);
            this.f55984q = immVideoGuideViewA;
        }
    }

    public final void v(View view) {
        Fragment fragment;
        FragmentManager childFragmentManager;
        ShareDialogFragment shareDialogFragment;
        Subject subject;
        Integer subjectRate;
        User user;
        User user2;
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 500L)) {
            return;
        }
        com.transsion.postdetail.helper.a.f55063a.y(this.f55974g, "postdetail_video", this.F);
        if (this.f55973f == null) {
            ILoginApi loginApi = getLoginApi();
            UserInfo userInfoP = loginApi != null ? loginApi.P() : null;
            PostSubjectItem postSubjectItem = this.f55974g;
            boolean zEquals = TextUtils.equals((postSubjectItem == null || (user2 = postSubjectItem.getUser()) == null) ? null : user2.getUserId(), userInfoP != null ? userInfoP.getUserId() : null);
            ShareDialogFragment.a aVar = ShareDialogFragment.f57724t;
            PostType postType = PostType.POST_TYPE;
            PostSubjectItem postSubjectItem2 = this.f55974g;
            String postId = postSubjectItem2 != null ? postSubjectItem2.getPostId() : null;
            PostSubjectItem postSubjectItem3 = this.f55974g;
            String userId = (postSubjectItem3 == null || (user = postSubjectItem3.getUser()) == null) ? null : user.getUserId();
            String value = ReportType.POST.getValue();
            PostSubjectItem postSubjectItem4 = this.f55974g;
            String title = postSubjectItem4 != null ? postSubjectItem4.getTitle() : null;
            PostSubjectItem postSubjectItem5 = this.f55974g;
            String string = (postSubjectItem5 == null || (subjectRate = postSubjectItem5.getSubjectRate()) == null) ? null : subjectRate.toString();
            PostSubjectItem postSubjectItem6 = this.f55974g;
            boolean z11 = false;
            if (postSubjectItem6 != null && (subject = postSubjectItem6.getSubject()) != null) {
                Integer subjectType = subject.getSubjectType();
                int value2 = SubjectType.SHORT_TV.getValue();
                if (subjectType != null && subjectType.intValue() == value2) {
                    z11 = true;
                }
            }
            boolean z12 = !z11;
            PostSubjectItem postSubjectItem7 = this.f55974g;
            ShareDialogFragment shareDialogFragmentA = aVar.a(postType, postId, userId, value, title, string, z12, zEquals, false, "postdetail", postSubjectItem7 != null ? postSubjectItem7.getOps() : null, view.getContext().getString(R$string.save_video));
            this.f55973f = shareDialogFragmentA;
            if (shareDialogFragmentA != null) {
                shareDialogFragmentA.E0(new d(view, this));
            }
        }
        try {
            Fragment fragment2 = this.f55975h;
            if (fragment2 == null || !fragment2.isAdded() || (fragment = this.f55975h) == null || (childFragmentManager = fragment.getChildFragmentManager()) == null) {
                return;
            }
            childFragmentManager.executePendingTransactions();
            ShareDialogFragment shareDialogFragment2 = this.f55973f;
            if ((shareDialogFragment2 == null || !shareDialogFragment2.isAdded()) && childFragmentManager.findFragmentByTag(AppLovinEventTypes.USER_SHARED_LINK) == null && (shareDialogFragment = this.f55973f) != null) {
                shareDialogFragment.show(childFragmentManager, AppLovinEventTypes.USER_SHARED_LINK);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void videoStartPrepare(String str) {
        com.transsion.postdetail.layer.b bVar;
        this.F = str;
        if (str != null && (bVar = this.f55987t) != null) {
            bVar.t(str);
        }
        com.transsion.postdetail.layer.b bVar2 = this.f55987t;
        if (bVar2 != null) {
            bVar2.g();
        }
        com.transsion.postdetail.layer.b bVar3 = this.f55987t;
        if (bVar3 != null) {
            bVar3.a(0, 0);
        }
        com.transsion.postdetail.layer.b bVar4 = this.f55987t;
        if (bVar4 != null) {
            bVar4.w(this.f55977j);
        }
    }

    public final void w() {
        ClipLoading clipLoading = this.f55970b.f77959d;
        Intrinsics.f(clipLoading, "viewBinding.clLoading");
        if (clipLoading.getVisibility() == 0) {
            return;
        }
        com.transsion.player.orplayer.f fVar = this.f55980m;
        if (fVar == null || !fVar.isPlaying()) {
            com.transsion.postdetail.layer.b bVar = this.f55987t;
            if (bVar != null) {
                bVar.c();
            }
            com.transsion.player.orplayer.f fVar2 = this.f55980m;
            if (fVar2 != null) {
                fVar2.play();
            }
            this.f55989v = false;
            return;
        }
        com.transsion.postdetail.layer.b bVar2 = this.f55987t;
        if (bVar2 != null) {
            bVar2.b();
        }
        com.transsion.player.orplayer.f fVar3 = this.f55980m;
        if (fVar3 != null) {
            fVar3.pause();
        }
        this.f55989v = true;
    }

    public final void y(DownloadBean downloadBean) {
        kotlinx.coroutines.j.d(kotlinx.coroutines.l0.a(w0.b()), null, null, new ImmVideoItemView$saveBuiltInVideo$1(downloadBean, null), 3, null);
    }
}
