package tu;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.noober.background.view.BLLinearLayout;
import com.noober.background.view.BLTextView;
import com.tn.lib.view.MaxHeightNestedScrollView;
import com.transsion.moviedetail.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final BLLinearLayout f77458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f77459b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f77460c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final MaxHeightNestedScrollView f77461d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final BLTextView f77462f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final BLTextView f77463g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77464h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77465i;

    public d(@NonNull BLLinearLayout bLLinearLayout, @NonNull ImageView imageView, @NonNull LinearLayoutCompat linearLayoutCompat, @NonNull MaxHeightNestedScrollView maxHeightNestedScrollView, @NonNull BLTextView bLTextView, @NonNull BLTextView bLTextView2, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatTextView appCompatTextView2) {
        this.f77458a = bLLinearLayout;
        this.f77459b = imageView;
        this.f77460c = linearLayoutCompat;
        this.f77461d = maxHeightNestedScrollView;
        this.f77462f = bLTextView;
        this.f77463g = bLTextView2;
        this.f77464h = appCompatTextView;
        this.f77465i = appCompatTextView2;
    }

    @NonNull
    public static d a(@NonNull View view) {
        int i11 = R$id.iv_select;
        ImageView imageView = (ImageView) n6.b.a(view, i11);
        if (imageView != null) {
            i11 = R$id.ll_select;
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) n6.b.a(view, i11);
            if (linearLayoutCompat != null) {
                i11 = R$id.ns_tips;
                MaxHeightNestedScrollView maxHeightNestedScrollView = (MaxHeightNestedScrollView) n6.b.a(view, i11);
                if (maxHeightNestedScrollView != null) {
                    i11 = R$id.tv_back;
                    BLTextView bLTextView = (BLTextView) n6.b.a(view, i11);
                    if (bLTextView != null) {
                        i11 = R$id.tv_confirm;
                        BLTextView bLTextView2 = (BLTextView) n6.b.a(view, i11);
                        if (bLTextView2 != null) {
                            i11 = R$id.tv_tips;
                            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                            if (appCompatTextView != null) {
                                i11 = R$id.tv_title;
                                AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                                if (appCompatTextView2 != null) {
                                    return new d((BLLinearLayout) view, imageView, linearLayoutCompat, maxHeightNestedScrollView, bLTextView, bLTextView2, appCompatTextView, appCompatTextView2);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public BLLinearLayout getRoot() {
        return this.f77458a;
    }
}
