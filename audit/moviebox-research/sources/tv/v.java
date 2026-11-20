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
import androidx.constraintlayout.widget.Barrier;
import com.google.android.material.imageview.ShapeableImageView;
import com.noober.background.view.BLTextView;
import com.noober.background.view.BLView;
import com.tn.lib.view.expand.ExpandView;
import com.transsion.baseui.widget.NestedScrollableHost;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.ui.view.ClipLoading;
import com.transsion.postdetail.ui.view.VideoProgressDragGestureView;
import com.transsion.shorttv.widget.ShortTvAdView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class v implements n6.a {

    @NonNull
    public final BLView A;

    @NonNull
    public final VideoProgressDragGestureView B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f77956a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final Barrier f77957b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final BLView f77958c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ClipLoading f77959d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final ExpandView f77960f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final FrameLayout f77961g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77962h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77963i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77964j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77965k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f77966l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f77967m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final b0 f77968n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final LinearLayout f77969o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final NestedScrollableHost f77970p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    public final ProgressBar f77971q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    public final Space f77972r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final AppCompatSeekBar f77973s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NonNull
    public final ShortTvAdView f77974t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77975u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77976v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77977w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77978x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @NonNull
    public final BLTextView f77979y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77980z;

    public v(@NonNull View view, @NonNull Barrier barrier, @NonNull BLView bLView, @NonNull ClipLoading clipLoading, @NonNull ExpandView expandView, @NonNull FrameLayout frameLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatImageView appCompatImageView3, @NonNull AppCompatImageView appCompatImageView4, @NonNull ShapeableImageView shapeableImageView, @NonNull ShapeableImageView shapeableImageView2, @NonNull b0 b0Var, @NonNull LinearLayout linearLayout, @NonNull NestedScrollableHost nestedScrollableHost, @NonNull ProgressBar progressBar, @NonNull Space space, @NonNull AppCompatSeekBar appCompatSeekBar, @NonNull ShortTvAdView shortTvAdView, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4, @NonNull BLTextView bLTextView, @NonNull AppCompatTextView appCompatTextView5, @NonNull BLView bLView2, @NonNull VideoProgressDragGestureView videoProgressDragGestureView) {
        this.f77956a = view;
        this.f77957b = barrier;
        this.f77958c = bLView;
        this.f77959d = clipLoading;
        this.f77960f = expandView;
        this.f77961g = frameLayout;
        this.f77962h = appCompatImageView;
        this.f77963i = appCompatImageView2;
        this.f77964j = appCompatImageView3;
        this.f77965k = appCompatImageView4;
        this.f77966l = shapeableImageView;
        this.f77967m = shapeableImageView2;
        this.f77968n = b0Var;
        this.f77969o = linearLayout;
        this.f77970p = nestedScrollableHost;
        this.f77971q = progressBar;
        this.f77972r = space;
        this.f77973s = appCompatSeekBar;
        this.f77974t = shortTvAdView;
        this.f77975u = appCompatTextView;
        this.f77976v = appCompatTextView2;
        this.f77977w = appCompatTextView3;
        this.f77978x = appCompatTextView4;
        this.f77979y = bLTextView;
        this.f77980z = appCompatTextView5;
        this.A = bLView2;
        this.B = videoProgressDragGestureView;
    }

    @NonNull
    public static v a(@NonNull View view) {
        View viewA;
        int i11 = R$id.barrier;
        Barrier barrier = (Barrier) n6.b.a(view, i11);
        if (barrier != null) {
            i11 = R$id.bottom_background;
            BLView bLView = (BLView) n6.b.a(view, i11);
            if (bLView != null) {
                i11 = R$id.cl_loading;
                ClipLoading clipLoading = (ClipLoading) n6.b.a(view, i11);
                if (clipLoading != null) {
                    i11 = R$id.ev_post_des;
                    ExpandView expandView = (ExpandView) n6.b.a(view, i11);
                    if (expandView != null) {
                        i11 = R$id.fl_container;
                        FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
                        if (frameLayout != null) {
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
                                                if (shapeableImageView2 != null && (viewA = n6.b.a(view, (i11 = R$id.layout_subject_room))) != null) {
                                                    b0 b0VarA = b0.a(viewA);
                                                    i11 = R$id.llOperationLayout;
                                                    LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
                                                    if (linearLayout != null) {
                                                        i11 = R$id.nsPostDes;
                                                        NestedScrollableHost nestedScrollableHost = (NestedScrollableHost) n6.b.a(view, i11);
                                                        if (nestedScrollableHost != null) {
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
                                                                                i11 = R$id.tv_favorite;
                                                                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                                                                if (appCompatTextView2 != null) {
                                                                                    i11 = R$id.tv_like;
                                                                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                                                                    if (appCompatTextView3 != null) {
                                                                                        i11 = R$id.tv_progress_des;
                                                                                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                                                                                        if (appCompatTextView4 != null) {
                                                                                            i11 = R$id.tvShortTvEp;
                                                                                            BLTextView bLTextView = (BLTextView) n6.b.a(view, i11);
                                                                                            if (bLTextView != null) {
                                                                                                i11 = R$id.tvTitle;
                                                                                                AppCompatTextView appCompatTextView5 = (AppCompatTextView) n6.b.a(view, i11);
                                                                                                if (appCompatTextView5 != null) {
                                                                                                    i11 = R$id.up_background;
                                                                                                    BLView bLView2 = (BLView) n6.b.a(view, i11);
                                                                                                    if (bLView2 != null) {
                                                                                                        i11 = R$id.v_progress_gesture;
                                                                                                        VideoProgressDragGestureView videoProgressDragGestureView = (VideoProgressDragGestureView) n6.b.a(view, i11);
                                                                                                        if (videoProgressDragGestureView != null) {
                                                                                                            return new v(view, barrier, bLView, clipLoading, expandView, frameLayout, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, shapeableImageView, shapeableImageView2, b0VarA, linearLayout, nestedScrollableHost, progressBar, space, appCompatSeekBar, shortTvAdView, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, bLTextView, appCompatTextView5, bLView2, videoProgressDragGestureView);
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
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    public View getRoot() {
        return this.f77956a;
    }
}
