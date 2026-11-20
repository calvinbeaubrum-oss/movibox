package com.transsion.room.fragment;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.ViewGroup;
import com.google.android.material.imageview.ShapeableImageView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.SourceDebugExtension;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1", f = "RoomDetailFragment.kt", l = {596}, m = "invokeSuspend")
@SourceDebugExtension
public final class RoomDetailFragment$showCover$2$onResourceReady$1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bitmap $resource;
    int label;
    final /* synthetic */ RoomDetailFragment this$0;

    /* JADX INFO: renamed from: com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1$1", f = "RoomDetailFragment.kt", l = {591}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.flow.b<? super Bitmap>, Continuation<? super Unit>, Object> {
        final /* synthetic */ Bitmap $resource;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Bitmap bitmap, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$resource = bitmap;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$resource, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.flow.b<? super Bitmap> bVar, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(bVar, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kotlin.coroutines.intrinsics.a.e();
            int i11 = this.label;
            if (i11 == 0) {
                ResultKt.b(obj);
                kotlinx.coroutines.flow.b bVar = (kotlinx.coroutines.flow.b) this.L$0;
                Bitmap bitmap = this.$resource;
                this.label = 1;
                if (bVar.emit(bitmap, this) == objE) {
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

    /* JADX INFO: renamed from: com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1$3", f = "RoomDetailFragment.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.b<? super Bitmap>, Throwable, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(3, continuation);
        }

        @Override // kotlin.jvm.functions.Function3
        public final Object invoke(kotlinx.coroutines.flow.b<? super Bitmap> bVar, Throwable th2, Continuation<? super Unit> continuation) {
            return new AnonymousClass3(continuation).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return Unit.f68710a;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a<T> implements kotlinx.coroutines.flow.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomDetailFragment f57162a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Bitmap f57163b;

        public a(RoomDetailFragment roomDetailFragment, Bitmap bitmap) {
            this.f57162a = roomDetailFragment;
            this.f57163b = bitmap;
        }

        @Override // kotlinx.coroutines.flow.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object emit(Bitmap bitmap, Continuation<? super Unit> continuation) {
            ShapeableImageView shapeableImageView;
            ShapeableImageView shapeableImageView2;
            ShapeableImageView shapeableImageView3;
            if (!this.f57162a.isAdded() || this.f57162a.isRemoving() || this.f57162a.isDetached()) {
                return Unit.f68710a;
            }
            sw.i mViewBinding = this.f57162a.getMViewBinding();
            if (mViewBinding != null) {
                mViewBinding.f76506d.setBackground(new BitmapDrawable(this.f57162a.getResources(), bitmap));
                ViewGroup.LayoutParams layoutParams = mViewBinding.f76505c.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.height = mViewBinding.f76506d.getMeasuredHeight();
                }
                mViewBinding.f76505c.setLayoutParams(layoutParams);
            }
            if (this.f57163b.getHeight() < com.blankj.utilcode.util.f0.a(56.0f)) {
                sw.i mViewBinding2 = this.f57162a.getMViewBinding();
                if (mViewBinding2 != null && (shapeableImageView3 = mViewBinding2.f76511j) != null) {
                    shapeableImageView3.setImageBitmap(bitmap);
                }
                sw.i mViewBinding3 = this.f57162a.getMViewBinding();
                if (mViewBinding3 != null && (shapeableImageView2 = mViewBinding3.f76511j) != null) {
                    so.c.k(shapeableImageView2);
                }
            } else {
                sw.i mViewBinding4 = this.f57162a.getMViewBinding();
                if (mViewBinding4 != null && (shapeableImageView = mViewBinding4.f76511j) != null) {
                    so.c.g(shapeableImageView);
                }
            }
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomDetailFragment$showCover$2$onResourceReady$1(Bitmap bitmap, RoomDetailFragment roomDetailFragment, Continuation<? super RoomDetailFragment$showCover$2$onResourceReady$1> continuation) {
        super(2, continuation);
        this.$resource = bitmap;
        this.this$0 = roomDetailFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RoomDetailFragment$showCover$2$onResourceReady$1(this.$resource, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
        return ((RoomDetailFragment$showCover$2$onResourceReady$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 == 0) {
            ResultKt.b(obj);
            final kotlinx.coroutines.flow.a aVarO = kotlinx.coroutines.flow.c.o(new AnonymousClass1(this.$resource, null));
            kotlinx.coroutines.flow.a aVarE = kotlinx.coroutines.flow.c.e(kotlinx.coroutines.flow.c.q(new kotlinx.coroutines.flow.a<Bitmap>() { // from class: com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1$invokeSuspend$$inlined$map$1

                /* JADX INFO: renamed from: com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                /* JADX INFO: compiled from: source.java */
                @Metadata
                @SourceDebugExtension
                public static final class AnonymousClass2<T> implements kotlinx.coroutines.flow.b {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public final /* synthetic */ kotlinx.coroutines.flow.b f57165a;

                    /* JADX INFO: renamed from: com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                    /* JADX INFO: compiled from: source.java */
                    @Metadata
                    @DebugMetadata(c = "com.transsion.room.fragment.RoomDetailFragment$showCover$2$onResourceReady$1$invokeSuspend$$inlined$map$1$2", f = "RoomDetailFragment.kt", l = {219}, m = "emit")
                    @SourceDebugExtension
                    public static final class AnonymousClass1 extends ContinuationImpl {
                        Object L$0;
                        int label;
                        /* synthetic */ Object result;

                        public AnonymousClass1(Continuation continuation) {
                            super(continuation);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            this.result = obj;
                            this.label |= Integer.MIN_VALUE;
                            return AnonymousClass2.this.emit(null, this);
                        }
                    }

                    public AnonymousClass2(kotlinx.coroutines.flow.b bVar) {
                        this.f57165a = bVar;
                    }

                    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
                    @Override // kotlinx.coroutines.flow.b
                    public final Object emit(Object obj, Continuation continuation) throws Throwable {
                        AnonymousClass1 anonymousClass1;
                        if (continuation instanceof AnonymousClass1) {
                            anonymousClass1 = (AnonymousClass1) continuation;
                            int i11 = anonymousClass1.label;
                            if ((i11 & Integer.MIN_VALUE) != 0) {
                                anonymousClass1.label = i11 - Integer.MIN_VALUE;
                            } else {
                                anonymousClass1 = new AnonymousClass1(continuation);
                            }
                        } else {
                            anonymousClass1 = new AnonymousClass1(continuation);
                        }
                        Object obj2 = anonymousClass1.result;
                        Object objE = kotlin.coroutines.intrinsics.a.e();
                        int i12 = anonymousClass1.label;
                        if (i12 == 0) {
                            ResultKt.b(obj2);
                            kotlinx.coroutines.flow.b bVar = this.f57165a;
                            Bitmap bitmapA = qo.b.a((Bitmap) obj, 50, false);
                            anonymousClass1.label = 1;
                            if (bVar.emit(bitmapA, anonymousClass1) == objE) {
                                return objE;
                            }
                        } else {
                            if (i12 != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.b(obj2);
                        }
                        return Unit.f68710a;
                    }
                }

                @Override // kotlinx.coroutines.flow.a
                public Object a(kotlinx.coroutines.flow.b<? super Bitmap> bVar, Continuation continuation) {
                    Object objA = aVarO.a(new AnonymousClass2(bVar), continuation);
                    return objA == kotlin.coroutines.intrinsics.a.e() ? objA : Unit.f68710a;
                }
            }, w0.a()), new AnonymousClass3(null));
            a aVar = new a(this.this$0, this.$resource);
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
