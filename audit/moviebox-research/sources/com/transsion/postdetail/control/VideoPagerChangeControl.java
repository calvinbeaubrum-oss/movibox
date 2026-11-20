package com.transsion.postdetail.control;

import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.r;
import androidx.lifecycle.u;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.tn.lib.pager.PagerLayoutManager;
import com.transsion.baselib.report.RoomActivityLifecycleCallbacks;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.FirstFrame;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.moviedetailapi.helper.ListVideoPreloadHelper;
import com.transsion.player.MediaSource;
import com.transsion.player.orplayer.ORPlayerPreloadManager;
import com.transsion.player.orplayer.e;
import com.transsion.player.orplayer.f;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.postdetail.helper.ImmVideoHelper;
import com.transsion.postdetail.ui.view.ImmVideoItemView;
import com.transsion.postdetail.util.l;
import com.transsnet.downloader.manager.DownloadEsHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.j;
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
@SourceDebugExtension
public class VideoPagerChangeControl extends jp.a implements r, RoomActivityLifecycleCallbacks.a {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final a f55006p = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f55007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f55008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.transsion.postdetail.ui.adapter.b f55009c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f55010d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ORPlayerView f55011f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PagerLayoutManager f55012g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f55013h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f55014i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f55015j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f55016k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f55017l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f55018m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f55019n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f55020o;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f55021a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f55021a = iArr;
        }
    }

    /* JADX INFO: renamed from: com.transsion.postdetail.control.VideoPagerChangeControl$onStateChanged$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.postdetail.control.VideoPagerChangeControl$onStateChanged$1", f = "VideoPagerChangeControl.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            ORPlayerPreloadManager.f54651i.a().b();
            return Unit.f68710a;
        }
    }

    public VideoPagerChangeControl(Fragment fragment, boolean z11, com.transsion.postdetail.ui.adapter.b bVar, f fVar, ORPlayerView oRPlayerView, PagerLayoutManager pagerLayoutManager, String str) {
        Intrinsics.g(fragment, "fragment");
        this.f55007a = fragment;
        this.f55008b = z11;
        this.f55009c = bVar;
        this.f55010d = fVar;
        this.f55011f = oRPlayerView;
        this.f55012g = pagerLayoutManager;
        this.f55013h = str;
        this.f55014i = 3;
        this.f55015j = 3000L;
        this.f55017l = true;
        fragment.getLifecycle().a(this);
        g();
    }

    private final void e() {
        h9.f fVarQ;
        com.transsion.postdetail.ui.adapter.b bVar = this.f55009c;
        if (((bVar == null || (fVarQ = bVar.Q()) == null) ? null : fVarQ.i()) == LoadMoreStatus.Fail && com.tn.lib.util.networkinfo.f.f49475a.e()) {
            uo.b.a.f(uo.b.f78622a, "ImmVideoPlayer", "current is fail, try load more", false, 4, null);
            this.f55009c.Q().v();
        }
    }

    private final void g() {
        RoomActivityLifecycleCallbacks.f51239a.b(this);
    }

    private final void h(int i11) {
        PostSubjectItem postSubjectItemO;
        com.transsion.postdetail.ui.adapter.b bVar = this.f55009c;
        if (bVar == null || (postSubjectItemO = bVar.O(i11 + this.f55014i)) == null) {
            return;
        }
        Media media = postSubjectItemO.getMedia();
        Video videoA = l.a(media != null ? media.getVideo() : null);
        if (videoA == null) {
            return;
        }
        n(postSubjectItemO, videoA);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void k(int i11, View view) {
        ORPlayerView oRPlayerView;
        this.f55019n = view;
        uo.b.a.f(uo.b.f78622a, "ImmVideoPlayer", "on page select position = " + i11, false, 4, null);
        f fVar = this.f55010d;
        if (fVar != null) {
            fVar.reset();
        }
        if (i11 >= 0) {
            com.transsion.postdetail.ui.adapter.b bVar = this.f55009c;
            if ((bVar != null ? bVar.getItemCount() : 0) > i11 && (view instanceof ImmVideoItemView)) {
                ImmVideoItemView immVideoItemView = (ImmVideoItemView) view;
                immVideoItemView.setPosition(Integer.valueOf(i11));
                f fVar2 = this.f55010d;
                if (fVar2 != null && (oRPlayerView = this.f55011f) != null) {
                    immVideoItemView.setPlayer(fVar2, oRPlayerView);
                }
                PagerLayoutManager pagerLayoutManager = this.f55012g;
                if (pagerLayoutManager != null) {
                    immVideoItemView.setPagerLayoutManager(pagerLayoutManager);
                }
                f fVar3 = this.f55010d;
                if (fVar3 != null) {
                    fVar3.setPlayerListener((e) view);
                }
                com.transsion.postdetail.ui.adapter.b bVar2 = this.f55009c;
                PostSubjectItem item = bVar2 != null ? bVar2.getItem(i11) : null;
                ORPlayerView oRPlayerView2 = this.f55011f;
                ViewParent parent = oRPlayerView2 != null ? oRPlayerView2.getParent() : null;
                if (parent instanceof FrameLayout) {
                    ((FrameLayout) parent).removeView(this.f55011f);
                }
                immVideoItemView.getPlayerContainer().addView(this.f55011f, new FrameLayout.LayoutParams(-1, -1));
                if (this.f55008b) {
                    this.f55008b = false;
                    immVideoItemView.showCommentDialog();
                }
                immVideoItemView.videoStartPrepare(this.f55013h);
                o(immVideoItemView, item);
                m(i11);
            }
        }
    }

    private final void m(int i11) {
        int i12 = this.f55014i;
        if (i12 > 0 && this.f55009c != null && 1 <= i12) {
            boolean z11 = false;
            int i13 = 1;
            while (true) {
                int i14 = i11 + i13;
                if (i14 >= 0 && this.f55009c.getItemCount() > i14) {
                    PostSubjectItem postSubjectItemO = this.f55009c.O(i14);
                    if (postSubjectItemO != null && !postSubjectItemO.getBuiltIn()) {
                        Media media = postSubjectItemO.getMedia();
                        Video videoA = l.a(media != null ? media.getVideo() : null);
                        if (videoA != null) {
                            uo.b.a.s(uo.b.f78622a, "ImmVideoPlayer", "try preload position = " + i14 + ", duration = " + videoA.getDuration() + ", url = " + videoA.getUrl(), false, 4, null);
                            n(postSubjectItemO, videoA);
                        } else if (i14 == (this.f55014i + i11) - 1) {
                            z11 = true;
                        }
                    }
                    if (i13 == i12) {
                        break;
                    } else {
                        i13++;
                    }
                } else {
                    break;
                }
            }
            if (z11) {
                h(i11);
            }
        }
    }

    @Override // jp.a
    public void b(View view) {
        PagerLayoutManager pagerLayoutManager = this.f55012g;
        if (pagerLayoutManager != null) {
            int iFindFirstVisibleItemPosition = pagerLayoutManager.findFirstVisibleItemPosition();
            uo.b.a.s(uo.b.f78622a, "ImmVideoPlayer", "onInitComplete, position = " + iFindFirstVisibleItemPosition + ", ----- currentPosition = " + this.f55016k, false, 4, null);
            if (this.f55016k == iFindFirstVisibleItemPosition) {
                return;
            }
            if (iFindFirstVisibleItemPosition != -1) {
                this.f55016k = iFindFirstVisibleItemPosition;
            }
            k(this.f55016k, view);
        }
    }

    @Override // jp.a
    public void c(boolean z11, int i11, View view) {
        uo.b.a.s(uo.b.f78622a, "ImmVideoPlayer", "onPageRelease, position = " + i11 + ", ----- currentPosition = " + this.f55016k, false, 4, null);
        if (i11 == this.f55016k) {
            f fVar = this.f55010d;
            if (fVar != null) {
                fVar.stop();
            }
            f fVar2 = this.f55010d;
            if (fVar2 != null) {
                fVar2.reset();
            }
            ORPlayerView oRPlayerView = this.f55011f;
            ViewParent parent = oRPlayerView != null ? oRPlayerView.getParent() : null;
            if (parent instanceof FrameLayout) {
                ((FrameLayout) parent).removeView(this.f55011f);
            }
        }
    }

    @Override // jp.a
    public void d(int i11, boolean z11, View view) {
        e();
        uo.b.a.f(uo.b.f78622a, "ImmVideoPlayer", "onPageSelected, position = " + i11 + ", ----- currentPosition = " + this.f55016k, false, 4, null);
        if (this.f55016k != i11 || this.f55018m) {
            this.f55018m = false;
            this.f55016k = i11;
            ImmVideoHelper.a aVar = ImmVideoHelper.f55024g;
            if (aVar.a().k()) {
                aVar.a().p();
            }
            k(i11, view);
        }
    }

    public final int f() {
        return this.f55016k;
    }

    public final void i() {
        if (this.f55017l) {
            this.f55017l = false;
            m(this.f55016k);
        }
    }

    public final void j(boolean z11) {
        this.f55020o = z11;
        if (z11) {
            View view = this.f55019n;
            ImmVideoItemView immVideoItemView = view instanceof ImmVideoItemView ? (ImmVideoItemView) view : null;
            if (immVideoItemView != null) {
                immVideoItemView.app2Background();
            }
        }
    }

    public final void l() {
        this.f55018m = true;
    }

    public final void n(PostSubjectItem postSubjectItem, Video video) {
        FirstFrame firstFrame;
        String url;
        String url2 = video.getUrl();
        if (url2 != null) {
            ORPlayerPreloadManager.f54651i.a().h(url2, this.f55015j);
        }
        Media media = postSubjectItem.getMedia();
        if (media == null || (firstFrame = media.getFirstFrame()) == null || (url = firstFrame.getUrl()) == null) {
            return;
        }
        ImageHelper.Companion companion = ImageHelper.f51371a;
        ListVideoPreloadHelper.a aVar = ListVideoPreloadHelper.f53890f;
        ImageHelper.Companion.x(companion, companion.e(url, (124 & 2) != 0 ? 0 : aVar.a(), (124 & 4) != 0 ? 0 : aVar.a(), (124 & 8) != 0, (124 & 16) != 0 ? false : true, (124 & 32) == 0 ? false : false, (124 & 64) != 0 ? 25 : 0), url, aVar.a(), null, 8, null);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x00a7  */
    public final void o(ImmVideoItemView view, PostSubjectItem postSubjectItem) {
        String url;
        String url2;
        String str;
        boolean z11;
        Subject subject;
        Media media;
        Intrinsics.g(view, "view");
        Video videoA = l.a((postSubjectItem == null || (media = postSubjectItem.getMedia()) == null) ? null : media.getVideo());
        uo.b.a aVar = uo.b.f78622a;
        uo.b.a.f(aVar, "ImmVideoPlayer", "play url=" + (videoA != null ? videoA.getUrl() : null) + "  width:" + (videoA != null ? videoA.getWidth() : null) + ",height:" + (videoA != null ? videoA.getHeight() : null) + ", duration: " + (videoA != null ? videoA.getDuration() : null) + ", builtIn = " + (postSubjectItem != null ? Boolean.valueOf(postSubjectItem.getBuiltIn()) : null), false, 4, null);
        f fVar = this.f55010d;
        if (fVar != null) {
            if (postSubjectItem == null || (subject = postSubjectItem.getSubject()) == null) {
                z11 = false;
            } else {
                Integer subjectType = subject.getSubjectType();
                int value = SubjectType.SHORT_TV.getValue();
                if (subjectType != null && subjectType.intValue() == value) {
                    z11 = true;
                } else {
                    z11 = false;
                }
            }
            fVar.setLooping(!z11);
        }
        if (postSubjectItem == null || !postSubjectItem.getBuiltIn()) {
            if (videoA == null || (url = videoA.getUrl()) == null) {
                return;
            }
            f fVar2 = this.f55010d;
            if (fVar2 != null) {
                fVar2.setDataSource(new MediaSource(url, url, 0, null, null, 28, null));
            }
            f fVar3 = this.f55010d;
            if (fVar3 != null) {
                fVar3.prepare();
            }
            view.setVideoUrl(url);
            ORPlayerPreloadManager.f54651i.a().e(url);
            return;
        }
        if (videoA == null || (url2 = videoA.getUrl()) == null) {
            return;
        }
        if (kotlin.text.l.L(url2, "main/", false, 2, null)) {
            String absolutePath = DownloadEsHelper.f60994m.a().c().getAbsolutePath();
            String title = postSubjectItem.getTitle();
            if (title == null) {
                Subject subject2 = postSubjectItem.getSubject();
                String title2 = subject2 != null ? subject2.getTitle() : null;
                title = title2 == null ? "" : title2;
            }
            String str2 = absolutePath + "/" + (title + ".mp4");
            videoA.setUrl(str2);
            str = str2;
        } else {
            str = url2;
        }
        uo.b.a.f(aVar, "ImmVideoPlayer", "play url= " + str, false, 4, null);
        f fVar4 = this.f55010d;
        if (fVar4 != null) {
            fVar4.setDataSource(new MediaSource(str, str, 0, null, null, 28, null));
        }
        f fVar5 = this.f55010d;
        if (fVar5 != null) {
            fVar5.prepare();
        }
        view.setVideoUrl(url2);
    }

    @Override // com.transsion.baselib.report.RoomActivityLifecycleCallbacks.a
    public void onBackgroundStatusChange(boolean z11) {
        if (z11 && !this.f55020o) {
            View view = this.f55019n;
            ImmVideoItemView immVideoItemView = view instanceof ImmVideoItemView ? (ImmVideoItemView) view : null;
            if (immVideoItemView != null) {
                immVideoItemView.app2Background();
            }
        }
    }

    @Override // androidx.lifecycle.r
    public void onStateChanged(u source, Lifecycle.Event event) {
        Intrinsics.g(source, "source");
        Intrinsics.g(event, "event");
        int i11 = b.f55021a[event.ordinal()];
        if (i11 == 1) {
            ORPlayerPreloadManager.f54651i.a().f();
            return;
        }
        if (i11 == 2) {
            ORPlayerPreloadManager.f54651i.a().i();
        } else {
            if (i11 != 3) {
                return;
            }
            RoomActivityLifecycleCallbacks.f51239a.k(this);
            this.f55019n = null;
            this.f55007a.getLifecycle().d(this);
            j.d(l0.a(w0.b()), null, null, new AnonymousClass1(null), 3, null);
        }
    }
}
