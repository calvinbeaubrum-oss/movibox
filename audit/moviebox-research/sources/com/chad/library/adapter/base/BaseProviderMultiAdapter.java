package com.chad.library.adapter.base;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
@Metadata
@SourceDebugExtension
public abstract class BaseProviderMultiAdapter<T> extends BaseQuickAdapter<T, BaseViewHolder> {
    public final Lazy H;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseProviderMultiAdapter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public BaseProviderMultiAdapter(List<T> list) {
        super(0, list);
        this.H = LazyKt__LazyJVMKt.a(LazyThreadSafetyMode.NONE, new Function0<SparseArray<BaseItemProvider<T>>>() { // from class: com.chad.library.adapter.base.BaseProviderMultiAdapter$mItemProviders$2
            @Override // kotlin.jvm.functions.Function0
            public final SparseArray<BaseItemProvider<T>> invoke() {
                return new SparseArray<>();
            }
        });
    }

    public /* synthetic */ BaseProviderMultiAdapter(List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : list);
    }

    public static final void M0(BaseViewHolder viewHolder, BaseProviderMultiAdapter this$0, BaseItemProvider provider, View v11) {
        Intrinsics.g(viewHolder, "$viewHolder");
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(provider, "$provider");
        int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return;
        }
        int iK = bindingAdapterPosition - this$0.K();
        Intrinsics.f(v11, "v");
        provider.k(viewHolder, v11, this$0.D().get(iK), iK);
    }

    public static final boolean N0(BaseViewHolder viewHolder, BaseProviderMultiAdapter this$0, BaseItemProvider provider, View v11) {
        Intrinsics.g(viewHolder, "$viewHolder");
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(provider, "$provider");
        int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return false;
        }
        int iK = bindingAdapterPosition - this$0.K();
        Intrinsics.f(v11, "v");
        return provider.l(viewHolder, v11, this$0.D().get(iK), iK);
    }

    public static final void P0(BaseViewHolder viewHolder, BaseProviderMultiAdapter this$0, View it) {
        Intrinsics.g(viewHolder, "$viewHolder");
        Intrinsics.g(this$0, "this$0");
        int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return;
        }
        int iK = bindingAdapterPosition - this$0.K();
        BaseItemProvider<T> baseItemProvider = this$0.T0().get(viewHolder.getItemViewType());
        Intrinsics.f(it, "it");
        baseItemProvider.m(viewHolder, it, this$0.D().get(iK), iK);
    }

    public static final boolean Q0(BaseViewHolder viewHolder, BaseProviderMultiAdapter this$0, View it) {
        Intrinsics.g(viewHolder, "$viewHolder");
        Intrinsics.g(this$0, "this$0");
        int bindingAdapterPosition = viewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return false;
        }
        int iK = bindingAdapterPosition - this$0.K();
        BaseItemProvider<T> baseItemProvider = this$0.T0().get(viewHolder.getItemViewType());
        Intrinsics.f(it, "it");
        return baseItemProvider.o(viewHolder, it, this$0.D().get(iK), iK);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public int F(int i11) {
        return S0(D(), i11);
    }

    public void K0(BaseItemProvider<T> provider) {
        Intrinsics.g(provider, "provider");
        provider.s(this);
        T0().put(provider.h(), provider);
    }

    public void L0(final BaseViewHolder viewHolder, int i11) {
        Intrinsics.g(viewHolder, "viewHolder");
        if (S() == null) {
            final BaseItemProvider<T> baseItemProviderR0 = R0(i11);
            if (baseItemProviderR0 == null) {
                return;
            }
            Iterator<T> it = baseItemProviderR0.d().iterator();
            while (it.hasNext()) {
                View viewFindViewById = viewHolder.itemView.findViewById(((Number) it.next()).intValue());
                if (viewFindViewById != null) {
                    Intrinsics.f(viewFindViewById, "findViewById<View>(id)");
                    if (!viewFindViewById.isClickable()) {
                        viewFindViewById.setClickable(true);
                    }
                    viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: b9.a
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            BaseProviderMultiAdapter.M0(viewHolder, this, baseItemProviderR0, view);
                        }
                    });
                }
            }
        }
        T();
        final BaseItemProvider<T> baseItemProviderR1 = R0(i11);
        if (baseItemProviderR1 == null) {
            return;
        }
        Iterator<T> it2 = baseItemProviderR1.e().iterator();
        while (it2.hasNext()) {
            View viewFindViewById2 = viewHolder.itemView.findViewById(((Number) it2.next()).intValue());
            if (viewFindViewById2 != null) {
                Intrinsics.f(viewFindViewById2, "findViewById<View>(id)");
                if (!viewFindViewById2.isLongClickable()) {
                    viewFindViewById2.setLongClickable(true);
                }
                viewFindViewById2.setOnLongClickListener(new View.OnLongClickListener() { // from class: b9.b
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view) {
                        return BaseProviderMultiAdapter.N0(viewHolder, this, baseItemProviderR1, view);
                    }
                });
            }
        }
    }

    public void O0(final BaseViewHolder viewHolder) {
        Intrinsics.g(viewHolder, "viewHolder");
        if (U() == null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: b9.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    BaseProviderMultiAdapter.P0(viewHolder, this, view);
                }
            });
        }
        if (V() == null) {
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: b9.d
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return BaseProviderMultiAdapter.Q0(viewHolder, this, view);
                }
            });
        }
    }

    public BaseItemProvider<T> R0(int i11) {
        return T0().get(i11);
    }

    public abstract int S0(List<? extends T> list, int i11);

    public final SparseArray<BaseItemProvider<T>> T0() {
        return (SparseArray) this.H.getValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: U0, reason: merged with bridge method [inline-methods] */
    public void onViewDetachedFromWindow(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        super.onViewDetachedFromWindow(holder);
        BaseItemProvider<T> baseItemProviderR0 = R0(holder.getItemViewType());
        if (baseItemProviderR0 != null) {
            baseItemProviderR0.q(holder);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public BaseViewHolder f0(ViewGroup parent, int i11) {
        Intrinsics.g(parent, "parent");
        BaseItemProvider<T> baseItemProviderR0 = R0(i11);
        if (baseItemProviderR0 == null) {
            throw new IllegalStateException(("ViewType: " + i11 + " no such provider found，please use addItemProvider() first!").toString());
        }
        Context context = parent.getContext();
        Intrinsics.f(context, "parent.context");
        baseItemProviderR0.t(context);
        BaseViewHolder baseViewHolderN = baseItemProviderR0.n(parent, i11);
        baseItemProviderR0.r(baseViewHolderN, i11);
        return baseViewHolderN;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(BaseViewHolder holder) {
        Intrinsics.g(holder, "holder");
        super.onViewAttachedToWindow(holder);
        BaseItemProvider<T> baseItemProviderR0 = R0(holder.getItemViewType());
        if (baseItemProviderR0 != null) {
            baseItemProviderR0.p(holder);
        }
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void r(BaseViewHolder viewHolder, int i11) {
        Intrinsics.g(viewHolder, "viewHolder");
        super.r(viewHolder, i11);
        O0(viewHolder);
        L0(viewHolder, i11);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void x(BaseViewHolder holder, T t11) {
        Intrinsics.g(holder, "holder");
        BaseItemProvider<T> baseItemProviderR0 = R0(holder.getItemViewType());
        Intrinsics.d(baseItemProviderR0);
        baseItemProviderR0.a(holder, t11);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void y(BaseViewHolder holder, T t11, List<? extends Object> payloads) {
        Intrinsics.g(holder, "holder");
        Intrinsics.g(payloads, "payloads");
        BaseItemProvider<T> baseItemProviderR0 = R0(holder.getItemViewType());
        Intrinsics.d(baseItemProviderR0);
        baseItemProviderR0.b(holder, t11, payloads);
    }
}
