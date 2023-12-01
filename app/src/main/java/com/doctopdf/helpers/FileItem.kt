package com.doctopdf.helpers

import java.io.File

/**
 * Class represents a file item of list view.
 * @param file File from which to create FileItem.
 */
class FileItem (file: File) {
    val name: String = file.name
    var size = file.length()
    val sizeText: String = convertFileSizeToString(file.length())
    val lastModifiedText: String = file.lastModified().toString()

    /**
     * Converts file size to units (B, KB, MB, GB) and returns it as a string.
     * If units > 1024, then it converts to higher units.
     * @param size: Size of a file.
     * @return Returns string in form '{sizeOfFile} {units}]'.
     */
    private fun convertFileSizeToString(size: Long): String {
        var fileUnitsIndex = 0
        var fileSize: Long = size
        var shouldStop = false

        while (!shouldStop) {
            if (fileSize <= 1024) {
                shouldStop = true
            } else {
                fileSize /= 1024
                fileUnitsIndex += 1
            }
        }

        return "$fileSize ${FileSizeUnits.values()[fileUnitsIndex]}"
    }

    /**
     * Represents possible file size units.
     * Assuming that the maximum stored on mobile is GBs.
     */
    enum class FileSizeUnits {
        B,
        KB,
        MB,
        GB
    }
}