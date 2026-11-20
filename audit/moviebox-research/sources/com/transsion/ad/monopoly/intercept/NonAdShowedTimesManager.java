package com.transsion.ad.monopoly.intercept;

import android.app.Application;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.transsion.ad.db.MbAdDatabase;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.plan.AdPlansTransform;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.j;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.w0;
import xq.k;

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
public final class NonAdShowedTimesManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NonAdShowedTimesManager f50524a = new NonAdShowedTimesManager();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, ShowedTimesMemoryBean> f50525b = new ConcurrentHashMap<>();

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object b(MbAdDbPlans mbAdDbPlans, Continuation<? super Integer> continuation) throws Throwable {
        NonAdShowedTimesManager$getShowedTimes$1 nonAdShowedTimesManager$getShowedTimes$1;
        Integer showedTimes;
        if (continuation instanceof NonAdShowedTimesManager$getShowedTimes$1) {
            nonAdShowedTimesManager$getShowedTimes$1 = (NonAdShowedTimesManager$getShowedTimes$1) continuation;
            int i11 = nonAdShowedTimesManager$getShowedTimes$1.label;
            if ((i11 & Integer.MIN_VALUE) != 0) {
                nonAdShowedTimesManager$getShowedTimes$1.label = i11 - Integer.MIN_VALUE;
            } else {
                nonAdShowedTimesManager$getShowedTimes$1 = new NonAdShowedTimesManager$getShowedTimes$1(this, continuation);
            }
        } else {
            nonAdShowedTimesManager$getShowedTimes$1 = new NonAdShowedTimesManager$getShowedTimes$1(this, continuation);
        }
        Object objG = nonAdShowedTimesManager$getShowedTimes$1.result;
        Object objE = kotlin.coroutines.intrinsics.a.e();
        int i12 = nonAdShowedTimesManager$getShowedTimes$1.label;
        if (i12 == 0) {
            ResultKt.b(objG);
            MbAdDatabase.e eVar = MbAdDatabase.f50387p;
            Application applicationA = Utils.a();
            Intrinsics.f(applicationA, "getApp()");
            rq.a aVarN = eVar.b(applicationA).N();
            String id2 = mbAdDbPlans != null ? mbAdDbPlans.getId() : null;
            nonAdShowedTimesManager$getShowedTimes$1.L$0 = this;
            nonAdShowedTimesManager$getShowedTimes$1.L$1 = mbAdDbPlans;
            nonAdShowedTimesManager$getShowedTimes$1.label = 1;
            objG = aVarN.g(id2, nonAdShowedTimesManager$getShowedTimes$1);
            if (objG == objE) {
                return objE;
            }
        } else {
            if (i12 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            mbAdDbPlans = (MbAdDbPlans) nonAdShowedTimesManager$getShowedTimes$1.L$1;
            ResultKt.b(objG);
        }
        MbAdDbPlans mbAdDbPlans2 = (MbAdDbPlans) objG;
        int iIntValue = 0;
        if (mbAdDbPlans != null) {
            ConcurrentHashMap<String, ShowedTimesMemoryBean> concurrentHashMap = f50525b;
            ShowedTimesMemoryBean showedTimesMemoryBean = concurrentHashMap.get(mbAdDbPlans.getId());
            if (showedTimesMemoryBean == null) {
                String showDate = mbAdDbPlans2 != null ? mbAdDbPlans2.getShowDate() : null;
                k kVar = k.f80682a;
                if (TextUtils.equals(showDate, kVar.c())) {
                    String id3 = mbAdDbPlans.getId();
                    Integer showedTimes2 = mbAdDbPlans.getShowedTimes();
                    concurrentHashMap.put(id3, new ShowedTimesMemoryBean(showedTimes2 != null ? showedTimes2.intValue() : 0, kVar.c()));
                    if (mbAdDbPlans2 != null && (showedTimes = mbAdDbPlans2.getShowedTimes()) != null) {
                        iIntValue = showedTimes.intValue();
                    }
                } else {
                    concurrentHashMap.put(mbAdDbPlans.getId(), new ShowedTimesMemoryBean(0, kVar.c()));
                }
            } else if (TextUtils.equals(showedTimesMemoryBean.getDate(), k.f80682a.c())) {
                iIntValue = showedTimesMemoryBean.getShowedTimes();
            }
        }
        return Boxing.d(iIntValue);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0051  */
    /* JADX WARN: Code duplicated, block: B:13:0x0061  */
    /* JADX WARN: Code duplicated, block: B:15:0x0067  */
    /* JADX WARN: Code duplicated, block: B:16:0x0071  */
    /* JADX WARN: Code duplicated, block: B:19:0x0081  */
    /* JADX WARN: Code duplicated, block: B:21:0x0093  */
    public final void c(AdPlans adPlans) {
        String showDate;
        k kVar;
        Integer showedTimes;
        Integer numValueOf;
        ShowedTimesMemoryBean showedTimesMemoryBeanPut;
        if (adPlans == null) {
            return;
        }
        MbAdDbPlans mbAdDbPlansE = AdPlansTransform.f50542a.e(adPlans);
        ConcurrentHashMap<String, ShowedTimesMemoryBean> concurrentHashMap = f50525b;
        ShowedTimesMemoryBean showedTimesMemoryBean = concurrentHashMap.get(mbAdDbPlansE.getId());
        if (showedTimesMemoryBean != null) {
            String date = showedTimesMemoryBean.getDate();
            k kVar2 = k.f80682a;
            if (TextUtils.equals(date, kVar2.c())) {
                showedTimesMemoryBean.setShowedTimes(showedTimesMemoryBean.getShowedTimes() + 1);
                showedTimesMemoryBeanPut = concurrentHashMap.put(mbAdDbPlansE.getId(), showedTimesMemoryBean);
            } else {
                showedTimesMemoryBeanPut = concurrentHashMap.put(mbAdDbPlansE.getId(), new ShowedTimesMemoryBean(1, kVar2.c()));
            }
            if (showedTimesMemoryBeanPut == null) {
                showDate = mbAdDbPlansE.getShowDate();
                kVar = k.f80682a;
                if (TextUtils.equals(showDate, kVar.c())) {
                    showedTimes = mbAdDbPlansE.getShowedTimes();
                    if (showedTimes != null) {
                        numValueOf = Integer.valueOf(showedTimes.intValue() + 1);
                    } else {
                        numValueOf = null;
                    }
                    mbAdDbPlansE.setShowedTimes(numValueOf);
                    String id2 = mbAdDbPlansE.getId();
                    Integer showedTimes2 = mbAdDbPlansE.getShowedTimes();
                    concurrentHashMap.put(id2, new ShowedTimesMemoryBean(showedTimes2 != null ? showedTimes2.intValue() : 1, kVar.c()));
                } else {
                    concurrentHashMap.put(mbAdDbPlansE.getId(), new ShowedTimesMemoryBean(1, kVar.c()));
                }
            }
        } else {
            showDate = mbAdDbPlansE.getShowDate();
            kVar = k.f80682a;
            if (TextUtils.equals(showDate, kVar.c())) {
                showedTimes = mbAdDbPlansE.getShowedTimes();
                if (showedTimes != null) {
                    numValueOf = Integer.valueOf(showedTimes.intValue() + 1);
                } else {
                    numValueOf = null;
                }
                mbAdDbPlansE.setShowedTimes(numValueOf);
                String id3 = mbAdDbPlansE.getId();
                Integer showedTimes3 = mbAdDbPlansE.getShowedTimes();
                concurrentHashMap.put(id3, new ShowedTimesMemoryBean(showedTimes3 != null ? showedTimes3.intValue() : 1, kVar.c()));
            } else {
                concurrentHashMap.put(mbAdDbPlansE.getId(), new ShowedTimesMemoryBean(1, kVar.c()));
            }
        }
        j.d(l0.a(w0.b()), null, null, new NonAdShowedTimesManager$saveShowedTimes$3(mbAdDbPlansE, null), 3, null);
    }
}
