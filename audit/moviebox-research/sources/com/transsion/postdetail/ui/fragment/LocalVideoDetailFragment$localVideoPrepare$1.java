package com.transsion.postdetail.ui.fragment;

import android.media.MediaMetadataRetriever;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

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
@DebugMetadata(c = "com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$localVideoPrepare$1", f = "LocalVideoDetailFragment.kt", l = {960}, m = "invokeSuspend")
public final class LocalVideoDetailFragment$localVideoPrepare$1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $path;
    int label;
    final /* synthetic */ LocalVideoDetailFragment this$0;

    /* JADX INFO: renamed from: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$localVideoPrepare$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$localVideoPrepare$1$1", f = "LocalVideoDetailFragment.kt", l = {957}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.b<? super Triple<? extends Integer, ? extends Integer, ? extends Long>>, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $path;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ LocalVideoDetailFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, LocalVideoDetailFragment localVideoDetailFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$path = str;
            this.this$0 = localVideoDetailFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$path, this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.flow.b<? super Triple<? extends Integer, ? extends Integer, ? extends Long>> bVar, Continuation<? super Unit> continuation) {
            return invoke2((kotlinx.coroutines.flow.b<? super Triple<Integer, Integer, Long>>) bVar, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.flow.b<? super Triple<Integer, Integer, Long>> bVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(bVar, continuation)).invokeSuspend(Unit.f68710a);
        }

        /* JADX WARN: Code duplicated, block: B:18:0x005e  */
        /* JADX WARN: Code duplicated, block: B:24:0x0079  */
        /* JADX WARN: Code duplicated, block: B:30:0x0094  */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            int iIntValue;
            int iIntValue2;
            long jLongValue;
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                kotlinx.coroutines.flow.b bVar = (kotlinx.coroutines.flow.b) this.L$0;
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                Ref.IntRef intRef = new Ref.IntRef();
                Ref.IntRef intRef2 = new Ref.IntRef();
                Ref.LongRef longRef = new Ref.LongRef();
                try {
                    try {
                        String str = this.$path;
                        LocalVideoDetailFragment localVideoDetailFragment = this.this$0;
                        mediaMetadataRetriever.setDataSource(str);
                        String strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                        if (strExtractMetadata != null) {
                            Intrinsics.f(strExtractMetadata, "extractMetadata(MediaMet…METADATA_KEY_VIDEO_WIDTH)");
                            Integer numL = kotlin.text.k.l(strExtractMetadata);
                            if (numL != null) {
                                iIntValue = numL.intValue();
                            } else {
                                iIntValue = 0;
                            }
                        } else {
                            iIntValue = 0;
                        }
                        intRef.element = iIntValue;
                        String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                        if (strExtractMetadata2 != null) {
                            Intrinsics.f(strExtractMetadata2, "extractMetadata(MediaMet…ETADATA_KEY_VIDEO_HEIGHT)");
                            Integer numL2 = kotlin.text.k.l(strExtractMetadata2);
                            if (numL2 != null) {
                                iIntValue2 = numL2.intValue();
                            } else {
                                iIntValue2 = 0;
                            }
                        } else {
                            iIntValue2 = 0;
                        }
                        intRef2.element = iIntValue2;
                        String strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(9);
                        if (strExtractMetadata3 != null) {
                            Intrinsics.f(strExtractMetadata3, "extractMetadata(MediaMet…er.METADATA_KEY_DURATION)");
                            Long lN = kotlin.text.k.n(strExtractMetadata3);
                            if (lN != null) {
                                jLongValue = lN.longValue();
                            } else {
                                jLongValue = 0;
                            }
                        } else {
                            jLongValue = 0;
                        }
                        longRef.element = jLongValue;
                        uo.b.a aVar = uo.b.f78622a;
                        uo.b.a.f(aVar, localVideoDetailFragment.f55673k, "play width:" + intRef.element + ",height:" + intRef2.element, false, 4, null);
                        uo.b.a.f(aVar, localVideoDetailFragment.f55673k, "play duration:" + longRef.element, false, 4, null);
                    } catch (Exception e11) {
                        e11.printStackTrace();
                        intRef.element = 0;
                        intRef2.element = 0;
                        longRef.element = 0L;
                    }
                    mediaMetadataRetriever.release();
                    Triple triple = new Triple(Boxing.d(intRef.element), Boxing.d(intRef2.element), Boxing.e(longRef.element));
                    this.label = 1;
                    if (bVar.emit(triple, this) == objE) {
                        return objE;
                    }
                } catch (Throwable th2) {
                    mediaMetadataRetriever.release();
                    throw th2;
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

    /* JADX INFO: renamed from: com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$localVideoPrepare$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.postdetail.ui.fragment.LocalVideoDetailFragment$localVideoPrepare$1$2", f = "LocalVideoDetailFragment.kt", l = {959}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.b<? super Triple<? extends Integer, ? extends Integer, ? extends Long>>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(kotlinx.coroutines.flow.b<? super Triple<? extends Integer, ? extends Integer, ? extends Long>> bVar, Throwable th2, Continuation<? super Unit> continuation) {
            return invoke2((kotlinx.coroutines.flow.b<? super Triple<Integer, Integer, Long>>) bVar, th2, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(kotlinx.coroutines.flow.b<? super Triple<Integer, Integer, Long>> bVar, Throwable th2, Continuation<? super Unit> continuation) {
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
                kotlinx.coroutines.flow.b bVar = (kotlinx.coroutines.flow.b) this.L$0;
                Triple triple = new Triple(Boxing.d(0), Boxing.d(0), Boxing.e(0L));
                this.label = 1;
                if (bVar.emit(triple, this) == objE) {
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
    public static final class a<T> implements kotlinx.coroutines.flow.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LocalVideoDetailFragment f55708a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f55709b;

        public a(LocalVideoDetailFragment localVideoDetailFragment, String str) {
            this.f55708a = localVideoDetailFragment;
            this.f55709b = str;
        }

        @Override // kotlinx.coroutines.flow.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(Triple<Integer, Integer, Long> triple, Continuation<? super Unit> continuation) {
            uo.b.a.s(uo.b.f78622a, this.f55708a.f55673k, "Prepare success width = " + triple.getFirst() + "， height = " + triple.getSecond() + " ,duration = " + triple.getThird() + ",completed = " + this.f55708a.f55700z, false, 4, null);
            this.f55708a.H = triple.getThird().longValue();
            this.f55708a.I = triple.getFirst().intValue();
            this.f55708a.J = triple.getSecond().intValue();
            this.f55708a.p3(triple.getFirst().intValue(), triple.getSecond().intValue(), this.f55709b);
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LocalVideoDetailFragment$localVideoPrepare$1(String str, LocalVideoDetailFragment localVideoDetailFragment, Continuation<? super LocalVideoDetailFragment$localVideoPrepare$1> continuation) {
        super(2, continuation);
        this.$path = str;
        this.this$0 = localVideoDetailFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LocalVideoDetailFragment$localVideoPrepare$1(this.$path, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
        return ((LocalVideoDetailFragment$localVideoPrepare$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            kotlinx.coroutines.flow.a aVarE = kotlinx.coroutines.flow.c.e(kotlinx.coroutines.flow.c.q(kotlinx.coroutines.flow.c.o(new AnonymousClass1(this.$path, this.this$0, null)), kotlinx.coroutines.w0.b()), new AnonymousClass2(null));
            a aVar = new a(this.this$0, this.$path);
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
