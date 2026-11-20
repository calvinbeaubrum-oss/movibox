package com.transsion.room.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.v0;
import androidx.lifecycle.x0;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsion.baseui.fragment.LazyFragment;
import com.transsion.moviedetailapi.bean.RoomFilter;
import com.transsion.moviedetailapi.bean.RoomFilterClasses;
import com.transsion.room.R$id;
import com.transsion.room.R$layout;
import com.transsion.room.adapter.RoomFilterTabListAdapter;
import com.transsion.room.viewmodel.RoomViewModel;
import com.transsion.usercenter.R$string;
import java.util.Iterator;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
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
public final class RoomFilterListFragment extends LazyFragment<sw.k> {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final a f57175t = new a(null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public RoomFilterTabListAdapter f57176o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f57177p = FragmentViewModelLazyKt.a(this, Reflection.b(RoomViewModel.class), new Function0<x0>() { // from class: com.transsion.room.fragment.RoomFilterListFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final x0 invoke() {
            x0 viewModelStore = this.requireActivity().getViewModelStore();
            Intrinsics.f(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<v0.c>() { // from class: com.transsion.room.fragment.RoomFilterListFragment$special$$inlined$activityViewModels$default$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final v0.c invoke() {
            v0.c defaultViewModelProviderFactory = this.requireActivity().getDefaultViewModelProviderFactory();
            Intrinsics.f(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Integer f57178q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f57179r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public View f57180s;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RoomFilterListFragment a(boolean z11) {
            RoomFilterListFragment roomFilterListFragment = new RoomFilterListFragment();
            roomFilterListFragment.setArguments(androidx.core.os.c.b(TuplesKt.a("is_select_room", Boolean.valueOf(z11))));
            return roomFilterListFragment;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b implements androidx.lifecycle.d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f57181a;

        public b(Function1 function) {
            Intrinsics.g(function, "function");
            this.f57181a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f57181a;
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof androidx.lifecycle.d0) && (obj instanceof FunctionAdapter)) {
                return Intrinsics.b(a(), ((FunctionAdapter) obj).a());
            }
            return false;
        }

        public final int hashCode() {
            return a().hashCode();
        }

        @Override // androidx.lifecycle.d0
        public final /* synthetic */ void onChanged(Object obj) {
            this.f57181a.invoke(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X0() {
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            G0(false);
        } else {
            L0(false);
        }
    }

    private final RoomViewModel Z0() {
        return (RoomViewModel) this.f57177p.getValue();
    }

    public static final void c1(RoomFilterListFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        if (com.transsion.baseui.util.c.f51452a.a(view.getId(), 500L)) {
            return;
        }
        Object item = adapter.getItem(i11);
        Intrinsics.e(item, "null cannot be cast to non-null type com.transsion.moviedetailapi.bean.RoomFilter");
        this$0.e1((RoomFilter) item);
    }

    private final void d1() {
        Z0().w();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean A0() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        d1();
    }

    public final Fragment Y0(Integer num) {
        return RoomListFragment.J.a(num, this.f57179r);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    /* JADX INFO: renamed from: a1, reason: merged with bridge method [inline-methods] */
    public sw.k getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        sw.k kVarC = sw.k.c(inflater);
        Intrinsics.f(kVarC, "inflate(inflater)");
        return kVarC;
    }

    public final void b1() {
        List<Fragment> fragments = getChildFragmentManager().getFragments();
        Intrinsics.f(fragments, "childFragmentManager.fragments");
        Iterator<Fragment> it = fragments.iterator();
        while (it.hasNext()) {
            getChildFragmentManager().beginTransaction().hide(it.next()).commitNowAllowingStateLoss();
        }
    }

    public final void e1(RoomFilter roomFilter) {
        if (Intrinsics.b(this.f57178q, roomFilter.getCid())) {
            return;
        }
        f1(roomFilter);
        this.f57178q = roomFilter.getCid();
        g1(roomFilter);
    }

    public final void f1(RoomFilter roomFilter) {
        int i11;
        List<RoomFilter> listD;
        RoomFilter roomFilter2;
        List<RoomFilter> listD2;
        Object next;
        List<RoomFilter> listD3;
        List<RoomFilter> listD4;
        RoomFilterTabListAdapter roomFilterTabListAdapter = this.f57176o;
        int i12 = -1;
        if (roomFilterTabListAdapter == null || (listD4 = roomFilterTabListAdapter.D()) == null) {
            i11 = -1;
            break;
        }
        Iterator<RoomFilter> it = listD4.iterator();
        i11 = 0;
        while (true) {
            if (!it.hasNext()) {
                i11 = -1;
                break;
            } else if (Intrinsics.b(this.f57178q, it.next().getCid())) {
                break;
            } else {
                i11++;
            }
        }
        RoomFilterTabListAdapter roomFilterTabListAdapter2 = this.f57176o;
        if (roomFilterTabListAdapter2 != null && (listD3 = roomFilterTabListAdapter2.D()) != null) {
            Iterator<RoomFilter> it2 = listD3.iterator();
            int i13 = 0;
            while (it2.hasNext()) {
                if (Intrinsics.b(roomFilter.getCid(), it2.next().getCid())) {
                    i12 = i13;
                    break;
                }
                i13++;
            }
        }
        RoomFilter roomFilter3 = null;
        Object obj = null;
        roomFilter3 = null;
        if (i11 >= 0) {
            RoomFilterTabListAdapter roomFilterTabListAdapter3 = this.f57176o;
            if (roomFilterTabListAdapter3 == null || (listD2 = roomFilterTabListAdapter3.D()) == null) {
                roomFilter2 = null;
            } else {
                Iterator<T> it3 = listD2.iterator();
                do {
                    if (!it3.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it3.next();
                } while (!Intrinsics.b(this.f57178q, ((RoomFilter) next).getCid()));
                roomFilter2 = (RoomFilter) next;
            }
            if (roomFilter2 != null) {
                roomFilter2.setSelected(false);
            }
            RoomFilterTabListAdapter roomFilterTabListAdapter4 = this.f57176o;
            if (roomFilterTabListAdapter4 != null) {
                roomFilterTabListAdapter4.notifyItemChanged(i11, Boolean.FALSE);
            }
        }
        if (i12 >= 0) {
            RoomFilterTabListAdapter roomFilterTabListAdapter5 = this.f57176o;
            if (roomFilterTabListAdapter5 != null && (listD = roomFilterTabListAdapter5.D()) != null) {
                for (Object obj2 : listD) {
                    if (Intrinsics.b(roomFilter.getCid(), ((RoomFilter) obj2).getCid())) {
                        obj = obj2;
                        break;
                    }
                }
                roomFilter3 = (RoomFilter) obj;
            }
            if (roomFilter3 != null) {
                roomFilter3.setSelected(true);
            }
            RoomFilterTabListAdapter roomFilterTabListAdapter6 = this.f57176o;
            if (roomFilterTabListAdapter6 != null) {
                roomFilterTabListAdapter6.notifyItemChanged(i12, Boolean.TRUE);
            }
        }
    }

    public final void g1(RoomFilter roomFilter) {
        String str = roomFilter.getTitle() + roomFilter.getCid();
        uo.b.a.f(uo.b.f78622a, "RoomFilter", "showFragment tag = " + str, false, 4, null);
        b1();
        Fragment fragmentFindFragmentByTag = getChildFragmentManager().findFragmentByTag(str);
        if (fragmentFindFragmentByTag == null) {
            fragmentFindFragmentByTag = Y0(roomFilter.getCid());
        }
        if (fragmentFindFragmentByTag.isAdded()) {
            getChildFragmentManager().beginTransaction().show(fragmentFindFragmentByTag).commitNowAllowingStateLoss();
        } else {
            getChildFragmentManager().beginTransaction().add(R$id.fl_container, fragmentFindFragmentByTag, str).commitNowAllowingStateLoss();
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        Z0().y().j(this, new b(new Function1<RoomFilterClasses, Unit>() { // from class: com.transsion.room.fragment.RoomFilterListFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RoomFilterClasses roomFilterClasses) {
                invoke2(roomFilterClasses);
                return Unit.f68710a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(RoomFilterClasses roomFilterClasses) {
                List<RoomFilter> classes;
                RecyclerView recyclerView;
                Integer cid;
                if (roomFilterClasses == null || (classes = roomFilterClasses.getClasses()) == null || classes.isEmpty()) {
                    RoomFilterListFragment.this.X0();
                    return;
                }
                List<RoomFilter> classes2 = roomFilterClasses.getClasses();
                Intrinsics.d(classes2);
                for (RoomFilter roomFilter : classes2) {
                    if ((RoomFilterListFragment.this.f57178q != null && Intrinsics.b(RoomFilterListFragment.this.f57178q, roomFilter.getCid())) || ((roomFilterClasses.getDefCid() != null && Intrinsics.b(roomFilter.getCid(), roomFilterClasses.getDefCid())) || ((cid = roomFilter.getCid()) != null && cid.intValue() == -1))) {
                        roomFilter.setSelected(true);
                        RoomFilterListFragment.this.f57178q = roomFilter.getCid();
                        RoomFilterListFragment.this.g1(roomFilter);
                        break;
                    }
                }
                RoomFilterListFragment.this.F0();
                sw.k kVar = (sw.k) RoomFilterListFragment.this.getMViewBinding();
                if (kVar != null && (recyclerView = kVar.f76549c) != null) {
                    so.c.k(recyclerView);
                }
                RoomFilterTabListAdapter roomFilterTabListAdapter = RoomFilterListFragment.this.f57176o;
                if (roomFilterTabListAdapter != null) {
                    roomFilterTabListAdapter.w0(roomFilterClasses.getClasses());
                }
            }
        }));
        if (com.tn.lib.util.networkinfo.f.f49475a.e()) {
            return;
        }
        M0(false);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String k0() {
        String string = getString(R$string.profile_not_content);
        Intrinsics.f(string, "getString(com.transsion.…ring.profile_not_content)");
        return string;
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
        K0();
        d1();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h("room_list", false, 2, null);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public View p0() {
        if (this.f57180s == null) {
            this.f57180s = LayoutInflater.from(requireContext()).inflate(R$layout.layout_room_list_filter_loading, (ViewGroup) o0(), false);
        }
        return this.f57180s;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        RecyclerView recyclerView;
        Bundle arguments = getArguments();
        this.f57179r = arguments != null ? arguments.getBoolean("is_select_room") : false;
        RoomFilterTabListAdapter roomFilterTabListAdapter = new RoomFilterTabListAdapter();
        roomFilterTabListAdapter.B0(new f9.d() { // from class: com.transsion.room.fragment.u
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                RoomFilterListFragment.c1(this.f57276a, baseQuickAdapter, view, i11);
            }
        });
        this.f57176o = roomFilterTabListAdapter;
        sw.k kVar = (sw.k) getMViewBinding();
        if (kVar == null || (recyclerView = kVar.f76549c) == null) {
            return;
        }
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(requireContext()));
        recyclerView.setAdapter(this.f57176o);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean x0() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean y0() {
        return false;
    }
}
