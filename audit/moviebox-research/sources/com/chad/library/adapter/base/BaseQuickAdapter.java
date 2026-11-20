package com.chad.library.adapter.base;

import android.animation.Animator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import f9.c;
import f9.d;
import f9.e;
import h9.f;
import h9.g;
import h9.h;
import h9.j;
import h9.l;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public abstract class BaseQuickAdapter<T, VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> {
    public static final a G = new a(null);
    public g A;
    public h9.a B;
    public f C;
    public RecyclerView D;
    public final LinkedHashSet<Integer> E;
    public final LinkedHashSet<Integer> F;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f28828i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<T> f28829j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f28830k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f28831l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f28832m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f28833n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f28834o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f28835p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f28836q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public c9.b f28837r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public d9.a<T> f28838s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public LinearLayout f28839t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public LinearLayout f28840u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public FrameLayout f28841v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f28842w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public d f28843x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public e f28844y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public f9.b f28845z;

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    @Metadata
    public enum AnimationType {
        AlphaIn,
        ScaleIn,
        SlideInBottom,
        SlideInLeft,
        SlideInRight
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    /* JADX INFO: loaded from: classes4.dex */
    @Metadata
    public static final class b extends GridLayoutManager.c {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ BaseQuickAdapter<T, VH> f28846e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.m f28847f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ GridLayoutManager.c f28848g;

        public b(BaseQuickAdapter<T, VH> baseQuickAdapter, RecyclerView.m mVar, GridLayoutManager.c cVar) {
            this.f28846e = baseQuickAdapter;
            this.f28847f = mVar;
            this.f28848g = cVar;
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.c
        public int f(int i11) {
            int itemViewType = this.f28846e.getItemViewType(i11);
            if (itemViewType == 268435729 && this.f28846e.L()) {
                return 1;
            }
            if (itemViewType == 268436275 && this.f28846e.H()) {
                return 1;
            }
            BaseQuickAdapter.g(this.f28846e);
            return this.f28846e.c0(itemViewType) ? ((GridLayoutManager) this.f28847f).getSpanCount() : this.f28848g.f(i11);
        }
    }

    @JvmOverloads
    public BaseQuickAdapter(int i11, List<T> list) {
        this.f28828i = i11;
        this.f28829j = list == null ? new ArrayList<>() : list;
        this.f28832m = true;
        this.f28836q = true;
        this.f28842w = -1;
        v();
        this.E = new LinkedHashSet<>();
        this.F = new LinkedHashSet<>();
    }

    public /* synthetic */ BaseQuickAdapter(int i11, List list, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, (i12 & 2) != 0 ? null : list);
    }

    public static final /* synthetic */ f9.a g(BaseQuickAdapter baseQuickAdapter) {
        baseQuickAdapter.getClass();
        return null;
    }

    public static /* synthetic */ int o(BaseQuickAdapter baseQuickAdapter, View view, int i11, int i12, int i13, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addFooterView");
        }
        if ((i13 & 2) != 0) {
            i11 = -1;
        }
        if ((i13 & 4) != 0) {
            i12 = 1;
        }
        return baseQuickAdapter.n(view, i11, i12);
    }

    public static /* synthetic */ int q(BaseQuickAdapter baseQuickAdapter, View view, int i11, int i12, int i13, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addHeaderView");
        }
        if ((i13 & 2) != 0) {
            i11 = -1;
        }
        if ((i13 & 4) != 0) {
            i12 = 1;
        }
        return baseQuickAdapter.p(view, i11, i12);
    }

    public static final void s(BaseViewHolder viewHolder, BaseQuickAdapter this$0, View v11) {
        Intrinsics.g(viewHolder, "$viewHolder");
        Intrinsics.g(this$0, "this$0");
        int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return;
        }
        int iK = bindingAdapterPosition - this$0.K();
        Intrinsics.f(v11, "v");
        this$0.y0(v11, iK);
    }

    public static final void t(BaseViewHolder viewHolder, BaseQuickAdapter this$0, View v11) {
        Intrinsics.g(viewHolder, "$viewHolder");
        Intrinsics.g(this$0, "this$0");
        int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return;
        }
        int iK = bindingAdapterPosition - this$0.K();
        Intrinsics.f(v11, "v");
        this$0.A0(v11, iK);
    }

    public static final boolean u(BaseViewHolder viewHolder, BaseQuickAdapter this$0, View v11) {
        Intrinsics.g(viewHolder, "$viewHolder");
        Intrinsics.g(this$0, "this$0");
        int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return false;
        }
        int iK = bindingAdapterPosition - this$0.K();
        Intrinsics.f(v11, "v");
        return this$0.C0(v11, iK);
    }

    public static /* synthetic */ int u0(BaseQuickAdapter baseQuickAdapter, View view, int i11, int i12, int i13, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setHeaderView");
        }
        if ((i13 & 2) != 0) {
            i11 = 0;
        }
        if ((i13 & 4) != 0) {
            i12 = 1;
        }
        return baseQuickAdapter.t0(view, i11, i12);
    }

    public VH A(View view) {
        Intrinsics.g(view, "view");
        Class<?> clsN = null;
        for (Class<?> superclass = getClass(); clsN == null && superclass != null; superclass = superclass.getSuperclass()) {
            clsN = N(superclass);
        }
        VH vh2 = clsN == null ? (VH) new BaseViewHolder(view) : (VH) z(clsN, view);
        return vh2 == null ? (VH) new BaseViewHolder(view) : vh2;
    }

    public void A0(View v11, int i11) {
        Intrinsics.g(v11, "v");
        d dVar = this.f28843x;
        if (dVar != null) {
            dVar.a(this, v11, i11);
        }
    }

    public VH B(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        return (VH) A(i9.a.a(parent, i11));
    }

    public final void B0(d dVar) {
        this.f28843x = dVar;
    }

    public final LinkedHashSet<Integer> C() {
        return this.E;
    }

    public boolean C0(View v11, int i11) {
        Intrinsics.g(v11, "v");
        e eVar = this.f28844y;
        if (eVar != null) {
            return eVar.a(this, v11, i11);
        }
        return false;
    }

    public final List<T> D() {
        return this.f28829j;
    }

    public final void D0(e eVar) {
        this.f28844y = eVar;
    }

    public int E() {
        return this.f28829j.size();
    }

    public final void E0(boolean z11) {
        this.f28832m = z11;
    }

    public int F(int i11) {
        return super.getItemViewType(i11);
    }

    public void F0(Animator anim, int i11) {
        Intrinsics.g(anim, "anim");
        anim.start();
    }

    public final int G() {
        return a0() ? 1 : 0;
    }

    public final boolean H() {
        return this.f28834o;
    }

    public final int I() {
        if (!Z()) {
            return K() + this.f28829j.size();
        }
        int i11 = (this.f28830k && b0()) ? 2 : 1;
        if (this.f28831l) {
            return i11;
        }
        return -1;
    }

    public final LinearLayout J() {
        LinearLayout linearLayout = this.f28839t;
        if (linearLayout != null) {
            if (linearLayout != null) {
                return linearLayout;
            }
            Intrinsics.y("mHeaderLayout");
        }
        return null;
    }

    public final int K() {
        return b0() ? 1 : 0;
    }

    public final boolean L() {
        return this.f28833n;
    }

    public final int M() {
        return (!Z() || this.f28830k) ? 0 : -1;
    }

    public final Class<?> N(Class<?> cls) {
        try {
            Type genericSuperclass = cls.getGenericSuperclass();
            if (!(genericSuperclass instanceof ParameterizedType)) {
                return null;
            }
            Type[] types = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
            Intrinsics.f(types, "types");
            for (Type type : types) {
                if (type instanceof Class) {
                    if (BaseViewHolder.class.isAssignableFrom((Class) type)) {
                        return (Class) type;
                    }
                } else if (type instanceof ParameterizedType) {
                    Type rawType = ((ParameterizedType) type).getRawType();
                    if ((rawType instanceof Class) && BaseViewHolder.class.isAssignableFrom((Class) rawType)) {
                        return (Class) rawType;
                    }
                } else {
                    continue;
                }
            }
            return null;
        } catch (TypeNotPresentException e11) {
            e11.printStackTrace();
            return null;
        } catch (GenericSignatureFormatError e12) {
            e12.printStackTrace();
            return null;
        } catch (MalformedParameterizedTypeException e13) {
            e13.printStackTrace();
            return null;
        }
    }

    public T O(int i11) {
        return (T) CollectionsKt___CollectionsKt.h0(this.f28829j, i11);
    }

    public int P(T t11) {
        if (t11 == null || !(!this.f28829j.isEmpty())) {
            return -1;
        }
        return this.f28829j.indexOf(t11);
    }

    public final f Q() {
        f fVar = this.C;
        if (fVar == null) {
            throw new IllegalStateException("Please first implements LoadMoreModule".toString());
        }
        Intrinsics.d(fVar);
        return fVar;
    }

    public final f R() {
        return this.C;
    }

    public final f9.b S() {
        return this.f28845z;
    }

    public final c T() {
        return null;
    }

    public final d U() {
        return this.f28843x;
    }

    public final e V() {
        return this.f28844y;
    }

    public final RecyclerView W() {
        RecyclerView recyclerView = this.D;
        if (recyclerView == null) {
            throw new IllegalStateException("Please get it after onAttachedToRecyclerView()".toString());
        }
        Intrinsics.d(recyclerView);
        return recyclerView;
    }

    public final RecyclerView X() {
        return this.D;
    }

    public final View Y(int i11, int i12) {
        BaseViewHolder baseViewHolder;
        RecyclerView recyclerView = this.D;
        if (recyclerView == null || (baseViewHolder = (BaseViewHolder) recyclerView.findViewHolderForLayoutPosition(i11)) == null) {
            return null;
        }
        return baseViewHolder.getViewOrNull(i12);
    }

    public final boolean Z() {
        FrameLayout frameLayout = this.f28841v;
        if (frameLayout != null) {
            if (frameLayout == null) {
                Intrinsics.y("mEmptyLayout");
                frameLayout = null;
            }
            if (frameLayout.getChildCount() != 0 && this.f28832m) {
                return this.f28829j.isEmpty();
            }
            return false;
        }
        return false;
    }

    public final boolean a0() {
        LinearLayout linearLayout = this.f28840u;
        if (linearLayout == null) {
            return false;
        }
        if (linearLayout == null) {
            Intrinsics.y("mFooterLayout");
            linearLayout = null;
        }
        return linearLayout.getChildCount() > 0;
    }

    public final boolean b0() {
        LinearLayout linearLayout = this.f28839t;
        if (linearLayout == null) {
            return false;
        }
        if (linearLayout == null) {
            Intrinsics.y("mHeaderLayout");
            linearLayout = null;
        }
        return linearLayout.getChildCount() > 0;
    }

    public boolean c0(int i11) {
        return i11 == 268436821 || i11 == 268435729 || i11 == 268436275 || i11 == 268436002;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: d0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(VH holder, int i11) {
        Intrinsics.g(holder, "holder");
        f fVar = this.C;
        if (fVar != null) {
            fVar.e(i11);
        }
        switch (holder.getItemViewType()) {
            case 268435729:
            case 268436275:
            case 268436821:
                break;
            case 268436002:
                f fVar2 = this.C;
                if (fVar2 != null) {
                    fVar2.j().convert(holder, i11, fVar2.i());
                }
                break;
            default:
                x(holder, getItem(i11 - K()));
                break;
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(VH holder, int i11, List<Object> payloads) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(payloads, "payloads");
        if (payloads.isEmpty()) {
            onBindViewHolder(holder, i11);
        }
        f fVar = this.C;
        if (fVar != null) {
            fVar.e(i11);
        }
        switch (holder.getItemViewType()) {
            case 268435729:
            case 268436275:
            case 268436821:
                break;
            case 268436002:
                f fVar2 = this.C;
                if (fVar2 != null) {
                    fVar2.j().convert(holder, i11, fVar2.i());
                }
                break;
            default:
                y(holder, getItem(i11 - K()), payloads);
                break;
        }
    }

    public VH f0(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        return (VH) B(parent, this.f28828i);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public VH onCreateViewHolder(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        View view = null;
        switch (i11) {
            case 268435729:
                LinearLayout linearLayout = this.f28839t;
                if (linearLayout == null) {
                    Intrinsics.y("mHeaderLayout");
                    linearLayout = null;
                }
                ViewParent parent2 = linearLayout.getParent();
                if (parent2 instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) parent2;
                    LinearLayout linearLayout2 = this.f28839t;
                    if (linearLayout2 == null) {
                        Intrinsics.y("mHeaderLayout");
                        linearLayout2 = null;
                    }
                    viewGroup.removeView(linearLayout2);
                }
                LinearLayout linearLayout3 = this.f28839t;
                if (linearLayout3 == null) {
                    Intrinsics.y("mHeaderLayout");
                } else {
                    view = linearLayout3;
                }
                return (VH) A(view);
            case 268436002:
                f fVar = this.C;
                Intrinsics.d(fVar);
                VH vh2 = (VH) A(fVar.j().getRootView(parent));
                f fVar2 = this.C;
                Intrinsics.d(fVar2);
                fVar2.E(vh2);
                return vh2;
            case 268436275:
                LinearLayout linearLayout4 = this.f28840u;
                if (linearLayout4 == null) {
                    Intrinsics.y("mFooterLayout");
                    linearLayout4 = null;
                }
                ViewParent parent3 = linearLayout4.getParent();
                if (parent3 instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) parent3;
                    LinearLayout linearLayout5 = this.f28840u;
                    if (linearLayout5 == null) {
                        Intrinsics.y("mFooterLayout");
                        linearLayout5 = null;
                    }
                    viewGroup2.removeView(linearLayout5);
                }
                LinearLayout linearLayout6 = this.f28840u;
                if (linearLayout6 == null) {
                    Intrinsics.y("mFooterLayout");
                } else {
                    view = linearLayout6;
                }
                return (VH) A(view);
            case 268436821:
                FrameLayout frameLayout = this.f28841v;
                if (frameLayout == null) {
                    Intrinsics.y("mEmptyLayout");
                    frameLayout = null;
                }
                ViewParent parent4 = frameLayout.getParent();
                if (parent4 instanceof ViewGroup) {
                    ViewGroup viewGroup3 = (ViewGroup) parent4;
                    FrameLayout frameLayout2 = this.f28841v;
                    if (frameLayout2 == null) {
                        Intrinsics.y("mEmptyLayout");
                        frameLayout2 = null;
                    }
                    viewGroup3.removeView(frameLayout2);
                }
                FrameLayout frameLayout3 = this.f28841v;
                if (frameLayout3 == null) {
                    Intrinsics.y("mEmptyLayout");
                } else {
                    view = frameLayout3;
                }
                return (VH) A(view);
            default:
                VH vh3 = (VH) f0(parent, i11);
                r(vh3, i11);
                h0(vh3, i11);
                return vh3;
        }
    }

    public final Context getContext() {
        Context context = W().getContext();
        Intrinsics.f(context, "recyclerView.context");
        return context;
    }

    public T getItem(int i11) {
        return this.f28829j.get(i11);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int i11 = 1;
        if (!Z()) {
            f fVar = this.C;
            return K() + E() + G() + ((fVar == null || !fVar.m()) ? 0 : 1);
        }
        if (this.f28830k && b0()) {
            i11 = 2;
        }
        return (this.f28831l && a0()) ? i11 + 1 : i11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i11) {
        return i11;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [boolean] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i11) {
        if (Z()) {
            boolean z11 = this.f28830k && b0();
            if (i11 != 0) {
                return i11 != 1 ? 268436275 : 268436275;
            }
            if (z11) {
                return 268435729;
            }
            return 268436821;
        }
        boolean zB0 = b0();
        if (zB0 && i11 == 0) {
            return 268435729;
        }
        if (zB0) {
            i11--;
        }
        int size = this.f28829j.size();
        if (i11 < size) {
            return F(i11);
        }
        return i11 - size < a0() ? 268436275 : 268436002;
    }

    public final void h(RecyclerView.a0 a0Var) {
        if (this.f28835p) {
            if (!this.f28836q || a0Var.getLayoutPosition() > this.f28842w) {
                c9.b aVar = this.f28837r;
                if (aVar == null) {
                    aVar = new c9.a(0.0f, 1, null);
                }
                View view = a0Var.itemView;
                Intrinsics.f(view, "holder.itemView");
                for (Animator animator : aVar.a(view)) {
                    F0(animator, a0Var.getLayoutPosition());
                }
                this.f28842w = a0Var.getLayoutPosition();
            }
        }
    }

    public void h0(VH viewHolder, int i11) {
        Intrinsics.g(viewHolder, "viewHolder");
    }

    public final void i(int... viewIds) {
        Intrinsics.g(viewIds, "viewIds");
        for (int i11 : viewIds) {
            this.E.add(Integer.valueOf(i11));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: i0 */
    public void onViewAttachedToWindow(VH holder) {
        Intrinsics.g(holder, "holder");
        super.onViewAttachedToWindow(holder);
        if (c0(holder.getItemViewType())) {
            s0(holder);
        } else {
            h(holder);
        }
    }

    public void j(int i11, T t11) {
        this.f28829j.add(i11, t11);
        notifyItemInserted(i11 + K());
        w(1);
    }

    public final void j0() {
        if (b0()) {
            LinearLayout linearLayout = this.f28839t;
            if (linearLayout == null) {
                Intrinsics.y("mHeaderLayout");
                linearLayout = null;
            }
            linearLayout.removeAllViews();
            int iM = M();
            if (iM != -1) {
                notifyItemRemoved(iM);
            }
        }
    }

    public void k(int i11, Collection<? extends T> newData) {
        Intrinsics.g(newData, "newData");
        this.f28829j.addAll(i11, newData);
        notifyItemRangeInserted(i11 + K(), newData.size());
        w(newData.size());
    }

    public void k0(int i11) {
        if (i11 >= this.f28829j.size()) {
            return;
        }
        this.f28829j.remove(i11);
        int iK = i11 + K();
        notifyItemRemoved(iK);
        w(0);
        notifyItemRangeChanged(iK, this.f28829j.size() - iK);
    }

    public void l(@NonNull T t11) {
        this.f28829j.add(t11);
        notifyItemInserted(this.f28829j.size() + K());
        w(1);
    }

    public final void l0() {
        FrameLayout frameLayout = this.f28841v;
        if (frameLayout != null) {
            if (frameLayout == null) {
                Intrinsics.y("mEmptyLayout");
                frameLayout = null;
            }
            frameLayout.removeAllViews();
        }
    }

    public void m(@NonNull Collection<? extends T> newData) {
        Intrinsics.g(newData, "newData");
        this.f28829j.addAll(newData);
        notifyItemRangeInserted((this.f28829j.size() - newData.size()) + K(), newData.size());
        w(newData.size());
    }

    public final void m0(View header) {
        int iM;
        Intrinsics.g(header, "header");
        if (b0()) {
            LinearLayout linearLayout = this.f28839t;
            LinearLayout linearLayout2 = null;
            if (linearLayout == null) {
                Intrinsics.y("mHeaderLayout");
                linearLayout = null;
            }
            linearLayout.removeView(header);
            LinearLayout linearLayout3 = this.f28839t;
            if (linearLayout3 == null) {
                Intrinsics.y("mHeaderLayout");
            } else {
                linearLayout2 = linearLayout3;
            }
            if (linearLayout2.getChildCount() != 0 || (iM = M()) == -1) {
                return;
            }
            notifyItemRemoved(iM);
        }
    }

    @JvmOverloads
    public final int n(View view, int i11, int i12) {
        int I;
        Intrinsics.g(view, "view");
        LinearLayout linearLayout = null;
        if (this.f28840u == null) {
            LinearLayout linearLayout2 = new LinearLayout(view.getContext());
            this.f28840u = linearLayout2;
            linearLayout2.setOrientation(i12);
            LinearLayout linearLayout3 = this.f28840u;
            if (linearLayout3 == null) {
                Intrinsics.y("mFooterLayout");
                linearLayout3 = null;
            }
            linearLayout3.setLayoutParams(i12 == 1 ? new RecyclerView.n(-1, -2) : new RecyclerView.n(-2, -1));
        }
        LinearLayout linearLayout4 = this.f28840u;
        if (linearLayout4 == null) {
            Intrinsics.y("mFooterLayout");
            linearLayout4 = null;
        }
        int childCount = linearLayout4.getChildCount();
        if (i11 < 0 || i11 > childCount) {
            i11 = childCount;
        }
        LinearLayout linearLayout5 = this.f28840u;
        if (linearLayout5 == null) {
            Intrinsics.y("mFooterLayout");
            linearLayout5 = null;
        }
        linearLayout5.addView(view, i11);
        LinearLayout linearLayout6 = this.f28840u;
        if (linearLayout6 == null) {
            Intrinsics.y("mFooterLayout");
        } else {
            linearLayout = linearLayout6;
        }
        if (linearLayout.getChildCount() == 1 && (I = I()) != -1) {
            notifyItemInserted(I);
        }
        return i11;
    }

    public final void n0(boolean z11) {
        this.f28835p = z11;
    }

    public final void o0(DiffUtil.e<T> diffCallback) {
        Intrinsics.g(diffCallback, "diffCallback");
        p0(new d9.b.a(diffCallback).a());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.g(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.D = recyclerView;
        RecyclerView.m layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new b(this, layoutManager, gridLayoutManager.getSpanSizeLookup()));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Intrinsics.g(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.D = null;
    }

    @JvmOverloads
    public final int p(View view, int i11, int i12) {
        int iM;
        Intrinsics.g(view, "view");
        LinearLayout linearLayout = null;
        if (this.f28839t == null) {
            LinearLayout linearLayout2 = new LinearLayout(view.getContext());
            this.f28839t = linearLayout2;
            linearLayout2.setOrientation(i12);
            LinearLayout linearLayout3 = this.f28839t;
            if (linearLayout3 == null) {
                Intrinsics.y("mHeaderLayout");
                linearLayout3 = null;
            }
            linearLayout3.setLayoutParams(i12 == 1 ? new RecyclerView.n(-1, -2) : new RecyclerView.n(-2, -1));
        }
        LinearLayout linearLayout4 = this.f28839t;
        if (linearLayout4 == null) {
            Intrinsics.y("mHeaderLayout");
            linearLayout4 = null;
        }
        int childCount = linearLayout4.getChildCount();
        if (i11 < 0 || i11 > childCount) {
            i11 = childCount;
        }
        LinearLayout linearLayout5 = this.f28839t;
        if (linearLayout5 == null) {
            Intrinsics.y("mHeaderLayout");
            linearLayout5 = null;
        }
        linearLayout5.addView(view, i11);
        LinearLayout linearLayout6 = this.f28839t;
        if (linearLayout6 == null) {
            Intrinsics.y("mHeaderLayout");
        } else {
            linearLayout = linearLayout6;
        }
        if (linearLayout.getChildCount() == 1 && (iM = M()) != -1) {
            notifyItemInserted(iM);
        }
        return i11;
    }

    public final void p0(d9.b<T> config) {
        Intrinsics.g(config, "config");
        this.f28838s = new d9.a<>(this, config);
    }

    public final void q0(int i11) {
        RecyclerView recyclerView = this.D;
        if (recyclerView != null) {
            View view = LayoutInflater.from(recyclerView.getContext()).inflate(i11, (ViewGroup) recyclerView, false);
            Intrinsics.f(view, "view");
            r0(view);
        }
    }

    public void r(final VH viewHolder, int i11) {
        Intrinsics.g(viewHolder, "viewHolder");
        if (this.f28843x != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: b9.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseQuickAdapter.t(viewHolder, this, view);
                }
            });
        }
        if (this.f28844y != null) {
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: b9.f
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return BaseQuickAdapter.u(viewHolder, this, view);
                }
            });
        }
        if (this.f28845z != null) {
            for (Integer id2 : C()) {
                View view = viewHolder.itemView;
                Intrinsics.f(id2, "id");
                View viewFindViewById = view.findViewById(id2.intValue());
                if (viewFindViewById != null) {
                    Intrinsics.f(viewFindViewById, "findViewById<View>(id)");
                    if (!viewFindViewById.isClickable()) {
                        viewFindViewById.setClickable(true);
                    }
                    viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: b9.g
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            BaseQuickAdapter.s(viewHolder, this, view2);
                        }
                    });
                }
            }
        }
    }

    public final void r0(View emptyView) {
        boolean z11;
        Intrinsics.g(emptyView, "emptyView");
        int itemCount = getItemCount();
        FrameLayout frameLayout = null;
        if (this.f28841v == null) {
            FrameLayout frameLayout2 = new FrameLayout(emptyView.getContext());
            this.f28841v = frameLayout2;
            ViewGroup.LayoutParams layoutParams = emptyView.getLayoutParams();
            frameLayout2.setLayoutParams(layoutParams != null ? new ViewGroup.LayoutParams(layoutParams.width, layoutParams.height) : new ViewGroup.LayoutParams(-1, -1));
            z11 = true;
        } else {
            ViewGroup.LayoutParams layoutParams2 = emptyView.getLayoutParams();
            if (layoutParams2 != null) {
                FrameLayout frameLayout3 = this.f28841v;
                if (frameLayout3 == null) {
                    Intrinsics.y("mEmptyLayout");
                    frameLayout3 = null;
                }
                ViewGroup.LayoutParams layoutParams3 = frameLayout3.getLayoutParams();
                layoutParams3.width = layoutParams2.width;
                layoutParams3.height = layoutParams2.height;
                FrameLayout frameLayout4 = this.f28841v;
                if (frameLayout4 == null) {
                    Intrinsics.y("mEmptyLayout");
                    frameLayout4 = null;
                }
                frameLayout4.setLayoutParams(layoutParams3);
            }
            z11 = false;
        }
        FrameLayout frameLayout5 = this.f28841v;
        if (frameLayout5 == null) {
            Intrinsics.y("mEmptyLayout");
            frameLayout5 = null;
        }
        frameLayout5.removeAllViews();
        FrameLayout frameLayout6 = this.f28841v;
        if (frameLayout6 == null) {
            Intrinsics.y("mEmptyLayout");
        } else {
            frameLayout = frameLayout6;
        }
        frameLayout.addView(emptyView);
        this.f28832m = true;
        if (z11 && Z()) {
            int i11 = (this.f28830k && b0()) ? 1 : 0;
            if (getItemCount() > itemCount) {
                notifyItemInserted(i11);
            } else {
                notifyDataSetChanged();
            }
        }
    }

    public void s0(RecyclerView.a0 holder) {
        Intrinsics.g(holder, "holder");
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.b) {
            ((StaggeredGridLayoutManager.b) layoutParams).e(true);
        }
    }

    @JvmOverloads
    public final int t0(View view, int i11, int i12) {
        Intrinsics.g(view, "view");
        LinearLayout linearLayout = this.f28839t;
        if (linearLayout != null) {
            LinearLayout linearLayout2 = null;
            if (linearLayout == null) {
                Intrinsics.y("mHeaderLayout");
                linearLayout = null;
            }
            if (linearLayout.getChildCount() > i11) {
                LinearLayout linearLayout3 = this.f28839t;
                if (linearLayout3 == null) {
                    Intrinsics.y("mHeaderLayout");
                    linearLayout3 = null;
                }
                linearLayout3.removeViewAt(i11);
                LinearLayout linearLayout4 = this.f28839t;
                if (linearLayout4 == null) {
                    Intrinsics.y("mHeaderLayout");
                } else {
                    linearLayout2 = linearLayout4;
                }
                linearLayout2.addView(view, i11);
                return i11;
            }
        }
        return p(view, i11, i12);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void v() {
        if (this instanceof j) {
            this.C = ((j) this).a(this);
        }
        if (this instanceof l) {
            ((l) this).a(this);
        }
        if (this instanceof h) {
            ((h) this).a(this);
        }
    }

    public final void v0(boolean z11) {
        this.f28830k = z11;
    }

    public final void w(int i11) {
        if (this.f28829j.size() == i11) {
            notifyDataSetChanged();
        }
    }

    public void w0(Collection<? extends T> collection) {
        List<T> list = this.f28829j;
        if (collection != list) {
            list.clear();
            if (collection != null && !collection.isEmpty()) {
                this.f28829j.addAll(collection);
            }
        } else if (collection == null || collection.isEmpty()) {
            this.f28829j.clear();
        } else {
            ArrayList arrayList = new ArrayList(collection);
            this.f28829j.clear();
            this.f28829j.addAll(arrayList);
        }
        f fVar = this.C;
        if (fVar != null) {
            fVar.w();
        }
        this.f28842w = -1;
        notifyDataSetChanged();
        f fVar2 = this.C;
        if (fVar2 != null) {
            fVar2.f();
        }
    }

    public abstract void x(VH vh2, T t11);

    public void x0(List<T> list) {
        if (list == this.f28829j) {
            return;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f28829j = list;
        f fVar = this.C;
        if (fVar != null) {
            fVar.w();
        }
        this.f28842w = -1;
        notifyDataSetChanged();
        f fVar2 = this.C;
        if (fVar2 != null) {
            fVar2.f();
        }
    }

    public void y(VH holder, T t11, List<? extends Object> payloads) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(payloads, "payloads");
    }

    public void y0(View v11, int i11) {
        Intrinsics.g(v11, "v");
        f9.b bVar = this.f28845z;
        if (bVar != null) {
            bVar.a(this, v11, i11);
        }
    }

    public final VH z(Class<?> cls, View view) {
        try {
            if (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) {
                Constructor<?> declaredConstructor = cls.getDeclaredConstructor(View.class);
                Intrinsics.f(declaredConstructor, "z.getDeclaredConstructor(View::class.java)");
                declaredConstructor.setAccessible(true);
                Object objNewInstance = declaredConstructor.newInstance(view);
                Intrinsics.e(objNewInstance, "null cannot be cast to non-null type VH of com.chad.library.adapter.base.BaseQuickAdapter");
                return (VH) objNewInstance;
            }
            Constructor<?> declaredConstructor2 = cls.getDeclaredConstructor(getClass(), View.class);
            Intrinsics.f(declaredConstructor2, "z.getDeclaredConstructor…aClass, View::class.java)");
            declaredConstructor2.setAccessible(true);
            Object objNewInstance2 = declaredConstructor2.newInstance(this, view);
            Intrinsics.e(objNewInstance2, "null cannot be cast to non-null type VH of com.chad.library.adapter.base.BaseQuickAdapter");
            return (VH) objNewInstance2;
        } catch (IllegalAccessException e11) {
            e11.printStackTrace();
            return null;
        } catch (InstantiationException e12) {
            e12.printStackTrace();
            return null;
        } catch (NoSuchMethodException e13) {
            e13.printStackTrace();
            return null;
        } catch (InvocationTargetException e14) {
            e14.printStackTrace();
            return null;
        }
    }

    public final void z0(f9.b bVar) {
        this.f28845z = bVar;
    }
}
