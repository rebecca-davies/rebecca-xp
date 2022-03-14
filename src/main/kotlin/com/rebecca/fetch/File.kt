package com.rebecca.fetch

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.nio.file.Files

/**
 *  Represents a file in a directory
 *
 *  @property name  the name of the file
 *  @property size  the size of the file (kilobytes)
 *  @property type  the MIME type of the file
 */
data class File(val name: String, val size: Long, val type: String?)

/**
 *  Reads from the requested directory and returns a list of files.
 *
 *  @return a list of unordered files
 */
fun instantiate(): List<File> {
    return java.io.File(dir).listFiles()!!.map {
        File(name = it.name, size = size(res = "$dir${it.name}"), type = it.getMimeType())
    }.toList()
}

/**
 *  Reads the length of the fed file into kilobytes.
 *
 *  @param res  the path of the file being measured
 *  @return the length of the file in kilobytes
 */
fun size(res: String): Long {
    return java.io.File(res).length() / 1024 //TODO add precision
}

/**
 *  Reads the files MIME type for categorization
 *
 *  @return the MIME type as a string
 */
fun java.io.File.getMimeType(): String? {
    return Files.probeContentType(this.toPath())
}
