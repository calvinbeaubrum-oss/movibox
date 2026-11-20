package athena;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.transsion.api.gateway.utils.SafeStringUtils;
import com.transsion.gslb.GslbSdk;
import com.transsion.push.PushConstants;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes.dex */
public class x extends y {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f13764d;

    public x(String str) {
        this.f13764d = str;
    }

    @Override // athena.y
    public void a() throws Throwable {
        String string;
        byte[] bytes;
        Context contextA = ws.a.a();
        boolean zO = j0.o(contextA);
        String str = this.f13764d;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes(Charset.forName("UTF-8")));
            byte[] bArrDigest = messageDigest.digest();
            StringBuilder sb2 = new StringBuilder();
            for (int i11 = 0; i11 < bArrDigest.length; i11++) {
                if (Integer.toHexString(bArrDigest[i11] & 255).length() == 1) {
                    sb2.append("0");
                    sb2.append(Integer.toHexString(bArrDigest[i11] & 255));
                } else {
                    sb2.append(Integer.toHexString(bArrDigest[i11] & 255));
                }
            }
            string = sb2.toString();
        } catch (NoSuchAlgorithmException unused) {
            string = "";
        }
        JSONArray jSONArray = new JSONArray();
        try {
            JSONObject jSONObjectPut = new JSONObject().put(SafeStringUtils.SP_APPID, 9999).put("hostid", 9999).put(PushConstants.PROVIDER_FIELD_PKG, "").put("vn", "").put("vc", "").put("ins", "").put("sdkv", "3.0.0.5").put("isfl", zO).put("cnt", 1).put("events", new JSONArray().put(new JSONObject(this.f13764d)));
            try {
                PackageManager packageManager = contextA.getPackageManager();
                String packageName = contextA.getPackageName();
                JSONObject jSONObjectPut2 = jSONObjectPut.put(PushConstants.PROVIDER_FIELD_PKG, packageName == null ? "" : packageName);
                String installerPackageName = packageManager.getInstallerPackageName(packageName);
                if (installerPackageName == null) {
                    installerPackageName = "";
                }
                jSONObjectPut2.put("ins", installerPackageName);
                PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
                if (packageInfo != null) {
                    String str2 = packageInfo.versionName;
                    if (str2 == null) {
                        str2 = "";
                    }
                    JSONObject jSONObjectPut3 = jSONObjectPut.put("vn", str2);
                    String strValueOf = String.valueOf(packageInfo.versionCode);
                    if (strValueOf == null) {
                        strValueOf = "";
                    }
                    jSONObjectPut3.put("vc", strValueOf);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            jSONArray.put(jSONObjectPut);
        } catch (Exception e12) {
            a0.c(Log.getStackTraceString(e12));
        }
        String strB = com.transsion.ga.g.b(0);
        try {
            JSONObject jSONObject = new JSONObject();
            String strT = br.g.t();
            if (strT == null) {
                strT = "";
            }
            JSONObject jSONObjectPut4 = jSONObject.put("channel", strT);
            String strI = j0.i(contextA, "opid");
            if (strI == null) {
                strI = "";
            }
            JSONObject jSONObjectPut5 = jSONObjectPut4.put("opid", strI);
            String strI2 = j0.i(contextA, "oneid");
            if (strI2 == null) {
                strI2 = "";
            }
            JSONObject jSONObjectPut6 = jSONObjectPut5.put("tsid", strI2);
            String strA = i0.a();
            if (strA == null) {
                strA = "";
            }
            JSONObject jSONObjectPut7 = jSONObjectPut6.put(PushConstants.PROVIDER_VAID, strA);
            JSONObject jSONObject2 = new JSONObject();
            String strM = j0.m();
            if (strM == null) {
                strM = "";
            }
            JSONObject jSONObjectPut8 = jSONObject2.put("tz", strM);
            String strC = j0.c();
            if (strC == null) {
                strC = "";
            }
            JSONObject jSONObjectPut9 = jSONObjectPut8.put("gaid", strC);
            String strH = br.g.h();
            if (strH == null) {
                strH = "";
            }
            JSONObject jSONObjectPut10 = jSONObjectPut9.put("tuid", strH).put("actype", (int) br.g.j());
            String strI3 = com.transsion.ga.g.i();
            if (strI3 == null) {
                strI3 = "";
            }
            JSONObject jSONObjectPut11 = jSONObjectPut10.put("osver", strI3);
            String str3 = Build.VERSION.RELEASE;
            if (str3 == null) {
                str3 = "";
            }
            JSONObject jSONObjectPut12 = jSONObjectPut11.put("aver", str3);
            String str4 = Build.DISPLAY;
            if (str4 == null) {
                str4 = "";
            }
            JSONObject jSONObjectPut13 = jSONObjectPut12.put("build", str4);
            String language = Locale.getDefault().getLanguage();
            if (language == null) {
                language = "";
            }
            JSONObject jSONObjectPut14 = jSONObjectPut13.put("lang", language);
            String str5 = Build.BRAND;
            if (str5 == null) {
                str5 = "";
            }
            JSONObject jSONObjectPut15 = jSONObjectPut14.put("brand", str5);
            String str6 = Build.MODEL;
            if (str6 == null) {
                str6 = "";
            }
            JSONObject jSONObjectPut16 = jSONObjectPut15.put("model", str6).put("net", j0.b(contextA).ordinal()).put("uts", System.currentTimeMillis()).put("try", 0);
            String strG = com.transsion.ga.g.g();
            if (strG == null) {
                strG = "";
            }
            JSONObject jSONObjectPut17 = jSONObjectPut16.put("mcc", strG);
            String strH2 = com.transsion.ga.g.h();
            if (strH2 == null) {
                strH2 = "";
            }
            JSONObject jSONObjectPut18 = jSONObjectPut17.put("mnc", strH2).put("ekey", jSONObjectPut7.toString()).put("appids", jSONArray);
            JSONObject jSONObjectU = br.g.u();
            try {
                if (jSONObjectU != null && jSONObjectU.length() > 0) {
                    int length = jSONObjectU.toString().getBytes(StandardCharsets.UTF_8).length;
                    if (length > 2000) {
                        Locale locale = Locale.getDefault();
                        Object[] objArr = new Object[1];
                        objArr[0] = Integer.valueOf(length);
                        String str7 = String.format(locale, "custom param is too long,limit is 2000 bytes(now is %d bytes)", objArr);
                        a0.c(str7);
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("errorMsg", str7);
                        jSONObjectPut7.put("cparam", jSONObject3.toString());
                    } else {
                        jSONObjectPut7.put("cparam", jSONObjectU.toString());
                    }
                }
                if (br.g.B) {
                    jSONObjectPut18.put("iid", strB == null ? "" : strB);
                }
                bytes = jSONObjectPut18.toString().getBytes(StandardCharsets.UTF_8);
            } catch (Exception e13) {
                e = e13;
                a0.c(Log.getStackTraceString(e));
                bytes = null;
            }
        } catch (Exception e14) {
            e = e14;
        }
        if (TextUtils.isEmpty(strB)) {
            strB = j0.c();
        }
        if (TextUtils.isEmpty(strB)) {
            strB = com.transsion.ga.g.a();
        }
        y0<b> y0VarC = v.c(TextUtils.isEmpty(null) ? GslbSdk.getDomain(br.g.B(), true) : GslbSdk.getDomain(br.g.b(null), true), bytes, 1, Collections.singletonList(9999), string, strB + "_" + cr.b.d());
        if (y0VarC.f13772a == 0) {
            m0.a(contextA).g("gdpr_close", "");
        } else {
            a0.d("PostGdprEventTask requestByPost error : %s", y0VarC.f13773b.f13602d);
        }
        if (zO) {
            m0.a(contextA).g("first_launch", "false");
        }
    }

    @Override // athena.y
    public String d() {
        return "GDPR";
    }
}
