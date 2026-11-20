package lt;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import com.transsion.home.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f70380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TextView f70381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f70382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f70383d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f70384f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final TextView f70385g;

    public a0(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull AppCompatImageView appCompatImageView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f70380a = linearLayout;
        this.f70381b = textView;
        this.f70382c = linearLayout2;
        this.f70383d = appCompatImageView;
        this.f70384f = textView2;
        this.f70385g = textView3;
    }

    @NonNull
    public static a0 a(@NonNull View view) {
        int i11 = R$id.btnClaim;
        TextView textView = (TextView) n6.b.a(view, i11);
        if (textView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i11 = R$id.ivIcon;
            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.tvSubTitle;
                TextView textView2 = (TextView) n6.b.a(view, i11);
                if (textView2 != null) {
                    i11 = R$id.tvTitle;
                    TextView textView3 = (TextView) n6.b.a(view, i11);
                    if (textView3 != null) {
                        return new a0(linearLayout, textView, linearLayout, appCompatImageView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f70380a;
    }
}
