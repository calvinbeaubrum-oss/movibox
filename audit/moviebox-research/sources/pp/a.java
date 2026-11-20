package pp;

import android.graphics.Rect;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class a extends RecyclerView.r {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final C0807a f73966g = new C0807a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f73967a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RecyclerView f73970d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f73968b = 10;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f73969c = 2;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SparseArray<Long> f73971f = new SparseArray<>();

    /* JADX INFO: renamed from: pp.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class C0807a {
        public C0807a() {
        }

        public /* synthetic */ C0807a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public interface b {
        int a();

        void onItemViewVisible(boolean z11, int i11);
    }

    private final String i() {
        return a.class.getSimpleName();
    }

    public final void d() {
        l();
        RecyclerView recyclerView = this.f73970d;
        if (recyclerView != null) {
            recyclerView.removeOnScrollListener(this);
        }
        this.f73967a = null;
        this.f73970d = null;
    }

    public final int[] e(int[] iArr, int[] iArr2) {
        int i11 = iArr[0];
        int i12 = iArr2[0];
        int length = iArr.length;
        for (int i13 = 1; i13 < length; i13++) {
            int i14 = iArr[i13];
            if (i11 > i14) {
                i11 = i14;
            }
        }
        int length2 = iArr2.length;
        for (int i15 = 1; i15 < length2; i15++) {
            int i16 = iArr2[i15];
            if (i12 < i16) {
                i12 = i16;
            }
        }
        return new int[]{i11, i12};
    }

    public final int[] f(GridLayoutManager gridLayoutManager) {
        return new int[]{gridLayoutManager.findFirstVisibleItemPosition(), gridLayoutManager.findLastVisibleItemPosition()};
    }

    public final int[] g(LinearLayoutManager linearLayoutManager) {
        return new int[]{linearLayoutManager.findFirstVisibleItemPosition(), linearLayoutManager.findLastVisibleItemPosition()};
    }

    public final int[] h(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
        int[] iArr2 = new int[staggeredGridLayoutManager.getSpanCount()];
        staggeredGridLayoutManager.findFirstVisibleItemPositions(iArr);
        staggeredGridLayoutManager.findLastVisibleItemPositions(iArr2);
        return e(iArr, iArr2);
    }

    public final void j() {
        Object objM163constructorimpl;
        RecyclerView recyclerView = this.f73970d;
        if (recyclerView == null || recyclerView == null || recyclerView.getVisibility() != 0) {
            return;
        }
        RecyclerView recyclerView2 = this.f73970d;
        if (recyclerView2 == null || recyclerView2.isShown()) {
            RecyclerView recyclerView3 = this.f73970d;
            if (recyclerView3 == null || recyclerView3.getGlobalVisibleRect(new Rect())) {
                try {
                    Result.Companion companion = Result.Companion;
                    int[] iArrH = new int[2];
                    RecyclerView recyclerView4 = this.f73970d;
                    RecyclerView.m layoutManager = recyclerView4 != null ? recyclerView4.getLayoutManager() : null;
                    if (layoutManager instanceof GridLayoutManager) {
                        iArrH = f((GridLayoutManager) layoutManager);
                    } else if (layoutManager instanceof LinearLayoutManager) {
                        iArrH = g((LinearLayoutManager) layoutManager);
                    } else if (layoutManager instanceof StaggeredGridLayoutManager) {
                        iArrH = h((StaggeredGridLayoutManager) layoutManager);
                    }
                    int i11 = iArrH[0];
                    int i12 = iArrH[1];
                    if (i11 <= i12) {
                        while (true) {
                            b bVar = this.f73967a;
                            if (bVar == null || i11 != bVar.a()) {
                                m(layoutManager != null ? layoutManager.findViewByPosition(i11) : null, i11);
                            }
                            if (i11 == i12) {
                                break;
                            } else {
                                i11++;
                            }
                        }
                    }
                    objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                } catch (Throwable th2) {
                    Result.Companion companion2 = Result.Companion;
                    objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
                }
                Throwable thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
                if (thM166exceptionOrNullimpl == null) {
                    return;
                }
                uo.b.a aVar = uo.b.f78622a;
                String strI = i();
                Intrinsics.f(strI, "getClassTag()");
                uo.b.a.j(aVar, strI, "RecyclerViewExposeUtil --> handleCurrentVisibleItems() --> " + Log.getStackTraceString(thM166exceptionOrNullimpl), false, 4, null);
            }
        }
    }

    public final void k() {
        j();
    }

    public final void l() {
        this.f73971f.clear();
    }

    public final void m(View view, int i11) {
        if (view != null && view.getVisibility() == 0 && view.isShown() && view.getGlobalVisibleRect(new Rect())) {
            Rect rect = new Rect();
            boolean globalVisibleRect = view.getGlobalVisibleRect(rect);
            boolean z11 = ((double) rect.height()) * ((double) rect.width()) > ((((double) view.getMeasuredHeight()) * ((double) view.getMeasuredWidth())) * ((double) this.f73968b)) / ((double) 100);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("isItemViewVisibleInLogic = ");
            sb2.append(z11);
            if (!globalVisibleRect || !z11) {
                b bVar = this.f73967a;
                if (bVar != null) {
                    bVar.onItemViewVisible(false, i11);
                }
                if (this.f73969c == 2) {
                    this.f73971f.remove(i11);
                    return;
                }
                return;
            }
            if (this.f73971f.get(i11) != null) {
                return;
            }
            this.f73971f.put(i11, Long.valueOf(System.currentTimeMillis()));
            b bVar2 = this.f73967a;
            if (bVar2 != null) {
                bVar2.onItemViewVisible(true, i11);
            }
        }
    }

    public final void n(RecyclerView recyclerView, b bVar) {
        RecyclerView recyclerView2;
        this.f73967a = bVar;
        this.f73970d = recyclerView;
        if (recyclerView == null || recyclerView == null || recyclerView.getVisibility() != 0 || (recyclerView2 = this.f73970d) == null) {
            return;
        }
        recyclerView2.addOnScrollListener(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
        Intrinsics.g(recyclerView, "recyclerView");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
        Intrinsics.g(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i11, i12);
        j();
    }
}
