package h00;

import android.view.View;
import androidx.annotation.NonNull;
import com.noober.background.view.BLView;
import com.tn.lib.widget.TnTextView;
import com.transsnet.downloader.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class b1 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f65747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final TnTextView f65748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final BLView f65749c;

    public b1(@NonNull View view, @NonNull TnTextView tnTextView, @NonNull BLView bLView) {
        this.f65747a = view;
        this.f65748b = tnTextView;
        this.f65749c = bLView;
    }

    @NonNull
    public static b1 a(@NonNull View view) {
        int i11 = R$id.tv_title;
        TnTextView tnTextView = (TnTextView) n6.b.a(view, i11);
        if (tnTextView != null) {
            i11 = R$id.v_dot;
            BLView bLView = (BLView) n6.b.a(view, i11);
            if (bLView != null) {
                return new b1(view, tnTextView, bLView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    public View getRoot() {
        return this.f65747a;
    }
}
