package OooO0o0;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniapp.dialog.BottomDialog$MenuItem;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import xb.e;
import xb.i;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class OooOOOO extends com.cloud.tmc.miniapp.ui.adapter.a<BottomDialog$MenuItem> {

    /* JADX INFO: compiled from: source.java */
    public final class OooO00o extends com.cloud.tmc.miniapp.ui.adapter.a<BottomDialog$MenuItem>.AbstractC0347a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Lazy f71d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Lazy f72f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Lazy f73g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Lazy f74h;

        /* JADX INFO: renamed from: OooO0o0.OooOOOO$OooO00o$OooO00o, reason: collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        public static final class C0007OooO00o extends Lambda implements Function0<AppCompatImageView> {
            public C0007OooO00o() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public AppCompatImageView invoke() {
                return (AppCompatImageView) OooO00o.this.findViewById(R$id.iv_icon);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public static final class OooO0O0 extends Lambda implements Function0<AppCompatImageView> {
            public OooO0O0() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public AppCompatImageView invoke() {
                return (AppCompatImageView) OooO00o.this.findViewById(R$id.iv_msg_badge);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public static final class OooO0OO extends Lambda implements Function0<LinearLayoutCompat> {
            public OooO0OO() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public LinearLayoutCompat invoke() {
                return (LinearLayoutCompat) OooO00o.this.findViewById(R$id.ll_bottom_item);
            }
        }

        /* JADX INFO: compiled from: source.java */
        public static final class OooO0o extends Lambda implements Function0<TextView> {
            public OooO0o() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public TextView invoke() {
                return (TextView) OooO00o.this.findViewById(R$id.tv_name);
            }
        }

        public OooO00o() {
            super(R$layout.mini_item_bottom_dialog);
            this.f71d = LazyKt__LazyJVMKt.b(new C0007OooO00o());
            this.f72f = LazyKt__LazyJVMKt.b(new OooO0o());
            this.f73g = LazyKt__LazyJVMKt.b(new OooO0O0());
            this.f74h = LazyKt__LazyJVMKt.b(new OooO0OO());
        }

        @Override // com.cloud.tmc.miniapp.base.BaseAdapter.a
        public void g(int i11) {
            BottomDialog$MenuItem item = OooOOOO.this.getItem(i11);
            if (Intrinsics.b(item.getId(), "-1")) {
                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) this.f74h.getValue();
                if (linearLayoutCompat == null) {
                    return;
                }
                linearLayoutCompat.setVisibility(4);
                return;
            }
            LinearLayoutCompat linearLayoutCompat2 = (LinearLayoutCompat) this.f74h.getValue();
            if (linearLayoutCompat2 != null) {
                linearLayoutCompat2.setVisibility(0);
            }
            AppCompatImageView appCompatImageView = (AppCompatImageView) this.f71d.getValue();
            if (appCompatImageView != null) {
                appCompatImageView.setImageResource(item.getIcon());
            }
            TextView textView = (TextView) this.f72f.getValue();
            if (textView != null) {
                textView.setText(e.a(item.getName(), ""));
            }
            if (item.getDotBadge()) {
                AppCompatImageView appCompatImageView2 = (AppCompatImageView) this.f73g.getValue();
                if (appCompatImageView2 != null) {
                    i.e(appCompatImageView2);
                    return;
                }
                return;
            }
            AppCompatImageView appCompatImageView3 = (AppCompatImageView) this.f73g.getValue();
            if (appCompatImageView3 != null) {
                i.d(appCompatImageView3);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OooOOOO(Context context) {
        super(context);
        Intrinsics.g(context, "context");
    }

    @Override // com.cloud.tmc.miniapp.base.BaseAdapter
    public RecyclerView.m k(Context context) {
        Intrinsics.g(context, "context");
        return new GridLayoutManager(context, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.a0 onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        return new OooO00o();
    }
}
