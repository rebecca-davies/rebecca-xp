package com.rebecca.fetch

import java.io.File
import java.nio.file.Files

/**
 *  Represents a file in a directory
 *
 *  @property name  the name of the file
 *  @property size  the size of the file (kilobytes)
 *  @property type  the MIME type of the file
 */
data class FileData(val name: String, val size: Long, val type: String?, val path: String)

/**
 *  Reads from the requested directory and returns a list of files.
 *
 *  @return a list of unordered files
 */
fun instantiate(): List<FileData> {
    return File(dir).listFiles()!!.map {
        FileData(name = it.name, size = size(it), type = it.getMimeType(), path = it.path)
    }.toList()
}

/**
 *  Reads the length of the fed file into kilobytes.
 *
 *  @param res  the path of the file being measured
 *  @return the length of the file in kilobytes
 */
fun size(file: File): Long {
    return file.length() / 1024 //TODO add precision
}

/**
 *  Reads the files MIME type for categorization
 *
 *  @return the MIME type as a string
 */
fun File.getMimeType(): String? {
    return Files.probeContentType(this.toPath())
}
