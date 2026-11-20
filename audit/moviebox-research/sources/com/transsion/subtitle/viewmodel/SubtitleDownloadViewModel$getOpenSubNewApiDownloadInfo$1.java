package com.transsion.subtitle.viewmodel;

import com.transsion.subtitle.bean.OpenSubtitleDownloadInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.b;
import kotlinx.coroutines.flow.c;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel$getOpenSubNewApiDownloadInfo$1", f = "SubtitleDownloadViewModel.kt", l = {164}, m = "invokeSuspend")
public final class SubtitleDownloadViewModel$getOpenSubNewApiDownloadInfo$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ vx.a $item;
    int label;
    final /* synthetic */ SubtitleDownloadViewModel this$0;

    /* JADX INFO: renamed from: com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel$getOpenSubNewApiDownloadInfo$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel$getOpenSubNewApiDownloadInfo$1$1", f = "SubtitleDownloadViewModel.kt", l = {161, 161}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<b<? super OpenSubtitleDownloadInfo>, Continuation<? super Unit>, Object> {
        final /* synthetic */ vx.a $item;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(vx.a aVar, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$item = aVar;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$item, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(b<? super OpenSubtitleDownloadInfo> bVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(bVar, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            b bVar;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 != 0) {
                if (i11 == 1) {
                    bVar = (b) this.L$0;
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
            bVar = (b) this.L$0;
            com.transsion.subtitle.helper.b bVar2 = com.transsion.subtitle.helper.b.f58260a;
            String strC = this.$item.c();
            Intrinsics.d(strC);
            this.L$0 = bVar;
            this.label = 1;
            obj = bVar2.d(strC, this);
            if (obj == objE) {
                return objE;
            }
            this.L$0 = null;
            this.label = 2;
            if (bVar.emit(obj, this) == objE) {
                return objE;
            }
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel$getOpenSubNewApiDownloadInfo$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.subtitle.viewmodel.SubtitleDownloadViewModel$getOpenSubNewApiDownloadInfo$1$2", f = "SubtitleDownloadViewModel.kt", l = {163}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<b<? super OpenSubtitleDownloadInfo>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(b<? super OpenSubtitleDownloadInfo> bVar, Throwable th2, Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(continuation);
            anonymousClass2.L$0 = bVar;
            return anonymousClass2.invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                b bVar = (b) this.L$0;
                this.label = 1;
                if (bVar.emit(null, this) == objE) {
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

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a<T> implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ vx.a f58330a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SubtitleDownloadViewModel f58331b;

        public a(vx.a aVar, SubtitleDownloadViewModel subtitleDownloadViewModel) {
            this.f58330a = aVar;
            this.f58331b = subtitleDownloadViewModel;
        }

        @Override // kotlinx.coroutines.flow.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(OpenSubtitleDownloadInfo openSubtitleDownloadInfo, Continuation<? super Unit> continuation) {
            if (openSubtitleDownloadInfo != null && openSubtitleDownloadInfo.getLink().length() > 0) {
                this.f58330a.b().setUrl(openSubtitleDownloadInfo.getLink());
                this.f58331b.j().n(this.f58330a);
            }
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubtitleDownloadViewModel$getOpenSubNewApiDownloadInfo$1(vx.a aVar, SubtitleDownloadViewModel subtitleDownloadViewModel, Continuation<? super SubtitleDownloadViewModel$getOpenSubNewApiDownloadInfo$1> continuation) {
        super(2, continuation);
        this.$item = aVar;
        this.this$0 = subtitleDownloadViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SubtitleDownloadViewModel$getOpenSubNewApiDownloadInfo$1(this.$item, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((SubtitleDownloadViewModel$getOpenSubNewApiDownloadInfo$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.a aVarE = c.e(c.o(new AnonymousClass1(this.$item, null)), new AnonymousClass2(null));
            a aVar = new a(this.$item, this.this$0);
            this.label = 1;
            if (aVarE.a(aVar, this) == objE) {
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
