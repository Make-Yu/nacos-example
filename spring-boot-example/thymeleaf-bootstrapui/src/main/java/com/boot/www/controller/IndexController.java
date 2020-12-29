package com.boot.www.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class IndexController {

	/**
	 * 页面跳转
	 * @param url
	 * @return
	 */
	@GetMapping("{url}.shtml")
	public String page(@PathVariable("url") String url) {
		return url;
	}
	/**
	 * 页面跳转(二级目录)
	 * @param module
	 * @param url
	 * @return
	 */
	@GetMapping("{module}/{url}.shtml")
	public String page(@PathVariable("module") String module,@PathVariable("url") String url) {
		return module + "/" + url;
	}
}
