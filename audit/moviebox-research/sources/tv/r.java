package tv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.postdetail.R$id;
import com.transsion.postdetail.R$layout;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class r implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f77913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MagicIndicator f77914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f77915c;

    public r(@NonNull FrameLayout frameLayout, @NonNull MagicIndicator magicIndicator, @NonNull ViewPager2 viewPager2) {
        this.f77913a = frameLayout;
        this.f77914b = magicIndicator;
        this.f77915c = viewPager2;
    }

    @NonNull
    public static r a(@NonNull View view) {
        int i11 = R$id.magic_indicator;
        MagicIndicator magicIndicator = (MagicIndicator) n6.b.a(view, i11);
        if (magicIndicator != null) {
            i11 = R$id.view_pager;
            ViewPager2 viewPager2 = (ViewPager2) n6.b.a(view, i11);
            if (viewPager2 != null) {
                return new r((FrameLayout) view, magicIndicator, viewPager2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static r c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static r d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_short_tv_home, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f77913a;
    }
}
