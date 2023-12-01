package com.doctopdf.helpers

import java.io.File
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.Date

/**
 * Class represents a file item of list view.
 * @param file File from which to create FileItem.
 */
class FileItem (file: File) {
    val name: String = file.name
    var size = file.length()
    val sizeText: String = convertFileSizeToString(file.length())
    val lastModifiedText: String = convertToDate(file.lastModified())

    /**
     * Converts file size to units (B, KB, MB, GB) and returns it as a string.
     * If units > 1024, then it converts to higher units.
     * @param size: Size of a file.
     * @return Returns string in form '{sizeOfFile} {units}]'.
     */
    private fun convertFileSizeToString(size: Long): String {
        val decimalFormat = DecimalFormat("#.##")
        var fileUnitsIndex = 0
        var fileSize: Double = size.toDouble()

        while (true) {
            if (fileSize <= 1000 || fileUnitsIndex >= 3) {
                break
            } else {
                fileSize /= 1000
                fileUnitsIndex += 1
            }
        }

        return "${decimalFormat.format(fileSize)} ${FileSizeUnits.values()[fileUnitsIndex]}"
    }

    /**
     * Converts long to date.
     * @param lastModified Last modification as Long.
     * @return Formatted date of last modification.
     */
    private fun convertToDate(lastModified: Long): String {
        val lastModified = Date(lastModified)
        val dateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm:ss")

        return dateFormat.format(lastModified)
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