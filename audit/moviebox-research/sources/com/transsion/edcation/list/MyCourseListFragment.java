package com.transsion.edcation.list;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.v;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tn.lib.view.StateView;
import com.transsion.baseui.fragment.BaseListFragment;
import com.transsion.core.utils.e;
import com.transsion.edcation.CourseManager;
import com.transsion.edcation.R$string;
import com.transsion.edcation.bean.CourseBean;
import com.transsion.home.p003enum.BottomTabType;
import com.transsion.moviedetailapi.bean.Pager;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.u0;
import kotlinx.coroutines.flow.v0;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;

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
public final class MyCourseListFragment extends BaseListFragment<CourseBean> {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public String f51892p;

    /* JADX INFO: renamed from: com.transsion.edcation.list.MyCourseListFragment$initViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.edcation.list.MyCourseListFragment$initViewModel$1", f = "MyCourseListFragment.kt", l = {62}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.transsion.edcation.list.MyCourseListFragment$initViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        @DebugMetadata(c = "com.transsion.edcation.list.MyCourseListFragment$initViewModel$1$1", f = "MyCourseListFragment.kt", l = {63}, m = "invokeSuspend")
        public static final class C05671 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ MyCourseListFragment this$0;

            /* JADX INFO: renamed from: com.transsion.edcation.list.MyCourseListFragment$initViewModel$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            @Metadata
            @DebugMetadata(c = "com.transsion.edcation.list.MyCourseListFragment$initViewModel$1$1$1", f = "MyCourseListFragment.kt", l = {}, m = "invokeSuspend")
            public static final class C05681 extends SuspendLambda implements Function2<List<CourseBean>, Continuation<? super Unit>, Object> {
                final /* synthetic */ k0 $$this$repeatOnLifecycle;
                /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ MyCourseListFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C05681(k0 k0Var, MyCourseListFragment myCourseListFragment, Continuation<? super C05681> continuation) {
                    super(2, continuation);
                    this.$$this$repeatOnLifecycle = k0Var;
                    this.this$0 = myCourseListFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C05681 c05681 = new C05681(this.$$this$repeatOnLifecycle, this.this$0, continuation);
                    c05681.L$0 = obj;
                    return c05681;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(List<CourseBean> list, Continuation<? super Unit> continuation) {
                    return ((C05681) create(list, continuation)).invokeSuspend(Unit.f68710a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    kotlin.coroutines.intrinsics.a.e();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    List list = (List) this.L$0;
                    String.valueOf(this.$$this$repeatOnLifecycle);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("list: ");
                    sb2.append(list);
                    BaseQuickAdapter<CourseBean, BaseViewHolder> baseQuickAdapterW0 = this.this$0.W0();
                    if (baseQuickAdapterW0 != null) {
                        baseQuickAdapterW0.w0(list);
                    }
                    this.this$0.F0();
                    return Unit.f68710a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C05671(MyCourseListFragment myCourseListFragment, Continuation<? super C05671> continuation) {
                super(2, continuation);
                this.this$0 = myCourseListFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                C05671 c05671 = new C05671(this.this$0, continuation);
                c05671.L$0 = obj;
                return c05671;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                return ((C05671) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objE = kotlin.coroutines.intrinsics.a.e();
                int i11 = this.label;
                if (i11 == 0) {
                    ResultKt.b(obj);
                    k0 k0Var = (k0) this.L$0;
                    v0<List<CourseBean>> v0VarF = CourseManager.f51853a.f();
                    C05681 c05681 = new C05681(k0Var, this.this$0, null);
                    this.label = 1;
                    if (kotlinx.coroutines.flow.c.h(v0VarF, c05681, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return Unit.f68710a;
            }
        }

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MyCourseListFragment.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                Lifecycle lifecycle = MyCourseListFragment.this.getLifecycle();
                Intrinsics.f(lifecycle, "lifecycle");
                Lifecycle.State state = Lifecycle.State.RESUMED;
                C05671 c05671 = new C05671(MyCourseListFragment.this, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.a(lifecycle, state, c05671, this) == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsion.edcation.list.MyCourseListFragment$initViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.edcation.list.MyCourseListFragment$initViewModel$2", f = "MyCourseListFragment.kt", l = {71}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.transsion.edcation.list.MyCourseListFragment$initViewModel$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        @DebugMetadata(c = "com.transsion.edcation.list.MyCourseListFragment$initViewModel$2$1", f = "MyCourseListFragment.kt", l = {73}, m = "invokeSuspend")
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ MyCourseListFragment this$0;

            /* JADX INFO: renamed from: com.transsion.edcation.list.MyCourseListFragment$initViewModel$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: source.java */
            @Metadata
            @DebugMetadata(c = "com.transsion.edcation.list.MyCourseListFragment$initViewModel$2$1$1", f = "MyCourseListFragment.kt", l = {}, m = "invokeSuspend")
            public static final class C05691 extends SuspendLambda implements Function2<Pager, Continuation<? super Unit>, Object> {
                /* synthetic */ Object L$0;
                int label;
                final /* synthetic */ MyCourseListFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C05691(MyCourseListFragment myCourseListFragment, Continuation<? super C05691> continuation) {
                    super(2, continuation);
                    this.this$0 = myCourseListFragment;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C05691 c05691 = new C05691(this.this$0, continuation);
                    c05691.L$0 = obj;
                    return c05691;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Pager pager, Continuation<? super Unit> continuation) {
                    return ((C05691) create(pager, continuation)).invokeSuspend(Unit.f68710a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    kotlin.coroutines.intrinsics.a.e();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    Pager pager = (Pager) this.L$0;
                    if (pager != null) {
                        MyCourseListFragment myCourseListFragment = this.this$0;
                        if (Intrinsics.b(pager.getHasMore(), Boxing.a(true))) {
                            String nextPage = pager.getNextPage();
                            if (nextPage == null) {
                                nextPage = "1";
                            }
                            myCourseListFragment.f51892p = nextPage;
                            myCourseListFragment.j1();
                        } else {
                            BaseListFragment.l1(myCourseListFragment, false, 1, null);
                        }
                    }
                    if (this.this$0.h1()) {
                        this.this$0.q1(false);
                    }
                    return Unit.f68710a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(MyCourseListFragment myCourseListFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = myCourseListFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objE = kotlin.coroutines.intrinsics.a.e();
                int i11 = this.label;
                if (i11 == 0) {
                    ResultKt.b(obj);
                    u0<Pager> u0VarG = CourseManager.f51853a.g();
                    C05691 c05691 = new C05691(this.this$0, null);
                    this.label = 1;
                    if (kotlinx.coroutines.flow.c.h(u0VarG, c05691, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return Unit.f68710a;
            }
        }

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MyCourseListFragment.this.new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                Lifecycle lifecycle = MyCourseListFragment.this.getLifecycle();
                Intrinsics.f(lifecycle, "lifecycle");
                Lifecycle.State state = Lifecycle.State.RESUMED;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(MyCourseListFragment.this, null);
                this.label = 1;
                if (RepeatOnLifecycleKt.a(lifecycle, state, anonymousClass1, this) == objE) {
                    return objE;
                }
            } else {
                if (i11 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        }
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public boolean A0() {
        return false;
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void E0() {
        CourseManager.n(CourseManager.f51853a, null, null, 3, null);
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public BaseQuickAdapter<CourseBean, BaseViewHolder> T0() {
        return new CourseListAdapter(0, 1, null);
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public View X0() {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        StateView stateView = new StateView(contextRequireContext);
        String string = getString(R$string.course_list_empy);
        Intrinsics.f(string, "getString(R.string.course_list_empy)");
        stateView.showData(4, 1, false, "", string);
        String string2 = getString(R$string.course_explore_now);
        Intrinsics.f(string2, "getString(R.string.course_explore_now)");
        stateView.setReTryTxt(string2);
        stateView.retry(new Function0<Unit>() { // from class: com.transsion.edcation.list.MyCourseListFragment$getRvEmptyView$1$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                com.alibaba.android.arouter.launcher.a.d().b("/main/tab").withString("bottomTab", BottomTabType.TAB_CODE_HOME).withString("topTab", "Education").navigation();
            }
        });
        return stateView;
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public String Z0() {
        return "";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void e1() {
        super.e1();
        fs.a aVar = (fs.a) getMViewBinding();
        if (aVar != null) {
            aVar.f65251d.setPadding(0, 0, 0, e.a(12.0f));
            b1();
            BaseListFragment.s1(this, null, 1, null);
        }
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void i1() {
        lazyLoadData();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public void initViewModel() {
        j.d(v.a(this), null, null, new AnonymousClass1(null), 3, null);
        j.d(v.a(this), null, null, new AnonymousClass2(null), 3, null);
    }

    @Override // com.transsion.baseui.fragment.LazyFragment
    public void lazyLoadData() {
        CourseManager courseManager = CourseManager.f51853a;
        String str = this.f51892p;
        if (str == null) {
            str = "1";
        }
        CourseManager.n(courseManager, str, null, 2, null);
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment
    public void o1() {
        q1(true);
        this.f51892p = "1";
        lazyLoadData();
    }

    @Override // com.transsion.baseui.fragment.PageStatusFragment
    public String t0() {
        return "";
    }

    @Override // com.transsion.baseui.fragment.BaseListFragment, com.transsion.baseui.fragment.PageStatusFragment
    public void v0() {
        super.v0();
        K0();
    }
}
