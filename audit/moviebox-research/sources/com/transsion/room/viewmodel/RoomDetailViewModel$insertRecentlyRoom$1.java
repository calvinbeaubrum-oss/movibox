package com.transsion.room.viewmodel;

import com.transsion.baselib.db.room.RoomItemBean;
import com.transsion.moviedetailapi.bean.RoomItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.k0;
import yr.a;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.room.viewmodel.RoomDetailViewModel$insertRecentlyRoom$1", f = "RoomDetailViewModel.kt", l = {142, 143, 146}, m = "invokeSuspend")
@SourceDebugExtension
public final class RoomDetailViewModel$insertRecentlyRoom$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    final /* synthetic */ RoomItem $roomItem;
    int label;
    final /* synthetic */ RoomDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RoomDetailViewModel$insertRecentlyRoom$1(RoomItem roomItem, RoomDetailViewModel roomDetailViewModel, Continuation<? super RoomDetailViewModel$insertRecentlyRoom$1> continuation) {
        super(2, continuation);
        this.$roomItem = roomItem;
        this.this$0 = roomDetailViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RoomDetailViewModel$insertRecentlyRoom$1(this.$roomItem, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((RoomDetailViewModel$insertRecentlyRoom$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0090  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b2 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        RoomItemBean roomItemBean;
        a aVarJ;
        Object objA;
        a aVarJ2;
        RoomItemBean roomItemBean2;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        List list = null;
        if (i11 != 0) {
            if (i11 == 1) {
                ResultKt.b(obj);
            } else if (i11 == 2) {
                ResultKt.b(obj);
                objA = obj;
                list = (List) objA;
                if (list != null && list.size() > 5 && (aVarJ2 = this.this$0.j()) != null) {
                    roomItemBean2 = (RoomItemBean) list.get(list.size() - 1);
                    this.label = 3;
                    if (aVarJ2.c(roomItemBean2, this) == objE) {
                        return objE;
                    }
                }
            } else {
                if (i11 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        String groupId = this.$roomItem.getGroupId();
        if (groupId != null) {
            RoomItem roomItem = this.$roomItem;
            roomItemBean = new RoomItemBean(groupId, roomItem.getName(), roomItem.getAvatar(), roomItem.getHasJoin(), roomItem.getNewPostCount(), roomItem.getDescription(), roomItem.getPostCount(), roomItem.getUserCount(), roomItem.getLevel(), System.currentTimeMillis());
        } else {
            roomItemBean = null;
        }
        if (roomItemBean != null && (aVarJ = this.this$0.j()) != null) {
            this.label = 1;
            if (aVarJ.b(roomItemBean, this) == objE) {
                return objE;
            }
        }
        a aVarJ3 = this.this$0.j();
        if (aVarJ3 != null) {
            this.label = 2;
            objA = aVarJ3.a(this);
            if (objA == objE) {
                return objE;
            }
            list = (List) objA;
            if (list != null) {
                roomItemBean2 = (RoomItemBean) list.get(list.size() - 1);
                this.label = 3;
                if (aVarJ2.c(roomItemBean2, this) == objE) {
                    return objE;
                }
            }
        } else if (list != null) {
            roomItemBean2 = (RoomItemBean) list.get(list.size() - 1);
            this.label = 3;
            if (aVarJ2.c(roomItemBean2, this) == objE) {
                return objE;
            }
        }
        return Unit.f68710a;
    }
}
