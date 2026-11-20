package com.transsion.edcation;

import androidx.fragment.app.FragmentManager;
import com.tn.lib.net.bean.BaseDto;
import com.tn.lib.net.manager.NetServiceGenerator;
import com.transsion.baselib.report.launch.RoomAppMMKV;
import com.transsion.edcation.bean.CourseBean;
import com.transsion.edcation.bean.CourseListResp;
import com.transsion.edcation.dialog.InterestSelectDialog;
import com.transsion.moviedetailapi.bean.Pager;
import com.transsion.moviedetailapi.bean.Subject;
import io.reactivex.rxjava3.core.j;
import io.reactivex.rxjava3.core.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k10.h;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.a1;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.u0;
import kotlinx.coroutines.flow.v0;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l2;
import kotlinx.coroutines.q1;
import kotlinx.coroutines.w0;
import zo.d;

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
@SourceDebugExtension
public final class CourseManager implements k0 {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static q1 f51861j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CourseManager f51853a = new CourseManager();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f51854b = LazyKt__LazyJVMKt.b(new Function0<com.transsion.edcation.a>() { // from class: com.transsion.edcation.CourseManager$mApi$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final a invoke() {
            return (a) NetServiceGenerator.f49399d.a().i(a.class);
        }
    });

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f51855c = LazyKt__LazyJVMKt.b(new Function0<Boolean>() { // from class: com.transsion.edcation.CourseManager$isFirstInterestShow$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.valueOf(RoomAppMMKV.f51271a.a().getBoolean("edu_interest_dialog", true));
        }
    });

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f51856d = true;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final u0<CourseBean> f51857f = a1.b(0, 0, null, 7, null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final v0<CourseBean> f51858g = g1.a(null);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final v0<List<CourseBean>> f51859h = g1.a(new ArrayList());

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final u0<Pager> f51860i = a1.b(0, 0, null, 7, null);

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final CoroutineContext f51862k = w0.b().plus(l2.b(null, 1, null));

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a<T, R> implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a<T, R> f51863a = new a<>();

        @Override // k10.h
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final m<? extends BaseDto<CourseListResp>> apply(Throwable it) {
            Intrinsics.g(it, "it");
            return j.i(it);
        }
    }

    public static /* synthetic */ void n(CourseManager courseManager, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "1";
        }
        if ((i11 & 2) != 0) {
            str2 = null;
        }
        courseManager.m(str, str2);
    }

    public static /* synthetic */ void q(CourseManager courseManager, Subject subject, Boolean bool, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            bool = null;
        }
        courseManager.p(subject, bool);
    }

    public final void e(FragmentManager fragmentManager) {
        Intrinsics.g(fragmentManager, "fragmentManager");
        if (k() && f51856d) {
            new InterestSelectDialog().show(fragmentManager, "InterestSelectDialog");
        }
    }

    public final v0<List<CourseBean>> f() {
        return f51859h;
    }

    public final u0<Pager> g() {
        return f51860i;
    }

    @Override // kotlinx.coroutines.k0
    public CoroutineContext getCoroutineContext() {
        return f51862k;
    }

    public final u0<CourseBean> h() {
        return f51857f;
    }

    public final com.transsion.edcation.a i() {
        return (com.transsion.edcation.a) f51854b.getValue();
    }

    public final v0<CourseBean> j() {
        return f51858g;
    }

    public final boolean k() {
        return ((Boolean) f51855c.getValue()).booleanValue();
    }

    public final void l(CourseBean courseBean) {
        q1 q1Var = f51861j;
        if (q1Var != null) {
            q1.a.b(q1Var, null, 1, null);
        }
        f51861j = kotlinx.coroutines.j.d(this, null, null, new CourseManager$notifyCourse$1(courseBean, null), 3, null);
    }

    public final void m(final String page, final String str) {
        Intrinsics.g(page, "page");
        com.transsion.edcation.a.C0564a.b(i(), null, page, 0, 5, null).r(q10.a.b()).t(a.f51863a).e(d.f82109a.c()).subscribe(new zo.a<CourseListResp>() { // from class: com.transsion.edcation.CourseManager$refreshCourseList$2
            @Override // zo.a
            public void a(String str2, String str3) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("error: ");
                sb2.append(str2);
                sb2.append(", msg:");
                sb2.append(str3);
            }

            @Override // zo.a
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void c(CourseListResp courseListResp) {
                List<CourseBean> items;
                List<CourseBean> items2;
                super.c(courseListResp);
                List listM0 = null;
                Integer numValueOf = (courseListResp == null || (items2 = courseListResp.getItems()) == null) ? null : Integer.valueOf(items2.size());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("list is empty: ");
                sb2.append(numValueOf);
                CourseManager courseManager = CourseManager.f51853a;
                kotlinx.coroutines.j.d(courseManager, null, null, new CourseManager$refreshCourseList$2$onSuccess$1(courseListResp, str, null), 3, null);
                if (courseListResp != null && (items = courseListResp.getItems()) != null) {
                    listM0 = CollectionsKt___CollectionsKt.M0(items);
                }
                courseManager.t(listM0, page);
            }
        });
    }

    public final void o(boolean z11) {
        f51856d = z11;
    }

    public final void p(Subject subject, Boolean bool) {
        if (subject == null) {
            return;
        }
        kotlinx.coroutines.j.d(this, null, null, new CourseManager$subscribeCourse$1(subject, bool, null), 3, null);
    }

    public final void r(String str, Integer num) {
        if (str == null) {
            return;
        }
        kotlinx.coroutines.j.d(this, null, null, new CourseManager$subscribeCourseById$1(num, str, null), 3, null);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object s(CourseBean courseBean, Continuation<? super Unit> continuation) throws Throwable {
        CourseManager$updateCourse$1 courseManager$updateCourse$1;
        CourseBean courseBean2;
        List<CourseBean> list;
        Object next;
        if (continuation instanceof CourseManager$updateCourse$1) {
            courseManager$updateCourse$1 = (CourseManager$updateCourse$1) continuation;
            int i11 = courseManager$updateCourse$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                courseManager$updateCourse$1.label = i11 - Integer.MIN_VALUE;
            } else {
                courseManager$updateCourse$1 = new CourseManager$updateCourse$1(this, continuation);
            }
        } else {
            courseManager$updateCourse$1 = new CourseManager$updateCourse$1(this, continuation);
        }
        Object obj = courseManager$updateCourse$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = courseManager$updateCourse$1.label;
        if (i12 != 0) {
            if (i12 == 1) {
                list = (List) courseManager$updateCourse$1.L$0;
                ResultKt.b(obj);
            } else {
                if (i12 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        List<CourseBean> value = f51859h.getValue();
        if (value != null) {
            Iterator<T> it = value.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
            } while (!Intrinsics.b(((CourseBean) next).getSubjectId(), courseBean.getSubjectId()));
            courseBean2 = (CourseBean) next;
        } else {
            courseBean2 = null;
        }
        if (courseBean2 != null) {
            Boxing.a(value.remove(courseBean2));
        }
        if (courseBean.getSeenStatus() == 1 && value != null) {
            value.add(0, courseBean);
        }
        v0<List<CourseBean>> v0Var = f51859h;
        courseManager$updateCourse$1.L$0 = value;
        courseManager$updateCourse$1.label = 1;
        if (v0Var.emit(value, courseManager$updateCourse$1) == objE) {
            return objE;
        }
        list = value;
        v0<CourseBean> v0Var2 = f51858g;
        CourseBean courseBean3 = list != null ? (CourseBean) CollectionsKt___CollectionsKt.g0(list) : null;
        courseManager$updateCourse$1.L$0 = null;
        courseManager$updateCourse$1.label = 2;
        if (v0Var2.emit(courseBean3, courseManager$updateCourse$1) == objE) {
            return objE;
        }
        return Unit.f68710a;
    }

    public final void t(List<CourseBean> list, String str) {
        kotlinx.coroutines.j.d(this, null, null, new CourseManager$updateCourseList$1(str, list, null), 3, null);
    }
}
