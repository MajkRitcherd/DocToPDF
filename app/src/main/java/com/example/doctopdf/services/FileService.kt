package com.example.doctopdf.services

import java.io.File

// File service as a singleton
object FileService {
    /**
     * Gets list of PDF files from given directories.
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