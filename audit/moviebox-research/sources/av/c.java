package av;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.moviedetailapi.bean.PostSubjectItem;
import com.transsion.ninegridview.R$id;
import com.transsion.ninegridview.video.NineGridVideoView;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
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
public final class c extends RecyclerView.r {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final a f13837j = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BaseQuickAdapter<PostSubjectItem, BaseViewHolder> f13838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public bv.a f13839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public d f13840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13841d = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f13842f = -1;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f13843g = -1;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f13844h = -1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f13845i;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private final void i(int i11) {
        List<PostSubjectItem> listD;
        List<PostSubjectItem> listD2;
        BaseQuickAdapter<PostSubjectItem, BaseViewHolder> baseQuickAdapter = this.f13838a;
        int size = (baseQuickAdapter == null || (listD2 = baseQuickAdapter.D()) == null) ? 0 : listD2.size();
        for (int i12 = i11; i12 < size; i12++) {
            if (i12 > i11) {
                BaseQuickAdapter<PostSubjectItem, BaseViewHolder> baseQuickAdapter2 = this.f13838a;
                PostSubjectItem postSubjectItem = (baseQuickAdapter2 == null || (listD = baseQuickAdapter2.D()) == null) ? null : listD.get(i12);
                if (bv.b.a(postSubjectItem != null ? postSubjectItem.getMedia() : null)) {
                    bv.a aVar = this.f13839b;
                    if (aVar != null) {
                        aVar.v(postSubjectItem != null ? postSubjectItem.getMedia() : null);
                        return;
                    }
                    return;
                }
            }
        }
    }

