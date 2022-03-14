package com.rebecca.fetch

/**
 *  Sorts an unordered list by MIME extension
 *
 *  @return a list of files sorted by extension for a directory
 */
fun List<File>.sort(): List<File> {
    return sortedWith(compareBy { file ->
        file.name.contains(other = ".")
    })
}

var dir: String = "$top/example/test3/"    //The current directory being observed
