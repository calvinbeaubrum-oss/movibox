package com.transsion.moviedetail.staff;

import android.graphics.Rect;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.d0;
import com.google.android.material.appbar.AppBarLayout;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function2;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@SourceDebugExtension
public final class m extends RecyclerView.r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f53781a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<Integer, Pair<? extends Object, Long>, Unit> f53782b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RecyclerView f53783c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f53784d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f53785f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f53786g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f53787h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f53788i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f53789j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public SparseArray<Pair<Object, Long>> f53790k;

    /* JADX WARN: Multi-variable type inference failed */
    public m(j adapter, Function2<? super Integer, ? super Pair<? extends Object, Long>, Unit> callback) {
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(callback, "callback");
        this.f53781a = adapter;
        this.f53782b = callback;
        this.f53784d = "MovieStaffScroll";
        this.f53787h = -1;
        this.f53788i = -1;
        this.f53789j = -1;
        this.f53790k = new SparseArray<>();
    }

    public final void d(AppBarLayout appBarLayout, int i11) {
        Intrinsics.g(appBarLayout, "appBarLayout");
        uo.b.a.f(uo.b.f78622a, this.f53784d, "appbarScroll  moveY:" + i11, false, 4, null);
        try {
            this.f53786g = i11;
            int iC = d0.c();
            int iA = com.blankj.utilcode.util.d.a();
            RecyclerView recyclerView = this.f53783c;
            int iD = 0;
            int top = (iC - iA) - (recyclerView != null ? recyclerView.getTop() : 0);
            RecyclerView recyclerView2 = this.f53783c;
            GridLayoutManager gridLayoutManager = (GridLayoutManager) (recyclerView2 != null ? recyclerView2.getLayoutManager() : null);
            if (gridLayoutManager == null) {
                return;
            }
            int iFindFirstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();
            int iFindLastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition();
            int i12 = -1;
            if (iFindFirstVisibleItemPosition <= iFindLastVisibleItemPosition) {
                int i13 = -1;
                int i14 = 0;
                while (true) {
                    View viewFindViewByPosition = gridLayoutManager.findViewByPosition(iFindFirstVisibleItemPosition);
                    if (viewFindViewByPosition != null) {
                        uo.b.a aVar = uo.b.f78622a;
                        uo.b.a.f(aVar, this.f53784d, "appbarScroll  *****  index:" + iFindFirstVisibleItemPosition + "  totalY:" + this.f53785f + "    top:" + viewFindViewByPosition.getTop(), false, 4, null);
                        if (viewFindViewByPosition.getTop() >= 0) {
                            if (viewFindViewByPosition.getBottom() >= viewFindViewByPosition.getHeight() * 0.7f) {
                                if (gridLayoutManager.getSpanSizeLookup().e(iFindFirstVisibleItemPosition, gridLayoutManager.getSpanCount()) == 0) {
                                    if (i13 == -1) {
                                        i13 = iFindFirstVisibleItemPosition;
                                    }
                                    int height = viewFindViewByPosition.getHeight();
                                    int i15 = i14 + height;
                                    if (i15 >= top) {
                                        if (((top - i14) * 100) / height < 70) {
                                            iD = kotlin.ranges.a.d(iFindFirstVisibleItemPosition - 1, 0);
                                            break;
                                        }
                                        int i16 = iFindFirstVisibleItemPosition + 1;
                                        if (i16 <= iFindLastVisibleItemPosition) {
                                            while (true) {
                                                int i17 = iFindFirstVisibleItemPosition;
                                                iFindFirstVisibleItemPosition = i16;
                                                if (gridLayoutManager.getSpanSizeLookup().e(iFindFirstVisibleItemPosition, gridLayoutManager.getSpanCount()) != 0) {
                                                    if (iFindFirstVisibleItemPosition == iFindLastVisibleItemPosition) {
                                                        break;
                                                    } else {
                                                        i16 = iFindFirstVisibleItemPosition + 1;
                                                    }
                                                } else {
                                                    iFindFirstVisibleItemPosition = i17;
                                                    break;
                                                }
                                            }
                                        }
                                        iD = iFindFirstVisibleItemPosition;
                                        break;
                                    }
                                    i14 = i15;
                                }
                            } else {
                                uo.b.a.f(aVar, this.f53784d, "index:" + iFindFirstVisibleItemPosition + "  标题栏档住了，不计入", false, 4, null);
                            }
                        } else {
                            return;
                        }
                    }
                    if (iFindFirstVisibleItemPosition == iFindLastVisibleItemPosition) {
                        break;
                    } else {
                        iFindFirstVisibleItemPosition++;
                    }
                }
                i12 = i13;
            }
            uo.b.a.f(uo.b.f78622a, this.f53784d, "firstVisiblePosition:" + i12 + "   realLastVisiblePosition:" + iD, false, 4, null);
            h(i12, iD);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void e(int i11, int i12) {
        while (i11 < i12) {
            try {
                Pair<? extends Object, Long> pair = this.f53790k.get(i11);
                if (pair != null) {
                    this.f53782b.invoke(Integer.valueOf(i11), pair);
                    this.f53790k.remove(i11);
                }
                i11++;
            } catch (Exception e11) {
                e11.printStackTrace();
                return;
            }
        }
    }

    public final void f() {
        try {
            IntIterator intIteratorA = androidx.core.util.k.a(this.f53790k);
            while (intIteratorA.hasNext()) {
                int iIntValue = intIteratorA.next().intValue();
                Function2<Integer, Pair<? extends Object, Long>, Unit> function2 = this.f53782b;
                Integer numValueOf = Integer.valueOf(iIntValue);
                Pair<Object, Long> pair = this.f53790k.get(iIntValue);
                Intrinsics.f(pair, "subjectBrowserHashMap.get(it)");
                function2.invoke(numValueOf, (Pair<? extends Object, Long>) pair);
            }
            this.f53790k.clear();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void g() {
        try {
            int i11 = this.f53787h;
            if (i11 >= 0) {
                int i12 = this.f53788i;
                this.f53787h = -1;
                this.f53788i = -1;
                h(i11, i12);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void h(int i11, int i12) {
        if (i11 > i12) {
            return;
        }
        try {
            int itemCount = this.f53781a.getItemCount();
            if (this.f53787h == i11 && i12 == this.f53788i && this.f53789j == itemCount) {
                return;
            }
            this.f53789j = itemCount;
            uo.b.a.f(uo.b.f78622a, this.f53784d, "showChange firstPosition:" + i11 + "  lastPosition:" + i12, false, 4, null);
            if (this.f53787h >= 0 && this.f53788i >= 0) {
                ArrayList arrayList = new ArrayList();
                IntIterator intIteratorA = androidx.core.util.k.a(this.f53790k);
                while (intIteratorA.hasNext()) {
                    int iIntValue = intIteratorA.next().intValue();
                    if (i11 > iIntValue || iIntValue > i12) {
                        Function2<Integer, Pair<? extends Object, Long>, Unit> function2 = this.f53782b;
                        Integer numValueOf = Integer.valueOf(iIntValue);
                        Pair<Object, Long> pair = this.f53790k.get(iIntValue);
                        Intrinsics.f(pair, "subjectBrowserHashMap.get(it)");
                        function2.invoke(numValueOf, (Pair<? extends Object, Long>) pair);
                        arrayList.add(Integer.valueOf(iIntValue));
                    } else if (iIntValue >= 0 && iIntValue < this.f53781a.getItemCount() && !Intrinsics.b(this.f53790k.get(iIntValue).getFirst(), this.f53781a.getItem(iIntValue))) {
                        Function2<Integer, Pair<? extends Object, Long>, Unit> function3 = this.f53782b;
                        Integer numValueOf2 = Integer.valueOf(iIntValue);
                        Pair<Object, Long> pair2 = this.f53790k.get(iIntValue);
                        Intrinsics.f(pair2, "subjectBrowserHashMap.get(it)");
                        function3.invoke(numValueOf2, (Pair<? extends Object, Long>) pair2);
                        this.f53790k.put(iIntValue, new Pair<>(this.f53781a.getItem(iIntValue), Long.valueOf(SystemClock.elapsedRealtime())));
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.f53790k.remove(((Number) it.next()).intValue());
                }
                if (i11 <= i12) {
                    int i13 = i11;
                    while (true) {
                        Object item = this.f53781a.getItem(i13);
                        if (this.f53790k.get(i13) == null) {
                            this.f53790k.put(i13, new Pair<>(item, Long.valueOf(SystemClock.elapsedRealtime())));
                        }
                        if (i13 == i12) {
                            break;
                        } else {
                            i13++;
                        }
                    }
                }
            } else if (i11 <= i12) {
                int i14 = i11;
                while (true) {
                    this.f53790k.put(i14, new Pair<>(this.f53781a.getItem(i14), Long.valueOf(SystemClock.elapsedRealtime())));
                    if (i14 == i12) {
                        break;
                    } else {
                        i14++;
                    }
                }
            }
            this.f53787h = i11;
            this.f53788i = i12;
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.r
    public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
        Intrinsics.g(recyclerView, "recyclerView");
        super.onScrolled(recyclerView, i11, i12);
        this.f53785f += i12;
        this.f53783c = recyclerView;
        if (this.f53786g >= 0) {
            return;
        }
        RecyclerView.m layoutManager = recyclerView.getLayoutManager();
        Intrinsics.e(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
        GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
        int iFindFirstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();
        int iFindLastVisibleItemPosition = gridLayoutManager.findLastVisibleItemPosition();
        for (int i13 = iFindFirstVisibleItemPosition; i13 < iFindLastVisibleItemPosition; i13++) {
            View viewFindViewByPosition = gridLayoutManager.findViewByPosition(i13);
            if (viewFindViewByPosition != null) {
                Rect rect = new Rect();
                viewFindViewByPosition.getLocalVisibleRect(rect);
                uo.b.a aVar = uo.b.f78622a;
                uo.b.a.f(aVar, this.f53784d, "index:" + i13 + "  totalY:" + this.f53785f + "    dy:" + i12 + " top:" + recyclerView.getTop(), false, 4, null);
                uo.b.a.f(aVar, this.f53784d, "index:" + i13 + "  firstView top:" + viewFindViewByPosition.getTop() + "    bottom:" + viewFindViewByPosition.getBottom(), false, 4, null);
                if (viewFindViewByPosition.getBottom() >= viewFindViewByPosition.getHeight() * 0.7f) {
                    if ((rect.height() * 100) / viewFindViewByPosition.getHeight() >= 70) {
                        iFindFirstVisibleItemPosition = i13;
                        break;
                    }
                } else {
                    uo.b.a.f(aVar, this.f53784d, "index:" + i13 + "  标题栏档住了，不计入", false, 4, null);
                }
            }
        }
        if (iFindFirstVisibleItemPosition <= iFindLastVisibleItemPosition) {
            int i14 = iFindLastVisibleItemPosition;
            while (true) {
                View viewFindViewByPosition2 = gridLayoutManager.findViewByPosition(i14);
                if (viewFindViewByPosition2 != null) {
                    Rect rect2 = new Rect();
                    viewFindViewByPosition2.getLocalVisibleRect(rect2);
                    if ((rect2.height() * 100) / viewFindViewByPosition2.getHeight() >= 70) {
                        iFindLastVisibleItemPosition = i14;
                        break;
                    }
                }
                if (i14 == iFindFirstVisibleItemPosition) {
                    break;
                } else {
                    i14--;
                }
            }
        }
        uo.b.a.f(uo.b.f78622a, this.f53784d, "firstVisiblePosition:" + iFindFirstVisibleItemPosition + "   lastVisiblePosition:" + iFindLastVisibleItemPosition, false, 4, null);
        h(iFindFirstVisibleItemPosition, iFindLastVisibleItemPosition);
    }
}