    public final void d(RecyclerView recyclerView) {
        List<PostSubjectItem> listD;
        int position;
        d dVar;
        RecyclerView.m layoutManager = recyclerView.getLayoutManager();
        if ((layoutManager instanceof LinearLayoutManager) && g()) {
            if (this.f13839b == null && (dVar = this.f13840c) != null) {
                dVar.a();
            }
            bv.a aVar = this.f13839b;
            int iB = aVar != null ? aVar.b() : -1;
            bv.a aVar2 = this.f13839b;
            int iF = aVar2 != null ? aVar2.f() : -1;
            bv.a aVar3 = this.f13839b;
            if (aVar3 != null && aVar3.n() && h((LinearLayoutManager) layoutManager, iB, iF)) {
                return;
            }
            bv.a aVar4 = this.f13839b;
            if (aVar4 != null) {
                aVar4.r();
            }
            BaseQuickAdapter<PostSubjectItem, BaseViewHolder> baseQuickAdapter = this.f13838a;
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int iF2 = f(baseQuickAdapter != null ? baseQuickAdapter.D() : null, linearLayoutManager);
            if (iF2 < 0) {
                return;
            }
            uo.b.a.f(uo.b.f78622a, "ItemChangeListener", "curPos=" + iB + " next=" + iF2 + ", dy=" + this.f13845i + ", firstVisible=" + this.f13843g + " lastVisible=" + this.f13844h, false, 4, null);
            BaseQuickAdapter<PostSubjectItem, BaseViewHolder> baseQuickAdapter2 = this.f13838a;
            if (baseQuickAdapter2 == null || (listD = baseQuickAdapter2.D()) == null) {
                return;
            }
            int childCount = linearLayoutManager.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = linearLayoutManager.getChildAt(i11);
                if (childAt != null && (position = linearLayoutManager.getPosition(childAt)) == iF2 && position < listD.size() && iB != iF2) {
                    PostSubjectItem postSubjectItem = listD.get(iF2);
                    bv.a aVar5 = this.f13839b;
                    if (aVar5 != null) {
                        aVar5.s(postSubjectItem, childAt, iF2);
                    }
                    bv.a aVar6 = this.f13839b;
                    if (aVar6 != null && aVar6.e(postSubjectItem.getMedia()) == 1) {
                        i(iF2);
                    }
                }
            }
        }
    }

    public final void e() {
        this.f13838a = null;
        this.f13839b = null;
        this.f13842f = -1;
        this.f13841d = -1;
        this.f13843g = -1;
        this.f13844h = -1;
        this.f13845i = 0;
        this.f13840c = null;
    }

    public final int f(List<PostSubjectItem> list, LinearLayoutManager linearLayoutManager) {
        NineGridVideoView nineGridVideoView;
        int position;
        int i11 = -1;
        if (list == null) {
            return -1;
        }
        int childCount = linearLayoutManager.getChildCount();
        float f11 = 0.0f;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = linearLayoutManager.getChildAt(i12);
            if (childAt != null && (nineGridVideoView = (NineGridVideoView) childAt.findViewById(R$id.nine_grid)) != null && (position = linearLayoutManager.getPosition(childAt)) >= 0 && position < list.size()) {
                PostSubjectItem postSubjectItem = list.get(position);
                if (bv.b.a(postSubjectItem.getMedia())) {
                    bv.a aVar = this.f13839b;
                    float fH = aVar != null ? aVar.h(nineGridVideoView, postSubjectItem.getMedia()) : 0.0f;
                    if (f11 < fH) {
                        if (fH > 0.5f) {
                            i11 = position;
                        }
                        f11 = fH;
                    }
                }
            }
        }
        return i11;
    }

    public final boolean g() {
        List<PostSubjectItem> listD;
        BaseQuickAdapter<PostSubjectItem, BaseViewHolder> baseQuickAdapter = this.f13838a;
        if (baseQuickAdapter == null || (listD = baseQuickAdapter.D()) == null) {
            return false;
        }
        Iterator<T> it = listD.iterator();
        while (it.hasNext()) {
            if (bv.b.a(((PostSubjectItem) it.next()).getMedia())) {
                return true;
            }
        }
        return false;
    }

    public final boolean h(LinearLayoutManager linearLayoutManager, int i11, int i12) {
        int childCount = linearLayoutManager.getChildCount();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = linearLayoutManager.getChildAt(i13);
            if (childAt != null) {
                NineGridVideoView nineGridVideoView = (NineGridVideoView) childAt.findViewById(R$id.nine_grid);
                int position = linearLayoutManager.getPosition(childAt);
                if (position == i11) {
                    Boolean boolValueOf = nineGridVideoView != null ? Boolean.valueOf(nineGridVideoView.currentGifVisible(i12)) : null;
                    if (Intrinsics.b(boolValueOf, Boolean.TRUE)) {
                        uo.b.a.f(uo.b.f78622a, "ItemChangeListener", "childPos=" + position + " currentGifVisible=" + boolValueOf, false, 4, null);
                        return true;
                    }
                    boolean zHasGifVisible = nineGridVideoView != null ? nineGridVideoView.hasGifVisible() : false;
                    uo.b.a.f(uo.b.f78622a, "ItemChangeListener", "childPos=" + position + " gifVisible=" + zHasGifVisible, false, 4, null);
                    bv.a aVar = this.f13839b;
                    if (aVar != null) {
                        aVar.q();
                    }
                    return zHasGifVisible;
                }
            }
        }
        return false;
    }

    public final void j(BaseQuickAdapter<PostSubjectItem, BaseViewHolder> baseQuickAdapter) {
        this.f13838a = baseQuickAdapter;
    }

    public final void k(bv.a aVar) {
        this.f13839b = aVar;
    }

    public final void l(d dVar) {
        this.f13840c = dVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onScrollStateChanged(RecyclerView recyclerView, int i11) {
        Intrinsics.g(recyclerView, "recyclerView");
        if (recyclerView.getScrollState() == 0) {
            d(recyclerView);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
        Intrinsics.g(recyclerView, "recyclerView");
        RecyclerView.m layoutManager = recyclerView.getLayoutManager();
        if (!(layoutManager instanceof LinearLayoutManager)) {
            throw new RuntimeException("Unsupported layoutManager.");
        }
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        this.f13841d = linearLayoutManager.findLastCompletelyVisibleItemPosition();
        this.f13842f = linearLayoutManager.findFirstCompletelyVisibleItemPosition();
        this.f13843g = linearLayoutManager.findFirstVisibleItemPosition();
        this.f13844h = linearLayoutManager.findLastVisibleItemPosition();
        this.f13845i = i12;
        if (recyclerView.getScrollState() == 0) {
            d(recyclerView);
        }
    }
}
