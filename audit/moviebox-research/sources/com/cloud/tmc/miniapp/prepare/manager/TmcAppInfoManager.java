package com.cloud.tmc.miniapp.prepare.manager;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.model.AppInfoModel;
import com.cloud.tmc.integration.model.AppModel;
import lb.a;
import zb.c;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@c("com.cloud.tmc.miniapp.prepare.impl.TmcAppInfoManagerImpl")
public interface TmcAppInfoManager {
    void delectOldVersionFilesAndUpdate(@NonNull Context context, @NonNull AppModel appModel);

    void deleteOldVersionFiles(@NonNull Context context, @NonNull AppModel appModel, boolean z11);

    @Nullable
    String findUrlMappedAppId(@NonNull Context context, String str);

    AppInfoModel getAppInfoModel(@NonNull Context context, @NonNull a aVar);

    AppModel getAppModel(@NonNull Context context, @NonNull a aVar);

    @Nullable
    AppInfoModel getAppModelFromCDN(@NonNull Context context, @NonNull String str);

    @Nullable
    AppInfoModel getAppModelFromConfig(@NonNull Context context, @NonNull String str);

    AppModel getAppModelFromDev(@NonNull Context context, @NonNull String str);

    @Nullable
    AppModel getAppModelFromOffline(@NonNull Context context, @NonNull String str, @NonNull String str2);

    AppModel getAppModelFromOld(@NonNull Context context, @NonNull String str);

    AppModel getAppModelFromPackage(@NonNull Context context, @NonNull String str);

    AppModel getAppModelFromPre(@NonNull Context context, @NonNull String str);

    AppModel getAppModelFromUsed(@NonNull Context context, @NonNull String str);

    AppModel getAppWarmupModel(@NonNull Context context, @NonNull a aVar);

    long getLastUpdateTime(@NonNull Context context, @NonNull String str);

    boolean getPreUnzipStatus(@NonNull Context context, String str);

    AppModel getSubpackageAppModelFromUsed(@NonNull Context context, @NonNull String str);

    void refreshUpdateTime(@NonNull Context context, @NonNull String str, long j11);

    void resetAppPreModel(@NonNull Context context, @NonNull String str);

    void updateAppModel(@NonNull Context context, AppModel appModel, String str);

    void updateAppWarmupModel(@NonNull Context context, AppModel appModel);

    void updateOldVersion(@NonNull Context context, @NonNull AppModel appModel, String str);

    void updatePreUnzipStatus(@NonNull Context context, String str, boolean z11);
}
