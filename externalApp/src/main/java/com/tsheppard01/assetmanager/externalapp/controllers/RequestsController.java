package com.tsheppard01.assetmanager.externalapp.controllers;

import com.tsheppard01.assetmanager.externalapp.services.RequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.UUID;

@Controller
public class RequestsController {

  private UUID userId = UUID.fromString("5fd997a7-bb64-4bd0-a213-6e15d76bcfc0");

  @Autowired
  private RequestsService requestsService;

  @PostMapping("/requests/create")
  public RedirectView createNewRequest() {

    UUID requestId = requestsService.createNewRequest(userId);

    return new RedirectView("/assetTypes");
  }
}
