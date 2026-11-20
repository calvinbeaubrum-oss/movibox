package zl;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, k> f82095c = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f82096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f82097b;

    public k(Context context, String str) {
        this.f82096a = context;
        this.f82097b = str;
    }

    public static synchronized k c(Context context, String str) {
        Map<String, k> map;
        try {
            map = f82095c;
            if (!map.containsKey(str)) {
                map.put(str, new k(context, str));
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return map.get(str);
    }

    public synchronized Void a() {
        this.f82096a.deleteFile(this.f82097b);
        return null;
    }

    public String b() {
        return this.f82097b;
    }

    public synchronized com.google.firebase.remoteconfig.internal.a d() throws IOException {
        FileInputStream fileInputStreamOpenFileInput;
        Throwable th2;
        try {
            try {
                fileInputStreamOpenFileInput = this.f82096a.openFileInput(this.f82097b);
                try {
                    int iAvailable = fileInputStreamOpenFileInput.available();
                    byte[] bArr = new byte[iAvailable];
                    fileInputStreamOpenFileInput.read(bArr, 0, iAvailable);
                    com.google.firebase.remoteconfig.internal.a aVarB = com.google.firebase.remoteconfig.internal.a.b(new JSONObject(new String(bArr, "UTF-8")));
                    fileInputStreamOpenFileInput.close();
                    return aVarB;
                } catch (FileNotFoundException | JSONException unused) {
                    if (fileInputStreamOpenFileInput != null) {
                        fileInputStreamOpenFileInput.close();
                    }
                    return null;
                } catch (Throwable th3) {
                    th2 = th3;
                    if (fileInputStreamOpenFileInput != null) {
                        fileInputStreamOpenFileInput.close();
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                throw th4;
            }
        } catch (FileNotFoundException | JSONException unused2) {
            fileInputStreamOpenFileInput = null;
        } catch (Throwable th5) {
            fileInputStreamOpenFileInput = null;
            th2 = th5;
        }
    }

    public synchronized Void e(com.google.firebase.remoteconfig.internal.a aVar) throws IOException {
        FileOutputStream fileOutputStreamOpenFileOutput = this.f82096a.openFileOutput(this.f82097b, 0);
        try {
            fileOutputStreamOpenFileOutput.write(aVar.toString().getBytes("UTF-8"));
            fileOutputStreamOpenFileOutput.close();
        } catch (Throwable th2) {
            fileOutputStreamOpenFileOutput.close();
            throw th2;
        }
        return null;
    }
}
