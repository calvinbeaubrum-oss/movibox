package ok;

import com.google.firebase.crashlytics.internal.common.CommonUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes6.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f72452a;

    public a(nk.f fVar) {
        this.f72452a = fVar.e("com.crashlytics.settings.json");
    }

    public final File a() {
        return this.f72452a;
    }

    public JSONObject b() throws Throwable {
        Throwable th2;
        FileInputStream fileInputStream;
        JSONObject jSONObject;
        gk.f.f().b("Checking for cached settings...");
        FileInputStream fileInputStream2 = null;
        try {
            try {
                File fileA = a();
                if (fileA.exists()) {
                    fileInputStream = new FileInputStream(fileA);
                    try {
                        jSONObject = new JSONObject(CommonUtils.C(fileInputStream));
                        fileInputStream2 = fileInputStream;
                    } catch (Exception e11) {
                        e = e11;
                        gk.f.f().e("Failed to fetch cached settings", e);
                        CommonUtils.e(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    }
                } else {
                    gk.f.f().i("Settings file does not exist.");
                    jSONObject = null;
                }
                CommonUtils.e(fileInputStream2, "Error while closing settings cache file.");
                return jSONObject;
            } catch (Throwable th3) {
                th2 = th3;
                CommonUtils.e(null, "Error while closing settings cache file.");
                throw th2;
            }
        } catch (Exception e12) {
            e = e12;
            fileInputStream = null;
        } catch (Throwable th4) {
            th2 = th4;
            CommonUtils.e(null, "Error while closing settings cache file.");
            throw th2;
        }
    }

    public void c(long j11, JSONObject jSONObject) throws Throwable {
        gk.f.f().i("Writing settings to cache file...");
        if (jSONObject != null) {
            FileWriter fileWriter = null;
            try {
                try {
                    jSONObject.put("expires_at", j11);
                    FileWriter fileWriter2 = new FileWriter(a());
                    try {
                        fileWriter2.write(jSONObject.toString());
                        fileWriter2.flush();
                        CommonUtils.e(fileWriter2, "Failed to close settings writer.");
                    } catch (Exception e11) {
                        e = e11;
                        fileWriter = fileWriter2;
                        gk.f.f().e("Failed to cache settings", e);
                        CommonUtils.e(fileWriter, "Failed to close settings writer.");
                    } catch (Throwable th2) {
                        th = th2;
                        fileWriter = fileWriter2;
                        CommonUtils.e(fileWriter, "Failed to close settings writer.");
                        throw th;
                    }
                } catch (Throwable th3) {
                    th = th3;
                }
            } catch (Exception e12) {
                e = e12;
            }
        }
    }
}
