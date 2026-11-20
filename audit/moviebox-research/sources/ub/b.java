package ub;

import com.cloud.tmc.integration.model.MiniAppConfigModel;
import com.cloud.tmc.integration.structure.Page;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public interface b {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a {
        public static /* synthetic */ void a(b bVar, MiniAppConfigModel.TabBarBean tabBarBean, Page page, String str, int i11, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTabs");
            }
            if ((i11 & 4) != 0) {
                str = "";
            }
            bVar.setTabs(tabBarBean, page, str);
        }
    }

    boolean hideTabBar(boolean z11);

    boolean removeTabBarBadge(int i11);

    boolean setTabBarBadge(int i11, String str);

    boolean setTabBarStyle(String str, String str2, String str3, String str4);

    void setTabs(MiniAppConfigModel.TabBarBean tabBarBean, Page page, String str);

    boolean setUnreadIconVisible(int i11, boolean z11);

    boolean setUnreadVisible(int i11, boolean z11);

    boolean showTabBar(boolean z11);

    void showTabBarUnreadIcon(int i11, String str, Page page, Function1<? super Boolean, Unit> function1);

    boolean updateAllTabs(List<MiniAppConfigModel.TabBarBean.ListBean> list, Page page);

    boolean updateTabItem(int i11, MiniAppConfigModel.TabBarBean.ListBean listBean, Page page);
}
