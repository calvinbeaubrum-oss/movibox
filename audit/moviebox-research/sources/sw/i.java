package sw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.CheckInAnimationView;
import com.tn.lib.view.ToolBarCheckInAnimationView;
import com.tn.lib.view.expand.ExpandView;
import com.transsion.publish.view.PublishStateView;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;
import com.transsion.room.view.roundimage.PileLayout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class i implements n6.a {

    @NonNull
    public final ViewPager2 A;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f76503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppBarLayout f76504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f76505c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f76506d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final CoordinatorLayout f76507f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f76508g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f76509h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final PublishStateView f76510i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f76511j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f76512k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f76513l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final v f76514m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final PileLayout f76515n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f76516o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final Toolbar f76517p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    public final FrameLayout f76518q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    public final CollapsingToolbarLayout f76519r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final ToolBarCheckInAnimationView f76520s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NonNull
    public final TextView f76521t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    @NonNull
    public final CheckInAnimationView f76522u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    @NonNull
    public final TextView f76523v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f76524w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @NonNull
    public final ExpandView f76525x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f76526y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f76527z;

    public i(@NonNull ConstraintLayout constraintLayout, @NonNull AppBarLayout appBarLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull ConstraintLayout constraintLayout2, @NonNull CoordinatorLayout coordinatorLayout, @NonNull AppCompatImageView appCompatImageView2, @NonNull ShapeableImageView shapeableImageView, @NonNull PublishStateView publishStateView, @NonNull ShapeableImageView shapeableImageView2, @NonNull ShapeableImageView shapeableImageView3, @NonNull AppCompatImageView appCompatImageView3, @NonNull v vVar, @NonNull PileLayout pileLayout, @NonNull ConstraintLayout constraintLayout3, @NonNull Toolbar toolbar, @NonNull FrameLayout frameLayout, @NonNull CollapsingToolbarLayout collapsingToolbarLayout, @NonNull ToolBarCheckInAnimationView toolBarCheckInAnimationView, @NonNull TextView textView, @NonNull CheckInAnimationView checkInAnimationView, @NonNull TextView textView2, @NonNull AppCompatTextView appCompatTextView, @NonNull ExpandView expandView, @NonNull AppCompatTextView appCompatTextView2, @NonNull AppCompatTextView appCompatTextView3, @NonNull ViewPager2 viewPager2) {
        this.f76503a = constraintLayout;
        this.f76504b = appBarLayout;
        this.f76505c = appCompatImageView;
        this.f76506d = constraintLayout2;
        this.f76507f = coordinatorLayout;
        this.f76508g = appCompatImageView2;
        this.f76509h = shapeableImageView;
        this.f76510i = publishStateView;
        this.f76511j = shapeableImageView2;
        this.f76512k = shapeableImageView3;
        this.f76513l = appCompatImageView3;
        this.f76514m = vVar;
        this.f76515n = pileLayout;
        this.f76516o = constraintLayout3;
        this.f76517p = toolbar;
        this.f76518q = frameLayout;
        this.f76519r = collapsingToolbarLayout;
        this.f76520s = toolBarCheckInAnimationView;
        this.f76521t = textView;
        this.f76522u = checkInAnimationView;
        this.f76523v = textView2;
        this.f76524w = appCompatTextView;
        this.f76525x = expandView;
        this.f76526y = appCompatTextView2;
        this.f76527z = appCompatTextView3;
        this.A = viewPager2;
    }

    @NonNull
    public static i a(@NonNull View view) {
        View viewA;
        int i11 = R$id.app_bar;
        AppBarLayout appBarLayout = (AppBarLayout) n6.b.a(view, i11);
        if (appBarLayout != null) {
            i11 = R$id.bg_transparent;
            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.cl_bar;
                ConstraintLayout constraintLayout = (ConstraintLayout) n6.b.a(view, i11);
                if (constraintLayout != null) {
                    i11 = R$id.content;
                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) n6.b.a(view, i11);
                    if (coordinatorLayout != null) {
                        i11 = R$id.iv_back;
                        AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                        if (appCompatImageView2 != null) {
                            i11 = R$id.iv_cover_small;
                            ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
                            if (shapeableImageView != null) {
                                i11 = R$id.ivPublish;
                                PublishStateView publishStateView = (PublishStateView) n6.b.a(view, i11);
                                if (publishStateView != null) {
                                    i11 = R$id.iv_room_blur_cover;
                                    ShapeableImageView shapeableImageView2 = (ShapeableImageView) n6.b.a(view, i11);
                                    if (shapeableImageView2 != null) {
                                        i11 = R$id.iv_room_cover;
                                        ShapeableImageView shapeableImageView3 = (ShapeableImageView) n6.b.a(view, i11);
                                        if (shapeableImageView3 != null) {
                                            i11 = R$id.iv_share;
                                            AppCompatImageView appCompatImageView3 = (AppCompatImageView) n6.b.a(view, i11);
                                            if (appCompatImageView3 != null && (viewA = n6.b.a(view, (i11 = R$id.ll_tab_room))) != null) {
                                                v vVarA = v.a(viewA);
                                                i11 = R$id.pl_member_ic;
                                                PileLayout pileLayout = (PileLayout) n6.b.a(view, i11);
                                                if (pileLayout != null) {
                                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) view;
                                                    i11 = R$id.toolbar;
                                                    Toolbar toolbar = (Toolbar) n6.b.a(view, i11);
                                                    if (toolbar != null) {
                                                        i11 = R$id.toolbar_frame;
                                                        FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
                                                        if (frameLayout != null) {
                                                            i11 = R$id.toolbar_layout;
                                                            CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) n6.b.a(view, i11);
                                                            if (collapsingToolbarLayout != null) {
                                                                i11 = R$id.toolbarTvCheckIn;
                                                                ToolBarCheckInAnimationView toolBarCheckInAnimationView = (ToolBarCheckInAnimationView) n6.b.a(view, i11);
                                                                if (toolBarCheckInAnimationView != null) {
                                                                    i11 = R$id.toolbar_tv_edit;
                                                                    TextView textView = (TextView) n6.b.a(view, i11);
                                                                    if (textView != null) {
                                                                        i11 = R$id.tvCheckIn;
                                                                        CheckInAnimationView checkInAnimationView = (CheckInAnimationView) n6.b.a(view, i11);
                                                                        if (checkInAnimationView != null) {
                                                                            i11 = R$id.tv_edit;
                                                                            TextView textView2 = (TextView) n6.b.a(view, i11);
                                                                            if (textView2 != null) {
                                                                                i11 = R$id.tv_member_count;
                                                                                AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                                                                                if (appCompatTextView != null) {
                                                                                    i11 = R$id.tv_room_info_desc;
                                                                                    ExpandView expandView = (ExpandView) n6.b.a(view, i11);
                                                                                    if (expandView != null) {
                                                                                        i11 = R$id.tv_room_title;
                                                                                        AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                                                                        if (appCompatTextView2 != null) {
                                                                                            i11 = R$id.tv_title;
                                                                                            AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                                                                                            if (appCompatTextView3 != null) {
                                                                                                i11 = R$id.view_pager;
                                                                                                ViewPager2 viewPager2 = (ViewPager2) n6.b.a(view, i11);
                                                                                                if (viewPager2 != null) {
                                                                                                    return new i(constraintLayout2, appBarLayout, appCompatImageView, constraintLayout, coordinatorLayout, appCompatImageView2, shapeableImageView, publishStateView, shapeableImageView2, shapeableImageView3, appCompatImageView3, vVarA, pileLayout, constraintLayout2, toolbar, frameLayout, collapsingToolbarLayout, toolBarCheckInAnimationView, textView, checkInAnimationView, textView2, appCompatTextView, expandView, appCompatTextView2, appCompatTextView3, viewPager2);
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

    @NonNull
    public static i c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static i d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_room_detail, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f76503a;
    }
}
