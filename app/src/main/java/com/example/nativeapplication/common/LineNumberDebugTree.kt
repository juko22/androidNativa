package com.example.nativeapplication.common

import timber.log.Timber

class LineNumberDebugTree : Timber.DebugTree() {
    override fun createStackElementTag(element: StackTraceElement): String? =
        "$TIMBER_TAG: (${element.fileName}:${element.lineNumber}) #${element.methodName}"

}