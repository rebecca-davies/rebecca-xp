package com.rebecca.fetch


val directory = mutableMapOf<String, FileData>()    //A map of the directory
var dir: String = "$top/example/"    //The current directory being observed


/**
 *  Sorts an unordered list by MIME extension
 *
 *  @return a list of files sorted by extension for a directory
 */
fun List<FileData>.sort(): List<FileData> {
    return sortedWith(compareBy { file ->
        file.name.contains(other = ".")
    }).also { render() }
}

/**
 *  Populates the directory of the sorted files and maps them for fetching
 */
fun List<FileData>.render() {
    forEach {
        directory[it.hashCode().toString()] = it
    }
}






