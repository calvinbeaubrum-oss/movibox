package tv;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.transsion.postdetail.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class n0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f77870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f77871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayout f77872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f77873d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final TextView f77874f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final View f77875g;

    public n0(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull View view) {
        this.f77870a = linearLayout;
        this.f77871b = imageView;
        this.f77872c = linearLayout2;
        this.f77873d = textView;
        this.f77874f = textView2;
        this.f77875g = view;
    }

    @NonNull
    public static n0 a(@NonNull View view) {
        View viewA;
        int i11 = R$id.ivRight;
        ImageView imageView = (ImageView) n6.b.a(view, i11);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i11 = R$id.tvCountDown;
            TextView textView = (TextView) n6.b.a(view, i11);
            if (textView != null) {
                i11 = R$id.tvGetAdFree;
                TextView textView2 = (TextView) n6.b.a(view, i11);
                if (textView2 != null && (viewA = n6.b.a(view, (i11 = R$id.view))) != null) {
                    return new n0(linearLayout, imageView, linearLayout, textView, textView2, viewA);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayout getRoot() {
        return this.f77870a;
    }
}
