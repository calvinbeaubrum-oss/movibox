package tv;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Space;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.ui.view.ClipLoading;
import com.transsion.postdetail.ui.view.VideoProgressDragGestureView;
import com.transsion.shorttv.widget.ShortTvAdView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class i0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f77768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final BLView f77769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ClipLoading f77770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final FrameLayout f77771d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final Group f77772f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77773g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77774h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77775i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77776j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f77777k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f77778l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final LinearLayout f77779m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final ProgressBar f77780n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final Space f77781o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final AppCompatSeekBar f77782p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    public final ShortTvAdView f77783q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77784r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77785s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77786t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77787u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77788v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @NonNull
    public final BLTextView f77789w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77790x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @NonNull
    public final BLView f77791y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @NonNull
    public final VideoProgressDragGestureView f77792z;

    public i0(@NonNull View view, @NonNull BLView bLView, @NonNull ClipLoading clipLoading, @NonNull FrameLayout frameLayout, @NonNull Group group, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatImageView appCompatImageView3, @NonNull AppCompatImageView appCompatImageView4, @NonNull ShapeableImageView shapeableImageView, @NonNull ShapeableImageView shapeableImageView2, @NonNull LinearLayout linearLayout, @NonNull ProgressBar progressBar, @NonNull Space space, @NonNull AppCompatSeekBar appCompatSeekBar, @NonNull ShortTvAdView shortTvAdView, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4, @NonNull AppCompatTextView appCompatTextView5, @NonNull BLTextView bLTextView, @NonNull AppCompatTextView appCompatTextView6, @NonNull BLView bLView2, @NonNull VideoProgressDragGestureView videoProgressDragGestureView) {
        this.f77768a = view;
        this.f77769b = bLView;
        this.f77770c = clipLoading;
        this.f77771d = frameLayout;
        this.f77772f = group;
        this.f77773g = appCompatImageView;
        this.f77774h = appCompatImageView2;
        this.f77775i = appCompatImageView3;
        this.f77776j = appCompatImageView4;
        this.f77777k = shapeableImageView;
        this.f77778l = shapeableImageView2;
        this.f77779m = linearLayout;
        this.f77780n = progressBar;
        this.f77781o = space;
        this.f77782p = appCompatSeekBar;
        this.f77783q = shortTvAdView;
        this.f77784r = appCompatTextView;
        this.f77785s = appCompatTextView2;
        this.f77786t = appCompatTextView3;
        this.f77787u = appCompatTextView4;
        this.f77788v = appCompatTextView5;
        this.f77789w = bLTextView;
        this.f77790x = appCompatTextView6;
        this.f77791y = bLView2;
        this.f77792z = videoProgressDragGestureView;
    }

    @NonNull
    public static i0 a(@NonNull View view) {
        int i11 = R$id.bottom_background;
        BLView bLView = (BLView) n6.b.a(view, i11);
        if (bLView != null) {
            i11 = R$id.cl_loading;
            ClipLoading clipLoading = (ClipLoading) n6.b.a(view, i11);
            if (clipLoading != null) {
                i11 = R$id.fl_container;
                FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
                if (frameLayout != null) {
                    i11 = R$id.group_content;
                    Group group = (Group) n6.b.a(view, i11);
                    if (group != null) {
                        i11 = R$id.iv_cover;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                        if (appCompatImageView != null) {
                            i11 = R$id.iv_download;
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                            if (appCompatImageView2 != null) {
                                i11 = R$id.iv_pause;
                                AppCompatImageView appCompatImageView3 = (AppCompatImageView) n6.b.a(view, i11);
                                if (appCompatImageView3 != null) {
                                    i11 = R$id.iv_share;
                                    AppCompatImageView appCompatImageView4 = (AppCompatImageView) n6.b.a(view, i11);
                                    if (appCompatImageView4 != null) {
                                        i11 = R$id.iv_short_cover;
                                        ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
                                        if (shapeableImageView != null) {
                                            i11 = R$id.iv_video_avatar;
                                            ShapeableImageView shapeableImageView2 = (ShapeableImageView) n6.b.a(view, i11);
                                            if (shapeableImageView2 != null) {
                                                i11 = R$id.llOperationLayout;
                                                LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
                                                if (linearLayout != null) {
                                                    i11 = R$id.progress_bar;
                                                    ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
                                                    if (progressBar != null) {
                                                        i11 = R$id.progress_guideline;
                                                        Space space = (Space) n6.b.a(view, i11);
                                                        if (space != null) {
                                                            i11 = R$id.seek_bar;
                                                            AppCompatSeekBar appCompatSeekBar = (AppCompatSeekBar) n6.b.a(view, i11);
                                                            if (appCompatSeekBar != null) {
                                                                i11 = R$id.shortTvAdView;
                                                                ShortTvAdView shortTvAdView = (ShortTvAdView) n6.b.a(view, i11);
                                                                if (shortTvAdView != null) {
                                                                    i11 = R$id.tv_comment;
                                                                    AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                                                                    if (appCompatTextView != null) {
                                                                        i11 = R$id.tv_desc;
                                                                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                                                        if (appCompatTextView2 != null) {
                                                                            i11 = R$id.tv_favorite;
                                                                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                                                            if (appCompatTextView3 != null) {
                                                                                i11 = R$id.tv_like;
                                                                                AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                                                                                if (appCompatTextView4 != null) {
                                                                                    i11 = R$id.tv_progress_des;
                                                                                    AppCompatTextView appCompatTextView5 = (AppCompatTextView) n6.b.a(view, i11);
                                                                                    if (appCompatTextView5 != null) {
                                                                                        i11 = R$id.tv_short_tv_ep;
                                                                                        BLTextView bLTextView = (BLTextView) n6.b.a(view, i11);
                                                                                        if (bLTextView != null) {
                                                                                            i11 = R$id.tv_title;
                                                                                            AppCompatTextView appCompatTextView6 = (AppCompatTextView) n6.b.a(view, i11);
                                                                                            if (appCompatTextView6 != null) {
                                                                                                i11 = R$id.up_background;
                                                                                                BLView bLView2 = (BLView) n6.b.a(view, i11);
                                                                                                if (bLView2 != null) {
                                                                                                    i11 = R$id.v_progress_gesture;
                                                                                                    VideoProgressDragGestureView videoProgressDragGestureView = (VideoProgressDragGestureView) n6.b.a(view, i11);
                                                                                                    if (videoProgressDragGestureView != null) {
                                                                                                        return new i0(view, bLView, clipLoading, frameLayout, group, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, shapeableImageView, shapeableImageView2, linearLayout, progressBar, space, appCompatSeekBar, shortTvAdView, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5, bLTextView, appCompatTextView6, bLView2, videoProgressDragGestureView);
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    public View getRoot() {
        return this.f77768a;
    }
}
