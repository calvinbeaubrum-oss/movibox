package com.transsion.ad.test;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.v;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.manager.AdPlansStorageManager;
import com.vungle.warren.error.VungleException;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.a2;
import kotlinx.coroutines.k0;
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
public final class TestAdPlansActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public pq.k f50632a;

    /* JADX INFO: renamed from: com.transsion.ad.test.TestAdPlansActivity$onCreate$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.ad.test.TestAdPlansActivity$onCreate$1", f = "TestAdPlansActivity.kt", l = {VungleException.WEB_CRASH, 36}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;

        /* JADX INFO: renamed from: com.transsion.ad.test.TestAdPlansActivity$onCreate$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        @DebugMetadata(c = "com.transsion.ad.test.TestAdPlansActivity$onCreate$1$1", f = "TestAdPlansActivity.kt", l = {32}, m = "invokeSuspend")
        @SourceDebugExtension
        public static final class C05511 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
            final /* synthetic */ StringBuilder $sb;
            int label;
            final /* synthetic */ TestAdPlansActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C05511(TestAdPlansActivity testAdPlansActivity, StringBuilder sb2, Continuation<? super C05511> continuation) {
                super(2, continuation);
                this.this$0 = testAdPlansActivity;
                this.$sb = sb2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C05511(this.this$0, this.$sb, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                return ((C05511) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objE = kotlin.coroutines.intrinsics.a.e();
                int i11 = this.label;
                if (i11 == 0) {
                    ResultKt.b(obj);
                    AdPlansStorageManager adPlansStorageManager = AdPlansStorageManager.f50532a;
                    this.label = 1;
                    obj = adPlansStorageManager.h(this);
                    if (obj == objE) {
                        return objE;
                    }
                } else {
                    if (i11 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
                List list = (List) obj;
                if (list == null) {
                    return null;
                }
                TestAdPlansActivity testAdPlansActivity = this.this$0;
                StringBuilder sb2 = this.$sb;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    testAdPlansActivity.O(sb2, (MbAdDbPlans) it.next());
                }
                return Unit.f68710a;
            }
        }

        /* JADX INFO: renamed from: com.transsion.ad.test.TestAdPlansActivity$onCreate$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: source.java */
        @Metadata
        @DebugMetadata(c = "com.transsion.ad.test.TestAdPlansActivity$onCreate$1$2", f = "TestAdPlansActivity.kt", l = {}, m = "invokeSuspend")
        public static final class AnonymousClass2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
            final /* synthetic */ StringBuilder $sb;
            int label;
            final /* synthetic */ TestAdPlansActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(TestAdPlansActivity testAdPlansActivity, StringBuilder sb2, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = testAdPlansActivity;
                this.$sb = sb2;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, this.$sb, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
                return ((AnonymousClass2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                kotlin.coroutines.intrinsics.a.e();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                pq.k kVar = this.this$0.f50632a;
                pq.k kVar2 = null;
                if (kVar == null) {
                    Intrinsics.y("binding");
                    kVar = null;
                }
                kVar.f74032b.setMovementMethod(new ScrollingMovementMethod());
                pq.k kVar3 = this.this$0.f50632a;
                if (kVar3 == null) {
                    Intrinsics.y("binding");
                } else {
                    kVar2 = kVar3;
                }
                kVar2.f74032b.setText(this.$sb.toString());
                return Unit.f68710a;
            }
        }

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return TestAdPlansActivity.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            StringBuilder sb2;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 != 0) {
                if (i11 == 1) {
                    sb2 = (StringBuilder) this.L$0;
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
            sb2 = new StringBuilder();
            CoroutineDispatcher coroutineDispatcherB = w0.b();
            C05511 c05511 = new C05511(TestAdPlansActivity.this, sb2, null);
            this.L$0 = sb2;
            this.label = 1;
            if (kotlinx.coroutines.h.g(coroutineDispatcherB, c05511, this) == objE) {
                return objE;
            }
            a2 a2VarC = w0.c();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(TestAdPlansActivity.this, sb2, null);
            this.L$0 = null;
            this.label = 2;
            if (kotlinx.coroutines.h.g(a2VarC, anonymousClass2, this) == objE) {
                return objE;
            }
            return Unit.f68710a;
        }
    }

    public final void O(StringBuilder sb2, MbAdDbPlans mbAdDbPlans) {
        sb2.append("------------------\n");
        sb2.append("id = " + mbAdDbPlans.getId() + "\n");
        sb2.append("name = " + mbAdDbPlans.getName() + "\n");
        xq.k kVar = xq.k.f80682a;
        String startTime = mbAdDbPlans.getStartTime();
        sb2.append("startTime = " + xq.k.b(kVar, startTime != null ? Long.valueOf(Long.parseLong(startTime)) : null, null, 2, null) + "\n");
        String endTime = mbAdDbPlans.getEndTime();
        sb2.append("endTime = " + xq.k.b(kVar, endTime != null ? Long.valueOf(Long.parseLong(endTime)) : null, null, 2, null) + "\n");
        sb2.append("dispatchTimeStart = " + mbAdDbPlans.getDispatchTimeStart() + "\n");
        sb2.append("dispatchTimeEnd = " + mbAdDbPlans.getDispatchTimeEnd() + "\n");
        sb2.append("displayTimes = " + mbAdDbPlans.getDisplayTimes() + "\n");
        sb2.append("showedTimes = " + mbAdDbPlans.getShowedTimes() + "\n");
        sb2.append("showDate = " + mbAdDbPlans.getShowDate() + "\n");
        sb2.append("adSource = " + mbAdDbPlans.getAdSource() + "\n");
        sb2.append("extAdSlot = " + mbAdDbPlans.getExtAdSlot() + "\n");
        sb2.append("sort = " + mbAdDbPlans.getSort() + "\n");
        sb2.append("ctxEnableExpr = " + mbAdDbPlans.getCtxEnableExpr() + "\n");
        sb2.append("ctxDisableExpr = " + mbAdDbPlans.getCtxDisableExpr() + "\n");
        sb2.append("bidEcpmCent = " + mbAdDbPlans.getBidEcpmCent() + "\n");
        sb2.append("ecpmCent = " + mbAdDbPlans.getEcpmCent() + "\n");
        sb2.append("\n");
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        pq.k kVarC = pq.k.c(getLayoutInflater());
        Intrinsics.f(kVarC, "inflate(layoutInflater)");
        this.f50632a = kVarC;
        if (kVarC == null) {
            Intrinsics.y("binding");
            kVarC = null;
        }
        setContentView(kVarC.getRoot());
        kotlinx.coroutines.j.d(v.a(this), null, null, new AnonymousClass1(null), 3, null);
    }
}
