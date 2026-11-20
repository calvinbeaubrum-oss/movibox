package tv;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import com.tn.lib.view.HorizontalRecyclerview2;
import com.tn.lib.widget.TnTextView;
import com.transsion.postdetail.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class f0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f77737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final HorizontalRecyclerview2 f77738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77739c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TnTextView f77740d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f77741f;

    public f0(@NonNull View view, @NonNull HorizontalRecyclerview2 horizontalRecyclerview2, @NonNull AppCompatTextView appCompatTextView, @NonNull TnTextView tnTextView, @NonNull AppCompatTextView appCompatTextView2) {
        this.f77737a = view;
        this.f77738b = horizontalRecyclerview2;
        this.f77739c = appCompatTextView;
        this.f77740d = tnTextView;
        this.f77741f = appCompatTextView2;
    }

    @NonNull
    public static f0 a(@NonNull View view) {
        int i11 = R$id.recycler_view;
        HorizontalRecyclerview2 horizontalRecyclerview2 = (HorizontalRecyclerview2) n6.b.a(view, i11);
        if (horizontalRecyclerview2 != null) {
            i11 = R$id.tv_title;
            AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
            if (appCompatTextView != null) {
                i11 = R$id.tv_title_trending;
                TnTextView tnTextView = (TnTextView) n6.b.a(view, i11);
                if (tnTextView != null) {
                    i11 = R$id.tv_view_all;
                    AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                    if (appCompatTextView2 != null) {
                        return new f0(view, horizontalRecyclerview2, appCompatTextView, tnTextView, appCompatTextView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    public View getRoot() {
        return this.f77737a;
    }
}
