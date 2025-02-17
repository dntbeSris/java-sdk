/*
 * Copyright 2021 The Dapr Authors
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
limitations under the License.
*/

package io.dapr.it.binding.http;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * SpringBoot Controller to handle input binding.
 */
@RestController
public class InputBindingController {

  private static final List<String> messagesReceived = new ArrayList();

  @PostMapping(path = "/sample123")
  @PutMapping(path = "/sample123")
  public void handleInputBinding(@RequestBody(required = false) String body) {
    messagesReceived.add(body);
    System.out.println("Received message through binding: " + (body == null ? "" : body));
  }

  @GetMapping(path = "/messages")
  public List<String> getMessages() {
    return messagesReceived;
  }

  @GetMapping(path = "/")
  public String hello() {
    return "hello";
  }

}
