package xy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.view.TitleLayout;
import com.transsion.usercenter.R$id;
import com.transsion.usercenter.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class g implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f80804a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f80805b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TitleLayout f80806c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f80807d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f80808f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f80809g;

    public g(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull TitleLayout titleLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f80804a = constraintLayout;
        this.f80805b = imageView;
        this.f80806c = titleLayout;
        this.f80807d = textView;
        this.f80808f = textView2;
        this.f80809g = textView3;
    }

    @NonNull
    public static g a(@NonNull View view) {
        int i11 = R$id.ivLogo;
        ImageView imageView = (ImageView) n6.b.a(view, i11);
        if (imageView != null) {
            i11 = R$id.titleLayout;
            TitleLayout titleLayout = (TitleLayout) n6.b.a(view, i11);
            if (titleLayout != null) {
                i11 = R$id.tvAgreement;
                TextView textView = (TextView) n6.b.a(view, i11);
                if (textView != null) {
                    i11 = R$id.tvAppName;
                    TextView textView2 = (TextView) n6.b.a(view, i11);
                    if (textView2 != null) {
                        i11 = R$id.tvAppVersion;
                        TextView textView3 = (TextView) n6.b.a(view, i11);
                        if (textView3 != null) {
                            return new g((ConstraintLayout) view, imageView, titleLayout, textView, textView2, textView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static g c(@NonNull LayoutInflater layoutInflater) {
        return d(layoutInflater, null, false);
    }

    @NonNull
    public static g d(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z11) {
        View viewInflate = layoutInflater.inflate(R$layout.activity_pro_file_setting_about_us, viewGroup, false);
        if (z11) {
            viewGroup.addView(viewInflate);
        }
        return a(viewInflate);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f80804a;
    }
}
