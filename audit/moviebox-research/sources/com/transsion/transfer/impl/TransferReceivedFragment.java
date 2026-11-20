package com.transsion.transfer.impl;

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
import kotlin.jvm.functions.Function2;
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
public final class TransferReceivedFragment extends BaseFragment<ky.h> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f58936d = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f58937a = LazyKt__LazyJVMKt.b(new Function0<ClientViewModel>() { // from class: com.transsion.transfer.impl.TransferReceivedFragment$clientViewModel$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ClientViewModel invoke() {
            FragmentActivity fragmentActivityRequireActivity = this.this$0.requireActivity();
            Intrinsics.f(fragmentActivityRequireActivity, "this.requireActivity()");
            return (ClientViewModel) new v0(fragmentActivityRequireActivity).a(ClientViewModel.class);
        }
    });

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f58938b = LazyKt__LazyJVMKt.b(new Function0<CopyOnWriteArrayList<FileData>>() { // from class: com.transsion.transfer.impl.TransferReceivedFragment$data$2
        @Override // kotlin.jvm.functions.Function0
        public final CopyOnWriteArrayList<FileData> invoke() {
            return new CopyOnWriteArrayList<>();
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f58939c = LazyKt__LazyJVMKt.b(new Function0<ly.b>() { // from class: com.transsion.transfer.impl.TransferReceivedFragment$mAdapter$2
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final ly.b invoke() {
            u viewLifecycleOwner = this.this$0.getViewLifecycleOwner();
            Intrinsics.f(viewLifecycleOwner, "viewLifecycleOwner");
            ly.b bVar = new ly.b(v.a(viewLifecycleOwner), false, this.this$0.l0());
            final TransferReceivedFragment transferReceivedFragment = this.this$0;
            bVar.O0(new Function1<FileData, Unit>() { // from class: com.transsion.transfer.impl.TransferReceivedFragment$mAdapter$2$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FileData fileData) {
                    invoke2(fileData);
                    return Unit.f68710a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(FileData it) {
                    Intrinsics.g(it, "it");
                    transferReceivedFragment.k0().t(it);
                }
            });
            return bVar;
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

        public final TransferReceivedFragment a() {
            TransferReceivedFragment transferReceivedFragment = new TransferReceivedFragment();
            transferReceivedFragment.setArguments(androidx.core.os.c.a());
            return transferReceivedFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f58940a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f58940a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f58940a;
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
            this.f58940a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClientViewModel k0() {
        return (ClientViewModel) this.f58937a.getValue();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        RecyclerView recyclerView;
        Intrinsics.g(view, "view");
        ky.h mViewBinding = getMViewBinding();
        if (mViewBinding != null && (recyclerView = mViewBinding.f69702b) != null) {
            recyclerView.setItemAnimator(null);
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext(), 1, false));
            recyclerView.setAdapter(m0());
        }
        k0().p().j(this, new b(new Function1<List<FileData>, Unit>() { // from class: com.transsion.transfer.impl.TransferReceivedFragment.initView.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<FileData> list) {
                invoke2(list);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<FileData> list) {
                List<FileData> list2 = list;
                if (list2 != null && !list2.isEmpty()) {
                    List<FileData> listD = TransferReceivedFragment.this.m0().D();
                    LinkedHashMap linkedHashMap = new LinkedHashMap(kotlin.ranges.a.d(r.e(kotlin.collections.h.v(listD, 10)), 16));
                    for (Object obj : listD) {
                        linkedHashMap.put(((FileData) obj).getFileRemotePath(), obj);
                    }
                    List<FileData> list3 = list;
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap(kotlin.ranges.a.d(r.e(kotlin.collections.h.v(list3, 10)), 16));
                    for (Object obj2 : list3) {
                        linkedHashMap2.put(((FileData) obj2).getFileRemotePath(), obj2);
                    }
                    List listJ0 = CollectionsKt___CollectionsKt.J0(s.n(linkedHashMap, linkedHashMap2).values());
                    TransferReceivedFragment.this.l0().clear();
                    List list4 = listJ0;
                    TransferReceivedFragment.this.l0().addAll(CollectionsKt___CollectionsKt.M0(list4));
                    TransferReceivedFragment.this.m0().notifyDataSetChanged();
                    TransferReceivedFragment.this.k0().w(CollectionsKt___CollectionsKt.M0(list4));
                }
                TransferReceivedFragment.this.r0();
            }
        }));
        k0().q().j(this, new b(new Function1<Pair<? extends String, ? extends Triple<? extends TaskState, ? extends Long, ? extends Long>>, Unit>() { // from class: com.transsion.transfer.impl.TransferReceivedFragment.initView.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends String, ? extends Triple<? extends TaskState, ? extends Long, ? extends Long>> pair) {
                invoke2((Pair<String, ? extends Triple<? extends TaskState, Long, Long>>) pair);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<String, ? extends Triple<? extends TaskState, Long, Long>> pair) {
                Object next;
                Iterator<T> it = ry.a.f75766a.d().iterator();
                do {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                } while (!Intrinsics.b(((FileData) next).getFileRemotePath(), pair.getFirst()));
                FileData fileData = (FileData) next;
                if (fileData != null) {
                    TransferReceivedFragment.this.m0().N0(pair.getFirst(), fileData);
                }
            }
        }));
        r0();
    }

    public final CopyOnWriteArrayList<FileData> l0() {
        return (CopyOnWriteArrayList) this.f58938b.getValue();
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        if (k0().s()) {
            k0().o(false);
        } else {
            k0().h(new Function2<Boolean, String, Unit>() { // from class: com.transsion.transfer.impl.TransferReceivedFragment.lazyLoadData.1
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str) {
                    invoke(bool.booleanValue(), str);
                    return Unit.f68710a;
                }

                public final void invoke(boolean z11, String error) {
                    Intrinsics.g(error, "error");
                    if (z11) {
                        TransferReceivedFragment.this.k0().o(false);
                    }
                }
            });
        }
    }

    public final ly.b m0() {
        return (ly.b) this.f58939c.getValue();
    }

    public final void n0() {
        k0().o(true);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public ky.h getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        ky.h hVarC = ky.h.c(inflater);
        Intrinsics.f(hVarC, "inflate(inflater)");
        return hVarC;
    }

    public final void p0() {
        m0().M0();
    }

    public final void q0() {
        List<FileData> listD = ry.a.f75766a.d();
        if (!listD.isEmpty()) {
            List<FileData> listD2 = m0().D();
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
            l0().clear();
            l0().addAll(CollectionsKt___CollectionsKt.M0(listJ0));
            m0().notifyDataSetChanged();
        }
        r0();
    }

    public final void r0() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        if (l0().isEmpty()) {
            ky.h mViewBinding = getMViewBinding();
            if (mViewBinding == null || (linearLayout2 = mViewBinding.f69703c) == null) {
                return;
            }
            so.c.k(linearLayout2);
            return;
        }
        ky.h mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (linearLayout = mViewBinding2.f69703c) == null) {
            return;
        }
        so.c.g(linearLayout);
    }
}
