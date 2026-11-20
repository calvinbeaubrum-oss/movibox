package com.transsion.postdetail.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.baseui.image.ImageHelper;
import com.transsion.baseui.util.TimeUtilKt;
import com.transsion.player.ui.ORPlayerView;
import com.transsion.postdetail.R$layout;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import tv.q0;

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
public final class PostFeedVideoView extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q0 f56241a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ORPlayerView f56242b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f56243c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostFeedVideoView(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        View.inflate(getContext(), R$layout.view_post_feed_video, this);
        q0 q0VarA = q0.a(this);
        Intrinsics.f(q0VarA, "bind(this)");
        this.f56241a = q0VarA;
        Context context2 = getContext();
        Intrinsics.f(context2, "context");
        ORPlayerView oRPlayerView = new ORPlayerView(context2);
        this.f56242b = oRPlayerView;
        addView(oRPlayerView, 0, new FrameLayout.LayoutParams(-1, -1));
        q0VarA.f77912g.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.video.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostFeedVideoView.b(this.f56246a, view);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostFeedVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.g(context, "context");
        View.inflate(getContext(), R$layout.view_post_feed_video, this);
        q0 q0VarA = q0.a(this);
        Intrinsics.f(q0VarA, "bind(this)");
        this.f56241a = q0VarA;
        Context context2 = getContext();
        Intrinsics.f(context2, "context");
        ORPlayerView oRPlayerView = new ORPlayerView(context2);
        this.f56242b = oRPlayerView;
        addView(oRPlayerView, 0, new FrameLayout.LayoutParams(-1, -1));
        q0VarA.f77912g.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.video.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostFeedVideoView.b(this.f56246a, view);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PostFeedVideoView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.g(context, "context");
        View.inflate(getContext(), R$layout.view_post_feed_video, this);
        q0 q0VarA = q0.a(this);
        Intrinsics.f(q0VarA, "bind(this)");
        this.f56241a = q0VarA;
        Context context2 = getContext();
        Intrinsics.f(context2, "context");
        ORPlayerView oRPlayerView = new ORPlayerView(context2);
        this.f56242b = oRPlayerView;
        addView(oRPlayerView, 0, new FrameLayout.LayoutParams(-1, -1));
        q0VarA.f77912g.setOnClickListener(new View.OnClickListener() { // from class: com.transsion.postdetail.video.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PostFeedVideoView.b(this.f56246a, view);
            }
        });
    }

    public static final void b(PostFeedVideoView this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        boolean zIsSelected = this$0.f56241a.f77908b.isSelected();
        this$0.f56241a.f77908b.setSelected(!zIsSelected);
        Function1<? super Boolean, Unit> function1 = this$0.f56243c;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(zIsSelected));
        }
    }

    private final void setCountdown(int i11) {
        int max = (this.f56241a.f77910d.getMax() - i11) + 500;
        if (max > 0) {
            this.f56241a.f77911f.setText(TimeUtilKt.f(max));
        }
    }

    public final SurfaceView getSurfaceView() {
        return this.f56242b.getSurface();
    }

    public final void onVideoRenderFirstFrame() {
        ShapeableImageView shapeableImageView = this.f56241a.f77909c;
        Intrinsics.f(shapeableImageView, "viewBinding.ivPlayerCover");
        so.c.g(shapeableImageView);
    }

    public final void setCover(String coverUrl, String thumbnail, boolean z11) {
        Intrinsics.g(coverUrl, "coverUrl");
        Intrinsics.g(thumbnail, "thumbnail");
        ImageHelper.Companion companion = ImageHelper.f51371a;
        Context context = getContext();
        ShapeableImageView ivPlayerCover = this.f56241a.f77909c;
        int iA = z11 ? gs.a.a(280) : gs.a.a(162);
        int iA2 = gs.a.a(z11 ? 218 : 280);
        Intrinsics.f(context, "context");
        Intrinsics.f(ivPlayerCover, "ivPlayerCover");
        companion.q(context, ivPlayerCover, coverUrl, (8120 & 8) != 0 ? companion.d() : iA2, (8120 & 16) != 0 ? companion.c() : iA, (8120 & 32) != 0, (8120 & 64) != 0 ? "" : thumbnail, (8120 & 128) != 0, (8120 & 256) != 0, (8120 & 512) != 0 ? false : false, (8120 & 1024) != 0 ? false : false, (8120 & 2048) != 0 ? false : false, (8120 & 4096) != 0 ? 25 : 0);
        ShapeableImageView shapeableImageView = this.f56241a.f77909c;
        Intrinsics.f(shapeableImageView, "viewBinding.ivPlayerCover");
        so.c.k(shapeableImageView);
        this.f56241a.f77910d.setProgress(0);
    }

    public final void setDurationTime(long j11) {
        this.f56241a.f77911f.setText(TimeUtilKt.f(j11));
    }

    public final void setMuteClickCallback(Function1<? super Boolean, Unit> callback) {
        Intrinsics.g(callback, "callback");
        this.f56243c = callback;
    }

    public final void setProgress(int i11) {
        this.f56241a.f77910d.setProgress(i11);
        setCountdown(i11);
    }

    public final void setProgressMax(int i11) {
        this.f56241a.f77910d.setMax(i11);
    }

    public final void updateMute(boolean z11) {
        this.f56241a.f77908b.setSelected(!z11);
    }
}
