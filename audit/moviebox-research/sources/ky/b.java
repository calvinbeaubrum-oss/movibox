package ky;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.tn.lib.view.TitleLayout;
import com.transsion.transfer.R$id;
import com.transsion.transfer.R$layout;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class b implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f69653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayout f69654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final CoordinatorLayout f69655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayout f69656d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final FrameLayout f69657f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final MagicIndicator f69658g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f69659h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final TitleLayout f69660i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final TextView f69661j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final TextView f69662k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f69663l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @NonNull
    public final ImageView f69664m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f69665n;

    public b(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayout linearLayout, @NonNull CoordinatorLayout coordinatorLayout, @NonNull LinearLayout linearLayout2, @NonNull FrameLayout frameLayout, @NonNull MagicIndicator magicIndicator, @NonNull TextView textView, @NonNull TitleLayout titleLayout, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull AppCompatImageView appCompatImageView, @NonNull ImageView imageView, @NonNull ViewPager2 viewPager2) {
        this.f69653a = constraintLayout;
        this.f69654b = linearLayout;
        this.f69655c = coordinatorLayout;
        this.f69656d = linearLayout2;
        this.f69657f = frameLayout;
        this.f69658g = magicIndicator;
        this.f69659h = textView;
        this.f69660i = titleLayout;
        this.f69661j = textView2;
        this.f69662k = textView3;
        this.f69663l = appCompatImageView;
        this.f69664m = imageView;
        this.f69665n = viewPager2;
    }

    @NonNull
    public static b a(@NonNull View view) {
        int i11 = R$id.bottom_layout;
        LinearLayout linearLayout = (LinearLayout) n6.b.a(view, i11);
        if (linearLayout != null) {
            i11 = R$id.cl_root;
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) n6.b.a(view, i11);
            if (coordinatorLayout != null) {
                i11 = R$id.connect_info_layout;
                LinearLayout linearLayout2 = (LinearLayout) n6.b.a(view, i11);
                if (linearLayout2 != null) {
                    i11 = R$id.fl_select_page_container;
                    FrameLayout frameLayout = (FrameLayout) n6.b.a(view, i11);
                    if (frameLayout != null) {
                        i11 = R$id.magic_indicator;
                        MagicIndicator magicIndicator = (MagicIndicator) n6.b.a(view, i11);
                        if (magicIndicator != null) {
                            i11 = R$id.sendMore;
                            TextView textView = (TextView) n6.b.a(view, i11);
                            if (textView != null) {
                                i11 = R$id.tool_bar;
                                TitleLayout titleLayout = (TitleLayout) n6.b.a(view, i11);
                                if (titleLayout != null) {
                                    i11 = R$id.transfer_connect_state;
                                    TextView textView2 = (TextView) n6.b.a(view, i11);
                                    if (textView2 != null) {
                                        i11 = R$id.transfer_connected_devicename;
                                        TextView textView3 = (TextView) n6.b.a(view, i11);
                                        if (textView3 != null) {
                                            i11 = R$id.transfer_connected_state_image;
                                            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
                                            if (appCompatImageView != null) {
                                                i11 = R$id.v_top_bg;
                                                ImageView imageView = (ImageView) n6.b.a(view, i11);
                                                if (imageView != null) {
                                                    i11 = R$id.view_pager;
                                                    ViewPager2 viewPager2 = (ViewPager2) n6.b.a(view, i11);
                                                    if (viewPager2 != null) {
                                                        return new b((ConstraintLayout) view, linearLayout, coordinatorLayout, linearLayout2, frameLayout, magicIndicator, textView, titleLayout, textView2, textView3, appCompatImageView, imageView, viewPager2);
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
    public static b c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static b d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_transfer_status, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f69653a;
    }
}
