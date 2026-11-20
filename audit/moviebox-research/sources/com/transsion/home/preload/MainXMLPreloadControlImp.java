package com.transsion.home.preload;

import android.app.Activity;
import android.os.Build;
import android.view.View;
import com.google.android.gms.fido.u2f.api.common.RegisterRequest;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.l;
import kotlinx.coroutines.j;
import kotlinx.coroutines.k0;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.o0;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class MainXMLPreloadControlImp implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f52647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f52648b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f52649c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public View f52650d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f52651e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f52652f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f52653g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f52654h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f52655i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f52656j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f52657k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f52658l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f52659m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f52660n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f52661o;

    /* JADX INFO: renamed from: com.transsion.home.preload.MainXMLPreloadControlImp$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.home.preload.MainXMLPreloadControlImp$1", f = "MainXMLPreloadControlImp.kt", l = {52, 59, RegisterRequest.U2F_V1_CHALLENGE_BYTE_LENGTH, 71}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Activity $activity;
        private /* synthetic */ Object L$0;
        Object L$1;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Activity activity, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$activity = activity;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = MainXMLPreloadControlImp.this.new AnonymousClass1(this.$activity, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        /* JADX WARN: Code duplicated, block: B:29:0x014b A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:30:0x014c  */
        /* JADX WARN: Code duplicated, block: B:33:0x0192 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:34:0x0193  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objC;
            k0 k0Var;
            MainXMLPreloadControlImp mainXMLPreloadControlImp;
            MainXMLPreloadControlImp mainXMLPreloadControlImp2;
            Object objC2;
            MainXMLPreloadControlImp mainXMLPreloadControlImp3;
            Object objC3;
            k0 k0Var2;
            MainXMLPreloadControlImp mainXMLPreloadControlImp4;
            Object objC4;
            MainXMLPreloadControlImp mainXMLPreloadControlImp5;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 != 0) {
                if (i11 == 1) {
                    mainXMLPreloadControlImp = (MainXMLPreloadControlImp) this.L$1;
                    k0 k0Var3 = (k0) this.L$0;
                    ResultKt.b(obj);
                    k0Var = k0Var3;
                    objC = obj;
                } else if (i11 == 2) {
                    mainXMLPreloadControlImp2 = (MainXMLPreloadControlImp) this.L$1;
                    k0 k0Var4 = (k0) this.L$0;
                    ResultKt.b(obj);
                    k0Var = k0Var4;
                    objC2 = obj;
                    mainXMLPreloadControlImp2.f52651e = (View) objC2;
                    o0 o0VarB = j.b(k0Var, w0.b(), null, new MainXMLPreloadControlImp$1$opMovieRankDeferred$1(this.$activity, null), 2, null);
                    uo.b.a.f(uo.b.f78622a, "MainXMLPreload", "---- itemSubjectOpView preload success, ThreadName = " + Thread.currentThread().getName(), false, 4, null);
                    mainXMLPreloadControlImp3 = MainXMLPreloadControlImp.this;
                    this.L$0 = k0Var;
                    this.L$1 = mainXMLPreloadControlImp3;
                    this.label = 3;
                    objC3 = o0VarB.c(this);
                    if (objC3 == objE) {
                        return objE;
                    }
                    k0Var2 = k0Var;
                    mainXMLPreloadControlImp3.f52652f = (View) objC3;
                    o0 o0VarB2 = j.b(k0Var2, w0.b(), null, new MainXMLPreloadControlImp$1$opPlayListDeferred$1(this.$activity, null), 2, null);
                    uo.b.a.f(uo.b.f78622a, "MainXMLPreload", "---- itemSubjectOpView preload success, ThreadName = " + Thread.currentThread().getName(), false, 4, null);
                    mainXMLPreloadControlImp4 = MainXMLPreloadControlImp.this;
                    this.L$0 = mainXMLPreloadControlImp4;
                    this.L$1 = null;
                    this.label = 4;
                    objC4 = o0VarB2.c(this);
                    if (objC4 == objE) {
                        return objE;
                    }
                    mainXMLPreloadControlImp5 = mainXMLPreloadControlImp4;
                } else if (i11 == 3) {
                    MainXMLPreloadControlImp mainXMLPreloadControlImp6 = (MainXMLPreloadControlImp) this.L$1;
                    k0 k0Var5 = (k0) this.L$0;
                    ResultKt.b(obj);
                    mainXMLPreloadControlImp3 = mainXMLPreloadControlImp6;
                    k0Var2 = k0Var5;
                    objC3 = obj;
                    mainXMLPreloadControlImp3.f52652f = (View) objC3;
                    o0 o0VarB3 = j.b(k0Var2, w0.b(), null, new MainXMLPreloadControlImp$1$opPlayListDeferred$1(this.$activity, null), 2, null);
                    uo.b.a.f(uo.b.f78622a, "MainXMLPreload", "---- itemSubjectOpView preload success, ThreadName = " + Thread.currentThread().getName(), false, 4, null);
                    mainXMLPreloadControlImp4 = MainXMLPreloadControlImp.this;
                    this.L$0 = mainXMLPreloadControlImp4;
                    this.L$1 = null;
                    this.label = 4;
                    objC4 = o0VarB3.c(this);
                    if (objC4 == objE) {
                        return objE;
                    }
                    mainXMLPreloadControlImp5 = mainXMLPreloadControlImp4;
                } else {
                    if (i11 != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    mainXMLPreloadControlImp5 = (MainXMLPreloadControlImp) this.L$0;
                    ResultKt.b(obj);
                    objC4 = obj;
                }
                mainXMLPreloadControlImp5.f52653g = (View) objC4;
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            k0 k0Var6 = (k0) this.L$0;
            if (Build.VERSION.SDK_INT == 30 && l.v(Build.MANUFACTURER, "TCL", true)) {
                return Unit.f68710a;
            }
            o0 o0VarB4 = j.b(k0Var6, w0.b(), null, new MainXMLPreloadControlImp$1$postListDeferred$1(this.$activity, null), 2, null);
            MainXMLPreloadControlImp mainXMLPreloadControlImp7 = MainXMLPreloadControlImp.this;
            this.L$0 = k0Var6;
            this.L$1 = mainXMLPreloadControlImp7;
            this.label = 1;
            objC = o0VarB4.c(this);
            if (objC == objE) {
                return objE;
            }
            k0Var = k0Var6;
            mainXMLPreloadControlImp = mainXMLPreloadControlImp7;
            mainXMLPreloadControlImp.f52647a = (View) objC;
            uo.b.a aVar = uo.b.f78622a;
            uo.b.a.f(aVar, "MainXMLPreload", "---- postListView preload success, ThreadName = " + Thread.currentThread().getName(), false, 4, null);
            o0 o0VarB5 = j.b(k0Var, w0.b(), null, new MainXMLPreloadControlImp$1$rankingDeferred$1(this.$activity, null), 2, null);
            uo.b.a.f(aVar, "MainXMLPreload", "---- itemRanking preload success, ThreadName = " + Thread.currentThread().getName(), false, 4, null);
            mainXMLPreloadControlImp2 = MainXMLPreloadControlImp.this;
            this.L$0 = k0Var;
            this.L$1 = mainXMLPreloadControlImp2;
            this.label = 2;
            objC2 = o0VarB5.c(this);
            if (objC2 == objE) {
                return objE;
            }
            mainXMLPreloadControlImp2.f52651e = (View) objC2;
            o0 o0VarB6 = j.b(k0Var, w0.b(), null, new MainXMLPreloadControlImp$1$opMovieRankDeferred$1(this.$activity, null), 2, null);
            uo.b.a.f(uo.b.f78622a, "MainXMLPreload", "---- itemSubjectOpView preload success, ThreadName = " + Thread.currentThread().getName(), false, 4, null);
            mainXMLPreloadControlImp3 = MainXMLPreloadControlImp.this;
            this.L$0 = k0Var;
            this.L$1 = mainXMLPreloadControlImp3;
            this.label = 3;
            objC3 = o0VarB6.c(this);
            if (objC3 == objE) {
                return objE;
            }
            k0Var2 = k0Var;
            mainXMLPreloadControlImp3.f52652f = (View) objC3;
            o0 o0VarB7 = j.b(k0Var2, w0.b(), null, new MainXMLPreloadControlImp$1$opPlayListDeferred$1(this.$activity, null), 2, null);
            uo.b.a.f(uo.b.f78622a, "MainXMLPreload", "---- itemSubjectOpView preload success, ThreadName = " + Thread.currentThread().getName(), false, 4, null);
            mainXMLPreloadControlImp4 = MainXMLPreloadControlImp.this;
            this.L$0 = mainXMLPreloadControlImp4;
            this.L$1 = null;
            this.label = 4;
            objC4 = o0VarB7.c(this);
            if (objC4 == objE) {
                return objE;
            }
            mainXMLPreloadControlImp5 = mainXMLPreloadControlImp4;
            mainXMLPreloadControlImp5.f52653g = (View) objC4;
            return Unit.f68710a;
        }
    }

    public MainXMLPreloadControlImp(Activity activity) {
        Intrinsics.g(activity, "activity");
        j.d(l0.a(w0.a()), null, null, new AnonymousClass1(activity, null), 3, null);
    }

    @Override // com.transsion.home.preload.b
    public boolean a() {
        return this.f52661o;
    }

    @Override // com.transsion.home.preload.b
    public boolean b() {
        return this.f52660n;
    }

    @Override // com.transsion.home.preload.b
    public boolean c() {
        return this.f52657k;
    }

    @Override // com.transsion.home.preload.b
    public View d() {
        this.f52660n = true;
        return this.f52652f;
    }

    @Override // com.transsion.home.preload.b
    public View e() {
        this.f52657k = true;
        return this.f52651e;
    }

    @Override // com.transsion.home.preload.b
    public boolean f() {
        return this.f52654h;
    }

    @Override // com.transsion.home.preload.b
    public View g() {
        this.f52654h = true;
        return this.f52647a;
    }

    @Override // com.transsion.home.preload.b
    public View h() {
        this.f52661o = true;
        return this.f52653g;
    }

    @Override // com.transsion.home.preload.b
    public void reset() {
        this.f52647a = null;
        this.f52650d = null;
        this.f52651e = null;
        this.f52648b = null;
        this.f52649c = null;
        this.f52652f = null;
        this.f52654h = false;
        this.f52658l = false;
        this.f52659m = false;
        this.f52655i = false;
        this.f52656j = false;
        this.f52657k = false;
        this.f52660n = false;
    }
}
