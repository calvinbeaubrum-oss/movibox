package com.transsion.edcation.history;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.lifecycle.v;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.util.Utils;
import com.tn.lib.view.StateView;
import com.transsion.baselib.db.AppDatabase;
import com.transsion.baselib.db.video.VideoDetailPlayBean;
import com.transsion.baselib.db.video.VideoDetailPlayDao;
import com.transsion.baseui.fragment.BaseFragment;
import com.transsion.edcation.R$string;
import com.transsion.home.p003enum.BottomTabType;
import com.transsion.moviedetailapi.SubjectType;
import h9.f;
import java.util.ArrayList;
import java.util.List;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.h;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.r0;
import kotlinx.coroutines.w0;

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
public final class EducationHistoryFragment extends BaseFragment<bt.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public EducationHistoryAdapter f51885a;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f51887c;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f51886b = LazyKt__LazyJVMKt.b(new Function0<VideoDetailPlayDao>() { // from class: com.transsion.edcation.history.EducationHistoryFragment$mVideoDetailPlayDao$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final VideoDetailPlayDao invoke() {
            AppDatabase.v0 v0Var = AppDatabase.f51036p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            return v0Var.b(applicationA).O0();
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f51888d = 10;

    /* JADX INFO: renamed from: com.transsion.edcation.history.EducationHistoryFragment$lazyLoadData$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.edcation.history.EducationHistoryFragment$lazyLoadData$1", f = "EducationHistoryFragment.kt", l = {72, 74}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.transsion.edcation.history.EducationHistoryFragment$lazyLoadData$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        @DebugMetadata(c = "com.transsion.edcation.history.EducationHistoryFragment$lazyLoadData$1$1", f = "EducationHistoryFragment.kt", l = {}, m = "invokeSuspend")
        public static final class C05651 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<VideoDetailPlayBean> $list;
            int label;
            final /* synthetic */ EducationHistoryFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C05651(EducationHistoryFragment educationHistoryFragment, List<VideoDetailPlayBean> list, Continuation<? super C05651> continuation) {
                super(2, continuation);
                this.this$0 = educationHistoryFragment;
                this.$list = list;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C05651(this.this$0, this.$list, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                return ((C05651) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                EducationHistoryAdapter educationHistoryAdapter;
                f fVarQ;
                kotlin.coroutines.intrinsics.a.e();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                if (this.this$0.f51887c > 0) {
                    EducationHistoryAdapter educationHistoryAdapter2 = this.this$0.f51885a;
                    if (educationHistoryAdapter2 != null) {
                        educationHistoryAdapter2.w0(this.$list);
                    }
                } else {
                    EducationHistoryAdapter educationHistoryAdapter3 = this.this$0.f51885a;
                    if (educationHistoryAdapter3 != null) {
                        educationHistoryAdapter3.r0(this.this$0.n0());
                    }
                }
                if (this.$list.size() < this.this$0.f51888d && (educationHistoryAdapter = this.this$0.f51885a) != null && (fVarQ = educationHistoryAdapter.Q()) != null) {
                    f.t(fVarQ, false, 1, null);
                }
                return Unit.f68710a;
            }
        }

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EducationHistoryFragment.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 != 0) {
                if (i11 == 1) {
                    ResultKt.b(obj);
                } else {
                    if (i11 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            EducationHistoryFragment educationHistoryFragment = EducationHistoryFragment.this;
            this.label = 1;
            obj = educationHistoryFragment.m0(true, this);
            if (obj == objE) {
                return objE;
            }
            a2 a2VarC = w0.c();
            C05651 c05651 = new C05651(EducationHistoryFragment.this, (List) obj, null);
            this.label = 2;
            if (h.g(a2VarC, c05651, this) == objE) {
                return objE;
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsion.edcation.history.EducationHistoryFragment$onResume$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.edcation.history.EducationHistoryFragment$onResume$1", f = "EducationHistoryFragment.kt", l = {93, 94, 96}, m = "invokeSuspend")
    public static final class C19931 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: renamed from: com.transsion.edcation.history.EducationHistoryFragment$onResume$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        @DebugMetadata(c = "com.transsion.edcation.history.EducationHistoryFragment$onResume$1$1", f = "EducationHistoryFragment.kt", l = {}, m = "invokeSuspend")
        public static final class C05661 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
            final /* synthetic */ List<VideoDetailPlayBean> $list;
            int label;
            final /* synthetic */ EducationHistoryFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C05661(EducationHistoryFragment educationHistoryFragment, List<VideoDetailPlayBean> list, Continuation<? super C05661> continuation) {
                super(2, continuation);
                this.this$0 = educationHistoryFragment;
                this.$list = list;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C05661(this.this$0, this.$list, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                return ((C05661) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                EducationHistoryAdapter educationHistoryAdapter;
                f fVarQ;
                kotlin.coroutines.intrinsics.a.e();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                if (this.this$0.f51887c > 0) {
                    EducationHistoryAdapter educationHistoryAdapter2 = this.this$0.f51885a;
                    if (educationHistoryAdapter2 != null) {
                        educationHistoryAdapter2.w0(this.$list);
                    }
                } else {
                    EducationHistoryAdapter educationHistoryAdapter3 = this.this$0.f51885a;
                    if (educationHistoryAdapter3 != null) {
                        educationHistoryAdapter3.r0(this.this$0.n0());
                    }
                }
                if (this.$list.size() < this.this$0.f51888d && (educationHistoryAdapter = this.this$0.f51885a) != null && (fVarQ = educationHistoryAdapter.Q()) != null) {
                    f.t(fVarQ, false, 1, null);
                }
                return Unit.f68710a;
            }
        }

        public C19931(Continuation<? super C19931> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return EducationHistoryFragment.this.new C19931(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((C19931) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        /* JADX WARN: Code duplicated, block: B:20:0x0054 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            a2 a2VarC;
            C05661 c05661;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 != 0) {
                if (i11 == 1) {
                    ResultKt.b(obj);
                } else if (i11 == 2) {
                    ResultKt.b(obj);
                    a2VarC = w0.c();
                    c05661 = new C05661(EducationHistoryFragment.this, (List) obj, null);
                    this.label = 3;
                    if (h.g(a2VarC, c05661, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i11 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            this.label = 1;
            if (r0.a(1000L, this) == objE) {
                return objE;
            }
            EducationHistoryFragment educationHistoryFragment = EducationHistoryFragment.this;
            this.label = 2;
            obj = educationHistoryFragment.m0(true, this);
            if (obj == objE) {
                return objE;
            }
            a2VarC = w0.c();
            c05661 = new C05661(EducationHistoryFragment.this, (List) obj, null);
            this.label = 3;
            if (h.g(a2VarC, c05661, this) == objE) {
                return objE;
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View n0() {
        Context contextRequireContext = requireContext();
        Intrinsics.f(contextRequireContext, "requireContext()");
        StateView stateView = new StateView(contextRequireContext);
        String string = getString(R$string.course_list_empy);
        Intrinsics.f(string, "getString(R.string.course_list_empy)");
        stateView.showData(4, 1, false, "", string);
        String string2 = getString(R$string.course_explore_now);
        Intrinsics.f(string2, "getString(R.string.course_explore_now)");
        stateView.setReTryTxt(string2);
        stateView.retry(new Function0<Unit>() { // from class: com.transsion.edcation.history.EducationHistoryFragment$getEmptyView$1$1
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

    private final VideoDetailPlayDao o0() {
        return (VideoDetailPlayDao) this.f51886b.getValue();
    }

    public static final void q0(EducationHistoryFragment this$0) {
        Intrinsics.g(this$0, "this$0");
        j.d(v.a(this$0), null, null, new EducationHistoryFragment$initView$1$1$1(this$0, null), 3, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void initView(View view, Bundle bundle) {
        Intrinsics.g(view, "view");
        bt.b mViewBinding = getMViewBinding();
        RecyclerView recyclerView = mViewBinding != null ? mViewBinding.f14398b : null;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        }
        EducationHistoryAdapter educationHistoryAdapter = new EducationHistoryAdapter(new ArrayList());
        this.f51885a = educationHistoryAdapter;
        if (recyclerView != null) {
            recyclerView.setAdapter(educationHistoryAdapter);
        }
        EducationHistoryAdapter educationHistoryAdapter2 = this.f51885a;
        if (educationHistoryAdapter2 != null) {
            educationHistoryAdapter2.Q().y(true);
            educationHistoryAdapter2.Q().y(true);
            educationHistoryAdapter2.Q().x(true);
            educationHistoryAdapter2.Q().C(new f9.f() { // from class: com.transsion.edcation.history.b
                @Override // f9.f
                public final void a() {
                    EducationHistoryFragment.q0(this.f51891a);
                }
            });
        }
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    public void lazyLoadData() {
        j.d(v.a(this), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object m0(boolean z11, Continuation<? super List<VideoDetailPlayBean>> continuation) throws Throwable {
        EducationHistoryFragment$fetchHistory$1 educationHistoryFragment$fetchHistory$1;
        EducationHistoryFragment educationHistoryFragment;
        if (continuation instanceof EducationHistoryFragment$fetchHistory$1) {
            educationHistoryFragment$fetchHistory$1 = (EducationHistoryFragment$fetchHistory$1) continuation;
            int i11 = educationHistoryFragment$fetchHistory$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                educationHistoryFragment$fetchHistory$1.label = i11 - Integer.MIN_VALUE;
            } else {
                educationHistoryFragment$fetchHistory$1 = new EducationHistoryFragment$fetchHistory$1(this, continuation);
            }
        } else {
            educationHistoryFragment$fetchHistory$1 = new EducationHistoryFragment$fetchHistory$1(this, continuation);
        }
        Object objH = educationHistoryFragment$fetchHistory$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = educationHistoryFragment$fetchHistory$1.label;
        if (i12 == 0) {
            ResultKt.b(objH);
            if (z11) {
                this.f51887c = 0;
            }
            VideoDetailPlayDao videoDetailPlayDaoO0 = o0();
            int i13 = this.f51887c;
            int i14 = this.f51888d;
            int value = SubjectType.EDUCATION.getValue();
            educationHistoryFragment$fetchHistory$1.L$0 = this;
            educationHistoryFragment$fetchHistory$1.label = 1;
            objH = videoDetailPlayDaoO0.h(i13, i14, value, educationHistoryFragment$fetchHistory$1);
            if (objH == objE) {
                return objE;
            }
            educationHistoryFragment = this;
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            educationHistoryFragment = (EducationHistoryFragment) educationHistoryFragment$fetchHistory$1.L$0;
            ResultKt.b(objH);
        }
        List list = (List) objH;
        educationHistoryFragment.f51887c += list != null ? list.size() : 0;
        return list == null ? new ArrayList() : list;
    }

    @Override // com.transsion.baseui.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        j.d(v.a(this), null, null, new C19931(null), 3, null);
    }

    @Override // com.transsion.baseui.fragment.BaseFragment
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public bt.b getViewBinding(LayoutInflater inflater) {
        Intrinsics.g(inflater, "inflater");
        bt.b bVarC = bt.b.c(inflater);
        Intrinsics.f(bVarC, "inflate(inflater)");
        return bVarC;
    }
}
