package com.transsion.postdetail.control;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.u;
import com.tn.lib.pager.PagerLayoutManager;
import com.transsion.baselib.report.RoomActivityLifecycleCallbacks;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.ShortTVItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.player.MediaSource;
import com.transsion.player.orplayer.f;
import com.transsion.player.shorttv.preload.VideoPreloadManager;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.postdetail.ui.adapter.g;
import com.transsion.postdetail.ui.view.ShortTvImmVideoItemView;
import com.transsnet.downloader.manager.DownloadEsHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;

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
public final class a extends SubjectVideoPagerChangeControl {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final C0587a f55022p = new C0587a(null);

    /* JADX INFO: renamed from: com.transsion.postdetail.control.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0587a {
        public C0587a() {
        }

        public /* synthetic */ C0587a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(Subject subject) {
            String url;
            ShortTVItem shortTVFirstEp;
            Media video;
            Video videoAddress = (subject == null || (shortTVFirstEp = subject.getShortTVFirstEp()) == null || (video = shortTVFirstEp.getVideo()) == null) ? null : video.getVideoAddress();
            if (subject == null || !subject.getBuiltIn()) {
                if (videoAddress != null) {
                    return videoAddress.getUrl();
                }
                return null;
            }
            if (videoAddress == null || (url = videoAddress.getUrl()) == null) {
                return null;
            }
            if (!l.L(url, "main/", false, 2, null)) {
                return url;
            }
            String absolutePath = DownloadEsHelper.f60994m.a().c().getAbsolutePath();
            String title = subject.getTitle();
            if (title == null) {
                title = "";
            }
            String str = absolutePath + "/" + (title + ".mp4");
            videoAddress.setUrl(str);
            return str;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f55023a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f55023a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Fragment fragment, g gVar, f fVar, ORPlayerView oRPlayerView, PagerLayoutManager pagerLayoutManager) {
        super(fragment, gVar, fVar, oRPlayerView, pagerLayoutManager);
        Intrinsics.g(fragment, "fragment");
    }

    @Override // com.transsion.postdetail.control.SubjectVideoPagerChangeControl, jp.a
    public void c(boolean z11, int i11, View view) {
        super.c(z11, i11, view);
        if (view instanceof ShortTvImmVideoItemView) {
            ((ShortTvImmVideoItemView) view).onPlayerReset();
        }
    }

    @Override // com.transsion.postdetail.control.SubjectVideoPagerChangeControl
    public void e(List<? extends Subject> datas) {
        f fVarI;
        f fVarI2;
        Media video;
        Intrinsics.g(datas, "datas");
        super.e(datas);
        boolean z11 = false;
        for (Subject subject : datas) {
            ShortTVItem shortTVFirstEp = subject.getShortTVFirstEp();
            Video videoAddress = (shortTVFirstEp == null || (video = shortTVFirstEp.getVideo()) == null) ? null : video.getVideoAddress();
            uo.b.a aVar = uo.b.f78622a;
            String url = videoAddress != null ? videoAddress.getUrl() : null;
            Integer width = videoAddress != null ? videoAddress.getWidth() : null;
            Integer height = videoAddress != null ? videoAddress.getHeight() : null;
            Integer duration = videoAddress != null ? videoAddress.getDuration() : null;
            uo.b.a.f(aVar, "ShortTvImmVideoPlayer", "play url=" + url + "  width:" + width + ",height:" + height + ", duration: " + duration + ", builtIn = " + Boolean.valueOf(subject.getBuiltIn()), false, 4, null);
            String strA = f55022p.a(subject);
            if (strA != null && (fVarI2 = i()) != null) {
                ShortTVItem shortTVFirstEp2 = subject.getShortTVFirstEp();
                boolean zAddDataSource = fVarI2.addDataSource(new MediaSource(shortTVFirstEp2 != null ? shortTVFirstEp2.getId() : null, strA, 0, null, null, 28, null));
                if (!z11) {
                    z11 = zAddDataSource;
                }
            }
        }
        if (!z11 || (fVarI = i()) == null) {
            return;
        }
        fVarI.prepare();
    }

    @Override // com.transsion.postdetail.control.SubjectVideoPagerChangeControl
    public void l(int i11) {
    }

    @Override // com.transsion.postdetail.control.SubjectVideoPagerChangeControl
    public void o(int i11, View view) {
        super.o(i11, view);
    }

    @Override // com.transsion.postdetail.control.SubjectVideoPagerChangeControl, androidx.lifecycle.r
    public void onStateChanged(u source, Lifecycle.Event event) {
        Intrinsics.g(source, "source");
        Intrinsics.g(event, "event");
        if (b.f55023a[event.ordinal()] == 1) {
            RoomActivityLifecycleCallbacks.f51239a.k(this);
            t(null);
            h().getLifecycle().d(this);
            f fVarI = i();
            if (fVarI != null) {
                fVarI.release();
            }
        }
    }

    @Override // com.transsion.postdetail.control.SubjectVideoPagerChangeControl
    public void q(int i11) {
    }

    @Override // com.transsion.postdetail.control.SubjectVideoPagerChangeControl
    public void r(Subject item, Video video) {
        Intrinsics.g(item, "item");
        Intrinsics.g(video, "video");
    }

    @Override // com.transsion.postdetail.control.SubjectVideoPagerChangeControl
    public void s() {
    }

    @Override // com.transsion.postdetail.control.SubjectVideoPagerChangeControl
    public void u() {
        f fVarI = i();
        if (fVarI != null) {
            fVarI.pause();
        }
    }

    @Override // com.transsion.postdetail.control.SubjectVideoPagerChangeControl
    public void v(ShortTvImmVideoItemView view, Subject subject) {
        ShortTVItem shortTVFirstEp;
        Media video;
        Intrinsics.g(view, "view");
        Video videoAddress = (subject == null || (shortTVFirstEp = subject.getShortTVFirstEp()) == null || (video = shortTVFirstEp.getVideo()) == null) ? null : video.getVideoAddress();
        uo.b.a.f(uo.b.f78622a, "ShortTvImmVideoPlayer", "play url=" + (videoAddress != null ? videoAddress.getUrl() : null) + "  width:" + (videoAddress != null ? videoAddress.getWidth() : null) + ",height:" + (videoAddress != null ? videoAddress.getHeight() : null) + ", duration: " + (videoAddress != null ? videoAddress.getDuration() : null) + ", builtIn = " + (subject != null ? Boolean.valueOf(subject.getBuiltIn()) : null), false, 4, null);
        String strA = f55022p.a(subject);
        if (strA == null) {
            f fVarI = i();
            if (fVarI != null) {
                fVarI.pause();
                return;
            }
            return;
        }
        f fVarI2 = i();
        if (fVarI2 != null) {
            fVarI2.seekTo(VideoPreloadManager.f54774a.G(strA), 0L);
        }
        f fVarI3 = i();
        if (fVarI3 != null) {
            fVarI3.play();
        }
        view.setVideoUrl(strA);
    }
}
