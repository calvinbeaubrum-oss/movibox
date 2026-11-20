package bv;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.moviedetailapi.bean.GifBean;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.moviedetailapi.bean.Media;
import com.transsion.moviedetailapi.bean.MediaType;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.ninegridview.R$id;
import com.transsion.ninegridview.video.NineGridItemView;
import com.transsion.ninegridview.video.NineGridVideoView;
import com.transsion.player.MediaSource;
import com.transsion.player.orplayer.ORPlayerPreloadManager;
import com.transsion.player.orplayer.f;
import com.transsion.player.ui.ORPlayerView;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.g;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final C0150a f14413i = new C0150a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f14414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ORPlayerView f14415b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14417d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PostSubjectItem f14418e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f14419f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f14420g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f14416c = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map<String, Boolean> f14421h = new LinkedHashMap();

    /* JADX INFO: renamed from: bv.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0150a {
        public C0150a() {
        }

        public /* synthetic */ C0150a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(f fVar, ORPlayerView oRPlayerView) {
        this.f14414a = fVar;
        this.f14415b = oRPlayerView;
    }

    public final void A(NineGridItemView nineGridItemView) {
        ShapeableImageView shapeableImageView = nineGridItemView != null ? (ShapeableImageView) nineGridItemView.findViewById(R$id.video_cover) : null;
        FrameLayout frameLayout = nineGridItemView != null ? (FrameLayout) nineGridItemView.findViewById(R$id.video_container) : null;
        ORPlayerView oRPlayerView = this.f14415b;
        ViewParent parent = oRPlayerView != null ? oRPlayerView.getParent() : null;
        if (parent instanceof FrameLayout) {
            FrameLayout frameLayout2 = (FrameLayout) parent;
            frameLayout2.removeView(this.f14415b);
            ViewParent parent2 = frameLayout2.getParent();
            if (parent2 instanceof FrameLayout) {
                FrameLayout frameLayout3 = (FrameLayout) parent2;
                ShapeableImageView shapeableImageView2 = (ShapeableImageView) frameLayout3.findViewById(R$id.video_cover);
                if (shapeableImageView2 != null) {
                    so.c.k(shapeableImageView2);
                }
                AppCompatImageView appCompatImageView = (AppCompatImageView) frameLayout3.findViewById(R$id.label_gif);
                if (appCompatImageView != null) {
                    so.c.k(appCompatImageView);
                }
            }
        }
        ORPlayerView oRPlayerView2 = this.f14415b;
        if (oRPlayerView2 != null) {
            oRPlayerView2.setId(R$id.player_view);
        }
        ORPlayerView oRPlayerView3 = this.f14415b;
        if (oRPlayerView3 != null) {
            oRPlayerView3.setLayoutParams(new FrameLayout.LayoutParams(shapeableImageView != null ? shapeableImageView.getWidth() : 0, shapeableImageView != null ? shapeableImageView.getHeight() : 0));
        }
        if (frameLayout != null) {
            frameLayout.addView(this.f14415b);
        }
        if (nineGridItemView != null) {
            nineGridItemView.requestLayout();
        }
    }

    public final void a() {
        this.f14416c = -1;
        this.f14417d = 0;
        this.f14418e = null;
        this.f14419f = null;
        ORPlayerPreloadManager.f54651i.a().b();
    }

    public final int b() {
        return this.f14416c;
    }

    public final int c(Media media) {
        List<Image> image;
        List<Image> image2;
        String videoUrl;
        if (media == null || (image = media.getImage()) == null || image.size() <= 0 || media == null || (image2 = media.getImage()) == null) {
            return -1;
        }
        int i11 = 0;
        for (Object obj : image2) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                g.u();
            }
            GifBean gifBean = ((Image) obj).getGifBean();
            if (gifBean != null && (videoUrl = gifBean.getVideoUrl()) != null && videoUrl.length() > 0) {
                return i11;
            }
            i11 = i12;
        }
        return -1;
    }

    public final NineGridItemView d(Media media, View view) {
        List<Image> image;
        String videoUrl;
        if (media == null || (image = media.getImage()) == null) {
            return null;
        }
        int i11 = 0;
        for (Object obj : image) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                g.u();
            }
            GifBean gifBean = ((Image) obj).getGifBean();
            if (gifBean != null && (videoUrl = gifBean.getVideoUrl()) != null && videoUrl.length() > 0) {
                NineGridItemView nineGridItemViewK = k(view, i11);
                if (o(nineGridItemViewK)) {
                    this.f14417d = i11;
                    return nineGridItemViewK;
                }
            }
            i11 = i12;
        }
        return null;
    }

    public final int e(Media media) {
        List<Image> image;
        GifBean gifBean;
        String videoUrl;
        int i11 = 0;
        if (Intrinsics.b(media != null ? media.getMediaType() : null, MediaType.IMAGE.getValue()) && (image = media.getImage()) != null) {
            for (Image image2 : image) {
                if (image2.getGifBean() != null && (gifBean = image2.getGifBean()) != null && (videoUrl = gifBean.getVideoUrl()) != null && videoUrl.length() > 0) {
                    i11++;
                }
            }
        }
        return i11;
    }

    public final int f() {
        return this.f14417d;
    }

    public final int g(Media media) {
        List<Image> image;
        Image image2;
        GifBean gifBean;
        String videoUrl;
        List<Image> image3;
        int size = (media == null || (image3 = media.getImage()) == null) ? 0 : image3.size();
        if (size > 0) {
            for (int i11 = size - 1; -1 < i11; i11--) {
                if (media != null && (image = media.getImage()) != null && (image2 = image.get(i11)) != null && (gifBean = image2.getGifBean()) != null && (videoUrl = gifBean.getVideoUrl()) != null && videoUrl.length() > 0) {
                    return i11;
                }
            }
        }
        return -1;
    }

    public final float h(NineGridVideoView nineGridView, Media media) {
        List<Image> image;
        Image image2;
        List<Image> image3;
        Intrinsics.g(nineGridView, "nineGridView");
        int size = (media == null || (image3 = media.getImage()) == null) ? 0 : image3.size();
        float f11 = 0.0f;
        for (int i11 = 0; i11 < size; i11++) {
            int i12 = i(media, i11);
            if (i12 < 0 || i12 >= size) {
                break;
            }
            GifBean gifBean = (media == null || (image = media.getImage()) == null || (image2 = image.get(i12)) == null) ? null : image2.getGifBean();
            if (gifBean != null && gifBean.getVideoUrl() != null) {
                NineGridItemView nineGridItemViewK = k(nineGridView, i12);
                if (nineGridItemViewK == null) {
                    return f11;
                }
                float fL = l(nineGridItemViewK);
                if (f11 < fL) {
                    f11 = fL;
                }
            }
        }
        return f11;
    }

    public final int i(Media media, int i11) {
        List<Image> image;
        GifBean gifBean;
        String videoUrl;
        if (i11 == g(media)) {
            return c(media);
        }
        if (media == null || (image = media.getImage()) == null) {
            return -1;
        }
        int i12 = 0;
        for (Object obj : image) {
            int i13 = i12 + 1;
            if (i12 < 0) {
                g.u();
            }
            Image image2 = (Image) obj;
            if (i11 < i12 && (gifBean = image2.getGifBean()) != null && (videoUrl = gifBean.getVideoUrl()) != null && videoUrl.length() > 0) {
                return i12;
            }
            i12 = i13;
        }
        return -1;
    }

    public final String j(Media media, int i11) {
        List<Image> image;
        Image image2;
        GifBean gifBean;
        List<Image> image3;
        int i12 = i(media, i11);
        int size = (media == null || (image3 = media.getImage()) == null) ? 0 : image3.size();
        if (i12 < 0 || i12 >= size || i12 == this.f14417d || media == null || (image = media.getImage()) == null || (image2 = image.get(i12)) == null || (gifBean = image2.getGifBean()) == null) {
            return null;
        }
        return gifBean.getVideoUrl();
    }

    public final NineGridItemView k(View view, int i11) {
        NineGridVideoView nineGridVideoView = view != null ? (NineGridVideoView) view.findViewById(R$id.nine_grid) : null;
        int childCount = nineGridVideoView != null ? nineGridVideoView.getChildCount() : 0;
        if (i11 >= 0 && i11 < childCount) {
            View childAt = nineGridVideoView != null ? nineGridVideoView.getChildAt(i11) : null;
            if (childAt instanceof NineGridItemView) {
                return (NineGridItemView) childAt;
            }
        }
        return null;
    }

    public final float l(View view) {
        Intrinsics.g(view, "view");
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return 0.0f;
        }
        return (rect.height() * 1.0f) / (view.getHeight() * 1.0f);
    }

    public final void m(NineGridItemView nineGridItemView) {
        AppCompatImageView appCompatImageView;
        ShapeableImageView shapeableImageView;
        if (nineGridItemView != null && (shapeableImageView = (ShapeableImageView) nineGridItemView.findViewById(R$id.video_cover)) != null) {
            so.c.g(shapeableImageView);
        }
        if (nineGridItemView == null || (appCompatImageView = (AppCompatImageView) nineGridItemView.findViewById(R$id.label_gif)) == null) {
            return;
        }
        so.c.h(appCompatImageView);
    }

    public final boolean n() {
        f fVar = this.f14414a;
        if (fVar != null) {
            return fVar.isPlaying();
        }
        return false;
    }

    public final boolean o(View view) {
        if (view == null) {
            return false;
        }
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            if ((rect.height() * 1.0f) / (view.getHeight() * 1.0f) > 0.5f) {
                return true;
            }
        }
        return false;
    }

    public void p() {
        m(k(this.f14419f, this.f14417d));
    }

    public void q() {
        String videoUrl;
        List<Image> image;
        Image image2;
        List<Image> image3;
        PostSubjectItem postSubjectItem = this.f14418e;
        Media media = postSubjectItem != null ? postSubjectItem.getMedia() : null;
        int size = (media == null || (image3 = media.getImage()) == null) ? 0 : image3.size();
        int iE = e(media);
        while (size > 0) {
            int i11 = i(media, this.f14417d);
            this.f14417d = i11;
            if (i11 < 0 || i11 >= size) {
                return;
            }
            GifBean gifBean = (media == null || (image = media.getImage()) == null || (image2 = image.get(this.f14417d)) == null) ? null : image2.getGifBean();
            if (gifBean != null && (videoUrl = gifBean.getVideoUrl()) != null) {
                NineGridItemView nineGridItemViewK = k(this.f14419f, this.f14417d);
                if (o(nineGridItemViewK) || this.f14420g) {
                    t(gifBean, nineGridItemViewK, size == 1);
                    this.f14421h.put(videoUrl, Boolean.TRUE);
                    return;
                }
                this.f14421h.put(videoUrl, Boolean.FALSE);
            }
            if (!this.f14421h.containsValue(Boolean.TRUE) && this.f14421h.size() >= iE) {
                this.f14416c = -1;
                f fVar = this.f14414a;
                if (fVar == null || !fVar.isPlaying()) {
                    return;
                }
                this.f14414a.pause();
                return;
            }
        }
    }

    public void r() {
        f fVar = this.f14414a;
        if (fVar != null && fVar.isPlaying()) {
            this.f14414a.pause();
            z(this.f14419f);
        }
        a();
    }

    public void s(PostSubjectItem postSubjectItem, View view, int i11) {
        String videoUrl;
        Image image;
        this.f14419f = view;
        GifBean gifBean = null;
        Media media = postSubjectItem != null ? postSubjectItem.getMedia() : null;
        ORPlayerPreloadManager.f54651i.a().f();
        this.f14421h.clear();
        if (Intrinsics.b(media != null ? media.getMediaType() : null, MediaType.IMAGE.getValue())) {
            List<Image> image2 = media.getImage();
            int size = image2 != null ? image2.size() : 0;
            NineGridItemView nineGridItemViewD = d(postSubjectItem.getMedia(), view);
            int i12 = this.f14417d;
            if (i12 < 0 || i12 >= size) {
                return;
            }
            List<Image> image3 = media.getImage();
            if (image3 != null && (image = image3.get(this.f14417d)) != null) {
                gifBean = image.getGifBean();
            }
            if (gifBean == null || (videoUrl = gifBean.getVideoUrl()) == null || videoUrl.length() <= 0) {
                return;
            }
            t(gifBean, nineGridItemViewD, e(media) == 1);
            this.f14416c = i11;
            this.f14418e = postSubjectItem;
            if (size > 1) {
                u(media);
            }
        }
    }

    public final void t(GifBean gifBean, NineGridItemView nineGridItemView, boolean z11) {
        if (nineGridItemView == null) {
            return;
        }
        uo.b.a.f(uo.b.f78622a, "ItemChangeListener", "play url = " + gifBean.getVideoUrl(), false, 4, null);
        A(nineGridItemView);
        f fVar = this.f14414a;
        if (fVar != null) {
            String videoUrl = gifBean.getVideoUrl();
            String str = videoUrl == null ? "" : videoUrl;
            String videoUrl2 = gifBean.getVideoUrl();
            if (videoUrl2 == null) {
                videoUrl2 = "";
            }
            fVar.setDataSource(new MediaSource(str, videoUrl2, 0, null, null, 28, null));
        }
        f fVar2 = this.f14414a;
        if (fVar2 != null) {
            fVar2.prepare();
        }
        f fVar3 = this.f14414a;
        if (fVar3 != null) {
            fVar3.play();
        }
        f fVar4 = this.f14414a;
        if (fVar4 != null) {
            fVar4.setLooping(z11);
        }
    }

    public final void u(Media media) {
        int iE = e(media) - 1;
        for (int i11 = 0; i11 < iE; i11++) {
            String strJ = j(media, this.f14417d + i11);
            if (strJ != null && strJ.length() > 0) {
                ORPlayerPreloadManager.f54651i.a().h(strJ, com.transsion.ninegridview.a.f53943h.a().l());
            }
        }
    }

    public final void v(Media media) {
        List<Image> image;
        Image image2;
        GifBean gifBean;
        List<Image> image3;
        int iC = c(media);
        int size = (media == null || (image3 = media.getImage()) == null) ? 0 : image3.size();
        if (iC < 0 || iC >= size) {
            return;
        }
        String videoUrl = (media == null || (image = media.getImage()) == null || (image2 = image.get(iC)) == null || (gifBean = image2.getGifBean()) == null) ? null : gifBean.getVideoUrl();
        if (videoUrl == null || videoUrl.length() <= 0) {
            return;
        }
        ORPlayerPreloadManager.f54651i.a().h(videoUrl, com.transsion.ninegridview.a.f53943h.a().l());
    }

    public final void w() {
        s(this.f14418e, this.f14419f, this.f14416c);
    }

    public final void x(int i11) {
        this.f14416c = i11;
    }

    public final void y(boolean z11) {
        this.f14420g = z11;
    }

    public final void z(View view) {
        ORPlayerView oRPlayerView = view != null ? (ORPlayerView) view.findViewById(R$id.player_view) : null;
        ViewParent parent = oRPlayerView != null ? oRPlayerView.getParent() : null;
        if (parent instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) parent;
            frameLayout.removeView(oRPlayerView);
            ViewParent parent2 = frameLayout.getParent();
            if (parent2 instanceof FrameLayout) {
                FrameLayout frameLayout2 = (FrameLayout) parent2;
                ShapeableImageView shapeableImageView = (ShapeableImageView) frameLayout2.findViewById(R$id.video_cover);
                if (shapeableImageView != null) {
                    so.c.k(shapeableImageView);
                }
                AppCompatImageView appCompatImageView = (AppCompatImageView) frameLayout2.findViewById(R$id.label_gif);
                if (appCompatImageView != null) {
                    so.c.k(appCompatImageView);
                }
            }
        }
    }
}
