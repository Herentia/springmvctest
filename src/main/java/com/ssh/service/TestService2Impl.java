package com.ssh.service;

import org.springframework.stereotype.Service;

@Service
public class TestService2Impl implements TestService {

	@Override
	public String test() {
		return "haha";
	}

}
