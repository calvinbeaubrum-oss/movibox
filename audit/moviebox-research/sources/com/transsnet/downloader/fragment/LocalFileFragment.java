package com.transsnet.downloader.fragment;

import com.blankj.utilcode.util.Utils;
import com.tn.lib.view.TitleLayout;
import com.transsion.baselib.db.download.DownloadBean;
import com.transsion.web.api.WebConstants;
import com.transsnet.downloader.R$string;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
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
@Metadata
public final class LocalFileFragment extends LocalFileBaseFragment {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final a f60836u = new a(null);

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f60837s = LazyKt__LazyJVMKt.b(new Function0<com.transsnet.downloader.manager.a>() { // from class: com.transsnet.downloader.fragment.LocalFileFragment$downloadManager$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.transsnet.downloader.manager.a invoke() {
            return com.transsnet.downloader.manager.b.f61062a.a(Utils.a());
        }
    });

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final b f60838t = new b();

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
    public static final class b extends tr.a {
        public b() {
        }

        @Override // tr.a, tr.g
        public void e(DownloadBean bean, String str) {
            Intrinsics.g(bean, "bean");
            super.e(bean, str);
            LocalFileFragment.this.B0();
        }
    }

    /* JADX INFO: renamed from: com.transsnet.downloader.fragment.LocalFileFragment$initViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsnet.downloader.fragment.LocalFileFragment$initViewModel$1", f = "LocalFileFragment.kt", l = {53}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LocalFileFragment.this.new AnonymousClass1(continuation);
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
                kotlinx.coroutines.flow.v0<Integer> v0VarC = LocalFileFragment.this.h1().C();
                final LocalFileFragment localFileFragment = LocalFileFragment.this;
                kotlinx.coroutines.flow.b<? super Integer> bVar = new kotlinx.coroutines.flow.b() { // from class: com.transsnet.downloader.fragment.LocalFileFragment.initViewModel.1.1

                    /* JADX INFO: renamed from: com.transsnet.downloader.fragment.LocalFileFragment$initViewModel$1$1$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: source.java */
                    @Metadata
                    @DebugMetadata(c = "com.transsnet.downloader.fragment.LocalFileFragment$initViewModel$1$1$1", f = "LocalFileFragment.kt", l = {}, m = "invokeSuspend")
                    public static final class C06211 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
                        final /* synthetic */ int $it;
                        int label;
                        final /* synthetic */ LocalFileFragment this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        public C06211(int i11, LocalFileFragment localFileFragment, Continuation<? super C06211> continuation) {
                            super(2, continuation);
                            this.$it = i11;
                            this.this$0 = localFileFragment;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C06211(this.$it, this.this$0, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
                            return ((C06211) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
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
                        Object objG = kotlinx.coroutines.h.g(kotlinx.coroutines.w0.c(), new C06211(i12, localFileFragment, null), continuation);
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

    private final com.transsnet.downloader.manager.a C1() {
        return (com.transsnet.downloader.manager.a) this.f60837s.getValue();
    }

    @Override // com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment
    public String getPageName() {
        return "file_manager_tab_all";
    }

    @Override // com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initListener() {
        super.initListener();
        C1().f(this.f60838t);
    }

    @Override // com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        super.initViewModel();
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
        com.transsion.baselib.report.h hVar = new com.transsion.baselib.report.h(getPageName(), false, 2, null);
        hVar.g().put("permission", com.transsnet.downloader.viewmodel.c.f61276a.a() ? "1" : "0");
        hVar.g().put(WebConstants.PAGE_FROM, "");
        return hVar;
    }

    @Override // com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment, com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        C1().v(this.f60838t);
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment
    public boolean p1() {
        return true;
    }

    @Override // com.transsnet.downloader.fragment.LocalFileBaseFragment, com.transsnet.downloader.fragment.AllHistoricalPlayRecordFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        super.v0();
        h00.t mViewBinding = getMViewBinding();
        TitleLayout titleLayout = mViewBinding != null ? mViewBinding.f66029d : null;
        if (titleLayout != null) {
            titleLayout.setVisibility(8);
        }
        com.transsnet.downloader.adapter.a aVarG1 = g1();
        h9.f fVarQ = aVarG1 != null ? aVarG1.Q() : null;
        if (fVarQ == null) {
            return;
        }
        fVarQ.y(false);
    }
}
