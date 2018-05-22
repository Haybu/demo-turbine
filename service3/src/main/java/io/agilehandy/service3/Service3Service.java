/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.agilehandy.service3;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * @author Haytham Mohamed
 */

@Service
public class Service3Service {

	Logger logger = LoggerFactory.getLogger(Service3Service.class);

	@HystrixCommand(fallbackMethod = "service3AnotherValue")
	public String service3Value() {
		String[] values = {"good", "bad"};
		String val = values[new Random().nextInt(values.length)];

		if (val.equalsIgnoreCase("bad")) {
			throw new RuntimeException("Some Exception happens");
		}

		return val;
	}

	public String service3AnotherValue() {
		logger.info(">>> fallback method is called...");
		return "oops..!";
	}
}
