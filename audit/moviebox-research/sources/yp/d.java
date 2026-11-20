package yp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Space;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import com.tn.lib.widget.R$id;
import com.tn.lib.widget.R$layout;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final View f81589a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f81590b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ProgressBar f81591c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f81592d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final Space f81593f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final AppCompatTextView f81594g;

    public d(@NonNull View view, @NonNull AppCompatTextView appCompatTextView, @NonNull ProgressBar progressBar, @NonNull AppCompatTextView appCompatTextView2, @NonNull Space space, @NonNull AppCompatTextView appCompatTextView3) {
        this.f81589a = view;
        this.f81590b = appCompatTextView;
        this.f81591c = progressBar;
        this.f81592d = appCompatTextView2;
        this.f81593f = space;
        this.f81594g = appCompatTextView3;
    }

    @NonNull
    public static d a(@NonNull View view) {
        int i11 = R$id.go_to_setting;
        AppCompatTextView appCompatTextView = (AppCompatTextView) n6.b.a(view, i11);
        if (appCompatTextView != null) {
            i11 = R$id.progress_bar;
            ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
            if (progressBar != null) {
                i11 = R$id.retry;
                AppCompatTextView appCompatTextView2 = (AppCompatTextView) n6.b.a(view, i11);
                if (appCompatTextView2 != null) {
                    i11 = R$id.space;
                    Space space = (Space) n6.b.a(view, i11);
                    if (space != null) {
                        i11 = R$id.tv_title;
                        AppCompatTextView appCompatTextView3 = (AppCompatTextView) n6.b.a(view, i11);
                        if (appCompatTextView3 != null) {
                            return new d(view, appCompatTextView, progressBar, appCompatTextView2, space, appCompatTextView3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @NonNull
    public static d b(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup == null) {
            throw new NullPointerException("parent");
        }
        layoutInflater.inflate(R$layout.view_no_network, viewGroup);
        return a(viewGroup);
    }

    @Override // n6.a
    @NonNull
    public View getRoot() {
        return this.f81589a;
    }
}
