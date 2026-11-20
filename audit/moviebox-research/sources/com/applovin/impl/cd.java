package com.applovin.impl;

import android.graphics.Color;
import androidx.core.view.ViewCompat;
import com.applovin.impl.sdk.utils.JsonUtils;
import org.json.JSONObject;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes3.dex */
public class cd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JSONObject f18179a;

    public cd(JSONObject jSONObject) {
        this.f18179a = jSONObject == null ? new JSONObject() : jSONObject;
    }

    public int a() {
        String string = JsonUtils.getString(this.f18179a, "background_color", null);
        return string != null ? Color.parseColor(string) : ViewCompat.MEASURED_STATE_MASK;
    }

    public long b() {
        return JsonUtils.getLong(this.f18179a, "close_button_delay_ms", 3000L);
    }

    public int c() {
        return JsonUtils.getInt(this.f18179a, "close_button_extended_touch_area_size", 10);
    }

    public int d() {
        return JsonUtils.getInt(this.f18179a, "close_button_h_margin", 5);
    }

    public int e() {
        return JsonUtils.getInt(this.f18179a, "close_button_size", 30);
    }

    public int f() {
        return JsonUtils.getInt(this.f18179a, "close_button_top_margin", 20);
    }
}
