package OooO0o0;

import OooO0o0.oo000o;
import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniapp.base.BaseAdapter;
import id.b;
import id.e;
import id.h;
import j.a0;
import j.z;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class oo000o extends OooO0OO.OooO00o<oo000o> implements BaseAdapter.d {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public a0 f163t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f164u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final o00Oo0 f165v;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO00o extends Lambda implements Function0<RecyclerView> {
        public OooO00o() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public RecyclerView invoke() {
            return (RecyclerView) oo000o.this.findViewById(R$id.rv_image_album_list);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oo000o(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        this.f164u = LazyKt__LazyJVMKt.b(new OooO00o());
        j(R$layout.layout_image_album_dialog);
        b(b.f67188f8.a());
        o00Oo0 o00oo0 = new o00Oo0(context);
        this.f165v = o00oo0;
        o00oo0.q(this);
        RecyclerView recyclerViewW = w();
        if (recyclerViewW == null) {
            return;
        }
        recyclerViewW.setAdapter(o00oo0);
    }

    public static final void v(oo000o this$0, int i11) {
        Intrinsics.g(this$0, "this$0");
        a0 a0Var = this$0.f163t;
        if (a0Var != null) {
            a0Var.a(this$0.f28b, i11, this$0.f165v.getItem(i11));
        }
        this$0.l();
    }

    @Override // OooO0o0.OooO0OO.OooO00o
    public OooO0OO i(Context context, int i11) {
        Intrinsics.g(context, "context");
        a aVar = new a(context, i11);
        aVar.f87k.P0(h.a.c(this).getDisplayMetrics().heightPixels / 2);
        return aVar;
    }

    @Override // com.cloud.tmc.miniapp.base.BaseAdapter.d
    public void onItemClick(RecyclerView recyclerView, View view, final int i11) {
        for (z zVar : this.f165v.v()) {
            if (zVar.f67799e) {
                zVar.f67799e = false;
                break;
            }
        }
        this.f165v.getItem(i11).f67799e = true;
        this.f165v.notifyDataSetChanged();
        Runnable runnable = new Runnable() { // from class: j.g0
            @Override // java.lang.Runnable
            public final void run() {
                oo000o.v(this.f67776a, i11);
            }
        };
        Intrinsics.g(runnable, "runnable");
        if (!p()) {
            e(new OooO0OO.l(runnable, 300L));
            return;
        }
        OooO0OO oooO0OO = this.f28b;
        if (oooO0OO != null) {
            e.b.e(oooO0OO, runnable, 300L);
        }
    }

    public final RecyclerView w() {
        return (RecyclerView) this.f164u.getValue();
    }
}
