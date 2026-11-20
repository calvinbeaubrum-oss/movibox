package androidx.room;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:68)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:31)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: source.java */
/* JADX INFO: loaded from: classes2.dex */
@Metadata
public final class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f12883a = new r();

    @JvmStatic
    public static final <T extends RoomDatabase> RoomDatabase.a<T> a(Context context, Class<T> klass, String str) {
        Intrinsics.g(context, "context");
        Intrinsics.g(klass, "klass");
        if (true ^ (str == null || kotlin.text.l.y(str))) {
            return new RoomDatabase.a<>(context, klass, str);
        }
        throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder".toString());
    }

    @JvmStatic
    public static final <T, C> T b(Class<C> klass, String suffix) {
        String str;
        Intrinsics.g(klass, "klass");
        Intrinsics.g(suffix, "suffix");
        Package r11 = klass.getPackage();
        Intrinsics.d(r11);
        String fullPackage = r11.getName();
        String canonicalName = klass.getCanonicalName();
        Intrinsics.d(canonicalName);
        Intrinsics.f(fullPackage, "fullPackage");
        if (fullPackage.length() != 0) {
            canonicalName = canonicalName.substring(fullPackage.length() + 1);
            Intrinsics.f(canonicalName, "this as java.lang.String).substring(startIndex)");
        }
        String str2 = kotlin.text.l.E(canonicalName, '.', '_', false, 4, null) + suffix;
        try {
            if (fullPackage.length() == 0) {
                str = str2;
            } else {
                str = fullPackage + '.' + str2;
            }
            Class<?> cls = Class.forName(str, true, klass.getClassLoader());
            Intrinsics.e(cls, "null cannot be cast to non-null type java.lang.Class<T of androidx.room.Room.getGeneratedImplementation>");
            return (T) cls.newInstance();
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("Cannot find implementation for " + klass.getCanonicalName() + ". " + str2 + " does not exist");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException("Cannot access the constructor " + klass + ".canonicalName");
        } catch (InstantiationException unused3) {
            throw new RuntimeException("Failed to create an instance of " + klass + ".canonicalName");
        }
    }

    @JvmStatic
    public static final <T extends RoomDatabase> RoomDatabase.a<T> c(Context context, Class<T> klass) {
        Intrinsics.g(context, "context");
        Intrinsics.g(klass, "klass");
        return new RoomDatabase.a<>(context, klass, null);
    }
}
