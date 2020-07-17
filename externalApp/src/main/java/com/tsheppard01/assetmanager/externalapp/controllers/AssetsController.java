package com.tsheppard01.assetmanager.externalapp.controllers;

import com.tsheppard01.assetmanager.externalapp.dto.AddRequestItemDto;
import com.tsheppard01.assetmanager.externalapp.dto.AssetTypeDto;
import com.tsheppard01.assetmanager.externalapp.services.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.UUID;

@Controller
public class AssetsController {

  private UUID userId = UUID.fromString("5fd997a7-bb64-4bd0-a213-6e15d76bcfc0");

  @Autowired
  private AssetsService assetsService;

  @RequestMapping("/")
  public ModelAndView index() {
    return new ModelAndView("index");
  }

  @RequestMapping("/assetTypes")
  public ModelAndView getAllAssetTypes(@RequestParam(name = "rid") UUID requestId) {

    List<AssetTypeDto> assetTypes = assetsService.getAllAssetTypes();

    return new ModelAndView("assetTypes", "assetTypes", assetTypes);
  }

  @RequestMapping("/assetTypes/{assetTypeId}")
  public ModelAndView getAssetType(@PathVariable(value = "assetTypeId") UUID assetTypeId,
                                   @RequestParam(name = "rid") UUID requestId) {

    AssetTypeDto assetType = assetsService.getAssetType(assetTypeId);
    return new ModelAndView("assetTypeDetails", "assetType", assetType);
  }

  @PostMapping("/assetTypes/request")
  public RedirectView orderAsset(@ModelAttribute AddRequestItemDto addItemRequest) {
    assetsService.addItemToRequest(addItemRequest);
    return new RedirectView("/assetTypes");
  }
}
