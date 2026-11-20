package com.transsion.ad.monopoly.manager;

import android.app.Application;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.transsion.ad.b;
import com.transsion.ad.db.plan.MbAdDbPlans;
import com.transsion.ad.monopoly.model.AdMaterialList;
import com.transsion.ad.monopoly.model.AdPlans;
import com.transsion.ad.monopoly.model.MbAdImage;
import com.transsion.ad.monopoly.model.MbAdPlansBean;
import com.transsion.ad.monopoly.model.MbAdPlansDto;
import com.transsion.ad.monopoly.model.MbAdVideo;
import com.transsion.ad.monopoly.plan.AdPlansTransform;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.a;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.h;
import kotlinx.coroutines.w0;
import xq.d;

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
@SourceDebugExtension
public final class AdPlansAssetsManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AdPlansAssetsManager f50529a = new AdPlansAssetsManager();

    public final MbAdPlansDto d(MbAdPlansDto mbAdPlansDto) {
        List<AdPlans> adPlans;
        MbAdPlansBean data = mbAdPlansDto.getData();
        if (data != null && (adPlans = data.getAdPlans()) != null) {
            for (AdPlans adPlans2 : adPlans) {
                AdPlansAssetsManager adPlansAssetsManager = f50529a;
                String advertiserAvatar = adPlans2.getAdvertiserAvatar();
                if (advertiserAvatar == null) {
                    advertiserAvatar = "";
                }
                String strH = adPlansAssetsManager.h(advertiserAvatar);
                if (!TextUtils.isEmpty(strH)) {
                    adPlans2.setAdvertiserAvatarPath(strH);
                }
                List<AdMaterialList> adMaterialList = adPlans2.getAdMaterialList();
                if (adMaterialList != null) {
                    for (AdMaterialList adMaterialList2 : adMaterialList) {
                        MbAdVideo video = adMaterialList2.getVideo();
                        if (video != null) {
                            AdPlansAssetsManager adPlansAssetsManager2 = f50529a;
                            String url = video.getUrl();
                            if (url == null) {
                                url = "";
                            }
                            String strH2 = adPlansAssetsManager2.h(url);
                            if (!TextUtils.isEmpty(strH2)) {
                                video.setPath(strH2);
                                adMaterialList2.setDownloadMaterialSuccess(true);
                            }
                        }
                        MbAdImage image = adMaterialList2.getImage();
                        if (image != null) {
                            AdPlansAssetsManager adPlansAssetsManager3 = f50529a;
                            String url2 = image.getUrl();
                            if (url2 == null) {
                                url2 = "";
                            }
                            String strH3 = adPlansAssetsManager3.h(url2);
                            if (!TextUtils.isEmpty(strH3)) {
                                image.setPath(strH3);
                                adMaterialList2.setDownloadMaterialSuccess(true);
                            }
                        }
                    }
                }
            }
        }
        return mbAdPlansDto;
    }

    public final String e() {
        String simpleName = AdPlansAssetsManager.class.getSimpleName();
        Intrinsics.f(simpleName, "javaClass.simpleName");
        return simpleName;
    }

    public final Object f(MbAdPlansDto mbAdPlansDto, Continuation<? super Unit> continuation) {
        MbAdPlansBean data = mbAdPlansDto.getData();
        if (data != null) {
            ArrayList arrayList = new ArrayList();
            List<AdPlans> adPlans = data.getAdPlans();
            if (adPlans != null) {
                Iterator<T> it = adPlans.iterator();
                while (it.hasNext()) {
                    MbAdDbPlans mbAdDbPlansE = AdPlansTransform.f50542a.e((AdPlans) it.next());
                    mbAdDbPlansE.setVersion(data.getVersion());
                    arrayList.add(mbAdDbPlansE);
                }
            }
            Object objL = AdPlansStorageManager.f50532a.l(arrayList, continuation);
            if (objL == a.e()) {
                return objL;
            }
        }
        return Unit.f68710a;
    }

    public final Object g(Continuation<? super Unit> continuation) {
        Object objG = h.g(w0.b(), new AdPlansAssetsManager$saveAssets2Download$2(null), continuation);
        return objG == a.e() ? objG : Unit.f68710a;
    }

    public final String h(String str) {
        File file = new File(b.f50277a.b(), System.currentTimeMillis() + ".mineType");
        d dVar = d.f80669a;
        Application applicationA = Utils.a();
        Intrinsics.f(applicationA, "getApp()");
        if (dVar.a(applicationA, str, file)) {
            return file.getAbsolutePath();
        }
        return null;
    }
}
