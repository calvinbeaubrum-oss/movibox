package tx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.subroom.R$id;
import com.transsion.subroom.R$layout;
import com.transsion.subroom.guide.Indicator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class a implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f78050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f78051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f78052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final Indicator f78053d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f78054f;

    public a(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2, @NonNull Indicator indicator, @NonNull ViewPager2 viewPager2) {
        this.f78050a = constraintLayout;
        this.f78051b = appCompatTextView;
        this.f78052c = appCompatTextView2;
        this.f78053d = indicator;
        this.f78054f = viewPager2;
    }

    @NonNull
    public static a a(@NonNull View view) {
        int i11 = R$id.btn_continue;
        AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
        if (appCompatTextView != null) {
            i11 = R$id.btn_skip;
            AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
            if (appCompatTextView2 != null) {
                i11 = R$id.indicator;
                Indicator indicator = (Indicator) n6.b.a(view, i11);
                if (indicator != null) {
                    i11 = R$id.view_pager;
                    ViewPager2 viewPager2 = (ViewPager2) n6.b.a(view, i11);
                    if (viewPager2 != null) {
                        return new a((ConstraintLayout) view, appCompatTextView, appCompatTextView2, indicator, viewPager2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static a c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static a d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_guide, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f78050a;
    }
}
