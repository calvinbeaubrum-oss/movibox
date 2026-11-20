package com.transsion.postdetail.video;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.d0;
import com.transsion.baselib.report.RoomActivityLifecycleCallbacks;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsion.moviedetailapi.bean.Cover;
import com.transsion.moviedetailapi.bean.FirstFrame;
import com.transsion.moviedetailapi.bean.Group;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.player.MediaSource;
import com.transsion.player.orplayer.PlayError;
import com.transsion.player.orplayer.e;
import com.transsion.player.orplayer.f;
import com.transsion.player.orplayer.global.TnPlayerManager;
import com.transsion.player.p006enum.ScaleMode;
import com.transsion.postdetail.R$id;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__IndentKt;
import kotlin.text.StringsKt__StringsKt;

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
public final class PostFeedVideoManagerImp extends RecyclerView.r implements b, e, RoomActivityLifecycleCallbacks.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f56224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f56225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.transsion.postdetail.ui.adapter.d f56226c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f56227d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f56228f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f56229g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f56230h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f56231i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f56232j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public f f56233k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public PostFeedVideoView f56234l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.transsion.postdetail.layer.b f56235m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f56236n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f56237o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f56238p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public long f56239q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f56240r;

    public PostFeedVideoManagerImp(Context context, RecyclerView recyclerView, com.transsion.postdetail.ui.adapter.d dVar, String pageName, String subpageName, boolean z11) {
        Intrinsics.g(context, "context");
        Intrinsics.g(pageName, "pageName");
        Intrinsics.g(subpageName, "subpageName");
        this.f56224a = context;
        this.f56225b = recyclerView;
        this.f56226c = dVar;
        this.f56227d = pageName;
        this.f56228f = subpageName;
        this.f56229g = z11;
        this.f56231i = gs.a.a(82);
        this.f56232j = gs.a.a(56);
        this.f56236n = -1;
        this.f56238p = d0.a();
        this.f56240r = true;
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(this);
        }
        RoomActivityLifecycleCallbacks.f51239a.b(this);
        k();
    }

    private final void k() {
        Boolean boolY0;
        boolean zBooleanValue = false;
        ConfigBean configBeanC = ConfigManager.c(ConfigManager.f53111c.a(), "sa_post_video_auto_play", false, 2, null);
        String value = configBeanC != null ? configBeanC.getValue() : null;
        if (value != null && value.length() != 0 && (boolY0 = StringsKt__StringsKt.Y0(value)) != null) {
            zBooleanValue = boolY0.booleanValue();
        }
        this.f56230h = zBooleanValue;
        uo.b.a.f(uo.b.f78622a, "PostFeedVideo", "----------------initConfig, isOpen:" + zBooleanValue, false, 4, null);
    }

    @Override // com.transsion.postdetail.video.b
    public void a() {
        uo.b.a.f(uo.b.f78622a, "PostFeedVideo", "onSetFirstData--checkActiveItemPosition", false, 4, null);
        f();
    }

    @Override // com.transsion.postdetail.video.b
    public void b() {
        f fVar;
        uo.b.a aVar = uo.b.f78622a;
        uo.b.a.f(aVar, "PostFeedVideo", "onPagePause--", false, 4, null);
        f fVar2 = this.f56233k;
        if (fVar2 != null) {
            fVar2.pause();
        }
        String str = this.f56237o;
        if (str == null || (fVar = this.f56233k) == null) {
            return;
        }
        long currentPosition = fVar.getCurrentPosition();
        if (currentPosition > 0) {
            uo.b.a.s(aVar, "PostFeedVideo", "==feedvideo savePlayProgress:" + currentPosition, false, 4, null);
            d.f56247a.c(str, currentPosition);
        }
    }

    @Override // com.transsion.postdetail.video.b
    public void c() {
        Long lB;
        k();
        String str = this.f56237o;
        if (str != null && (lB = d.f56247a.b(str)) != null) {
            long jLongValue = lB.longValue();
            if (jLongValue > 0) {
                uo.b.a.f(uo.b.f78622a, "PostFeedVideo", "==onPageResume seekTo:" + jLongValue, false, 4, null);
                f fVar = this.f56233k;
                if (fVar != null) {
                    fVar.seekTo(jLongValue);
                }
            }
        }
        uo.b.a.f(uo.b.f78622a, "PostFeedVideo", "onPageResume play", false, 4, null);
        f fVar2 = this.f56233k;
        if (fVar2 != null) {
            fVar2.play();
        }
    }

    public final void f() {
        int iFindFirstVisibleItemPosition;
        int iFindLastVisibleItemPosition;
        PostSubjectItem item;
        List<PostSubjectItem> listD;
        RecyclerView recyclerView = this.f56225b;
        RecyclerView.m layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null || (iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition()) > (iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition())) {
            return;
        }
        while (true) {
            View viewFindViewByPosition = linearLayoutManager.findViewByPosition(iFindFirstVisibleItemPosition);
            if (viewFindViewByPosition != null) {
                Rect rect = new Rect();
                viewFindViewByPosition.getGlobalVisibleRect(rect);
                int height = viewFindViewByPosition.getHeight();
                int iD = kotlin.ranges.a.d(rect.bottom - (height / 2), rect.top);
                int size = 0;
                int i11 = this.f56238p - (this.f56229g ? this.f56232j : 0);
                int i12 = this.f56231i;
                int i13 = ((i11 - i12) / 2) + i12;
                int iA = i13 - gs.a.a(200);
                int iA2 = gs.a.a(250) + i13;
                if (this.f56236n == iFindFirstVisibleItemPosition) {
                    uo.b.a.f(uo.b.f78622a, "PostFeedVideo", "triggerVideoPlay position:" + iFindFirstVisibleItemPosition + " same ~ return", false, 4, null);
                } else {
                    com.transsion.postdetail.ui.adapter.d dVar = this.f56226c;
                    if (dVar != null && (listD = dVar.D()) != null) {
                        size = listD.size();
                    }
                    if (iFindFirstVisibleItemPosition >= size) {
                        return;
                    }
                    com.transsion.postdetail.ui.adapter.d dVar2 = this.f56226c;
                    if (dVar2 != null && (item = dVar2.getItem(iFindFirstVisibleItemPosition)) != null && item.isVideo()) {
                        View viewY = this.f56226c.Y(iFindFirstVisibleItemPosition, R$id.flPlayer);
                        FrameLayout frameLayout = viewY instanceof FrameLayout ? (FrameLayout) viewY : null;
                        if (frameLayout == null) {
                            uo.b.a.j(uo.b.f78622a, "PostFeedVideo", "triggerVideoPlay playerContainer is null", false, 4, null);
                        } else {
                            uo.b.a.o(uo.b.f78622a, "PostFeedVideo", new String[]{StringsKt__IndentKt.f("\n                checkActiveItemPosition position:" + iFindFirstVisibleItemPosition + ",  \n                    top:" + rect.top + ", bottom:" + rect.bottom + "\n                    screenCenterTop：" + iA + "   screenCenterBottom：" + iA2 + "\n                    itemHeight:" + height + " viewCenter:" + iD + ", screenCenter:" + i13 + "\n            ")}, false, 4, null);
                            if (Math.abs(i13 - iD) < gs.a.a(100)) {
                                l(iFindFirstVisibleItemPosition, item, frameLayout);
                                return;
                            }
                        }
                    }
                }
            }
            if (iFindFirstVisibleItemPosition == iFindLastVisibleItemPosition) {
                return;
            } else {
                iFindFirstVisibleItemPosition++;
            }
        }
    }

    public final void g(RecyclerView recyclerView) {
        int iFindFirstVisibleItemPosition;
        int iFindLastVisibleItemPosition;
        RecyclerView.m layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null || (iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition()) > (iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition())) {
            return;
        }
        while (true) {
            View viewFindViewByPosition = linearLayoutManager.findViewByPosition(iFindFirstVisibleItemPosition);
            if (viewFindViewByPosition != null) {
                Rect rect = new Rect();
                viewFindViewByPosition.getGlobalVisibleRect(rect);
                if (rect.bottom - rect.top <= viewFindViewByPosition.getHeight() * 0.5f) {
                    i(iFindFirstVisibleItemPosition);
                }
            }
            if (iFindFirstVisibleItemPosition == iFindLastVisibleItemPosition) {
                return;
            } else {
                iFindFirstVisibleItemPosition++;
            }
        }
    }

    public final void h(Context context) {
        if (this.f56233k == null) {
            PostFeedVideoView postFeedVideoView = new PostFeedVideoView(context);
            postFeedVideoView.updateMute(this.f56240r);
            postFeedVideoView.setMuteClickCallback(new Function1<Boolean, Unit>() { // from class: com.transsion.postdetail.video.PostFeedVideoManagerImp$createPlayer$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.f68710a;
                }

                public final void invoke(boolean z11) {
                    uo.b.a.f(uo.b.f78622a, "PostFeedVideo", "volume click isMute:" + z11, false, 4, null);
                    this.this$0.f56240r = z11;
                    f fVar = this.this$0.f56233k;
                    if (fVar != null) {
                        fVar.setMute(z11);
                    }
                }
            });
            this.f56234l = postFeedVideoView;
            f fVarI = TnPlayerManager.f54684a.i();
            uo.b.a.f(uo.b.f78622a, "PostFeedVideo", "createPlayer----", false, 4, null);
            fVarI.addPlayerListener(this);
            PostFeedVideoView postFeedVideoView2 = this.f56234l;
            fVarI.setSurfaceView(postFeedVideoView2 != null ? postFeedVideoView2.getSurfaceView() : null);
            this.f56233k = fVarI;
            com.transsion.postdetail.layer.b bVar = new com.transsion.postdetail.layer.b();
            f fVar = this.f56233k;
            Intrinsics.d(fVar);
            bVar.v(fVar);
            bVar.u(this.f56227d);
            bVar.z(this.f56228f);
            this.f56235m = bVar;
        }
    }

    public final void i(int i11) {
        List<PostSubjectItem> listD;
        try {
            Result.Companion companion = Result.Companion;
            PostFeedVideoView postFeedVideoView = this.f56234l;
            if ((postFeedVideoView != null ? postFeedVideoView.getParent() : null) != null && this.f56236n == i11) {
                com.transsion.postdetail.ui.adapter.d dVar = this.f56226c;
                if (i11 >= ((dVar == null || (listD = dVar.D()) == null) ? 0 : listD.size())) {
                    return;
                }
                com.transsion.postdetail.ui.adapter.d dVar2 = this.f56226c;
                PostSubjectItem item = dVar2 != null ? dVar2.getItem(i11) : null;
                if (item != null && item.isVideo()) {
                    uo.b.a aVar = uo.b.f78622a;
                    Group group = item.getGroup();
                    String name = group != null ? group.getName() : null;
                    uo.b.a.f(aVar, "PostFeedVideo", "position：" + i11 + " --已隐藏超过50%, 移除播放器, " + name + ", " + item.getContent(), false, 4, null);
                    j();
                }
                Result.m163constructorimpl(Unit.f68710a);
            }
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            Result.m163constructorimpl(ResultKt.a(th2));
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void initPlayer() {
        e.a.a(this);
    }

    public final void j() {
        com.transsion.postdetail.layer.b bVar = this.f56235m;
        if (bVar != null) {
            com.transsion.postdetail.layer.b.e(bVar, false, 1, null);
        }
        PostFeedVideoView postFeedVideoView = this.f56234l;
        ViewParent parent = postFeedVideoView != null ? postFeedVideoView.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.f56234l);
        }
        f fVar = this.f56233k;
        if (fVar != null) {
            fVar.stop();
        }
        f fVar2 = this.f56233k;
        if (fVar2 != null) {
            fVar2.reset();
        }
        f fVar3 = this.f56233k;
        if (fVar3 != null) {
            fVar3.clearScreen();
        }
        this.f56236n = -1;
        this.f56237o = null;
        d.f56247a.a();
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0081 A[PHI: r2
  0x0081: PHI (r2v21 java.lang.Integer) = (r2v13 java.lang.Integer), (r2v24 java.lang.Integer) binds: [B:25:0x0098, B:17:0x007f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:34:0x00ae A[PHI: r3
  0x00ae: PHI (r3v23 java.lang.Integer) = (r3v18 java.lang.Integer), (r3v26 java.lang.Integer) binds: [B:41:0x00c5, B:33:0x00ac] A[DONT_GENERATE, DONT_INLINE]] */
    public final void l(int i11, PostSubjectItem postSubjectItem, FrameLayout frameLayout) {
        List<Video> video;
        FirstFrame firstFrame;
        String url;
        Integer height;
        int iIntValue;
        FirstFrame firstFrame2;
        Integer width;
        int iIntValue2;
        FirstFrame firstFrame3;
        String thumbnail;
        Cover cover;
        Cover cover2;
        Cover cover3;
        uo.b.a aVar = uo.b.f78622a;
        String[] strArr = new String[1];
        Group group = postSubjectItem.getGroup();
        Object obj = null;
        String name = group != null ? group.getName() : null;
        strArr[0] = "-------> triggerVideoPlay 播放视频:" + i11 + ", roomName:" + name + ", " + postSubjectItem.getContent();
        uo.b.a.o(aVar, "PostFeedVideo", strArr, false, 4, null);
        j();
        h(this.f56224a);
        frameLayout.addView(this.f56234l);
        this.f56236n = i11;
        this.f56237o = postSubjectItem.getPostId();
        Media media = postSubjectItem.getMedia();
        if (media != null && (firstFrame = media.getFirstFrame()) != null && (url = firstFrame.getUrl()) != null) {
            Media media2 = postSubjectItem.getMedia();
            if (media2 == null || (cover3 = media2.getCover()) == null || (height = cover3.getHeight()) == null) {
                Media media3 = postSubjectItem.getMedia();
                height = (media3 == null || (firstFrame2 = media3.getFirstFrame()) == null) ? null : firstFrame2.getHeight();
                if (height != null) {
                    iIntValue = height.intValue();
                } else {
                    iIntValue = 0;
                }
            } else {
                iIntValue = height.intValue();
            }
            Media media4 = postSubjectItem.getMedia();
            if (media4 == null || (cover2 = media4.getCover()) == null || (width = cover2.getWidth()) == null) {
                Media media5 = postSubjectItem.getMedia();
                width = (media5 == null || (firstFrame3 = media5.getFirstFrame()) == null) ? null : firstFrame3.getWidth();
                if (width != null) {
                    iIntValue2 = width.intValue();
                } else {
                    iIntValue2 = 0;
                }
            } else {
                iIntValue2 = width.intValue();
            }
            PostFeedVideoView postFeedVideoView = this.f56234l;
            if (postFeedVideoView != null) {
                Media media6 = postSubjectItem.getMedia();
                if (media6 == null || (cover = media6.getCover()) == null || (thumbnail = cover.getThumbnail()) == null) {
                    thumbnail = "";
                }
                postFeedVideoView.setCover(url, thumbnail, iIntValue > iIntValue2);
            }
        }
        com.transsion.postdetail.layer.b bVar = this.f56235m;
        if (bVar != null) {
            bVar.g();
        }
        com.transsion.postdetail.layer.b bVar2 = this.f56235m;
        if (bVar2 != null) {
            bVar2.a(0, 0);
        }
        com.transsion.postdetail.layer.b bVar3 = this.f56235m;
        if (bVar3 != null) {
            bVar3.x(postSubjectItem.getPostId(), postSubjectItem);
        }
        Media media7 = postSubjectItem.getMedia();
        if (media7 == null || (video = media7.getVideo()) == null) {
            return;
        }
        for (Object obj2 : video) {
            String url2 = ((Video) obj2).getUrl();
            if (!(url2 == null || url2.length() == 0)) {
                obj = obj2;
                break;
            }
        }
        Video video2 = (Video) obj;
        if (video2 != null) {
            Integer duration = video2.getDuration();
            if (duration != null) {
                int iIntValue3 = duration.intValue();
                PostFeedVideoView postFeedVideoView2 = this.f56234l;
                if (postFeedVideoView2 != null) {
                    postFeedVideoView2.setDurationTime(((long) iIntValue3) * 1000);
                }
            }
            uo.b.a.f(uo.b.f78622a, "PostFeedVideo", "triggerVideoPlay updateMute:" + this.f56240r, false, 4, null);
            PostFeedVideoView postFeedVideoView3 = this.f56234l;
            if (postFeedVideoView3 != null) {
                postFeedVideoView3.updateMute(this.f56240r);
            }
            String url3 = video2.getUrl();
            if (url3 != null) {
                com.transsion.postdetail.layer.b bVar4 = this.f56235m;
                if (bVar4 != null) {
                    bVar4.A(url3);
                }
                f fVar = this.f56233k;
                if (fVar != null) {
                    fVar.setDataSource(new MediaSource(url3, url3, 0, null, null, 28, null));
                }
                f fVar2 = this.f56233k;
                if (fVar2 != null) {
                    fVar2.prepare();
                }
            }
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onAliyunDecodeErrorChangeSoftwareDecoder(MediaSource mediaSource) {
        e.a.b(this, mediaSource);
    }

    @Override // com.transsion.baselib.report.RoomActivityLifecycleCallbacks.a
    public void onBackgroundStatusChange(boolean z11) {
        com.transsion.postdetail.layer.b bVar;
        if (z11 && (bVar = this.f56235m) != null) {
            bVar.d(true);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onBufferedPosition(long j11, MediaSource mediaSource) {
        e.a.c(this, j11, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onCompletion(MediaSource mediaSource) {
        e.a.d(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onFocusChange(boolean z11) {
        e.a.f(this, z11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onIsPlayingChanged(boolean z11) {
        e.a.g(this, z11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingBegin(MediaSource mediaSource) {
        com.transsion.postdetail.layer.b bVar = this.f56235m;
        if (bVar != null) {
            bVar.h();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingEnd(MediaSource mediaSource) {
        com.transsion.postdetail.layer.b bVar = this.f56235m;
        if (bVar != null) {
            bVar.i();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoadingProgress(int i11, float f11, MediaSource mediaSource) {
        e.a.l(this, i11, f11, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onLoopingStart() {
        e.a.n(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onMediaItemTransition(String str) {
        e.a.o(this, str);
    }

    @Override // com.transsion.postdetail.video.b
    public void onPageDestroy() {
        uo.b.a.f(uo.b.f78622a, "PostFeedVideo", "onPageDestroy", false, 4, null);
        RecyclerView recyclerView = this.f56225b;
        if (recyclerView != null) {
            recyclerView.removeOnScrollListener(this);
        }
        f fVar = this.f56233k;
        if (fVar != null) {
            fVar.removePlayerListener(this);
        }
        f fVar2 = this.f56233k;
        if (fVar2 != null) {
            fVar2.stop();
        }
        f fVar3 = this.f56233k;
        if (fVar3 != null) {
            fVar3.reset();
        }
        f fVar4 = this.f56233k;
        if (fVar4 != null) {
            fVar4.release();
        }
        this.f56233k = null;
        PostFeedVideoView postFeedVideoView = this.f56234l;
        ViewParent parent = postFeedVideoView != null ? postFeedVideoView.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.f56234l);
        }
        this.f56234l = null;
        d.f56247a.a();
        RoomActivityLifecycleCallbacks.f51239a.k(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayError(PlayError errorInfo, MediaSource mediaSource) {
        Intrinsics.g(errorInfo, "errorInfo");
        com.transsion.postdetail.layer.b bVar = this.f56235m;
        if (bVar != null) {
            bVar.k(errorInfo);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerRelease(MediaSource mediaSource) {
        e.a.s(this, mediaSource);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPlayerReset() {
        e.a.u(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onPrepare(MediaSource mediaSource) {
        uo.b.a.s(uo.b.f78622a, "PostFeedVideo", "----------onPrepare Position:" + this.f56236n + "， isVideoMute：" + this.f56240r, false, 4, null);
        f fVar = this.f56233k;
        if (fVar != null) {
            fVar.setLooping(true);
        }
        f fVar2 = this.f56233k;
        if (fVar2 != null) {
            fVar2.setScaleMode(ScaleMode.SCALE_ASPECT_FILL);
        }
        PostFeedVideoView postFeedVideoView = this.f56234l;
        if (postFeedVideoView != null) {
            f fVar3 = this.f56233k;
            postFeedVideoView.setProgressMax(fVar3 != null ? (int) fVar3.getDuration() : 100);
        }
        f fVar4 = this.f56233k;
        if (fVar4 != null) {
            fVar4.play();
        }
        f fVar5 = this.f56233k;
        if (fVar5 != null) {
            fVar5.setMute(this.f56240r);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onProgress(long j11, MediaSource mediaSource) {
        PostFeedVideoView postFeedVideoView = this.f56234l;
        if (postFeedVideoView != null) {
            postFeedVideoView.setProgress((int) j11);
        }
        com.transsion.postdetail.layer.b bVar = this.f56235m;
        if (bVar != null) {
            bVar.l(j11);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onRenderFirstFrame() {
        uo.b.a.f(uo.b.f78622a, "PostFeedVideo", "-----onRenderFirstFrame Position:" + this.f56236n, false, 4, null);
        com.transsion.postdetail.layer.b bVar = this.f56235m;
        if (bVar != null) {
            bVar.m();
        }
        PostFeedVideoView postFeedVideoView = this.f56234l;
        if (postFeedVideoView != null) {
            postFeedVideoView.onVideoRenderFirstFrame();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
        Intrinsics.g(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, i11);
        if (this.f56230h && i11 == 0) {
            f();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
        Intrinsics.g(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i11, i12);
        if (this.f56230h) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.f56239q < 100) {
                return;
            }
            this.f56239q = jCurrentTimeMillis;
            g(recyclerView);
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onSetDataSource() {
        e.a.A(this);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksAudioBitrateChange(int i11) {
        e.a.B(this, i11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksChange(ov.c cVar) {
        e.a.C(this, cVar);
    }

    @Override // com.transsion.player.orplayer.e
    public void onTracksVideoBitrateChange(int i11) {
        e.a.D(this, i11);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoPause(MediaSource mediaSource) {
        com.transsion.postdetail.layer.b bVar = this.f56235m;
        if (bVar != null) {
            bVar.n();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoSizeChanged(int i11, int i12) {
        e.a.G(this, i11, i12);
    }

    @Override // com.transsion.player.orplayer.e
    public void onVideoStart(MediaSource mediaSource) {
        uo.b.a.f(uo.b.f78622a, "PostFeedVideo", "-----onVideoStart Position:" + this.f56236n, false, 4, null);
        com.transsion.postdetail.layer.b bVar = this.f56235m;
        if (bVar != null) {
            bVar.o();
        }
    }

    @Override // com.transsion.player.orplayer.e
    public void setOnSeekCompleteListener() {
        e.a.J(this);
    }
}
