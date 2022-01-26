package fr.sylvainjanet.personal_website.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.sylvainjanet.personal_website.constants.api.uri.PublicUri;
import fr.sylvainjanet.personal_website.controllers.interfaces.IPageController;
import fr.sylvainjanet.personal_website.dto.entities.PageDto;
import fr.sylvainjanet.personal_website.entities.Page;
import fr.sylvainjanet.personal_website.services.interfaces.IPageService;

@RestController
@RequestMapping(PublicUri.PAGE_CONTROLLER)
public class PageController extends GenericCRUDController<Page, PageDto> implements IPageController {

	public PageController(@Autowired IPageService pageService) {
		super(pageService);
	}

}
