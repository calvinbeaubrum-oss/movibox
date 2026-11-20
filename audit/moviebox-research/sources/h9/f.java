package h9;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.loadmore.LoadMoreStatus;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BaseQuickAdapter<?, ?> f66393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f9.f f66394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f66395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LoadMoreStatus f66396d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f66397e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g9.a f66398f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f66399g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f66400h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f66401i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f66402j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f66403k;

    public f(BaseQuickAdapter<?, ?> baseQuickAdapter) {
        Intrinsics.g(baseQuickAdapter, "baseQuickAdapter");
        this.f66393a = baseQuickAdapter;
        this.f66395c = true;
        this.f66396d = LoadMoreStatus.Complete;
        this.f66398f = k.a();
        this.f66400h = true;
        this.f66401i = true;
        this.f66402j = 1;
    }

    public static final void F(f this$0, View view) {
        Intrinsics.g(this$0, "this$0");
        LoadMoreStatus loadMoreStatus = this$0.f66396d;
        if (loadMoreStatus == LoadMoreStatus.Fail) {
            this$0.v();
            return;
        }
        if (loadMoreStatus == LoadMoreStatus.Complete) {
            this$0.v();
        } else if (this$0.f66399g && loadMoreStatus == LoadMoreStatus.End) {
            this$0.v();
        }
    }

    public static final void g(f this$0, RecyclerView.m manager) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(manager, "$manager");
        if (this$0.p((LinearLayoutManager) manager)) {
            this$0.f66395c = true;
        }
    }

    public static final void h(RecyclerView.m manager, f this$0) {
        Intrinsics.g(manager, "$manager");
        Intrinsics.g(this$0, "this$0");
        StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) manager;
        int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
        staggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(iArr);
        if (this$0.l(iArr) + 1 != this$0.f66393a.getItemCount()) {
            this$0.f66395c = true;
        }
    }

    public static final void o(f this$0) {
        Intrinsics.g(this$0, "this$0");
        f9.f fVar = this$0.f66394b;
        if (fVar != null) {
            fVar.a();
        }
    }

    public static /* synthetic */ void t(f fVar, boolean z11, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadMoreEnd");
        }
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        fVar.s(z11);
    }

    public final void A(boolean z11) {
        this.f66401i = z11;
    }

    public final void B(g9.a aVar) {
        Intrinsics.g(aVar, "<set-?>");
        this.f66398f = aVar;
    }

    public void C(f9.f fVar) {
        this.f66394b = fVar;
        y(true);
    }

    public final void D(int i11) {
        if (i11 > 1) {
            this.f66402j = i11;
        }
    }

    public final void E(BaseViewHolder viewHolder) {
        Intrinsics.g(viewHolder, "viewHolder");
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: h9.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.F(this.f66387a, view);
            }
        });
    }

    public final void e(int i11) {
        LoadMoreStatus loadMoreStatus;
        if (this.f66400h && m() && i11 >= this.f66393a.getItemCount() - this.f66402j && (loadMoreStatus = this.f66396d) == LoadMoreStatus.Complete && loadMoreStatus != LoadMoreStatus.Loading && this.f66395c) {
            n();
        }
    }

    public final void f() {
        final RecyclerView.m layoutManager;
        if (this.f66401i) {
            return;
        }
        this.f66395c = false;
        RecyclerView recyclerViewX = this.f66393a.X();
        if (recyclerViewX == null || (layoutManager = recyclerViewX.getLayoutManager()) == null) {
            return;
        }
        if (layoutManager instanceof LinearLayoutManager) {
            recyclerViewX.postDelayed(new Runnable() { // from class: h9.c
                @Override // java.lang.Runnable
                public final void run() {
                    f.g(this.f66388a, layoutManager);
                }
            }, 50L);
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            recyclerViewX.postDelayed(new Runnable() { // from class: h9.d
                @Override // java.lang.Runnable
                public final void run() {
                    f.h(layoutManager, this);
                }
            }, 50L);
        }
    }

    public final LoadMoreStatus i() {
        return this.f66396d;
    }

    public final g9.a j() {
        return this.f66398f;
    }

    public final int k() {
        if (this.f66393a.Z()) {
            return -1;
        }
        BaseQuickAdapter<?, ?> baseQuickAdapter = this.f66393a;
        return baseQuickAdapter.K() + baseQuickAdapter.D().size() + baseQuickAdapter.G();
    }

    public final int l(int[] iArr) {
        int i11 = -1;
        if (iArr != null && iArr.length != 0) {
            for (int i12 : iArr) {
                if (i12 > i11) {
                    i11 = i12;
                }
            }
        }
        return i11;
    }

    public final boolean m() {
        if (this.f66394b == null || !this.f66403k) {
            return false;
        }
        if (this.f66396d == LoadMoreStatus.End && this.f66397e) {
            return false;
        }
        return !this.f66393a.D().isEmpty();
    }

    public final void n() {
        this.f66396d = LoadMoreStatus.Loading;
        RecyclerView recyclerViewX = this.f66393a.X();
        if (recyclerViewX != null) {
            recyclerViewX.post(new Runnable() { // from class: h9.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.o(this.f66392a);
                }
            });
            return;
        }
        f9.f fVar = this.f66394b;
        if (fVar != null) {
            fVar.a();
        }
    }

    public final boolean p(LinearLayoutManager linearLayoutManager) {
        return (linearLayoutManager.findLastCompletelyVisibleItemPosition() + 1 == this.f66393a.getItemCount() && linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0) ? false : true;
    }

    public final boolean q() {
        return this.f66396d == LoadMoreStatus.Loading;
    }

    public final void r() {
        if (m()) {
            this.f66396d = LoadMoreStatus.Complete;
            this.f66393a.notifyItemChanged(k());
            f();
        }
    }

    @JvmOverloads
    public final void s(boolean z11) {
        if (m()) {
            this.f66397e = z11;
            this.f66396d = LoadMoreStatus.End;
            if (z11) {
                this.f66393a.notifyItemRemoved(k());
            } else {
                this.f66393a.notifyItemChanged(k());
            }
        }
    }

    public final void u() {
        if (m()) {
            this.f66396d = LoadMoreStatus.Fail;
            this.f66393a.notifyItemChanged(k());
        }
    }

    public final void v() {
        LoadMoreStatus loadMoreStatus = this.f66396d;
        LoadMoreStatus loadMoreStatus2 = LoadMoreStatus.Loading;
        if (loadMoreStatus == loadMoreStatus2) {
            return;
        }
        this.f66396d = loadMoreStatus2;
        this.f66393a.notifyItemChanged(k());
        n();
    }

    public final void w() {
        if (this.f66394b != null) {
            y(true);
            this.f66396d = LoadMoreStatus.Complete;
        }
    }

    public final void x(boolean z11) {
        this.f66400h = z11;
    }

    public final void y(boolean z11) {
        boolean zM = m();
        this.f66403k = z11;
        boolean zM2 = m();
        if (zM) {
            if (zM2) {
                return;
            }
            this.f66393a.notifyItemRemoved(k());
        } else if (zM2) {
            this.f66396d = LoadMoreStatus.Complete;
            this.f66393a.notifyItemInserted(k());
        }
    }

    public final void z(boolean z11) {
        this.f66399g = z11;
    }
}
