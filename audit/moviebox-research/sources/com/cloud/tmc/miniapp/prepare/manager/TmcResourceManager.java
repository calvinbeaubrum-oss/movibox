package com.cloud.tmc.miniapp.prepare.manager;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.cloud.tmc.integration.model.AppModel;
import com.cloud.tmc.integration.model.SubPackageInfo;
import ua.o;
import wc.f;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
public interface TmcResourceManager {
    void clearDownloadAppMap();

    void creatBaseDirectory(@NonNull AppModel appModel);

    void createSoDirectory();

    void deleteDownloadPackage(@NonNull AppModel appModel);

    void deleteInstallStatus(@NonNull String str);

    void downloadApp(@NonNull AppModel appModel, int i11, boolean z11, @Nullable f fVar);

    void downloadApp(String str, String str2, String str3, String str4, int i11, boolean z11, @Nullable f fVar);

    String getInstallPath(@NonNull AppModel appModel);

    @Nullable
    String getInstalledAppVersion(@NonNull String str);

    boolean getNativeCache(@NonNull Context context, @NonNull AppModel appModel);

    boolean getOfflineCache(@NonNull Context context, @NonNull AppModel appModel);

    void installApp(@NonNull AppModel appModel, @Nullable o oVar);

    void installApp(@NonNull AppModel appModel, boolean z11, SubPackageInfo subPackageInfo, @Nullable o oVar);

    void installZip(@NonNull Context context, @NonNull AppModel appModel, @Nullable o oVar);

    void installZip(@NonNull Context context, @NonNull AppModel appModel, boolean z11, SubPackageInfo subPackageInfo, @Nullable o oVar);

    boolean isAvailable(@NonNull Context context, @NonNull AppModel appModel);

    boolean isDownloaded(@NonNull Context context, @NonNull AppModel appModel);

    boolean isDownloaded(@NonNull Context context, String str, String str2);

    void removeDownloadAppMap(String str);
}
