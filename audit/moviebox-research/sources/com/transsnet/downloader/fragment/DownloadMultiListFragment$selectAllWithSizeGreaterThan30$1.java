package com.transsnet.downloader.fragment;

import com.transsion.baselib.db.download.DownloadBean;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;

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
@DebugMetadata(c = "com.transsnet.downloader.fragment.DownloadMultiListFragment$selectAllWithSizeGreaterThan30$1", f = "DownloadMultiListFragment.kt", l = {342, 345, 348, 351, 355}, m = "invokeSuspend")
@SourceDebugExtension
public final class DownloadMultiListFragment$selectAllWithSizeGreaterThan30$1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<DownloadBean> $data;
    final /* synthetic */ boolean $isSelected;
    final /* synthetic */ int $size;
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    final /* synthetic */ DownloadMultiListFragment this$0;

    /* JADX INFO: renamed from: com.transsnet.downloader.fragment.DownloadMultiListFragment$selectAllWithSizeGreaterThan30$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: source.java */
    @Metadata
    @DebugMetadata(c = "com.transsnet.downloader.fragment.DownloadMultiListFragment$selectAllWithSizeGreaterThan30$1$2", f = "DownloadMultiListFragment.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.LongRef $totalSize;
        int label;
        final /* synthetic */ DownloadMultiListFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(DownloadMultiListFragment downloadMultiListFragment, Ref.LongRef longRef, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = downloadMultiListFragment;
            this.$totalSize = longRef;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$totalSize, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            CopyOnWriteArrayList<DownloadBean> copyOnWriteArrayListL0;
            List<DownloadBean> listD;
            CopyOnWriteArrayList<DownloadBean> copyOnWriteArrayListL1;
            kotlin.coroutines.intrinsics.a.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            if (!this.this$0.isAdded() || this.this$0.isDetached() || this.this$0.isRemoving()) {
                return Unit.f68710a;
            }
            g00.c cVar = this.this$0.V;
            if (cVar != null) {
                cVar.H(this.this$0.f60650x, Boxing.e(this.$totalSize.element));
            }
            g00.c cVar2 = this.this$0.V;
            if (cVar2 != null) {
                cVar2.f0(false);
            }
            com.transsnet.downloader.adapter.f fVar = this.this$0.f60648v;
            if (fVar != null && (copyOnWriteArrayListL0 = fVar.L0()) != null) {
                DownloadMultiListFragment downloadMultiListFragment = this.this$0;
                uo.b.a aVar = uo.b.f78622a;
                String TAG = downloadMultiListFragment.X0();
                Intrinsics.f(TAG, "TAG");
                com.transsnet.downloader.adapter.f fVar2 = downloadMultiListFragment.f60648v;
                Integer numD = null;
                Integer numD2 = (fVar2 == null || (copyOnWriteArrayListL1 = fVar2.L0()) == null) ? null : Boxing.d(copyOnWriteArrayListL1.size());
                int i11 = downloadMultiListFragment.T;
                com.transsnet.downloader.adapter.f fVar3 = downloadMultiListFragment.f60648v;
                if (fVar3 != null && (listD = fVar3.D()) != null) {
                    numD = Boxing.d(listD.size());
                }
                uo.b.a.s(aVar, TAG, "selectAllWithSizeGreaterThan30,checkedSize = " + numD2 + ",unableSize = " + i11 + ", dataSize = " + numD, false, 4, null);
                downloadMultiListFragment.f2();
                g00.c cVar3 = downloadMultiListFragment.V;
                if (cVar3 != null) {
                    int i12 = downloadMultiListFragment.f60650x;
                    int size = copyOnWriteArrayListL0.size() + downloadMultiListFragment.T;
                    com.transsnet.downloader.adapter.f fVar4 = downloadMultiListFragment.f60648v;
                    Intrinsics.d(fVar4);
                    cVar3.q(i12, copyOnWriteArrayListL0, size == fVar4.D().size());
                }
            }
            return Unit.f68710a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DownloadMultiListFragment$selectAllWithSizeGreaterThan30$1(List<DownloadBean> list, DownloadMultiListFragment downloadMultiListFragment, boolean z11, int i11, Continuation<? super DownloadMultiListFragment$selectAllWithSizeGreaterThan30$1> continuation) {
        super(2, continuation);
        this.$data = list;
        this.this$0 = downloadMultiListFragment;
        this.$isSelected = z11;
        this.$size = i11;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DownloadMultiListFragment$selectAllWithSizeGreaterThan30$1(this.$data, this.this$0, this.$isSelected, this.$size, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
        return ((DownloadMultiListFragment$selectAllWithSizeGreaterThan30$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:21:0x00db  */
    /* JADX WARN: Code duplicated, block: B:24:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:28:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:29:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:32:0x010a  */
    /* JADX WARN: Code duplicated, block: B:37:0x011b  */
    /* JADX WARN: Code duplicated, block: B:39:0x013d A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x013e  */
    /* JADX WARN: Code duplicated, block: B:43:0x0161 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:44:0x0162  */
    /* JADX WARN: Code duplicated, block: B:47:0x0178  */
    /* JADX WARN: Code duplicated, block: B:49:0x017e  */
    /* JADX WARN: Code duplicated, block: B:51:0x019e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:52:0x019f  */
    /* JADX WARN: Code duplicated, block: B:55:0x01c0 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:57:0x01ce  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x01be -> B:56:0x01c1). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:19:0x00d3
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r23) {
        /*
            Method dump skipped, instruction units count: 512
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.transsnet.downloader.fragment.DownloadMultiListFragment$selectAllWithSizeGreaterThan30$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
