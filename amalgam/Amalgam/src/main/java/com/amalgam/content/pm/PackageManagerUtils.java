package com.amalgam.content.pm;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;

/**
 */
public final class PackageManagerUtils {
    public static final String TAG = PackageManagerUtils.class.getSimpleName();
    private static final int FALLBACK_VERSION_CODE = 0;

    private PackageManagerUtils() {}

    public static final int getVersionCode(Context context) {
        return getVersionCode(context, FALLBACK_VERSION_CODE);
    }

    public static final int getVersionCode(Context context, int fallback) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            return info.versionCode;
        } catch (NameNotFoundException e) {
            Log.e(TAG, "no such package installed on the device: ", e);
        }
        return fallback;
    }

    public static final String getVersionName(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            return info.versionName;
        } catch (NameNotFoundException e) {
            throw new IllegalStateException("no such package installed on the device: ", e);
        }
    }

    public static final PackageInfo getSignaturePackageInfo(Context context) throws NameNotFoundException {
        PackageManager manager = context.getPackageManager();
        return getSignaturePackageInfo(manager, context.getPackageName());
    }

    public static final PackageInfo getSignaturePackageInfo(PackageManager manager, String targetPackage) throws NameNotFoundException {
        return manager.getPackageInfo(targetPackage, PackageManager.GET_SIGNATURES);
    }

    public static final PackageInfo getActivityPackageInfo(Context context) throws NameNotFoundException {
        PackageManager manager = context.getPackageManager();
        return manager.getPackageInfo(context.getPackageName(), PackageManager.GET_ACTIVITIES);
    }

    public static final PackageInfo getIntentFilterPackageInfo(Context context) throws NameNotFoundException {
        PackageManager manager = context.getPackageManager();
        return manager.getPackageInfo(context.getPackageName(), PackageManager.GET_INTENT_FILTERS);
    }

    public static final PackageInfo getServicePackageInfo(Context context) throws NameNotFoundException {
        PackageManager manager = context.getPackageManager();
        return manager.getPackageInfo(context.getPackageName(), PackageManager.GET_SERVICES);
    }

    public static final PackageInfo getProviderPackageInfo(Context context) throws NameNotFoundException {
        PackageManager manager = context.getPackageManager();
        return manager.getPackageInfo(context.getPackageName(), PackageManager.GET_PROVIDERS);
    }

    public static final PackageInfo getPermissionPackageInfo(Context context) throws NameNotFoundException {
        PackageManager manager = context.getPackageManager();
        return manager.getPackageInfo(context.getPackageName(), PackageManager.GET_PERMISSIONS);
    }

    public static final PackageInfo getReceiverPackageInfo(Context context) throws NameNotFoundException {
        PackageManager manager = context.getPackageManager();
        return manager.getPackageInfo(context.getPackageName(), PackageManager.GET_RECEIVERS);
    }
}