package qs;

import com.hisavana.common.tracking.TrackingKey;
import java.util.HashMap;
import kotlin.Metadata;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f74884a = new a();

    public static /* synthetic */ void b(a aVar, boolean z11, ps.a aVar2, String str, String str2, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            str2 = null;
        }
        aVar.a(z11, aVar2, str, str2);
    }

    public final void a(boolean z11, ps.a aVar, String str, String str2) {
        HashMap map = new HashMap();
        map.put("source", aVar.j().getValue());
        map.put("module_name", str);
        map.put(TrackingKey.GAME_NAME, aVar.d());
        String strG = aVar.g();
        if (strG != null) {
            map.put("game_id", strG);
        }
        if (str2 != null) {
            map.put("action_type", str2);
        }
        String strH = aVar.h();
        if (strH != null) {
            if (z11) {
                com.transsion.baselib.helper.a.f51183a.b(strH, map);
            } else {
                com.transsion.baselib.helper.a.f51183a.a(strH, map);
            }
        }
    }

    public final void c(ps.a info, String pageStyle) {
        Intrinsics.g(info, "info");
        Intrinsics.g(pageStyle, "pageStyle");
        b(this, false, info, pageStyle, null, 8, null);
    }

    public final void d(ps.a info, String pageStyle) {
        Intrinsics.g(info, "info");
        Intrinsics.g(pageStyle, "pageStyle");
        b(this, true, info, pageStyle, null, 8, null);
    }

    public final void e(ps.a info, String pageStyle, String actionType) {
        Intrinsics.g(info, "info");
        Intrinsics.g(pageStyle, "pageStyle");
        Intrinsics.g(actionType, "actionType");
        a(true, info, pageStyle, actionType);
    }
}
