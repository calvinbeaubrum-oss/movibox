package xy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.material.imageview.ShapeableImageView;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;
import com.transsion.usercenter.setting.labelsfeedback.UCEditText;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class z implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f80992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f80993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatEditText f80994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final UCEditText f80995d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final ShapeableImageView f80996f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatEditText f80997g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final View f80998h;

    public z(@NonNull LinearLayout linearLayout, @NonNull AppCompatTextView appCompatTextView, @NonNull AppCompatEditText appCompatEditText, @NonNull UCEditText uCEditText, @NonNull ShapeableImageView shapeableImageView, @NonNull AppCompatEditText appCompatEditText2, @NonNull View view) {
        this.f80992a = linearLayout;
        this.f80993b = appCompatTextView;
        this.f80994c = appCompatEditText;
        this.f80995d = uCEditText;
        this.f80996f = shapeableImageView;
        this.f80997g = appCompatEditText2;
        this.f80998h = view;
    }

    @NonNull
    public static z a(@NonNull View view) {
        View viewA;
        int i11 = R$id.countTextView;
        AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
        if (appCompatTextView != null) {
            i11 = R$id.countryEditText;
            AppCompatEditText appCompatEditText = (AppCompatEditText) n6.b.a(view, i11);
            if (appCompatEditText != null) {
                i11 = R$id.editText;
                UCEditText uCEditText = (UCEditText) n6.b.a(view, i11);
                if (uCEditText != null) {
                    i11 = R$id.imageView;
                    ShapeableImageView shapeableImageView = (ShapeableImageView) n6.b.a(view, i11);
                    if (shapeableImageView != null) {
                        i11 = R$id.phoneEditText;
                        AppCompatEditText appCompatEditText2 = (AppCompatEditText) n6.b.a(view, i11);
                        if (appCompatEditText2 != null && (viewA = n6.b.a(view, (i11 = R$id.view6))) != null) {
                            return new z((LinearLayout) view, appCompatTextView, appCompatEditText, uCEditText, shapeableImageView, appCompatEditText2, viewA);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static z c(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.feedback_option_list_footer, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f80992a;
    }
}
