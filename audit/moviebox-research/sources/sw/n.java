package sw;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class n implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f76561a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f76562b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f76563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f76564d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final MagicIndicator f76565f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f76566g;

    public n(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull AppCompatImageView appCompatImageView, @NonNull ImageView imageView, @NonNull MagicIndicator magicIndicator, @NonNull ViewPager2 viewPager2) {
        this.f76561a = constraintLayout;
        this.f76562b = constraintLayout2;
        this.f76563c = appCompatImageView;
        this.f76564d = imageView;
        this.f76565f = magicIndicator;
        this.f76566g = viewPager2;
    }

    @NonNull
    public static n a(@NonNull View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i11 = R$id.iv_back;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.iv_top_bg;
            ImageView imageView = (ImageView) n6.b.a(view, i11);
            if (imageView != null) {
                i11 = R$id.magic_indicator;
                MagicIndicator magicIndicator = (MagicIndicator) n6.b.a(view, i11);
                if (magicIndicator != null) {
                    i11 = R$id.view_pager;
                    ViewPager2 viewPager2 = (ViewPager2) n6.b.a(view, i11);
                    if (viewPager2 != null) {
                        return new n(constraintLayout, constraintLayout, appCompatImageView, imageView, magicIndicator, viewPager2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static n c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static n d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_room_list_main, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f76561a;
    }
}
