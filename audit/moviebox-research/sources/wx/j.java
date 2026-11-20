package wx;

import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.transsion.subtitle.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class j implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f79740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final EditText f79741b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f79742c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f79743d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatImageView f79744f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f79745g;

    public j(@NonNull LinearLayoutCompat linearLayoutCompat, @NonNull EditText editText, @NonNull AppCompatImageView appCompatImageView, @NonNull AppCompatImageView appCompatImageView2, @NonNull AppCompatImageView appCompatImageView3, @NonNull LinearLayoutCompat linearLayoutCompat2) {
        this.f79740a = linearLayoutCompat;
        this.f79741b = editText;
        this.f79742c = appCompatImageView;
        this.f79743d = appCompatImageView2;
        this.f79744f = appCompatImageView3;
        this.f79745g = linearLayoutCompat2;
    }

    @NonNull
    public static j a(@NonNull View view) {
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
                        return new j(linearLayoutCompat, editText, appCompatImageView, appCompatImageView2, appCompatImageView3, linearLayoutCompat);
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
        return this.f79740a;
    }
}
