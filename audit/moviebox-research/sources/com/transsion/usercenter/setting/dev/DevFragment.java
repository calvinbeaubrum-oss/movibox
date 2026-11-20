package com.transsion.usercenter.setting.dev;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.d0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.transsion.baseui.fragment.BaseListFragment;
import java.util.List;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class DevFragment extends BaseListFragment<String> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f59674p;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f59677s;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f59675q = 10;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f59676r = "ID:001";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final Lazy f59678t = LazyKt__LazyJVMKt.b(new Function0<DevViewModel>() { // from class: com.transsion.usercenter.setting.dev.DevFragment$mViewModel$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final DevViewModel invoke() {
            return new DevViewModel();
        }
    });

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements d0, FunctionAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function1 f59679a;

        public a(Function1 function) {
            Intrinsics.g(function, "function");
            this.f59679a = function;
        }

        @Override // kotlin.jvm.internal.FunctionAdapter
        public final Function<?> a() {
            return this.f59679a;
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
            this.f59679a.invoke(obj);
        }
    }

    public static final void B1(DevFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        this$0.A1().c(this$0.f59674p, this$0.f59675q, this$0.f59676r);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean A0() {
        return true;
    }

    public final DevViewModel A1() {
        return (DevViewModel) this.f59678t.getValue();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        zp.b.f82110a.e("联网重试");
        lazyLoadData();
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public BaseQuickAdapter<String, BaseViewHolder> T0() {
        return new b();
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public String Z0() {
        return "我是标题";
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void i1() {
        lazyLoadData();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        A1().b().j(this, new a(new Function1<List<String>, Unit>() { // from class: com.transsion.usercenter.setting.dev.DevFragment.initViewModel.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<String> list) {
                invoke2(list);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<String> list) {
                List<String> listD;
                List<String> listD2;
                DevFragment.this.i0(false);
                if (DevFragment.this.f59677s) {
                    BaseListFragment.s1(DevFragment.this, null, 1, null);
                    DevFragment.this.q1(false);
                    return;
                }
                DevFragment.this.f59674p++;
                if (DevFragment.this.h1()) {
                    if (list == null) {
                        BaseListFragment.s1(DevFragment.this, null, 1, null);
                    } else {
                        BaseQuickAdapter<String, BaseViewHolder> baseQuickAdapterW0 = DevFragment.this.W0();
                        if (baseQuickAdapterW0 != null) {
                            baseQuickAdapterW0.w0(list);
                        }
                    }
                    DevFragment.this.q1(false);
                    return;
                }
                if (list == null) {
                    DevFragment.this.m1();
                    return;
                }
                BaseQuickAdapter<String, BaseViewHolder> baseQuickAdapterW1 = DevFragment.this.W0();
                if (baseQuickAdapterW1 != null && (listD2 = baseQuickAdapterW1.D()) != null && listD2.size() > 20) {
                    DevFragment.this.m1();
                    return;
                }
                BaseQuickAdapter<String, BaseViewHolder> baseQuickAdapterW2 = DevFragment.this.W0();
                if (baseQuickAdapterW2 != null && (listD = baseQuickAdapterW2.D()) != null && listD.size() > 30) {
                    BaseListFragment.l1(DevFragment.this, false, 1, null);
                    return;
                }
                BaseQuickAdapter<String, BaseViewHolder> baseQuickAdapterW3 = DevFragment.this.W0();
                if (baseQuickAdapterW3 != null) {
                    baseQuickAdapterW3.m(list);
                }
                DevFragment.this.j1();
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
        ConstraintLayout root;
        BaseListFragment.u1(this, null, 1, null);
        fs.a aVar = (fs.a) getMViewBinding();
        if (aVar == null || (root = aVar.getRoot()) == null) {
            return;
        }
        root.postDelayed(new Runnable() { // from class: com.transsion.usercenter.setting.dev.a
            @Override // java.lang.Runnable
            public final void run() {
                DevFragment.B1(this.f59681a);
            }
        }, 3000L);
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void o1() {
        this.f59674p = 0;
        lazyLoadData();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "无网络、无数据的时候展示的标题";
    }
}
