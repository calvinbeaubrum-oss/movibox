package ev;

import android.view.View;
import androidx.annotation.NonNull;
import com.noober.background.view.BLView;
import com.tn.lib.widget.TnTextView;
import com.transsion.play.detail.R$id;
import n6.b;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class a implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f64356a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TnTextView f64357b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final BLView f64358c;

    public a(@NonNull View view, @NonNull TnTextView tnTextView, @NonNull BLView bLView) {
        this.f64356a = view;
        this.f64357b = tnTextView;
        this.f64358c = bLView;
    }

    @NonNull
    public static a a(@NonNull View view) {
        int i11 = R$id.tv_title;
        TnTextView tnTextView = (TnTextView) b.a(view, i11);
        if (tnTextView != null) {
            i11 = R$id.v_dot;
            BLView bLView = (BLView) b.a(view, i11);
            if (bLView != null) {
                return new a(view, tnTextView, bLView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    public View getRoot() {
        return this.f64356a;
    }
}
