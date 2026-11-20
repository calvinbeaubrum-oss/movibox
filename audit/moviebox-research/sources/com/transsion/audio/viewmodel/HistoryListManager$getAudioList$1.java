package com.transsion.audio.viewmodel;

import android.text.TextUtils;
import com.transsion.audio.player.AudioPlayer;
import com.transsion.baselib.db.audio.AudioBean;
import com.transsion.baselib.db.download.DownloadBean;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.k0;
import rr.a;
import uo.b;

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
@DebugMetadata(c = "com.transsion.audio.viewmodel.HistoryListManager$getAudioList$1", f = "HistoryListManager.kt", l = {DownloadBean.STATUS_COMPLETED_REMOVED, 68}, m = "invokeSuspend")
public final class HistoryListManager$getAudioList$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ HistoryListManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoryListManager$getAudioList$1(HistoryListManager historyListManager, Continuation<? super HistoryListManager$getAudioList$1> continuation) {
        super(2, continuation);
        this.this$0 = historyListManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new HistoryListManager$getAudioList$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((HistoryListManager$getAudioList$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0069  */
    /* JADX WARN: Code duplicated, block: B:26:0x0078  */
    /* JADX WARN: Code duplicated, block: B:27:0x007d  */
    /* JADX WARN: Code duplicated, block: B:38:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:39:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:43:0x0076 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x0088 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x0094 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x00a2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x0063 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x0063 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x0063 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x0063 A[SYNTHETIC] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        List<AudioBean> list;
        List<AudioBean> list2;
        AudioBean audioBeanS;
        Iterator<AudioBean> it;
        Integer numD;
        AudioBean next;
        String audioUrl;
        a aVarJ;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i11 = this.label;
        if (i11 != 0) {
            if (i11 == 1) {
                ResultKt.b(obj);
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) this.L$2;
                audioBeanS = (AudioBean) this.L$1;
                list2 = (List) this.L$0;
                ResultKt.b(obj);
            }
            while (it.hasNext()) {
                next = it.next();
                if (next.getStatus() != 3) {
                    if (audioBeanS != null) {
                        audioUrl = audioBeanS.getAudioUrl();
                    } else {
                        audioUrl = null;
                    }
                    if (TextUtils.equals(audioUrl, next.getAudioUrl())) {
                        continue;
                    } else {
                        next.setStatus(4);
                        aVarJ = this.this$0.j();
                        if (aVarJ != null) {
                            this.L$0 = list2;
                            this.L$1 = audioBeanS;
                            this.L$2 = it;
                            this.label = 2;
                            if (aVarJ.h(next, this) == objE) {
                                return objE;
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            this.this$0.i().q(list2);
            b.a aVar = b.f78622a;
            if (list2 != null) {
                numD = Boxing.d(list2.size());
            } else {
                numD = null;
            }
            b.a.g(aVar, "get getAudioList success" + numD, false, 2, null);
            return Unit.f68710a;
        }
        ResultKt.b(obj);
        a aVarJ2 = this.this$0.j();
        if (aVarJ2 != null) {
            this.label = 1;
            obj = aVarJ2.e(this);
            if (obj == objE) {
                return objE;
            }
        } else {
            list = null;
        }
        if (list == null && (!list.isEmpty())) {
            list2 = list;
            audioBeanS = AudioPlayer.f50830i.a().s();
            it = list.iterator();
            while (it.hasNext()) {
                next = it.next();
                if (next.getStatus() != 3) {
                    if (audioBeanS != null) {
                        audioUrl = audioBeanS.getAudioUrl();
                    } else {
                        audioUrl = null;
                    }
                    if (TextUtils.equals(audioUrl, next.getAudioUrl())) {
                        next.setStatus(4);
                        aVarJ = this.this$0.j();
                        if (aVarJ != null) {
                            this.L$0 = list2;
                            this.L$1 = audioBeanS;
                            this.L$2 = it;
                            this.label = 2;
                            if (aVarJ.h(next, this) == objE) {
                                return objE;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            }
        } else {
            list2 = list;
            this = this;
        }
        this.this$0.i().q(list2);
        b.a aVar2 = b.f78622a;
        if (list2 != null) {
            numD = Boxing.d(list2.size());
        } else {
            numD = null;
        }
        b.a.g(aVar2, "get getAudioList success" + numD, false, 2, null);
        return Unit.f68710a;
        list = (List) obj;
        if (list == null) {
        }
        list2 = list;
        this = this;
        this.this$0.i().q(list2);
        b.a aVar3 = b.f78622a;
        if (list2 != null) {
            numD = Boxing.d(list2.size());
        } else {
            numD = null;
        }
        b.a.g(aVar3, "get getAudioList success" + numD, false, 2, null);
        return Unit.f68710a;
    }
}
