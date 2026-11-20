package zr;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.baselib.exposure.ExposureType;
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
    public static final a f82141j = new a(null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static String f82142k = "ExposureHelper";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f82143a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zr.a f82144b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f82145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f82146d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ExposureType f82147f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f82148g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f82149h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final SparseArray<Long> f82150i;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a() {
            return b.f82142k;
        }
    }

    @JvmOverloads
    public b(float f11, zr.a callback, boolean z11) {
        Intrinsics.g(callback, "callback");
        this.f82143a = f11;
        this.f82144b = callback;
        this.f82145c = z11;
        this.f82147f = ExposureType.VERTICAL_FEED;
        this.f82150i = new SparseArray<>();
    }

    public /* synthetic */ b(float f11, zr.a aVar, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, aVar, (i11 & 4) != 0 ? false : z11);
    }

    public static /* synthetic */ void j(b bVar, LinearLayoutManager linearLayoutManager, int i11, boolean z11, boolean z12, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            z12 = false;
        }
        bVar.i(linearLayoutManager, i11, z11, z12);
    }

    public final boolean e(View view) {
        if (view == null) {
            return false;
        }
        int width = view.getWidth();
        int height = view.getHeight();
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return false;
        }
        int iWidth = rect.width();
        int iHeight = rect.height();
        int i11 = this.f82146d;
        if (i11 != 1) {
            if (i11 != 2) {
                double d11 = (((double) iWidth) * 1.0d) / ((double) width);
                float f11 = this.f82143a;
                if (d11 < f11 || (((double) iHeight) * 1.0d) / ((double) height) < f11) {
                    return false;
                }
            } else if ((((double) iHeight) * 1.0d) / ((double) height) < this.f82143a) {
                return false;
            }
        } else if ((((double) iWidth) * 1.0d) / ((double) width) < this.f82143a) {
            return false;
        }
        return true;
    }

    public final void f() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        SparseArray<Long> sparseArray = this.f82150i;
        int size = sparseArray.size();
        for (int i11 = 0; i11 < size; i11++) {
            int iKeyAt = sparseArray.keyAt(i11);
            Long lValueAt = sparseArray.valueAt(i11);
            long jLongValue = jCurrentTimeMillis - (lValueAt != null ? lValueAt.longValue() : jCurrentTimeMillis);
            uo.b.a.f(uo.b.f78622a, f82142k, "clearCache out position " + iKeyAt + " duration " + jLongValue, false, 4, null);
            this.f82144b.a(iKeyAt, jLongValue, null);
        }
        this.f82150i.clear();
    }

    public final void g() {
        f();
        this.f82148g = 0;
        this.f82149h = 0;
    }

    public final void h(int i11, int i12, int i13) {
        if (i12 < 0 || i13 >= i11 || i12 > i13 || i12 > i13) {
            return;
        }
        while (this.f82150i.get(i12) == null) {
            uo.b.a.f(uo.b.f78622a, f82142k, "offer position  " + i12, false, 4, null);
            this.f82150i.put(i12, Long.valueOf(System.currentTimeMillis()));
            if (i12 == i13) {
                return;
            } else {
                i12++;
            }
        }
    }

    public final void i(LinearLayoutManager manager, int i11, boolean z11, boolean z12) {
        Intrinsics.g(manager, "manager");
        if (z11) {
            View viewFindViewByPosition = manager.findViewByPosition(i11);
            if (z12) {
                h(manager.getItemCount(), i11, i11);
                return;
            }
            boolean zE = e(viewFindViewByPosition);
            uo.b.a.f(uo.b.f78622a, f82142k, "firstView " + viewFindViewByPosition + " export " + zE + " count " + manager.getItemCount(), false, 4, null);
            if (zE) {
                h(manager.getItemCount(), i11, i11);
            }
        }
    }

    public final void k(LinearLayoutManager manager, boolean z11) {
        Intrinsics.g(manager, "manager");
        int iFindFirstVisibleItemPosition = manager.findFirstVisibleItemPosition();
        int iFindLastVisibleItemPosition = manager.findLastVisibleItemPosition();
        if (!e(manager.findViewByPosition(iFindFirstVisibleItemPosition)) && this.f82147f != ExposureType.NEST_HORIZONTAL) {
            iFindFirstVisibleItemPosition++;
        }
        if (!e(manager.findViewByPosition(iFindLastVisibleItemPosition)) && this.f82147f != ExposureType.NEST_HORIZONTAL) {
            iFindLastVisibleItemPosition--;
        }
        if (this.f82148g == 0 && this.f82149h == 0) {
            h(manager.getItemCount(), iFindFirstVisibleItemPosition, iFindLastVisibleItemPosition);
            this.f82148g = iFindFirstVisibleItemPosition;
            this.f82149h = iFindLastVisibleItemPosition;
            return;
        }
        if (z11) {
            m(manager.getItemCount(), this.f82148g, iFindFirstVisibleItemPosition - 1);
            h(manager.getItemCount(), this.f82149h + 1, iFindLastVisibleItemPosition);
        } else {
            m(manager.getItemCount(), iFindLastVisibleItemPosition + 1, this.f82149h);
            h(manager.getItemCount(), iFindFirstVisibleItemPosition, this.f82148g - 1);
        }
        this.f82148g = iFindFirstVisibleItemPosition;
        this.f82149h = iFindLastVisibleItemPosition;
    }

    public final void l(int i11) {
        if (this.f82150i.get(i11) == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        Long l11 = this.f82150i.get(i11);
        long jLongValue = l11 != null ? l11.longValue() : jCurrentTimeMillis;
        this.f82150i.remove(i11);
        long j11 = jCurrentTimeMillis - jLongValue;
        uo.b.a.f(uo.b.f78622a, f82142k, "out position " + i11 + " duration " + j11, false, 4, null);
        if (j11 <= 1000) {
            return;
        }
        this.f82144b.a(i11, j11, null);
    }

    public final void m(int i11, int i12, int i13) {
        if (i12 < 0 || i13 >= i11 || i12 > i13 || i12 > i13) {
            return;
        }
        while (true) {
            l(i13);
            if (i13 == i12) {
                return;
            } else {
                i13--;
            }
        }
    }

    public final void n(int i11) {
        this.f82146d = i11;
    }

    public final void o(ExposureType exposureType) {
        Intrinsics.g(exposureType, "exposureType");
        this.f82147f = exposureType;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
        Intrinsics.g(recyclerView, "recyclerView");
        uo.b.a.f(uo.b.f78622a, f82142k, "newState " + i11, false, 4, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
        Intrinsics.g(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i11, i12);
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            RecyclerView.m layoutManager = recyclerView.getLayoutManager();
            Intrinsics.e(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            boolean z11 = false;
            if (linearLayoutManager.getOrientation() != 1 ? i11 > 0 : i12 > 0) {
                z11 = true;
            }
            k(linearLayoutManager, z11);
        }
    }
}
