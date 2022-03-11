package com.rebecca.fetch

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

/**
 *  Represents a file in a directory
 *
 *  @property name  the name of the file
 *  @property size  the size of the file (kilobytes)
 *  @property type  the MIME type of the file
 */
data class File(val name: String, val size: Long, val type: String?) {
    constructor(name: String, size: Long) : this(name = name, size = size, type = "")
}

/**
 *  Reads from the requested directory and returns a list of files.
 *
 *  @return a list of unordered files
 */
fun instantiate(): List<File> {
    return getResourceFiles(dir).map {
        File(name = it, size = size(res = "$dir$it"))
    }
}

/**
 *  Reads the length of the fed file into kilobytes.
 *
 *  @param res  the path of the file being measured
 *  @return the length of the file in kilobytes
 */
fun size(res: String): Long {
    return java.io.File(ClassLoader.getSystemResource(res).file).length() / 1024 //TODO Precision
}

/**
 *  Fetches the files from the requested directory and returns a list of paths to files
 *
 *  @param path the path of the directory being scanned
 *  @return a list of paths to files in the directory
 */
fun getResourceFiles(path: String): List<String> = getResourceAsStream(resource = path).use { stream ->
    return if(stream == null) emptyList()
    else BufferedReader(InputStreamReader(stream)).readLines()
}

/**
 *  Finds a resource with a given name
 *
 *  @param resource the resource being scanned in the directory
 *  @return an InputStream that feeds information from the directory
 */
private fun getResourceAsStream(resource: String): InputStream? =
    Thread.currentThread().contextClassLoader.getResourceAsStream(resource)
        ?: resource::class.java.getResourceAsStream(resource)