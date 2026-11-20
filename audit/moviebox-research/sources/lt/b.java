package lt;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.tn.lib.view.TitleLayout;
import com.transsion.home.R$id;
import com.transsion.home.R$layout;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f70386a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final MagicIndicator f70387b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TitleLayout f70388c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f70389d;

    public b(@NonNull ConstraintLayout constraintLayout, @NonNull MagicIndicator magicIndicator, @NonNull TitleLayout titleLayout, @NonNull ViewPager2 viewPager2) {
        this.f70386a = constraintLayout;
        this.f70387b = magicIndicator;
        this.f70388c = titleLayout;
        this.f70389d = viewPager2;
    }

    @NonNull
    public static b a(@NonNull View view) {
        int i11 = R$id.magic_indicator;
        MagicIndicator magicIndicator = (MagicIndicator) n6.b.a(view, i11);
        if (magicIndicator != null) {
            i11 = R$id.tool_bar;
            TitleLayout titleLayout = (TitleLayout) n6.b.a(view, i11);
            if (titleLayout != null) {
                i11 = R$id.view_pager;
                ViewPager2 viewPager2 = (ViewPager2) n6.b.a(view, i11);
                if (viewPager2 != null) {
                    return new b((ConstraintLayout) view, magicIndicator, titleLayout, viewPager2);
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
        View viewInflate = layoutInflater.inflate(R$layout.activity_movie_filter, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f70386a;
    }
}
