package tv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.ninegridview.video.NineGridVideoView;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import com.transsion.postdetail.ui.view.PostDetailOperationView;
import com.transsion.postdetail.ui.view.PostDetailSubjectView;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class m implements n6.a {

    @NonNull
    public final AppCompatTextView A;

    @NonNull
    public final AppCompatTextView B;

    @NonNull
    public final View C;

    @NonNull
    public final View D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77832a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f77833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77834c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77835d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatSeekBar f77836f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppBarLayout f77837g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77838h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final CoordinatorLayout f77839i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final k0 f77840j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f77841k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final FrameLayout f77842l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final Group f77843m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77844n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f77845o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77846p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77847q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    public final LinearLayout f77848r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final NineGridVideoView f77849s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NonNull
    public final PostDetailOperationView f77850t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NonNull
    public final PostDetailSubjectView f77851u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NonNull
    public final Toolbar f77852v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @NonNull
    public final CollapsingToolbarLayout f77853w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NonNull
    public final j0 f77854x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77855y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @NonNull
    public final l0 f77856z;

    public m(@NonNull ConstraintLayout constraintLayout, @NonNull TextView textView, @NonNull ConstraintLayout constraintLayout2, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatSeekBar appCompatSeekBar, @NonNull AppBarLayout appBarLayout, @NonNull ConstraintLayout constraintLayout3, @NonNull CoordinatorLayout coordinatorLayout, @NonNull k0 k0Var, @NonNull ConstraintLayout constraintLayout4, @NonNull FrameLayout frameLayout, @NonNull Group group, @NonNull AppCompatImageView appCompatImageView2, @NonNull ShapeableImageView shapeableImageView, @NonNull AppCompatImageView appCompatImageView3, @NonNull AppCompatImageView appCompatImageView4, @NonNull LinearLayout linearLayout, @NonNull NineGridVideoView nineGridVideoView, @NonNull PostDetailOperationView postDetailOperationView, @NonNull PostDetailSubjectView postDetailSubjectView, @NonNull Toolbar toolbar, @NonNull CollapsingToolbarLayout collapsingToolbarLayout, @NonNull j0 j0Var, @NonNull AppCompatTextView appCompatTextView, @NonNull l0 l0Var, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull View view, @NonNull View view2) {
        this.f77832a = constraintLayout;
        this.f77833b = textView;
        this.f77834c = constraintLayout2;
        this.f77835d = appCompatImageView;
        this.f77836f = appCompatSeekBar;
        this.f77837g = appBarLayout;
        this.f77838h = constraintLayout3;
        this.f77839i = coordinatorLayout;
        this.f77840j = k0Var;
        this.f77841k = constraintLayout4;
        this.f77842l = frameLayout;
        this.f77843m = group;
        this.f77844n = appCompatImageView2;
        this.f77845o = shapeableImageView;
        this.f77846p = appCompatImageView3;
        this.f77847q = appCompatImageView4;
        this.f77848r = linearLayout;
        this.f77849s = nineGridVideoView;
        this.f77850t = postDetailOperationView;
        this.f77851u = postDetailSubjectView;
        this.f77852v = toolbar;
        this.f77853w = collapsingToolbarLayout;
        this.f77854x = j0Var;
        this.f77855y = appCompatTextView;
        this.f77856z = l0Var;
        this.A = appCompatTextView2;
        this.B = appCompatTextView3;
        this.C = view;
        this.D = view2;
    }

    @NonNull
    public static m a(@NonNull View view) {
        View viewA;
        View viewA2;
        View viewA3;
        View viewA4;
        View viewA5;
        int i11 = R$id.ad_audio_time;
        TextView textView = (TextView) n6.b.a(view, i11);
        if (textView != null) {
            i11 = R$id.ad_bottom_controller;
            ConstraintLayout constraintLayout = (ConstraintLayout) n6.b.a(view, i11);
            if (constraintLayout != null) {
                i11 = R$id.ad_pause;
                AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView != null) {
                    i11 = R$id.ad_seekbar;
                    AppCompatSeekBar appCompatSeekBar = (AppCompatSeekBar) n6.b.a(view, i11);
                    if (appCompatSeekBar != null) {
                        i11 = R$id.appBar;
                        AppBarLayout appBarLayout = (AppBarLayout) n6.b.a(view, i11);
                        if (appBarLayout != null) {
                            ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                            i11 = R$id.clContent;
                            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) n6.b.a(view, i11);
                            if (coordinatorLayout != null && (viewA = n6.b.a(view, (i11 = R$id.clRating))) != null) {
                                k0 k0VarA = k0.a(viewA);
                                i11 = R$id.contentView;
                                ConstraintLayout constraintLayout3 = (ConstraintLayout) n6.b.a(view, i11);
                                if (constraintLayout3 != null) {
                                    i11 = R$id.flContainer;
                                    FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
                                    if (frameLayout != null) {
                                        i11 = R$id.groupAudio;
                                        Group group = (Group) n6.b.a(view, i11);
                                        if (group != null) {
                                            i11 = R$id.iv_audio_wave;
                                            AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                                            if (appCompatImageView2 != null) {
                                                i11 = R$id.ivAvatar;
                                                ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
                                                if (shapeableImageView != null) {
                                                    i11 = R$id.ivBack;
                                                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) n6.b.a(view, i11);
                                                    if (appCompatImageView3 != null) {
                                                        i11 = R$id.iv_cover;
                                                        AppCompatImageView appCompatImageView4 = (AppCompatImageView) n6.b.a(view, i11);
                                                        if (appCompatImageView4 != null) {
                                                            i11 = R$id.llTop;
                                                            LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
                                                            if (linearLayout != null) {
                                                                i11 = R$id.nine_grid;
                                                                NineGridVideoView nineGridVideoView = (NineGridVideoView) n6.b.a(view, i11);
                                                                if (nineGridVideoView != null) {
                                                                    i11 = R$id.postDetailOperationView;
                                                                    PostDetailOperationView postDetailOperationView = (PostDetailOperationView) n6.b.a(view, i11);
                                                                    if (postDetailOperationView != null) {
                                                                        i11 = R$id.postDetailSubjectView;
                                                                        PostDetailSubjectView postDetailSubjectView = (PostDetailSubjectView) n6.b.a(view, i11);
                                                                        if (postDetailSubjectView != null) {
                                                                            i11 = R$id.toolbar;
                                                                            Toolbar toolbar = (Toolbar) n6.b.a(view, i11);
                                                                            if (toolbar != null) {
                                                                                i11 = R$id.toolbarLayout;
                                                                                CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) n6.b.a(view, i11);
                                                                                if (collapsingToolbarLayout != null && (viewA2 = n6.b.a(view, (i11 = R$id.tvPostDesc))) != null) {
                                                                                    j0 j0VarA = j0.a(viewA2);
                                                                                    i11 = R$id.tvPostTime;
                                                                                    AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                                                                                    if (appCompatTextView != null && (viewA3 = n6.b.a(view, (i11 = R$id.tvPostTitle))) != null) {
                                                                                        l0 l0VarA = l0.a(viewA3);
                                                                                        i11 = R$id.tvSubject;
                                                                                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                                                                        if (appCompatTextView2 != null) {
                                                                                            i11 = R$id.tvTitle;
                                                                                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                                                                            if (appCompatTextView3 != null && (viewA4 = n6.b.a(view, (i11 = R$id.viewBg))) != null && (viewA5 = n6.b.a(view, (i11 = R$id.viewTitleLine))) != null) {
                                                                                                return new m(constraintLayout2, textView, constraintLayout, appCompatImageView, appCompatSeekBar, appBarLayout, constraintLayout2, coordinatorLayout, k0VarA, constraintLayout3, frameLayout, group, appCompatImageView2, shapeableImageView, appCompatImageView3, appCompatImageView4, linearLayout, nineGridVideoView, postDetailOperationView, postDetailSubjectView, toolbar, collapsingToolbarLayout, j0VarA, appCompatTextView, l0VarA, appCompatTextView2, appCompatTextView3, viewA4, viewA5);
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

    @NonNull
    public static m c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static m d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_post_detail_common_layout, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f77832a;
    }
}
