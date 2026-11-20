package h00;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import com.transsnet.downloader.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class a1 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f65715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f65716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ImageView f65717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f65718d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final View f65719f;

    public a1(@NonNull View view, @NonNull AppCompatImageView appCompatImageView, @NonNull ImageView imageView, @NonNull AppCompatTextView appCompatTextView, @NonNull View view2) {
        this.f65715a = view;
        this.f65716b = appCompatImageView;
        this.f65717c = imageView;
        this.f65718d = appCompatTextView;
        this.f65719f = view2;
    }

    @NonNull
    public static a1 a(@NonNull View view) {
        View viewA;
        int i11 = R$id.iv_download_fail;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.iv_download_icon;
            ImageView imageView = (ImageView) n6.b.a(view, i11);
            if (imageView != null) {
                i11 = R$id.tv_download_status;
                AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView != null && (viewA = n6.b.a(view, (i11 = R$id.v_download_tips))) != null) {
                    return new a1(view, appCompatImageView, imageView, appCompatTextView, viewA);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    public View getRoot() {
        return this.f65715a;
    }
}
