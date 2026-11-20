package nt;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.home.R$id;
import com.transsion.home.view.OpRankingView;
import java.util.SortedSet;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class b extends RecyclerView.r {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f72151j = new a(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f72152k = 8;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static String f72153l = "ExposureHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f72154a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final nt.a f72155b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f72156c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f72157d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f72158f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f72159g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final SparseArray<Long> f72160h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public SortedSet<Integer> f72161i;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @JvmOverloads
    public b(float f11, nt.a callback, boolean z11) {
        Intrinsics.g(callback, "callback");
        this.f72154a = f11;
        this.f72155b = callback;
        this.f72156c = z11;
        this.f72160h = new SparseArray<>();
    }

    public /* synthetic */ b(float f11, nt.a aVar, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, aVar, (i11 & 4) != 0 ? false : z11);
    }

    private final boolean d(View view) {
        if (view == null) {
            return false;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return false;
        }
        if (f(view)) {
            return true;
        }
        int iWidth = rect.width();
        int iHeight = rect.height();
        int i11 = this.f72157d;
        if (i11 != 1) {
            if (i11 != 2) {
                double d11 = (((double) iWidth) * 1.0d) / ((double) width);
                float f11 = this.f72154a;
                if (d11 < f11 || (((double) iHeight) * 1.0d) / ((double) height) < f11) {
                    return false;
                }
            } else if ((((double) iHeight) * 1.0d) / ((double) height) < this.f72154a) {
                return false;
            }
        } else if ((((double) iWidth) * 1.0d) / ((double) width) < this.f72154a) {
            return false;
        }
        return true;
    }

    private final void g(int i11, int i12, int i13) {
        if (i12 < 0 || i13 >= i11 || i12 > i13 || i12 > i13) {
            return;
        }
        while (true) {
            if (this.f72160h.get(i12) == null) {
                uo.b.a.f(uo.b.f78622a, f72153l, "offer position  " + i12, false, 4, null);
                this.f72160h.put(i12, Long.valueOf(System.currentTimeMillis()));
            }
            if (i12 == i13) {
                return;
            } else {
                i12++;
            }
        }
    }

    private final void j(int i11) {
        if (this.f72160h.get(i11) == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Long l11 = this.f72160h.get(i11);
        long jLongValue = l11 != null ? l11.longValue() : jCurrentTimeMillis;
        this.f72160h.remove(i11);
        long j11 = jCurrentTimeMillis - jLongValue;
        uo.b.a.f(uo.b.f78622a, f72153l, "out position " + i11 + " duration " + j11, false, 4, null);
        if (j11 <= 1000) {
            return;
        }
        this.f72155b.a(i11, j11, null);
    }

    private final void k(int i11, int i12, int i13) {
        if (i12 < 0 || i13 >= i11 || i12 > i13 || i12 > i13) {
            return;
        }
        while (true) {
            j(i13);
            if (i13 == i12) {
                return;
            } else {
                i13--;
            }
        }
    }

    public final void e() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        SparseArray<Long> sparseArray = this.f72160h;
        int size = sparseArray.size();
        for (int i11 = 0; i11 < size; i11++) {
            int iKeyAt = sparseArray.keyAt(i11);
            Long lValueAt = sparseArray.valueAt(i11);
            long jLongValue = jCurrentTimeMillis - (lValueAt != null ? lValueAt.longValue() : jCurrentTimeMillis);
            uo.b.a.f(uo.b.f78622a, f72153l, "clearCache out position " + iKeyAt + " duration " + jLongValue, false, 4, null);
            if (jLongValue <= 1000) {
                return;
            }
            this.f72155b.a(iKeyAt, jLongValue, null);
        }
        this.f72160h.clear();
    }

    public final boolean f(View view) {
        OpRankingView opRankingView;
        if (view == null || (opRankingView = (OpRankingView) view.findViewById(R$id.ranking_view)) == null) {
            opRankingView = null;
        } else {
            RecyclerView.m layoutManager = ((RecyclerView) opRankingView.findViewById(R$id.recycler_view)).getLayoutManager();
            Intrinsics.e(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            this.f72161i = opRankingView.calcExposureLines((GridLayoutManager) layoutManager);
        }
        return opRankingView != null;
    }

    public final void h(LinearLayoutManager manager, int i11, boolean z11) {
        Intrinsics.g(manager, "manager");
        if (z11) {
            g(manager.getItemCount(), i11, i11);
        }
    }

    public final void i(LinearLayoutManager manager, boolean z11) {
        Intrinsics.g(manager, "manager");
        int iFindFirstVisibleItemPosition = manager.findFirstVisibleItemPosition();
        int iFindLastVisibleItemPosition = manager.findLastVisibleItemPosition();
        if (!d(manager.findViewByPosition(iFindFirstVisibleItemPosition))) {
            iFindFirstVisibleItemPosition++;
        }
        if (!d(manager.findViewByPosition(iFindLastVisibleItemPosition))) {
            iFindLastVisibleItemPosition--;
        }
        if (this.f72158f == 0 && this.f72159g == 0) {
            g(manager.getItemCount(), iFindFirstVisibleItemPosition, iFindLastVisibleItemPosition);
            this.f72158f = iFindFirstVisibleItemPosition;
            this.f72159g = iFindLastVisibleItemPosition;
            return;
        }
        if (z11) {
            k(manager.getItemCount(), this.f72158f, iFindFirstVisibleItemPosition - 1);
            g(manager.getItemCount(), this.f72159g + 1, iFindLastVisibleItemPosition);
        } else {
            k(manager.getItemCount(), iFindLastVisibleItemPosition + 1, this.f72159g);
            g(manager.getItemCount(), iFindFirstVisibleItemPosition, this.f72158f - 1);
        }
        this.f72158f = iFindFirstVisibleItemPosition;
        this.f72159g = iFindLastVisibleItemPosition;
    }

    public final void l(int i11) {
        this.f72157d = i11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
        Intrinsics.g(recyclerView, "recyclerView");
        uo.b.a.f(uo.b.f78622a, f72153l, "newState " + i11, false, 4, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
        Intrinsics.g(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i11, i12);
        RecyclerView.m layoutManager = recyclerView.getLayoutManager();
        Intrinsics.e(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        i((LinearLayoutManager) layoutManager, i12 >= 0);
    }
}
