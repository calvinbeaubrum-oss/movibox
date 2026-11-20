package f4;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioDeviceInfo;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioProfile;
import android.media.AudioTrack;
import android.net.Uri;
import android.provider.Settings;
import android.util.Pair;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.primitives.Ints;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.vungle.warren.error.VungleException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final e f64553c = new e(ImmutableList.of(C0668e.f64558d));

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @SuppressLint({"InlinedApi"})
    public static final ImmutableList<Integer> f64554d = ImmutableList.of(2, 5, 6);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ImmutableMap<Integer, Integer> f64555e = new ImmutableMap.b().g(5, 6).g(17, 6).g(7, 6).g(30, 10).g(18, 6).g(6, 8).g(8, 8).g(14, 8).d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray<C0668e> f64556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f64557b;

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(23)
    public static final class b {
        private static ImmutableSet<Integer> a() {
            ImmutableSet.a aVarJ = new ImmutableSet.a().j(8, 7);
            int i11 = z3.u0.f81838a;
            if (i11 >= 31) {
                aVarJ.j(26, 27);
            }
            if (i11 >= 33) {
                aVarJ.a(30);
            }
            return aVarJ.n();
        }

        public static boolean b(AudioManager audioManager, @Nullable k kVar) {
            AudioDeviceInfo[] devices = kVar == null ? ((AudioManager) z3.a.e(audioManager)).getDevices(2) : new AudioDeviceInfo[]{kVar.f64562a};
            ImmutableSet<Integer> immutableSetA = a();
            for (AudioDeviceInfo audioDeviceInfo : devices) {
                if (immutableSetA.contains(Integer.valueOf(audioDeviceInfo.getType()))) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(VungleException.INCORRECT_DEFAULT_API_USAGE)
    public static final class c {
        public static ImmutableList<Integer> a(androidx.media3.common.d dVar) {
            ImmutableList.a aVarBuilder = ImmutableList.builder();
            com.google.common.collect.g1<Integer> it = e.f64555e.keySet().iterator();
            while (it.hasNext()) {
                int iIntValue = it.next().intValue();
                if (z3.u0.f81838a >= z3.u0.K(iIntValue) && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(iIntValue).setSampleRate(48000).build(), dVar.a().f9136a)) {
                    aVarBuilder.a(Integer.valueOf(iIntValue));
                }
            }
            aVarBuilder.a(2);
            return aVarBuilder.m();
        }

        public static int b(int i11, int i12, androidx.media3.common.d dVar) {
            for (int i13 = 10; i13 > 0; i13--) {
                int iM = z3.u0.M(i13);
                if (iM != 0 && AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i11).setSampleRate(i12).setChannelMask(iM).build(), dVar.a().f9136a)) {
                    return i13;
                }
            }
            return 0;
        }
    }

    /* JADX INFO: compiled from: source.java */
    @RequiresApi(33)
    public static final class d {
        public static e a(AudioManager audioManager, androidx.media3.common.d dVar) {
            return new e(e.c(audioManager.getDirectProfilesForAttributes(dVar.a().f9136a)));
        }

        @Nullable
        public static k b(AudioManager audioManager, androidx.media3.common.d dVar) {
            try {
                List audioDevicesForAttributes = ((AudioManager) z3.a.e(audioManager)).getAudioDevicesForAttributes(dVar.a().f9136a);
                if (audioDevicesForAttributes.isEmpty()) {
                    return null;
                }
                return new k(h.a(audioDevicesForAttributes.get(0)));
            } catch (RuntimeException unused) {
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: f4.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: source.java */
    public static final class C0668e {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final C0668e f64558d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f64559a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f64560b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @Nullable
        public final ImmutableSet<Integer> f64561c;

        static {
            f64558d = z3.u0.f81838a >= 33 ? new C0668e(2, a(10)) : new C0668e(2, 10);
        }

        public C0668e(int i11, int i12) {
            this.f64559a = i11;
            this.f64560b = i12;
            this.f64561c = null;
        }

        @RequiresApi(33)
        public C0668e(int i11, Set<Integer> set) {
            this.f64559a = i11;
            ImmutableSet<Integer> immutableSetCopyOf = ImmutableSet.copyOf((Collection) set);
            this.f64561c = immutableSetCopyOf;
            com.google.common.collect.g1<Integer> it = immutableSetCopyOf.iterator();
            int iMax = 0;
            while (it.hasNext()) {
                iMax = Math.max(iMax, Integer.bitCount(it.next().intValue()));
            }
            this.f64560b = iMax;
        }

        public static ImmutableSet<Integer> a(int i11) {
            ImmutableSet.a aVar = new ImmutableSet.a();
            for (int i12 = 1; i12 <= i11; i12++) {
                aVar.a(Integer.valueOf(z3.u0.M(i12)));
            }
            return aVar.n();
        }

        public int b(int i11, androidx.media3.common.d dVar) {
            if (this.f64561c != null) {
                return this.f64560b;
            }
            return z3.u0.f81838a >= 29 ? c.b(this.f64559a, i11, dVar) : ((Integer) z3.a.e(e.f64555e.getOrDefault(Integer.valueOf(this.f64559a), 0))).intValue();
        }

        public boolean c(int i11) {
            if (this.f64561c == null) {
                return i11 <= this.f64560b;
            }
            int iM = z3.u0.M(i11);
            if (iM == 0) {
                return false;
            }
            return this.f64561c.contains(Integer.valueOf(iM));
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0668e)) {
                return false;
            }
            C0668e c0668e = (C0668e) obj;
            return this.f64559a == c0668e.f64559a && this.f64560b == c0668e.f64560b && z3.u0.c(this.f64561c, c0668e.f64561c);
        }

        public int hashCode() {
            int i11 = ((this.f64559a * 31) + this.f64560b) * 31;
            ImmutableSet<Integer> immutableSet = this.f64561c;
            return i11 + (immutableSet == null ? 0 : immutableSet.hashCode());
        }

        public String toString() {
            return "AudioProfile[format=" + this.f64559a + ", maxChannelCount=" + this.f64560b + ", channelMasks=" + this.f64561c + "]";
        }
    }

    public e(List<C0668e> list) {
        this.f64556a = new SparseArray<>();
        for (int i11 = 0; i11 < list.size(); i11++) {
            C0668e c0668e = list.get(i11);
            this.f64556a.put(c0668e.f64559a, c0668e);
        }
        int iMax = 0;
        for (int i12 = 0; i12 < this.f64556a.size(); i12++) {
            iMax = Math.max(iMax, this.f64556a.valueAt(i12).f64560b);
        }
        this.f64557b = iMax;
    }

    public static boolean b() {
        if (z3.u0.f81838a >= 17) {
            String str = z3.u0.f81840c;
            if ("Amazon".equals(str) || "Xiaomi".equals(str)) {
                return true;
            }
        }
        return false;
    }

    @RequiresApi(33)
    @SuppressLint({"WrongConstant"})
    public static ImmutableList<C0668e> c(List<AudioProfile> list) {
        HashMap map = new HashMap();
        map.put(2, new HashSet(Ints.c(12)));
        for (int i11 = 0; i11 < list.size(); i11++) {
            AudioProfile audioProfileA = f4.a.a(list.get(i11));
            if (audioProfileA.getEncapsulationType() != 1) {
                int format = audioProfileA.getFormat();
                if (z3.u0.I0(format) || f64555e.containsKey(Integer.valueOf(format))) {
                    if (map.containsKey(Integer.valueOf(format))) {
                        ((Set) z3.a.e((Set) map.get(Integer.valueOf(format)))).addAll(Ints.c(audioProfileA.getChannelMasks()));
                    } else {
                        map.put(Integer.valueOf(format), new HashSet(Ints.c(audioProfileA.getChannelMasks())));
                    }
                }
            }
        }
        ImmutableList.a aVarBuilder = ImmutableList.builder();
        for (Map.Entry entry : map.entrySet()) {
            aVarBuilder.a(new C0668e(((Integer) entry.getKey()).intValue(), (Set<Integer>) entry.getValue()));
        }
        return aVarBuilder.m();
    }

    public static ImmutableList<C0668e> d(@Nullable int[] iArr, int i11) {
        ImmutableList.a aVarBuilder = ImmutableList.builder();
        if (iArr == null) {
            iArr = new int[0];
        }
        for (int i12 : iArr) {
            aVarBuilder.a(new C0668e(i12, i11));
        }
        return aVarBuilder.m();
    }

    public static e e(Context context, androidx.media3.common.d dVar, @Nullable AudioDeviceInfo audioDeviceInfo) {
        return g(context, dVar, (z3.u0.f81838a < 23 || audioDeviceInfo == null) ? null : new k(audioDeviceInfo));
    }

    @SuppressLint({"InlinedApi"})
    public static e f(Context context, @Nullable Intent intent, androidx.media3.common.d dVar, @Nullable k kVar) {
        AudioManager audioManager = (AudioManager) z3.a.e(context.getSystemService(MimeTypes.BASE_TYPE_AUDIO));
        if (kVar == null) {
            kVar = z3.u0.f81838a >= 33 ? d.b(audioManager, dVar) : null;
        }
        int i11 = z3.u0.f81838a;
        if (i11 >= 33 && (z3.u0.M0(context) || z3.u0.F0(context))) {
            return d.a(audioManager, dVar);
        }
        if (i11 >= 23 && b.b(audioManager, kVar)) {
            return f64553c;
        }
        ImmutableSet.a aVar = new ImmutableSet.a();
        aVar.a(2);
        if (i11 >= 29 && (z3.u0.M0(context) || z3.u0.F0(context))) {
            aVar.k(c.a(dVar));
            return new e(d(Ints.m(aVar.n()), 10));
        }
        ContentResolver contentResolver = context.getContentResolver();
        boolean z11 = Settings.Global.getInt(contentResolver, "use_external_surround_sound_flag", 0) == 1;
        if ((z11 || b()) && Settings.Global.getInt(contentResolver, "external_surround_sound_enabled", 0) == 1) {
            aVar.k(f64554d);
        }
        if (intent == null || z11 || intent.getIntExtra("android.media.extra.AUDIO_PLUG_STATE", 0) != 1) {
            return new e(d(Ints.m(aVar.n()), 10));
        }
        int[] intArrayExtra = intent.getIntArrayExtra("android.media.extra.ENCODINGS");
        if (intArrayExtra != null) {
            aVar.k(Ints.c(intArrayExtra));
        }
        return new e(d(Ints.m(aVar.n()), intent.getIntExtra("android.media.extra.MAX_CHANNEL_COUNT", 10)));
    }

    @SuppressLint({"UnprotectedReceiver"})
    public static e g(Context context, androidx.media3.common.d dVar, @Nullable k kVar) {
        return f(context, context.registerReceiver(null, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG")), dVar, kVar);
    }

    public static int h(int i11) {
        int i12 = z3.u0.f81838a;
        if (i12 <= 28) {
            if (i11 == 7) {
                i11 = 8;
            } else if (i11 == 3 || i11 == 4 || i11 == 5) {
                i11 = 6;
            }
        }
        if (i12 <= 26 && "fugu".equals(z3.u0.f81839b) && i11 == 1) {
            i11 = 2;
        }
        return z3.u0.M(i11);
    }

    @Nullable
    public static Uri j() {
        if (b()) {
            return Settings.Global.getUriFor("external_surround_sound_enabled");
        }
        return null;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return z3.u0.t(this.f64556a, eVar.f64556a) && this.f64557b == eVar.f64557b;
    }

    public int hashCode() {
        return this.f64557b + (z3.u0.u(this.f64556a) * 31);
    }

    @Nullable
    public Pair<Integer, Integer> i(androidx.media3.common.y yVar, androidx.media3.common.d dVar) {
        int iF = androidx.media3.common.f0.f((String) z3.a.e(yVar.f9501m), yVar.f9498j);
        if (!f64555e.containsKey(Integer.valueOf(iF))) {
            return null;
        }
        if (iF == 18 && !l(18)) {
            iF = 6;
        } else if ((iF == 8 && !l(8)) || (iF == 30 && !l(30))) {
            iF = 7;
        }
        if (!l(iF)) {
            return null;
        }
        C0668e c0668e = (C0668e) z3.a.e(this.f64556a.get(iF));
        int iB = yVar.f9514z;
        if (iB == -1 || iF == 18) {
            int i11 = yVar.A;
            if (i11 == -1) {
                i11 = 48000;
            }
            iB = c0668e.b(i11, dVar);
        } else if (!yVar.f9501m.equals("audio/vnd.dts.uhd;profile=p2") || z3.u0.f81838a >= 33) {
            if (!c0668e.c(iB)) {
                return null;
            }
        } else if (iB > 10) {
            return null;
        }
        int iH = h(iB);
        if (iH == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(iF), Integer.valueOf(iH));
    }

    public boolean k(androidx.media3.common.y yVar, androidx.media3.common.d dVar) {
        return i(yVar, dVar) != null;
    }

    public boolean l(int i11) {
        return z3.u0.r(this.f64556a, i11);
    }

    public String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f64557b + ", audioProfiles=" + this.f64556a + "]";
    }
}
