package xb;

import android.content.Context;
import com.cloud.tmc.integration.model.AlertBeforeUnloadCache;
import com.cloud.tmc.integration.proxy.ToastProxy;
import com.cloud.tmc.integration.structure.Page;
import com.cloud.tmc.integration.ui.fragment.TmcFragment;
import com.cloud.tmc.kernel.log.TmcLogger;
import kotlin.Metadata;
import kotlin.Unit;
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
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:31)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public final class c {

    /* JADX INFO: compiled from: source.java */
    @Metadata
    public static final class a implements ua.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Page f80469a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AlertBeforeUnloadCache f80470b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f80471c;

        public a(Page page, AlertBeforeUnloadCache alertBeforeUnloadCache, Function0<Unit> function0) {
            this.f80469a = page;
            this.f80470b = alertBeforeUnloadCache;
            this.f80471c = function0;
        }

        @Override // ua.a
        public void a() {
            this.f80469a.putBooleanValue("miniAppAlertBeforeUnload", false);
            this.f80470b.setEnabled(false);
            Function0<Unit> function0 = this.f80471c;
            if (function0 != null) {
                function0.invoke();
            }
        }

        @Override // ua.a
        public void b() {
            this.f80469a.putBooleanValue("miniAppAlertBeforeUnload", false);
            TmcLogger.c("PageExt", "alertBeforeUnload is cancel");
        }
    }

    public static final synchronized boolean a(Page page, Function0<Unit> function0) {
        Boolean boolValueOf;
        AlertBeforeUnloadCache alertBeforeUnloadCache;
        Context context;
        if (page != null) {
            try {
                boolValueOf = Boolean.valueOf(page.getBooleanValue("miniAppAlertBeforeUnload"));
            } catch (Throwable th2) {
                throw th2;
            }
        } else {
            boolValueOf = null;
        }
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.b(boolValueOf, bool)) {
            return true;
        }
        if (page != null && (alertBeforeUnloadCache = (AlertBeforeUnloadCache) page.getData(AlertBeforeUnloadCache.class)) != null) {
            tb.d pageContext = page.getPageContext();
            TmcFragment tmcFragment = pageContext instanceof TmcFragment ? (TmcFragment) pageContext : null;
            if (tmcFragment != null && (context = tmcFragment.getContext()) != null) {
                if (!alertBeforeUnloadCache.getEnabled()) {
                    return false;
                }
                page.putBooleanValue("miniAppAlertBeforeUnload", true);
                ((ToastProxy) tc.a.a(ToastProxy.class)).showCommonDialog(null, alertBeforeUnloadCache.getMessage(), 0, bool, null, null, null, null, context, new a(page, alertBeforeUnloadCache, function0));
                return true;
            }
            return false;
        }
        return false;
    }
}
