package com.transsion.ninegridview.preview;

import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.blankj.utilcode.util.d0;
import com.transsion.moviedetailapi.bean.GifBean;
import com.transsion.moviedetailapi.bean.Image;
import com.transsion.ninegridview.R$id;
import com.transsion.photoview.PhotoView;
import com.transsion.player.MediaSource;
import com.transsion.player.ui.ORPlayerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class m extends jp.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.transsion.player.orplayer.f f54002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ORPlayerView f54003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f54004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f54005d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Image f54006f;

    public m(com.transsion.player.orplayer.f player, ORPlayerView playerView) {
        Intrinsics.g(player, "player");
        Intrinsics.g(playerView, "playerView");
        this.f54002a = player;
        this.f54003b = playerView;
        this.f54004c = -1;
    }

    @Override // jp.a
    public void c(boolean z11, int i11, View view) {
    }

    public final void e(View view) {
        PhotoView photoView = view != null ? (PhotoView) view.findViewById(R$id.video_cover) : null;
        if (photoView != null) {
            so.c.g(photoView);
        }
    }

    public final void f(int i11, Image image, View view) {
        String videoUrl;
        this.f54004c = i11;
        this.f54005d = view;
        this.f54006f = image;
        GifBean gifBean = image != null ? image.getGifBean() : null;
        if (gifBean == null || (videoUrl = gifBean.getVideoUrl()) == null || videoUrl.length() <= 0) {
            return;
        }
        h(gifBean, view, true);
    }

    public void g() {
        e(this.f54005d);
    }

    public final void h(GifBean gifBean, View view, boolean z11) {
        i(view);
        com.transsion.player.orplayer.f fVar = this.f54002a;
        String videoUrl = gifBean.getVideoUrl();
        String str = videoUrl == null ? "" : videoUrl;
        String videoUrl2 = gifBean.getVideoUrl();
        if (videoUrl2 == null) {
            videoUrl2 = "";
        }
        fVar.setDataSource(new MediaSource(str, videoUrl2, 0, null, null, 28, null));
        this.f54002a.prepare();
        this.f54002a.play();
        this.f54002a.setLooping(z11);
    }

    public final void i(View view) {
        Integer height;
        Integer width;
        PhotoView photoView;
        FrameLayout frameLayout = view != null ? (FrameLayout) view.findViewById(R$id.video_container) : null;
        ViewParent parent = this.f54003b.getParent();
        if (parent instanceof FrameLayout) {
            FrameLayout frameLayout2 = (FrameLayout) parent;
            frameLayout2.removeView(this.f54003b);
            ViewParent parent2 = frameLayout2.getParent();
            if ((parent2 instanceof FrameLayout) && (photoView = (PhotoView) ((FrameLayout) parent2).findViewById(R$id.video_cover)) != null) {
                so.c.k(photoView);
            }
        }
        this.f54003b.setId(R$id.player_view);
        Image image = this.f54006f;
        float fE = (image == null || (width = image.getWidth()) == null) ? d0.e() : width.intValue();
        Image image2 = this.f54006f;
        float fC = (image2 == null || (height = image2.getHeight()) == null) ? d0.c() : height.intValue();
        float fE2 = d0.e();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) fE2, (int) ((fC / fE) * fE2));
        layoutParams.gravity = 17;
        this.f54003b.setLayoutParams(layoutParams);
        if (frameLayout != null) {
            frameLayout.addView(this.f54003b);
        }
    }
}
