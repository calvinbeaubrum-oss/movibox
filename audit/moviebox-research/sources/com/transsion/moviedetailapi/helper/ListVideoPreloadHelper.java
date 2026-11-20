package com.transsion.moviedetailapi.helper;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.d0;
import com.tn.lib.util.networkinfo.f;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import com.transsion.moviedetailapi.bean.FirstFrame;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.moviedetailapi.bean.Subject;
import com.transsion.moviedetailapi.bean.Video;
import com.transsion.player.orplayer.ORPlayerPreloadManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt__StringsKt;

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
public final class ListVideoPreloadHelper extends RecyclerView.r {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f53890f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Lazy<Integer> f53891g = LazyKt__LazyJVMKt.b(new Function0<Integer>() { // from class: com.transsion.moviedetailapi.helper.ListVideoPreloadHelper$Companion$videoCoverW$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Integer invoke() {
            return Integer.valueOf(d0.e());
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f53892a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<Integer, PostSubjectItem> f53893b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f53894c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f53895d;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return ((Number) ListVideoPreloadHelper.f53891g.getValue()).intValue();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ListVideoPreloadHelper(float f11, Function1<? super Integer, PostSubjectItem> getItemCallback) {
        String value;
        Boolean boolY0;
        Intrinsics.g(getItemCallback, "getItemCallback");
        this.f53892a = f11;
        this.f53893b = getItemCallback;
        this.f53894c = "ListVideoPreload";
        boolean zBooleanValue = false;
        ConfigBean configBeanB = ConfigManager.f53111c.a().b("feed_video_preload_switch", false);
        if (configBeanB != null && (value = configBeanB.getValue()) != null && (boolY0 = StringsKt__StringsKt.Y0(value)) != null) {
            zBooleanValue = boolY0.booleanValue();
        }
        this.f53895d = zBooleanValue;
    }

    public final float e(View view) {
        if (view == null) {
            return 0.0f;
        }
        int height = view.getHeight();
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            return (float) ((((double) rect.height()) * 1.0d) / ((double) height));
        }
        return 0.0f;
    }

    public final Video f(List<Video> list) {
        Video video = null;
        if (list != null) {
            for (Video video2 : list) {
                Integer definition = video2.getDefinition();
                if (definition != null && definition.intValue() == 3) {
                    video = video2;
                }
            }
        }
        if (video == null && list != null && (!list.isEmpty())) {
            video = list.get(0);
        }
        return video;
    }

    public final void g(PostSubjectItem postSubjectItem) {
        FirstFrame firstFrame;
        String url;
        Media media = postSubjectItem.getMedia();
        if (media == null || (firstFrame = media.getFirstFrame()) == null || (url = firstFrame.getUrl()) == null) {
            return;
        }
        ImageHelper.Companion companion = ImageHelper.f51371a;
        a aVar = f53890f;
        ImageHelper.Companion.x(companion, companion.e(url, (124 & 2) != 0 ? 0 : aVar.a(), (124 & 4) != 0 ? 0 : aVar.a(), (124 & 8) != 0, (124 & 16) != 0 ? false : true, (124 & 32) == 0 ? false : false, (124 & 64) != 0 ? 25 : 0), url, aVar.a(), null, 8, null);
    }

    public final void h(PostSubjectItem postSubjectItem) {
        String url;
        Media media = postSubjectItem.getMedia();
        Video videoF = f(media != null ? media.getVideo() : null);
        if (videoF == null || (url = videoF.getUrl()) == null) {
            return;
        }
        ORPlayerPreloadManager.f54651i.a().g(url);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
        int iFindFirstVisibleItemPosition;
        int iFindLastVisibleItemPosition;
        Media media;
        Intrinsics.g(recyclerView, "recyclerView");
        super.onScrollStateChanged(recyclerView, i11);
        if (i11 != 0 || !this.f53895d || !f.f49475a.e()) {
            return;
        }
        RecyclerView.m layoutManager = recyclerView.getLayoutManager();
        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
        if (linearLayoutManager == null || (iFindFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition()) > (iFindLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition())) {
            return;
        }
        int i12 = iFindFirstVisibleItemPosition;
        while (true) {
            uo.b.a aVar = uo.b.f78622a;
            uo.b.a.f(aVar, this.f53894c, "on scroll idle, firstPosition = " + iFindFirstVisibleItemPosition + ", lastPosition = " + iFindLastVisibleItemPosition + ", position = " + i12, false, 4, null);
            try {
                PostSubjectItem postSubjectItemInvoke = this.f53893b.invoke(Integer.valueOf(i12));
                if (Intrinsics.b((postSubjectItemInvoke == null || (media = postSubjectItemInvoke.getMedia()) == null) ? null : media.getMediaType(), MediaType.VIDEO.getValue()) && !postSubjectItemInvoke.getBuiltIn()) {
                    View viewFindViewByPosition = linearLayoutManager.findViewByPosition(i12);
                    float fE = e(viewFindViewByPosition);
                    float f11 = this.f53892a;
                    if (f11 > 0.6f) {
                        f11 = 0.6f;
                    }
                    if (fE >= f11) {
                        String str = this.f53894c;
                        Subject subject = postSubjectItemInvoke.getSubject();
                        uo.b.a.f(aVar, str, "tryPreloadVideo, position = " + i12 + ", title = " + (subject != null ? subject.getTitle() : null), false, 4, null);
                        g(postSubjectItemInvoke);
                    }
                    if (e(viewFindViewByPosition) >= this.f53892a) {
                        String str2 = this.f53894c;
                        Subject subject2 = postSubjectItemInvoke.getSubject();
                        uo.b.a.f(aVar, str2, "tryPreloadVideo, position = " + i12 + ", title = " + (subject2 != null ? subject2.getTitle() : null), false, 4, null);
                        h(postSubjectItemInvoke);
                    }
                }
            } catch (Throwable unused) {
            }
            if (i12 == iFindLastVisibleItemPosition) {
                return;
            } else {
                i12++;
            }
        }
    }
}
