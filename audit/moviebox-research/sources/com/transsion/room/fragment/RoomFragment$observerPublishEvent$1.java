package com.transsion.room.fragment;

import com.transsion.moviedetailapi.bean.RoomItem;
import com.transsnet.flow.event.sync.event.PublishEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
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
@DebugMetadata(c = "com.transsion.room.fragment.RoomFragment$observerPublishEvent$1", f = "RoomFragment.kt", l = {}, m = "invokeSuspend")
@SourceDebugExtension
public final class RoomFragment$observerPublishEvent$1 extends SuspendLambda implements Function2<kotlinx.coroutines.k0, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ RoomFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomFragment$observerPublishEvent$1(RoomFragment roomFragment, Continuation<? super RoomFragment$observerPublishEvent$1> continuation) {
        super(2, continuation);
        this.this$0 = roomFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        RoomFragment$observerPublishEvent$1 roomFragment$observerPublishEvent$1 = new RoomFragment$observerPublishEvent$1(this.this$0, continuation);
        roomFragment$observerPublishEvent$1.L$0 = obj;
        return roomFragment$observerPublishEvent$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(kotlinx.coroutines.k0 k0Var, Continuation<? super Unit> continuation) {
        return ((RoomFragment$observerPublishEvent$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        kotlin.coroutines.intrinsics.a.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        kotlinx.coroutines.k0 k0Var = (kotlinx.coroutines.k0) this.L$0;
        final RoomFragment roomFragment = this.this$0;
        kotlinx.coroutines.j.d(k0Var, null, null, new RoomFragment$observerPublishEvent$1$invokeSuspend$$inlined$observeEvent$1(false, new Function1<PublishEvent, Unit>() { // from class: com.transsion.room.fragment.RoomFragment$observerPublishEvent$1.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(PublishEvent publishEvent) {
                invoke2(publishEvent);
                return Unit.f68710a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PublishEvent it) {
                List<RoomItem> listD;
                Intrinsics.g(it, "it");
                com.transsion.room.adapter.b bVar = roomFragment.f57185c;
                if (bVar == null || (listD = bVar.D()) == null) {
                    return;
                }
                RoomFragment roomFragment2 = roomFragment;
                int i11 = 0;
                for (Object obj2 : listD) {
                    int i12 = i11 + 1;
                    if (i11 < 0) {
                        kotlin.collections.g.u();
                    }
                    RoomItem roomItem = (RoomItem) obj2;
                    if (Intrinsics.b(it.getGroupId(), roomItem.getGroupId())) {
                        Long postCount = roomItem.getPostCount();
                        roomItem.setPostCount(postCount != null ? Long.valueOf(postCount.longValue() + 1) : null);
                        com.transsion.room.adapter.b bVar2 = roomFragment2.f57185c;
                        if (bVar2 != null) {
                            bVar2.notifyItemChanged(i11);
                            return;
                        }
                        return;
                    }
                    i11 = i12;
                }
            }
        }, null), 3, null);
        return Unit.f68710a;
    }
}
