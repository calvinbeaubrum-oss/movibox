package mv;

import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsion.player.longvideo.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class g implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f71214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final EditText f71215b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f71216c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f71217d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f71218f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f71219g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f71220h;

    public g(@NonNull LinearLayoutCompat linearLayoutCompat, @NonNull EditText editText, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatImageView appCompatImageView3, @NonNull LinearLayoutCompat linearLayoutCompat2, @NonNull LinearLayoutCompat linearLayoutCompat3) {
        this.f71214a = linearLayoutCompat;
        this.f71215b = editText;
        this.f71216c = appCompatImageView;
        this.f71217d = appCompatImageView2;
        this.f71218f = appCompatImageView3;
        this.f71219g = linearLayoutCompat2;
        this.f71220h = linearLayoutCompat3;
    }

    @NonNull
    public static g a(@NonNull View view) {
        int i11 = R$id.et_sync_adjust;
        EditText editText = (EditText) n6.b.a(view, i11);
        if (editText != null) {
            i11 = R$id.iv_close;
            AppCompatImageView appCompatImageView = (AppCompatImageView) n6.b.a(view, i11);
            if (appCompatImageView != null) {
                i11 = R$id.iv_sync_adjust_minus;
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) n6.b.a(view, i11);
                if (appCompatImageView2 != null) {
                    i11 = R$id.iv_sync_adjust_plus;
                    AppCompatImageView appCompatImageView3 = (AppCompatImageView) n6.b.a(view, i11);
                    if (appCompatImageView3 != null) {
                        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view;
                        i11 = R$id.llSyncAdjust;
                        LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) n6.b.a(view, i11);
                        if (linearLayoutCompat2 != null) {
                            return new g(linearLayoutCompat, editText, appCompatImageView, appCompatImageView2, appCompatImageView3, linearLayoutCompat, linearLayoutCompat2);
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
    public LinearLayoutCompat getRoot() {
        return this.f71214a;
    }
}
