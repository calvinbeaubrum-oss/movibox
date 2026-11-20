package com.transsion.baseui.widget.magicindicator;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import e20.b;
import h20.c;
import h20.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.lucode.hackware.magicindicator.R$id;
import net.lucode.hackware.magicindicator.R$layout;

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
public final class ORCommonNavigator extends FrameLayout implements f20.a, b.a {
    public static final int $stable = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HorizontalScrollView f51540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LinearLayout f51541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LinearLayout f51542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public c f51543d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ks.a f51544f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f51545g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f51546h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f51547i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public float f51548j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f51549k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f51550l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f51551m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f51552n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f51553o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f51554p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f51555q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List<i20.a> f51556r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final DataSetObserver f51557s;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a extends DataSetObserver {
        public a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            b bVar = ORCommonNavigator.this.f51545g;
            ks.a aVar = ORCommonNavigator.this.f51544f;
            bVar.m(aVar != null ? aVar.a() : 0);
            ORCommonNavigator.this.a();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ORCommonNavigator(Context context) {
        super(context);
        Intrinsics.d(context);
        b bVar = new b();
        this.f51545g = bVar;
        this.f51548j = 0.5f;
        this.f51549k = true;
        this.f51550l = true;
        this.f51555q = true;
        this.f51556r = new ArrayList();
        this.f51557s = new a();
        bVar.k(this);
    }

    public final void a() {
        ViewParent parent;
        removeAllViews();
        View viewInflate = this.f51546h ? LayoutInflater.from(getContext()).inflate(R$layout.pager_navigator_layout_no_scroll, this) : LayoutInflater.from(getContext()).inflate(R$layout.pager_navigator_layout, this);
        View viewFindViewById = viewInflate.findViewById(R$id.scroll_view);
        Intrinsics.e(viewFindViewById, "null cannot be cast to non-null type android.widget.HorizontalScrollView");
        this.f51540a = (HorizontalScrollView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R$id.title_container);
        Intrinsics.e(viewFindViewById2, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout = (LinearLayout) viewFindViewById2;
        this.f51541b = linearLayout;
        if (linearLayout != null) {
            linearLayout.setPadding(this.f51552n, 0, this.f51551m, 0);
        }
        View viewFindViewById3 = viewInflate.findViewById(R$id.indicator_container);
        Intrinsics.e(viewFindViewById3, "null cannot be cast to non-null type android.widget.LinearLayout");
        LinearLayout linearLayout2 = (LinearLayout) viewFindViewById3;
        this.f51542c = linearLayout2;
        if (this.f51553o && linearLayout2 != null && (parent = linearLayout2.getParent()) != null) {
            parent.bringChildToFront(this.f51542c);
        }
        b();
    }

    public final void b() {
        int iG = this.f51545g.g();
        int i11 = 0;
        while (true) {
            LinearLayout.LayoutParams layoutParams = null;
            if (i11 >= iG) {
                break;
            }
            ks.a aVar = this.f51544f;
            Object objC = aVar != null ? aVar.c(getContext(), i11) : null;
            ks.a aVar2 = this.f51544f;
            if (aVar2 != null) {
                Context context = getContext();
                Intrinsics.f(context, "context");
                layoutParams = aVar2.h(context, i11);
            }
            if (objC instanceof View) {
                View view = (View) objC;
                if (layoutParams == null) {
                    if (this.f51546h) {
                        layoutParams = new LinearLayout.LayoutParams(0, -1);
                        ks.a aVar3 = this.f51544f;
                        if (aVar3 != null) {
                            layoutParams.weight = aVar3.d(getContext(), i11);
                        }
                    } else {
                        layoutParams = new LinearLayout.LayoutParams(-2, -1);
                    }
                }
                LinearLayout linearLayout = this.f51541b;
                if (linearLayout != null) {
                    linearLayout.addView(view, layoutParams);
                }
            }
            i11++;
        }
        ks.a aVar4 = this.f51544f;
        if (aVar4 != null) {
            c cVarB = aVar4 != null ? aVar4.b(getContext()) : null;
            this.f51543d = cVarB;
            if (cVarB instanceof View) {
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
                LinearLayout linearLayout2 = this.f51542c;
                if (linearLayout2 != null) {
                    linearLayout2.addView((View) this.f51543d, layoutParams2);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c() {
        View view;
        View childAt;
        this.f51556r.clear();
        int iG = this.f51545g.g();
        for (int i11 = 0; i11 < iG; i11++) {
            i20.a aVar = new i20.a();
            LinearLayout linearLayout = this.f51541b;
            if (linearLayout != null) {
                childAt = linearLayout.getChildAt(i11);
            } else {
                view = 0;
            }
            if (view != 0) {
                aVar.f66885a = view.getLeft();
                aVar.f66886b = view.getTop();
                aVar.f66887c = view.getRight();
                int bottom = view.getBottom();
                aVar.f66888d = bottom;
                if (view instanceof h20.b) {
                    view = childAt;
                    h20.b bVar = (h20.b) view;
                    aVar.f66889e = bVar.getContentLeft();
                    aVar.f66890f = bVar.getContentTop();
                    aVar.f66891g = bVar.getContentRight();
                    aVar.f66892h = bVar.getContentBottom();
                } else {
                    view = childAt;
                    aVar.f66889e = aVar.f66885a;
                    aVar.f66890f = aVar.f66886b;
                    aVar.f66891g = aVar.f66887c;
                    aVar.f66892h = bottom;
                }
            } else {
                view = childAt;
            }
            this.f51556r.add(aVar);
        }
    }

    public final ks.a getAdapter() {
        return this.f51544f;
    }

    public final int getLeftPadding() {
        return this.f51552n;
    }

    public final c getPagerIndicator() {
        return this.f51543d;
    }

    public final d getPagerTitleView(int i11) {
        LinearLayout linearLayout = this.f51541b;
        if (linearLayout == null) {
            return null;
        }
        View childAt = linearLayout != null ? linearLayout.getChildAt(i11) : null;
        if (childAt instanceof d) {
            return (d) childAt;
        }
        return null;
    }

    public final int getRightPadding() {
        return this.f51551m;
    }

    public final float getScrollPivotX() {
        return this.f51548j;
    }

    public final LinearLayout getTitleContainer() {
        return this.f51541b;
    }

    public final boolean isAdjustMode() {
        return this.f51546h;
    }

    public final boolean isEnablePivotScroll() {
        return this.f51547i;
    }

    public final boolean isFollowTouch() {
        return this.f51550l;
    }

    public final boolean isIndicatorOnTop() {
        return this.f51553o;
    }

    public final boolean isReselectWhenLayout() {
        return this.f51555q;
    }

    public final boolean isSkimOver() {
        return this.f51554p;
    }

    public final boolean isSmoothScroll() {
        return this.f51549k;
    }

    @Override // f20.a
    public void notifyDataSetChanged() {
        ks.a aVar = this.f51544f;
        if (aVar == null || aVar == null) {
            return;
        }
        aVar.e();
    }

    @Override // f20.a
    public void onAttachToMagicIndicator() {
        a();
    }

    @Override // e20.b.a
    public void onDeselected(int i11, int i12) {
        LinearLayout linearLayout = this.f51541b;
        if (linearLayout == null) {
            return;
        }
        KeyEvent.Callback childAt = linearLayout != null ? linearLayout.getChildAt(i11) : null;
        if (childAt instanceof d) {
            ((d) childAt).onDeselected(i11, i12);
        }
    }

    @Override // f20.a
    public void onDetachFromMagicIndicator() {
    }

    @Override // e20.b.a
    public void onEnter(int i11, int i12, float f11, boolean z11) {
        LinearLayout linearLayout = this.f51541b;
        if (linearLayout == null) {
            return;
        }
        KeyEvent.Callback childAt = linearLayout != null ? linearLayout.getChildAt(i11) : null;
        if (childAt instanceof d) {
            ((d) childAt).onEnter(i11, i12, f11, z11);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        super.onLayout(z11, i11, i12, i13, i14);
        if (this.f51544f != null) {
            c();
            c cVar = this.f51543d;
            if (cVar != null && cVar != null) {
                cVar.onPositionDataProvide(this.f51556r);
            }
            if (this.f51555q && this.f51545g.f() == 0) {
                onPageSelected(this.f51545g.e());
                onPageScrolled(this.f51545g.e(), 0.0f, 0);
            }
        }
    }

    @Override // e20.b.a
    public void onLeave(int i11, int i12, float f11, boolean z11) {
        LinearLayout linearLayout = this.f51541b;
        if (linearLayout == null) {
            return;
        }
        KeyEvent.Callback childAt = linearLayout != null ? linearLayout.getChildAt(i11) : null;
        if (childAt instanceof d) {
            ((d) childAt).onLeave(i11, i12, f11, z11);
        }
    }

    @Override // f20.a
    public void onPageScrollStateChanged(int i11) {
        if (this.f51544f != null) {
            this.f51545g.h(i11);
            c cVar = this.f51543d;
            if (cVar == null || cVar == null) {
                return;
            }
            cVar.onPageScrollStateChanged(i11);
        }
    }

    @Override // f20.a
    public void onPageScrolled(int i11, float f11, int i12) {
        if (this.f51544f != null) {
            this.f51545g.i(i11, f11, i12);
            c cVar = this.f51543d;
            if (cVar != null) {
                cVar.onPageScrolled(i11, f11, i12);
            }
            if (this.f51540a == null || this.f51556r.size() <= 0 || i11 < 0 || i11 >= this.f51556r.size() || !this.f51550l) {
                return;
            }
            int iMin = (int) Math.min(this.f51556r.size() - 1, i11);
            int iMin2 = (int) Math.min(this.f51556r.size() - 1, i11 + 1);
            i20.a aVar = this.f51556r.get(iMin);
            i20.a aVar2 = this.f51556r.get(iMin2);
            float fA = aVar.a();
            HorizontalScrollView horizontalScrollView = this.f51540a;
            float width = fA - ((horizontalScrollView != null ? horizontalScrollView.getWidth() : 0) * this.f51548j);
            float fA2 = aVar2.a();
            HorizontalScrollView horizontalScrollView2 = this.f51540a;
            float width2 = fA2 - ((horizontalScrollView2 != null ? horizontalScrollView2.getWidth() : 0) * this.f51548j);
            HorizontalScrollView horizontalScrollView3 = this.f51540a;
            if (horizontalScrollView3 != null) {
                horizontalScrollView3.scrollTo((int) (width + ((width2 - width) * f11)), 0);
            }
        }
    }

    @Override // f20.a
    public void onPageSelected(int i11) {
        if (this.f51544f != null) {
            this.f51545g.j(i11);
            c cVar = this.f51543d;
            if (cVar == null || cVar == null) {
                return;
            }
            cVar.onPageSelected(i11);
        }
    }

    @Override // e20.b.a
    public void onSelected(int i11, int i12) {
        LinearLayout linearLayout = this.f51541b;
        if (linearLayout == null) {
            return;
        }
        KeyEvent.Callback childAt = linearLayout != null ? linearLayout.getChildAt(i11) : null;
        if (childAt instanceof d) {
            ((d) childAt).onSelected(i11, i12);
        }
        if (this.f51546h || this.f51550l || this.f51540a == null || this.f51556r.size() <= 0) {
            return;
        }
        i20.a aVar = this.f51556r.get((int) Math.min(this.f51556r.size() - 1, i11));
        if (this.f51547i) {
            float fA = aVar.a();
            HorizontalScrollView horizontalScrollView = this.f51540a;
            Intrinsics.d(horizontalScrollView);
            float width = fA - (horizontalScrollView.getWidth() * this.f51548j);
            if (this.f51549k) {
                HorizontalScrollView horizontalScrollView2 = this.f51540a;
                if (horizontalScrollView2 != null) {
                    horizontalScrollView2.smoothScrollTo((int) width, 0);
                    return;
                }
                return;
            }
            HorizontalScrollView horizontalScrollView3 = this.f51540a;
            if (horizontalScrollView3 != null) {
                horizontalScrollView3.scrollTo((int) width, 0);
                return;
            }
            return;
        }
        HorizontalScrollView horizontalScrollView4 = this.f51540a;
        Intrinsics.d(horizontalScrollView4);
        int scrollX = horizontalScrollView4.getScrollX();
        int i13 = aVar.f66885a;
        if (scrollX > i13) {
            if (this.f51549k) {
                HorizontalScrollView horizontalScrollView5 = this.f51540a;
                if (horizontalScrollView5 != null) {
                    horizontalScrollView5.smoothScrollTo(i13, 0);
                    return;
                }
                return;
            }
            HorizontalScrollView horizontalScrollView6 = this.f51540a;
            if (horizontalScrollView6 != null) {
                horizontalScrollView6.scrollTo(i13, 0);
                return;
            }
            return;
        }
        HorizontalScrollView horizontalScrollView7 = this.f51540a;
        Intrinsics.d(horizontalScrollView7);
        int scrollX2 = horizontalScrollView7.getScrollX() + getWidth();
        int i14 = aVar.f66887c;
        if (scrollX2 < i14) {
            if (this.f51549k) {
                HorizontalScrollView horizontalScrollView8 = this.f51540a;
                if (horizontalScrollView8 != null) {
                    horizontalScrollView8.smoothScrollTo(i14 - getWidth(), 0);
                    return;
                }
                return;
            }
            HorizontalScrollView horizontalScrollView9 = this.f51540a;
            if (horizontalScrollView9 != null) {
                horizontalScrollView9.scrollTo(i14 - getWidth(), 0);
            }
        }
    }

    public final void setAdapter(ks.a aVar) {
        ks.a aVar2;
        ks.a aVar3 = this.f51544f;
        if (aVar3 == aVar) {
            return;
        }
        if (aVar3 != null && aVar3 != null) {
            aVar3.g(this.f51557s);
        }
        this.f51544f = aVar;
        if (aVar == null) {
            this.f51545g.m(0);
            a();
            return;
        }
        if (aVar != null) {
            aVar.f(this.f51557s);
        }
        b bVar = this.f51545g;
        ks.a aVar4 = this.f51544f;
        bVar.m(aVar4 != null ? aVar4.a() : 0);
        if (this.f51541b == null || (aVar2 = this.f51544f) == null) {
            return;
        }
        aVar2.e();
    }

    public final void setAdjustMode(boolean z11) {
        this.f51546h = z11;
    }

    public final void setEnablePivotScroll(boolean z11) {
        this.f51547i = z11;
    }

    public final void setFollowTouch(boolean z11) {
        this.f51550l = z11;
    }

    public final void setIndicatorOnTop(boolean z11) {
        this.f51553o = z11;
    }

    public final void setLeftPadding(int i11) {
        this.f51552n = i11;
    }

    public final void setReselectWhenLayout(boolean z11) {
        this.f51555q = z11;
    }

    public final void setRightPadding(int i11) {
        this.f51551m = i11;
    }

    public final void setScrollPivotX(float f11) {
        this.f51548j = f11;
    }

    public final void setSkimOver(boolean z11) {
        this.f51554p = z11;
        this.f51545g.l(z11);
    }

    public final void setSmoothScroll(boolean z11) {
        this.f51549k = z11;
    }
}
