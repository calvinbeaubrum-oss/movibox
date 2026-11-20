package lt;

import android.view.View;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.transsion.home.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class b0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f70390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f70391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f70392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f70393d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f70394f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f70395g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f70396h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f70397i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NonNull
    public final ProgressBar f70398j;

    public b0(@NonNull ConstraintLayout constraintLayout, @NonNull LinearLayoutCompat linearLayoutCompat, @NonNull View view, @NonNull LinearLayoutCompat linearLayoutCompat2, @NonNull LinearLayoutCompat linearLayoutCompat3, @NonNull LinearLayoutCompat linearLayoutCompat4, @NonNull LinearLayoutCompat linearLayoutCompat5, @NonNull ConstraintLayout constraintLayout2, @NonNull ProgressBar progressBar) {
        this.f70390a = constraintLayout;
        this.f70391b = linearLayoutCompat;
        this.f70392c = view;
        this.f70393d = linearLayoutCompat2;
        this.f70394f = linearLayoutCompat3;
        this.f70395g = linearLayoutCompat4;
        this.f70396h = linearLayoutCompat5;
        this.f70397i = constraintLayout2;
        this.f70398j = progressBar;
    }

    @NonNull
    public static b0 a(@NonNull View view) {
        View viewA;
        int i11 = R$id.f51974l1;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) n6.b.a(view, i11);
        if (linearLayoutCompat != null && (viewA = n6.b.a(view, (i11 = R$id.f51975l2))) != null) {
            i11 = R$id.f51976l3;
            LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) n6.b.a(view, i11);
            if (linearLayoutCompat2 != null) {
                i11 = R$id.f51977l4;
                LinearLayoutCompat linearLayoutCompat3 = (LinearLayoutCompat) n6.b.a(view, i11);
                if (linearLayoutCompat3 != null) {
                    i11 = R$id.f51978l5;
                    LinearLayoutCompat linearLayoutCompat4 = (LinearLayoutCompat) n6.b.a(view, i11);
                    if (linearLayoutCompat4 != null) {
                        i11 = R$id.f51979l6;
                        LinearLayoutCompat linearLayoutCompat5 = (LinearLayoutCompat) n6.b.a(view, i11);
                        if (linearLayoutCompat5 != null) {
                            ConstraintLayout constraintLayout = (ConstraintLayout) view;
                            i11 = R$id.loading_pb;
                            ProgressBar progressBar = (ProgressBar) n6.b.a(view, i11);
                            if (progressBar != null) {
                                return new b0(constraintLayout, linearLayoutCompat, viewA, linearLayoutCompat2, linearLayoutCompat3, linearLayoutCompat4, linearLayoutCompat5, constraintLayout, progressBar);
                            }
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
    public ConstraintLayout getRoot() {
        return this.f70390a;
    }
}
