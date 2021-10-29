package fr.sylvainjanet.personal_website.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.sylvainjanet.personal_website.constants.api.uri.PublicUri;
import fr.sylvainjanet.personal_website.controllers.interfaces.IWebPageCategoryMainController;
import fr.sylvainjanet.personal_website.dto.entities.WebPageCategoryMainDto;
import fr.sylvainjanet.personal_website.entities.WebPageCategoryMain;
import fr.sylvainjanet.personal_website.services.interfaces.IWebPageCategoryMainService;

@RestController
@RequestMapping(PublicUri.WEBPAGE_CATEGORY_MAIN_CONTROLLER)
public class WebPageCategoryMainController extends GenericCRUDController<WebPageCategoryMain, WebPageCategoryMainDto>
		implements IWebPageCategoryMainController {

	public WebPageCategoryMainController(@Autowired IWebPageCategoryMainService webPageCategoryMainService) {
		super(webPageCategoryMainService);
	}

}
