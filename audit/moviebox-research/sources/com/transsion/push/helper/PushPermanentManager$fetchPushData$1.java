package com.transsion.push.helper;

import com.tn.lib.net.bean.BaseDto;
import com.transsion.push.bean.PagerConfig;
import com.transsion.push.bean.PermanentConfig;
import com.transsion.push.bean.PermanentItemBean;
import com.transsion.push.bean.PermanentPushResp;
import com.transsion.push.db.PermanentRoom;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.k0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "com.transsion.push.helper.PushPermanentManager$fetchPushData$1", f = "PushPermanentManager.kt", l = {101, 118, 121}, m = "invokeSuspend")
public final class PushPermanentManager$fetchPushData$1 extends SuspendLambda implements Function2<k0, Continuation<? super Unit>, Object> {
    int I$0;
    private /* synthetic */ Object L$0;
    int label;

    public PushPermanentManager$fetchPushData$1(Continuation<? super PushPermanentManager$fetchPushData$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PushPermanentManager$fetchPushData$1 pushPermanentManager$fetchPushData$1 = new PushPermanentManager$fetchPushData$1(continuation);
        pushPermanentManager$fetchPushData$1.L$0 = obj;
        return pushPermanentManager$fetchPushData$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(k0 k0Var, Continuation<? super Unit> continuation) {
        return ((PushPermanentManager$fetchPushData$1) create(k0Var, continuation)).invokeSuspend(Unit.f68710a);
    }

    /* JADX WARN: Code duplicated, block: B:52:0x011e A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:53:0x011f  */
    /* JADX WARN: Code duplicated, block: B:57:0x0129 A[Catch: all -> 0x001e, TryCatch #0 {all -> 0x001e, blocks: (B:8:0x0019, B:55:0x0123, B:57:0x0129, B:59:0x0131, B:60:0x0135, B:61:0x013f, B:63:0x0147, B:64:0x014d, B:66:0x0181, B:68:0x018c, B:67:0x0187, B:15:0x002f, B:50:0x0110, B:16:0x0034, B:25:0x008d, B:27:0x009b, B:29:0x00ac, B:31:0x00b2, B:32:0x00b6, B:34:0x00bc, B:36:0x00c5, B:37:0x00d5, B:39:0x00dd, B:42:0x00e4, B:44:0x00fc, B:22:0x0075), top: B:76:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0131 A[Catch: all -> 0x001e, TryCatch #0 {all -> 0x001e, blocks: (B:8:0x0019, B:55:0x0123, B:57:0x0129, B:59:0x0131, B:60:0x0135, B:61:0x013f, B:63:0x0147, B:64:0x014d, B:66:0x0181, B:68:0x018c, B:67:0x0187, B:15:0x002f, B:50:0x0110, B:16:0x0034, B:25:0x008d, B:27:0x009b, B:29:0x00ac, B:31:0x00b2, B:32:0x00b6, B:34:0x00bc, B:36:0x00c5, B:37:0x00d5, B:39:0x00dd, B:42:0x00e4, B:44:0x00fc, B:22:0x0075), top: B:76:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0147 A[Catch: all -> 0x001e, TryCatch #0 {all -> 0x001e, blocks: (B:8:0x0019, B:55:0x0123, B:57:0x0129, B:59:0x0131, B:60:0x0135, B:61:0x013f, B:63:0x0147, B:64:0x014d, B:66:0x0181, B:68:0x018c, B:67:0x0187, B:15:0x002f, B:50:0x0110, B:16:0x0034, B:25:0x008d, B:27:0x009b, B:29:0x00ac, B:31:0x00b2, B:32:0x00b6, B:34:0x00bc, B:36:0x00c5, B:37:0x00d5, B:39:0x00dd, B:42:0x00e4, B:44:0x00fc, B:22:0x0075), top: B:76:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0181 A[Catch: all -> 0x001e, TryCatch #0 {all -> 0x001e, blocks: (B:8:0x0019, B:55:0x0123, B:57:0x0129, B:59:0x0131, B:60:0x0135, B:61:0x013f, B:63:0x0147, B:64:0x014d, B:66:0x0181, B:68:0x018c, B:67:0x0187, B:15:0x002f, B:50:0x0110, B:16:0x0034, B:25:0x008d, B:27:0x009b, B:29:0x00ac, B:31:0x00b2, B:32:0x00b6, B:34:0x00bc, B:36:0x00c5, B:37:0x00d5, B:39:0x00dd, B:42:0x00e4, B:44:0x00fc, B:22:0x0075), top: B:76:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:67:0x0187 A[Catch: all -> 0x001e, TryCatch #0 {all -> 0x001e, blocks: (B:8:0x0019, B:55:0x0123, B:57:0x0129, B:59:0x0131, B:60:0x0135, B:61:0x013f, B:63:0x0147, B:64:0x014d, B:66:0x0181, B:68:0x018c, B:67:0x0187, B:15:0x002f, B:50:0x0110, B:16:0x0034, B:25:0x008d, B:27:0x009b, B:29:0x00ac, B:31:0x00b2, B:32:0x00b6, B:34:0x00bc, B:36:0x00c5, B:37:0x00d5, B:39:0x00dd, B:42:0x00e4, B:44:0x00fc, B:22:0x0075), top: B:76:0x000b }] */
    /* JADX WARN: Code duplicated, block: B:73:0x01a3  */
    /* JADX WARN: Instruction removed from duplicated block: B:73:0x01a3, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v9 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objM163constructorimpl;
        Throwable thM166exceptionOrNullimpl;
        PermanentPushResp permanentPushResp;
        int i11;
        PermanentPushResp permanentPushResp2;
        PermanentRoom permanentRoom;
        int i12;
        PermanentPushResp permanentPushResp3;
        ?? r11;
        PagerConfig pager;
        String title;
        String nextPage;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i13 = this.label;
        try {
            if (i13 != 0) {
                if (i13 == 1) {
                    ResultKt.b(obj);
                } else if (i13 == 2) {
                    i11 = this.I$0;
                    permanentPushResp2 = (PermanentPushResp) this.L$0;
                    ResultKt.b(obj);
                    permanentPushResp = permanentPushResp2;
                    permanentRoom = PermanentRoom.f56861a;
                    this.L$0 = permanentPushResp;
                    this.I$0 = i11;
                    this.label = 3;
                    if (permanentRoom.j(permanentPushResp, this) == objE) {
                        return objE;
                    }
                    i12 = i11;
                    permanentPushResp3 = permanentPushResp;
                } else {
                    if (i13 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    i12 = this.I$0;
                    permanentPushResp3 = (PermanentPushResp) this.L$0;
                    ResultKt.b(obj);
                }
                r11 = i12;
                permanentPushResp = permanentPushResp3;
                pager = permanentPushResp.getPager();
                if (pager != null) {
                    PushPermanentManager pushPermanentManager = PushPermanentManager.f56895a;
                    nextPage = pager.getNextPage();
                    if (nextPage == null) {
                        nextPage = PushPermanentManager.f56899e;
                    }
                    PushPermanentManager.f56899e = nextPage;
                    PushPermanentManager.f56900f = pager.getHasMore();
                }
                PushPermanentManager pushPermanentManager2 = PushPermanentManager.f56895a;
                title = permanentPushResp.getTitle();
                if (title == null) {
                    title = PushPermanentManager.f56895a.s();
                }
                PushPermanentManager.f56901g = title;
                b.a.f(b.f78622a, "PUSH_SHOW", "loopRequest pushCacheList:" + PushPermanentManager.f56897c.size() + ", cfg:" + permanentPushResp.getCfg(), false, 4, null);
                if (r11 != 0) {
                    PushPermanentManager.f56895a.v();
                } else {
                    PushShowPermanentHelper.f56904a.c();
                }
                objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
                thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
                if (thM166exceptionOrNullimpl != null) {
                    b.a.f(b.f78622a, "PUSH_SHOW", "onFailure: " + thM166exceptionOrNullimpl, false, 4, null);
                }
                return Unit.f68710a;
            }
            ResultKt.b(obj);
            PushPermanentManager pushPermanentManager3 = PushPermanentManager.f56895a;
            if (!pushPermanentManager3.t()) {
                PushPermanentManager.f56899e = "1";
            }
            b.a.f(b.f78622a, "PUSH_SHOW", "fetchPushData pager:" + PushPermanentManager.f56899e + ",lastRequestTime:" + PushPermanentManager.f56902h, false, 4, null);
            Result.Companion companion = Result.Companion;
            kw.a aVarR = pushPermanentManager3.r();
            String str = PushPermanentManager.f56899e;
            this.label = 1;
            obj = kw.a.C0747a.a(aVarR, null, str, null, this, 5, null);
            if (obj == objE) {
                return objE;
            }
            BaseDto baseDto = (BaseDto) obj;
            if (Intrinsics.b(baseDto.getCode(), "0")) {
                PushPermanentManager pushPermanentManager4 = PushPermanentManager.f56895a;
                PushPermanentManager.f56902h = System.currentTimeMillis();
                permanentPushResp = (PermanentPushResp) baseDto.getData();
                if (permanentPushResp != null) {
                    PermanentConfig cfg = permanentPushResp.getCfg();
                    boolean enable = cfg != null ? cfg.getEnable() : true;
                    PermanentConfig cfg2 = permanentPushResp.getCfg();
                    if (cfg2 != null) {
                        PushPermanentManager.f56898d = cfg2;
                        if (cfg2.getInterval() > 0) {
                            PushPermanentManager.f56895a.u(((long) (cfg2.getInterval() * 60)) * 1000);
                        }
                    }
                    List<PermanentItemBean> items = permanentPushResp.getItems();
                    r11 = enable;
                    if (items != null) {
                        if (items.isEmpty()) {
                            r11 = enable;
                        } else {
                            PushPermanentManager.f56897c.addAll(0, permanentPushResp.getItems());
                            if (Intrinsics.b(PushPermanentManager.f56899e, "1")) {
                                PermanentRoom permanentRoom2 = PermanentRoom.f56861a;
                                this.L$0 = permanentPushResp;
                                this.I$0 = enable ? 1 : 0;
                                this.label = 2;
                                if (permanentRoom2.b(this) == objE) {
                                    return objE;
                                }
                                permanentPushResp2 = permanentPushResp;
                                i11 = enable ? 1 : 0;
                                permanentPushResp = permanentPushResp2;
                            } else {
                                i11 = enable ? 1 : 0;
                            }
                            permanentRoom = PermanentRoom.f56861a;
                            this.L$0 = permanentPushResp;
                            this.I$0 = i11;
                            this.label = 3;
                            if (permanentRoom.j(permanentPushResp, this) == objE) {
                                return objE;
                            }
                            i12 = i11;
                            permanentPushResp3 = permanentPushResp;
                            r11 = i12;
                            permanentPushResp = permanentPushResp3;
                        }
                    }
                    pager = permanentPushResp.getPager();
                    if (pager != null) {
                        PushPermanentManager pushPermanentManager5 = PushPermanentManager.f56895a;
                        nextPage = pager.getNextPage();
                        if (nextPage == null) {
                            nextPage = PushPermanentManager.f56899e;
                        }
                        PushPermanentManager.f56899e = nextPage;
                        PushPermanentManager.f56900f = pager.getHasMore();
                    }
                    PushPermanentManager pushPermanentManager6 = PushPermanentManager.f56895a;
                    title = permanentPushResp.getTitle();
                    if (title == null) {
                        title = PushPermanentManager.f56895a.s();
                    }
                    PushPermanentManager.f56901g = title;
                    b.a.f(b.f78622a, "PUSH_SHOW", "loopRequest pushCacheList:" + PushPermanentManager.f56897c.size() + ", cfg:" + permanentPushResp.getCfg(), false, 4, null);
                    if (r11 != 0) {
                        PushPermanentManager.f56895a.v();
                    } else {
                        PushShowPermanentHelper.f56904a.c();
                    }
                }
            }
            objM163constructorimpl = Result.m163constructorimpl(Unit.f68710a);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            objM163constructorimpl = Result.m163constructorimpl(ResultKt.a(th2));
        }
        thM166exceptionOrNullimpl = Result.m166exceptionOrNullimpl(objM163constructorimpl);
        if (thM166exceptionOrNullimpl != null) {
            b.a.f(b.f78622a, "PUSH_SHOW", "onFailure: " + thM166exceptionOrNullimpl, false, 4, null);
        }
        return Unit.f68710a;
    }
}
