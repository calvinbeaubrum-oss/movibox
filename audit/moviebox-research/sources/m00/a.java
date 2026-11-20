package m00;

import android.app.Application;
import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.blankj.utilcode.util.Utils;
import com.transsnet.loginapi.bean.Country;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

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
@SourceDebugExtension
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f70582a = new a();

    public final Country a(Context context, String phone) throws Throwable {
        Intrinsics.g(context, "context");
        Intrinsics.g(phone, "phone");
        ArrayList<Country> arrayListA = b.b().a(context);
        if (arrayListA != null && !arrayListA.isEmpty()) {
            for (Country country : arrayListA) {
                String code = country.getCode();
                String strSubstring = phone.substring(1, (code != null ? code.length() : 0) + 1);
                Intrinsics.f(strSubstring, "substring(...)");
                if (TextUtils.equals(strSubstring, country.getCode())) {
                    return country;
                }
            }
        }
        return null;
    }

    public final Country b() throws Throwable {
        Application applicationA = Utils.a();
        ArrayList<Country> arrayListA = b.b().a(applicationA);
        Object systemService = applicationA.getSystemService("phone");
        Intrinsics.e(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        String simCountryIso = ((TelephonyManager) systemService).getSimCountryIso();
        Intrinsics.f(simCountryIso, "telephonyManager.simCountryIso");
        String upperCase = simCountryIso.toUpperCase(Locale.ROOT);
        Intrinsics.f(upperCase, "toUpperCase(...)");
        Object obj = null;
        if (arrayListA == null) {
            return null;
        }
        for (Object obj2 : arrayListA) {
            if (Intrinsics.b(((Country) obj2).getCountry_s(), upperCase)) {
                obj = obj2;
                break;
            }
        }
        return (Country) obj;
    }
}
