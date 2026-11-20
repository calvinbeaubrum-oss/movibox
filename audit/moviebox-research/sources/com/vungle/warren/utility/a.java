package com.vungle.warren.utility;

import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import com.vungle.warren.VungleLogger;
import com.vungle.warren.model.admarkup.AdMarkup;
import com.vungle.warren.model.admarkup.AdMarkupV1;
import com.vungle.warren.model.admarkup.AdMarkupV2;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a {
    @Nullable
    public static AdMarkup a(@Nullable String str) {
        if (str == null) {
            return null;
        }
        try {
            JsonElement string = JsonParser.parseString(str);
            if (!string.isJsonObject()) {
                return null;
            }
            JsonObject asJsonObject = string.getAsJsonObject();
            int asInt = string.getAsJsonObject().get("version").getAsInt();
            if (asInt == 1) {
                return AdMarkupV1.fromString(str);
            }
            if (asInt != 2) {
                return null;
            }
            return d(asJsonObject);
        } catch (JsonSyntaxException unused) {
            c();
            return null;
        }
    }

    public static String b(byte[] bArr) throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream, 32);
        StringBuilder sb2 = new StringBuilder();
        byte[] bArr2 = new byte[32];
        while (true) {
            int i11 = gZIPInputStream.read(bArr2);
            if (i11 == -1) {
                gZIPInputStream.close();
                byteArrayInputStream.close();
                return sb2.toString();
            }
            sb2.append(new String(bArr2, 0, i11));
        }
    }

    public static void c() {
        VungleLogger.c(a.class.getName(), "Encountered issue serializing models");
    }

    public static AdMarkupV2 d(JsonObject jsonObject) {
        String asString = jsonObject.get("adunit").getAsString();
        JsonArray asJsonArray = jsonObject.get("impression").getAsJsonArray();
        String[] strArr = new String[asJsonArray.size()];
        for (int i11 = 0; i11 < asJsonArray.size(); i11++) {
            strArr[i11] = asJsonArray.get(i11).getAsString();
        }
        try {
            return new AdMarkupV2(JsonParser.parseString(b(Base64.decode(asString, 0))).getAsJsonObject(), strArr);
        } catch (IOException unused) {
            c();
            return null;
        }
    }
}
