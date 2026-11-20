package com.transsion.postdetail.control;

import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.r;
import androidx.lifecycle.u;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.tn.lib.pager.PagerLayoutManager;
import com.transsion.baselib.report.RoomActivityLifecycleCallbacks;
import com.transsion.baselib.report.m;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.moviedetailapi.SubjectType;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PreVideoAddress;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Trailer;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.moviedetailapi.helper.ListVideoPreloadHelper;
import com.transsion.player.MediaSource;
import com.transsion.player.orplayer.ORPlayerPreloadManager;
import com.transsion.player.orplayer.e;
import com.transsion.player.orplayer.f;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.postdetail.helper.ImmVideoHelper;
import com.transsion.postdetail.ui.adapter.g;
import com.transsion.postdetail.ui.view.ShortTvImmVideoItemView;
import com.transsnet.downloader.manager.DownloadEsHelper;
import java.util.List;
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
import kotlin.text.l;
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
public class SubjectVideoPagerChangeControl extends jp.a implements r, RoomActivityLifecycleCallbacks.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final a f54991o = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f54992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f54993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f54994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ORPlayerView f54995d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public PagerLayoutManager f54996f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f54997g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f54998h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f54999i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f55000j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f55001k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f55002l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final String f55003m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f55004n;

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
        public static final /* synthetic */ int[] f55005a;

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
            f55005a = iArr;
        }
    }

    /* JADX INFO: renamed from: com.transsion.postdetail.control.SubjectVideoPagerChangeControl$onStateChanged$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.postdetail.control.SubjectVideoPagerChangeControl$onStateChanged$1", f = "SubjectVideoPagerChangeControl.kt", l = {}, m = "invokeSuspend")
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

    public SubjectVideoPagerChangeControl(Fragment fragment, g gVar, f fVar, ORPlayerView oRPlayerView, PagerLayoutManager pagerLayoutManager) {
        Intrinsics.g(fragment, "fragment");
        this.f54992a = fragment;
        this.f54993b = gVar;
        this.f54994c = fVar;
        this.f54995d = oRPlayerView;
        this.f54996f = pagerLayoutManager;
        this.f54997g = 3;
        this.f54998h = 3000L;
        this.f55000j = true;
        fragment.getLifecycle().a(this);
        k();
        this.f55003m = m.f51277a.f();
    }

    @Override // jp.a
    public void b(View view) {
        PagerLayoutManager pagerLayoutManager = this.f54996f;
        if (pagerLayoutManager != null) {
            int iFindFirstVisibleItemPosition = pagerLayoutManager.findFirstVisibleItemPosition();
            uo.b.a.s(uo.b.f78622a, "ShortTvImmVideoPlayer", "onInitComplete, position = " + iFindFirstVisibleItemPosition + ", ----- currentPosition = " + this.f54999i, false, 4, null);
            if (this.f54999i == iFindFirstVisibleItemPosition) {
                return;
            }
            if (iFindFirstVisibleItemPosition != -1) {
                this.f54999i = iFindFirstVisibleItemPosition;
            }
            o(this.f54999i, view);
        }
    }

    @Override // jp.a
    public void c(boolean z11, int i11, View view) {
        uo.b.a.s(uo.b.f78622a, "ShortTvImmVideoPlayer", "onPageRelease, position = " + i11 + ", ----- currentPosition = " + this.f54999i, false, 4, null);
        if (i11 == this.f54999i) {
            u();
            ORPlayerView oRPlayerView = this.f54995d;
            ViewParent parent = oRPlayerView != null ? oRPlayerView.getParent() : null;
            if (parent instanceof FrameLayout) {
                ((FrameLayout) parent).removeView(this.f54995d);
            }
        }
    }

    @Override // jp.a
    public void d(int i11, boolean z11, View view) {
        f();
        uo.b.a.f(uo.b.f78622a, "ShortTvImmVideoPlayer", "onPageSelected, position = " + i11 + ", ----- currentPosition = " + this.f54999i, false, 4, null);
        if (this.f54999i != i11 || this.f55001k) {
            this.f55001k = false;
            this.f54999i = i11;
            ImmVideoHelper.a aVar = ImmVideoHelper.f55024g;
            if (aVar.a().k()) {
                aVar.a().p();
            }
            o(i11, view);
        }
    }

    public void e(List<? extends Subject> data) {
        Intrinsics.g(data, "data");
        g gVar = this.f54993b;
        if (gVar != null) {
            gVar.m(data);
        }
    }

    public final void f() {
        h9.f fVarQ;
        g gVar = this.f54993b;
        if (((gVar == null || (fVarQ = gVar.Q()) == null) ? null : fVarQ.i()) == LoadMoreStatus.Fail && com.tn.lib.util.networkinfo.f.f49475a.e()) {
            uo.b.a.f(uo.b.f78622a, "ShortTvImmVideoPlayer", "current is fail, try load more", false, 4, null);
            this.f54993b.Q().v();
        }
    }

    public final int g() {
        return this.f54999i;
    }

    public final Fragment h() {
        return this.f54992a;
    }

    public final f i() {
        return this.f54994c;
    }

    public final Video j(Subject subject) {
        Media video;
        PreVideoAddress videoAddress;
        if (subject == null) {
            return null;
        }
        Trailer trailer = subject.getTrailer();
        if ((trailer != null ? trailer.getVideoAddress() : null) != null) {
            Trailer trailer2 = subject.getTrailer();
            if (trailer2 == null || (videoAddress = trailer2.getVideoAddress()) == null) {
                return null;
            }
            return xu.b.a(videoAddress);
        }
        ShortTVItem shortTVFirstEp = subject.getShortTVFirstEp();
        if (shortTVFirstEp == null || (video = shortTVFirstEp.getVideo()) == null) {
            return null;
        }
        return video.getVideoAddress();
    }

    public final void k() {
        RoomActivityLifecycleCallbacks.f51239a.b(this);
    }

    public void l(int i11) {
        Subject subjectO;
        Video videoJ;
        g gVar = this.f54993b;
        if (gVar == null || (subjectO = gVar.O(i11 + this.f54997g)) == null || (videoJ = j(subjectO)) == null) {
            return;
        }
        r(subjectO, videoJ);
    }

    public final void m() {
        if (this.f55000j) {
            this.f55000j = false;
            q(this.f54999i);
        }
    }

    public final void n(boolean z11) {
        this.f55004n = z11;
        if (z11) {
            View view = this.f55002l;
            ShortTvImmVideoItemView shortTvImmVideoItemView = view instanceof ShortTvImmVideoItemView ? (ShortTvImmVideoItemView) view : null;
            if (shortTvImmVideoItemView != null) {
                shortTvImmVideoItemView.app2Background();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void o(int i11, View view) {
        RecyclerView recyclerViewW;
        ORPlayerView oRPlayerView;
        this.f55002l = view;
        uo.b.a.f(uo.b.f78622a, "ImmVideoPlayer", "on page select position = " + i11, false, 4, null);
        s();
        if (i11 >= 0) {
            g gVar = this.f54993b;
            int height = 0;
            if ((gVar != null ? gVar.getItemCount() : 0) > i11 && (view instanceof ShortTvImmVideoItemView)) {
                ShortTvImmVideoItemView shortTvImmVideoItemView = (ShortTvImmVideoItemView) view;
                shortTvImmVideoItemView.setPosition(Integer.valueOf(i11));
                f fVar = this.f54994c;
                if (fVar != null && (oRPlayerView = this.f54995d) != null) {
                    shortTvImmVideoItemView.setPlayer(fVar, oRPlayerView);
                }
                PagerLayoutManager pagerLayoutManager = this.f54996f;
                if (pagerLayoutManager != null) {
                    shortTvImmVideoItemView.setPagerLayoutManager(pagerLayoutManager);
                }
                f fVar2 = this.f54994c;
                if (fVar2 != null) {
                    fVar2.setPlayerListener((e) view);
                }
                g gVar2 = this.f54993b;
                Subject item = gVar2 != null ? gVar2.getItem(i11) : null;
                ORPlayerView oRPlayerView2 = this.f54995d;
                ViewParent parent = oRPlayerView2 != null ? oRPlayerView2.getParent() : null;
                if (parent instanceof FrameLayout) {
                    ((FrameLayout) parent).removeView(this.f54995d);
                }
                ORPlayerView oRPlayerView3 = this.f54995d;
                Video videoJ = j(item);
                g gVar3 = this.f54993b;
                if (gVar3 != null && (recyclerViewW = gVar3.W()) != null) {
                    height = recyclerViewW.getHeight();
                }
                shortTvImmVideoItemView.addVideoView(oRPlayerView3, videoJ, height);
                shortTvImmVideoItemView.videoStartPrepare(this.f55003m);
                v(shortTvImmVideoItemView, item);
                q(i11);
            }
        }
    }

    @Override // com.transsion.baselib.report.RoomActivityLifecycleCallbacks.a
    public void onBackgroundStatusChange(boolean z11) {
        if (z11 && !this.f55004n) {
            View view = this.f55002l;
            ShortTvImmVideoItemView shortTvImmVideoItemView = view instanceof ShortTvImmVideoItemView ? (ShortTvImmVideoItemView) view : null;
            if (shortTvImmVideoItemView != null) {
                shortTvImmVideoItemView.app2Background();
            }
        }
    }

    @Override // androidx.lifecycle.r
    public void onStateChanged(u source, Lifecycle.Event event) {
        Intrinsics.g(source, "source");
        Intrinsics.g(event, "event");
        int i11 = b.f55005a[event.ordinal()];
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
            this.f55002l = null;
            this.f54992a.getLifecycle().d(this);
            j.d(l0.a(w0.b()), null, null, new AnonymousClass1(null), 3, null);
        }
    }

    public final void p() {
        this.f55001k = true;
    }

    public void q(int i11) {
        int i12 = this.f54997g;
        if (i12 > 0 && this.f54993b != null && 1 <= i12) {
            boolean z11 = false;
            int i13 = 1;
            while (true) {
                int i14 = i11 + i13;
                if (i14 >= 0 && this.f54993b.getItemCount() > i14) {
                    Subject subjectO = this.f54993b.O(i14);
                    if (subjectO != null && !subjectO.getBuiltIn()) {
                        Video videoJ = j(subjectO);
                        if (videoJ != null) {
                            uo.b.a.s(uo.b.f78622a, "ShortTvImmVideoPlayer", "try preload position = " + i14 + ", duration = " + videoJ.getDuration() + ", url = " + videoJ.getUrl(), false, 4, null);
                            r(subjectO, videoJ);
                        } else if (i14 == (this.f54997g + i11) - 1) {
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
                l(i11);
            }
        }
    }

    public void r(Subject item, Video video) {
        Media video2;
        Cover cover;
        String url;
        Intrinsics.g(item, "item");
        Intrinsics.g(video, "video");
        String url2 = video.getUrl();
        if (url2 != null) {
            ORPlayerPreloadManager.f54651i.a().h(url2, this.f54998h);
        }
        ShortTVItem shortTVFirstEp = item.getShortTVFirstEp();
        if (shortTVFirstEp == null || (video2 = shortTVFirstEp.getVideo()) == null || (cover = video2.getCover()) == null || (url = cover.getUrl()) == null) {
            return;
        }
        ImageHelper.Companion companion = ImageHelper.f51371a;
        ListVideoPreloadHelper.a aVar = ListVideoPreloadHelper.f53890f;
        ImageHelper.Companion.x(companion, companion.e(url, (124 & 2) != 0 ? 0 : aVar.a(), (124 & 4) != 0 ? 0 : aVar.a(), (124 & 8) != 0, (124 & 16) != 0 ? false : true, (124 & 32) == 0 ? false : false, (124 & 64) != 0 ? 25 : 0), url, aVar.a(), null, 8, null);
    }

    public void s() {
        f fVar = this.f54994c;
        if (fVar != null) {
            fVar.reset();
        }
    }

    public final void t(View view) {
        this.f55002l = view;
    }

    public void u() {
        f fVar = this.f54994c;
        if (fVar != null) {
            fVar.stop();
        }
        f fVar2 = this.f54994c;
        if (fVar2 != null) {
            fVar2.reset();
        }
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0095  */
    public void v(ShortTvImmVideoItemView view, Subject subject) {
        String url;
        String url2;
        String str;
        boolean z11;
        Intrinsics.g(view, "view");
        Video videoJ = j(subject);
        uo.b.a aVar = uo.b.f78622a;
        uo.b.a.f(aVar, "ImmVideoPlayer", "play url=" + (videoJ != null ? videoJ.getUrl() : null) + "  width:" + (videoJ != null ? videoJ.getWidth() : null) + ",height:" + (videoJ != null ? videoJ.getHeight() : null) + ", duration: " + (videoJ != null ? videoJ.getDuration() : null) + ", builtIn = " + (subject != null ? Boolean.valueOf(subject.getBuiltIn()) : null), false, 4, null);
        f fVar = this.f54994c;
        if (fVar != null) {
            if (subject != null) {
                Integer subjectType = subject.getSubjectType();
                int value = SubjectType.SHORT_TV.getValue();
                if (subjectType != null && subjectType.intValue() == value) {
                    z11 = true;
                } else {
                    z11 = false;
                }
            } else {
                z11 = false;
            }
            fVar.setLooping(!z11);
        }
        if (subject == null || !subject.getBuiltIn()) {
            if (videoJ == null || (url = videoJ.getUrl()) == null) {
                return;
            }
            f fVar2 = this.f54994c;
            if (fVar2 != null) {
                fVar2.setDataSource(new MediaSource(url, url, 0, null, null, 28, null));
            }
            f fVar3 = this.f54994c;
            if (fVar3 != null) {
                fVar3.prepare();
            }
            view.setVideoUrl(url);
            ORPlayerPreloadManager.f54651i.a().e(url);
            return;
        }
        if (videoJ == null || (url2 = videoJ.getUrl()) == null) {
            return;
        }
        if (l.L(url2, "main/", false, 2, null)) {
            String absolutePath = DownloadEsHelper.f60994m.a().c().getAbsolutePath();
            String title = subject.getTitle();
            if (title == null) {
                title = "";
            }
            String str2 = absolutePath + "/" + (title + ".mp4");
            videoJ.setUrl(str2);
            str = str2;
        } else {
            str = url2;
        }
        uo.b.a.f(aVar, "ImmVideoPlayer", "play url= " + str, false, 4, null);
        f fVar4 = this.f54994c;
        if (fVar4 != null) {
            fVar4.setDataSource(new MediaSource(str, str, 0, null, null, 28, null));
        }
        f fVar5 = this.f54994c;
        if (fVar5 != null) {
            fVar5.prepare();
        }
        view.setVideoUrl(url2);
    }
}
