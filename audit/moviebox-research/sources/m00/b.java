package m00;

import android.content.Context;
import com.transsnet.loginapi.bean.Country;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static b f70583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static JSONArray f70584b;

    public static b b() {
        if (f70583a == null) {
            f70583a = new b();
        }
        return f70583a;
    }

    public ArrayList<Country> a(Context context) throws Throwable {
        ArrayList<Country> arrayList = new ArrayList<>();
        if (f70584b == null) {
            d(context);
        }
        JSONArray jSONArray = f70584b;
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i11 = 0; i11 < length; i11++) {
                try {
                    JSONObject jSONObject = f70584b.getJSONObject(i11);
                    Country country = new Country();
                    country.setCountry(jSONObject.getString("cn"));
                    country.setCode(jSONObject.getString("pcc"));
                    if (jSONObject.has("mcc")) {
                        country.setMcc(jSONObject.getString("mcc"));
                    }
                    if (jSONObject.has("alpha2")) {
                        country.setCountry_s(jSONObject.getString("alpha2"));
                    }
                    arrayList.add(country);
                } catch (JSONException e11) {
                    e11.printStackTrace();
                }
            }
        }
        return arrayList;
    }

    public final String c(InputStream inputStream) throws Throwable {
        StringBuilder sb2 = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream));
                while (true) {
                    try {
                        String line = bufferedReader2.readLine();
                        if (line == null) {
                            break;
                        }
                        sb2.append(line);
                    } catch (IOException unused) {
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                        return sb2.toString();
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException unused2) {
                            }
                        }
                        throw th;
                    }
                }
                bufferedReader2.close();
            } catch (IOException unused3) {
            }
        } catch (IOException unused4) {
        } catch (Throwable th3) {
            th = th3;
        }
        return sb2.toString();
    }

    public JSONArray d(Context context) throws Throwable {
        String strC;
        if (f70584b == null) {
            try {
                strC = c(context.getAssets().open("sdk_country_cc_mcc.json"));
            } catch (IOException e11) {
                e11.printStackTrace();
                strC = "";
            }
            try {
                f70584b = new JSONArray(strC);
            } catch (JSONException e12) {
                e12.printStackTrace();
            }
        }
        return f70584b;
    }
}
