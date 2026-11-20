package com.transsion.home.adapter.suboperate.provider;

import com.mbridge.msdk.playercommon.exoplayer2.extractor.ts.TsExtractor;
import com.transsion.edcation.CourseManager;
import com.transsion.edcation.bean.CourseBean;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.flow.u0;
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
@DebugMetadata(c = "com.transsion.home.adapter.suboperate.provider.SubHorizontalBannerProvider$registerCourse$1", f = "SubHorizontalBannerProvider.kt", l = {TsExtractor.TS_STREAM_TYPE_AC3}, m = "invokeSuspend")
public final class SubHorizontalBannerProvider$registerCourse$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SubHorizontalBannerProvider this$0;

    /* JADX INFO: renamed from: com.transsion.home.adapter.suboperate.provider.SubHorizontalBannerProvider$registerCourse$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @SourceDebugExtension
    public static final class AnonymousClass1 implements kotlinx.coroutines.flow.b<CourseBean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SubHorizontalBannerProvider f52145a;

        public AnonymousClass1(SubHorizontalBannerProvider subHorizontalBannerProvider) {
            this.f52145a = subHorizontalBannerProvider;
        }

        /* JADX WARN: Code duplicated, block: B:23:0x0069  */
        /* JADX WARN: Code duplicated, block: B:25:0x0071  */
        /* JADX WARN: Code duplicated, block: B:28:0x007d  */
        /* JADX WARN: Code duplicated, block: B:29:0x0082  */
        /* JADX WARN: Code duplicated, block: B:34:0x008c  */
        /* JADX WARN: Code duplicated, block: B:37:0x00b0 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:38:0x00b1 A[EDGE_INSN: B:38:0x00b1->B:39:0x00b4 BREAK  A[LOOP:0: B:21:0x0063->B:40:0x00b8]] */
        /* JADX WARN: Code duplicated, block: B:40:0x00b8 A[LOOP:0: B:21:0x0063->B:40:0x00b8, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:44:0x0089 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:7:0x0013  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00b1 -> B:39:0x00b4). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:37:0x00b0
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        @Override // kotlinx.coroutines.flow.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final java.lang.Object emit(com.transsion.edcation.bean.CourseBean r11, kotlin.coroutines.Continuation<? super kotlin.Unit> r12) {
            /*
                r10 = this;
                boolean r0 = r12 instanceof com.transsion.home.adapter.suboperate.provider.SubHorizontalBannerProvider$registerCourse$1$1$emit$1
                if (r0 == 0) goto L13
                r0 = r12
                com.transsion.home.adapter.suboperate.provider.SubHorizontalBannerProvider$registerCourse$1$1$emit$1 r0 = (com.transsion.home.adapter.suboperate.provider.SubHorizontalBannerProvider$registerCourse$1$1$emit$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.label = r1
                goto L18
            L13:
                com.transsion.home.adapter.suboperate.provider.SubHorizontalBannerProvider$registerCourse$1$1$emit$1 r0 = new com.transsion.home.adapter.suboperate.provider.SubHorizontalBannerProvider$registerCourse$1$1$emit$1
                r0.<init>(r10, r12)
            L18:
                java.lang.Object r12 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.e()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L40
                if (r2 != r3) goto L38
                int r11 = r0.I$0
                java.lang.Object r2 = r0.L$2
                java.util.Iterator r2 = (java.util.Iterator) r2
                java.lang.Object r4 = r0.L$1
                com.transsion.home.adapter.suboperate.provider.SubHorizontalBannerProvider r4 = (com.transsion.home.adapter.suboperate.provider.SubHorizontalBannerProvider) r4
                java.lang.Object r5 = r0.L$0
                com.transsion.edcation.bean.CourseBean r5 = (com.transsion.edcation.bean.CourseBean) r5
                kotlin.ResultKt.b(r12)
                goto Lb4
            L38:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r12)
                throw r11
            L40:
                kotlin.ResultKt.b(r12)
                com.transsion.home.adapter.suboperate.provider.SubHorizontalBannerProvider r12 = r10.f52145a
                com.transsion.moviedetailapi.bean.OperateItem r12 = com.transsion.home.adapter.suboperate.provider.SubHorizontalBannerProvider.z(r12)
                if (r12 == 0) goto Lba
                com.transsion.moviedetailapi.bean.BannerBean r12 = r12.getBanner()
                if (r12 == 0) goto Lba
                java.util.List r12 = r12.getBanners()
                if (r12 == 0) goto Lba
                java.lang.Iterable r12 = (java.lang.Iterable) r12
                com.transsion.home.adapter.suboperate.provider.SubHorizontalBannerProvider r2 = r10.f52145a
                java.util.Iterator r12 = r12.iterator()
                r4 = 0
                r9 = r2
                r2 = r12
                r12 = r9
            L63:
                boolean r5 = r2.hasNext()
                if (r5 == 0) goto Lba
                java.lang.Object r5 = r2.next()
                int r6 = r4 + 1
                if (r4 >= 0) goto L74
                kotlin.collections.CollectionsKt.u()
            L74:
                com.transsion.moviedetailapi.bean.BannerData r5 = (com.transsion.moviedetailapi.bean.BannerData) r5
                java.lang.String r4 = r11.getSubjectId()
                r7 = 0
                if (r5 == 0) goto L82
                java.lang.String r8 = r5.getSubjectId()
                goto L83
            L82:
                r8 = r7
            L83:
                boolean r4 = kotlin.jvm.internal.Intrinsics.b(r4, r8)
                if (r4 == 0) goto Lb8
                if (r5 != 0) goto L8c
                goto L97
            L8c:
                int r4 = r11.getSeenStatus()
                java.lang.Integer r4 = kotlin.coroutines.jvm.internal.Boxing.d(r4)
                r5.setSeenStatus(r4)
            L97:
                kotlinx.coroutines.a2 r4 = kotlinx.coroutines.w0.c()
                com.transsion.home.adapter.suboperate.provider.SubHorizontalBannerProvider$registerCourse$1$1$emit$2$1 r5 = new com.transsion.home.adapter.suboperate.provider.SubHorizontalBannerProvider$registerCourse$1$1$emit$2$1
                r5.<init>(r12, r7)
                r0.L$0 = r11
                r0.L$1 = r12
                r0.L$2 = r2
                r0.I$0 = r6
                r0.label = r3
                java.lang.Object r4 = kotlinx.coroutines.h.g(r4, r5, r0)
                if (r4 != r1) goto Lb1
                return r1
            Lb1:
                r5 = r11
                r4 = r12
                r11 = r6
            Lb4:
                r12 = r4
                r4 = r11
                r11 = r5
                goto L63
            Lb8:
                r4 = r6
                goto L63
            Lba:
                kotlin.Unit r11 = kotlin.Unit.f68710a
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.transsion.home.adapter.suboperate.provider.SubHorizontalBannerProvider$registerCourse$1.AnonymousClass1.emit(com.transsion.edcation.bean.CourseBean, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubHorizontalBannerProvider$registerCourse$1(SubHorizontalBannerProvider subHorizontalBannerProvider, Continuation<? super SubHorizontalBannerProvider$registerCourse$1> continuation) {
        super(2, continuation);
        this.this$0 = subHorizontalBannerProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubHorizontalBannerProvider$registerCourse$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((SubHorizontalBannerProvider$registerCourse$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            u0<CourseBean> u0VarH = CourseManager.f51853a.h();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0);
            this.label = 1;
            if (u0VarH.a(anonymousClass1, this) == objE) {
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
