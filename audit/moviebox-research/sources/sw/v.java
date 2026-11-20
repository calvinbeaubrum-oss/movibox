package sw;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.LinearLayoutCompat;
import com.google.android.material.tabs.TabLayout;
import com.transsion.room.R$id;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class v implements n6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f76614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final View f76615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    public final LinearLayoutCompat f76616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NonNull
    public final TabLayout f76617d;

    public v(@NonNull LinearLayoutCompat linearLayoutCompat, @NonNull View view, @NonNull LinearLayoutCompat linearLayoutCompat2, @NonNull TabLayout tabLayout) {
        this.f76614a = linearLayoutCompat;
        this.f76615b = view;
        this.f76616c = linearLayoutCompat2;
        this.f76617d = tabLayout;
    }

    @NonNull
    public static v a(@NonNull View view) {
        int i11 = R$id.divider;
        View viewA = n6.b.a(view, i11);
        if (viewA != null) {
            LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) view;
            int i12 = R$id.tab_room;
            TabLayout tabLayout = (TabLayout) n6.b.a(view, i12);
            if (tabLayout != null) {
                return new v(linearLayoutCompat, viewA, linearLayoutCompat, tabLayout);
            }
            i11 = i12;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i11)));
    }

    @Override // n6.a
    @NonNull
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LinearLayoutCompat getRoot() {
        return this.f76614a;
    }
}
