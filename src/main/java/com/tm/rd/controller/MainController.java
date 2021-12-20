package com.tm.rd.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Here is MainController
 * 
 * @author tong
 *
 */

@RestController
@RequestMapping(value = "/api/devices", produces = { "application/json", "application/xml" })
public class MainController {

	@Autowired
	public MainController() {
	}

}
