package com.rebecca.controller

import com.rebecca.fetch.fetch
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

/**
 *  The observer class of any /index requests
 */
@Controller
class IndexController {

    /**
     *  Observes and populates the template with directory listings
     *
     *  @param model holder of specified attributes inserted into the template
     *  @return returns the .html file requested from the observer
     */
    @GetMapping("/")
    fun index(model : Model) : String {
        model["populate"] = fetch()
        return "index"
    }
}