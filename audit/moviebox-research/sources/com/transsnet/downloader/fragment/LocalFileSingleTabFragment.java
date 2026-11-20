package com.transsnet.downloader.fragment;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.tn.lib.view.TitleLayout;
import com.tn.lib.view.layoutmanager.NpaLinearLayoutManager;
import com.transsnet.downloader.R$id;
import com.transsnet.downloader.R$string;
import com.transsnet.downloader.bean.HistoricalPlayRecordMultipleEntity;
import java.util.Locale;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes8.dex */
@Deprecated
@Metadata
public final class LocalFileSingleTabFragment extends LocalFileBaseFragment {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final a f60847u = new a(null);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String f60848s = "";

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f60849t;

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class b extends RecyclerView.l {
        @Override // androidx.recyclerview.widget.RecyclerView.l
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.x state) {
            Intrinsics.g(outRect, "outRect");
            Intrinsics.g(view, "view");
            Intrinsics.g(parent, "parent");
            Intrinsics.g(state, "state");
            super.getItemOffsets(outRect, view, parent, state);
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            if (parent.getAdapter() == null || childAdapterPosition != 0) {
                return;
            }
            outRect.top = com.blankj.utilcode.util.f0.a(12.0f);
        }
    }

    /* JADX INFO: renamed from: com.transsnet.downloader.fragment.LocalFileSingleTabFragment$initViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsnet.downloader.fragment.LocalFileSingleTabFragment$initViewModel$1", f = "LocalFileSingleTabFragment.kt", l = {95}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LocalFileSingleTabFragment.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                kotlinx.coroutines.flow.v0<Integer> v0VarC = LocalFileSingleTabFragment.this.h1().C();
                final LocalFileSingleTabFragment localFileSingleTabFragment = LocalFileSingleTabFragment.this;
                kotlinx.coroutines.flow.b<? super Integer> bVar = new kotlinx.coroutines.flow.b() { // from class: com.transsnet.downloader.fragment.LocalFileSingleTabFragment.initViewModel.1.1

                    /* JADX INFO: renamed from: com.transsnet.downloader.fragment.LocalFileSingleTabFragment$initViewModel$1$1$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: source.java */
                    @Metadata
                    @DebugMetadata(c = "com.transsnet.downloader.fragment.LocalFileSingleTabFragment$initViewModel$1$1$1", f = "LocalFileSingleTabFragment.kt", l = {}, m = "invokeSuspend")
                    public static final class C06231 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
                        final /* synthetic */ int $it;
                        int label;
                        final /* synthetic */ LocalFileSingleTabFragment this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public C06231(int i11, LocalFileSingleTabFragment localFileSingleTabFragment, Continuation<? super C06231> continuation) {
                            super(2, continuation);
                            this.$it = i11;
                            this.this$0 = localFileSingleTabFragment;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C06231(this.$it, this.this$0, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
                            return ((C06231) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) throws Throwable {
                            kotlin.coroutines.intrinsics.a.e();
                            if (this.label != 0) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.b(obj);
                            int i11 = this.$it;
                            if (i11 >= 0) {
                                com.transsnet.downloader.adapter.a aVarG1 = this.this$0.g1();
                                if (aVarG1 != null) {
                                    aVarG1.notifyItemChanged(this.$it);
                                }
                                com.transsnet.downloader.viewmodel.c.f61276a.x("刷新UI index = " + this.$it);
                            } else {
                                com.transsnet.downloader.viewmodel.c.f61276a.x(" 异常  index = " + i11);
                            }
                            return Unit.f68710a;
                        }
                    }

                    public final Object a(int i12, Continuation<? super Unit> continuation) {
                        Object objG = kotlinx.coroutines.h.g(kotlinx.coroutines.w0.c(), new C06231(i12, localFileSingleTabFragment, null), continuation);
                        return objG == kotlin.coroutines.intrinsics.a.e() ? objG : Unit.f68710a;
                    }

                    @Override // kotlinx.coroutines.flow.b
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return a(((Number) obj2).intValue(), continuation);
                    }
                };
                this.label = 1;
                if (v0VarC.a(bVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            throw new KotlinNothingValueException();
        }
    }

    public static final void E1(LocalFileSingleTabFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        this$0.r1(adapter, view, i11);
    }

    public static final void F1(LocalFileSingleTabFragment this$0, BaseQuickAdapter adapter, View view, int i11) {
        Intrinsics.g(this$0, "this$0");
        Intrinsics.g(adapter, "adapter");
        Intrinsics.g(view, "view");
        Object obj = adapter.D().get(i11);
        this$0.s1(obj instanceof HistoricalPlayRecordMultipleEntity ? (HistoricalPlayRecordMultipleEntity) obj : null, i11, this$0.f60849t);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void D0() {
        super.D0();
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("extra_download_out_file_tab_name") : null;
        if (string == null) {
            string = "";
        }
        this.f60848s = string;
        Bundle arguments2 = getArguments();
        this.f60849t = arguments2 != null ? arguments2.getInt("extra_position") : 0;
    }

    @Override // com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment
    public String getPageName() {
        String lowerCase = this.f60848s.toLowerCase(Locale.ROOT);
        Intrinsics.f(lowerCase, "toLowerCase(...)");
        return "file_manager_tab_" + lowerCase;
    }

    @Override // com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        kotlinx.coroutines.j.d(androidx.lifecycle.v.a(this), null, null, new AnonymousClass1(null), 3, null);
    }

    @Override // com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment, com.transsion.baseui.fragment.PageStatusFragment
    public String k0() {
        String string = getString(R$string.download_no_local_file_tips_2);
        Intrinsics.f(string, "getString(R.string.download_no_local_file_tips_2)");
        return string;
    }

    @Override // com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment, com.transsion.baseui.fragment.PageStatusFragment
    public com.transsion.baselib.report.h newLogViewConfig() {
        return new com.transsion.baselib.report.h(getPageName(), false, 2, null);
    }

    @Override // com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment
    public boolean p1() {
        return true;
    }

    @Override // com.transsnet.downloader.fragment.LocalFileBaseFragment, com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        RecyclerView recyclerView;
        h00.t mViewBinding = getMViewBinding();
        TitleLayout titleLayout = mViewBinding != null ? mViewBinding.f66029d : null;
        if (titleLayout != null) {
            titleLayout.setVisibility(8);
        }
        com.transsnet.downloader.adapter.a aVarG1 = g1();
        h9.f fVarQ = aVarG1 != null ? aVarG1.Q() : null;
        if (fVarQ != null) {
            fVarQ.y(false);
        }
        h00.t mViewBinding2 = getMViewBinding();
        if (mViewBinding2 == null || (recyclerView = mViewBinding2.f66027b) == null) {
            return;
        }
        recyclerView.setLayoutManager(new NpaLinearLayoutManager(requireContext()));
        com.transsnet.downloader.adapter.a aVar = new com.transsnet.downloader.adapter.a(p1());
        aVar.B0(new f9.d() { // from class: com.transsnet.downloader.fragment.r1
            @Override // f9.d
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                LocalFileSingleTabFragment.E1(this.f60956a, baseQuickAdapter, view, i11);
            }
        });
        aVar.i(R$id.ivTopRightCornerPoint);
        aVar.z0(new f9.b() { // from class: com.transsnet.downloader.fragment.s1
            @Override // f9.b
            public final void a(BaseQuickAdapter baseQuickAdapter, View view, int i11) {
                LocalFileSingleTabFragment.F1(this.f60959a, baseQuickAdapter, view, i11);
            }
        });
        u1(aVar);
        recyclerView.setAdapter(g1());
        recyclerView.addItemDecoration(new b());
    }
}
