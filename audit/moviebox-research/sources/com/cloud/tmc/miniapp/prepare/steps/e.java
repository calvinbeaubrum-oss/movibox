package com.cloud.tmc.miniapp.prepare.steps;

import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.kernel.proxy.performanceanalyse.PointAnalyseType;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class e {
    public static PointAnalyseType a(AppModel appModel, PointAnalyseType pointAnalyseType, String str, String str2, String str3) {
        return pointAnalyseType.putData(str, appModel.getAppId()).putData(str2, str3);
    }
}
