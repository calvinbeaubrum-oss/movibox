package zu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.noober.background.view.BLView;
import com.transsion.ninegridview.R$id;
import com.transsion.ninegridview.R$layout;
import com.transsion.ninegridview.preview.HackyViewPager;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f82164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final BLView f82165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final BLView f82166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final ImageView f82167d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f82168f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final View f82169g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f82170h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final TextView f82171i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f82172j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @NonNull
    public final HackyViewPager f82173k;

    public b(@NonNull ConstraintLayout constraintLayout, @NonNull BLView bLView, @NonNull BLView bLView2, @NonNull ImageView imageView, @NonNull ConstraintLayout constraintLayout2, @NonNull View view, @NonNull AppCompatTextView appCompatTextView, @NonNull TextView textView, @NonNull AppCompatTextView appCompatTextView2, @NonNull HackyViewPager hackyViewPager) {
        this.f82164a = constraintLayout;
        this.f82165b = bLView;
        this.f82166c = bLView2;
        this.f82167d = imageView;
        this.f82168f = constraintLayout2;
        this.f82169g = view;
        this.f82170h = appCompatTextView;
        this.f82171i = textView;
        this.f82172j = appCompatTextView2;
        this.f82173k = hackyViewPager;
    }

    @NonNull
    public static b a(@NonNull View view) {
        int i11 = R$id.bg_download;
        BLView bLView = (BLView) n6.b.a(view, i11);
        if (bLView != null) {
            i11 = R$id.bg_share;
            BLView bLView2 = (BLView) n6.b.a(view, i11);
            if (bLView2 != null) {
                i11 = R$id.iv_back;
                ImageView imageView = (ImageView) n6.b.a(view, i11);
                if (imageView != null) {
                    ConstraintLayout constraintLayout = (ConstraintLayout) view;
                    i11 = R$id.statusSpace;
                    View viewA = n6.b.a(view, i11);
                    if (viewA != null) {
                        i11 = R$id.tv_download;
                        AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView != null) {
                            i11 = R$id.tv_pager;
                            TextView textView = (TextView) n6.b.a(view, i11);
                            if (textView != null) {
                                i11 = R$id.tv_share;
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                if (appCompatTextView2 != null) {
                                    i11 = R$id.viewPager;
                                    HackyViewPager hackyViewPager = (HackyViewPager) n6.b.a(view, i11);
                                    if (hackyViewPager != null) {
                                        return new b(constraintLayout, bLView, bLView2, imageView, constraintLayout, viewA, appCompatTextView, textView, appCompatTextView2, hackyViewPager);
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
        View viewInflate = layoutInflater.inflate(R$layout.activity_preview, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f82164a;
    }
}
