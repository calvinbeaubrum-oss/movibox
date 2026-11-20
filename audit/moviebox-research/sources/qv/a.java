package qv;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import com.transsion.player.view.R$id;
import n6.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayout f74982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ImageView f74983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ProgressBar f74984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayout f74985d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final ProgressBar f74986f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final LinearLayout f74987g;

    public a(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ProgressBar progressBar, @NonNull LinearLayout linearLayout2, @NonNull ProgressBar progressBar2, @NonNull LinearLayout linearLayout3) {
        this.f74982a = linearLayout;
        this.f74983b = imageView;
        this.f74984c = progressBar;
        this.f74985d = linearLayout2;
        this.f74986f = progressBar2;
        this.f74987g = linearLayout3;
    }

    @NonNull
    public static a a(@NonNull View view) {
        int i11 = R$id.bvIV;
        ImageView imageView = (ImageView) b.a(view, i11);
        if (imageView != null) {
            i11 = R$id.bvProgress;
            ProgressBar progressBar = (ProgressBar) b.a(view, i11);
            if (progressBar != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                i11 = R$id.secProgress;
                ProgressBar progressBar2 = (ProgressBar) b.a(view, i11);
                if (progressBar2 != null) {
                    i11 = R$id.tipsLL;
                    LinearLayout linearLayout2 = (LinearLayout) b.a(view, i11);
                    if (linearLayout2 != null) {
                        return new a(linearLayout, imageView, progressBar, linearLayout, progressBar2, linearLayout2);
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
        return this.f74982a;
    }
}
