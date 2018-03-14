package com.ssh.service;

import org.springframework.stereotype.Service;

@Service("ts")
public class TestServiceImpl implements TestService {

	@Override
	public String test() {
		return "test";
	}

}
