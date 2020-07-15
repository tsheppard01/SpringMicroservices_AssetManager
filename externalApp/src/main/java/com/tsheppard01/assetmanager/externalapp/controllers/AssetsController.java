package com.tsheppard01.assetmanager.externalapp.controllers;

import com.tsheppard01.assetmanager.externalapp.dto.AssetTypeDto;
import com.tsheppard01.assetmanager.externalapp.services.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AssetsController {

  @Autowired
  private AssetsService assetsService;

  @RequestMapping("/assetTypes")
  public ModelAndView getAllAssetTypes() {

    List<AssetTypeDto> assetTypes = assetsService.getAllAssetTypes();

    return new ModelAndView("assetTypes", "assetTypes", assetTypes);
  }
}
