package androidx.appcompat.app;

import androidx.annotation.RequiresApi;
import java.util.LinkedHashSet;
import java.util.Locale;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(24)
public final class z {
    public static androidx.core.os.h a(androidx.core.os.h hVar, androidx.core.os.h hVar2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i11 = 0;
        while (i11 < hVar.g() + hVar2.g()) {
            Locale localeD = i11 < hVar.g() ? hVar.d(i11) : hVar2.d(i11 - hVar.g());
            if (localeD != null) {
                linkedHashSet.add(localeD);
            }
            i11++;
        }
        return androidx.core.os.h.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
    }

    public static androidx.core.os.h b(androidx.core.os.h hVar, androidx.core.os.h hVar2) {
        return (hVar == null || hVar.f()) ? androidx.core.os.h.e() : a(hVar, hVar2);
    }
}
