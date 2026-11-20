package com.transsion.transfer.impl;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.d0;
import androidx.lifecycle.u;
import androidx.lifecycle.v;
import androidx.lifecycle.v0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.transfer.impl.entity.FileData;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.r;
import kotlin.collections.s;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@SourceDebugExtension
public final class TransferSentFragment extends BaseFragment<ky.i> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f58941d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f58942a = LazyKt__LazyJVMKt.b(new Function0<CopyOnWriteArrayList<FileData>>() { // from class: com.transsion.transfer.impl.TransferSentFragment$data$2
        @Override // kotlin.jvm.functions.Function0
        public final CopyOnWriteArrayList<FileData> invoke() {
            return new CopyOnWriteArrayList<>();
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f58943b = LazyKt__LazyJVMKt.b(new Function0<ly.b>() { // from class: com.transsion.transfer.impl.TransferSentFragment$mAdapter$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ly.b invoke() {
            u viewLifecycleOwner = this.this$0.getViewLifecycleOwner();
            Intrinsics.f(viewLifecycleOwner, "viewLifecycleOwner");
            return new ly.b(v.a(viewLifecycleOwner), true, this.this$0.j0());
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f58944c = LazyKt__LazyJVMKt.b(new Function0<g>() { // from class: com.transsion.transfer.impl.TransferSentFragment$serverViewModel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final g invoke() {
            FragmentActivity fragmentActivityRequireActivity = this.this$0.requireActivity();
            Intrinsics.f(fragmentActivityRequireActivity, "this.requireActivity()");
            return (g) new v0(fragmentActivityRequireActivity).a(g.class);
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TransferSentFragment a() {
            TransferSentFragment transferSentFragment = new TransferSentFragment();
            transferSentFragment.setArguments(androidx.core.os.c.a());
            return transferSentFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f58945a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f58945a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f58945a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f58945a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CopyOnWriteArrayList<FileData> j0() {
        return (CopyOnWriteArrayList) this.f58942a.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ly.b k0() {
        return (ly.b) this.f58943b.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final g l0() {
        return (g) this.f58944c.getValue();
    }

    private final void o0() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        if (j0().isEmpty()) {
            ky.i mViewBinding = getMViewBinding();
            if (mViewBinding == null || (linearLayout2 = mViewBinding.f69706c) == null) {
                return;
            }
            so.c.k(linearLayout2);
            return;
        }
        ky.i mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (linearLayout = mViewBinding2.f69706c) == null) {
            return;
        }
        so.c.g(linearLayout);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    @SuppressLint({"NotifyDataSetChanged"})
    public void initView(View view, Bundle bundle) {
        RecyclerView recyclerView;
        Intrinsics.g(view, "view");
        ky.i mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView = mViewBinding.f69705b) != null) {
            recyclerView.setItemAnimator(null);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
            recyclerView.setAdapter(k0());
        }
        l0().u().j(this, new b(new Function1<Pair<? extends String, ? extends List<FileData>>, Unit>() { // from class: com.transsion.transfer.impl.TransferSentFragment.initView.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends String, ? extends List<FileData>> pair) {
                invoke2((Pair<String, ? extends List<FileData>>) pair);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<String, ? extends List<FileData>> pair) {
                py.b.f74066a.q(pair.getSecond().size(), TransferSentFragment.this.l0().t());
            }
        }));
        l0().v().j(this, new b(new Function1<Triple<? extends String, ? extends String, ? extends Triple<? extends TaskState, ? extends Long, ? extends Long>>, Unit>() { // from class: com.transsion.transfer.impl.TransferSentFragment.initView.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Triple<? extends String, ? extends String, ? extends Triple<? extends TaskState, ? extends Long, ? extends Long>> triple) {
                invoke2((Triple<String, String, ? extends Triple<? extends TaskState, Long, Long>>) triple);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Triple<String, String, ? extends Triple<? extends TaskState, Long, Long>> triple) {
                Object next;
                Iterator<T> it = ry.b.f75768a.d().iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.b(triple.getSecond(), ((FileData) next).getFileRemotePath()));
                FileData fileData = (FileData) next;
                if (fileData != null) {
                    TransferSentFragment.this.k0().N0(triple.getSecond(), fileData);
                }
            }
        }));
        l0().o().j(this, new b(new Function1<Pair<? extends String, ? extends Boolean>, Unit>() { // from class: com.transsion.transfer.impl.TransferSentFragment.initView.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends String, ? extends Boolean> pair) {
                invoke2((Pair<String, Boolean>) pair);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<String, Boolean> pair) {
                if (pair.getSecond().booleanValue()) {
                    return;
                }
                TransferSentFragment.this.k0().M0();
            }
        }));
        o0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    @SuppressLint({"NotifyDataSetChanged"})
    public void lazyLoadData() {
        j0().addAll(ry.b.f75768a.d());
        k0().notifyDataSetChanged();
        o0();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public ky.i getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        ky.i iVarC = ky.i.c(inflater);
        Intrinsics.f(iVarC, "inflate(inflater)");
        return iVarC;
    }

    public final void n0() {
        List<FileData> listD = ry.b.f75768a.d();
        if (!listD.isEmpty()) {
            List<FileData> listD2 = k0().D();
            LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.a.d(r.e(kotlin.collections.h.v(listD2, 10)), 16));
            for (Object obj : listD2) {
                linkedHashMap.put(((FileData) obj).getFileRemotePath(), obj);
            }
            List<FileData> list = listD;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(kotlin.ranges.a.d(r.e(kotlin.collections.h.v(list, 10)), 16));
            for (Object obj2 : list) {
                linkedHashMap2.put(((FileData) obj2).getFileRemotePath(), obj2);
            }
            List listJ0 = CollectionsKt___CollectionsKt.J0(s.n(linkedHashMap, linkedHashMap2).values());
            j0().clear();
            j0().addAll(CollectionsKt___CollectionsKt.M0(listJ0));
            k0().notifyDataSetChanged();
        }
        o0();
    }
}
