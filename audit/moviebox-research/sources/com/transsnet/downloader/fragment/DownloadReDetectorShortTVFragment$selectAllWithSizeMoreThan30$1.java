package com.transsnet.downloader.fragment;

import android.widget.FrameLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.PointerIconCompat;
import com.transsnet.downloader.adapter.DownloadShortTvEpListAdapter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$selectAllWithSizeMoreThan30$1", f = "DownloadReDetectorShortTVFragment.kt", l = {PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, PointerIconCompat.TYPE_ZOOM_OUT, 1022, InputDeviceCompat.SOURCE_GAMEPAD, 1030}, m = "invokeSuspend")
public final class DownloadReDetectorShortTVFragment$selectAllWithSizeMoreThan30$1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $isSelected;
    final /* synthetic */ Ref.ObjectRef<Map<Integer, f00.c>> $selectMap;
    int I$0;
    int I$1;
    long J$0;
    Object L$0;
    int label;
    final /* synthetic */ DownloadReDetectorShortTVFragment this$0;

    /* JADX INFO: renamed from: com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$selectAllWithSizeMoreThan30$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$selectAllWithSizeMoreThan30$1$1", f = "DownloadReDetectorShortTVFragment.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.IntRef $positionStart;
        int label;
        final /* synthetic */ DownloadReDetectorShortTVFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(DownloadReDetectorShortTVFragment downloadReDetectorShortTVFragment, Ref.IntRef intRef, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = downloadReDetectorShortTVFragment;
            this.$positionStart = intRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$positionStart, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            DownloadShortTvEpListAdapter downloadShortTvEpListAdapter = this.this$0.B;
            if (downloadShortTvEpListAdapter == null) {
                return null;
            }
            downloadShortTvEpListAdapter.notifyItemRangeChanged(this.$positionStart.element, 30);
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$selectAllWithSizeMoreThan30$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$selectAllWithSizeMoreThan30$1$2", f = "DownloadReDetectorShortTVFragment.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.IntRef $positionStart;
        int label;
        final /* synthetic */ DownloadReDetectorShortTVFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(DownloadReDetectorShortTVFragment downloadReDetectorShortTVFragment, Ref.IntRef intRef, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = downloadReDetectorShortTVFragment;
            this.$positionStart = intRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$positionStart, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            DownloadShortTvEpListAdapter downloadShortTvEpListAdapter = this.this$0.B;
            if (downloadShortTvEpListAdapter == null) {
                return null;
            }
            downloadShortTvEpListAdapter.notifyItemRangeChanged(this.$positionStart.element, this.this$0.C - this.$positionStart.element);
            return Unit.f68710a;
        }
    }

    /* JADX INFO: renamed from: com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$selectAllWithSizeMoreThan30$1$3, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$selectAllWithSizeMoreThan30$1$3", f = "DownloadReDetectorShortTVFragment.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ DownloadReDetectorShortTVFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(DownloadReDetectorShortTVFragment downloadReDetectorShortTVFragment, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.this$0 = downloadReDetectorShortTVFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            FrameLayout frameLayout;
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            if (!this.this$0.isAdded() || this.this$0.isDetached() || this.this$0.isRemoving()) {
                return Unit.f68710a;
            }
            h00.g0 g0Var = (h00.g0) this.this$0.getMViewBinding();
            if (g0Var != null && (frameLayout = g0Var.f65859h) != null) {
                so.c.g(frameLayout);
            }
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadReDetectorShortTVFragment$selectAllWithSizeMoreThan30$1(DownloadReDetectorShortTVFragment downloadReDetectorShortTVFragment, boolean z11, Ref.ObjectRef<Map<Integer, f00.c>> objectRef, Continuation<? super DownloadReDetectorShortTVFragment$selectAllWithSizeMoreThan30$1> continuation) {
        super(2, continuation);
        this.this$0 = downloadReDetectorShortTVFragment;
        this.$isSelected = z11;
        this.$selectMap = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadReDetectorShortTVFragment$selectAllWithSizeMoreThan30$1(this.this$0, this.$isSelected, this.$selectMap, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadReDetectorShortTVFragment$selectAllWithSizeMoreThan30$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0082  */
    /* JADX WARN: Code duplicated, block: B:21:0x008a  */
    /* JADX WARN: Code duplicated, block: B:24:0x0095  */
    /* JADX WARN: Code duplicated, block: B:26:0x0098  */
    /* JADX WARN: Code duplicated, block: B:28:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:31:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:34:0x00be  */
    /* JADX WARN: Code duplicated, block: B:42:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:43:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:46:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:49:0x0103  */
    /* JADX WARN: Code duplicated, block: B:52:0x0117  */
    /* JADX WARN: Code duplicated, block: B:54:0x0132 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:55:0x0133  */
    /* JADX WARN: Code duplicated, block: B:58:0x014b A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:59:0x014c  */
    /* JADX WARN: Code duplicated, block: B:60:0x0159  */
    /* JADX WARN: Code duplicated, block: B:62:0x0162  */
    /* JADX WARN: Code duplicated, block: B:64:0x017e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:65:0x017f  */
    /* JADX WARN: Code duplicated, block: B:68:0x0195 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:70:0x019e  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:67:0x0193 -> B:69:0x0196). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x019e -> B:71:0x01a2). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:65:0x017f
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            Method dump skipped, instruction units count: 491
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.fragment.DownloadReDetectorShortTVFragment$selectAllWithSizeMoreThan30$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
