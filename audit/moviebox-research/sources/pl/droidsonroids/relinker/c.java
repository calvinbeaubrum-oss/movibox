package pl.droidsonroids.relinker;

import android.os.Build;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes8.dex */
public final class c implements b.InterfaceC0806b {
    @Override // pl.droidsonroids.relinker.b.InterfaceC0806b
    public void a(String str) {
        System.loadLibrary(str);
    }

    @Override // pl.droidsonroids.relinker.b.InterfaceC0806b
    public String b(String str) {
        return (str.startsWith("lib") && str.endsWith(".so")) ? str : System.mapLibraryName(str);
    }

    @Override // pl.droidsonroids.relinker.b.InterfaceC0806b
    public String c(String str) {
        return str.substring(3, str.length() - 3);
    }

    @Override // pl.droidsonroids.relinker.b.InterfaceC0806b
    public String[] d() {
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr.length > 0) {
            return strArr;
        }
        String str = Build.CPU_ABI2;
        return !d.a(str) ? new String[]{Build.CPU_ABI, str} : new String[]{Build.CPU_ABI};
    }

    @Override // pl.droidsonroids.relinker.b.InterfaceC0806b
    public void e(String str) {
        System.load(str);
    }
}
