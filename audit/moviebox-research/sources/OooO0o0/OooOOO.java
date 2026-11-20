package OooO0o0;

import android.content.Context;
import android.util.ArrayMap;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.cloud.tmc.integration.ActivityHelper;
import com.cloud.tmc.kernel.log.TmcLogger;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PerformanceAnalyseProxy;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;
import com.cloud.tmc.kernel.proxy.storage.KVStorageProxy;
import com.cloud.tmc.miniapp.R$id;
import com.cloud.tmc.miniapp.R$layout;
import com.cloud.tmc.miniapp.base.BaseAdapter;
import com.cloud.tmc.miniapp.dialog.BottomDialog$MenuItem;
import com.cloud.tmc.miniapp.utils.MessageBubbleUtils;
import com.cloud.tmc.miniutils.util.j0;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension
public final class OooOOO extends OooO0OO.OooO00o<OooOOO> {
    public BaseAdapter.d A;
    public final ArrayMap<Integer, BottomDialog$MenuItem> B;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f60t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Lazy f61u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Lazy f62v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Lazy f63w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Lazy f64x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final OooOOOO f65y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public String f66z;

    /* JADX INFO: compiled from: source.java */
    public static final class OooO extends Lambda implements Function0<AppCompatImageView> {
        public OooO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatImageView invoke() {
            return (AppCompatImageView) OooOOO.this.findViewById(R$id.iv_go);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooO0o extends Lambda implements Function0<ActivityHelper> {
        public final /* synthetic */ Context OooO00o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public OooO0o(Context context) {
            super(0);
            this.OooO00o = context;
        }

        @Override // kotlin.jvm.functions.Function0
        public ActivityHelper invoke() {
            Context context = this.OooO00o;
            com.cloud.tmc.miniapp.ui.OooO0OO oooO0OO = context instanceof com.cloud.tmc.miniapp.ui.OooO0OO ? (com.cloud.tmc.miniapp.ui.OooO0OO) context : null;
            if (oooO0OO != null) {
                return oooO0OO.f31719d;
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOO0 extends Lambda implements Function0<AppCompatImageView> {
        public OooOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public AppCompatImageView invoke() {
            return (AppCompatImageView) OooOOO.this.findViewById(R$id.iv_logo);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOO0O extends Lambda implements Function0<RecyclerView> {
        public OooOO0O() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public RecyclerView invoke() {
            return (RecyclerView) OooOOO.this.findViewById(R$id.rv_menu_items);
        }
    }

    /* JADX INFO: renamed from: OooO0o0.OooOOO$OooOOO, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0006OooOOO extends Lambda implements Function0<TextView> {
        public C0006OooOOO() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) OooOOO.this.findViewById(R$id.tv_product_name);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class OooOOO0 extends Lambda implements Function0<TextView> {
        public OooOOO0() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public TextView invoke() {
            return (TextView) OooOOO.this.findViewById(R$id.tv_company_name);
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class a implements BaseAdapter.b {
        public a() {
        }

        @Override // com.cloud.tmc.miniapp.base.BaseAdapter.b
        public void onChildClick(RecyclerView recyclerView, View view, int i11) {
            BaseAdapter.d dVar = OooOOO.this.A;
            if (dVar != null) {
                dVar.onItemClick(recyclerView, view, i11);
            }
        }
    }

    /* JADX INFO: compiled from: source.java */
    public static final class b implements OooO0OO.f {
        public b() {
        }

        @Override // OooO0o0.OooO0OO.f
        public void a(OooO0OO oooO0OO) {
            ((PerformanceAnalyseProxy) tc.a.a(PerformanceAnalyseProxy.class)).record(OooOOO.this.f66z, PointAnalyseType.POINT_MORE_EXIT, "");
        }
    }

    /* JADX INFO: compiled from: source.java */
    @SourceDebugExtension
    public static final class c implements OooO0OO.j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f70b;

        public c(Context context) {
            this.f70b = context;
        }

        @Override // OooO0o0.OooO0OO.j
        public void b(OooO0OO oooO0OO) {
            if (MessageBubbleUtils.f31780a.b()) {
                try {
                    Iterator<BottomDialog$MenuItem> it = OooOOO.this.f65y.v().iterator();
                    int i11 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i11 = -1;
                            break;
                        } else if (Intrinsics.b(it.next().getId(), "message")) {
                            break;
                        } else {
                            i11++;
                        }
                    }
                    Integer numValueOf = Integer.valueOf(i11);
                    if (numValueOf.intValue() < 0) {
                        numValueOf = null;
                    }
                    if (numValueOf != null) {
                        OooOOO oooOOO = OooOOO.this;
                        Context context = this.f70b;
                        int iIntValue = numValueOf.intValue();
                        BottomDialog$MenuItem bottomDialog$MenuItem = oooOOO.f65y.v().get(iIntValue);
                        Intrinsics.g(context, "context");
                        bottomDialog$MenuItem.setDotBadge(((KVStorageProxy) tc.a.a(KVStorageProxy.class)).getBoolean(context, "miniMsgKvId", "miniNewMsgStatus", false));
                        oooOOO.f65y.notifyItemChanged(iIntValue);
                    }
                } catch (Throwable th2) {
                    TmcLogger.h("BottomDialog", th2);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OooOOO(Context context) {
        super(context);
        Intrinsics.g(context, "context");
        this.f60t = LazyKt__LazyJVMKt.b(new OooOO0());
        this.f61u = LazyKt__LazyJVMKt.b(new C0006OooOOO());
        this.f62v = LazyKt__LazyJVMKt.b(new OooOOO0());
        this.f63w = LazyKt__LazyJVMKt.b(new OooO());
        this.f64x = LazyKt__LazyJVMKt.b(new OooOO0O());
        OooOOOO oooOOOO = new OooOOOO(context);
        this.f65y = oooOOOO;
        this.f66z = "";
        LazyKt__LazyJVMKt.b(new OooO0o(context));
        this.B = new ArrayMap<>();
        j(R$layout.mini_layout_bottom_dialog);
        g(true);
        oooOOOO.p(R$id.fl_container, new a());
        RecyclerView recyclerViewW = w();
        if (recyclerViewW != null) {
            recyclerViewW.setAdapter(oooOOOO);
        }
        AppCompatImageView appCompatImageViewV = v();
        if (appCompatImageViewV != null) {
            appCompatImageViewV.setRotationY(j0.a() ? 180.0f : 0.0f);
        }
        c(new b());
        e(new c(context));
    }

    public final AppCompatImageView v() {
        return (AppCompatImageView) this.f63w.getValue();
    }

    public final RecyclerView w() {
        return (RecyclerView) this.f64x.getValue();
    }

    public final TextView x() {
        return (TextView) this.f62v.getValue();
    }
}
