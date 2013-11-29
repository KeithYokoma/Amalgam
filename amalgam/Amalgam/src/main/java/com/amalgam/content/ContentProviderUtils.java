package com.amalgam.content;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;

/**
 */
public final class ContentProviderUtils {
    private static final String PLURAL_MIME_TYPE = "vnd.android.cursor.dir";
    private static final String SINGULAR_MIME_TYPE = "vnd.android.cursor.item";
    private ContentProviderUtils() {}

    public static final String buildPluralMimeType(String subType) {
        return PLURAL_MIME_TYPE + "/" + subType;
    }

    public static final String buildSingularMimeType(String subType) {
        return SINGULAR_MIME_TYPE + "/" + subType;
    }

    public static final void notifyChange(ContentProvider provider, Uri uri, ContentObserver observer) {
        notifyChange(provider.getContext(), uri, observer);
    }

    public static final void notifyChange(Context context, Uri uri, ContentObserver observer) {
        ContentResolver resolver = context.getContentResolver();
        resolver.notifyChange(uri, observer);
    }
}