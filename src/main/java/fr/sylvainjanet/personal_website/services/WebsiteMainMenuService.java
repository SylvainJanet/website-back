package fr.sylvainjanet.personal_website.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.sylvainjanet.personal_website.dto.entities.WebsiteMainMenuDto;
import fr.sylvainjanet.personal_website.entities.WebsiteMainMenu;
import fr.sylvainjanet.personal_website.repositories.WebsiteMainMenuRepository;
import fr.sylvainjanet.personal_website.services.interfaces.IWebsiteMainMenuService;

@Service
@Transactional
public class WebsiteMainMenuService extends GenericService<WebsiteMainMenu, WebsiteMainMenuDto>
		implements IWebsiteMainMenuService {

	public WebsiteMainMenuService(@Autowired WebsiteMainMenuRepository websiteMainMenuRepository) {
		super(WebsiteMainMenuDto.class, websiteMainMenuRepository);
	}

}
