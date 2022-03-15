package com.rebecca.fetch

import com.rebecca.fetch.template.folder
import com.rebecca.fetch.template.image

/**
 *  The built HTML being inserted after processing the current directory
 *
 *  @return the HTML being inserted into the template
 */
fun built(): String {
    return instantiate().sort().built()
}

/**
 *  Templates the files in the directory after sorting them for display order
 *
 *  @return the HTML ready to be inserted into the template
 */
private fun List<FileData>.built(): String {
    return joinToString(separator = "") {
        template(it)
    }
}

/**
 *  Templates the file based on its MIME type
 *
 *  @return the <div> built and ready to be joined into a string of HTML
 */
fun template(file: FileData): String {
    when(file.type) {
        "image/png" -> return image(file)
        null -> return folder(file)
    }
    return ""
}
