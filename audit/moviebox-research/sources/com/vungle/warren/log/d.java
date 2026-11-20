package com.vungle.warren.log;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.vungle.warren.VungleApiClient;
import com.vungle.warren.persistence.FilePreferences;
import com.vungle.warren.utility.i;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.UUID;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f62095e = "d";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final VungleApiClient f62096a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FilePreferences f62097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f62098c = b();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f62099d = a();

    public d(@NonNull VungleApiClient vungleApiClient, @NonNull FilePreferences filePreferences) {
        this.f62096a = vungleApiClient;
        this.f62097b = filePreferences;
    }

    public final int a() {
        return this.f62097b.e("batch_id", 0);
    }

    @NonNull
    public final String b() {
        String strF = this.f62097b.f("device_id", "");
        if (!TextUtils.isEmpty(strF)) {
            return strF;
        }
        String string = UUID.randomUUID().toString();
        this.f62097b.j("device_id", string);
        this.f62097b.c();
        return string;
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0023: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:9:0x0023 */
    @Nullable
    public final JsonArray c(@NonNull File file) throws Throwable {
        BufferedReader bufferedReader;
        Closeable closeable;
        JsonArray jsonArray = new JsonArray();
        Closeable closeable2 = null;
        try {
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            i.a(bufferedReader);
                            return jsonArray;
                        }
                        jsonArray.add(JsonParser.parseString(line).getAsJsonObject());
                    } catch (Exception unused) {
                        Log.e(f62095e, "Invalidate log document file.");
                        i.a(bufferedReader);
                        return null;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                closeable2 = closeable;
                i.a(closeable2);
                throw th;
            }
        } catch (Exception unused2) {
            bufferedReader = null;
        } catch (Throwable th3) {
            th = th3;
            i.a(closeable2);
            throw th;
        }
    }

    public final void d() {
        this.f62097b.i("batch_id", this.f62099d);
        this.f62097b.c();
    }

    public void e(@NonNull File[] fileArr) {
        for (File file : fileArr) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("batch_id", Integer.valueOf(this.f62099d));
            jsonObject.addProperty("device_guid", this.f62098c);
            try {
                JsonArray jsonArrayC = c(file);
                if (jsonArrayC == null) {
                    i.b(file);
                } else {
                    jsonObject.add("payload", jsonArrayC);
                    if (this.f62096a.B(jsonObject).execute().e()) {
                        i.b(file);
                    }
                    if (this.f62099d >= Integer.MAX_VALUE) {
                        this.f62099d = -1;
                    }
                    this.f62099d++;
                }
            } catch (IOException unused) {
                Log.e(f62095e, "Failed to generate request payload.");
            }
        }
        d();
    }
}
