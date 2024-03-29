package com.example.dincerkizildere.materialthemes.log;

import android.os.Bundle;

import timber.log.Timber;

public class LogUtils {
    public static final String METHOD_ONLY = DebugClassAndMethodTree.MESSAGE_SHOW_METHOD_ONLY;

    private static Timber.Tree sLoggingTree;

    public static synchronized void initLoggingUtilities() {
        if (sLoggingTree == null) {
            sLoggingTree = new DebugClassAndMethodTree();
            Timber.plant(sLoggingTree);
        }
    }

    public static String getSavedInstanceStateNullMessage(Bundle savedInstanceState) {
        StringBuilder stringBuilder = new StringBuilder("savedInstanceState")
                .append(savedInstanceState == null ? " == " : " != ")
                .append("null");
        return stringBuilder.toString();
    }
}