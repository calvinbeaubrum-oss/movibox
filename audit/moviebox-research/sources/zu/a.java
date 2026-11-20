package zu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.transsion.ninegridview.R$id;
import com.transsion.ninegridview.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f82159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f82160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f82161c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f82162d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final ViewPager2 f82163f;

    public a(@NonNull ConstraintLayout constraintLayout, @NonNull AppCompatImageView appCompatImageView, @NonNull ConstraintLayout constraintLayout2, @NonNull TextView textView, @NonNull ViewPager2 viewPager2) {
        this.f82159a = constraintLayout;
        this.f82160b = appCompatImageView;
        this.f82161c = constraintLayout2;
        this.f82162d = textView;
        this.f82163f = viewPager2;
    }

    @NonNull
    public static a a(@NonNull View view) {
        int i11 = R$id.iv_download;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            i11 = R$id.tv_pager;
            TextView textView = (TextView) n6.b.a(view, i11);
            if (textView != null) {
                i11 = R$id.viewPager;
                ViewPager2 viewPager2 = (ViewPager2) n6.b.a(view, i11);
                if (viewPager2 != null) {
                    return new a(constraintLayout, appCompatImageView, constraintLayout, textView, viewPager2);
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
        View viewInflate = layoutInflater.inflate(R$layout.activity_gif_image_preview, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f82159a;
    }
}
