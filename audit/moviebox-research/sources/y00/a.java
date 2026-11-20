package y00;

import android.os.Bundle;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class a implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f81026b = "a";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s00.a f81027a;

    public a(s00.a aVar) {
        this.f81027a = aVar;
    }

    public static g b(int i11, String str, String[] strArr, int i12) {
        Bundle bundle = new Bundle();
        bundle.putInt("action_extra", i11);
        bundle.putString("extra_body", str);
        bundle.putStringArray("extra_urls", strArr);
        return new g(f81026b).p(false).l(bundle).o(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS, 1).n(i12).m(5);
    }

    @Override // y00.e
    public int a(Bundle bundle, h hVar) {
        String[] stringArray;
        int i11 = bundle.getInt("action_extra", -1);
        if (i11 == 0) {
            this.f81027a.c(((JsonElement) new Gson().fromJson(bundle.getString("extra_body"), JsonElement.class)).getAsJsonObject());
            return 0;
        }
        if (i11 == 1) {
            String[] stringArray2 = bundle.getStringArray("extra_urls");
            if (stringArray2 == null) {
                return 0;
            }
            String[] strArrB = this.f81027a.b(stringArray2);
            if (strArrB.length == 0) {
                return 0;
            }
            bundle.putStringArray("extra_urls", strArrB);
            return 2;
        }
        if (i11 == 2) {
            String[] strArrA = this.f81027a.a();
            if (strArrA.length == 0) {
                return 0;
            }
            bundle.putStringArray("extra_urls", strArrA);
            return 2;
        }
        if (i11 != 3 || (stringArray = bundle.getStringArray("extra_urls")) == null) {
            return 0;
        }
        this.f81027a.d(stringArray);
        return 0;
    }
}
