package sw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.imageview.ShapeableImageView;
import com.tn.lib.view.RoomJoinAnimationView;
import com.tn.lib.view.expand.ExpandView;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;
import com.transsion.room.view.roundimage.PileLayout;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class j implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f76528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppBarLayout f76529b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f76530c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ExpandView f76531d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final FrameLayout f76532f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final Group f76533g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f76534h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f76535i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f76536j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f76537k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final ImageView f76538l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final LinearLayout f76539m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final MagicIndicator f76540n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    @NonNull
    public final PileLayout f76541o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f76542p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f76543q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    @NonNull
    public final RoomJoinAnimationView f76544r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final View f76545s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f76546t;

    public j(@NonNull ConstraintLayout constraintLayout, @NonNull AppBarLayout appBarLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull ExpandView expandView, @NonNull FrameLayout frameLayout, @NonNull Group group, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull ShapeableImageView shapeableImageView, @NonNull AppCompatImageView appCompatImageView3, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout, @NonNull MagicIndicator magicIndicator, @NonNull PileLayout pileLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull RoomJoinAnimationView roomJoinAnimationView, @NonNull View view, @NonNull ViewPager2 viewPager2) {
        this.f76528a = constraintLayout;
        this.f76529b = appBarLayout;
        this.f76530c = constraintLayout2;
        this.f76531d = expandView;
        this.f76532f = frameLayout;
        this.f76533g = group;
        this.f76534h = appCompatImageView;
        this.f76535i = appCompatImageView2;
        this.f76536j = shapeableImageView;
        this.f76537k = appCompatImageView3;
        this.f76538l = imageView;
        this.f76539m = linearLayout;
        this.f76540n = magicIndicator;
        this.f76541o = pileLayout;
        this.f76542p = appCompatTextView;
        this.f76543q = appCompatTextView2;
        this.f76544r = roomJoinAnimationView;
        this.f76545s = view;
        this.f76546t = viewPager2;
    }

    @NonNull
    public static j a(@NonNull View view) {
        View viewA;
        int i11 = R$id.app_bar;
        AppBarLayout appBarLayout = (AppBarLayout) n6.b.a(view, i11);
        if (appBarLayout != null) {
            i11 = R$id.cl_top_content;
            ConstraintLayout constraintLayout = (ConstraintLayout) n6.b.a(view, i11);
            if (constraintLayout != null) {
                i11 = R$id.ev_room_des;
                ExpandView expandView = (ExpandView) n6.b.a(view, i11);
                if (expandView != null) {
                    i11 = R$id.fl_tab;
                    FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
                    if (frameLayout != null) {
                        i11 = R$id.group_member;
                        Group group = (Group) n6.b.a(view, i11);
                        if (group != null) {
                            i11 = R$id.iv_back;
                            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                            if (appCompatImageView != null) {
                                i11 = R$id.iv_publish;
                                AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                                if (appCompatImageView2 != null) {
                                    i11 = R$id.iv_room_cover;
                                    ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
                                    if (shapeableImageView != null) {
                                        i11 = R$id.iv_share;
                                        AppCompatImageView appCompatImageView3 = (AppCompatImageView) n6.b.a(view, i11);
                                        if (appCompatImageView3 != null) {
                                            i11 = R$id.iv_top_bg;
                                            ImageView imageView = (ImageView) n6.b.a(view, i11);
                                            if (imageView != null) {
                                                i11 = R$id.ll_header_root;
                                                LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
                                                if (linearLayout != null) {
                                                    i11 = R$id.magic_indicator;
                                                    MagicIndicator magicIndicator = (MagicIndicator) n6.b.a(view, i11);
                                                    if (magicIndicator != null) {
                                                        i11 = R$id.pl_member_ic;
                                                        PileLayout pileLayout = (PileLayout) n6.b.a(view, i11);
                                                        if (pileLayout != null) {
                                                            i11 = R$id.tv_member;
                                                            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                                                            if (appCompatTextView != null) {
                                                                i11 = R$id.tv_title;
                                                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                                                if (appCompatTextView2 != null) {
                                                                    i11 = R$id.v_join;
                                                                    RoomJoinAnimationView roomJoinAnimationView = (RoomJoinAnimationView) n6.b.a(view, i11);
                                                                    if (roomJoinAnimationView != null && (viewA = n6.b.a(view, (i11 = R$id.v_title_bar_bg))) != null) {
                                                                        i11 = R$id.view_pager;
                                                                        ViewPager2 viewPager2 = (ViewPager2) n6.b.a(view, i11);
                                                                        if (viewPager2 != null) {
                                                                            return new j((ConstraintLayout) view, appBarLayout, constraintLayout, expandView, frameLayout, group, appCompatImageView, appCompatImageView2, shapeableImageView, appCompatImageView3, imageView, linearLayout, magicIndicator, pileLayout, appCompatTextView, appCompatTextView2, roomJoinAnimationView, viewA, viewPager2);
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
    public static j c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static j d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_room_detail_new, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f76528a;
    }
}
