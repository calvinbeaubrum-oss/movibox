package h00;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.tn.lib.widget.TnTextView;
import com.transsnet.downloader.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class r implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f66002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f66003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f66004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TnTextView f66005d;

    public r(@NonNull View view, @NonNull AppCompatImageView appCompatImageView, @NonNull LinearLayoutCompat linearLayoutCompat, @NonNull TnTextView tnTextView) {
        this.f66002a = view;
        this.f66003b = appCompatImageView;
        this.f66004c = linearLayoutCompat;
        this.f66005d = tnTextView;
    }

    @NonNull
    public static r a(@NonNull View view) {
        int i11 = R$id.iv_icon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
        if (appCompatImageView != null) {
            i11 = R$id.ll_download_inner;
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) n6.b.a(view, i11);
            if (linearLayoutCompat != null) {
                i11 = R$id.tv_tips;
                TnTextView tnTextView = (TnTextView) n6.b.a(view, i11);
                if (tnTextView != null) {
                    return new r(view, appCompatImageView, linearLayoutCompat, tnTextView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    public View getRoot() {
        return this.f66002a;
    }
}
