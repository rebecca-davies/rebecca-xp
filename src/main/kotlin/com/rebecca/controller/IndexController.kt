package com.rebecca.controller

import com.rebecca.fetch.dir
import com.rebecca.fetch.directory
import com.rebecca.fetch.fetch
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.*


/**
 *  The observer class of any /index requests
 */
@Controller
class IndexController {

    /**
     *  Observes and populates the template with directory listings
     *
     *  @param hash the hashcode of the file
     *  @param model holder of specified attributes inserted into the template
     *  @return returns the .html file or #files depending on whether the hash is null
     */
    @GetMapping("/")
    fun index(@RequestParam(value = "hash", required = false) hash : String?, model : Model) : String {
        hash?.let {
            dir = directory[hash]?.path.toString()
        }
        model["populate"] = fetch()
        return when(hash.isNullOrEmpty()) {
            false -> "index :: #files"
            true -> "index"
        }
    }
}