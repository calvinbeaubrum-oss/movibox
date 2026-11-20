package wx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.baseui.widget.EditTextWithClear;
import com.transsion.baseui.widget.NestedScrollableHost;
import com.transsion.subtitle.R$id;
import com.transsion.subtitle.R$layout;
import net.lucode.hackware.magicindicator.MagicIndicator;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class f implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f79686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final EditTextWithClear f79687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f79688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f79689d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final MagicIndicator f79690f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final NestedScrollableHost f79691g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final TextView f79692h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f79693i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f79694j;

    public f(@NonNull ConstraintLayout constraintLayout, @NonNull EditTextWithClear editTextWithClear, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull MagicIndicator magicIndicator, @NonNull NestedScrollableHost nestedScrollableHost, @NonNull TextView textView, @NonNull AppCompatTextView appCompatTextView, @NonNull ViewPager2 viewPager2) {
        this.f79686a = constraintLayout;
        this.f79687b = editTextWithClear;
        this.f79688c = appCompatImageView;
        this.f79689d = appCompatImageView2;
        this.f79690f = magicIndicator;
        this.f79691g = nestedScrollableHost;
        this.f79692h = textView;
        this.f79693i = appCompatTextView;
        this.f79694j = viewPager2;
    }

    @NonNull
    public static f a(@NonNull View view) {
        int i11 = R$id.et_search_keyword;
        EditTextWithClear editTextWithClear = (EditTextWithClear) n6.b.a(view, i11);
        if (editTextWithClear != null) {
            i11 = R$id.ivBack;
            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.iv_search_keyword;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView2 != null) {
                    i11 = R$id.magic_indicator;
                    MagicIndicator magicIndicator = (MagicIndicator) n6.b.a(view, i11);
                    if (magicIndicator != null) {
                        i11 = R$id.nsh_content;
                        NestedScrollableHost nestedScrollableHost = (NestedScrollableHost) n6.b.a(view, i11);
                        if (nestedScrollableHost != null) {
                            i11 = R$id.tv_search;
                            TextView textView = (TextView) n6.b.a(view, i11);
                            if (textView != null) {
                                i11 = R$id.tvStyle;
                                AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                                if (appCompatTextView != null) {
                                    i11 = R$id.view_pager;
                                    ViewPager2 viewPager2 = (ViewPager2) n6.b.a(view, i11);
                                    if (viewPager2 != null) {
                                        return new f((ConstraintLayout) view, editTextWithClear, appCompatImageView, appCompatImageView2, magicIndicator, nestedScrollableHost, textView, appCompatTextView, viewPager2);
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
    public static f c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static f d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.fragment_subtitle_search_download, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f79686a;
    }
}
