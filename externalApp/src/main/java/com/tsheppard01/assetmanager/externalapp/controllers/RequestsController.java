package com.tsheppard01.assetmanager.externalapp.controllers;

import com.tsheppard01.assetmanager.externalapp.dto.RequestItemDto;
import com.tsheppard01.assetmanager.externalapp.services.RequestsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
public class RequestsController {

  private UUID userId = UUID.fromString("5fd997a7-bb64-4bd0-a213-6e15d76bcfc0");

  @Autowired
  private RequestsService requestsService;

  @RequestMapping("/requests")
  public ModelAndView viewRequests() {

    return new ModelAndView(
        "requests",
        "requests",
        requestsService.getRequestsForUser(userId)
    );
  }

  @RequestMapping("/requests/{requestId}")
  public ModelAndView viewRequestDetails(@PathVariable(name = "requestId") UUID requestId) {

    return new ModelAndView(
        "requestDetails",
        "requestDetails",
        requestsService.getRequestDetails(requestId)
    );
  }

  @PostMapping("/requests/create")
  public ModelAndView createNewRequest() {

    UUID requestId = requestsService.createNewRequest(userId);

    return new ModelAndView("redirect:/assetTypes?rid="+requestId);
  }

  @PostMapping("/requests/{requestId}/addItem")
  public ModelAndView addItemToRequest(@PathVariable(name = "requestId") UUID requestId,
                                       RequestItemDto requestItemDto) {

    requestsService.addItemToRequest(requestId, requestItemDto);

    return new ModelAndView("redirect:/assetTypes?rid="+requestId);
  }
}
