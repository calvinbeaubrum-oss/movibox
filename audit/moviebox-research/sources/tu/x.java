package tu;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsion.moviedetail.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class x implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f77649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f77650b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final TextView f77651c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TextView f77652d;

    public x(@NonNull LinearLayoutCompat linearLayoutCompat, @NonNull AppCompatImageView appCompatImageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f77649a = linearLayoutCompat;
        this.f77650b = appCompatImageView;
        this.f77651c = textView;
        this.f77652d = textView2;
    }

    @NonNull
    public static x a(@NonNull View view) {
        int i11 = R$id.ivDefaultImage;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.tvDesc;
            TextView textView = (TextView) n6.b.a(view, i11);
            if (textView != null) {
                i11 = R$id.tv_retry;
                TextView textView2 = (TextView) n6.b.a(view, i11);
                if (textView2 != null) {
                    return new x((LinearLayoutCompat) view, appCompatImageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.f77649a;
    }
}
