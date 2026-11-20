package np;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tn.lib.tranpay.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public final class d implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f72135a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final ConstraintLayout f72136b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final View f72137c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final View f72138d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NonNull
    public final View f72139f;

    public d(@NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout2, @NonNull View view, @NonNull View view2, @NonNull View view3) {
        this.f72135a = constraintLayout;
        this.f72136b = constraintLayout2;
        this.f72137c = view;
        this.f72138d = view2;
        this.f72139f = view3;
    }

    @NonNull
    public static d a(@NonNull View view) {
        View viewA;
        View viewA2;
        ConstraintLayout constraintLayout = (ConstraintLayout) view;
        int i11 = R$id.view1;
        View viewA3 = n6.b.a(view, i11);
        if (viewA3 == null || (viewA = n6.b.a(view, (i11 = R$id.view2))) == null || (viewA2 = n6.b.a(view, (i11 = R$id.view3))) == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
        }
        return new d(constraintLayout, constraintLayout, viewA3, viewA, viewA2);
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public ConstraintLayout getRoot() {
        return this.f72135a;
    }
}
