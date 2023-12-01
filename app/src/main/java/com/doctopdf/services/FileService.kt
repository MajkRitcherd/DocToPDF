package com.doctopdf.services

import java.io.File

/**
 * File service represented as a singleton.
 */
object FileService {
    /**
     * Gets list of PDF files from given directories.
     * @param directories ArrayList of directories to search.
     * @return List of PDF files.
     */
    fun getPDFFiles(directories: ArrayList<File>): ArrayList<File> {
        val fileNames: ArrayList<File> = arrayListOf()

        for (directory in directories) {
            fileNames.addAll(getPDFFilesFromDirectory(directory))
        }

        return fileNames
    }

    /**
     * Get list of PDF files in a given directory.
     * @param directory Directory to search PDF files in.
     * @return List of PDF files.
     */
    private fun getPDFFilesFromDirectory(directory: File): ArrayList<File> {
        val pdfPattern = ".pdf"
        val fileNames = arrayListOf<File>()

        val files = directory.listFiles()
        if (files != null) {
            for (file in files) {
                if (file.name.endsWith(pdfPattern)) {
                    fileNames.add(file)
                }
            }
        }

        return fileNames
    }
}