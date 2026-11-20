package com.transsion.ad.middle.splash;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.transsion.ad.middle.splash.NonSplashActivity$showCountDown$2", f = "NonSplashActivity.kt", l = {388}, m = "invokeSuspend")
public final class NonSplashActivity$showCountDown$2 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $countDownSeconds;
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    Object L$0;
    int label;
    final /* synthetic */ NonSplashActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NonSplashActivity$showCountDown$2(int i11, NonSplashActivity nonSplashActivity, Continuation<? super NonSplashActivity$showCountDown$2> continuation) {
        super(2, continuation);
        this.$countDownSeconds = i11;
        this.this$0 = nonSplashActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NonSplashActivity$showCountDown$2(this.$countDownSeconds, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((NonSplashActivity$showCountDown$2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:10:0x0033  */
    /* JADX WARN: Code duplicated, block: B:12:0x0047 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:13:0x0048  */
    /* JADX WARN: Code duplicated, block: B:17:0x0050  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0048 -> B:14:0x0049). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.e()
            int r1 = r12.label
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L25
            if (r1 != r3) goto L1d
            int r1 = r12.I$3
            int r4 = r12.I$2
            int r5 = r12.I$1
            int r6 = r12.I$0
            java.lang.Object r7 = r12.L$0
            com.transsion.ad.middle.splash.NonSplashActivity r7 = (com.transsion.ad.middle.splash.NonSplashActivity) r7
            kotlin.ResultKt.b(r13)
            r13 = r12
            goto L49
        L1d:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L25:
            kotlin.ResultKt.b(r13)
            int r13 = r12.$countDownSeconds
            com.transsion.ad.middle.splash.NonSplashActivity r1 = r12.this$0
            r5 = r13
            r6 = r5
            r7 = r1
            r1 = 0
            r13 = r12
        L31:
            if (r1 >= r6) goto L7b
            r13.L$0 = r7
            r13.I$0 = r6
            r13.I$1 = r5
            r13.I$2 = r1
            r13.I$3 = r1
            r13.label = r3
            r8 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r4 = kotlinx.coroutines.r0.a(r8, r13)
            if (r4 != r0) goto L48
            return r0
        L48:
            r4 = r1
        L49:
            android.widget.TextView r8 = com.transsion.ad.middle.splash.NonSplashActivity.Q(r7)
            if (r8 != 0) goto L50
            goto L78
        L50:
            kotlin.jvm.internal.StringCompanionObject r9 = kotlin.jvm.internal.StringCompanionObject.f68912a
            int r9 = com.transsion.ad.R$string.skip_ad
            java.lang.String r9 = r7.getString(r9)
            java.lang.String r10 = "getString(R.string.skip_ad)"
            kotlin.jvm.internal.Intrinsics.f(r9, r10)
            java.lang.Object[] r10 = new java.lang.Object[r3]
            int r11 = r5 + (-1)
            int r11 = r11 - r1
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.d(r11)
            r10[r2] = r1
            java.lang.Object[] r1 = java.util.Arrays.copyOf(r10, r3)
            java.lang.String r1 = java.lang.String.format(r9, r1)
            java.lang.String r9 = "format(...)"
            kotlin.jvm.internal.Intrinsics.f(r1, r9)
            r8.setText(r1)
        L78:
            int r1 = r4 + 1
            goto L31
        L7b:
            com.transsion.ad.middle.splash.NonSplashActivity r13 = r13.this$0
            r13.finish()
            kotlin.Unit r13 = kotlin.Unit.f68710a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsion.ad.middle.splash.NonSplashActivity$showCountDown$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
