package p007do;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.google.common.base.p;
import com.google.common.io.BaseEncoding;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes7.dex */
public abstract class t {
    public static Cursor a(Context context, JSONObject jSONObject) throws JSONException {
        Uri uri = Uri.parse(jSONObject.getString("ur"));
        ArrayList arrayList = new ArrayList();
        String strOptString = jSONObject.optString("sl");
        ArrayList arrayList2 = new ArrayList();
        String strOptString2 = jSONObject.optString("so");
        if (!jSONObject.isNull("pj")) {
            JSONArray jSONArray = jSONObject.getJSONArray("pj");
            for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                arrayList.add(jSONArray.getString(i11));
            }
        }
        if (!jSONObject.isNull("sa")) {
            JSONArray jSONArray2 = jSONObject.getJSONArray("sa");
            for (int i12 = 0; i12 < jSONArray2.length(); i12++) {
                arrayList2.add(jSONArray2.getString(i12));
            }
        }
        return context.getContentResolver().query(uri, arrayList.isEmpty() ? null : (String[]) arrayList.toArray(new String[0]), p.a(strOptString), arrayList2.isEmpty() ? null : (String[]) arrayList2.toArray(new String[0]), p.a(strOptString2));
    }

    public static byte[] b(Context context, JSONObject jSONObject) {
        try {
            Cursor cursorA = a(context, jSONObject);
            try {
                if (cursorA == null) {
                    return null;
                }
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(2048);
                    while (cursorA.moveToNext()) {
                        try {
                            JSONStringer jSONStringer = new JSONStringer();
                            jSONStringer.object();
                            for (int i11 = 0; i11 < cursorA.getColumnCount(); i11++) {
                                String columnName = cursorA.getColumnName(i11);
                                if (p.b(columnName)) {
                                    columnName = Integer.toString(i11);
                                }
                                int type = cursorA.getType(i11);
                                if (type == 1) {
                                    jSONStringer.key(columnName).value(cursorA.getLong(i11));
                                } else if (type == 2) {
                                    jSONStringer.key(columnName).value(Double.doubleToLongBits(cursorA.getDouble(i11)));
                                } else if (type == 3) {
                                    jSONStringer.key(columnName).value(cursorA.getString(i11));
                                } else if (type == 4) {
                                    jSONStringer.key(columnName).value(BaseEncoding.a().f(cursorA.getBlob(i11)));
                                }
                            }
                            jSONStringer.endObject();
                            byteArrayOutputStream.write(jSONStringer.toString().getBytes(StandardCharsets.UTF_8));
                            byteArrayOutputStream.write(10);
                        } catch (Throwable th2) {
                            try {
                                byteArrayOutputStream.close();
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                            }
                            throw th2;
                        }
                    }
                    byteArrayOutputStream.flush();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    cursorA.close();
                    return byteArray;
                } catch (IOException | JSONException e11) {
                    throw new RuntimeException(e11);
                }
            } catch (Throwable th4) {
                cursorA.close();
                throw th4;
            }
        } catch (JSONException e12) {
            throw new RuntimeException(e12);
        }
    }
}
