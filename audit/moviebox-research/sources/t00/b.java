package t00;

import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public class b implements a {
    @Override // t00.a
    public String a() {
        return TimeZone.getDefault().getID();
    }

    @Override // t00.a
    public String b() {
        return Locale.getDefault().getLanguage();
    }
}
