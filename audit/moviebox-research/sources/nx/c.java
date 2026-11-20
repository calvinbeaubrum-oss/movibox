package nx;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.Space;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.expand.ExpandView;
import com.tn.lib.widget.TnTextView;
import com.transsion.baseui.widget.NestedScrollableHost;
import com.transsion.shorttv.R$id;
import com.transsion.shorttv.widget.ShortTvAdView;
import com.transsion.shorttv.widget.VideoProgressDragGestureView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class c implements n6.a {

    @NonNull
    public final VideoProgressDragGestureView A;

    @NonNull
    public final ViewStub B;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f72178a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f72179b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ExpandView f72180c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final FrameLayout f72181d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final Group f72182f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f72183g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f72184h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f72185i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f72186j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f72187k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f72188l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f72189m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final NestedScrollableHost f72190n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final ProgressBar f72191o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final Space f72192p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    public final AppCompatSeekBar f72193q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    public final ShortTvAdView f72194r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f72195s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f72196t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f72197u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f72198v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f72199w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f72200x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @NonNull
    public final TnTextView f72201y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @NonNull
    public final View f72202z;

    public c(@NonNull View view, @NonNull View view2, @NonNull ExpandView expandView, @NonNull FrameLayout frameLayout, @NonNull Group group, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatImageView appCompatImageView3, @NonNull AppCompatImageView appCompatImageView4, @NonNull AppCompatImageView appCompatImageView5, @NonNull AppCompatImageView appCompatImageView6, @NonNull ShapeableImageView shapeableImageView, @NonNull NestedScrollableHost nestedScrollableHost, @NonNull ProgressBar progressBar, @NonNull Space space, @NonNull AppCompatSeekBar appCompatSeekBar, @NonNull ShortTvAdView shortTvAdView, @NonNull ConstraintLayout constraintLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull AppCompatTextView appCompatTextView4, @NonNull AppCompatTextView appCompatTextView5, @NonNull TnTextView tnTextView, @NonNull View view3, @NonNull VideoProgressDragGestureView videoProgressDragGestureView, @NonNull ViewStub viewStub) {
        this.f72178a = view;
        this.f72179b = view2;
        this.f72180c = expandView;
        this.f72181d = frameLayout;
        this.f72182f = group;
        this.f72183g = appCompatImageView;
        this.f72184h = appCompatImageView2;
        this.f72185i = appCompatImageView3;
        this.f72186j = appCompatImageView4;
        this.f72187k = appCompatImageView5;
        this.f72188l = appCompatImageView6;
        this.f72189m = shapeableImageView;
        this.f72190n = nestedScrollableHost;
        this.f72191o = progressBar;
        this.f72192p = space;
        this.f72193q = appCompatSeekBar;
        this.f72194r = shortTvAdView;
        this.f72195s = constraintLayout;
        this.f72196t = appCompatTextView;
        this.f72197u = appCompatTextView2;
        this.f72198v = appCompatTextView3;
        this.f72199w = appCompatTextView4;
        this.f72200x = appCompatTextView5;
        this.f72201y = tnTextView;
        this.f72202z = view3;
        this.A = videoProgressDragGestureView;
        this.B = viewStub;
    }

    @NonNull
    public static c a(@NonNull View view) {
        View viewA;
        int i11 = R$id.bottom_background;
        View viewA2 = n6.b.a(view, i11);
        if (viewA2 != null) {
            i11 = R$id.ev_post_des;
            ExpandView expandView = (ExpandView) n6.b.a(view, i11);
            if (expandView != null) {
                i11 = R$id.fl_container;
                FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
                if (frameLayout != null) {
                    i11 = R$id.group_content;
                    Group group = (Group) n6.b.a(view, i11);
                    if (group != null) {
                        i11 = R$id.iv_back;
                        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                        if (appCompatImageView != null) {
                            i11 = R$id.iv_cover;
                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                            if (appCompatImageView2 != null) {
                                i11 = R$id.iv_download;
                                AppCompatImageView appCompatImageView3 = (AppCompatImageView) n6.b.a(view, i11);
                                if (appCompatImageView3 != null) {
                                    i11 = R$id.iv_download_icon;
                                    AppCompatImageView appCompatImageView4 = (AppCompatImageView) n6.b.a(view, i11);
                                    if (appCompatImageView4 != null) {
                                        i11 = R$id.iv_play_status;
                                        AppCompatImageView appCompatImageView5 = (AppCompatImageView) n6.b.a(view, i11);
                                        if (appCompatImageView5 != null) {
                                            i11 = R$id.iv_share;
                                            AppCompatImageView appCompatImageView6 = (AppCompatImageView) n6.b.a(view, i11);
                                            if (appCompatImageView6 != null) {
                                                i11 = R$id.iv_short_cover;
                                                ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
                                                if (shapeableImageView != null) {
                                                    i11 = R$id.ns_post_des;
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
                                                                        i11 = R$id.tool_bar;
                                                                        ConstraintLayout constraintLayout = (ConstraintLayout) n6.b.a(view, i11);
                                                                        if (constraintLayout != null) {
                                                                            i11 = R$id.tv_all_short_tv;
                                                                            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                                                                            if (appCompatTextView != null) {
                                                                                i11 = R$id.tv_episode;
                                                                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                                                                if (appCompatTextView2 != null) {
                                                                                    i11 = R$id.tv_favorite;
                                                                                    AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                                                                    if (appCompatTextView3 != null) {
                                                                                        i11 = R$id.tv_name;
                                                                                        AppCompatTextView appCompatTextView4 = (AppCompatTextView) n6.b.a(view, i11);
                                                                                        if (appCompatTextView4 != null) {
                                                                                            i11 = R$id.tv_progress_des;
                                                                                            AppCompatTextView appCompatTextView5 = (AppCompatTextView) n6.b.a(view, i11);
                                                                                            if (appCompatTextView5 != null) {
                                                                                                i11 = R$id.tv_title;
                                                                                                TnTextView tnTextView = (TnTextView) n6.b.a(view, i11);
                                                                                                if (tnTextView != null && (viewA = n6.b.a(view, (i11 = R$id.up_background))) != null) {
                                                                                                    i11 = R$id.v_progress_gesture;
                                                                                                    VideoProgressDragGestureView videoProgressDragGestureView = (VideoProgressDragGestureView) n6.b.a(view, i11);
                                                                                                    if (videoProgressDragGestureView != null) {
                                                                                                        i11 = R$id.vs_unlock;
                                                                                                        ViewStub viewStub = (ViewStub) n6.b.a(view, i11);
                                                                                                        if (viewStub != null) {
                                                                                                            return new c(view, viewA2, expandView, frameLayout, group, appCompatImageView, appCompatImageView2, appCompatImageView3, appCompatImageView4, appCompatImageView5, appCompatImageView6, shapeableImageView, nestedScrollableHost, progressBar, space, appCompatSeekBar, shortTvAdView, constraintLayout, appCompatTextView, appCompatTextView2, appCompatTextView3, appCompatTextView4, appCompatTextView5, tnTextView, viewA, videoProgressDragGestureView, viewStub);
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
        return this.f72178a;
    }
}
