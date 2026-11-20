package vb;

import com.cloud.tmc.integration.model.MiniAppConfigModel;
import java.util.ArrayList;
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
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public interface b {
    boolean X(int i11, MiniAppConfigModel.TabBarBean.ListBean listBean);

    boolean hideTabBar(boolean z11);

    boolean hideTabBarRedDot(int i11);

    boolean hideTabBarUnreadIcon(int i11);

    boolean j(ArrayList<MiniAppConfigModel.TabBarBean.ListBean> arrayList);

    boolean n(MiniAppConfigModel.TabBarBean tabBarBean, String str);

    boolean removeTabBarBadge(int i11);

    boolean setTabBarBadge(int i11, String str);

    boolean setTabBarStyle(String str, String str2, String str3, String str4);

    boolean showTabBar(boolean z11);

    boolean showTabBarRedDot(int i11);

    void showTabBarUnreadIcon(int i11, String str, Function1<? super Boolean, Unit> function1);
}
