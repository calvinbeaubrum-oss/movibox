package h00;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.transsnet.downloader.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class d0 implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final FrameLayout f65782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final w0 f65783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final ViewStub f65784c;

    public d0(@NonNull FrameLayout frameLayout, @NonNull w0 w0Var, @NonNull ViewStub viewStub) {
        this.f65782a = frameLayout;
        this.f65783b = w0Var;
        this.f65784c = viewStub;
    }

    @NonNull
    public static d0 a(@NonNull View view) {
        int i11 = R$id.included_content;
        View viewA = n6.b.a(view, i11);
        if (viewA != null) {
            w0 w0VarA = w0.a(viewA);
            int i12 = R$id.vs_allow_access;
            ViewStub viewStub = (ViewStub) n6.b.a(view, i12);
            if (viewStub != null) {
                return new d0((FrameLayout) view, w0VarA, viewStub);
            }
            i11 = i12;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public FrameLayout getRoot() {
        return this.f65782a;
    }
}
