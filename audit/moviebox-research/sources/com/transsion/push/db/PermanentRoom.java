package com.transsion.push.db;

import android.app.Application;
import com.blankj.utilcode.util.Utils;
import com.blankj.utilcode.util.n;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.tencent.mmkv.MMKV;
import com.transsion.push.PushConstants;
import com.transsion.push.bean.PagerConfig;
import com.transsion.push.bean.PermanentConfig;
import com.transsion.push.bean.PermanentItemBean;
import com.transsion.push.bean.PermanentPushResp;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.g;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

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
public final class PermanentRoom {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final PermanentRoom f56861a = new PermanentRoom();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f56862b = LazyKt__LazyJVMKt.b(new Function0<MMKV>() { // from class: com.transsion.push.db.PermanentRoom$mmkv$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MMKV invoke() {
            return MMKV.z("PermanentRushMsg");
        }
    });

    public final Object a(List<PermanentItemBean> list, Continuation<? super Unit> continuation) {
        Object objB;
        PermanentPushDatabase.a aVar = PermanentPushDatabase.f56857p;
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        return (list != null && (objB = aVar.b(applicationA).I().b(list, continuation)) == kotlin.coroutines.intrinsics.a.e()) ? objB : Unit.f68710a;
    }

    public final Object b(Continuation<? super Unit> continuation) {
        PermanentPushDatabase.a aVar = PermanentPushDatabase.f56857p;
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        Object objA = aVar.b(applicationA).I().a(continuation);
        return objA == kotlin.coroutines.intrinsics.a.e() ? objA : Unit.f68710a;
    }

    public final Object c(PermanentItemBean permanentItemBean, Continuation<? super Unit> continuation) {
        if (permanentItemBean == null) {
            return Unit.f68710a;
        }
        PermanentPushDatabase.a aVar = PermanentPushDatabase.f56857p;
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        Object objD = aVar.b(applicationA).I().d(permanentItemBean, continuation);
        return objD == kotlin.coroutines.intrinsics.a.e() ? objD : Unit.f68710a;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object d(Continuation<? super List<PermanentItemBean>> continuation) throws Throwable {
        PermanentRoom$getAll$1 permanentRoom$getAll$1;
        if (continuation instanceof PermanentRoom$getAll$1) {
            permanentRoom$getAll$1 = (PermanentRoom$getAll$1) continuation;
            int i11 = permanentRoom$getAll$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                permanentRoom$getAll$1.label = i11 - Integer.MIN_VALUE;
            } else {
                permanentRoom$getAll$1 = new PermanentRoom$getAll$1(this, continuation);
            }
        } else {
            permanentRoom$getAll$1 = new PermanentRoom$getAll$1(this, continuation);
        }
        Object objC = permanentRoom$getAll$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = permanentRoom$getAll$1.label;
        if (i12 == 0) {
            ResultKt.b(objC);
            PermanentPushDatabase.a aVar = PermanentPushDatabase.f56857p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            a aVarI = aVar.b(applicationA).I();
            permanentRoom$getAll$1.label = 1;
            objC = aVarI.c(permanentRoom$getAll$1);
            if (objC == objE) {
                return objE;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(objC);
        }
        List list = (List) objC;
        return list == null ? g.l() : list;
    }

    public final PermanentConfig e() {
        String string = i().getString(PushConstants.SP_KEY_CONFIG, null);
        if (string != null) {
            return (PermanentConfig) n.d(string, PermanentConfig.class);
        }
        return null;
    }

    public final String f() {
        String string = i().getString("pager", "1");
        return string == null ? "1" : string;
    }

    public final long g() {
        return i().getLong("time", 0L);
    }

    public final String h() {
        String string = i().getString(CampaignEx.JSON_KEY_TITLE, "");
        return string == null ? "" : string;
    }

    public final MMKV i() {
        Object value = f56862b.getValue();
        Intrinsics.f(value, "<get-mmkv>(...)");
        return (MMKV) value;
    }

    public final Object j(PermanentPushResp permanentPushResp, Continuation<? super Unit> continuation) {
        String strF;
        String title = permanentPushResp.getTitle();
        if (title == null) {
            title = h();
        }
        n(title);
        PagerConfig pager = permanentPushResp.getPager();
        if (pager == null || (strF = pager.getNextPage()) == null) {
            strF = f();
        }
        l(strF);
        m(System.currentTimeMillis());
        PermanentConfig cfg = permanentPushResp.getCfg();
        if (cfg != null) {
            f56861a.k(cfg);
        }
        uo.b.a aVar = uo.b.f78622a;
        List<PermanentItemBean> items = permanentPushResp.getItems();
        Integer numD = items != null ? Boxing.d(items.size()) : null;
        PagerConfig pager2 = permanentPushResp.getPager();
        String nextPage = pager2 != null ? pager2.getNextPage() : null;
        uo.b.a.j(aVar, "PUSH_SHOW", "DB-addMsgList, size:" + numD + "，mPager:" + nextPage + ",title:" + permanentPushResp.getTitle() + " ", false, 4, null);
        Object objA = a(permanentPushResp.getItems(), continuation);
        return objA == kotlin.coroutines.intrinsics.a.e() ? objA : Unit.f68710a;
    }

    public final void k(PermanentConfig permanentConfig) {
        i().putString(PushConstants.SP_KEY_CONFIG, n.j(permanentConfig));
    }

    public final void l(String value) {
        Intrinsics.g(value, "value");
        i().putString("pager", value);
    }

    public final void m(long j11) {
        i().putLong("time", j11);
    }

    public final void n(String value) {
        Intrinsics.g(value, "value");
        i().putString(CampaignEx.JSON_KEY_TITLE, value);
    }
}
