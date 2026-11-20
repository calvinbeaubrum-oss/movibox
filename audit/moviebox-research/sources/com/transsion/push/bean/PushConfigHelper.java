package com.transsion.push.bean;

import com.transsion.mb.config.manager.ConfigBean;
import com.transsion.mb.config.manager.ConfigManager;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.k;

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
public final class PushConfigHelper {
    public static final int PERMANENT_A_TYPE = 1;
    public static final int PERMANENT_B_TYPE = 2;
    public static final int PERMANENT_DEFAULT_TYPE = 0;
    private static final String PUSH_PERMANENT_AB_CONFIG = "push_permanent_ui_ab_config";
    public static final String PUSH_PIC_TYPE_CONFIG_KEY = "push_pic_type_config";
    private static final String PUSH_REMIND_NOTIFICATION_TIME = "push_remind_notification_time";
    public static final PushConfigHelper INSTANCE = new PushConfigHelper();
    private static final Lazy abType$delegate = LazyKt__LazyJVMKt.b(new Function0<Integer>() { // from class: com.transsion.push.bean.PushConfigHelper$abType$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Integer invoke() {
            String value;
            ConfigBean configBeanB = ConfigManager.f53111c.a().b("push_permanent_ui_ab_config", true);
            Integer numL = (configBeanB == null || (value = configBeanB.getValue()) == null) ? null : k.l(value);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("push init_abType:");
            sb2.append(numL);
            return Integer.valueOf(numL != null ? numL.intValue() : 0);
        }
    });
    private static final Lazy remindTime$delegate = LazyKt__LazyJVMKt.b(new Function0<Integer>() { // from class: com.transsion.push.bean.PushConfigHelper$remindTime$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Integer invoke() {
            String value;
            ConfigBean configBeanB = ConfigManager.f53111c.a().b("push_remind_notification_time", true);
            Integer numL = (configBeanB == null || (value = configBeanB.getValue()) == null) ? null : k.l(value);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("remindTime:");
            sb2.append(numL);
            return numL;
        }
    });
    private static final Lazy verticalType$delegate = LazyKt__LazyJVMKt.b(new Function0<Boolean>() { // from class: com.transsion.push.bean.PushConfigHelper$verticalType$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            String value;
            Boolean boolY0;
            ConfigBean configBeanB = ConfigManager.f53111c.a().b(PushConfigHelper.PUSH_PIC_TYPE_CONFIG_KEY, true);
            return Boolean.valueOf((configBeanB == null || (value = configBeanB.getValue()) == null || (boolY0 = StringsKt__StringsKt.Y0(value)) == null) ? false : boolY0.booleanValue());
        }
    });

    private PushConfigHelper() {
    }

    private final int getAbType() {
        return ((Number) abType$delegate.getValue()).intValue();
    }

    private final boolean getVerticalType() {
        return ((Boolean) verticalType$delegate.getValue()).booleanValue();
    }

    public final int getCurAbType() {
        return getAbType();
    }

    public final Integer getRemindTime() {
        return (Integer) remindTime$delegate.getValue();
    }

    public final boolean isAbType() {
        return getCurAbType() != 0;
    }

    public final boolean isVerticalType() {
        boolean verticalType = getVerticalType();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isVerticalType:");
        sb2.append(verticalType);
        return getVerticalType();
    }
}
